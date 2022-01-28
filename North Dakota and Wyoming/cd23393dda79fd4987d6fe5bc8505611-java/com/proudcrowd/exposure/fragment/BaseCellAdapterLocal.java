package com.proudcrowd.exposure.fragment;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.List;

public abstract class BaseCellAdapterLocal<InnerType> extends BaseAdapter {
    List<InnerType> mLocalData;

    public long getItemId(int i) {
        return (long) i;
    }

    public abstract View getView(int i, View view, ViewGroup viewGroup);

    /* access modifiers changed from: protected */
    public void loadData(List<InnerType> list) {
        this.mLocalData = list;
        notifyDataSetChanged();
    }

    public int getCount() {
        List<InnerType> list = this.mLocalData;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public Object getItem(int i) {
        List<InnerType> list = this.mLocalData;
        if (list != null) {
            return list.get(i);
        }
        return null;
    }
}
