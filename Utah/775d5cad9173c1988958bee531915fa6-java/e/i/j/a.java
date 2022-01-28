package e.i.j;

import android.content.res.Resources;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.ListView;
import e.i.i.v;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class a implements View.OnTouchListener {
    public static final int r = ViewConfiguration.getTapTimeout();
    public final C0039a b;
    public final Interpolator c = new AccelerateInterpolator();

    /* renamed from: d  reason: collision with root package name */
    public final View f1563d;

    /* renamed from: e  reason: collision with root package name */
    public Runnable f1564e;

    /* renamed from: f  reason: collision with root package name */
    public float[] f1565f = {0.0f, 0.0f};

    /* renamed from: g  reason: collision with root package name */
    public float[] f1566g = {Float.MAX_VALUE, Float.MAX_VALUE};

    /* renamed from: h  reason: collision with root package name */
    public int f1567h;

    /* renamed from: i  reason: collision with root package name */
    public int f1568i;

    /* renamed from: j  reason: collision with root package name */
    public float[] f1569j = {0.0f, 0.0f};

    /* renamed from: k  reason: collision with root package name */
    public float[] f1570k = {0.0f, 0.0f};

    /* renamed from: l  reason: collision with root package name */
    public float[] f1571l = {Float.MAX_VALUE, Float.MAX_VALUE};
    public boolean m;
    public boolean n;
    public boolean o;
    public boolean p;
    public boolean q;

    /* renamed from: e.i.j.a$a  reason: collision with other inner class name */
    public static class C0039a {
        public int a;
        public int b;
        public float c;

        /* renamed from: d  reason: collision with root package name */
        public float f1572d;

        /* renamed from: e  reason: collision with root package name */
        public long f1573e = Long.MIN_VALUE;

        /* renamed from: f  reason: collision with root package name */
        public long f1574f = 0;

        /* renamed from: g  reason: collision with root package name */
        public int f1575g = 0;

        /* renamed from: h  reason: collision with root package name */
        public int f1576h = 0;

        /* renamed from: i  reason: collision with root package name */
        public long f1577i = -1;

        /* renamed from: j  reason: collision with root package name */
        public float f1578j;

        /* renamed from: k  reason: collision with root package name */
        public int f1579k;

        public final float a(long j2) {
            long j3 = this.f1573e;
            if (j2 < j3) {
                return 0.0f;
            }
            long j4 = this.f1577i;
            if (j4 < 0 || j2 < j4) {
                return a.b(((float) (j2 - j3)) / ((float) this.a), 0.0f, 1.0f) * 0.5f;
            }
            float f2 = this.f1578j;
            return (a.b(((float) (j2 - j4)) / ((float) this.f1579k), 0.0f, 1.0f) * f2) + (1.0f - f2);
        }
    }

    public class b implements Runnable {
        public b() {
        }

        public void run() {
            a aVar = a.this;
            if (aVar.p) {
                if (aVar.n) {
                    aVar.n = false;
                    C0039a aVar2 = aVar.b;
                    Objects.requireNonNull(aVar2);
                    long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                    aVar2.f1573e = currentAnimationTimeMillis;
                    aVar2.f1577i = -1;
                    aVar2.f1574f = currentAnimationTimeMillis;
                    aVar2.f1578j = 0.5f;
                    aVar2.f1575g = 0;
                    aVar2.f1576h = 0;
                }
                C0039a aVar3 = a.this.b;
                if ((aVar3.f1577i > 0 && AnimationUtils.currentAnimationTimeMillis() > aVar3.f1577i + ((long) aVar3.f1579k)) || !a.this.e()) {
                    a.this.p = false;
                    return;
                }
                a aVar4 = a.this;
                if (aVar4.o) {
                    aVar4.o = false;
                    Objects.requireNonNull(aVar4);
                    long uptimeMillis = SystemClock.uptimeMillis();
                    MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                    aVar4.f1563d.onTouchEvent(obtain);
                    obtain.recycle();
                }
                if (aVar3.f1574f != 0) {
                    long currentAnimationTimeMillis2 = AnimationUtils.currentAnimationTimeMillis();
                    float a = aVar3.a(currentAnimationTimeMillis2);
                    aVar3.f1574f = currentAnimationTimeMillis2;
                    float f2 = ((float) (currentAnimationTimeMillis2 - aVar3.f1574f)) * ((a * 4.0f) + (-4.0f * a * a));
                    aVar3.f1575g = (int) (aVar3.c * f2);
                    int i2 = (int) (f2 * aVar3.f1572d);
                    aVar3.f1576h = i2;
                    ((c) a.this).s.scrollListBy(i2);
                    View view = a.this.f1563d;
                    AtomicInteger atomicInteger = v.a;
                    v.d.m(view, this);
                    return;
                }
                throw new RuntimeException("Cannot compute scroll delta before calling start()");
            }
        }
    }

    public a(View view) {
        C0039a aVar = new C0039a();
        this.b = aVar;
        this.f1563d = view;
        float f2 = Resources.getSystem().getDisplayMetrics().density;
        float[] fArr = this.f1571l;
        float f3 = ((float) ((int) ((1575.0f * f2) + 0.5f))) / 1000.0f;
        fArr[0] = f3;
        fArr[1] = f3;
        float[] fArr2 = this.f1570k;
        float f4 = ((float) ((int) ((f2 * 315.0f) + 0.5f))) / 1000.0f;
        fArr2[0] = f4;
        fArr2[1] = f4;
        this.f1567h = 1;
        float[] fArr3 = this.f1566g;
        fArr3[0] = Float.MAX_VALUE;
        fArr3[1] = Float.MAX_VALUE;
        float[] fArr4 = this.f1565f;
        fArr4[0] = 0.2f;
        fArr4[1] = 0.2f;
        float[] fArr5 = this.f1569j;
        fArr5[0] = 0.001f;
        fArr5[1] = 0.001f;
        this.f1568i = r;
        aVar.a = 500;
        aVar.b = 500;
    }

    public static float b(float f2, float f3, float f4) {
        return f2 > f4 ? f4 : f2 < f3 ? f3 : f2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x003e A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x003f  */
    public final float a(int i2, float f2, float f3, float f4) {
        float f5;
        int i3;
        float f6;
        float b2 = b(this.f1565f[i2] * f3, 0.0f, this.f1566g[i2]);
        float c2 = c(f3 - f2, b2) - c(f2, b2);
        if (c2 < 0.0f) {
            f6 = -this.c.getInterpolation(-c2);
        } else if (c2 > 0.0f) {
            f6 = this.c.getInterpolation(c2);
        } else {
            f5 = 0.0f;
            i3 = (f5 > 0.0f ? 1 : (f5 == 0.0f ? 0 : -1));
            if (i3 != 0) {
                return 0.0f;
            }
            float f7 = this.f1569j[i2];
            float f8 = this.f1570k[i2];
            float f9 = this.f1571l[i2];
            float f10 = f7 * f4;
            return i3 > 0 ? b(f5 * f10, f8, f9) : -b((-f5) * f10, f8, f9);
        }
        f5 = b(f6, -1.0f, 1.0f);
        i3 = (f5 > 0.0f ? 1 : (f5 == 0.0f ? 0 : -1));
        if (i3 != 0) {
        }
    }

    public final float c(float f2, float f3) {
        if (f3 == 0.0f) {
            return 0.0f;
        }
        int i2 = this.f1567h;
        if (i2 == 0 || i2 == 1) {
            if (f2 < f3) {
                return f2 >= 0.0f ? 1.0f - (f2 / f3) : (!this.p || i2 != 1) ? 0.0f : 1.0f;
            }
        } else if (i2 == 2 && f2 < 0.0f) {
            return f2 / (-f3);
        }
    }

    public final void d() {
        int i2 = 0;
        if (this.n) {
            this.p = false;
            return;
        }
        C0039a aVar = this.b;
        Objects.requireNonNull(aVar);
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        int i3 = (int) (currentAnimationTimeMillis - aVar.f1573e);
        int i4 = aVar.b;
        if (i3 > i4) {
            i2 = i4;
        } else if (i3 >= 0) {
            i2 = i3;
        }
        aVar.f1579k = i2;
        aVar.f1578j = aVar.a(currentAnimationTimeMillis);
        aVar.f1577i = currentAnimationTimeMillis;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    public boolean e() {
        boolean z;
        C0039a aVar = this.b;
        float f2 = aVar.f1572d;
        int abs = (int) (f2 / Math.abs(f2));
        float f3 = aVar.c;
        int abs2 = (int) (f3 / Math.abs(f3));
        if (abs != 0) {
            ListView listView = ((c) this).s;
            int count = listView.getCount();
            if (count != 0) {
                int childCount = listView.getChildCount();
                int firstVisiblePosition = listView.getFirstVisiblePosition();
                int i2 = firstVisiblePosition + childCount;
                if (abs <= 0 ? !(abs >= 0 || (firstVisiblePosition <= 0 && listView.getChildAt(0).getTop() >= 0)) : !(i2 >= count && listView.getChildAt(childCount - 1).getBottom() <= listView.getHeight())) {
                    z = true;
                    if (z) {
                        return false;
                    }
                    return true;
                }
            }
            z = false;
            if (z) {
            }
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0013, code lost:
        if (r0 != 3) goto L_0x007f;
     */
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int i2;
        if (!this.q) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                }
            }
            d();
            return false;
        }
        this.o = true;
        this.m = false;
        float a = a(0, motionEvent.getX(), (float) view.getWidth(), (float) this.f1563d.getWidth());
        float a2 = a(1, motionEvent.getY(), (float) view.getHeight(), (float) this.f1563d.getHeight());
        C0039a aVar = this.b;
        aVar.c = a;
        aVar.f1572d = a2;
        if (!this.p && e()) {
            if (this.f1564e == null) {
                this.f1564e = new b();
            }
            this.p = true;
            this.n = true;
            if (this.m || (i2 = this.f1568i) <= 0) {
                this.f1564e.run();
            } else {
                View view2 = this.f1563d;
                Runnable runnable = this.f1564e;
                long j2 = (long) i2;
                AtomicInteger atomicInteger = v.a;
                v.d.n(view2, runnable, j2);
            }
            this.m = true;
        }
        return false;
    }
}
