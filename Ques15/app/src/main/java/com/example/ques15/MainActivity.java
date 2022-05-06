package com.example.ques15;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class MainActivity extends AppCompatActivity {

    Button create,insert,update,view,delete;
    DatabaseFile databaseFile;
    EditText roll,name,dob,phn,email;
    Button send;

    ListView listView;
    LinearLayout ll;

    String sname="",sdob="",phone="",semail="";
    int rno=0,currentRno=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        create = findViewById(R.id.button);
        insert = findViewById(R.id.button2);
        view   = findViewById(R.id.button3);
        update = findViewById(R.id.button4);
        delete = findViewById(R.id.button5);
        roll = findViewById(R.id.editTextNumber);
        name = findViewById(R.id.editTextTextPersonName);
        dob = findViewById(R.id.editTextDate);
        phn = findViewById(R.id.editTextPhone);
        email = findViewById(R.id.editTextTextEmailAddress);
        listView = findViewById(R.id.ListView);
        ll= findViewById(R.id.mainFrame);

        send = findViewById(R.id.insertData);

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(databaseFile == null)
                    databaseFile = new DatabaseFile(MainActivity.this);
                else
                    Toast.makeText(MainActivity.this, "Table Already Exists", Toast.LENGTH_SHORT).show();
            }
        });

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(databaseFile != null){
                    FrameLayout fm = findViewById(R.id.frameLayout);
                    ll.setVisibility(View.GONE);
                    fm.setVisibility(View.VISIBLE);
                    send.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if(roll.getText().toString().equals("")||name.getText().toString().equals("")||dob.getText().toString().equals("")||phn.getText().toString().equals("")||email.getText().toString().equals(""))
                                Toast.makeText(MainActivity.this, "Please fill all columns", Toast.LENGTH_SHORT).show();
                            else
                            {
                                rno = Integer.parseInt(roll.getText().toString());
                                sname = name.getText().toString();
                                sdob = dob.getText().toString();
                                phone = phn.getText().toString();
                                semail = email.getText().toString();

                                fm.setVisibility(View.GONE);
                                ll.setVisibility(View.VISIBLE);

                                try {
                                    Date input = new SimpleDateFormat("yyyy/MM/dd").parse(sdob);
                                    databaseFile.addNewStudent(rno,sname, (java.sql.Date) input,phone,semail);
                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    });
                }
                else
                    Toast.makeText(MainActivity.this, "Table Does not Exist,Create Table First", Toast.LENGTH_SHORT).show();
            }
        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(databaseFile != null){
                    final ArrayList array_list = databaseFile.getAllStudents();
                    final ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1, array_list);
                    listView.setAdapter(arrayAdapter);
                    ll.setVisibility(View.GONE);
                    listView.setVisibility(View.VISIBLE);
                }
                else
                    Toast.makeText(MainActivity.this, "Table Does not Exist,Create Table First", Toast.LENGTH_SHORT).show();
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(databaseFile != null){
                    FrameLayout fm = findViewById(R.id.frameLayout);

                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                    builder.setTitle("Enter current Roll No.");

                    AlertDialog dialog = builder.create();

                    EditText crno = new EditText(MainActivity.this);
                    crno.setInputType(InputType.TYPE_CLASS_NUMBER);
                    crno.setText("0");
                    crno.setEms(12);
                    builder.setView(crno);

                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            currentRno = Integer.parseInt(crno.getText().toString());
                            ll.setVisibility(View.GONE);
                            fm.setVisibility(View.VISIBLE);
                            dialogInterface.dismiss();
                        }
                    });

                    dialog.show();


                    send.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            int rno1 = Integer.parseInt(roll.getText().toString());
                            String sname1 = name.getText().toString();
                            String sdob1 = dob.getText().toString();
                            String phone1 = phn.getText().toString();
                            String semail1 = email.getText().toString();

                            if(rno1==0)
                                rno1 = rno;
                            if(sname1.equals(""))
                                sname1 = sname;
                            if(sdob1.equals(""))
                                sdob1 = sdob;
                            if(phone1.equals(""))
                                phone1 = phone;
                            if(semail1.equals(""))
                                semail1 = semail;

                            fm.setVisibility(View.GONE);
                            ll.setVisibility(View.VISIBLE);

                            try {
                                Date input = new SimpleDateFormat("yyyy/MM/dd").parse(sdob1);
                                databaseFile.updateStudent(currentRno,rno1,sname1, (java.sql.Date) input,phone1,semail1);
                            } catch (ParseException e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }
                else
                    Toast.makeText(MainActivity.this, "Table Does not Exist,Create Table First", Toast.LENGTH_SHORT).show();
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(databaseFile != null){
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                    builder.setTitle("Enter Roll No.");

                    AlertDialog dialog = builder.create();

                    EditText crno = new EditText(MainActivity.this);
                    crno.setInputType(InputType.TYPE_CLASS_NUMBER);
                    crno.setText("0");

                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            currentRno = Integer.parseInt(crno.getText().toString());

                            dialogInterface.dismiss();
                            databaseFile.deleteStudent(currentRno);
                        }
                    });
                    dialog.setView(crno);

                    dialog.show();

                }
                else
                    Toast.makeText(MainActivity.this, "Table Does not Exist,Create Table First", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onBackPressed() {
        FrameLayout frameLayout = findViewById(R.id.frameLayout);
        if(frameLayout.getVisibility()==View.VISIBLE)
            frameLayout.setVisibility(View.GONE);
        if(listView.getVisibility()==View.VISIBLE)
            listView.setVisibility(View.GONE);
        if(ll.getVisibility()==View.GONE)
            ll.setVisibility(View.VISIBLE);
    }
}