package c.b.a.b.x;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import c.b.a.b.h;
import c.b.a.b.j;
import java.util.Calendar;
import java.util.Locale;

public class f extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public static final int f4570e = (Build.VERSION.SDK_INT >= 26 ? 4 : 1);

    /* renamed from: b  reason: collision with root package name */
    public final Calendar f4571b;

    /* renamed from: c  reason: collision with root package name */
    public final int f4572c;

    /* renamed from: d  reason: collision with root package name */
    public final int f4573d = this.f4571b.getFirstDayOfWeek();

    public f() {
        Calendar g2 = a0.g();
        this.f4571b = g2;
        this.f4572c = g2.getMaximum(7);
    }

    public int getCount() {
        return this.f4572c;
    }

    public Object getItem(int i) {
        int i2 = this.f4572c;
        if (i >= i2) {
            return null;
        }
        int i3 = i + this.f4573d;
        if (i3 > i2) {
            i3 -= i2;
        }
        return Integer.valueOf(i3);
    }

    public long getItemId(int i) {
        return 0;
    }

    @SuppressLint({"WrongConstant"})
    public View getView(int i, View view, ViewGroup viewGroup) {
        TextView textView = (TextView) view;
        if (view == null) {
            textView = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(h.mtrl_calendar_day_of_week, viewGroup, false);
        }
        Calendar calendar = this.f4571b;
        int i2 = i + this.f4573d;
        int i3 = this.f4572c;
        if (i2 > i3) {
            i2 -= i3;
        }
        calendar.set(7, i2);
        textView.setText(this.f4571b.getDisplayName(7, f4570e, Locale.getDefault()));
        textView.setContentDescription(String.format(viewGroup.getContext().getString(j.mtrl_picker_day_of_week_column_header), this.f4571b.getDisplayName(7, 2, Locale.getDefault())));
        return textView;
    }
}
