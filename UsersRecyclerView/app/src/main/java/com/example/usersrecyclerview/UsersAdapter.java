package com.example.usersrecyclerview;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.UsersViewHolder> {

    ArrayList<User> users;
    TextView txtUsername;
    ImageView userImageView;

    public UsersAdapter(ArrayList<User> users){
        this.users = users;
    }

    class UsersViewHolder extends RecyclerView.ViewHolder{

        public UsersViewHolder(@NonNull View itemView) {
            super(itemView);
            userImageView = itemView.findViewById(R.id.userImageView);
            txtUsername = itemView.findViewById(R.id.txtUsername);
            userImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    User user = users.get(getAdapterPosition());
                    Log.e("tag","--"+user.getImageId());
                    Intent intent = new Intent(v.getContext(),UserDetailsActivity.class);
                    /*intent.putExtra("userId",user.getUserId());
                    intent.putExtra("username",user.getUsername());
                    intent.putExtra("userImageId",user.getImageId());*/
                    intent.putExtra("user",user);
                v.getContext().startActivity(intent);
                }
            });
            txtUsername.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    User user = users.get(getAdapterPosition());
                    Log.e("tag",user.getUsername());
                    Toast.makeText(v.getContext(), "--"+user.getUsername(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(v.getContext(),UserDetailsActivity.class);
                    /*intent.putExtra("userId",user.getUserId());
                    intent.putExtra("username",user.getUsername());
                    intent.putExtra("userImageId",user.getImageId());*/
                    intent.putExtra("user",user);
                    v.getContext().startActivity(intent);
                }
            });
        }
    }


    @NonNull
    @Override
    public UsersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View userView = layoutInflater.inflate(R.layout.user_view,null);
        userImageView = userView.findViewById(R.id.userImageView);
        txtUsername = userView.findViewById(R.id.txtUsername);

        /*userImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "ImageClicked", Toast.LENGTH_LONG).show();
            }
        });

        txtUsername.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "TextUsername Clicked", Toast.LENGTH_SHORT).show();
            }
        });*/

        return new UsersViewHolder(userView);
    }

    @Override
    public void onBindViewHolder(@NonNull UsersViewHolder holder, int position) {
        User user = users.get(position);
        txtUsername = holder.itemView.findViewById(R.id.txtUsername);
        userImageView = holder.itemView.findViewById(R.id.userImageView);

        userImageView.setImageResource(user.getImageId());
        txtUsername.setText(user.getUsername());
    }

    @Override
    public int getItemCount() {
        return users.size();
    }
}
