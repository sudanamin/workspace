package de.hdodenhof.circleimageview.sample;





import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.Display;
import android.widget.LinearLayout;
import android.widget.TextView;

@SuppressLint("ResourceAsColor")
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       LinearLayout layou = (LinearLayout) findViewById(R.id.linear);
       LinearLayout layou2 = (LinearLayout) findViewById(R.id.linear2);
       
       layou2.setBackgroundResource(R.drawable.rounded_corner);
       
       TextView t =  (TextView) findViewById(R.id.textView2);
      // TextView t2 =  (TextView) findViewById(R.id.textView3);
       t.setTextSize(25);
       t.setText("Hi Amin");
     //  t2.setTextSize(25);
   //   t2.setText("Hi Amin");
      custom_textview ctxt = new custom_textview(this);
      ctxt.setTextSize(100);
      ctxt.setPadding(5, 5, 5, 15);
       ctxt.setText("custom txt");
       layou2.addView(ctxt);
       for(int i=0;i<10;i++){
        
        CircleImageView imageView = new CircleImageView(this);
        
	
		imageView.setId(1);
		Display display = getWindowManager().getDefaultDisplay();
		// ImageView iv = (LinearLayout) findViewById(R.id.left);
		int width = display.getWidth() * 60 / 100; // ((display.getWidth()*20)/100)
		int height = display.getHeight() * 40 / 100;// ((display.getHeight()*30)/100)
		LinearLayout.LayoutParams parms = new LinearLayout.LayoutParams(width, height);
		parms.leftMargin = 10;
		imageView.setBorderWidth(2);
		imageView.setBorderColor(R.color.light);
		//imageView.setBackgroundColor(2290466);
		imageView.setImageDrawable(getResources().getDrawable(R.drawable.hugh));
		
		

		
		
	    imageView.setLayoutParams(parms);
	   layou.addView(imageView);
       }
    //   layou.addView(ctxt);
		 
    }

}
