import javax.swing.tree.DefaultMutableTreeNode;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;


import java.awt.*;


/**
 * Makes a GUI with Java Swing for books.
 * 
 * @author Mallory Beemus
 * @version PA2 : bookzV2
 * 
 */

public class PrintBooksGUI extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JTree tree;
	private JPanel panel;
	private JLabel imageLabel;
	private JLabel selectedLabel;
	private JLabel bookInfo;
	private Map<String, ImageIcon> images;
	
	/**
	 * Creates GUI Method.
	 * 
	 * @throws IOException exception error
	 */
	
	public PrintBooksGUI() throws IOException{
		
		//create frame
		frame = new JFrame("Bookz V2");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setTitle("Bookz V2");
		
		// create root node
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("Authors");

		
		//reads file from BookListReader
		//sorts books by author
		InputStream in = new FileInputStream("books.json");
		List<Book> books = BookListReader.readBookList(in);
		Collections.sort(books, Comparator.comparing(Book::getAuthor));
		
		
		String author = null;
        DefaultMutableTreeNode authorNode = null;
        images = new HashMap<>();

		
		//create new child node for every author 
		for(Book book : books) {
			if(!book.getAuthor().equals(author)) {
				author = book.getAuthor();
				authorNode = new DefaultMutableTreeNode(author);
				root.add(authorNode);
			}
			 DefaultMutableTreeNode bookNode = new DefaultMutableTreeNode(book.getTitle());
	         authorNode.add(bookNode);
	         
	         
	        
	         // place the book image in the image panel 
	         if(!book.getImageLink().isEmpty()) {
	        	 ImageIcon image = new ImageIcon(book.getImageLink());
	        	 images.put(book.getTitle(), image);
	         }
			

		}
		
		//create the tree
		tree = new JTree(root);
		panel = new JPanel(new BorderLayout());
		panel.setPreferredSize(new Dimension(400, 600));
		frame.add(panel, BorderLayout.EAST);
		
		
		
		 //Tree Selection Listener
		selectedLabel = new JLabel();
		panel.add(selectedLabel, BorderLayout.CENTER);
		
		
		//Add image to panel
		imageLabel = new JLabel();
		panel.add(imageLabel, BorderLayout.CENTER);
		
		
		//Image info Label
		bookInfo = new JLabel();
		panel.add(bookInfo, BorderLayout.SOUTH);
		bookInfo.setBorder(new EmptyBorder(10, 10, 50, 10));
		
        tree.getSelectionModel().addTreeSelectionListener(new TreeSelectionListener() {
			@Override
			public void valueChanged(TreeSelectionEvent e) {
				DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode)
						tree.getLastSelectedPathComponent();
				
				if(selectedNode != null && selectedNode.getUserObject() != null) {
					String bookTitle = selectedNode.getUserObject().toString();
                    selectedLabel.setText(bookTitle);

                    // Set the book image to the image label
                    ImageIcon bookImage = images.get(bookTitle);
                    if (bookImage != null) {
                        imageLabel.setIcon(bookImage);
                    } else {
                        imageLabel.setIcon(null);
                    }
                    
                    for(Book book : books) {
                    	if(book.getTitle().equals(bookTitle)) {
                    		String bookInfoText = book.getTitle() + "by " 
                    	+ book.getAuthor() + " (" + book.getYear() + ")";
                    		
                    		bookInfo.setText(bookInfoText);
                    		return;
                    	}
                    }
                    
                    bookInfo.setText("");
				}
				
				}
			});
			

		//add scrollPane
		JScrollPane scrollPane = new JScrollPane(tree);
		frame.add(scrollPane, BorderLayout.WEST);
		frame.setVisible(true);
		
	}


	public static void main(String[] args) {
       SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
					new PrintBooksGUI();
				} catch (IOException e) {
				e.printStackTrace();
				}
           }
        });
    }
}
		



