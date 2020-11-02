package com.anasdavood.appforcusat;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.gpfreetech.IndiUpi.IndiUpi;
import com.gpfreetech.IndiUpi.entity.TransactionResponse;
import com.gpfreetech.IndiUpi.listener.PaymentStatusListener;
import com.gpfreetech.IndiUpi.util.Validator;

public class PayMent extends AppCompatActivity implements PaymentStatusListener{
     TextInputEditText admission,yearodadmission,presntsem,fee,latefee,total,share;
     CheckBox checkBox;
     LinearLayout btnpay;
     View back;
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_ment);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);

        admission = findViewById(R.id.admission1);
        yearodadmission = findViewById(R.id.yradd1);
        presntsem = findViewById(R.id.ps1);
        fee = findViewById(R.id.fee1);
        latefee = findViewById(R.id.lfee1);
        total = findViewById(R.id.totl1);
        share = findViewById(R.id.shr1);
        checkBox = findViewById(R.id.checkman);
        btnpay = findViewById(R.id.pay);
        back = findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(PayMent.this, MainActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
            }
        });

        btnpay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String  madmision=admission.getText().toString();
                String  myadmison=yearodadmission.getText().toString();
                String  mpsem=presntsem.getText().toString();
                String  mfee=fee.getText().toString();
                String  mlfee=latefee.getText().toString();
                String  mtotal=total.getText().toString();
                String  mshare=share.getText().toString();

                if(madmision.equals("")){
                    admission.setError("Please Fill Me");

                }
                else if(myadmison.equals("")){

                    yearodadmission.setError("Please Fill Me");

                }
                else if(mpsem.equals("")){

                    presntsem.setError("Please Fill Me");
                }
                else if(mfee.equals("")){

                    fee.setError("Please Fill Me");
                }
                else if(mtotal.equals("")){

                    total.setError("Please Fill Me");
                }
                else {

                    if (checkBox.isChecked()){
                        initPayment();
                    }
                    else {
                        Toast.makeText(PayMent.this, "Please Accept Terms and conditions", Toast.LENGTH_SHORT).show();
                    }


                }

            }
        });

    }




    private void initPayment() {

        String  mtotal=total.getText().toString();
        String amt =mtotal+".00";

        final IndiUpi indiUpi = new IndiUpi.Builder()
                .with(PayMent.this)
                .setPayeeVpa("hafsanv123@okhdfcbank")
                .setPayeeName("CUSAT")
                .setTransactionId(Validator.generateRandom())
                .setTransactionRefId(Validator.generateRandom())
                .setDescription("FEE PAYMENT")
                .setAmount(amt)
                .build();

        indiUpi.setPaymentStatusListener(this);

        indiUpi.pay("PaymentPayload Using");
    }


    public void onTransactionCompleted(TransactionResponse transactionResponse) {
        // Transaction Completed
        Log.d("TransactionResponse", transactionResponse.toString());

    }


    public void onTransactionSuccess(TransactionResponse transactionResponse) {

        Intent i=new Intent(PayMent.this, PAymentsucces.class);
        startActivity(i);

    }


    public void onTransactionSubmitted() {
        // PaymentPayload Pending
        Toast.makeText(this, "Pending | Submitted", Toast.LENGTH_SHORT).show();

    }


    public void onTransactionFailed() {
        // PaymentPayload Failed

        Intent i=new Intent(PayMent.this, Paymentfailed.class);
        startActivity(i);

    }


    public void onTransactionCancelled() {
        // PaymentPayload Cancelled by User
        Toast.makeText(this, "Cancelled", Toast.LENGTH_SHORT).show();

        Intent i=new Intent(PayMent.this, Paymentfailed.class);
        startActivity(i);
    }
}