
###  Pre-requisites
* Java 16.0.1
* Gradlew version: 7.3.2

###  1. Run Open API

    Go to Gradle - open api tools - run openApiGenerate

###  2. Start application

    ./gradlew test


###  3. Run tests:

    ./gradlew bootRun

### 4. Search and kill process
Search and kill process running on 8080 port:
For ID 1 it will return you a simple object:

    lsof -t -i tcp:8080 | xargs kill**


### Troubleshooting
In case you get this message:
java.lang.IllegalAccessError: class org.gradle.internal.compiler.java.ClassNameCollector (in unnamed module @0x18031153) cannot access class com.sun.tools.javac.code.Symbol$TypeSymbol (in module jdk.compiler) because module jdk.compiler does not export com.sun.tools.javac.code to unnamed module @0x18031153

try updating the gradlew version:
go to gradle folder, open the gradle-wrapper.properties and change the value of: distributionUrl
to: https\://services.gradle.org/distributions/gradle-7.3.2-bin.zip


