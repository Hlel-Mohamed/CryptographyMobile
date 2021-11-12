package com.example.cryptage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button button1;
    private Button button3;
    private Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCesar();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openVig();
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHill();
            }
        });
    }
    public void openCesar(){
        Intent intent = new Intent(this, Caesar.class);
        startActivity(intent);
    }
    public void openVig(){
        Intent intent = new Intent(this, Vigenere.class);
        startActivity(intent);
    }
    public void openHill(){
        Intent intent = new Intent(this, Hill.class);
        startActivity(intent);
    }
}