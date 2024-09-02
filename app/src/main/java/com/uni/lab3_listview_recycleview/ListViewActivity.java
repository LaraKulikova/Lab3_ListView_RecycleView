package com.uni.lab3_listview_recycleview;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ListViewActivity extends AppCompatActivity {
    final String LOG_TAG = "myLogs";
    ListView lvPeopleNames;
    String[] peopleNames;
    String[] emailAddresses;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        // Получаем данные из ресурсов
        peopleNames = getResources().getStringArray(R.array.peopleNames);
        emailAddresses = getResources().getStringArray(R.array.emailPeople);

        lvPeopleNames = findViewById(R.id.lvPeopleNames);

        // Устанавливаем адаптер для ListView
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, peopleNames);
        lvPeopleNames.setAdapter(adapter);

        // Обработка нажатий на элементы списка
        lvPeopleNames.setOnItemClickListener((parent, view, position, id) -> {
            // Получаем адрес электронной почты по выбранному индексу
            String selectedEmail = emailAddresses[position];

            // Открываем почтовый клиент
            openEmailApp(selectedEmail);
        });
    }

    @SuppressLint("QueryPermissionsNeeded")
    private void openEmailApp(String email) {

        Bundle args = getIntent().getExtras();
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{email});
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject Here");
        if (emailIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(emailIntent);
        } else {
            Log.e(LOG_TAG, "No email client found.");
            Toast.makeText(this, "Нет доступного почтового клиента.", Toast.LENGTH_SHORT).show();
        }
    }
    public void buttonReturnMP(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}