package fr.epita.logger;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {

	
	public void info(String message) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		String timestamp = sdf.format(new Date());
		System.out.println(timestamp + " -- info -- " + message);
		
	}
}
