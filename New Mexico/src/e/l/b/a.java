package e.l.b;

import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import com.google.android.material.chip.Chip;
import e.b.a.m;
import e.f.i;
import e.j.j.v;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public abstract class a extends e.j.j.c {
    public static final Rect n = new Rect(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);
    public static final b<e.j.j.c0.b> o = new C0046a();
    public static final c<i<e.j.j.c0.b>, e.j.j.c0.b> p = new b();

    /* renamed from: h */
    public final AccessibilityManager f1681h;

    /* renamed from: i */
    public final View f1682i;

    /* renamed from: j */
    public c f1683j;

    /* renamed from: d */
    public final Rect f1677d = new Rect();

    /* renamed from: e */
    public final Rect f1678e = new Rect();

    /* renamed from: f */
    public final Rect f1679f = new Rect();

    /* renamed from: g */
    public final int[] f1680g = new int[2];

    /* renamed from: k */
    public int f1684k = Integer.MIN_VALUE;

    /* renamed from: l */
    public int f1685l = Integer.MIN_VALUE;
    public int m = Integer.MIN_VALUE;

    /* renamed from: e.l.b.a$a */
    /* loaded from: classes.dex */
    public class C0046a implements b<e.j.j.c0.b> {
        public void a(Object obj, Rect rect) {
            ((e.j.j.c0.b) obj).a.getBoundsInParent(rect);
        }
    }

    /* loaded from: classes.dex */
    public class b implements c<i<e.j.j.c0.b>, e.j.j.c0.b> {
    }

    /* loaded from: classes.dex */
    public class c extends e.j.j.c0.c {
        public c() {
            a.this = r1;
        }

        @Override // e.j.j.c0.c
        public e.j.j.c0.b a(int i2) {
            return new e.j.j.c0.b(AccessibilityNodeInfo.obtain(a.this.o(i2).a));
        }

        @Override // e.j.j.c0.c
        public e.j.j.c0.b b(int i2) {
            int i3 = i2 == 2 ? a.this.f1684k : a.this.f1685l;
            if (i3 == Integer.MIN_VALUE) {
                return null;
            }
            return new e.j.j.c0.b(AccessibilityNodeInfo.obtain(a.this.o(i3).a));
        }

        @Override // e.j.j.c0.c
        public boolean c(int i2, int i3, Bundle bundle) {
            int i4;
            a aVar = a.this;
            if (i2 != -1) {
                boolean z = true;
                if (i3 == 1) {
                    return aVar.r(i2);
                }
                if (i3 == 2) {
                    return aVar.k(i2);
                }
                if (i3 != 64) {
                    return i3 != 128 ? aVar.p(i2, i3, bundle) : aVar.j(i2);
                }
                if (!aVar.f1681h.isEnabled() || !aVar.f1681h.isTouchExplorationEnabled() || (i4 = aVar.f1684k) == i2) {
                    z = false;
                } else {
                    if (i4 != Integer.MIN_VALUE) {
                        aVar.j(i4);
                    }
                    aVar.f1684k = i2;
                    aVar.f1682i.invalidate();
                    aVar.s(i2, 32768);
                }
                return z;
            }
            View view = aVar.f1682i;
            AtomicInteger atomicInteger = v.a;
            return v.d.j(view, i3, bundle);
        }
    }

    public a(View view) {
        if (view != null) {
            this.f1682i = view;
            this.f1681h = (AccessibilityManager) view.getContext().getSystemService("accessibility");
            view.setFocusable(true);
            AtomicInteger atomicInteger = v.a;
            if (v.d.c(view) == 0) {
                v.d.s(view, 1);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("View may not be null");
    }

    @Override // e.j.j.c
    public e.j.j.c0.c b(View view) {
        if (this.f1683j == null) {
            this.f1683j = new c();
        }
        return this.f1683j;
    }

    @Override // e.j.j.c
    public void c(View view, AccessibilityEvent accessibilityEvent) {
        this.a.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    @Override // e.j.j.c
    public void d(View view, e.j.j.c0.b bVar) {
        this.a.onInitializeAccessibilityNodeInfo(view, bVar.a);
        Chip.b bVar2 = (Chip.b) this;
        bVar.a.setCheckable(Chip.this.f());
        bVar.a.setClickable(Chip.this.isClickable());
        bVar.a.setClassName(Chip.this.getAccessibilityClassName());
        CharSequence text = Chip.this.getText();
        if (Build.VERSION.SDK_INT >= 23) {
            bVar.a.setText(text);
        } else {
            bVar.a.setContentDescription(text);
        }
    }

    public final boolean j(int i2) {
        if (this.f1684k != i2) {
            return false;
        }
        this.f1684k = Integer.MIN_VALUE;
        this.f1682i.invalidate();
        s(i2, 65536);
        return true;
    }

    public final boolean k(int i2) {
        if (this.f1685l != i2) {
            return false;
        }
        this.f1685l = Integer.MIN_VALUE;
        Chip.b bVar = (Chip.b) this;
        if (i2 == 1) {
            Chip chip = Chip.this;
            chip.n = false;
            chip.refreshDrawableState();
        }
        s(i2, 8);
        return true;
    }

    public final e.j.j.c0.b l(int i2) {
        AccessibilityNodeInfo accessibilityNodeInfo;
        AccessibilityNodeInfo obtain = AccessibilityNodeInfo.obtain();
        e.j.j.c0.b bVar = new e.j.j.c0.b(obtain);
        obtain.setEnabled(true);
        bVar.a.setFocusable(true);
        bVar.a.setClassName("android.view.View");
        Rect rect = n;
        bVar.a.setBoundsInParent(rect);
        bVar.a.setBoundsInScreen(rect);
        View view = this.f1682i;
        bVar.b = -1;
        bVar.a.setParent(view);
        q(i2, bVar);
        if (bVar.g() == null && bVar.e() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
        }
        bVar.a.getBoundsInParent(this.f1678e);
        if (!this.f1678e.equals(rect)) {
            int actions = bVar.a.getActions();
            if ((actions & 64) == 0) {
                int i3 = 128;
                if ((actions & 128) == 0) {
                    bVar.a.setPackageName(this.f1682i.getContext().getPackageName());
                    View view2 = this.f1682i;
                    bVar.c = i2;
                    bVar.a.setSource(view2, i2);
                    boolean z = false;
                    if (this.f1684k == i2) {
                        bVar.a.setAccessibilityFocused(true);
                        accessibilityNodeInfo = bVar.a;
                    } else {
                        bVar.a.setAccessibilityFocused(false);
                        accessibilityNodeInfo = bVar.a;
                        i3 = 64;
                    }
                    accessibilityNodeInfo.addAction(i3);
                    boolean z2 = this.f1685l == i2;
                    if (z2) {
                        bVar.a.addAction(2);
                    } else if (bVar.a.isFocusable()) {
                        bVar.a.addAction(1);
                    }
                    bVar.a.setFocused(z2);
                    this.f1682i.getLocationOnScreen(this.f1680g);
                    bVar.a.getBoundsInScreen(this.f1677d);
                    if (this.f1677d.equals(rect)) {
                        bVar.a.getBoundsInParent(this.f1677d);
                        if (bVar.b != -1) {
                            e.j.j.c0.b bVar2 = new e.j.j.c0.b(AccessibilityNodeInfo.obtain());
                            for (int i4 = bVar.b; i4 != -1; i4 = bVar2.b) {
                                View view3 = this.f1682i;
                                bVar2.b = -1;
                                bVar2.a.setParent(view3, -1);
                                bVar2.a.setBoundsInParent(n);
                                q(i4, bVar2);
                                bVar2.a.getBoundsInParent(this.f1678e);
                                Rect rect2 = this.f1677d;
                                Rect rect3 = this.f1678e;
                                rect2.offset(rect3.left, rect3.top);
                            }
                            bVar2.a.recycle();
                        }
                        this.f1677d.offset(this.f1680g[0] - this.f1682i.getScrollX(), this.f1680g[1] - this.f1682i.getScrollY());
                    }
                    if (this.f1682i.getLocalVisibleRect(this.f1679f)) {
                        this.f1679f.offset(this.f1680g[0] - this.f1682i.getScrollX(), this.f1680g[1] - this.f1682i.getScrollY());
                        if (this.f1677d.intersect(this.f1679f)) {
                            bVar.a.setBoundsInScreen(this.f1677d);
                            Rect rect4 = this.f1677d;
                            if (rect4 != null && !rect4.isEmpty() && this.f1682i.getWindowVisibility() == 0) {
                                View view4 = this.f1682i;
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

    public abstract void m(List<Integer> list);

    /* JADX WARN: Code restructure failed: missing block: B:65:0x0144, code lost:
        if (r13 < ((r17 * r17) + ((r12 * 13) * r12))) goto L_0x0146;
     */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0150 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x014b  */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public final boolean n(int i2, Rect rect) {
        e.j.j.c0.b bVar;
        int i3;
        Object obj;
        int h2;
        int i4;
        boolean z;
        int i5;
        int i6;
        ArrayList arrayList = new ArrayList();
        m(arrayList);
        i iVar = new i();
        int i7 = 0;
        for (int i8 = 0; i8 < arrayList.size(); i8++) {
            iVar.g(((Integer) arrayList.get(i8)).intValue(), l(((Integer) arrayList.get(i8)).intValue()));
        }
        int i9 = this.f1685l;
        e.j.j.c0.b bVar2 = i9 == Integer.MIN_VALUE ? null : (e.j.j.c0.b) iVar.d(i9);
        int i10 = -1;
        if (i2 == 1 || i2 == 2) {
            View view = this.f1682i;
            AtomicInteger atomicInteger = v.a;
            boolean z2 = v.e.d(view) == 1;
            c<i<e.j.j.c0.b>, e.j.j.c0.b> cVar = p;
            b<e.j.j.c0.b> bVar3 = o;
            Objects.requireNonNull((b) cVar);
            int h3 = iVar.h();
            ArrayList arrayList2 = new ArrayList(h3);
            for (int i11 = 0; i11 < h3; i11++) {
                if (iVar.b) {
                    iVar.c();
                }
                arrayList2.add((e.j.j.c0.b) iVar.f1318d[i11]);
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
                    bVar = (e.j.j.c0.b) obj;
                }
                obj = null;
                bVar = (e.j.j.c0.b) obj;
            } else if (i2 == 2) {
                int size2 = arrayList2.size();
                int lastIndexOf = (bVar2 == null ? -1 : arrayList2.lastIndexOf(bVar2)) + 1;
                if (lastIndexOf < size2) {
                    obj = arrayList2.get(lastIndexOf);
                    bVar = (e.j.j.c0.b) obj;
                }
                obj = null;
                bVar = (e.j.j.c0.b) obj;
            } else {
                throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD}.");
            }
        } else if (i2 == 17 || i2 == 33 || i2 == 66 || i2 == 130) {
            Rect rect2 = new Rect();
            int i13 = this.f1685l;
            if (i13 != Integer.MIN_VALUE) {
                o(i13).a.getBoundsInParent(rect2);
            } else if (rect != null) {
                rect2.set(rect);
            } else {
                View view2 = this.f1682i;
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
            c<i<e.j.j.c0.b>, e.j.j.c0.b> cVar2 = p;
            b<e.j.j.c0.b> bVar4 = o;
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
                    e.j.j.c0.b bVar5 = (e.j.j.c0.b) iVar.f1318d[i4];
                    if (bVar5 != bVar2) {
                        ((C0046a) bVar4).a(bVar5, rect4);
                        if (m.e.L0(rect2, rect4, i2)) {
                            if (m.e.L0(rect2, rect3, i2) && !m.e.c(i2, rect2, rect4, rect3)) {
                                if (!m.e.c(i2, rect2, rect3, rect4)) {
                                    int W0 = m.e.W0(i2, rect2, rect4);
                                    int a1 = m.e.a1(i2, rect2, rect4);
                                    int i14 = (a1 * a1) + (W0 * 13 * W0);
                                    int W02 = m.e.W0(i2, rect2, rect3);
                                    int a12 = m.e.a1(i2, rect2, rect3);
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
                if (i7 >= iVar.f1319e) {
                    break;
                } else if (iVar.f1318d[i7] == bVar) {
                    i10 = i7;
                    break;
                } else {
                    i7++;
                }
            }
            i3 = iVar.f(i10);
        }
        return r(i3);
    }

    public e.j.j.c0.b o(int i2) {
        if (i2 != -1) {
            return l(i2);
        }
        AccessibilityNodeInfo obtain = AccessibilityNodeInfo.obtain(this.f1682i);
        e.j.j.c0.b bVar = new e.j.j.c0.b(obtain);
        View view = this.f1682i;
        AtomicInteger atomicInteger = v.a;
        view.onInitializeAccessibilityNodeInfo(obtain);
        ArrayList arrayList = new ArrayList();
        m(arrayList);
        if (bVar.a.getChildCount() <= 0 || arrayList.size() <= 0) {
            int size = arrayList.size();
            for (int i3 = 0; i3 < size; i3++) {
                bVar.a.addChild(this.f1682i, ((Integer) arrayList.get(i3)).intValue());
            }
            return bVar;
        }
        throw new RuntimeException("Views cannot have both real and virtual children");
    }

    public abstract boolean p(int i2, int i3, Bundle bundle);

    public abstract void q(int i2, e.j.j.c0.b bVar);

    public final boolean r(int i2) {
        int i3;
        if ((!this.f1682i.isFocused() && !this.f1682i.requestFocus()) || (i3 = this.f1685l) == i2) {
            return false;
        }
        if (i3 != Integer.MIN_VALUE) {
            k(i3);
        }
        if (i2 == Integer.MIN_VALUE) {
            return false;
        }
        this.f1685l = i2;
        Chip.b bVar = (Chip.b) this;
        if (i2 == 1) {
            Chip chip = Chip.this;
            chip.n = true;
            chip.refreshDrawableState();
        }
        s(i2, 8);
        return true;
    }

    public final boolean s(int i2, int i3) {
        ViewParent parent;
        AccessibilityEvent accessibilityEvent;
        if (i2 == Integer.MIN_VALUE || !this.f1681h.isEnabled() || (parent = this.f1682i.getParent()) == null) {
            return false;
        }
        if (i2 != -1) {
            accessibilityEvent = AccessibilityEvent.obtain(i3);
            e.j.j.c0.b o2 = o(i2);
            accessibilityEvent.getText().add(o2.g());
            accessibilityEvent.setContentDescription(o2.e());
            accessibilityEvent.setScrollable(o2.a.isScrollable());
            accessibilityEvent.setPassword(o2.a.isPassword());
            accessibilityEvent.setEnabled(o2.a.isEnabled());
            accessibilityEvent.setChecked(o2.a.isChecked());
            if (!accessibilityEvent.getText().isEmpty() || accessibilityEvent.getContentDescription() != null) {
                accessibilityEvent.setClassName(o2.a.getClassName());
                accessibilityEvent.setSource(this.f1682i, i2);
                accessibilityEvent.setPackageName(this.f1682i.getContext().getPackageName());
            } else {
                throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
            }
        } else {
            accessibilityEvent = AccessibilityEvent.obtain(i3);
            this.f1682i.onInitializeAccessibilityEvent(accessibilityEvent);
        }
        return parent.requestSendAccessibilityEvent(this.f1682i, accessibilityEvent);
    }
}
