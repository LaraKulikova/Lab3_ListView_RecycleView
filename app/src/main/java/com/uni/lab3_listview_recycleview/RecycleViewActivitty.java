package com.uni.lab3_listview_recycleview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.uni.lab3_listview_recycleview.recycleView.Contact;
import com.uni.lab3_listview_recycleview.recycleView.ContactsAdapter;

import java.util.ArrayList;
import java.util.List;

public class RecycleViewActivitty extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ContactsAdapter adapter;
    private List<Contact> contactList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view_activitty);
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        contactList = new ArrayList<>();
        // Добавьте контакты в список
        contactList.add(new Contact("John Doe", "1234567890", "john@example.com"));
        contactList.add(new Contact("Jane Smith", "0987654321", "jane@example.com"));

        adapter = new ContactsAdapter(contactList, this);
        recyclerView.setAdapter(adapter);
    }

}