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

public class FilterBuy extends AppCompatActivity {

    String[] categories = {"Select a Category", "Tickets", "Textbooks", "Electronics", "Clothing", "Furniture"};
    String[] textbook_conditions = {"Select a Condition", "New", "Rarely Used", "Used", "Heavily Used"};
    String[] ticket_tags = {"Select a Tag", "Sporting Event", "Concert", "Comedy Show", "Theater", "Football", "Basketball", "Hockey", "Collegiate", "Pro", "Rap", "Hip-Hop", "Pop", "Rock"};
    String[] textbook_tags = {"Select a Tag", "CSE", "CLA", "CBS", "CSOM", "CEHD", "CDES", "CFANS", "Algorithms", "Artifical Intelligence", "Data Mining", "Data Structures", "Machine Architecture", "Accounting", "Hardcover", "Paperback", "Required"};
    //ArrayList<String> selected_filters = new ArrayList<String>();
    Boolean ticket = false;
    String price_max_;
    String price_min_;
    String location;
    String filter_category;
    String event_date_;
    String ticket_tag;
    String book_condition;
    String textbook_tag;
    String title;

    private Button filter_items;

    Boolean initialDisplay = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter_buy);

        Intent iin = getIntent();
        Bundle extras = iin.getExtras();

        if (extras != null) {
            System.out.println("EXTRAS NOT NULL IN FILTER BUY");
            price_max_ = extras.getString("price_max");
            price_min_ = extras.getString("price_min");
            location = extras.getString("zip_code");
            filter_category = extras.getString("category");
            event_date_ = extras.getString("event_date");
            ticket_tag = extras.getString("ticket_tags");
            book_condition = extras.getString("condition");
            textbook_tag = extras.getString("textbook_tags");
            title = extras.getString("title");

            //Getting the instance of Spinner and applying OnItemSelectedListener on it
            final Spinner item_categories = (Spinner) findViewById(R.id.buy_filter_categories);


            //Item Title
            final EditText item_title = (EditText) findViewById(R.id.buy_filter_title);
//            item_title.setVisibility(View.INVISIBLE);

            //Item Price Min & Max
            final EditText price_min = (EditText) findViewById(R.id.buy_filter_price_min);
            final EditText price_max = (EditText) findViewById(R.id.buy_filter_price_max);
            if(price_min_ != null && !price_min_.equals("")){
                price_min.setText(price_min_);
            }
            if(price_max_ != null && !price_max_.equals("")){
                price_max.setText(price_max_);
            }
//            price_min.setVisibility(View.INVISIBLE);
//            price_max.setVisibility(View.INVISIBLE);

            //Item Sale Zip Code
            final EditText zip_code = (EditText) findViewById(R.id.buy_filter_zip_code);
            if(location != null && !location.equals("")){
                zip_code.setText(location);
            }
//            zip_code.setVisibility(View.INVISIBLE);

            //Tickets - Event Date
            final EditText event_date = (EditText) findViewById(R.id.buy_filter_event_date);
            if(event_date_ != null && !event_date_.equals("")){
                event_date.setText(event_date_);
            }
            if(filter_category.equals("Tickets")) {
            }else{ event_date.setVisibility(View.GONE);
            }

            //Textbooks - Condition
            final Spinner conditions = (Spinner) findViewById(R.id.buy_filter_condition);
            if(filter_category.equals("Textbooks")) {
            }else{ conditions.setVisibility(View.GONE);
            }

            //Tickets - Tags
            final Spinner tix_tags = (Spinner) findViewById(R.id.buy_filter_ticket_tags);
            if(filter_category.equals("Tickets")) {
            }else{ tix_tags.setVisibility(View.GONE);
            }
            final Spinner tix_tags2 = (Spinner) findViewById(R.id.buy_filter_ticket_tags2);
            if(filter_category.equals("Tickets")) {
            }else{ tix_tags2.setVisibility(View.GONE);
            }
            final Spinner tix_tags3 = (Spinner) findViewById(R.id.buy_filter_ticket_tags3);
            if(filter_category.equals("Tickets")) {
            }else{ tix_tags3.setVisibility(View.GONE);
            }

            //Textbooks - Tags
            final Spinner txtbook_tags = (Spinner) findViewById(R.id.buy_filter_textbook_tags);
            if(filter_category.equals("Textbooks")) {
            }else{ txtbook_tags.setVisibility(View.GONE);
            }
            final Spinner txtbook_tags2 = (Spinner) findViewById(R.id.buy_filter_textbook_tags2);
            if(filter_category.equals("Textbooks")) {
            }else{ txtbook_tags2.setVisibility(View.GONE);
            }
            final Spinner txtbook_tags3 = (Spinner) findViewById(R.id.buy_filter_textbook_tags3);
            if(filter_category.equals("Textbooks")) {
            }else{ txtbook_tags3.setVisibility(View.GONE);
            }

            //Search button
            filter_items = (Button) findViewById(R.id.buy_filter_search);
            //filter_items.setClickable(true);
            //filter_items.setVisibility(View.INVISIBLE);

            //Creating the ArrayAdapter instance having the categories list
            ArrayAdapter aa1 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, categories);
            aa1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            //Setting the ArrayAdapter data on the Spinner
            item_categories.setAdapter(aa1);
            if(filter_category != null){
                int spinposition = aa1.getPosition(filter_category);
                item_categories.setSelection(spinposition);
            }

            //Creating the ArrayAdapter instance having the condition list
            ArrayAdapter aa2 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, textbook_conditions);
            aa2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            //Setting the ArrayAdapter data on the Spinner
            conditions.setAdapter(aa2);
            if(book_condition != null && filter_category.equals("Textbooks")){
                int spinposition = aa2.getPosition(book_condition);
                conditions.setSelection(spinposition);
            }

            //Creating the ArrayAdapter instance having the ticket tags list
            ArrayAdapter aa3 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, ticket_tags);
            aa3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            //Setting the ArrayAdapter data on the Spinner
            tix_tags.setAdapter(aa3);
            if(ticket_tag != null && filter_category.equals("Tickets")){
                int spinposition = aa3.getPosition(ticket_tag);
                tix_tags.setSelection(spinposition);
            }

            ArrayAdapter aa4 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, ticket_tags);
            aa4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            tix_tags2.setAdapter(aa4);

            ArrayAdapter aa5 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, ticket_tags);
            aa5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            tix_tags3.setAdapter(aa5);

            //Creating the ArrayAdapter instance having the ticket tags list
            ArrayAdapter aa6 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, textbook_tags);
            aa6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            //Setting the ArrayAdapter data on the Spinner
            txtbook_tags.setAdapter(aa6);
            if(textbook_tag != null && filter_category.equals("Textbooks")){
                int spinposition = aa6.getPosition(textbook_tag);
                txtbook_tags.setSelection(spinposition);
            }

            //Creating the ArrayAdapter instance having the textbook tags list 2
            ArrayAdapter aa7 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, textbook_tags);
            aa7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            txtbook_tags2.setAdapter(aa7);

            //Creating the ArrayAdapter instance having the textbook tags list 3
            ArrayAdapter aa8 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, textbook_tags);
            aa8.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            txtbook_tags3.setAdapter(aa8);

            item_categories.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    if (!initialDisplay) {
                        initialDisplay = false;
                    } else {
                        item_title.setVisibility(View.VISIBLE);
                        price_min.setVisibility(View.VISIBLE);
                        price_max.setVisibility(View.VISIBLE);
                        zip_code.setVisibility(View.VISIBLE);
                        if (filter_category.equals("Tickets")) { //Tickets is selected
                            //Hide all textbook things
                            conditions.setVisibility(View.GONE);
                            txtbook_tags.setVisibility(View.GONE);
                            txtbook_tags2.setVisibility(View.GONE);
                            txtbook_tags3.setVisibility(View.GONE);
                            //Display all necessary spinners for tickets
                            event_date.setVisibility(View.VISIBLE);
                            tix_tags.setVisibility(View.VISIBLE);
                            tix_tags2.setVisibility(View.VISIBLE);
                            tix_tags3.setVisibility(View.VISIBLE);
                            ticket = true;
                        }
                        if (filter_category.equals("Textbooks")) { //Textbook is selected
                            //Hide all ticket things
                            event_date.setVisibility(View.GONE);
                            tix_tags.setVisibility((View.GONE));
                            tix_tags2.setVisibility(View.GONE);
                            tix_tags3.setVisibility(View.GONE);
                            //Display all necessary spinners for textbooks
                            conditions.setVisibility(View.VISIBLE);
                            txtbook_tags.setVisibility(View.VISIBLE);
                            txtbook_tags2.setVisibility(View.VISIBLE);
                            txtbook_tags3.setVisibility(View.VISIBLE);
                        }

                        filter_items.setVisibility(View.VISIBLE);
                        filter_items.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                String[] txtbook_tag_list = {txtbook_tags.getSelectedItem().toString(),
                                        txtbook_tags2.getSelectedItem().toString(),
                                        txtbook_tags3.getSelectedItem().toString()};

                                String[] ticket_tag_list = {tix_tags.getSelectedItem().toString(),
                                        tix_tags2.getSelectedItem().toString(),
                                        tix_tags3.getSelectedItem().toString()};
                                System.out.println("in filter buy printing txtbook tags");
                                System.out.println(txtbook_tag_list[0]);
                                System.out.println(txtbook_tag_list[1]);
                                System.out.println(txtbook_tag_list[2]);
                                Intent filter_intent = new Intent(FilterBuy.this, BuyCardView.class);
                                filter_intent.putExtra("category", item_categories.getSelectedItem().toString());
                                filter_intent.putExtra("title", item_title.getText().toString());
                                filter_intent.putExtra("price_min", price_min.getText().toString());
                                filter_intent.putExtra("price_max", price_max.getText().toString());
                                filter_intent.putExtra("zip_code", zip_code.getText().toString());
                                if (ticket) {
                                    filter_intent.putExtra("event_date", event_date.getText().toString());
                                    filter_intent.putExtra("ticket_tags_list", ticket_tag_list);
                                    filter_intent.putExtra("ticket_tags", tix_tags.getSelectedItem().toString());
                                } else {
                                    filter_intent.putExtra("condition", conditions.getSelectedItem().toString());
                                    filter_intent.putExtra("textbook_tags", txtbook_tags.getSelectedItem().toString());
                                    // System.out.println(txtbook_tag_list);
                                    filter_intent.putExtra("textbook_tags_list", txtbook_tag_list);
                                }
                                startActivity(filter_intent);
                                //finish();
                            }
                        });
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }

            });


        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.user_profile:
                startActivity(new Intent(FilterBuy.this, MainProfile.class));
                return true;
            case R.id.homeButton:
                startActivity(new Intent(FilterBuy.this, MainActivity.class));
                return true;
//            case R.id.filterButton:
//                startActivity(new Intent(FilterBuy.this, FilterBuy.class));
//                return true;
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
