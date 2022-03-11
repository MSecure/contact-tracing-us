package f.b.a.d.q;

import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import java.lang.reflect.Constructor;
import java.util.Objects;

public final class h {

    /* renamed from: j  reason: collision with root package name */
    public static boolean f2790j;

    /* renamed from: k  reason: collision with root package name */
    public static Constructor<StaticLayout> f2791k;

    /* renamed from: l  reason: collision with root package name */
    public static Object f2792l;
    public CharSequence a;
    public final TextPaint b;
    public final int c;

    /* renamed from: d  reason: collision with root package name */
    public int f2793d;

    /* renamed from: e  reason: collision with root package name */
    public Layout.Alignment f2794e = Layout.Alignment.ALIGN_NORMAL;

    /* renamed from: f  reason: collision with root package name */
    public int f2795f = Integer.MAX_VALUE;

    /* renamed from: g  reason: collision with root package name */
    public boolean f2796g = true;

    /* renamed from: h  reason: collision with root package name */
    public boolean f2797h;

    /* renamed from: i  reason: collision with root package name */
    public TextUtils.TruncateAt f2798i = null;

    public static class a extends Exception {
        /* JADX WARNING: Illegal instructions before constructor call */
        public a(Throwable th) {
            super(r0.toString(), th);
            StringBuilder h2 = f.a.a.a.a.h("Error thrown initializing StaticLayout ");
            h2.append(th.getMessage());
        }
    }

    public h(CharSequence charSequence, TextPaint textPaint, int i2) {
        this.a = charSequence;
        this.b = textPaint;
        this.c = i2;
        this.f2793d = charSequence.length();
    }

    public StaticLayout a() {
        if (this.a == null) {
            this.a = "";
        }
        int max = Math.max(0, this.c);
        CharSequence charSequence = this.a;
        if (this.f2795f == 1) {
            charSequence = TextUtils.ellipsize(charSequence, this.b, (float) max, this.f2798i);
        }
        int min = Math.min(charSequence.length(), this.f2793d);
        this.f2793d = min;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 23) {
            if (this.f2797h) {
                this.f2794e = Layout.Alignment.ALIGN_OPPOSITE;
            }
            StaticLayout.Builder obtain = StaticLayout.Builder.obtain(charSequence, 0, min, this.b, max);
            obtain.setAlignment(this.f2794e);
            obtain.setIncludePad(this.f2796g);
            obtain.setTextDirection(this.f2797h ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR);
            TextUtils.TruncateAt truncateAt = this.f2798i;
            if (truncateAt != null) {
                obtain.setEllipsize(truncateAt);
            }
            obtain.setMaxLines(this.f2795f);
            return obtain.build();
        }
        if (!f2790j) {
            try {
                f2792l = this.f2797h && i2 >= 23 ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR;
                Class cls = Integer.TYPE;
                Class cls2 = Float.TYPE;
                Constructor<StaticLayout> declaredConstructor = StaticLayout.class.getDeclaredConstructor(CharSequence.class, cls, cls, TextPaint.class, cls, Layout.Alignment.class, TextDirectionHeuristic.class, cls2, cls2, Boolean.TYPE, TextUtils.TruncateAt.class, cls, cls);
                f2791k = declaredConstructor;
                declaredConstructor.setAccessible(true);
                f2790j = true;
            } catch (Exception e2) {
                throw new a(e2);
            }
        }
        try {
            Constructor<StaticLayout> constructor = f2791k;
            Objects.requireNonNull(constructor);
            Object obj = f2792l;
            Objects.requireNonNull(obj);
            return constructor.newInstance(charSequence, 0, Integer.valueOf(this.f2793d), this.b, Integer.valueOf(max), this.f2794e, obj, Float.valueOf(1.0f), Float.valueOf(0.0f), Boolean.valueOf(this.f2796g), null, Integer.valueOf(max), Integer.valueOf(this.f2795f));
        } catch (Exception e3) {
            throw new a(e3);
        }
    }
}
