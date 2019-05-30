package com.example.browserdemo;

import android.content.ClipData;
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

public class AdapterToShowDataFromDatabase extends BaseAdapter {
    private Context mcontext;


    ArrayList<NameAndUrlModel> images;
    ArrayList<Integer> imagesInt;
    ArrayList<NameAndUrlModel> names;
    ArrayList<NameAndUrlModel> UrlArrayList;
    ArrayList<Integer> ImagevaluesInt;
    TextView tv;
    ImageView iv;

   /* public AdapterToShowDataFromDatabase(Context mcontext, ArrayList<Integer> imagesInt, ArrayList<NameAndUrlModel> names) {
        this.mcontext = mcontext;
        this.imagesInt = imagesInt;
        this.names = names;
    } */

    public AdapterToShowDataFromDatabase(Context mcontext, ArrayList<NameAndUrlModel> names, ArrayList<NameAndUrlModel> UrlArrayList) {
        this.mcontext = mcontext;
        //this.images = images;
        this.names = names;
        //this.imagesInt=imagesInt;
        this.UrlArrayList = UrlArrayList;
    }

    public AdapterToShowDataFromDatabase(Context c, ArrayList<NameAndUrlModel> names) {
        mcontext = c;
        this.names = names;
    }


    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return names.size();
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
    public View getView(final int position, View convertView, final ViewGroup parent) {
        // TODO Auto-generated method stub

        //String Selected_item = parent.getIt

        View grid;
        LayoutInflater layoutinflatr = (LayoutInflater) mcontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null) {

            grid = new View(mcontext);


            grid = layoutinflatr.inflate(R.layout.saved_web_address_layout, null);


            tv = (TextView) grid.findViewById(R.id.savedUrlNameId);
            iv = (ImageView) grid.findViewById(R.id.imageViewIdSingleLayout);


            String UrlCheck =UrlArrayList.get(position).getUrl() ;
            int newPosition;



                tv.setText(names.get(position).getItemName());

                if(names.get(position).getItemName().charAt(0)=='f' || names.get(position).getItemName().charAt(0)=='F')
                {
                    //Toast.makeText(mcontext, ""+UrlArrayList.get(position).getUrl(), Toast.LENGTH_SHORT).show();

                    if((names.get(position).getItemName()).equals("Facebook") || (names.get(position).getItemName()).equals("facebook") ){

                        iv.setImageResource(R.drawable.facebook);
                        //Toast.makeText(mcontext, ""+UrlArrayList.get(position).getUrl(), Toast.LENGTH_SHORT).show();
                    }

                    else {
                        iv.setImageResource(R.drawable.f);
                    }
                }

                else if(names.get(position).getItemName().charAt(0)=='a' || names.get(position).getItemName().charAt(0)=='A')
                {

                    if(UrlCheck.equals("http://www.amazon.com") || UrlCheck.equals("www.amazon.com") ||UrlCheck.equals("amazon.com")){

                        iv.setImageResource(R.drawable.amazon);
                    }
                    else if((names.get(position).getItemName().equals("Add Item"))){
                        iv.setImageResource(R.drawable.plus);
                    }

                    else

                    iv.setImageResource(R.drawable.a);
                    //Toast.makeText(mcontext,names.get(position).getItemName().charAt(0) , Toast.LENGTH_SHORT).show();
                }

                else if(names.get(position).getItemName().charAt(0)=='b' || names.get(position).getItemName().charAt(0)=='B')
                {
                    iv.setImageResource(R.drawable.b);
                    //Toast.makeText(mcontext,names.get(position).getItemName().charAt(0) , Toast.LENGTH_SHORT).show();
                }

                else if(names.get(position).getItemName().charAt(0)=='c' || names.get(position).getItemName().charAt(0)=='C')
                {
                    iv.setImageResource(R.drawable.c);
                    //Toast.makeText(mcontext,names.get(position).getItemName().charAt(0) , Toast.LENGTH_SHORT).show();
                }

                else if(names.get(position).getItemName().charAt(0)=='d' || names.get(position).getItemName().charAt(0)=='D')
                {
                    iv.setImageResource(R.drawable.d);
                    //Toast.makeText(mcontext,names.get(position).getItemName().charAt(0) , Toast.LENGTH_SHORT).show();
                }else if(names.get(position).getItemName().charAt(0)=='e' || names.get(position).getItemName().charAt(0)=='E')
                {

                    iv.setImageResource(R.drawable.e);
                    //Toast.makeText(mcontext,names.get(position).getItemName().charAt(0) , Toast.LENGTH_SHORT).show();
                }else if(names.get(position).getItemName().charAt(0)=='g' || names.get(position).getItemName().charAt(0)=='G')
                {
                    if(UrlCheck.equals("http://www.google.com") || UrlCheck.equals("www.google.com") ||UrlCheck.equals("google.com")){

                        iv.setImageResource(R.drawable.google);
                    }
                    else if(UrlCheck.equals("http://www.gmail.com") || UrlCheck.equals("www.gmail.com") ||UrlCheck.equals("gmail.com")){

                        iv.setImageResource(R.drawable.gmail);
                    }
                    else
                        iv.setImageResource(R.drawable.g);

                }else if(names.get(position).getItemName().charAt(0)=='h' || names.get(position).getItemName().charAt(0)=='H')
                {
                    iv.setImageResource(R.drawable.additem);
                    //Toast.makeText(mcontext,names.get(position).getItemName().charAt(0) , Toast.LENGTH_SHORT).show();
                }else if(names.get(position).getItemName().charAt(0)=='i' || names.get(position).getItemName().charAt(0)=='I')
                {
                    if(UrlCheck.equals("http://www.instagram.com") || UrlCheck.equals("www.instagram.com") ||UrlCheck.equals("instagram.com")){

                        iv.setImageResource(R.drawable.instagram);
                    }
                    else
                        iv.setImageResource(R.drawable.i);
                    //Toast.makeText(mcontext,names.get(position).getItemName().charAt(0) , Toast.LENGTH_SHORT).show();
                }else if(names.get(position).getItemName().charAt(0)=='j' || names.get(position).getItemName().charAt(0)=='J')
                {
                    iv.setImageResource(R.drawable.additem);

                }else if(names.get(position).getItemName().charAt(0)=='k' || names.get(position).getItemName().charAt(0)=='K')
                {
                    iv.setImageResource(R.drawable.ic_launcher_background);

                }else if(names.get(position).getItemName().charAt(0)=='l' || names.get(position).getItemName().charAt(0)=='L')
                {
                    if(UrlCheck.equals("http://www.linkedin.com") || UrlCheck.equals("www.linkedin.com") ||UrlCheck.equals("linkedin.com")){

                        iv.setImageResource(R.drawable.linkedin);
                    }

                    else
                    iv.setImageResource(R.drawable.ic_launcher_background);
                    //Toast.makeText(mcontext,names.get(position).getItemName().charAt(0) , Toast.LENGTH_SHORT).show();
                }else if(names.get(position).getItemName().charAt(0)=='m' || names.get(position).getItemName().charAt(0)=='M')
                {
                    iv.setImageResource(R.drawable.ic_launcher_background);
                    //Toast.makeText(mcontext,names.get(position).getItemName().charAt(0) , Toast.LENGTH_SHORT).show();
                }else if(names.get(position).getItemName().charAt(0)=='n' || names.get(position).getItemName().charAt(0)=='N')
                {
                    iv.setImageResource(R.drawable.ic_launcher_background);
                    //Toast.makeText(mcontext,names.get(position).getItemName().charAt(0) , Toast.LENGTH_SHORT).show();
                }else if(names.get(position).getItemName().charAt(0)=='o' || names.get(position).getItemName().charAt(0)=='O')
                {
                    iv.setImageResource(R.drawable.o);

                }else if(names.get(position).getItemName().charAt(0)=='p' || names.get(position).getItemName().charAt(0)=='P')
                {
                    iv.setImageResource(R.drawable.p);

                }else if(names.get(position).getItemName().charAt(0)=='q' || names.get(position).getItemName().charAt(0)=='Q')
                {
                    if(UrlCheck.equals("http://www.quora.com") || UrlCheck.equals("www.quora.com") ||UrlCheck.equals("quora.com")){

                        iv.setImageResource(R.drawable.quora);
                    }
                    else
                        iv.setImageResource(R.drawable.quora);

                }else if(names.get(position).getItemName().charAt(0)=='r' || names.get(position).getItemName().charAt(0)=='R')
                {
                    iv.setImageResource(R.drawable.r);

                }else if(names.get(position).getItemName().charAt(0)=='s' || names.get(position).getItemName().charAt(0)=='S')
                {
                    iv.setImageResource(R.drawable.s);

                }else if(names.get(position).getItemName().charAt(0)=='t' || names.get(position).getItemName().charAt(0)=='T')
                {
                    if((UrlArrayList.get(position).getUrl()).equals("http://www.twitter.com") || (UrlArrayList.get(position).getUrl()).equals("www.twitter.com") ||(UrlArrayList.get(position).getUrl()).equals("twitter.com")){

                        iv.setImageResource(R.drawable.twitter);
                    }

                    else{
                        iv.setImageResource(R.drawable.t);
                    }


                }else if(names.get(position).getItemName().charAt(0)=='u' || names.get(position).getItemName().charAt(0)=='U')
                {
                    iv.setImageResource(R.drawable.u);

                }else if(names.get(position).getItemName().charAt(0)=='v' || names.get(position).getItemName().charAt(0)=='V')
                {
                    iv.setImageResource(R.drawable.reviewfinal2);

                }
                else if(names.get(position).getItemName().charAt(0)=='w' || names.get(position).getItemName().charAt(0)=='W')
                {
                    if(UrlCheck.equals("http://www.wikipedia.org") || UrlCheck.equals("www.wikipedia.org") ||UrlCheck.equals("wikipedia.org")){

                        iv.setImageResource(R.drawable.wikipedia);
                    }

                    else
                    iv.setImageResource(R.drawable.w);

                }
                else if(names.get(position).getItemName().charAt(0)=='x' || names.get(position).getItemName().charAt(0)=='X')
                {
                    iv.setImageResource(R.drawable.x);

                }else if(names.get(position).getItemName().charAt(0)=='y' || names.get(position).getItemName().charAt(0)=='Y')
                {
                    if((UrlArrayList.get(position).getUrl()).equals("http://www.youtube.com") || (UrlArrayList.get(position).getUrl()).equals("www.youtube.com") ||(UrlArrayList.get(position).getUrl()).equals("youtube.com")){

                        tv.setText(names.get(position).getItemName());
                        iv.setImageResource(R.drawable.youtube);
                    }else
                    iv.setImageResource(R.drawable.ic_launcher_background);

                }
                else if(names.get(position).getItemName().charAt(0)=='z' || names.get(position).getItemName().charAt(0)=='Z')
                {
                    iv.setImageResource(R.drawable.z);

                }



                else {
                    iv.setImageResource(R.drawable.additem);
                }


            }



         else {
            grid = (View) convertView;
        }
        //grid.setTag(position);
        //grid.setTag(3);
        final View finalGrid = grid;
        /*grid.setOnClickListener(new View.OnClickListener() {

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

                //String getText = tv.getText().toString();
                String value = (names.get(position).getItemName()).trim();
                String check = "Add Item";
                //Toast.makeText(mcontext, value + check, Toast.LENGTH_SHORT).show();
                //Toast.makeText(mcontext,Fusionbd.charAt(0) , Toast.LENGTH_SHORT).show();
                if(value.equals(check)){
                    //Toast.makeText(mcontext, "Hello", Toast.LENGTH_SHORT).show();
                    v.getContext().startActivity(new Intent(mcontext,AddItem.class));



                    /*
                    String valueToChange,temp,with;

                    valueToChange = names.get(position).getItemName();
                    with = names.get(position+1).getItemName();

                    valueToChange = with;
                    with = valueToChange;

                    Toast.makeText(mcontext, with, Toast.LENGTH_SHORT).show(); */

                    /*int AddItemPosition = position , prevItemPosition = position+1;

                    if(AddItemPosition<prevItemPosition) {

                        //String changeRow = "UPDATE " + MyDatabaseHelper.TABLE_NAME + " SET " +

                        tv.setText(names.get(position+1).getItemName());
                        iv.setImageResource(R.drawable.ic_launcher_background);
                    } */





              /*  }

                //if(value.equals(check).)
            }
        }); */
        return grid;
    }
}
