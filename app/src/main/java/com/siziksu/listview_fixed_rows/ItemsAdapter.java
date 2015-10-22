package com.siziksu.listview_fixed_rows;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class ItemsAdapter extends BaseAdapter {

  private List<String> list;
  private LayoutInflater inflater;

  public ItemsAdapter(Context context, List<String> list) {
    inflater = LayoutInflater.from(context);
    this.list = list;
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    return getCustomView(position, convertView, parent);
  }

  public View getCustomView(int position, View convertView, ViewGroup parent) {
    if (convertView == null) {
      convertView = inflater.inflate(R.layout.list_row, parent, false);
    }
    TextView text;
    text = (TextView) convertView.findViewById(R.id.title);
    text.setText(list.get(position));
    return convertView;
  }

  @Override
  public int getCount() {
    return list.size();
  }

  @Override
  public Object getItem(int position) {
    return list.get(position);
  }

  @Override
  public long getItemId(int position) {
    return position;
  }
}
