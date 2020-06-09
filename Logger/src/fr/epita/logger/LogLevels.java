package fr.epita.logger;

public enum LogLevels {
	
	ERROR("error", 0),
	WARNING("warning", 10),
	INFO("info", 20),
	DEBUG("debug", 30),
	TRACE("trace", 40);
	
	
	private String level;
	private int levelOrder;
	
	
	
	private LogLevels(String level, int levelOrder) {
		this.level = level;
		this.levelOrder = levelOrder;
	}


	public String getLevel() {
		return level;
	}


	public void setLevel(String level) {
		this.level = level;
	}


	public int getLevelOrder() {
		return levelOrder;
	}


	public void setLevelOrder(int levelOrder) {
		this.levelOrder = levelOrder;
	}
	
	
	
	
	

}
