package com.management.denkit.schoolmanagementv4.Service.serviceImpl;

import com.management.denkit.schoolmanagementv4.Service.SubjectService;
import com.management.denkit.schoolmanagementv4.entity.Subject;
import com.management.denkit.schoolmanagementv4.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired
    private SubjectService subjectService;

    @Override
    public List<Subject> findAllSubjects() {

        return subjectRepository.findAll();
    }

    @Override
    public Subject findSubjectById(Integer id) {

        return subjectRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Subject updateSubject(Integer id, Subject Subject) {

        Subject actualSubject = subjectService.findSubjectById(id);

        actualSubject.setName(Subject.getName());

        return subjectRepository.save(Subject);
    }

    @Override
    public void deleteSubject(Subject Subject) {

        subjectRepository.delete(Subject);
    }

    @Override
    public Subject createSubject(Subject Subject) {

        return subjectRepository.save(Subject);
    }
}
