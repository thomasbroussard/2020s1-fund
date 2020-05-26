package fr.epita.geometry.launcher;

import fr.epita.geometry.datamodel.Circle;
import fr.epita.geometry.datamodel.Square;
import fr.epita.geometry.datamodel.Triangle;

public class Launcher {
	
	public static void main(String[] args) {
		Triangle t1 = new Triangle(3,3,2,5);
		System.out.println(t1.calculateArea());
		
		Circle c1 = new Circle(3);
		System.out.println(c1.calculatePerimeter());
		
		Square s1 = new Square(5);
		
		System.out.println(s1.calculateArea());
	}
	
}
