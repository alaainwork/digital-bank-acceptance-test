package co.wedevx.digitalbank.automation.ui.steps;

import co.wedevx.digitalbank.automation.ui.models.AccountCard;
import co.wedevx.digitalbank.automation.ui.models.BankTransaction;
import co.wedevx.digitalbank.automation.ui.models.NewCheckingAccountInfo;
import io.cucumber.java.DataTableType;
import java.util.Map;



public class DataTableTransformer {


  @DataTableType
  public AccountCard accountCardEntry(Map<String, String> entry){
    //accountName                  | accountType       | ownership  | accountNumber | interestRate | balance    |
    String accountName = entry.get("accountName");
    String accountType = entry.get("accountType");
    String ownership = entry.get("ownership");
    long accountNumber = Long.parseLong(entry.get("accountNumber"));
    String interestRate = entry.get("interestRate");
    double balance = Double.parseDouble(entry.get("balance"));
    return new AccountCard(accountName,accountType,ownership,accountNumber,interestRate,balance);
  }

  @DataTableType
  public BankTransaction transactionEntry(Map<String, String> entry){
    //| date             | category | description               | amount     | balance    |
    String date = entry.get("date");
    String category = entry.get("category");
    String description = entry.get("description");
    double amount = Double.parseDouble(entry.get("amount"));
    double balance = Double.parseDouble(entry.get("balance"));
    return new BankTransaction(date, category,description,amount,balance);
  }

  @DataTableType
  public NewCheckingAccountInfo newCheckingAccountInfoEntry(Map<String, String> entry){
    // | checkingAccountType | accountOwnerShip | accountName                  | initialDepositAmount |
    String checkingAccountType = entry.get("checkingAccountType");
    String accountOwnerShip = entry.get("accountOwnerShip");
    String accountName = entry.get("accountName");
    double initialDepositAmount = Double.parseDouble(entry.get("initialDepositAmount"));

    return new NewCheckingAccountInfo(checkingAccountType, accountOwnerShip,accountName,initialDepositAmount);
  }
}

