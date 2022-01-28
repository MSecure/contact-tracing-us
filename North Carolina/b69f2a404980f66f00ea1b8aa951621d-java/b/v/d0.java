package b.v;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import b.v.i;

public abstract class d0 extends i {
    public static final String[] K = {"android:visibility:visibility", "android:visibility:parent"};
    public int J = 3;

    public static class a extends AnimatorListenerAdapter implements i.d {

        /* renamed from: a  reason: collision with root package name */
        public final View f1790a;

        /* renamed from: b  reason: collision with root package name */
        public final int f1791b;

        /* renamed from: c  reason: collision with root package name */
        public final ViewGroup f1792c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f1793d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f1794e;
        public boolean f = false;

        public a(View view, int i, boolean z) {
            this.f1790a = view;
            this.f1791b = i;
            this.f1792c = (ViewGroup) view.getParent();
            this.f1793d = z;
            g(true);
        }

        @Override // b.v.i.d
        public void a(i iVar) {
            g(false);
        }

        @Override // b.v.i.d
        public void b(i iVar) {
            g(true);
        }

        @Override // b.v.i.d
        public void c(i iVar) {
        }

        @Override // b.v.i.d
        public void d(i iVar) {
        }

        @Override // b.v.i.d
        public void e(i iVar) {
            f();
            iVar.w(this);
        }

        public final void f() {
            if (!this.f) {
                v.f1832a.f(this.f1790a, this.f1791b);
                ViewGroup viewGroup = this.f1792c;
                if (viewGroup != null) {
                    viewGroup.invalidate();
                }
            }
            g(false);
        }

        public final void g(boolean z) {
            ViewGroup viewGroup;
            if (this.f1793d && this.f1794e != z && (viewGroup = this.f1792c) != null) {
                this.f1794e = z;
                s.a(viewGroup, z);
            }
        }

        public void onAnimationCancel(Animator animator) {
            this.f = true;
        }

        public void onAnimationEnd(Animator animator) {
            f();
        }

        public void onAnimationPause(Animator animator) {
            if (!this.f) {
                v.f1832a.f(this.f1790a, this.f1791b);
            }
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationResume(Animator animator) {
            if (!this.f) {
                v.f1832a.f(this.f1790a, 0);
            }
        }

        public void onAnimationStart(Animator animator) {
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public boolean f1795a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f1796b;

        /* renamed from: c  reason: collision with root package name */
        public int f1797c;

        /* renamed from: d  reason: collision with root package name */
        public int f1798d;

        /* renamed from: e  reason: collision with root package name */
        public ViewGroup f1799e;
        public ViewGroup f;
    }

    public final void I(q qVar) {
        qVar.f1823a.put("android:visibility:visibility", Integer.valueOf(qVar.f1824b.getVisibility()));
        qVar.f1823a.put("android:visibility:parent", qVar.f1824b.getParent());
        int[] iArr = new int[2];
        qVar.f1824b.getLocationOnScreen(iArr);
        qVar.f1823a.put("android:visibility:screenLocation", iArr);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0079, code lost:
        if (r9 == 0) goto L_0x008c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0083, code lost:
        if (r0.f1799e == null) goto L_0x008c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0095, code lost:
        if (r0.f1797c == 0) goto L_0x0097;
     */
    public final b J(q qVar, q qVar2) {
        b bVar = new b();
        bVar.f1795a = false;
        bVar.f1796b = false;
        if (qVar == null || !qVar.f1823a.containsKey("android:visibility:visibility")) {
            bVar.f1797c = -1;
            bVar.f1799e = null;
        } else {
            bVar.f1797c = ((Integer) qVar.f1823a.get("android:visibility:visibility")).intValue();
            bVar.f1799e = (ViewGroup) qVar.f1823a.get("android:visibility:parent");
        }
        if (qVar2 == null || !qVar2.f1823a.containsKey("android:visibility:visibility")) {
            bVar.f1798d = -1;
            bVar.f = null;
        } else {
            bVar.f1798d = ((Integer) qVar2.f1823a.get("android:visibility:visibility")).intValue();
            bVar.f = (ViewGroup) qVar2.f1823a.get("android:visibility:parent");
        }
        if (qVar == null || qVar2 == null) {
            if (!(qVar == null && bVar.f1798d == 0)) {
                if (qVar2 == null) {
                }
                return bVar;
            }
        } else if (bVar.f1797c == bVar.f1798d && bVar.f1799e == bVar.f) {
            return bVar;
        } else {
            int i = bVar.f1797c;
            int i2 = bVar.f1798d;
            if (i != i2) {
                if (i != 0) {
                }
                bVar.f1796b = false;
                bVar.f1795a = true;
                return bVar;
            }
            if (bVar.f != null) {
            }
            bVar.f1796b = false;
            bVar.f1795a = true;
            return bVar;
        }
        bVar.f1796b = true;
        bVar.f1795a = true;
        return bVar;
    }

    public abstract Animator K(ViewGroup viewGroup, View view, q qVar, q qVar2);

    @Override // b.v.i
    public void e(q qVar) {
        I(qVar);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00e1, code lost:
        if (r12.w != false) goto L_0x00e3;
     */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00a2  */
    @Override // b.v.i
    public Animator l(ViewGroup viewGroup, q qVar, q qVar2) {
        boolean z;
        View view;
        boolean z2;
        View view2;
        Float f;
        b J2 = J(qVar, qVar2);
        Animator animator = null;
        if (J2.f1795a && !(J2.f1799e == null && J2.f == null)) {
            if (!J2.f1796b) {
                int i = J2.f1798d;
                if ((this.J & 2) == 2 && qVar != null) {
                    View view3 = qVar.f1824b;
                    View view4 = qVar2 != null ? qVar2.f1824b : null;
                    View view5 = (View) view3.getTag(f.save_overlay_view);
                    if (view5 != null) {
                        view = null;
                        z = true;
                    } else {
                        if (view4 == null || view4.getParent() == null) {
                            if (view4 != null) {
                                view2 = null;
                                z2 = false;
                                if (z2) {
                                    if (view3.getParent() != null) {
                                        if (view3.getParent() instanceof View) {
                                            View view6 = (View) view3.getParent();
                                            if (!J(r(view6, true), o(view6, true)).f1795a) {
                                                view4 = p.a(viewGroup, view3, view6);
                                            } else {
                                                int id = view6.getId();
                                                if (view6.getParent() == null) {
                                                    if (id != -1) {
                                                        if (viewGroup.findViewById(id) != null) {
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    z = false;
                                    view = view2;
                                    view5 = view3;
                                }
                                z = false;
                                view5 = view4;
                                view = view2;
                            }
                        } else if (i == 4 || view3 == view4) {
                            z2 = false;
                            view2 = view4;
                            view4 = null;
                            if (z2) {
                            }
                            z = false;
                            view5 = view4;
                            view = view2;
                        }
                        view4 = null;
                        view2 = null;
                        z2 = true;
                        if (z2) {
                        }
                        z = false;
                        view5 = view4;
                        view = view2;
                    }
                    if (view5 != null) {
                        if (!z) {
                            int[] iArr = (int[]) qVar.f1823a.get("android:visibility:screenLocation");
                            int i2 = iArr[0];
                            int i3 = iArr[1];
                            int[] iArr2 = new int[2];
                            viewGroup.getLocationOnScreen(iArr2);
                            view5.offsetLeftAndRight((i2 - iArr2[0]) - view5.getLeft());
                            view5.offsetTopAndBottom((i3 - iArr2[1]) - view5.getTop());
                            viewGroup.getOverlay().add(view5);
                        }
                        animator = K(viewGroup, view5, qVar, qVar2);
                        if (!z) {
                            if (animator == null) {
                                viewGroup.getOverlay().remove(view5);
                            } else {
                                view3.setTag(f.save_overlay_view, view5);
                                a(new c0(this, viewGroup, view5, view3));
                            }
                        }
                    } else if (view != null) {
                        int visibility = view.getVisibility();
                        v.f1832a.f(view, 0);
                        animator = K(viewGroup, view, qVar, qVar2);
                        if (animator != null) {
                            a aVar = new a(view, i, true);
                            animator.addListener(aVar);
                            animator.addPauseListener(aVar);
                            a(aVar);
                        } else {
                            v.f1832a.f(view, visibility);
                        }
                    }
                }
            } else if ((this.J & 1) != 1 || qVar2 == null) {
                return null;
            } else {
                if (qVar == null) {
                    View view7 = (View) qVar2.f1824b.getParent();
                    if (J(o(view7, false), r(view7, false)).f1795a) {
                        return null;
                    }
                }
                View view8 = qVar2.f1824b;
                c cVar = (c) this;
                float f2 = 0.0f;
                float floatValue = (qVar == null || (f = (Float) qVar.f1823a.get("android:fade:transitionAlpha")) == null) ? 0.0f : f.floatValue();
                if (floatValue != 1.0f) {
                    f2 = floatValue;
                }
                return cVar.L(view8, f2, 1.0f);
            }
        }
        return animator;
    }

    @Override // b.v.i
    public String[] q() {
        return K;
    }

    @Override // b.v.i
    public boolean s(q qVar, q qVar2) {
        if (qVar == null && qVar2 == null) {
            return false;
        }
        if (qVar != null && qVar2 != null && qVar2.f1823a.containsKey("android:visibility:visibility") != qVar.f1823a.containsKey("android:visibility:visibility")) {
            return false;
        }
        b J2 = J(qVar, qVar2);
        if (J2.f1795a) {
            return J2.f1797c == 0 || J2.f1798d == 0;
        }
        return false;
    }
}
