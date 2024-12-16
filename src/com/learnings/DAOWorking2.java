package com.learnings;

import java.util.ArrayList;
import java.util.List;

class Student2 {
	String name;
	int rollnumber;

	// Constructor
	public Student2(String name, int rollnumber) {
		super();
		this.name = name;
		this.rollnumber = rollnumber;
	}

	// Getter
	// Setter

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the rollnumber
	 */
	public int getRollnumber() {
		return rollnumber;
	}

	/**
	 * @param rollnumber the rollnumber to set
	 */
	public void setRollnumber(int rollnumber) {
		this.rollnumber = rollnumber;
	}
}

interface DaoInterface2 {
	List<Student2> getAllStudents();

	Student2 getStudent(int rollnumber);

	void updateStudent(Student2 st);

	void deleteStudent(Student2 st);
}

class DAOimplement2 implements DaoInterface2 {

//	List of student.
	List<Student2> students;

	// Constructor
	public DAOimplement2() {
//		Arraylist of student class
		students = new ArrayList<Student2>();
//		Create students
//		Add

		Student2 st1 = new Student2("A", 1);
		Student2 st2 = new Student2("b", 2);
		students.add(st1);
		students.add(st2);
	}

	@Override
	public List<Student2> getAllStudents() {
		return students;
	}

	@Override
	public Student2 getStudent(int rollnumber) {
		return students.get(rollnumber);
	}

	@Override
	public void updateStudent(Student2 st) {
		students.get(st.getRollnumber()).setName("tiger");
	}

	@Override
	public void deleteStudent(Student2 st) {
		int i1 = st.getRollnumber();
		System.out.println(i1);
		Student2 s1 = students.remove(i1);
		System.out.println(s1);
	}

}

public class DAOWorking2 {

	public static void main(String[] args) {

		DaoInterface2 d1 = new DAOimplement2();

		Student2 rollNumberIsZero = d1.getStudent(0);
		// we get memory address because student is normal class not collections.
		System.out.println(rollNumberIsZero);

		// we get memory address because student is normal class not collections.
		String rollNumberIsZeroToString = rollNumberIsZero.toString();
		System.out.println(rollNumberIsZeroToString);

		// this is how we print the values
		// we get student object
		// in student we have getter and setter
		// use the getter for roll number and get the value
		// we get the roll number of first student size zero represents first index.
		int rollNumberIsZeroInteger = rollNumberIsZero.getRollnumber();
		System.out.println(rollNumberIsZeroInteger);

		String rollNumberIsZeroString = rollNumberIsZero.getName();
		System.out.println(rollNumberIsZeroString);

	}

}
