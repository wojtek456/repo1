package DataBase;

import java.security.KeyStore.ProtectionParameter;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

public class DataBaseUpdate extends DataBaseConfig {

	protected PreparedStatement preparedStatement;

	private String columnNameModyfication;
	private int number;
	private String dbName;
	private String dbTable;
	private String Value;
	protected String sqlQueryUpdate;

	public void setValue(String value) {
		Value = value;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

	public void setDbTable(String dbTable) {
		this.dbTable = dbTable;
	}

	public void setColumnNameModyfication(String columnNameModyfication) {
		this.columnNameModyfication = columnNameModyfication;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	@Override
	protected void statement() {
		sqlQueryUpdate = "UPDATE " + dbName + "." + dbTable + " SET " + columnNameModyfication + " = ? "
				+ " WHERE idklienta = ?";
		try {
			System.out.println(sqlQueryUpdate);
			preparedStatement = (PreparedStatement) connection.prepareStatement(sqlQueryUpdate);
			preparedStatement.setString(1, Value);
			preparedStatement.setInt(2, number);

		} catch (SQLException e) {
			System.out.println("nie uda³o siê wywo³aæ kwerendy :|");
			e.printStackTrace();
		}

	}

	@Override
	protected void process() throws SQLException {
		preparedStatement.executeUpdate();
		System.out.println("Wykonano UPDATE bazy)");
	}

}
