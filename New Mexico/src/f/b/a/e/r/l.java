package f.b.a.e.r;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.util.Property;
import e.a0.a.a.b;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public abstract class l extends Drawable implements Animatable {

    /* renamed from: l */
    public static final Property<l, Float> f3041l = new a(Float.class, "growFraction");
    public final Context b;
    public final c c;

    /* renamed from: e */
    public ValueAnimator f3043e;

    /* renamed from: f */
    public ValueAnimator f3044f;

    /* renamed from: g */
    public List<b> f3045g;

    /* renamed from: h */
    public boolean f3046h;

    /* renamed from: i */
    public float f3047i;

    /* renamed from: j */
    public final Paint f3048j = new Paint();

    /* renamed from: d */
    public a f3042d = new a();

    /* renamed from: k */
    public int f3049k = 255;

    /* loaded from: classes.dex */
    public static class a extends Property<l, Float> {
        public a(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        public Float get(l lVar) {
            return Float.valueOf(lVar.c());
        }

        @Override // android.util.Property
        public void set(l lVar, Float f2) {
            l lVar2 = lVar;
            float floatValue = f2.floatValue();
            if (lVar2.f3047i != floatValue) {
                lVar2.f3047i = floatValue;
                lVar2.invalidateSelf();
            }
        }
    }

    public l(Context context, c cVar) {
        this.b = context;
        this.c = cVar;
        invalidateSelf();
    }

    public final void b(ValueAnimator... valueAnimatorArr) {
        boolean z = this.f3046h;
        this.f3046h = true;
        for (ValueAnimator valueAnimator : valueAnimatorArr) {
            valueAnimator.end();
        }
        this.f3046h = z;
    }

    public float c() {
        c cVar = this.c;
        boolean z = false;
        if (!(cVar.f3024e != 0)) {
            if (cVar.f3025f != 0) {
                z = true;
            }
            if (!z) {
                return 1.0f;
            }
        }
        return this.f3047i;
    }

    public boolean d() {
        return h(false, false, false);
    }

    public boolean e() {
        ValueAnimator valueAnimator = this.f3044f;
        return valueAnimator != null && valueAnimator.isRunning();
    }

    public boolean f() {
        ValueAnimator valueAnimator = this.f3043e;
        return valueAnimator != null && valueAnimator.isRunning();
    }

    public void g(b bVar) {
        if (this.f3045g == null) {
            this.f3045g = new ArrayList();
        }
        if (!this.f3045g.contains(bVar)) {
            this.f3045g.add(bVar);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f3049k;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public boolean h(boolean z, boolean z2, boolean z3) {
        return i(z, z2, z3 && this.f3042d.a(this.b.getContentResolver()) > 0.0f);
    }

    public boolean i(boolean z, boolean z2, boolean z3) {
        if (this.f3043e == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, f3041l, 0.0f, 1.0f);
            this.f3043e = ofFloat;
            ofFloat.setDuration(500L);
            this.f3043e.setInterpolator(f.b.a.e.a.a.b);
            ValueAnimator valueAnimator = this.f3043e;
            if (valueAnimator == null || !valueAnimator.isRunning()) {
                this.f3043e = valueAnimator;
                valueAnimator.addListener(new j(this));
            } else {
                throw new IllegalArgumentException("Cannot set showAnimator while the current showAnimator is running.");
            }
        }
        if (this.f3044f == null) {
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, f3041l, 1.0f, 0.0f);
            this.f3044f = ofFloat2;
            ofFloat2.setDuration(500L);
            this.f3044f.setInterpolator(f.b.a.e.a.a.b);
            ValueAnimator valueAnimator2 = this.f3044f;
            if (valueAnimator2 == null || !valueAnimator2.isRunning()) {
                this.f3044f = valueAnimator2;
                valueAnimator2.addListener(new k(this));
            } else {
                throw new IllegalArgumentException("Cannot set hideAnimator while the current hideAnimator is running.");
            }
        }
        if (!isVisible() && !z) {
            return false;
        }
        ValueAnimator valueAnimator3 = z ? this.f3043e : this.f3044f;
        if (!z3) {
            if (valueAnimator3.isRunning()) {
                valueAnimator3.end();
            } else {
                b(valueAnimator3);
            }
            return super.setVisible(z, false);
        } else if (z3 && valueAnimator3.isRunning()) {
            return false;
        } else {
            boolean z4 = !z || super.setVisible(z, false);
            if (!(!z ? this.c.f3025f != 0 : this.c.f3024e != 0)) {
                b(valueAnimator3);
                return z4;
            }
            if (z2 || !valueAnimator3.isPaused()) {
                valueAnimator3.start();
            } else {
                valueAnimator3.resume();
            }
            return z4;
        }
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return f() || e();
    }

    public boolean j(b bVar) {
        List<b> list = this.f3045g;
        if (list == null || !list.contains(bVar)) {
            return false;
        }
        this.f3045g.remove(bVar);
        if (!this.f3045g.isEmpty()) {
            return true;
        }
        this.f3045g = null;
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        this.f3049k = i2;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f3048j.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        return h(z, z2, true);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        i(true, true, false);
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        i(false, true, false);
    }
}
