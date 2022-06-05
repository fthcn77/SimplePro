package api;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ResponseDeserialization2 {


    @Test
    public void illinoisCovidTest() throws URISyntaxException, IOException {
        HttpClient httpClient = HttpClientBuilder.create().build();
        //https://corona.lmao.ninja/v2/states/Illinois
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https");
        uriBuilder.setHost("corona.lmao.ninja");
        uriBuilder.setPath("v2/states/Illinois");

        HttpGet httpGet = new HttpGet(uriBuilder.build());
        //let server know that we expect response body in JSON format
        httpGet.setHeader("Accept", "application/json");

        HttpResponse response = httpClient.execute(httpGet);

        Assert.assertEquals(HttpStatus.SC_OK, response.getStatusLine().getStatusCode());

        ObjectMapper objectMapper = new ObjectMapper();

        //actual deserialization:
        //parsing response body to java Map<String, Object>
        Map<String, Object> parsedResponse = objectMapper.readValue(response.getEntity().getContent(),
                new TypeReference<Map<String, Object>>() {
                });

        Assert.assertEquals("Illinois", parsedResponse.get("state"));
        Assert.assertTrue(12671821 == (int) parsedResponse.get("population"));


    }


    @Test
    public void swTest() throws URISyntaxException, IOException {


        HttpClient client = HttpClientBuilder.create().build();

        //http://swapi.dev/api/people
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("http");
        uriBuilder.setHost("swapi.dev");
        uriBuilder.setPath("api/people");

        HttpGet httpGet = new HttpGet(uriBuilder.build());
        httpGet.setHeader("Accept", "application/json");

        HttpResponse response = client.execute(httpGet);

        Assert.assertEquals(HttpStatus.SC_OK, response.getStatusLine().getStatusCode());


        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> parsedResponse = objectMapper.readValue(response.getEntity().getContent(),
                new TypeReference<Map<String, Object>>() {
                });


        List<Map<String, Object>> resultsList = (List<Map<String, Object>>) parsedResponse.get("results");

        System.out.println(resultsList);

        Map<String, Object> map0 = resultsList.get(0);
        Assert.assertEquals("Luke Skywalker", map0.get("name"));
        /**
         *  {
         *             "name": "Luke Skywalker",
         *             "height": "172",
         *             "mass": "77",
         *             "hair_color": "blond",
         *             "skin_color": "fair",
         *             "eye_color": "blue",
         *             "birth_year": "19BBY",
         *             "gender": "male",
         *             "homeworld": "http://swapi.dev/api/planets/1/",
         *       }
         */


    }


}
