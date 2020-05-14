package com.example.openx;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class BuyCardView extends AppCompatActivity {
    private int id;
    private String itemTitle;
    List<List<String>> textbookTagLists = new ArrayList<>();
    List<List<String>> ticketTagLists = new ArrayList<>();
    List<String> tagList = new ArrayList<>();
    private int price;
    private int image;
    private int zipCode;
    private String itemCategory;

    public BuyCardView(){
    }

    public BuyCardView(int id, String itemTitle, int price, int image, List<String> tagList, int zipCode, String itemCategory) {
        this.id = id;
        this.itemTitle = itemTitle;
        this.price = price;
        this.image = image;
        this.tagList = tagList;
        this.zipCode = zipCode;
        this.itemCategory = itemCategory;
    }

    public int getId() {
        return id;
    }

    public String getitemTitle() {
        return itemTitle;
    }

    public int getPrice() { return price; }

    public String printPrice() { return "Price: $" + price; }

    public int getImage() {
        return image;
    }

    public List<List<String>> getTextbookTagLists() { return textbookTagLists; }

    public String printTextbookTagLists() { return "Tags: " + textbookTagLists; }

    public List<List<String>> getTicketTagLists() { return ticketTagLists; }

    public String printTicketTagLists() { return "Tags: " + ticketTagLists; }

    public List<String> getTagList() { return tagList; }
    public String printTagList() { return "Tags: " + tagList; }

    //a list to store all the products
    List<BuyCardView> buyCardList;

    //the recyclerview
    RecyclerView recyclerView;

    String price_max;
    String price_min;
    String location;
    String filter_category;
    String event_date;
    String ticket_tags;
    String book_condition;
    String textbook_tags;
    String title;
    String[] textbook_tags_list;
    String[] ticket_tags_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_card_view);

        Button filter_items = (Button) findViewById(R.id.filterButtonBuyCardView);
        //filter_items.setVisibility(View.INVISIBLE);

        Intent iin = getIntent();
        Bundle extras = iin.getExtras();

        if(extras != null) {
            price_max = extras.getString("price_max");
            price_min = extras.getString("price_min");
            location = extras.getString("zip_code");
            filter_category = extras.getString("category");
            event_date = extras.getString("event_date");
            ticket_tags = extras.getString("ticket_tags");
            book_condition = extras.getString("condition");
            textbook_tags = extras.getString("textbook_tags");
            title = extras.getString("title");
            textbook_tags_list = extras.getStringArray("textbook_tags_list");
            ticket_tags_list = extras.getStringArray("ticket_tags_list");

            //getting the recyclerview from xml
            recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            //initializing the buyCardList
            buyCardList = new ArrayList<>();

            List<String> tagList0 = Arrays.asList("Algorithms", "CSE", "CLA", "Used");
            textbookTagLists.add(tagList0);
            List<String> tagList1 = Arrays.asList("Accounting", "CSOM", "Used");
            textbookTagLists.add(tagList1);
            List<String> tagList2 = Arrays.asList("Algorithms", "CSE", "CLA", "Rarily Used");
            textbookTagLists.add(tagList2);
            List<String> tagList3 = Arrays.asList("Artificial Intelligence", "CSE", "Used");
            textbookTagLists.add(tagList3);
            List<String> tagList4 = Arrays.asList("Machine Architecture", "CSE", "CLA", "Used");
            textbookTagLists.add(tagList4);
            List<String> tagList5 = Arrays.asList("Data Mining", "CSE", "New");
            textbookTagLists.add(tagList5);
            List<String> tagList6 = Arrays.asList("Algorithms", "Data Structures", "CSE", "CLA", "Used");
            textbookTagLists.add(tagList6);
            List<String> tagList7 = Arrays.asList("Algorithms", "Data Structures", "CSE", "CLA", "New");
            textbookTagLists.add(tagList7);
            List<String> tagList8 = Arrays.asList("Accounting", "CSOM", "Rarely Used");
            textbookTagLists.add(tagList8);
            List<String> tagList9 = Arrays.asList("Algorithms", "CSE", "CLA", "Used");
            textbookTagLists.add(tagList9);

            List<String> tagList10 = Arrays.asList("Football", "Sporting Event", "Collegiate");
            ticketTagLists.add(tagList10);
            List<String> tagList11 = Arrays.asList("Football", "Sporting Event", "Pro");
            ticketTagLists.add(tagList11);
            List<String> tagList12 = Arrays.asList("Theater");
            ticketTagLists.add(tagList12);
            List<String> tagList13 = Arrays.asList("Hip-Hop", "Concert", "Collegiate");
            ticketTagLists.add(tagList13);
            List<String> tagList14 = Arrays.asList("Comedy Show", "Theater");
            ticketTagLists.add(tagList14);
            List<String> tagList15 = Arrays.asList("Hockey", "Sporting Event", "Collegiate");
            ticketTagLists.add(tagList15);
            List<String> tagList16 = Arrays.asList("Rap", "Concert");
            ticketTagLists.add(tagList16);
            List<String> tagList17 = Arrays.asList("Football", "Sporting Event", "Collegiate");
            ticketTagLists.add(tagList17);
            List<String> tagList18 = Arrays.asList("Hockey", "Sporting Event", "Pro");
            ticketTagLists.add(tagList18);
            List<String> tagList19 = Arrays.asList("Pop", "Concert");
            ticketTagLists.add(tagList19);
            List<String> tagList20 = Arrays.asList("Football", "Sporting Event", "Collegiate");
            ticketTagLists.add(tagList20);
            List<String> tagList21 = Arrays.asList("Pop", "Concert");
            ticketTagLists.add(tagList21);
            List<String> tagList22 = Arrays.asList("Hockey", "Sporting Event", "Collegiate");
            ticketTagLists.add(tagList22);
            List<String> tagList23 = Arrays.asList("Basketball", "Sporting Event", "Collegiate");
            ticketTagLists.add(tagList23);
            List<String> tagList24 = Arrays.asList("Basketball", "Sporting Event", "Collegiate");
            ticketTagLists.add(tagList24);
            List<String> tagList25 = Arrays.asList("Basketball", "Sporting Event", "Pro");
            ticketTagLists.add(tagList25);

            //adding some items to our list
            buyCardList.add(
                    new BuyCardView(
                            1,
                            "Used Intro to Algorithms 3rd E - CSCI 4041",
                            50,
                            R.drawable.algs_used_back,
                            textbookTagLists.get(0),
                            55455,
                            "Textbooks"));

            buyCardList.add(
                    new BuyCardView(
                            2,
                            "ACCT 2050 - Used Textbook",
                            20,
                            R.drawable.acct_2050_textbook,
                            textbookTagLists.get(1),
                            55414,
                            "Textbooks"));

            buyCardList.add(
                    new BuyCardView(
                            3,
                            "CSCI 4041 - Introduction to Algorithms 3rd Edition",
                            40,
                            R.drawable.algorithms_used,
                            textbookTagLists.get(2),
                            55455,
                            "Textbooks"));

            buyCardList.add(
                    new BuyCardView(
                            4,
                            "Introduction to Artificial Intelligence - CSCI 4511W - Used",
                            40,
                            R.drawable.artificial_intelligence_used_front,
                            textbookTagLists.get(3),
                            55414,
                            "Textbooks"));

            buyCardList.add(
                    new BuyCardView(
                            5,
                            "Machine Architecture - CSCI 2021",
                            30,
                            R.drawable.csci_2021_used,
                            textbookTagLists.get(4),
                            55414,
                            "Textbooks"));

            buyCardList.add(
                    new BuyCardView(
                            6,
                            "Introduction to Data Mining - CSCI 5523 (Used)",
                            25,
                            R.drawable.intro_data_mining_5523,
                            textbookTagLists.get(5),
                            55414,
                            "Textbooks"));

            buyCardList.add(
                    new BuyCardView(
                            7,
                            "Intro to Algs & Data Structures (CSCI 1913)",
                            25,
                            R.drawable.java_textbook_used_pic,
                            textbookTagLists.get(6),
                            55414,
                            "Textbooks"));

            buyCardList.add(
                    new BuyCardView(
                            8,
                            "Intro to Algorithms and Data Structures 4th Edition(CSCI 1913)",
                            25,
                            R.drawable.java_1913_book_4e,
                            textbookTagLists.get(7),
                            55455,
                            "Textbooks"));

            buyCardList.add(
                    new BuyCardView(
                            9,
                            "Used ACCT 2050 book",
                            25,
                            R.drawable.used_acct_2050_book,
                            textbookTagLists.get(8),
                            55455,
                            "Textbooks"));

            buyCardList.add(
                    new BuyCardView(
                            10,
                            "USED - Introduction to Algorithms (CSCI 4041)",
                            25,
                            R.drawable.algorithms_used,
                            textbookTagLists.get(9),
                            55414,
                            "Textbooks"));

            buyCardList.add(
                    new BuyCardView(
                            11,
                            "Gopher Football vs. Wisconsin Student Ticket",
                            30,
                            R.drawable.ticket_icon,
                            ticketTagLists.get(0),
                            55414,
                            "Tickets"));

            buyCardList.add(
                    new BuyCardView(
                            12,
                            "Vikings vs. Packers 12/29 (2nd Deck)",
                            75,
                            R.drawable.ticket_icon,
                            ticketTagLists.get(1),
                            55414,
                            "Tickets"));

            buyCardList.add(
                    new BuyCardView(
                            13,
                            "Hamilton",
                            125,
                            R.drawable.ticket_icon,
                            ticketTagLists.get(2),
                            55414,
                            "Tickets"));

            buyCardList.add(
                    new BuyCardView(
                            14,
                            "Post Malone Concert",
                            155,
                            R.drawable.ticket_icon,
                            ticketTagLists.get(3),
                            55414,
                            "Tickets"));

            buyCardList.add(
                    new BuyCardView(
                            15,
                            "Cody Ko & Noel Miller (2x)",
                            100,
                            R.drawable.ticket_icon,
                            ticketTagLists.get(4),
                            55414,
                            "Tickets"));

            buyCardList.add(
                    new BuyCardView(
                            16,
                            "Gopher Hockey vs. Wisconsin",
                            25,
                            R.drawable.ticket_icon,
                            ticketTagLists.get(5),
                            55414,
                            "Tickets"));

            buyCardList.add(
                    new BuyCardView(
                            17,
                            "Lil Wayne Concert (2x)",
                            200,
                            R.drawable.ticket_icon,
                            ticketTagLists.get(6),
                            55414,
                            "Tickets"));

            buyCardList.add(
                    new BuyCardView(
                            18,
                            "Gopher Football vs. Wisconsin",
                            35,
                            R.drawable.ticket_icon,
                            ticketTagLists.get(7),
                            55414,
                            "Tickets"));

            buyCardList.add(
                    new BuyCardView(
                            19,
                            "Wild vs. Dallas 12/1 (2x)",
                            130,
                            R.drawable.ticket_icon,
                            ticketTagLists.get(8),
                            55455,
                            "Tickets"));

            buyCardList.add(
                    new BuyCardView(
                            20,
                            "Ariana Grande Concert",
                            125,
                            R.drawable.ticket_icon,
                            ticketTagLists.get(9),
                            55414,
                            "Tickets"));

            buyCardList.add(
                    new BuyCardView(
                            21,
                            "Gopher Football vs. Wisconsin",
                            40,
                            R.drawable.ticket_icon,
                            ticketTagLists.get(10),
                            55414,
                            "Tickets"));

            buyCardList.add(
                    new BuyCardView(
                            22,
                            "Ariana Grande Concert",
                            135,
                            R.drawable.ticket_icon,
                            ticketTagLists.get(11),
                            55455,
                            "Tickets"));

            buyCardList.add(
                    new BuyCardView(
                            23,
                            "Gophers vs. Badgers Hockey",
                            20,
                            R.drawable.ticket_icon,
                            ticketTagLists.get(12),
                            55455,
                            "Tickets"));

            buyCardList.add(
                    new BuyCardView(
                            23,
                            "Gophers vs. Badgers Basketball (2x)",
                            40,
                            R.drawable.ticket_icon,
                            ticketTagLists.get(13),
                            55455,
                            "Tickets"));

            buyCardList.add(
                    new BuyCardView(
                            24,
                            "Gophers vs. Iowa Basketball",
                            15,
                            R.drawable.ticket_icon,
                            ticketTagLists.get(14),
                            55455,
                            "Tickets"));

            buyCardList.add(
                    new BuyCardView(
                            25,
                            "Timberwolves vs. Lakers Basketball (2x)",
                            80,
                            R.drawable.ticket_icon,
                            ticketTagLists.get(15),
                            55455,
                            "Tickets"));

            if (price_max != null && !price_max.equals("")) {
                buyCardList.removeIf((BuyCardView n) -> n.price > Integer.parseInt(price_max));
            }
            if (location != null && !location.equals("")) {
                buyCardList.removeIf((BuyCardView n) -> n.zipCode != Integer.parseInt(location));
            }
            if (filter_category != null && !filter_category.equals("")) {
                buyCardList.removeIf((BuyCardView n) -> !(n.itemCategory.equals(filter_category)));

                if (filter_category.equals("Tickets") && ticket_tags != null && !ticket_tags.equals("")) {
                    if (!ticket_tags.equals("Select a Tag")) {
                        buyCardList.removeIf((BuyCardView n) -> !(n.tagList.contains(ticket_tags)));
                    }
                }
                if (filter_category.equals("Tickets") && ticket_tags_list != null && !ticket_tags_list.equals("")) {
                    if (!ticket_tags_list[0].equals("Select a Tag")) {
                        buyCardList.removeIf((BuyCardView n) -> !(n.tagList.contains(ticket_tags_list[0])));
                    }
                    if (!ticket_tags_list[1].equals("Select a Tag")) {
                        buyCardList.removeIf((BuyCardView n) -> !(n.tagList.contains(ticket_tags_list[1])));
                    }
                    if (!ticket_tags_list[2].equals("Select a Tag")) {
                        buyCardList.removeIf((BuyCardView n) -> !(n.tagList.contains(ticket_tags_list[2])));
                    }
                }
                if (filter_category.equals("Textbooks") && book_condition != null && !book_condition.equals("")) {
                    if (!book_condition.equals("Select a Condition")) {
                        buyCardList.removeIf((BuyCardView n) -> !(n.tagList.contains(book_condition)));
                    }
                }
                if (filter_category.equals("Textbooks") && textbook_tags != null && !textbook_tags.equals("")) {
                    if (!textbook_tags.equals("Select a Tag")) {
                        buyCardList.removeIf((BuyCardView n) -> !(n.tagList.contains(textbook_tags)));
                    }
                }
                if (filter_category.equals("Textbooks") && textbook_tags_list != null && !textbook_tags_list.equals("")) {
                    if (!textbook_tags_list[0].equals("Select a Tag")) {
                        System.out.println("in removing textbook tags");
                        System.out.println(textbook_tags_list[0]);
                        System.out.println(textbook_tags_list[1]);
                        System.out.println(textbook_tags_list[2]);
                        buyCardList.removeIf((BuyCardView n) -> !(n.tagList.contains(textbook_tags_list[0])));
                    } if (!textbook_tags_list[1].equals("Select a Tag")){
                        buyCardList.removeIf((BuyCardView n) -> !(n.tagList.contains(textbook_tags_list[1])));
                    } if (!textbook_tags_list[2].equals("Select a Tag")){
                        buyCardList.removeIf((BuyCardView n) -> !(n.tagList.contains(textbook_tags_list[2])));
                    }
                }
            }

            BuyCardViewAdapter adapter = new BuyCardViewAdapter(this, buyCardList);

            //setting adapter to recyclerview
            recyclerView.setAdapter(adapter);


            filter_items.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent tag_intent = new Intent(BuyCardView.this, FilterBuy.class);
                    tag_intent.putExtra("category", filter_category);
                    tag_intent.putExtra("title", title);
                    tag_intent.putExtra("price_max", price_max);
                    tag_intent.putExtra("price_min", price_min);
                    tag_intent.putExtra("zip_code", location);
                    if (filter_category.equals("Tickets")) {
                        tag_intent.putExtra("event_date", event_date);
                        tag_intent.putExtra("ticket_tags", ticket_tags);
                    } else {
                        tag_intent.putExtra("condition", book_condition);
                        tag_intent.putExtra("textbook_tags", textbook_tags);
                    }

                    startActivity(tag_intent);
                    finish();
                }
            });

        }
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
                startActivity(new Intent(BuyCardView.this, MainProfile.class));
                return true;
            case R.id.homeButton:
                startActivity(new Intent(BuyCardView.this, MainActivity.class));
                return true;
//            case R.id.filterButton:
//                startActivity(new Intent(BuyCardView.this, FilterBuy.class));
//                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}

