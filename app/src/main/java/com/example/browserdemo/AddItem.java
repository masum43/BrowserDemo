package com.example.browserdemo;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import static com.example.browserdemo.MyDatabaseHelper.TABLE_NAME;

public class AddItem extends AppCompatActivity {

    Button button;
    EditText name,url;

    MyDatabaseSource myDatabaseSource;
    MyDatabaseHelper myDatabaseHelper;
    NameAndUrlModel nameAndUrlModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        button = findViewById(R.id.saveBtnId);
        name = findViewById(R.id.enterNameId);
        url = findViewById(R.id.enterUrlId);



        myDatabaseSource = new MyDatabaseSource(this);
        myDatabaseHelper = new MyDatabaseHelper(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                NameAndUrlModel nameAndUrlModel = new NameAndUrlModel(name.getText().toString(),url.getText().toString());
                    Boolean status = myDatabaseSource.addItemWithNameAndUrl(nameAndUrlModel);

                    if (status){
                        Toast.makeText(AddItem.this, "Saved Successfully.......",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(AddItem.this,MainActivity.class);
                        startActivity(intent);


                    }
                    else {
                        Toast.makeText(AddItem.this, "Failed to Save.......",Toast.LENGTH_SHORT).show();
                    }



            }
        });

    }


}
