package org.myframeworks.annotations;

import org.myframeworks.enums.CategoryType;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target(METHOD)
public @interface FrameWorkAnnotation {

    String[] author();

    CategoryType[] category();

}
