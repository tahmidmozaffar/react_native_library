package com.remotearth.mynativeandroidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.remotearth.CustomListViewActivity;
import com.remotearth.DetailsActivity;
import com.remotearth.HelloActivity;
import com.remotearth.HelloActivityNew;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button).setOnClickListener(view -> {
          Intent intent = new Intent(MainActivity.this, HelloActivity.class);
          intent.putExtra("NAME", "Tahmid");
          startActivity(intent);
        });

      findViewById(R.id.button2).setOnClickListener(view -> {
        Intent intent = new Intent(MainActivity.this, CustomListViewActivity.class);
        startActivity(intent);
      });

    }
}
