package com.google.android.material.behavior;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import b.i.l.m;
import b.i.l.w.b;
import b.k.b.e;
import c.b.a.b.i0.l;
import c.b.a.b.i0.o;

public class SwipeDismissBehavior<V extends View> extends CoordinatorLayout.c<V> {

    /* renamed from: a  reason: collision with root package name */
    public e f6011a;

    /* renamed from: b  reason: collision with root package name */
    public b f6012b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f6013c;

    /* renamed from: d  reason: collision with root package name */
    public float f6014d = 0.0f;

    /* renamed from: e  reason: collision with root package name */
    public int f6015e = 2;

    /* renamed from: f  reason: collision with root package name */
    public float f6016f = 0.5f;

    /* renamed from: g  reason: collision with root package name */
    public float f6017g = 0.0f;
    public float h = 0.5f;
    public final e.c i = new a();

    public class a extends e.c {

        /* renamed from: a  reason: collision with root package name */
        public int f6018a;

        /* renamed from: b  reason: collision with root package name */
        public int f6019b = -1;

        public a() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0026, code lost:
            if (r5 != false) goto L_0x001c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:6:0x0010, code lost:
            if (r5 != false) goto L_0x0012;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x001c, code lost:
            r5 = r2.f6018a;
            r3 = r3.getWidth() + r5;
         */
        @Override // b.k.b.e.c
        public int a(View view, int i, int i2) {
            int i3;
            int i4;
            boolean z = m.p(view) == 1;
            int i5 = SwipeDismissBehavior.this.f6015e;
            if (i5 != 0) {
                if (i5 != 1) {
                    i3 = this.f6018a - view.getWidth();
                    i4 = view.getWidth() + this.f6018a;
                    return Math.min(Math.max(i3, i), i4);
                }
            }
            i3 = this.f6018a - view.getWidth();
            i4 = this.f6018a;
            return Math.min(Math.max(i3, i), i4);
        }

        @Override // b.k.b.e.c
        public int b(View view, int i, int i2) {
            return view.getTop();
        }

        @Override // b.k.b.e.c
        public int c(View view) {
            return view.getWidth();
        }

        @Override // b.k.b.e.c
        public void e(View view, int i) {
            this.f6019b = i;
            this.f6018a = view.getLeft();
            ViewParent parent = view.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }

        @Override // b.k.b.e.c
        public void f(int i) {
            b bVar = SwipeDismissBehavior.this.f6012b;
            if (bVar != null) {
                l lVar = (l) bVar;
                if (lVar == null) {
                    throw null;
                } else if (i == 0) {
                    o.b().f(lVar.f4337a.n);
                } else if (i == 1 || i == 2) {
                    o.b().e(lVar.f4337a.n);
                }
            }
        }

        @Override // b.k.b.e.c
        public void g(View view, int i, int i2, int i3, int i4) {
            float width = (((float) view.getWidth()) * SwipeDismissBehavior.this.f6017g) + ((float) this.f6018a);
            float width2 = (((float) view.getWidth()) * SwipeDismissBehavior.this.h) + ((float) this.f6018a);
            float f2 = (float) i;
            if (f2 <= width) {
                view.setAlpha(1.0f);
            } else if (f2 >= width2) {
                view.setAlpha(0.0f);
            } else {
                view.setAlpha(SwipeDismissBehavior.C(0.0f, 1.0f - ((f2 - width) / (width2 - width)), 1.0f));
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0053, code lost:
            if (java.lang.Math.abs(r8.getLeft() - r7.f6018a) >= java.lang.Math.round(((float) r8.getWidth()) * r7.f6020c.f6016f)) goto L_0x002a;
         */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x0058  */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x0064  */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x0075  */
        /* JADX WARNING: Removed duplicated region for block: B:31:0x0080  */
        @Override // b.k.b.e.c
        public void h(View view, float f2, float f3) {
            boolean z;
            int i;
            b bVar;
            this.f6019b = -1;
            int width = view.getWidth();
            int i2 = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
            boolean z2 = true;
            if (i2 != 0) {
                boolean z3 = m.p(view) == 1;
                int i3 = SwipeDismissBehavior.this.f6015e;
                if (i3 != 2) {
                    if (i3 == 0) {
                        z = false;
                        if (z) {
                            int left = view.getLeft();
                            int i4 = this.f6018a;
                            i = left < i4 ? i4 - width : i4 + width;
                        } else {
                            i = this.f6018a;
                            z2 = false;
                        }
                        if (SwipeDismissBehavior.this.f6011a.t(i, view.getTop())) {
                            m.N(view, new c(view, z2));
                            return;
                        } else if (z2 && (bVar = SwipeDismissBehavior.this.f6012b) != null) {
                            ((l) bVar).a(view);
                            return;
                        } else {
                            return;
                        }
                    } else {
                        z = false;
                        if (z) {
                        }
                        if (SwipeDismissBehavior.this.f6011a.t(i, view.getTop())) {
                        }
                    }
                }
            }
            z = true;
            if (z) {
            }
            if (SwipeDismissBehavior.this.f6011a.t(i, view.getTop())) {
            }
        }

        @Override // b.k.b.e.c
        public boolean i(View view, int i) {
            int i2 = this.f6019b;
            return (i2 == -1 || i2 == i) && SwipeDismissBehavior.this.B(view);
        }
    }

    public interface b {
    }

    public class c implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final View f6021b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f6022c;

        public c(View view, boolean z) {
            this.f6021b = view;
            this.f6022c = z;
        }

        public void run() {
            b bVar;
            e eVar = SwipeDismissBehavior.this.f6011a;
            if (eVar != null && eVar.i(true)) {
                m.N(this.f6021b, this);
            } else if (this.f6022c && (bVar = SwipeDismissBehavior.this.f6012b) != null) {
                ((l) bVar).a(this.f6021b);
            }
        }
    }

    public static float C(float f2, float f3, float f4) {
        return Math.min(Math.max(f2, f3), f4);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean A(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        e eVar = this.f6011a;
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
        boolean z = this.f6013c;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            z = coordinatorLayout.l(v, (int) motionEvent.getX(), (int) motionEvent.getY());
            this.f6013c = z;
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.f6013c = false;
        }
        if (!z) {
            return false;
        }
        if (this.f6011a == null) {
            this.f6011a = new e(coordinatorLayout.getContext(), coordinatorLayout, this.i);
        }
        return this.f6011a.u(motionEvent);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean k(CoordinatorLayout coordinatorLayout, V v, int i2) {
        if (m.n(v) != 0) {
            return false;
        }
        v.setImportantForAccessibility(1);
        m.P(v, 1048576);
        if (!B(v)) {
            return false;
        }
        m.R(v, b.a.j, null, new c.b.a.b.p.a(this));
        return false;
    }
}
