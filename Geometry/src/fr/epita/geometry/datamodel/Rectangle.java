package fr.epita.geometry.datamodel;

public class Rectangle implements Shape {
	
	private double height;
	private double width;
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	
	@Override
	public double calculateArea() {
		return this.width * this.height;
	}
	@Override
	public double calculatePerimeter() {
		return this.height * 2 + this.width *2;
	}
	
	
	
	

}
