package ro.emanuel.tema2.pojo;

public class Book {

	private int id;
	private String title;
	private int pages;
	private int weight;
	public Book(int id, String title, int pages, int weight) {
		super();
		this.id = id;
		this.title = title;
		this.pages = pages;
		this.weight = weight;
	}
	public Book(String title, int pages, int weight) {
		super();
		this.title = title;
		this.pages = pages;
		this.weight = weight;
	}
	public Book() {
		super();
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", pages=" + pages + ", weight=" + weight + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
}
