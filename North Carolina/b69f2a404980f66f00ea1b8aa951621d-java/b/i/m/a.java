package b.i.m;

import android.content.res.Resources;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.ListView;
import b.i.l.m;
import gov.nc.dhhs.exposurenotification.otpview.OtpView;

public abstract class a implements View.OnTouchListener {
    public static final int r = ViewConfiguration.getTapTimeout();

    /* renamed from: b  reason: collision with root package name */
    public final C0027a f1207b = new C0027a();

    /* renamed from: c  reason: collision with root package name */
    public final Interpolator f1208c = new AccelerateInterpolator();

    /* renamed from: d  reason: collision with root package name */
    public final View f1209d;

    /* renamed from: e  reason: collision with root package name */
    public Runnable f1210e;
    public float[] f = {0.0f, 0.0f};
    public float[] g = {Float.MAX_VALUE, Float.MAX_VALUE};
    public int h;
    public int i;
    public float[] j = {0.0f, 0.0f};
    public float[] k = {0.0f, 0.0f};
    public float[] l = {Float.MAX_VALUE, Float.MAX_VALUE};
    public boolean m;
    public boolean n;
    public boolean o;
    public boolean p;
    public boolean q;

    /* renamed from: b.i.m.a$a  reason: collision with other inner class name */
    public static class C0027a {

        /* renamed from: a  reason: collision with root package name */
        public int f1211a;

        /* renamed from: b  reason: collision with root package name */
        public int f1212b;

        /* renamed from: c  reason: collision with root package name */
        public float f1213c;

        /* renamed from: d  reason: collision with root package name */
        public float f1214d;

        /* renamed from: e  reason: collision with root package name */
        public long f1215e = Long.MIN_VALUE;
        public long f = 0;
        public int g = 0;
        public int h = 0;
        public long i = -1;
        public float j;
        public int k;

        public final float a(long j2) {
            if (j2 < this.f1215e) {
                return 0.0f;
            }
            long j3 = this.i;
            if (j3 < 0 || j2 < j3) {
                return a.b(((float) (j2 - this.f1215e)) / ((float) this.f1211a), 0.0f, 1.0f) * 0.5f;
            }
            float f2 = this.j;
            return (a.b(((float) (j2 - j3)) / ((float) this.k), 0.0f, 1.0f) * f2) + (1.0f - f2);
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
                    C0027a aVar2 = aVar.f1207b;
                    if (aVar2 != null) {
                        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                        aVar2.f1215e = currentAnimationTimeMillis;
                        aVar2.i = -1;
                        aVar2.f = currentAnimationTimeMillis;
                        aVar2.j = 0.5f;
                        aVar2.g = 0;
                        aVar2.h = 0;
                    } else {
                        throw null;
                    }
                }
                C0027a aVar3 = a.this.f1207b;
                if ((aVar3.i > 0 && AnimationUtils.currentAnimationTimeMillis() > aVar3.i + ((long) aVar3.k)) || !a.this.e()) {
                    a.this.p = false;
                    return;
                }
                a aVar4 = a.this;
                if (aVar4.o) {
                    aVar4.o = false;
                    if (aVar4 != null) {
                        long uptimeMillis = SystemClock.uptimeMillis();
                        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                        aVar4.f1209d.onTouchEvent(obtain);
                        obtain.recycle();
                    } else {
                        throw null;
                    }
                }
                if (aVar3.f != 0) {
                    long currentAnimationTimeMillis2 = AnimationUtils.currentAnimationTimeMillis();
                    float a2 = aVar3.a(currentAnimationTimeMillis2);
                    aVar3.f = currentAnimationTimeMillis2;
                    float f = ((float) (currentAnimationTimeMillis2 - aVar3.f)) * ((a2 * 4.0f) + (-4.0f * a2 * a2));
                    aVar3.g = (int) (aVar3.f1213c * f);
                    int i = (int) (f * aVar3.f1214d);
                    aVar3.h = i;
                    ((c) a.this).s.scrollListBy(i);
                    m.M(a.this.f1209d, this);
                    return;
                }
                throw new RuntimeException("Cannot compute scroll delta before calling start()");
            }
        }
    }

    public a(View view) {
        this.f1209d = view;
        float f2 = Resources.getSystem().getDisplayMetrics().density;
        float[] fArr = this.l;
        float f3 = ((float) ((int) ((1575.0f * f2) + 0.5f))) / 1000.0f;
        fArr[0] = f3;
        fArr[1] = f3;
        float[] fArr2 = this.k;
        float f4 = ((float) ((int) ((f2 * 315.0f) + 0.5f))) / 1000.0f;
        fArr2[0] = f4;
        fArr2[1] = f4;
        this.h = 1;
        float[] fArr3 = this.g;
        fArr3[0] = Float.MAX_VALUE;
        fArr3[1] = Float.MAX_VALUE;
        float[] fArr4 = this.f;
        fArr4[0] = 0.2f;
        fArr4[1] = 0.2f;
        float[] fArr5 = this.j;
        fArr5[0] = 0.001f;
        fArr5[1] = 0.001f;
        this.i = r;
        C0027a aVar = this.f1207b;
        aVar.f1211a = OtpView.BLINK;
        aVar.f1212b = OtpView.BLINK;
    }

    public static float b(float f2, float f3, float f4) {
        return f2 > f4 ? f4 : f2 < f3 ? f3 : f2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x003d A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x003e  */
    public final float a(int i2, float f2, float f3, float f4) {
        float f5;
        int i3;
        float f6;
        float b2 = b(this.f[i2] * f3, 0.0f, this.g[i2]);
        float c2 = c(f3 - f2, b2) - c(f2, b2);
        if (c2 < 0.0f) {
            f6 = -this.f1208c.getInterpolation(-c2);
        } else if (c2 > 0.0f) {
            f6 = this.f1208c.getInterpolation(c2);
        } else {
            f5 = 0.0f;
            i3 = (f5 > 0.0f ? 1 : (f5 == 0.0f ? 0 : -1));
            if (i3 != 0) {
                return 0.0f;
            }
            float f7 = this.j[i2];
            float f8 = this.k[i2];
            float f9 = this.l[i2];
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
        int i2 = this.h;
        if (i2 == 0 || i2 == 1) {
            if (f2 < f3) {
                return f2 >= 0.0f ? 1.0f - (f2 / f3) : (!this.p || this.h != 1) ? 0.0f : 1.0f;
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
        C0027a aVar = this.f1207b;
        if (aVar != null) {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            int i3 = (int) (currentAnimationTimeMillis - aVar.f1215e);
            int i4 = aVar.f1212b;
            if (i3 > i4) {
                i2 = i4;
            } else if (i3 >= 0) {
                i2 = i3;
            }
            aVar.k = i2;
            aVar.j = aVar.a(currentAnimationTimeMillis);
            aVar.i = currentAnimationTimeMillis;
            return;
        }
        throw null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    public boolean e() {
        boolean z;
        C0027a aVar = this.f1207b;
        float f2 = aVar.f1214d;
        int abs = (int) (f2 / Math.abs(f2));
        float f3 = aVar.f1213c;
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
                        return true;
                    }
                }
            }
            z = false;
            if (z) {
            }
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0013, code lost:
        if (r0 != 3) goto L_0x007d;
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
        float a2 = a(0, motionEvent.getX(), (float) view.getWidth(), (float) this.f1209d.getWidth());
        float a3 = a(1, motionEvent.getY(), (float) view.getHeight(), (float) this.f1209d.getHeight());
        C0027a aVar = this.f1207b;
        aVar.f1213c = a2;
        aVar.f1214d = a3;
        if (!this.p && e()) {
            if (this.f1210e == null) {
                this.f1210e = new b();
            }
            this.p = true;
            this.n = true;
            if (this.m || (i2 = this.i) <= 0) {
                this.f1210e.run();
            } else {
                m.N(this.f1209d, this.f1210e, (long) i2);
            }
            this.m = true;
        }
        return false;
    }
}
