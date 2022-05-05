package com.example.ques5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_bar,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.Excel:{
                textView.setText(item.getTitle());
                break;
            }
            case R.id.Word:{
                textView.setText(item.getTitle());
                break;
            }
            case R.id.SQL:{
                textView.setText(item.getTitle());
                break;
            }
            case R.id.PHP:{
                textView.setText(item.getTitle());
                break;
            }
            case R.id.exit:{
                textView.setText(item.getTitle());
                break;
            }
        }
        return(super.onOptionsItemSelected(item));
    }
}