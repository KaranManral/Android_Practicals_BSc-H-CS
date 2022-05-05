package com.example.ques6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        spinner = findViewById(R.id.spinner);

        String[] courses = {"B.Com (Hons.)","B.Sc. (Hons.) Computer Science","B.Sc. (Hons.) Electronics","B.Sc. (Hons.) Mathematics","B.Sc. (Prog.) Mathematical Sciences","BMS","B.Sc. (Hons.) Physics","B.A. (Hons.) Psychology"};
        String[] tic = {"Dr. Shalini Kumar","Ms. Maulein Pathak","Dr. Jyoti Anand","Dr. Rajni Mendiratta","Unknown","Ms. Sonu Mehta","Dr. V.K. Verma","Dr. Daisy Sharma"};

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item,courses);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(arrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                textView.setText(tic[i]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}