package com.example.cgi.my_home_circle;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;



import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.jar.Attributes;

/**
 * Created by CGI on 1/20/2017.
 */
public class SignUp1Activity extends AppCompatActivity implements View.OnClickListener {

    private Button back , next;
    private static EditText inputPassword=null , inputZip=null , inputPhone=null, ConfirmPassword=null, inputEmail , inputName , inputSirname , inputLocation=null;
    private User user;
    private FirebaseAuth auth;
    private FirebaseDatabase database;
    private DatabaseReference databaseRef;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup1);


        inputEmail = (EditText) findViewById(R.id.Email);
        inputName = (EditText) findViewById(R.id.Name);
        inputSirname = (EditText) findViewById(R.id.Sirname);




//        user = new User("Native",inputEmail.getText().toString().trim(), (inputLocation.getText().toString().trim()),inputPassword.getText().toString().trim(),(inputPhone.getText().toString().trim()),"Regular",inputZip.getText().toString().trim());

        database = FirebaseDatabase.getInstance();
        databaseRef = database.getReference();



        Button back  = (Button) findViewById(R.id.button01);
        Button next  = (Button) findViewById(R.id.button02);
        back.setOnClickListener(this);
        next.setOnClickListener(this);

    }

    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.button01:
                // reference a function that would house your current onClick behavior, such as:
                Intent i=new Intent(SignUp1Activity.this, SignUpActivity.class);
                startActivity(i);
                break;
            case R.id.button02:
                String email = inputEmail.getText().toString().trim();
                String name = inputName.getText().toString().trim();
                String Sirname = inputSirname.getText().toString().trim();






//                user = new User("Native",inputEmail.getText().toString().trim(), (inputLocation.getText().toString().trim()),inputPassword.getText().toString().trim(),(inputPhone.getText().toString().trim()),"Regular",inputZip.getText().toString().trim())

                ;
                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getApplicationContext(), "Enter email", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(name)) {
                    Toast.makeText(getApplicationContext(), "Enter name", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(Sirname)) {
                    Toast.makeText(getApplicationContext(), "Enter Sirname", Toast.LENGTH_SHORT).show();
                    return;
                }



                databaseRef.child("user").push().setValue(user);
                databaseRef.child("user").push().child("Auth type").setValue("Native");
                databaseRef.child("user").child("Email").setValue(email);


                Log.i("clicks","You Clicked B1");
                 i=new Intent(SignUp1Activity.this, SignUp2Activity.class);
                startActivity(i);
                break;
        }}
    public static String kuhaName()
    {
        String email = inputEmail.getText().toString().trim();
        return email;

    }

    public static String FistnameString()
    {
        String Firstname = inputName.getText().toString().trim();
        return Firstname;

    }

    public static String LastNameString()
    {
        String LastName = inputSirname.getText().toString().trim();
        return LastName;

    }

        }



