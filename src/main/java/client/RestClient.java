package client;

import org.apache.http.Header;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import java.io.IOException;
import java.util.HashMap;
import static org.apache.http.impl.client.HttpClients.createDefault;

public class RestClient {


    //1. GET Method
    public void get (String url) throws IOException {

        CloseableHttpClient httpClient = createDefault(); // It will create a http client
        HttpGet httpGet = new HttpGet(url); // http get request
        CloseableHttpResponse closeableHttpResponse = httpClient.execute(httpGet); // Hit the get url

        //a. Get Status code
        int statusCode = closeableHttpResponse.getStatusLine().getStatusCode(); // Get only status code from the entire response
        System.out.println("Status Code ---->" + statusCode);

        //b. JSON String
        String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8"); // Gives output as only pure string, Basically converts special chars to UTF-8 format string

        JSONObject responseJson = new JSONObject(responseString); // Convert response from String to JSON format and stored in the responseJson. Stored as in key and value pair
        System.out.println("Response JSON from API ---->" + responseJson);

        //c. All Headers
        Header[] headersArray = closeableHttpResponse.getAllHeaders(); // To get the all headers and store in headers array
        HashMap<String, String> allHeaders = new HashMap<String, String>(); // Saving all headers in hashmap, so it's easy to iterate
        for (Header header : headersArray){
            allHeaders.put(header.getName(), header.getValue());
        }
        System.out.println("Headers Array ---->" + allHeaders);

    }
}
