package com.example.cryptage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class Caesar extends AppCompatActivity {

    private ImageButton esc;
    private Button but_enc,but_dec;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caesar);

        esc = (ImageButton) findViewById(R.id.escape);
        but_enc = (Button) findViewById(R.id.ces_en);
        but_dec = (Button) findViewById(R.id.ces_dec);

        esc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHome();
            }
        });

        but_enc.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                cesEncrypt();
            }
        });

        but_dec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cesDecrypt();
            }
        });
    }
    public void openHome(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void cesEncrypt(){
        String ces_text = ((EditText)findViewById(R.id.ces_text)).getText().toString() ;
        int ces_key = Integer.valueOf(((EditText)findViewById(R.id.ces_key)).getText().toString());
             StringBuffer result= new StringBuffer();
                for (int i=0; i<ces_text.length(); i++)
                {
                    if (Character.isUpperCase(ces_text.charAt(i)))
                    {
                        int res= (int)ces_text.charAt(i)-64+ces_key;
                        while (res>26) res = res - 26;
                        result.append((char)(res+64));
                    }
                    else
                    {
                        int res= (int)ces_text.charAt(i)-96+ces_key;
                        while (res>26) res = res - 26;
                        result.append((char)(res+96));
                    }
                }
        TextView resu=(TextView)findViewById((R.id.ces_res));
        resu.setText(result);
    }
    public void cesDecrypt(){
        String ces_text = ((EditText)findViewById(R.id.ces_text)).getText().toString() ;
        int ces_key = Integer.valueOf(((EditText)findViewById(R.id.ces_key)).getText().toString());
        StringBuffer result= new StringBuffer();
        for (int i=0; i<ces_text.length(); i++)
        {
            if (Character.isUpperCase(ces_text.charAt(i)))
            {
                int res= (int)ces_text.charAt(i)-ces_key;
                while (res<65) res = res + 26;
                result.append((char)res);
            }
            else
            {
                int res= (int)ces_text.charAt(i)-ces_key;
                while (res<97) res = res + 26;
                result.append((char)res);
            }
        }
        TextView resu=(TextView)findViewById((R.id.ces_res));
        resu.setText(result);
    }
}