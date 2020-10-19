package com.example.midterm20;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Calendar;

public class Activity2 extends AppCompatActivity {
    EditText name, birthday;
    TextView outText, res;
    String person, year;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        Button bttnAct3= (Button) findViewById(R.id.bttnAct3);
        Button bttn1= (Button) findViewById(R.id.bttnAct1);

        name=(EditText)findViewById(R.id.inputName);
        birthday=(EditText)findViewById(R.id.birthInput);
        outText=(TextView)findViewById(R.id.infoTxtView);

        final RadioGroup radioGroup= (RadioGroup) findViewById(R.id.rdGroup);

        final RadioButton rbMale= (RadioButton) findViewById(R.id.rbMale);
        final RadioButton rbFemale= (RadioButton) findViewById(R.id.rbFemale);

        final Button bttnSub= (Button) findViewById(R.id.buttonSub);

        bttnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(rbMale.isChecked()){
                    person="Mr. ";
                }else {
                    person="Miss ";
                }
                person+= name.getText().toString();
                year= birthday.getText().toString();

                int yr= new Integer(year).intValue();
                String brYear= Integer.toString((2020-yr));



                outText.setText("Hi "+person+", You are "+brYear+" years old");
            }
        });

        //CALENDAR
        res= (TextView) findViewById(R.id.res);
        Button buttonGo= (Button) findViewById(R.id.bttnGo);
        buttonGo.setOnClickListener(new View.OnClickListener() {
         @Override
        public void onClick(View v) {
         new DatePickerDialog(Activity2.this, d,
           c.get(Calendar.YEAR),
           c.get(Calendar.MONTH),
           c.get(Calendar.DAY_OF_MONTH)).show();
        }
         });

        Button buttonBack= (Button) findViewById(R.id.bttnBack);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(Activity2.this, d,
                        c.get(Calendar.YEAR),
                        c.get(Calendar.MONTH),
                        c.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        bttn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Activity2.this, MainActivity.class));

            }
        });

        bttnAct3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Activity2.this, Activity3.class));

            }
        });


    }


     Calendar c= Calendar.getInstance();
    DateFormat dtform= DateFormat.getDateInstance();
     DatePickerDialog.OnDateSetListener d= new DatePickerDialog.OnDateSetListener() {
     @Override
     public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
    c.set(Calendar.YEAR, year);
     c.set(Calendar.MONTH, month);
     c.set(Calendar.DAY_OF_MONTH, dayOfMonth);

     res.setText("Your chose to leave/come back on "+dtform.format(c.getTime()));

    }
     };
}