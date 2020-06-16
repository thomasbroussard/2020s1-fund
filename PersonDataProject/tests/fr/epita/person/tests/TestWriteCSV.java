package fr.epita.person.tests;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import fr.epita.person.datamodel.Person;
import fr.epita.person.services.PersonCSVDAO;

public class TestWriteCSV {

	
	public static void main(String[] args) {
		Person p1 = new Person();
		p1.setAge(25);
		p1.setName("Thomas");
		p1.setSex("M");
		p1.setHeight(74);
		p1.setWeight(170);
		
		
		Person p2 = new Person();
		p2.setAge(30);
		p2.setName("Quentin");
		p2.setSex("M");
		p2.setHeight(80);
		p2.setWeight(180);
		
		List<Person> persons = Arrays.asList(p1,p2);
		PersonCSVDAO dao = new PersonCSVDAO();
		dao.writeAll(persons, new File("data-2.csv"));
		
		//make a list from the hardcoded persons
		//write this list in a file (data-2.csv) using the csv format present in the data.csv file
		
	}


}
