package com.example.milind.mapplication3;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class display_message extends AppCompatActivity {

    private EditText input, digits, pass, phone;
    private Button next, display;
    private Context context;
    private TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);
        context = this.getApplicationContext();

        input = (EditText) findViewById(R.id.editInp);
        digits = (EditText) findViewById(R.id.editDig);
        pass = (EditText) findViewById(R.id.editPass);
        phone = (EditText) findViewById(R.id.editPhone);
        text = (TextView) findViewById(R.id.textv);

        text.setTextColor(Color.BLUE);
       // input.addTextChangedListener(TextWatcher );
        input.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                text.setTextColor(Color.BLUE);

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                text.setTextColor(Color.RED);

            }
            String mk,std;
            int i=0,j=0;


            @Override
            public void afterTextChanged(Editable s) {
                std = text.getText().toString();
                mk  = input.getText().toString();
                if(mk.length() > 0 && mk.charAt(mk.length() - 1) != ' ') {
                    if (mk.charAt(j) != std.charAt(i)) {
                        text.setTextColor(Color.RED);
                    } else {
                        text.setTextColor(Color.GREEN);
                        i++;
                        j++;
                    }
                }else if(mk.length()>0){
                    input.setText("");
                    j=0;
                    i++;
                   //i= mk.length() - 1;
                }
                /*for(int i=0;i<mk.length();i++) {
                    if (mk.charAt(i)!=std.charAt(i)){
                        text.setTextColor(Color.RED);
                    }else
                        text.setTextColor(Color.GREEN);
                }*/

            }
        });
        /*input.setOnTouchListener(new View.OnTouchListener(){
            public void onTouch(View v){

            }
        });
*/
        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast msg = Toast.makeText(getBaseContext(), "Only 10 numbers",
                        Toast.LENGTH_LONG);
                msg.show();
            }
        });

        next = (Button) findViewById(R.id.nextBtn);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent myIntent = new Intent(context, NextScreen.class);
                myIntent.putExtra("pass", pass.getText().toString());
                myIntent.putExtra("phone", phone.getText().toString());
                startActivity(myIntent);
            }
        });

        display = (Button) findViewById(R.id.displayBtn);

        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setTextColor(Color.RED);
                String displayString = "You typed '" + input.getText().toString() +
                        "' as input text and '" + digits.getText().toString() + "' as digits";

                Toast msg = Toast.makeText(getBaseContext(), displayString,
                        Toast.LENGTH_LONG);
                msg.show();
            }
        });
    }

    public void displayAd(){
        Intent myIntent = new Intent(context, Interstitial_ad.class);

        startActivity(myIntent);
    }
      /*  Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }*/

}
