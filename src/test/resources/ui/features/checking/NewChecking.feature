Feature: Creating a new checking account
@IGNORE
  Scenario: Create a standard individual checking account
    Given the user logged in as "james@gmail.com" "Password12"
    When the user creates a new checking account with the following data
      | checkingAccountType | accountOwnerShip | accountName           | initialDepositAmount |
      | Standard Checking   | Individual       | James Second Checking | 100000.0             |
    Then the user should see the green "Successfully created new Standard Checking account named James Second Checking" message
    And the user should see newly added Account Card
      | accountName           | accountType       | ownership  | accountNumber | interestRate | balance   |
      | James Second Checking | Standard Checking | Individual | 486131202     | 0.0%         | 100000.00 |
    And the user should see the following transactions
      | date             | category | description               | amount   | balance  |
      | 2023-09-07 16:12 | Income   | 845321905 (DPT) - Deposit | 100000.0 | 100000.0 |