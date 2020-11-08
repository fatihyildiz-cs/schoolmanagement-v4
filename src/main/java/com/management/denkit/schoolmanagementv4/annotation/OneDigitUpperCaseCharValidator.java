package com.management.denkit.schoolmanagementv4.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class OneDigitUpperCaseCharValidator implements ConstraintValidator<OneDigitUpperCaseChar, String> {
    public void initialize(OneDigitUpperCaseChar constraint) {
    }

    public boolean isValid(String branchCode, ConstraintValidatorContext context) {

        if(branchCode.length() == 1 && Character.isLetter(branchCode.charAt(0)) && Character.isUpperCase(branchCode.charAt(0))){
            return true;
        }
        return false;
    }
}
