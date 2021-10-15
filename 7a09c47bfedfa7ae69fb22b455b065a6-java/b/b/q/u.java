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
    public final SeekBar f945d;

    /* renamed from: e  reason: collision with root package name */
    public Drawable f946e;

    /* renamed from: f  reason: collision with root package name */
    public ColorStateList f947f = null;

    /* renamed from: g  reason: collision with root package name */
    public PorterDuff.Mode f948g = null;
    public boolean h = false;
    public boolean i = false;

    public u(SeekBar seekBar) {
        super(seekBar);
        this.f945d = seekBar;
    }

    @Override // b.b.q.q
    public void a(AttributeSet attributeSet, int i2) {
        super.a(attributeSet, i2);
        y0 q = y0.q(this.f945d.getContext(), attributeSet, j.AppCompatSeekBar, i2, 0);
        SeekBar seekBar = this.f945d;
        m.T(seekBar, seekBar.getContext(), j.AppCompatSeekBar, attributeSet, q.f986b, i2, 0);
        Drawable h2 = q.h(j.AppCompatSeekBar_android_thumb);
        if (h2 != null) {
            this.f945d.setThumb(h2);
        }
        Drawable g2 = q.g(j.AppCompatSeekBar_tickMark);
        Drawable drawable = this.f946e;
        if (drawable != null) {
            drawable.setCallback(null);
        }
        this.f946e = g2;
        if (g2 != null) {
            g2.setCallback(this.f945d);
            g2.setLayoutDirection(m.p(this.f945d));
            if (g2.isStateful()) {
                g2.setState(this.f945d.getDrawableState());
            }
            c();
        }
        this.f945d.invalidate();
        if (q.o(j.AppCompatSeekBar_tickMarkTintMode)) {
            this.f948g = e0.d(q.j(j.AppCompatSeekBar_tickMarkTintMode, -1), this.f948g);
            this.i = true;
        }
        if (q.o(j.AppCompatSeekBar_tickMarkTint)) {
            this.f947f = q.c(j.AppCompatSeekBar_tickMarkTint);
            this.h = true;
        }
        q.f986b.recycle();
        c();
    }

    public final void c() {
        if (this.f946e == null) {
            return;
        }
        if (this.h || this.i) {
            Drawable mutate = this.f946e.mutate();
            this.f946e = mutate;
            if (this.h) {
                mutate.setTintList(this.f947f);
            }
            if (this.i) {
                this.f946e.setTintMode(this.f948g);
            }
            if (this.f946e.isStateful()) {
                this.f946e.setState(this.f945d.getDrawableState());
            }
        }
    }

    public void d(Canvas canvas) {
        if (this.f946e != null) {
            int max = this.f945d.getMax();
            int i2 = 1;
            if (max > 1) {
                int intrinsicWidth = this.f946e.getIntrinsicWidth();
                int intrinsicHeight = this.f946e.getIntrinsicHeight();
                int i3 = intrinsicWidth >= 0 ? intrinsicWidth / 2 : 1;
                if (intrinsicHeight >= 0) {
                    i2 = intrinsicHeight / 2;
                }
                this.f946e.setBounds(-i3, -i2, i3, i2);
                float width = ((float) ((this.f945d.getWidth() - this.f945d.getPaddingLeft()) - this.f945d.getPaddingRight())) / ((float) max);
                int save = canvas.save();
                canvas.translate((float) this.f945d.getPaddingLeft(), (float) (this.f945d.getHeight() / 2));
                for (int i4 = 0; i4 <= max; i4++) {
                    this.f946e.draw(canvas);
                    canvas.translate(width, 0.0f);
                }
                canvas.restoreToCount(save);
            }
        }
    }
}
