package com.example.developer.myapplication;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.developer.myapplication.databinding.ActivityMainBinding;
import com.example.developer.myapplication.model.User;

import java.util.ArrayList;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private Adapter adapter;
    private ArrayList<User> user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.recycler.setLayoutManager(new LinearLayoutManager(this));
        adapter = new Adapter(new ArrayList<User>());
        binding.recycler.setAdapter(adapter);
        load();
        MyApplication.getInstance().getUmoriliApi().getData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(users -> {
                    adapter.setUsers(users.getData());
                    show();
        });
    }

    private void load() {
        binding.loadWrap.setVisibility(View.VISIBLE);
        binding.recycler.setVisibility(View.GONE);
    }

    private void show() {
        binding.loadWrap.setVisibility(View.GONE);
        binding.recycler.setVisibility(View.VISIBLE);
    }
}
