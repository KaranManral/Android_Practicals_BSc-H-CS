package com.example.ques3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn;
    EditText uid,pwd;

    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=findViewById(R.id.button);
        uid=findViewById(R.id.editTextTextEmailAddress);
        pwd=findViewById(R.id.editTextTextPassword);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;
                if((uid.getText().toString()).equals("Test@1234")&&(pwd.getText().toString()).equals("1234@Tested"))
                {
                    Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                    return;
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Wrong Credentials", Toast.LENGTH_SHORT).show();
                }
                if(count>2)
                    Toast.makeText(MainActivity.this, "Username is Test@1234 and Password is 1234@Tested", Toast.LENGTH_LONG).show();
            }
        });
    }
}