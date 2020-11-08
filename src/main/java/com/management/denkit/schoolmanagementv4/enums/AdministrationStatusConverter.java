package com.management.denkit.schoolmanagementv4.enums;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class AdministrationStatusConverter implements AttributeConverter<AdministrationStatus,String> {


    @Override
    public String convertToDatabaseColumn(AdministrationStatus administrationStatus) {

        return administrationStatus.getStatus();
    }

    @Override
    public AdministrationStatus convertToEntityAttribute(String s) {

        for (AdministrationStatus status : AdministrationStatus.values()) {
            if (status.getStatus().equals(s)) {
                return status;
            }
        }
        throw new IllegalArgumentException(String.valueOf(s));
    }
}
