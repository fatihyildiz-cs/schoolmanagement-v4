package com.management.denkit.schoolmanagementv4.enums;

public enum AdministrationStatus {

    PRESIDENT("President"),
    VICEPRESIDENT("Vice President"),
    REGULAR("Regular Teacher");

    private final String status;

    AdministrationStatus(String administrationStatus) {
        this.status = administrationStatus;
    }

    public String getStatus() {
        return status;
    }
}
