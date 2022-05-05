package com.example.ques7;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;

public class MainActivity extends AppCompatActivity {

    Button changeColor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        changeColor = findViewById(R.id.button);

        changeColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu(MainActivity.this,changeColor);

                popupMenu.getMenuInflater().inflate(R.menu.menu_bar,popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        ConstraintLayout constraintLayout = findViewById(R.id.main_activity);
                        switch (menuItem.getItemId())
                        {
                            case R.id.red:{
                                constraintLayout.setBackgroundColor(getResources().getColor(R.color.red));
                                break;
                            }
                            case R.id.green:{
                                constraintLayout.setBackgroundColor(getResources().getColor(R.color.green));
                                break;
                            }
                            case R.id.blue:{
                                constraintLayout.setBackgroundColor(getResources().getColor(R.color.blue));
                                break;
                            }
                        }
                        return true;
                    }
                });

                popupMenu.show();
            }
        });
    }
}