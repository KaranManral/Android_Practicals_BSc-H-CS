package com.example.ques4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = findViewById(R.id.spinner);
        imageView = findViewById(R.id.imageView);

        String[] arraySpinner = getResources().getStringArray(R.array.images);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item,arraySpinner);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i)
                {
                    case 0:{
                        imageView.setImageDrawable(getResources().getDrawable(R.drawable.tj));
                        break;
                    }
                    case 1:{
                        imageView.setImageDrawable(getResources().getDrawable(R.drawable.oggy));
                        break;
                    }
                    case 2:{
                        imageView.setImageDrawable(getResources().getDrawable(R.drawable.b10));
                        break;
                    }
                    case 3:{
                        imageView.setImageDrawable(getResources().getDrawable(R.drawable.doremon));
                        break;
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}