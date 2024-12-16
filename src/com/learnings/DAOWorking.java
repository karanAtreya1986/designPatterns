package com.learnings;

import java.util.ArrayList;
import java.util.List;
//Dao pattern-
//Databases or xml – used when dealing with them
//Segregate business functionality with background functionality. 
//Example get from database is background task, separate it from 
//normal business functionality.

//Three participants-
//Model/value – classes/objects which contain all the db field names.
//contains simple getter setter methods to get/set the data.
//Dao interface- standard methods to perform operation on model/value. Example crud.
//Dao concrete class – get the data from db or xml or any other storage.

//Student class – model class
class Student {
	String name;
	int rollnumber;

	// Constructor
	public Student(String name, int rollnumber) {
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

//Dao interface-
//Standard operations.
//Interface.
interface DaoInterface {
	// Get all students. Returns list.
	List<Student> getAllStudents();

	// Get student by roll number. Returns student.
	Student getStudent(int rollnumber);

	// Update student.
	void updateStudent(Student st);

	// Delete student.
	void deleteStudent(Student st);
}

//Dao implementation-
//Class implement interface.

class DAOimplement implements DaoInterface {

//	List of student.
	List<Student> students;

	// Constructor
	public DAOimplement() {
//		Arraylist of student class
		students = new ArrayList<Student>();
//		Create students
//		Add

		Student st1 = new Student("A", 1);
		Student st2 = new Student("b", 2);
		students.add(st1);
		students.add(st2);
	}
//	Implementing all methods of interface

	// Return students.
	@Override
	public List<Student> getAllStudents() {
		return students;
	}

	// Get student by roll number.
	@Override
	public Student getStudent(int rollnumber) {
		return students.get(rollnumber);
	}

	// Get the roll number and set for update.
	@Override
	public void updateStudent(Student st1) {
		students.get(st1.getRollnumber()).setName("tiger");
	}

	// Get roll number and remove for removal.
	@Override
	public void deleteStudent(Student st1) {
		int i1 = st1.getRollnumber();
		System.out.println(i1);
		Student s1 = students.remove(i1);
		System.out.println(s1);
	}

}

public class DAOWorking {

	public static void main(String[] args) {

		// Interface object. run time polymorphism.
		DaoInterface d1 = new DAOimplement();

		// this is another way to write for each loop
		// on right side use the methods and get the value
		// because this is interface and we need to call interface methods.
		// getallstudents() return List<Student> but we open up the wrapper in foreach
		// so outer cover gone and it is only Student.
		// For each to iterate all students and print name and roll number

		for (Student string : d1.getAllStudents()) {
			String s2 = string.name;
			int roll1 = string.rollnumber;
			System.out.println(s2);
			System.out.println(roll1);
		}

	}

}
