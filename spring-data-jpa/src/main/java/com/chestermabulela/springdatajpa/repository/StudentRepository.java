package com.chestermabulela.springdatajpa.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.chestermabulela.springdatajpa.entity.Student;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    public List<Student> findByFirstName(String firstName);
    public  List<Student> findByFirstNameContaining(String name);

    public List<Student> findByLastNameNotNull();

    public List<Student> findByGuardianName(String guardianName);

    //public Student FindStudentByFirstNameAndLastName(String firstName,String lastName);

    //JPQL
    @Query("SELECT s FROM Student s WHERE s.mobileNo = ?1")
    public Student getStudentByMobileNo(String mobileNo);


    //JPQL
    @Query("SELECT s.firstName FROM Student s WHERE s.mobileNo = ?1")
    public String getStudentFirstNameByMobileNo(String mobileNo);

    //NativeQuery
    @Query(
            value= "SELECT * FROM student_tbl s WHERE s.mobileNo = ?1 ",
             nativeQuery = true)
    public Student getStudentByMobileNative(String mobileNo);


    @Modifying
    @Transactional
    @Query(
            value = "update student_tbl set first_name=?1 where mobile_no=?2",
           nativeQuery = true)

      public int updateStudentNameByMobileNo(String firstName, String mobileNo);

}
