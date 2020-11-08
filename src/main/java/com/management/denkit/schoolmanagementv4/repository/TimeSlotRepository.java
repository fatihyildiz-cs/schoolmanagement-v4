package com.management.denkit.schoolmanagementv4.repository;

import com.management.denkit.schoolmanagementv4.entity.Teacher;
import com.management.denkit.schoolmanagementv4.entity.TimeSlot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TimeSlotRepository extends JpaRepository<TimeSlot, Integer> {

    List<TimeSlot> findByWeeklyScheduleRefId(Integer weeklyScheduleRefId);

    List<TimeSlot> findByWeeklyScheduleRefIdAndDayName(Integer weeklyScheduleRefId, String dayName);

    Integer countByTeacherRef(Teacher teacherRef);
}
