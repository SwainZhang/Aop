package com.emery.test.aop;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @BehaviorInterface("shake")
    public void shake(View view){

        ListView listView=new ListView(this);
        listView.setAdapter(new ArrayAdapter<String>(this,android.R.layout.activity_list_item));


        new Thread(new Runnable() {
            @Override
            public void run() {
                // System.out.println("------"+ new SimpleDateFormat().format(new Date())+"-----------");
                //long begin=System.currentTimeMillis();

                SystemClock.sleep(300);
                System.out.println("shake......");


                //long end=begin-System.currentTimeMillis();
                //System.out.println("------------共耗时"+end+"ms-------------");
            }
        }).start();
    }
}
