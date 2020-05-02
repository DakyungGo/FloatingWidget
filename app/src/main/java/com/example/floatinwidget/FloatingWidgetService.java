package com.example.floatinwidget;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import static android.content.ContentValues.TAG;

public class FloatingWidgetService extends Service {

    private WindowManager mWindowManager;
    private FloatingWidgetView floatingWidgetView;


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
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
        final ImageView btn_close = (ImageView) floatingWidgetView.findViewById(R.id.close_button);
        btn_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //INVISIBLE만 하면 위젯 아이콘 움직이는데 범위 한계있음.

                //Animation
                expandedView.setAlpha(0f);

                expandedView.setVisibility(View.GONE);
                btn_close.setVisibility(View.INVISIBLE);

                floatingWidgetView.findViewById(R.id.floatingIcon).setVisibility(View.VISIBLE);
            }
        });


        StringBuffer strBuffer = new StringBuffer();
        try {
            InputStream is = new FileInputStream(getFilesDir() + "/apkList.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line = "";
            while((line = reader.readLine())!= null){
                strBuffer.append(line + "\n");
            }
            for(String x : strBuffer.toString().split("\n")){
                final String y[] = x.split("\t");
                try{
                    switch (y[0]){
                        case "button1":
                            PackageManager pm = this.getPackageManager();
                            Drawable icon1 = getPackageManager().getApplicationIcon(y[2]);

                            if(Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN){}
                            else{}
                            Button btn1 = (Button)floatingWidgetView.findViewById(R.id.button1);
                            btn1.setForeground(icon1);
                            btn1.setBackground(null);
                            btn1.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {

                                    ((MainActivity)MainActivity.mContext).finish();

                                    //Toast.makeText(getApplicationContext(),"touched",Toast.LENGTH_SHORT).show();
                                    Intent intent= getPackageManager().getLaunchIntentForPackage(y[2]);
                                    intent.putExtra("package","package"+y[2]);
                                    intent.setData(Uri.parse("package:"+y[2]));
                                    startActivity(intent);
                                }
                            });

                            TextView t1 = (TextView)floatingWidgetView.findViewById(R.id.textView1);
                            t1.setText(y[1]);
                            break;

                        case "button2":
                            PackageManager pm2 = this.getPackageManager();
                            Drawable icon2 = getPackageManager().getApplicationIcon(y[2]);
                            Button btn2 = (Button)floatingWidgetView.findViewById(R.id.button2);
                            btn2.setForeground(icon2);
                            btn2.setBackground(null);
                            btn2.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {

                                    ((MainActivity)MainActivity.mContext).finish();

                                    Intent intent= getPackageManager().getLaunchIntentForPackage(y[2]);
                                    intent.putExtra("package","package"+y[2]);
                                    intent.setData(Uri.parse("package:"+y[2]));
                                    startActivity(intent);
                                }
                            });

                            TextView t2 = (TextView)floatingWidgetView.findViewById(R.id.textView2);
                            t2.setText(y[1]);
                            break;

                        case "button3":
                            PackageManager pm3 = this.getPackageManager();
                            Drawable icon3 = getPackageManager().getApplicationIcon(y[2]);
                            Button btn3 = (Button)floatingWidgetView.findViewById(R.id.button3);
                            btn3.setForeground(icon3);
                            btn3.setBackground(null);
                            btn3.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {

                                    ((MainActivity)MainActivity.mContext).finish();

                                    Intent intent= getPackageManager().getLaunchIntentForPackage(y[2]);
                                    intent.putExtra("package","package"+y[2]);
                                    intent.setData(Uri.parse("package:"+y[2]));
                                    startActivity(intent);

                                }
                            });

                            TextView t3 = (TextView)floatingWidgetView.findViewById(R.id.textView3);
                            t3.setText(y[1]);
                            break;

                        case "button4":
                            PackageManager pm4 = this.getPackageManager();
                            Drawable icon4 = getPackageManager().getApplicationIcon(y[2]);
                            Button btn4 = (Button)floatingWidgetView.findViewById(R.id.button4);
                            btn4.setForeground(icon4);
                            btn4.setBackground(null);
                            btn4.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {

                                    ((MainActivity)MainActivity.mContext).finish();

                                    Intent intent= getPackageManager().getLaunchIntentForPackage(y[2]);
                                    intent.putExtra("package","package"+y[2]);
                                    intent.setData(Uri.parse("package:"+y[2]));
                                    startActivity(intent);
                                }
                            });

                            TextView t4 = (TextView)floatingWidgetView.findViewById(R.id.textView4);
                            t4.setText(y[1]);
                            break;
                        case "button5":
                            PackageManager pm5 = this.getPackageManager();
                            Drawable icon5 = getPackageManager().getApplicationIcon(y[2]);
                            Button btn5 = (Button)floatingWidgetView.findViewById(R.id.button5);
                            btn5.setForeground(icon5);
                            btn5.setBackground(null);
                            btn5.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {

                                    ((MainActivity)MainActivity.mContext).finish();

                                    Intent intent= getPackageManager().getLaunchIntentForPackage(y[2]);
                                    intent.putExtra("package","package"+y[2]);
                                    intent.setData(Uri.parse("package:"+y[2]));
                                    startActivity(intent);
                                }
                            });

                            TextView t5 = (TextView)floatingWidgetView.findViewById(R.id.textView5);
                            t5.setText(y[1]);
                            break;
                        case "button6":
                            PackageManager pm6 = this.getPackageManager();
                            Drawable icon6 = getPackageManager().getApplicationIcon(y[2]);
                            Button btn6 = (Button)floatingWidgetView.findViewById(R.id.button6);
                            btn6.setForeground(icon6);
                            btn6.setBackground(null);
                            btn6.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {

                                    ((MainActivity)MainActivity.mContext).finish();

                                    Intent intent= getPackageManager().getLaunchIntentForPackage(y[2]);
                                    intent.putExtra("package","package"+y[2]);
                                    intent.setData(Uri.parse("package:"+y[2]));
                                    startActivity(intent);
                                }
                            });

                            TextView t6 = (TextView)floatingWidgetView.findViewById(R.id.textView6);
                            t6.setText(y[1]);
                            break;
                        case "button7":
                            PackageManager pm7 = this.getPackageManager();
                            Drawable icon7 = getPackageManager().getApplicationIcon(y[2]);
                            Button btn7 = (Button)floatingWidgetView.findViewById(R.id.button7);
                            btn7.setForeground(icon7);
                            btn7.setBackground(null);
                            btn7.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {

                                    ((MainActivity)MainActivity.mContext).finish();

                                    Intent intent= getPackageManager().getLaunchIntentForPackage(y[2]);
                                    intent.putExtra("package","package"+y[2]);
                                    intent.setData(Uri.parse("package:"+y[2]));
                                    startActivity(intent);
                                }
                            });

                            TextView t7 = (TextView)floatingWidgetView.findViewById(R.id.textView7);
                            t7.setText(y[1]);
                            break;
                        case "button8":
                            PackageManager pm8 = this.getPackageManager();
                            Drawable icon8 = getPackageManager().getApplicationIcon(y[2]);
                            Button btn8 = (Button)floatingWidgetView.findViewById(R.id.button8);
                            btn8.setForeground(icon8);
                            btn8.setBackground(null);
                            btn8.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {

                                    ((MainActivity)MainActivity.mContext).finish();

                                    Intent intent= getPackageManager().getLaunchIntentForPackage(y[2]);
                                    intent.putExtra("package","package"+y[2]);
                                    intent.setData(Uri.parse("package:"+y[2]));
                                    startActivity(intent);
                                }
                            });

                            TextView t8 = (TextView)floatingWidgetView.findViewById(R.id.textView8);
                            t8.setText(y[1]);
                            break;
                        case "button9":
                            PackageManager pm9 = this.getPackageManager();
                            Drawable icon9 = getPackageManager().getApplicationIcon(y[2]);
                            Button btn9 = (Button)floatingWidgetView.findViewById(R.id.button9);
                            btn9.setForeground(icon9);
                            btn9.setBackground(null);
                            btn9.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {

                                    ((MainActivity)MainActivity.mContext).finish();

                                    Intent intent= getPackageManager().getLaunchIntentForPackage(y[2]);
                                    intent.putExtra("package","package"+y[2]);
                                    intent.setData(Uri.parse("package:"+y[2]));
                                    startActivity(intent);
                                }
                            });

                            TextView t9 = (TextView)floatingWidgetView.findViewById(R.id.textView9);
                            t9.setText(y[1]);
                            break;
                        case "button10":
                            PackageManager pm10 = this.getPackageManager();
                            Drawable icon10 = getPackageManager().getApplicationIcon(y[2]);
                            Button btn10 = (Button)floatingWidgetView.findViewById(R.id.button10);
                            btn10.setForeground(icon10);
                            btn10.setBackground(null);
                            btn10.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {

                                    ((MainActivity)MainActivity.mContext).finish();

                                    Intent intent= getPackageManager().getLaunchIntentForPackage(y[2]);
                                    intent.putExtra("package","package"+y[2]);
                                    intent.setData(Uri.parse("package:"+y[2]));
                                    startActivity(intent);
                                }
                            });

                            TextView t10 = (TextView)floatingWidgetView.findViewById(R.id.textView10);
                            t10.setText(y[1]);
                            break;

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }



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
