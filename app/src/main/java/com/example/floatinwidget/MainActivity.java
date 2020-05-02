package com.example.floatinwidget;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private static final int DRAW_OVERLAYS_PERMISSION_REQUEST_CODE = 666;

    Button tb_General;
    Button btn_float;

    public static Context mContext;


    public void ToolBarOnClick(View v){
        tb_General = (Button)findViewById(R.id.toolbar_general);

        switch(v.getId()) {

            case R.id.toolbar_general:

//                //다이얼로그
                Intent intent = new Intent(MainActivity.this, PopUpModify.class);
                startActivity(intent);

                Timer timer = new Timer();
                timer.schedule( new TimerTask()
                                {
                                    public void run()
                                    {
                                        Intent nextintent = new Intent(MainActivity.this, ModifyActivity.class);
                                        startActivity(nextintent);
                                    }
                                }
                        , 1000);



                break;


        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        //다이얼로그
        Intent intent2 = new Intent(MainActivity.this, PopUpClose.class);
        startActivity(intent2);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public  void onResume() {
        super.onResume();

        StringBuffer strBuffer = new StringBuffer();
        try {
            InputStream is = new FileInputStream(getFilesDir() + "/apkList.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line = "";
            while ((line = reader.readLine()) != null) {
                strBuffer.append(line + "\n");
            }
            for (String x : strBuffer.toString().split("\n")) {
                final String[] y = x.split("\t");
                if( y[1] == "app"){
                    continue;
                }
                try {
                    switch (y[0]) {
                        case "button1":
                            PackageManager pm = this.getPackageManager();
                            Drawable draw1 = pm.getApplicationIcon(y[2]);
                            Drawable icon = draw1;
                            //Drawable icon = pm.getApplicationIcon(y[2]);
                            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
                                (findViewById(R.id.button1)).setBackgroundDrawable(icon);
                            } else {
                                Button button = new Button(this);
                                button = findViewById(R.id.button1);
                                ((AppCompatButton) button).setForeground(icon);
                                ((AppCompatButton) button).setBackground(null);
                            }
                            (findViewById(R.id.button1)).setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {

                                    finish();

                                    Intent in1 = getPackageManager().getLaunchIntentForPackage(y[2]);
                                    in1.putExtra("package", "package"+y[2]);
                                    in1.setData(Uri.parse("package:" + y[2]));

//                                            Intent intent = getPackageManager().getLaunchIntentForPackage(y[2]);
//                                            intent.putExtra("package", "package"+y[2]);
//                                            intent.setData(Uri.parse("package:" + y[2]));

                                    startActivity(in1);

//                                    Intent intent = getPackageManager().getLaunchIntentForPackage(y[2]);
//                                    intent.putExtra("package", "package"+y[2]);
//                                    intent.setData(Uri.parse("package:" + y[2]));
                                    //startActivity(intent);
                                }
                            });

                            ((TextView) findViewById(R.id.textView1)).setText(y[1]);
                            break;
                        case "button2":
                            PackageManager pm2 = getPackageManager();
                            Drawable icon2 = getPackageManager().getApplicationIcon(y[2]);
                            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
                                (findViewById(R.id.button2)).setBackgroundDrawable(icon2);
                            } else {
                                Button button = new Button(this);
                                button = findViewById(R.id.button2);
                                ((AppCompatButton) button).setForeground(icon2);
                                ((AppCompatButton) button).setBackground(null);
                            }
                            (findViewById(R.id.button2)).setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {

                                    finish();

                                    Intent intent = getPackageManager().getLaunchIntentForPackage(y[2]);
                                    intent.putExtra("package", "package"+y[2]);
                                    intent.setData(Uri.parse("package:" + y[2]));
                                    startActivity(intent);

//                                    Intent intent = getPackageManager().getLaunchIntentForPackage(y[2]);
//                                    intent.putExtra("package", "package"+y[2]);
//                                    intent.setData(Uri.parse("package:" + y[2]));
                                    //startActivity(intent);
                                }
                            });

                            ((TextView) findViewById(R.id.textView2)).setText(y[1]);
                            break;

                        case "button3":
                            PackageManager pm3 = getPackageManager();
                            Drawable icon3 = getPackageManager().getApplicationIcon(y[2]);
                            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
                                (findViewById(R.id.button3)).setBackgroundDrawable(icon3);
                            } else {
                                Button button = new Button(this);
                                button = findViewById(R.id.button3);
                                ((AppCompatButton) button).setForeground(icon3);
                                ((AppCompatButton) button).setBackground(null);
                            }
                            (findViewById(R.id.button3)).setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {

                                    finish();

                                    Intent intent = getPackageManager().getLaunchIntentForPackage(y[2]);
                                    intent.putExtra("package", "package"+y[2]);
                                    intent.setData(Uri.parse("package:" + y[2]));
                                    startActivity(intent);

//                                    Intent intent = getPackageManager().getLaunchIntentForPackage(y[2]);
//                                    intent.putExtra("package", "package"+y[2]);
//                                    intent.setData(Uri.parse("package:" + y[2]));
                                    //startActivity(intent);
                                }
                            });

                            ((TextView) findViewById(R.id.textView3)).setText(y[1]);
                            break;

                        case "button4":
                            PackageManager pm4 = getPackageManager();
                            Drawable icon4 = getPackageManager().getApplicationIcon(y[2]);
                            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
                                (findViewById(R.id.button4)).setBackgroundDrawable(icon4);
                            } else {
                                Button button = new Button(this);
                                button = findViewById(R.id.button4);
                                ((AppCompatButton) button).setForeground(icon4);
                                ((AppCompatButton) button).setBackground(null);
                            }
                            (findViewById(R.id.button4)).setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {

                                    finish();

                                    Intent intent = getPackageManager().getLaunchIntentForPackage(y[2]);
                                    intent.putExtra("package", "package"+y[2]);
                                    intent.setData(Uri.parse("package:" + y[2]));
                                    startActivity(intent);

//                                    Intent intent = getPackageManager().getLaunchIntentForPackage(y[2]);
//                                    intent.putExtra("package", "package"+y[2]);
//                                    intent.setData(Uri.parse("package:" + y[2]));
                                    //startActivity(intent);
                                }
                            });

                            ((TextView) findViewById(R.id.textView4)).setText(y[1]);
                            break;

                        case "button5":
                            PackageManager pm5 = getPackageManager();
                            Drawable icon5 = getPackageManager().getApplicationIcon(y[2]);
                            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
                                (findViewById(R.id.button5)).setBackgroundDrawable(icon5);
                            } else {
                                Button button = new Button(this);
                                button = findViewById(R.id.button5);
                                ((AppCompatButton) button).setForeground(icon5);
                                ((AppCompatButton) button).setBackground(null);
                            }
                            (findViewById(R.id.button5)).setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {

                                    finish();

                                    Intent intent = getPackageManager().getLaunchIntentForPackage(y[2]);
                                    intent.putExtra("package", "package"+y[2]);
                                    intent.setData(Uri.parse("package:" + y[2]));
                                    startActivity(intent);

//                                    Intent intent = getPackageManager().getLaunchIntentForPackage(y[2]);
//                                    intent.putExtra("package", "package"+y[2]);
//                                    intent.setData(Uri.parse("package:" + y[2]));
                                    //startActivity(intent);
                                }
                            });

                            ((TextView) findViewById(R.id.textView5)).setText(y[1]);
                            break;
                        case "button6":
                            PackageManager pm6 = getPackageManager();
                            Drawable icon6 = getPackageManager().getApplicationIcon(y[2]);
                            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
                                (findViewById(R.id.button6)).setBackgroundDrawable(icon6);
                            } else {
                                Button button = new Button(this);
                                button = findViewById(R.id.button6);
                                ((AppCompatButton) button).setForeground(icon6);
                                ((AppCompatButton) button).setBackground(null);
                            }
                            (findViewById(R.id.button6)).setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Log.d("6번",y[1]);

                                    finish();

                                    Intent intent = getPackageManager().getLaunchIntentForPackage(y[2]);
                                    intent.putExtra("package", "package"+y[2]);
                                    intent.setData(Uri.parse("package:" + y[2]));
                                    startActivity(intent);

//                                    Intent intent = getPackageManager().getLaunchIntentForPackage(y[2]);
//                                    intent.putExtra("package", "package"+y[2]);
//                                    intent.setData(Uri.parse("package:" + y[2]));
                                    //startActivity(intent);
                                }
                            });

                            ((TextView) findViewById(R.id.textView6)).setText(y[1]);
                            break;
                        case "button7":
                            PackageManager pm7 = getPackageManager();
                            Drawable icon7 = getPackageManager().getApplicationIcon(y[2]);
                            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
                                (findViewById(R.id.button7)).setBackgroundDrawable(icon7);
                            } else {
                                Button button = new Button(this);
                                button = findViewById(R.id.button7);
                                ((AppCompatButton) button).setForeground(icon7);
                                ((AppCompatButton) button).setBackground(null);
                            }
                            ((TextView) findViewById(R.id.textView7)).setText(y[1]);
                            (findViewById(R.id.button7)).setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Log.d("7번",y[1]);

                                    finish();

                                    Intent intent = getPackageManager().getLaunchIntentForPackage(y[2]);
                                    intent.putExtra("package", "package"+y[2]);
                                    intent.setData(Uri.parse("package:" + y[2]));
                                    startActivity(intent);

//                                    Intent intent = getPackageManager().getLaunchIntentForPackage(y[2]);
//                                    intent.putExtra("package", "package"+y[2]);
//                                    intent.setData(Uri.parse("package:" + y[2]));
                                    //startActivity(intent);
                                }
                            });


                            break;
                        case "button8":
                            PackageManager pm8 = getPackageManager();
                            Drawable icon8 = getPackageManager().getApplicationIcon(y[2]);
                            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
                                (findViewById(R.id.button8)).setBackgroundDrawable(icon8);
                            } else {
                                Button button = new Button(this);
                                button = findViewById(R.id.button8);
                                ((AppCompatButton) button).setForeground(icon8);
                                ((AppCompatButton) button).setBackground(null);
                            }
                            ((TextView) findViewById(R.id.textView8)).setText(y[1]);
                            (findViewById(R.id.button8)).setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Log.d("8번",y[1]);
                                    finish();

                                    Intent intent = getPackageManager().getLaunchIntentForPackage(y[2]);
                                    intent.putExtra("package", "package" + y[2]);
                                    intent.setData(Uri.parse("package:" + y[2]));
                                    startActivity(intent);
//                                    Intent intent = getPackageManager().getLaunchIntentForPackage(y[2]);
//                                    intent.putExtra("package", "package"+y[2]);
//                                    intent.setData(Uri.parse("package:" + y[2]));
                                    //startActivity(intent);
                                }
                            });


                            break;
                        case "button9":
                            PackageManager pm9 = getPackageManager();
                            Drawable icon9 = getPackageManager().getApplicationIcon(y[2]);
                            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
                                (findViewById(R.id.button9)).setBackgroundDrawable(icon9);
                            } else {
                                Button button = new Button(this);
                                button = findViewById(R.id.button9);
                                ((AppCompatButton) button).setForeground(icon9);
                                ((AppCompatButton) button).setBackground(null);
                            }
                            ((TextView) findViewById(R.id.textView9)).setText(y[1]);
                            (findViewById(R.id.button9)).setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Log.d("9번",y[1]);

                                    finish();

                                    Intent intent = getPackageManager().getLaunchIntentForPackage(y[2]);
                                    intent.putExtra("package", "package"+y[2]);
                                    intent.setData(Uri.parse("package:" + y[2]));
                                    startActivity(intent);

//                                    Intent intent = getPackageManager().getLaunchIntentForPackage(y[2]);
//                                    intent.putExtra("package", "package"+y[2]);
//                                    intent.setData(Uri.parse("package:" + y[2]));
                                    //startActivity(intent);
                                }
                            });


                            break;
                        case "button10":
                            PackageManager pm10 = getPackageManager();
                            Drawable icon10 = getPackageManager().getApplicationIcon(y[2]);
                            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
                                (findViewById(R.id.button9)).setBackgroundDrawable(icon10);
                            } else {
                                Button button = new Button(this);
                                button = findViewById(R.id.button10);
                                ((AppCompatButton) button).setForeground(icon10);
                                ((AppCompatButton) button).setBackground(null);
                            }
                            ((TextView) findViewById(R.id.textView10)).setText(y[1]);
                            (findViewById(R.id.button10)).setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Log.d("10번",y[1]);

                                    finish();

                                    Intent intent = getPackageManager().getLaunchIntentForPackage(y[2]);
                                    intent.putExtra("package", "package"+y[2]);
                                    intent.setData(Uri.parse("package:" + y[2]));
                                    startActivity(intent);

                                }
                            });

                            break;
                    }
                } catch (PackageManager.NameNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        writeToSDFile();

        ///플로팅 위젯 사용을 위한 윈도우 오버레이 허용////
        if(!isDrawOverlaysAllowed()){
            requestForDrawingOverAppsPermission();
        }

        mContext = this;

        ConstraintLayout cl = (ConstraintLayout)findViewById(R.id.mainactivity_layout);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar1);
//        setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayShowTitleEnabled(false);

        btn_float = (Button)findViewById(R.id.btn_float);
        btn_float.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startFloatingWidgetMaybe();

            }
        });


        StringBuffer strBuffer = new StringBuffer();
        try {
            Log.d("apklist","try to read");
            Log.d("apklist",getFilesDir().toString());
            InputStream is = new FileInputStream(getFilesDir() + "/apkList.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line = "";
            while ((line = reader.readLine()) != null) {
                strBuffer.append(line + "\n");
            }
            for (String x : strBuffer.toString().split("\n")) {
                final String[] y = x.split("\t");
                try {
                    switch (y[0]) {
                        case "button1":
                            PackageManager pm = this.getPackageManager();
                            Drawable icon = getPackageManager().getApplicationIcon(y[2]);
                            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
                                (cl.findViewById(R.id.button1)).setBackgroundDrawable(icon);
                            } else {
                                Button button = new Button(this);
                                button = cl.findViewById(R.id.button1);
                             //   ((AppCompatButton) button).setForeground(icon);
                                ((AppCompatButton) button).setBackground(null);
                            }
                            (findViewById(R.id.button1)).setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {

                                    finish();

                                    Intent in1 = getPackageManager().getLaunchIntentForPackage(y[2]);
                                    in1.putExtra("package","package"+y[2]);
                                    in1.setData(Uri.parse("package:"+y[2]));

//                                            Intent intent = getPackageManager().getLaunchIntentForPackage(y[2]);
//                                            intent.putExtra("package", "package"+y[2]);
//                                            intent.setData(Uri.parse("package:" + y[2]));
                                    //moveBtn1();
                                    startActivity(in1);

                                }
                            });
                            String tv1 = y[1];
                            ((TextView) findViewById(R.id.textView1)).setText(tv1);
                            //((TextView) findViewById(R.id.textView1)).setText(y[1]);
                            break;
                        case "button2":
                            PackageManager pm2 = getPackageManager();
                            Drawable icon2 = getPackageManager().getApplicationIcon(y[2]);
                            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
                                (cl.findViewById(R.id.button2)).setBackgroundDrawable(icon2);
                            } else {
                                Button button = new Button(this);
                                button = findViewById(R.id.button2);
                            //  ((AppCompatButton) button).setForeground(icon2);
                                ((AppCompatButton) button).setBackground(null);
                            }
                            (findViewById(R.id.button2)).setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {

                                    finish();

                                    Intent intent = getPackageManager().getLaunchIntentForPackage(y[2]);
                                    intent.putExtra("package", "package"+y[2]);
                                    intent.setData(Uri.parse("package:" + y[2]));
                                    startActivity(intent);
                                    finish();

//                                    Intent intent = getPackageManager().getLaunchIntentForPackage(y[2]);
//                                    intent.putExtra("package", "package"+y[2]);
//                                    intent.setData(Uri.parse("package:" + y[2]));
                                    //startActivity(intent);
                                }
                            });

                            ((TextView) findViewById(R.id.textView2)).setText(y[1]);
                            break;

                        case "button3":
                            PackageManager pm3 = getPackageManager();
                            Drawable icon3 = getPackageManager().getApplicationIcon(y[2]);
                            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
                                (cl.findViewById(R.id.button3)).setBackgroundDrawable(icon3);
                            } else {
                                Button button = new Button(this);
                                button = findViewById(R.id.button3);
                             //   ((AppCompatButton) button).setForeground(icon3);
                                ((AppCompatButton) button).setBackground(null);
                            }
                            (findViewById(R.id.button3)).setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {

                                    finish();

                                    Intent intent = getPackageManager().getLaunchIntentForPackage(y[2]);
                                    intent.putExtra("package", "package"+y[2]);
                                    intent.setData(Uri.parse("package:" + y[2]));
                                    startActivity(intent);

//                                    Intent intent = getPackageManager().getLaunchIntentForPackage(y[2]);
//                                    intent.putExtra("package", "package"+y[2]);
//                                    intent.setData(Uri.parse("package:" + y[2]));
                                    //startActivity(intent);
                                }
                            });

                            ((TextView) findViewById(R.id.textView3)).setText(y[1]);
                            break;

                        case "button4":
                            PackageManager pm4 = getPackageManager();
                            Drawable icon4 = getPackageManager().getApplicationIcon(y[2]);
                            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
                                (findViewById(R.id.button4)).setBackgroundDrawable(icon4);
                            } else {
                                Button button = new Button(this);
                                button = findViewById(R.id.button4);
                               // ((AppCompatButton) button).setForeground(icon4);
                                ((AppCompatButton) button).setBackground(null);
                            }
                            (findViewById(R.id.button4)).setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {

                                    finish();

                                    Intent intent = getPackageManager().getLaunchIntentForPackage(y[2]);
                                    intent.putExtra("package", "package"+y[2]);
                                    intent.setData(Uri.parse("package:" + y[2]));
                                    startActivity(intent);

//                                    Intent intent = getPackageManager().getLaunchIntentForPackage(y[2]);
//                                    intent.putExtra("package", "package"+y[2]);
//                                    intent.setData(Uri.parse("package:" + y[2]));
                                    //startActivity(intent);
                                }
                            });

                            ((TextView) findViewById(R.id.textView4)).setText(y[1]);
                            break;

                        case "button5":
                            PackageManager pm5 = getPackageManager();
                            Drawable icon5 = getPackageManager().getApplicationIcon(y[2]);
                            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
                                (findViewById(R.id.button5)).setBackgroundDrawable(icon5);
                            } else {
                                Button button = new Button(this);
                                button = findViewById(R.id.button5);
                               // ((AppCompatButton) button).setForeground(icon5);
                                ((AppCompatButton) button).setBackground(null);
                            }
                            (findViewById(R.id.button5)).setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {

                                    finish();

                                    Intent intent = getPackageManager().getLaunchIntentForPackage(y[2]);
                                    intent.putExtra("package", "package"+y[2]);
                                    intent.setData(Uri.parse("package:" + y[2]));
                                    startActivity(intent);

//                                    Intent intent = getPackageManager().getLaunchIntentForPackage(y[2]);
//                                    intent.putExtra("package", "package"+y[2]);
//                                    intent.setData(Uri.parse("package:" + y[2]));
                                    //startActivity(intent);
                                }
                            });

                            ((TextView) findViewById(R.id.textView5)).setText(y[1]);
                            break;
                        case "button6":
                            PackageManager pm6 = getPackageManager();
                            Drawable icon6 = getPackageManager().getApplicationIcon(y[2]);
                            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
                                (findViewById(R.id.button6)).setBackgroundDrawable(icon6);
                            } else {
                                Button button = new Button(this);
                                button = findViewById(R.id.button6);
                               // ((AppCompatButton) button).setForeground(icon6);
                                ((AppCompatButton) button).setBackground(null);
                            }
                            (findViewById(R.id.button6)).setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Log.d("6번",y[1]);

                                    finish();

                                    Intent intent = getPackageManager().getLaunchIntentForPackage(y[2]);
                                    intent.putExtra("package", "package"+y[2]);
                                    intent.setData(Uri.parse("package:" + y[2]));
                                    startActivity(intent);

//                                    Intent intent = getPackageManager().getLaunchIntentForPackage(y[2]);
//                                    intent.putExtra("package", "package"+y[2]);
//                                    intent.setData(Uri.parse("package:" + y[2]));
                                    //startActivity(intent);
                                }
                            });

                            ((TextView) findViewById(R.id.textView6)).setText(y[1]);
                            break;
                        case "button7":
                            PackageManager pm7 = getPackageManager();
                            Drawable icon7 = getPackageManager().getApplicationIcon(y[2]);
                            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
                                (findViewById(R.id.button7)).setBackgroundDrawable(icon7);
                            } else {
                                Button button = new Button(this);
                                button = findViewById(R.id.button7);
                                //((AppCompatButton) button).setForeground(icon7);
                                ((AppCompatButton) button).setBackground(null);
                            }
                            ((TextView) findViewById(R.id.textView7)).setText(y[1]);
                            (findViewById(R.id.button7)).setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Log.d("7번",y[1]);

                                    finish();

                                    Intent intent = getPackageManager().getLaunchIntentForPackage(y[2]);
                                    intent.putExtra("package", "package"+y[2]);
                                    intent.setData(Uri.parse("package:" + y[2]));
                                    startActivity(intent);

//                                    Intent intent = getPackageManager().getLaunchIntentForPackage(y[2]);
//                                    intent.putExtra("package", "package"+y[2]);
//                                    intent.setData(Uri.parse("package:" + y[2]));
                                    //startActivity(intent);
                                }
                            });

                            break;
                        case "button8":
                            PackageManager pm8 = getPackageManager();
                            Drawable icon8 = getPackageManager().getApplicationIcon(y[2]);
                            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
                                (findViewById(R.id.button8)).setBackgroundDrawable(icon8);
                            } else {
                                Button button = new Button(this);
                                button = findViewById(R.id.button8);
                                //((AppCompatButton) button).setForeground(icon8);
                                ((AppCompatButton) button).setBackground(null);
                            }
                            ((TextView) findViewById(R.id.textView8)).setText(y[1]);

                            (findViewById(R.id.button8)).setOnClickListener(new View.OnClickListener() {

                                @Override
                                public void onClick(View v) {

                                    Log.d("8번",y[1]);

                                    finish();

                                    Intent intent = getPackageManager().getLaunchIntentForPackage(y[2]);
                                    intent.putExtra("package", "package" + y[2]);
                                    intent.setData(Uri.parse("package:" + y[2]));
                                    startActivity(intent);

//                                    Intent intent = getPackageManager().getLaunchIntentForPackage(y[2]);
//                                    intent.putExtra("package", "package"+y[2]);
//                                    intent.setData(Uri.parse("package:" + y[2]));
                                    //startActivity(intent);
                                }
                            });

                            break;
                        case "button9":
                            PackageManager pm9 = getPackageManager();
                            Drawable icon9 = getPackageManager().getApplicationIcon(y[2]);
                            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
                                (findViewById(R.id.button9)).setBackgroundDrawable(icon9);
                            } else {
                                Button button = new Button(this);
                                button = findViewById(R.id.button9);
                               // ((AppCompatButton) button).setForeground(icon9);
                                ((AppCompatButton) button).setBackground(null);
                            }
                            ((TextView) findViewById(R.id.textView9)).setText(y[1]);
                            (findViewById(R.id.button9)).setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Log.d("9번",y[1]);

                                    finish();

                                    Intent intent = getPackageManager().getLaunchIntentForPackage(y[2]);
                                    intent.putExtra("package", "package"+y[2]);
                                    intent.setData(Uri.parse("package:" + y[2]));
                                    startActivity(intent);

//                                    Intent intent = getPackageManager().getLaunchIntentForPackage(y[2]);
//                                    intent.putExtra("package", "package"+y[2]);
//                                    intent.setData(Uri.parse("package:" + y[2]));
                                    //startActivity(intent);
                                }
                            });


                            break;
                        case "button10":
                            PackageManager pm10 = getPackageManager();
                            Drawable icon10 = getPackageManager().getApplicationIcon(y[2]);
                            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
                                (findViewById(R.id.button10)).setBackgroundDrawable(icon10);
                            } else {
                                Button button = new Button(this);
                                button = findViewById(R.id.button10);
                                // ((AppCompatButton) button).setForeground(icon9);
                                ((AppCompatButton) button).setBackground(null);
                            }
                            ((TextView) findViewById(R.id.textView10)).setText(y[1]);
                            (findViewById(R.id.button10)).setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Log.d("10번",y[1]);

                                    finish();

                                    Intent intent = getPackageManager().getLaunchIntentForPackage(y[2]);
                                    intent.putExtra("package", "package"+y[2]);
                                    intent.setData(Uri.parse("package:" + y[2]));
                                    startActivity(intent);

                                }
                            });


                            break;
                    }
                } catch (PackageManager.NameNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        }
//        catch(FileNotFoundException ex){
//            File dir = getFilesDir();
//            File file = new File("apkList.txt");
//        }
        catch(Exception ex) {
            ex.printStackTrace();
        }

        (findViewById(R.id.button1)).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Log.d("1번",(findViewById(R.id.textView1)).getContext().toString());

                Intent nextIntent = new Intent(MainActivity.this, ModifyActivity.class);
                nextIntent.putExtra("request",1);
                startActivity(nextIntent);
            }
        });
        (findViewById(R.id.button2)).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Log.d("2번",(findViewById(R.id.textView6)).getContext().toString());

                Intent nextIntent = new Intent(MainActivity.this, ModifyActivity.class);
                nextIntent.putExtra("request",2);
                startActivity(nextIntent);
            }
        });
        (findViewById(R.id.button3)).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Log.d("3번",(findViewById(R.id.textView3)).getContext().toString());

                Intent nextIntent = new Intent(MainActivity.this, ModifyActivity.class);
                nextIntent.putExtra("request",3);
                startActivity(nextIntent);
            }
        });
        (findViewById(R.id.button4)).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Log.d("4번",(findViewById(R.id.textView4)).getContext().toString());

                Intent nextIntent = new Intent(MainActivity.this, ModifyActivity.class);
                nextIntent.putExtra("request",4);
                startActivity(nextIntent);
            }
        });
        (findViewById(R.id.button5)).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Log.d("5번",(findViewById(R.id.textView5)).getContext().toString());

                Intent nextIntent = new Intent(MainActivity.this, ModifyActivity.class);
                nextIntent.putExtra("request",5);
                startActivity(nextIntent);
            }
        });
        (findViewById(R.id.button6)).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Log.d("6번",(findViewById(R.id.textView6)).getContext().toString());

                Intent nextIntent = new Intent(MainActivity.this, ModifyActivity.class);
                nextIntent.putExtra("request",6);
                startActivity(nextIntent);
            }
        });
        (findViewById(R.id.button7)).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Log.d("7번",(findViewById(R.id.textView7)).getContext().toString());

                Intent nextIntent = new Intent(MainActivity.this, ModifyActivity.class);
                nextIntent.putExtra("request",7);
                startActivity(nextIntent);
            }
        });
        (findViewById(R.id.button8)).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Log.d("8번",(findViewById(R.id.textView8)).getContext().toString());

                Intent nextIntent = new Intent(MainActivity.this, ModifyActivity.class);
                nextIntent.putExtra("request",8);
                startActivity(nextIntent);
            }
        });
        (findViewById(R.id.button9)).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Log.d("9번",(findViewById(R.id.textView9)).getContext().toString());

                Intent nextIntent = new Intent(MainActivity.this, ModifyActivity.class);
                nextIntent.putExtra("request",9);
                startActivity(nextIntent);
            }
        });
        (findViewById(R.id.button10)).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Log.d("10번",(findViewById(R.id.textView10)).getContext().toString());

                Intent nextIntent = new Intent(MainActivity.this, ModifyActivity.class);
                nextIntent.putExtra("request",10);
                startActivity(nextIntent);
            }
        });


        final boolean[] isLongPress = {false};
        final int duration = 3000;
        final Handler somehandler = new Handler();

        (findViewById(R.id.button1)).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                final Runnable someCall = new Runnable() {
                    @Override
                    public void run() {
                        if(isLongPress[0]){
                            //////code here
                            Intent nextIntent = new Intent(MainActivity.this, ModifyActivity.class);
                            nextIntent.putExtra("request",1);
                            startActivity(nextIntent);
                        }
                    }
                };

                int eventAction = motionEvent.getAction();
                if(eventAction == MotionEvent.ACTION_DOWN){
                    isLongPress[0] = true;
                    somehandler.postDelayed(someCall, duration);
                }
                else if(eventAction == MotionEvent.ACTION_UP){
                    isLongPress[0] = false;
                    somehandler.removeCallbacks(someCall);
                }
                return false;
            }
        });

        (findViewById(R.id.button2)).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                final Runnable someCall = new Runnable() {
                    @Override
                    public void run() {
                        if(isLongPress[0]){
                            //////code here
                            Intent nextIntent = new Intent(MainActivity.this, ModifyActivity.class);
                            nextIntent.putExtra("request",2);
                            startActivity(nextIntent);
                        }
                    }
                };

                int eventAction = motionEvent.getAction();
                if(eventAction == MotionEvent.ACTION_DOWN){
                    isLongPress[0] = true;
                    somehandler.postDelayed(someCall, duration);
                }
                else if(eventAction == MotionEvent.ACTION_UP){
                    isLongPress[0] = false;
                    somehandler.removeCallbacks(someCall);
                }
                return false;
            }
        });
        (findViewById(R.id.button3)).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                final Runnable someCall = new Runnable() {
                    @Override
                    public void run() {
                        if(isLongPress[0]){
                            //////code here
                            Intent nextIntent = new Intent(MainActivity.this, ModifyActivity.class);
                            nextIntent.putExtra("request",3);
                            startActivity(nextIntent);
                        }
                    }
                };

                int eventAction = motionEvent.getAction();
                if(eventAction == MotionEvent.ACTION_DOWN){
                    isLongPress[0] = true;
                    somehandler.postDelayed(someCall, duration);
                }
                else if(eventAction == MotionEvent.ACTION_UP){
                    isLongPress[0] = false;
                    somehandler.removeCallbacks(someCall);
                }
                return false;
            }
        });
        (findViewById(R.id.button4)).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                final Runnable someCall = new Runnable() {
                    @Override
                    public void run() {
                        if(isLongPress[0]){
                            //////code here
                            Intent nextIntent = new Intent(MainActivity.this, ModifyActivity.class);
                            nextIntent.putExtra("request",4);
                            startActivity(nextIntent);
                        }
                    }
                };

                int eventAction = motionEvent.getAction();
                if(eventAction == MotionEvent.ACTION_DOWN){
                    isLongPress[0] = true;
                    somehandler.postDelayed(someCall, duration);
                }
                else if(eventAction == MotionEvent.ACTION_UP){
                    isLongPress[0] = false;
                    somehandler.removeCallbacks(someCall);
                }
                return false;
            }
        });
        (findViewById(R.id.button5)).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                final Runnable someCall = new Runnable() {
                    @Override
                    public void run() {
                        if(isLongPress[0]){
                            //////code here
                            Intent nextIntent = new Intent(MainActivity.this, ModifyActivity.class);
                            nextIntent.putExtra("request",5);
                            startActivity(nextIntent);
                        }
                    }
                };

                int eventAction = motionEvent.getAction();
                if(eventAction == MotionEvent.ACTION_DOWN){
                    isLongPress[0] = true;
                    somehandler.postDelayed(someCall, duration);
                }
                else if(eventAction == MotionEvent.ACTION_UP){
                    isLongPress[0] = false;
                    somehandler.removeCallbacks(someCall);
                }
                return false;
            }
        });
        (findViewById(R.id.button6)).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                final Runnable someCall = new Runnable() {
                    @Override
                    public void run() {
                        if(isLongPress[0]){
                            //////code here
                            Intent nextIntent = new Intent(MainActivity.this, ModifyActivity.class);
                            nextIntent.putExtra("request",6);
                            startActivity(nextIntent);
                        }
                    }
                };

                int eventAction = motionEvent.getAction();
                if(eventAction == MotionEvent.ACTION_DOWN){
                    isLongPress[0] = true;
                    somehandler.postDelayed(someCall, duration);
                }
                else if(eventAction == MotionEvent.ACTION_UP){
                    isLongPress[0] = false;
                    somehandler.removeCallbacks(someCall);
                }
                return false;
            }
        });
        (findViewById(R.id.button7)).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                final Runnable someCall = new Runnable() {
                    @Override
                    public void run() {
                        if(isLongPress[0]){
                            //////code here
                            Intent nextIntent = new Intent(MainActivity.this, ModifyActivity.class);
                            nextIntent.putExtra("request",7);
                            startActivity(nextIntent);
                        }
                    }
                };

                int eventAction = motionEvent.getAction();
                if(eventAction == MotionEvent.ACTION_DOWN){
                    isLongPress[0] = true;
                    somehandler.postDelayed(someCall, duration);
                }
                else if(eventAction == MotionEvent.ACTION_UP){
                    isLongPress[0] = false;
                    somehandler.removeCallbacks(someCall);
                }
                return false;
            }
        });
        (findViewById(R.id.button8)).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                final Runnable someCall = new Runnable() {
                    @Override
                    public void run() {
                        if(isLongPress[0]){
                            //////code here
                            Intent nextIntent = new Intent(MainActivity.this, ModifyActivity.class);
                            nextIntent.putExtra("request",8);
                            startActivity(nextIntent);
                        }
                    }
                };

                int eventAction = motionEvent.getAction();
                if(eventAction == MotionEvent.ACTION_DOWN){
                    isLongPress[0] = true;
                    somehandler.postDelayed(someCall, duration);
                }
                else if(eventAction == MotionEvent.ACTION_UP){
                    isLongPress[0] = false;
                    somehandler.removeCallbacks(someCall);
                }
                return false;
            }
        });
        (findViewById(R.id.button9)).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                final Runnable someCall = new Runnable() {
                    @Override
                    public void run() {
                        if(isLongPress[0]){
                            //////code here
                            Intent nextIntent = new Intent(MainActivity.this, ModifyActivity.class);
                            nextIntent.putExtra("request",9);
                            startActivity(nextIntent);
                        }
                    }
                };

                int eventAction = motionEvent.getAction();
                if(eventAction == MotionEvent.ACTION_DOWN){
                    isLongPress[0] = true;
                    somehandler.postDelayed(someCall, duration);
                }
                else if(eventAction == MotionEvent.ACTION_UP){
                    isLongPress[0] = false;
                    somehandler.removeCallbacks(someCall);
                }
                return false;
            }
        });
        (findViewById(R.id.button10)).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                final Runnable someCall = new Runnable() {
                    @Override
                    public void run() {
                        if(isLongPress[0]){
                            //////code here
                            Intent nextIntent = new Intent(MainActivity.this, ModifyActivity.class);
                            nextIntent.putExtra("request",10);
                            startActivity(nextIntent);
                        }
                    }
                };

                int eventAction = motionEvent.getAction();
                if(eventAction == MotionEvent.ACTION_DOWN){
                    isLongPress[0] = true;
                    somehandler.postDelayed(someCall, duration);
                }
                else if(eventAction == MotionEvent.ACTION_UP){
                    isLongPress[0] = false;
                    somehandler.removeCallbacks(someCall);
                }
                return false;
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


    private void writeToSDFile(){
        // Here, thisActivity is the current activity
        if (ContextCompat.checkSelfPermission(MainActivity.this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {

            // Permission is not granted
            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.
            } else {
                // No explanation needed; request the permission
                ActivityCompat.requestPermissions(MainActivity.this,
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                        1);

                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
        } else {
            // Permission has already been granted
        }
        // Find the root of the external storage.
        // See http://developer.android.com/guide/topics/data/data-  storage.html#filesExternal

        File root = android.os.Environment.getExternalStorageDirectory();

        // See http://stackoverflow.com/questions/3551821/android-write-to-sd-card-folder

        File dir = new File (root.getAbsolutePath() + "/download");
        dir.mkdirs();
        File file = new File(dir, "myData.txt");

        try {
            FileOutputStream f = new FileOutputStream(file);
            PrintWriter pw = new PrintWriter(f);

            StringBuffer strBuffer = new StringBuffer();
            InputStream is = new FileInputStream(getFilesDir() + "/apkList.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line = "";
            while ((line = reader.readLine()) != null) {
                strBuffer.append(line + "\n");
            }

            pw.println(strBuffer.toString());
            pw.flush();
            pw.close();
            f.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Toast.makeText(this,"ERROR OCCUR!", Toast.LENGTH_LONG);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}
