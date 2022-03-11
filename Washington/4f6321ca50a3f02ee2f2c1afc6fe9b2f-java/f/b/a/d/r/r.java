package f.b.a.d.r;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.util.Property;

public final class r extends k<AnimatorSet> {

    /* renamed from: h  reason: collision with root package name */
    public static final Property<r, Float> f2730h = new a(Float.class, "lineConnectPoint1Fraction");

    /* renamed from: i  reason: collision with root package name */
    public static final Property<r, Float> f2731i = new b(Float.class, "lineConnectPoint2Fraction");

    /* renamed from: d  reason: collision with root package name */
    public AnimatorSet f2732d;

    /* renamed from: e  reason: collision with root package name */
    public int f2733e;

    /* renamed from: f  reason: collision with root package name */
    public float f2734f;

    /* renamed from: g  reason: collision with root package name */
    public float f2735g;

    public static class a extends Property<r, Float> {
        public a(Class cls, String str) {
            super(cls, str);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.util.Property
        public Float get(r rVar) {
            return Float.valueOf(rVar.f2734f);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // android.util.Property
        public void set(r rVar, Float f2) {
            r rVar2 = rVar;
            rVar2.f2734f = f2.floatValue();
            rVar2.j();
            rVar2.a.invalidateSelf();
        }
    }

    public static class b extends Property<r, Float> {
        public b(Class cls, String str) {
            super(cls, str);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.util.Property
        public Float get(r rVar) {
            return Float.valueOf(rVar.f2735g);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // android.util.Property
        public void set(r rVar, Float f2) {
            r rVar2 = rVar;
            rVar2.f2735g = f2.floatValue();
            rVar2.j();
            rVar2.a.invalidateSelf();
        }
    }

    public r() {
        super(3);
    }

    @Override // f.b.a.d.r.k
    public void a() {
        AnimatorSet animatorSet = this.f2732d;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
    }

    @Override // f.b.a.d.r.k
    public void b() {
        this.f2733e = 0;
        i();
    }

    @Override // f.b.a.d.r.k
    public void c(e.x.a.a.b bVar) {
    }

    @Override // f.b.a.d.r.k
    public void e() {
    }

    @Override // f.b.a.d.r.k
    public void f() {
        this.f2734f = 0.0f;
        j();
        this.a.invalidateSelf();
        this.f2735g = 0.0f;
        j();
        this.a.invalidateSelf();
        this.f2733e = 0;
        i();
    }

    @Override // f.b.a.d.r.k
    public void g() {
        if (this.f2732d == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, f2730h, 0.0f, 1.0f);
            ofFloat.setDuration(667L);
            TimeInterpolator timeInterpolator = f.b.a.d.a.a.b;
            ofFloat.setInterpolator(timeInterpolator);
            ofFloat.setRepeatCount(-1);
            ofFloat.setRepeatMode(1);
            ofFloat.addListener(new p(this));
            Property<r, Float> property = f2731i;
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, property, 0.0f, 0.0f);
            ofFloat2.setDuration(333L);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this, property, 0.0f, 1.0f);
            ofFloat3.setDuration(667L);
            ofFloat3.setInterpolator(timeInterpolator);
            ofFloat3.setRepeatCount(-1);
            ofFloat3.setRepeatMode(1);
            ofFloat3.addListener(new q(this));
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playSequentially(ofFloat2, ofFloat3);
            AnimatorSet animatorSet2 = new AnimatorSet();
            this.f2732d = animatorSet2;
            animatorSet2.playTogether(ofFloat, animatorSet);
        }
        this.f2732d.start();
    }

    @Override // f.b.a.d.r.k
    public void h() {
    }

    public final void i() {
        int i2 = this.f2733e;
        int i3 = i2 + 2;
        int[] iArr = this.a.f2719k;
        int length = iArr.length;
        int i4 = i3 / length;
        if ((i3 ^ length) < 0 && i4 * length != i3) {
            i4--;
        }
        int i5 = i3 - (i4 * length);
        int i6 = i2 + 1;
        int length2 = iArr.length;
        int i7 = i6 / length2;
        if ((i6 ^ length2) < 0 && i7 * length2 != i6) {
            i7--;
        }
        int[] iArr2 = this.c;
        iArr2[0] = iArr[i5];
        iArr2[1] = iArr[i6 - (i7 * length2)];
        iArr2[2] = iArr[i2];
    }

    public final void j() {
        float[] fArr = this.b;
        fArr[0] = 0.0f;
        float min = Math.min(this.f2734f, this.f2735g);
        fArr[2] = min;
        fArr[1] = min;
        float[] fArr2 = this.b;
        float max = Math.max(this.f2734f, this.f2735g);
        fArr2[4] = max;
        fArr2[3] = max;
        this.b[5] = 1.0f;
    }
}
