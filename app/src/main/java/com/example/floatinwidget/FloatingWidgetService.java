package com.example.floatinwidget;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import static android.content.ContentValues.TAG;

public class FloatingWidgetService extends Service {

    private WindowManager mWindowManager;
    private FloatingWidgetView floatingWidgetView;


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        Log.d(TAG,"Floating Widget Service OnCreate");

        mWindowManager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        floatingWidgetView = new FloatingWidgetView(this);

        //The root element of the collapsed view layout
        final View collapsedView = floatingWidgetView.findViewById(R.id.collapse_view);
        //The root element of the expanded view layout
        final View expandedView = floatingWidgetView.findViewById(R.id.expanded_container);

        //Set Floating Icon
        final ImageView floatingIcon2 = (ImageView) floatingWidgetView.findViewById(R.id.floatingIcon2);
        floatingIcon2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //INVISIBLE만 하면 위젯 아이콘 움직이는데 범위 한계있음.

                //Animation
                expandedView.setAlpha(0f);

                expandedView.setVisibility(View.GONE);
                floatingIcon2.setVisibility(View.INVISIBLE);

                floatingWidgetView.findViewById(R.id.floatingIcon).setVisibility(View.VISIBLE);
            }
        });

    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        Log.d(TAG,"Floating Widget Service OnDestroy");

        if(((FloatingWidgetService)this).mWindowManager != null){
            WindowManager var10000 = this.mWindowManager;
            if (var10000 == null) {

                throw new IllegalStateException();
            }

            FloatingWidgetView var10001 = this.floatingWidgetView;
            if (var10001 == null) {
                throw new IllegalStateException();
            }

            var10000.removeView((View)var10001);
        }
    }
}
