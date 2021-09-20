package com.example.appnetustest;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<String> msg = new ArrayList<>();
    RecyclerView recyclerView;
    List<User> userList = new ArrayList<>();
    ChatAdapter chatAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        userList.add(new User("0", "Google LLC is an American multinational technology company that specializes in Internet-related services and products"));
        userList.add(new User("1", "Google LLC is an American multinational technology company that specializes in Internet-related services and products"));
        userList.add(new User("0", "Google LLC is an American multinational technology company that specializes in Internet-related services and products"));
        userList.add(new User("0", "Google LLC is an American multinational technology company that specializes in Internet-related services and products"));
        userList.add(new User("1", "Google LLC is an American multinational technology company that specializes in Internet-related services and products"));
        userList.add(new User("0", "Google LLC is an American multinational technology company that specializes in Internet-related services and products"));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        chatAdapter = new ChatAdapter(MainActivity.this, userList);
        recyclerView.setAdapter(chatAdapter);
        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                userList.remove(viewHolder.getAdapterPosition());
                chatAdapter.notifyDataSetChanged();
            }
        }).attachToRecyclerView(recyclerView);
        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                userList.remove(viewHolder.getAdapterPosition());
                chatAdapter.notifyDataSetChanged();
            }
        }).attachToRecyclerView(recyclerView);
    }
}