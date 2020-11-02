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

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

public class ClassStatus extends AppCompatActivity {
    VerticalStepView step_view;
    TextView txtdat,day,am,am2,am3,am4,am6,am5,txt1,txt2,txt3,txt4,txt5,txt6;
    LinearLayout ll1,ll2,ll3,ll4,ll5,ll6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_status);
        ll1= findViewById(R.id.ll1);
        ll2= findViewById(R.id.ll2);
        ll3= findViewById(R.id.ll3);
        ll4= findViewById(R.id.ll4);
        ll5= findViewById(R.id.ll5);
        ll6= findViewById(R.id.ll6);
        am= findViewById(R.id.am);
        am2= findViewById(R.id.am2);
        am3= findViewById(R.id.am3);
        am4= findViewById(R.id.am4);
        am5 = findViewById(R.id.am5);
        am6= findViewById(R.id.am6);
        txt1 = findViewById(R.id.txt1);
        txt2 = findViewById(R.id.txt2);
        txt3 = findViewById(R.id.txt3);
        txt4 = findViewById(R.id.txt4);
        txt5= findViewById(R.id.txt5);
        txt6= findViewById(R.id.txt6);
        status();




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
        SimpleDateFormat sdf = new SimpleDateFormat("HHmm");
        String str = sdf.format(new Date());
        long l = Long.parseLong("0930");
        long ll = Long.parseLong("1030");
        long lll = Long.parseLong("1130");
        int i = Integer.parseInt(str);


        if(i>l)
        {
            am.setTextColor(Color.parseColor("#C4C4C4"));
           // am5.setTextColor(Color.parseColor("#EB5757"));
            txt1.setTextColor(Color.parseColor("#45000000"));
            ll1.setBackgroundResource(R.drawable.ic_boxcompleted);


        }
        if(i>ll)
        {
            am2.setTextColor(Color.parseColor("#C4C4C4"));
            txt2.setTextColor(Color.parseColor("#45000000"));
            ll2.setBackgroundResource(R.drawable.ic_boxcompleted);

        }
        if(i>lll)
        {
            am3.setTextColor(Color.parseColor("#C4C4C4"));
            txt3.setTextColor(Color.parseColor("#45000000"));
            ll3.setBackgroundResource(R.drawable.ic_boxcompleted);



        }
    }







}