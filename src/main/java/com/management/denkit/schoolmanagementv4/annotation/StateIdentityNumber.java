package com.management.denkit.schoolmanagementv4.annotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = StateIdentityNumberValidator.class)
@Target( {ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface StateIdentityNumber {

    String message() default "Invalid state identity number.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
