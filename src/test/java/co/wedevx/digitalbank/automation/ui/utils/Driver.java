package co.wedevx.digitalbank.automation.ui.utils;

import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.DriverManagerType;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Driver {

  private static WebDriver driver;

  private Driver() {

  }

  public static WebDriver getDriver() {

    if (driver == null) {
      String browser = ConfigReader.getPropertiesValue("digitalbank.browser");

      switch (browser.toLowerCase()) {
        case "chrome":
          WebDriverManager.chromedriver().setup();
          driver = new ChromeDriver();
          break;
        case "safari":
          driver = new SafariDriver();
          break;
        case "ie":
          WebDriverManager.iedriver().setup();
          driver = new InternetExplorerDriver();
          break;
        case "headless":
          FirefoxDriverManager.getInstance(DriverManagerType.FIREFOX).setup();
          FirefoxOptions options = new FirefoxOptions();
          options.setHeadless(true);

          driver = new FirefoxDriver(options);
//          ChromeDriverManager.getInstance(DriverManagerType.CHROME).setup();
//          ChromeOptions options = new ChromeOptions();
//          options.addArguments("--window-size=1920,1080");
//          options.addArguments("disable-extensions");
//          options.setExperimentalOption("userAutomationExtension", false);
//          options.addArguments("--proxy-server='direct://'");
//          options.addArguments("--proxy-bypass-list=*");
//          options.addArguments("--start-maximized");
//          options.addArguments("--headless");
//
//          driver = new ChromeDriver(options);
          break;
        case "firefox":
        default:
          WebDriverManager.firefoxdriver().setup();
          driver = new FirefoxDriver();
          break;
      }
    }
    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    driver.manage().window().maximize();

    return driver;
  }

  public static void takeScreenShot(Scenario scenario){
    if(scenario.isFailed()){
      //take a screenshot
      final byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
      //adding the screenshot to the report
      scenario.attach(screenshot,"image/png","screenshot");
    }
  }

  public static void closeDriver() {
    if (driver != null) {
      driver.quit();
      driver = null;
    }
  }

}
