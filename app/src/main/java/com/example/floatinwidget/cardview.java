package com.example.floatinwidget;

import android.content.Context;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class cardview extends AppCompatActivity {

    EditText Search_Content;
    ImageView Search_btn;
    ListView installed_AppList;
    public static Context cardContext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardview);

        cardContext = this;

        Search_Content = (EditText)findViewById(R.id.search_content);
        Search_btn = (ImageView) findViewById(R.id.search_btn);
        installed_AppList = (ListView) findViewById(R.id.installed_app_list);



    }

}
