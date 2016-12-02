package com.qcxzuo.myuniversaladapter;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import adapter.CommonAdapter;
import viewholder.ViewHolder;

public class MainActivity extends Activity {

    private ListView mLv;
    private List<String> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLv = (ListView) findViewById(R.id.lv);
        for (int i = 0; i < 20; i++) {
            list.add("来互相伤害啊" + i);
        }
        mLv.setAdapter(new CommonAdapter<String>(MainActivity.this, list, R.layout.item) {
            @Override
            public void convert(ViewHolder helper, String item) {
                helper.setText(R.id.tv, item);
            }

            @Override
            public void setItemOnClickListener(ViewHolder helper, final int itemId) {
                helper.getView(itemId).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(MainActivity.this, "%%" + itemId, Toast.LENGTH_SHORT).show();
                    }
                });
            }

        });
    }
}
