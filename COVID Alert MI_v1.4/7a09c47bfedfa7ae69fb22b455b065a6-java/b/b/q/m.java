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
    public final ImageView f890a;

    /* renamed from: b  reason: collision with root package name */
    public w0 f891b;

    public m(ImageView imageView) {
        this.f890a = imageView;
    }

    public void a() {
        w0 w0Var;
        Drawable drawable = this.f890a.getDrawable();
        if (drawable != null) {
            e0.b(drawable);
        }
        if (drawable != null && (w0Var = this.f891b) != null) {
            j.f(drawable, w0Var, this.f890a.getDrawableState());
        }
    }

    public void b(AttributeSet attributeSet, int i) {
        int l;
        y0 q = y0.q(this.f890a.getContext(), attributeSet, j.AppCompatImageView, i, 0);
        ImageView imageView = this.f890a;
        b.i.l.m.T(imageView, imageView.getContext(), j.AppCompatImageView, attributeSet, q.f986b, i, 0);
        try {
            Drawable drawable = this.f890a.getDrawable();
            if (!(drawable != null || (l = q.l(j.AppCompatImageView_srcCompat, -1)) == -1 || (drawable = a.b(this.f890a.getContext(), l)) == null)) {
                this.f890a.setImageDrawable(drawable);
            }
            if (drawable != null) {
                e0.b(drawable);
            }
            if (q.o(j.AppCompatImageView_tint)) {
                this.f890a.setImageTintList(q.c(j.AppCompatImageView_tint));
            }
            if (q.o(j.AppCompatImageView_tintMode)) {
                this.f890a.setImageTintMode(e0.d(q.j(j.AppCompatImageView_tintMode, -1), null));
            }
            q.f986b.recycle();
        } catch (Throwable th) {
            q.f986b.recycle();
            throw th;
        }
    }

    public void c(int i) {
        if (i != 0) {
            Drawable b2 = a.b(this.f890a.getContext(), i);
            if (b2 != null) {
                e0.b(b2);
            }
            this.f890a.setImageDrawable(b2);
        } else {
            this.f890a.setImageDrawable(null);
        }
        a();
    }

    public void d(ColorStateList colorStateList) {
        if (this.f891b == null) {
            this.f891b = new w0();
        }
        w0 w0Var = this.f891b;
        w0Var.f968a = colorStateList;
        w0Var.f971d = true;
        a();
    }

    public void e(PorterDuff.Mode mode) {
        if (this.f891b == null) {
            this.f891b = new w0();
        }
        w0 w0Var = this.f891b;
        w0Var.f969b = mode;
        w0Var.f970c = true;
        a();
    }
}
