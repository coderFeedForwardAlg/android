package com.example.data;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class random extends AppCompatActivity {

    // things on the screen

    Button randButton;

    Button backButton;

    TextView randNum;


    // useful constants

    static final String RANDOM = "random";

    static final String COUNT = "count";

    int count = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_random);


        // declar buttons / text view
        randButton = findViewById(R.id.randBut);

        backButton = findViewById(R.id.backBut);

        randNum = findViewById(R.id.randomText);


        // intents
        Intent intent = getIntent();

        count = intent.getIntExtra(COUNT, 0);

        randNum.setText(String.valueOf(count));


        // make button get random numb
        randButton.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v1) {

                count = (int) (Math.random() * 99) + 1 ;    // random range + start

                randNum.setText(String.valueOf(count));

            }
        });


        // button to go back to first activity
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v2) {
                Intent intent = new Intent();
                intent.putExtra(RANDOM, count);
                setResult(RESULT_OK, intent);
                finish();
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

                Intent intent = new Intent(getApplicationContext(),MainActivity.class);

                intent.putExtra(COUNT, count);

                startActivity(intent);

                return true;


            case R.id.input:

                Intent intent2 = new Intent(getApplicationContext(),inputFeels.class);

                startActivity(intent2);

                return true;


            case R.id.disp:
                Intent intent3 = new Intent(getApplicationContext(),displayUserIn.class);

                startActivity(intent3);

                return true;


            default:

                return true;
        }

    }

}