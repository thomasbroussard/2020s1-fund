package fr.epita.person.tests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class testh2 {

	
	public static void main(String[] args) throws SQLException {
		Connection connection = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
		
		PreparedStatement statement = connection.prepareStatement("select * from person");
		ResultSet rs = statement.executeQuery();
		while (rs.next()) {
			System.out.println(rs.getString(1));
		}
		System.out.println("============================");
		statement = connection.prepareStatement("SELECT * FROM PERSON ORDER BY WEIGHT DESC");
		rs = statement.executeQuery();
		while (rs.next()) {
			System.out.println(rs.getString(1));
		}
		System.out.println("============================");
		Scanner scanner = new Scanner(System.in);
		System.out.println("enter the first letters of the name you want to find");
		String filter = scanner.nextLine();
		statement = connection.prepareStatement("SELECT * FROM PERSON WHERE NAME LIKE ?");
		statement.setString(1, filter + "%");
		rs = statement.executeQuery();
		while (rs.next()) {
			System.out.println(rs.getString(1));
		}
		System.out.println("============================");
		
		statement = connection.prepareStatement("select age as ages, count(*) as count from person group by age");
		rs = statement.executeQuery();
		while (rs.next()) {
			System.out.print(rs.getInt(1));
			System.out.print(" \t");
			System.out.println(rs.getInt(2));
		}
		
		
		scanner.close();
		
		//TODO : extract the content of the following queries :
		
//		SELECT * FROM PERSON ORDER BY WEIGHT DESC;
//		SELECT * FROM PERSON WHERE NAME LIKE 'Q%'
//		select age as ages, count(*) as count from person group by age;
		
	}
}
