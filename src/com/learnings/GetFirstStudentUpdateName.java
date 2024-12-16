package com.learnings;

import java.util.ArrayList;
import java.util.List;

class Student1 {
	String name;
	int rollnumber;

	public Student1(String name, int rollnumber) {
		super();
		this.name = name;
		this.rollnumber = rollnumber;
	}

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

interface DaoInterface1 {
	List<Student1> getAllStudents();

	Student1 getStudent(int rollnumber);

	void updateStudent(Student1 st);

	void deleteStudent(Student1 st);
}

class DAOimplement1 implements DaoInterface1 {

	List<Student1> students;

	public DAOimplement1() {
		students = new ArrayList<Student1>();
		Student1 st1 = new Student1("A", 1);
		Student1 st2 = new Student1("b", 2);
		students.add(st1);
		students.add(st2);
	}

	@Override
	public List<Student1> getAllStudents() {
		return students;
	}

	@Override
	public Student1 getStudent(int rollnumber) {
		return students.get(rollnumber);
	}

	@Override
	public void updateStudent(Student1 st1) {
		students.get(st1.getRollnumber()).setName("tiger");
	}

	@Override
	public void deleteStudent(Student1 st1) {
		int i1 = st1.getRollnumber();
		System.out.println(i1);
		Student1 s1 = students.remove(i1);
		System.out.println(s1);
	}

}

public class GetFirstStudentUpdateName {

	public static void main(String[] args) {

		DaoInterface1 d1 = new DAOimplement1();

		//get first student details
		Student1 s1=d1.getAllStudents().get(0);
		//update name
		s1.setName("tiger");
		String s2=s1.getName();
		System.out.println("new name is " + s2);
		int i2=s1.getRollnumber();
		System.out.println("student roll number is " + i2);

	}

}
