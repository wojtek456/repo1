package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSetMetaData;

public abstract class DataBaseConfig {
	private String dBName="ksiegarnia"; 
	private String driver_name = "com.mysql.jdbc.Driver"; // DRIVER_NAME
	private String url = "jdbc:mysql://127.0.0.1/" + dBName; // DATABASE_URL
	private String username = "root"; // USERNAME
	private String password = ""; // PASSWORD
	protected Connection connection;
	private PreparedStatement preparedStatement;


	
	public void setDBName(String dataBaseName) {
		this.dBName = dataBaseName;
	}
	public String getDBName(){
		return dBName;
		
	}
	private void connection() throws ClassNotFoundException {
		Class.forName(driver_name);
		System.out.println("��cz� z baz� danych.....");
		try {
			connection = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			System.out.println("Nie uda�o si� po��czy� z baz� danych :( " + "\n");
			e.printStackTrace();
		}
		System.out.println("Po��czenie z baz� danych zako�czone pomy�lnie :) \n");
	}

	protected abstract void statement() throws SQLException;

	protected abstract void process() throws SQLException;

	public void close() throws SQLException {

		connection.close();
		System.out.println("\nBaza danych zosta�a zamkni�ta");

	}

	public void execute() throws ClassNotFoundException, SQLException {
		connection();
		statement();
		process();
		
	}

}
