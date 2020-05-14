package com.example.openx;

import Model.ItemData;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class InterestedBuyers extends AppCompatActivity {


    Bundle extras;
    int position;
    ItemData item;
    ImageView buyerPic;
    TextView usernameBuyers;
    Button sendContact;
    TextView pointID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interested_buyers);

        extras = getIntent().getExtras();
        position = extras.getInt("position");
        item = MainActivity.profile.getActivePostsSell().get(position);

        buyerPic = findViewById(R.id.buyerPic);
        usernameBuyers = findViewById(R.id.usernameBuyers);
        sendContact = findViewById(R.id.sendcontact);
        pointID = findViewById(R.id.pointID);

        buyerPic.setImageResource(R.drawable.profile_pic_one);
        usernameBuyers.setText("Max_907");
        pointID.setText("5674");


        sendContact.setBackgroundColor(Color.parseColor("#8BC34A"));

        sendContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                confirmDialog();
            }
        });





    }

    private void confirmDialog() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(InterestedBuyers.this);
        builder.setCancelable(false);
        builder.setMessage("Confirm Sending Contact");

        final AlertDialog dialog = builder.create();

        dialog.setButton(DialogInterface.BUTTON_POSITIVE, "Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                // confirm to user that changes were made
                Toast.makeText(InterestedBuyers.this, "Contact Sent", Toast.LENGTH_LONG).show();
                sendContact.setText("Contact Sent");
                sendContact.setBackgroundColor(Color.parseColor("gray"));
                //dialog.dismiss();
            }
        });
        dialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialog.dismiss();
            }
        });
        dialog.show();
        dialog.getButton(dialog.BUTTON_NEGATIVE).setVisibility(View.VISIBLE);
        dialog.getButton(dialog.BUTTON_POSITIVE).setVisibility(View.VISIBLE);
        dialog.getButton(dialog.BUTTON_NEGATIVE).setTextColor(Color.parseColor("#0000ff"));
        dialog.getButton(dialog.BUTTON_POSITIVE).setTextColor(Color.parseColor("#0000ff"));

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
