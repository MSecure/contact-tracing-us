package f.b.a.e.l;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.google.android.material.R$layout;
import com.google.android.material.datepicker.MaterialCalendarGridView;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicReference;
/* loaded from: classes.dex */
public class v extends BaseAdapter {

    /* renamed from: g  reason: collision with root package name */
    public static final int f2951g = d0.g().getMaximum(4);
    public final u b;
    public final f<?> c;

    /* renamed from: d  reason: collision with root package name */
    public Collection<Long> f2952d;

    /* renamed from: e  reason: collision with root package name */
    public c f2953e;

    /* renamed from: f  reason: collision with root package name */
    public final a f2954f;

    public v(u uVar, f<?> fVar, a aVar) {
        this.b = uVar;
        this.c = fVar;
        this.f2954f = aVar;
        this.f2952d = fVar.m();
    }

    public int a(int i2) {
        return b() + (i2 - 1);
    }

    public int b() {
        return this.b.s();
    }

    /* renamed from: c */
    public Long getItem(int i2) {
        if (i2 < this.b.s() || i2 > d()) {
            return null;
        }
        u uVar = this.b;
        return Long.valueOf(uVar.t((i2 - uVar.s()) + 1));
    }

    public int d() {
        return (this.b.s() + this.b.f2948f) - 1;
    }

    public final void e(TextView textView, long j2) {
        b bVar;
        if (textView != null) {
            boolean z = false;
            if (this.f2954f.f2921d.f(j2)) {
                textView.setEnabled(true);
                Iterator<Long> it = this.c.m().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    if (d0.a(j2) == d0.a(it.next().longValue())) {
                        z = true;
                        break;
                    }
                }
                if (z) {
                    bVar = this.f2953e.b;
                } else {
                    int i2 = (d0.f().getTimeInMillis() > j2 ? 1 : (d0.f().getTimeInMillis() == j2 ? 0 : -1));
                    c cVar = this.f2953e;
                    bVar = i2 == 0 ? cVar.c : cVar.a;
                }
            } else {
                textView.setEnabled(false);
                bVar = this.f2953e.f2936g;
            }
            bVar.b(textView);
        }
    }

    public final void f(MaterialCalendarGridView materialCalendarGridView, long j2) {
        if (u.q(j2).equals(this.b)) {
            Calendar d2 = d0.d(this.b.b);
            d2.setTimeInMillis(j2);
            e((TextView) materialCalendarGridView.getChildAt(materialCalendarGridView.getAdapter().a(d2.get(5)) - materialCalendarGridView.getFirstVisiblePosition()), j2);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return b() + this.b.f2948f;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        return (long) (i2 / this.b.f2947e);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00e0  */
    @Override // android.widget.Adapter
    /* Code decompiled incorrectly, please refer to instructions dump */
    public View getView(int i2, View view, ViewGroup viewGroup) {
        Long c;
        CharSequence charSequence;
        Context context = viewGroup.getContext();
        if (this.f2953e == null) {
            this.f2953e = new c(context);
        }
        TextView textView = (TextView) view;
        if (view == null) {
            textView = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.mtrl_calendar_day, viewGroup, false);
        }
        int b = i2 - b();
        if (b >= 0) {
            u uVar = this.b;
            if (b < uVar.f2948f) {
                int i3 = b + 1;
                textView.setTag(uVar);
                textView.setText(String.format(textView.getResources().getConfiguration().locale, "%d", Integer.valueOf(i3)));
                long t = this.b.t(i3);
                if (this.b.f2946d == u.r().f2946d) {
                    Locale locale = Locale.getDefault();
                    if (Build.VERSION.SDK_INT >= 24) {
                        charSequence = d0.c("MMMEd", locale).format(new Date(t));
                    } else {
                        AtomicReference<c0> atomicReference = d0.a;
                        DateFormat dateInstance = DateFormat.getDateInstance(0, locale);
                        dateInstance.setTimeZone(d0.e());
                        charSequence = dateInstance.format(new Date(t));
                    }
                } else {
                    Locale locale2 = Locale.getDefault();
                    if (Build.VERSION.SDK_INT >= 24) {
                        charSequence = d0.c("yMMMEd", locale2).format(new Date(t));
                    } else {
                        AtomicReference<c0> atomicReference2 = d0.a;
                        DateFormat dateInstance2 = DateFormat.getDateInstance(0, locale2);
                        dateInstance2.setTimeZone(d0.e());
                        charSequence = dateInstance2.format(new Date(t));
                    }
                }
                textView.setContentDescription(charSequence);
                textView.setVisibility(0);
                textView.setEnabled(true);
                c = getItem(i2);
                if (c != null) {
                    e(textView, c.longValue());
                }
                return textView;
            }
        }
        textView.setVisibility(8);
        textView.setEnabled(false);
        c = getItem(i2);
        if (c != null) {
        }
        return textView;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return true;
    }
}
