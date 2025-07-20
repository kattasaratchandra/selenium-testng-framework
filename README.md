# Selenium TestNG Framework

A robust framework designed for automated testing using Selenium and TestNG. This framework incorporates features like
data-driven testing, Maven integration, dynamic TestNG method interception, and comprehensive reporting and logging.

## Features

### Centralized WebDriver Management

- Abstracted WebDriver setup and teardown in the `BaseTest` class using TestNG annotations.
- Thread-safe WebDriver management with `DriverManager` leveraging `ThreadLocal<WebDriver>` for parallel test execution.

### Dynamic Execution Modes

- Configurable `runmode` in `config.properties` to switch between **local execution** and **remote execution** using
  Dockerized Selenium Grid.

### Dockerized Selenium Grid Integration

- Enabled parallel test execution across multiple browsers and versions using Docker Compose.
- YAML-based configuration for flexible browser and capability management.

### Data Providers

- Supports multiple data sources for TestNG tests:
    - **Excel-based data**: Tabular test data in array or map format for external test input.
    - **JSON-based data**: Structured data management for tests.
    - **Properties file-based data**: Key-value-driven configuration tests.
    - **Hardcoded method-specific data**: Custom data per test method.

### Retry and Annotation Transformers

- Automatic retries for failed tests using `IRetryAnalyzer`.
- Runtime annotation modifications via `IAnnotationTransformer` for dynamic test configurations.

### Extent Reports

- Dynamic report file names based on current date and time.
- Embedded screenshots using Base64 encoding for improved visualization.
- Logs exceptions and stack traces for failed tests with fine-grained control over screenshot inclusion.

### Custom Annotations

- Introduced `@Category` and `@Author` annotations for better test categorization and traceability.

### Exception Handling

- Clear and actionable runtime exceptions for robust debugging of file errors and runtime failures.

### IMethodInterceptor

- Dynamic control over test execution order, filtering, and repetition.

### Driver Factory

- Simplified browser management with `DriverFactory` supporting local and remote (Dockerized Selenium Grid) run modes.

## Setup Instructions

### Prerequisites

- Java (Version 8 or higher)
- Maven (Version 3.6 or higher)
- Docker (Version 20.10 or higher)

### Installation Steps

1. Clone the repository:
   ```bash
   git clone https://github.com/kattasaratchandra/selenium-testng-framework.git
   ```
2. Navigate to the project directory:
   ```bash
   cd selenium-testng-framework
   ```
3. Install dependencies using Maven:
   ```bash
   mvn install
    ```
4. Dockerize Selenium Grid setup:
    1. Start the Selenium Grid using Docker Compose:
       ```bash
        docker-compose up -d
        ```
    2. Verify the Docker containers are running:
       ```bash
       docker ps
       ```
    3. Verify the Selenium Grid is running by accessing the Grid Console:
       ````
       http://localhost:4444/wd/hub
       ````

### Running the tests

Update the `config.properties` file to set the `runmode`:

1. For remote execution (Dockerized Selenium Grid):
   ```
   runmode=remote
   ```
2. For local execution:
   ```
   runmode=local
   ```
3. Execute the tests using Maven:
   ```bash
   mvn clean test
   ```
    
### Reports

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

I welcome contributions! Please follow these steps:

1. Fork the repository.
2. Create a new branch for your feature or bug fix.
3. Submit a pull request with a detailed description of your changes.
