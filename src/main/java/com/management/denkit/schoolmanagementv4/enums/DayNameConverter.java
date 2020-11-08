package com.management.denkit.schoolmanagementv4.enums;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class DayNameConverter implements AttributeConverter<DayName,String> {


    @Override
    public String convertToDatabaseColumn(DayName dayName) {
        return null;
    }

    @Override
    public DayName convertToEntityAttribute(String s) {
        return null;
    }
}
