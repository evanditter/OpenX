package com.example.openx;

import Adapter.ProfileAdapter;
import Model.ItemData;
import Model.User;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainProfile extends AppCompatActivity {

    private RecyclerView profileOptions;
    private RecyclerView.Adapter adapter;

    private CardView account;
    private CardView activePosts;
    private CardView favorites;
    private CardView history;
    private CardView logout;

    // list of profile options to choose from
    final private String[] options = {"Account", "Active Posts", "Favorites", "History", "Logout"};
    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_profile);


        // set the RecyclerView
        //profileOptions = findViewById(R.id.profileOptions);
        //profileOptions.setHasFixedSize(true);
        //profileOptions.setLayoutManager(new LinearLayoutManager(this));

        // creates adapter... passing the profile options
        //adapter = new ProfileAdapter(MainProfile.this, options);

        // sets it...
        //profileOptions.setAdapter(adapter);


        setAccountOption();

    }

    private void setAccountOption() {
        account = (CardView) findViewById(R.id.accountOptID);
        activePosts = (CardView) findViewById(R.id.activePostsID);
        favorites = (CardView) findViewById(R.id.favoriteOptID);
        history = (CardView) findViewById(R.id.historyID);
        logout = (CardView) findViewById(R.id.logoutID);

        account.setOnClickListener((View v) -> {
            intent = new Intent(MainProfile.this, AccountDetail.class);
            startActivity(intent);
        });

        activePosts.setOnClickListener((View v) -> {
            intent =new Intent(MainProfile.this, UserPostDetailTwoOpt.class);
            intent.putExtra("option", "Active Posts");
            startActivity(intent);
        });

        favorites.setOnClickListener((View v) -> {
            intent = new Intent(MainProfile.this, UserPostDetail.class);
            intent.putExtra("option", "Favorites");
            startActivity(intent);
        });

        history.setOnClickListener((View v) -> {
            intent = new Intent(MainProfile.this, UserPostDetailTwoOpt.class);
            intent.putExtra("option", "History");
            startActivity(intent);
        });

        logout.setOnClickListener((View v) -> {
            intent = new Intent(MainProfile.this, MainActivity.class);
            startActivity(intent);
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
