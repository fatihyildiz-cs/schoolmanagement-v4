package com.management.denkit.schoolmanagementv4.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class StateIdentityNumberValidator implements ConstraintValidator<StateIdentityNumber, Long> {

    @Override
    public boolean isValid(Long stateIdentityNumber, ConstraintValidatorContext constraintValidatorContext) {
        if(stateIdentityNumber.toString().length() == 11){
            return true;
        }
        return false;
    }
}
