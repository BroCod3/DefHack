package com.anasdavood.appforcusat;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.baoyachi.stepview.VerticalStepView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

public class ClassStatus extends AppCompatActivity {
    VerticalStepView step_view;
    TextView txtdat,day,am,am1,am5;
    LinearLayout ll1,ll2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_status);
        ll1= findViewById(R.id.ll1);
        ll2= findViewById(R.id.ll2);
        am= findViewById(R.id.am);
        am1= findViewById(R.id.am2);
        am5 = findViewById(R.id.am5);


        am.setTextColor(Color.parseColor("#C4C4C4"));
        am1.setTextColor(Color.parseColor("#C4C4C4"));
        am5.setTextColor(Color.parseColor("#EB5757"));

        ll1.setBackgroundResource(R.drawable.ic_boxcompleted);
        ll2.setBackgroundResource(R.drawable.ic_boxcompleted);


        txtdat =findViewById(R.id.txtdate);
        day=findViewById(R.id.txtday);

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

       String date1 = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault()).format(new Date());
       String day1 = (String) DateFormat.format("EEEE" , new Date());
       txtdat.setText(date1);
       day.setText(day1);

        String currentTime = new SimpleDateFormat("HH:mm", Locale.getDefault()).format(new Date());




    }

    public void status(){
        String currentTime = new SimpleDateFormat("HH:mm", Locale.getDefault()).format(new Date());

    }







}