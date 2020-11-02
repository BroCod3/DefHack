package com.anasdavood.appforcusat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView home,notibotm;
    View menu,noti;
    TextView txtview,txtteacher;

    LinearLayout bot,sstatus,fee,library,publicchat,adress,mystatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        menu = findViewById(R.id.menu);
        txtview = findViewById(R.id.view_more);
        home = findViewById(R.id.home1);
        notibotm = findViewById(R.id.notibtm);
        bot = findViewById(R.id.bot);
        sstatus = findViewById(R.id.sstatus);
        fee = findViewById(R.id.fee);
        library = findViewById(R.id.library);
        publicchat = findViewById(R.id.publicchat);
        adress = findViewById(R.id.adressbk);
        mystatus = findViewById(R.id.myss);
        txtteacher = findViewById(R.id.txtteacher);

        txtteacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Teahesers.class);
                startActivity(i);
            }
        });


        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "On The Way", Toast.LENGTH_SHORT).show();
            }
        });
        txtview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "On The Way", Toast.LENGTH_SHORT).show();
            }
        });

        notibotm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "On The Way", Toast.LENGTH_SHORT).show();
            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "You are in home", Toast.LENGTH_SHORT).show();
            }
        });
        bot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, BOtmachan.class);
                startActivity(i);
            }
        });
        sstatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, ClassStatus.class);
                startActivity(i);
            }
        });
        fee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, PayMent.class);
                startActivity(i);
            }
        });
        library.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,Library.class);
                startActivity(i);
            }
        });
        publicchat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Work of Philona", Toast.LENGTH_SHORT).show();
            }
        });
        adress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Work of adarsh", Toast.LENGTH_SHORT).show();
            }
        });
        mystatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,Mystatus.class);
                startActivity(i);
            }
        });










        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);






        int[] images = new int[]{R.drawable.svg,R.drawable.svg,R.drawable.svg,R.drawable.svg,R.drawable.svg,R.drawable.svg,R.drawable.svg,R.drawable.svg};
        LinearLayout sv = (LinearLayout) findViewById (R.id.linear);
        for (int i=0 ; i<images.length; i++){
            ImageView iv = new ImageView (this);
            LinearLayout.LayoutParams imageViewLayoutParams = new
                    LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT);
            iv.setPadding(-350,0,-450,0);
            iv.setImageResource(images[i]);
            iv.setLayoutParams(imageViewLayoutParams);
            sv.addView(iv);
        }


    }
}