package com.iics.ust.espinosa_listview.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.iics.ust.espinosa_listview.Model.College;
import com.iics.ust.espinosa_listview.R;

import java.util.List;

/**
 * Created by 9720JAS-PC-LT on 9/7/2017.
 */

public class CustomAdapter extends BaseAdapter {


    private List<College> colleges;
    ImageView iv_Logo;
    TextView tv_Name, tv_Year;
    Context context;

    public CustomAdapter(Context context, List<College> colleges) {
        this.context = context;
        this.colleges = colleges;
    }

    @Override
    public int getCount() {
        return colleges.size();
    }

    @Override
    public Object getItem(int i) {
        return colleges.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View v = View.inflate(context, R.layout.row_layout, null);
        iv_Logo = (ImageView) v.findViewById(R.id.ivLogo);
        tv_Name = (TextView) v.findViewById(R.id.tvCollege);
        tv_Year = (TextView) v.findViewById(R.id.tvYear);

        iv_Logo.setImageResource(colleges.get(i).getLogo());
        tv_Name.setText(colleges.get(i).getName());
        tv_Year.setText(colleges.get(i).getYear());

        return null;
    }
}

