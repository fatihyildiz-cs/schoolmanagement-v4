package com.management.denkit.schoolmanagementv4.Service.serviceImpl;


import com.management.denkit.schoolmanagementv4.Service.ClassroomService;
import com.management.denkit.schoolmanagementv4.Service.StudentService;
import com.management.denkit.schoolmanagementv4.Service.TeacherService;
import com.management.denkit.schoolmanagementv4.Service.WeeklyScheduleService;
import com.management.denkit.schoolmanagementv4.entity.Teacher;
import com.management.denkit.schoolmanagementv4.entity.TimeSlot;
import com.management.denkit.schoolmanagementv4.entity.WeeklySchedule;
import com.management.denkit.schoolmanagementv4.model.WeeklyScheduleWithTimeSlotsModel;
import com.management.denkit.schoolmanagementv4.repository.TimeSlotRepository;
import com.management.denkit.schoolmanagementv4.repository.WeeklyScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class WeeklyScheduleServiceImpl implements WeeklyScheduleService {

    @Autowired
    private WeeklyScheduleRepository weeklyScheduleRepository;
    @Autowired
    private TimeSlotRepository timeSlotRepository;
    @Autowired
    private StudentService studentService;
    @Autowired
    private ClassroomService classroomService;
    @Autowired
    private WeeklyScheduleService weeklyScheduleService;
    @Autowired
    private TeacherService teacherService;

    @Override
    public List<WeeklySchedule> findAllWeeklySchedules() {

        return weeklyScheduleRepository.findAll();
    }

    @Override
    public WeeklySchedule findWeeklyScheduleById(Integer id) {

        return weeklyScheduleRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public WeeklySchedule updateWeeklySchedule(Integer id, WeeklySchedule weeklySchedule) {

        WeeklySchedule actualWeeklySchedule = weeklyScheduleService.findWeeklyScheduleById(id);

        actualWeeklySchedule.setNumberOfHours(weeklySchedule.getNumberOfHours());

        return weeklyScheduleRepository.save(weeklySchedule);
    }

    @Override
    public void deleteWeeklySchedule(WeeklySchedule weeklySchedule) {

        weeklyScheduleRepository.delete(weeklySchedule);
    }

    @Override
    public WeeklySchedule createWeeklySchedule(WeeklySchedule weeklySchedule) {

        return weeklyScheduleRepository.save(weeklySchedule);
    }

    @Override
    public TimeSlot assignTimeSlotToTeacher(Integer slotId, Integer teacherId) {

        Teacher teacher = teacherService.findTeacherById(teacherId);
        if(timeSlotRepository.countByTeacherRef(teacher) == 4) {
            throw new RuntimeException("A teacher can have a total of 4 time slots");
        }

        TimeSlot timeSlot = timeSlotRepository.findById(slotId).get();
        timeSlot.setTeacherRef(teacher);
        return timeSlotRepository.save(timeSlot);
    }



    @Override
    public WeeklyScheduleWithTimeSlotsModel findWeeklyScheduleWithTimeSlotsByClassId(Integer classId, String dayName) {

        WeeklyScheduleWithTimeSlotsModel model = new WeeklyScheduleWithTimeSlotsModel();
        WeeklySchedule weeklyScheduleRef = classroomService.findClassroomById(classId).getWeeklyScheduleRef();

        List<TimeSlot> timeSlotList;

        if(dayName.length() == 0){
            timeSlotList = timeSlotRepository.findByWeeklyScheduleRefId(weeklyScheduleRef.getId());
        }
        else{
            timeSlotList = timeSlotRepository.findByWeeklyScheduleRefIdAndDayName(weeklyScheduleRef.getId(), dayName);
        }
        System.out.println(dayName);
        model.setWeeklySchedule(weeklyScheduleRef);
        model.setTimeSlotList(timeSlotList);

        return model;
    }
}
