package f.b.a.d.l;

import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.google.android.material.R$layout;
import com.google.android.material.R$string;
import java.util.Calendar;
import java.util.Locale;

public class h extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public static final int f2631e = (Build.VERSION.SDK_INT >= 26 ? 4 : 1);
    public final Calendar b;
    public final int c;

    /* renamed from: d  reason: collision with root package name */
    public final int f2632d;

    public h() {
        Calendar g2 = d0.g();
        this.b = g2;
        this.c = g2.getMaximum(7);
        this.f2632d = g2.getFirstDayOfWeek();
    }

    public int getCount() {
        return this.c;
    }

    public Object getItem(int i2) {
        int i3 = this.c;
        if (i2 >= i3) {
            return null;
        }
        int i4 = i2 + this.f2632d;
        if (i4 > i3) {
            i4 -= i3;
        }
        return Integer.valueOf(i4);
    }

    public long getItemId(int i2) {
        return 0;
    }

    public View getView(int i2, View view, ViewGroup viewGroup) {
        TextView textView = (TextView) view;
        if (view == null) {
            textView = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.mtrl_calendar_day_of_week, viewGroup, false);
        }
        Calendar calendar = this.b;
        int i3 = i2 + this.f2632d;
        int i4 = this.c;
        if (i3 > i4) {
            i3 -= i4;
        }
        calendar.set(7, i3);
        textView.setText(this.b.getDisplayName(7, f2631e, Locale.getDefault()));
        textView.setContentDescription(String.format(viewGroup.getContext().getString(R$string.mtrl_picker_day_of_week_column_header), this.b.getDisplayName(7, 2, Locale.getDefault())));
        return textView;
    }
}
