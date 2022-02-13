package edu.neu.madcourse.numad22sp_jiayuezhao;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_2);
    }

    @SuppressLint({"NonConstantResourceId", "SetTextI18n"})
    public void onClick(View view){
        TextView tv = findViewById(R.id.textViewClicky);
        switch (view.getId()){
            case R.id.button:
                tv.setText("Pressed: A");
                break;
            case R.id.button2:
                tv.setText("Pressed: B");
                break;
            case R.id.button3:
                tv.setText("Pressed: C");
                break;
            case R.id.button4:
                tv.setText("Pressed: D");
                break;
            case R.id.button5:
                tv.setText("Pressed: E");
                break;
            case R.id.button6:
                tv.setText("Pressed: F");
                break;
        }
    }

}