package b.b.m.a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.SparseArray;
import b.b.k.i;
import b.b.m.a.d;

public class b extends Drawable implements Drawable.Callback {

    /* renamed from: b  reason: collision with root package name */
    public c f455b;

    /* renamed from: c  reason: collision with root package name */
    public Rect f456c;

    /* renamed from: d  reason: collision with root package name */
    public Drawable f457d;

    /* renamed from: e  reason: collision with root package name */
    public Drawable f458e;
    public int f = 255;
    public boolean g;
    public int h = -1;
    public boolean i;
    public Runnable j;
    public long k;
    public long l;
    public C0008b m;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            b.this.a(true);
            b.this.invalidateSelf();
        }
    }

    /* renamed from: b.b.m.a.b$b  reason: collision with other inner class name */
    public static class C0008b implements Drawable.Callback {

        /* renamed from: b  reason: collision with root package name */
        public Drawable.Callback f460b;

        public void invalidateDrawable(Drawable drawable) {
        }

        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
            Drawable.Callback callback = this.f460b;
            if (callback != null) {
                callback.scheduleDrawable(drawable, runnable, j);
            }
        }

        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            Drawable.Callback callback = this.f460b;
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

        /* renamed from: a  reason: collision with root package name */
        public final b f461a;

        /* renamed from: b  reason: collision with root package name */
        public Resources f462b;

        /* renamed from: c  reason: collision with root package name */
        public int f463c = 160;

        /* renamed from: d  reason: collision with root package name */
        public int f464d;

        /* renamed from: e  reason: collision with root package name */
        public int f465e;
        public SparseArray<Drawable.ConstantState> f;
        public Drawable[] g;
        public int h;
        public boolean i;
        public boolean j;
        public Rect k;
        public boolean l;
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
            this.i = false;
            this.l = false;
            this.x = true;
            this.A = 0;
            this.B = 0;
            this.f461a = bVar;
            this.f462b = resources != null ? resources : cVar != null ? cVar.f462b : null;
            int d2 = b.d(resources, cVar != null ? cVar.f463c : 0);
            this.f463c = d2;
            if (cVar != null) {
                this.f464d = cVar.f464d;
                this.f465e = cVar.f465e;
                this.v = true;
                this.w = true;
                this.i = cVar.i;
                this.l = cVar.l;
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
                if (cVar.f463c == d2) {
                    if (cVar.j) {
                        this.k = new Rect(cVar.k);
                        this.j = true;
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
                Drawable[] drawableArr = cVar.g;
                this.g = new Drawable[drawableArr.length];
                this.h = cVar.h;
                SparseArray<Drawable.ConstantState> sparseArray = cVar.f;
                this.f = sparseArray != null ? sparseArray.clone() : new SparseArray<>(this.h);
                int i2 = this.h;
                for (int i3 = 0; i3 < i2; i3++) {
                    if (drawableArr[i3] != null) {
                        Drawable.ConstantState constantState = drawableArr[i3].getConstantState();
                        if (constantState != null) {
                            this.f.put(i3, constantState);
                        } else {
                            this.g[i3] = drawableArr[i3];
                        }
                    }
                }
                return;
            }
            this.g = new Drawable[10];
            this.h = 0;
        }

        public final int a(Drawable drawable) {
            int i2 = this.h;
            if (i2 >= this.g.length) {
                int i3 = i2 + 10;
                d.a aVar = (d.a) this;
                Drawable[] drawableArr = new Drawable[i3];
                System.arraycopy(aVar.g, 0, drawableArr, 0, i2);
                aVar.g = drawableArr;
                int[][] iArr = new int[i3][];
                System.arraycopy(aVar.J, 0, iArr, 0, i2);
                aVar.J = iArr;
            }
            drawable.mutate();
            drawable.setVisible(false, true);
            drawable.setCallback(this.f461a);
            this.g[i2] = drawable;
            this.h++;
            this.f465e = drawable.getChangingConfigurations() | this.f465e;
            this.r = false;
            this.t = false;
            this.k = null;
            this.j = false;
            this.m = false;
            this.v = false;
            return i2;
        }

        public void b() {
            this.m = true;
            c();
            int i2 = this.h;
            Drawable[] drawableArr = this.g;
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
            SparseArray<Drawable.ConstantState> sparseArray = this.f;
            if (sparseArray != null) {
                int size = sparseArray.size();
                for (int i2 = 0; i2 < size; i2++) {
                    int keyAt = this.f.keyAt(i2);
                    Drawable[] drawableArr = this.g;
                    Drawable newDrawable = this.f.valueAt(i2).newDrawable(this.f462b);
                    newDrawable.setLayoutDirection(this.z);
                    Drawable mutate = newDrawable.mutate();
                    mutate.setCallback(this.f461a);
                    drawableArr[keyAt] = mutate;
                }
                this.f = null;
            }
        }

        public boolean canApplyTheme() {
            int i2 = this.h;
            Drawable[] drawableArr = this.g;
            for (int i3 = 0; i3 < i2; i3++) {
                Drawable drawable = drawableArr[i3];
                if (drawable == null) {
                    Drawable.ConstantState constantState = this.f.get(i3);
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
            Drawable drawable = this.g[i2];
            if (drawable != null) {
                return drawable;
            }
            SparseArray<Drawable.ConstantState> sparseArray = this.f;
            if (sparseArray == null || (indexOfKey = sparseArray.indexOfKey(i2)) < 0) {
                return null;
            }
            Drawable newDrawable = this.f.valueAt(indexOfKey).newDrawable(this.f462b);
            newDrawable.setLayoutDirection(this.z);
            Drawable mutate = newDrawable.mutate();
            mutate.setCallback(this.f461a);
            this.g[i2] = mutate;
            this.f.removeAt(indexOfKey);
            if (this.f.size() == 0) {
                this.f = null;
            }
            return mutate;
        }

        public abstract void e();

        public final void f(Resources resources) {
            if (resources != null) {
                this.f462b = resources;
                int d2 = b.d(resources, this.f463c);
                int i2 = this.f463c;
                this.f463c = d2;
                if (i2 != d2) {
                    this.m = false;
                    this.j = false;
                }
            }
        }

        public int getChangingConfigurations() {
            return this.f464d | this.f465e;
        }
    }

    public static int d(Resources resources, int i2) {
        if (resources != null) {
            i2 = resources.getDisplayMetrics().densityDpi;
        }
        if (i2 == 0) {
            return 160;
        }
        return i2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0062 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:24:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    public void a(boolean z) {
        boolean z2;
        Drawable drawable;
        boolean z3 = true;
        this.g = true;
        long uptimeMillis = SystemClock.uptimeMillis();
        Drawable drawable2 = this.f457d;
        if (drawable2 != null) {
            long j2 = this.k;
            if (j2 != 0) {
                if (j2 <= uptimeMillis) {
                    drawable2.setAlpha(this.f);
                } else {
                    drawable2.setAlpha(((255 - (((int) ((j2 - uptimeMillis) * 255)) / this.f455b.A)) * this.f) / 255);
                    z2 = true;
                    drawable = this.f458e;
                    if (drawable != null) {
                        long j3 = this.l;
                        if (j3 != 0) {
                            if (j3 <= uptimeMillis) {
                                drawable.setVisible(false, false);
                                this.f458e = null;
                            } else {
                                drawable.setAlpha(((((int) ((j3 - uptimeMillis) * 255)) / this.f455b.B) * this.f) / 255);
                                if (!z && z3) {
                                    scheduleSelf(this.j, uptimeMillis + 16);
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
                    this.l = 0;
                    z3 = z2;
                    if (!z) {
                    }
                }
            }
            z2 = false;
            drawable = this.f458e;
            if (drawable != null) {
            }
            this.l = 0;
            z3 = z2;
            if (!z) {
            }
        }
        this.k = 0;
        z2 = false;
        drawable = this.f458e;
        if (drawable != null) {
        }
        this.l = 0;
        z3 = z2;
        if (!z) {
        }
    }

    public void applyTheme(Resources.Theme theme) {
        c cVar = this.f455b;
        if (cVar == null) {
            throw null;
        } else if (theme != null) {
            cVar.c();
            int i2 = cVar.h;
            Drawable[] drawableArr = cVar.g;
            for (int i3 = 0; i3 < i2; i3++) {
                if (drawableArr[i3] != null && drawableArr[i3].canApplyTheme()) {
                    drawableArr[i3].applyTheme(theme);
                    cVar.f465e |= drawableArr[i3].getChangingConfigurations();
                }
            }
            cVar.f(theme.getResources());
        }
    }

    public abstract c b();

    public final void c(Drawable drawable) {
        if (this.m == null) {
            this.m = new C0008b();
        }
        C0008b bVar = this.m;
        bVar.f460b = drawable.getCallback();
        drawable.setCallback(bVar);
        try {
            if (this.f455b.A <= 0 && this.g) {
                drawable.setAlpha(this.f);
            }
            if (this.f455b.E) {
                drawable.setColorFilter(this.f455b.D);
            } else {
                if (this.f455b.H) {
                    drawable.setTintList(this.f455b.F);
                }
                if (this.f455b.I) {
                    drawable.setTintMode(this.f455b.G);
                }
            }
            drawable.setVisible(isVisible(), true);
            drawable.setDither(this.f455b.x);
            drawable.setState(getState());
            drawable.setLevel(getLevel());
            drawable.setBounds(getBounds());
            drawable.setLayoutDirection(getLayoutDirection());
            drawable.setAutoMirrored(this.f455b.C);
            Rect rect = this.f456c;
            if (rect != null) {
                drawable.setHotspotBounds(rect.left, rect.top, rect.right, rect.bottom);
            }
        } finally {
            C0008b bVar2 = this.m;
            Drawable.Callback callback = bVar2.f460b;
            bVar2.f460b = null;
            drawable.setCallback(callback);
        }
    }

    public boolean canApplyTheme() {
        return this.f455b.canApplyTheme();
    }

    public void draw(Canvas canvas) {
        Drawable drawable = this.f457d;
        if (drawable != null) {
            drawable.draw(canvas);
        }
        Drawable drawable2 = this.f458e;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0073  */
    public boolean e(int i2) {
        Runnable runnable;
        if (i2 == this.h) {
            return false;
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        if (this.f455b.B > 0) {
            Drawable drawable = this.f458e;
            if (drawable != null) {
                drawable.setVisible(false, false);
            }
            Drawable drawable2 = this.f457d;
            if (drawable2 != null) {
                this.f458e = drawable2;
                this.l = ((long) this.f455b.B) + uptimeMillis;
            } else {
                this.f458e = null;
                this.l = 0;
            }
        } else {
            Drawable drawable3 = this.f457d;
            if (drawable3 != null) {
                drawable3.setVisible(false, false);
            }
        }
        if (i2 >= 0) {
            c cVar = this.f455b;
            if (i2 < cVar.h) {
                Drawable d2 = cVar.d(i2);
                this.f457d = d2;
                this.h = i2;
                if (d2 != null) {
                    int i3 = this.f455b.A;
                    if (i3 > 0) {
                        this.k = uptimeMillis + ((long) i3);
                    }
                    c(d2);
                }
                if (!(this.k == 0 && this.l == 0)) {
                    runnable = this.j;
                    if (runnable != null) {
                        this.j = new a();
                    } else {
                        unscheduleSelf(runnable);
                    }
                    a(true);
                }
                invalidateSelf();
                return true;
            }
        }
        this.f457d = null;
        this.h = -1;
        runnable = this.j;
        if (runnable != null) {
        }
        a(true);
        invalidateSelf();
        return true;
    }

    public void f(c cVar) {
        this.f455b = cVar;
        int i2 = this.h;
        if (i2 >= 0) {
            Drawable d2 = cVar.d(i2);
            this.f457d = d2;
            if (d2 != null) {
                c(d2);
            }
        }
        this.f458e = null;
    }

    public int getAlpha() {
        return this.f;
    }

    public int getChangingConfigurations() {
        return super.getChangingConfigurations() | this.f455b.getChangingConfigurations();
    }

    public final Drawable.ConstantState getConstantState() {
        boolean z;
        c cVar = this.f455b;
        synchronized (cVar) {
            z = true;
            if (cVar.v) {
                z = cVar.w;
            } else {
                cVar.c();
                cVar.v = true;
                int i2 = cVar.h;
                Drawable[] drawableArr = cVar.g;
                for (int i3 = 0; i3 < i2; i3++) {
                    if (drawableArr[i3].getConstantState() == null) {
                        cVar.w = false;
                        z = false;
                        break;
                    }
                }
                cVar.w = true;
            }
        }
        if (!z) {
            return null;
        }
        this.f455b.f464d = getChangingConfigurations();
        return this.f455b;
    }

    public Drawable getCurrent() {
        return this.f457d;
    }

    public void getHotspotBounds(Rect rect) {
        Rect rect2 = this.f456c;
        if (rect2 != null) {
            rect.set(rect2);
        } else {
            super.getHotspotBounds(rect);
        }
    }

    public int getIntrinsicHeight() {
        c cVar = this.f455b;
        if (cVar.l) {
            if (!cVar.m) {
                cVar.b();
            }
            return cVar.o;
        }
        Drawable drawable = this.f457d;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return -1;
    }

    public int getIntrinsicWidth() {
        c cVar = this.f455b;
        if (cVar.l) {
            if (!cVar.m) {
                cVar.b();
            }
            return cVar.n;
        }
        Drawable drawable = this.f457d;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return -1;
    }

    public int getMinimumHeight() {
        c cVar = this.f455b;
        if (cVar.l) {
            if (!cVar.m) {
                cVar.b();
            }
            return cVar.q;
        }
        Drawable drawable = this.f457d;
        if (drawable != null) {
            return drawable.getMinimumHeight();
        }
        return 0;
    }

    public int getMinimumWidth() {
        c cVar = this.f455b;
        if (cVar.l) {
            if (!cVar.m) {
                cVar.b();
            }
            return cVar.p;
        }
        Drawable drawable = this.f457d;
        if (drawable != null) {
            return drawable.getMinimumWidth();
        }
        return 0;
    }

    public int getOpacity() {
        Drawable drawable = this.f457d;
        int i2 = -2;
        if (drawable == null || !drawable.isVisible()) {
            return -2;
        }
        c cVar = this.f455b;
        if (cVar.r) {
            return cVar.s;
        }
        cVar.c();
        int i3 = cVar.h;
        Drawable[] drawableArr = cVar.g;
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
        Drawable drawable = this.f457d;
        if (drawable != null) {
            drawable.getOutline(outline);
        }
    }

    public boolean getPadding(Rect rect) {
        boolean z;
        c cVar = this.f455b;
        Rect rect2 = null;
        boolean z2 = false;
        if (!cVar.i) {
            if (cVar.k != null || cVar.j) {
                rect2 = cVar.k;
            } else {
                cVar.c();
                Rect rect3 = new Rect();
                int i2 = cVar.h;
                Drawable[] drawableArr = cVar.g;
                for (int i3 = 0; i3 < i2; i3++) {
                    if (drawableArr[i3].getPadding(rect3)) {
                        if (rect2 == null) {
                            rect2 = new Rect(0, 0, 0, 0);
                        }
                        int i4 = rect3.left;
                        if (i4 > rect2.left) {
                            rect2.left = i4;
                        }
                        int i5 = rect3.top;
                        if (i5 > rect2.top) {
                            rect2.top = i5;
                        }
                        int i6 = rect3.right;
                        if (i6 > rect2.right) {
                            rect2.right = i6;
                        }
                        int i7 = rect3.bottom;
                        if (i7 > rect2.bottom) {
                            rect2.bottom = i7;
                        }
                    }
                }
                cVar.j = true;
                cVar.k = rect2;
            }
        }
        if (rect2 != null) {
            rect.set(rect2);
            z = (((rect2.left | rect2.top) | rect2.bottom) | rect2.right) != 0;
        } else {
            Drawable drawable = this.f457d;
            z = drawable != null ? drawable.getPadding(rect) : super.getPadding(rect);
        }
        if (this.f455b.C && getLayoutDirection() == 1) {
            z2 = true;
        }
        if (z2) {
            int i8 = rect.left;
            rect.left = rect.right;
            rect.right = i8;
        }
        return z;
    }

    public void invalidateDrawable(Drawable drawable) {
        c cVar = this.f455b;
        if (cVar != null) {
            cVar.r = false;
            cVar.t = false;
        }
        if (drawable == this.f457d && getCallback() != null) {
            getCallback().invalidateDrawable(this);
        }
    }

    public boolean isAutoMirrored() {
        return this.f455b.C;
    }

    public void jumpToCurrentState() {
        boolean z;
        Drawable drawable = this.f458e;
        boolean z2 = true;
        if (drawable != null) {
            drawable.jumpToCurrentState();
            this.f458e = null;
            z = true;
        } else {
            z = false;
        }
        Drawable drawable2 = this.f457d;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
            if (this.g) {
                this.f457d.setAlpha(this.f);
            }
        }
        if (this.l != 0) {
            this.l = 0;
            z = true;
        }
        if (this.k != 0) {
            this.k = 0;
        } else {
            z2 = z;
        }
        if (z2) {
            invalidateSelf();
        }
    }

    public Drawable mutate() {
        if (!this.i && super.mutate() == this) {
            c b2 = b();
            b2.e();
            f(b2);
            this.i = true;
        }
        return this;
    }

    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f458e;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
        Drawable drawable2 = this.f457d;
        if (drawable2 != null) {
            drawable2.setBounds(rect);
        }
    }

    public boolean onLayoutDirectionChanged(int i2) {
        c cVar = this.f455b;
        int i3 = this.h;
        int i4 = cVar.h;
        Drawable[] drawableArr = cVar.g;
        boolean z = false;
        for (int i5 = 0; i5 < i4; i5++) {
            if (drawableArr[i5] != null) {
                boolean layoutDirection = drawableArr[i5].setLayoutDirection(i2);
                if (i5 == i3) {
                    z = layoutDirection;
                }
            }
        }
        cVar.z = i2;
        return z;
    }

    public boolean onLevelChange(int i2) {
        Drawable drawable = this.f458e;
        if (drawable != null) {
            return drawable.setLevel(i2);
        }
        Drawable drawable2 = this.f457d;
        if (drawable2 != null) {
            return drawable2.setLevel(i2);
        }
        return false;
    }

    public boolean onStateChange(int[] iArr) {
        Drawable drawable = this.f458e;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        Drawable drawable2 = this.f457d;
        if (drawable2 != null) {
            return drawable2.setState(iArr);
        }
        return false;
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j2) {
        if (drawable == this.f457d && getCallback() != null) {
            getCallback().scheduleDrawable(this, runnable, j2);
        }
    }

    public void setAlpha(int i2) {
        if (!this.g || this.f != i2) {
            this.g = true;
            this.f = i2;
            Drawable drawable = this.f457d;
            if (drawable == null) {
                return;
            }
            if (this.k == 0) {
                drawable.setAlpha(i2);
            } else {
                a(false);
            }
        }
    }

    public void setAutoMirrored(boolean z) {
        c cVar = this.f455b;
        if (cVar.C != z) {
            cVar.C = z;
            Drawable drawable = this.f457d;
            if (drawable != null) {
                drawable.setAutoMirrored(z);
            }
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        c cVar = this.f455b;
        cVar.E = true;
        if (cVar.D != colorFilter) {
            cVar.D = colorFilter;
            Drawable drawable = this.f457d;
            if (drawable != null) {
                drawable.setColorFilter(colorFilter);
            }
        }
    }

    public void setDither(boolean z) {
        c cVar = this.f455b;
        if (cVar.x != z) {
            cVar.x = z;
            Drawable drawable = this.f457d;
            if (drawable != null) {
                drawable.setDither(z);
            }
        }
    }

    public void setHotspot(float f2, float f3) {
        Drawable drawable = this.f457d;
        if (drawable != null) {
            drawable.setHotspot(f2, f3);
        }
    }

    public void setHotspotBounds(int i2, int i3, int i4, int i5) {
        Rect rect = this.f456c;
        if (rect == null) {
            this.f456c = new Rect(i2, i3, i4, i5);
        } else {
            rect.set(i2, i3, i4, i5);
        }
        Drawable drawable = this.f457d;
        if (drawable != null) {
            drawable.setHotspotBounds(i2, i3, i4, i5);
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        c cVar = this.f455b;
        cVar.H = true;
        if (cVar.F != colorStateList) {
            cVar.F = colorStateList;
            i.j.c1(this.f457d, colorStateList);
        }
    }

    public void setTintMode(PorterDuff.Mode mode) {
        c cVar = this.f455b;
        cVar.I = true;
        if (cVar.G != mode) {
            cVar.G = mode;
            i.j.d1(this.f457d, mode);
        }
    }

    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        Drawable drawable = this.f458e;
        if (drawable != null) {
            drawable.setVisible(z, z2);
        }
        Drawable drawable2 = this.f457d;
        if (drawable2 != null) {
            drawable2.setVisible(z, z2);
        }
        return visible;
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        if (drawable == this.f457d && getCallback() != null) {
            getCallback().unscheduleDrawable(this, runnable);
        }
    }
}
