package com.learnings;

//Three steps for factory-

//Create interface with all methods.
//Create class implementing the interface and add interface methods.
//Factory class returning objects of concrete class.
//Use the factory .

//Interface shape is created.
interface Shape {
	// Draw method.
	void draw();
}

//Factory design pattern-
//Create object without exposing its creation logic to client.
//Use one common interface to access the object

//Rectangle square and circle implement the interface methods.

class Rectangle implements Shape {

	@Override
	public void draw() {
		System.out.println("rectangle class implementing shape");

	}

}

class Square implements Shape {

	@Override
	public void draw() {
		System.out.println("square class implementing shape");

	}

}

class Circle implements Shape {

	@Override
	public void draw() {
		System.out.println("circle class implementing shape");

	}

}

//create class.
class ShapeFactory {
	// returning object also works if we are not sure of the datatype
	// in out case we know all classes implement shape interface.
//	Object getShape(String shapeType) {
	Shape getShape(String shapeType) {

		// If shape is null then return null else return instance of respective class.
		if (shapeType == null) {
			return null;
		} else if (shapeType.equalsIgnoreCase("rectangle")) {
			return new Rectangle();
		} else if (shapeType.equalsIgnoreCase("circle")) {
			return new Circle();
		} else if (shapeType.equalsIgnoreCase("square")) {
			return new Square();
		}
		// if none of the value comes then return null
		// if we dont write below return we get - This method must return a result of
		// type Shape
		// this is because all other return runs when some condition is met,
		// what to do when no condition is met and what to return.
//		return null;
		return null;
	}
}

public class FactoryDesignPatternWorking {

	public static void main(String[] args) {
		// Shape factory object
		ShapeFactory sf1 = new ShapeFactory();
		// write in upper case and it will be ignored based on the conditional check we
		// applied earlier.
		// Call method and pass argument
		Shape s1 = sf1.getShape("CIRCLE");
		// Call draw method
		s1.draw();
		Shape s2 = sf1.getShape("RECTANGLE");
		s2.draw();
		Shape s3 = sf1.getShape("SQUARE");
		s3.draw();
	}

}
