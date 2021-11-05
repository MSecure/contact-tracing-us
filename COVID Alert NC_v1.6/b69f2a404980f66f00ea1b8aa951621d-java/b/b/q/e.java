package b.b.q;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import b.b.j;
import b.i.l.m;

public class e {

    /* renamed from: a  reason: collision with root package name */
    public final View f619a;

    /* renamed from: b  reason: collision with root package name */
    public final j f620b;

    /* renamed from: c  reason: collision with root package name */
    public int f621c = -1;

    /* renamed from: d  reason: collision with root package name */
    public w0 f622d;

    /* renamed from: e  reason: collision with root package name */
    public w0 f623e;
    public w0 f;

    public e(View view) {
        this.f619a = view;
        this.f620b = j.a();
    }

    public void a() {
        Drawable background = this.f619a.getBackground();
        if (background != null) {
            boolean z = true;
            if (this.f622d != null) {
                if (this.f == null) {
                    this.f = new w0();
                }
                w0 w0Var = this.f;
                w0Var.f743a = null;
                w0Var.f746d = false;
                w0Var.f744b = null;
                w0Var.f745c = false;
                ColorStateList h = m.h(this.f619a);
                if (h != null) {
                    w0Var.f746d = true;
                    w0Var.f743a = h;
                }
                PorterDuff.Mode backgroundTintMode = this.f619a.getBackgroundTintMode();
                if (backgroundTintMode != null) {
                    w0Var.f745c = true;
                    w0Var.f744b = backgroundTintMode;
                }
                if (w0Var.f746d || w0Var.f745c) {
                    j.f(background, w0Var, this.f619a.getDrawableState());
                } else {
                    z = false;
                }
                if (z) {
                    return;
                }
            }
            w0 w0Var2 = this.f623e;
            if (w0Var2 != null) {
                j.f(background, w0Var2, this.f619a.getDrawableState());
                return;
            }
            w0 w0Var3 = this.f622d;
            if (w0Var3 != null) {
                j.f(background, w0Var3, this.f619a.getDrawableState());
            }
        }
    }

    public ColorStateList b() {
        w0 w0Var = this.f623e;
        if (w0Var != null) {
            return w0Var.f743a;
        }
        return null;
    }

    public PorterDuff.Mode c() {
        w0 w0Var = this.f623e;
        if (w0Var != null) {
            return w0Var.f744b;
        }
        return null;
    }

    public void d(AttributeSet attributeSet, int i) {
        y0 q = y0.q(this.f619a.getContext(), attributeSet, j.ViewBackgroundHelper, i, 0);
        View view = this.f619a;
        m.S(view, view.getContext(), j.ViewBackgroundHelper, attributeSet, q.f759b, i, 0);
        try {
            if (q.o(j.ViewBackgroundHelper_android_background)) {
                this.f621c = q.l(j.ViewBackgroundHelper_android_background, -1);
                ColorStateList d2 = this.f620b.d(this.f619a.getContext(), this.f621c);
                if (d2 != null) {
                    g(d2);
                }
            }
            if (q.o(j.ViewBackgroundHelper_backgroundTint)) {
                this.f619a.setBackgroundTintList(q.c(j.ViewBackgroundHelper_backgroundTint));
            }
            if (q.o(j.ViewBackgroundHelper_backgroundTintMode)) {
                this.f619a.setBackgroundTintMode(e0.d(q.j(j.ViewBackgroundHelper_backgroundTintMode, -1), null));
            }
            q.f759b.recycle();
        } catch (Throwable th) {
            q.f759b.recycle();
            throw th;
        }
    }

    public void e() {
        this.f621c = -1;
        g(null);
        a();
    }

    public void f(int i) {
        this.f621c = i;
        j jVar = this.f620b;
        g(jVar != null ? jVar.d(this.f619a.getContext(), i) : null);
        a();
    }

    public void g(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.f622d == null) {
                this.f622d = new w0();
            }
            w0 w0Var = this.f622d;
            w0Var.f743a = colorStateList;
            w0Var.f746d = true;
        } else {
            this.f622d = null;
        }
        a();
    }

    public void h(ColorStateList colorStateList) {
        if (this.f623e == null) {
            this.f623e = new w0();
        }
        w0 w0Var = this.f623e;
        w0Var.f743a = colorStateList;
        w0Var.f746d = true;
        a();
    }

    public void i(PorterDuff.Mode mode) {
        if (this.f623e == null) {
            this.f623e = new w0();
        }
        w0 w0Var = this.f623e;
        w0Var.f744b = mode;
        w0Var.f745c = true;
        a();
    }
}
