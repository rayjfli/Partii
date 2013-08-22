package com.example.partii_study;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.ClientContext;
import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.apache.http.cookie.Cookie;

import android.os.AsyncTask;

public class Partii_Post extends AsyncTask<String, Void, String>{
	
	@Override
	protected String doInBackground(String... args) {
		// TODO Auto-generated method stub
	    // Create a new HttpClient and Post Header

			
		String result = null;
	    HttpClient httpclient = new DefaultHttpClient();
	    String url = null;
	    if (args[0] == "login")
	    	url = "https://partii.cc/SCI/accounts/login";
	    else
	    	url = "https://partii.cc/SCI/accounts/isloggedin";
	    	
	    HttpPost httppost = new HttpPost(url);

	    try {
	        // Add your data
			if (args[0] == "login"){
				
		        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
		        nameValuePairs.add(new BasicNameValuePair("username", "ray"));
		        nameValuePairs.add(new BasicNameValuePair("passwd", "1234qwer"));
		        httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
			}
			
	        // Execute HTTP Post Request
	        HttpResponse response = httpclient.execute(httppost);
	        if (response.getStatusLine().getStatusCode() == 200){
	        	
	        	CookieStore store = ((AbstractHttpClient) httpclient).getCookieStore();
	        	
//	        	HttpContext localContext = new BasicHttpContext();
//	        	localContext.setAttribute(ClientContext.COOKIE_STORE, store);
	        	
	        	List<Cookie> cookies = store.getCookies();
	        	if (cookies != null) {
	        		for (Cookie c : cookies) {
	        			result += "Name ["+c.getName()+"] - Val ["+c.getValue()+"] - Domain ["+c.getDomain()+"] - Path ["+c.getPath()+"]";
	        		}
	        	}



	        	//result = EntityUtils.toString(response.getEntity());
	        }
	        else{
	        	result = "Error Response: " + response.getStatusLine().toString();
	        }
	        
	    } catch (ClientProtocolException e) {
	        // TODO Auto-generated catch block
	    } catch (IOException e) {
	        // TODO Auto-generated catch block
	    }

		return result;
	} 

}
