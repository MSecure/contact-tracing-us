package com.google.android.material.timepicker;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import b.i.l.m;
import b.x.t;
import c.b.a.b.l;
import java.util.ArrayList;
import java.util.List;

public class ClockHandView extends View {

    /* renamed from: b  reason: collision with root package name */
    public ValueAnimator f6181b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f6182c;

    /* renamed from: d  reason: collision with root package name */
    public float f6183d;

    /* renamed from: e  reason: collision with root package name */
    public float f6184e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f6185f;

    /* renamed from: g  reason: collision with root package name */
    public int f6186g;
    public final List<d> h = new ArrayList();
    public final int i;
    public final float j;
    public final Paint k = new Paint();
    public final RectF l = new RectF();
    public final int m;
    public float n;
    public boolean o;
    public c p;
    public double q;
    public int r;

    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            ClockHandView.this.d(((Float) valueAnimator.getAnimatedValue()).floatValue(), true);
        }
    }

    public class b extends AnimatorListenerAdapter {
        public b(ClockHandView clockHandView) {
        }

        public void onAnimationCancel(Animator animator) {
            animator.end();
        }
    }

    public interface c {
        void a(float f2, boolean z);
    }

    public interface d {
        void a(float f2, boolean z);
    }

    public ClockHandView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l.ClockHandView, 0, 0);
        this.r = obtainStyledAttributes.getDimensionPixelSize(l.ClockHandView_materialCircleRadius, 0);
        this.i = obtainStyledAttributes.getDimensionPixelSize(l.ClockHandView_selectorSize, 0);
        Resources resources = getResources();
        this.m = resources.getDimensionPixelSize(c.b.a.b.d.material_clock_hand_stroke_width);
        this.j = (float) resources.getDimensionPixelSize(c.b.a.b.d.material_clock_hand_center_dot_radius);
        int A1 = t.A1(this, c.b.a.b.b.colorPrimary);
        this.k.setAntiAlias(true);
        this.k.setColor(A1);
        setHandRotation(0.0f);
        this.f6186g = ViewConfiguration.get(context).getScaledTouchSlop();
        m.b0(this, 2);
        obtainStyledAttributes.recycle();
    }

    public final int b(float f2, float f3) {
        int degrees = ((int) Math.toDegrees(Math.atan2((double) (f3 - ((float) (getHeight() / 2))), (double) (f2 - ((float) (getWidth() / 2)))))) + 90;
        return degrees < 0 ? degrees + 360 : degrees;
    }

    public void c(float f2, boolean z) {
        ValueAnimator valueAnimator = this.f6181b;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        if (!z) {
            d(f2, false);
            return;
        }
        float handRotation = getHandRotation();
        if (Math.abs(handRotation - f2) > 180.0f) {
            if (handRotation > 180.0f && f2 < 180.0f) {
                f2 += 360.0f;
            }
            if (handRotation < 180.0f && f2 > 180.0f) {
                handRotation += 360.0f;
            }
        }
        Pair pair = new Pair(Float.valueOf(handRotation), Float.valueOf(f2));
        ValueAnimator ofFloat = ValueAnimator.ofFloat(((Float) pair.first).floatValue(), ((Float) pair.second).floatValue());
        this.f6181b = ofFloat;
        ofFloat.setDuration(200L);
        this.f6181b.addUpdateListener(new a());
        this.f6181b.addListener(new b(this));
        this.f6181b.start();
    }

    public final void d(float f2, boolean z) {
        float f3 = f2 % 360.0f;
        this.n = f3;
        this.q = Math.toRadians((double) (f3 - 90.0f));
        float cos = (((float) this.r) * ((float) Math.cos(this.q))) + ((float) (getWidth() / 2));
        float sin = (((float) this.r) * ((float) Math.sin(this.q))) + ((float) (getHeight() / 2));
        RectF rectF = this.l;
        int i2 = this.i;
        rectF.set(cos - ((float) i2), sin - ((float) i2), cos + ((float) i2), sin + ((float) i2));
        for (d dVar : this.h) {
            dVar.a(f3, z);
        }
        invalidate();
    }

    public RectF getCurrentSelectorBox() {
        return this.l;
    }

    public float getHandRotation() {
        return this.n;
    }

    public int getSelectorRadius() {
        return this.i;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight() / 2;
        int width = getWidth() / 2;
        float f2 = (float) width;
        float f3 = (float) height;
        this.k.setStrokeWidth(0.0f);
        canvas.drawCircle((((float) this.r) * ((float) Math.cos(this.q))) + f2, (((float) this.r) * ((float) Math.sin(this.q))) + f3, (float) this.i, this.k);
        double sin = Math.sin(this.q);
        double cos = Math.cos(this.q);
        double d2 = (double) ((float) (this.r - this.i));
        this.k.setStrokeWidth((float) this.m);
        canvas.drawLine(f2, f3, (float) (width + ((int) (cos * d2))), (float) (height + ((int) (d2 * sin))), this.k);
        canvas.drawCircle(f2, f3, this.j, this.k);
    }

    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        setHandRotation(getHandRotation());
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        boolean z2;
        boolean z3;
        c cVar;
        int actionMasked = motionEvent.getActionMasked();
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        boolean z4 = false;
        if (actionMasked == 0) {
            this.f6183d = x;
            this.f6184e = y;
            this.f6185f = true;
            this.o = false;
            z3 = false;
            z2 = false;
            z = true;
        } else if (actionMasked == 1 || actionMasked == 2) {
            int i2 = (int) (x - this.f6183d);
            int i3 = (int) (y - this.f6184e);
            this.f6185f = (i3 * i3) + (i2 * i2) > this.f6186g;
            z2 = this.o;
            z3 = actionMasked == 1;
            z = false;
        } else {
            z3 = false;
            z2 = false;
            z = false;
        }
        boolean z5 = this.o;
        float b2 = (float) b(x, y);
        boolean z6 = getHandRotation() != b2;
        if (!z || !z6) {
            if (z6 || z2) {
                if (z3 && this.f6182c) {
                    z4 = true;
                }
                c(b2, z4);
            }
            boolean z7 = z4 | z5;
            this.o = z7;
            if (z7 && z3 && (cVar = this.p) != null) {
                cVar.a((float) b(x, y), this.f6185f);
            }
            return true;
        }
        z4 = true;
        boolean z72 = z4 | z5;
        this.o = z72;
        cVar.a((float) b(x, y), this.f6185f);
        return true;
    }

    public void setAnimateOnTouchUp(boolean z) {
        this.f6182c = z;
    }

    public void setCircleRadius(int i2) {
        this.r = i2;
        invalidate();
    }

    public void setHandRotation(float f2) {
        c(f2, false);
    }

    public void setOnActionUpListener(c cVar) {
        this.p = cVar;
    }
}
