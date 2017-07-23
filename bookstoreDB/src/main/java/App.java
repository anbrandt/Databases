import com.sun.org.apache.xpath.internal.SourceTree;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by andrzej on 23.07.17.
 */
public class App {


	public static void main(String[] args) {

		DatabaseServer server = new DatabaseServer("localhost", "bookstore", "andrzej"
				, "password123");


		List<String> listOfAllBooks = new ArrayList<>();

		DatabaseBooksDAO databaseBooksDAO = new DatabaseBooksDAO(server);


		List<Books> books2 = databaseBooksDAO.get();


	}
}
