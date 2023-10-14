package co.wedevx.digitalbank.automation.ui.pages;

import static co.wedevx.digitalbank.automation.ui.utils.Driver.getDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;

import co.wedevx.digitalbank.automation.ui.models.NewCheckingAccountInfo;
import co.wedevx.digitalbank.automation.ui.utils.ConfigReader;
import java.util.List;
import java.util.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class CreateCheckingPage extends BaseMenuPage{


  public CreateCheckingPage(WebDriver driver) {
    super(driver);
  }


  @FindBy(id = "Standard Checking")
  private WebElement standardCheckingAccountTypeRadioButton;
  @FindBy(id = "Interest Checking")
  private WebElement interestCheckingAccountTypeRadioButton;

  @FindBy(id = "Individual")
  private WebElement individualOwnerShipRadioButton;

  @FindBy(id = "Joint")
  private WebElement jointOwnerShipRadioButton;

  @FindBy(id = "name")
  private WebElement accountNameTxt;

  @FindBy(id = "openingBalance")
  private WebElement openingBalanceTxtBox;

  @FindBy(id = "newCheckingSubmit")
  private WebElement submitBtn;

  @FindBy(id = "new-account-conf-alert")
  private WebElement newAccountConfAlertDiv;


  public void createNewChecking(List<NewCheckingAccountInfo> checkingAccountInfoList){
    NewCheckingAccountInfo testDataForOneCheckingAccount = checkingAccountInfoList.get(0);
    //user clicks on checking button
    checkingMenu.click();

    //the user clicks on the new checking button
    newCheckingButton.click();

    assertEquals(ConfigReader.getPropertiesValue("digitalbank.createnewcheckingurl"), getDriver().getCurrentUrl(),
        "new Checking Button didnt take to the url" + ConfigReader.getPropertiesValue("digitalbank.createnewcheckingurl"));

    //the user select the account type

    if(testDataForOneCheckingAccount.getCheckingAccountType().equalsIgnoreCase("Standard Checking")){
      standardCheckingAccountTypeRadioButton.click();
    }else if(testDataForOneCheckingAccount.getCheckingAccountType().equalsIgnoreCase("Interest Checking")){
      interestCheckingAccountTypeRadioButton.click();
    }else {
      throw new NoSuchElementException("Invalid checking account type option provided. Only support Standard Checking and Interest Checking");
    }

    if(testDataForOneCheckingAccount.getAccountOwnerShip().equalsIgnoreCase("Individual")){
      individualOwnerShipRadioButton.click();
    }else if(testDataForOneCheckingAccount.getAccountOwnerShip().equalsIgnoreCase("Joint")){
      jointOwnerShipRadioButton.click();
    }else {
      throw new NoSuchElementException("Invalid ownership type option provided. Only support Individual Checking and Joint Checking");
    }

    //the user names the account
    accountNameTxt.sendKeys(testDataForOneCheckingAccount.getAccountName());

    //the user makes the initial deposit
    openingBalanceTxtBox.sendKeys(String.valueOf(testDataForOneCheckingAccount.getInitialDepositAmount()));

    //user clicks on the submit button
    submitBtn.click();
  }



}
