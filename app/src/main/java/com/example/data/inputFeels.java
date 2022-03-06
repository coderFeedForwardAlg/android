package com.example.data;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class inputFeels extends AppCompatActivity {

    EditText input1, input2, input3, input4;

    Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_input_feels);


        input1 = findViewById(R.id.in1);

        input2 = findViewById(R.id.in2);

        input3 = findViewById(R.id.in3);

        input4 = findViewById(R.id.in4);

        save = findViewById(R.id.saveBut);

        save.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {

                SharedPreferences preferences = getSharedPreferences("preferences",MODE_PRIVATE);

                SharedPreferences.Editor editor = preferences.edit();


                if (input1.getText().toString().trim().length() > 0)

                    editor.putString("input1", input1.getText().toString());

                if (input2.getText().toString().trim().length() > 0)

                    editor.putString("input2", input2.getText().toString());

                if (input3.getText().toString().trim().length() > 0)

                    editor.putString("input3", input3.getText().toString());

                if (input4.getText().toString().trim().length() > 0)

                    editor.putString("input4", input4.getText().toString());



                //clearing the prefrenc file
                editor.clear();

                editor.apply();

                //display the toast
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(getApplicationContext(), "Data Saved", duration);

                toast.show();

                //clear the input fields
                input1.setText("");

                input2.setText("");

                input3.setText("");

                input4.setText("");

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

            case R.id.disp:

                Intent intent3 = new Intent(getApplicationContext(),displayUserIn.class);

                startActivity(intent3);

                return true;

            default:

                return true;

        }


    }
}