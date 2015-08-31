package android.tut.lazylist;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.widget.ListView;
import android.widget.Toast;

public class LazyListview extends Activity {
	ListView list;
    LazyAdapter adapter;
    
    String sublist[];
	String catg_name[]= {"Catg 1","Catg 2","Catg 3","Catg 4"};
	String catg_descp[]= {"Catg 1","Catg 2","Catg 3","Catg 4"};
	String hash_tag[];
	Integer[] images;
	String imageUrls[];
 
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lazy_listview);
        
        String imageUrls[]={
                "http://192.168.43.125/source/fail.png",
                "http://192.168.43.125/source/help.png",
                "http://192.168.43.125/source/offers.png",
                "http://192.168.43.125/source/problem.png"};
        
        //new MemoryCache().clear();
		//new FileCache(getApplicationContext()).clear();
        
        list=(ListView)findViewById(R.id.listView1);
        adapter=new LazyAdapter(this, imageUrls,catg_name,catg_descp);
        list.setAdapter(adapter);
    }
     
    @Override
    public void onDestroy()
    {
        list.setAdapter(null);
        super.onDestroy();
    }
     

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.lazy_listview, menu);
		return true;
	}
	

}
