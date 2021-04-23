package com.bryan.firebase5;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ItemView extends AppCompatActivity {

    TextView image_name;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        getSupportActionBar().hide();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_view);

        image = findViewById(R.id.pic);
        image_name = findViewById(R.id.pic_name);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String pic = intent.getStringExtra("pic");

        image.setImageURI(Uri.parse(pic));
        image_name.setText(name);
    }
}