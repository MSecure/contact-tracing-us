package f.b.a.d.p;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.view.View;
import android.view.ViewTreeObserver;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import e.b.a.m;
import e.i.i.l;
import f.b.a.d.v.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class d {
    public static final int[] A = {16842919, 16842910};
    public static final int[] B = {16843623, 16842908, 16842910};
    public static final int[] C = {16842908, 16842910};
    public static final int[] D = {16843623, 16842910};
    public static final int[] E = {16842910};
    public static final int[] F = new int[0];
    public static final TimeInterpolator z = f.b.a.d.a.a.c;
    public j a;
    public boolean b;
    public boolean c = true;

    /* renamed from: d  reason: collision with root package name */
    public float f2664d;

    /* renamed from: e  reason: collision with root package name */
    public float f2665e;

    /* renamed from: f  reason: collision with root package name */
    public float f2666f;

    /* renamed from: g  reason: collision with root package name */
    public final f.b.a.d.q.g f2667g;

    /* renamed from: h  reason: collision with root package name */
    public f.b.a.d.a.g f2668h;

    /* renamed from: i  reason: collision with root package name */
    public f.b.a.d.a.g f2669i;

    /* renamed from: j  reason: collision with root package name */
    public Animator f2670j;

    /* renamed from: k  reason: collision with root package name */
    public f.b.a.d.a.g f2671k;

    /* renamed from: l  reason: collision with root package name */
    public f.b.a.d.a.g f2672l;
    public float m;
    public float n = 1.0f;
    public int o = 0;
    public ArrayList<Animator.AnimatorListener> p;
    public ArrayList<Animator.AnimatorListener> q;
    public ArrayList<e> r;
    public final FloatingActionButton s;
    public final f.b.a.d.u.b t;
    public final Rect u = new Rect();
    public final RectF v = new RectF();
    public final RectF w = new RectF();
    public final Matrix x = new Matrix();
    public ViewTreeObserver.OnPreDrawListener y;

    public class a extends f.b.a.d.a.f {
        public a() {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [float, java.lang.Object, java.lang.Object] */
        @Override // android.animation.TypeEvaluator
        public Matrix evaluate(float f2, Matrix matrix, Matrix matrix2) {
            d.this.n = f2;
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

    public class b extends h {
        public b(d dVar) {
            super(null);
        }

        @Override // f.b.a.d.p.d.h
        public float a() {
            return 0.0f;
        }
    }

    public class c extends h {
        public c() {
            super(null);
        }

        @Override // f.b.a.d.p.d.h
        public float a() {
            d dVar = d.this;
            return dVar.f2664d + dVar.f2665e;
        }
    }

    /* renamed from: f.b.a.d.p.d$d  reason: collision with other inner class name */
    public class C0093d extends h {
        public C0093d() {
            super(null);
        }

        @Override // f.b.a.d.p.d.h
        public float a() {
            d dVar = d.this;
            return dVar.f2664d + dVar.f2666f;
        }
    }

    public interface e {
        void a();

        void b();
    }

    public interface f {
    }

    public class g extends h {
        public g() {
            super(null);
        }

        @Override // f.b.a.d.p.d.h
        public float a() {
            return d.this.f2664d;
        }
    }

    public abstract class h extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {
        public boolean a;
        public float b;

        public h(b bVar) {
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

    public d(FloatingActionButton floatingActionButton, f.b.a.d.u.b bVar) {
        this.s = floatingActionButton;
        this.t = bVar;
        f.b.a.d.q.g gVar = new f.b.a.d.q.g();
        this.f2667g = gVar;
        gVar.a(A, b(new C0093d()));
        gVar.a(B, b(new c()));
        gVar.a(C, b(new c()));
        gVar.a(D, b(new c()));
        gVar.a(E, b(new g()));
        gVar.a(F, b(new b(this)));
        this.m = floatingActionButton.getRotation();
    }

    public final AnimatorSet a(f.b.a.d.a.g gVar, float f2, float f3, float f4) {
        ArrayList arrayList = new ArrayList();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.s, View.ALPHA, f2);
        gVar.d("opacity").a(ofFloat);
        arrayList.add(ofFloat);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.s, View.SCALE_X, f3);
        gVar.d("scale").a(ofFloat2);
        int i2 = Build.VERSION.SDK_INT;
        if (i2 == 26) {
            ofFloat2.setEvaluator(new e(this));
        }
        arrayList.add(ofFloat2);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.s, View.SCALE_Y, f3);
        gVar.d("scale").a(ofFloat3);
        if (i2 == 26) {
            ofFloat3.setEvaluator(new e(this));
        }
        arrayList.add(ofFloat3);
        this.x.reset();
        this.s.getDrawable();
        ObjectAnimator ofObject = ObjectAnimator.ofObject(this.s, new f.b.a.d.a.e(), new a(), new Matrix(this.x));
        gVar.d("iconScale").a(ofObject);
        arrayList.add(ofObject);
        AnimatorSet animatorSet = new AnimatorSet();
        f.b.a.c.b.o.b.w1(animatorSet, arrayList);
        return animatorSet;
    }

    public final ValueAnimator b(h hVar) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setInterpolator(z);
        valueAnimator.setDuration(100L);
        valueAnimator.addListener(hVar);
        valueAnimator.addUpdateListener(hVar);
        valueAnimator.setFloatValues(0.0f, 1.0f);
        return valueAnimator;
    }

    public float c() {
        throw null;
    }

    public void d(Rect rect) {
        int i2 = 0;
        if (this.b) {
            i2 = (0 - this.s.getSizeDimension()) / 2;
        }
        float c2 = this.c ? c() + this.f2666f : 0.0f;
        int max = Math.max(i2, (int) Math.ceil((double) c2));
        int max2 = Math.max(i2, (int) Math.ceil((double) (c2 * 1.5f)));
        rect.set(max, max2, max, max2);
    }

    public boolean e() {
        return this.s.getVisibility() == 0 ? this.o == 1 : this.o != 2;
    }

    public boolean f() {
        return this.s.getVisibility() != 0 ? this.o == 2 : this.o != 1;
    }

    public void g() {
        throw null;
    }

    public void h() {
        throw null;
    }

    public void i(int[] iArr) {
        throw null;
    }

    public void j(float f2, float f3, float f4) {
        throw null;
    }

    public void k() {
        ArrayList<e> arrayList = this.r;
        if (arrayList != null) {
            Iterator<e> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
        }
    }

    public void l() {
        ArrayList<e> arrayList = this.r;
        if (arrayList != null) {
            Iterator<e> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().b();
            }
        }
    }

    public boolean m() {
        throw null;
    }

    public final void n(float f2) {
        this.n = f2;
        Matrix matrix = this.x;
        matrix.reset();
        this.s.getDrawable();
        this.s.setImageMatrix(matrix);
    }

    public void o(ColorStateList colorStateList) {
        throw null;
    }

    public boolean p() {
        throw null;
    }

    public final boolean q() {
        FloatingActionButton floatingActionButton = this.s;
        AtomicInteger atomicInteger = l.a;
        return floatingActionButton.isLaidOut() && !this.s.isInEditMode();
    }

    public final boolean r() {
        return !this.b || this.s.getSizeDimension() >= 0;
    }

    public void s() {
        throw null;
    }

    public final void t() {
        Rect rect = this.u;
        d(rect);
        m.h.o(null, "Didn't initialize content background");
        if (p()) {
            InsetDrawable insetDrawable = new InsetDrawable((Drawable) null, rect.left, rect.top, rect.right, rect.bottom);
            FloatingActionButton.b bVar = (FloatingActionButton.b) this.t;
            Objects.requireNonNull(bVar);
            d.super.setBackgroundDrawable(insetDrawable);
        } else {
            Objects.requireNonNull((FloatingActionButton.b) this.t);
        }
        f.b.a.d.u.b bVar2 = this.t;
        int i2 = rect.left;
        Objects.requireNonNull(FloatingActionButton.this);
        throw null;
    }
}
