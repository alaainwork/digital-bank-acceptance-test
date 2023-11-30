Feature: Create Account Test Scenarios

  @DB
  Scenario: Create a valid account
    Given The user with "steve@apple.com" is not in DB
    Given the following user is in the db
      | title | firstName | lastName | gender | dob        | ssn         | emailAddress    | password  | address         | locality | region | postalCode | country | homePhone  | mobilePhone | workPhone |
      | Mr.   | Steve     | Jobs     | M      | 03/20/1954 | 122-44-3122 | steve@apple.com | Test123$$ | 1 infinite loop | CA       | CA     | 4444312    | US      | 444-221233 |             |           |





  Scenario: Create an account with wrong Account Name

  Scenario: Create an account with wrong Account Type Code

  Scenario: Create an account with wrong opening Deposit

  Scenario: Create an account with wrong ownerTypeCode


    #
    # "address": "123 main st",
    #    "country": "US",
    #    "dob": "01/30/1999",
    #    "emailAddress": "steve@gmail.com",
    #    "firstName": "Steve",
    #    "gender": "M",
    #    "homePhone": "3120001234",
    #    "lastName": "Steve",
    #    "locality": "CA",
    #    "mobilePhone": "",
    #    "password": "Test123$$",
    #    "postalCode": "60001",
    #    "region": "Palo Alto",
    #    "ssn": "133-33-5555",
    #    "title": "Mr.",
    #    "workPhone": ""