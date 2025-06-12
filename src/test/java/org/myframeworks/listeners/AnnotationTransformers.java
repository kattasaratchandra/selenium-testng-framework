package org.myframeworks.listeners;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class AnnotationTransformers implements IAnnotationTransformer {
    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        if(testMethod.getName().equals("testMethod1")) {
            // Setting the invocation count to 3 for testMethod2
            annotation.setRetryAnalyzer(TestRetry.class);
            System.out.println("Transformed " + testMethod.getName() + " to run 2 times.");
        }
    }
}
