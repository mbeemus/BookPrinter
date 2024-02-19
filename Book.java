/**
 * Book Class for Bookz V1 Pa1.
 * 
 * @author Mallory Beemus
 * @version PA1
 * 
 */
public class Book {
	
	private final String title;
	private final String author;
	private final String country;
	private final String imageLink;
	private final String language;
	private final String link;
	private final int pages;
	private final int year;
	
	

	/**
	 * Constructor method for class method.
	 * 
	 * @param title String
	 * @param author String
	 * @param country String
	 * @param imageLink String
	 * @param language String
	 * @param link String
	 * @param pages int
	 * @param year int
	 */
	public Book(String title, String author, 
			String country, String imageLink, String language,
			String link, int pages, int year){
		
		this.title = title;
		this.author = author;
		this.country = country;
		this.imageLink = imageLink;
		this.language = language;
		this.link = link;
		this.pages = pages;
		this.year = year;
			
	}
	
	/**
	 * Getter method for Title.
	 * 
	 * @return title String
	 */
	public String getTitle() {
		return title;
		
	}
	
	/**
	 * Getter method for author.
	 * 
	 * @return author String
	 */
	public String getAuthor() {
		return author;
		
	}
	
	/**
	 * Getter method for country.
	 * 
	 * @return country String
	 */
	public String getCountry() {
		return country;
	}
	
	/**
	 * Getter method for imageLink.
	 * 
	 * @return imageLink String
	 */
	public String getImageLink() {
		return imageLink;
	}
	
	/**
	 * Getter method for language.
	 * 
	 * @return language String
	 */
	public String getLanguage() {
		return language;
	}
	
	/**
	 * Getter method for link.
	 * 
	 * @return link String
	 */
	public String getLink() {
		return link;
	}
	
	/**
	 * Getter method for pages.
	 * 
	 * @return pages int
	 */
	public int getPages() {
		return pages;
	}
	
	/**
	 * Getter method for year.
	 * 
	 * @return year int
	 */
	public int getYear() {
		return year;
	}

}
