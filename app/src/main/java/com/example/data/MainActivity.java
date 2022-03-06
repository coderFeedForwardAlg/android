package com.example.data;



import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

// got some help from: https://www.youtube.com/watch?v=Y8o8WFQ7iAo&t=189s
// and the github files

public class MainActivity extends AppCompatActivity {

    // things on the screen
    Button addButton;

    Button subButton;

    Button getButton;

    TextView mainNum;

    // usefull constents
    int REQUEST_NUM_CODE = 1;

    static final String COUNT = "count";

    static final String RANDOM = "random";

    int count = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        // declar the things on the scree
        addButton = findViewById(R.id.addBut);

        subButton = findViewById(R.id.subBut);

        getButton = findViewById(R.id.get);

        mainNum = findViewById(R.id.totNum);

        // addition, subtraction, pass data
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v1) {

                count ++;

                mainNum.setText(String.valueOf(count));

            }

        });

        subButton.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v2) {

                count --;

                mainNum.setText(String.valueOf(count));

            }

        });

        getButton.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v3) {

                Intent intent = new Intent(MainActivity.this, random.class);

                intent.putExtra(COUNT, count);

                startActivityForResult(intent, REQUEST_NUM_CODE);

            }

        });



    }


    // handle  return call
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_NUM_CODE && resultCode == RESULT_OK) {


            count = data.getIntExtra(RANDOM, 0);

            mainNum.setText(String.valueOf(count));


            Context context = getApplicationContext();

            CharSequence text = "@string/gotData";

            int duration = Toast.LENGTH_SHORT;


            //tost is good with jam
            Toast toast = Toast.makeText(context, text, duration);

            toast.show();

        }
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

            case R.id.random:

                Intent intent = new Intent(getApplicationContext(),random.class);

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
