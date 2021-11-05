package b.q.d;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;
import b.i.l.m;
import gov.nc.dhhs.exposurenotification.otpview.OtpView;

public class q extends RecyclerView.n implements RecyclerView.s {
    public static final int[] D = {16842919};
    public static final int[] E = new int[0];
    public int A = 0;
    public final Runnable B = new a();
    public final RecyclerView.t C = new b();

    /* renamed from: a  reason: collision with root package name */
    public final int f1564a;

    /* renamed from: b  reason: collision with root package name */
    public final int f1565b;

    /* renamed from: c  reason: collision with root package name */
    public final StateListDrawable f1566c;

    /* renamed from: d  reason: collision with root package name */
    public final Drawable f1567d;

    /* renamed from: e  reason: collision with root package name */
    public final int f1568e;
    public final int f;
    public final StateListDrawable g;
    public final Drawable h;
    public final int i;
    public final int j;
    public int k;
    public int l;
    public float m;
    public int n;
    public int o;
    public float p;
    public int q = 0;
    public int r = 0;
    public RecyclerView s;
    public boolean t = false;
    public boolean u = false;
    public int v = 0;
    public int w = 0;
    public final int[] x = new int[2];
    public final int[] y = new int[2];
    public final ValueAnimator z = ValueAnimator.ofFloat(0.0f, 1.0f);

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            q qVar = q.this;
            int i = qVar.A;
            if (i == 1) {
                qVar.z.cancel();
            } else if (i != 2) {
                return;
            }
            qVar.A = 3;
            ValueAnimator valueAnimator = qVar.z;
            valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 0.0f);
            qVar.z.setDuration((long) OtpView.BLINK);
            qVar.z.start();
        }
    }

    public class b extends RecyclerView.t {
        public b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.t
        public void b(RecyclerView recyclerView, int i, int i2) {
            q qVar = q.this;
            int computeHorizontalScrollOffset = recyclerView.computeHorizontalScrollOffset();
            int computeVerticalScrollOffset = recyclerView.computeVerticalScrollOffset();
            int computeVerticalScrollRange = qVar.s.computeVerticalScrollRange();
            int i3 = qVar.r;
            qVar.t = computeVerticalScrollRange - i3 > 0 && i3 >= qVar.f1564a;
            int computeHorizontalScrollRange = qVar.s.computeHorizontalScrollRange();
            int i4 = qVar.q;
            boolean z = computeHorizontalScrollRange - i4 > 0 && i4 >= qVar.f1564a;
            qVar.u = z;
            if (qVar.t || z) {
                if (qVar.t) {
                    float f = (float) i3;
                    qVar.l = (int) ((((f / 2.0f) + ((float) computeVerticalScrollOffset)) * f) / ((float) computeVerticalScrollRange));
                    qVar.k = Math.min(i3, (i3 * i3) / computeVerticalScrollRange);
                }
                if (qVar.u) {
                    float f2 = (float) computeHorizontalScrollOffset;
                    float f3 = (float) i4;
                    qVar.o = (int) ((((f3 / 2.0f) + f2) * f3) / ((float) computeHorizontalScrollRange));
                    qVar.n = Math.min(i4, (i4 * i4) / computeHorizontalScrollRange);
                }
                int i5 = qVar.v;
                if (i5 == 0 || i5 == 1) {
                    qVar.j(1);
                }
            } else if (qVar.v != 0) {
                qVar.j(0);
            }
        }
    }

    public class c extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        public boolean f1571a = false;

        public c() {
        }

        public void onAnimationCancel(Animator animator) {
            this.f1571a = true;
        }

        public void onAnimationEnd(Animator animator) {
            if (this.f1571a) {
                this.f1571a = false;
            } else if (((Float) q.this.z.getAnimatedValue()).floatValue() == 0.0f) {
                q qVar = q.this;
                qVar.A = 0;
                qVar.j(0);
            } else {
                q qVar2 = q.this;
                qVar2.A = 2;
                qVar2.s.invalidate();
            }
        }
    }

    public class d implements ValueAnimator.AnimatorUpdateListener {
        public d() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
            q.this.f1566c.setAlpha(floatValue);
            q.this.f1567d.setAlpha(floatValue);
            q.this.s.invalidate();
        }
    }

    public q(RecyclerView recyclerView, StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2, int i2, int i3, int i4) {
        this.f1566c = stateListDrawable;
        this.f1567d = drawable;
        this.g = stateListDrawable2;
        this.h = drawable2;
        this.f1568e = Math.max(i2, stateListDrawable.getIntrinsicWidth());
        this.f = Math.max(i2, drawable.getIntrinsicWidth());
        this.i = Math.max(i2, stateListDrawable2.getIntrinsicWidth());
        this.j = Math.max(i2, drawable2.getIntrinsicWidth());
        this.f1564a = i3;
        this.f1565b = i4;
        this.f1566c.setAlpha(255);
        this.f1567d.setAlpha(255);
        this.z.addListener(new c());
        this.z.addUpdateListener(new d());
        RecyclerView recyclerView2 = this.s;
        if (recyclerView2 != recyclerView) {
            if (recyclerView2 != null) {
                recyclerView2.removeItemDecoration(this);
                this.s.removeOnItemTouchListener(this);
                this.s.removeOnScrollListener(this.C);
                f();
            }
            this.s = recyclerView;
            recyclerView.addItemDecoration(this);
            this.s.addOnItemTouchListener(this);
            this.s.addOnScrollListener(this.C);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.s
    public boolean a(RecyclerView recyclerView, MotionEvent motionEvent) {
        int i2 = this.v;
        if (i2 == 1) {
            boolean h2 = h(motionEvent.getX(), motionEvent.getY());
            boolean g2 = g(motionEvent.getX(), motionEvent.getY());
            if (motionEvent.getAction() == 0 && (h2 || g2)) {
                if (g2) {
                    this.w = 1;
                    this.p = (float) ((int) motionEvent.getX());
                } else if (h2) {
                    this.w = 2;
                    this.m = (float) ((int) motionEvent.getY());
                }
                j(2);
                return true;
            }
        } else if (i2 == 2) {
            return true;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.s
    public void b(RecyclerView recyclerView, MotionEvent motionEvent) {
        if (this.v != 0) {
            if (motionEvent.getAction() == 0) {
                boolean h2 = h(motionEvent.getX(), motionEvent.getY());
                boolean g2 = g(motionEvent.getX(), motionEvent.getY());
                if (h2 || g2) {
                    if (g2) {
                        this.w = 1;
                        this.p = (float) ((int) motionEvent.getX());
                    } else if (h2) {
                        this.w = 2;
                        this.m = (float) ((int) motionEvent.getY());
                    }
                    j(2);
                }
            } else if (motionEvent.getAction() == 1 && this.v == 2) {
                this.m = 0.0f;
                this.p = 0.0f;
                j(1);
                this.w = 0;
            } else if (motionEvent.getAction() == 2 && this.v == 2) {
                k();
                if (this.w == 1) {
                    float x2 = motionEvent.getX();
                    int[] iArr = this.y;
                    int i2 = this.f1565b;
                    iArr[0] = i2;
                    iArr[1] = this.q - i2;
                    float max = Math.max((float) iArr[0], Math.min((float) iArr[1], x2));
                    if (Math.abs(((float) this.o) - max) >= 2.0f) {
                        int i3 = i(this.p, max, iArr, this.s.computeHorizontalScrollRange(), this.s.computeHorizontalScrollOffset(), this.q);
                        if (i3 != 0) {
                            this.s.scrollBy(i3, 0);
                        }
                        this.p = max;
                    }
                }
                if (this.w == 2) {
                    float y2 = motionEvent.getY();
                    int[] iArr2 = this.x;
                    int i4 = this.f1565b;
                    iArr2[0] = i4;
                    iArr2[1] = this.r - i4;
                    float max2 = Math.max((float) iArr2[0], Math.min((float) iArr2[1], y2));
                    if (Math.abs(((float) this.l) - max2) >= 2.0f) {
                        int i5 = i(this.m, max2, iArr2, this.s.computeVerticalScrollRange(), this.s.computeVerticalScrollOffset(), this.r);
                        if (i5 != 0) {
                            this.s.scrollBy(0, i5);
                        }
                        this.m = max2;
                    }
                }
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.s
    public void c(boolean z2) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void e(Canvas canvas, RecyclerView recyclerView, RecyclerView.a0 a0Var) {
        if (this.q != this.s.getWidth() || this.r != this.s.getHeight()) {
            this.q = this.s.getWidth();
            this.r = this.s.getHeight();
            j(0);
        } else if (this.A != 0) {
            if (this.t) {
                int i2 = this.q;
                int i3 = this.f1568e;
                int i4 = i2 - i3;
                int i5 = this.l;
                int i6 = this.k;
                int i7 = i5 - (i6 / 2);
                this.f1566c.setBounds(0, 0, i3, i6);
                this.f1567d.setBounds(0, 0, this.f, this.r);
                boolean z2 = true;
                if (m.o(this.s) != 1) {
                    z2 = false;
                }
                if (z2) {
                    this.f1567d.draw(canvas);
                    canvas.translate((float) this.f1568e, (float) i7);
                    canvas.scale(-1.0f, 1.0f);
                    this.f1566c.draw(canvas);
                    canvas.scale(1.0f, 1.0f);
                    i4 = this.f1568e;
                } else {
                    canvas.translate((float) i4, 0.0f);
                    this.f1567d.draw(canvas);
                    canvas.translate(0.0f, (float) i7);
                    this.f1566c.draw(canvas);
                }
                canvas.translate((float) (-i4), (float) (-i7));
            }
            if (this.u) {
                int i8 = this.r;
                int i9 = this.i;
                int i10 = i8 - i9;
                int i11 = this.o;
                int i12 = this.n;
                int i13 = i11 - (i12 / 2);
                this.g.setBounds(0, 0, i12, i9);
                this.h.setBounds(0, 0, this.q, this.j);
                canvas.translate(0.0f, (float) i10);
                this.h.draw(canvas);
                canvas.translate((float) i13, 0.0f);
                this.g.draw(canvas);
                canvas.translate((float) (-i13), (float) (-i10));
            }
        }
    }

    public final void f() {
        this.s.removeCallbacks(this.B);
    }

    public boolean g(float f2, float f3) {
        if (f3 >= ((float) (this.r - this.i))) {
            int i2 = this.o;
            int i3 = this.n;
            return f2 >= ((float) (i2 - (i3 / 2))) && f2 <= ((float) ((i3 / 2) + i2));
        }
    }

    public boolean h(float f2, float f3) {
        if (m.o(this.s) == 1) {
            if (f2 > ((float) (this.f1568e / 2))) {
                return false;
            }
        } else if (f2 < ((float) (this.q - this.f1568e))) {
            return false;
        }
        int i2 = this.l;
        int i3 = this.k / 2;
        return f3 >= ((float) (i2 - i3)) && f3 <= ((float) (i3 + i2));
    }

    public final int i(float f2, float f3, int[] iArr, int i2, int i3, int i4) {
        int i5 = iArr[1] - iArr[0];
        if (i5 == 0) {
            return 0;
        }
        int i6 = i2 - i4;
        int i7 = (int) (((f3 - f2) / ((float) i5)) * ((float) i6));
        int i8 = i3 + i7;
        if (i8 >= i6 || i8 < 0) {
            return 0;
        }
        return i7;
    }

    public void j(int i2) {
        int i3;
        if (i2 == 2 && this.v != 2) {
            this.f1566c.setState(D);
            f();
        }
        if (i2 == 0) {
            this.s.invalidate();
        } else {
            k();
        }
        if (this.v != 2 || i2 == 2) {
            if (i2 == 1) {
                i3 = 1500;
            }
            this.v = i2;
        }
        this.f1566c.setState(E);
        i3 = 1200;
        f();
        this.s.postDelayed(this.B, (long) i3);
        this.v = i2;
    }

    public void k() {
        int i2 = this.A;
        if (i2 != 0) {
            if (i2 == 3) {
                this.z.cancel();
            } else {
                return;
            }
        }
        this.A = 1;
        ValueAnimator valueAnimator = this.z;
        valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 1.0f);
        this.z.setDuration(500L);
        this.z.setStartDelay(0);
        this.z.start();
    }
}
