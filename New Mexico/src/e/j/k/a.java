package e.j.k;

import android.content.res.Resources;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.ListView;
import e.j.j.v;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public abstract class a implements View.OnTouchListener {
    public static final int r = ViewConfiguration.getTapTimeout();
    public final C0043a b;

    /* renamed from: d */
    public final View f1648d;

    /* renamed from: e */
    public Runnable f1649e;
    public boolean m;
    public boolean n;
    public boolean o;
    public boolean p;
    public boolean q;
    public final Interpolator c = new AccelerateInterpolator();

    /* renamed from: f */
    public float[] f1650f = {0.0f, 0.0f};

    /* renamed from: g */
    public float[] f1651g = {Float.MAX_VALUE, Float.MAX_VALUE};

    /* renamed from: j */
    public float[] f1654j = {0.0f, 0.0f};

    /* renamed from: k */
    public float[] f1655k = {0.0f, 0.0f};

    /* renamed from: l */
    public float[] f1656l = {Float.MAX_VALUE, Float.MAX_VALUE};

    /* renamed from: h */
    public int f1652h = 1;

    /* renamed from: i */
    public int f1653i = r;

    /* renamed from: e.j.k.a$a */
    /* loaded from: classes.dex */
    public static class C0043a {
        public int a;
        public int b;
        public float c;

        /* renamed from: d */
        public float f1657d;

        /* renamed from: j */
        public float f1663j;

        /* renamed from: k */
        public int f1664k;

        /* renamed from: e */
        public long f1658e = Long.MIN_VALUE;

        /* renamed from: i */
        public long f1662i = -1;

        /* renamed from: f */
        public long f1659f = 0;

        /* renamed from: g */
        public int f1660g = 0;

        /* renamed from: h */
        public int f1661h = 0;

        public final float a(long j2) {
            long j3 = this.f1658e;
            if (j2 < j3) {
                return 0.0f;
            }
            long j4 = this.f1662i;
            if (j4 < 0 || j2 < j4) {
                return a.b(((float) (j2 - j3)) / ((float) this.a), 0.0f, 1.0f) * 0.5f;
            }
            float f2 = this.f1663j;
            return (a.b(((float) (j2 - j4)) / ((float) this.f1664k), 0.0f, 1.0f) * f2) + (1.0f - f2);
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public b() {
            a.this = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = a.this;
            if (aVar.p) {
                if (aVar.n) {
                    aVar.n = false;
                    C0043a aVar2 = aVar.b;
                    Objects.requireNonNull(aVar2);
                    long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                    aVar2.f1658e = currentAnimationTimeMillis;
                    aVar2.f1662i = -1;
                    aVar2.f1659f = currentAnimationTimeMillis;
                    aVar2.f1663j = 0.5f;
                    aVar2.f1660g = 0;
                    aVar2.f1661h = 0;
                }
                C0043a aVar3 = a.this.b;
                if ((aVar3.f1662i > 0 && AnimationUtils.currentAnimationTimeMillis() > aVar3.f1662i + ((long) aVar3.f1664k)) || !a.this.e()) {
                    a.this.p = false;
                    return;
                }
                a aVar4 = a.this;
                if (aVar4.o) {
                    aVar4.o = false;
                    Objects.requireNonNull(aVar4);
                    long uptimeMillis = SystemClock.uptimeMillis();
                    MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                    aVar4.f1648d.onTouchEvent(obtain);
                    obtain.recycle();
                }
                if (aVar3.f1659f != 0) {
                    long currentAnimationTimeMillis2 = AnimationUtils.currentAnimationTimeMillis();
                    float a = aVar3.a(currentAnimationTimeMillis2);
                    aVar3.f1659f = currentAnimationTimeMillis2;
                    float f2 = ((float) (currentAnimationTimeMillis2 - aVar3.f1659f)) * ((a * 4.0f) + (-4.0f * a * a));
                    aVar3.f1660g = (int) (aVar3.c * f2);
                    int i2 = (int) (f2 * aVar3.f1657d);
                    aVar3.f1661h = i2;
                    ((c) a.this).s.scrollListBy(i2);
                    View view = a.this.f1648d;
                    AtomicInteger atomicInteger = v.a;
                    v.d.m(view, this);
                    return;
                }
                throw new RuntimeException("Cannot compute scroll delta before calling start()");
            }
        }
    }

    public a(View view) {
        C0043a aVar = new C0043a();
        this.b = aVar;
        this.f1648d = view;
        float f2 = Resources.getSystem().getDisplayMetrics().density;
        float[] fArr = this.f1656l;
        float f3 = ((float) ((int) ((1575.0f * f2) + 0.5f))) / 1000.0f;
        fArr[0] = f3;
        fArr[1] = f3;
        float[] fArr2 = this.f1655k;
        float f4 = ((float) ((int) ((f2 * 315.0f) + 0.5f))) / 1000.0f;
        fArr2[0] = f4;
        fArr2[1] = f4;
        float[] fArr3 = this.f1651g;
        fArr3[0] = Float.MAX_VALUE;
        fArr3[1] = Float.MAX_VALUE;
        float[] fArr4 = this.f1650f;
        fArr4[0] = 0.2f;
        fArr4[1] = 0.2f;
        float[] fArr5 = this.f1654j;
        fArr5[0] = 0.001f;
        fArr5[1] = 0.001f;
        aVar.a = 500;
        aVar.b = 500;
    }

    public static float b(float f2, float f3, float f4) {
        return f2 > f4 ? f4 : f2 < f3 ? f3 : f2;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x003e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x003f  */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public final float a(int i2, float f2, float f3, float f4) {
        float f5;
        int i3;
        float f6;
        float b2 = b(this.f1650f[i2] * f3, 0.0f, this.f1651g[i2]);
        float c = c(f3 - f2, b2) - c(f2, b2);
        if (c < 0.0f) {
            f6 = -this.c.getInterpolation(-c);
        } else if (c > 0.0f) {
            f6 = this.c.getInterpolation(c);
        } else {
            f5 = 0.0f;
            i3 = (f5 > 0.0f ? 1 : (f5 == 0.0f ? 0 : -1));
            if (i3 != 0) {
                return 0.0f;
            }
            float f7 = this.f1654j[i2];
            float f8 = this.f1655k[i2];
            float f9 = this.f1656l[i2];
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
        int i2 = this.f1652h;
        if (i2 == 0 || i2 == 1) {
            if (f2 < f3) {
                if (f2 >= 0.0f) {
                    return 1.0f - (f2 / f3);
                }
                if (this.p && i2 == 1) {
                    return 1.0f;
                }
            }
        } else if (i2 == 2 && f2 < 0.0f) {
            return f2 / (-f3);
        }
        return 0.0f;
    }

    public final void d() {
        int i2 = 0;
        if (this.n) {
            this.p = false;
            return;
        }
        C0043a aVar = this.b;
        Objects.requireNonNull(aVar);
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        int i3 = (int) (currentAnimationTimeMillis - aVar.f1658e);
        int i4 = aVar.b;
        if (i3 > i4) {
            i2 = i4;
        } else if (i3 >= 0) {
            i2 = i3;
        }
        aVar.f1664k = i2;
        aVar.f1663j = aVar.a(currentAnimationTimeMillis);
        aVar.f1662i = currentAnimationTimeMillis;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public boolean e() {
        boolean z;
        C0043a aVar = this.b;
        float f2 = aVar.f1657d;
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
                    if (!z) {
                        return true;
                    }
                }
            }
            z = false;
            if (!z) {
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0013, code lost:
        if (r0 != 3) goto L_0x007f;
     */
    @Override // android.view.View.OnTouchListener
    /* Code decompiled incorrectly, please refer to instructions dump */
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
        float a = a(0, motionEvent.getX(), (float) view.getWidth(), (float) this.f1648d.getWidth());
        float a2 = a(1, motionEvent.getY(), (float) view.getHeight(), (float) this.f1648d.getHeight());
        C0043a aVar = this.b;
        aVar.c = a;
        aVar.f1657d = a2;
        if (!this.p && e()) {
            if (this.f1649e == null) {
                this.f1649e = new b();
            }
            this.p = true;
            this.n = true;
            if (this.m || (i2 = this.f1653i) <= 0) {
                this.f1649e.run();
            } else {
                View view2 = this.f1648d;
                Runnable runnable = this.f1649e;
                long j2 = (long) i2;
                AtomicInteger atomicInteger = v.a;
                v.d.n(view2, runnable, j2);
            }
            this.m = true;
        }
        return false;
    }
}
