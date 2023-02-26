package com.example.onlinecreation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class onlinecreation2 extends AppCompatActivity {
    private EditText name , phone,email,address,tag,website;
 private Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onlinecreation2);
        submit = findViewById(R.id.button2);

        name = findViewById(R.id.editTextTextPersonName1);
        phone = findViewById(R.id.editTextTextPersonName2);
        email = findViewById(R.id.editTextTextPersonName3);
        address = findViewById(R.id.editTextTextPersonName4);
        tag = findViewById(R.id.editTextTextPersonName5);
        website = findViewById(R.id.editTextTextPersonName);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String n=name.getText().toString();
                String m= phone.getText().toString();
                String o= email.getText().toString();
                String p= address.getText().toString();
                String r= website.getText().toString();
                String q= tag.getText().toString();
                Intent intent = new Intent(onlinecreation2.this,onlinecreation3.class);
                intent.putExtra( "nameuser",n);
                intent.putExtra("phoneuser",m);
                intent.putExtra("emailuser",o);
                intent.putExtra("adduser",p);
                intent.putExtra("taguser",q);
                intent.putExtra("webuser",r);

                startActivity(intent);

            }
        });


    }
}