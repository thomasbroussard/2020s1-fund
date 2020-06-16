package fr.epita.person.tests;

import java.io.File;
import java.util.List;

import fr.epita.person.datamodel.Person;
import fr.epita.person.services.PersonCSVDAO;

public class TestWriteCSV {

	
	public static void main(String[] args) {

		PersonCSVDAO dao = new PersonCSVDAO();
		List<Person> persons = dao.readAll(new File("data.csv"));
		dao.writeAll(persons, new File("data-2-reversed.csv"));
		
		
		
		//make a list from the hardcoded persons
		//write this list in a file (data-2.csv) using the csv format present in the data.csv file
		
	}


}
