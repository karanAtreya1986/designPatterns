package com.learnings;

interface Shape2 {
	void draw();
}

class Rectangle2 implements Shape2 {

	@Override
	public void draw() {
		System.out.println("rectangle class implementing shape");

	}

}

class Square2 implements Shape2 {

	@Override
	public void draw() {
		System.out.println("square class implementing shape");

	}

}

class Circle2 implements Shape2 {

	@Override
	public void draw() {
		System.out.println("circle class implementing shape");

	}

}

class ShapeFactory2 {
	// if we return object, then we get methods from object class and not its child
	// classes.
	// we get tostring and other methods
	// we converted to string format
	// printed it
	// it gave us the memory address
	// so like earlier program, we need to typecast object to the desired class and
	// then use it.
	Object getShape(String shapeType) {
		if (shapeType == null) {
			return null;
		} else if (shapeType.equalsIgnoreCase("rectangle")) {
			return new Rectangle2();
		} else if (shapeType.equalsIgnoreCase("circle")) {
			return new Circle2();
		} else if (shapeType.equalsIgnoreCase("square")) {
			return new Square2();
		}

		return null;
	}
}

public class UsingObjectAsReturnTypeInShapeFactoryClassWithoutTypeCastingObject {

	public static void main(String[] args) {
		ShapeFactory2 sf1 = new ShapeFactory2();

		Object s1 = sf1.getShape("CIRCLE");
		String s11 = s1.toString();
		System.out.println(s11);
		Object s2 = sf1.getShape("RECTANGLE");
		String s22 = s1.toString();
		System.out.println(s22);
		Object s3 = sf1.getShape("SQUARE");
		String s33 = s1.toString();
		System.out.println(s33);

	}

}
