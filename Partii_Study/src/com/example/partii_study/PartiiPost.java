package com.example.partii_study;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import android.os.AsyncTask;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;


public class PartiiPost extends AsyncTask<String, Void, String>{

	@Override
	protected String doInBackground(String... params) {
		// TODO Auto-generated method stub
		String url = "https://partii.cc/SCI/post.php";
		HttpPost post = new HttpPost(url);
		List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
		nameValuePairs.add(new BasicNameValuePair("username", "Ray"));
		try {
			post.setEntity(new UrlEncodedFormEntity(nameValuePairs));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}
