package com.example.developer.myapplication;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.developer.myapplication.databinding.ItemBinding;
import com.example.developer.myapplication.model.User;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private ArrayList<User> users;



    public void setUsers(ArrayList<User> users) {
        this.users = users;
        notifyDataSetChanged();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ItemBinding binding;

        public ViewHolder(View v) {
            super(v);
        }
    }

    public Adapter(ArrayList<User> users) {
        this.users = users;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item, parent, false);
        return new ViewHolder(binding.getRoot());

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.binding.age.setText("" + users.get(position).getAge());
        holder.binding.name.setText(users.get(position).getName());
        Glide.with(holder.itemView).load(users.get(position).getImage()).into(holder.binding.profileImage);

    }

    @Override
    public int getItemCount() {
        return users.size();
    }
}
