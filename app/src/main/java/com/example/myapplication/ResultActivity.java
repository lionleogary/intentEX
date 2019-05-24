package com.example.myapplication;


import android.content.Intent;
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
        setContentView(R.layout.layout2);
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

    }
    public  void onBackClick(View view){
        finish();
    }



}
