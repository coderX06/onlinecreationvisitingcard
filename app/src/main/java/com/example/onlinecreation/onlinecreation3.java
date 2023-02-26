package com.example.onlinecreation;

import android.graphics.Bitmap;
import android.os.Environment;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;

public class onlinecreation3 extends AppCompatActivity {
    RelativeLayout relativeLayout;
    TextView nameTextView, mobileTextView, emailTextView, addressTextView, tagTextView, webTextView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onlinecreation3);
        nameTextView = findViewById(R.id.nameText);
        mobileTextView = findViewById(R.id.textView3);
        emailTextView = findViewById(R.id.textView5);
        addressTextView = findViewById(R.id.textView7);
        tagTextView = findViewById(R.id.textView8);
        webTextView = findViewById(R.id.textView10);

        String username = getIntent().getStringExtra("nameuser");
        String usermobile = getIntent().getStringExtra("phoneuser");
        String useremail = getIntent().getStringExtra("emailuser");
        String useraddress = getIntent().getStringExtra("adduser");
        String usertag = getIntent().getStringExtra("taguser");
        String userweb = getIntent().getStringExtra("webuser");


        nameTextView.setText(username);
        mobileTextView.setText(usermobile);
        emailTextView.setText(useremail);
        addressTextView.setText(useraddress);
        tagTextView.setText(usertag);
        webTextView.setText(userweb);


        relativeLayout = findViewById(R.id.myLayout);
        Button button = findViewById(R.id.saveLayout4);
        button.setOnClickListener(View -> {
            saveImage();
        });
    }


    private void saveImage() {
        relativeLayout.setDrawingCacheEnabled(true);
        relativeLayout.buildDrawingCache();
        relativeLayout.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
        Bitmap bitmap=relativeLayout.getDrawingCache();
        save(bitmap);
    }

    private void save(Bitmap bitmap) {
        String root = Environment.getExternalStorageDirectory().getAbsolutePath();
        File file = new File(root+"/Download");
        String filename ="Visiting_card.jpg";
        File myfile = new File(file,filename);
        if( myfile.exists()){
            myfile.delete();
        }

        try { FileOutputStream fileOutputStream = new FileOutputStream(myfile);
            bitmap.compress(Bitmap.CompressFormat.JPEG,100,fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            Toast.makeText(this, "saved...", Toast.LENGTH_SHORT).show();
            relativeLayout.setDrawingCacheEnabled(false);
        }catch (Exception e){
            Toast.makeText(this, "Error: " +e.toString(), Toast.LENGTH_SHORT).show();
        }



    }
}
