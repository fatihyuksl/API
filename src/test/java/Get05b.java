import base_urls.ReqresBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class Get05b extends ReqresBaseUrl {
    /*
        Given
          https://reqres.in/api/unknown/3
        When
            User send a GET request to the URL
        Then
            HTTP Status Code should be 200
        And
            Response content type is "application/json"
        And
            Response body should be like;(Soft Assertion)
        {
        "data": {
            "id": 3,
            "name": "true red",
            "year": 2002,
            "color": "#BF1932",
            "pantone_value": "19-1664"
        },
        "support": {
            "url": "https://reqres.in/#support-heading",
            "text": "To keep ReqRes free, contributions towards server costs are appreciated!"
        }
}
      */
    // body ve jsonpath ile olabilir
    @Test
    public void get05b(){
        spec.pathParams("first","unknown","second",3);
        //Send The Request and Get The Response
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();
        //Do Assertion12
        SoftAssert softAssert = new SoftAssert();
        JsonPath jsonpath=response.jsonPath();

        softAssert.assertEquals(response.getStatusCode(),200);
        softAssert.assertEquals(response.contentType(),"application/json; charset=utf-8");
        softAssert.assertEquals(jsonpath.getInt("data.id"),3,"İd Değeri doğru degil");
        softAssert.assertEquals(jsonpath.getString("data.name"),"true red","name değeri doğru değil");
        softAssert.assertEquals(jsonpath.getString("data.year"),"2002","year değeri doğru değil");
        softAssert.assertEquals(jsonpath.getString("data.color"),"#BF1932","color değeri doğru değil");
        softAssert.assertEquals(jsonpath.getString("support.url"),"https://reqres.in/#support-heading", "url degeri dogru degil");
        softAssert.assertEquals(jsonpath.getString("support.text"),"To keep ReqRes free, contributions towards server costs are appreciated!", "text degeri dogru degil");
        softAssert.assertAll();

    }
}
