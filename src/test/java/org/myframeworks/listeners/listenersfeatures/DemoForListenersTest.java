package org.myframeworks.listeners.listenersfeatures;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class DemoForListenersTest {

    @BeforeMethod
    public void setUp(Method method) {
        System.out.println("Setting up before each test method: " + method.getName());
        // Here you can initialize WebDriver or any other setup required for the tests
    }

    @AfterMethod
    public void tearDown(Method method) {
        System.out.println("Tearing down after each test method: " + method.getName());
        // Here you can quit WebDriver or perform any cleanup required after the tests
    }


    @Test
    public void testMethod1() {
        System.out.println("Executing testMethod1");
        // Simulating a failure
        assert false : "Intentional fail in testMethod1";
    }

    @Test
    public void testMethod2() {
        System.out.println("Executing testMethod2");
        // Simulating a success
        assert true : "Intentional success in testMethod2";
    }

    @Test
    public void testMethod3() {
        System.out.println("Executing testMethod3");
        // Simulating a failure
        assert false : "Intentional failure in testMethod3";

    }
}
