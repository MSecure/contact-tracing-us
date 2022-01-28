package c.b.a.b.b0;

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
import b.b.k.i;
import b.i.l.m;
import b.x.t;
import c.b.a.b.h0.j;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.Iterator;

public class e {
    public static final TimeInterpolator A = c.b.a.b.m.a.f4412c;
    public static final int[] B = {16842919, 16842910};
    public static final int[] C = {16843623, 16842908, 16842910};
    public static final int[] D = {16842908, 16842910};
    public static final int[] E = {16843623, 16842910};
    public static final int[] F = {16842910};
    public static final int[] G = new int[0];

    /* renamed from: a  reason: collision with root package name */
    public j f4170a;

    /* renamed from: b  reason: collision with root package name */
    public c.b.a.b.h0.g f4171b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f4172c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f4173d = true;

    /* renamed from: e  reason: collision with root package name */
    public float f4174e;

    /* renamed from: f  reason: collision with root package name */
    public float f4175f;

    /* renamed from: g  reason: collision with root package name */
    public float f4176g;
    public final c.b.a.b.c0.g h;
    public c.b.a.b.m.g i;
    public c.b.a.b.m.g j;
    public Animator k;
    public c.b.a.b.m.g l;
    public c.b.a.b.m.g m;
    public float n;
    public float o = 1.0f;
    public int p = 0;
    public ArrayList<Animator.AnimatorListener> q;
    public ArrayList<Animator.AnimatorListener> r;
    public ArrayList<AbstractC0072e> s;
    public final FloatingActionButton t;
    public final c.b.a.b.g0.b u;
    public final Rect v = new Rect();
    public final RectF w = new RectF();
    public final RectF x = new RectF();
    public final Matrix y = new Matrix();
    public ViewTreeObserver.OnPreDrawListener z;

    public class a extends c.b.a.b.m.f {
        public a() {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [float, java.lang.Object, java.lang.Object] */
        @Override // android.animation.TypeEvaluator
        public Matrix evaluate(float f2, Matrix matrix, Matrix matrix2) {
            e.this.o = f2;
            matrix.getValues(this.f4420a);
            matrix2.getValues(this.f4421b);
            for (int i = 0; i < 9; i++) {
                float[] fArr = this.f4421b;
                float f3 = fArr[i];
                float[] fArr2 = this.f4420a;
                fArr[i] = ((f3 - fArr2[i]) * f2) + fArr2[i];
            }
            this.f4422c.setValues(this.f4421b);
            return this.f4422c;
        }
    }

    public class b extends h {
        public b(e eVar) {
            super(null);
        }

        @Override // c.b.a.b.b0.e.h
        public float a() {
            return 0.0f;
        }
    }

    public class c extends h {
        public c() {
            super(null);
        }

        @Override // c.b.a.b.b0.e.h
        public float a() {
            e eVar = e.this;
            return eVar.f4174e + eVar.f4175f;
        }
    }

    public class d extends h {
        public d() {
            super(null);
        }

        @Override // c.b.a.b.b0.e.h
        public float a() {
            e eVar = e.this;
            return eVar.f4174e + eVar.f4176g;
        }
    }

    /* renamed from: c.b.a.b.b0.e$e  reason: collision with other inner class name */
    public interface AbstractC0072e {
        void a();

        void b();
    }

    public interface f {
    }

    public class g extends h {
        public g() {
            super(null);
        }

        @Override // c.b.a.b.b0.e.h
        public float a() {
            return e.this.f4174e;
        }
    }

    public abstract class h extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: a  reason: collision with root package name */
        public boolean f4181a;

        /* renamed from: b  reason: collision with root package name */
        public float f4182b;

        /* renamed from: c  reason: collision with root package name */
        public float f4183c;

        public h(c cVar) {
        }

        public abstract float a();

        public void onAnimationEnd(Animator animator) {
            if (e.this != null) {
                this.f4181a = false;
                return;
            }
            throw null;
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (!this.f4181a) {
                c.b.a.b.h0.g gVar = e.this.f4171b;
                this.f4182b = gVar == null ? 0.0f : gVar.f4261b.o;
                this.f4183c = a();
                this.f4181a = true;
            }
            e eVar = e.this;
            valueAnimator.getAnimatedFraction();
            if (eVar == null) {
                throw null;
            }
        }
    }

    public e(FloatingActionButton floatingActionButton, c.b.a.b.g0.b bVar) {
        this.t = floatingActionButton;
        this.u = bVar;
        c.b.a.b.c0.g gVar = new c.b.a.b.c0.g();
        this.h = gVar;
        gVar.a(B, b(new d()));
        this.h.a(C, b(new c()));
        this.h.a(D, b(new c()));
        this.h.a(E, b(new c()));
        this.h.a(F, b(new g()));
        this.h.a(G, b(new b(this)));
        this.n = this.t.getRotation();
    }

    public final AnimatorSet a(c.b.a.b.m.g gVar, float f2, float f3, float f4) {
        ArrayList arrayList = new ArrayList();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.t, View.ALPHA, f2);
        gVar.d("opacity").a(ofFloat);
        arrayList.add(ofFloat);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.t, View.SCALE_X, f3);
        gVar.d("scale").a(ofFloat2);
        if (Build.VERSION.SDK_INT == 26) {
            ofFloat2.setEvaluator(new f(this));
        }
        arrayList.add(ofFloat2);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.t, View.SCALE_Y, f3);
        gVar.d("scale").a(ofFloat3);
        if (Build.VERSION.SDK_INT == 26) {
            ofFloat3.setEvaluator(new f(this));
        }
        arrayList.add(ofFloat3);
        this.y.reset();
        this.t.getDrawable();
        ObjectAnimator ofObject = ObjectAnimator.ofObject(this.t, new c.b.a.b.m.e(), new a(), new Matrix(this.y));
        gVar.d("iconScale").a(ofObject);
        arrayList.add(ofObject);
        AnimatorSet animatorSet = new AnimatorSet();
        t.n2(animatorSet, arrayList);
        return animatorSet;
    }

    public final ValueAnimator b(h hVar) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setInterpolator(A);
        valueAnimator.setDuration(100L);
        valueAnimator.addListener(hVar);
        valueAnimator.addUpdateListener(hVar);
        valueAnimator.setFloatValues(0.0f, 1.0f);
        return valueAnimator;
    }

    public abstract float c();

    public void d(Rect rect) {
        int i2 = 0;
        if (this.f4172c) {
            i2 = (0 - this.t.getSizeDimension()) / 2;
        }
        float c2 = this.f4173d ? c() + this.f4176g : 0.0f;
        int max = Math.max(i2, (int) Math.ceil((double) c2));
        int max2 = Math.max(i2, (int) Math.ceil((double) (c2 * 1.5f)));
        rect.set(max, max2, max, max2);
    }

    public boolean e() {
        return this.t.getVisibility() == 0 ? this.p == 1 : this.p != 2;
    }

    public boolean f() {
        return this.t.getVisibility() != 0 ? this.p == 2 : this.p != 1;
    }

    public abstract void g();

    public abstract void h();

    public abstract void i(int[] iArr);

    public abstract void j(float f2, float f3, float f4);

    public void k() {
        ArrayList<AbstractC0072e> arrayList = this.s;
        if (arrayList != null) {
            Iterator<AbstractC0072e> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
        }
    }

    public void l() {
        ArrayList<AbstractC0072e> arrayList = this.s;
        if (arrayList != null) {
            Iterator<AbstractC0072e> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().b();
            }
        }
    }

    public abstract boolean m();

    public final void n(float f2) {
        this.o = f2;
        Matrix matrix = this.y;
        matrix.reset();
        this.t.getDrawable();
        this.t.setImageMatrix(matrix);
    }

    public abstract void o(ColorStateList colorStateList);

    public abstract boolean p();

    public final boolean q() {
        return m.C(this.t) && !this.t.isInEditMode();
    }

    public final boolean r() {
        return !this.f4172c || this.t.getSizeDimension() >= 0;
    }

    public abstract void s();

    public final void t() {
        Rect rect = this.v;
        d(rect);
        i.j.h(null, "Didn't initialize content background");
        if (p()) {
            InsetDrawable insetDrawable = new InsetDrawable((Drawable) null, rect.left, rect.top, rect.right, rect.bottom);
            FloatingActionButton.b bVar = (FloatingActionButton.b) this.u;
            if (bVar != null) {
                FloatingActionButton.c(FloatingActionButton.this, insetDrawable);
            } else {
                throw null;
            }
        } else if (((FloatingActionButton.b) this.u) == null) {
            throw null;
        }
        c.b.a.b.g0.b bVar2 = this.u;
        int i2 = rect.left;
        int i3 = rect.top;
        int i4 = rect.right;
        int i5 = rect.bottom;
        FloatingActionButton.b bVar3 = (FloatingActionButton.b) bVar2;
        FloatingActionButton.this.l.set(i2, i3, i4, i5);
        FloatingActionButton floatingActionButton = FloatingActionButton.this;
        int i6 = floatingActionButton.j;
        floatingActionButton.setPadding(i2 + i6, i3 + i6, i4 + i6, i5 + i6);
    }
}
