package fr.epita.logger.tests;

import fr.epita.logger.LogLevels;
import fr.epita.logger.Logger;

public class TestLogger {
	
	
	
	
	//error
	//warning
	//info
	//debug
	//trace
	public static void main(String[] args) {
		Logger logger = new Logger();
		logger.setThreshold(LogLevels.DEBUG);
		
		
		logger.info("program started");
		logger.warning("warning");
		logger.error("error");
		logger.debug("debug");
		logger.trace("trace");
		
		
		
	}

}
