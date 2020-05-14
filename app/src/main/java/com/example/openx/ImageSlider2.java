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
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

public class ImageSlider2 extends AppCompatActivity {

    private Button alertButton;
    private TextView alertTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_item_view_2);

        ViewPager viewPager = findViewById(R.id.viewPager);
        ImageAdapter2 adapter = new ImageAdapter2(this);
        viewPager.setAdapter(adapter);

        alertButton = (Button) findViewById(R.id.requestSellerInfo);
        alertTextView = (TextView) findViewById(R.id.AlertTextView);

        alertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(ImageSlider2.this);
                //AlertDialog.Builder builder = new AlertDialog.Builder(ImageSlider2.this);

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
                startActivity(new Intent(ImageSlider2.this, MainProfile.class));
                return true;
            case R.id.homeButton:
                startActivity(new Intent(ImageSlider2.this, MainActivity.class));
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
