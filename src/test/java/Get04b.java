import base_urls.RestfulBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Get04b extends RestfulBaseUrl {
    /*
   Given
       https://restful-booker.herokuapp.com/booking?firstname=Almedin&lastname=Alikadic
   When
       User send GET Request to the URL
   Then
       HTTP Status Code should be 200
   And
       Response format should be "application/json"
   And
       "email" is "janet.weaver@reqres.in",
   And
       "first_name" is "Janet"
   And
       "last_name" is "Weaver"
   And
       "text" is "To keep ReqRes free, contributions towards server costs are appreciated!"
*/
    @Test
    public void get04(){
        //Set the Url soru isreti sdnrası query parameter
        spec.pathParam("first","booking").queryParams("firstname","Almedin","lastname","Alikadic");
//Set The Expected Data parametre / dan sonraki diğerleri \? den sonraki query parametre dir

//Send The Request and Get The Response
        Response response = given().spec(spec).when().get("/{first}");
        response.prettyPrint();
//Do Assertion
        assertEquals(200, response.statusCode());
        assertTrue(response.asString().contains("bookingid"));

    }
}
