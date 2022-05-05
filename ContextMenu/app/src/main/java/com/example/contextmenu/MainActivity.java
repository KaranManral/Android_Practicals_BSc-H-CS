package com.example.contextmenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    String[] contacts={"Amit","Ajay","Nirmal","Sumit","Tina","Uttkarsh","Vishal"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,contacts);
        listView.setAdapter(adapter);

        registerForContextMenu(listView);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu,v,menuInfo);
        getMenuInflater().inflate(R.menu.con_menu,menu);
        menu.setHeaderTitle("Select the Action");
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.call)
            Toast.makeText(this, "Calling", Toast.LENGTH_SHORT).show();
        else if(item.getItemId()==R.id.sms)
            Toast.makeText(this, "Sending SMS", Toast.LENGTH_SHORT).show();
        else
            return false;
        return true;
    }
}