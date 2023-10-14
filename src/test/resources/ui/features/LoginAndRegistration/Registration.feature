@Registration
Feature: Digital Bank Registration Page

  Background:
    Given The user with "jack@test.co" is not in DB
    Given User navigate to Digital Bank signup page
@Test
  Scenario: Positive Case. As a user, I want to successfully create Digital Bank Account
    When User create account with following fields
      | title | firstName | lastName | gender | dob        | ssn         | email        | password  | address    | locality | region | postalCode | country | homePhone  | mobilePhone | workPhone  | termsCheckMark |
      | Mr.   | Jack      | Test     | M      | 12/12/1998 | 123-33-2235 | jack@test.co | Tester123 | 12 Main st | City     | CA     | 99912      | us      | 2146591008 | 2136591208  | 1134444444 | true           |
    Then user should be displayed with the message "Success Registration Successful. Please Login."
    Then the following user info should be saved in the db
      | title | firstName | lastName | gender | dob        | ssn         | email        | password  | address    | locality | region | postalCode | country | homePhone  | mobilePhone | workPhone  | accountNonExpired | accountNonLocked | credentialsNonExpired | enabled |
      | Mr.   | Jack      | Test     | M      | 12/12/1998 | 123-33-2235 | jack@test.co | Tester123 | 12 Main st | City     | CA     | 99912      | us      | 2146591008 | 2136591208  | 1134444444 | true              | true             | true                  | true    |

  @NegativeRegistrationCases
  Scenario Outline: Negative Test Case. As a Digital Bank Admin I want to make sure users can not register without providing all valid data
    When User create account with following fields
      | title   | firstName   | lastName   | gender   | dob   | ssn   | email   | password   | address   | locality   | region   | postalCode   | country   | homePhone   | mobilePhone   | workPhone   | termsCheckMark   | fieldWithError   | errorMessage   |
      | <title> | <firstName> | <lastName> | <gender> | <dob> | <ssn> | <email> | <password> | <address> | <locality> | <region> | <postalCode> | <country> | <homePhone> | <mobilePhone> | <workPhone> | <termsCheckMark> | <fieldWithError> | <errorMessage> |
    Then user should see the "<fieldWithError>" required field error message "<errorMessage>"

    Examples:
      | title | firstName | lastName | gender | dob | ssn | email | password | address | locality | region | postalCode | country | homePhone | mobilePhone | workPhone | termsCheckMark | fieldWithError | errorMessage                        |
      |       |           |          |        |     |     |       |          |         |          |        |            |         |           |             |           |                | title          | Please select an item in the list.  |
      | Mr.   |           |          |        |     |     |       |          |         |          |        |            |         |           |             |           |                | firstName      | Please fill out this field.         |
      | Mr.   | Jack      |          |        |     |     |       |          |         |          |        |            |         |           |             |           |                | lastName       | Please fill out this field.         |
      | Mr.   | Jack      | Spero    |        |     |     |       |          |         |          |        |            |         |           |             |           |                | gender         | Please select one of these options. |
#      | Mr.   | Jack      | Spero    | M      |            |        |        |           |            |          |        |            |         |            |             |           |                | dob            | Please fill out this field.                    |
#      | Mr.   | Jack      | Spero    | M      | 10/10/1999 |        |        |           |            |          |        |            |         |            |             |           |                | ssn            | Please fill out this field.                    |
#      | Mr.   | Jack      | Spero    | M      | 10/10/1999 | random |        |           |            |          |        |            |         |            |             |           |                | email          | Please fill out this field.                    |
#      | Mr.   | Jack      | Spero    | M      | 10/10/1999 | random | random |           |            |          |        |            |         |            |             |           |                | password       | Please fill out this field.                    |
#      | Mr.   | Jack      | Spero    | M      | 10/10/1999 | random | random | Tester123 |            |          |        |            |         |            |             |           |                | address        | Please fill out this field.                    |
#      | Mr.   | Jack      | Spero    | M      | 10/10/1999 | random | random | Tester123 | 12 Main st |          |        |            |         |            |             |           |                | locality       | Please fill out this field.                    |
#      | Mr.   | Jack      | Spero    | M      | 10/10/1999 | random | random | Tester123 | 12 Main st | City     |        |            |         |            |             |           |                | region         | Please fill out this field.                    |
#      | Mr.   | Jack      | Spero    | M      | 10/10/1999 | random | random | Tester123 | 12 Main st | City     | CA     |            |         |            |             |           |                | postalCode     | Please fill out this field.                    |
#      | Mr.   | Jack      | Spero    | M      | 10/10/1999 | random | random | Tester123 | 12 Main st | City     | CA     | 99912      |         |            |             |           |                | country        | Please fill out this field.                    |
#      | Mr.   | Jack      | Spero    | M      | 10/10/1999 | random | random | Tester123 | 12 Main st | City     | CA     | 99912      | us      |            |             |           |                | homePhone      | Please fill out this field.                    |
#      | Mr.   | Jack      | Spero    | M      | 10/10/1999 | random | random | Tester123 | 12 Main st | City     | CA     | 99912      | us      | 1231231234 |             |           |                | termsCheckMark | Please check this box if you want to proceed.  |
#      | Mr.   | Jack      | Spero    | M      | 10/10/1999 | random | random | Tester123 | 12 Main st | City     | CA     | 99912      | us      | 1231231234 |             |           | true           | termsCheckMark | Success Registration Successful. Please Login. |
