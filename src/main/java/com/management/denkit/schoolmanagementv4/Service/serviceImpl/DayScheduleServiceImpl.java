package com.management.denkit.schoolmanagementv4.Service.serviceImpl;

import com.management.denkit.schoolmanagementv4.Service.*;
import com.management.denkit.schoolmanagementv4.entity.DaySchedule;
import com.management.denkit.schoolmanagementv4.repository.DayScheduleRepository;
import com.management.denkit.schoolmanagementv4.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class DayScheduleServiceImpl implements DayScheduleService {

    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private StudentService studentService;
    @Autowired
    private ClassroomService classroomService;
    @Autowired
    private TeacherService teacherService;
    @Autowired
    private DayScheduleService dayScheduleService;
    @Autowired
    private DayScheduleRepository dayScheduleRepository;

    @Override
    public List<DaySchedule> findAllDaySchedules() {

        return dayScheduleRepository.findAll();
    }

    @Override
    public DaySchedule findDayScheduleById(Integer id) {

        return dayScheduleRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public DaySchedule updateDaySchedule(Integer id, DaySchedule DaySchedule) {

        DaySchedule actualDaySchedule = dayScheduleService.findDayScheduleById(id);

        actualDaySchedule.setDate(DaySchedule.getDate());
        actualDaySchedule.setClassroomRef(DaySchedule.getClassroomRef());
        actualDaySchedule.setRoomRef(DaySchedule.getRoomRef());
        actualDaySchedule.setTeacherRef1(DaySchedule.getTeacherRef1());
        actualDaySchedule.setTeacherRef2(DaySchedule.getTeacherRef2());
        actualDaySchedule.setTeacherRef3(DaySchedule.getTeacherRef3());
        actualDaySchedule.setTeacherRef4(DaySchedule.getTeacherRef4());
        actualDaySchedule.setTeacherRef5(DaySchedule.getTeacherRef5());
        actualDaySchedule.setTeacherRef6(DaySchedule.getTeacherRef6());

        return dayScheduleRepository.save(DaySchedule);
    }

    @Override
    public void deleteDaySchedule(DaySchedule DaySchedule) {

        dayScheduleRepository.delete(DaySchedule);
    }

    @Override
    public DaySchedule createDaySchedule(DaySchedule DaySchedule) {

        return dayScheduleRepository.save(DaySchedule);
    }
}
