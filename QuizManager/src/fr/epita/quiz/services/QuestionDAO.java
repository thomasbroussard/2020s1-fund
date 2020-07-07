package fr.epita.quiz.services;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.epita.quiz.datamodel.Question;

public class QuestionDAO {
	
	//CRUD : CREATE, READ, UPDATE, DELETE
	public void create(Question question) throws SQLException {
		Configuration conf = Configuration.getInstance();
		String SQL_QUERY = "INSERT INTO QUESTION(SUBJECT, TOPICS, DIFFICULTY) VALUES(?, ?, ?);";
		Connection connection = DriverManager.getConnection(conf.getConfValue("db.url"), conf.getConfValue("db.user"), conf.getConfValue("db.password") ); //TODO : externalize
		PreparedStatement pstmt = connection.prepareStatement(SQL_QUERY);
		pstmt.setString(1, question.getSubject());
		String arrayAsString = String.valueOf(question.getTopics());
		pstmt.setString(2, arrayAsString);
		pstmt.setInt(3, question.getDifficulty());
		pstmt.execute();
		
	}
	
	public List<Question> search(Question question) {
		List<Question> questionResult = new ArrayList<>();
		
		return questionResult;
	}
	
	public void update(Question question) {
		
	}
	
	public void delete(Question question) {
		
	}
	

}
