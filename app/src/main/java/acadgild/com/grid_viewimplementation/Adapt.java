package acadgild.com.grid_viewimplementation;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by user on 1/14/2017.
 */

class App{
    int imagesId;
    String appnames;
   public App(int imagesId,String appnames){
        this.appnames=appnames;
        this.imagesId=imagesId;
    }
}
public class Adapt extends BaseAdapter {

    Context context;
    ArrayList<App> list;

   public Adapt(Context context){
       this.context=context;
       list=new ArrayList<>();
       Resources res=context.getResources();
       String[] app_name=res.getStringArray(R.array.Apps_name);
       int[] apps={R.drawable.images1,R.drawable.images2,R.drawable.images3,R.drawable.images4,R.drawable.images5,R.drawable.images6};

       for(int i=0;i<6;i++){
           list.add(new App(apps[i],app_name[i]));
       }

   }

    @Override
    public int getCount()
    {
        return list.size();
    }

    @Override
    public Object getItem(int position)
    {
        return list.get(position);
    }


    @Override
    public long getItemId(int position)
    {
        return position;
    }

    class ImageHolder{
        TextView textView;
        ImageView imageView;
        public ImageHolder(View v){
            imageView= (ImageView) v.findViewById(R.id.imageView);
            textView= (TextView) v.findViewById(R.id.textView);
        }
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent){

            View view=convertView;
           ImageHolder imageHolder=null;

        if(view==null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.single_item, parent, false);
            imageHolder = new ImageHolder(view);
            view.setTag(imageHolder);
        }
        else {
            imageHolder= (ImageHolder) view.getTag();
        }
            App app=list.get(position);
             imageHolder.imageView.setImageResource(app.imagesId);
             imageHolder.textView.setText(app.appnames);

        return view;
    }
}
