package com.google.android.material.behavior;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import e.j.j.c0.b;
import e.j.j.v;
import e.l.b.e;
import f.b.a.e.w.l;
import f.b.a.e.w.p;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class SwipeDismissBehavior<V extends View> extends CoordinatorLayout.c<V> {
    public e a;
    public b b;
    public boolean c;

    /* renamed from: d */
    public int f508d = 2;

    /* renamed from: e */
    public float f509e = 0.5f;

    /* renamed from: f */
    public float f510f = 0.0f;

    /* renamed from: g */
    public float f511g = 0.5f;

    /* renamed from: h */
    public final e.c f512h = new a();

    /* loaded from: classes.dex */
    public class a extends e.c {
        public int a;
        public int b = -1;

        public a() {
            SwipeDismissBehavior.this = r1;
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x001e, code lost:
            r5 = r2.a;
            r3 = r3.getWidth() + r5;
         */
        /* JADX WARN: Code restructure failed: missing block: B:12:0x0028, code lost:
            if (r5 != false) goto L_0x001e;
         */
        /* JADX WARN: Code restructure failed: missing block: B:8:0x0012, code lost:
            if (r5 != false) goto L_0x0014;
         */
        /* JADX WARN: Code restructure failed: missing block: B:9:0x0014, code lost:
            r5 = r2.a - r3.getWidth();
            r3 = r2.a;
         */
        @Override // e.l.b.e.c
        /* Code decompiled incorrectly, please refer to instructions dump */
        public int a(View view, int i2, int i3) {
            int i4;
            int i5;
            AtomicInteger atomicInteger = v.a;
            boolean z = v.e.d(view) == 1;
            int i6 = SwipeDismissBehavior.this.f508d;
            if (i6 != 0) {
                if (i6 != 1) {
                    i4 = this.a - view.getWidth();
                    i5 = view.getWidth() + this.a;
                }
            }
            return Math.min(Math.max(i4, i2), i5);
        }

        @Override // e.l.b.e.c
        public int b(View view, int i2, int i3) {
            return view.getTop();
        }

        @Override // e.l.b.e.c
        public int c(View view) {
            return view.getWidth();
        }

        @Override // e.l.b.e.c
        public void e(View view, int i2) {
            this.b = i2;
            this.a = view.getLeft();
            ViewParent parent = view.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }

        @Override // e.l.b.e.c
        public void f(int i2) {
            b bVar = SwipeDismissBehavior.this.b;
            if (bVar != null) {
                l lVar = (l) bVar;
                Objects.requireNonNull(lVar);
                if (i2 == 0) {
                    p.b().f(lVar.a.m);
                } else if (i2 == 1 || i2 == 2) {
                    p.b().e(lVar.a.m);
                }
            }
        }

        @Override // e.l.b.e.c
        public void g(View view, int i2, int i3, int i4, int i5) {
            float width = (((float) view.getWidth()) * SwipeDismissBehavior.this.f510f) + ((float) this.a);
            float width2 = (((float) view.getWidth()) * SwipeDismissBehavior.this.f511g) + ((float) this.a);
            float f2 = (float) i2;
            if (f2 <= width) {
                view.setAlpha(1.0f);
            } else if (f2 >= width2) {
                view.setAlpha(0.0f);
            } else {
                view.setAlpha(SwipeDismissBehavior.C(0.0f, 1.0f - ((f2 - width) / (width2 - width)), 1.0f));
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:23:0x0056, code lost:
            if (java.lang.Math.abs(r8.getLeft() - r7.a) >= java.lang.Math.round(((float) r8.getWidth()) * com.google.android.material.behavior.SwipeDismissBehavior.this.f509e)) goto L_0x002c;
         */
        @Override // e.l.b.e.c
        /* Code decompiled incorrectly, please refer to instructions dump */
        public void h(View view, float f2, float f3) {
            boolean z;
            int i2;
            b bVar;
            this.b = -1;
            int width = view.getWidth();
            boolean z2 = false;
            int i3 = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
            if (i3 != 0) {
                AtomicInteger atomicInteger = v.a;
                boolean z3 = v.e.d(view) == 1;
                int i4 = SwipeDismissBehavior.this.f508d;
                if (i4 != 2) {
                    z = i4 == 0 ? false : false;
                }
                z = true;
            }
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
                AtomicInteger atomicInteger2 = v.a;
                v.d.m(view, cVar);
            } else if (z2 && (bVar = SwipeDismissBehavior.this.b) != null) {
                ((l) bVar).a(view);
            }
        }

        @Override // e.l.b.e.c
        public boolean i(View view, int i2) {
            int i3 = this.b;
            return (i3 == -1 || i3 == i2) && SwipeDismissBehavior.this.B(view);
        }
    }

    /* loaded from: classes.dex */
    public interface b {
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public final View b;
        public final boolean c;

        public c(View view, boolean z) {
            SwipeDismissBehavior.this = r1;
            this.b = view;
            this.c = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            b bVar;
            e eVar = SwipeDismissBehavior.this.a;
            if (eVar != null && eVar.i(true)) {
                View view = this.b;
                AtomicInteger atomicInteger = v.a;
                v.d.m(view, this);
            } else if (this.c && (bVar = SwipeDismissBehavior.this.b) != null) {
                ((l) bVar).a(this.b);
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
            this.a = new e(coordinatorLayout.getContext(), coordinatorLayout, this.f512h);
        }
        return this.a.u(motionEvent);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean k(CoordinatorLayout coordinatorLayout, V v, int i2) {
        AtomicInteger atomicInteger = v.a;
        if (v.d.c(v) == 0) {
            v.d.s(v, 1);
            v.r(1048576, v);
            v.m(v, 0);
            if (B(v)) {
                v.s(v, b.a.f1629j, null, new f.b.a.e.c.a(this));
            }
        }
        return false;
    }
}
