# Liberis Automation
### Technology Used : Selenium WebDriver with Java, Cucumber (Gherkin)
### Framework : BDD

# Pre requisites (OS-Windows)
1. Download and install apache-maven-3.8.4
   1. set the path in to System variables 
       Ex. Variable name: MAVEN_HOME
           Variable value: C:\Users\prasa\Desktop\apache-maven-3.8.4\bin 
   2. in the path->Edit copy and pest the above Variable value
2. Restart the system/machine

# How to execute Liberis framework and generate test report
1. get the Project Git URL from concern person and clone the project in to your system/machine
2. open the project in IDE (IntelliJ) 
3. open the Terminal inside the IDE
4. give command as (without double quotes) "mvn clean verify"

# How to check test report
1. Check execution of test and BUILD SUCCESS message in IntelliJ Terminal
2. Go to and Right click target-> cucumber-report-html -> cucumber-html-reports -> js -> file-src-test-java-Features-getADemo-feature.html
3. Open in -> Browser