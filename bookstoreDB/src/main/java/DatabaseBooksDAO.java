import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by andrzej on 23.07.17.
 */
public class DatabaseBooksDAO implements BooksDAO {
	private static DatabaseBooksDAO instance = null;
	private DatabaseServer server;

	public static void init(DatabaseServer server) {
		if(instance == null) {
			instance = new DatabaseBooksDAO(server);
		}
	}

	public DatabaseBooksDAO(DatabaseServer server) {
		this.server = server;
		try {
			server.connect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static DatabaseBooksDAO getInstance() {
		return instance;
	}

	public static final String GET_ALL_BOOKS = "select * from books";
	public static final String UPDATE_BOOKS = "";

	private Connection connection;


	public void closeConnection() {
		server.close();
	}

	@Override
	public List<Books> get() {
		List<Books> listOfBooks = new ArrayList<>();

		Statement statement = null;

		try {
			statement = server.createStatement();

			ResultSet resultSet = statement.executeQuery(GET_ALL_BOOKS);

			while (resultSet.next()) {
				int id = resultSet.getInt(resultSet.findColumn("id"));
				String title = resultSet.getString(resultSet.findColumn("title"));
				String author = resultSet.getString(resultSet.findColumn("author"));
				int price = resultSet.getInt(resultSet.findColumn("price"));

				listOfBooks.add(new Books(id, title,author,price));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listOfBooks;
	}

	@Override
	public void add(Books books) {
		Statement statement = null;

		try {
			statement = server.createStatement();
			statement.executeUpdate("insert into books (title, author, price) values (\"" +
					books.getTitle() + "\", \"" + books.getAuthor() + "\", \"" + books.getPrice() + "\")");

				} catch (SQLException e) {
			e.printStackTrace();
		}


	}

	@Override
	public void delete(Books books) {

		Statement statement = null;

		try {
			statement = server.createStatement();
			statement.executeUpdate("delete from books where id = " + books.getId());


		} catch (SQLException e) {
			e.printStackTrace();
		}



	}

	@Override
	public void update(Books books) {

		String update = "update books set title = \"" + books.getTitle() +
				"\", author = \"" + books.getAuthor() +
				"\", price = \"" + books.getPrice() + "\" where id = " + books.getId();
		Statement statement = null;

		try {
			statement = server.createStatement();

			statement.executeUpdate(update);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
