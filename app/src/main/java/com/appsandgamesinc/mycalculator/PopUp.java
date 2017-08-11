package com.appsandgamesinc.mycalculator;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.renderscript.Double2;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;

/**
 * Created by me on 8/9/17.
 */

public class PopUp extends MainActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popup);




//        DisplayMetrics dm = new DisplayMetrics();
//        getWindowManager().getDefaultDisplay().getMetrics(dm);
//
//        int width = dm.widthPixels;
//        int heigt = dm.heightPixels;
//
//        getWindow().setLayout((int) (width*.4),(int) (heigt*.2));
//
//        View.OnClickListener clickListener = new View.OnClickListener()
//        {
//            @Override
//            public void onClick(View view)
//            {
//                startActivity(new Intent(PopUp.this, MainActivity.class));
//            }
//        };
    }

}
