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
    public final SeekBar f949d;

    /* renamed from: e  reason: collision with root package name */
    public Drawable f950e;

    /* renamed from: f  reason: collision with root package name */
    public ColorStateList f951f = null;

    /* renamed from: g  reason: collision with root package name */
    public PorterDuff.Mode f952g = null;

    /* renamed from: h  reason: collision with root package name */
    public boolean f953h = false;

    /* renamed from: i  reason: collision with root package name */
    public boolean f954i = false;

    public u(SeekBar seekBar) {
        super(seekBar);
        this.f949d = seekBar;
    }

    @Override // e.b.f.q
    public void a(AttributeSet attributeSet, int i2) {
        super.a(attributeSet, i2);
        Context context = this.f949d.getContext();
        int[] iArr = R$styleable.AppCompatSeekBar;
        y0 q = y0.q(context, attributeSet, iArr, i2, 0);
        SeekBar seekBar = this.f949d;
        l.q(seekBar, seekBar.getContext(), iArr, attributeSet, q.b, i2, 0);
        Drawable h2 = q.h(R$styleable.AppCompatSeekBar_android_thumb);
        if (h2 != null) {
            this.f949d.setThumb(h2);
        }
        Drawable g2 = q.g(R$styleable.AppCompatSeekBar_tickMark);
        Drawable drawable = this.f950e;
        if (drawable != null) {
            drawable.setCallback(null);
        }
        this.f950e = g2;
        if (g2 != null) {
            g2.setCallback(this.f949d);
            SeekBar seekBar2 = this.f949d;
            AtomicInteger atomicInteger = l.a;
            m.h.Y0(g2, seekBar2.getLayoutDirection());
            if (g2.isStateful()) {
                g2.setState(this.f949d.getDrawableState());
            }
            c();
        }
        this.f949d.invalidate();
        int i3 = R$styleable.AppCompatSeekBar_tickMarkTintMode;
        if (q.o(i3)) {
            this.f952g = e0.d(q.j(i3, -1), this.f952g);
            this.f954i = true;
        }
        int i4 = R$styleable.AppCompatSeekBar_tickMarkTint;
        if (q.o(i4)) {
            this.f951f = q.c(i4);
            this.f953h = true;
        }
        q.b.recycle();
        c();
    }

    public final void c() {
        Drawable drawable = this.f950e;
        if (drawable == null) {
            return;
        }
        if (this.f953h || this.f954i) {
            Drawable v1 = m.h.v1(drawable.mutate());
            this.f950e = v1;
            if (this.f953h) {
                v1.setTintList(this.f951f);
            }
            if (this.f954i) {
                this.f950e.setTintMode(this.f952g);
            }
            if (this.f950e.isStateful()) {
                this.f950e.setState(this.f949d.getDrawableState());
            }
        }
    }

    public void d(Canvas canvas) {
        if (this.f950e != null) {
            int max = this.f949d.getMax();
            int i2 = 1;
            if (max > 1) {
                int intrinsicWidth = this.f950e.getIntrinsicWidth();
                int intrinsicHeight = this.f950e.getIntrinsicHeight();
                int i3 = intrinsicWidth >= 0 ? intrinsicWidth / 2 : 1;
                if (intrinsicHeight >= 0) {
                    i2 = intrinsicHeight / 2;
                }
                this.f950e.setBounds(-i3, -i2, i3, i2);
                float width = ((float) ((this.f949d.getWidth() - this.f949d.getPaddingLeft()) - this.f949d.getPaddingRight())) / ((float) max);
                int save = canvas.save();
                canvas.translate((float) this.f949d.getPaddingLeft(), (float) (this.f949d.getHeight() / 2));
                for (int i4 = 0; i4 <= max; i4++) {
                    this.f950e.draw(canvas);
                    canvas.translate(width, 0.0f);
                }
                canvas.restoreToCount(save);
            }
        }
    }
}
