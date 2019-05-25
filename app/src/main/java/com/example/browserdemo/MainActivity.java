package com.example.browserdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    GridView gridView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = findViewById(R.id.gridViewId);

        final List<Integer> images = new ArrayList<>();
        final List<String> names = new ArrayList<>();

        images.add(R.drawable.plus);
        images.add(R.drawable.facebook);
        images.add(R.drawable.twitter);
        images.add(R.drawable.searchitem);

        names.add("Add");
        names.add("Facebook");
        names.add("Twitter");
        names.add("Google");

        //String addItemName = null,addUrl=null;
        String[] nameArray = new String[100];
        Intent intentAddItem = getIntent();
        nameArray[0] = intentAddItem.getStringExtra("name");
        String addUrl = intentAddItem.getStringExtra("url");
        //nameArray[1]= intentAddItem.getStringExtra("name");
        //nameArray[2]= intentAddItem.getStringExtra("name");


            images.add(R.drawable.additem);
            names.add(nameArray[0]);


            //images.add(R.drawable.additem);
            //names.add(nameArray[1]);


            //images.add(R.drawable.additem);
            //names.add(nameArray[2]);











        Adapter adapter = new Adapter(this,images,names);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(MainActivity.this, "Clicked : "+parent, Toast.LENGTH_SHORT).show();
                //int AddBtnNumber =0;
                if(position==0){
                    Intent intent = new Intent(MainActivity.this,AddItem.class);
                    //int AddBtnNumber = 1;
                    startActivity(intent);


                }


            }
        });
    }
}
