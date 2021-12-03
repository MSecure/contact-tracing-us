package e.b.f;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;
import androidx.appcompat.R$styleable;
import e.b.a.m;
import e.i.i.m;
import java.util.concurrent.atomic.AtomicInteger;

public class u extends q {

    /* renamed from: d  reason: collision with root package name */
    public final SeekBar f942d;

    /* renamed from: e  reason: collision with root package name */
    public Drawable f943e;

    /* renamed from: f  reason: collision with root package name */
    public ColorStateList f944f = null;

    /* renamed from: g  reason: collision with root package name */
    public PorterDuff.Mode f945g = null;

    /* renamed from: h  reason: collision with root package name */
    public boolean f946h = false;

    /* renamed from: i  reason: collision with root package name */
    public boolean f947i = false;

    public u(SeekBar seekBar) {
        super(seekBar);
        this.f942d = seekBar;
    }

    @Override // e.b.f.q
    public void a(AttributeSet attributeSet, int i2) {
        super.a(attributeSet, i2);
        Context context = this.f942d.getContext();
        int[] iArr = R$styleable.AppCompatSeekBar;
        y0 q = y0.q(context, attributeSet, iArr, i2, 0);
        SeekBar seekBar = this.f942d;
        m.p(seekBar, seekBar.getContext(), iArr, attributeSet, q.b, i2, 0);
        Drawable h2 = q.h(R$styleable.AppCompatSeekBar_android_thumb);
        if (h2 != null) {
            this.f942d.setThumb(h2);
        }
        Drawable g2 = q.g(R$styleable.AppCompatSeekBar_tickMark);
        Drawable drawable = this.f943e;
        if (drawable != null) {
            drawable.setCallback(null);
        }
        this.f943e = g2;
        if (g2 != null) {
            g2.setCallback(this.f942d);
            SeekBar seekBar2 = this.f942d;
            AtomicInteger atomicInteger = m.a;
            m.h.f1(g2, seekBar2.getLayoutDirection());
            if (g2.isStateful()) {
                g2.setState(this.f942d.getDrawableState());
            }
            c();
        }
        this.f942d.invalidate();
        int i3 = R$styleable.AppCompatSeekBar_tickMarkTintMode;
        if (q.o(i3)) {
            this.f945g = e0.d(q.j(i3, -1), this.f945g);
            this.f947i = true;
        }
        int i4 = R$styleable.AppCompatSeekBar_tickMarkTint;
        if (q.o(i4)) {
            this.f944f = q.c(i4);
            this.f946h = true;
        }
        q.b.recycle();
        c();
    }

    public final void c() {
        Drawable drawable = this.f943e;
        if (drawable == null) {
            return;
        }
        if (this.f946h || this.f947i) {
            Drawable C1 = m.h.C1(drawable.mutate());
            this.f943e = C1;
            if (this.f946h) {
                C1.setTintList(this.f944f);
            }
            if (this.f947i) {
                this.f943e.setTintMode(this.f945g);
            }
            if (this.f943e.isStateful()) {
                this.f943e.setState(this.f942d.getDrawableState());
            }
        }
    }

    public void d(Canvas canvas) {
        if (this.f943e != null) {
            int max = this.f942d.getMax();
            int i2 = 1;
            if (max > 1) {
                int intrinsicWidth = this.f943e.getIntrinsicWidth();
                int intrinsicHeight = this.f943e.getIntrinsicHeight();
                int i3 = intrinsicWidth >= 0 ? intrinsicWidth / 2 : 1;
                if (intrinsicHeight >= 0) {
                    i2 = intrinsicHeight / 2;
                }
                this.f943e.setBounds(-i3, -i2, i3, i2);
                float width = ((float) ((this.f942d.getWidth() - this.f942d.getPaddingLeft()) - this.f942d.getPaddingRight())) / ((float) max);
                int save = canvas.save();
                canvas.translate((float) this.f942d.getPaddingLeft(), (float) (this.f942d.getHeight() / 2));
                for (int i4 = 0; i4 <= max; i4++) {
                    this.f943e.draw(canvas);
                    canvas.translate(width, 0.0f);
                }
                canvas.restoreToCount(save);
            }
        }
    }
}
