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

class SerializedSingleton3 implements Serializable {

	private static final long serialVersionUID = 1L;

	private SerializedSingleton3() {
	}

	private static class SingletonHelper {
		private static SerializedSingleton3 instance1 = new SerializedSingleton3();
	}

	public static SerializedSingleton3 getInstance() {
		return SingletonHelper.instance1;
	}

}

public class CommentOutNewProtectedMethodAndSeeOutput2 {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		SerializedSingleton3 s1 = SerializedSingleton3.getInstance();
		ObjectOutput o1 = new ObjectOutputStream(new FileOutputStream("E:/abcd.txt"));
		o1.writeObject(s1); // returns void
		// Close file
		o1.close(); // returns void

		// Read from file
		ObjectInput o2 = new ObjectInputStream(new FileInputStream("E:/abcd.txt"));
		// case to serialized singleton class

		// Another instance to read and store value.
		SerializedSingleton3 s2 = (SerializedSingleton3) o2.readObject(); // returns object

		// Close file
		o2.close();

		// Use hash code to print the values of the object.
		int instance1value = s1.hashCode();
		int instance2value = s2.hashCode();

		// here hash code is different because we didnt use the protected method
		// which gives us single object
		// so no singleton is actually followed here because multiple objects created
		System.out.println("hash code value of first object is " + instance1value);
		System.out.println("hash code value of second object is " + instance2value);

	}

}
