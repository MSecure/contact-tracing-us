package f.b.a.d.r;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.Property;
import android.view.animation.AnimationUtils;
import com.google.android.material.R$animator;
import java.util.Arrays;

public final class o extends k<AnimatorSet> {
    public static final Property<o, Float> m = new a(Float.class, "line1HeadFraction");
    public static final Property<o, Float> n = new b(Float.class, "line1TailFraction");
    public static final Property<o, Float> o = new c(Float.class, "line2HeadFraction");
    public static final Property<o, Float> p = new d(Float.class, "line2TailFraction");

    /* renamed from: d  reason: collision with root package name */
    public final Context f2721d;

    /* renamed from: e  reason: collision with root package name */
    public AnimatorSet f2722e;

    /* renamed from: f  reason: collision with root package name */
    public int f2723f;

    /* renamed from: g  reason: collision with root package name */
    public float f2724g;

    /* renamed from: h  reason: collision with root package name */
    public float f2725h;

    /* renamed from: i  reason: collision with root package name */
    public float f2726i;

    /* renamed from: j  reason: collision with root package name */
    public float f2727j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f2728k = false;

    /* renamed from: l  reason: collision with root package name */
    public e.x.a.a.b f2729l = null;

    public static class a extends Property<o, Float> {
        public a(Class cls, String str) {
            super(cls, str);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.util.Property
        public Float get(o oVar) {
            return Float.valueOf(oVar.f2724g);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // android.util.Property
        public void set(o oVar, Float f2) {
            o oVar2 = oVar;
            float floatValue = f2.floatValue();
            oVar2.f2724g = floatValue;
            oVar2.b[3] = floatValue;
            oVar2.a.invalidateSelf();
        }
    }

    public static class b extends Property<o, Float> {
        public b(Class cls, String str) {
            super(cls, str);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.util.Property
        public Float get(o oVar) {
            return Float.valueOf(oVar.f2725h);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // android.util.Property
        public void set(o oVar, Float f2) {
            o oVar2 = oVar;
            float floatValue = f2.floatValue();
            oVar2.f2725h = floatValue;
            oVar2.b[2] = floatValue;
            oVar2.a.invalidateSelf();
        }
    }

    public static class c extends Property<o, Float> {
        public c(Class cls, String str) {
            super(cls, str);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.util.Property
        public Float get(o oVar) {
            return Float.valueOf(oVar.f2726i);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // android.util.Property
        public void set(o oVar, Float f2) {
            o oVar2 = oVar;
            float floatValue = f2.floatValue();
            oVar2.f2726i = floatValue;
            oVar2.b[1] = floatValue;
            oVar2.a.invalidateSelf();
        }
    }

    public static class d extends Property<o, Float> {
        public d(Class cls, String str) {
            super(cls, str);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.util.Property
        public Float get(o oVar) {
            return Float.valueOf(oVar.f2727j);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // android.util.Property
        public void set(o oVar, Float f2) {
            o oVar2 = oVar;
            float floatValue = f2.floatValue();
            oVar2.f2727j = floatValue;
            oVar2.b[0] = floatValue;
            oVar2.a.invalidateSelf();
        }
    }

    public o(Context context) {
        super(2);
        this.f2721d = context;
    }

    @Override // f.b.a.d.r.k
    public void a() {
        AnimatorSet animatorSet = this.f2722e;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
    }

    @Override // f.b.a.d.r.k
    public void b() {
        this.f2723f = 0;
        Arrays.fill(this.c, this.a.f2719k[0]);
    }

    @Override // f.b.a.d.r.k
    public void c(e.x.a.a.b bVar) {
        this.f2729l = bVar;
    }

    @Override // f.b.a.d.r.k
    public void e() {
        if (!this.f2728k) {
            if (!this.a.isVisible()) {
                a();
            } else {
                this.f2728k = true;
            }
        }
    }

    @Override // f.b.a.d.r.k
    public void f() {
        i();
        this.f2723f = 0;
        Arrays.fill(this.c, this.a.f2719k[0]);
    }

    @Override // f.b.a.d.r.k
    public void g() {
        if (this.f2722e == null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, m, 0.0f, 1.0f);
            ofFloat.setDuration(750L);
            ofFloat.setInterpolator(AnimationUtils.loadInterpolator(this.f2721d, R$animator.linear_indeterminate_line1_head_interpolator));
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this, n, 0.0f, 1.0f);
            ofFloat2.setStartDelay(333);
            ofFloat2.setDuration(850L);
            ofFloat2.setInterpolator(AnimationUtils.loadInterpolator(this.f2721d, R$animator.linear_indeterminate_line1_tail_interpolator));
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this, o, 0.0f, 1.0f);
            ofFloat3.setStartDelay(1000);
            ofFloat3.setDuration(567L);
            ofFloat3.setInterpolator(AnimationUtils.loadInterpolator(this.f2721d, R$animator.linear_indeterminate_line2_head_interpolator));
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this, p, 0.0f, 1.0f);
            ofFloat4.setStartDelay(1267);
            ofFloat4.setDuration(533L);
            ofFloat4.setInterpolator(AnimationUtils.loadInterpolator(this.f2721d, R$animator.linear_indeterminate_line2_tail_interpolator));
            AnimatorSet animatorSet = new AnimatorSet();
            this.f2722e = animatorSet;
            animatorSet.playTogether(ofFloat, ofFloat2, ofFloat3, ofFloat4);
            this.f2722e.addListener(new n(this));
        }
        this.f2722e.start();
    }

    @Override // f.b.a.d.r.k
    public void h() {
        this.f2729l = null;
    }

    public void i() {
        this.f2724g = 0.0f;
        this.b[3] = 0.0f;
        this.a.invalidateSelf();
        this.f2725h = 0.0f;
        this.b[2] = 0.0f;
        this.a.invalidateSelf();
        this.f2726i = 0.0f;
        this.b[1] = 0.0f;
        this.a.invalidateSelf();
        this.f2727j = 0.0f;
        this.b[0] = 0.0f;
        this.a.invalidateSelf();
        int[] iArr = this.a.f2719k;
        int length = (this.f2723f + 1) % iArr.length;
        this.f2723f = length;
        Arrays.fill(this.c, iArr[length]);
    }
}
