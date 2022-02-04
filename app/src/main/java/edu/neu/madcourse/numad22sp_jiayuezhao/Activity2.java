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


        /*
        ConstraintLayout myCL = new ConstraintLayout(this);

        myCL.addView();
        myCL.addView(button);

        setContentView(myCL);


        ConstraintSet csForTV = new ConstraintSet();

        csForTV.constrainHeight(myTV.getId(), ConstraintSet.WRAP_CONTENT);
        csForTV.constrainWidth(myTV.getId(), ConstraintSet.WRAP_CONTENT);

        csForTV.connect(myTV.getId(),ConstraintSet.START,ConstraintSet.PARENT_ID,ConstraintSet.START,0);
        csForTV.connect(myTV.getId(),ConstraintSet.END,myButton.getId(),ConstraintSet.START,0);
        csForTV.connect(myTV.getId(),ConstraintSet.TOP,ConstraintSet.PARENT_ID,ConstraintSet.TOP,0);

        csForTV.applyTo(myCL);

        ConstraintSet csForButton = new ConstraintSet();
        csForButton.constrainHeight(myButton.getId(), ConstraintSet.WRAP_CONTENT);
        csForButton.constrainWidth(myButton.getId(), ConstraintSet.WRAP_CONTENT);
        csForButton.connect(myButton.getId(), ConstraintSet.START, myTV.getId(), ConstraintSet.END, 0);
    */

        setContentView(R.layout.activity_2);
    }

    @SuppressLint({"NonConstantResourceId", "SetTextI18n"})
    public void onClick(View view){
        TextView tv = (TextView) findViewById(R.id.textViewClicky);
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