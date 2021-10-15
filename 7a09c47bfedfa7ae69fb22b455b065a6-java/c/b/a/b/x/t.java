package c.b.a.b.x;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import c.b.a.b.h;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;

public class t extends BaseAdapter {

    /* renamed from: f  reason: collision with root package name */
    public static final int f4616f = a0.g().getMaximum(4);

    /* renamed from: b  reason: collision with root package name */
    public final s f4617b;

    /* renamed from: c  reason: collision with root package name */
    public final d<?> f4618c;

    /* renamed from: d  reason: collision with root package name */
    public c f4619d;

    /* renamed from: e  reason: collision with root package name */
    public final a f4620e;

    public t(s sVar, d<?> dVar, a aVar) {
        this.f4617b = sVar;
        this.f4618c = dVar;
        this.f4620e = aVar;
    }

    public int a() {
        return this.f4617b.A();
    }

    /* renamed from: b */
    public Long getItem(int i) {
        if (i < this.f4617b.A() || i > c()) {
            return null;
        }
        s sVar = this.f4617b;
        Calendar c2 = a0.c(sVar.f4610b);
        c2.set(5, (i - sVar.A()) + 1);
        return Long.valueOf(c2.getTimeInMillis());
    }

    public int c() {
        return (this.f4617b.A() + this.f4617b.f4615g) - 1;
    }

    public int getCount() {
        return a() + this.f4617b.f4615g;
    }

    public long getItemId(int i) {
        return (long) (i / this.f4617b.f4614f);
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x00c0  */
    public View getView(int i, View view, ViewGroup viewGroup) {
        Long b2;
        b bVar;
        String str;
        Context context = viewGroup.getContext();
        if (this.f4619d == null) {
            this.f4619d = new c(context);
        }
        TextView textView = (TextView) view;
        if (view == null) {
            textView = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(h.mtrl_calendar_day, viewGroup, false);
        }
        int a2 = i - a();
        if (a2 >= 0) {
            s sVar = this.f4617b;
            if (a2 < sVar.f4615g) {
                int i2 = a2 + 1;
                textView.setTag(sVar);
                textView.setText(String.valueOf(i2));
                Calendar c2 = a0.c(this.f4617b.f4610b);
                c2.set(5, i2);
                long timeInMillis = c2.getTimeInMillis();
                if (this.f4617b.f4613e == s.y().f4613e) {
                    Locale locale = Locale.getDefault();
                    str = Build.VERSION.SDK_INT >= 24 ? a0.b(locale).format(new Date(timeInMillis)) : a0.d(locale).format(new Date(timeInMillis));
                } else {
                    Locale locale2 = Locale.getDefault();
                    str = Build.VERSION.SDK_INT >= 24 ? a0.i(locale2).format(new Date(timeInMillis)) : a0.d(locale2).format(new Date(timeInMillis));
                }
                textView.setContentDescription(str);
                textView.setVisibility(0);
                textView.setEnabled(true);
                b2 = getItem(i);
                if (b2 != null) {
                    if (this.f4620e.f4542e.k(b2.longValue())) {
                        textView.setEnabled(true);
                        Iterator<Long> it = this.f4618c.s().iterator();
                        while (true) {
                            if (it.hasNext()) {
                                if (a0.a(b2.longValue()) == a0.a(it.next().longValue())) {
                                    bVar = this.f4619d.f4561b;
                                    break;
                                }
                            } else {
                                bVar = a0.f().getTimeInMillis() == b2.longValue() ? this.f4619d.f4562c : this.f4619d.f4560a;
                            }
                        }
                    } else {
                        textView.setEnabled(false);
                        bVar = this.f4619d.f4566g;
                    }
                    bVar.b(textView);
                }
                return textView;
            }
        }
        textView.setVisibility(8);
        textView.setEnabled(false);
        b2 = getItem(i);
        if (b2 != null) {
        }
        return textView;
    }

    public boolean hasStableIds() {
        return true;
    }
}
