package com.example.openx;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import java.util.ArrayList;

public class BuyItemCategory extends AppCompatActivity {

    String[] categories = {"Select a Category", "Tickets", "Textbooks", "Electronics", "Clothing", "Furniture"};
    String[] textbook_conditions = {"Select a Condition", "New", "Rarely Used", "Used", "Heavily Used"};
    String[] ticket_tags = {"Select a Tag", "Sporting Event", "Concert", "Comedy Show", "Theater", "Football", "Basketball", "Hockey", "Collegiate", "Pro", "Rap", "Hip-Hop", "Pop", "Rock"};
    String[] textbook_tags = {"Select a Tag", "CSE", "CLA", "CBS", "CSOM", "CEHD", "CDES", "CFANS", "Algorithms", "Artifical Intelligence", "Data Mining", "Data Structures", "Machine Architecture", "Accounting", "Hardcover", "Paperback", "Required"};
    //ArrayList<String> selected_filters = new ArrayList<String>();
    Boolean ticket = false;

    Boolean initialDisplay = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_item_category);

        //Getting the instance of Spinner and applying OnItemSelectedListener on it
        final Spinner item_categories = (Spinner) findViewById(R.id.buy_item_categories);


        //Item Title
        final EditText item_title = (EditText) findViewById(R.id.buy_item_title);
        item_title.setVisibility(View.INVISIBLE);

        //Item Price Min & Max
        final EditText price_min = (EditText) findViewById(R.id.buy_item_price_min);
        final EditText price_max = (EditText) findViewById(R.id.buy_item_price_max);
        price_min.setVisibility(View.INVISIBLE);
        price_max.setVisibility(View.INVISIBLE);

        //Item Sale Zip Code
        final EditText zip_code = (EditText) findViewById(R.id.buy_item_zip_code);
        zip_code.setVisibility(View.INVISIBLE);

        //Tickets - Event Date
        final EditText event_date = (EditText) findViewById(R.id.buy_item_event_date);
        event_date.setVisibility(View.GONE);

        //Textbooks - Condition
        final Spinner conditions = (Spinner) findViewById(R.id.buy_item_condition);
        conditions.setVisibility(View.GONE);

        //Tickets - Tags
        final Spinner tix_tags = (Spinner) findViewById(R.id.buy_item_ticket_tags);
        tix_tags.setVisibility(View.GONE);

        //Textbooks - Tags
        final Spinner txtbook_tags = (Spinner) findViewById(R.id.buy_item_textbook_tags);
        txtbook_tags.setVisibility(View.GONE);

        //Search button
        final Button search_items = (Button) findViewById(R.id.buy_item_search);
        search_items.setVisibility(View.INVISIBLE);

        //Creating the ArrayAdapter instance having the categories list
        ArrayAdapter aa1 = new ArrayAdapter(this,android.R.layout.simple_spinner_item,categories);
        aa1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        item_categories.setAdapter(aa1);

        //Creating the ArrayAdapter instance having the condition list
        ArrayAdapter aa2 = new ArrayAdapter(this,android.R.layout.simple_spinner_item,textbook_conditions);
        aa2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        conditions.setAdapter(aa2);

        //Creating the ArrayAdapter instance having the ticket tags list
        ArrayAdapter aa3 = new ArrayAdapter(this,android.R.layout.simple_spinner_item, ticket_tags);
        aa3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        tix_tags.setAdapter(aa3);

        //Creating the ArrayAdapter instance having the ticket tags list
        ArrayAdapter aa4 = new ArrayAdapter(this,android.R.layout.simple_spinner_item, textbook_tags);
        aa4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        txtbook_tags.setAdapter(aa4);

        item_categories.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (initialDisplay) {
                    initialDisplay = false;
                }
                else {
                    item_title.setVisibility(View.VISIBLE);
                    price_min.setVisibility(View.VISIBLE);
                    price_max.setVisibility(View.VISIBLE);
                    zip_code.setVisibility(View.VISIBLE);
                    if (categories[position].equals("Tickets")) { //Tickets is selected
                        //Hide all textbook things
                        conditions.setVisibility(View.GONE);
                        txtbook_tags.setVisibility(View.GONE);
                        //Display all necessary spinners for tickets
                        event_date.setVisibility(View.VISIBLE);
                        tix_tags.setVisibility(View.VISIBLE);
                        ticket = true;
                    }
                    if (categories[position].equals("Textbooks")) { //Textbook is selected
                        //Hide all ticket things
                        event_date.setVisibility(View.GONE);
                        tix_tags.setVisibility((View.GONE));
                        //Display all necessary spinners for textbooks
                        conditions.setVisibility(View.VISIBLE);
                        txtbook_tags.setVisibility(View.VISIBLE);
                    }

                    search_items.setVisibility(View.VISIBLE);
                    search_items.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent tag_intent = new Intent(BuyItemCategory.this, BuyCardView.class);
                            tag_intent.putExtra("category", item_categories.getSelectedItem().toString());
                            tag_intent.putExtra("title", item_title.getText().toString());
                            tag_intent.putExtra("price_min", price_min.getText().toString());
                            tag_intent.putExtra("price_max", price_max.getText().toString());
                            tag_intent.putExtra("zip_code", zip_code.getText().toString());
                            if(ticket) {
                                tag_intent.putExtra("event_date", event_date.getText().toString());
                                tag_intent.putExtra("ticket_tags", tix_tags.getSelectedItem().toString());
                            }
                            else {
                                tag_intent.putExtra("condition", conditions.getSelectedItem().toString());
                                tag_intent.putExtra("textbook_tags", txtbook_tags.getSelectedItem().toString());
                            }
                            startActivity(tag_intent);
                        }
                    });
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }

        });


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.user_profile:
                startActivity(new Intent(BuyItemCategory.this, MainProfile.class));
                return true;
            case R.id.homeButton:
                startActivity(new Intent(BuyItemCategory.this, MainActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}
