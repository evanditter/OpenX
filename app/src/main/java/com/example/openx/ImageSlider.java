package com.example.openx;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import Model.ItemData;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

public class ImageSlider extends AppCompatActivity {

    private Button alertButton;
    private TextView alertTextView;
    private Bundle extras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_item_view);

        ViewPager viewPager = findViewById(R.id.viewPager);
        ImageAdapter adapter = new ImageAdapter(this);
        viewPager.setAdapter(adapter);

        alertButton = (Button) findViewById(R.id.requestSellerInfo);
        alertTextView = (TextView) findViewById(R.id.AlertTextView);

        // If we came from the profile, disable the request seller info button
        extras = getIntent().getExtras();
        if (extras != null && (extras.getString("option").compareToIgnoreCase("Buying") == 0 ||
            extras.getString("option").compareToIgnoreCase("Active Posts") == 0)) {
            alertTextView.setVisibility(View.VISIBLE);
            alertButton.setVisibility(View.INVISIBLE);
        }

        alertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(ImageSlider.this);
                //AlertDialog.Builder builder = new AlertDialog.Builder(ImageSlider.this);

                builder.setCancelable(true);
                builder.setTitle("Are you sure you want to request the seller's info?");
                builder.setMessage("You will be contacted by the seller if the request is accepted.");
                final AlertDialog dialog = builder.create();

                dialog.setButton(DialogInterface.BUTTON_NEGATIVE, "NO", new DialogInterface.OnClickListener() {
                //builder.setNegativeButton(Html.fromHtml("<font color='#8BC34A'>No</font>"), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });


                dialog.setButton(DialogInterface.BUTTON_POSITIVE, "Yes", new DialogInterface.OnClickListener() {
                //builder.setPositiveButton(Html.fromHtml("<font color='#8BC34A'>Yes</font>"), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        alertTextView.setVisibility(View.VISIBLE);
                        alertButton.setVisibility(View.INVISIBLE);

                        // Collect item's data and add to the profile so we can view it later
                        ArrayList<String> tags = new ArrayList<>();
                        tags.add("USED");
                        tags.add("CSOM");
                        tags.add("Accounting");
                        ArrayList<String> pics = new ArrayList<>();
                        pics.add("acct_2050_textbook");
                        ItemData buyItem = new ItemData("book", "ACCT 2050 - Used Textbook", "20",
                                "55414", tags, pics, "Accounting 2050 - Financial Accounting\n\nLocation:" +
                                "55414\n\nCondition: Used\n\nPickup or Delivery: Both",
                                "iLuvPJFleck", "456");
                        MainActivity.profile.getActivePostsBuy().add(buyItem);
                    }
                });
                //builder.show();
                dialog.show();
                dialog.getButton(dialog.BUTTON_NEGATIVE).setVisibility(View.VISIBLE);
                dialog.getButton(dialog.BUTTON_POSITIVE).setVisibility(View.VISIBLE);
                dialog.getButton(dialog.BUTTON_NEGATIVE).setTextColor(Color.parseColor("#8BC34A"));
                dialog.getButton(dialog.BUTTON_POSITIVE).setTextColor(Color.parseColor("#8BC34A"));
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
                startActivity(new Intent(ImageSlider.this, MainProfile.class));
                return true;
            case R.id.homeButton:
                startActivity(new Intent(ImageSlider.this, MainActivity.class));
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
