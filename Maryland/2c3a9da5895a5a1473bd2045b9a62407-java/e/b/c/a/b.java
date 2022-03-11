package e.b.c.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.SystemClock;
import android.util.SparseArray;
import e.b.a.m;
import e.b.c.a.d;
import java.util.Objects;

public class b extends Drawable implements Drawable.Callback {
    public static final /* synthetic */ int n = 0;
    public c b;
    public Rect c;

    /* renamed from: d  reason: collision with root package name */
    public Drawable f713d;

    /* renamed from: e  reason: collision with root package name */
    public Drawable f714e;

    /* renamed from: f  reason: collision with root package name */
    public int f715f = 255;

    /* renamed from: g  reason: collision with root package name */
    public boolean f716g;

    /* renamed from: h  reason: collision with root package name */
    public int f717h = -1;

    /* renamed from: i  reason: collision with root package name */
    public boolean f718i;

    /* renamed from: j  reason: collision with root package name */
    public Runnable f719j;

    /* renamed from: k  reason: collision with root package name */
    public long f720k;

    /* renamed from: l  reason: collision with root package name */
    public long f721l;
    public C0016b m;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            b.this.a(true);
            b.this.invalidateSelf();
        }
    }

    /* renamed from: e.b.c.a.b$b  reason: collision with other inner class name */
    public static class C0016b implements Drawable.Callback {
        public Drawable.Callback b;

        public void invalidateDrawable(Drawable drawable) {
        }

        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j2) {
            Drawable.Callback callback = this.b;
            if (callback != null) {
                callback.scheduleDrawable(drawable, runnable, j2);
            }
        }

        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            Drawable.Callback callback = this.b;
            if (callback != null) {
                callback.unscheduleDrawable(drawable, runnable);
            }
        }
    }

    public static abstract class c extends Drawable.ConstantState {
        public int A;
        public int B;
        public boolean C;
        public ColorFilter D;
        public boolean E;
        public ColorStateList F;
        public PorterDuff.Mode G;
        public boolean H;
        public boolean I;
        public final b a;
        public Resources b;
        public int c = 160;

        /* renamed from: d  reason: collision with root package name */
        public int f722d;

        /* renamed from: e  reason: collision with root package name */
        public int f723e;

        /* renamed from: f  reason: collision with root package name */
        public SparseArray<Drawable.ConstantState> f724f;

        /* renamed from: g  reason: collision with root package name */
        public Drawable[] f725g;

        /* renamed from: h  reason: collision with root package name */
        public int f726h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f727i;

        /* renamed from: j  reason: collision with root package name */
        public boolean f728j;

        /* renamed from: k  reason: collision with root package name */
        public Rect f729k;

        /* renamed from: l  reason: collision with root package name */
        public boolean f730l;
        public boolean m;
        public int n;
        public int o;
        public int p;
        public int q;
        public boolean r;
        public int s;
        public boolean t;
        public boolean u;
        public boolean v;
        public boolean w;
        public boolean x;
        public boolean y;
        public int z;

        public c(c cVar, b bVar, Resources resources) {
            int i2 = 160;
            this.f727i = false;
            this.f730l = false;
            this.x = true;
            this.A = 0;
            this.B = 0;
            this.a = bVar;
            this.b = resources != null ? resources : cVar != null ? cVar.b : null;
            int i3 = cVar != null ? cVar.c : 0;
            int i4 = b.n;
            i3 = resources != null ? resources.getDisplayMetrics().densityDpi : i3;
            i2 = i3 != 0 ? i3 : i2;
            this.c = i2;
            if (cVar != null) {
                this.f722d = cVar.f722d;
                this.f723e = cVar.f723e;
                this.v = true;
                this.w = true;
                this.f727i = cVar.f727i;
                this.f730l = cVar.f730l;
                this.x = cVar.x;
                this.y = cVar.y;
                this.z = cVar.z;
                this.A = cVar.A;
                this.B = cVar.B;
                this.C = cVar.C;
                this.D = cVar.D;
                this.E = cVar.E;
                this.F = cVar.F;
                this.G = cVar.G;
                this.H = cVar.H;
                this.I = cVar.I;
                if (cVar.c == i2) {
                    if (cVar.f728j) {
                        this.f729k = new Rect(cVar.f729k);
                        this.f728j = true;
                    }
                    if (cVar.m) {
                        this.n = cVar.n;
                        this.o = cVar.o;
                        this.p = cVar.p;
                        this.q = cVar.q;
                        this.m = true;
                    }
                }
                if (cVar.r) {
                    this.s = cVar.s;
                    this.r = true;
                }
                if (cVar.t) {
                    this.u = cVar.u;
                    this.t = true;
                }
                Drawable[] drawableArr = cVar.f725g;
                this.f725g = new Drawable[drawableArr.length];
                this.f726h = cVar.f726h;
                SparseArray<Drawable.ConstantState> sparseArray = cVar.f724f;
                this.f724f = sparseArray != null ? sparseArray.clone() : new SparseArray<>(this.f726h);
                int i5 = this.f726h;
                for (int i6 = 0; i6 < i5; i6++) {
                    if (drawableArr[i6] != null) {
                        Drawable.ConstantState constantState = drawableArr[i6].getConstantState();
                        if (constantState != null) {
                            this.f724f.put(i6, constantState);
                        } else {
                            this.f725g[i6] = drawableArr[i6];
                        }
                    }
                }
                return;
            }
            this.f725g = new Drawable[10];
            this.f726h = 0;
        }

        public final int a(Drawable drawable) {
            int i2 = this.f726h;
            if (i2 >= this.f725g.length) {
                int i3 = i2 + 10;
                d.a aVar = (d.a) this;
                Drawable[] drawableArr = new Drawable[i3];
                System.arraycopy(aVar.f725g, 0, drawableArr, 0, i2);
                aVar.f725g = drawableArr;
                int[][] iArr = new int[i3][];
                System.arraycopy(aVar.J, 0, iArr, 0, i2);
                aVar.J = iArr;
            }
            drawable.mutate();
            drawable.setVisible(false, true);
            drawable.setCallback(this.a);
            this.f725g[i2] = drawable;
            this.f726h++;
            this.f723e = drawable.getChangingConfigurations() | this.f723e;
            this.r = false;
            this.t = false;
            this.f729k = null;
            this.f728j = false;
            this.m = false;
            this.v = false;
            return i2;
        }

        public void b() {
            this.m = true;
            c();
            int i2 = this.f726h;
            Drawable[] drawableArr = this.f725g;
            this.o = -1;
            this.n = -1;
            this.q = 0;
            this.p = 0;
            for (int i3 = 0; i3 < i2; i3++) {
                Drawable drawable = drawableArr[i3];
                int intrinsicWidth = drawable.getIntrinsicWidth();
                if (intrinsicWidth > this.n) {
                    this.n = intrinsicWidth;
                }
                int intrinsicHeight = drawable.getIntrinsicHeight();
                if (intrinsicHeight > this.o) {
                    this.o = intrinsicHeight;
                }
                int minimumWidth = drawable.getMinimumWidth();
                if (minimumWidth > this.p) {
                    this.p = minimumWidth;
                }
                int minimumHeight = drawable.getMinimumHeight();
                if (minimumHeight > this.q) {
                    this.q = minimumHeight;
                }
            }
        }

        public final void c() {
            SparseArray<Drawable.ConstantState> sparseArray = this.f724f;
            if (sparseArray != null) {
                int size = sparseArray.size();
                for (int i2 = 0; i2 < size; i2++) {
                    int keyAt = this.f724f.keyAt(i2);
                    Drawable[] drawableArr = this.f725g;
                    Drawable newDrawable = this.f724f.valueAt(i2).newDrawable(this.b);
                    if (Build.VERSION.SDK_INT >= 23) {
                        newDrawable.setLayoutDirection(this.z);
                    }
                    Drawable mutate = newDrawable.mutate();
                    mutate.setCallback(this.a);
                    drawableArr[keyAt] = mutate;
                }
                this.f724f = null;
            }
        }

        public boolean canApplyTheme() {
            int i2 = this.f726h;
            Drawable[] drawableArr = this.f725g;
            for (int i3 = 0; i3 < i2; i3++) {
                Drawable drawable = drawableArr[i3];
                if (drawable == null) {
                    Drawable.ConstantState constantState = this.f724f.get(i3);
                    if (constantState != null && constantState.canApplyTheme()) {
                        return true;
                    }
                } else if (drawable.canApplyTheme()) {
                    return true;
                }
            }
            return false;
        }

        public final Drawable d(int i2) {
            int indexOfKey;
            Drawable drawable = this.f725g[i2];
            if (drawable != null) {
                return drawable;
            }
            SparseArray<Drawable.ConstantState> sparseArray = this.f724f;
            if (sparseArray == null || (indexOfKey = sparseArray.indexOfKey(i2)) < 0) {
                return null;
            }
            Drawable newDrawable = this.f724f.valueAt(indexOfKey).newDrawable(this.b);
            if (Build.VERSION.SDK_INT >= 23) {
                newDrawable.setLayoutDirection(this.z);
            }
            Drawable mutate = newDrawable.mutate();
            mutate.setCallback(this.a);
            this.f725g[i2] = mutate;
            this.f724f.removeAt(indexOfKey);
            if (this.f724f.size() == 0) {
                this.f724f = null;
            }
            return mutate;
        }

        public abstract void e();

        public final void f(Resources resources) {
            if (resources != null) {
                this.b = resources;
                int i2 = b.n;
                int i3 = resources.getDisplayMetrics().densityDpi;
                if (i3 == 0) {
                    i3 = 160;
                }
                int i4 = this.c;
                this.c = i3;
                if (i4 != i3) {
                    this.m = false;
                    this.f728j = false;
                }
            }
        }

        public int getChangingConfigurations() {
            return this.f722d | this.f723e;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0066 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:24:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    public void a(boolean z) {
        boolean z2;
        Drawable drawable;
        boolean z3 = true;
        this.f716g = true;
        long uptimeMillis = SystemClock.uptimeMillis();
        Drawable drawable2 = this.f713d;
        if (drawable2 != null) {
            long j2 = this.f720k;
            if (j2 != 0) {
                if (j2 <= uptimeMillis) {
                    drawable2.setAlpha(this.f715f);
                } else {
                    drawable2.setAlpha(((255 - (((int) ((j2 - uptimeMillis) * 255)) / this.b.A)) * this.f715f) / 255);
                    z2 = true;
                    drawable = this.f714e;
                    if (drawable != null) {
                        long j3 = this.f721l;
                        if (j3 != 0) {
                            if (j3 <= uptimeMillis) {
                                drawable.setVisible(false, false);
                                this.f714e = null;
                            } else {
                                drawable.setAlpha(((((int) ((j3 - uptimeMillis) * 255)) / this.b.B) * this.f715f) / 255);
                                if (!z && z3) {
                                    scheduleSelf(this.f719j, uptimeMillis + 16);
                                    return;
                                }
                                return;
                            }
                        }
                        z3 = z2;
                        if (!z) {
                            return;
                        }
                        return;
                    }
                    this.f721l = 0;
                    z3 = z2;
                    if (!z) {
                    }
                }
            }
            z2 = false;
            drawable = this.f714e;
            if (drawable != null) {
            }
            this.f721l = 0;
            z3 = z2;
            if (!z) {
            }
        }
        this.f720k = 0;
        z2 = false;
        drawable = this.f714e;
        if (drawable != null) {
        }
        this.f721l = 0;
        z3 = z2;
        if (!z) {
        }
    }

    public void applyTheme(Resources.Theme theme) {
        c cVar = this.b;
        Objects.requireNonNull(cVar);
        if (theme != null) {
            cVar.c();
            int i2 = cVar.f726h;
            Drawable[] drawableArr = cVar.f725g;
            for (int i3 = 0; i3 < i2; i3++) {
                if (drawableArr[i3] != null && drawableArr[i3].canApplyTheme()) {
                    drawableArr[i3].applyTheme(theme);
                    cVar.f723e |= drawableArr[i3].getChangingConfigurations();
                }
            }
            cVar.f(theme.getResources());
        }
    }

    public c b() {
        throw null;
    }

    public final void c(Drawable drawable) {
        if (this.m == null) {
            this.m = new C0016b();
        }
        C0016b bVar = this.m;
        bVar.b = drawable.getCallback();
        drawable.setCallback(bVar);
        try {
            if (this.b.A <= 0 && this.f716g) {
                drawable.setAlpha(this.f715f);
            }
            c cVar = this.b;
            if (cVar.E) {
                drawable.setColorFilter(cVar.D);
            } else {
                if (cVar.H) {
                    drawable.setTintList(cVar.F);
                }
                c cVar2 = this.b;
                if (cVar2.I) {
                    drawable.setTintMode(cVar2.G);
                }
            }
            drawable.setVisible(isVisible(), true);
            drawable.setDither(this.b.x);
            drawable.setState(getState());
            drawable.setLevel(getLevel());
            drawable.setBounds(getBounds());
            if (Build.VERSION.SDK_INT >= 23) {
                drawable.setLayoutDirection(getLayoutDirection());
            }
            drawable.setAutoMirrored(this.b.C);
            Rect rect = this.c;
            if (rect != null) {
                drawable.setHotspotBounds(rect.left, rect.top, rect.right, rect.bottom);
            }
        } finally {
            C0016b bVar2 = this.m;
            Drawable.Callback callback = bVar2.b;
            bVar2.b = null;
            drawable.setCallback(callback);
        }
    }

    public boolean canApplyTheme() {
        return this.b.canApplyTheme();
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0073  */
    public boolean d(int i2) {
        Runnable runnable;
        if (i2 == this.f717h) {
            return false;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        if (this.b.B > 0) {
            Drawable drawable = this.f714e;
            if (drawable != null) {
                drawable.setVisible(false, false);
            }
            Drawable drawable2 = this.f713d;
            if (drawable2 != null) {
                this.f714e = drawable2;
                this.f721l = ((long) this.b.B) + uptimeMillis;
            } else {
                this.f714e = null;
                this.f721l = 0;
            }
        } else {
            Drawable drawable3 = this.f713d;
            if (drawable3 != null) {
                drawable3.setVisible(false, false);
            }
        }
        if (i2 >= 0) {
            c cVar = this.b;
            if (i2 < cVar.f726h) {
                Drawable d2 = cVar.d(i2);
                this.f713d = d2;
                this.f717h = i2;
                if (d2 != null) {
                    int i3 = this.b.A;
                    if (i3 > 0) {
                        this.f720k = uptimeMillis + ((long) i3);
                    }
                    c(d2);
                }
                if (!(this.f720k == 0 && this.f721l == 0)) {
                    runnable = this.f719j;
                    if (runnable != null) {
                        this.f719j = new a();
                    } else {
                        unscheduleSelf(runnable);
                    }
                    a(true);
                }
                invalidateSelf();
                return true;
            }
        }
        this.f713d = null;
        this.f717h = -1;
        runnable = this.f719j;
        if (runnable != null) {
        }
        a(true);
        invalidateSelf();
        return true;
    }

    public void draw(Canvas canvas) {
        Drawable drawable = this.f713d;
        if (drawable != null) {
            drawable.draw(canvas);
        }
        Drawable drawable2 = this.f714e;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
    }

    public void e(c cVar) {
        throw null;
    }

    public int getAlpha() {
        return this.f715f;
    }

    public int getChangingConfigurations() {
        return super.getChangingConfigurations() | this.b.getChangingConfigurations();
    }

    public final Drawable.ConstantState getConstantState() {
        boolean z;
        c cVar = this.b;
        synchronized (cVar) {
            z = false;
            if (cVar.v) {
                z = cVar.w;
            } else {
                cVar.c();
                cVar.v = true;
                int i2 = cVar.f726h;
                Drawable[] drawableArr = cVar.f725g;
                for (int i3 = 0; i3 < i2; i3++) {
                    if (drawableArr[i3].getConstantState() == null) {
                        cVar.w = false;
                    }
                }
                cVar.w = true;
                z = true;
            }
            break;
        }
        if (!z) {
            return null;
        }
        this.b.f722d = getChangingConfigurations();
        return this.b;
    }

    public Drawable getCurrent() {
        return this.f713d;
    }

    public void getHotspotBounds(Rect rect) {
        Rect rect2 = this.c;
        if (rect2 != null) {
            rect.set(rect2);
        } else {
            super.getHotspotBounds(rect);
        }
    }

    public int getIntrinsicHeight() {
        c cVar = this.b;
        if (cVar.f730l) {
            if (!cVar.m) {
                cVar.b();
            }
            return cVar.o;
        }
        Drawable drawable = this.f713d;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return -1;
    }

    public int getIntrinsicWidth() {
        c cVar = this.b;
        if (cVar.f730l) {
            if (!cVar.m) {
                cVar.b();
            }
            return cVar.n;
        }
        Drawable drawable = this.f713d;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return -1;
    }

    public int getMinimumHeight() {
        c cVar = this.b;
        if (cVar.f730l) {
            if (!cVar.m) {
                cVar.b();
            }
            return cVar.q;
        }
        Drawable drawable = this.f713d;
        if (drawable != null) {
            return drawable.getMinimumHeight();
        }
        return 0;
    }

    public int getMinimumWidth() {
        c cVar = this.b;
        if (cVar.f730l) {
            if (!cVar.m) {
                cVar.b();
            }
            return cVar.p;
        }
        Drawable drawable = this.f713d;
        if (drawable != null) {
            return drawable.getMinimumWidth();
        }
        return 0;
    }

    public int getOpacity() {
        Drawable drawable = this.f713d;
        int i2 = -2;
        if (drawable == null || !drawable.isVisible()) {
            return -2;
        }
        c cVar = this.b;
        if (cVar.r) {
            return cVar.s;
        }
        cVar.c();
        int i3 = cVar.f726h;
        Drawable[] drawableArr = cVar.f725g;
        if (i3 > 0) {
            i2 = drawableArr[0].getOpacity();
        }
        for (int i4 = 1; i4 < i3; i4++) {
            i2 = Drawable.resolveOpacity(i2, drawableArr[i4].getOpacity());
        }
        cVar.s = i2;
        cVar.r = true;
        return i2;
    }

    public void getOutline(Outline outline) {
        Drawable drawable = this.f713d;
        if (drawable != null) {
            drawable.getOutline(outline);
        }
    }

    public boolean getPadding(Rect rect) {
        boolean z;
        c cVar = this.b;
        Rect rect2 = null;
        boolean z2 = true;
        if (!cVar.f727i) {
            Rect rect3 = cVar.f729k;
            if (rect3 != null || cVar.f728j) {
                rect2 = rect3;
            } else {
                cVar.c();
                Rect rect4 = new Rect();
                int i2 = cVar.f726h;
                Drawable[] drawableArr = cVar.f725g;
                for (int i3 = 0; i3 < i2; i3++) {
                    if (drawableArr[i3].getPadding(rect4)) {
                        if (rect2 == null) {
                            rect2 = new Rect(0, 0, 0, 0);
                        }
                        int i4 = rect4.left;
                        if (i4 > rect2.left) {
                            rect2.left = i4;
                        }
                        int i5 = rect4.top;
                        if (i5 > rect2.top) {
                            rect2.top = i5;
                        }
                        int i6 = rect4.right;
                        if (i6 > rect2.right) {
                            rect2.right = i6;
                        }
                        int i7 = rect4.bottom;
                        if (i7 > rect2.bottom) {
                            rect2.bottom = i7;
                        }
                    }
                }
                cVar.f728j = true;
                cVar.f729k = rect2;
            }
        }
        if (rect2 != null) {
            rect.set(rect2);
            z = (((rect2.left | rect2.top) | rect2.bottom) | rect2.right) != 0;
        } else {
            Drawable drawable = this.f713d;
            z = drawable != null ? drawable.getPadding(rect) : super.getPadding(rect);
        }
        if (!this.b.C || m.h.i0(this) != 1) {
            z2 = false;
        }
        if (z2) {
            int i8 = rect.left;
            rect.left = rect.right;
            rect.right = i8;
        }
        return z;
    }

    public void invalidateDrawable(Drawable drawable) {
        c cVar = this.b;
        if (cVar != null) {
            cVar.r = false;
            cVar.t = false;
        }
        if (drawable == this.f713d && getCallback() != null) {
            getCallback().invalidateDrawable(this);
        }
    }

    public boolean isAutoMirrored() {
        return this.b.C;
    }

    public void jumpToCurrentState() {
        boolean z;
        Drawable drawable = this.f714e;
        boolean z2 = true;
        if (drawable != null) {
            drawable.jumpToCurrentState();
            this.f714e = null;
            z = true;
        } else {
            z = false;
        }
        Drawable drawable2 = this.f713d;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
            if (this.f716g) {
                this.f713d.setAlpha(this.f715f);
            }
        }
        if (this.f721l != 0) {
            this.f721l = 0;
            z = true;
        }
        if (this.f720k != 0) {
            this.f720k = 0;
        } else {
            z2 = z;
        }
        if (z2) {
            invalidateSelf();
        }
    }

    public Drawable mutate() {
        if (!this.f718i && super.mutate() == this) {
            c b2 = b();
            b2.e();
            e(b2);
            this.f718i = true;
        }
        return this;
    }

    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f714e;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
        Drawable drawable2 = this.f713d;
        if (drawable2 != null) {
            drawable2.setBounds(rect);
        }
    }

    public boolean onLayoutDirectionChanged(int i2) {
        c cVar = this.b;
        int i3 = this.f717h;
        int i4 = cVar.f726h;
        Drawable[] drawableArr = cVar.f725g;
        boolean z = false;
        for (int i5 = 0; i5 < i4; i5++) {
            if (drawableArr[i5] != null) {
                boolean layoutDirection = Build.VERSION.SDK_INT >= 23 ? drawableArr[i5].setLayoutDirection(i2) : false;
                if (i5 == i3) {
                    z = layoutDirection;
                }
            }
        }
        cVar.z = i2;
        return z;
    }

    public boolean onLevelChange(int i2) {
        Drawable drawable = this.f714e;
        if (drawable != null) {
            return drawable.setLevel(i2);
        }
        Drawable drawable2 = this.f713d;
        if (drawable2 != null) {
            return drawable2.setLevel(i2);
        }
        return false;
    }

    public boolean onStateChange(int[] iArr) {
        Drawable drawable = this.f714e;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        Drawable drawable2 = this.f713d;
        if (drawable2 != null) {
            return drawable2.setState(iArr);
        }
        return false;
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j2) {
        if (drawable == this.f713d && getCallback() != null) {
            getCallback().scheduleDrawable(this, runnable, j2);
        }
    }

    public void setAlpha(int i2) {
        if (!this.f716g || this.f715f != i2) {
            this.f716g = true;
            this.f715f = i2;
            Drawable drawable = this.f713d;
            if (drawable == null) {
                return;
            }
            if (this.f720k == 0) {
                drawable.setAlpha(i2);
            } else {
                a(false);
            }
        }
    }

    public void setAutoMirrored(boolean z) {
        c cVar = this.b;
        if (cVar.C != z) {
            cVar.C = z;
            Drawable drawable = this.f713d;
            if (drawable != null) {
                drawable.setAutoMirrored(z);
            }
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        c cVar = this.b;
        cVar.E = true;
        if (cVar.D != colorFilter) {
            cVar.D = colorFilter;
            Drawable drawable = this.f713d;
            if (drawable != null) {
                drawable.setColorFilter(colorFilter);
            }
        }
    }

    public void setDither(boolean z) {
        c cVar = this.b;
        if (cVar.x != z) {
            cVar.x = z;
            Drawable drawable = this.f713d;
            if (drawable != null) {
                drawable.setDither(z);
            }
        }
    }

    public void setHotspot(float f2, float f3) {
        Drawable drawable = this.f713d;
        if (drawable != null) {
            drawable.setHotspot(f2, f3);
        }
    }

    public void setHotspotBounds(int i2, int i3, int i4, int i5) {
        Rect rect = this.c;
        if (rect == null) {
            this.c = new Rect(i2, i3, i4, i5);
        } else {
            rect.set(i2, i3, i4, i5);
        }
        Drawable drawable = this.f713d;
        if (drawable != null) {
            drawable.setHotspotBounds(i2, i3, i4, i5);
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        c cVar = this.b;
        cVar.H = true;
        if (cVar.F != colorStateList) {
            cVar.F = colorStateList;
            m.h.f1(this.f713d, colorStateList);
        }
    }

    public void setTintMode(PorterDuff.Mode mode) {
        c cVar = this.b;
        cVar.I = true;
        if (cVar.G != mode) {
            cVar.G = mode;
            m.h.g1(this.f713d, mode);
        }
    }

    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        Drawable drawable = this.f714e;
        if (drawable != null) {
            drawable.setVisible(z, z2);
        }
        Drawable drawable2 = this.f713d;
        if (drawable2 != null) {
            drawable2.setVisible(z, z2);
        }
        return visible;
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        if (drawable == this.f713d && getCallback() != null) {
            getCallback().unscheduleDrawable(this, runnable);
        }
    }
}
