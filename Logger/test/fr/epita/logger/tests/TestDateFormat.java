package fr.epita.logger.tests;

import java.text.SimpleDateFormat;
import java.util.Date;



public class TestDateFormat {
	
	public static void main(String[] args) throws InterruptedException {
		
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		
		System.out.println(sdf.format(new Date()) + " operation1");
		Thread.sleep(10);
		System.out.println(sdf.format(new Date()) + " operation2");
	}

}
