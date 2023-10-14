package co.wedevx.digitalbank.automation.ui.runners;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.ExcludeTags;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;


@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("ui/features")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "co.wedevx.digitalbank.automation.ui.steps")  //import this final constant as a key and make its value steps
@ExcludeTags("IGNORE")

public class UiRegressionRunner {

}
