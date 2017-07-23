/**
 * Created by andrzej on 23.07.17.
 */
public class Books {
	private int id;
	private String title;
	private String author;
	private int price;


	public Books(int id, String title, String author, int price) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.price = price;
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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String toString() {
		return id + " " + title + " " + author + " " + price;
	}

}
