package org.myframeworks.listeners;

import org.myframeworks.utils.DataProviderUtils;
import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * AnnotationTransformer class implements IAnnotationTransformer to modify test annotations at runtime.
 * It sets a retry analyzer and a data provider for the test methods.
 * This allows for dynamic configuration of test methods without modifying the original test code.
 */
public class AnnotationTransformer implements IAnnotationTransformer {
    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        annotation.setRetryAnalyzer(RetryFailedMethods.class);
        annotation.setDataProvider("testData");
        annotation.setDataProviderClass(DataProviderUtils.class);
    }
}
