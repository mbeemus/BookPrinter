import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class ByAuthorPrinter implements BookListPrinter {

	@Override
	public void print(List<Book> books) {
		Collections.sort(books, Comparator.comparing(Book::getAuthor));
		
		
		String byAuthors = null;
		for(Book book : books) {
			if(!book.getAuthor().equals(byAuthors)) {
				byAuthors = book.getAuthor();
				System.out.println(byAuthors + ": ");
			}
			System.out.println("\t" + book.getTitle() + " (" 
					+ book.getYear() + ")");
		}
	}
		
	
}
