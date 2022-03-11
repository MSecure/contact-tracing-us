package f.b.a.d.r;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.util.Property;
import e.x.a.a.b;
import java.util.ArrayList;
import java.util.List;

public abstract class i extends Drawable implements Animatable {
    public static final Property<i, Float> n = new a(Float.class, "growFraction");
    public final Context b;
    public final s c;

    /* renamed from: d  reason: collision with root package name */
    public a f2712d;

    /* renamed from: e  reason: collision with root package name */
    public ValueAnimator f2713e;

    /* renamed from: f  reason: collision with root package name */
    public ValueAnimator f2714f;

    /* renamed from: g  reason: collision with root package name */
    public List<b> f2715g;

    /* renamed from: h  reason: collision with root package name */
    public b f2716h;

    /* renamed from: i  reason: collision with root package name */
    public float f2717i;

    /* renamed from: j  reason: collision with root package name */
    public int f2718j;

    /* renamed from: k  reason: collision with root package name */
    public int[] f2719k;

    /* renamed from: l  reason: collision with root package name */
    public final Paint f2720l = new Paint();
    public int m;

    public static class a extends Property<i, Float> {
        public a(Class cls, String str) {
            super(cls, str);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.util.Property
        public Float get(i iVar) {
            return Float.valueOf(iVar.f2717i);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // android.util.Property
        public void set(i iVar, Float f2) {
            iVar.e(f2.floatValue());
        }
    }

    public i(Context context, s sVar) {
        this.b = context;
        this.c = sVar;
        this.f2712d = new a();
        setAlpha(255);
    }

    public boolean b() {
        return f(false, false, false);
    }

    public void c() {
        this.f2718j = f.b.a.c.b.o.b.M(this.c.f2737e, this.m);
        this.f2719k = (int[]) this.c.f2736d.clone();
        int i2 = 0;
        while (true) {
            int[] iArr = this.f2719k;
            if (i2 < iArr.length) {
                iArr[i2] = f.b.a.c.b.o.b.M(iArr[i2], this.m);
                i2++;
            } else {
                return;
            }
        }
    }

    public void d(b bVar) {
        if (this.f2715g == null) {
            this.f2715g = new ArrayList();
        }
        if (!this.f2715g.contains(bVar)) {
            this.f2715g.add(bVar);
        }
    }

    public void e(float f2) {
        if (this.c.f2739g == 0) {
            f2 = 1.0f;
        }
        if (this.f2717i != f2) {
            this.f2717i = f2;
            invalidateSelf();
        }
    }

    public boolean f(boolean z, boolean z2, boolean z3) {
        boolean z4 = false;
        if (!isVisible() && !z) {
            return false;
        }
        if (this.f2713e == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, n, 0.0f, 1.0f);
            this.f2713e = ofFloat;
            ofFloat.setDuration(500L);
            this.f2713e.setInterpolator(f.b.a.d.a.a.b);
            ValueAnimator valueAnimator = this.f2713e;
            if (valueAnimator == null || !valueAnimator.isRunning()) {
                this.f2713e = valueAnimator;
                valueAnimator.addListener(new g(this));
            } else {
                throw new IllegalArgumentException("Cannot set showAnimator while the current showAnimator is running.");
            }
        }
        if (this.f2714f == null) {
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, n, 1.0f, 0.0f);
            this.f2714f = ofFloat2;
            ofFloat2.setDuration(500L);
            this.f2714f.setInterpolator(f.b.a.d.a.a.b);
            ValueAnimator valueAnimator2 = this.f2714f;
            if (valueAnimator2 == null || !valueAnimator2.isRunning()) {
                this.f2714f = valueAnimator2;
                valueAnimator2.addListener(new h(this));
            } else {
                throw new IllegalArgumentException("Cannot set hideAnimator while the current hideAnimator is running.");
            }
        }
        if (z3) {
            if ((z ? this.f2713e : this.f2714f).isRunning()) {
                return false;
            }
        }
        ValueAnimator valueAnimator3 = z ? this.f2713e : this.f2714f;
        boolean z5 = !z || super.setVisible(z, false);
        if (this.c.f2739g != 0) {
            z4 = true;
        }
        if (!z3 || !z4) {
            valueAnimator3.end();
            return z5;
        }
        if (z2 || !valueAnimator3.isPaused()) {
            valueAnimator3.start();
        } else {
            valueAnimator3.resume();
        }
        return z5;
    }

    public boolean g(b bVar) {
        List<b> list = this.f2715g;
        if (list == null || !list.contains(bVar)) {
            return false;
        }
        this.f2715g.remove(bVar);
        if (!this.f2715g.isEmpty()) {
            return true;
        }
        this.f2715g = null;
        return true;
    }

    public int getAlpha() {
        return this.m;
    }

    public int getOpacity() {
        return -3;
    }

    public boolean isRunning() {
        ValueAnimator valueAnimator;
        ValueAnimator valueAnimator2 = this.f2713e;
        return (valueAnimator2 != null && valueAnimator2.isRunning()) || ((valueAnimator = this.f2714f) != null && valueAnimator.isRunning());
    }

    public void setAlpha(int i2) {
        this.m = i2;
        c();
        invalidateSelf();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f2720l.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public boolean setVisible(boolean z, boolean z2) {
        return f(z, z2, this.f2712d.a(this.b.getContentResolver()) > 0.0f);
    }

    public void start() {
        setVisible(true, true);
    }

    public void stop() {
        setVisible(false, true);
    }
}
