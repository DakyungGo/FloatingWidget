package com.example.floatinwidget;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final int DRAW_OVERLAYS_PERMISSION_REQUEST_CODE = 666;

    Button btn_float;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ///플로팅 위젯 사용을 위한 윈도우 오버레이 허용////
        if(!isDrawOverlaysAllowed()){
            requestForDrawingOverAppsPermission();
        }

        btn_float = (Button)findViewById(R.id.btn_float);
        btn_float.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startFloatingWidgetMaybe();

            }
        });

    }


    //Floating Widget//
    public final void startFloatingWidgetMaybe() {
        if (isDrawOverlaysAllowed()) {
            startService(new Intent((Context)this, FloatingWidgetService.class));

            return;
        } else {
            requestForDrawingOverAppsPermission();
        }
    }

    private final void requestForDrawingOverAppsPermission() {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M
                && !Settings.canDrawOverlays(getApplicationContext())){
            Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION, Uri.parse("package:" + this.getPackageName()));
            startActivityForResult(intent, DRAW_OVERLAYS_PERMISSION_REQUEST_CODE);
        }

    }

    private final boolean isDrawOverlaysAllowed() {
        return Build.VERSION.SDK_INT < 23 || Settings.canDrawOverlays((Context)this);
    }
}
