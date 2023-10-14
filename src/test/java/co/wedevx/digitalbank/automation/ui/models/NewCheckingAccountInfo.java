package co.wedevx.digitalbank.automation.ui.models;

public class NewCheckingAccountInfo {
  // | checkingAccountType | accountOwnerShip | accountName                  | initialDepositAmount |

  private String checkingAccountType;
  private String accountOwnerShip;
  private String accountName;
  private double initialDepositAmount;

  public NewCheckingAccountInfo(String checkingAccountType, String accountOwnerShip,
      String accountName, double initialDepositAmount) {
    this.checkingAccountType = checkingAccountType;
    this.accountOwnerShip = accountOwnerShip;
    this.accountName = accountName;
    this.initialDepositAmount = initialDepositAmount;
  }

  public String getCheckingAccountType() {
    return checkingAccountType;
  }

  public void setCheckingAccountType(String checkingAccountType) {
    this.checkingAccountType = checkingAccountType;
  }

  public String getAccountOwnerShip() {
    return accountOwnerShip;
  }

  public void setAccountOwnerShip(String accountOwnerShip) {
    this.accountOwnerShip = accountOwnerShip;
  }

  public String getAccountName() {
    return accountName;
  }

  public void setAccountName(String accountName) {
    this.accountName = accountName;
  }

  public double getInitialDepositAmount() {
    return initialDepositAmount;
  }

  public void setInitialDepositAmount(double initialDepositAmount) {
    this.initialDepositAmount = initialDepositAmount;
  }
}

