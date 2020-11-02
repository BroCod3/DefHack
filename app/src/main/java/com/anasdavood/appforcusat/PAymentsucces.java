package com.anasdavood.appforcusat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.pdf.PdfDocument;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class PAymentsucces extends AppCompatActivity {
      View back;
    String file_name_path = "";
    int PERMISSION_ALL = 1;
    String[] PERMISSIONS = {

            android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
            android.Manifest.permission.READ_EXTERNAL_STORAGE,

    };
    ImageView btndnl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p_aymentsucces);
        back = findViewById(R.id.back);
        btndnl = findViewById(R.id.imgdwonload);

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(PAymentsucces.this, MainActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
            }
        });
       btndnl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               createpdf();
            }
        });
    }

    public void createpdf() {
        Rect bounds = new Rect();
        int pageWidth = 300;
        int pageheight = 470;
        int pathHeight = 2;

        final String fileName = "mypdf";
        file_name_path = "/pdfsdcard_location/" + fileName + ".pdf";
        PdfDocument myPdfDocument = new PdfDocument();
        Paint paint = new Paint();
        Paint paint2 = new Paint();
        Path path = new Path();
        PdfDocument.PageInfo myPageInfo = new PdfDocument.PageInfo.Builder(pageWidth, pageheight, 1).create();
        PdfDocument.Page documentPage = myPdfDocument.startPage(myPageInfo);
        Canvas canvas = documentPage.getCanvas();
        int y = 25; // x = 10,
        int x = 10;
        String name="anas";
        paint.getTextBounds(name, 0, name.length(), bounds);
        x = (canvas.getWidth() / 2) - (bounds.width() / 2);
        canvas.drawText(name, x, y, paint);
        String name2="anas2";
        paint.getTextBounds(name2, 0, name2.length(), bounds);
        x = (canvas.getWidth() / 2) - (bounds.width() / 2);
        y += paint.descent() - paint.ascent();
        canvas.drawText(name2, x, y, paint);

        y += paint.descent() - paint.ascent();
        canvas.drawText("", x, y, paint);

//horizontal line
        path.lineTo(pageWidth, pathHeight);
        paint2.setColor(Color.GRAY);
        paint2.setStyle(Paint.Style.STROKE);
        path.moveTo(x, y);

        canvas.drawLine(0, y, pageWidth, y, paint2);

//blank space
        y += paint.descent() - paint.ascent();
        canvas.drawText("", x, y, paint);

        y += paint.descent() - paint.ascent();
        x = 10;
        canvas.drawText(name, x, y, paint);

        y += paint.descent() - paint.ascent();
        x = 10;
        canvas.drawText(name, x, y, paint);

//blank space
        y += paint.descent() - paint.ascent();
        canvas.drawText("", x, y, paint);

//horizontal line
        path.lineTo(pageWidth, pathHeight);
        paint2.setColor(Color.GRAY);
        paint2.setStyle(Paint.Style.STROKE);
        path.moveTo(x, y);
        canvas.drawLine(0, y, pageWidth, y, paint2);

//blank space
        y += paint.descent() - paint.ascent();
        canvas.drawText("", x, y, paint);

        Resources res = getResources();
        Bitmap bitmap = BitmapFactory.decodeResource(res, R.drawable.checked);
        Bitmap b = (Bitmap.createScaledBitmap(bitmap, 100, 50, false));
        canvas.drawBitmap(b, x, y, paint);
        y += 25;
        canvas.drawText(getString(R.string.app_name), 120, y, paint);


        myPdfDocument.finishPage(documentPage);

        File file = new File(this.getExternalFilesDir(null).getAbsolutePath() + file_name_path);
        try {
            myPdfDocument.writeTo(new FileOutputStream(file));
        } catch (IOException e) {
            e.printStackTrace();
        }

        myPdfDocument.close();
        viewPdfFile();
    }

    public void viewPdfFile() {

        File file = new File(this.getExternalFilesDir(null).getAbsolutePath() + file_name_path);
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(Uri.fromFile(file), "application/pdf");
        startActivity(intent);
    }


    public static boolean hasPermissions(Context context, String... permissions) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && context != null && permissions != null) {
            for (String permission : permissions) {
                if (ActivityCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
                    return false;
                }
            }
        }
        return true;
    }
}