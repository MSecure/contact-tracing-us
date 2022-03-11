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
import e.j.j.v;
import f.b.a.e.v.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class d {
    public j a;
    public boolean b;

    /* renamed from: d */
    public float f2969d;

    /* renamed from: e */
    public float f2970e;

    /* renamed from: f */
    public float f2971f;

    /* renamed from: g */
    public final f.b.a.e.q.g f2972g;

    /* renamed from: h */
    public Animator f2973h;

    /* renamed from: i */
    public f.b.a.e.a.g f2974i;

    /* renamed from: j */
    public f.b.a.e.a.g f2975j;

    /* renamed from: k */
    public float f2976k;
    public int m;
    public ArrayList<Animator.AnimatorListener> o;
    public ArrayList<Animator.AnimatorListener> p;
    public ArrayList<f> q;
    public final FloatingActionButton r;
    public final f.b.a.e.u.b s;
    public ViewTreeObserver.OnPreDrawListener x;
    public static final TimeInterpolator y = f.b.a.e.a.a.c;
    public static final int[] z = {16842919, 16842910};
    public static final int[] A = {16843623, 16842908, 16842910};
    public static final int[] B = {16842908, 16842910};
    public static final int[] C = {16843623, 16842910};
    public static final int[] D = {16842910};
    public static final int[] E = new int[0];
    public boolean c = true;

    /* renamed from: l */
    public float f2977l = 1.0f;
    public int n = 0;
    public final Rect t = new Rect();
    public final RectF u = new RectF();
    public final RectF v = new RectF();
    public final Matrix w = new Matrix();

    /* loaded from: classes.dex */
    public class a extends f.b.a.e.a.f {
        public a() {
            d.this = r1;
        }

        @Override // android.animation.TypeEvaluator
        public Matrix evaluate(float f2, Matrix matrix, Matrix matrix2) {
            d.this.f2977l = f2;
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

    /* loaded from: classes.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ float a;
        public final /* synthetic */ float b;
        public final /* synthetic */ float c;

        /* renamed from: d */
        public final /* synthetic */ float f2979d;

        /* renamed from: e */
        public final /* synthetic */ float f2980e;

        /* renamed from: f */
        public final /* synthetic */ float f2981f;

        /* renamed from: g */
        public final /* synthetic */ float f2982g;

        /* renamed from: h */
        public final /* synthetic */ Matrix f2983h;

        public b(float f2, float f3, float f4, float f5, float f6, float f7, float f8, Matrix matrix) {
            d.this = r1;
            this.a = f2;
            this.b = f3;
            this.c = f4;
            this.f2979d = f5;
            this.f2980e = f6;
            this.f2981f = f7;
            this.f2982g = f8;
            this.f2983h = matrix;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            d.this.r.setAlpha(f.b.a.e.a.a.b(this.a, this.b, 0.0f, 0.2f, floatValue));
            d.this.r.setScaleX(f.b.a.e.a.a.a(this.c, this.f2979d, floatValue));
            d.this.r.setScaleY(f.b.a.e.a.a.a(this.f2980e, this.f2979d, floatValue));
            d.this.f2977l = f.b.a.e.a.a.a(this.f2981f, this.f2982g, floatValue);
            d.this.a(f.b.a.e.a.a.a(this.f2981f, this.f2982g, floatValue), this.f2983h);
            d.this.r.setImageMatrix(this.f2983h);
        }
    }

    /* loaded from: classes.dex */
    public class c extends i {
        public c(d dVar) {
            super(null);
        }

        @Override // f.b.a.e.p.d.i
        public float a() {
            return 0.0f;
        }
    }

    /* renamed from: f.b.a.e.p.d$d */
    /* loaded from: classes.dex */
    public class C0096d extends i {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0096d() {
            super(null);
            d.this = r2;
        }

        @Override // f.b.a.e.p.d.i
        public float a() {
            d dVar = d.this;
            return dVar.f2969d + dVar.f2970e;
        }
    }

    /* loaded from: classes.dex */
    public class e extends i {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e() {
            super(null);
            d.this = r2;
        }

        @Override // f.b.a.e.p.d.i
        public float a() {
            d dVar = d.this;
            return dVar.f2969d + dVar.f2971f;
        }
    }

    /* loaded from: classes.dex */
    public interface f {
        void a();

        void b();
    }

    /* loaded from: classes.dex */
    public interface g {
    }

    /* loaded from: classes.dex */
    public class h extends i {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h() {
            super(null);
            d.this = r2;
        }

        @Override // f.b.a.e.p.d.i
        public float a() {
            return d.this.f2969d;
        }
    }

    /* loaded from: classes.dex */
    public abstract class i extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {
        public boolean a;
        public float b;

        public i(b bVar) {
            d.this = r1;
        }

        public abstract float a();

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Objects.requireNonNull(d.this);
            this.a = false;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
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
        this.r = floatingActionButton;
        this.s = bVar;
        f.b.a.e.q.g gVar = new f.b.a.e.q.g();
        this.f2972g = gVar;
        gVar.a(z, d(new e()));
        gVar.a(A, d(new C0096d()));
        gVar.a(B, d(new C0096d()));
        gVar.a(C, d(new C0096d()));
        gVar.a(D, d(new h()));
        gVar.a(E, d(new c(this)));
        this.f2976k = floatingActionButton.getRotation();
    }

    public final void a(float f2, Matrix matrix) {
        matrix.reset();
        Drawable drawable = this.r.getDrawable();
        if (drawable != null && this.m != 0) {
            RectF rectF = this.u;
            RectF rectF2 = this.v;
            rectF.set(0.0f, 0.0f, (float) drawable.getIntrinsicWidth(), (float) drawable.getIntrinsicHeight());
            int i2 = this.m;
            rectF2.set(0.0f, 0.0f, (float) i2, (float) i2);
            matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
            int i3 = this.m;
            matrix.postScale(f2, f2, ((float) i3) / 2.0f, ((float) i3) / 2.0f);
        }
    }

    public final AnimatorSet b(f.b.a.e.a.g gVar, float f2, float f3, float f4) {
        ArrayList arrayList = new ArrayList();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.r, View.ALPHA, f2);
        gVar.d("opacity").a(ofFloat);
        arrayList.add(ofFloat);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.r, View.SCALE_X, f3);
        gVar.d("scale").a(ofFloat2);
        int i2 = Build.VERSION.SDK_INT;
        if (i2 == 26) {
            ofFloat2.setEvaluator(new e(this));
        }
        arrayList.add(ofFloat2);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.r, View.SCALE_Y, f3);
        gVar.d("scale").a(ofFloat3);
        if (i2 == 26) {
            ofFloat3.setEvaluator(new e(this));
        }
        arrayList.add(ofFloat3);
        a(f4, this.w);
        ObjectAnimator ofObject = ObjectAnimator.ofObject(this.r, new f.b.a.e.a.e(), new a(), new Matrix(this.w));
        gVar.d("iconScale").a(ofObject);
        arrayList.add(ofObject);
        AnimatorSet animatorSet = new AnimatorSet();
        f.b.a.c.b.o.b.h1(animatorSet, arrayList);
        return animatorSet;
    }

    public final AnimatorSet c(float f2, float f3, float f4) {
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new b(this.r.getAlpha(), f2, this.r.getScaleX(), f3, this.r.getScaleY(), this.f2977l, f4, new Matrix(this.w)));
        arrayList.add(ofFloat);
        f.b.a.c.b.o.b.h1(animatorSet, arrayList);
        Context context = this.r.getContext();
        int i2 = R$attr.motionDurationLong1;
        int integer = this.r.getContext().getResources().getInteger(R$integer.material_motion_duration_long_1);
        TypedValue l1 = f.b.a.c.b.o.b.l1(context, i2);
        if (l1 != null && l1.type == 16) {
            integer = l1.data;
        }
        animatorSet.setDuration((long) integer);
        Context context2 = this.r.getContext();
        int i3 = R$attr.motionEasingStandard;
        TimeInterpolator timeInterpolator = f.b.a.e.a.a.b;
        TypedValue typedValue = new TypedValue();
        if (context2.getTheme().resolveAttribute(i3, typedValue, true)) {
            if (typedValue.type == 3) {
                String valueOf = String.valueOf(typedValue.string);
                if (f.b.a.c.b.o.b.T0(valueOf, "cubic-bezier")) {
                    String[] split = valueOf.substring(13, valueOf.length() - 1).split(",");
                    if (split.length == 4) {
                        timeInterpolator = new PathInterpolator(f.b.a.c.b.o.b.A0(split, 0), f.b.a.c.b.o.b.A0(split, 1), f.b.a.c.b.o.b.A0(split, 2), f.b.a.c.b.o.b.A0(split, 3));
                    } else {
                        StringBuilder h2 = f.a.a.a.a.h("Motion easing theme attribute must have 4 control points if using bezier curve format; instead got: ");
                        h2.append(split.length);
                        throw new IllegalArgumentException(h2.toString());
                    }
                } else if (f.b.a.c.b.o.b.T0(valueOf, "path")) {
                    timeInterpolator = new PathInterpolator(m.e.N(valueOf.substring(5, valueOf.length() - 1)));
                } else {
                    throw new IllegalArgumentException(f.a.a.a.a.x("Invalid motion easing type: ", valueOf));
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
        valueAnimator.setInterpolator(y);
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
            i2 = (0 - this.r.getSizeDimension()) / 2;
        }
        float e2 = this.c ? e() + this.f2971f : 0.0f;
        int max = Math.max(i2, (int) Math.ceil((double) e2));
        int max2 = Math.max(i2, (int) Math.ceil((double) (e2 * 1.5f)));
        rect.set(max, max2, max, max2);
    }

    public boolean g() {
        return this.r.getVisibility() == 0 ? this.n == 1 : this.n != 2;
    }

    public boolean h() {
        return this.r.getVisibility() != 0 ? this.n == 2 : this.n != 1;
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
        ArrayList<f> arrayList = this.q;
        if (arrayList != null) {
            Iterator<f> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
        }
    }

    public void n() {
        ArrayList<f> arrayList = this.q;
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
        this.f2977l = f2;
        Matrix matrix = this.w;
        a(f2, matrix);
        this.r.setImageMatrix(matrix);
    }

    public void q(ColorStateList colorStateList) {
        throw null;
    }

    public boolean r() {
        throw null;
    }

    public final boolean s() {
        FloatingActionButton floatingActionButton = this.r;
        AtomicInteger atomicInteger = v.a;
        return v.g.c(floatingActionButton) && !this.r.isInEditMode();
    }

    public final boolean t() {
        return !this.b || this.r.getSizeDimension() >= 0;
    }

    public void u() {
        throw null;
    }

    public final void v() {
        Rect rect = this.t;
        f(rect);
        m.e.q(null, "Didn't initialize content background");
        if (r()) {
            InsetDrawable insetDrawable = new InsetDrawable((Drawable) null, rect.left, rect.top, rect.right, rect.bottom);
            FloatingActionButton.b bVar = (FloatingActionButton.b) this.s;
            Objects.requireNonNull(bVar);
            d.super.setBackgroundDrawable(insetDrawable);
        } else {
            Objects.requireNonNull((FloatingActionButton.b) this.s);
        }
        f.b.a.e.u.b bVar2 = this.s;
        int i2 = rect.left;
        Objects.requireNonNull(FloatingActionButton.this);
        throw null;
    }
}
