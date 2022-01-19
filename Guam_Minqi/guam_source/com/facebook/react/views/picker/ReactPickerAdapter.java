package com.facebook.react.views.picker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatDelegateImpl;
import java.util.List;

public class ReactPickerAdapter extends ArrayAdapter<ReactPickerItem> {
    public Integer mBackgroundColor;
    public final LayoutInflater mInflater;
    public Integer mPrimaryTextColor;

    public ReactPickerAdapter(Context context, List<ReactPickerItem> list) {
        super(context, 0, list);
        Object systemService = context.getSystemService("layout_inflater");
        AppCompatDelegateImpl.ConfigurationImplApi17.assertNotNull(systemService);
        this.mInflater = (LayoutInflater) systemService;
    }

    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        return getView(i, view, viewGroup, true);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        return getView(i, view, viewGroup, false);
    }

    public final View getView(int i, View view, ViewGroup viewGroup, boolean z) {
        Integer num;
        ReactPickerItem reactPickerItem = (ReactPickerItem) getItem(i);
        boolean z2 = false;
        if (view == null) {
            view = this.mInflater.inflate(z ? 17367049 : 17367048, viewGroup, false);
            view.setTag(((TextView) view).getTextColors());
            z2 = true;
        }
        TextView textView = (TextView) view;
        textView.setText(reactPickerItem.label);
        if (z || (num = this.mPrimaryTextColor) == null) {
            Integer num2 = reactPickerItem.color;
            if (num2 != null) {
                textView.setTextColor(num2.intValue());
            } else if (textView.getTag() != null && !z2) {
                textView.setTextColor((ColorStateList) textView.getTag());
            }
        } else {
            textView.setTextColor(num.intValue());
        }
        Integer num3 = this.mBackgroundColor;
        if (num3 != null) {
            textView.setBackgroundColor(num3.intValue());
        }
        return textView;
    }
}
