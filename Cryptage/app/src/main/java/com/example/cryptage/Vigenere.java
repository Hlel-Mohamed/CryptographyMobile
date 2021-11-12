package com.example.cryptage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class Vigenere extends AppCompatActivity {

    private ImageButton esc;
    private Button but_enc,but_dec;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_vigenere);
        esc = (ImageButton) findViewById(R.id.escape);
        but_enc = (Button) findViewById(R.id.vig_en);
        but_dec = (Button) findViewById(R.id.vig_dec);

        esc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHome();
            }
        });

        but_enc.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                vigEncrypt();
            }
        });

        but_dec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vigDecrypt();
            }
        });
    }public void openHome(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void vigEncrypt(){
        String vig_text = ((EditText)findViewById(R.id.vig_text)).getText().toString() ;
        String vig_key = ((EditText)findViewById(R.id.vig_key)).getText().toString();
        StringBuffer result= new StringBuffer();
        for (int i=0; i<vig_text.length(); i++)
        {
            if (Character.isUpperCase(vig_text.charAt(i)))
            {
                if (Character.isUpperCase(vig_key.charAt(i))) {
                    int aux1 = (int) vig_text.charAt(i) - 64;
                    int aux2 = (int) vig_key.charAt(i) - 64;
                    int res = aux1 + aux2;
                    while (res > 26) res = res - 26;
                    result.append((char) (res + 64));
                }else {
                    int aux1 = (int) vig_text.charAt(i) - 64;
                    int aux2 = (int) vig_key.charAt(i) - 96;
                    int res = aux1 + aux2;
                    while (res > 26) res = res - 26;
                    result.append((char) (res + 64));
                }
            }
            else
            {
                if (Character.isUpperCase(vig_key.charAt(i))) {
                    int aux1 = (int) vig_text.charAt(i) - 96;
                    int aux2 = (int) vig_key.charAt(i) - 64;
                    int res = aux1 + aux2;
                    while (res > 26) res = res - 26;
                    result.append((char) (res + 96));
                }else {
                    int aux1 = (int) vig_text.charAt(i) - 96;
                    int aux2 = (int) vig_key.charAt(i) - 96;
                    int res = aux1 + aux2;
                    while (res > 26) res = res - 26;
                    result.append((char) (res + 96));
                }
            }
        }
        TextView resu=(TextView)findViewById((R.id.vig_res));
        resu.setText(result);
    }
    public void vigDecrypt(){
        String vig_text = ((EditText)findViewById(R.id.vig_text)).getText().toString() ;
        String vig_key = ((EditText)findViewById(R.id.vig_key)).getText().toString();
        StringBuffer result= new StringBuffer();
        for (int i=0; i<vig_text.length(); i++)
        {
            if (Character.isUpperCase(vig_text.charAt(i)))
            {

                if (Character.isUpperCase(vig_key.charAt(i))) {
                    int aux1 = (int) vig_text.charAt(i);
                    int aux2 = (int) vig_key.charAt(i) - 64;
                    int res = aux1 - aux2;
                    while (res < 65) res = res + 26;
                    result.append((char)res);
                }else {
                    int aux1 = (int) vig_text.charAt(i);
                    int aux2 = (int) vig_key.charAt(i) - 96;
                    int res = aux1 - aux2;
                    while (res < 65) res = res + 26;
                    result.append((char)res);
                }
            }
            else
            {
                if (Character.isUpperCase(vig_key.charAt(i))) {
                    int aux1 = (int) vig_text.charAt(i);
                    int aux2 = (int) vig_key.charAt(i) - 64;
                    int res = aux1 - aux2;
                    while (res < 97) res = res + 26;
                    result.append((char)res);
                }else {
                    int aux1 = (int) vig_text.charAt(i);
                    int aux2 = (int) vig_key.charAt(i) - 96;
                    int res = aux1 - aux2;
                    while (res < 97) res = res + 26;
                    result.append((char)res);
                }
            }
        }
        TextView resu=(TextView)findViewById((R.id.vig_res));
        resu.setText(result);
    }
}