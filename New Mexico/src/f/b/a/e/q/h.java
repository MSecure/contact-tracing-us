package f.b.a.e.q;

import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import java.lang.reflect.Constructor;
import java.util.Objects;
/* loaded from: classes.dex */
public final class h {
    public static final int m;
    public static boolean n;
    public static Constructor<StaticLayout> o;
    public static Object p;
    public CharSequence a;
    public final TextPaint b;
    public final int c;

    /* renamed from: d  reason: collision with root package name */
    public int f3001d;

    /* renamed from: k  reason: collision with root package name */
    public boolean f3008k;

    /* renamed from: e  reason: collision with root package name */
    public Layout.Alignment f3002e = Layout.Alignment.ALIGN_NORMAL;

    /* renamed from: f  reason: collision with root package name */
    public int f3003f = Integer.MAX_VALUE;

    /* renamed from: g  reason: collision with root package name */
    public float f3004g = 0.0f;

    /* renamed from: h  reason: collision with root package name */
    public float f3005h = 1.0f;

    /* renamed from: i  reason: collision with root package name */
    public int f3006i = m;

    /* renamed from: j  reason: collision with root package name */
    public boolean f3007j = true;

    /* renamed from: l  reason: collision with root package name */
    public TextUtils.TruncateAt f3009l = null;

    /* loaded from: classes.dex */
    public static class a extends Exception {
        /* JADX WARN: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump */
        public a(Throwable th) {
            super(r0.toString(), th);
            StringBuilder h2 = f.a.a.a.a.h("Error thrown initializing StaticLayout ");
            h2.append(th.getMessage());
        }
    }

    static {
        m = Build.VERSION.SDK_INT >= 23 ? 1 : 0;
    }

    public h(CharSequence charSequence, TextPaint textPaint, int i2) {
        this.a = charSequence;
        this.b = textPaint;
        this.c = i2;
        this.f3001d = charSequence.length();
    }

    public StaticLayout a() {
        if (this.a == null) {
            this.a = "";
        }
        int max = Math.max(0, this.c);
        CharSequence charSequence = this.a;
        if (this.f3003f == 1) {
            charSequence = TextUtils.ellipsize(charSequence, this.b, (float) max, this.f3009l);
        }
        int min = Math.min(charSequence.length(), this.f3001d);
        this.f3001d = min;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 23) {
            if (this.f3008k && this.f3003f == 1) {
                this.f3002e = Layout.Alignment.ALIGN_OPPOSITE;
            }
            StaticLayout.Builder obtain = StaticLayout.Builder.obtain(charSequence, 0, min, this.b, max);
            obtain.setAlignment(this.f3002e);
            obtain.setIncludePad(this.f3007j);
            obtain.setTextDirection(this.f3008k ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR);
            TextUtils.TruncateAt truncateAt = this.f3009l;
            if (truncateAt != null) {
                obtain.setEllipsize(truncateAt);
            }
            obtain.setMaxLines(this.f3003f);
            float f2 = this.f3004g;
            if (!(f2 == 0.0f && this.f3005h == 1.0f)) {
                obtain.setLineSpacing(f2, this.f3005h);
            }
            if (this.f3003f > 1) {
                obtain.setHyphenationFrequency(this.f3006i);
            }
            return obtain.build();
        }
        if (!n) {
            try {
                p = this.f3008k && i2 >= 23 ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR;
                Class cls = Integer.TYPE;
                Class cls2 = Float.TYPE;
                Constructor<StaticLayout> declaredConstructor = StaticLayout.class.getDeclaredConstructor(CharSequence.class, cls, cls, TextPaint.class, cls, Layout.Alignment.class, TextDirectionHeuristic.class, cls2, cls2, Boolean.TYPE, TextUtils.TruncateAt.class, cls, cls);
                o = declaredConstructor;
                declaredConstructor.setAccessible(true);
                n = true;
            } catch (Exception e2) {
                throw new a(e2);
            }
        }
        try {
            Constructor<StaticLayout> constructor = o;
            Objects.requireNonNull(constructor);
            Object obj = p;
            Objects.requireNonNull(obj);
            return constructor.newInstance(charSequence, 0, Integer.valueOf(this.f3001d), this.b, Integer.valueOf(max), this.f3002e, obj, Float.valueOf(1.0f), Float.valueOf(0.0f), Boolean.valueOf(this.f3007j), null, Integer.valueOf(max), Integer.valueOf(this.f3003f));
        } catch (Exception e3) {
            throw new a(e3);
        }
    }
}
