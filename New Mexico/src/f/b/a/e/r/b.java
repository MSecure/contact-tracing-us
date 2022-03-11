package f.b.a.e.r;

import android.animation.ObjectAnimator;
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
import e.j.j.v;
import f.b.a.e.q.k;
import f.b.a.e.r.c;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public abstract class b<S extends c> extends ProgressBar {
    public static final int p = R$style.Widget_MaterialComponents_ProgressIndicator;
    public S b;
    public int c;

    /* renamed from: d */
    public boolean f3014d;

    /* renamed from: f */
    public final int f3016f;

    /* renamed from: g */
    public final int f3017g;

    /* renamed from: h */
    public long f3018h = -1;

    /* renamed from: j */
    public boolean f3020j = false;

    /* renamed from: k */
    public int f3021k = 4;

    /* renamed from: l */
    public final Runnable f3022l = new a();
    public final Runnable m = new RunnableC0097b();
    public final e.a0.a.a.b n = new c();
    public final e.a0.a.a.b o = new d();

    /* renamed from: i */
    public a f3019i = new a();

    /* renamed from: e */
    public boolean f3015e = true;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
            b.this = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            b bVar = b.this;
            if (bVar.f3017g > 0) {
                bVar.f3018h = SystemClock.uptimeMillis();
            }
            bVar.setVisibility(0);
        }
    }

    /* renamed from: f.b.a.e.r.b$b */
    /* loaded from: classes.dex */
    public class RunnableC0097b implements Runnable {
        public RunnableC0097b() {
            b.this = r1;
        }

        @Override // java.lang.Runnable
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
            b.this.f3018h = -1;
        }
    }

    /* loaded from: classes.dex */
    public class c extends e.a0.a.a.b {
        public c() {
            b.this = r1;
        }

        @Override // e.a0.a.a.b
        public void a(Drawable drawable) {
            b.this.setIndeterminate(false);
            b bVar = b.this;
            bVar.c(bVar.c, bVar.f3014d);
        }
    }

    /* loaded from: classes.dex */
    public class d extends e.a0.a.a.b {
        public d() {
            b.this = r1;
        }

        @Override // e.a0.a.a.b
        public void a(Drawable drawable) {
            b bVar = b.this;
            if (!bVar.f3020j) {
                bVar.setVisibility(bVar.f3021k);
            }
        }
    }

    public b(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(f.b.a.e.z.a.a.a(context, attributeSet, i2, p), attributeSet, i2);
        Context context2 = getContext();
        this.b = new h(context2, attributeSet);
        int[] iArr = R$styleable.BaseProgressIndicator;
        k.a(context2, attributeSet, i2, i3);
        k.b(context2, attributeSet, iArr, i2, i3, new int[0]);
        TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, iArr, i2, i3);
        this.f3016f = obtainStyledAttributes.getInt(R$styleable.BaseProgressIndicator_showDelay, -1);
        this.f3017g = Math.min(obtainStyledAttributes.getInt(R$styleable.BaseProgressIndicator_minHideDelay, -1), 1000);
        obtainStyledAttributes.recycle();
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
        if (this.f3015e) {
            ((l) getCurrentDrawable()).h(d(), false, z);
        }
    }

    public void b() {
        if (getVisibility() != 0) {
            removeCallbacks(this.f3022l);
            return;
        }
        removeCallbacks(this.m);
        long uptimeMillis = SystemClock.uptimeMillis() - this.f3018h;
        int i2 = this.f3017g;
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
            this.f3014d = z;
            this.f3020j = true;
            if (!getIndeterminateDrawable().isVisible() || this.f3019i.a(getContext().getContentResolver()) == 0.0f) {
                this.n.a(getIndeterminateDrawable());
                return;
            }
            g gVar = (g) getIndeterminateDrawable().n;
            ObjectAnimator objectAnimator = gVar.f3031e;
            if (objectAnimator != null && !objectAnimator.isRunning()) {
                if (gVar.a.isVisible()) {
                    gVar.f3031e.start();
                } else {
                    gVar.a();
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0022, code lost:
        if (getWindowVisibility() == 0) goto L_0x0024;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0024, code lost:
        r0 = true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public boolean d() {
        AtomicInteger atomicInteger = v.a;
        if (!v.g.b(this) || getWindowVisibility() != 0) {
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

    @Override // android.widget.ProgressBar
    public Drawable getCurrentDrawable() {
        return isIndeterminate() ? getIndeterminateDrawable() : getProgressDrawable();
    }

    public int getHideAnimationBehavior() {
        return this.b.f3025f;
    }

    @Override // android.widget.ProgressBar
    public o<S> getIndeterminateDrawable() {
        return (o) super.getIndeterminateDrawable();
    }

    public int[] getIndicatorColor() {
        return this.b.c;
    }

    @Override // android.widget.ProgressBar
    public i<S> getProgressDrawable() {
        return (i) super.getProgressDrawable();
    }

    public int getShowAnimationBehavior() {
        return this.b.f3024e;
    }

    public int getTrackColor() {
        return this.b.f3023d;
    }

    public int getTrackCornerRadius() {
        return this.b.b;
    }

    public int getTrackThickness() {
        return this.b.a;
    }

    @Override // android.view.View
    public void invalidate() {
        super.invalidate();
        if (getCurrentDrawable() != null) {
            getCurrentDrawable().invalidateSelf();
        }
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!(getProgressDrawable() == null || getIndeterminateDrawable() == null)) {
            ((g) getIndeterminateDrawable().n).f3037k = this.n;
        }
        if (getProgressDrawable() != null) {
            getProgressDrawable().g(this.o);
        }
        if (getIndeterminateDrawable() != null) {
            getIndeterminateDrawable().g(this.o);
        }
        if (d()) {
            if (this.f3017g > 0) {
                this.f3018h = SystemClock.uptimeMillis();
            }
            setVisibility(0);
        }
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onDetachedFromWindow() {
        removeCallbacks(this.m);
        removeCallbacks(this.f3022l);
        ((l) getCurrentDrawable()).d();
        if (getIndeterminateDrawable() != null) {
            getIndeterminateDrawable().j(this.o);
            ((g) getIndeterminateDrawable().n).f3037k = null;
        }
        if (getProgressDrawable() != null) {
            getProgressDrawable().j(this.o);
        }
        super.onDetachedFromWindow();
    }

    @Override // android.widget.ProgressBar, android.view.View
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

    @Override // android.widget.ProgressBar, android.view.View
    public synchronized void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        m<S> currentDrawingDelegate = getCurrentDrawingDelegate();
        if (currentDrawingDelegate != null) {
            int d2 = currentDrawingDelegate.d();
            int c2 = currentDrawingDelegate.c();
            setMeasuredDimension(d2 < 0 ? getMeasuredWidth() : d2 + getPaddingLeft() + getPaddingRight(), c2 < 0 ? getMeasuredHeight() : c2 + getPaddingTop() + getPaddingBottom());
        }
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i2) {
        super.onVisibilityChanged(view, i2);
        a(i2 == 0);
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
        a(false);
    }

    public void setAnimatorDurationScaleProvider(a aVar) {
        this.f3019i = aVar;
        if (getProgressDrawable() != null) {
            getProgressDrawable().f3042d = aVar;
        }
        if (getIndeterminateDrawable() != null) {
            getIndeterminateDrawable().f3042d = aVar;
        }
    }

    public void setHideAnimationBehavior(int i2) {
        this.b.f3025f = i2;
        invalidate();
    }

    @Override // android.widget.ProgressBar
    public synchronized void setIndeterminate(boolean z) {
        if (z != isIndeterminate()) {
            l lVar = (l) getCurrentDrawable();
            if (lVar != null) {
                lVar.d();
            }
            super.setIndeterminate(z);
            l lVar2 = (l) getCurrentDrawable();
            if (lVar2 != null) {
                lVar2.h(d(), false, false);
            }
            if ((lVar2 instanceof o) && d()) {
                ((o) lVar2).n.c();
            }
            this.f3020j = false;
        }
    }

    @Override // android.widget.ProgressBar
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
            iArr = new int[]{f.b.a.c.b.o.b.w0(getContext(), R$attr.colorPrimary, -1)};
        }
        if (!Arrays.equals(getIndicatorColor(), iArr)) {
            this.b.c = iArr;
            ((g) getIndeterminateDrawable().n).d();
            invalidate();
        }
    }

    @Override // android.widget.ProgressBar
    public synchronized void setProgress(int i2) {
        if (!isIndeterminate()) {
            c(i2, false);
        }
    }

    @Override // android.widget.ProgressBar
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
        this.b.f3024e = i2;
        invalidate();
    }

    public void setTrackColor(int i2) {
        S s = this.b;
        if (s.f3023d != i2) {
            s.f3023d = i2;
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
            this.f3021k = i2;
            return;
        }
        throw new IllegalArgumentException("The component's visibility must be one of VISIBLE, INVISIBLE, and GONE defined in View.");
    }
}
