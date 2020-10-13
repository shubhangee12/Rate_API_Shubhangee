Feature: API Validation

  @TC01
  Scenario Outline: Validation of Status Code of Response when Endpoint is Valid
    Given User is hitting the API "<Endpoint>" with Method "<Method>"
    Then Verify Status code should be "<RCode>"

    Examples:
      |Endpoint|Method|RCode|
      |https://api.ratesapi.io/api/latest|GET|200|
      |https://api.ratesapi.io/api/2010-01-12|GET|200|
      |https://api.ratesapi.io/api/latest?symbols=USD,GBP|GET|200|
      |https://api.ratesapi.io/api/latest?base=USD       |GET|200|
      |https://api.ratesapi.io/api/latest?base=USD&symbols=GBP|GET|200|


  @TC02
  Scenario Outline: Validation of Status Code (Error) when Endpoint is InValid
    Given User is hitting the API "<Endpoint>" with Method "<Method>"
    Then Verify Status code should be "<RCode>"

    Examples:
      |Endpoint|Method|RCode|
      |https://api.ratesapi.io/api/latstcc|GET|400|
      |https://api.ratesapi.io/api=e/2010-01-12|GET|404|



  @TC03
  Scenario Outline: Validation of Response body when Endpoint is Valid
    Given User is hitting the API "<Endpoint>" with Method "<Method>"
    Then Verify Status code should be "<RCode>"
    Then Verify Response body should have "<param>" with Value "<value>"

    Examples:
      |Endpoint|Method|RCode|param|value|
      |https://api.ratesapi.io/api/latest|GET|200|base|EUR|
      |https://api.ratesapi.io/api/2010-01-12|GET|200|base|EUR|
      |https://api.ratesapi.io/api/latest?symbols=USD,GBP|GET|200|base|EUR|
      |https://api.ratesapi.io/api/latest?base=USD       |GET|200|base|USD|
      |https://api.ratesapi.io/api/latest?base=USD&symbols=GBP|GET|200|base|USD|

  @TC04
  Scenario Outline: Validation of Response body when Endpoint is Valid and queryParameter provided
    Given User is hitting the API "<Endpoint>" with Method "<Method>"
    When query Param "<Qparam>" with Value "<QValue>"
    Then Verify Status code should be "<RCode>"
    Then Verify Response body should have "<param>" with Value "<value>"
    Examples:
      |Endpoint|Method|RCode|param|value|Qparam|QValue|
      |https://api.ratesapi.io/api/latest|GET|200|base|EUR|symbols|USD|
      |https://api.ratesapi.io/api/latest|GET|200|base|USD|base|USD|
      |https://api.ratesapi.io/api/2010-01-12|GET|200|base|EUR|base|USD|

  @TC05
  Scenario Outline: Validation Date when Date Provided in endpoint is future Date
    Given User is hitting the API "<Endpoint>" with Method "<Method>"
    Then Verify Status code should be "<RCode>"
    Then verify date in response should be "<pdate>"
    Examples:
      |Endpoint|Method|RCode|pdate|
      |https://api.ratesapi.io/api/2020-10-09|GET|200|2020-10-09|
      |https://api.ratesapi.io/api/2020-06-04|GET|200|2020-06-04|
      |https://api.ratesapi.io/api/2020-12-12|GET|200|2020-10-12|
      |https://api.ratesapi.io/api/2020-12-12|GET|200|2020-10-13|