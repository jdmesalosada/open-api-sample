
###  1. Run Open API

    Go to Gradle - open api tools - run openApiGenerate


###  2. Run tests:



### 3. Search and kill process
Search and kill process running on 8080 port:
For ID 1 it will return you a simple object:

    lsof -t -i tcp:8080 | xargs kill




java.lang.IllegalAccessError: class org.gradle.internal.compiler.java.ClassNameCollector (in unnamed module @0x18031153) cannot access class com.sun.tools.javac.code.Symbol$TypeSymbol (in module jdk.compiler) because module jdk.compiler does not export com.sun.tools.javac.code to unnamed module @0x18031153
