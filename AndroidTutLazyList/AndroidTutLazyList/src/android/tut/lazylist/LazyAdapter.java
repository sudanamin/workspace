package android.tut.lazylist;



import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
 

 
public class LazyAdapter extends BaseAdapter {
     
    private Activity activity;
    private String[] data;
    private String[] items_name;
    private String[] items_descp;
    private static LayoutInflater inflater=null;
    public ImageLoader imageLoader;
     
    public LazyAdapter(Activity a, String[] d,String[] catg_name,String[] catg_descp) {
        activity = a;
        
        data=d;
        items_name = catg_name;
        items_descp = catg_descp;
        
        inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        imageLoader=new ImageLoader(activity.getApplicationContext());
    }
 
    public int getCount() {
        return data.length;
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
            vi = inflater.inflate(R.layout.row_listview_item, null);
 
        TextView name=(TextView)vi.findViewById(R.id.title);;
        TextView descp = (TextView) vi.findViewById(R.id.artist);
        ImageView image=(ImageView)vi.findViewById(R.id.image);
        
        name.setText(items_name[position]);
        descp.setText(items_descp[position]);
        
        ProgressBar pb = (ProgressBar)vi.findViewById(R.id.progress);
        imageLoader.DisplayImage(data[position], image,pb);
        return vi;
    }
}