package com.example.floatinwidget;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewDebug;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.content.ContextCompat;

public class ModifyActivity extends AppCompatActivity implements View.OnClickListener{

    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    Button button9;
    Button button10;
    Button GetOut;

    private List<AppList> installedApps;
    private AppAdapter installedAppAdapter;
    ListView userInstalledApps;
    Dialog myDialog;
    private PopupWindow mPopupWindow;
    AppCompatButton clickedButton;

    public static Context acContext;

    AppList clickedApp;
    ArrayList<AppList> buttonApplist;

    ImageView Search_btn;
    String ss = "";

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
                            Drawable icon = getPackageManager().getApplicationIcon(y[2]);
                            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
                                (findViewById(R.id.button1)).setBackgroundDrawable(icon);
                            } else {
                                Button button = new Button(this);
                                button = findViewById(R.id.button1);
                                Drawable d = ContextCompat.getDrawable(this, R.drawable.ico_app_del);
                                ((AppCompatButton) button).setBackground(icon);
                                ((AppCompatButton) button).setForeground(d);
                            }
                            (findViewById(R.id.button1)).setOnClickListener(this);

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
                                Drawable d = ContextCompat.getDrawable(this, R.drawable.ico_app_del);
                                ((AppCompatButton) button).setBackground(icon2);
                                ((AppCompatButton) button).setForeground(d);
                            }
                            (findViewById(R.id.button2)).setOnClickListener(this);

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
                                Drawable d = ContextCompat.getDrawable(this, R.drawable.ico_app_del);
                                ((AppCompatButton) button).setBackground(icon3);
                                ((AppCompatButton) button).setForeground(d);
                            }
                            (findViewById(R.id.button3)).setOnClickListener(this);

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
                                Drawable d = ContextCompat.getDrawable(this, R.drawable.ico_app_del);
                                ((AppCompatButton) button).setBackground(icon4);
                                ((AppCompatButton) button).setForeground(d);
                            }
                            (findViewById(R.id.button4)).setOnClickListener(this);

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
                                Drawable d = ContextCompat.getDrawable(this, R.drawable.ico_app_del);
                                ((AppCompatButton) button).setBackground(icon5);
                                ((AppCompatButton) button).setForeground(d);
                            }
                            (findViewById(R.id.button5)).setOnClickListener(this);

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
                                Drawable d = ContextCompat.getDrawable(this, R.drawable.ico_app_del);
                                ((AppCompatButton) button).setBackground(icon6);
                                ((AppCompatButton) button).setForeground(d);
                            }
                            (findViewById(R.id.button6)).setOnClickListener(this);

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
                                Drawable d = ContextCompat.getDrawable(this, R.drawable.ico_app_del);
                                ((AppCompatButton) button).setBackground(icon7);
                                ((AppCompatButton) button).setForeground(d);
                            }
                            (findViewById(R.id.button7)).setOnClickListener(this);

                            ((TextView) findViewById(R.id.textView7)).setText(y[1]);
                            break;
                        case "button8":
                            PackageManager pm8 = getPackageManager();
                            Drawable icon8 = getPackageManager().getApplicationIcon(y[2]);
                            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
                                (findViewById(R.id.button8)).setBackgroundDrawable(icon8);
                            } else {
                                Button button = new Button(this);
                                button = findViewById(R.id.button8);
                                Drawable d = ContextCompat.getDrawable(this, R.drawable.ico_app_del);
                                ((AppCompatButton) button).setBackground(icon8);
                                ((AppCompatButton) button).setForeground(d);
                            }
                            (findViewById(R.id.button8)).setOnClickListener(this);

                            ((TextView) findViewById(R.id.textView8)).setText(y[1]);
                            break;
                        case "button9":
                            PackageManager pm9 = getPackageManager();
                            Drawable icon9 = getPackageManager().getApplicationIcon(y[2]);
                            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
                                (findViewById(R.id.button9)).setBackgroundDrawable(icon9);
                            } else {
                                Button button = new Button(this);
                                button = findViewById(R.id.button9);
                                Drawable d = ContextCompat.getDrawable(this, R.drawable.ico_app_del);
                                ((AppCompatButton) button).setBackground(icon9);
                                ((AppCompatButton) button).setForeground(d);
                            }
                            (findViewById(R.id.button9)).setOnClickListener(this);

                            ((TextView) findViewById(R.id.textView9)).setText(y[1]);
                            break;
                        case "button10":
                            PackageManager pm10 = getPackageManager();
                            Drawable icon10 = getPackageManager().getApplicationIcon(y[2]);
                            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
                                (findViewById(R.id.button9)).setBackgroundDrawable(icon10);
                            } else {
                                Button button = new Button(this);
                                button = findViewById(R.id.button10);
                                Drawable d = ContextCompat.getDrawable(this, R.drawable.ico_app_del);
                                ((AppCompatButton) button).setBackground(icon10);
                                ((AppCompatButton) button).setForeground(d);
                            }
                            (findViewById(R.id.button10)).setOnClickListener(this);

                            ((TextView) findViewById(R.id.textView10)).setText(y[1]);
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

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify);

        installedApps = getInstalledApps();
        myDialog = new Dialog(this);
        buttonApplist = new ArrayList<AppList>();
        myDialog.setContentView(R.layout.activity_cardview);
        installedAppAdapter = new AppAdapter(myDialog.getContext(), installedApps);
        userInstalledApps = findViewById(R.id.installed_app_list);

        acContext = this;

        buttonApplist.add(new AppList("app",null,""));
        buttonApplist.add(new AppList("app",null,""));
        buttonApplist.add(new AppList("app",null,""));
        buttonApplist.add(new AppList("app",null,""));
        buttonApplist.add(new AppList("app",null,""));
        buttonApplist.add(new AppList("app",null,""));
        buttonApplist.add(new AppList("app",null,""));
        buttonApplist.add(new AppList("app",null,""));
        buttonApplist.add(new AppList("app",null,""));
        buttonApplist.add(new AppList("app",null,""));
        buttonApplist.add(new AppList("app",null,""));
        //
        button1 = (Button)findViewById(R.id.button1);
        button2 = (Button)findViewById(R.id.button2);
        button3 = (Button)findViewById(R.id.button3);
        button4 = (Button)findViewById(R.id.button4);
        button5 = (Button)findViewById(R.id.button5);
        button6 = (Button)findViewById(R.id.button6);
        button7 = (Button)findViewById(R.id.button7);
        button8 = (Button)findViewById(R.id.button8);
        button9 = (Button)findViewById(R.id.button9);
        button10 = (Button)findViewById(R.id.button10);
        //
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        button10.setOnClickListener(this);

        GetOut = (Button)findViewById(R.id.toolbar_modify);
        GetOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View popupView = getLayoutInflater().inflate(R.layout.popup_saveorexit, null);
                Resources r = getResources();
                int width = Math.round(TypedValue.applyDimension(
                        TypedValue.COMPLEX_UNIT_DIP, 254,r.getDisplayMetrics()));
                int height = Math.round(TypedValue.applyDimension(
                        TypedValue.COMPLEX_UNIT_DIP, 150,r.getDisplayMetrics()));
                mPopupWindow = new PopupWindow(popupView, width, height);
                mPopupWindow.setFocusable(true);
                int[] location = new int[2];
                (findViewById(R.id.layout_none)).getLocationOnScreen(location);
                mPopupWindow.showAtLocation(popupView, Gravity.CENTER,0,-115);

                Button SaveButton = popupView.findViewById(R.id.btn_popup_save);
                Button ExitButton = popupView.findViewById(R.id.btn_popup_exit);

                SaveButton.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        String filename = "apkList.txt";
                        String fileContents = getFileContents();
                        FileOutputStream outputStream;
                        //Toast.makeText(activity_add_item.this , getFilesDir().getPath(), Toast.LENGTH_LONG).show();

                        try {
                            outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
                            outputStream.write(fileContents.getBytes());
                            outputStream.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        //일반모드로 전환 다이얼로그
                        Intent intent = new Intent(ModifyActivity.this, PopUpGeneral.class);
                        startActivity(intent);

                        finish();
                    }
                });

                ExitButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        //일반모드로 전환 다이얼로그
                        Intent intent = new Intent(ModifyActivity.this, PopUpGeneral.class);
                        startActivity(intent);
                        finish();
                    }
                });

            }
        });


        int request = getIntent().getIntExtra("request",-1);
        switch(request){
            case 1:
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        button1.callOnClick();
                    }
                },2000);

                break;
            case 2:
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        button2.callOnClick();
                    }
                },2000);

                break;
            case 3:

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        button3.callOnClick();
                    }
                },2000);

                break;
            case 4:
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        button4.callOnClick();
                    }
                },2000);

                break;
            case 5:
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        button5.callOnClick();
                    }
                },2000);

                break;
            case 6:
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        button6.callOnClick();
                    }
                },2000);

                break;
            case 7:
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        button7.callOnClick();
                    }
                },2000);

                break;
            case 8:
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        button8.callOnClick();
                    }
                },2000);

                break;
            case 9:
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        button9.callOnClick();
                    }
                },2000);

                break;
            case 10:
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        button10.callOnClick();
                    }
                },2000);

                break;
            default:
                break;

        }

    }

    private String getStringCompat(String answer, String buttonNumber){
        int startNum = answer.indexOf(answer);
        int endNum = startNum;
        for( int i=startNum; i<answer.length(); i++){
            if( answer.indexOf(i) == '\n'){
                endNum = i;
            }
        }
        return answer.substring(startNum, endNum);
    }

    public String getFileContents(){
        String answer = "";
        StringBuffer strBuffer = new StringBuffer();
        for (String x : strBuffer.toString().split("\n")) {
            final String[] y = x.split("\t");
            for (AppList appList : buttonApplist) {
                if (appList != null) {
                    int numX = buttonApplist.indexOf(appList);
                    String name = appList.getName().replaceAll("\n","");
                    answer += "button" + Integer.toString(numX) + "\t" + name + "\t" + appList.getPackages() + "\t" + "\"drawable://" + appList.getIcon() + "\n";
                }
            }
        }

        int count = 0;
        try {
            InputStream is = new FileInputStream(getFilesDir() + "/apkList.txt");
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String[] lines = answer.split("\n");
            String line;
            while (count != 11) {    //10
                line = reader.readLine();
                if( !lines[count].equals(line) && !lines[count].split("\t")[1].equals("app")) line = lines[count];
                strBuffer.append(line + "\n");
                count +=1;
            }
            answer = strBuffer.toString();
//            String temp = strBuffer.toString();
//            for(String xx : temp.split("\n")) {
//                final String[] yy = xx.split("\t");
//                if (temp.contains(yy[0])) {
//                    //String subString = getStringCompat(answer, yy[0]);
//                    temp = answer.replace(xx, "");
//                }
//            }
//            answer = temp+answer;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return answer;
    }



    public  void dimBehind(PopupWindow popupWindow) {
        View container;
        if (popupWindow.getBackground() == null) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                container = (View) popupWindow.getContentView().getParent();
            } else {
                container = popupWindow.getContentView();
            }
        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                container = (View) popupWindow.getContentView().getParent().getParent();
            } else {
                container = (View) popupWindow.getContentView().getParent();
            }
        }

        LinearLayout cardLayout = (LinearLayout) findViewById( R.id.cardView);
        Context context = popupWindow.getContentView().getContext();
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        WindowManager.LayoutParams p = (WindowManager.LayoutParams) container.getLayoutParams();



        p.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        p.dimAmount = 0.5f;
        wm.updateViewLayout(container, p);
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onClick(View view) {

        int height = (findViewById(R.id.layout_none)).getHeight();

        View popupView = getLayoutInflater().inflate(R.layout.activity_cardview, null);
        mPopupWindow = new PopupWindow(popupView, LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        mPopupWindow = new PopupWindow(popupView, LinearLayout.LayoutParams.WRAP_CONTENT, height);

        mPopupWindow.setFocusable(true);

        int[] location = new int[2];
        (findViewById(R.id.layout_none)).getLocationOnScreen(location);

        // 외부 영역 선택히 PopUp 종료
        mPopupWindow.showAtLocation(popupView,Gravity.CENTER|Gravity.TOP, location[0], location[1]);
        dimBehind(mPopupWindow);

        installedApps = getInstalledApps();
        installedAppAdapter = new AppAdapter(mPopupWindow.getContentView().getContext(), installedApps);
        userInstalledApps = popupView.findViewById(R.id.installed_app_list);
        userInstalledApps.setAdapter(installedAppAdapter);

        String s0 = Integer.toString(installedApps.size());
        Log.d("installed apps",s0);



        Search_btn = popupView.findViewById(R.id.search_btn);
        Search_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText et;
                et = popupView.findViewById(R.id.search_content);
                ss = et.getText().toString();

                Log.d("ddd",ss);
                Log.d("ddd","search btn");

                //userInstalledApps.smoothScrollToPosition(6);
                Log.d("Found!",String.valueOf(installedAppAdapter.getsearchedpos()));
                userInstalledApps.smoothScrollToPosition(installedAppAdapter.getsearchedpos());
            }
        });

        clickedButton = (AppCompatButton) findViewById(view.getId());
        userInstalledApps.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, final int i, long l) {

                final String[] colors = {" Select App (선택)"};
                AlertDialog.Builder builder = new AlertDialog.Builder(mPopupWindow.getContentView().getContext());
                builder.setTitle("Choose Action")
                        .setItems(colors, new DialogInterface.OnClickListener() {
                            @RequiresApi(api = Build.VERSION_CODES.M)
                            public void onClick(DialogInterface dialog, int which) {
                                // The 'which' argument contains the index position of the selected item
                                if (which==0) {
//                                    Intent intent = getPackageManager().getLaunchIntentForPackage(installedApps.get(i).packages);
//                                    if(intent != null){
//                                        startActivity(intent);
//                                    }
                                    clickedButton.setForeground(installedApps.get(i).icon);
                                    clickedButton.setBackground(null);
                                    switch( clickedButton.getId() ){
                                        case R.id.button1:
                                            ((TextView)findViewById(R.id.textView1)).setText(installedApps.get(i).getName());
                                            buttonApplist.set(1, installedApps.get(i));
                                            break;
                                        case R.id.button2:
                                            ((TextView)findViewById(R.id.textView2)).setText(installedApps.get(i).getName());
                                            buttonApplist.set(2, installedApps.get(i));
                                            break;

                                        case R.id.button3:
                                            ((TextView)findViewById(R.id.textView3)).setText(installedApps.get(i).getName());
                                            buttonApplist.set(3, installedApps.get(i));
                                            break;

                                        case R.id.button4:
                                            ((TextView)findViewById(R.id.textView4)).setText(installedApps.get(i).getName());
                                            buttonApplist.set(4, installedApps.get(i));
                                            break;

                                        case R.id.button5:
                                            ((TextView)findViewById(R.id.textView5)).setText(installedApps.get(i).getName());
                                            buttonApplist.set(5, installedApps.get(i));
                                            break;

                                        case R.id.button6:
                                            ((TextView)findViewById(R.id.textView6)).setText(installedApps.get(i).getName());
                                            buttonApplist.set(6, installedApps.get(i));
                                            break;

                                        case R.id.button7:
                                            ((TextView)findViewById(R.id.textView7)).setText(installedApps.get(i).getName());
                                            buttonApplist.set(7, installedApps.get(i));
                                            break;

                                        case R.id.button8:
                                            ((TextView)findViewById(R.id.textView8)).setText(installedApps.get(i).getName());
                                            buttonApplist.set(8, installedApps.get(i));
                                            break;
                                        case R.id.button9:
                                            ((TextView)findViewById(R.id.textView9)).setText(installedApps.get(i).getName());
                                            buttonApplist.set(9, installedApps.get(i));
                                            break;
                                        case R.id.button10:
                                            ((TextView)findViewById(R.id.textView10)).setText(installedApps.get(i).getName());
                                            buttonApplist.set(10, installedApps.get(i));
                                            break;

                                    }
                                    clickedApp = installedApps.get(i);
//                                    else {
//                                        Toast.makeText(mPopupWindow.getContentView().getContext(), installedApps.get(i).packages + " Error, Please Try Again...", Toast.LENGTH_SHORT).show();
//                                    }
                                    mPopupWindow.dismiss();
                                }
                                if (which==1){
//                                    Intent intent = new Intent(android.provider.Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
//                                    intent.setData(Uri.parse("package:" + installedApps.get(i).packages));
//                                    Toast.makeText(mPopupWindow.getContentView().getContext(), installedApps.get(i).packages, Toast.LENGTH_SHORT).show();
//                                    startActivity(intent);
                                    clickedApp = installedApps.get(i);
                                }
                            }
                        });
                builder.show();

            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private List<AppList> getInstalledApps() {
        Log.d("getinstalledapps","getinstalledapps start");

        PackageManager pm = getPackageManager();
        List<AppList> apps = new ArrayList<AppList>();
        List<PackageInfo> packs = getPackageManager().getInstalledPackages(PackageManager.GET_META_DATA);
        //List<PackageInfo> packs = getPackageManager().getInstalledPackages(PackageManager.GET_PERMISSIONS);
        Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        List<ResolveInfo> listCam = getPackageManager().queryIntentActivities(intent, 0);

        for (int i = 0; i < packs.size(); i++) {
            PackageInfo p = packs.get(i);

            listCam.forEach(j -> {
                if (j.activityInfo.packageName.equals(p.applicationInfo.packageName)) {
                    String appName = p.applicationInfo.loadLabel(getPackageManager()).toString();
                    Drawable icon = p.applicationInfo.loadIcon(getPackageManager());
                    String packages = p.applicationInfo.packageName;
                    apps.add(new AppList(appName, icon, packages));
                    Log.d("getinstalledapps",appName);
                }
            });
            if ((!isSystemPackage(p))) {
                String appName = p.applicationInfo.loadLabel(getPackageManager()).toString();
                Drawable icon = p.applicationInfo.loadIcon(getPackageManager());
                String packages = p.applicationInfo.packageName;
                apps.add(new AppList(appName, icon, packages));
                Log.d("getinstalledapps",appName);
            }
        }

        Log.d("getinstalledapps","getinstalledapps end");
        return apps;
    }

    private boolean isSystemPackage(PackageInfo pkgInfo) {
        return (pkgInfo.applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM) != 0;
    }


    public String gettxt1(){
        return ((TextView)findViewById(R.id.textView1)).getText().toString();
    }

    public String gettxt2(){
        return ((TextView)findViewById(R.id.textView2)).getText().toString();
    }

    public String gettxt3(){
        return ((TextView)findViewById(R.id.textView3)).getText().toString();
    }

    public String gettxt4(){
        return ((TextView)findViewById(R.id.textView4)).getText().toString();
    }

    public String gettxt5(){
        return ((TextView)findViewById(R.id.textView5)).getText().toString();
    }

    public String gettxt6(){
        return ((TextView)findViewById(R.id.textView6)).getText().toString();
    }

    public String gettxt7(){
        return ((TextView)findViewById(R.id.textView7)).getText().toString();
    }

    public String gettxt8(){
        return ((TextView)findViewById(R.id.textView8)).getText().toString();
    }

    public String gettxt9(){
        return ((TextView)findViewById(R.id.textView9)).getText().toString();
    }

    public String gettxt10(){
        return ((TextView)findViewById(R.id.textView10)).getText().toString();
    }

    public String getss(){
        return ss;
    }

}
