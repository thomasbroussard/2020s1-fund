package fr.epita.person.tests;

import java.io.File;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import fr.epita.person.datamodel.Person;
import fr.epita.person.services.PersonCSVDAO;

public class TestStats {
	
	public static void main(String[] args) {
		PersonCSVDAO dao = new PersonCSVDAO();
		List<Person> persons = dao.readAll(new File("data.csv"));
		
		//total age / #persons
		
		//calculateAverage(persons);
		
		persons.sort(new Comparator<Person>() {

			@Override
			public int compare(Person p1, Person p2) {
				return p1.getAge() - p2.getAge();
			}
			
			
		});
		
		System.out.println("median age : " );
		System.out.println(medianAge(persons));
		
		Map<Integer, Integer> countByAge = new LinkedHashMap<>();
		
		for (Person p : persons) {
			Integer age = p.getAge();
			Integer count = countByAge.get(age);
			if (count == null) {
				count = 1;
			}else {
				count++;
			}
			countByAge.put(age,count);
		}
		
		System.out.println(countByAge);
		
		Map<Integer,Long> map = persons.stream()
			.collect(Collectors.groupingBy(Person::getAge,Collectors.counting()));
		
		System.out.println("got this from stream api:");
		System.out.println(map);
	
		
		
		
		
		
	}

	private static int medianAge(List<Person> persons) {
		
	//	while (currentPopulation <= size /2) {
	//		currentPopulation ++;
	//	}
	//	medianAge =  persons.get(currentPopulation).getAge();
			
		int size = persons.size();
		
	//	System.out.println(persons);
		
		int currentPopulation = 0;
		int medianAge = 0;
		
		for (Person person : persons) {
			currentPopulation ++;
			if (currentPopulation > size /2 ) {
				 return person.getAge();
			}
		}
		return 0;
		
		
	}

	private static void calculateAverage(List<Person> persons) {
		int totalAge = 0;
		for (Person person : persons) {
			totalAge += person.getAge();
		}
		double averageAge = Double.valueOf(totalAge) / persons.size();
		System.out.println("average age = " + averageAge);
		
		persons.stream()
			.mapToInt(Person::getAge)
			.average();
	}

}
