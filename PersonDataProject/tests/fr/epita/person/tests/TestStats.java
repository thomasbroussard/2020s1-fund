package fr.epita.person.tests;

import java.io.File;
import java.util.List;

import fr.epita.person.datamodel.Person;
import fr.epita.person.services.PersonCSVDAO;

public class TestStats {
	
	public static void main(String[] args) {
		PersonCSVDAO dao = new PersonCSVDAO();
		List<Person> persons = dao.readAll(new File("data.csv"));
		
		//total age / #persons
		
		int totalAge = 0;
		for (Person person : persons) {
			totalAge += person.getAge();
		}
		double averageAge = totalAge / persons.size();
		System.out.println("average age = " + averageAge);
		
	}

}
