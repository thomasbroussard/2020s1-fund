package fr.epita.person.tests;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import fr.epita.person.datamodel.Person;

public class TestReadCSV {
	
	public static void main(String[] args) {
		
		File file = new File("data.csv");
		List<String> lines;
		try {
			lines = Files.readAllLines(file.toPath());
		} catch (IOException e) {
			System.out.println("unable to load the file, " + e.getMessage());
			System.out.println("check the configuration, the program must exit now");
			return;
		}
		List<Person> persons = new ArrayList<>();
		lines.remove(0);
		for(int i = 0; i < lines.size(); i++) {
			
			String csvLine = lines.get(i); 
			
			
			String[] lineParts = csvLine.split(",");
			Person p = new Person();
			
			p.setName(lineParts[0]);
			p.setSex(lineParts[1]);
			p.setAge(Integer.valueOf(lineParts[2].strip()));
			p.setHeight(Integer.valueOf(lineParts[3].strip()));
			p.setWeight(Integer.valueOf(lineParts[4].strip()));
			
			persons.add(p);
		}
		System.out.println(persons);
		
	}
	
	
//	public int readFromFile(List existingList) {
//		try {
//			existingList.addAll(Files.readAllLines(new File("").toPath()));
//		}catch(Exception e) {
//			return -1;
//		}
//		return 0;
//	}
//	
//	public static List<String> readFromFileWithException() throws Exception {
//	
//		return Files.readAllLines(new File("").toPath());
//
//	}

}
