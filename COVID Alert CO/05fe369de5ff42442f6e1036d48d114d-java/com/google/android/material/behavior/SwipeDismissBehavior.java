package com.google.android.material.behavior;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import e.i.i.m;
import e.i.i.x.b;
import e.k.b.e;
import f.b.a.e.v.p;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class SwipeDismissBehavior<V extends View> extends CoordinatorLayout.c<V> {
    public e a;
    public b b;
    public boolean c;

    /* renamed from: d  reason: collision with root package name */
    public int f500d = 2;

    /* renamed from: e  reason: collision with root package name */
    public float f501e = 0.5f;

    /* renamed from: f  reason: collision with root package name */
    public float f502f = 0.0f;

    /* renamed from: g  reason: collision with root package name */
    public float f503g = 0.5f;

    /* renamed from: h  reason: collision with root package name */
    public final e.c f504h = new a();

    public class a extends e.c {
        public int a;
        public int b = -1;

        public a() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0028, code lost:
            if (r5 != false) goto L_0x001e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:6:0x0012, code lost:
            if (r5 != false) goto L_0x0014;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x001e, code lost:
            r5 = r2.a;
            r3 = r3.getWidth() + r5;
         */
        @Override // e.k.b.e.c
        public int a(View view, int i2, int i3) {
            int i4;
            int i5;
            AtomicInteger atomicInteger = m.a;
            boolean z = view.getLayoutDirection() == 1;
            int i6 = SwipeDismissBehavior.this.f500d;
            if (i6 != 0) {
                if (i6 != 1) {
                    i4 = this.a - view.getWidth();
                    i5 = view.getWidth() + this.a;
                    return Math.min(Math.max(i4, i2), i5);
                }
            }
            i4 = this.a - view.getWidth();
            i5 = this.a;
            return Math.min(Math.max(i4, i2), i5);
        }

        @Override // e.k.b.e.c
        public int b(View view, int i2, int i3) {
            return view.getTop();
        }

        @Override // e.k.b.e.c
        public int c(View view) {
            return view.getWidth();
        }

        @Override // e.k.b.e.c
        public void e(View view, int i2) {
            this.b = i2;
            this.a = view.getLeft();
            ViewParent parent = view.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }

        @Override // e.k.b.e.c
        public void f(int i2) {
            b bVar = SwipeDismissBehavior.this.b;
            if (bVar != null) {
                f.b.a.e.v.m mVar = (f.b.a.e.v.m) bVar;
                Objects.requireNonNull(mVar);
                if (i2 == 0) {
                    p.b().f(mVar.a.n);
                } else if (i2 == 1 || i2 == 2) {
                    p.b().e(mVar.a.n);
                }
            }
        }

        @Override // e.k.b.e.c
        public void g(View view, int i2, int i3, int i4, int i5) {
            float width = (((float) view.getWidth()) * SwipeDismissBehavior.this.f502f) + ((float) this.a);
            float width2 = (((float) view.getWidth()) * SwipeDismissBehavior.this.f503g) + ((float) this.a);
            float f2 = (float) i2;
            if (f2 <= width) {
                view.setAlpha(1.0f);
            } else if (f2 >= width2) {
                view.setAlpha(0.0f);
            } else {
                view.setAlpha(SwipeDismissBehavior.C(0.0f, 1.0f - ((f2 - width) / (width2 - width)), 1.0f));
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0056, code lost:
            if (java.lang.Math.abs(r8.getLeft() - r7.a) >= java.lang.Math.round(((float) r8.getWidth()) * r7.c.f501e)) goto L_0x002c;
         */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x005b  */
        /* JADX WARNING: Removed duplicated region for block: B:28:0x0068  */
        /* JADX WARNING: Removed duplicated region for block: B:31:0x0078  */
        /* JADX WARNING: Removed duplicated region for block: B:32:0x0085  */
        @Override // e.k.b.e.c
        public void h(View view, float f2, float f3) {
            boolean z;
            int i2;
            b bVar;
            this.b = -1;
            int width = view.getWidth();
            boolean z2 = false;
            int i3 = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
            if (i3 != 0) {
                AtomicInteger atomicInteger = m.a;
                boolean z3 = view.getLayoutDirection() == 1;
                int i4 = SwipeDismissBehavior.this.f500d;
                if (i4 != 2) {
                    if (i4 == 0) {
                        z = false;
                        if (z) {
                            int left = view.getLeft();
                            int i5 = this.a;
                            i2 = left < i5 ? i5 - width : i5 + width;
                            z2 = true;
                        } else {
                            i2 = this.a;
                        }
                        if (SwipeDismissBehavior.this.a.t(i2, view.getTop())) {
                            c cVar = new c(view, z2);
                            AtomicInteger atomicInteger2 = m.a;
                            view.postOnAnimation(cVar);
                            return;
                        } else if (z2 && (bVar = SwipeDismissBehavior.this.b) != null) {
                            ((f.b.a.e.v.m) bVar).a(view);
                            return;
                        } else {
                            return;
                        }
                    } else {
                        z = false;
                        if (z) {
                        }
                        if (SwipeDismissBehavior.this.a.t(i2, view.getTop())) {
                        }
                    }
                }
            }
            z = true;
            if (z) {
            }
            if (SwipeDismissBehavior.this.a.t(i2, view.getTop())) {
            }
        }

        @Override // e.k.b.e.c
        public boolean i(View view, int i2) {
            int i3 = this.b;
            return (i3 == -1 || i3 == i2) && SwipeDismissBehavior.this.B(view);
        }
    }

    public interface b {
    }

    public class c implements Runnable {
        public final View b;
        public final boolean c;

        public c(View view, boolean z) {
            this.b = view;
            this.c = z;
        }

        public void run() {
            b bVar;
            e eVar = SwipeDismissBehavior.this.a;
            if (eVar != null && eVar.i(true)) {
                View view = this.b;
                AtomicInteger atomicInteger = m.a;
                view.postOnAnimation(this);
            } else if (this.c && (bVar = SwipeDismissBehavior.this.b) != null) {
                ((f.b.a.e.v.m) bVar).a(this.b);
            }
        }
    }

    public static float C(float f2, float f3, float f4) {
        return Math.min(Math.max(f2, f3), f4);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean A(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        e eVar = this.a;
        if (eVar == null) {
            return false;
        }
        eVar.n(motionEvent);
        return true;
    }

    public boolean B(View view) {
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean j(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        boolean z = this.c;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            z = coordinatorLayout.p(v, (int) motionEvent.getX(), (int) motionEvent.getY());
            this.c = z;
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.c = false;
        }
        if (!z) {
            return false;
        }
        if (this.a == null) {
            this.a = new e(coordinatorLayout.getContext(), coordinatorLayout, this.f504h);
        }
        return this.a.u(motionEvent);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean k(CoordinatorLayout coordinatorLayout, V v, int i2) {
        AtomicInteger atomicInteger = m.a;
        if (v.getImportantForAccessibility() == 0) {
            v.setImportantForAccessibility(1);
            m.n(1048576, v);
            m.k(v, 0);
            if (B(v)) {
                m.o(v, b.a.f1314j, null, new f.b.a.e.c.a(this));
            }
        }
        return false;
    }
}
