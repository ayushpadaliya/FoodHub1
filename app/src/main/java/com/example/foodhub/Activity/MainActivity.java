package com.example.foodhub.Activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.foodhub.Activity.Utils.VariableBag;
import com.example.foodhub.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });imageView=findViewById(R.id.FoodHub_splace);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                    if (user != null) {
                        // Name, email address, and profile photo Url
                        String name = user.getDisplayName();
                        String email = user.getEmail();
                        Uri photoUrl = user.getPhotoUrl();
                        VariableBag.pathImage=photoUrl;
                        // Check if user's email is verified
                        Intent i=new Intent(new Intent(MainActivity.this, LandingActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                        startActivity(i);
                        finish();
                        boolean emailVerified = user.isEmailVerified();

                        // The user's ID, unique to the Firebase project. Do NOT use this value to
                        // authenticate with your backend server, if you have one. Use
                        // FirebaseUser.getIdToken() instead.
                        String uid = user.getUid();
                    }
                    else {
                        Intent i = new Intent(MainActivity.this, WelcomeActivity.class);
                        startActivity(i);
                        finish();                    }

            }
        },2000);

    }
}