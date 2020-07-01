package fr.epita.quiz.datamodel;

public class Question {
	//rename question to subject : less confusing
	private String subject;
	
	private String[] topics;
	
	private Integer difficulty;

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String[] getTopics() {
		return topics;
	}

	public void setTopics(String[] topics) {
		this.topics = topics;
	}

	public Integer getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(Integer difficulty) {
		this.difficulty = difficulty;
	}

	
	
	
}
