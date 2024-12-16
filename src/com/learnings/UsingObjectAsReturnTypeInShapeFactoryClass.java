package com.learnings;

interface Shape1 {
	void draw();
}

class Rectangle1 implements Shape1 {

	@Override
	public void draw() {
		System.out.println("rectangle class implementing shape");

	}

}

class Square1 implements Shape1 {

	@Override
	public void draw() {
		System.out.println("square class implementing shape");

	}

}

class Circle1 implements Shape1 {

	@Override
	public void draw() {
		System.out.println("circle class implementing shape");

	}

}

class ShapeFactory1 {
	// returning object also works if we are not sure of the datatype
	// in out case we know all classes implement shape interface.
	Object getShape(String shapeType) {
		if (shapeType == null) {
			return null;
		} else if (shapeType.equalsIgnoreCase("rectangle")) {
			return new Rectangle1();
		} else if (shapeType.equalsIgnoreCase("circle")) {
			return new Circle1();
		} else if (shapeType.equalsIgnoreCase("square")) {
			return new Square1();
		}

		return null;
	}
}

public class UsingObjectAsReturnTypeInShapeFactoryClass {

	public static void main(String[] args) {
		ShapeFactory1 sf1 = new ShapeFactory1();

		Object s1 = sf1.getShape("CIRCLE");
		((Shape1) s1).draw();
		Object s2 = sf1.getShape("RECTANGLE");
		((Shape1) s2).draw();
		Object s3 = sf1.getShape("SQUARE");
		((Shape1) s3).draw();
	}

}
