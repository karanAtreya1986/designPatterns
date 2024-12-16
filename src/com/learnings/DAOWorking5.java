package com.learnings;

import java.util.ArrayList;
import java.util.List;

class Student5 {
	String name;
	int rollnumber;

	// Constructor
	public Student5(String name, int rollnumber) {
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

interface DaoInterface5 {
	List<Student5> getAllStudents();

	Student5 getStudent(int rollnumber);

	void updateStudent(Student5 st);

	void deleteStudent(Student5 st);
}

class DAOimplement5 implements DaoInterface5 {

//	List of student.
	List<Student5> students;

	// Constructor
	public DAOimplement5() {
//		Arraylist of student class
		students = new ArrayList<Student5>();
//		Create students
//		Add

		Student5 st1 = new Student5("A", 1);
		Student5 st2 = new Student5("b", 2);
		students.add(st1);
		students.add(st2);
	}

	@Override
	public List<Student5> getAllStudents() {
		return students;
	}

	@Override
	public Student5 getStudent(int rollnumber) {
		return students.get(rollnumber);
	}

	@Override
	public void updateStudent(Student5 st) {
		// we are passing in the current name only in setname method.
		// setname wants string and getname() method returns string.
		students.get(st.getRollnumber()).setName(st.getName());
	}

	@Override
	public void deleteStudent(Student5 st) {
		int i1 = st.getRollnumber();
		System.out.println(i1);
		Student5 s1 = students.remove(i1);
		System.out.println(s1);
	}

}

public class DAOWorking5 {

	public static void main(String[] args) {

		DaoInterface5 d1 = new DAOimplement5();

		Student5 rollNumberIsZero = d1.getStudent(1);

		int i1 = rollNumberIsZero.getRollnumber();
		System.out.println(i1);

		String s1 = rollNumberIsZero.getName();
		System.out.println(s1);

	}

}
