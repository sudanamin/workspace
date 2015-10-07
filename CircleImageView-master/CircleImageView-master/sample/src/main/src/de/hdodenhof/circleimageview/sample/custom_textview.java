package de.hdodenhof.circleimageview.sample;


	import android.content.Context;
	import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
	import android.util.AttributeSet;
	import android.widget.TextView;
	
	
	public class custom_textview extends TextView {


	    public custom_textview(Context context) {
	      super(context);
	    //  Typeface face=Typeface.createFromAsset(context.getAssets(), "Helvetica_Neue.ttf"); 
	   //   this.setTypeface(face); 
	    }

	    public custom_textview(Context context, AttributeSet attrs) {
	        super(context, attrs);
	   //  Typeface face=Typeface.createFromAsset(context.getAssets(), "Helvetica_Neue.ttf"); 
	//  this.setTypeface(face); 
	    }

	    public custom_textview(Context context, AttributeSet attrs, int defStyle) {
	        super(context, attrs, defStyle);
	   //  Typeface face=Typeface.createFromAsset(context.getAssets(), "Helvetica_Neue.ttf"); 
	//  this.setTypeface(face); 
	    }

	    protected void onDraw (Canvas canvas) {
	        super.onDraw(canvas);
	        float width = getMeasuredWidth();
	        float height = getMeasuredHeight();
	        Paint paint = new Paint();
	        paint.setStrokeWidth(5);
	        paint.setColor(Color.RED);
	        canvas.drawLine(0,0,width,height,paint);
	        canvas.drawLine(width,0,0,height,paint);
	        
	       
	    }

	}

