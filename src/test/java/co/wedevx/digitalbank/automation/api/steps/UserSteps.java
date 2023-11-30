package co.wedevx.digitalbank.automation.api.steps;

import static co.wedevx.digitalbank.automation.api.utils.ObjectMapperUtils.objectMapper;
import static io.restassured.RestAssured.given;

import co.wedevx.digitalbank.automation.api.models.User;
import co.wedevx.digitalbank.automation.api.utils.ObjectMapperUtils;
import co.wedevx.digitalbank.automation.api.utils.RestHttpRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import java.util.List;

public class UserSteps {

  @Given("the following user is in the db")
  public void the_following_user_is_in_the_db(List<User> users) throws JsonProcessingException {
//    RestAssured.baseURI = "http://alaa2.mydevx.com/bank/api/v1";
//
//    Response authRequestResponse = given()
//        .queryParam("username", "admin@demo.io")
//        .queryParam("password", "Demo123!")
//        .when()
//        .post("/auth");
//
//    JsonPath authResponseJsonPath = authRequestResponse.jsonPath();
//
//    String authToken = authResponseJsonPath.getString("authToken");
//
//    //convert the POJO of users into a single user json string
//    ObjectMapper objectMapper = new ObjectMapper();
//    String createUserBodyPayLoad = objectMapper.writeValueAsString(users.get(0));
//    System.out.println(createUserBodyPayLoad);
//
//    //to send a create user request
//    Response createUserRequestResponse = given()
//        .header("Authorization", "Bearer " + authToken)
//        .accept(ContentType.JSON)
//        .contentType(ContentType.JSON)
//        .body(createUserBodyPayLoad)
//        .when()
//        .post("user");
//
//    createUserRequestResponse.prettyPrint();

    String createUserBodyPayLoad = objectMapper.writeValueAsString(users.get(0));
    Response response= RestHttpRequest.requestSpecification
        .body(createUserBodyPayLoad)
        .when()
        .post("user");
    response.prettyPrint();
  }

}


//baseURI -> take from config
//generate auth token only once per the whole test suite run
//apply generated auth token to all requests
//move objectMapper to utils class to make sure we are creating the objectMapper object only once
