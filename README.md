# Selenium TestNG Framework

A robust framework designed for automated testing using Selenium and TestNG. This framework incorporates features like
data-driven testing, Maven integration, dynamic TestNG method interception, and comprehensive reporting and logging.

## Features

- **Excel-based Test Runner**: Configure test execution directly in an Excel file. Tests will only run if the "Execute"
  field is set to "Yes".
- **Data-driven Testing**: Easily configure test data using Excel files for parameterized test execution.
- **Maven Integration**: Seamless build and dependency management.
- **Dynamic TestNG Method Interception**: Modify TestNG methods dynamically before execution based on the Excel test
  runner.
- **Custom Utilities**: Utilities for reading property files and parsing Excel data.
- **Comprehensive Reporting**: Detailed reports and logs generated after test execution.
- **Dynamic Description Updates**: TestNG method descriptions can be updated dynamically based on values in the Excel
  file.
- **Custom TestNG Annotations**: Extend and enhance TestNG functionality with user-defined annotations
- **Screenshot Configuration via `config.properties`**: Automatically capture screenshots of test failures or other
  specified events as configured in `config.properties`.
- **Retry Failed Tests via `config.properties`**: Configure retry logic for failed tests using properties in the
  `config.properties` file. This ensures test robustness by automatically re-executing failed tests.
- **Data Provider and Retry Class Configuration with Annotation Transformer**: Use TestNG's `IAnnotationTransformer` to
  dynamically configure the `DataProvider` and retry logic for tests. This allows for flexible and efficient test
  execution based on runtime conditions.

## Setup Instructions

### Prerequisites

- Java (Version 8 or higher)
- Maven (Version 3.6 or higher)

### Installation Steps

1. Clone the repository:
   ```bash
   git clone https://github.com/kattasaratchandra/selenium-testng-framework.git
2. Navigate to the project directory:
   ```bash
   cd selenium-testng-framework
   ```
3. Install dependencies using Maven:
   ```bash
   mvn install
    ```
4. Run the tests:
   ```bash
   mvn clean test
    ```

## Reports

After running the tests, the reports will be generated in the `Extent-output` directory. Navigate there to view the test
execution results and logs.

## FAQs and Troubleshooting

### Common Issues

1. **Java Version Compatibility**:
   Ensure you are using Java 8 or higher.

2. **Dependency Issues**:
   Run `mvn clean install` to resolve dependency conflicts.

3. **TestNG Configuration Errors**:
   Verify the TestNG XML file for correct configurations.

### Troubleshooting Tips

- Check the logs in the `Extent-output` directory for detailed error information.

### Contributing

We welcome contributions! Please follow these steps:

1. Fork the repository.
2. Create a new branch for your feature or bug fix.
3. Submit a pull request with a detailed description of your changes.