package cn.azir.adapter;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listview);
        List<String> vals = new ArrayList<>();
        for (int i = 0;i < 10;i++) {
            vals.add("val = " + i);
        }

        DemoAdapter adapter = new DemoAdapter(this);

        listView.setAdapter(adapter);

        adapter.setData(vals);
    }




}
