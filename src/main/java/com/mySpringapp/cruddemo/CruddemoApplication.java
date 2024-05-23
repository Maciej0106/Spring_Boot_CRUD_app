package com.mySpringapp.cruddemo;

import com.mySpringapp.cruddemo.dao.StudentDAO;
import com.mySpringapp.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){

		return runner -> {
			//createStudent(studentDAO);
			createMultipleStudents(studentDAO);
			//readStudent(studentDAO);
			//queryForStudents(studentDAO);
			//queryForStudentsByLastName(studentDAO);
			//updateStudent(studentDAO);
			//deleteStudent(studentDAO);
			//deleteAllStudents(studentDAO);
			
		};

	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting all students");
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("Deleted row count: " + numRowsDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 3;
		System.out.println("Deleting student id: " + studentId);
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {

		int studentId = 1;
		System.out.println("Getting student with id: " + studentId);
		Student myStudent = studentDAO.findById(studentId);

		System.out.println("Updating student ...");
		myStudent.setFirstName("Jacek");

		studentDAO.update(myStudent);

		System.out.println("Updated student: " + myStudent);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {

		List<Student> theStudents = studentDAO.findByLastName("Sowa");

		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {

		List<Student> theStudents = studentDAO.findAll();

		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}


	}

	private void readStudent(StudentDAO studentDAO) {


		System.out.println("Creating new student object ...");
		Student tempStudent = new Student("Jan", "Sobieski", "jansobieski@email.com");


		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent);


		int theId = tempStudent.getId();
		System.out.println("Saved student. Generated id: " + theId);


		System.out.println("Retrieving student with id: " + theId);
		Student myStudent = studentDAO.findById(theId);


		System.out.println("Found the student: " + myStudent);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {

		System.out.println("Creating 3 student object");
		Student tempStudent1 = new Student("Jan","Kowalski","jankowalski@email.com");
		Student tempStudent2 = new Student("Miachal","Nowak","michalnowak@email.com");
		Student tempStudent3 = new Student("Jakub","Sowa","jakubsowa@email.com");

		System.out.println("Saving the students");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);

	}

	private void createStudent(StudentDAO studentDAO){

		System.out.println("Creating new student object");
		Student tempStudent = new Student("Jan","Nowicki","jansobieski@email.com");

		System.out.println("Saving the new student");
		studentDAO.save(tempStudent);

	}

}
