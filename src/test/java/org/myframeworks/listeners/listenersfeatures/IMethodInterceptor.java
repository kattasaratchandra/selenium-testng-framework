package org.myframeworks.listeners.listenersfeatures;

import org.testng.IMethodInstance;
import org.testng.ITestContext;

import java.util.ArrayList;
import java.util.List;

public class IMethodInterceptor implements org.testng.IMethodInterceptor {
    @Override
    public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {
        // i want to run specific tests multiple times for ex: testmethod2 3 times
        List<IMethodInstance> newMethods = new ArrayList<>();
        for (IMethodInstance method : methods) {
            if(method.getMethod().getMethodName().equals("testMethod2")) {
                // Adding the method three times to run it three times
                method.getMethod().setInvocationCount(3);
                newMethods.add(method);
            }
        }

        return newMethods;

    }
}
