package com.management.denkit.schoolmanagementv4.enums;

public enum DayName {

    monday("Monday"),
    tuesday("Tuesday"),
    wednesday("Wednesday"),
    thursday("Thursday"),
    friday("Friday");

    private final String dayName;

    DayName(String dayName) {
        this.dayName = dayName;
    }

    public String getDayName() {
        return dayName;
    }
}
