package f.b.a.e.l;

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
/* loaded from: classes.dex */
public class h extends BaseAdapter {

    /* renamed from: e  reason: collision with root package name */
    public static final int f2942e;
    public final Calendar b;
    public final int c;

    /* renamed from: d  reason: collision with root package name */
    public final int f2943d;

    static {
        f2942e = Build.VERSION.SDK_INT >= 26 ? 4 : 1;
    }

    public h() {
        Calendar g2 = d0.g();
        this.b = g2;
        this.c = g2.getMaximum(7);
        this.f2943d = g2.getFirstDayOfWeek();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.c;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        int i3 = this.c;
        if (i2 >= i3) {
            return null;
        }
        int i4 = i2 + this.f2943d;
        if (i4 > i3) {
            i4 -= i3;
        }
        return Integer.valueOf(i4);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return 0;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        TextView textView = (TextView) view;
        if (view == null) {
            textView = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.mtrl_calendar_day_of_week, viewGroup, false);
        }
        Calendar calendar = this.b;
        int i3 = i2 + this.f2943d;
        int i4 = this.c;
        if (i3 > i4) {
            i3 -= i4;
        }
        calendar.set(7, i3);
        textView.setText(this.b.getDisplayName(7, f2942e, textView.getResources().getConfiguration().locale));
        textView.setContentDescription(String.format(viewGroup.getContext().getString(R$string.mtrl_picker_day_of_week_column_header), this.b.getDisplayName(7, 2, Locale.getDefault())));
        return textView;
    }
}
