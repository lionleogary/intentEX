package com.example.myapplication;


import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

public class ResultActivity extends AppCompatActivity{
    private TextView tvResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        tvResult=(TextView)findViewById(R.id.tvResult);
        showResults();

    }
    private void showResults(){
        NumberFormat nf=NumberFormat.getInstance();
        Bundle bundle=getIntent().getExtras();
        int programming =bundle.getInt("programming");
        int datastructure =bundle.getInt("datastructure");
        int algorithm=bundle.getInt("algorithm");
        int sum=programming+datastructure+algorithm;
        double average=sum/3.0;
        String text="programming="+programming+
                "\ndataStructure="+datastructure+
                "\nalgorithm="+algorithm+
                "\nsum="+sum+
                "\naverage="+nf.format(average);
        tvResult.setText(text);
        alert(average);


    }
    private void alert(double average){
        String message=new String();
        String tittle=new String();
        int pic=0;
        if(average==100){
            message="100";
            tittle="pass";
            pic=R.drawable.circle;
        }
        else if(average>=60){
            message="congratulation";
            tittle="pass";
            pic=R.drawable.circle;
        }
        else {
            message="fail";
            tittle="fail";
            pic=R.drawable.circle;
        }
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setMessage(message);
        builder.setTitle(tittle);
        builder.setIcon(pic);
        builder.setPositiveButton("OK",null);
        builder.setNegativeButton("Cancel",null);
        builder.setNeutralButton("Nothing",null);
        builder.show();


    }
    public  void onBackClick(View view){
        finish();
    }



}
