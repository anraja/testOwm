package stepdefs;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.lang3.StringUtils;
import utils.SharedObject;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created by anra1 on 18/01/18.
 */
public class CommonStepDefinitions {
    private Response response;
    private ValidatableResponse json;
    private RequestSpecification request;
    public static final String API_KEY = "da758bbcb85931e3ec95e88ced90b145";
    public static final String ENDPOINT_OPENWEATHER = "http://api.openweathermap.org/data/2.5/weather";
    private SharedObject sharedObject;

    public CommonStepDefinitions(SharedObject sharedObject) {
        this.sharedObject = sharedObject;
    }
    @Then("the status code is (\\d+)")
    public void verify_status_code(int statusCode){
        json = sharedObject.getResponse().then().statusCode(statusCode);
    }

    @And("response includes the following$")
    public void response_equals(Map<String,String> responseFields){
        for (Map.Entry<String, String> field : responseFields.entrySet()) {
            if(StringUtils.isNumeric(field.getValue())){
                json.body(field.getKey(), equalTo(Integer.parseInt(field.getValue())));
            }
            else{
                json.body(field.getKey(), equalTo(field.getValue()));
            }
        }
    }

}

