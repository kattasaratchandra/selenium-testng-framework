package org.myframeworks.listeners;

import org.myframeworks.constants.FrameworkConstants;
import org.myframeworks.utils.ReadExcelUtils;
import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Interceptor class that modifies the list of test methods before execution based on conditions
 * defined in an external Excel file.
 * This implementation assumes that the Excel file contains test case names and execution flags.
 */
public class MethodInterceptor implements IMethodInterceptor {

    @Override
    public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {
        // Null check for methods parameter
        if (methods == null) {
            throw new IllegalArgumentException("Methods list cannot be null");
        }

        List<IMethodInstance> result = new ArrayList<>();

        try {
            // Retrieve test data from Excel file
            List<HashMap<String, String>> list = ReadExcelUtils.getDataFromExcel(FrameworkConstants.getTestData(), "TestsRunner");
            if (list.isEmpty()) {
                throw new RuntimeException("Test data from Excel file is null");
            }

            for (IMethodInstance method : methods) {
                for (HashMap<String, String> executionList : list) {
                    if (executionList == null) {
                        continue; // Skip null entries in the list
                    }

                    String testCase = executionList.get("TestCase");
                    String execute = executionList.get("Execute");

                    // Filter methods based on test case name and "Execute" flag
                    if (testCase != null && execute != null && testCase.equalsIgnoreCase(method.getMethod().getMethodName()) && execute.equalsIgnoreCase("yes")) {
                        String description = executionList.get("Description");
                        if (description != null) {
                            method.getMethod().setDescription(description); // Update method description
                        }
                        result.add(method);
                    }
                }
            }
        } catch (IllegalArgumentException | IOException e) {
            throw new RuntimeException("Error reading test data from Excel file", e);
        }
        return result;
    }
}