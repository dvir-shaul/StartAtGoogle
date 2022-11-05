package StartAtGoogle.week3.DesignPatterns.Structural;


import com.google.gson.Gson;
import org.apache.hc.client5.http.classic.methods.*;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.HttpHeaders;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.entity.StringEntity;

import java.io.IOException;
import java.net.URL;


public class facadeHTTP {

    private static final CloseableHttpClient httpClient = HttpClients.createDefault();

    public static Response get(String s) throws Exception {
        HttpGet request = new HttpGet(s);
        // add request headers
        request.addHeader("custom-key", "myDvir");
        request.addHeader(HttpHeaders.USER_AGENT, "DvirBot");
        try (CloseableHttpResponse response = httpClient.execute(request)) {
            HttpEntity entity = response.getEntity();
            return new Response(response.getCode(), EntityUtils.toString(entity));
        }

    }

    public static Response post(String s, String name, String job) {
        HttpPost httpPost = new HttpPost(s);
        Gson gson = new Gson();
        String json = gson.toJson(new BodyResponse(name, job));
        StringEntity ent = new StringEntity(json);
        httpPost.setEntity(ent);
        httpPost.setHeader("Accept", "application/json");
        httpPost.setHeader("Content-type", "application/json");
        try ( CloseableHttpResponse response = httpClient.execute(httpPost)) {
            HttpEntity entity1 = response.getEntity();
            return new Response(response.getCode(), EntityUtils.toString(entity1));
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static Response put(String s, String name, String job) {
        HttpPut httpPut = new HttpPut(s);
        Gson gson = new Gson();
        String json = gson.toJson(new BodyResponse(name, job));
        StringEntity ent = new StringEntity(json);
        httpPut.setEntity(ent);
        httpPut.setHeader("Accept", "application/json");
        httpPut.setHeader("Content-type", "application/json");
        try ( CloseableHttpResponse response = httpClient.execute(httpPut)) {
            HttpEntity entity1 = response.getEntity();
            return new Response(response.getCode(), EntityUtils.toString(entity1));
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static Response patch(String s, String name, String job) {
        HttpPatch httpPatch = new HttpPatch(s);
        Gson gson = new Gson();
        String json = gson.toJson(new BodyResponse(name, job));
        StringEntity entity = new StringEntity(json);
        httpPatch.setEntity(entity);
        httpPatch.setHeader("Accept", "application/json");
        httpPatch.setHeader("Content-type", "application/json");
        try ( CloseableHttpResponse response = httpClient.execute(httpPatch)) {
            HttpEntity ent = response.getEntity();
            return new Response(response.getCode(), EntityUtils.toString(ent));
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static Response delete(String s) {
        HttpDelete httpDelete = new HttpDelete(s);
        try ( CloseableHttpResponse response = httpClient.execute(httpDelete)) {
            return new Response(response.getCode());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}


