package org.myframeworks.listeners;

import org.myframeworks.utils.DataProviderUtils;
import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class AnnotationTransformer implements IAnnotationTransformer {
    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
                annotation.setRetryAnalyzer(RetryFailedMethods.class);
                annotation.setDataProvider("testData");
                annotation.setDataProviderClass(DataProviderUtils.class);
    }
}
