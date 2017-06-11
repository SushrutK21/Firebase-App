package com.example.cgi.my_home_circle;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
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
public class SignInActivity extends AppCompatActivity implements View.OnClickListener {

    private Button back , signin;
    private static EditText  siginemail , signinpassword ;
    private User user;
    private FirebaseAuth mAuth;
    private FirebaseDatabase database;
    private DatabaseReference databaseRef;
    private FirebaseAuth.AuthStateListener mAuthListener;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);


        siginemail = (EditText) findViewById(R.id.EmailForSignIn);
        signinpassword= (EditText) findViewById(R.id.Passwordforsignin);


        Button back  = (Button) findViewById(R.id.back);
        Button signin  = (Button) findViewById(R.id.Signinbutton);
        back.setOnClickListener(this);
        signin.setOnClickListener(this);


        mAuth = FirebaseAuth.getInstance();

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

    }

    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.back:
                // reference a function that would house your current onClick behavior, such as:
                Intent i=new Intent(SignInActivity.this, SignUpActivity.class);
                startActivity(i);
                break;
            case R.id.Signinbutton:

                String email = siginemail.getText().toString().trim();
                String password = signinpassword.getText().toString().trim();

                mAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                Log.d("TAG", "signInWithEmail:onComplete:" + task.isSuccessful());

                             Intent  i=new Intent(SignInActivity.this, Onboarding.class);
                                startActivity(i);


                                // If sign in fails, display a message to the user. If sign in succeeds
                                // the auth state listener will be notified and logic to handle the
                                // signed in user can be handled in the listener.
                                if (!task.isSuccessful()) {
                                    Log.w("TAG", "signInWithEmail:failed", task.getException());
                                    Toast.makeText(SignInActivity.this, R.string.auth_failed,
                                            Toast.LENGTH_SHORT).show();

                                    i=new Intent(SignInActivity.this, SignUp1Activity.class);
                                    startActivity(i);
                                }

                                // ...
                            }
                        });

                // reference a function that would house your current onClick behavior, such as:


                break;
        }}


}



