package ibmanager;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Observable;

public class Connection extends Observable {
	private java.sql.Connection conn;
	private static volatile Connection instance;
	private Boolean connected = false;
	
	public Boolean isConnected() {
		return connected;
	}

	public void connect(String host, String port, String username, String password) {
		try {
			connected = false;
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		    conn = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port, username, password);
		    connected = true;
//		    System.out.println("Connected");
		    
//		    DatabaseMetaData dbMetaData = conn.getMetaData();
//		    String productName = dbMetaData.getDatabaseProductName();
//		    System.out.println("Database: " + productName);
//		    String productVersion = dbMetaData.getDatabaseProductVersion();
//		    System.out.println("Version: " + productVersion);
		    
		} catch (SQLException e) {
			connected = false;
			conn = null;
			System.err.println("Error. Failed to connect to the server. " + e.getMessage());
		    System.err.println("SQLException: " + e.getMessage());
		    System.err.println("SQLState: " + e.getSQLState());
		    System.err.println("VendorError: " + e.getErrorCode());
		} catch (Exception e) {
			conn = null;
			connected = false;
		    System.err.println("Error. Failed to connect to the server. " + e.getMessage());
		}
		
		setChanged();
		notifyObservers(null);
	}
	
	public ResultSet executeQuery(String command) throws SQLException {
		Statement stmt = conn.createStatement();
		return stmt.executeQuery(command);
	}
	
	public void executeUpdate(String command) throws SQLException {
		Statement stmt = conn.createStatement();
		stmt.executeUpdate(command);
	}
	
	public static Connection getInstance() {
		 if (instance == null) {
			   synchronized (Connection.class) {
	                if (instance == null) {
	                    instance = new Connection();
	                }
	            }
		 }
		 return instance;
	 }
	
}
