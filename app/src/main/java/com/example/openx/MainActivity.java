package com.example.openx;

import Model.ItemData;
import Model.User;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //for creating a user profile-------------------------------------------------------------------
    // User profile, made public and static for all to access
    public static User profile;

    private ArrayList<String> tags = new ArrayList<>();
    private ArrayList<String> ticketTags = new ArrayList<>();
    private ArrayList<String> pics = new ArrayList<>();
    private ArrayList<String> ticketPics = new ArrayList<>();
    private ArrayList<ItemData> fav = new ArrayList<>();
    private ArrayList<ItemData> actBuy = new ArrayList<>();
    private ArrayList<ItemData> actSell = new ArrayList<>();
    private ArrayList<ItemData> bought = new ArrayList<>();
    private ArrayList<ItemData> sold = new ArrayList<>();

    // a dummy item
    private ItemData item;
    //----------------------------------------------------------------------------------------------



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Creating dummy profile-------------------------------------------------------------------
        // inputting dummy data to profile
        // create a item in active posts
        if (profile == null) {
            tags.add("CSE");
            pics.add("artificial_intelligence");
            item = new ItemData("furniture", "Dummy Post", "20.00", "55106", tags, pics, "I need to get rid of this. It has bed bug!", "BobTheSeller", "542");
            ItemData itemA = new ItemData("furniture", "Old Thing", "20.00", "55106", tags, pics, "I need to get rid of this. It has bed bug!", "BobTheSeller", "542");

            ArrayList<String> tagsB = new ArrayList<>(); tagsB.add("NEW");
            ArrayList<String> picsB = new ArrayList<>(); picsB.add("intro_data_mining_5523");
            ItemData itemB = new ItemData("electronic", "Used Brand New Old Book Not Joking", "1723.17", "55456", tagsB, picsB, "I need to get rid of this. It has bed bug!", "Flake_King", "0");

            ArrayList<String> tagsC = new ArrayList<>(); tagsC.add("CLA");
            ArrayList<String> picsC = new ArrayList<>(); picsC.add("java_1913_book_4e");
            ItemData itemC = new ItemData("furniture", "Java Book, Very Good Condition", "55.00", "55106", tagsC, picsC, "I need to get rid of this. It has bed bug!", "Annie_097", "1254");

            ArrayList<String> tagsD = new ArrayList<>(); tagsD.add("CEHD");
            ArrayList<String> picsD = new ArrayList<>(); picsD.add("csci_2021_used");
            ItemData itemD = new ItemData("furniture", "New Never Open!", "1.00", "55196", tagsD, picsD, "I need to get rid of this. It has bed bug!", "Tinker_Smarts", "298");
            actBuy.add(itemB);
            actSell.add(item);
            fav.add(itemD);
            actBuy.add(item);
            bought.add(itemC);
            bought.add(item);
            bought.add(item);
            bought.add(item);
            sold.add(item);
            sold.add(item);
            sold.add(item);
            sold.add(item);
            sold.add(item);
            fav.add(item);
            fav.add(item);
            fav.add(item);
            fav.add(item);
            ticketTags.add("Collegiate");
            ticketTags.add("Sporting Event");
            ticketTags.add("Football");
            ticketPics.add("mnwisco");
            ItemData ticket = new ItemData("ticket", "Gopher Football vs. Wisconsin Student Ticket",
                    "30.00", "55414", ticketTags, ticketPics, "NA", "tony_tiger", "770");
            actSell.add(ticket);

            // create the user
            profile = new User("Bobby", "shady_sam_087", "abc123", "1000", "oldschool@aol.com", "(612)911-0987", "profile_pic", fav, actSell, actBuy, bought, sold);
        }
        //-End creating dummy profile --------------------------------------------------------------

        final Button buy_button = (Button) findViewById(R.id.buy_main_activity);
        buy_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, BuyItemCategory.class));
            }
        });

        final Button sell_button = (Button) findViewById(R.id.sell_main_activity);
        sell_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SellItemCategory.class));
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
                startActivity(new Intent(MainActivity.this, MainProfile.class));
                return true;
            case R.id.homeButton:
                startActivity(new Intent(MainActivity.this, MainActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
