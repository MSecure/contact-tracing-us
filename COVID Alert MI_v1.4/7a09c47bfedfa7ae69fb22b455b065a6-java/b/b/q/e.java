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
    public final View f819a;

    /* renamed from: b  reason: collision with root package name */
    public final j f820b;

    /* renamed from: c  reason: collision with root package name */
    public int f821c = -1;

    /* renamed from: d  reason: collision with root package name */
    public w0 f822d;

    /* renamed from: e  reason: collision with root package name */
    public w0 f823e;

    /* renamed from: f  reason: collision with root package name */
    public w0 f824f;

    public e(View view) {
        this.f819a = view;
        this.f820b = j.a();
    }

    public void a() {
        Drawable background = this.f819a.getBackground();
        if (background != null) {
            boolean z = true;
            if (this.f822d != null) {
                if (this.f824f == null) {
                    this.f824f = new w0();
                }
                w0 w0Var = this.f824f;
                w0Var.f968a = null;
                w0Var.f971d = false;
                w0Var.f969b = null;
                w0Var.f970c = false;
                ColorStateList i = m.i(this.f819a);
                if (i != null) {
                    w0Var.f971d = true;
                    w0Var.f968a = i;
                }
                PorterDuff.Mode backgroundTintMode = this.f819a.getBackgroundTintMode();
                if (backgroundTintMode != null) {
                    w0Var.f970c = true;
                    w0Var.f969b = backgroundTintMode;
                }
                if (w0Var.f971d || w0Var.f970c) {
                    j.f(background, w0Var, this.f819a.getDrawableState());
                } else {
                    z = false;
                }
                if (z) {
                    return;
                }
            }
            w0 w0Var2 = this.f823e;
            if (w0Var2 != null) {
                j.f(background, w0Var2, this.f819a.getDrawableState());
                return;
            }
            w0 w0Var3 = this.f822d;
            if (w0Var3 != null) {
                j.f(background, w0Var3, this.f819a.getDrawableState());
            }
        }
    }

    public ColorStateList b() {
        w0 w0Var = this.f823e;
        if (w0Var != null) {
            return w0Var.f968a;
        }
        return null;
    }

    public PorterDuff.Mode c() {
        w0 w0Var = this.f823e;
        if (w0Var != null) {
            return w0Var.f969b;
        }
        return null;
    }

    public void d(AttributeSet attributeSet, int i) {
        y0 q = y0.q(this.f819a.getContext(), attributeSet, j.ViewBackgroundHelper, i, 0);
        View view = this.f819a;
        m.T(view, view.getContext(), j.ViewBackgroundHelper, attributeSet, q.f986b, i, 0);
        try {
            if (q.o(j.ViewBackgroundHelper_android_background)) {
                this.f821c = q.l(j.ViewBackgroundHelper_android_background, -1);
                ColorStateList d2 = this.f820b.d(this.f819a.getContext(), this.f821c);
                if (d2 != null) {
                    g(d2);
                }
            }
            if (q.o(j.ViewBackgroundHelper_backgroundTint)) {
                this.f819a.setBackgroundTintList(q.c(j.ViewBackgroundHelper_backgroundTint));
            }
            if (q.o(j.ViewBackgroundHelper_backgroundTintMode)) {
                this.f819a.setBackgroundTintMode(e0.d(q.j(j.ViewBackgroundHelper_backgroundTintMode, -1), null));
            }
            q.f986b.recycle();
        } catch (Throwable th) {
            q.f986b.recycle();
            throw th;
        }
    }

    public void e() {
        this.f821c = -1;
        g(null);
        a();
    }

    public void f(int i) {
        this.f821c = i;
        j jVar = this.f820b;
        g(jVar != null ? jVar.d(this.f819a.getContext(), i) : null);
        a();
    }

    public void g(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.f822d == null) {
                this.f822d = new w0();
            }
            w0 w0Var = this.f822d;
            w0Var.f968a = colorStateList;
            w0Var.f971d = true;
        } else {
            this.f822d = null;
        }
        a();
    }

    public void h(ColorStateList colorStateList) {
        if (this.f823e == null) {
            this.f823e = new w0();
        }
        w0 w0Var = this.f823e;
        w0Var.f968a = colorStateList;
        w0Var.f971d = true;
        a();
    }

    public void i(PorterDuff.Mode mode) {
        if (this.f823e == null) {
            this.f823e = new w0();
        }
        w0 w0Var = this.f823e;
        w0Var.f969b = mode;
        w0Var.f970c = true;
        a();
    }
}
