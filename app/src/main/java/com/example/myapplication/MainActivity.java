package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText etprogramming,etdatastructure,etalgorithm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
    }
    private void findViews(){
        etprogramming=(EditText)findViewById(R.id.etprogramming);
        etalgorithm=(EditText)findViewById(R.id.etalgorithm);
        etdatastructure=(EditText)findViewById(R.id.etdatastructure);
    }
    private boolean isValid(EditText editText){
        String pattern ="1[0]{2}|[0-9]{1,2}";
        String text =editText.getText().toString();
        if (!text.matches(pattern)){
            editText.setError("0~100");
            return  false;

        }else{
            return true;
        }
    }

    public  void onsubmitclick(View view){
        boolean isValid =
                isValid(etprogramming)&isValid(etalgorithm)&isValid(etdatastructure);
        if(!isValid){
            return;
        }
        int programming =Integer.parseInt(etprogramming.getText().toString());
        int dataStructure =Integer.parseInt(etdatastructure.getText().toString());
        int algorithm =Integer.parseInt(etalgorithm.getText().toString());
        Intent intent=new Intent(this,ResultActivity.class);
        Bundle bundle =new Bundle();
        bundle.putInt("programming",programming);
        bundle.putInt("algorithm",algorithm);
        bundle.putInt("datastructure",dataStructure);
        intent.putExtras(bundle);
        startActivity(intent);


    }




}
