import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AlphabeticalPrinter implements BookListPrinter{

	@Override
	public void print(List<Book> books) {
		Collections.sort(books, Comparator.comparing(Book::getTitle));
		
		for(Book book : books) {
			System.out.println(book.getTitle() 
					+ " by " + book.getAuthor() 
					+ " (" + book.getYear() + ")");
		}
	}

}