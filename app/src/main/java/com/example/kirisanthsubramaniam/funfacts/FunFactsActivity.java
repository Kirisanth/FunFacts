package com.example.kirisanthsubramaniam.funfacts;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;


public class FunFactsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fun_facts);


        //Declare our View variables and assign the Views from the layout file
        final TextView factLabel = (TextView) findViewById(R.id.factTextView);
        Button showFactButton = (Button) findViewById(R.id.showFactButton);

        View.OnClickListener listener = new View.OnClickListener(){
            public void onClick(View view){
//                String fact = "Ostriches can run faster than horses";
                String fact = "";

                //Random number generator
                Random randomGenerator = new Random();
                int randomNumber = randomGenerator.nextInt(3);
                fact = randomNumber + "";

                if(randomNumber == 0) {
                    fact = "Ants stretch when they wake up in the morning.";
                }
                else if(randomNumber == 1) {
                    fact = "Ostriches can run faster than horses.";
                }
                else if(randomNumber == 2) {
                    fact = "Olympic gold metals are actually made mostly of silver.";
                }
                else {
                    fact = "Sorry, there was an error!";
                }

                //This is a closure requires factLabel to be final
                factLabel.setText(fact);
            }
        };
        showFactButton.setOnClickListener(listener);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.fun_facts, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
