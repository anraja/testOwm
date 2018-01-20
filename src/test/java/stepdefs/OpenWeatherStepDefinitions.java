package stepdefs;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.lang3.StringUtils;
import utils.SharedObject;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;
import static stepdefs.CommonStepDefinitions.API_KEY;
import static stepdefs.CommonStepDefinitions.ENDPOINT_OPENWEATHER;

/**
 * Created by anra1 on 18/01/18.
 */
public class OpenWeatherStepDefinitions {
    private RequestSpecification request;
    private Response response;
    private SharedObject sharedObject;

    public OpenWeatherStepDefinitions(SharedObject sharedObject) {
        this.sharedObject = sharedObject;
    }

    @Given("^a api key to retrieve data$")
    public void api_Key_is_set_to_retrieve_data() {
        request = given().queryParam("APPID", API_KEY);
    }

    @When("^a user retrieves the data by city id (\\d+)$")
    public void a_user_retrieves_the_data_by_city_id(int id) {
        response = request
                .queryParam("id" ,id)
                .when().get(ENDPOINT_OPENWEATHER);
        sharedObject.setResponse(response);
        System.out.println("response: " + response.prettyPrint());
    }

    @When("^a user retrieves the data by city id \"([^\"]*)\"$")
    public void a_user_retrieves_the_data_by_city_id(String id)  {
        response = request
                .queryParam("id" ,id)
                .when().get(ENDPOINT_OPENWEATHER);
        sharedObject.setResponse(response);
        System.out.println("response: " + response.prettyPrint());
    }

    @When("^a user retrieves the data by city name \"([^\"]*)\"$")
    public void a_user_retrieves_the_data_by_city_name(String city) {
        response = request
                .queryParam("q", city)
                .when().get(ENDPOINT_OPENWEATHER);
        sharedObject.setResponse(response);
        System.out.println("response: " + response.prettyPrint());
    }

    @When("^a user retrieves the data by city name (\\d+)$")
    public void a_user_retrieves_the_data_by_city_name(int city) {
        response = request
                .queryParam("q", city)
                .when().get(ENDPOINT_OPENWEATHER);
        sharedObject.setResponse(response);
        System.out.println("response: " + response.prettyPrint());
    }

    @When("^a user retrieves the data by cordinates latitude (\\d+) and longitude (\\d+)$")
    public void a_user_retrieves_the_data_by_cordinates_latitude_and_longitude(int latitude, int longitude) {
        response = request
                .queryParam("lat", latitude)
                .queryParam("lon", longitude)
                .when().get(ENDPOINT_OPENWEATHER);
        sharedObject.setResponse(response);
        System.out.println("response: " + response.prettyPrint());
    }

    @When("^a user retrieves the data by cordinates latitude \"([^\"]*)\" and longitude \"([^\"]*)\"$")
    public void a_user_retrieves_the_data_by_cordinates_latitude_and_longitude(String latitude, String longitude)  {
        response = request
                .queryParam("lat", latitude)
                .queryParam("lon", longitude)
                .when().get(ENDPOINT_OPENWEATHER);
        sharedObject.setResponse(response);
        System.out.println("response: " + response.prettyPrint());

    }

}
