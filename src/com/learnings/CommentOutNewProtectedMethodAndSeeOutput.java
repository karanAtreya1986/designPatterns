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
class SerializedSingleton1 implements Serializable {

	private static final long serialVersionUID = 1L;

	// private constructor.
	private SerializedSingleton1() {
	}

	// Private static inner class with instance.
	private static class SingletonHelper {
		private static SerializedSingleton1 instance1 = new SerializedSingleton1();
	}

	// Public static method which returns instance of class.
	public static SerializedSingleton1 getInstance() {
		return SingletonHelper.instance1;
	}

}

public class CommentOutNewProtectedMethodAndSeeOutput {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		// Create instance
		SerializedSingleton1 s1 = SerializedSingleton1.getInstance();
		ObjectOutput o1 = new ObjectOutputStream(new FileOutputStream("E:/abcd.txt"));
		// Write to file the instance value
		o1.writeObject(s1); // returns void
		// Close file
		o1.close(); // returns void

		// Read from file
		ObjectInput o2 = new ObjectInputStream(new FileInputStream("E:/abcd.txt"));
		// case to serialized singleton class

		// Another instance to read and store value.
		SerializedSingleton1 s2 = (SerializedSingleton1) o2.readObject(); // returns object

		// Close file
		o2.close();

		// now the memory address or hash code is different.
		// two different objects created when we removed the protected method of
		// singleton.
		System.out.println("hash code value of first object is " + s1);
		System.out.println("hash code value of second object is " + s2);

	}

}
