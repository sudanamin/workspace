package com.example.sudan;




import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
//import android.tut.json.JSONParser;
import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
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

public class details extends Activity {
//import com.rogcg.gridviewexample.R;


//public class LazyListview extends Fragment {
	
	static InputStream is = null;
	static JSONObject jObj = null;
	static String json = "";
	private static String jsonurl = "http://sudan.besaba.com/detailjsontest.php?id=";
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
	private static final String TAG_IMAGES = "detailimages";

	JSONArray images = null;
 
    @Override
  //  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
   //     View v =inflater.inflate(R.layout.activity_lazy_listview,container,false);
    protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	
		setContentView(R.layout.products);
		//setContentView(R.layout.products);
       // gridView = (GridView)v.findViewById(R.id.gridview);
        gridView = (GridView)findViewById(R.id.gridview);
        
       
        Intent i = getIntent();
		String  pid = i.getStringExtra("product_id");
		int product_id = Integer.parseInt(pid);
		
		Log.e("product id is ", ""+product_id);
        
     
        GetData getdata = new GetData(gridView, adapter , this,TAG_IMAGES);
       // new GetData().execute(jsonurl);
        
        
       // getdata.execute(jsonurl);
        getdata.execute(jsonurl+""+product_id);
    
    //    return v;
        
    }
     
    @Override
    public void onDestroy()
    {
    	gridView.setAdapter(null);
        super.onDestroy();
    }
     
/*
@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.lazy_listview, menu);
		return true;
	}*/
	
}


