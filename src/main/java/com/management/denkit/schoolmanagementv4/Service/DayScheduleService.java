package com.management.denkit.schoolmanagementv4.Service;

import com.management.denkit.schoolmanagementv4.entity.DaySchedule;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DayScheduleService {

    List<DaySchedule> findAllDaySchedules();

    DaySchedule findDayScheduleById(Integer id);

    DaySchedule updateDaySchedule(Integer id, DaySchedule daySchedule);

    void deleteDaySchedule(DaySchedule daySchedule);

    DaySchedule createDaySchedule(DaySchedule daySchedule);
}
