package fr.epita.person.tests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestH2 {

	
	public static void main(String[] args) throws SQLException {
		Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
		


		
		PreparedStatement statement = connection.prepareStatement("select * from person");
		ResultSet rs = statement.executeQuery();
		while (rs.next()) {
			System.out.println(rs.getString(1));
		}
		
		//TODO : extract the content of the following queries :
		
//		SELECT * FROM PERSON ORDER BY WEIGHT DESC;
//		SELECT * FROM PERSON WHERE NAME LIKE 'Q%'
//		select age as ages, count(*) as count from person group by age;
		
	}
}
