package com.example.floatinwidget;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AppAdapter extends BaseAdapter {

    public LayoutInflater layoutInflater;
    public List<AppList> listStorage;

    private int pos = 0;

    public AppAdapter(Context context, List<AppList> customizedListView) {
        layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        listStorage = customizedListView;
    }

    @Override
    public int getCount() {
        return listStorage.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        ViewHolder listViewHolder;
        if (convertView == null) {
            listViewHolder = new ViewHolder();
            convertView = layoutInflater.inflate(R.layout.installed_app_list, parent, false);

            listViewHolder.textInListView = (TextView) convertView.findViewById(R.id.list_app_name);
            listViewHolder.imageInListView = (ImageView) convertView.findViewById(R.id.app_icon);
            listViewHolder.packageInListView = (TextView) convertView.findViewById(R.id.app_package);
            convertView.setTag(listViewHolder);
        } else {
            listViewHolder = (ViewHolder) convertView.getTag();
        }
        listViewHolder.textInListView.setText(listStorage.get(position).getName());
        listViewHolder.imageInListView.setImageDrawable(listStorage.get(position).getIcon());
        listViewHolder.packageInListView.setText(listStorage.get(position).getPackages());

        Log.d("listviewholder",listViewHolder.textInListView.getText().toString());

        //        convertView.setBackgroundColor(Color.BLUE);

        if (listStorage.get(position).getName().equals(((ModifyActivity) ModifyActivity.acContext).gettxt1())
                || listStorage.get(position).getName().equals(((ModifyActivity) ModifyActivity.acContext).gettxt2())
                || listStorage.get(position).getName().equals(((ModifyActivity) ModifyActivity.acContext).gettxt3())
                || listStorage.get(position).getName().equals(((ModifyActivity) ModifyActivity.acContext).gettxt4())
                || listStorage.get(position).getName().equals(((ModifyActivity) ModifyActivity.acContext).gettxt5())
                || listStorage.get(position).getName().equals(((ModifyActivity) ModifyActivity.acContext).gettxt6())
                || listStorage.get(position).getName().equals(((ModifyActivity) ModifyActivity.acContext).gettxt7())
                || listStorage.get(position).getName().equals(((ModifyActivity) ModifyActivity.acContext).gettxt8())
                || listStorage.get(position).getName().equals(((ModifyActivity) ModifyActivity.acContext).gettxt9())
                || listStorage.get(position).getName().equals(((ModifyActivity) ModifyActivity.acContext).gettxt10())) {

            convertView.setBackgroundColor(Color.GRAY);
        } else {
            convertView.setBackgroundColor(Color.WHITE);
        }


        return convertView;
    }

    public int getsearchedpos(){

        String s1 = ((ModifyActivity)ModifyActivity.acContext).getss();
        String appname = "";

        if(s1.equals("")){
            Log.d("ddd","empty");

        }else{
            Log.d("ddd","notempty");

            for(int i=0; i<listStorage.size(); i++){
                Log.d("Looking",listStorage.get(i).getName() + " ^^ " +s1);
                appname = listStorage.get(i).getName();

                if(appname.contains(s1)
                        ||appname.toLowerCase().contains(s1.toLowerCase())
                        ||appname.equalsIgnoreCase(s1)){
                    pos = i;
                    Log.d("Found","looking for pos");
                    break;
                }
            }

        }


        return pos;
    }

    class ViewHolder{
        TextView textInListView;
        ImageView imageInListView;
        TextView packageInListView;
    }

}
