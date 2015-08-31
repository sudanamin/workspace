package php.android;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
 

 
public class CustomListViewAdapter extends BaseAdapter {
     
    private Activity activity;
    
    private int[] images;
    private String[] items_name;
    private String[] items_descp;
    private String[] items_offer;
    private float[] items_rate;
    
    private static LayoutInflater inflater=null;

    public CustomListViewAdapter(Activity a, int[] imgs ,String[] name ,String[] descp ,String[] hash ,float[] rate) {
        activity = a;
        
        images=imgs;
        items_name = name;
        items_descp = descp;
        items_offer = hash;
        items_rate = rate;
        
        inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
      
    }
 
    public int getCount() {
        return images.length;
    }
 
    public Object getItem(int position) {
        return position;
    }
 
    public long getItemId(int position) {
        return position;
    }
     
    public View getView(int position, View convertView, ViewGroup parent) {
        View vi=convertView;
        
        if(convertView==null)
            vi = inflater.inflate(R.layout.list_row, null);
 
        TextView name=(TextView)vi.findViewById(R.id.title);;
        TextView descp = (TextView) vi.findViewById(R.id.descrp);
        ImageView image = (ImageView) vi.findViewById(R.id.list_image);
        TextView hash = (TextView) vi.findViewById(R.id.down_count);
        RatingBar rating = (RatingBar) vi.findViewById(R.id.ratingbar_Small);
        
       
	        name.setText(items_name[position]);
	        descp.setText(items_descp[position]);
	        hash.setText(items_offer[position]);
	        rating.setRating(items_rate[position]);
	        image.setBackgroundResource(images[position]);
        
        
        return vi;
    }
}