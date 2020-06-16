package fr.epita.person.tests;

import fr.epita.person.datamodel.Person;

public class TestWriteCSV {

	
	public static void main(String[] args) {
		Person p1 = new Person();
		p1.setAge(25);
		p1.setName("Thomas");
		p1.setSex("M");
		p1.setHeight(74);
		p1.setWeight(170);
		
		//make a list from the hardcoded persons
		//write this list in a file (data-2.csv) using the csv format present in the data.csv file
		
	}
}
