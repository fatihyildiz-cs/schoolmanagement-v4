package com.management.denkit.schoolmanagementv4.Service;

import com.management.denkit.schoolmanagementv4.entity.TimeSlot;
import com.management.denkit.schoolmanagementv4.entity.WeeklySchedule;
import com.management.denkit.schoolmanagementv4.model.WeeklyScheduleWithTimeSlotsModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface WeeklyScheduleService {

    List<WeeklySchedule> findAllWeeklySchedules();

    WeeklySchedule findWeeklyScheduleById(Integer id);

    WeeklyScheduleWithTimeSlotsModel findWeeklyScheduleWithTimeSlotsByClassId(Integer classId, String dayName);

    WeeklySchedule updateWeeklySchedule(Integer id, WeeklySchedule weeklySchedule);

    void deleteWeeklySchedule(WeeklySchedule weeklySchedule);

    WeeklySchedule createWeeklySchedule(WeeklySchedule weeklySchedule);

    TimeSlot assignTimeSlotToTeacher(Integer slotId, Integer teacherId);
}
