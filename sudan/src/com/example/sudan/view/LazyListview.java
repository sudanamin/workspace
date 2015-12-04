package com.example.sudan.view;



import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.sudan.R;
import com.example.sudan.adapters.LazyAdapter;
import com.example.sudan.util.GetData;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
//import android.tut.json.JSONParser;
import android.app.Activity;

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


//import com.rogcg.gridviewexample.R;


public class LazyListview extends Fragment {
	
	/*static InputStream is = null;
	static JSONObject jObj = null;
	static String json = "";*/
	private static String jsonurl = "http://sudan.besaba.com/brandsjson.txt";
	LazyAdapter adapter;
    GridView gridView;
  /*  String sublist[];
	String catg_name[]= {"Catg 1","Catg 2","Catg 3","Catg 4"};
	String catg_descp[]= {"Catg 1","Catg 2","Catg 3","Catg 4"};
	String hash_tag[];
	//Integer[] images;
	String names[];
	String urls[];
	String imageUrls[];*/

	JSONArray images = null;
 
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.activity_lazy_listview,container,false);
       
        getArguments().getInt("someInt", 0);
        gridView = (GridView)v.findViewById(R.id.gridview);
        String jsonName = "brands";
        
        GetData getdata = new GetData(gridView, adapter , getActivity(),jsonName);
       // new GetData().execute(jsonurl);
        getdata.execute(jsonurl);
            
        return v;
                      
    }
     
    @Override
    public void onDestroy()
    {
    	gridView.setAdapter(null);
        super.onDestroy();
    }
 
}

