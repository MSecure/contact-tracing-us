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
    public final SeekBar f952d;

    /* renamed from: e  reason: collision with root package name */
    public Drawable f953e;

    /* renamed from: f  reason: collision with root package name */
    public ColorStateList f954f = null;

    /* renamed from: g  reason: collision with root package name */
    public PorterDuff.Mode f955g = null;

    /* renamed from: h  reason: collision with root package name */
    public boolean f956h = false;

    /* renamed from: i  reason: collision with root package name */
    public boolean f957i = false;

    public u(SeekBar seekBar) {
        super(seekBar);
        this.f952d = seekBar;
    }

    @Override // e.b.f.q
    public void a(AttributeSet attributeSet, int i2) {
        super.a(attributeSet, i2);
        Context context = this.f952d.getContext();
        int[] iArr = R$styleable.AppCompatSeekBar;
        y0 q = y0.q(context, attributeSet, iArr, i2, 0);
        SeekBar seekBar = this.f952d;
        m.q(seekBar, seekBar.getContext(), iArr, attributeSet, q.b, i2, 0);
        Drawable h2 = q.h(R$styleable.AppCompatSeekBar_android_thumb);
        if (h2 != null) {
            this.f952d.setThumb(h2);
        }
        Drawable g2 = q.g(R$styleable.AppCompatSeekBar_tickMark);
        Drawable drawable = this.f953e;
        if (drawable != null) {
            drawable.setCallback(null);
        }
        this.f953e = g2;
        if (g2 != null) {
            g2.setCallback(this.f952d);
            SeekBar seekBar2 = this.f952d;
            AtomicInteger atomicInteger = m.a;
            m.h.Z0(g2, seekBar2.getLayoutDirection());
            if (g2.isStateful()) {
                g2.setState(this.f952d.getDrawableState());
            }
            c();
        }
        this.f952d.invalidate();
        int i3 = R$styleable.AppCompatSeekBar_tickMarkTintMode;
        if (q.o(i3)) {
            this.f955g = e0.d(q.j(i3, -1), this.f955g);
            this.f957i = true;
        }
        int i4 = R$styleable.AppCompatSeekBar_tickMarkTint;
        if (q.o(i4)) {
            this.f954f = q.c(i4);
            this.f956h = true;
        }
        q.b.recycle();
        c();
    }

    public final void c() {
        Drawable drawable = this.f953e;
        if (drawable == null) {
            return;
        }
        if (this.f956h || this.f957i) {
            Drawable w1 = m.h.w1(drawable.mutate());
            this.f953e = w1;
            if (this.f956h) {
                w1.setTintList(this.f954f);
            }
            if (this.f957i) {
                this.f953e.setTintMode(this.f955g);
            }
            if (this.f953e.isStateful()) {
                this.f953e.setState(this.f952d.getDrawableState());
            }
        }
    }

    public void d(Canvas canvas) {
        if (this.f953e != null) {
            int max = this.f952d.getMax();
            int i2 = 1;
            if (max > 1) {
                int intrinsicWidth = this.f953e.getIntrinsicWidth();
                int intrinsicHeight = this.f953e.getIntrinsicHeight();
                int i3 = intrinsicWidth >= 0 ? intrinsicWidth / 2 : 1;
                if (intrinsicHeight >= 0) {
                    i2 = intrinsicHeight / 2;
                }
                this.f953e.setBounds(-i3, -i2, i3, i2);
                float width = ((float) ((this.f952d.getWidth() - this.f952d.getPaddingLeft()) - this.f952d.getPaddingRight())) / ((float) max);
                int save = canvas.save();
                canvas.translate((float) this.f952d.getPaddingLeft(), (float) (this.f952d.getHeight() / 2));
                for (int i4 = 0; i4 <= max; i4++) {
                    this.f953e.draw(canvas);
                    canvas.translate(width, 0.0f);
                }
                canvas.restoreToCount(save);
            }
        }
    }
}
