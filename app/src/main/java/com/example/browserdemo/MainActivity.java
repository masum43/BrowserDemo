package com.example.browserdemo;

import android.Manifest;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    GridView gridView ;
    EditText searchWeb;
    Button goBtn;
    ArrayList<NameAndUrlModel>NewNamesFromDatabase;
    ArrayList<NameAndUrlModel>ImagesFromDatabase;
    ArrayList<NameAndUrlModel>UrlFromDatabase;
    ArrayList<NameAndUrlModel>ids;

    MyDatabaseSource myDatabaseSource;
    MyDatabaseHelper myDatabaseHelper;
    AdapterToShowDataFromDatabase adapterToShowDataFromDatabase;

    //int AddBtnNumber = 0;
    //String[] MnewName = new String[100];



    String [] names ={"Facebook","Twitter","Google","Youtube","Wikipedia",
            "Amazon","Linkedin","Gmail","Instagram","Quora","Stack","Add Item"};
    int [] images={
            R.drawable.facebook,R.drawable.twitter,
            R.drawable.google, R.drawable.youtube,
            R.drawable.wikipedia, R.drawable.amazon,
            R.drawable.linkedin, R.drawable.gmail,
            R.drawable.instagram, R.drawable.quora,
            R.drawable.overflowing,R.drawable.plus};

    //int [] ids = {1,2,3,100};

    GridAdapter adapter;

    ArrayList<Integer> NewImages;
    ArrayList<String> NewNames;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = findViewById(R.id.gridViewId);
        searchWeb = findViewById(R.id.searchWebId);
        goBtn = findViewById(R.id.goBtnId);



        NewImages = new ArrayList<Integer>();
        NewNames = new ArrayList<String>();
        //adapterToShowDataFromDatabase = new AdapterToShowDataFromDatabase(this);

        myDatabaseSource = new MyDatabaseSource(this);

        for (int i = 0; i < names.length; i++) {
            NewImages.add(images[i]);
            NewNames.add(names[i]);


        }



              NewNamesFromDatabase = myDatabaseSource.getAllItemWithNameUrlAndImage();
              ImagesFromDatabase = myDatabaseSource.getAllItemWithNameUrlAndImage();
               adapterToShowDataFromDatabase = new AdapterToShowDataFromDatabase(MainActivity.this,ImagesFromDatabase,NewNamesFromDatabase,NewImages);
               gridView.setAdapter(adapterToShowDataFromDatabase);


               goBtn.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {

                       try{
                           String urlStr = searchWeb.getText().toString();
                           Intent intentAddItem = new Intent(MainActivity.this, BrowsingActivity.class);
                           intentAddItem.putExtra("url","http://www."+urlStr);
                           startActivity(intentAddItem);
                           finish();
                       }

                       catch (Exception e){
                           Toast.makeText(MainActivity.this, "Error :   "+e, Toast.LENGTH_SHORT).show();
                       }

                   }
               });

               gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                   @Override
                   public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                       String itemName = NewNamesFromDatabase.get(position).getItemName();
                       if(itemName.equals("Add Item")){
                           Intent addIntent = new Intent(MainActivity.this,AddItem.class);
                           startActivity(addIntent);
                       }
                       else {

                           UrlFromDatabase = myDatabaseSource.getAllItemWithNameUrlAndImage();
                           String url = UrlFromDatabase.get(position).getUrl();
                           Intent intentAddItem = new Intent(MainActivity.this, BrowsingActivity.class);
                           intentAddItem.putExtra("urlFromGrid","http://"+url);
                           startActivity(intentAddItem);
                           finish();
                       }


                   }
               });

































        /*

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
        final Intent intentAddItem = getIntent();



            nameArray[0] = intentAddItem.getStringExtra("name");
            String addUrl = intentAddItem.getStringExtra("url");
            //nameArray[1]= intentAddItem.getStringExtra("name");
            //nameArray[2]= intentAddItem.getStringExtra("name");


            images.add(R.drawable.additem);
            names.add(MnewName[0]);


            nameArray[1]= intentAddItem.getStringExtra("name");
        images.add(R.drawable.additem);
        names.add(nameArray[1]);






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

                int Id = parent.getSelectedItemPosition();

                int result = AddBtnNumber;
                if(position==0){
                    Intent intent = new Intent(MainActivity.this,AddItem.class);
                    //int AddBtnNumber = 1;
                    startActivity(intent);

                    result = result+1;

                }
                for(result = 0;result<=100;result++){
                    if(result==1){
                        Intent intentAddItem = getIntent();
                        String[] newNameStr = new String[100];
                        newNameStr[0] = intentAddItem.getStringExtra("name");
                        MnewName[0]=newNameStr[0];
                    }

                }


            }
        }); */
    }
}
