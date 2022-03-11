package f.b.a.d.r;

import android.animation.ObjectAnimator;
import android.util.Property;

public final class g extends n<ObjectAnimator> {

    /* renamed from: l  reason: collision with root package name */
    public static final int[] f2818l = {0, 1350, 2700, 4050};
    public static final int[] m = {667, 2017, 3367, 4717};
    public static final int[] n = {1000, 2350, 3700, 5050};
    public static final Property<g, Float> o = new a(Float.class, "animationFraction");
    public static final Property<g, Float> p = new b(Float.class, "completeEndFraction");

    /* renamed from: d  reason: collision with root package name */
    public ObjectAnimator f2819d;

    /* renamed from: e  reason: collision with root package name */
    public ObjectAnimator f2820e;

    /* renamed from: f  reason: collision with root package name */
    public final e.o.a.a.b f2821f;

    /* renamed from: g  reason: collision with root package name */
    public final c f2822g;

    /* renamed from: h  reason: collision with root package name */
    public int f2823h = 0;

    /* renamed from: i  reason: collision with root package name */
    public float f2824i;

    /* renamed from: j  reason: collision with root package name */
    public float f2825j;

    /* renamed from: k  reason: collision with root package name */
    public e.x.a.a.b f2826k = null;

    public static class a extends Property<g, Float> {
        public a(Class cls, String str) {
            super(cls, str);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.util.Property
        public Float get(g gVar) {
            return Float.valueOf(gVar.f2824i);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // android.util.Property
        public void set(g gVar, Float f2) {
            g gVar2 = gVar;
            float floatValue = f2.floatValue();
            gVar2.f2824i = floatValue;
            int i2 = (int) (5400.0f * floatValue);
            float[] fArr = gVar2.b;
            float f3 = floatValue * 1520.0f;
            fArr[0] = -20.0f + f3;
            fArr[1] = f3;
            for (int i3 = 0; i3 < 4; i3++) {
                float b = gVar2.b(i2, g.f2818l[i3], 667);
                float[] fArr2 = gVar2.b;
                fArr2[1] = (gVar2.f2821f.getInterpolation(b) * 250.0f) + fArr2[1];
                float b2 = gVar2.b(i2, g.m[i3], 667);
                float[] fArr3 = gVar2.b;
                fArr3[0] = (gVar2.f2821f.getInterpolation(b2) * 250.0f) + fArr3[0];
            }
            float[] fArr4 = gVar2.b;
            fArr4[0] = ((fArr4[1] - fArr4[0]) * gVar2.f2825j) + fArr4[0];
            fArr4[0] = fArr4[0] / 360.0f;
            fArr4[1] = fArr4[1] / 360.0f;
            int i4 = 0;
            while (true) {
                if (i4 >= 4) {
                    break;
                }
                float b3 = gVar2.b(i2, g.n[i4], 333);
                if (b3 >= 0.0f && b3 <= 1.0f) {
                    int i5 = i4 + gVar2.f2823h;
                    int[] iArr = gVar2.f2822g.c;
                    int length = i5 % iArr.length;
                    int M = f.b.a.c.b.o.b.M(iArr[length], gVar2.a.f2838k);
                    int M2 = f.b.a.c.b.o.b.M(gVar2.f2822g.c[(length + 1) % iArr.length], gVar2.a.f2838k);
                    gVar2.c[0] = f.b.a.d.a.b.a.evaluate(gVar2.f2821f.getInterpolation(b3), Integer.valueOf(M), Integer.valueOf(M2)).intValue();
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
            return Float.valueOf(gVar.f2825j);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // android.util.Property
        public void set(g gVar, Float f2) {
            gVar.f2825j = f2.floatValue();
        }
    }

    public g(h hVar) {
        super(1);
        this.f2822g = hVar;
        this.f2821f = new e.o.a.a.b();
    }

    @Override // f.b.a.d.r.n
    public void a() {
        ObjectAnimator objectAnimator = this.f2819d;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    public void c() {
        this.f2823h = 0;
        this.c[0] = f.b.a.c.b.o.b.M(this.f2822g.c[0], this.a.f2838k);
        this.f2825j = 0.0f;
    }
}
