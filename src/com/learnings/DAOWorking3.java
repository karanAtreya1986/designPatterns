package com.learnings;

import java.util.ArrayList;
import java.util.List;

class Student3 {
	String name;
	int rollnumber;

	// Constructor
	public Student3(String name, int rollnumber) {
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

interface DaoInterface3 {
	List<Student3> getAllStudents();

	Student3 getStudent(int rollnumber);

	void updateStudent(Student3 st);

	void deleteStudent(Student3 st);
}

class DAOimplement3 implements DaoInterface3 {

//	List of student.
	List<Student3> students;

	// Constructor
	public DAOimplement3() {
//		Arraylist of student class
		students = new ArrayList<Student3>();
//		Create students
//		Add

		Student3 st1 = new Student3("A", 1);
		Student3 st2 = new Student3("b", 2);
		students.add(st1);
		students.add(st2);
	}

	@Override
	public List<Student3> getAllStudents() {
		return students;
	}

	@Override
	public Student3 getStudent(int rollnumber) {
		return students.get(rollnumber);
	}

	@Override
	public void updateStudent(Student3 st) {
		students.get(st.getRollnumber()).setName("tiger");
	}

	@Override
	public void deleteStudent(Student3 st) {
		int i1 = st.getRollnumber();
		System.out.println(i1);
		Student3 s1 = students.remove(i1);
		System.out.println(s1);
	}

}

public class DAOWorking3 {

	public static void main(String[] args) {

		DaoInterface3 d1 = new DAOimplement3();

		// when we give invalid roll number we get index out of bounds exception.
		// since only two values are there.
		Student3 rollNumberIsZero = d1.getStudent(98);

		int i1 = rollNumberIsZero.getRollnumber();
		System.out.println(i1);

		String s1 = rollNumberIsZero.getName();
		System.out.println(s1);

	}

}
