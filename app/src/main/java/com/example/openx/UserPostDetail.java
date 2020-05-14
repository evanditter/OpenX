package com.example.openx;

import Adapter.PostDetailAdapter;
import Adapter.ProfileAdapter;
import Model.ItemData;
import Model.User;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;

public class UserPostDetail extends AppCompatActivity {
    private TextView header;
    private Bundle extras;
    private PostDetailAdapter adapter;
    private RecyclerView recyclerView;
    private String headerName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_post_detail);

        extras = getIntent().getExtras();

        header = findViewById(R.id.header);

        if (extras != null) {
            headerName = extras.getString("option");
            header.setText(headerName);
        }


        // set the RecyclerView
        recyclerView = findViewById(R.id.postListRecyViewID);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // creates adapter... passing the profile options to get the right list of posts
        adapter = new PostDetailAdapter(UserPostDetail.this, headerName);
        
        // sets the adapter to the recycler view
        recyclerView.setAdapter(adapter);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.user_profile:
                startActivity(new Intent(this, MainProfile.class));
                return true;
            case R.id.homeButton:
                startActivity(new Intent(this, MainActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
