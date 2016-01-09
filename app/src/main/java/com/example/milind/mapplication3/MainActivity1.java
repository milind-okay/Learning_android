package com.example.milind.mapplication3;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.AdRequest;



public class MainActivity1 extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "com.mycompany.myfirstapp.MESSAGE";
    int counter;
    Button add,sub,database;
    TextView counterText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        counter = 0;
        add = (Button)findViewById(R.id.buttonAdd);
        sub = (Button) findViewById(R.id.buttonSub);
        database = (Button)findViewById(R.id.database);
        counterText = (TextView)findViewById(R.id.counter);
        database.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               startdatabase();
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;
                counterText.setText("counter = " + counter);
            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter--;
                counterText.setText("counter = " + counter);
            }
        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_activity1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        switch (item.getItemId()) {
            case R.id.rate_us:
                rate_us();
                return true;
            case R.id.help:
                showHelp();
                return true;
            case R.id.action_settings:
                Intent intent = new Intent(this, fill_sudoku.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }


    }

    private void showHelp() {
        String str ="https://play.google.com/store/apps/details?id=ws.crandell.newspaperpuzzles";
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(str)));
    }

    public void sendMessage(View view){
        Intent intent = new Intent(this, display_message.class);
        EditText editText = (EditText) findViewById(R.id.edit_message);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
    public void displayAct(View view){

        Intent intent = new Intent(this, fill_sudoku.class);
        startActivity(intent);
    }
    public void rate_us(){
        String str ="https://play.google.com/store/apps/details?id=ws.crandell.newspaperpuzzles";
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(str)));
    }
    public void scroll(){
        Intent intent = new Intent(this, ScrollingActivity.class);

        startActivity(intent);
    }
    public void startdatabase(){
        Intent intent = new Intent(this, data_main.class);

        startActivity(intent);
    }
}
