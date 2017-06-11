package com.example.cgi.my_home_circle;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserInfo;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

/**
 * Created by CGI on 1/20/2017.
 */
public class ProductDetail extends AppCompatActivity implements View.OnClickListener {

    private Button back , ThumbsUp , ThumbsDown;

    private RatingBar rb1 , rb2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.productdetail);
        back = (Button)findViewById(R.id.back) ;


        ThumbsUp  = (Button) findViewById(R.id.ThumbsUp);
        ThumbsDown  = (Button) findViewById(R.id.ThumbsDown);
        back.setOnClickListener(this);
        ThumbsUp.setOnClickListener(this);
        ThumbsDown.setOnClickListener(this);

        rb1=(RatingBar)findViewById(R.id.MyRating);
        rb2=(RatingBar)findViewById(R.id.ratingBar);

        rb1.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener(){

            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating,
                                        boolean fromUser) {
                // TODO Auto-generated method stub
                Toast.makeText(getApplicationContext(),Float.toString(rating),Toast.LENGTH_LONG).show();

            }

        });

        rb2.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener(){

            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating,
                                        boolean fromUser) {
                // TODO Auto-generated method stub
                Toast.makeText(getApplicationContext(),Float.toString(rating),Toast.LENGTH_LONG).show();

            }

        });
    }




    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.back:
                // reference a function that would house your current onClick behavior, such as:
                Intent i=new Intent(ProductDetail.this, ReferralActivity.class);
                startActivity(i);
                break;
            case R.id.ThumbsUp:
                i=new Intent(ProductDetail.this, CompleteReferral.class);
                startActivity(i);
                break;

            case R.id.ThumbsDown:
                i=new Intent(ProductDetail.this, CompleteReferral.class);
                startActivity(i);
                break;
        }}


}



