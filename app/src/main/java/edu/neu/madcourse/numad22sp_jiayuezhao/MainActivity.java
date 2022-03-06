package edu.neu.madcourse.numad22sp_jiayuezhao;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void toastMsg(String msg) {
        Toast toast = Toast.makeText(this, msg, Toast.LENGTH_LONG);
        toast.show();
    }

    public void displayToastMsg(View v) {
        toastMsg("Jiayue Zhao, zhao.jiayu@northeastern.edu");
    }

    public void openActivity2(View v){
        Intent intent = new Intent(this, Activity2.class);
        startActivity(intent);
    }

    public void openActivity3(View v){
        Intent intent = new Intent(this, Activity3.class);
        startActivity(intent);
    }

    public void openActivity4(View v){
        Intent intent = new Intent(this, Activity4.class);
        startActivity(intent);
    }
    public void openActivity5(View v){
        Intent intent = new Intent(this, Activity5.class);
        startActivity(intent);
    }
    public void openActivity6(View v){
        Intent intent = new Intent(this, Activity6.class);
        startActivity(intent);
    }

}