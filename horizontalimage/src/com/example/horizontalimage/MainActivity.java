package com.example.horizontalimage;

import android.support.v7.app.ActionBarActivity;

import java.util.concurrent.ExecutionException;

import com.bumptech.glide.Glide;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.TextView;

@SuppressLint("InflateParams")
public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		LinearLayout layout = (LinearLayout) findViewById(R.id.linear);
	   this.getApplicationContext();
		// for (int i = 0; i < 10; i++) {
	     //   ImageView  imageView = new ImageView(this);
		  LayoutInflater inflater = (LayoutInflater)this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		ImageView imageView = (ImageView) inflater.inflate(R.layout.singleimage, null);
        imageView.setId(1);
	     //   imageView.setPadding(25, 25, 25, 25);
	        
	        Display display = getWindowManager().getDefaultDisplay();
	        // ImageView iv = (LinearLayout) findViewById(R.id.left);
	         int width = display.getWidth()*60/100; // ((display.getWidth()*20)/100)
	         int height = display.getHeight()*30/100;// ((display.getHeight()*30)/100)
	         LinearLayout.LayoutParams parms = new LinearLayout.LayoutParams(width,height);
	         imageView.setLayoutParams(parms);
	         
	       //  RelativeLayout layout = (RelativeLayout) findViewById(R.layout.activity_main);
	         
	       
	      //   Glide.with(this.getApplicationContext()) .load("http://sudan.besaba.com/details/1.png") .into(imageView);
	     //  imageView.setImageBitmap(BitmapFactory.decodeResource(
	        //       getResources(), R.drawable.ic_launcher));
	         
	         try {
	        	 Bitmap theBitmap = Glide.
					        with(this).
					        load("http://sudan.besaba.com/details/1.png").
					        asBitmap().
					        into(100, 100). // Width and height
					        get();
				 imageView.setImageBitmap(theBitmap);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
	         
	       
	        
	      
	         
	       //  tiles[i] = (ImageView) inflater.inflate(R.layout.activity_main, null);
	       
	        layout.addView(imageView);
	   // }
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
