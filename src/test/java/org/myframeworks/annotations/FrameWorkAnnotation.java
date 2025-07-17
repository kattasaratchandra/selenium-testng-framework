package org.myframeworks.annotations;

import org.myframeworks.enums.CategoryType;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(METHOD)
public @interface FrameWorkAnnotation {
	
	String[] author();
	CategoryType[] category();

}
