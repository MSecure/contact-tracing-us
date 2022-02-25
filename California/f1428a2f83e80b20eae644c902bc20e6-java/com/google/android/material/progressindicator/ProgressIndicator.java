package com.google.android.material.progressindicator;

import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.widget.ProgressBar;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import f.b.a.d.r.f;
import f.b.a.d.r.i;
import f.b.a.d.r.j;
import f.b.a.d.r.k;
import f.b.a.d.r.l;
import f.b.a.d.r.o;
import f.b.a.d.r.r;
import f.b.a.d.r.s;
import java.util.concurrent.atomic.AtomicInteger;

public final class ProgressIndicator extends ProgressBar {
    public static final int p = R$style.Widget_MaterialComponents_ProgressIndicator_Linear_Determinate;
    public final s b;
    public int c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f539d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f540e = true;

    /* renamed from: f  reason: collision with root package name */
    public int f541f;

    /* renamed from: g  reason: collision with root package name */
    public int f542g;

    /* renamed from: h  reason: collision with root package name */
    public long f543h = -1;

    /* renamed from: i  reason: collision with root package name */
    public f.b.a.d.r.a f544i = new f.b.a.d.r.a();

    /* renamed from: j  reason: collision with root package name */
    public boolean f545j = false;

    /* renamed from: k  reason: collision with root package name */
    public int f546k = 4;

    /* renamed from: l  reason: collision with root package name */
    public final Runnable f547l = new a();
    public final Runnable m = new b();
    public final e.x.a.a.b n = new c();
    public final e.x.a.a.b o = new d();

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            ProgressIndicator progressIndicator = ProgressIndicator.this;
            if (progressIndicator.f542g > 0) {
                progressIndicator.f543h = SystemClock.uptimeMillis();
            }
            progressIndicator.setVisibility(0);
        }
    }

    public class b implements Runnable {
        public b() {
        }

        public void run() {
            ProgressIndicator progressIndicator = ProgressIndicator.this;
            int i2 = ProgressIndicator.p;
            boolean z = false;
            progressIndicator.getCurrentDrawable().setVisible(false, false);
            if ((progressIndicator.getProgressDrawable() == null || !progressIndicator.getProgressDrawable().isVisible()) && (progressIndicator.getIndeterminateDrawable() == null || !progressIndicator.getIndeterminateDrawable().isVisible())) {
                z = true;
            }
            if (z) {
                progressIndicator.setVisibility(4);
            }
            ProgressIndicator.this.f543h = -1;
        }
    }

    public class c extends e.x.a.a.b {
        public c() {
        }

        @Override // e.x.a.a.b
        public void a(Drawable drawable) {
            ProgressIndicator.this.setIndeterminate(false);
            ProgressIndicator.this.e(0, false);
            ProgressIndicator progressIndicator = ProgressIndicator.this;
            progressIndicator.e(progressIndicator.c, progressIndicator.f539d);
        }
    }

    public class d extends e.x.a.a.b {
        public d() {
        }

        @Override // e.x.a.a.b
        public void a(Drawable drawable) {
            ProgressIndicator progressIndicator = ProgressIndicator.this;
            if (!progressIndicator.f545j && progressIndicator.f()) {
                ProgressIndicator progressIndicator2 = ProgressIndicator.this;
                progressIndicator2.setVisibility(progressIndicator2.f546k);
            }
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    public ProgressIndicator(Context context, AttributeSet attributeSet) {
        super(f.b.a.d.a0.a.a.a(context, attributeSet, r0, r1), attributeSet, r0);
        int i2;
        int i3 = R$attr.progressIndicatorStyle;
        int i4 = p;
        Context context2 = getContext();
        s sVar = new s();
        this.b = sVar;
        int[] iArr = R$styleable.ProgressIndicator;
        TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, iArr, i3, i4);
        sVar.a = obtainStyledAttributes.getInt(R$styleable.ProgressIndicator_indicatorType, 0);
        sVar.b = obtainStyledAttributes.getDimensionPixelSize(R$styleable.ProgressIndicator_indicatorSize, context2.getResources().getDimensionPixelSize(R$dimen.mtrl_progress_indicator_size));
        sVar.f2732h = obtainStyledAttributes.getDimensionPixelSize(R$styleable.ProgressIndicator_circularInset, context2.getResources().getDimensionPixelSize(R$dimen.mtrl_progress_circular_inset));
        sVar.f2733i = obtainStyledAttributes.getDimensionPixelSize(R$styleable.ProgressIndicator_circularRadius, context2.getResources().getDimensionPixelSize(R$dimen.mtrl_progress_circular_radius));
        sVar.f2730f = obtainStyledAttributes.getBoolean(R$styleable.ProgressIndicator_inverse, false);
        sVar.f2731g = obtainStyledAttributes.getInt(R$styleable.ProgressIndicator_growMode, 0);
        int i5 = R$styleable.ProgressIndicator_indicatorColors;
        if (obtainStyledAttributes.hasValue(i5)) {
            sVar.f2728d = context2.getResources().getIntArray(obtainStyledAttributes.getResourceId(i5, -1));
            if (obtainStyledAttributes.hasValue(R$styleable.ProgressIndicator_indicatorColor)) {
                throw new IllegalArgumentException("Attributes indicatorColors and indicatorColor cannot be used at the same time.");
            } else if (sVar.f2728d.length == 0) {
                throw new IllegalArgumentException("indicatorColors cannot be empty when indicatorColor is not used.");
            }
        } else {
            int[] iArr2 = new int[1];
            int i6 = R$styleable.ProgressIndicator_indicatorColor;
            iArr2[0] = obtainStyledAttributes.hasValue(i6) ? obtainStyledAttributes.getColor(i6, -1) : f.b.a.c.b.o.b.J0(context2, R$attr.colorPrimary, -1);
            sVar.f2728d = iArr2;
        }
        int i7 = R$styleable.ProgressIndicator_trackColor;
        if (obtainStyledAttributes.hasValue(i7)) {
            i2 = obtainStyledAttributes.getColor(i7, -1);
        } else {
            sVar.f2729e = sVar.f2728d[0];
            TypedArray obtainStyledAttributes2 = context2.getTheme().obtainStyledAttributes(new int[]{16842803});
            float f2 = obtainStyledAttributes2.getFloat(0, 0.2f);
            obtainStyledAttributes2.recycle();
            i2 = f.b.a.c.b.o.b.M(sVar.f2729e, (int) (f2 * 255.0f));
        }
        sVar.f2729e = i2;
        sVar.f2734j = obtainStyledAttributes.getBoolean(R$styleable.ProgressIndicator_linearSeamless, true) && sVar.a == 0 && sVar.f2728d.length >= 3;
        sVar.c = Math.min(obtainStyledAttributes.getDimensionPixelSize(R$styleable.ProgressIndicator_indicatorCornerRadius, 0), sVar.b / 2);
        obtainStyledAttributes.recycle();
        if (sVar.a == 1 && sVar.f2733i < sVar.b / 2) {
            throw new IllegalArgumentException("The circularRadius cannot be less than half of the indicatorSize.");
        } else if (!sVar.f2734j || sVar.c <= 0) {
            TypedArray obtainStyledAttributes3 = context2.obtainStyledAttributes(attributeSet, iArr, i3, i4);
            this.f541f = obtainStyledAttributes3.getInt(R$styleable.ProgressIndicator_showDelay, -1);
            this.f542g = Math.min(obtainStyledAttributes3.getInt(R$styleable.ProgressIndicator_minHideDelay, -1), 1000);
            obtainStyledAttributes3.recycle();
            c();
        } else {
            throw new IllegalArgumentException("Rounded corners are not supported in linear seamless mode.");
        }
    }

    public final void a() {
        if (this.f540e) {
            getCurrentDrawable().setVisible(f(), false);
        }
    }

    public void b() {
        if (getVisibility() != 0) {
            removeCallbacks(this.f547l);
            return;
        }
        removeCallbacks(this.m);
        long uptimeMillis = SystemClock.uptimeMillis() - this.f543h;
        int i2 = this.f542g;
        if (uptimeMillis >= ((long) i2)) {
            this.m.run();
        } else {
            postDelayed(this.m, ((long) i2) - uptimeMillis);
        }
    }

    public final void c() {
        setIndeterminateDrawable(new l(getContext(), this.b));
        setProgressDrawable(new f(getContext(), this.b));
        a();
    }

    public final boolean d() {
        if (isIndeterminate()) {
            s sVar = this.b;
            return sVar.a == 0 && sVar.f2728d.length >= 3;
        }
    }

    public void e(int i2, boolean z) {
        if (!isIndeterminate()) {
            super.setProgress(i2);
            if (getProgressDrawable() != null && !z) {
                getProgressDrawable().jumpToCurrentState();
            }
        } else if (getProgressDrawable() != null && !this.b.f2734j) {
            this.c = i2;
            this.f539d = z;
            this.f545j = true;
            if (this.f544i.a(getContext().getContentResolver()) == 0.0f) {
                this.n.a(getIndeterminateDrawable());
            } else {
                getIndeterminateDrawable().p.e();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0022, code lost:
        if (getWindowVisibility() == 0) goto L_0x0024;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0024, code lost:
        r0 = true;
     */
    public final boolean f() {
        AtomicInteger atomicInteger = e.i.i.l.a;
        if (!isAttachedToWindow() || getWindowVisibility() != 0) {
            return false;
        }
        View view = this;
        while (true) {
            if (view.getVisibility() != 0) {
                break;
            }
            ViewParent parent = view.getParent();
            if (parent != null) {
                if (!(parent instanceof View)) {
                    break;
                }
                view = (View) parent;
            }
        }
        boolean z = false;
        if (z) {
            return true;
        }
        return false;
    }

    public int getCircularInset() {
        return this.b.f2732h;
    }

    public int getCircularRadius() {
        return this.b.f2733i;
    }

    public i getCurrentDrawable() {
        return isIndeterminate() ? getIndeterminateDrawable() : getProgressDrawable();
    }

    public j getCurrentDrawingDelegate() {
        if (isIndeterminate()) {
            return getIndeterminateDrawable().o;
        }
        return getProgressDrawable().o;
    }

    public int getGrowMode() {
        return this.b.f2731g;
    }

    public l getIndeterminateDrawable() {
        return (l) super.getIndeterminateDrawable();
    }

    public int[] getIndicatorColors() {
        return this.b.f2728d;
    }

    public int getIndicatorCornerRadius() {
        return this.b.c;
    }

    public int getIndicatorSize() {
        return this.b.b;
    }

    public int getIndicatorType() {
        return this.b.a;
    }

    public f getProgressDrawable() {
        return (f) super.getProgressDrawable();
    }

    public s getSpec() {
        return this.b;
    }

    public int getTrackColor() {
        return this.b.f2729e;
    }

    public void invalidate() {
        super.invalidate();
        if (getCurrentDrawable() != null) {
            getCurrentDrawable().invalidateSelf();
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!(getProgressDrawable() == null || getIndeterminateDrawable() == null)) {
            getIndeterminateDrawable().p.c(this.n);
        }
        if (getProgressDrawable() != null) {
            getProgressDrawable().d(this.o);
        }
        if (getIndeterminateDrawable() != null) {
            getIndeterminateDrawable().d(this.o);
        }
        if (f()) {
            if (this.f542g > 0) {
                this.f543h = SystemClock.uptimeMillis();
            }
            setVisibility(0);
        }
    }

    public void onDetachedFromWindow() {
        removeCallbacks(this.m);
        removeCallbacks(this.f547l);
        getCurrentDrawable().b();
        if (getIndeterminateDrawable() != null) {
            getIndeterminateDrawable().g(this.o);
            getIndeterminateDrawable().p.h();
        }
        if (getProgressDrawable() != null) {
            getProgressDrawable().g(this.o);
        }
        super.onDetachedFromWindow();
    }

    public synchronized void onDraw(Canvas canvas) {
        int save = canvas.save();
        if (!(getPaddingLeft() == 0 && getPaddingTop() == 0)) {
            canvas.translate((float) getPaddingLeft(), (float) getPaddingTop());
        }
        if (!(getPaddingRight() == 0 && getPaddingBottom() == 0)) {
            canvas.clipRect(0, 0, getWidth() - (getPaddingLeft() + getPaddingRight()), getHeight() - (getPaddingTop() + getPaddingBottom()));
        }
        getCurrentDrawable().draw(canvas);
        canvas.restoreToCount(save);
    }

    public synchronized void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        j currentDrawingDelegate = getCurrentDrawingDelegate();
        int a2 = currentDrawingDelegate.a(this.b);
        int b2 = currentDrawingDelegate.b(this.b);
        setMeasuredDimension(a2 < 0 ? getMeasuredWidth() : a2 + getPaddingLeft() + getPaddingRight(), b2 < 0 ? getMeasuredHeight() : b2 + getPaddingTop() + getPaddingBottom());
    }

    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        if (this.b.a == 0) {
            int paddingRight = i2 - (getPaddingRight() + getPaddingLeft());
            int paddingBottom = i3 - (getPaddingBottom() + getPaddingTop());
            l indeterminateDrawable = getIndeterminateDrawable();
            if (indeterminateDrawable != null) {
                indeterminateDrawable.setBounds(0, 0, paddingRight, paddingBottom);
            }
            f progressDrawable = getProgressDrawable();
            if (progressDrawable != null) {
                progressDrawable.setBounds(0, 0, paddingRight, paddingBottom);
                return;
            }
            return;
        }
        super.onSizeChanged(i2, i3, i4, i5);
    }

    public void onVisibilityChanged(View view, int i2) {
        super.onVisibilityChanged(view, i2);
        a();
    }

    public void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
        a();
    }

    public void setAnimatorDurationScaleProvider(f.b.a.d.r.a aVar) {
        this.f544i = aVar;
        if (getProgressDrawable() != null) {
            getProgressDrawable().f2704d = aVar;
        }
        if (getIndeterminateDrawable() != null) {
            getIndeterminateDrawable().f2704d = aVar;
        }
    }

    public void setCircularInset(int i2) {
        s sVar = this.b;
        if (sVar.a == 1 && sVar.f2732h != i2) {
            sVar.f2732h = i2;
            invalidate();
        }
    }

    public void setCircularRadius(int i2) {
        s sVar = this.b;
        if (sVar.a == 1 && sVar.f2733i != i2) {
            sVar.f2733i = i2;
            invalidate();
        }
    }

    public void setGrowMode(int i2) {
        s sVar = this.b;
        if (sVar.f2731g != i2) {
            sVar.f2731g = i2;
            invalidate();
        }
    }

    public synchronized void setIndeterminate(boolean z) {
        if (z != isIndeterminate()) {
            if (!z && this.b.f2734j) {
                return;
            }
            if (!f() || !z) {
                i currentDrawable = getCurrentDrawable();
                if (currentDrawable != null) {
                    currentDrawable.b();
                }
                super.setIndeterminate(z);
                i currentDrawable2 = getCurrentDrawable();
                if (currentDrawable2 != null) {
                    currentDrawable2.f(f(), false, false);
                }
                this.f545j = false;
                return;
            }
            throw new IllegalStateException("Cannot switch to indeterminate mode while the progress indicator is visible.");
        }
    }

    public void setIndeterminateDrawable(Drawable drawable) {
        if (drawable == null) {
            super.setIndeterminateDrawable(null);
        } else if (drawable instanceof l) {
            ((l) drawable).b();
            super.setIndeterminateDrawable(drawable);
        } else {
            throw new IllegalArgumentException("Cannot set framework drawable as indeterminate drawable.");
        }
    }

    public void setIndicatorColors(int[] iArr) {
        this.b.f2728d = iArr;
        getProgressDrawable().c();
        getIndeterminateDrawable().c();
        if (!d()) {
            this.b.f2734j = false;
        }
        invalidate();
    }

    public void setIndicatorCornerRadius(int i2) {
        s sVar = this.b;
        if (sVar.c != i2) {
            sVar.c = Math.min(i2, sVar.b / 2);
            if (this.b.f2734j && i2 > 0) {
                throw new IllegalArgumentException("Rounded corners are not supported in linear seamless mode.");
            }
        }
    }

    public void setIndicatorSize(int i2) {
        s sVar = this.b;
        if (sVar.b != i2) {
            sVar.b = i2;
            requestLayout();
        }
    }

    public void setIndicatorType(int i2) {
        if (!f() || this.b.a == i2) {
            this.b.a = i2;
            c();
            requestLayout();
            return;
        }
        throw new IllegalStateException("Cannot change indicatorType while the progress indicator is visible.");
    }

    public void setInverse(boolean z) {
        s sVar = this.b;
        if (sVar.f2730f != z) {
            sVar.f2730f = z;
            invalidate();
        }
    }

    public void setLinearSeamless(boolean z) {
        l lVar;
        k<AnimatorSet> kVar;
        if (this.b.f2734j != z) {
            if (!f() || !isIndeterminate()) {
                if (d()) {
                    s sVar = this.b;
                    sVar.f2734j = z;
                    if (z) {
                        sVar.c = 0;
                    }
                    if (z) {
                        lVar = getIndeterminateDrawable();
                        kVar = new r();
                    } else {
                        lVar = getIndeterminateDrawable();
                        kVar = new o(getContext());
                    }
                    lVar.h(kVar);
                } else {
                    this.b.f2734j = false;
                }
                invalidate();
                return;
            }
            throw new IllegalStateException("Cannot change linearSeamless while the progress indicator is shown in indeterminate mode.");
        }
    }

    public synchronized void setProgress(int i2) {
        if (!isIndeterminate()) {
            e(i2, false);
        }
    }

    public void setProgressDrawable(Drawable drawable) {
        if (drawable == null) {
            super.setProgressDrawable(null);
        } else if (drawable instanceof f) {
            f fVar = (f) drawable;
            fVar.b();
            super.setProgressDrawable(fVar);
            fVar.setLevel((int) ((((float) getProgress()) / ((float) getMax())) * 10000.0f));
        } else {
            throw new IllegalArgumentException("Cannot set framework drawable as progress drawable.");
        }
    }

    public void setTrackColor(int i2) {
        s sVar = this.b;
        if (sVar.f2729e != i2) {
            sVar.f2729e = i2;
            getProgressDrawable().c();
            getIndeterminateDrawable().c();
            invalidate();
        }
    }

    public void setVisibilityAfterHide(int i2) {
        if (i2 == 0 || i2 == 4 || i2 == 8) {
            this.f546k = i2;
            return;
        }
        throw new IllegalArgumentException("The component's visibility must be one of VISIBLE, INVISIBLE, and GONE defined in View.");
    }
}
