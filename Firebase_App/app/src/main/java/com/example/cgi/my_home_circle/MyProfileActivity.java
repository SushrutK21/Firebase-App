package com.example.cgi.my_home_circle;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


import android.widget.EditText;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserInfo;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

/**
 * Created by CGI on 1/20/2017.
 */
public class MyProfileActivity extends AppCompatActivity implements View.OnClickListener {

    private Button back , next;
    private static EditText FirstName , LastName , ZipCode , Phonenumber , EmailID , Passwords , username;
    private User user;
    private FirebaseAuth auth;
    private FirebaseDatabase database;
    private DatabaseReference databaseRef;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myprofile);


/*
        FirstName = (EditText) findViewById(R.id.FirstName);
        LastName = (EditText) findViewById(R.id.LastName);
        ZipCode = (EditText) findViewById(R.id.zipcode);
        Phonenumber = (EditText) findViewById(R.id.phonenumber);
        EmailID = (EditText) findViewById(R.id.email);
        Passwords = (EditText) findViewById(R.id.password);

        String emailprofile = SignUp1Activity.kuhaName();
        String firstnameprofile = SignUp1Activity.FistnameString();
        String lastnameprofile = SignUp1Activity.LastNameString();
        String zipcodeprofile = SignUp2Activity.zipString();
        String phoneprofile = SignUp2Activity.phneString();
        String passwordprofile = SignUp2Activity.passwordString();

        FirstName.setText(firstnameprofile);
        LastName.setText(lastnameprofile);
        ZipCode.setText(zipcodeprofile);
        Phonenumber.setText(phoneprofile);
        EmailID.setText(emailprofile);
        Passwords.setText(passwordprofile);



//        user = new User("Native",inputEmail.getText().toString().trim(), (inputLocation.getText().toString().trim()),inputPassword.getText().toString().trim(),(inputPhone.getText().toString().trim()),"Regular",inputZip.getText().toString().trim());

        database = FirebaseDatabase.getInstance();
        databaseRef = database.getReference();



        Button back  = (Button) findViewById(R.id.button01);
        Button next  = (Button) findViewById(R.id.button02);
        back.setOnClickListener(this);
        next.setOnClickListener(this);*/




        String facebookUserId = "";
        String user_name = "";
        String user_email = "email";


        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        ImageView profilePicture = (ImageView) findViewById(R.id.account_picture);

// find the Facebook profile and get the user's id
        for(UserInfo profile : user.getProviderData()) {
            // check if the provider id matches "facebook.com"
            facebookUserId = profile.getUid();
            user_name = profile.getDisplayName();
            user_email = profile.getEmail();

        }


        username = (EditText) findViewById(R.id.FirstName);
        username.setText(user_name);

        EmailID = (EditText) findViewById(R.id.Email);
//        EmailID.setText(user_email);

// construct the URL to the profile picture, with a custom height
// alternatively, use '?type=small|medium|large' instead of ?height=
        String photoUrl = "https://graph.facebook.com/" + facebookUserId + "/picture?type=medium";

// (optional) use Picasso to download and show to image
        Picasso.with(this).load(photoUrl).into(profilePicture);



    }

    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.back:
                // reference a function that would house your current onClick behavior, such as:
                Intent i=new Intent(MyProfileActivity.this, GetReferralActivity.class);
                startActivity(i);
                break;
            case R.id.next:
                 i=new Intent(MyProfileActivity.this, MyProfileActivity.class);
                startActivity(i);

                break;
        }}


}



