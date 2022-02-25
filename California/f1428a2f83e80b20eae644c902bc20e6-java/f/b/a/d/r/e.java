package f.b.a.d.r;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.util.Property;

public final class e extends k<AnimatorSet> {
    public static final Property<e, Integer> o = new a(Integer.class, "displayedIndicatorColor");
    public static final Property<e, Float> p = new b(Float.class, "indicatorInCycleOffset");
    public static final Property<e, Float> q = new c(Float.class, "indicatorHeadChangeFraction");
    public static final Property<e, Float> r = new d(Float.class, "indicatorTailChangeFraction");

    /* renamed from: d  reason: collision with root package name */
    public AnimatorSet f2695d;

    /* renamed from: e  reason: collision with root package name */
    public ObjectAnimator f2696e;

    /* renamed from: f  reason: collision with root package name */
    public ObjectAnimator f2697f;

    /* renamed from: g  reason: collision with root package name */
    public int f2698g;

    /* renamed from: h  reason: collision with root package name */
    public int f2699h;

    /* renamed from: i  reason: collision with root package name */
    public float f2700i;

    /* renamed from: j  reason: collision with root package name */
    public float f2701j;

    /* renamed from: k  reason: collision with root package name */
    public float f2702k;

    /* renamed from: l  reason: collision with root package name */
    public float f2703l;
    public boolean m = false;
    public e.x.a.a.b n = null;

    public static class a extends Property<e, Integer> {
        public a(Class cls, String str) {
            super(cls, str);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.util.Property
        public Integer get(e eVar) {
            return Integer.valueOf(eVar.f2699h);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // android.util.Property
        public void set(e eVar, Integer num) {
            e eVar2 = eVar;
            int intValue = num.intValue();
            eVar2.f2699h = intValue;
            eVar2.c[0] = intValue;
            eVar2.a.invalidateSelf();
        }
    }

    public static class b extends Property<e, Float> {
        public b(Class cls, String str) {
            super(cls, str);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.util.Property
        public Float get(e eVar) {
            return Float.valueOf(eVar.f2701j);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // android.util.Property
        public void set(e eVar, Float f2) {
            e eVar2 = eVar;
            eVar2.f2701j = f2.floatValue();
            eVar2.n();
            eVar2.a.invalidateSelf();
        }
    }

    public static class c extends Property<e, Float> {
        public c(Class cls, String str) {
            super(cls, str);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.util.Property
        public Float get(e eVar) {
            return Float.valueOf(eVar.f2702k);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // android.util.Property
        public void set(e eVar, Float f2) {
            eVar.l(f2.floatValue());
        }
    }

    public static class d extends Property<e, Float> {
        public d(Class cls, String str) {
            super(cls, str);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.util.Property
        public Float get(e eVar) {
            return Float.valueOf(eVar.f2703l);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // android.util.Property
        public void set(e eVar, Float f2) {
            eVar.m(f2.floatValue());
        }
    }

    public e() {
        super(1);
    }

    @Override // f.b.a.d.r.k
    public void a() {
        AnimatorSet animatorSet = this.f2695d;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
    }

    @Override // f.b.a.d.r.k
    public void b() {
        j();
    }

    @Override // f.b.a.d.r.k
    public void c(e.x.a.a.b bVar) {
        this.n = bVar;
    }

    @Override // f.b.a.d.r.k
    public void d(l lVar) {
        this.a = lVar;
        ObjectAnimator ofObject = ObjectAnimator.ofObject(this, o, new f.b.a.d.a.b(), Integer.valueOf(lVar.f2711k[this.f2698g]), Integer.valueOf(lVar.f2711k[i()]));
        this.f2697f = ofObject;
        ofObject.setDuration(333L);
        this.f2697f.setStartDelay(1000);
        this.f2697f.setInterpolator(f.b.a.d.a.a.b);
        AnimatorSet animatorSet = this.f2695d;
        if (animatorSet != null) {
            animatorSet.playTogether(this.f2697f);
        }
    }

    @Override // f.b.a.d.r.k
    public void e() {
        if (!this.m) {
            if (this.a.isVisible()) {
                this.m = true;
            } else {
                a();
            }
        }
    }

    @Override // f.b.a.d.r.k
    public void f() {
        l(0.0f);
        m(0.0f);
        this.f2700i = 0.0f;
        n();
        this.a.invalidateSelf();
        ObjectAnimator objectAnimator = this.f2696e;
        if (objectAnimator != null) {
            objectAnimator.setFloatValues(0.0f, 1.0f);
        }
        j();
    }

    @Override // f.b.a.d.r.k
    public void g() {
        if (this.f2695d == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, p, 0.0f, 360.0f);
            ofFloat.setDuration(1333L);
            ofFloat.setInterpolator(null);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, q, 0.0f, 1.0f);
            ofFloat2.setDuration(666L);
            TimeInterpolator timeInterpolator = f.b.a.d.a.a.b;
            ofFloat2.setInterpolator(timeInterpolator);
            ofFloat2.addListener(new c(this));
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this, r, 0.0f, 1.0f);
            this.f2696e = ofFloat3;
            ofFloat3.setDuration(666L);
            this.f2696e.setInterpolator(timeInterpolator);
            AnimatorSet animatorSet = new AnimatorSet();
            this.f2695d = animatorSet;
            animatorSet.playSequentially(ofFloat2, this.f2696e);
            this.f2695d.playTogether(ofFloat);
            ObjectAnimator objectAnimator = this.f2697f;
            if (objectAnimator != null) {
                this.f2695d.playTogether(objectAnimator);
            }
            this.f2695d.addListener(new d(this));
        }
        this.f2695d.start();
    }

    @Override // f.b.a.d.r.k
    public void h() {
        this.n = null;
    }

    public final int i() {
        return (this.f2698g + 1) % this.a.f2711k.length;
    }

    public final void j() {
        this.f2698g = 0;
        ObjectAnimator objectAnimator = this.f2697f;
        int[] iArr = this.a.f2711k;
        objectAnimator.setIntValues(iArr[0], iArr[i()]);
        k(this.a.f2711k[this.f2698g]);
    }

    public final void k(int i2) {
        this.f2699h = i2;
        this.c[0] = i2;
        this.a.invalidateSelf();
    }

    public void l(float f2) {
        this.f2702k = f2;
        n();
        this.a.invalidateSelf();
    }

    public void m(float f2) {
        this.f2703l = f2;
        n();
        this.a.invalidateSelf();
    }

    public final void n() {
        float[] fArr = this.b;
        float f2 = this.f2700i + this.f2701j;
        fArr[0] = ((this.f2703l * 250.0f) + (f2 - 20.0f)) / 360.0f;
        fArr[1] = ((this.f2702k * 250.0f) + f2) / 360.0f;
    }
}
