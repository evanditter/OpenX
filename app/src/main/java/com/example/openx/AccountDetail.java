package com.example.openx;

import Model.User;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;


public class AccountDetail extends AppCompatActivity {

    private EditText username;      // username
    private ImageView userIcon;     // user's profile pic
    private EditText name;          // name of the user
    private EditText password;      // password of the user
    private EditText phoneNum;      // number of the user
    private EditText email;         // email of the user
    private TextView points;        // total points of the user





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_detail);

        // Stop scrollview from focusing (auto enter on editText) on the editText
        ScrollView view = (ScrollView)findViewById(R.id.scrollView);
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


        username = (EditText) findViewById(R.id.usernameID);
        userIcon = (ImageView) findViewById(R.id.profile_icon_id);
        name = (EditText) findViewById(R.id.nameID);
        password = (EditText) findViewById(R.id.passwordID);
        phoneNum = (EditText) findViewById(R.id.phoneNumID);
        email = (EditText) findViewById(R.id.emailID);
        points = (TextView) findViewById(R.id.pointsID);

        // display username
        if (MainActivity.profile.getUsername() != null) {
            username.setHint(MainActivity.profile.getUsername());
        }

        // display user's profile pic
        if (MainActivity.profile.getProfilePic() != null) {
            String iconName = MainActivity.profile.getProfilePic();

            // Convert string of img into drawable ID
            int drawID = getResources().getIdentifier(iconName, "drawable", getPackageName());
            userIcon.setImageResource(drawID);

        }

        // display to screen
        if (MainActivity.profile.getName() != null) {
            name.setHint(MainActivity.profile.getName());
        }

        if (MainActivity.profile.getPassword() != null) {
            password.setHint(MainActivity.profile.getPassword());
        }

        if (MainActivity.profile.getPhone() != null) {
            phoneNum.setHint(MainActivity.profile.getPhone());
        }

        if (MainActivity.profile.getEmail() != null) {
            email.setHint(MainActivity.profile.getEmail());
        }

        if (MainActivity.profile.getPoints() != null) {
            points.setText(MainActivity.profile.getPoints());
        }

        // update button, saves changes
        final Button update_button = (Button) findViewById(R.id.updateButtonID);
        update_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmDialog();

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
                startActivity(new Intent(this, MainProfile.class));
                return true;
            case R.id.homeButton:
                startActivity(new Intent(this, MainActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void confirmDialog() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setMessage("Confirm Update");

        final AlertDialog dialog = builder.create();

        dialog.setButton(DialogInterface.BUTTON_POSITIVE, "Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                // Update the user name
                if (username.getText().toString().compareTo("") != 0) {
                    MainActivity.profile.setUsername(username.getText().toString());
                }

                // Update the name
                if (name.getText().toString().compareTo("") != 0) {
                    MainActivity.profile.setName(name.getText().toString());
                }

                // Update the password
                if (password.getText().toString().compareTo("") != 0) {
                    MainActivity.profile.setPassword(password.getText().toString());
                }

                // Update the phonenum
                if (phoneNum.getText().toString().compareTo("") != 0) {
                    MainActivity.profile.setPhone(phoneNum.getText().toString());
                }

                // Update the email
                if (email.getText().toString().compareTo("") != 0) {
                    MainActivity.profile.setEmail(email.getText().toString());
                }

                // confirm to user that changes were made
                Toast.makeText(AccountDetail.this, "UPDATED", Toast.LENGTH_LONG).show();

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
}
