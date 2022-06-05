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

public class ApiIntro {

    /**
     * 1. Launch/instantiate POSTMAN/client
     * 2. Find/provide an endpoint/URL/URI
     * 3. Define a HTTP request(action)
     * 4. Send/execute a request
     * 5. Check the status code
     */
    @Test
    public void getTest() throws URISyntaxException, IOException {
        //1. Launch client
        HttpClient client = HttpClientBuilder.create().build();
        //2. Find/provide/construct an endpoint/URL
        //https://corona.lmao.ninja/v2/countries/Italy:
        //https - protocol/scheme
        //corona.lmao.ninja - domain/host
        //v2/countries/Italy - path
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https");
        uriBuilder.setHost("corona.lmao.ninja");
        uriBuilder.setPath("v2/countries/Italy");

        //3. Define a HTTP request(action)
        HttpGet get = new HttpGet(uriBuilder.build());

        //4. Send/execute a request
        HttpResponse response = client.execute(get);

        //5. Check the status code
        Assert.assertEquals(200, response.getStatusLine().getStatusCode());
    }

    /**
     * 1. Launch/instantiate POSTMAN/client
     * 2. Find/provide an endpoint/URL/URI
     * 3. Define a HTTP request(action)
     * 4. Send/execute a request
     * 5. Check the status code
     */
    @Test
    public void getTest2() throws URISyntaxException, IOException {
        //1. Launch/instantiate POSTMAN/client
        HttpClient client = HttpClientBuilder.create().build();

        //2. Find/provide an endpoint/URL/URI
        URIBuilder uriBuilder = new URIBuilder();
        //https://corona.lmao.ninja/v2/states/Texas

        uriBuilder.setScheme("https");
        uriBuilder.setHost("corona.lmao.ninja");
        uriBuilder.setPath("v2/states/Texas");

        //3. Define a HTTP request(action)
        HttpGet get = new HttpGet(uriBuilder.build());

        //4. Send/execute a request
        HttpResponse response = client.execute(get);

        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println("Get request has a response status code " +
                statusCode);

        //5. Check the status code
        Assert.assertEquals(200, statusCode);


    }


}
