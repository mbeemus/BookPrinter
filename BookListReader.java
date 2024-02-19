import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


public class BookListReader {
	
	
	public static List<Book> readBookList(InputStream in) throws IOException{
		ObjectMapper mapper = new ObjectMapper();
		JsonNode tree = mapper.readTree(in);
		
		//JsonNode treeArray = tree.get("test_data");		
		List<Book> books = new ArrayList<>();
		
		for(JsonNode book : tree) {
			String title = book.get("title").asText();
			String author = book.get("author").asText();
			String country = book.get("country").asText();
			String imageLink = book.get("imageLink").asText();
			String language = book.get("language").asText();
			String link = book.get("link").asText();
			int pages = book.get("pages").asInt();
			int year = book.get("year").asInt();
			
			Book singleBook = new Book(title, author, country, imageLink, 
					language, link, pages,year);
			books.add(singleBook);
		}
		
		return books;
	}
}
