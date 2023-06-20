package com.cydeo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD}) // we can put our annotation above method - method level
@Retention(RetentionPolicy.RUNTIME)
public @interface LoggingAnnotation {
}
