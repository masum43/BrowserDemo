package com.example.browserdemo;

import android.Manifest;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
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
    ArrayList<NameAndUrlModel>deleteArrayList;

    MyDatabaseSource myDatabaseSource;
    MyDatabaseHelper myDatabaseHelper;
    AdapterToShowDataFromDatabase adapterToShowDataFromDatabase;





    String [] names ={"Facebook","Twitter","Google","Youtube","Wikipedia",
            "Amazon","Linkedin","Gmail","Instagram","Quora","Stack","Add Item"};
    int [] images={
            R.drawable.facebook,R.drawable.twitter,
            R.drawable.google, R.drawable.youtube,
            R.drawable.wikipedia, R.drawable.amazon,
            R.drawable.linkedin, R.drawable.gmail,
            R.drawable.instagram, R.drawable.quora,
            R.drawable.overflowing,R.drawable.plus};



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


        myDatabaseSource = new MyDatabaseSource(this);

        for (int i = 0; i < names.length; i++) {
            NewImages.add(images[i]);
            NewNames.add(names[i]);


        }



              NewNamesFromDatabase = myDatabaseSource.getAllItemWithNameUrlAndImage();
              ImagesFromDatabase = myDatabaseSource.getAllItemWithNameUrlAndImage();
              UrlFromDatabase = myDatabaseSource.getAllItemWithNameUrlAndImage();
               adapterToShowDataFromDatabase = new AdapterToShowDataFromDatabase(MainActivity.this,NewNamesFromDatabase,UrlFromDatabase);
               gridView.setAdapter(adapterToShowDataFromDatabase);

               //To delete single item now need to register gridview with context menu

               registerForContextMenu(gridView);


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

                           String url = UrlFromDatabase.get(position).getUrl();
                           Intent intentAddItem = new Intent(MainActivity.this, BrowsingActivity.class);
                           intentAddItem.putExtra("urlFromGrid","http://"+url);
                           startActivity(intentAddItem);
                           finish();
                       }


                   }
               });

    }

    //to delete single item now need to override onCreateContextMenu method and onContextItemSelected method


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu,menu);
        //menu.setHeaderTitle("Delete");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {


        //To get the selected position... listview ba gridview k context er sathe reg na korle listview.getselectedItemPosion(); method er maddhome o position get kora jeto
        AdapterView.AdapterContextMenuInfo adapterContextMenuInfo = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        if(item.getItemId() == R.id.deleteItemId){
            deleteArrayList = myDatabaseSource.getAllItemWithNameUrlAndImage();
            //Toast.makeText(this, "Error :  "+deleteArrayList, Toast.LENGTH_LONG).show();
            if (deleteArrayList.get(adapterContextMenuInfo.position).getItemName().equals("Add Item")){
                Toast.makeText(this, "No no you can not delete this... Please don't mind.. :)", Toast.LENGTH_SHORT).show();
            }
            else {

                Boolean status = myDatabaseSource.deleteItem(deleteArrayList.get(adapterContextMenuInfo.position));




                if(status){
                    Toast.makeText(this, "Deleted Successfully. Please Exit and come back to see the change....", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(MainActivity.this,MainActivity.class);
                }
                else {
                    Toast.makeText(this, "Failed to delete.......", Toast.LENGTH_SHORT).show();
                }

            }

        }
        return super.onContextItemSelected(item);

    }


}
