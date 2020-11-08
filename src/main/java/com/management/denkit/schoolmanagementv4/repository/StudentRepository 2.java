package com.management.denkit.schoolmanagementv4.repository;

import com.management.denkit.schoolmanagementv4.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findByClassroomRefIdOrderByFirstNameAscLastNameAsc(Integer classroomId);

    List<Student> findByOrderByFirstNameAscLastNameAsc();

    @Query(
            value = "select * frdsl;fmaom asmkldfjnasdf dkasfas dsalkf" , nativeQuery = true
    )
    List<Student> findByOrderByFirstNameAscLastNameAsc2();



}
