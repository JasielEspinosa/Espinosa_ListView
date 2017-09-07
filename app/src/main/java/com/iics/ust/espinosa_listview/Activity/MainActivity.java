package com.iics.ust.espinosa_listview.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.iics.ust.espinosa_listview.Adapter.CustomAdapter;
import com.iics.ust.espinosa_listview.Model.College;
import com.iics.ust.espinosa_listview.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView lv_Colleges;
    CustomAdapter adapter;
    //List<College> listColleges;
    //ArrayAdapter<String> adapter;
    ArrayList<College> listColleges;
    String[] colleges;
    int[] logos;
    String[] years;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        colleges = getResources().getStringArray(R.array.Colleges);
        years = getResources().getStringArray(R.array.Year);

        lv_Colleges = (ListView) findViewById(R.id.ivColleges);
        listColleges = new ArrayList<College>();


        logos = new int[]{
                R.drawable.logo_arch,
                R.drawable.logo_edu,
                R.drawable.logo_eng,
                R.drawable.logo_iics,
                R.drawable.logo_med
        };

        for (int i = 0; i < colleges.length; i++) {
            listColleges.add(new College(logos[i], colleges[i], years[i]));
            //if (i == 10) break;
        }

        //adapter = new ArrayAdapter<String>(this, R.layout.row_layout, colleges);

        adapter = new CustomAdapter(MainActivity.this, listColleges);
        lv_Colleges.setAdapter(adapter);
        lv_Colleges.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String msg = "You Clicked " + colleges[i];
                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
