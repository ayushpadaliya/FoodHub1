package com.example.foodhub.Activity;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.foodhub.Activity.Utils.VariableBag;
import com.example.foodhub.R;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LoginActivity extends AppCompatActivity {

    TextView textView,phone;
    ImageButton login;
    private FirebaseAuth mAuth;
    GoogleSignInAccount account;
    CallbackManager mCallbackManager;
ImageView facebook;
    GoogleSignInClient googleSignInClient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        FacebookSdk.sdkInitialize(getApplicationContext());
        mAuth=FirebaseAuth.getInstance();
        mCallbackManager = CallbackManager.Factory.create();
        ImageView facebook=findViewById(R.id.welcome_facebook);
//        loginButton.setReadPermissions("email", "public_profile");
        facebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<String> need=new ArrayList<>();
                need.add("email");
                need.add("public_profile");
                LoginManager.getInstance().logInWithReadPermissions(LoginActivity.this, need);
                LoginManager.getInstance().registerCallback(mCallbackManager, new com.facebook.FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {
                        handleFacebookAccessToken(loginResult.getAccessToken());
                    }
                    @Override
                    public void onCancel() {
                        Toast.makeText(LoginActivity.this, "Facebook login canceled", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(FacebookException exception) {
                        Toast.makeText(LoginActivity.this, "Error occurred during Facebook login", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });

        login=findViewById(R.id.login_login);
        phone=findViewById(R.id.login_text4);
        textView=findViewById(R.id.login_text2);
        ImageView imageView=findViewById(R.id.welcome_google);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, VerificationCodeActivity.class));
            }
        });
        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, PhoneRegistrationActivity.class));

            }
        });
//        checkUser();
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUserAccount();


            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    checkUser();
                    finishAffinity();
            }
        });

        try {
            PackageInfo info = getPackageManager().getPackageInfo("com.example.foodhub", PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        } catch (PackageManager.NameNotFoundException e) {
            Log.e("KeyHash:", e.toString());
        } catch (NoSuchAlgorithmException e) {
            Log.e("KeyHash:", e.toString());
        }
    }
    private void loginUserAccount() {
        GoogleSignInOptions googleSignInOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken("990064800255-1vqaeb9vqii1skg88g8064hgcrd1447p.apps.googleusercontent.com")
                .requestEmail()
                .build();
        googleSignInClient = GoogleSignIn.getClient(LoginActivity.this, googleSignInOptions);
        Intent intent = googleSignInClient.getSignInIntent();
        startActivityForResult(intent, 200);
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser firebaseUser = mAuth.getCurrentUser();
        if (firebaseUser != null) {
            startActivity(new Intent(LoginActivity.this, LandingActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
        }

    }
    public void checkUser()
    {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            String name = user.getDisplayName();
            String email = user.getEmail();
            Uri photoUrl = user.getPhotoUrl();
            VariableBag.pathImage=photoUrl;
            Toast.makeText(this, "perfect", Toast.LENGTH_SHORT).show();
            Intent i=new Intent(new Intent(LoginActivity.this, LandingActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
            startActivity(i);
            boolean emailVerified = user.isEmailVerified();
            String uid = user.getUid();
        }
        else {
            Toast.makeText(this, "you have to sign in first!", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mCallbackManager.onActivityResult(requestCode,resultCode,data);
        Log.d("callBack","");
        if (requestCode==200)
        {
            Task<GoogleSignInAccount> signInAccountTask = GoogleSignIn.getSignedInAccountFromIntent(data);
            if (signInAccountTask.isSuccessful()) {
                String s = "Google sign in successful";
                account=signInAccountTask.getResult();
                Uri path=account.getPhotoUrl();

                try {
                    GoogleSignInAccount googleSignInAccount = signInAccountTask.getResult(ApiException.class);
                    if (googleSignInAccount != null) {
                        AuthCredential authCredential = GoogleAuthProvider.getCredential(googleSignInAccount.getIdToken(), null);
                        mAuth.signInWithCredential(authCredential).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                // Check condition
                                if (task.isSuccessful()) {
                                    Intent i=new Intent(new Intent(LoginActivity.this, LandingActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                                    assert path != null;
                                    VariableBag.pathImage=path;
//
                                    startActivity(i);
                                    finishAffinity();
                                    Toast.makeText(LoginActivity.this, "Firebase authentication successful", Toast.LENGTH_SHORT).show();
                                } else {
                                    // When task is unsuccessful display Toast
                                    Toast.makeText(LoginActivity.this, "Authentication Failed :", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                    }
                } catch (ApiException e) {
                    e.printStackTrace();
                }
            }

        }
        else {

//            Toast.makeText(this, "not perfect", Toast.LENGTH_SHORT).show();
        }
    }

    private void handleFacebookAccessToken(AccessToken token)
    {
        AuthCredential credential=FacebookAuthProvider.getCredential(token.getToken());
        Log.d("Token"," "+token.getToken());
        FirebaseAuth.getInstance().signInWithCredential(credential).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful())
                {
                    startActivity(new Intent(LoginActivity.this, LandingActivity.class));
                    finishAffinity();
                }
                else
                {
                    Log.d("task is"," "+task.isSuccessful());
                    Log.d("task exception"," "+task.getException());
                    Log.d("task result"," "+task.getResult());
                }
            }
        });
    }


}
