package f.b.a.e.r;

import android.animation.ObjectAnimator;
import android.util.Property;

public final class g extends n<ObjectAnimator> {

    /* renamed from: l  reason: collision with root package name */
    public static final int[] f2987l = {0, 1350, 2700, 4050};
    public static final int[] m = {667, 2017, 3367, 4717};
    public static final int[] n = {1000, 2350, 3700, 5050};
    public static final Property<g, Float> o = new a(Float.class, "animationFraction");
    public static final Property<g, Float> p = new b(Float.class, "completeEndFraction");

    /* renamed from: d  reason: collision with root package name */
    public ObjectAnimator f2988d;

    /* renamed from: e  reason: collision with root package name */
    public ObjectAnimator f2989e;

    /* renamed from: f  reason: collision with root package name */
    public final e.p.a.a.b f2990f;

    /* renamed from: g  reason: collision with root package name */
    public final c f2991g;

    /* renamed from: h  reason: collision with root package name */
    public int f2992h = 0;

    /* renamed from: i  reason: collision with root package name */
    public float f2993i;

    /* renamed from: j  reason: collision with root package name */
    public float f2994j;

    /* renamed from: k  reason: collision with root package name */
    public e.z.a.a.b f2995k = null;

    public static class a extends Property<g, Float> {
        public a(Class cls, String str) {
            super(cls, str);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.util.Property
        public Float get(g gVar) {
            return Float.valueOf(gVar.f2993i);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // android.util.Property
        public void set(g gVar, Float f2) {
            g gVar2 = gVar;
            float floatValue = f2.floatValue();
            gVar2.f2993i = floatValue;
            int i2 = (int) (5400.0f * floatValue);
            float[] fArr = gVar2.b;
            float f3 = floatValue * 1520.0f;
            fArr[0] = -20.0f + f3;
            fArr[1] = f3;
            for (int i3 = 0; i3 < 4; i3++) {
                float b = gVar2.b(i2, g.f2987l[i3], 667);
                float[] fArr2 = gVar2.b;
                fArr2[1] = (gVar2.f2990f.getInterpolation(b) * 250.0f) + fArr2[1];
                float b2 = gVar2.b(i2, g.m[i3], 667);
                float[] fArr3 = gVar2.b;
                fArr3[0] = (gVar2.f2990f.getInterpolation(b2) * 250.0f) + fArr3[0];
            }
            float[] fArr4 = gVar2.b;
            fArr4[0] = ((fArr4[1] - fArr4[0]) * gVar2.f2994j) + fArr4[0];
            fArr4[0] = fArr4[0] / 360.0f;
            fArr4[1] = fArr4[1] / 360.0f;
            int i4 = 0;
            while (true) {
                if (i4 >= 4) {
                    break;
                }
                float b3 = gVar2.b(i2, g.n[i4], 333);
                if (b3 >= 0.0f && b3 <= 1.0f) {
                    int i5 = i4 + gVar2.f2992h;
                    int[] iArr = gVar2.f2991g.c;
                    int length = i5 % iArr.length;
                    int H = f.b.a.c.b.o.b.H(iArr[length], gVar2.a.f3007k);
                    int H2 = f.b.a.c.b.o.b.H(gVar2.f2991g.c[(length + 1) % iArr.length], gVar2.a.f3007k);
                    gVar2.c[0] = f.b.a.e.a.b.a.evaluate(gVar2.f2990f.getInterpolation(b3), Integer.valueOf(H), Integer.valueOf(H2)).intValue();
                    break;
                }
                i4++;
            }
            gVar2.a.invalidateSelf();
        }
    }

    public static class b extends Property<g, Float> {
        public b(Class cls, String str) {
            super(cls, str);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.util.Property
        public Float get(g gVar) {
            return Float.valueOf(gVar.f2994j);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // android.util.Property
        public void set(g gVar, Float f2) {
            gVar.f2994j = f2.floatValue();
        }
    }

    public g(h hVar) {
        super(1);
        this.f2991g = hVar;
        this.f2990f = new e.p.a.a.b();
    }

    @Override // f.b.a.e.r.n
    public void a() {
        ObjectAnimator objectAnimator = this.f2988d;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    @Override // f.b.a.e.r.n
    public void c() {
        if (this.f2988d == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, o, 0.0f, 1.0f);
            this.f2988d = ofFloat;
            ofFloat.setDuration(5400L);
            this.f2988d.setInterpolator(null);
            this.f2988d.setRepeatCount(-1);
            this.f2988d.addListener(new e(this));
        }
        if (this.f2989e == null) {
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, p, 0.0f, 1.0f);
            this.f2989e = ofFloat2;
            ofFloat2.setDuration(333L);
            this.f2989e.setInterpolator(this.f2990f);
            this.f2989e.addListener(new f(this));
        }
        d();
        this.f2988d.start();
    }

    public void d() {
        this.f2992h = 0;
        this.c[0] = f.b.a.c.b.o.b.H(this.f2991g.c[0], this.a.f3007k);
        this.f2994j = 0.0f;
    }
}
