package e.b.f;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.R$styleable;
import e.i.i.m;
import java.util.concurrent.atomic.AtomicInteger;

public class e {
    public final View a;
    public final j b;
    public int c = -1;

    /* renamed from: d  reason: collision with root package name */
    public w0 f875d;

    /* renamed from: e  reason: collision with root package name */
    public w0 f876e;

    /* renamed from: f  reason: collision with root package name */
    public w0 f877f;

    public e(View view) {
        this.a = view;
        this.b = j.a();
    }

    public void a() {
        Drawable background = this.a.getBackground();
        if (background != null) {
            int i2 = Build.VERSION.SDK_INT;
            boolean z = true;
            if (i2 <= 21 ? i2 == 21 : this.f875d != null) {
                if (this.f877f == null) {
                    this.f877f = new w0();
                }
                w0 w0Var = this.f877f;
                w0Var.a = null;
                w0Var.f969d = false;
                w0Var.b = null;
                w0Var.c = false;
                View view = this.a;
                AtomicInteger atomicInteger = m.a;
                ColorStateList backgroundTintList = view.getBackgroundTintList();
                if (backgroundTintList != null) {
                    w0Var.f969d = true;
                    w0Var.a = backgroundTintList;
                }
                PorterDuff.Mode backgroundTintMode = this.a.getBackgroundTintMode();
                if (backgroundTintMode != null) {
                    w0Var.c = true;
                    w0Var.b = backgroundTintMode;
                }
                if (w0Var.f969d || w0Var.c) {
                    j.f(background, w0Var, this.a.getDrawableState());
                } else {
                    z = false;
                }
                if (z) {
                    return;
                }
            }
            w0 w0Var2 = this.f876e;
            if (w0Var2 != null) {
                j.f(background, w0Var2, this.a.getDrawableState());
                return;
            }
            w0 w0Var3 = this.f875d;
            if (w0Var3 != null) {
                j.f(background, w0Var3, this.a.getDrawableState());
            }
        }
    }

    public ColorStateList b() {
        w0 w0Var = this.f876e;
        if (w0Var != null) {
            return w0Var.a;
        }
        return null;
    }

    public PorterDuff.Mode c() {
        w0 w0Var = this.f876e;
        if (w0Var != null) {
            return w0Var.b;
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0073 A[Catch:{ all -> 0x007b }] */
    public void d(AttributeSet attributeSet, int i2) {
        boolean z;
        int i3 = Build.VERSION.SDK_INT;
        Context context = this.a.getContext();
        int[] iArr = R$styleable.ViewBackgroundHelper;
        boolean z2 = false;
        y0 q = y0.q(context, attributeSet, iArr, i2, 0);
        View view = this.a;
        m.q(view, view.getContext(), iArr, attributeSet, q.b, i2, 0);
        try {
            int i4 = R$styleable.ViewBackgroundHelper_android_background;
            if (q.o(i4)) {
                this.c = q.l(i4, -1);
                ColorStateList d2 = this.b.d(this.a.getContext(), this.c);
                if (d2 != null) {
                    g(d2);
                }
            }
            int i5 = R$styleable.ViewBackgroundHelper_backgroundTint;
            if (q.o(i5)) {
                View view2 = this.a;
                view2.setBackgroundTintList(q.c(i5));
                if (i3 == 21) {
                    Drawable background = view2.getBackground();
                    if (view2.getBackgroundTintList() == null) {
                        if (view2.getBackgroundTintMode() == null) {
                            z = false;
                            if (background != null && z) {
                                if (background.isStateful()) {
                                    background.setState(view2.getDrawableState());
                                }
                                view2.setBackground(background);
                            }
                        }
                    }
                    z = true;
                    if (background.isStateful()) {
                    }
                    view2.setBackground(background);
                }
            }
            int i6 = R$styleable.ViewBackgroundHelper_backgroundTintMode;
            if (q.o(i6)) {
                View view3 = this.a;
                view3.setBackgroundTintMode(e0.d(q.j(i6, -1), null));
                if (i3 == 21) {
                    Drawable background2 = view3.getBackground();
                    if (!(view3.getBackgroundTintList() == null && view3.getBackgroundTintMode() == null)) {
                        z2 = true;
                    }
                    if (background2 != null && z2) {
                        if (background2.isStateful()) {
                            background2.setState(view3.getDrawableState());
                        }
                        view3.setBackground(background2);
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
        j jVar = this.b;
        g(jVar != null ? jVar.d(this.a.getContext(), i2) : null);
        a();
    }

    public void g(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.f875d == null) {
                this.f875d = new w0();
            }
            w0 w0Var = this.f875d;
            w0Var.a = colorStateList;
            w0Var.f969d = true;
        } else {
            this.f875d = null;
        }
        a();
    }

    public void h(ColorStateList colorStateList) {
        if (this.f876e == null) {
            this.f876e = new w0();
        }
        w0 w0Var = this.f876e;
        w0Var.a = colorStateList;
        w0Var.f969d = true;
        a();
    }

    public void i(PorterDuff.Mode mode) {
        if (this.f876e == null) {
            this.f876e = new w0();
        }
        w0 w0Var = this.f876e;
        w0Var.b = mode;
        w0Var.c = true;
        a();
    }
}
