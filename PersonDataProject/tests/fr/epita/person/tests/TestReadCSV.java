package fr.epita.person.tests;

import fr.epita.person.datamodel.Person;

public class TestReadCSV {
	
	public static void main(String[] args) {
		String csvLine = "\"Alex\", \"M\", 41, 74, 170"; 
		String[] lineParts = csvLine.split(",");
		Person p = new Person();
		
		p.setName(lineParts[0]);
		p.setSex(lineParts[1]);
		p.setAge(Integer.valueOf(lineParts[2].strip()));
		p.setHeight(Integer.valueOf(lineParts[3].strip()));
		p.setWeight(Integer.valueOf(lineParts[4].strip()));
		
		System.out.println(p);
		
	}

}
