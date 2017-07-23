import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by andrzej on 23.07.17.
 */
public class DatabaseServer {
	private String address;
	private String databaseName;
	private String userName;
	private String userPassword;

	private Connection connection;

	public DatabaseServer(String address, String databaseName, String userName, String userPassword) {
		this.address = address;
		this.databaseName = databaseName;
		this.userName = userName;
		this.userPassword = userPassword;
	}

	public void connect() throws SQLException {
		connection = DriverManager.getConnection(
				"jdbc:mysql://" + address + "/" + databaseName + "?" +
						"user=" + userName	 + "&password=" + userPassword);
	}

	public Statement createStatement() throws SQLException {
		if(connection == null) {
			throw new IllegalStateException("Call connect() first!!!");
		}

		return connection.createStatement();
	}


	public void close() {
		if(connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
}
