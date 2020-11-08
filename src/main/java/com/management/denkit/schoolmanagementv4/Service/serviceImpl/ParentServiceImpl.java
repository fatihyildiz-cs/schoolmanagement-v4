package com.management.denkit.schoolmanagementv4.Service.serviceImpl;

import com.management.denkit.schoolmanagementv4.Service.ClassroomService;
import com.management.denkit.schoolmanagementv4.Service.ParentService;
import com.management.denkit.schoolmanagementv4.Service.StudentService;
import com.management.denkit.schoolmanagementv4.Service.TeacherService;
import com.management.denkit.schoolmanagementv4.entity.Parent;
import com.management.denkit.schoolmanagementv4.repository.ParentRepository;
import com.management.denkit.schoolmanagementv4.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class ParentServiceImpl implements ParentService {

    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private StudentService studentService;
    @Autowired
    private ClassroomService classroomService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private ParentService parentService;
    @Autowired
    private ParentRepository parentRepository;

    @Override
    public List<Parent> findAllParents() {

        return parentRepository.findAll();
    }

    @Override
    public Parent findParentById(Integer id) {

        return parentRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Parent updateParent(Integer id, Parent Parent) {

        Parent actualParent = parentService.findParentById(id);

        actualParent.setFirstName(Parent.getFirstName());
        actualParent.setLastName(Parent.getLastName());
        actualParent.setEmail(Parent.getEmail());
        actualParent.setPhoneNumber(Parent.getPhoneNumber());

        return parentRepository.save(Parent);
    }

    @Override
    public void deleteParent(Parent Parent) {

        parentRepository.delete(Parent);
    }

    @Override
    public Parent createParent(Parent Parent) {

        return parentRepository.save(Parent);
    }
}
