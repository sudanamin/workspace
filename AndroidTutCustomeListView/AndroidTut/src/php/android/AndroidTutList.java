package php.android;

import android.app.*;
import android.os.*;
import android.view.View;
import android.webkit.*;
import android.widget.*;
import android.widget.AdapterView.*;

public class AndroidTutList extends Activity {
	
	int images[] = {R.drawable.skype,R.drawable.facebook,R.drawable.subway};
	String name[] = {"Skype","Facebook","Subway surf"};
	String descp[]={"Social app","Social app","Games"};
	String offer[] = {"1,200","1,532","1,132"};
	float rate[]={(float) 2.5,3,(float)4.5};
	
	
	
	public void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		ListView list=(ListView)findViewById(R.id.fruite);
		
		
		CustomListViewAdapter adapter=new CustomListViewAdapter(AndroidTutList.this, images,name,descp,offer,rate);
        list.setAdapter(adapter);
		
		list.setOnItemClickListener(new OnItemClickListener() {
			 
			public void onItemClick(AdapterView<?> arg0, View arg1, int position,long arg3) {
				// TODO Auto-generated method stub
				
	              // Show Alert 
	              Toast.makeText(getApplicationContext(),"  You Clicked : " +name[position] , Toast.LENGTH_LONG)
	                .show();
			}

       }); 
	}
	
}
