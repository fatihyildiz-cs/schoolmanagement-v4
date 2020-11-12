package com.management.denkit.schoolmanagementv4.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class StateIdentityNumberValidator implements ConstraintValidator<StateIdentityNumber, String> {

    @Override
    public void initialize(StateIdentityNumber constraintAnnotation) {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if(s.length() == 11){

            return true;
        }
        return false;
    }
}
