Rate API Automation Framework using Rest Assured and Cucumber


1.Refer RateAPITestCase.xlsx for Manual Test Cases.

2.for Automation Please Download project ZIP file

3.Open Project in intellij and add Plugin "Cucumber for Java"

4.Run Project using command : 

	mvn clean verify
	or run test runner file from location : src\test\java\com\companyname\projectname\testrunners\TestRunner.java
Note:
at end of execution below error will be shown as for some negative scenarioes incorrect data has been added in examples.
Please check the Cucumber report for detailed execution report.

Failed to execute goal org.apache.maven.plugins:maven-surefire-plugin:2.16:test (default-test) on project RestAssuredCucumber: There are test failures.


5.Check report at location : target/cucumber-reports/report.html

6.Please refer Feature File : src\test\resources\API

Scenarios Covered:

	1.Validation of Status Code of Response when Endpoint is Valid

	2.Validation of Status Code (Error) when Endpoint is InValid  (Negative Test)

	3.Validation of Response body when Endpoint is Valid

	4.Validation of Response body when Endpoint is Valid and queryParameter provided

	5. Validation Date for Rate API"API - To get past conversion rates" 
	//Rates are shown as per Timezone and date hence for today and also future date yesterday's Date shown,
	hence instead of getting current date added date in input for verification.
	
