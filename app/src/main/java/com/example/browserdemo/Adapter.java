package com.example.browserdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class Adapter extends BaseAdapter {

    private List<Integer> images;
    private List<String> names;
    private Context applicationContext;
    private LayoutInflater inflater;


    public Adapter(Context applicationContext, List<Integer>imageIDs, List<String> names) {
        this.applicationContext = applicationContext;
        this.images = imageIDs;
        this.names = names;

        inflater = LayoutInflater.from(applicationContext);

    }
    @Override
    public int getCount() {
        return names.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = inflater.inflate(R.layout.saved_web_address_layout,null);
        ImageView imageView = v.findViewById(R.id.imageViewIdSingleLayout);
        imageView.setImageResource(images.get(position));

        TextView name = v.findViewById(R.id.savedUrlNameId);
        name.setText(names.get(position));

        return v;




    }
}
