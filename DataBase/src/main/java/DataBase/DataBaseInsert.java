package DataBase;

import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class DataBaseInsert extends DataBaseConfig {
	protected PreparedStatement preparedStatement;

	private String dbTable;

	private String dBfirstColumnName;

	private String dBsecondColumnName;

	private String dBthirdColumnName;

	private String dBfourthColumnName;

	private String valueInFirstColumn;

	private String valueInSecondColumn;

	private String valueInThirdColumn;

	private String valueInFourthColumn;

	public void setdBfirstColumnName(String dBfirstColumnName) {
		this.dBfirstColumnName = dBfirstColumnName;
	}

	public void setdBsecondColumnName(String dBsecondColumnName) {
		this.dBsecondColumnName = dBsecondColumnName;
	}

	public void setdBthirdColumnName(String dBthirdColumnName) {
		this.dBthirdColumnName = dBthirdColumnName;
	}

	public void setdBfourthColumnName(String dBfourthColumnName) {
		this.dBfourthColumnName = dBfourthColumnName;
	}

	public void setValueInFirstColumn(String idklienta) {
		this.valueInFirstColumn = idklienta;
	}

	public void setValueInSecondColumn(String imie) {
		this.valueInSecondColumn = imie;
	}

	public void setValueInThirdColumn(String nazwisko) {
		this.valueInThirdColumn = nazwisko;
	}

	public void setValueInFourthColumn(String miejscowosc) {
		this.valueInFourthColumn = miejscowosc;
	}

	public void setDbTable(String dbTable) {
		this.dbTable = dbTable;
	}

	@Override
	protected void statement() throws SQLException {
		final String sqlQueryInsert = "INSERT INTO "  +getDBName() +"."+dbTable + " (" + dBsecondColumnName + ", " + dBthirdColumnName + ", " + dBfourthColumnName + ")" 
				+  " VALUES" + " (" + valueInSecondColumn + ", " + valueInThirdColumn + ", " + valueInFourthColumn + ")";
		try {
			System.out.println(sqlQueryInsert);
			preparedStatement = (PreparedStatement) connection.prepareStatement(sqlQueryInsert);
			
		
		} catch (SQLException e) {
			System.out.println("nie uda³o siê wstawiæ wiersza :|");
			e.printStackTrace();
		}

	}

	@Override
	protected void process() throws SQLException {
		preparedStatement.executeUpdate();
		System.out.println("Wykonano wstawienie do bazy danych");

	}

}
