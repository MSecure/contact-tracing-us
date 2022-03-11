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
import e.j.j.v;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class x extends t {

    /* renamed from: d  reason: collision with root package name */
    public final SeekBar f1044d;

    /* renamed from: e  reason: collision with root package name */
    public Drawable f1045e;

    /* renamed from: f  reason: collision with root package name */
    public ColorStateList f1046f = null;

    /* renamed from: g  reason: collision with root package name */
    public PorterDuff.Mode f1047g = null;

    /* renamed from: h  reason: collision with root package name */
    public boolean f1048h = false;

    /* renamed from: i  reason: collision with root package name */
    public boolean f1049i = false;

    public x(SeekBar seekBar) {
        super(seekBar);
        this.f1044d = seekBar;
    }

    @Override // e.b.f.t
    public void a(AttributeSet attributeSet, int i2) {
        super.a(attributeSet, i2);
        Context context = this.f1044d.getContext();
        int[] iArr = R$styleable.AppCompatSeekBar;
        c1 q = c1.q(context, attributeSet, iArr, i2, 0);
        SeekBar seekBar = this.f1044d;
        v.t(seekBar, seekBar.getContext(), iArr, attributeSet, q.b, i2, 0);
        Drawable h2 = q.h(R$styleable.AppCompatSeekBar_android_thumb);
        if (h2 != null) {
            this.f1044d.setThumb(h2);
        }
        Drawable g2 = q.g(R$styleable.AppCompatSeekBar_tickMark);
        Drawable drawable = this.f1045e;
        if (drawable != null) {
            drawable.setCallback(null);
        }
        this.f1045e = g2;
        if (g2 != null) {
            g2.setCallback(this.f1044d);
            SeekBar seekBar2 = this.f1044d;
            AtomicInteger atomicInteger = v.a;
            m.e.z1(g2, v.e.d(seekBar2));
            if (g2.isStateful()) {
                g2.setState(this.f1044d.getDrawableState());
            }
            c();
        }
        this.f1044d.invalidate();
        int i3 = R$styleable.AppCompatSeekBar_tickMarkTintMode;
        if (q.o(i3)) {
            this.f1047g = i0.e(q.j(i3, -1), this.f1047g);
            this.f1049i = true;
        }
        int i4 = R$styleable.AppCompatSeekBar_tickMarkTint;
        if (q.o(i4)) {
            this.f1046f = q.c(i4);
            this.f1048h = true;
        }
        q.b.recycle();
        c();
    }

    public final void c() {
        Drawable drawable = this.f1045e;
        if (drawable == null) {
            return;
        }
        if (this.f1048h || this.f1049i) {
            Drawable X1 = m.e.X1(drawable.mutate());
            this.f1045e = X1;
            if (this.f1048h) {
                X1.setTintList(this.f1046f);
            }
            if (this.f1049i) {
                this.f1045e.setTintMode(this.f1047g);
            }
            if (this.f1045e.isStateful()) {
                this.f1045e.setState(this.f1044d.getDrawableState());
            }
        }
    }

    public void d(Canvas canvas) {
        if (this.f1045e != null) {
            int max = this.f1044d.getMax();
            int i2 = 1;
            if (max > 1) {
                int intrinsicWidth = this.f1045e.getIntrinsicWidth();
                int intrinsicHeight = this.f1045e.getIntrinsicHeight();
                int i3 = intrinsicWidth >= 0 ? intrinsicWidth / 2 : 1;
                if (intrinsicHeight >= 0) {
                    i2 = intrinsicHeight / 2;
                }
                this.f1045e.setBounds(-i3, -i2, i3, i2);
                float width = ((float) ((this.f1044d.getWidth() - this.f1044d.getPaddingLeft()) - this.f1044d.getPaddingRight())) / ((float) max);
                int save = canvas.save();
                canvas.translate((float) this.f1044d.getPaddingLeft(), (float) (this.f1044d.getHeight() / 2));
                for (int i4 = 0; i4 <= max; i4++) {
                    this.f1045e.draw(canvas);
                    canvas.translate(width, 0.0f);
                }
                canvas.restoreToCount(save);
            }
        }
    }
}
