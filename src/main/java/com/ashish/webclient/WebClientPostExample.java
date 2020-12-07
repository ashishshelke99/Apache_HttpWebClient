package com.ashish.webclient;
import java.io.IOException;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class WebClientPostExample {

	public static void main(String[] args)  {
		
		 try {
	            //String result = sendPOST("https://httpbin.org/post");
			 String result = sendPOST("http://localhost:8080/addProduct");
	            //http://localhost:8080/products
	            System.out.println(result);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		
	}
	
	private static String sendPOST(String url) throws IOException {

        String result = "";
        HttpPost post = new HttpPost(url);
        post.setHeader("Content-type", "application/json");

        StringBuilder json = new StringBuilder();
        json.append("{");
        json.append("\"id\":\"5\",");
        json.append("\"name\":\"bottle\",");
        json.append("\"quantity\":\"7\",");
        json.append("\"price\":\"1800\"");
        json.append("}");

        // send a JSON data
        post.setEntity(new StringEntity(json.toString()));

        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(post)) {

            result = EntityUtils.toString(response.getEntity());
        }

        return result;
    }

}
