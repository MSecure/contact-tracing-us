package f.b.a.e.q;

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
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import e.i.i.m;
import f.b.a.e.p.k;
import f.b.a.e.q.c;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class b<S extends c> extends ProgressBar {
    public static final int p = R$style.Widget_MaterialComponents_ProgressIndicator;
    public S b;
    public int c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f2908d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f2909e;

    /* renamed from: f  reason: collision with root package name */
    public final int f2910f;

    /* renamed from: g  reason: collision with root package name */
    public final int f2911g;

    /* renamed from: h  reason: collision with root package name */
    public long f2912h = -1;

    /* renamed from: i  reason: collision with root package name */
    public a f2913i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f2914j = false;

    /* renamed from: k  reason: collision with root package name */
    public int f2915k = 4;

    /* renamed from: l  reason: collision with root package name */
    public final Runnable f2916l = new a();
    public final Runnable m = new RunnableC0096b();
    public final e.x.a.a.b n = new c();
    public final e.x.a.a.b o = new d();

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            b bVar = b.this;
            if (bVar.f2911g > 0) {
                bVar.f2912h = SystemClock.uptimeMillis();
            }
            bVar.setVisibility(0);
        }
    }

    /* renamed from: f.b.a.e.q.b$b  reason: collision with other inner class name */
    public class RunnableC0096b implements Runnable {
        public RunnableC0096b() {
        }

        public void run() {
            b bVar = b.this;
            int i2 = b.p;
            boolean z = false;
            ((l) bVar.getCurrentDrawable()).h(false, false, true);
            if ((bVar.getProgressDrawable() == null || !bVar.getProgressDrawable().isVisible()) && (bVar.getIndeterminateDrawable() == null || !bVar.getIndeterminateDrawable().isVisible())) {
                z = true;
            }
            if (z) {
                bVar.setVisibility(4);
            }
            b.this.f2912h = -1;
        }
    }

    public class c extends e.x.a.a.b {
        public c() {
        }

        @Override // e.x.a.a.b
        public void a(Drawable drawable) {
            b.this.setIndeterminate(false);
            b.this.c(0, false);
            b bVar = b.this;
            bVar.c(bVar.c, bVar.f2908d);
        }
    }

    public class d extends e.x.a.a.b {
        public d() {
        }

        @Override // e.x.a.a.b
        public void a(Drawable drawable) {
            b bVar = b.this;
            if (!bVar.f2914j) {
                bVar.setVisibility(bVar.f2915k);
            }
        }
    }

    public b(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(f.b.a.e.y.a.a.a(context, attributeSet, i2, p), attributeSet, i2);
        Context context2 = getContext();
        this.b = new h(context2, attributeSet);
        int[] iArr = R$styleable.BaseProgressIndicator;
        k.a(context2, attributeSet, i2, i3);
        k.b(context2, attributeSet, iArr, i2, i3, new int[0]);
        TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, iArr, i2, i3);
        this.f2910f = obtainStyledAttributes.getInt(R$styleable.BaseProgressIndicator_showDelay, -1);
        this.f2911g = Math.min(obtainStyledAttributes.getInt(R$styleable.BaseProgressIndicator_minHideDelay, -1), 1000);
        obtainStyledAttributes.recycle();
        this.f2913i = new a();
        this.f2909e = true;
    }

    private m<S> getCurrentDrawingDelegate() {
        if (isIndeterminate()) {
            if (getIndeterminateDrawable() == null) {
                return null;
            }
            return getIndeterminateDrawable().m;
        } else if (getProgressDrawable() == null) {
            return null;
        } else {
            return getProgressDrawable().m;
        }
    }

    public void a(boolean z) {
        if (this.f2909e) {
            ((l) getCurrentDrawable()).h(d(), false, z);
        }
    }

    public void b() {
        if (getVisibility() != 0) {
            removeCallbacks(this.f2916l);
            return;
        }
        removeCallbacks(this.m);
        long uptimeMillis = SystemClock.uptimeMillis() - this.f2912h;
        int i2 = this.f2911g;
        if (uptimeMillis >= ((long) i2)) {
            this.m.run();
        } else {
            postDelayed(this.m, ((long) i2) - uptimeMillis);
        }
    }

    public void c(int i2, boolean z) {
        if (!isIndeterminate()) {
            super.setProgress(i2);
            if (getProgressDrawable() != null && !z) {
                getProgressDrawable().jumpToCurrentState();
            }
        } else if (getProgressDrawable() != null) {
            this.c = i2;
            this.f2908d = z;
            this.f2914j = true;
            if (!getIndeterminateDrawable().isVisible() || this.f2913i.a(getContext().getContentResolver()) == 0.0f) {
                this.n.a(getIndeterminateDrawable());
                return;
            }
            g gVar = (g) getIndeterminateDrawable().n;
            if (!gVar.f2925e.isRunning()) {
                if (gVar.a.isVisible()) {
                    gVar.f2925e.start();
                } else {
                    gVar.a();
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0022, code lost:
        if (getWindowVisibility() == 0) goto L_0x0024;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0024, code lost:
        r0 = true;
     */
    public boolean d() {
        AtomicInteger atomicInteger = m.a;
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

    public Drawable getCurrentDrawable() {
        return isIndeterminate() ? getIndeterminateDrawable() : getProgressDrawable();
    }

    public int getHideAnimationBehavior() {
        return this.b.f2919f;
    }

    public o<S> getIndeterminateDrawable() {
        return (o) super.getIndeterminateDrawable();
    }

    public int[] getIndicatorColor() {
        return this.b.c;
    }

    public i<S> getProgressDrawable() {
        return (i) super.getProgressDrawable();
    }

    public int getShowAnimationBehavior() {
        return this.b.f2918e;
    }

    public int getTrackColor() {
        return this.b.f2917d;
    }

    public int getTrackCornerRadius() {
        return this.b.b;
    }

    public int getTrackThickness() {
        return this.b.a;
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
            ((g) getIndeterminateDrawable().n).f2931k = this.n;
        }
        if (getProgressDrawable() != null) {
            getProgressDrawable().g(this.o);
        }
        if (getIndeterminateDrawable() != null) {
            getIndeterminateDrawable().g(this.o);
        }
        if (d()) {
            if (this.f2911g > 0) {
                this.f2912h = SystemClock.uptimeMillis();
            }
            setVisibility(0);
        }
    }

    public void onDetachedFromWindow() {
        removeCallbacks(this.m);
        removeCallbacks(this.f2916l);
        ((l) getCurrentDrawable()).d();
        if (getIndeterminateDrawable() != null) {
            getIndeterminateDrawable().j(this.o);
            ((g) getIndeterminateDrawable().n).f2931k = null;
        }
        if (getProgressDrawable() != null) {
            getProgressDrawable().j(this.o);
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
        m<S> currentDrawingDelegate = getCurrentDrawingDelegate();
        if (currentDrawingDelegate != null) {
            int d2 = currentDrawingDelegate.d();
            int c2 = currentDrawingDelegate.c();
            setMeasuredDimension(d2 < 0 ? getMeasuredWidth() : d2 + getPaddingLeft() + getPaddingRight(), c2 < 0 ? getMeasuredHeight() : c2 + getPaddingTop() + getPaddingBottom());
        }
    }

    public void onVisibilityChanged(View view, int i2) {
        super.onVisibilityChanged(view, i2);
        a(i2 == 0);
    }

    public void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
        a(false);
    }

    public void setAnimatorDurationScaleProvider(a aVar) {
        this.f2913i = aVar;
        if (getProgressDrawable() != null) {
            getProgressDrawable().f2936d = aVar;
        }
        if (getIndeterminateDrawable() != null) {
            getIndeterminateDrawable().f2936d = aVar;
        }
    }

    public void setHideAnimationBehavior(int i2) {
        this.b.f2919f = i2;
        invalidate();
    }

    public synchronized void setIndeterminate(boolean z) {
        if (z != isIndeterminate()) {
            if (!d() || !z) {
                l lVar = (l) getCurrentDrawable();
                if (lVar != null) {
                    lVar.d();
                }
                super.setIndeterminate(z);
                l lVar2 = (l) getCurrentDrawable();
                if (lVar2 != null) {
                    lVar2.h(d(), false, false);
                }
                this.f2914j = false;
                return;
            }
            throw new IllegalStateException("Cannot switch to indeterminate mode while the progress indicator is visible.");
        }
    }

    public void setIndeterminateDrawable(Drawable drawable) {
        if (drawable == null) {
            super.setIndeterminateDrawable(null);
        } else if (drawable instanceof o) {
            ((l) drawable).d();
            super.setIndeterminateDrawable(drawable);
        } else {
            throw new IllegalArgumentException("Cannot set framework drawable as indeterminate drawable.");
        }
    }

    public void setIndicatorColor(int... iArr) {
        if (iArr.length == 0) {
            iArr = new int[]{f.b.a.c.b.o.b.u0(getContext(), R$attr.colorPrimary, -1)};
        }
        if (!Arrays.equals(getIndicatorColor(), iArr)) {
            this.b.c = iArr;
            ((g) getIndeterminateDrawable().n).c();
            invalidate();
        }
    }

    public synchronized void setProgress(int i2) {
        if (!isIndeterminate()) {
            c(i2, false);
        }
    }

    public void setProgressDrawable(Drawable drawable) {
        if (drawable == null) {
            super.setProgressDrawable(null);
        } else if (drawable instanceof i) {
            i iVar = (i) drawable;
            iVar.d();
            super.setProgressDrawable(iVar);
            iVar.setLevel((int) ((((float) getProgress()) / ((float) getMax())) * 10000.0f));
        } else {
            throw new IllegalArgumentException("Cannot set framework drawable as progress drawable.");
        }
    }

    public void setShowAnimationBehavior(int i2) {
        this.b.f2918e = i2;
        invalidate();
    }

    public void setTrackColor(int i2) {
        S s = this.b;
        if (s.f2917d != i2) {
            s.f2917d = i2;
            invalidate();
        }
    }

    public void setTrackCornerRadius(int i2) {
        S s = this.b;
        if (s.b != i2) {
            s.b = Math.min(i2, s.a / 2);
        }
    }

    public void setTrackThickness(int i2) {
        S s = this.b;
        if (s.a != i2) {
            s.a = i2;
            requestLayout();
        }
    }

    public void setVisibilityAfterHide(int i2) {
        if (i2 == 0 || i2 == 4 || i2 == 8) {
            this.f2915k = i2;
            return;
        }
        throw new IllegalArgumentException("The component's visibility must be one of VISIBLE, INVISIBLE, and GONE defined in View.");
    }
}
