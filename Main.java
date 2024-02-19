import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException{
		if(args.length > 0) {
			String commandLineOption = args[0];
			
			InputStream in = new FileInputStream("books.json");
				//new BookListReader();
				List<Book> books = BookListReader.readBookList(in);

                BookListPrinter bookListPrinter;
                if ("alpha".equalsIgnoreCase(commandLineOption)) {
                    bookListPrinter = new AlphabeticalPrinter();
                    bookListPrinter.print(books);
                } else if ("auth".equalsIgnoreCase(commandLineOption)) {
                    bookListPrinter = new ByAuthorPrinter();
                    bookListPrinter.print(books);
              
                }
                in.close();
		}
		else {		
			InputStream in = new FileInputStream("books.json");
			List<Book> books = BookListReader.readBookList(in);

            BookListPrinter bookListPrinter;
            bookListPrinter = new AlphabeticalPrinter();
            bookListPrinter.print(books);
			
		}

                
            
//        } else {
//            System.out.println("Please provide an option: 'alpha' or 'auth'.");
//        }
    }
}