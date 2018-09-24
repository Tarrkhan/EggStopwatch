package com.example.tarakhan.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class listview extends AppCompatActivity {
    ListView lv;
    ArrayList<Modal> modalArrayList;
    Modal modal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        lv=(ListView)findViewById(R.id.lv);
        String[] names = {"Divyanshu","Ankit","some","Nikita","Jagmeet","Moksh"};
        String[] details = {"hello","hello","hello","hello","hello","hello"};
        int[] images = {R.drawable.aa,R.drawable.aa,R.drawable.aa,R.drawable.aa,R.drawable.aa,R.drawable.aa};

        modalArrayList = new ArrayList<>();
        for (int i=0;i<names.length;i++){
            modal = new Modal(names[i],details[i],images[i]);
            modalArrayList.add(modal);
        }

        MyAdapter adapter = new MyAdapter(this,modalArrayList);
        lv.setAdapter(adapter);

    }
}
