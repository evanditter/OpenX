package com.example.openx;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class PostPublished extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_published);

        final Button post_published_btn = (Button) findViewById(R.id.see_post_published);
        post_published_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // ToDo: change to post
                startActivity(new Intent(PostPublished.this, ImageSlider2.class));
            }
        });

        final Button home_button = (Button) findViewById(R.id.home_post_published);
        home_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PostPublished.this, MainActivity.class));
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.user_profile:
                startActivity(new Intent(PostPublished.this, MainProfile.class));
                return true;
            case R.id.homeButton:
                startActivity(new Intent(PostPublished.this, MainActivity.class));
                return true;
//            case R.id.filterButton:
//                startActivity(new Intent(BuyCardView.this, FilterBuy.class));
//                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}


