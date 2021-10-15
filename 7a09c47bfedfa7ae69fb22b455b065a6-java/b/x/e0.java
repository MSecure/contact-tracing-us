package b.x;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import b.x.i;

public abstract class e0 extends i {
    public static final String[] K = {"android:visibility:visibility", "android:visibility:parent"};
    public int J = 3;

    public static class a extends AnimatorListenerAdapter implements i.d {

        /* renamed from: a  reason: collision with root package name */
        public final View f2675a;

        /* renamed from: b  reason: collision with root package name */
        public final int f2676b;

        /* renamed from: c  reason: collision with root package name */
        public final ViewGroup f2677c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f2678d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f2679e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f2680f = false;

        public a(View view, int i, boolean z) {
            this.f2675a = view;
            this.f2676b = i;
            this.f2677c = (ViewGroup) view.getParent();
            this.f2678d = z;
            g(true);
        }

        @Override // b.x.i.d
        public void a(i iVar) {
            g(false);
        }

        @Override // b.x.i.d
        public void b(i iVar) {
            g(true);
        }

        @Override // b.x.i.d
        public void c(i iVar) {
        }

        @Override // b.x.i.d
        public void d(i iVar) {
        }

        @Override // b.x.i.d
        public void e(i iVar) {
            f();
            iVar.y(this);
        }

        public final void f() {
            if (!this.f2680f) {
                w.f2726a.f(this.f2675a, this.f2676b);
                ViewGroup viewGroup = this.f2677c;
                if (viewGroup != null) {
                    viewGroup.invalidate();
                }
            }
            g(false);
        }

        public final void g(boolean z) {
            ViewGroup viewGroup;
            if (this.f2678d && this.f2679e != z && (viewGroup = this.f2677c) != null) {
                this.f2679e = z;
                s.a(viewGroup, z);
            }
        }

        public void onAnimationCancel(Animator animator) {
            this.f2680f = true;
        }

        public void onAnimationEnd(Animator animator) {
            f();
        }

        public void onAnimationPause(Animator animator) {
            if (!this.f2680f) {
                w.f2726a.f(this.f2675a, this.f2676b);
            }
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationResume(Animator animator) {
            if (!this.f2680f) {
                w.f2726a.f(this.f2675a, 0);
            }
        }

        public void onAnimationStart(Animator animator) {
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public boolean f2681a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f2682b;

        /* renamed from: c  reason: collision with root package name */
        public int f2683c;

        /* renamed from: d  reason: collision with root package name */
        public int f2684d;

        /* renamed from: e  reason: collision with root package name */
        public ViewGroup f2685e;

        /* renamed from: f  reason: collision with root package name */
        public ViewGroup f2686f;
    }

    public final void K(q qVar) {
        qVar.f2712a.put("android:visibility:visibility", Integer.valueOf(qVar.f2713b.getVisibility()));
        qVar.f2712a.put("android:visibility:parent", qVar.f2713b.getParent());
        int[] iArr = new int[2];
        qVar.f2713b.getLocationOnScreen(iArr);
        qVar.f2712a.put("android:visibility:screenLocation", iArr);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0079, code lost:
        if (r9 == 0) goto L_0x008c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0083, code lost:
        if (r0.f2685e == null) goto L_0x008c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0095, code lost:
        if (r0.f2683c == 0) goto L_0x0097;
     */
    public final b L(q qVar, q qVar2) {
        b bVar = new b();
        bVar.f2681a = false;
        bVar.f2682b = false;
        if (qVar == null || !qVar.f2712a.containsKey("android:visibility:visibility")) {
            bVar.f2683c = -1;
            bVar.f2685e = null;
        } else {
            bVar.f2683c = ((Integer) qVar.f2712a.get("android:visibility:visibility")).intValue();
            bVar.f2685e = (ViewGroup) qVar.f2712a.get("android:visibility:parent");
        }
        if (qVar2 == null || !qVar2.f2712a.containsKey("android:visibility:visibility")) {
            bVar.f2684d = -1;
            bVar.f2686f = null;
        } else {
            bVar.f2684d = ((Integer) qVar2.f2712a.get("android:visibility:visibility")).intValue();
            bVar.f2686f = (ViewGroup) qVar2.f2712a.get("android:visibility:parent");
        }
        if (qVar == null || qVar2 == null) {
            if (!(qVar == null && bVar.f2684d == 0)) {
                if (qVar2 == null) {
                }
                return bVar;
            }
        } else if (bVar.f2683c == bVar.f2684d && bVar.f2685e == bVar.f2686f) {
            return bVar;
        } else {
            int i = bVar.f2683c;
            int i2 = bVar.f2684d;
            if (i != i2) {
                if (i != 0) {
                }
                bVar.f2682b = false;
                bVar.f2681a = true;
                return bVar;
            }
            if (bVar.f2686f != null) {
            }
            bVar.f2682b = false;
            bVar.f2681a = true;
            return bVar;
        }
        bVar.f2682b = true;
        bVar.f2681a = true;
        return bVar;
    }

    public abstract Animator M(ViewGroup viewGroup, View view, q qVar, q qVar2);

    @Override // b.x.i
    public void e(q qVar) {
        K(qVar);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00e1, code lost:
        if (r12.w != false) goto L_0x00e3;
     */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00a2  */
    @Override // b.x.i
    public Animator l(ViewGroup viewGroup, q qVar, q qVar2) {
        boolean z;
        View view;
        boolean z2;
        View view2;
        Float f2;
        b L = L(qVar, qVar2);
        Animator animator = null;
        if (L.f2681a && !(L.f2685e == null && L.f2686f == null)) {
            if (!L.f2682b) {
                int i = L.f2684d;
                if ((this.J & 2) == 2 && qVar != null) {
                    View view3 = qVar.f2713b;
                    View view4 = qVar2 != null ? qVar2.f2713b : null;
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
                                            if (!L(s(view6, true), o(view6, true)).f2681a) {
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
                            int[] iArr = (int[]) qVar.f2712a.get("android:visibility:screenLocation");
                            int i2 = iArr[0];
                            int i3 = iArr[1];
                            int[] iArr2 = new int[2];
                            viewGroup.getLocationOnScreen(iArr2);
                            view5.offsetLeftAndRight((i2 - iArr2[0]) - view5.getLeft());
                            view5.offsetTopAndBottom((i3 - iArr2[1]) - view5.getTop());
                            viewGroup.getOverlay().add(view5);
                        }
                        animator = M(viewGroup, view5, qVar, qVar2);
                        if (!z) {
                            if (animator == null) {
                                viewGroup.getOverlay().remove(view5);
                            } else {
                                view3.setTag(f.save_overlay_view, view5);
                                a(new d0(this, viewGroup, view5, view3));
                            }
                        }
                    } else if (view != null) {
                        int visibility = view.getVisibility();
                        w.f2726a.f(view, 0);
                        animator = M(viewGroup, view, qVar, qVar2);
                        if (animator != null) {
                            a aVar = new a(view, i, true);
                            animator.addListener(aVar);
                            animator.addPauseListener(aVar);
                            a(aVar);
                        } else {
                            w.f2726a.f(view, visibility);
                        }
                    }
                }
            } else if ((this.J & 1) != 1 || qVar2 == null) {
                return null;
            } else {
                if (qVar == null) {
                    View view7 = (View) qVar2.f2713b.getParent();
                    if (L(o(view7, false), s(view7, false)).f2681a) {
                        return null;
                    }
                }
                View view8 = qVar2.f2713b;
                c cVar = (c) this;
                float f3 = 0.0f;
                float floatValue = (qVar == null || (f2 = (Float) qVar.f2712a.get("android:fade:transitionAlpha")) == null) ? 0.0f : f2.floatValue();
                if (floatValue != 1.0f) {
                    f3 = floatValue;
                }
                return cVar.N(view8, f3, 1.0f);
            }
        }
        return animator;
    }

    @Override // b.x.i
    public String[] r() {
        return K;
    }

    @Override // b.x.i
    public boolean t(q qVar, q qVar2) {
        if (qVar == null && qVar2 == null) {
            return false;
        }
        if (qVar != null && qVar2 != null && qVar2.f2712a.containsKey("android:visibility:visibility") != qVar.f2712a.containsKey("android:visibility:visibility")) {
            return false;
        }
        b L = L(qVar, qVar2);
        if (L.f2681a) {
            return L.f2683c == 0 || L.f2684d == 0;
        }
        return false;
    }
}
