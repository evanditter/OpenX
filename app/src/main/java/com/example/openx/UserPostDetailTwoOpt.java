package com.example.openx;

import Adapter.PostDetailAdapter;
import Model.ItemData;
import Model.User;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class UserPostDetailTwoOpt extends AppCompatActivity {

    PostDetailAdapter adapter;
    private RecyclerView recyclerView;
    private TextView header;
    private Bundle extras;
    private String headerName;
    private ArrayList<ItemData> tmp;
    private Button firstButton;
    private  Button secondButton;
    private String newHeader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_post_detail_two_opt);


        extras = getIntent().getExtras();

        header = findViewById(R.id.header);

        // set the RecyclerView
        recyclerView = findViewById(R.id.postListRecyViewID);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // set buttons
        firstButton = (Button) findViewById(R.id.postOptionOneID);
        secondButton = (Button) findViewById(R.id.postOptionTwoID);


        if (extras != null) {
            headerName = extras.getString("option");
            header.setText(headerName);
        }


        if (headerName.compareToIgnoreCase("Active Posts") == 0) {

            // Set up view for Active items, showing Buying first
            firstButton.setText("Buying");
            firstButton.setBackgroundColor(Color.parseColor("#8BC34A"));
            secondButton.setText("Selling");

        } else if (headerName.compareToIgnoreCase("History") == 0) {

            // set up view for history,shows Bought first
            firstButton.setText("Bought");
            firstButton.setBackgroundColor(Color.parseColor("#8BC34A"));
            secondButton.setText("Sold");
        }

        secondButton.setBackgroundColor(Color.parseColor("#FF9FA6A7"));

        // creates adapter... passing the profile options
        adapter = new PostDetailAdapter(UserPostDetailTwoOpt.this, headerName);

        // sets it...
        recyclerView.setAdapter(adapter);


        firstButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (headerName.compareToIgnoreCase("Active Posts") == 0) {

                    // Set up view for Active items, showing Buying first
                    newHeader = "Buying";
                    firstButton.setBackgroundColor(Color.parseColor("#8BC34A"));
                    secondButton.setBackgroundColor(Color.parseColor("#FF9FA6A7"));

                } else if (headerName.compareToIgnoreCase("History") == 0) {

                    // set up view for history,shows Bought first
                    newHeader  = "Bought";
                    firstButton.setBackgroundColor(Color.parseColor("#8BC34A"));
                    secondButton.setBackgroundColor(Color.parseColor("#FF9FA6A7"));
                }

                // creates adapter... passing the profile options
                adapter = new PostDetailAdapter(UserPostDetailTwoOpt.this, newHeader);

                // sets it...
                recyclerView.setAdapter(adapter);
            }
        });

        secondButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (headerName.compareToIgnoreCase("Active Posts") == 0) {

                    // Set up view for Active items, showing Buying first
                    newHeader  = "Selling";
                    firstButton.setBackgroundColor(Color.parseColor("#FF9FA6A7"));
                    secondButton.setBackgroundColor(Color.parseColor("#8BC34A"));

                } else if (headerName.compareToIgnoreCase("History") == 0) {

                    // set up view for history,shows Bought first
                    newHeader  = "Sold";
                    firstButton.setBackgroundColor(Color.parseColor("#FF9FA6A7"));
                    secondButton.setBackgroundColor(Color.parseColor("#8BC34A"));
                }

                // creates adapter... passing the profile options
                adapter = new PostDetailAdapter(UserPostDetailTwoOpt.this, newHeader );

                // sets it...
                recyclerView.setAdapter(adapter);
            }
        });


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
                startActivity(new Intent(UserPostDetailTwoOpt.this, MainProfile.class));
                return true;
            case R.id.homeButton:
                startActivity(new Intent(UserPostDetailTwoOpt.this, MainActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
