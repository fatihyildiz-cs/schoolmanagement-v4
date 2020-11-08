package com.management.denkit.schoolmanagementv4.repository;

import com.management.denkit.schoolmanagementv4.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Integer> {
}
