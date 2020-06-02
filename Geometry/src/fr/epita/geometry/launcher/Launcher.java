package fr.epita.geometry.launcher;

import java.util.Arrays;
import java.util.List;

import fr.epita.geometry.datamodel.Circle;
import fr.epita.geometry.datamodel.Shape;
import fr.epita.geometry.datamodel.Square;
import fr.epita.geometry.datamodel.Triangle;

public class Launcher {
	
	public static void main(String[] args) {
		Triangle t1 = new Triangle(3,3,2,5);
		Triangle t2 = new Triangle(4,3,2,5);
		Triangle t3 = new Triangle(5,3,2,5);
		
		Triangle[] triangleArray =  new Triangle[3];
		triangleArray[0] = t1;
		triangleArray[1] = t2;
		triangleArray[2] = t3;
		
		
//		for (Triangle t : triangleList) {
//			trianglesArea += t.calculateArea();
//		}
//		trianglesArea = 0;
//		for (int i = 0; i < triangleList.size(); i++) {
//			Triangle currentTriangle = triangleList.get(i);
//			trianglesArea += currentTriangle.calculateArea();
//		}
		
		// List<Triangle> --> | map: f(t) -> t.calculateArea() | reduce : sum(area)
		
		Circle c1 = new Circle(3);
		Circle c2 = new Circle(7);
		Circle c3 = new Circle(10);

		
		
		Square s1 = new Square(5);
		Square s2 = new Square(6);
		Square s3 = new Square(8);
		
		List<Shape> shapes = Arrays.asList(t1,t2,t3,c1,c2,c3,s1,s2,s3);
		
		Shape t4 = new Triangle(3,4,5,6);
		
		double globalArea = shapes.stream()
				.mapToDouble(shape -> shape.calculateArea())
				.sum();
		
		System.out.println(globalArea);
		
	}
	
}
