package com.google.android.material.timepicker;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
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
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$styleable;
import e.i.i.l;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ClockHandView extends View {
    public static final /* synthetic */ int q = 0;
    public ValueAnimator b;
    public float c;

    /* renamed from: d  reason: collision with root package name */
    public float f623d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f624e;

    /* renamed from: f  reason: collision with root package name */
    public int f625f;

    /* renamed from: g  reason: collision with root package name */
    public final List<c> f626g = new ArrayList();

    /* renamed from: h  reason: collision with root package name */
    public final int f627h;

    /* renamed from: i  reason: collision with root package name */
    public final float f628i;

    /* renamed from: j  reason: collision with root package name */
    public final Paint f629j;

    /* renamed from: k  reason: collision with root package name */
    public final RectF f630k;

    /* renamed from: l  reason: collision with root package name */
    public final int f631l;
    public float m;
    public boolean n;
    public double o;
    public int p;

    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            ClockHandView clockHandView = ClockHandView.this;
            int i2 = ClockHandView.q;
            clockHandView.c(floatValue, true);
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

    public ClockHandView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        Paint paint = new Paint();
        this.f629j = paint;
        this.f630k = new RectF();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ClockHandView, 0, 0);
        this.p = obtainStyledAttributes.getDimensionPixelSize(R$styleable.ClockHandView_materialCircleRadius, 0);
        this.f627h = obtainStyledAttributes.getDimensionPixelSize(R$styleable.ClockHandView_selectorSize, 0);
        Resources resources = getResources();
        this.f631l = resources.getDimensionPixelSize(R$dimen.material_clock_hand_stroke_width);
        this.f628i = (float) resources.getDimensionPixelSize(R$dimen.material_clock_hand_center_dot_radius);
        int K0 = f.b.a.c.b.o.b.K0(this, R$attr.colorPrimary);
        paint.setAntiAlias(true);
        paint.setColor(K0);
        b(0.0f, false);
        this.f625f = ViewConfiguration.get(context).getScaledTouchSlop();
        AtomicInteger atomicInteger = l.a;
        setImportantForAccessibility(2);
        obtainStyledAttributes.recycle();
    }

    public final int a(float f2, float f3) {
        int degrees = ((int) Math.toDegrees(Math.atan2((double) (f3 - ((float) (getHeight() / 2))), (double) (f2 - ((float) (getWidth() / 2)))))) + 90;
        return degrees < 0 ? degrees + 360 : degrees;
    }

    public void b(float f2, boolean z) {
        ValueAnimator valueAnimator = this.b;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        if (!z) {
            c(f2, false);
            return;
        }
        float f3 = this.m;
        if (Math.abs(f3 - f2) > 180.0f) {
            if (f3 > 180.0f && f2 < 180.0f) {
                f2 += 360.0f;
            }
            if (f3 < 180.0f && f2 > 180.0f) {
                f3 += 360.0f;
            }
        }
        Pair pair = new Pair(Float.valueOf(f3), Float.valueOf(f2));
        ValueAnimator ofFloat = ValueAnimator.ofFloat(((Float) pair.first).floatValue(), ((Float) pair.second).floatValue());
        this.b = ofFloat;
        ofFloat.setDuration(200L);
        this.b.addUpdateListener(new a());
        this.b.addListener(new b(this));
        this.b.start();
    }

    public final void c(float f2, boolean z) {
        float f3 = f2 % 360.0f;
        this.m = f3;
        this.o = Math.toRadians((double) (f3 - 90.0f));
        float cos = (((float) this.p) * ((float) Math.cos(this.o))) + ((float) (getWidth() / 2));
        float sin = (((float) this.p) * ((float) Math.sin(this.o))) + ((float) (getHeight() / 2));
        RectF rectF = this.f630k;
        int i2 = this.f627h;
        rectF.set(cos - ((float) i2), sin - ((float) i2), cos + ((float) i2), sin + ((float) i2));
        for (c cVar : this.f626g) {
            cVar.a(f3, z);
        }
        invalidate();
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight() / 2;
        int width = getWidth() / 2;
        float f2 = (float) width;
        float f3 = (float) height;
        this.f629j.setStrokeWidth(0.0f);
        canvas.drawCircle((((float) this.p) * ((float) Math.cos(this.o))) + f2, (((float) this.p) * ((float) Math.sin(this.o))) + f3, (float) this.f627h, this.f629j);
        double sin = Math.sin(this.o);
        double cos = Math.cos(this.o);
        double d2 = (double) ((float) (this.p - this.f627h));
        this.f629j.setStrokeWidth((float) this.f631l);
        canvas.drawLine(f2, f3, (float) (width + ((int) (cos * d2))), (float) (height + ((int) (d2 * sin))), this.f629j);
        canvas.drawCircle(f2, f3, this.f628i, this.f629j);
    }

    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        b(this.m, false);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        boolean z2;
        int actionMasked = motionEvent.getActionMasked();
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        boolean z3 = false;
        if (actionMasked != 0) {
            if (actionMasked == 1 || actionMasked == 2) {
                int i2 = (int) (x - this.c);
                int i3 = (int) (y - this.f623d);
                this.f624e = (i3 * i3) + (i2 * i2) > this.f625f;
                z2 = this.n;
                if (actionMasked == 1) {
                }
            } else {
                z2 = false;
            }
            z = false;
        } else {
            this.c = x;
            this.f623d = y;
            this.f624e = true;
            this.n = false;
            z2 = false;
            z = true;
        }
        boolean z4 = this.n;
        float a2 = (float) a(x, y);
        boolean z5 = this.m != a2;
        if (!z || !z5) {
            if (z5 || z2) {
                b(a2, false);
            }
            this.n = z4 | z3;
            return true;
        }
        z3 = true;
        this.n = z4 | z3;
        return true;
    }
}
