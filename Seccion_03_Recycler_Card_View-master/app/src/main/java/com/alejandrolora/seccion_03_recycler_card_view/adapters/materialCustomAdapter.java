package com.alejandrolora.seccion_03_recycler_card_view.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.alejandrolora.seccion_03_recycler_card_view.R;

import java.util.List;

public class materialCustomAdapter extends BaseAdapter {

    private Context mContext;
    private int layout;
    private List<String> materialList;


    public materialCustomAdapter(Context mContext, int layout, List<String> materialList) {
        this.mContext = mContext;
        this.layout = layout;
        this.materialList = materialList;
    }

    @Override
    public int getCount() {
        return this.materialList.size();
    }

    @Override
    public Object getItem(int position) {
        return this.materialList.get(position);
    }

    @Override
    public long getItemId(int id) {
        return id;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        View v = convertView;

        LayoutInflater layoutInflater = LayoutInflater.from(this.mContext);
        v = layoutInflater.inflate(R.layout.item_mult, null);

        String currentName = materialList.get(position);

        TextView textView = (TextView) v.findViewById(R.id.txtmultimetro);
        textView.setText(currentName);

        return v;


    }

}