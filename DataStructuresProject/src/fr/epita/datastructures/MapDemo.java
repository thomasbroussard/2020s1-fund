package fr.epita.datastructures;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapDemo {
	
	public static void main(String[] args) {
		Map<Integer,Integer> map = new HashMap<Integer, Integer>();
		
		Person p1 = new Person();
		p1.setAge(20);
		p1.setName("Thomas");
		
		Person p2 = new Person();
		p2.setAge(20);
		p2.setName("Lucas");
		
		Person p3 = new Person();
		p3.setAge(25);
		p3.setName("Quentin");
		
		List<Person> list = Arrays.asList(p1,p2,p3);
		for(Person p : list) {
			Integer integer = map.get(p.getAge());
			if (integer == null) {
				integer = 1;
			}else {
				integer++;
			}
			map.put(p.getAge(),integer++);
		}
		System.out.println(map);
		
	}

}
