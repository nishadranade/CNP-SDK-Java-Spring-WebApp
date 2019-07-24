This is a sample web app made using Spring and Java to demonstrate the use of the CNP SDK for Java. 

To run the application, follow these steps-
  1. Clone the CNP SDK for Java repo, or just download the directory inside in named "sampled_webapp".
  
  2. cd into sample_webapp/complete
  
  3. Build the .jar using the command: ./gradlew build
  
  4. The .jar file will be created in complete/build/libs
  
  5. Execute it using: java -jar gs-handling-form-submission-0.1.0.jar 
  
The application is now hosted at http://localhost:8080/home

It can be hosted on another port using:

java -jar -Dserver.port=XXXX gs-handling-form-submission-0.1.0.jar

