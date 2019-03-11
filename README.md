# Spring Boot Starter Extensions

## How to use?

1. Clone spring-initializr-extensions

    ```bash
    git clone https://github.com/sivaprasadreddy/spring-initializr-extensions.git
    spring-initializr-extensions> ./mvnw clean install
    ```

2. Clone spring-io/start.spring.io

    `git clone https://github.com/spring-io/start.spring.io.git`

3. Add spring-initializr-extensions dependency

    ```xml
    <properties>
        ...
        <spring-initializr-extensions.version>0.0.1-SNAPSHOT</spring-initializr-extensions.version>
    </properties>
    
    <dependencies>
        <dependency>
            <groupId>com.sivalabs</groupId>
            <artifactId>spring-initializr-extensions</artifactId>
            <version>${spring-initializr-extensions.version}</version>
        </dependency>
        ...
        ...
    </dependencies>
    ```

4. Run start.spring.io as SpringBoot app

    `start.spring.io> mvn spring-boot:run`

5. Generate springboot app

The generated application should have:

* **Dockerfile**
* **Procfile**
* **Jenkinsfile**
