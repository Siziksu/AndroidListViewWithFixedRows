package com.siziksu.listview_fixed_rows;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends Activity implements AdapterView.OnItemClickListener {

  private TextView text;
  private List<String> list;
  private FixedListView fixedListView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_home);

    text = (TextView) findViewById(R.id.text);

    list = new ArrayList<String>();
    list.add("First element");
    list.add("Second element");
    list.add("Third element");
    list.add("Forth element");
    list.add("Fifth element");
    list.add("Sixth element");
    list.add("Seventh element");
    list.add("Eighth element");
    list.add("Ninth element");
    list.add("Tenth element");

    fixedListView = (FixedListView) findViewById(R.id.customListView);
    fixedListView.setAdapter(new ItemsAdapter(this, list));
    fixedListView.setVisibleItemNumber(7);
    fixedListView.setOnItemClickListener(this);
  }

  int count = 1;

  @Override
  public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
    String s = list.get(position) + getString(R.string.action_click);
    text.setText(s);
    fixedListView.setVisibleItemNumber(count++);
  }
}
