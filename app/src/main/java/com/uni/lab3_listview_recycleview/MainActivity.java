package com.uni.lab3_listview_recycleview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
 //Button buttonListView;
 //Button buttonRecycleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
       // buttonListView = (Button)findViewById(R.id.buttonListView);
       // buttonRecycleView = (Button)findViewById(R.id.buttonRecycleView);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void onClickListView(View v){
    Intent intentListView = new Intent(this, ListViewActivity.class);
    startActivity(intentListView);
    }

   public void onClickRecycleView(View v){
       Intent intentRecycleView = new Intent(this, RecycleViewActivitty.class);
       startActivity(intentRecycleView);
   }
}