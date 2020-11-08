package com.management.denkit.schoolmanagementv4.Service;

import com.management.denkit.schoolmanagementv4.entity.Parent;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ParentService {

    List<Parent> findAllParents();

    Parent findParentById(Integer id);

    Parent updateParent(Integer id, Parent Parent);

    void deleteParent(Parent Parent);

    Parent createParent(Parent Parent);
}
