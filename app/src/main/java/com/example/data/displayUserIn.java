package com.example.data;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class displayUserIn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_display_user_in);

        SharedPreferences preferences = getSharedPreferences("preferences", MODE_PRIVATE);

        ArrayList<String> list = new ArrayList<>();

        if (preferences.contains("input1"))

            list.add(preferences.getString("input1", ""));

        if (preferences.contains("input2"))

            list.add(preferences.getString("input2", ""));

        if (preferences.contains("input3"))

            list.add(preferences.getString("input3", ""));

        if (preferences.contains("input4"))

            list.add(preferences.getString("input4", ""));



        ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(), R.layout.row_item, R.id.listItem, list);

        final ListView listView = (ListView) findViewById(android.R.id.list);

        listView.setAdapter(adapter);




        TextView emptyView = (TextView) findViewById(android.R.id.empty);

        listView.setEmptyView(emptyView);



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String selectedItem = (String) listView.getItemAtPosition(position);

                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(getApplicationContext(), selectedItem, duration);

                toast.show();

            }

        });

    }


    /* ****************  MENU STUFF ***************** */

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        switch (id){


            case R.id.addSubtract:

                Intent intenta = new Intent(getApplicationContext(),MainActivity.class);

                startActivity(intenta);

                return true;

            case R.id.random:

                Intent intent = new Intent(getApplicationContext(),random.class);

                startActivity(intent);

                return true;

            case R.id.input:

                Intent intent3 = new Intent(getApplicationContext(),inputFeels.class);

                startActivity(intent3);

                return true;

            default:

                return true;
        }


    }
}