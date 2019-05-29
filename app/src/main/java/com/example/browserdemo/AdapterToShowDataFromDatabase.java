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
    ArrayList<String> NamevaluesStr;
    ArrayList<Integer> ImagevaluesInt;
    TextView tv;
    ImageView iv;

   /* public AdapterToShowDataFromDatabase(Context mcontext, ArrayList<Integer> imagesInt, ArrayList<NameAndUrlModel> names) {
        this.mcontext = mcontext;
        this.imagesInt = imagesInt;
        this.names = names;
    } */

    public AdapterToShowDataFromDatabase(Context mcontext, ArrayList<NameAndUrlModel> images, ArrayList<NameAndUrlModel> names,    ArrayList<Integer> imagesInt) {
        this.mcontext = mcontext;
        this.images = images;
        this.names = names;
        this.imagesInt=imagesInt;
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

            //String value3 = (names.get(3).getItemName()).trim();
            //String value4 = (names.get(4).getItemName()).trim();



            /*for (int i=position;i<names.size();i++){


                NamevaluesStr.add(names.get(i).getItemName());
            } */


            String check = "Add Item";
            int newPosition;

            if(position<12){
                tv.setText(names.get(position).getItemName());
                iv.setImageResource(imagesInt.get(position));
            }

            else {

                tv.setText(names.get(position).getItemName());

                if(names.get(position).getItemName().charAt(0)=='f' || names.get(position).getItemName().charAt(0)=='F')
                {
                    iv.setImageResource(R.drawable.f);
                    //Toast.makeText(mcontext,names.get(position).getItemName().charAt(0) , Toast.LENGTH_SHORT).show();
                }

                else if(names.get(position).getItemName().charAt(0)=='a' || names.get(position).getItemName().charAt(0)=='A')
                {
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
                    iv.setImageResource(R.drawable.g);
                    //Toast.makeText(mcontext,names.get(position).getItemName().charAt(0) , Toast.LENGTH_SHORT).show();
                }else if(names.get(position).getItemName().charAt(0)=='h' || names.get(position).getItemName().charAt(0)=='H')
                {
                    iv.setImageResource(R.drawable.additem);
                    //Toast.makeText(mcontext,names.get(position).getItemName().charAt(0) , Toast.LENGTH_SHORT).show();
                }else if(names.get(position).getItemName().charAt(0)=='i' || names.get(position).getItemName().charAt(0)=='I')
                {
                    iv.setImageResource(R.drawable.i);
                    //Toast.makeText(mcontext,names.get(position).getItemName().charAt(0) , Toast.LENGTH_SHORT).show();
                }else if(names.get(position).getItemName().charAt(0)=='j' || names.get(position).getItemName().charAt(0)=='J')
                {
                    iv.setImageResource(R.drawable.additem);
                    //Toast.makeText(mcontext,names.get(position).getItemName().charAt(0) , Toast.LENGTH_SHORT).show();
                }else if(names.get(position).getItemName().charAt(0)=='k' || names.get(position).getItemName().charAt(0)=='K')
                {
                    iv.setImageResource(R.drawable.ic_launcher_background);
                    //Toast.makeText(mcontext,names.get(position).getItemName().charAt(0) , Toast.LENGTH_SHORT).show();
                }else if(names.get(position).getItemName().charAt(0)=='l' || names.get(position).getItemName().charAt(0)=='L')
                {
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
                    iv.setImageResource(R.drawable.quora);

                }else if(names.get(position).getItemName().charAt(0)=='r' || names.get(position).getItemName().charAt(0)=='R')
                {
                    iv.setImageResource(R.drawable.r);

                }else if(names.get(position).getItemName().charAt(0)=='s' || names.get(position).getItemName().charAt(0)=='S')
                {
                    iv.setImageResource(R.drawable.s);

                }else if(names.get(position).getItemName().charAt(0)=='t' || names.get(position).getItemName().charAt(0)=='T')
                {
                    iv.setImageResource(R.drawable.t);

                }else if(names.get(position).getItemName().charAt(0)=='u' || names.get(position).getItemName().charAt(0)=='U')
                {
                    iv.setImageResource(R.drawable.u);

                }else if(names.get(position).getItemName().charAt(0)=='v' || names.get(position).getItemName().charAt(0)=='V')
                {
                    iv.setImageResource(R.drawable.reviewfinal2);

                }else if(names.get(position).getItemName().charAt(0)=='w' || names.get(position).getItemName().charAt(0)=='W')
                {
                    iv.setImageResource(R.drawable.w);

                }else if(names.get(position).getItemName().charAt(0)=='x' || names.get(position).getItemName().charAt(0)=='X')
                {
                    iv.setImageResource(R.drawable.x);

                }else if(names.get(position).getItemName().charAt(0)=='y' || names.get(position).getItemName().charAt(0)=='Y')
                {
                    iv.setImageResource(R.drawable.ic_launcher_background);

                }else if(names.get(position).getItemName().charAt(0)=='z' || names.get(position).getItemName().charAt(0)=='Z')
                {
                    iv.setImageResource(R.drawable.z);

                }

                else {
                    iv.setImageResource(R.drawable.additem);
                }


            }

           // String value2 = tv.getText().toString();

            /*try {
                if(position==4&&value3.equals(check)){

                    if(position==4){
                            tv.setText(check);
                    iv.setImageResource(imagesInt.get(position-1));
                            }

                    tv.setText(names.get(position+1).getItemName());

                }
            }
            catch (Exception e){

                Toast.makeText(mcontext, "Error : "+e, Toast.LENGTH_LONG).show();
            }

            /*if(value.equals(check)){
                newPosition = position;
                if()
            } */

        } else {
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
