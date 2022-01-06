package com.example.myapplication;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    EditText etPassword;
    EditText etDob;
    Button btnSignIn;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etName = findViewById(R.id.etName);
        etPassword = findViewById(R.id.etPassword);
        etDob = findViewById(R.id.etDob);
        btnSignIn = findViewById(R.id.btnSignIn);

        Calendar myCalendar= Calendar.getInstance();
        DatePickerDialog.OnDateSetListener date =new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH,month);
                myCalendar.set(Calendar.DAY_OF_MONTH,day);
                String myFormat="MM/dd/yy";
                SimpleDateFormat dateFormat=new SimpleDateFormat(myFormat, Locale.US);
                etDob.setText(dateFormat.format(myCalendar.getTime()));
            }
        };

        etDob.setOnClickListener(new View.OnClickListener() {
                                     @Override
                                     public void onClick(View view) {
                                         new DatePickerDialog(MainActivity.this,
                                                 date,
                                                 myCalendar.get(Calendar.YEAR),
                                                 myCalendar.get(Calendar.MONTH),
                                                 myCalendar.get(Calendar.DAY_OF_MONTH))
                                                 .show();
                                     }
                                 });

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (etName.getText().toString().equals("chike") && etPassword.getText().toString().equals("password")){
                    Toast.makeText(getApplicationContext(),R.string.messsage_login_successful,Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(getApplicationContext(),"Failure",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}