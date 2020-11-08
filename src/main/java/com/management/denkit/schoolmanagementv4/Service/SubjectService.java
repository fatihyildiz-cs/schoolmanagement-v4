package com.management.denkit.schoolmanagementv4.Service;

import com.management.denkit.schoolmanagementv4.entity.Subject;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SubjectService {

    List<Subject> findAllSubjects();

    Subject findSubjectById(Integer id);

    Subject updateSubject(Integer id, Subject Subject);

    void deleteSubject(Subject Subject);

    Subject createSubject(Subject Subject);
}
