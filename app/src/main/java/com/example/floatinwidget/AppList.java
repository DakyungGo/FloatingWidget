package com.example.floatinwidget;

import android.graphics.drawable.Drawable;

public class AppList {

    public String name;
    Drawable icon;
    public String packages;
    public AppList(String name, Drawable icon, String packages) {
        this.name = name;
        this.icon = icon;
        this.packages = packages;
    }
    public String getName() {
        return name;
    }
    public Drawable getIcon() {
        return icon;
    }
    public String getPackages() {
        return packages;
    }
}
