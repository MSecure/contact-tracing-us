package e.s.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;
import e.i.i.l;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class i extends RecyclerView.l implements RecyclerView.q {
    public static final int[] D = {16842919};
    public static final int[] E = new int[0];
    public int A;
    public final Runnable B;
    public final RecyclerView.r C;
    public final int a;
    public final int b;
    public final StateListDrawable c;

    /* renamed from: d  reason: collision with root package name */
    public final Drawable f1794d;

    /* renamed from: e  reason: collision with root package name */
    public final int f1795e;

    /* renamed from: f  reason: collision with root package name */
    public final int f1796f;

    /* renamed from: g  reason: collision with root package name */
    public final StateListDrawable f1797g;

    /* renamed from: h  reason: collision with root package name */
    public final Drawable f1798h;

    /* renamed from: i  reason: collision with root package name */
    public final int f1799i;

    /* renamed from: j  reason: collision with root package name */
    public final int f1800j;

    /* renamed from: k  reason: collision with root package name */
    public int f1801k;

    /* renamed from: l  reason: collision with root package name */
    public int f1802l;
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
    public final ValueAnimator z;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            i iVar = i.this;
            int i2 = iVar.A;
            if (i2 == 1) {
                iVar.z.cancel();
            } else if (i2 != 2) {
                return;
            }
            iVar.A = 3;
            ValueAnimator valueAnimator = iVar.z;
            valueAnimator.setFloatValues(((Float) valueAnimator.getAnimatedValue()).floatValue(), 0.0f);
            iVar.z.setDuration((long) 500);
            iVar.z.start();
        }
    }

    public class b extends RecyclerView.r {
        public b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.r
        public void b(RecyclerView recyclerView, int i2, int i3) {
            i iVar = i.this;
            int computeHorizontalScrollOffset = recyclerView.computeHorizontalScrollOffset();
            int computeVerticalScrollOffset = recyclerView.computeVerticalScrollOffset();
            int computeVerticalScrollRange = iVar.s.computeVerticalScrollRange();
            int i4 = iVar.r;
            iVar.t = computeVerticalScrollRange - i4 > 0 && i4 >= iVar.a;
            int computeHorizontalScrollRange = iVar.s.computeHorizontalScrollRange();
            int i5 = iVar.q;
            boolean z = computeHorizontalScrollRange - i5 > 0 && i5 >= iVar.a;
            iVar.u = z;
            boolean z2 = iVar.t;
            if (z2 || z) {
                if (z2) {
                    float f2 = (float) i4;
                    iVar.f1802l = (int) ((((f2 / 2.0f) + ((float) computeVerticalScrollOffset)) * f2) / ((float) computeVerticalScrollRange));
                    iVar.f1801k = Math.min(i4, (i4 * i4) / computeVerticalScrollRange);
                }
                if (iVar.u) {
                    float f3 = (float) computeHorizontalScrollOffset;
                    float f4 = (float) i5;
                    iVar.o = (int) ((((f4 / 2.0f) + f3) * f4) / ((float) computeHorizontalScrollRange));
                    iVar.n = Math.min(i5, (i5 * i5) / computeHorizontalScrollRange);
                }
                int i6 = iVar.v;
                if (i6 == 0 || i6 == 1) {
                    iVar.j(1);
                }
            } else if (iVar.v != 0) {
                iVar.j(0);
            }
        }
    }

    public class c extends AnimatorListenerAdapter {
        public boolean a = false;

        public c() {
        }

        public void onAnimationCancel(Animator animator) {
            this.a = true;
        }

        public void onAnimationEnd(Animator animator) {
            if (this.a) {
                this.a = false;
            } else if (((Float) i.this.z.getAnimatedValue()).floatValue() == 0.0f) {
                i iVar = i.this;
                iVar.A = 0;
                iVar.j(0);
            } else {
                i iVar2 = i.this;
                iVar2.A = 2;
                iVar2.s.invalidate();
            }
        }
    }

    public class d implements ValueAnimator.AnimatorUpdateListener {
        public d() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int floatValue = (int) (((Float) valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
            i.this.c.setAlpha(floatValue);
            i.this.f1794d.setAlpha(floatValue);
            i.this.s.invalidate();
        }
    }

    public i(RecyclerView recyclerView, StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2, int i2, int i3, int i4) {
        boolean z2 = false;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.z = ofFloat;
        this.A = 0;
        this.B = new a();
        b bVar = new b();
        this.C = bVar;
        this.c = stateListDrawable;
        this.f1794d = drawable;
        this.f1797g = stateListDrawable2;
        this.f1798h = drawable2;
        this.f1795e = Math.max(i2, stateListDrawable.getIntrinsicWidth());
        this.f1796f = Math.max(i2, drawable.getIntrinsicWidth());
        this.f1799i = Math.max(i2, stateListDrawable2.getIntrinsicWidth());
        this.f1800j = Math.max(i2, drawable2.getIntrinsicWidth());
        this.a = i3;
        this.b = i4;
        stateListDrawable.setAlpha(255);
        drawable.setAlpha(255);
        ofFloat.addListener(new c());
        ofFloat.addUpdateListener(new d());
        RecyclerView recyclerView2 = this.s;
        if (recyclerView2 != recyclerView) {
            if (recyclerView2 != null) {
                RecyclerView.m mVar = recyclerView2.n;
                if (mVar != null) {
                    mVar.d("Cannot remove item decoration during a scroll  or layout");
                }
                recyclerView2.p.remove(this);
                if (recyclerView2.p.isEmpty()) {
                    recyclerView2.setWillNotDraw(recyclerView2.getOverScrollMode() == 2 ? true : z2);
                }
                recyclerView2.Q();
                recyclerView2.requestLayout();
                RecyclerView recyclerView3 = this.s;
                recyclerView3.q.remove(this);
                if (recyclerView3.r == this) {
                    recyclerView3.r = null;
                }
                List<RecyclerView.r> list = this.s.k0;
                if (list != null) {
                    list.remove(bVar);
                }
                f();
            }
            this.s = recyclerView;
            recyclerView.g(this);
            this.s.q.add(this);
            this.s.h(bVar);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.q
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

    @Override // androidx.recyclerview.widget.RecyclerView.q
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
                    int i2 = this.b;
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
                    int i4 = this.b;
                    iArr2[0] = i4;
                    iArr2[1] = this.r - i4;
                    float max2 = Math.max((float) iArr2[0], Math.min((float) iArr2[1], y2));
                    if (Math.abs(((float) this.f1802l) - max2) >= 2.0f) {
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

    @Override // androidx.recyclerview.widget.RecyclerView.q
    public void c(boolean z2) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.l
    public void e(Canvas canvas, RecyclerView recyclerView, RecyclerView.y yVar) {
        if (this.q != this.s.getWidth() || this.r != this.s.getHeight()) {
            this.q = this.s.getWidth();
            this.r = this.s.getHeight();
            j(0);
        } else if (this.A != 0) {
            if (this.t) {
                int i2 = this.q;
                int i3 = this.f1795e;
                int i4 = i2 - i3;
                int i5 = this.f1802l;
                int i6 = this.f1801k;
                int i7 = i5 - (i6 / 2);
                this.c.setBounds(0, 0, i3, i6);
                this.f1794d.setBounds(0, 0, this.f1796f, this.r);
                RecyclerView recyclerView2 = this.s;
                AtomicInteger atomicInteger = l.a;
                boolean z2 = true;
                if (recyclerView2.getLayoutDirection() != 1) {
                    z2 = false;
                }
                if (z2) {
                    this.f1794d.draw(canvas);
                    canvas.translate((float) this.f1795e, (float) i7);
                    canvas.scale(-1.0f, 1.0f);
                    this.c.draw(canvas);
                    canvas.scale(1.0f, 1.0f);
                    i4 = this.f1795e;
                } else {
                    canvas.translate((float) i4, 0.0f);
                    this.f1794d.draw(canvas);
                    canvas.translate(0.0f, (float) i7);
                    this.c.draw(canvas);
                }
                canvas.translate((float) (-i4), (float) (-i7));
            }
            if (this.u) {
                int i8 = this.r;
                int i9 = this.f1799i;
                int i10 = i8 - i9;
                int i11 = this.o;
                int i12 = this.n;
                int i13 = i11 - (i12 / 2);
                this.f1797g.setBounds(0, 0, i12, i9);
                this.f1798h.setBounds(0, 0, this.q, this.f1800j);
                canvas.translate(0.0f, (float) i10);
                this.f1798h.draw(canvas);
                canvas.translate((float) i13, 0.0f);
                this.f1797g.draw(canvas);
                canvas.translate((float) (-i13), (float) (-i10));
            }
        }
    }

    public final void f() {
        this.s.removeCallbacks(this.B);
    }

    public boolean g(float f2, float f3) {
        if (f3 >= ((float) (this.r - this.f1799i))) {
            int i2 = this.o;
            int i3 = this.n;
            return f2 >= ((float) (i2 - (i3 / 2))) && f2 <= ((float) ((i3 / 2) + i2));
        }
    }

    public boolean h(float f2, float f3) {
        RecyclerView recyclerView = this.s;
        AtomicInteger atomicInteger = l.a;
        if (recyclerView.getLayoutDirection() == 1) {
            if (f2 > ((float) (this.f1795e / 2))) {
                return false;
            }
        } else if (f2 < ((float) (this.q - this.f1795e))) {
            return false;
        }
        int i2 = this.f1802l;
        int i3 = this.f1801k / 2;
        if (f3 < ((float) (i2 - i3)) || f3 > ((float) (i3 + i2))) {
            return false;
        }
        return true;
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
            this.c.setState(D);
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
        this.c.setState(E);
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
