package eventgram.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import eventgram.model.Photo;

public class InstagramParser {

  private static String readAll(Reader rd) throws IOException {
    StringBuilder sb = new StringBuilder();
    int cp;
    while ((cp = rd.read()) != -1) {
      sb.append((char) cp);
    }
    return sb.toString();
  }

  public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
    InputStream is = new URL(url).openStream();
    try {
      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
      String jsonText = readAll(rd);
      JSONObject json = new JSONObject(jsonText);
      return json;
    } finally {
      is.close();
    }
  }

  public List<Photo> parser(String url) throws IOException, JSONException {
    List<Photo> photos = new ArrayList();
    
	JSONObject json = readJsonFromUrl(url);
    System.out.println(json.getJSONArray("data").length());
    
    int index;
    int length = json.getJSONArray("data").length();
    for(index = 0; index <= (length - 1); index++) {
    	
    	JSONArray data = json.getJSONArray("data");
    	JSONObject jsPhoto = data.getJSONObject(index);
    	
    	//Username
    	JSONObject jsUser = jsPhoto.getJSONObject("user");
    	
    	//Subtitle
    	JSONObject jsCaption = jsPhoto.getJSONObject("caption");
    	
    	//Thumbnail e Link
    	JSONObject jsImages = jsPhoto.getJSONObject("images");
    	JSONObject jsThumb = jsImages.getJSONObject("thumbnail");
    	JSONObject jsLink = jsImages.getJSONObject("standard_resolution");

    	
    	//if(jsPhoto.getString("type") == "image") {
    		Photo photo = new Photo();
    		System.out.println("- - - - - - - - - - -");
        	
    		photo.setOwnerUsername(jsUser.getString("username"));
        	System.out.println(jsUser.getString("username").toString());
        	
        	photo.setSubtitle(jsCaption.getString("text"));
        	System.out.println(jsCaption.getString("text").toString());
        	
        	photo.setThumbnail(jsThumb.getString("url"));
        	System.out.println(jsThumb.getString("url").toString());
        	
        	photo.setLink(jsLink.getString("url"));
        	System.out.println(jsLink.getString("url").toString());
        	
        	photos.add(photo);
    	//}
    }
    return photos;
  }
}