package e.k.b;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import e.b.a.m;
import e.e.i;
import e.i.i.l;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class a extends e.i.i.a {
    public static final Rect n = new Rect(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);
    public static final b<e.i.i.w.b> o = new C0040a();
    public static final c<i<e.i.i.w.b>, e.i.i.w.b> p = new b();

    /* renamed from: d  reason: collision with root package name */
    public final Rect f1523d = new Rect();

    /* renamed from: e  reason: collision with root package name */
    public final Rect f1524e = new Rect();

    /* renamed from: f  reason: collision with root package name */
    public final Rect f1525f = new Rect();

    /* renamed from: g  reason: collision with root package name */
    public final int[] f1526g = new int[2];

    /* renamed from: h  reason: collision with root package name */
    public final AccessibilityManager f1527h;

    /* renamed from: i  reason: collision with root package name */
    public final View f1528i;

    /* renamed from: j  reason: collision with root package name */
    public c f1529j;

    /* renamed from: k  reason: collision with root package name */
    public int f1530k = Integer.MIN_VALUE;

    /* renamed from: l  reason: collision with root package name */
    public int f1531l = Integer.MIN_VALUE;
    private int m = Integer.MIN_VALUE;

    /* renamed from: e.k.b.a$a  reason: collision with other inner class name */
    public static class C0040a implements b<e.i.i.w.b> {
        public void a(Object obj, Rect rect) {
            ((e.i.i.w.b) obj).a.getBoundsInParent(rect);
        }
    }

    public static class b implements c<i<e.i.i.w.b>, e.i.i.w.b> {
    }

    public class c extends e.i.i.w.c {
        public c() {
        }

        @Override // e.i.i.w.c
        public e.i.i.w.b a(int i2) {
            return new e.i.i.w.b(AccessibilityNodeInfo.obtain(a.this.q(i2).a));
        }

        @Override // e.i.i.w.c
        public e.i.i.w.b b(int i2) {
            int i3 = i2 == 2 ? a.this.f1530k : a.this.f1531l;
            if (i3 == Integer.MIN_VALUE) {
                return null;
            }
            return new e.i.i.w.b(AccessibilityNodeInfo.obtain(a.this.q(i3).a));
        }

        @Override // e.i.i.w.c
        public boolean c(int i2, int i3, Bundle bundle) {
            int i4;
            a aVar = a.this;
            if (i2 != -1) {
                boolean z = true;
                if (i3 == 1) {
                    return aVar.v(i2);
                }
                if (i3 == 2) {
                    return aVar.k(i2);
                }
                if (i3 != 64) {
                    return i3 != 128 ? aVar.r(i2, i3, bundle) : aVar.j(i2);
                }
                if (!aVar.f1527h.isEnabled() || !aVar.f1527h.isTouchExplorationEnabled() || (i4 = aVar.f1530k) == i2) {
                    z = false;
                } else {
                    if (i4 != Integer.MIN_VALUE) {
                        aVar.j(i4);
                    }
                    aVar.f1530k = i2;
                    aVar.f1528i.invalidate();
                    aVar.w(i2, 32768);
                }
                return z;
            }
            View view = aVar.f1528i;
            AtomicInteger atomicInteger = l.a;
            return view.performAccessibilityAction(i3, bundle);
        }
    }

    public a(View view) {
        if (view != null) {
            this.f1528i = view;
            this.f1527h = (AccessibilityManager) view.getContext().getSystemService("accessibility");
            view.setFocusable(true);
            AtomicInteger atomicInteger = l.a;
            if (view.getImportantForAccessibility() == 0) {
                view.setImportantForAccessibility(1);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("View may not be null");
    }

    @Override // e.i.i.a
    public e.i.i.w.c b(View view) {
        if (this.f1529j == null) {
            this.f1529j = new c();
        }
        return this.f1529j;
    }

    @Override // e.i.i.a
    public void c(View view, AccessibilityEvent accessibilityEvent) {
        this.a.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    @Override // e.i.i.a
    public void d(View view, e.i.i.w.b bVar) {
        this.a.onInitializeAccessibilityNodeInfo(view, bVar.a);
        s(bVar);
    }

    public final boolean j(int i2) {
        if (this.f1530k != i2) {
            return false;
        }
        this.f1530k = Integer.MIN_VALUE;
        this.f1528i.invalidate();
        w(i2, 65536);
        return true;
    }

    public final boolean k(int i2) {
        if (this.f1531l != i2) {
            return false;
        }
        this.f1531l = Integer.MIN_VALUE;
        u(i2, false);
        w(i2, 8);
        return true;
    }

    public final e.i.i.w.b l(int i2) {
        AccessibilityNodeInfo accessibilityNodeInfo;
        AccessibilityNodeInfo obtain = AccessibilityNodeInfo.obtain();
        e.i.i.w.b bVar = new e.i.i.w.b(obtain);
        obtain.setEnabled(true);
        bVar.a.setFocusable(true);
        bVar.a.setClassName("android.view.View");
        Rect rect = n;
        bVar.a.setBoundsInParent(rect);
        bVar.a.setBoundsInScreen(rect);
        View view = this.f1528i;
        bVar.b = -1;
        bVar.a.setParent(view);
        t(i2, bVar);
        if (bVar.g() == null && bVar.e() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
        }
        bVar.a.getBoundsInParent(this.f1524e);
        if (!this.f1524e.equals(rect)) {
            int actions = bVar.a.getActions();
            if ((actions & 64) == 0) {
                int i3 = 128;
                if ((actions & 128) == 0) {
                    bVar.a.setPackageName(this.f1528i.getContext().getPackageName());
                    View view2 = this.f1528i;
                    bVar.c = i2;
                    bVar.a.setSource(view2, i2);
                    boolean z = false;
                    if (this.f1530k == i2) {
                        bVar.a.setAccessibilityFocused(true);
                        accessibilityNodeInfo = bVar.a;
                    } else {
                        bVar.a.setAccessibilityFocused(false);
                        accessibilityNodeInfo = bVar.a;
                        i3 = 64;
                    }
                    accessibilityNodeInfo.addAction(i3);
                    boolean z2 = this.f1531l == i2;
                    if (z2) {
                        bVar.a.addAction(2);
                    } else if (bVar.a.isFocusable()) {
                        bVar.a.addAction(1);
                    }
                    bVar.a.setFocused(z2);
                    this.f1528i.getLocationOnScreen(this.f1526g);
                    bVar.a.getBoundsInScreen(this.f1523d);
                    if (this.f1523d.equals(rect)) {
                        bVar.a.getBoundsInParent(this.f1523d);
                        if (bVar.b != -1) {
                            e.i.i.w.b bVar2 = new e.i.i.w.b(AccessibilityNodeInfo.obtain());
                            for (int i4 = bVar.b; i4 != -1; i4 = bVar2.b) {
                                View view3 = this.f1528i;
                                bVar2.b = -1;
                                bVar2.a.setParent(view3, -1);
                                bVar2.a.setBoundsInParent(n);
                                t(i4, bVar2);
                                bVar2.a.getBoundsInParent(this.f1524e);
                                Rect rect2 = this.f1523d;
                                Rect rect3 = this.f1524e;
                                rect2.offset(rect3.left, rect3.top);
                            }
                            bVar2.a.recycle();
                        }
                        this.f1523d.offset(this.f1526g[0] - this.f1528i.getScrollX(), this.f1526g[1] - this.f1528i.getScrollY());
                    }
                    if (this.f1528i.getLocalVisibleRect(this.f1525f)) {
                        this.f1525f.offset(this.f1526g[0] - this.f1528i.getScrollX(), this.f1526g[1] - this.f1528i.getScrollY());
                        if (this.f1523d.intersect(this.f1525f)) {
                            bVar.a.setBoundsInScreen(this.f1523d);
                            Rect rect4 = this.f1523d;
                            if (rect4 != null && !rect4.isEmpty() && this.f1528i.getWindowVisibility() == 0) {
                                View view4 = this.f1528i;
                                while (true) {
                                    ViewParent parent = view4.getParent();
                                    if (parent instanceof View) {
                                        view4 = (View) parent;
                                        if (view4.getAlpha() > 0.0f) {
                                            if (view4.getVisibility() != 0) {
                                                break;
                                            }
                                        } else {
                                            break;
                                        }
                                    } else if (parent != null) {
                                        z = true;
                                    }
                                }
                            }
                            if (z) {
                                bVar.a.setVisibleToUser(true);
                            }
                        }
                    }
                    return bVar;
                }
                throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
            }
            throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
        }
        throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
    }

    public final boolean m(MotionEvent motionEvent) {
        int i2;
        if (this.f1527h.isEnabled() && this.f1527h.isTouchExplorationEnabled()) {
            int action = motionEvent.getAction();
            if (action == 7 || action == 9) {
                int n2 = n(motionEvent.getX(), motionEvent.getY());
                int i3 = this.m;
                if (i3 != n2) {
                    this.m = n2;
                    w(n2, 128);
                    w(i3, 256);
                }
                if (n2 != Integer.MIN_VALUE) {
                    return true;
                }
            } else if (action != 10 || (i2 = this.m) == Integer.MIN_VALUE) {
                return false;
            } else {
                if (i2 != Integer.MIN_VALUE) {
                    this.m = Integer.MIN_VALUE;
                    w(Integer.MIN_VALUE, 128);
                    w(i2, 256);
                }
                return true;
            }
        }
        return false;
    }

    public abstract int n(float f2, float f3);

    public abstract void o(List<Integer> list);

    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0130, code lost:
        if (r13 < ((r17 * r17) + ((r12 * 13) * r12))) goto L_0x0132;
     */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x013c A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0137  */
    public final boolean p(int i2, Rect rect) {
        e.i.i.w.b bVar;
        int i3;
        Object obj;
        int h2;
        int i4;
        boolean z;
        int i5;
        int i6;
        ArrayList arrayList = new ArrayList();
        o(arrayList);
        i iVar = new i();
        int i7 = 0;
        for (int i8 = 0; i8 < arrayList.size(); i8++) {
            iVar.g(i8, l(i8));
        }
        int i9 = this.f1531l;
        e.i.i.w.b bVar2 = i9 == Integer.MIN_VALUE ? null : (e.i.i.w.b) iVar.d(i9);
        int i10 = -1;
        if (i2 == 1 || i2 == 2) {
            View view = this.f1528i;
            AtomicInteger atomicInteger = l.a;
            boolean z2 = view.getLayoutDirection() == 1;
            c<i<e.i.i.w.b>, e.i.i.w.b> cVar = p;
            b<e.i.i.w.b> bVar3 = o;
            Objects.requireNonNull((b) cVar);
            int h3 = iVar.h();
            ArrayList arrayList2 = new ArrayList(h3);
            for (int i11 = 0; i11 < h3; i11++) {
                if (iVar.b) {
                    iVar.c();
                }
                arrayList2.add((e.i.i.w.b) iVar.f1201d[i11]);
            }
            Collections.sort(arrayList2, new d(z2, bVar3));
            if (i2 == 1) {
                int size = arrayList2.size();
                if (bVar2 != null) {
                    size = arrayList2.indexOf(bVar2);
                }
                int i12 = size - 1;
                if (i12 >= 0) {
                    obj = arrayList2.get(i12);
                    bVar = (e.i.i.w.b) obj;
                }
            } else if (i2 == 2) {
                int size2 = arrayList2.size();
                int lastIndexOf = (bVar2 == null ? -1 : arrayList2.lastIndexOf(bVar2)) + 1;
                if (lastIndexOf < size2) {
                    obj = arrayList2.get(lastIndexOf);
                    bVar = (e.i.i.w.b) obj;
                }
            } else {
                throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD}.");
            }
            obj = null;
            bVar = (e.i.i.w.b) obj;
        } else if (i2 == 17 || i2 == 33 || i2 == 66 || i2 == 130) {
            Rect rect2 = new Rect();
            int i13 = this.f1531l;
            if (i13 != Integer.MIN_VALUE) {
                q(i13).a.getBoundsInParent(rect2);
            } else if (rect != null) {
                rect2.set(rect);
            } else {
                View view2 = this.f1528i;
                int width = view2.getWidth();
                int height = view2.getHeight();
                if (i2 == 17) {
                    rect2.set(width, 0, width, height);
                } else if (i2 == 33) {
                    rect2.set(0, height, width, height);
                } else if (i2 == 66) {
                    rect2.set(-1, 0, -1, height);
                } else if (i2 == 130) {
                    rect2.set(0, -1, width, -1);
                } else {
                    throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                }
            }
            c<i<e.i.i.w.b>, e.i.i.w.b> cVar2 = p;
            b<e.i.i.w.b> bVar4 = o;
            Rect rect3 = new Rect(rect2);
            if (i2 != 17) {
                if (i2 == 33) {
                    i6 = rect2.height() + 1;
                } else if (i2 == 66) {
                    i5 = -(rect2.width() + 1);
                } else if (i2 == 130) {
                    i6 = -(rect2.height() + 1);
                } else {
                    throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                }
                rect3.offset(0, i6);
                Objects.requireNonNull((b) cVar2);
                h2 = iVar.h();
                Rect rect4 = new Rect();
                bVar = null;
                for (i4 = 0; i4 < h2; i4++) {
                    if (iVar.b) {
                        iVar.c();
                    }
                    e.i.i.w.b bVar5 = (e.i.i.w.b) iVar.f1201d[i4];
                    if (bVar5 != bVar2) {
                        ((C0040a) bVar4).a(bVar5, rect4);
                        if (m.h.v0(rect2, rect4, i2)) {
                            if (m.h.v0(rect2, rect3, i2) && !m.h.c(i2, rect2, rect4, rect3)) {
                                if (!m.h.c(i2, rect2, rect3, rect4)) {
                                    int A0 = m.h.A0(i2, rect2, rect4);
                                    int C0 = m.h.C0(i2, rect2, rect4);
                                    int i14 = (C0 * C0) + (A0 * 13 * A0);
                                    int A02 = m.h.A0(i2, rect2, rect3);
                                    int C02 = m.h.C0(i2, rect2, rect3);
                                }
                            }
                            z = true;
                            if (!z) {
                                rect3.set(rect4);
                                bVar = bVar5;
                            }
                        }
                        z = false;
                        if (!z) {
                        }
                    }
                }
            } else {
                i5 = rect2.width() + 1;
            }
            rect3.offset(i5, 0);
            Objects.requireNonNull((b) cVar2);
            h2 = iVar.h();
            Rect rect42 = new Rect();
            bVar = null;
            while (i4 < h2) {
            }
        } else {
            throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD, FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        if (bVar == null) {
            i3 = Integer.MIN_VALUE;
        } else {
            if (iVar.b) {
                iVar.c();
            }
            while (true) {
                if (i7 >= iVar.f1202e) {
                    break;
                } else if (iVar.f1201d[i7] == bVar) {
                    i10 = i7;
                    break;
                } else {
                    i7++;
                }
            }
            i3 = iVar.f(i10);
        }
        return v(i3);
    }

    public e.i.i.w.b q(int i2) {
        if (i2 != -1) {
            return l(i2);
        }
        AccessibilityNodeInfo obtain = AccessibilityNodeInfo.obtain(this.f1528i);
        e.i.i.w.b bVar = new e.i.i.w.b(obtain);
        View view = this.f1528i;
        AtomicInteger atomicInteger = l.a;
        view.onInitializeAccessibilityNodeInfo(obtain);
        ArrayList arrayList = new ArrayList();
        o(arrayList);
        if (bVar.a.getChildCount() <= 0 || arrayList.size() <= 0) {
            int size = arrayList.size();
            for (int i3 = 0; i3 < size; i3++) {
                bVar.a.addChild(this.f1528i, ((Integer) arrayList.get(i3)).intValue());
            }
            return bVar;
        }
        throw new RuntimeException("Views cannot have both real and virtual children");
    }

    public abstract boolean r(int i2, int i3, Bundle bundle);

    public void s(e.i.i.w.b bVar) {
    }

    public abstract void t(int i2, e.i.i.w.b bVar);

    public void u(int i2, boolean z) {
    }

    public final boolean v(int i2) {
        int i3;
        if ((!this.f1528i.isFocused() && !this.f1528i.requestFocus()) || (i3 = this.f1531l) == i2) {
            return false;
        }
        if (i3 != Integer.MIN_VALUE) {
            k(i3);
        }
        this.f1531l = i2;
        u(i2, true);
        w(i2, 8);
        return true;
    }

    public final boolean w(int i2, int i3) {
        ViewParent parent;
        AccessibilityEvent accessibilityEvent;
        if (i2 == Integer.MIN_VALUE || !this.f1527h.isEnabled() || (parent = this.f1528i.getParent()) == null) {
            return false;
        }
        if (i2 != -1) {
            accessibilityEvent = AccessibilityEvent.obtain(i3);
            e.i.i.w.b q = q(i2);
            accessibilityEvent.getText().add(q.g());
            accessibilityEvent.setContentDescription(q.e());
            accessibilityEvent.setScrollable(q.a.isScrollable());
            accessibilityEvent.setPassword(q.a.isPassword());
            accessibilityEvent.setEnabled(q.a.isEnabled());
            accessibilityEvent.setChecked(q.a.isChecked());
            if (!accessibilityEvent.getText().isEmpty() || accessibilityEvent.getContentDescription() != null) {
                accessibilityEvent.setClassName(q.a.getClassName());
                accessibilityEvent.setSource(this.f1528i, i2);
                accessibilityEvent.setPackageName(this.f1528i.getContext().getPackageName());
            } else {
                throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
            }
        } else {
            accessibilityEvent = AccessibilityEvent.obtain(i3);
            this.f1528i.onInitializeAccessibilityEvent(accessibilityEvent);
        }
        return parent.requestSendAccessibilityEvent(this.f1528i, accessibilityEvent);
    }

    public final void x(int i2) {
        int i3 = this.m;
        if (i3 != i2) {
            this.m = i2;
            w(i2, 128);
            w(i3, 256);
        }
    }
}
