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
import android.widget.Toast;

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
    View vdc1,vdc2,vdc3,vdc4,vdc5,vdc6;
    View vdl1,vdl2,vdl3,vdl4,vdl5;

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

        vdc1= findViewById(R.id.vdc1);
        vdc2= findViewById(R.id.vdc2);
        vdc3= findViewById(R.id.vdc3);
        vdc4= findViewById(R.id.vdc4);
        vdc5= findViewById(R.id.vdc5);
        vdc6= findViewById(R.id.vdc6);

        vdl1= findViewById(R.id.vline1);
        vdl2= findViewById(R.id.vlines2);
        vdl3= findViewById(R.id.vlines3);
        vdl4= findViewById(R.id.vlines4);
        vdl5= findViewById(R.id.vlines5);
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

        int i = Integer.parseInt(str);


        if(i>930)
        {
            am.setTextColor(Color.parseColor("#C4C4C4"));
           // am5.setTextColor(Color.parseColor("#EB5757"));
            txt1.setTextColor(Color.parseColor("#45000000"));
            ll1.setBackgroundResource(R.drawable.ic_boxcompleted);
            vdc1.setVisibility(View.VISIBLE);


        }
        if(i>1030)
        {
            am2.setTextColor(Color.parseColor("#C4C4C4"));
            txt2.setTextColor(Color.parseColor("#45000000"));
            ll2.setBackgroundResource(R.drawable.ic_boxcompleted);
            vdc1.setVisibility(View.VISIBLE);
            vdl1.setVisibility(View.VISIBLE);
            vdc2.setVisibility(View.VISIBLE);

        }
        if(i>1130)
        {
            am3.setTextColor(Color.parseColor("#C4C4C4"));
            txt3.setTextColor(Color.parseColor("#45000000"));
            ll3.setBackgroundResource(R.drawable.ic_boxcompleted);
            vdc1.setVisibility(View.VISIBLE);
            vdl1.setVisibility(View.VISIBLE);
            vdc2.setVisibility(View.VISIBLE);
            vdl2.setVisibility(View.VISIBLE);
            vdc3.setVisibility(View.VISIBLE);



        }
        if(i>1230)
        {
            am4.setTextColor(Color.parseColor("#C4C4C4"));
            txt4.setTextColor(Color.parseColor("#45000000"));
            ll4.setBackgroundResource(R.drawable.ic_boxcompleted);

            vdc1.setVisibility(View.VISIBLE);
            vdl1.setVisibility(View.VISIBLE);
            vdc2.setVisibility(View.VISIBLE);
            vdl2.setVisibility(View.VISIBLE);
            vdc3.setVisibility(View.VISIBLE);
            vdl3.setVisibility(View.VISIBLE);
            vdc4.setVisibility(View.VISIBLE);



        }
        if(i>1430)
        {
            am5.setTextColor(Color.parseColor("#C4C4C4"));
            txt5.setTextColor(Color.parseColor("#45000000"));
            ll5.setBackgroundResource(R.drawable.ic_boxcompleted);
            vdc1.setVisibility(View.VISIBLE);
            vdl1.setVisibility(View.VISIBLE);
            vdc2.setVisibility(View.VISIBLE);
            vdl2.setVisibility(View.VISIBLE);
            vdc3.setVisibility(View.VISIBLE);
            vdl3.setVisibility(View.VISIBLE);
            vdc4.setVisibility(View.VISIBLE);
            vdl4.setVisibility(View.VISIBLE);
            vdc5.setVisibility(View.VISIBLE);



        }
        if(i>1530)
        {
            am6.setTextColor(Color.parseColor("#C4C4C4"));
            txt6.setTextColor(Color.parseColor("#45000000"));
            ll6.setBackgroundResource(R.drawable.ic_boxcompleted);

            vdc1.setVisibility(View.VISIBLE);
            vdl1.setVisibility(View.VISIBLE);
            vdc2.setVisibility(View.VISIBLE);
            vdl2.setVisibility(View.VISIBLE);
            vdc3.setVisibility(View.VISIBLE);
            vdl3.setVisibility(View.VISIBLE);
            vdc4.setVisibility(View.VISIBLE);
            vdl4.setVisibility(View.VISIBLE);
            vdc5.setVisibility(View.VISIBLE);
            vdl5.setVisibility(View.VISIBLE);
            vdc6.setVisibility(View.VISIBLE);



        }
    }







}