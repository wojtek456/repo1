package DataBase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

public class DataBaseSelect extends DataBaseConfig {

	private String sqlQuery = "SELECT*FROM ksiazki";
	private ResultSet result;
	private PreparedStatement preparedStatement;
	// private String sqlQuery;
	private ResultSetMetaData metaDate;

	public ResultSet getResult() {
		return result;
	}

	public void setSqlQuery(String SqlQuery) {
		this.sqlQuery = SqlQuery;
	}

	public PreparedStatement getPreparedStatement() {
		return preparedStatement;
	}

	@Override

	protected void statement() throws SQLException {
		preparedStatement = (PreparedStatement) connection.prepareStatement(sqlQuery);
		result = preparedStatement.executeQuery();
		System.out.println("Odczytano rekord, przypisano do ResultSet");
		metaDate = getResult().getMetaData();
	}

	@Override
	protected void process() throws SQLException {
		int numberOfColumn = metaDate.getColumnCount();
		for (int i = 0; i < numberOfColumn; i++) {
			System.out.print(metaDate.getColumnName(i + 1) + "\t");
		}

		System.out.print("\n");

	}

}
