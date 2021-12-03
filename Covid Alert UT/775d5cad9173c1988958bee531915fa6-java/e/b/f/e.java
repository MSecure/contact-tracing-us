package e.b.f;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.R$styleable;
import e.i.i.v;
import java.util.concurrent.atomic.AtomicInteger;

public class e {
    public final View a;
    public final k b;
    public int c = -1;

    /* renamed from: d  reason: collision with root package name */
    public a1 f859d;

    /* renamed from: e  reason: collision with root package name */
    public a1 f860e;

    /* renamed from: f  reason: collision with root package name */
    public a1 f861f;

    public e(View view) {
        this.a = view;
        this.b = k.a();
    }

    public void a() {
        Drawable background = this.a.getBackground();
        if (background != null) {
            int i2 = Build.VERSION.SDK_INT;
            boolean z = true;
            if (i2 <= 21 ? i2 == 21 : this.f859d != null) {
                if (this.f861f == null) {
                    this.f861f = new a1();
                }
                a1 a1Var = this.f861f;
                a1Var.a = null;
                a1Var.f836d = false;
                a1Var.b = null;
                a1Var.c = false;
                View view = this.a;
                AtomicInteger atomicInteger = v.a;
                ColorStateList g2 = v.i.g(view);
                if (g2 != null) {
                    a1Var.f836d = true;
                    a1Var.a = g2;
                }
                PorterDuff.Mode h2 = v.i.h(this.a);
                if (h2 != null) {
                    a1Var.c = true;
                    a1Var.b = h2;
                }
                if (a1Var.f836d || a1Var.c) {
                    k.f(background, a1Var, this.a.getDrawableState());
                } else {
                    z = false;
                }
                if (z) {
                    return;
                }
            }
            a1 a1Var2 = this.f860e;
            if (a1Var2 != null) {
                k.f(background, a1Var2, this.a.getDrawableState());
                return;
            }
            a1 a1Var3 = this.f859d;
            if (a1Var3 != null) {
                k.f(background, a1Var3, this.a.getDrawableState());
            }
        }
    }

    public ColorStateList b() {
        a1 a1Var = this.f860e;
        if (a1Var != null) {
            return a1Var.a;
        }
        return null;
    }

    public PorterDuff.Mode c() {
        a1 a1Var = this.f860e;
        if (a1Var != null) {
            return a1Var.b;
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0073 A[Catch:{ all -> 0x007b }] */
    public void d(AttributeSet attributeSet, int i2) {
        boolean z;
        Context context = this.a.getContext();
        int[] iArr = R$styleable.ViewBackgroundHelper;
        boolean z2 = false;
        c1 q = c1.q(context, attributeSet, iArr, i2, 0);
        View view = this.a;
        v.t(view, view.getContext(), iArr, attributeSet, q.b, i2, 0);
        try {
            int i3 = R$styleable.ViewBackgroundHelper_android_background;
            if (q.o(i3)) {
                this.c = q.l(i3, -1);
                ColorStateList d2 = this.b.d(this.a.getContext(), this.c);
                if (d2 != null) {
                    g(d2);
                }
            }
            int i4 = R$styleable.ViewBackgroundHelper_backgroundTint;
            if (q.o(i4)) {
                View view2 = this.a;
                ColorStateList c2 = q.c(i4);
                int i5 = Build.VERSION.SDK_INT;
                v.i.q(view2, c2);
                if (i5 == 21) {
                    Drawable background = view2.getBackground();
                    if (v.i.g(view2) == null) {
                        if (v.i.h(view2) == null) {
                            z = false;
                            if (background != null && z) {
                                if (background.isStateful()) {
                                    background.setState(view2.getDrawableState());
                                }
                                v.d.q(view2, background);
                            }
                        }
                    }
                    z = true;
                    if (background.isStateful()) {
                    }
                    v.d.q(view2, background);
                }
            }
            int i6 = R$styleable.ViewBackgroundHelper_backgroundTintMode;
            if (q.o(i6)) {
                View view3 = this.a;
                PorterDuff.Mode e2 = i0.e(q.j(i6, -1), null);
                int i7 = Build.VERSION.SDK_INT;
                v.i.r(view3, e2);
                if (i7 == 21) {
                    Drawable background2 = view3.getBackground();
                    if (!(v.i.g(view3) == null && v.i.h(view3) == null)) {
                        z2 = true;
                    }
                    if (background2 != null && z2) {
                        if (background2.isStateful()) {
                            background2.setState(view3.getDrawableState());
                        }
                        v.d.q(view3, background2);
                    }
                }
            }
            q.b.recycle();
        } catch (Throwable th) {
            q.b.recycle();
            throw th;
        }
    }

    public void e() {
        this.c = -1;
        g(null);
        a();
    }

    public void f(int i2) {
        this.c = i2;
        k kVar = this.b;
        g(kVar != null ? kVar.d(this.a.getContext(), i2) : null);
        a();
    }

    public void g(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.f859d == null) {
                this.f859d = new a1();
            }
            a1 a1Var = this.f859d;
            a1Var.a = colorStateList;
            a1Var.f836d = true;
        } else {
            this.f859d = null;
        }
        a();
    }

    public void h(ColorStateList colorStateList) {
        if (this.f860e == null) {
            this.f860e = new a1();
        }
        a1 a1Var = this.f860e;
        a1Var.a = colorStateList;
        a1Var.f836d = true;
        a();
    }

    public void i(PorterDuff.Mode mode) {
        if (this.f860e == null) {
            this.f860e = new a1();
        }
        a1 a1Var = this.f860e;
        a1Var.b = mode;
        a1Var.c = true;
        a();
    }
}
