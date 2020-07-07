package fr.epita.services.tests;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.epita.quiz.datamodel.Question;
import fr.epita.quiz.services.Configuration;
import fr.epita.quiz.services.QuestionDAO;

public class TestQuestionDAO {

	
	
	static boolean isInited = false;
	
	private static void init() throws SQLException {
		if (!isInited) {
		String createTableSQL = "CREATE TABLE QUESTION(ID INT PRIMARY KEY AUTO_INCREMENT , SUBJECT VARCHAR(2000), TOPICS VARCHAR(1000), DIFFICULTY INT)";
		Connection connection = DriverManager.getConnection("jdbc:h2:mem:quiz", "sa", ""); //TODO : externalize
		PreparedStatement pstmt = connection.prepareStatement(createTableSQL);
		pstmt.execute();
		isInited = true;
		}
		
	}
	
	public static void main(String[] args) throws SQLException, FileNotFoundException, IOException {
		Configuration conf = Configuration.getInstance();
		
		//given
		init();
		Question question = new Question();
		question.setDifficulty(3);
		question.setSubject("What is a dao");
		question.setTopics(new String[] {"design pattern","dao"});
		
		//when
		QuestionDAO dao = new QuestionDAO();
		dao.create(question);
		
		//then
		Connection connection = DriverManager.getConnection(conf.getConfValue("db.url"), conf.getConfValue("db.user"), conf.getConfValue("db.password")); //TODO : externalize
		PreparedStatement statement = connection.prepareStatement("select count(1) from QUESTION where subject='What is a dao'");
		ResultSet rs = statement.executeQuery();
		rs.next();
		int matchingQuestionCount = rs.getInt(1);
		System.out.println(matchingQuestionCount);
		if (matchingQuestionCount < 1) {
			System.out.println("error");
		}else {
			System.out.println("success!");
		}
		
		//clean
		
		
	}
}
