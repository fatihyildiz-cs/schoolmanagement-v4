package com.management.denkit.schoolmanagementv4.repository;

import com.management.denkit.schoolmanagementv4.entity.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassroomRepository extends JpaRepository<Classroom, Integer>, CrudRepository<Classroom,Integer>, JpaSpecificationExecutor<Classroom> {

    List<Classroom> findAllByOrderByYearAscBranchAsc();
}
