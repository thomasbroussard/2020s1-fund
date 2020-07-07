package fr.epita.quiz.services;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.epita.quiz.datamodel.Question;

public class QuestionDAO {

	// CRUD : CREATE, READ, UPDATE, DELETE
	public void create(Question question) throws CreateFailedException {
		Configuration conf = Configuration.getInstance();
		String SQL_QUERY = "INSERT INTO QUESTION(SUBJECT, TOPICS, DIFFICULTY) VALUES(?, ?, ?);";
		try {
			Connection connection = getConnection(conf);
			PreparedStatement pstmt = connection.prepareStatement(SQL_QUERY);
			pstmt.setString(1, question.getSubject());
			String arrayAsString = String.valueOf(question.getTopics()); //add comma between each part of the array
			pstmt.setString(2, arrayAsString);
			pstmt.setInt(3, question.getDifficulty());
			pstmt.execute();
			connection.close();
		} catch (SQLException e) {
			CreateFailedException createFailedException = new CreateFailedException();
			createFailedException.initCause(e);
			createFailedException.setObj(question);
			throw createFailedException;
		}

	}

	public List<Question> search(Question question) throws SQLException {
		Configuration conf = Configuration.getInstance();
		List<Question> questionResult = new ArrayList<>();
		Connection connection = getConnection(conf);
		PreparedStatement statement = connection
				.prepareStatement("select SUBJECT, TOPICS, DIFFICULTY from QUESTION where subject LIKE ?");
		statement.setString(1, question.getSubject() + "%");
		ResultSet rs = statement.executeQuery();
		while(rs.next()) {
			String subject = rs.getString(1);
			String topics = rs.getString(2);
			Integer difficulty = rs.getInt(3);
			Question currentQuestion = new Question();
			currentQuestion.setSubject(subject);
			currentQuestion.setTopics(topics.split(","));
			currentQuestion.setDifficulty(difficulty);
			questionResult.add(currentQuestion);
		}
		
		connection.close();
		return questionResult;
	}

	private Connection getConnection(Configuration conf) throws SQLException {
		Connection connection = DriverManager.getConnection(conf.getConfValue("db.url"), conf.getConfValue("db.user"),
				conf.getConfValue("db.password")); // TODO : externalize
		return connection;
	}

	public void update(Question question) {

	}

	public void delete(Question question) {

	}

}
