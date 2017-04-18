package projeto.interdisciplinar.ton.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AcessDAO {

	private String dbUrl = "jdbc:oracle:thin:@localhost:1521:XE";
	private String dbUser = "TONDBA";
	private String dbPassword = "ADMTON123";
	private  Connection myConnection;

	public AcessDAO() throws ClassNotFoundException {
		// Carrega driver do oracle
		Class.forName("oracle.jdbc.driver.OracleDriver");
	}

	public Connection openConnection() throws SQLException {
		setMyConnection(DriverManager.getConnection(dbUrl, dbUser, dbPassword));

		return getMyConnection();
	}

	public Connection getMyConnection() {
		return myConnection;
	}

	public void setMyConnection(Connection myConnection) {
		this.myConnection = myConnection;
	}

}
