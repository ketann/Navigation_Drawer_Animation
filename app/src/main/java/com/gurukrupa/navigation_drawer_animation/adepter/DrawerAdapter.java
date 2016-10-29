package com.gurukrupa.navigation_drawer_animation.adepter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.gurukrupa.navigation_drawer_animation.R;

import java.util.ArrayList;

/**
 * Created by GURUKRUPA on 10/29/2016.
 */

public class DrawerAdapter extends BaseAdapter {

    private LayoutInflater mInflater;
    private ArrayList<String> mDataList;

    /**
     * Default constructor
     */

    public DrawerAdapter(Context context, ArrayList<String> stringArrayList) {
        this.mInflater = LayoutInflater.from(context);
        this.mDataList = stringArrayList;
    }


    @Override
    public int getCount() {
        return mDataList.size();
    }

    @Override
    public Object getItem(int position) {
        return mDataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            holder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.item_drawer, parent, false);
            holder.itemTitle = (TextView) convertView.findViewById(R.id.title);
            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.itemTitle.setText(mDataList.get(position));

        return convertView;
    }

    public static class ViewHolder {

        TextView itemTitle;
    }
}
