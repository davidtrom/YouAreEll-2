package controllers;


import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TransactionController {
    private String rootURL = "http://zipcode.rocks:8085";
    CloseableHttpClient httpClient;

    public TransactionController() {
        this.httpClient = HttpClients.createDefault();
    }

    public String makeURLCall(String mainurl, String method, String jpayload) {
        //needs to call a post, put or get
        try {
            if (method.equals("GET")) {

                return get(mainurl);
            }
            else if (method.equals("POST")) {
                return post(mainurl, jpayload);
            }
            else if (method.equals("PUT")) {
                return put(mainurl, jpayload);
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }


        return "nada";
    }

    public String get(String mainurl) throws IOException {
        //Talking to the server over the internet
        HttpGet httpGet = new HttpGet(rootURL + mainurl);
        CloseableHttpResponse response1 = httpClient.execute(httpGet);
// The underlying HTTP connection is still held by the response object
// to allow the response content to be streamed directly from the network socket.
// In order to ensure correct deallocation of system resources
// the user MUST call CloseableHttpResponse#close() from a finally clause.
// Please note that if response content is not fully consumed the underlying
// connection cannot be safely re-used and will be shut down and discarded
// by the connection manager.
        try {
            System.out.println(response1.getStatusLine());
            HttpEntity entity1 = response1.getEntity();

            String result = new BufferedReader( new InputStreamReader(entity1.getContent()))
                    .lines().collect(Collectors.joining("\n"));
            // do something useful with the response body
            // and ensure it is fully consumed
            EntityUtils.consume(entity1);
            return result;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            response1.close();
        }
        return null;
    }

    public String post(String mainurl, String jpayload) throws IOException {
        //Talking to the server over the internet
        //Talking to the server over the internet
        // System.out.println(content);

        HttpPost httpPost = new HttpPost(rootURL + mainurl);
        httpPost.setEntity(new StringEntity(jpayload));
        CloseableHttpResponse response2 = httpClient.execute(httpPost);

        try {
            System.out.println(response2.getStatusLine());
            HttpEntity entity2 = response2.getEntity();
            String result = new BufferedReader(new InputStreamReader((entity2.getContent())))
                    .lines().collect(Collectors.joining("\n"));
            // do something useful with the response body
            // and ensure it is fully consumed
            EntityUtils.consume(entity2);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            response2.close();
        }
        return null;
    }

    public String put(String mainurl, String jpayload) throws IOException {
        //Talking to the server over the internet
              // System.out.println(content);

        HttpPut httpPut = new HttpPut(rootURL + mainurl);
        httpPut.setEntity(new StringEntity(jpayload));
        CloseableHttpResponse response2 = httpClient.execute(httpPut);

        try {
            System.out.println(response2.getStatusLine());
            HttpEntity entity2 = response2.getEntity();
            String result = new BufferedReader( new InputStreamReader(entity2.getContent()))
                    .lines().collect(Collectors.joining("\n"));
            // do something useful with the response body
            // and ensure it is fully consumed
            EntityUtils.consume(entity2);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            response2.close();
        }
        return null;
    }


}

