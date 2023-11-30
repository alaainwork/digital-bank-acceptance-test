package co.wedevx.digitalbank.automation.api.utils;

import static io.restassured.RestAssured.given;

import co.wedevx.digitalbank.automation.ui.utils.ConfigReader;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestHttpRequest {

  public static RequestSpecification requestSpecification = RestAssured.given();

  //authToken is auto generated, no need to generate it again
  public final static String authToken;
  static {
    requestSpecification.baseUri(ConfigReader.getPropertiesValue("digitalbank.base.api.uri"));
    authToken = generateAuthToken();
    addHeaders();
  }

  private static String generateAuthToken(){
    Response authRequestResponse = requestSpecification
        .queryParam("username", ConfigReader.getPropertiesValue("digitalbank.api.admin.username"))
        .queryParam("password", ConfigReader.getPropertiesValue("digitalbank.api.admin.password"))
        .when()
        .post("/auth");

    JsonPath authResponseJsonPath = authRequestResponse.jsonPath();

    return authResponseJsonPath.getString("authToken");
  }

  private static void addHeaders(){
    requestSpecification.contentType(ContentType.JSON)
        .accept(ContentType.JSON)
        .header("Authorization", "Bearer " + authToken);
  }

}
