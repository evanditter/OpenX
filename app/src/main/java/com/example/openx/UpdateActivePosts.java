package com.example.openx;

import Adapter.PostDetailAdapter;
import Model.ItemData;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;
import android.widget.AbsoluteLayout;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Scroller;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.xmlpull.v1.XmlPullParser;

import java.util.ArrayList;

public class UpdateActivePosts extends AppCompatActivity {


    Scroller activePost;
    RelativeLayout otherPost;
    ImageView upImage;
    CardView card;
    EditText title;
    EditText price;
    EditText location;
    Spinner tags;
    Bundle extras;
    int position;
    ItemData item;
    Button upPost;
    TextView dispTags;
    ArrayList<String> tagList;
    String[] textbook_tags = {"Select a Tag", "CSE", "CLA", "CBS", "CSOM", "CEHD", "CDES", "CFANS",
            "Algorithms", "Artifical Intelligence", "Data Mining", "Data Structures", "Machine Architecture",
            "Accounting", "Hardcover", "Paperback", "Required"};
    String[] ticket_tags = {"Select a Tag", "Sporting Event", "Concert", "Comedy Show", "Theater", "Football",
            "Basketball", "Hockey", "Collegiate", "Pro", "Rap", "Hip-Hop", "Pop", "Rock"};
    String[] sel_tags;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_active_posts);

        extras = getIntent().getExtras();
        position = extras.getInt("position");
        item = MainActivity.profile.getActivePostsSell().get(position);

        if (item.getCategory().compareToIgnoreCase("ticket") == 0) {
            sel_tags = ticket_tags;
        } else {
            sel_tags = textbook_tags;
        }

        // Stop scrollview from focusing (auto enter on editText) on the editText
        ScrollView view = (ScrollView)findViewById(R.id.updatescrollid);
        view.setDescendantFocusability(ViewGroup.FOCUS_BEFORE_DESCENDANTS);
        view.setFocusable(true);
        view.setFocusableInTouchMode(true);
        view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                v.requestFocusFromTouch();
                return false;
            }
        });

        upImage = findViewById(R.id.upImage);
        card = findViewById(R.id.cardView4);
        title = findViewById(R.id.editText8);
        price = findViewById(R.id.editText9);
        location = findViewById(R.id.editText10);
        tags = findViewById(R.id.upSpinner);
        upPost = findViewById(R.id.upPost);
        dispTags = findViewById(R.id.textView24);


        //Creating the ArrayAdapter instance having the ticket tags list
        ArrayAdapter aa4 = new ArrayAdapter(this,android.R.layout.simple_spinner_item, sel_tags);
        aa4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        tags.setAdapter(aa4);

        // to display the first picture
        ArrayList<String> img = item.getPictures();
        if (img.size() > 0) {
            int drawID = this.getResources().getIdentifier(img.get(0), "drawable", this.getPackageName());
            upImage.setImageResource(drawID);
        }

        title.setText(item.getTitle());
        price.setText(item.getPrice());
        location.setText(item.getLocation());

        tagList = MainActivity.profile.getActivePostsSell().get(position).getTags();
        String tagGet = "";
        for (int i = 0; i < tagList.size();i++) {
            tagGet += tagList.get(i) + " ";
        }
        dispTags.setText(tagGet);

        card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UpdateActivePosts.this, InterestedBuyers.class);
                intent.putExtra("position", position);
                startActivity(intent);
            }
        });

        upPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmDialog();
            }
        });
    }

    private void confirmDialog() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setMessage("Confirm Update");

        final AlertDialog dialog = builder.create();

        dialog.setButton(DialogInterface.BUTTON_POSITIVE, "Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                // confirm to user that changes were made
                // Update the user name
                if (title.getText().toString().compareTo("") != 0) {
                    MainActivity.profile.getActivePostsSell().get(position).setTitle(title.getText().toString());
                }

                // Update the name
                if (price.getText().toString().compareTo("") != 0) {
                    MainActivity.profile.getActivePostsSell().get(position).setPrice(price.getText().toString());
                }

                // Update the password
                if (location.getText().toString().compareTo("") != 0) {
                    MainActivity.profile.getActivePostsSell().get(position).setLocation(location.getText().toString());
                }

                // Update the tags
                if (tags.getSelectedItem().toString().compareTo("") != 0 && tags.getSelectedItem().toString().compareTo("Select a Tag") != 0) {
                    MainActivity.profile.getActivePostsSell().get(position).addTags(tags.getSelectedItem().toString());
                }

                // confirm to user that changes were made
                Toast.makeText(UpdateActivePosts.this, "UPDATED", Toast.LENGTH_LONG).show();

                finish();
                startActivity(getIntent());
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

