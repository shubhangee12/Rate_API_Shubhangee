

1.Refer RateAPITestCase.xlsx for Manual Test Cases.

2.for Automation Please Download project ZIP file

3.Open Project in intellij and add Plugin "Cucumber for Java"

4.Run Project using command : 

	mvn clean verify
	or run test runner file from location : src\test\java\com\companyname\projectname\testrunners\TestRunner.java

5.Check report at location : target/cucumber-reports/report.html

6.Please refer Feature File : src\test\resources\API

Scenarios Covered:

	1.Validation of Status Code of Response when Endpoint is Valid

	2.Validation of Status Code (Error) when Endpoint is InValid  (Negative Test)

	3.Validation of Response body when Endpoint is Valid

	4.Validation of Response body when Endpoint is Valid and queryParameter provided

	5. Validation Date for Rate API"API - To get past conversion rates" 

