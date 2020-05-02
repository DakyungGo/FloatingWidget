package com.example.floatinwidget;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

import java.util.Timer;
import java.util.TimerTask;

import androidx.annotation.Nullable;

public class PopUpGeneral extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.popup_general);

        Timer timer = new Timer();
        timer.schedule( new TimerTask()
                        {
                            public void run()
                            {
                                finish();
                            }
                        }
                , 1000);

    }
}
