package com.example.speedcalculator;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button check = findViewById(R.id.cal);
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final EditText et1 = findViewById(R.id.meter1);
                final EditText et2 = findViewById(R.id.second2);
                TextView t1 = findViewById(R.id.textView4);
                int count1 = et1.length();
                int count2 = et2.length();
                if(count1==0||count2==0){
                    Toast toast = Toast.makeText(MainActivity.this, R.string.add,Toast.LENGTH_SHORT);
                    toast.show();
                }
                else{
                    String numtext = et2.getText().toString();
                    double myDoubleVar = Double.parseDouble(numtext);
                    //String str = String.format(Locale.getDefault(),"%.2f",myDoubleVar);
                    if(myDoubleVar==0){
                        Toast toast = Toast.makeText(MainActivity.this, R.string.zero,Toast.LENGTH_SHORT);
                        toast.show();
                    }
                    else{
                        String numspeed = et1.getText().toString();
                        int speed = Integer.parseInt(numspeed);
                        double result=speed/myDoubleVar*3600/1000;
                        String str = String.format(Locale.getDefault(), "%.2f", result);
                        t1.setText(str);
                        if(result>80){
                            AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                            dialog.setTitle("SPEED CALCULATOR");
                            dialog.setMessage(R.string.calspeed);
                            dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                }
                            });
                            dialog.show();
                        }
                    }
                }
            }
        });
        Button clear = findViewById(R.id.clear1);
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText et1 = findViewById(R.id.meter1);
                EditText et2 = findViewById(R.id.second2);
                TextView t1 = findViewById(R.id.textView4);
                et1.setText("");
                et2.setText("");
                t1.setText("");
            }
        });
    }
}