package com.example.sudan;


import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.Spanned;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

/**
 * Created by Edwin on 15/02/2015.
 */
@SuppressLint("NewApi")
@SuppressWarnings("deprecation")
public class MainActivity extends ActionBarActivity {

	// Declaring Your View and Variables

	Toolbar toolbar;
	ViewPager pager;
	ViewPagerAdapter adapter;
	SlidingTabLayout tabs;
	CharSequence Titles[] = { "Home ", " Events ", " Montana ", " Alhilal " };
	int Numboftabs = 4;

	//@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// Creating The Toolbar and setting it as the Toolbar for the activity

		toolbar = (Toolbar) findViewById(R.id.tool_bar);
		//getSupportActionBar().setDisplayShowHomeEnabled(true);
		//getSupportActionBar().setIcon(R.drawable.ic_action);
		//toolbar.setic();
		toolbar.setNavigationIcon(R.drawable.ic_launcher);
		TextView title = (TextView)findViewById(R.id.title);
		
		Typeface type = Typeface.createFromAsset(getAssets(),"Lato-Regular.ttf"); 
		Spanned text = Html.fromHtml(" <b>bold</b> and <i>italic</i> ");
		title.setTypeface(type);
		title.setText(text);
		toolbar.setTitle("amin");
		setSupportActionBar(toolbar);
		//toolbar.settext

		// Creating The ViewPagerAdapter and Passing Fragment Manager, Titles
		// fot the Tabs and Number Of Tabs.
		adapter = new ViewPagerAdapter(getSupportFragmentManager(), Titles,
				Numboftabs);

		// Assigning ViewPager View and setting the adapter
		pager = (ViewPager) findViewById(R.id.pager);
		pager.setAdapter(adapter);

		// Assiging the Sliding Tab Layout View
		tabs = (SlidingTabLayout) findViewById(R.id.tabs);
	//	tabs.setDistributeEvenly(true); // To make the Tabs Fixed set this true,
										// This makes the tabs Space Evenly in
										// Available width

		// Setting Custom Color for the Scroll bar indicator of the Tab View
		/*
		 * tabs.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
		 * 
		 * @Override public int getIndicatorColor(int position) { return
		 * getResources().getColor(R.color.tabsScrollColor); } });
		 */
		tabs.setSelectedIndicatorColors(getResources().getColor(
				R.color.indicator));
		
		tabs.setDividerColors(getResources().getColor(R.color.Dividercolor));
		tabs.setBackgroundColor(getResources().getColor(R.color.aminbackground));
	//	tabs.setDividerColors(getResources().getColor(
		//		R.color.Dividercolor));
		/*tabs.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {

		    @Override
		    public int getIndicatorColor(int position) {
		    return getResources().getColor(R.color.white);    //define any color in xml resources and set it here, I have used white
		    }

		    @Override
		    public int getDividerColor(int position) {
		    return getResources().getColor(R.color.white);
		    }
		});*/
		// Setting the ViewPager For the SlidingTabsLayout
		tabs.setViewPager(pager);
		

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		// noinspection SimplifiableIfStatement
		if (id == R.id.action_settings) {
			return true;
		}

		return super.onOptionsItemSelected(item);
	}
}