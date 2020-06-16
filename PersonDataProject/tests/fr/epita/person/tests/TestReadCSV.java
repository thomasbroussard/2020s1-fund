package fr.epita.person.tests;

import java.io.File;
import java.util.List;

import fr.epita.person.datamodel.Person;
import fr.epita.person.services.PersonCSVDAO;

public class TestReadCSV {
	
	public static void main(String[] args) {
		PersonCSVDAO dao = new PersonCSVDAO();
		List<Person> persons = dao.readAll(new File("data.csv"));
		System.out.println(persons);
		
	}
	
}
