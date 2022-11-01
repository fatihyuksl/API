package get_requests;

import base_urls.GoRestBaseUrl;
import org.junit.Test;

public class Get10 extends GoRestBaseUrl {
    /*
   Given
       https://gorest.co.in/public/v1/users/2986
   When
       User send GET Request to the URL
   Then
       Status Code should be 200
   And
       Response body should be like
    {
  "meta": null,
    "data": {
        "id": 2986,
        "name": "Kanaka Jain",
        "email": "kanaka_jain@stark.net",
        "gender": "male",
        "status": "active"
            }
     }
*/
    @Test
    public void get10() {
        spec.pathParams("first","users","second",2986);


    }
}
