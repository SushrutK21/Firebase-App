package com.example.cgi.my_home_circle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserInfo;
import com.squareup.picasso.Picasso;

public class NetworkActivity extends Activity implements View.OnClickListener {

    // List view
    private ListView lv;
    static TextView username;
    Button toprofile;
    Button settings;

    // Listview Adapter
    ArrayAdapter<String> adapter;





    // ArrayList for Listview
    ArrayList<HashMap<String, String>> productList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network);

        String facebookUserId = "";
        String user_name = "";

        toprofile = (Button) findViewById(R.id.toprofile) ;
        toprofile.setOnClickListener(this);

        settings = (Button) findViewById(R.id.settings);
        settings.setOnClickListener(this);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        ImageView profilePicture = (ImageView) findViewById(R.id.profile_picture);

// find the Facebook profile and get the user's id
        for(UserInfo profile : user.getProviderData()) {
            // check if the provider id matches "facebook.com"
                   facebookUserId = profile.getUid();
                user_name = profile.getDisplayName();
        }


        username = (TextView) findViewById(R.id.nameofuser);
        username.setText(user_name);

// construct the URL to the profile picture, with a custom height
// alternatively, use '?type=small|medium|large' instead of ?height=
        String photoUrl = "https://graph.facebook.com/" + facebookUserId + "/picture?type=small";

// (optional) use Picasso to download and show to image
        Picasso.with(this).load(photoUrl).into(profilePicture);



        String friends[] = {"Edgar Soto",
                "Gene Fisher",
                "Tom Smith",
                "Gary Gladwell"
                };

        lv = (ListView) findViewById(R.id.list_view);

        adapter = new ArrayAdapter<String>(this, R.layout.list_item, R.id.product_name, friends);
        lv.setAdapter(adapter);

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.toprofile:
                // reference a function that would house your current onClick behavior, such as:
                Intent i = new Intent(NetworkActivity.this, MyProfileActivity.class);
                startActivity(i);
                break;

            case R.id.settings:
                // reference a function that would house your current onClick behavior, such as:
                i = new Intent(NetworkActivity.this, SettingActivity.class);
                startActivity(i);
                break;


        }
    }
}