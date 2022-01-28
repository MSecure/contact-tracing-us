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
    public static final int f = a0.g().getMaximum(4);

    /* renamed from: b  reason: collision with root package name */
    public final s f3283b;

    /* renamed from: c  reason: collision with root package name */
    public final d<?> f3284c;

    /* renamed from: d  reason: collision with root package name */
    public c f3285d;

    /* renamed from: e  reason: collision with root package name */
    public final a f3286e;

    public t(s sVar, d<?> dVar, a aVar) {
        this.f3283b = sVar;
        this.f3284c = dVar;
        this.f3286e = aVar;
    }

    public int a() {
        return this.f3283b.u();
    }

    /* renamed from: b */
    public Long getItem(int i) {
        if (i < this.f3283b.u() || i > c()) {
            return null;
        }
        s sVar = this.f3283b;
        Calendar c2 = a0.c(sVar.f3279b);
        c2.set(5, (i - sVar.u()) + 1);
        return Long.valueOf(c2.getTimeInMillis());
    }

    public int c() {
        return (this.f3283b.u() + this.f3283b.g) - 1;
    }

    public int getCount() {
        return a() + this.f3283b.g;
    }

    public long getItemId(int i) {
        return (long) (i / this.f3283b.f);
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x00c0  */
    public View getView(int i, View view, ViewGroup viewGroup) {
        Long b2;
        b bVar;
        String str;
        Context context = viewGroup.getContext();
        if (this.f3285d == null) {
            this.f3285d = new c(context);
        }
        TextView textView = (TextView) view;
        if (view == null) {
            textView = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(h.mtrl_calendar_day, viewGroup, false);
        }
        int a2 = i - a();
        if (a2 >= 0) {
            s sVar = this.f3283b;
            if (a2 < sVar.g) {
                int i2 = a2 + 1;
                textView.setTag(sVar);
                textView.setText(String.valueOf(i2));
                Calendar c2 = a0.c(this.f3283b.f3279b);
                c2.set(5, i2);
                long timeInMillis = c2.getTimeInMillis();
                if (this.f3283b.f3282e == s.t().f3282e) {
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
                    if (this.f3286e.f3221e.i(b2.longValue())) {
                        textView.setEnabled(true);
                        Iterator<Long> it = this.f3284c.o().iterator();
                        while (true) {
                            if (it.hasNext()) {
                                if (a0.a(b2.longValue()) == a0.a(it.next().longValue())) {
                                    bVar = this.f3285d.f3236b;
                                    break;
                                }
                            } else {
                                bVar = a0.f().getTimeInMillis() == b2.longValue() ? this.f3285d.f3237c : this.f3285d.f3235a;
                            }
                        }
                    } else {
                        textView.setEnabled(false);
                        bVar = this.f3285d.g;
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
