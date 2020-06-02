package fr.epita.logger.tests;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.List;
import java.util.Scanner;

public class TestFiles {
	
	public static void main(String[] args) throws IOException {
		File file = new File("test.txt");
		PrintWriter writer = new PrintWriter(file);
		writer.println("hi from java");
		writer.close();
		
	
		
		List<String> lines = Files.readAllLines(file.toPath());
		System.out.println(lines);
		
		Scanner scanner = new Scanner(file);
		while(scanner.hasNextLine()) {
			System.out.println(scanner.nextLine());
		}
		
		scanner.close();
		
	}

}
