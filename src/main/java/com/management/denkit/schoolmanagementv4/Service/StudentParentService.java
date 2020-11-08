package com.management.denkit.schoolmanagementv4.Service;

import com.management.denkit.schoolmanagementv4.entity.StudentParent;
import com.management.denkit.schoolmanagementv4.entity.StudentParentKey;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentParentService {

    void assignStudentToParent(Integer studentId, Integer parentId);

    List<StudentParent> findAllStudentParents();

    StudentParent findStudentParentById(StudentParentKey studentParentKey);

    List<StudentParent> findByStudentParentKeyStudent(Integer studentId);

    List<StudentParent> findByStudentParentKeyParent(Integer parentId);

    StudentParent saveStudentParent(StudentParent studentParent);

    void deleteStudentParent(StudentParent studentParent);
}
