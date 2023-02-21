package com.example.usersrecyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class UserDetailsActivity extends AppCompatActivity {
    TextView txtUsername1;
    ImageView userImageView1;
    String txtUsername;
    int userId, userImageId;
    User user;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_details_activity);
        txtUsername1 = findViewById(R.id.txtUsername1);
        userImageView1 = findViewById(R.id.userImageView1);
        Intent intent = getIntent();
        /*userId = intent.getIntExtra("userId",10);
        userImageId = intent.getIntExtra("userImageId",0);
        txtUsername = intent.getStringExtra("username");

        userImageView1.setImageResource(userImageId);
        txtUsername1.setText(txtUsername);*/
        user = (User) intent.getSerializableExtra("user");

        user.getUserId();
        txtUsername1.setText(user.getUsername());
        userImageView1.setImageResource(user.getImageId());
    }
}
