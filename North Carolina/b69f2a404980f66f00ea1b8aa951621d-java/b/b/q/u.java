package b.b.q;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;
import b.b.j;
import b.i.l.m;

public class u extends q {

    /* renamed from: d  reason: collision with root package name */
    public final SeekBar f724d;

    /* renamed from: e  reason: collision with root package name */
    public Drawable f725e;
    public ColorStateList f = null;
    public PorterDuff.Mode g = null;
    public boolean h = false;
    public boolean i = false;

    public u(SeekBar seekBar) {
        super(seekBar);
        this.f724d = seekBar;
    }

    @Override // b.b.q.q
    public void a(AttributeSet attributeSet, int i2) {
        super.a(attributeSet, i2);
        y0 q = y0.q(this.f724d.getContext(), attributeSet, j.AppCompatSeekBar, i2, 0);
        SeekBar seekBar = this.f724d;
        m.S(seekBar, seekBar.getContext(), j.AppCompatSeekBar, attributeSet, q.f759b, i2, 0);
        Drawable h2 = q.h(j.AppCompatSeekBar_android_thumb);
        if (h2 != null) {
            this.f724d.setThumb(h2);
        }
        Drawable g2 = q.g(j.AppCompatSeekBar_tickMark);
        Drawable drawable = this.f725e;
        if (drawable != null) {
            drawable.setCallback(null);
        }
        this.f725e = g2;
        if (g2 != null) {
            g2.setCallback(this.f724d);
            g2.setLayoutDirection(m.o(this.f724d));
            if (g2.isStateful()) {
                g2.setState(this.f724d.getDrawableState());
            }
            c();
        }
        this.f724d.invalidate();
        if (q.o(j.AppCompatSeekBar_tickMarkTintMode)) {
            this.g = e0.d(q.j(j.AppCompatSeekBar_tickMarkTintMode, -1), this.g);
            this.i = true;
        }
        if (q.o(j.AppCompatSeekBar_tickMarkTint)) {
            this.f = q.c(j.AppCompatSeekBar_tickMarkTint);
            this.h = true;
        }
        q.f759b.recycle();
        c();
    }

    public final void c() {
        if (this.f725e == null) {
            return;
        }
        if (this.h || this.i) {
            Drawable mutate = this.f725e.mutate();
            this.f725e = mutate;
            if (this.h) {
                mutate.setTintList(this.f);
            }
            if (this.i) {
                this.f725e.setTintMode(this.g);
            }
            if (this.f725e.isStateful()) {
                this.f725e.setState(this.f724d.getDrawableState());
            }
        }
    }

    public void d(Canvas canvas) {
        if (this.f725e != null) {
            int max = this.f724d.getMax();
            int i2 = 1;
            if (max > 1) {
                int intrinsicWidth = this.f725e.getIntrinsicWidth();
                int intrinsicHeight = this.f725e.getIntrinsicHeight();
                int i3 = intrinsicWidth >= 0 ? intrinsicWidth / 2 : 1;
                if (intrinsicHeight >= 0) {
                    i2 = intrinsicHeight / 2;
                }
                this.f725e.setBounds(-i3, -i2, i3, i2);
                float width = ((float) ((this.f724d.getWidth() - this.f724d.getPaddingLeft()) - this.f724d.getPaddingRight())) / ((float) max);
                int save = canvas.save();
                canvas.translate((float) this.f724d.getPaddingLeft(), (float) (this.f724d.getHeight() / 2));
                for (int i4 = 0; i4 <= max; i4++) {
                    this.f725e.draw(canvas);
                    canvas.translate(width, 0.0f);
                }
                canvas.restoreToCount(save);
            }
        }
    }
}
