package fr.epita.geometry.datamodel;

public class Square extends Rectangle implements Shape {

	private double side;

	public double getSide() {
		return side;
	}

	public void setSide(double side) {
		this.side = side;
	}

	
	
	@Override
	public double getHeight() {
		// TODO Auto-generated method stub
		return this.side;
	}

	@Override
	public void setHeight(double height) {
		// TODO Auto-generated method stub
		this.side = height;
	}

	@Override
	public double getWidth() {
		return this.side;
	}

	@Override
	public void setWidth(double width) {
		// TODO Auto-generated method stub
		this.side = width;
	}

	public Square(double side) {
		this.side = side;
	}
	
	public double calculateArea() {
		return this.side * this.side;
	}
	
	public double calculatePerimeter() {
		return this.side * 4;
	}
	
}
