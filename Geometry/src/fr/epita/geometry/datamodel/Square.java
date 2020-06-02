package fr.epita.geometry.datamodel;

public class Square implements Shape {

	private double side;
	
	private Rectangle rectangle;
	
	public double getSide() {
		return side;
	}

	public void setSide(double side) {
		this.side = side;
	}




	public Square(double side) {
		this.side = side;
		this.rectangle = new Rectangle();
		rectangle.setHeight(side);
		rectangle.setWidth(side);
	}
	
	public double calculateArea() {
		return rectangle.calculateArea();
	}
	
	public double calculatePerimeter() {
		return rectangle.calculatePerimeter();
	}
	
}
