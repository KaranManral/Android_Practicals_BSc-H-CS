package com.example.ques2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button inc,dec,reset;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.textView);
        inc = findViewById(R.id.button);
        dec = findViewById(R.id.button2);
        reset = findViewById(R.id.button3);

        inc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int temp = Integer.parseInt(tv.getText().toString());
                temp++;
                tv.setText(Integer.toString(temp));
            }
        });
        dec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int temp = Integer.parseInt(tv.getText().toString());
                temp--;
                tv.setText(Integer.toString(temp));
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv.setText("0");
            }
        });
    }
}