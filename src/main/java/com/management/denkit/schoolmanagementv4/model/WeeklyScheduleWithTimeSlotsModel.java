package com.management.denkit.schoolmanagementv4.model;

import com.management.denkit.schoolmanagementv4.entity.TimeSlot;
import com.management.denkit.schoolmanagementv4.entity.WeeklySchedule;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class WeeklyScheduleWithTimeSlotsModel {

    private WeeklySchedule weeklySchedule;

    private List<TimeSlot> timeSlotList = new ArrayList<>();
}
