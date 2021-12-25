package extensions;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import utilities.CommonOps;

import java.util.List;

public class ApiActions extends CommonOps {

    @Step("Get Data From Server")
    public static Response get(String paramValues) {
        response = request.get(paramValues);
        request = RestAssured.given();
        return response;
    }

    @Step("Extract Value From JSON Format")
    public static String extractValueFromJSON(Response response, String key) {
        jp = response.jsonPath();
        return jp.get(key).toString();
    }

    @Step("Extract List of Values From JSON Format")
    public static List<String> extractListOfValuesFromJSON(Response response, String key) {
        jp = response.jsonPath();
        return jp.getList(key);
    }

//
//    @Step("Post Data to Server")
//    public static void post(JSONObject params, String resource) {
//        request.header("Content-Type", "application/json");
//        request.body(params.toJSONString());
//        response = request.post(resource);
//        request = RestAssured.given();
//
//    }
//
//    @Step("Update Data in Server")
//    public static void put(JSONObject params, String resource) {
//        request.header("Content-Type", "application/json");
//        request.body(params.toJSONString());
//        response = request.put(resource);
//        request = RestAssured.given();
//    }
//
//    @Step("Delete Data from Server")
//    public static void delete(String id, String path) {
//        response = request.delete(path + id);
//        request = RestAssured.given();
//    }
}
