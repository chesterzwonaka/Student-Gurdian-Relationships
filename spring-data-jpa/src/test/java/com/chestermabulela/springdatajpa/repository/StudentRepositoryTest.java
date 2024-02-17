package com.chestermabulela.springdatajpa.repository;

import static org.junit.jupiter.api.Assertions.*;

import com.chestermabulela.springdatajpa.entity.Guardian;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.chestermabulela.springdatajpa.entity.Student;

import java.util.List;

@SpringBootTest
class StudentRepositoryTest {
	
	@Autowired
	private StudentRepository studentRepository;

	@Test
	public void saveStudent()
	{
		Student student= Student.builder()
				.firstName("chess")
				.lastName("mabs")
				.mobileNo("0737709276")
				//.guardianName("nancy kobs")
				//.guardianAddress("37 mystreet")
				//.guardianMobileNo("0723456789")
				.build();

		// Save the Student to the database using the repository
		studentRepository.save(student);

	}


	@Test
	public void saveStudentWithGuardian()
	{

		Guardian guardian= Guardian.builder().
				name("letty Jol").
				address("24 Muystreet").
				mobileNo("0725674321")

				.build();

		Student student=Student.builder().
				firstName("tom").
				lastName("jerry").
				mobileNo("0886542345").
				guardian(guardian)

				.build();

		studentRepository.save(student);


	}

	@Test

	public void  showAllStudents()
	{
		List<Student> students=
				studentRepository.findAll();
		System.out.println("student lis: " + students);

	}

	@Test
	public void findStudentByFirstName()
	{
		List<Student> students=
				studentRepository.findByFirstName("John");

		System.out.println("you are looking for:" + students);

	}

	@Test
	public void findStudentByFirstNameContaining()
	{
		List<Student> students=
				studentRepository.findByFirstNameContaining("ch");

		System.out.println("you are looking for:" + students);

	}

	@Test
	public void findStudentBasedOnGuardianName()
	{

       List<Student> students= studentRepository.findByGuardianName("Jane Doe");
		System.out.println("you are looking for:" + students);
	}

/*@Test
	public void findStudentByFirstNameAndLastName()
{
	Student students= studentRepository.FindStudentByFirstNameAndLastName(
			"chess","mabs");
	if (students != null) {
		System.out.println("You are looking for: " + students);
	} else {
		System.out.println("Student not found");
	}

}*/

	@Test
	public void getStudentByMobileNo() {

		Student student = studentRepository.getStudentByMobileNo("0737709276");
		System.out.println("the student is: " + student);}

@Test
	public void getStudentFirstNameByMobileNo()
{
	String firstName=studentRepository.getStudentFirstNameByMobileNo("0725674321");
	System.out.println("firstName is: 	" + firstName	);
}

	@Test
	public void getStudentByMobileNoNative() {
		String mobileNo = "0737709276";
		Student student = studentRepository.getStudentByMobileNo(mobileNo);

		if (student != null) {
			System.out.println("Student details: " + student);
		} else {
			System.out.println("Student not found for mobile number: " + mobileNo);
		}
	}
@Test
	public void updateStudentNameByMobileNoTest(){

		studentRepository.updateStudentNameByMobileNo("chester","0737709276");
}

}