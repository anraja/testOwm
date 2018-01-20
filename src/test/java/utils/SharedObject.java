package utils;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.Data;

/**
 * Created by anra1 on 19/01/18.
 */
public @Data class SharedObject {
    private Response response;
    private RequestSpecification request;

    public void setResponse(Response response){
        this.response=response;
    }

    public Response getResponse(){
        return this.response;
    }
}