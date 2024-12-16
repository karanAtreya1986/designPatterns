package com.learnings;

import java.util.ArrayList;
import java.util.List;

class Student4 {
	String name;
	int rollnumber;

	// Constructor
	public Student4(String name, int rollnumber) {
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

interface DaoInterface4 {
	List<Student4> getAllStudents();

	Student4 getStudent(int rollnumber);

	void updateStudent(Student4 st);

	void deleteStudent(Student4 st);
}

class DAOimplement4 implements DaoInterface4 {

//	List of student.
	List<Student4> students;

	// Constructor
	public DAOimplement4() {
//		Arraylist of student class
		students = new ArrayList<Student4>();
//		Create students
//		Add

		Student4 st1 = new Student4("A", 1);
		Student4 st2 = new Student4("b", 2);
		students.add(st1);
		students.add(st2);
	}

	@Override
	public List<Student4> getAllStudents() {
		return students;
	}

	@Override
	public Student4 getStudent(int rollnumber) {
		return students.get(rollnumber);
	}

	@Override
	public void updateStudent(Student4 st) {
		students.get(st.getRollnumber()).setName("tiger");
	}

	@Override
	public void deleteStudent(Student4 st) {
		int i1 = st.getRollnumber();
		System.out.println(i1);
		Student4 s1 = students.remove(i1);
		System.out.println(s1);
	}

}

public class DAOWorking4 {

	public static void main(String[] args) {

		DaoInterface4 d1 = new DAOimplement4();

		// when we give invalid roll number we get index out of bounds exception.
		// since only two values are there.
		// we give negative index.
		Student4 rollNumberIsZero = d1.getStudent(-33498);

		int i1 = rollNumberIsZero.getRollnumber();
		System.out.println(i1);

		String s1 = rollNumberIsZero.getName();
		System.out.println(s1);

	}

}
