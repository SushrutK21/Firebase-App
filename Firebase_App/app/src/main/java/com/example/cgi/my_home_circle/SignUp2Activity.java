package com.example.cgi.my_home_circle;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;


import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by CGI on 1/20/2017.
 */
public class SignUp2Activity extends AppCompatActivity implements View.OnClickListener {

    private Button back , next;
    static EditText inputPassword;
  static  EditText inputZip;
   static EditText inputPhone;
   static EditText ConfirmPassword;
    EditText inputEmail;
    EditText inputName;
    EditText inputSirname;
    EditText inputLocation;
    private User user;
    private static FirebaseAuth auth;
    private FirebaseDatabase database;
    private DatabaseReference databaseRef;
    private FirebaseAuth.AuthStateListener mAuthListener;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup2);


        auth = FirebaseAuth.getInstance();


        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                    Log.d("TAG", "onAuthStateChanged:signed_in:" + user.getUid());
                } else {
                    // User is signed out
                    Log.d("TAG", "onAuthStateChanged:signed_out");
                }
                // ...
            }
        };

        inputPassword = (EditText) findViewById(R.id.password);
        inputZip = (EditText) findViewById(R.id.Zip);
        inputPhone = (EditText) findViewById(R.id.Phone);
        ConfirmPassword= (EditText) findViewById(R.id.ConfirmPassword);






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
                Intent i=new Intent(SignUp2Activity.this, SignUpActivity.class);
                startActivity(i);
                break;
            case R.id.button02:

                String password = inputPassword.getText().toString().trim();
                String ZIP = (inputZip.getText().toString().trim());
                String Phone = (inputPhone.getText().toString().trim());

                String Confirm = (ConfirmPassword.getText().toString().trim());


              //  user = new User("Native",inputEmail.getText().toString().trim(), (inputLocation.getText().toString().trim()),inputPassword.getText().toString().trim(),(inputPhone.getText().toString().trim()),"Regular",inputZip.getText().toString().trim())

                ;  if (TextUtils.isEmpty(password)) {
                Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
                return;
            }


                if (password.length() < 6) {
                    Toast.makeText(getApplicationContext(), "Password too short, enter minimum 6 characters!", Toast.LENGTH_SHORT).show();
                    return;
                }


                if (!password.equals(Confirm)) {
                    Toast.makeText(getApplicationContext(), "Passwords do not match!", Toast.LENGTH_SHORT).show();
                    return;
                }

                String email = SignUp1Activity.kuhaName();//Retrieve the name
                Log.d("myTag",email);
                databaseRef.child("user").push().setValue(user);
                databaseRef.child("user").push().child("Auth type").setValue("Native");
                databaseRef.child("user").child("Email").setValue(email);

                databaseRef.child("user").child("Password").setValue(password);
                databaseRef.child("user").child("Phone").setValue(Phone);
                databaseRef.child("user").child("UserType").setValue("Regular");
                databaseRef.child("user").child("zip").setValue(ZIP);

                Log.d("myTagsss",password);


                //create user
                auth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(SignUp2Activity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                Toast.makeText(SignUp2Activity.this, "createUserWithEmail:onComplete:" + task.isSuccessful(), Toast.LENGTH_SHORT).show();

                                // If sign in fails, display a message to the user. If sign in succeeds
                                // the auth state listener will be notified and logic to handle the
                                // signed in user can be handled in the listener.
                                if (!task.isSuccessful()) {
                                    Toast.makeText(SignUp2Activity.this, "Authentication failed." + task.getException(),
                                            Toast.LENGTH_SHORT).show();
                                } else {
                                    startActivity(new Intent(SignUp2Activity.this, Onboarding.class));
                                    finish();
                                }
                            }
                        });

                                break;
        }
    }
    @Override
    public void onStart() {
        super.onStart();
        auth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            auth.removeAuthStateListener(mAuthListener);
        }
    }

    public static String passwordString()
    {
        String pswrd = inputPassword.getText().toString().trim();
        return pswrd;

    }

    public static String zipString()
    {
        String zp = inputZip.getText().toString().trim();
        return zp;

    }

    public static String phneString()
    {
        String phne = inputPhone.getText().toString().trim();
        return phne;

    }
}