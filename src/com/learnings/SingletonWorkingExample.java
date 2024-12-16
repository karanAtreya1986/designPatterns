package com.learnings;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;

//create this class - SerializedSingleton
class SerializedSingleton implements Serializable {

	// Singleton -
	// One instance to work at one point in time.
	// One thread working at one point in time.
	// Another object never created unless first object done and dusted.

	// Rules-
	// Private constructor so other classes cannot create more than one object.
	// Private static variable – so that we can use variable with class not use them
	// at object level. Created within private static inner class.
	// Public static method – returns instance of class. To access singleton class
	// use this method.

	// this is not mandatory but we can just implement the variable.
	// Serializable present when we post data over network.

	private static final long serialVersionUID = 1L;

	// private constructor.
	private SerializedSingleton() {
	}

	// Private static inner class with instance.
	private static class SingletonHelper {
		private static SerializedSingleton instance1 = new SerializedSingleton();
	}

	// Public static method which returns instance of class.
	public static SerializedSingleton getInstance() {
		return SingletonHelper.instance1;
	}

	// Not mandatory new concept in java –
	// Create protected method to return single instance of class. Same work which
	// the public static method is doing.

	protected Object readResolve() {
		// get instance returns SerializedSingleton
		// Get instance using getinstance() method
		return getInstance();
	}
}

public class SingletonWorkingExample {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		// Create instance
		SerializedSingleton s1 = SerializedSingleton.getInstance();
		ObjectOutput o1 = new ObjectOutputStream(new FileOutputStream("E:/abcd.txt"));
		// Write to file the instance value
		o1.writeObject(s1); // returns void
		// Close file
		o1.close(); // returns void

		// Read from file
		ObjectInput o2 = new ObjectInputStream(new FileInputStream("E:/abcd.txt"));
		// case to serialized singleton class

		// Another instance to read and store value.
		// since readObject returns object, so we casted
		SerializedSingleton s2 = (SerializedSingleton) o2.readObject(); // returns object

		// Close file
		o2.close();

		// Check hash code value to see if one object is created or many
		// if only one object then hash code or memory address will be the same.
		System.out.println("hash code value of first object is " + s1);
		System.out.println("hash code value of second object is " + s2);

	}

}
