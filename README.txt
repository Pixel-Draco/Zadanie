This program is named "Zadanie". Zadanie serves to divide a list of individuals into specific number of teams which is given by the user too. User can insert data to the left textarea in the following format, for example "Alex", 3. It is important to keep these format of inserting data because in the program is used method split("\"") to split data. Automatically program count first output from data which are already coded in the program. Output is printed in the console.

Input.class serves to take input data from the user. Input.class extends JFrame which serves as window to allow user to insert data in the specific textarea. There are three text area: left serves as input textarea, centre serves as error messages area, right text area serves as output messages area. When user wants to get results should use "Enter" button.

Individual.class serves as structure which contains information about specific individual. Class has two fields first_name type String for first name and rate type int for rate value.

Main.class contains a main method. In the Main class objects of Input and Output data type are initialized. Method output_results is for taking data from Input object and give them to Output object, count results and send results to console or textarea.

Output.class serves to get data from object type Input.class, counts these data and prepare results of the program. Teams rate standard deviation is rounded to second decimal place in the mode HAL_UP.

Project has been written in the Java programming language.

Program should handle situation to divide individuals to equal numbers of members in the team and handle situation when it is not possible.

Data from sample document are already coded and program automatically counts these data and print result in the console.

Outcome data should be printed as it was presented in the document.

Program should handle input and output data.

Project include unit tests. For unit tests was used framework JUnit. There are 3 tests classes: IndividualTest.class, InputTest.class, OutputTest.class . Developer can run tests for each TestClass.

Code for this project was versioned using Git.