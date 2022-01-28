package f.b.a.e.p;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.PathInterpolator;
import com.google.android.material.R$attr;
import com.google.android.material.R$integer;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import e.b.a.m;
import e.i.i.v;
import f.b.a.e.v.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class d {
    public static final int[] A = {16842908, 16842910};
    public static final int[] B = {16843623, 16842910};
    public static final int[] C = {16842910};
    public static final int[] D = new int[0];
    public static final TimeInterpolator x = f.b.a.e.a.a.c;
    public static final int[] y = {16842919, 16842910};
    public static final int[] z = {16843623, 16842908, 16842910};
    public j a;
    public boolean b;
    public boolean c = true;

    /* renamed from: d  reason: collision with root package name */
    public float f2927d;

    /* renamed from: e  reason: collision with root package name */
    public float f2928e;

    /* renamed from: f  reason: collision with root package name */
    public float f2929f;

    /* renamed from: g  reason: collision with root package name */
    public final f.b.a.e.q.g f2930g;

    /* renamed from: h  reason: collision with root package name */
    public Animator f2931h;

    /* renamed from: i  reason: collision with root package name */
    public f.b.a.e.a.g f2932i;

    /* renamed from: j  reason: collision with root package name */
    public f.b.a.e.a.g f2933j;

    /* renamed from: k  reason: collision with root package name */
    public float f2934k;

    /* renamed from: l  reason: collision with root package name */
    public float f2935l = 1.0f;
    public int m = 0;
    public ArrayList<Animator.AnimatorListener> n;
    public ArrayList<Animator.AnimatorListener> o;
    public ArrayList<f> p;
    public final FloatingActionButton q;
    public final f.b.a.e.u.b r;
    public final Rect s = new Rect();
    public final RectF t = new RectF();
    public final RectF u = new RectF();
    public final Matrix v = new Matrix();
    public ViewTreeObserver.OnPreDrawListener w;

    public class a extends f.b.a.e.a.f {
        public a() {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [float, java.lang.Object, java.lang.Object] */
        @Override // android.animation.TypeEvaluator
        public Matrix evaluate(float f2, Matrix matrix, Matrix matrix2) {
            d.this.f2935l = f2;
            matrix.getValues(this.a);
            matrix2.getValues(this.b);
            for (int i2 = 0; i2 < 9; i2++) {
                float[] fArr = this.b;
                float f3 = fArr[i2];
                float[] fArr2 = this.a;
                fArr[i2] = ((f3 - fArr2[i2]) * f2) + fArr2[i2];
            }
            this.c.setValues(this.b);
            return this.c;
        }
    }

    public class b implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ float a;
        public final /* synthetic */ float b;
        public final /* synthetic */ float c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ float f2937d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ float f2938e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ float f2939f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ float f2940g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Matrix f2941h;

        public b(float f2, float f3, float f4, float f5, float f6, float f7, float f8, Matrix matrix) {
            this.a = f2;
            this.b = f3;
            this.c = f4;
            this.f2937d = f5;
            this.f2938e = f6;
            this.f2939f = f7;
            this.f2940g = f8;
            this.f2941h = matrix;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            d.this.q.setAlpha(f.b.a.e.a.a.b(this.a, this.b, 0.0f, 0.2f, floatValue));
            d.this.q.setScaleX(f.b.a.e.a.a.a(this.c, this.f2937d, floatValue));
            d.this.q.setScaleY(f.b.a.e.a.a.a(this.f2938e, this.f2937d, floatValue));
            d.this.f2935l = f.b.a.e.a.a.a(this.f2939f, this.f2940g, floatValue);
            d.this.a(f.b.a.e.a.a.a(this.f2939f, this.f2940g, floatValue), this.f2941h);
            d.this.q.setImageMatrix(this.f2941h);
        }
    }

    public class c extends i {
        public c(d dVar) {
            super(null);
        }

        @Override // f.b.a.e.p.d.i
        public float a() {
            return 0.0f;
        }
    }

    /* renamed from: f.b.a.e.p.d$d  reason: collision with other inner class name */
    public class C0094d extends i {
        public C0094d() {
            super(null);
        }

        @Override // f.b.a.e.p.d.i
        public float a() {
            d dVar = d.this;
            return dVar.f2927d + dVar.f2928e;
        }
    }

    public class e extends i {
        public e() {
            super(null);
        }

        @Override // f.b.a.e.p.d.i
        public float a() {
            d dVar = d.this;
            return dVar.f2927d + dVar.f2929f;
        }
    }

    public interface f {
        void a();

        void b();
    }

    public interface g {
    }

    public class h extends i {
        public h() {
            super(null);
        }

        @Override // f.b.a.e.p.d.i
        public float a() {
            return d.this.f2927d;
        }
    }

    public abstract class i extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {
        public boolean a;
        public float b;

        public i(b bVar) {
        }

        public abstract float a();

        public void onAnimationEnd(Animator animator) {
            Objects.requireNonNull(d.this);
            this.a = false;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (!this.a) {
                Objects.requireNonNull(d.this);
                this.b = a();
                this.a = true;
            }
            d dVar = d.this;
            valueAnimator.getAnimatedFraction();
            Objects.requireNonNull(dVar);
        }
    }

    public d(FloatingActionButton floatingActionButton, f.b.a.e.u.b bVar) {
        this.q = floatingActionButton;
        this.r = bVar;
        f.b.a.e.q.g gVar = new f.b.a.e.q.g();
        this.f2930g = gVar;
        gVar.a(y, d(new e()));
        gVar.a(z, d(new C0094d()));
        gVar.a(A, d(new C0094d()));
        gVar.a(B, d(new C0094d()));
        gVar.a(C, d(new h()));
        gVar.a(D, d(new c(this)));
        this.f2934k = floatingActionButton.getRotation();
    }

    public final void a(float f2, Matrix matrix) {
        matrix.reset();
        this.q.getDrawable();
    }

    public final AnimatorSet b(f.b.a.e.a.g gVar, float f2, float f3, float f4) {
        ArrayList arrayList = new ArrayList();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.q, View.ALPHA, f2);
        gVar.d("opacity").a(ofFloat);
        arrayList.add(ofFloat);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.q, View.SCALE_X, f3);
        gVar.d("scale").a(ofFloat2);
        int i2 = Build.VERSION.SDK_INT;
        if (i2 == 26) {
            ofFloat2.setEvaluator(new e(this));
        }
        arrayList.add(ofFloat2);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.q, View.SCALE_Y, f3);
        gVar.d("scale").a(ofFloat3);
        if (i2 == 26) {
            ofFloat3.setEvaluator(new e(this));
        }
        arrayList.add(ofFloat3);
        a(f4, this.v);
        ObjectAnimator ofObject = ObjectAnimator.ofObject(this.q, new f.b.a.e.a.e(), new a(), new Matrix(this.v));
        gVar.d("iconScale").a(ofObject);
        arrayList.add(ofObject);
        AnimatorSet animatorSet = new AnimatorSet();
        f.b.a.c.b.o.b.g1(animatorSet, arrayList);
        return animatorSet;
    }

    public final AnimatorSet c(float f2, float f3, float f4) {
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new b(this.q.getAlpha(), f2, this.q.getScaleX(), f3, this.q.getScaleY(), this.f2935l, f4, new Matrix(this.v)));
        arrayList.add(ofFloat);
        f.b.a.c.b.o.b.g1(animatorSet, arrayList);
        Context context = this.q.getContext();
        int i2 = R$attr.motionDurationLong1;
        int integer = this.q.getContext().getResources().getInteger(R$integer.material_motion_duration_long_1);
        TypedValue k1 = f.b.a.c.b.o.b.k1(context, i2);
        if (k1 != null && k1.type == 16) {
            integer = k1.data;
        }
        animatorSet.setDuration((long) integer);
        Context context2 = this.q.getContext();
        int i3 = R$attr.motionEasingStandard;
        TimeInterpolator timeInterpolator = f.b.a.e.a.a.b;
        TypedValue typedValue = new TypedValue();
        if (context2.getTheme().resolveAttribute(i3, typedValue, true)) {
            if (typedValue.type == 3) {
                String valueOf = String.valueOf(typedValue.string);
                if (f.b.a.c.b.o.b.S0(valueOf, "cubic-bezier")) {
                    String[] split = valueOf.substring(13, valueOf.length() - 1).split(",");
                    if (split.length == 4) {
                        timeInterpolator = new PathInterpolator(f.b.a.c.b.o.b.z0(split, 0), f.b.a.c.b.o.b.z0(split, 1), f.b.a.c.b.o.b.z0(split, 2), f.b.a.c.b.o.b.z0(split, 3));
                    } else {
                        StringBuilder h2 = f.a.a.a.a.h("Motion easing theme attribute must have 4 control points if using bezier curve format; instead got: ");
                        h2.append(split.length);
                        throw new IllegalArgumentException(h2.toString());
                    }
                } else if (f.b.a.c.b.o.b.S0(valueOf, "path")) {
                    timeInterpolator = new PathInterpolator(m.e.M(valueOf.substring(5, valueOf.length() - 1)));
                } else {
                    throw new IllegalArgumentException(f.a.a.a.a.w("Invalid motion easing type: ", valueOf));
                }
            } else {
                throw new IllegalArgumentException("Motion easing theme attribute must be a string");
            }
        }
        animatorSet.setInterpolator(timeInterpolator);
        return animatorSet;
    }

    public final ValueAnimator d(i iVar) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setInterpolator(x);
        valueAnimator.setDuration(100L);
        valueAnimator.addListener(iVar);
        valueAnimator.addUpdateListener(iVar);
        valueAnimator.setFloatValues(0.0f, 1.0f);
        return valueAnimator;
    }

    public float e() {
        throw null;
    }

    public void f(Rect rect) {
        int i2 = 0;
        if (this.b) {
            i2 = (0 - this.q.getSizeDimension()) / 2;
        }
        float e2 = this.c ? e() + this.f2929f : 0.0f;
        int max = Math.max(i2, (int) Math.ceil((double) e2));
        int max2 = Math.max(i2, (int) Math.ceil((double) (e2 * 1.5f)));
        rect.set(max, max2, max, max2);
    }

    public boolean g() {
        return this.q.getVisibility() == 0 ? this.m == 1 : this.m != 2;
    }

    public boolean h() {
        return this.q.getVisibility() != 0 ? this.m == 2 : this.m != 1;
    }

    public void i() {
        throw null;
    }

    public void j() {
        throw null;
    }

    public void k(int[] iArr) {
        throw null;
    }

    public void l(float f2, float f3, float f4) {
        throw null;
    }

    public void m() {
        ArrayList<f> arrayList = this.p;
        if (arrayList != null) {
            Iterator<f> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
        }
    }

    public void n() {
        ArrayList<f> arrayList = this.p;
        if (arrayList != null) {
            Iterator<f> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().b();
            }
        }
    }

    public boolean o() {
        throw null;
    }

    public final void p(float f2) {
        this.f2935l = f2;
        Matrix matrix = this.v;
        a(f2, matrix);
        this.q.setImageMatrix(matrix);
    }

    public void q(ColorStateList colorStateList) {
        throw null;
    }

    public boolean r() {
        throw null;
    }

    public final boolean s() {
        FloatingActionButton floatingActionButton = this.q;
        AtomicInteger atomicInteger = v.a;
        return v.g.c(floatingActionButton) && !this.q.isInEditMode();
    }

    public final boolean t() {
        return !this.b || this.q.getSizeDimension() >= 0;
    }

    public void u() {
        throw null;
    }

    public final void v() {
        Rect rect = this.s;
        f(rect);
        m.e.q(null, "Didn't initialize content background");
        if (r()) {
            InsetDrawable insetDrawable = new InsetDrawable((Drawable) null, rect.left, rect.top, rect.right, rect.bottom);
            FloatingActionButton.b bVar = (FloatingActionButton.b) this.r;
            Objects.requireNonNull(bVar);
            d.super.setBackgroundDrawable(insetDrawable);
        } else {
            Objects.requireNonNull((FloatingActionButton.b) this.r);
        }
        f.b.a.e.u.b bVar2 = this.r;
        int i2 = rect.left;
        Objects.requireNonNull(FloatingActionButton.this);
        throw null;
    }
}
