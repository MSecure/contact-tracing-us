package f.b.a.e.r;

import android.animation.ObjectAnimator;
import android.util.Property;
/* loaded from: classes.dex */
public final class g extends n<ObjectAnimator> {

    /* renamed from: l */
    public static final int[] f3029l = {0, 1350, 2700, 4050};
    public static final int[] m = {667, 2017, 3367, 4717};
    public static final int[] n = {1000, 2350, 3700, 5050};
    public static final Property<g, Float> o = new a(Float.class, "animationFraction");
    public static final Property<g, Float> p = new b(Float.class, "completeEndFraction");

    /* renamed from: d */
    public ObjectAnimator f3030d;

    /* renamed from: e */
    public ObjectAnimator f3031e;

    /* renamed from: g */
    public final c f3033g;

    /* renamed from: i */
    public float f3035i;

    /* renamed from: j */
    public float f3036j;

    /* renamed from: h */
    public int f3034h = 0;

    /* renamed from: k */
    public e.a0.a.a.b f3037k = null;

    /* renamed from: f */
    public final e.q.a.a.b f3032f = new e.q.a.a.b();

    /* loaded from: classes.dex */
    public static class a extends Property<g, Float> {
        public a(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        public Float get(g gVar) {
            return Float.valueOf(gVar.f3035i);
        }

        @Override // android.util.Property
        public void set(g gVar, Float f2) {
            g gVar2 = gVar;
            float floatValue = f2.floatValue();
            gVar2.f3035i = floatValue;
            int i2 = (int) (5400.0f * floatValue);
            float[] fArr = gVar2.b;
            float f3 = floatValue * 1520.0f;
            fArr[0] = -20.0f + f3;
            fArr[1] = f3;
            for (int i3 = 0; i3 < 4; i3++) {
                float b = gVar2.b(i2, g.f3029l[i3], 667);
                float[] fArr2 = gVar2.b;
                fArr2[1] = (gVar2.f3032f.getInterpolation(b) * 250.0f) + fArr2[1];
                float b2 = gVar2.b(i2, g.m[i3], 667);
                float[] fArr3 = gVar2.b;
                fArr3[0] = (gVar2.f3032f.getInterpolation(b2) * 250.0f) + fArr3[0];
            }
            float[] fArr4 = gVar2.b;
            fArr4[0] = ((fArr4[1] - fArr4[0]) * gVar2.f3036j) + fArr4[0];
            fArr4[0] = fArr4[0] / 360.0f;
            fArr4[1] = fArr4[1] / 360.0f;
            int i4 = 0;
            while (true) {
                if (i4 >= 4) {
                    break;
                }
                float b3 = gVar2.b(i2, g.n[i4], 333);
                if (b3 >= 0.0f && b3 <= 1.0f) {
                    int i5 = i4 + gVar2.f3034h;
                    int[] iArr = gVar2.f3033g.c;
                    int length = i5 % iArr.length;
                    int I = f.b.a.c.b.o.b.I(iArr[length], gVar2.a.f3049k);
                    int I2 = f.b.a.c.b.o.b.I(gVar2.f3033g.c[(length + 1) % iArr.length], gVar2.a.f3049k);
                    gVar2.c[0] = f.b.a.e.a.b.a.evaluate(gVar2.f3032f.getInterpolation(b3), Integer.valueOf(I), Integer.valueOf(I2)).intValue();
                    break;
                }
                i4++;
            }
            gVar2.a.invalidateSelf();
        }
    }

    /* loaded from: classes.dex */
    public static class b extends Property<g, Float> {
        public b(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        public Float get(g gVar) {
            return Float.valueOf(gVar.f3036j);
        }

        @Override // android.util.Property
        public void set(g gVar, Float f2) {
            gVar.f3036j = f2.floatValue();
        }
    }

    public g(h hVar) {
        super(1);
        this.f3033g = hVar;
    }

    @Override // f.b.a.e.r.n
    public void a() {
        ObjectAnimator objectAnimator = this.f3030d;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    @Override // f.b.a.e.r.n
    public void c() {
        if (this.f3030d == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, o, 0.0f, 1.0f);
            this.f3030d = ofFloat;
            ofFloat.setDuration(5400L);
            this.f3030d.setInterpolator(null);
            this.f3030d.setRepeatCount(-1);
            this.f3030d.addListener(new e(this));
        }
        if (this.f3031e == null) {
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, p, 0.0f, 1.0f);
            this.f3031e = ofFloat2;
            ofFloat2.setDuration(333L);
            this.f3031e.setInterpolator(this.f3032f);
            this.f3031e.addListener(new f(this));
        }
        d();
        this.f3030d.start();
    }

    public void d() {
        this.f3034h = 0;
        this.c[0] = f.b.a.c.b.o.b.I(this.f3033g.c[0], this.a.f3049k);
        this.f3036j = 0.0f;
    }
}
