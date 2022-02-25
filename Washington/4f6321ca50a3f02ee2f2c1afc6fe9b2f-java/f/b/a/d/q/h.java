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
    public static boolean f2690j;

    /* renamed from: k  reason: collision with root package name */
    public static Constructor<StaticLayout> f2691k;

    /* renamed from: l  reason: collision with root package name */
    public static Object f2692l;
    public CharSequence a;
    public final TextPaint b;
    public final int c;

    /* renamed from: d  reason: collision with root package name */
    public int f2693d;

    /* renamed from: e  reason: collision with root package name */
    public Layout.Alignment f2694e = Layout.Alignment.ALIGN_NORMAL;

    /* renamed from: f  reason: collision with root package name */
    public int f2695f = Integer.MAX_VALUE;

    /* renamed from: g  reason: collision with root package name */
    public boolean f2696g = true;

    /* renamed from: h  reason: collision with root package name */
    public boolean f2697h;

    /* renamed from: i  reason: collision with root package name */
    public TextUtils.TruncateAt f2698i = null;

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
        this.f2693d = charSequence.length();
    }

    public StaticLayout a() {
        if (this.a == null) {
            this.a = "";
        }
        int max = Math.max(0, this.c);
        CharSequence charSequence = this.a;
        if (this.f2695f == 1) {
            charSequence = TextUtils.ellipsize(charSequence, this.b, (float) max, this.f2698i);
        }
        int min = Math.min(charSequence.length(), this.f2693d);
        this.f2693d = min;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 23) {
            if (this.f2697h) {
                this.f2694e = Layout.Alignment.ALIGN_OPPOSITE;
            }
            StaticLayout.Builder obtain = StaticLayout.Builder.obtain(charSequence, 0, min, this.b, max);
            obtain.setAlignment(this.f2694e);
            obtain.setIncludePad(this.f2696g);
            obtain.setTextDirection(this.f2697h ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR);
            TextUtils.TruncateAt truncateAt = this.f2698i;
            if (truncateAt != null) {
                obtain.setEllipsize(truncateAt);
            }
            obtain.setMaxLines(this.f2695f);
            return obtain.build();
        }
        if (!f2690j) {
            try {
                f2692l = this.f2697h && i2 >= 23 ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR;
                Class cls = Integer.TYPE;
                Class cls2 = Float.TYPE;
                Constructor<StaticLayout> declaredConstructor = StaticLayout.class.getDeclaredConstructor(CharSequence.class, cls, cls, TextPaint.class, cls, Layout.Alignment.class, TextDirectionHeuristic.class, cls2, cls2, Boolean.TYPE, TextUtils.TruncateAt.class, cls, cls);
                f2691k = declaredConstructor;
                declaredConstructor.setAccessible(true);
                f2690j = true;
            } catch (Exception e2) {
                throw new a(e2);
            }
        }
        try {
            Constructor<StaticLayout> constructor = f2691k;
            Objects.requireNonNull(constructor);
            Object obj = f2692l;
            Objects.requireNonNull(obj);
            return constructor.newInstance(charSequence, 0, Integer.valueOf(this.f2693d), this.b, Integer.valueOf(max), this.f2694e, obj, Float.valueOf(1.0f), Float.valueOf(0.0f), Boolean.valueOf(this.f2696g), null, Integer.valueOf(max), Integer.valueOf(this.f2695f));
        } catch (Exception e3) {
            throw new a(e3);
        }
    }
}
