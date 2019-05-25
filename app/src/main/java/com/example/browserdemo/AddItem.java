package com.example.browserdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddItem extends AppCompatActivity {

    Button button;
    EditText name,url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        button = findViewById(R.id.saveBtnId);
        name = findViewById(R.id.enterNameId);
        url = findViewById(R.id.enterUrlId);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String nameStr = name.getText().toString();
                String urlStr = url.getText().toString();
                Intent intentAddItem = new Intent(AddItem.this, MainActivity.class);
                intentAddItem.putExtra("name",nameStr);
                intentAddItem.putExtra("url",urlStr);
                startActivity(intentAddItem);


            }
        });
    }


}
