package co.wedevx.digitalbank.automation.ui.steps;

import co.wedevx.digitalbank.automation.ui.utils.DBUtils;
import co.wedevx.digitalbank.automation.ui.utils.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.AfterAll;

import static co.wedevx.digitalbank.automation.ui.utils.Driver.getDriver;

public class Hooks {


  @BeforeAll()
  public static void establishConnectionToDB() {
    DBUtils.establishConnection();
  }

  @Before("not @Registration")
  public void the_user_is_on_the_dbank_homepage() {
    getDriver().get("http://alaa.mydevx.com/bank/login");
  }

  @After("not @NegativeRegistrationCases")
  public void afterEachScenario(Scenario scenario){
    Driver.takeScreenShot(scenario);
    Driver.closeDriver();
  }

  @AfterAll()
  public static void closeConnectionToDB(){
    DBUtils.closeConnection();
  }

}
