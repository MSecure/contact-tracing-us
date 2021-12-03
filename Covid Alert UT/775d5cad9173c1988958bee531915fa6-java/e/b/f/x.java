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
import e.i.i.v;
import java.util.concurrent.atomic.AtomicInteger;

public class x extends t {

    /* renamed from: d  reason: collision with root package name */
    public final SeekBar f980d;

    /* renamed from: e  reason: collision with root package name */
    public Drawable f981e;

    /* renamed from: f  reason: collision with root package name */
    public ColorStateList f982f = null;

    /* renamed from: g  reason: collision with root package name */
    public PorterDuff.Mode f983g = null;

    /* renamed from: h  reason: collision with root package name */
    public boolean f984h = false;

    /* renamed from: i  reason: collision with root package name */
    public boolean f985i = false;

    public x(SeekBar seekBar) {
        super(seekBar);
        this.f980d = seekBar;
    }

    @Override // e.b.f.t
    public void a(AttributeSet attributeSet, int i2) {
        super.a(attributeSet, i2);
        Context context = this.f980d.getContext();
        int[] iArr = R$styleable.AppCompatSeekBar;
        c1 q = c1.q(context, attributeSet, iArr, i2, 0);
        SeekBar seekBar = this.f980d;
        v.t(seekBar, seekBar.getContext(), iArr, attributeSet, q.b, i2, 0);
        Drawable h2 = q.h(R$styleable.AppCompatSeekBar_android_thumb);
        if (h2 != null) {
            this.f980d.setThumb(h2);
        }
        Drawable g2 = q.g(R$styleable.AppCompatSeekBar_tickMark);
        Drawable drawable = this.f981e;
        if (drawable != null) {
            drawable.setCallback(null);
        }
        this.f981e = g2;
        if (g2 != null) {
            g2.setCallback(this.f980d);
            SeekBar seekBar2 = this.f980d;
            AtomicInteger atomicInteger = v.a;
            m.e.r1(g2, v.e.d(seekBar2));
            if (g2.isStateful()) {
                g2.setState(this.f980d.getDrawableState());
            }
            c();
        }
        this.f980d.invalidate();
        int i3 = R$styleable.AppCompatSeekBar_tickMarkTintMode;
        if (q.o(i3)) {
            this.f983g = i0.e(q.j(i3, -1), this.f983g);
            this.f985i = true;
        }
        int i4 = R$styleable.AppCompatSeekBar_tickMarkTint;
        if (q.o(i4)) {
            this.f982f = q.c(i4);
            this.f984h = true;
        }
        q.b.recycle();
        c();
    }

    public final void c() {
        Drawable drawable = this.f981e;
        if (drawable == null) {
            return;
        }
        if (this.f984h || this.f985i) {
            Drawable P1 = m.e.P1(drawable.mutate());
            this.f981e = P1;
            if (this.f984h) {
                P1.setTintList(this.f982f);
            }
            if (this.f985i) {
                this.f981e.setTintMode(this.f983g);
            }
            if (this.f981e.isStateful()) {
                this.f981e.setState(this.f980d.getDrawableState());
            }
        }
    }

    public void d(Canvas canvas) {
        if (this.f981e != null) {
            int max = this.f980d.getMax();
            int i2 = 1;
            if (max > 1) {
                int intrinsicWidth = this.f981e.getIntrinsicWidth();
                int intrinsicHeight = this.f981e.getIntrinsicHeight();
                int i3 = intrinsicWidth >= 0 ? intrinsicWidth / 2 : 1;
                if (intrinsicHeight >= 0) {
                    i2 = intrinsicHeight / 2;
                }
                this.f981e.setBounds(-i3, -i2, i3, i2);
                float width = ((float) ((this.f980d.getWidth() - this.f980d.getPaddingLeft()) - this.f980d.getPaddingRight())) / ((float) max);
                int save = canvas.save();
                canvas.translate((float) this.f980d.getPaddingLeft(), (float) (this.f980d.getHeight() / 2));
                for (int i4 = 0; i4 <= max; i4++) {
                    this.f981e.draw(canvas);
                    canvas.translate(width, 0.0f);
                }
                canvas.restoreToCount(save);
            }
        }
    }
}
