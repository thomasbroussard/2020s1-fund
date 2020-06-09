package fr.epita.logger;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {

	private LogLevels threshold = LogLevels.INFO;

	// error > warning > info > debug > trace
	// threshold: ^
	// only errors and warnings will be present in the log file.

	public LogLevels getThreshold() {
		return threshold;
	}

	public void setThreshold(LogLevels threshold) {
		this.threshold = threshold;
	}

	public void info(String message) {
		LogLevels level = LogLevels.INFO;
		checkAndPrint(message, level);

	}
	
	public void warning(String message) {
		checkAndPrint(message, LogLevels.WARNING);
	}

	public void error(String message) {
		checkAndPrint(message, LogLevels.ERROR);
	}

	public void debug(String message) {
		checkAndPrint(message, LogLevels.DEBUG);
	}

	public void trace(String message) {
		checkAndPrint(message, LogLevels.TRACE);
	}

	private void checkAndPrint(String message, LogLevels level) {
		if (threshold.getLevelOrder() >= level.getLevelOrder()) {

			print(message, getTimeStamp(), level.getLevel());
		}
	}
	private String getTimeStamp() {
		SimpleDateFormat sdf = getFormat();
		String timestamp = sdf.format(new Date());
		return timestamp;
	}

	private void print(String message, String timestamp, String logLevel) {
		String output = timestamp + " -- " + logLevel + " -- " + message;
		String fileName = "application.log";

		File file = new File(fileName);
		try (FileOutputStream out = new FileOutputStream(file, true); PrintWriter writer = new PrintWriter(out);) {
			writer.println(output);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private SimpleDateFormat getFormat() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		return sdf;
	}
}
