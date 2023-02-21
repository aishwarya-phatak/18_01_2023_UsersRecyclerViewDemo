package com.example.usersrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView userRecyclerView;
    ArrayList<User> users;
    UsersAdapter usersAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUsers();
        initViews();

    }
    private void initUsers(){
        users = new ArrayList<>();
        for(int i = 1; i<=10;i++) {
            users.add(
                    new User(
                            i,
                            R.drawable.ic_launcher_background,
                            "User "+i
                    ));
        }
    }

    private void initViews(){
        userRecyclerView = findViewById(R.id.userRecyclerView);
        userRecyclerView.setLayoutManager(new LinearLayoutManager(
                this,
                LinearLayoutManager.VERTICAL,
                false));
        usersAdapter = new UsersAdapter(users);
        userRecyclerView.setAdapter(usersAdapter);
    }
}