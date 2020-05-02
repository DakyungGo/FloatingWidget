package com.example.floatinwidget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

public class PopUpClose extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popup_close);
    }

    public void mYes(View view){

        finish();

        moveTaskToBack(true);   //배경으로 전환되는 애니메이션
        android.os.Process.killProcess(android.os.Process.myPid());
    }

    public void mNo(View view){


        finish();
    }


}
