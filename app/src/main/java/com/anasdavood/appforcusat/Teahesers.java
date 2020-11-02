package com.anasdavood.appforcusat;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Teahesers extends AppCompatActivity {

    LinearLayout bot,sstatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teahesers);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

        sstatus = findViewById(R.id.sstatus);

        sstatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Dialog dialog;

                    final String[] items = {"09:30 AM", "10:30 AM", "11:30 AM", "12:30 PM", "02:30 PM", "03:30 PM"};


                final ArrayList itemsSelected = new ArrayList();

                AlertDialog.Builder builder = new AlertDialog.Builder(Teahesers.this);

                builder.setTitle("Schedule Class ");

                builder.setMultiChoiceItems(items, null,
                        new DialogInterface.OnMultiChoiceClickListener() {


                            @Override
                            public void onClick(DialogInterface dialog, int selectedItemId,
                                                boolean isSelected) {
                                if (isSelected) {

                                    itemsSelected.add(selectedItemId);
                                } else if (itemsSelected.contains(selectedItemId)) {

                                    itemsSelected.remove(Integer.valueOf(selectedItemId));
                                }
                            }
                        })
                        .setPositiveButton("Set", new DialogInterface.OnClickListener() {
                            @RequiresApi(api = Build.VERSION_CODES.N)
                            @Override
                            public void onClick(DialogInterface dialog, int id) {

                                String set ="";
                                for (Object item1 : itemsSelected){
                                    set = set+item1;
                                }
                                Toast.makeText(Teahesers.this, "Submitted", Toast.LENGTH_SHORT).show();


                                String[] number = set.split("");

                                String list =  Stream.of(number).sorted().collect(Collectors.joining());







                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {





                            }
                        });

                dialog = builder.create();

                dialog.show();



            }
        });

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