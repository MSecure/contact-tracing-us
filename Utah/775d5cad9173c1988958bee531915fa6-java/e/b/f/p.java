package e.b.f;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.appcompat.R$styleable;
import e.b.a.m;
import e.i.i.v;

public class p {
    public final ImageView a;
    public a1 b;
    public a1 c;

    /* renamed from: d  reason: collision with root package name */
    public int f949d = 0;

    public p(ImageView imageView) {
        this.a = imageView;
    }

    public void a() {
        Drawable drawable = this.a.getDrawable();
        if (drawable != null) {
            i0.b(drawable);
        }
        if (drawable != null) {
            int i2 = Build.VERSION.SDK_INT;
            boolean z = true;
            if (i2 <= 21 && i2 == 21) {
                if (this.c == null) {
                    this.c = new a1();
                }
                a1 a1Var = this.c;
                a1Var.a = null;
                a1Var.f836d = false;
                a1Var.b = null;
                a1Var.c = false;
                ColorStateList imageTintList = this.a.getImageTintList();
                if (imageTintList != null) {
                    a1Var.f836d = true;
                    a1Var.a = imageTintList;
                }
                PorterDuff.Mode imageTintMode = this.a.getImageTintMode();
                if (imageTintMode != null) {
                    a1Var.c = true;
                    a1Var.b = imageTintMode;
                }
                if (a1Var.f836d || a1Var.c) {
                    k.f(drawable, a1Var, this.a.getDrawableState());
                } else {
                    z = false;
                }
                if (z) {
                    return;
                }
            }
            a1 a1Var2 = this.b;
            if (a1Var2 != null) {
                k.f(drawable, a1Var2, this.a.getDrawableState());
            }
        }
    }

    public void b(AttributeSet attributeSet, int i2) {
        Drawable drawable;
        Drawable drawable2;
        int l2;
        Context context = this.a.getContext();
        int[] iArr = R$styleable.AppCompatImageView;
        c1 q = c1.q(context, attributeSet, iArr, i2, 0);
        ImageView imageView = this.a;
        v.t(imageView, imageView.getContext(), iArr, attributeSet, q.b, i2, 0);
        try {
            Drawable drawable3 = this.a.getDrawable();
            if (!(drawable3 != null || (l2 = q.l(R$styleable.AppCompatImageView_srcCompat, -1)) == -1 || (drawable3 = m.e.h0(this.a.getContext(), l2)) == null)) {
                this.a.setImageDrawable(drawable3);
            }
            if (drawable3 != null) {
                i0.b(drawable3);
            }
            int i3 = R$styleable.AppCompatImageView_tint;
            if (q.o(i3)) {
                ImageView imageView2 = this.a;
                ColorStateList c2 = q.c(i3);
                int i4 = Build.VERSION.SDK_INT;
                imageView2.setImageTintList(c2);
                if (!(i4 != 21 || (drawable2 = imageView2.getDrawable()) == null || imageView2.getImageTintList() == null)) {
                    if (drawable2.isStateful()) {
                        drawable2.setState(imageView2.getDrawableState());
                    }
                    imageView2.setImageDrawable(drawable2);
                }
            }
            int i5 = R$styleable.AppCompatImageView_tintMode;
            if (q.o(i5)) {
                ImageView imageView3 = this.a;
                PorterDuff.Mode e2 = i0.e(q.j(i5, -1), null);
                int i6 = Build.VERSION.SDK_INT;
                imageView3.setImageTintMode(e2);
                if (!(i6 != 21 || (drawable = imageView3.getDrawable()) == null || imageView3.getImageTintList() == null)) {
                    if (drawable.isStateful()) {
                        drawable.setState(imageView3.getDrawableState());
                    }
                    imageView3.setImageDrawable(drawable);
                }
            }
            q.b.recycle();
        } catch (Throwable th) {
            q.b.recycle();
            throw th;
        }
    }

    public void c(int i2) {
        if (i2 != 0) {
            Drawable h0 = m.e.h0(this.a.getContext(), i2);
            if (h0 != null) {
                i0.b(h0);
            }
            this.a.setImageDrawable(h0);
        } else {
            this.a.setImageDrawable(null);
        }
        a();
    }

    public void d(ColorStateList colorStateList) {
        if (this.b == null) {
            this.b = new a1();
        }
        a1 a1Var = this.b;
        a1Var.a = colorStateList;
        a1Var.f836d = true;
        a();
    }

    public void e(PorterDuff.Mode mode) {
        if (this.b == null) {
            this.b = new a1();
        }
        a1 a1Var = this.b;
        a1Var.b = mode;
        a1Var.c = true;
        a();
    }
}
