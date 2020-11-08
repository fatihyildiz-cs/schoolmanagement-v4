package com.management.denkit.schoolmanagementv4.annotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = OneDigitUpperCaseCharValidator.class)
@Target( {ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface OneDigitUpperCaseChar {

    String message() default "Invalid branch code.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
