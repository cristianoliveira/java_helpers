package main;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

public class WebHelper {
	
	private static final String USER_AGENT = "Mozilla/5.0";
	
	public static String sendPost(String url, List<Parameter> parameters) throws Exception {
		 
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
 
		//header
		con.setRequestMethod("POST");
		con.setRequestProperty("User-Agent", USER_AGENT);
		con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
 
		String urlParameters = "m=1"; // Só para setar o primeiro parametro com qualquer coisa, não vai ser usado.
		
		for (int i = 0; i < parameters.size(); i++) {
			urlParameters += "&"+parameters.get(i).key+"="+parameters.get(i).val;
		}
		
		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(urlParameters);
		wr.flush();
		wr.close();
 
		int responseCode = con.getResponseCode();
		System.out.println("Enviando 'POST' request para URL : " + url);
		System.out.println("Post parameters : " + urlParameters);
		System.out.println("Response Code : " + responseCode);
 
		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
 
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
 
		//print result
		return response.toString();
 
	}
	
	public static Parameter buildParameter(String key, String val)
	{
		return new Parameter(key, val);
	}
	
	public static class Parameter{
		
	   public String key;
	   public String val;
	   
	   public Parameter(String key, String val)
	   {
		   this.key = key;
		   this.val = val;
	   }
	   
	}
}
