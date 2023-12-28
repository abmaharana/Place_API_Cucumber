package stepdefinition;

import io.cucumber.java.en.*;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.Assert;
import resources.ApiResources;
import resources.TestDataBuild;
import resources.Utils;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class StepDefinition extends Utils {

    RequestSpecification requestSpecification;
    ResponseSpecification responseSpecification;
    Response response;
    TestDataBuild data = new TestDataBuild();
    static String place_id; //all tc in that run will refer to same variable. if not static then it will null for next tc.

//        RestAssured.baseURI = "https://rahulshettyacademy.com";
//        Response response = given().log().all().queryParam("key","qaclick123").body(addPlace)
//                .when().post("/maps/api/place/add/json")
//                .then().assertThat().statusCode(200).extract().response();
    @Given("add place payload with {string} {string} {string}")
    public void add_place_payload(String name, String language, String address) throws IOException {
        requestSpecification = given().spec(requestSpecification()).body(data.addPlacePayload(name,language,address));
    }
    @When("user calls {string} api with {string} http request")
    public void user_calls_api_with_post_http_request(String resource, String method) {
        //constructor will be called with valueof resource which you pass
        ApiResources resourcesApi = ApiResources.valueOf(resource);
        System.out.println(resourcesApi.getResource());

        responseSpecification = new ResponseSpecBuilder().expectContentType(ContentType.JSON).expectStatusCode(200).build();
        if (method.equalsIgnoreCase("post")) {
            response = requestSpecification.when().post(resourcesApi.getResource());
        }else if(method.equalsIgnoreCase("get")){
            response = requestSpecification.when().get(resourcesApi.getResource());
        }
    }
    @Then("the api call is success with status code {int}")
    public void the_api_call_is_success_with_status_code(Integer int1) {
        Assert.assertEquals(200,response.getStatusCode());
    }
    @Then("{string} in response body is {string}")
    public void in_response_body_is(String key, String value) {
        Assert.assertEquals(getJsonPath(response,key),value);
    }

    @Then("verify place_id created maps to {string} using {string}")
    public void verify_place_id_created_maps_to_using(String key, String resource) throws IOException {
        place_id = getJsonPath(response,"place_id");
        requestSpecification=given().spec(requestSpecification()).queryParam("place_id",place_id);
        user_calls_api_with_post_http_request(resource,"GET");
        String nameFetched = getJsonPath(response,"name");
        Assert.assertEquals(nameFetched,key);

    }

    @Given("delete place payload")
    public void delete_place_payload() throws IOException {
        requestSpecification=given().spec(requestSpecification()).body(data.deletePlacePayLoad(place_id));
    }


}
