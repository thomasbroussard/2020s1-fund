package fr.epita.datastructures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ListDemo {

	public static void main(String[] args) {
		List<String> levelsList = new ArrayList<String>();
		levelsList.add("info");
		levelsList.add("debug");
		levelsList.add("warning");
		
		
		List<String> levelsListFromArray = Arrays.asList(new String[] {"info","debug","warning"});
		List<String> levelsListFromVarArgs = Arrays.asList("info","debug","warning","error");
		
		System.out.println(levelsList);
		System.out.println(levelsListFromArray);
		System.out.println(levelsListFromVarArgs);
		
		//Sorting principle:
		
		
		//given 3 strings : "a","w","d" 
		//comparator instance to indicate the sort order
		//comparator.compare("a","w") > 0 so stay in same order
		//comparator.compare("w","d") < 0 so exchange
		//final state :"a","d","w" 
		
		// section A
		Comparator<String> comparator = new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
			
		};
		
		
		levelsListFromVarArgs.sort(comparator);

		//end of section A

		// section B, equivalent to section A, lambda style
		levelsListFromVarArgs.sort((o1,o2) -> o1.compareTo(o2));
		// end of section B 
		
		
		
		
		System.out.println("sorted");
		System.out.println(levelsListFromVarArgs);
		
		System.out.println("is it true that levelsList contains 'a'? answer : "+ levelsList.contains("a"));
		System.out.println("is it true that levelsList contains 'info'? answer : "+ levelsList.contains("info"));
		
		levelsList.remove("info");
		levelsList.remove(0);
		System.out.println(levelsList);
		
		List<String> oList = levelsListFromVarArgs.stream()
			.filter(element -> element.contains("o") )
			.collect(Collectors.toList());
		
		System.out.println(oList);
		
	}
}
