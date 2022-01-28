package b.b.q;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import b.b.j;
import b.b.l.a.a;

public class m {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f679a;

    /* renamed from: b  reason: collision with root package name */
    public w0 f680b;

    public m(ImageView imageView) {
        this.f679a = imageView;
    }

    public void a() {
        w0 w0Var;
        Drawable drawable = this.f679a.getDrawable();
        if (drawable != null) {
            e0.b(drawable);
        }
        if (drawable != null && (w0Var = this.f680b) != null) {
            j.f(drawable, w0Var, this.f679a.getDrawableState());
        }
    }

    public void b(AttributeSet attributeSet, int i) {
        int l;
        y0 q = y0.q(this.f679a.getContext(), attributeSet, j.AppCompatImageView, i, 0);
        ImageView imageView = this.f679a;
        b.i.l.m.S(imageView, imageView.getContext(), j.AppCompatImageView, attributeSet, q.f759b, i, 0);
        try {
            Drawable drawable = this.f679a.getDrawable();
            if (!(drawable != null || (l = q.l(j.AppCompatImageView_srcCompat, -1)) == -1 || (drawable = a.b(this.f679a.getContext(), l)) == null)) {
                this.f679a.setImageDrawable(drawable);
            }
            if (drawable != null) {
                e0.b(drawable);
            }
            if (q.o(j.AppCompatImageView_tint)) {
                this.f679a.setImageTintList(q.c(j.AppCompatImageView_tint));
            }
            if (q.o(j.AppCompatImageView_tintMode)) {
                this.f679a.setImageTintMode(e0.d(q.j(j.AppCompatImageView_tintMode, -1), null));
            }
            q.f759b.recycle();
        } catch (Throwable th) {
            q.f759b.recycle();
            throw th;
        }
    }

    public void c(int i) {
        if (i != 0) {
            Drawable b2 = a.b(this.f679a.getContext(), i);
            if (b2 != null) {
                e0.b(b2);
            }
            this.f679a.setImageDrawable(b2);
        } else {
            this.f679a.setImageDrawable(null);
        }
        a();
    }

    public void d(ColorStateList colorStateList) {
        if (this.f680b == null) {
            this.f680b = new w0();
        }
        w0 w0Var = this.f680b;
        w0Var.f743a = colorStateList;
        w0Var.f746d = true;
        a();
    }

    public void e(PorterDuff.Mode mode) {
        if (this.f680b == null) {
            this.f680b = new w0();
        }
        w0 w0Var = this.f680b;
        w0Var.f744b = mode;
        w0Var.f745c = true;
        a();
    }
}
