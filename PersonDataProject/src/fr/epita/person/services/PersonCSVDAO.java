package fr.epita.person.services;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import fr.epita.person.datamodel.Person;

public class PersonCSVDAO {
	
	public List<Person> readAll(File dataFile){
		File file = new File("data-2.csv");
		List<String> lines;
		try {
			lines = Files.readAllLines(file.toPath());
		} catch (IOException e) {
			System.out.println("unable to load the file, " + e.getMessage());
			System.out.println("check the configuration, the program must exit now");
			return new ArrayList<>();
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
		return persons;
	}
	
	
	public void writeAll(List<Person> persons, File file) {
		PrintWriter writer;
		try {
			 writer = new PrintWriter(file);
		} catch (FileNotFoundException e) {
			System.out.println("not able to open the file in write mode : " + e.getMessage());
			System.out.println("exiting...");
			return;
			
		}
		
		writer.println("\"Name\", \"Sex\", \"Age\", \"Height (in)\", \"Weight (lbs)\"");
		
		for (Person person : persons) {
			//"Alex", "M", 41, 74, 170 
			writer.print("\"" + person.getName() +"\", ");
			writer.print("\"" + person.getSex() +"\", ");
			writer.print( person.getAge() + ", ");
			writer.print( person.getHeight() + ", ");
			writer.println( person.getWeight());
			
		}
		
		writer.flush();
		writer.close();
	}

}
