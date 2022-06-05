package api;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;

public class Petstore {

    /**
     * 1. Launch/instantiate POSTMAN/client
     * 2. Find/provide an endpoint/URL/URI
     * 3. Define a HTTP request(action)
     * 4. Send/execute a request
     * 5. Check the status code
     */
    @Test
    public void test1() throws URISyntaxException, IOException {
        //1. Launch/instantiate POSTMAN/client
        HttpClient client = HttpClientBuilder.create().build();

        //2. Find/provide an endpoint/URL/URI
        URIBuilder builder = new URIBuilder();
        //https://petstore.swagger.io/v2/pet/789
        builder.setScheme("https");
        builder.setHost("petstore.swagger.io");
        builder.setPath("v2/pet/789");

        //3. Define a HTTP request(action)
        HttpGet httpGet = new HttpGet(builder.build());

        //4. Send/execute a request
        HttpResponse response = client.execute(httpGet);

        Assert.assertFalse(response.getStatusLine().getStatusCode() == 404);
        Assert.assertEquals(200, response.getStatusLine().getStatusCode());



    }


}
