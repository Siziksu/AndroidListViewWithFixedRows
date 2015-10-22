package com.siziksu.listview_fixed_rows;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;

public class FixedListView extends ListView {

  public FixedListView(Context context) {
    super(context);
  }

  public FixedListView(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  public FixedListView(Context context, AttributeSet attrs, int defStyle) {
    super(context, attrs, defStyle);
  }

  public void setVisibleItemNumber(int number) {
    ListAdapter listAdapter = getAdapter();
    if (listAdapter == null) {
      return;
    }
    int totalHeight = 0;
    int items = (number < getCount() ? number : getCount());
    for (int i = 0; i < items; i++) {
      View item = listAdapter.getView(i, null, this);
      item.measure(0, 0);
      totalHeight += item.getMeasuredHeight() + getDividerHeight();
    }
    setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, totalHeight));
    requestLayout();
  }
}
