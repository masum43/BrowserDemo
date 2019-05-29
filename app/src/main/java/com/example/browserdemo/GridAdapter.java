package com.example.browserdemo;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class GridAdapter extends BaseAdapter {
    private Context mcontext;

    ArrayList<NameAndUrlModel> images;
    ArrayList<Integer> imagesInt;
    ArrayList<String> names;
    ArrayList<NameAndUrlModel> namesFromDatabase;

    public GridAdapter(Context c, ArrayList<String> names, ArrayList<NameAndUrlModel> images ,ArrayList<NameAndUrlModel> namesFromDatabase,ArrayList<Integer> imagesInt) {
        mcontext = c;
        this.images = images;
        this.names = names;
        this.namesFromDatabase = namesFromDatabase;
        this.imagesInt = imagesInt;
    }

   /* public GridAdapter(Context c, ArrayList<NameAndUrlModel> namesFromDatabase, ArrayList<Integer> images ) {
        mcontext = c;
        this.images = images;
        this.namesFromDatabase = namesFromDatabase;
    } */

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return namesFromDatabase.size();
        //return names.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub

        View grid;
        LayoutInflater layoutinflatr = (LayoutInflater) mcontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {

            grid = new View(mcontext);
            grid = layoutinflatr.inflate(R.layout.saved_web_address_layout, null);
            TextView tv = (TextView) grid.findViewById(R.id.savedUrlNameId);
            ImageView iv = (ImageView) grid.findViewById(R.id.imageViewIdSingleLayout);



            tv.setText(names.get(position));
             iv.setImageResource(imagesInt.get(position));

                if(position>3){
                    tv.setText(namesFromDatabase.get(position).getItemName());
                    iv.setImageResource(R.drawable.additem);
                }



            //iv.setImageResource(images.get(position));
        } else {
            grid = (View) convertView;
        }
        //grid.setTag(position);
        grid.setTag(3);
        final View finalGrid = grid;
        grid.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

               // if(v.getId()== finalGrid.getTag(3)){
                    //names.add()
                //}
                // TODO Auto-generated method stub
                // code to delete the selected item.
                //names.remove((int) v.getTag());
                //images.remove((int) v.getTag());
                //notifyDataSetChanged();
                if(position==3){
                    //Toast.makeText(mcontext, "Hello", Toast.LENGTH_SHORT).show();
                    v.getContext().startActivity(new Intent(mcontext,AddItem.class));



                }
            }
        });
        return grid;
    }
}
