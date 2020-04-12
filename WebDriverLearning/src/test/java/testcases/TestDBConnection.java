package testcases;

import java.sql.SQLException;

public class TestDBConnection {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		DbManager.setMysqlDbConnection();
		System.out.println(DbManager.getMysqlQuery("select tutorial_author from webdriver where tutorial_id=2"));
		

	}

}
