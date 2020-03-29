package com.example.amma.envapp3states;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity implements
        View.OnClickListener {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Button buttonOne = (Button) findViewById(R.id.buttonOne);
        buttonOne.setOnClickListener(this); // calling onClick() method
        Button buttonTwo = (Button) findViewById(R.id.buttonTwo);
        buttonTwo.setOnClickListener(this);
        Button buttonThree = (Button) findViewById(R.id.buttonThree);
        buttonThree.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.buttonOne:
                Intent intent1 = new Intent (Main2Activity.this,Main5Activity.class);
                Main2Activity.this.startActivity(intent1);
                break;

            case R.id.buttonTwo:
//                    Intent intent = new Intent (MainActivity.this,Main4Activity.class);
//                    MainActivity.this.startActivity(intent);
                break;

            case R.id.buttonThree:
//                    Intent intent2 = new Intent (MainActivity.this,Main5Activity.class);
//                    MainActivity.this.startActivity(intent2);
                break;


            default:
                break;
        }
    }
}


