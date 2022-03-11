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

public abstract class l extends Drawable implements Animatable {

    /* renamed from: l  reason: collision with root package name */
    public static final Property<l, Float> f2830l = new a(Float.class, "growFraction");
    public final Context b;
    public final c c;

    /* renamed from: d  reason: collision with root package name */
    public a f2831d;

    /* renamed from: e  reason: collision with root package name */
    public ValueAnimator f2832e;

    /* renamed from: f  reason: collision with root package name */
    public ValueAnimator f2833f;

    /* renamed from: g  reason: collision with root package name */
    public List<b> f2834g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f2835h;

    /* renamed from: i  reason: collision with root package name */
    public float f2836i;

    /* renamed from: j  reason: collision with root package name */
    public final Paint f2837j = new Paint();

    /* renamed from: k  reason: collision with root package name */
    public int f2838k;

    public static class a extends Property<l, Float> {
        public a(Class cls, String str) {
            super(cls, str);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.util.Property
        public Float get(l lVar) {
            return Float.valueOf(lVar.c());
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // android.util.Property
        public void set(l lVar, Float f2) {
            l lVar2 = lVar;
            float floatValue = f2.floatValue();
            if (lVar2.f2836i != floatValue) {
                lVar2.f2836i = floatValue;
                lVar2.invalidateSelf();
            }
        }
    }

    public l(Context context, c cVar) {
        this.b = context;
        this.c = cVar;
        this.f2831d = new a();
        this.f2838k = 255;
        invalidateSelf();
    }

    public final void b(ValueAnimator... valueAnimatorArr) {
        boolean z = this.f2835h;
        this.f2835h = true;
        for (ValueAnimator valueAnimator : valueAnimatorArr) {
            valueAnimator.end();
        }
        this.f2835h = z;
    }

    public float c() {
        c cVar = this.c;
        boolean z = false;
        if (!(cVar.f2813e != 0)) {
            if (cVar.f2814f != 0) {
                z = true;
            }
            if (!z) {
                return 1.0f;
            }
        }
        return this.f2836i;
    }

    public boolean d() {
        return h(false, false, false);
    }

    public boolean e() {
        ValueAnimator valueAnimator = this.f2833f;
        return valueAnimator != null && valueAnimator.isRunning();
    }

    public boolean f() {
        ValueAnimator valueAnimator = this.f2832e;
        return valueAnimator != null && valueAnimator.isRunning();
    }

    public void g(b bVar) {
        if (this.f2834g == null) {
            this.f2834g = new ArrayList();
        }
        if (!this.f2834g.contains(bVar)) {
            this.f2834g.add(bVar);
        }
    }

    public int getAlpha() {
        return this.f2838k;
    }

    public int getOpacity() {
        return -3;
    }

    public boolean h(boolean z, boolean z2, boolean z3) {
        return i(z, z2, z3 && this.f2831d.a(this.b.getContentResolver()) > 0.0f);
    }

    public boolean i(boolean z, boolean z2, boolean z3) {
        if (this.f2832e == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, f2830l, 0.0f, 1.0f);
            this.f2832e = ofFloat;
            ofFloat.setDuration(500L);
            this.f2832e.setInterpolator(f.b.a.d.a.a.b);
            ValueAnimator valueAnimator = this.f2832e;
            if (valueAnimator == null || !valueAnimator.isRunning()) {
                this.f2832e = valueAnimator;
                valueAnimator.addListener(new j(this));
            } else {
                throw new IllegalArgumentException("Cannot set showAnimator while the current showAnimator is running.");
            }
        }
        if (this.f2833f == null) {
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, f2830l, 1.0f, 0.0f);
            this.f2833f = ofFloat2;
            ofFloat2.setDuration(500L);
            this.f2833f.setInterpolator(f.b.a.d.a.a.b);
            ValueAnimator valueAnimator2 = this.f2833f;
            if (valueAnimator2 == null || !valueAnimator2.isRunning()) {
                this.f2833f = valueAnimator2;
                valueAnimator2.addListener(new k(this));
            } else {
                throw new IllegalArgumentException("Cannot set hideAnimator while the current hideAnimator is running.");
            }
        }
        if (!isVisible() && !z) {
            return false;
        }
        ValueAnimator valueAnimator3 = z ? this.f2832e : this.f2833f;
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
            if (!(!z ? this.c.f2814f != 0 : this.c.f2813e != 0)) {
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

    public boolean isRunning() {
        return f() || e();
    }

    public boolean j(b bVar) {
        List<b> list = this.f2834g;
        if (list == null || !list.contains(bVar)) {
            return false;
        }
        this.f2834g.remove(bVar);
        if (!this.f2834g.isEmpty()) {
            return true;
        }
        this.f2834g = null;
        return true;
    }

    public void setAlpha(int i2) {
        this.f2838k = i2;
        invalidateSelf();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f2837j.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public boolean setVisible(boolean z, boolean z2) {
        return h(z, z2, true);
    }

    public void start() {
        i(true, true, false);
    }

    public void stop() {
        i(false, true, false);
    }
}
