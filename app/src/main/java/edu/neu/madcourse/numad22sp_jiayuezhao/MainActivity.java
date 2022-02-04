package edu.neu.madcourse.numad22sp_jiayuezhao;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button clickybutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //setContentView(R.layout.activity_main);
        /*TextView myTV = new TextView(this);
        myTV.setText("Message New");
        myTV.setBackgroundColor(Color.CYAN);
        myTV.setId(R.id.myTextView);
        */


        Button myButton = (Button) findViewById(R.id.clickyButton);
        myButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) { openActivity2();
            }
        });

        /*
        ConstraintLayout myCL = new ConstraintLayout(this);
        myCL.setBackgroundColor(Color.YELLOW);

        myCL.addView(myTV);
        myCL.addView(myButton);

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
    }


    public void toastMsg(String msg) {
        Toast toast = Toast.makeText(this, msg, Toast.LENGTH_LONG);
        toast.show();
    }

    public void displayToastMsg(View v) {
        toastMsg("Jiayue Zhao, zhao.jiayu@northeastern.edu");
    }


    public void openActivity2(){
        Intent intent = new Intent(this, Activity2.class);
        startActivity(intent);
    }

}