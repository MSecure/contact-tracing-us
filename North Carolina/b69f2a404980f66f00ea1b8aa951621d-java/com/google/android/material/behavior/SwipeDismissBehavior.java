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
    public e f4457a;

    /* renamed from: b  reason: collision with root package name */
    public b f4458b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f4459c;

    /* renamed from: d  reason: collision with root package name */
    public float f4460d = 0.0f;

    /* renamed from: e  reason: collision with root package name */
    public int f4461e = 2;
    public float f = 0.5f;
    public float g = 0.0f;
    public float h = 0.5f;
    public final e.c i = new a();

    public class a extends e.c {

        /* renamed from: a  reason: collision with root package name */
        public int f4462a;

        /* renamed from: b  reason: collision with root package name */
        public int f4463b = -1;

        public a() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0026, code lost:
            if (r5 != false) goto L_0x001c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:6:0x0010, code lost:
            if (r5 != false) goto L_0x0012;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x001c, code lost:
            r5 = r2.f4462a;
            r3 = r3.getWidth() + r5;
         */
        @Override // b.k.b.e.c
        public int a(View view, int i, int i2) {
            int i3;
            int i4;
            boolean z = m.o(view) == 1;
            int i5 = SwipeDismissBehavior.this.f4461e;
            if (i5 != 0) {
                if (i5 != 1) {
                    i3 = this.f4462a - view.getWidth();
                    i4 = view.getWidth() + this.f4462a;
                    return Math.min(Math.max(i3, i), i4);
                }
            }
            i3 = this.f4462a - view.getWidth();
            i4 = this.f4462a;
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
            this.f4463b = i;
            this.f4462a = view.getLeft();
            ViewParent parent = view.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }

        @Override // b.k.b.e.c
        public void f(int i) {
            b bVar = SwipeDismissBehavior.this.f4458b;
            if (bVar != null) {
                l lVar = (l) bVar;
                if (lVar == null) {
                    throw null;
                } else if (i == 0) {
                    o.b().f(lVar.f3044a.n);
                } else if (i == 1 || i == 2) {
                    o.b().e(lVar.f3044a.n);
                }
            }
        }

        @Override // b.k.b.e.c
        public void g(View view, int i, int i2, int i3, int i4) {
            float width = (((float) view.getWidth()) * SwipeDismissBehavior.this.g) + ((float) this.f4462a);
            float width2 = (((float) view.getWidth()) * SwipeDismissBehavior.this.h) + ((float) this.f4462a);
            float f = (float) i;
            if (f <= width) {
                view.setAlpha(1.0f);
            } else if (f >= width2) {
                view.setAlpha(0.0f);
            } else {
                view.setAlpha(SwipeDismissBehavior.C(0.0f, 1.0f - ((f - width) / (width2 - width)), 1.0f));
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0053, code lost:
            if (java.lang.Math.abs(r8.getLeft() - r7.f4462a) >= java.lang.Math.round(((float) r8.getWidth()) * r7.f4464c.f)) goto L_0x002a;
         */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x0058  */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x0064  */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x0075  */
        /* JADX WARNING: Removed duplicated region for block: B:31:0x0080  */
        @Override // b.k.b.e.c
        public void h(View view, float f, float f2) {
            boolean z;
            int i;
            b bVar;
            this.f4463b = -1;
            int width = view.getWidth();
            int i2 = (f > 0.0f ? 1 : (f == 0.0f ? 0 : -1));
            boolean z2 = true;
            if (i2 != 0) {
                boolean z3 = m.o(view) == 1;
                int i3 = SwipeDismissBehavior.this.f4461e;
                if (i3 != 2) {
                    if (i3 == 0) {
                        z = false;
                        if (z) {
                            int left = view.getLeft();
                            int i4 = this.f4462a;
                            i = left < i4 ? i4 - width : i4 + width;
                        } else {
                            i = this.f4462a;
                            z2 = false;
                        }
                        if (SwipeDismissBehavior.this.f4457a.t(i, view.getTop())) {
                            m.M(view, new c(view, z2));
                            return;
                        } else if (z2 && (bVar = SwipeDismissBehavior.this.f4458b) != null) {
                            ((l) bVar).a(view);
                            return;
                        } else {
                            return;
                        }
                    } else {
                        z = false;
                        if (z) {
                        }
                        if (SwipeDismissBehavior.this.f4457a.t(i, view.getTop())) {
                        }
                    }
                }
            }
            z = true;
            if (z) {
            }
            if (SwipeDismissBehavior.this.f4457a.t(i, view.getTop())) {
            }
        }

        @Override // b.k.b.e.c
        public boolean i(View view, int i) {
            int i2 = this.f4463b;
            return (i2 == -1 || i2 == i) && SwipeDismissBehavior.this.B(view);
        }
    }

    public interface b {
    }

    public class c implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final View f4465b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f4466c;

        public c(View view, boolean z) {
            this.f4465b = view;
            this.f4466c = z;
        }

        public void run() {
            b bVar;
            e eVar = SwipeDismissBehavior.this.f4457a;
            if (eVar != null && eVar.i(true)) {
                m.M(this.f4465b, this);
            } else if (this.f4466c && (bVar = SwipeDismissBehavior.this.f4458b) != null) {
                ((l) bVar).a(this.f4465b);
            }
        }
    }

    public static float C(float f2, float f3, float f4) {
        return Math.min(Math.max(f2, f3), f4);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean A(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        e eVar = this.f4457a;
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
        boolean z = this.f4459c;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            z = coordinatorLayout.l(v, (int) motionEvent.getX(), (int) motionEvent.getY());
            this.f4459c = z;
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.f4459c = false;
        }
        if (!z) {
            return false;
        }
        if (this.f4457a == null) {
            this.f4457a = new e(coordinatorLayout.getContext(), coordinatorLayout, this.i);
        }
        return this.f4457a.u(motionEvent);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean k(CoordinatorLayout coordinatorLayout, V v, int i2) {
        if (m.m(v) != 0) {
            return false;
        }
        v.setImportantForAccessibility(1);
        m.O(v, 1048576);
        if (!B(v)) {
            return false;
        }
        m.Q(v, b.a.j, null, new c.b.a.b.p.a(this));
        return false;
    }
}
