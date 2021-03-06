package android.tut.lazylist;



import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
//import android.tut.json.JSONParser;
import android.app.Activity;
import android.view.Menu;
import android.widget.GridView;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;


//import com.rogcg.gridviewexample.R;


public class LazyListview extends Activity {
	
	static InputStream is = null;
	static JSONObject jObj = null;
	static String json = "";
	private static String jsonurl = "http://sudan.besaba.com/ima.txt";
	//private static String jsonurl = "http://sudan.besaba.com/images.txt";
    LazyAdapter adapter;
    GridView gridView;
    String sublist[];
	String catg_name[]= {"Catg 1","Catg 2","Catg 3","Catg 4"};
	String catg_descp[]= {"Catg 1","Catg 2","Catg 3","Catg 4"};
	String hash_tag[];
	//Integer[] images;
	String names[];
	String urls[];
	String imageUrls[];
	private static final String TAG_IMAGES = "images";
	private static final String TAG_NAME = "name";
	private static final String TAG_url = "url";
	JSONArray images = null;
 
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lazy_listview);
        new GetData().execute(jsonurl);
        
        
        
     /*   String imageUrls[]={
                "http://i.dailymail.co.uk/i/pix/2014/05/16/article-0-1DD055BE00000578-235_634x630.jpg",
                "http://www.heshestats.com/wp-content/uploads/2014/01/Maria-Sharapova.jpg",
                "http://mosnarcommunications.com/wp-content/uploads/2015/06/Maria-Sharapova-MC-MosnarCommunications-Luxury-PR-Media.jpg",
                "http://idontdull.com/wp-content/uploads/2015/08/mariah-624-1370002500.jpg"};
        */
        //new MemoryCache().clear();
		//new FileCache(getApplicationContext()).clear();
        
        
        
    }
     
    @Override
    public void onDestroy()
    {
    	gridView.setAdapter(null);
        super.onDestroy();
    }
     

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.lazy_listview, menu);
		return true;
	}
	



private class GetData extends AsyncTask<String, Void, JSONObject> {

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

     

    }

    @Override
    protected JSONObject doInBackground(String...  params) {


         String urll = params[0];
    	// Making HTTP request
    	try {
    		// defaultHttpClient
    		DefaultHttpClient httpClient = new DefaultHttpClient();
    		HttpPost httpPost = new HttpPost(urll);

    		HttpResponse httpResponse = httpClient.execute(httpPost);
    		HttpEntity httpEntity = httpResponse.getEntity();
    		is = httpEntity.getContent();			

    	} catch (UnsupportedEncodingException e) {
    		e.printStackTrace();
    	} catch (ClientProtocolException e) {
    		e.printStackTrace();
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	
    	try {
    		BufferedReader reader = new BufferedReader(new InputStreamReader(
    				is, "iso-8859-1"), 8);
    		StringBuilder sb = new StringBuilder();
    		String line = null;
    		while ((line = reader.readLine()) != null) {
    			sb.append(line + "\n");
    		}
    		is.close();
    		json = sb.toString();
    	} catch (Exception e) {
    		Log.e("Buffer Error", "Error converting result " + e.toString());
    	}

    	// try parse the string to a JSON object
    	try {
    		jObj = new JSONObject(json);
    	} catch (JSONException e) {
    		Log.e("JSON Parser", "Error parsing data " + e.toString());
    	}

    	// return JSON String
    	return jObj;

    }
    

    @Override
    protected void onPostExecute(JSONObject result) 
    {
        super.onPostExecute(result);
        
      //  JSONParser jParser = new JSONParser();

		// getting JSON string from URL
		//JSONObject json = result;
        

		try {
			// Getting Array of Contacts
			images = result.getJSONArray(TAG_IMAGES);
			names= new String[images.length()];
			 urls= new String[images.length()];
			
			// looping through All Contacts
			for(int i = 0; i < images.length(); i++){
				
				
				 
				
				JSONObject c = images.getJSONObject(i);
				
				// Storing each json item in variable
			    
				String name = c.getString(TAG_NAME);
				names[i]= name;
				
				String url = c.getString(TAG_url);
				urls[i]= url;
				System.out.println("I am here url "+ url);
				
				// Phone number is agin JSON Object
			/*	JSONObject phone = c.getJSONObject(TAG_PHONE);
				String mobile = phone.getString(TAG_PHONE_MOBILE);
				String home = phone.getString(TAG_PHONE_HOME);
				String office = phone.getString(TAG_PHONE_OFFICE);*/
				
				// creating new HashMap
			//	HashMap<String, String> map = new HashMap<String, String>();
				
				// adding each child node to HashMap key => value
			
	//			map.put(TAG_NAME, name);
	//			map.put(TAG_url, url);
				

				// adding HashList to ArrayList
				
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
        
        gridView = (GridView)findViewById(R.id.gridview);
        adapter=new LazyAdapter(LazyListview.this, urls,names);
        gridView.setAdapter(adapter);

        

       
        }
  
}

}

