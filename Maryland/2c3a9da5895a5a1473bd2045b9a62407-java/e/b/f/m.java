package e.b.f;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.appcompat.R$styleable;
import e.b.b.a.a;

public class m {
    public final ImageView a;
    public w0 b;
    public w0 c;

    public m(ImageView imageView) {
        this.a = imageView;
    }

    public void a() {
        Drawable drawable = this.a.getDrawable();
        if (drawable != null) {
            e0.b(drawable);
        }
        if (drawable != null) {
            int i2 = Build.VERSION.SDK_INT;
            boolean z = true;
            if (i2 <= 21 && i2 == 21) {
                if (this.c == null) {
                    this.c = new w0();
                }
                w0 w0Var = this.c;
                w0Var.a = null;
                w0Var.f969d = false;
                w0Var.b = null;
                w0Var.c = false;
                ColorStateList imageTintList = this.a.getImageTintList();
                if (imageTintList != null) {
                    w0Var.f969d = true;
                    w0Var.a = imageTintList;
                }
                PorterDuff.Mode imageTintMode = this.a.getImageTintMode();
                if (imageTintMode != null) {
                    w0Var.c = true;
                    w0Var.b = imageTintMode;
                }
                if (w0Var.f969d || w0Var.c) {
                    j.f(drawable, w0Var, this.a.getDrawableState());
                } else {
                    z = false;
                }
                if (z) {
                    return;
                }
            }
            w0 w0Var2 = this.b;
            if (w0Var2 != null) {
                j.f(drawable, w0Var2, this.a.getDrawableState());
            }
        }
    }

    public void b(AttributeSet attributeSet, int i2) {
        Drawable drawable;
        Drawable drawable2;
        int l2;
        int i3 = Build.VERSION.SDK_INT;
        Context context = this.a.getContext();
        int[] iArr = R$styleable.AppCompatImageView;
        y0 q = y0.q(context, attributeSet, iArr, i2, 0);
        ImageView imageView = this.a;
        e.i.i.m.q(imageView, imageView.getContext(), iArr, attributeSet, q.b, i2, 0);
        try {
            Drawable drawable3 = this.a.getDrawable();
            if (!(drawable3 != null || (l2 = q.l(R$styleable.AppCompatImageView_srcCompat, -1)) == -1 || (drawable3 = a.b(this.a.getContext(), l2)) == null)) {
                this.a.setImageDrawable(drawable3);
            }
            if (drawable3 != null) {
                e0.b(drawable3);
            }
            int i4 = R$styleable.AppCompatImageView_tint;
            if (q.o(i4)) {
                ImageView imageView2 = this.a;
                imageView2.setImageTintList(q.c(i4));
                if (!(i3 != 21 || (drawable2 = imageView2.getDrawable()) == null || imageView2.getImageTintList() == null)) {
                    if (drawable2.isStateful()) {
                        drawable2.setState(imageView2.getDrawableState());
                    }
                    imageView2.setImageDrawable(drawable2);
                }
            }
            int i5 = R$styleable.AppCompatImageView_tintMode;
            if (q.o(i5)) {
                ImageView imageView3 = this.a;
                imageView3.setImageTintMode(e0.d(q.j(i5, -1), null));
                if (!(i3 != 21 || (drawable = imageView3.getDrawable()) == null || imageView3.getImageTintList() == null)) {
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
            Drawable b2 = a.b(this.a.getContext(), i2);
            if (b2 != null) {
                e0.b(b2);
            }
            this.a.setImageDrawable(b2);
        } else {
            this.a.setImageDrawable(null);
        }
        a();
    }

    public void d(ColorStateList colorStateList) {
        if (this.b == null) {
            this.b = new w0();
        }
        w0 w0Var = this.b;
        w0Var.a = colorStateList;
        w0Var.f969d = true;
        a();
    }

    public void e(PorterDuff.Mode mode) {
        if (this.b == null) {
            this.b = new w0();
        }
        w0 w0Var = this.b;
        w0Var.b = mode;
        w0Var.c = true;
        a();
    }
}
