package com.management.denkit.schoolmanagementv4.repository;

import com.management.denkit.schoolmanagementv4.entity.Parent;
import com.management.denkit.schoolmanagementv4.entity.Student;
import com.management.denkit.schoolmanagementv4.entity.StudentParent;
import com.management.denkit.schoolmanagementv4.entity.StudentParentKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentParentRepository extends JpaRepository<StudentParent, StudentParentKey> {

    List<StudentParent> findByStudentParentKeyStudent(Student student);
    List<StudentParent> findByStudentParentKeyParent(Parent parent);
//    Assignment findByAssignmentKeyTeacherClassroom(Teacher teacher, Classroom classroom);
}
