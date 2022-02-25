package f.b.a.d.l;

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

public class v extends BaseAdapter {

    /* renamed from: g  reason: collision with root package name */
    public static final int f2640g = d0.g().getMaximum(4);
    public final u b;
    public final f<?> c;

    /* renamed from: d  reason: collision with root package name */
    public Collection<Long> f2641d;

    /* renamed from: e  reason: collision with root package name */
    public c f2642e;

    /* renamed from: f  reason: collision with root package name */
    public final a f2643f;

    public v(u uVar, f<?> fVar, a aVar) {
        this.b = uVar;
        this.c = fVar;
        this.f2643f = aVar;
        this.f2641d = fVar.m();
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
        return (this.b.s() + this.b.f2637f) - 1;
    }

    public final TextView e(TextView textView, long j2) {
        b bVar;
        if (this.f2643f.f2610d.f(j2)) {
            textView.setEnabled(true);
            Iterator<Long> it = this.c.m().iterator();
            while (true) {
                if (it.hasNext()) {
                    if (d0.a(j2) == d0.a(it.next().longValue())) {
                        bVar = this.f2642e.b;
                        break;
                    }
                } else {
                    int i2 = (d0.f().getTimeInMillis() > j2 ? 1 : (d0.f().getTimeInMillis() == j2 ? 0 : -1));
                    c cVar = this.f2642e;
                    bVar = i2 == 0 ? cVar.c : cVar.a;
                }
            }
        } else {
            textView.setEnabled(false);
            bVar = this.f2642e.f2625g;
        }
        bVar.b(textView);
        return textView;
    }

    public final void f(MaterialCalendarGridView materialCalendarGridView, long j2) {
        if (u.q(j2).equals(this.b)) {
            Calendar d2 = d0.d(this.b.b);
            d2.setTimeInMillis(j2);
            e((TextView) materialCalendarGridView.getChildAt(materialCalendarGridView.getAdapter().a(d2.get(5))), j2);
        }
    }

    public int getCount() {
        return b() + this.b.f2637f;
    }

    public long getItemId(int i2) {
        return (long) (i2 / this.b.f2636e);
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    public View getView(int i2, View view, ViewGroup viewGroup) {
        CharSequence charSequence;
        int i3 = Build.VERSION.SDK_INT;
        Context context = viewGroup.getContext();
        if (this.f2642e == null) {
            this.f2642e = new c(context);
        }
        TextView textView = (TextView) view;
        if (view == null) {
            textView = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.mtrl_calendar_day, viewGroup, false);
        }
        int b2 = i2 - b();
        if (b2 >= 0) {
            u uVar = this.b;
            if (b2 < uVar.f2637f) {
                int i4 = b2 + 1;
                textView.setTag(uVar);
                textView.setText(String.valueOf(i4));
                long t = this.b.t(i4);
                if (this.b.f2635d == u.r().f2635d) {
                    Locale locale = Locale.getDefault();
                    if (i3 >= 24) {
                        charSequence = d0.c("MMMEd", locale).format(new Date(t));
                    } else {
                        AtomicReference<c0> atomicReference = d0.a;
                        DateFormat dateInstance = DateFormat.getDateInstance(0, locale);
                        dateInstance.setTimeZone(d0.e());
                        charSequence = dateInstance.format(new Date(t));
                    }
                } else {
                    Locale locale2 = Locale.getDefault();
                    if (i3 >= 24) {
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
                Long c2 = getItem(i2);
                return c2 != null ? textView : e(textView, c2.longValue());
            }
        }
        textView.setVisibility(8);
        textView.setEnabled(false);
        Long c22 = getItem(i2);
        if (c22 != null) {
        }
    }

    public boolean hasStableIds() {
        return true;
    }
}
