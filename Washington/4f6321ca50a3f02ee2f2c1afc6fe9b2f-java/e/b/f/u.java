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
import e.i.i.l;
import java.util.concurrent.atomic.AtomicInteger;

public class u extends q {

    /* renamed from: d  reason: collision with root package name */
    public final SeekBar f948d;

    /* renamed from: e  reason: collision with root package name */
    public Drawable f949e;

    /* renamed from: f  reason: collision with root package name */
    public ColorStateList f950f = null;

    /* renamed from: g  reason: collision with root package name */
    public PorterDuff.Mode f951g = null;

    /* renamed from: h  reason: collision with root package name */
    public boolean f952h = false;

    /* renamed from: i  reason: collision with root package name */
    public boolean f953i = false;

    public u(SeekBar seekBar) {
        super(seekBar);
        this.f948d = seekBar;
    }

    @Override // e.b.f.q
    public void a(AttributeSet attributeSet, int i2) {
        super.a(attributeSet, i2);
        Context context = this.f948d.getContext();
        int[] iArr = R$styleable.AppCompatSeekBar;
        y0 q = y0.q(context, attributeSet, iArr, i2, 0);
        SeekBar seekBar = this.f948d;
        l.q(seekBar, seekBar.getContext(), iArr, attributeSet, q.b, i2, 0);
        Drawable h2 = q.h(R$styleable.AppCompatSeekBar_android_thumb);
        if (h2 != null) {
            this.f948d.setThumb(h2);
        }
        Drawable g2 = q.g(R$styleable.AppCompatSeekBar_tickMark);
        Drawable drawable = this.f949e;
        if (drawable != null) {
            drawable.setCallback(null);
        }
        this.f949e = g2;
        if (g2 != null) {
            g2.setCallback(this.f948d);
            SeekBar seekBar2 = this.f948d;
            AtomicInteger atomicInteger = l.a;
            m.h.Z0(g2, seekBar2.getLayoutDirection());
            if (g2.isStateful()) {
                g2.setState(this.f948d.getDrawableState());
            }
            c();
        }
        this.f948d.invalidate();
        int i3 = R$styleable.AppCompatSeekBar_tickMarkTintMode;
        if (q.o(i3)) {
            this.f951g = e0.d(q.j(i3, -1), this.f951g);
            this.f953i = true;
        }
        int i4 = R$styleable.AppCompatSeekBar_tickMarkTint;
        if (q.o(i4)) {
            this.f950f = q.c(i4);
            this.f952h = true;
        }
        q.b.recycle();
        c();
    }

    public final void c() {
        Drawable drawable = this.f949e;
        if (drawable == null) {
            return;
        }
        if (this.f952h || this.f953i) {
            Drawable w1 = m.h.w1(drawable.mutate());
            this.f949e = w1;
            if (this.f952h) {
                w1.setTintList(this.f950f);
            }
            if (this.f953i) {
                this.f949e.setTintMode(this.f951g);
            }
            if (this.f949e.isStateful()) {
                this.f949e.setState(this.f948d.getDrawableState());
            }
        }
    }

    public void d(Canvas canvas) {
        if (this.f949e != null) {
            int max = this.f948d.getMax();
            int i2 = 1;
            if (max > 1) {
                int intrinsicWidth = this.f949e.getIntrinsicWidth();
                int intrinsicHeight = this.f949e.getIntrinsicHeight();
                int i3 = intrinsicWidth >= 0 ? intrinsicWidth / 2 : 1;
                if (intrinsicHeight >= 0) {
                    i2 = intrinsicHeight / 2;
                }
                this.f949e.setBounds(-i3, -i2, i3, i2);
                float width = ((float) ((this.f948d.getWidth() - this.f948d.getPaddingLeft()) - this.f948d.getPaddingRight())) / ((float) max);
                int save = canvas.save();
                canvas.translate((float) this.f948d.getPaddingLeft(), (float) (this.f948d.getHeight() / 2));
                for (int i4 = 0; i4 <= max; i4++) {
                    this.f949e.draw(canvas);
                    canvas.translate(width, 0.0f);
                }
                canvas.restoreToCount(save);
            }
        }
    }
}
