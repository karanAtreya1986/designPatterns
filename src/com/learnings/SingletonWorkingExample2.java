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
import java.time.temporal.ValueRange;
import java.util.PrimitiveIterator.OfDouble;

//Marker interface – doesn’t force us to implement methods. Serializable is one example.

class SerializedSingleton2 implements Serializable {

	private static final long serialVersionUID = 1L;

	private SerializedSingleton2() {
	}

	private static class SingletonHelper {
		private static SerializedSingleton2 instance1 = new SerializedSingleton2();
	}

	public static SerializedSingleton2 getInstance() {
		return SingletonHelper.instance1;
	}

	protected Object readResolve() {
		return getInstance();
	}
}

public class SingletonWorkingExample2 {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		SerializedSingleton s1 = SerializedSingleton.getInstance();
		ObjectOutput o1 = new ObjectOutputStream(new FileOutputStream("E:/abcd.txt"));
		o1.writeObject(s1); // returns void
		o1.close(); // returns void

		ObjectInput o2 = new ObjectInputStream(new FileInputStream("E:/abcd.txt"));

		SerializedSingleton s2 = (SerializedSingleton) o2.readObject(); // returns object

		o2.close();

		// using hashcode to check if two objects are same or different.
		// here first object works, then closes, then second object comes so same.

		// Use hash code to print the values of the object.
		int instance1hashcode = s1.hashCode();
		int instance2hashcode = s2.hashCode();
		System.out.println("value of instance 1 object is ---- " + instance1hashcode);
		System.out.println("value of instance 2 object is ---- " + instance2hashcode);

	}

}
