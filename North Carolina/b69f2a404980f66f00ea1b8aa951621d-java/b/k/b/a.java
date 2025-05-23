package b.k.b;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.recyclerview.widget.RecyclerView;
import b.b.k.i;
import b.e.i;
import b.i.l.m;
import com.google.android.material.chip.Chip;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class a extends b.i.l.a {
    public static final Rect n = new Rect(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);
    public static final b<b.i.l.w.b> o = new C0030a();
    public static final c<i<b.i.l.w.b>, b.i.l.w.b> p = new b();

    /* renamed from: d  reason: collision with root package name */
    public final Rect f1232d = new Rect();

    /* renamed from: e  reason: collision with root package name */
    public final Rect f1233e = new Rect();
    public final Rect f = new Rect();
    public final int[] g = new int[2];
    public final AccessibilityManager h;
    public final View i;
    public c j;
    public int k = Integer.MIN_VALUE;
    public int l = Integer.MIN_VALUE;
    public int m = Integer.MIN_VALUE;

    /* renamed from: b.k.b.a$a  reason: collision with other inner class name */
    public static class C0030a implements b<b.i.l.w.b> {
        public void a(Object obj, Rect rect) {
            ((b.i.l.w.b) obj).f1195a.getBoundsInParent(rect);
        }
    }

    public static class b implements c<i<b.i.l.w.b>, b.i.l.w.b> {
    }

    public class c extends b.i.l.w.c {
        public c() {
        }

        @Override // b.i.l.w.c
        public b.i.l.w.b a(int i) {
            return new b.i.l.w.b(AccessibilityNodeInfo.obtain(a.this.o(i).f1195a));
        }

        @Override // b.i.l.w.c
        public b.i.l.w.b b(int i) {
            int i2 = i == 2 ? a.this.k : a.this.l;
            if (i2 == Integer.MIN_VALUE) {
                return null;
            }
            return new b.i.l.w.b(AccessibilityNodeInfo.obtain(a.this.o(i2).f1195a));
        }

        @Override // b.i.l.w.c
        public boolean c(int i, int i2, Bundle bundle) {
            int i3;
            a aVar = a.this;
            if (i == -1) {
                return m.K(aVar.i, i2, bundle);
            }
            boolean z = true;
            if (i2 == 1) {
                return aVar.r(i);
            }
            if (i2 == 2) {
                return aVar.k(i);
            }
            if (i2 != 64) {
                return i2 != 128 ? aVar.p(i, i2, bundle) : aVar.j(i);
            }
            if (!aVar.h.isEnabled() || !aVar.h.isTouchExplorationEnabled() || (i3 = aVar.k) == i) {
                z = false;
            } else {
                if (i3 != Integer.MIN_VALUE) {
                    aVar.j(i3);
                }
                aVar.k = i;
                aVar.i.invalidate();
                aVar.s(i, 32768);
            }
            return z;
        }
    }

    public a(View view) {
        if (view != null) {
            this.i = view;
            this.h = (AccessibilityManager) view.getContext().getSystemService("accessibility");
            view.setFocusable(true);
            if (m.m(view) == 0) {
                view.setImportantForAccessibility(1);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("View may not be null");
    }

    @Override // b.i.l.a
    public b.i.l.w.c b(View view) {
        if (this.j == null) {
            this.j = new c();
        }
        return this.j;
    }

    @Override // b.i.l.a
    public void c(View view, AccessibilityEvent accessibilityEvent) {
        this.f1139a.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    @Override // b.i.l.a
    public void d(View view, b.i.l.w.b bVar) {
        this.f1139a.onInitializeAccessibilityNodeInfo(view, bVar.f1195a);
        Chip.b bVar2 = (Chip.b) this;
        bVar.f1195a.setCheckable(Chip.this.g());
        bVar.f1195a.setClickable(Chip.this.isClickable());
        if (Chip.this.g() || Chip.this.isClickable()) {
            bVar.f1195a.setClassName(Chip.this.g() ? "android.widget.CompoundButton" : "android.widget.Button");
        } else {
            bVar.f1195a.setClassName("android.view.View");
        }
        bVar.f1195a.setText(Chip.this.getText());
    }

    public final boolean j(int i2) {
        if (this.k != i2) {
            return false;
        }
        this.k = Integer.MIN_VALUE;
        this.i.invalidate();
        s(i2, 65536);
        return true;
    }

    public final boolean k(int i2) {
        if (this.l != i2) {
            return false;
        }
        this.l = Integer.MIN_VALUE;
        Chip.b bVar = (Chip.b) this;
        if (i2 == 1) {
            Chip chip = Chip.this;
            chip.m = false;
            chip.refreshDrawableState();
        }
        s(i2, 8);
        return true;
    }

    public final b.i.l.w.b l(int i2) {
        AccessibilityNodeInfo accessibilityNodeInfo;
        b.i.l.w.b bVar = new b.i.l.w.b(AccessibilityNodeInfo.obtain());
        bVar.f1195a.setEnabled(true);
        bVar.f1195a.setFocusable(true);
        bVar.f1195a.setClassName("android.view.View");
        bVar.f1195a.setBoundsInParent(n);
        bVar.f1195a.setBoundsInScreen(n);
        View view = this.i;
        bVar.f1196b = -1;
        bVar.f1195a.setParent(view);
        q(i2, bVar);
        if (bVar.g() == null && bVar.e() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
        }
        bVar.f1195a.getBoundsInParent(this.f1233e);
        if (!this.f1233e.equals(n)) {
            int actions = bVar.f1195a.getActions();
            if ((actions & 64) == 0) {
                int i3 = RecyclerView.d0.FLAG_IGNORE;
                if ((actions & RecyclerView.d0.FLAG_IGNORE) == 0) {
                    bVar.f1195a.setPackageName(this.i.getContext().getPackageName());
                    View view2 = this.i;
                    bVar.f1197c = i2;
                    bVar.f1195a.setSource(view2, i2);
                    boolean z = false;
                    if (this.k == i2) {
                        bVar.f1195a.setAccessibilityFocused(true);
                        accessibilityNodeInfo = bVar.f1195a;
                    } else {
                        bVar.f1195a.setAccessibilityFocused(false);
                        accessibilityNodeInfo = bVar.f1195a;
                        i3 = 64;
                    }
                    accessibilityNodeInfo.addAction(i3);
                    boolean z2 = this.l == i2;
                    if (z2) {
                        bVar.f1195a.addAction(2);
                    } else if (bVar.f1195a.isFocusable()) {
                        bVar.f1195a.addAction(1);
                    }
                    bVar.f1195a.setFocused(z2);
                    this.i.getLocationOnScreen(this.g);
                    bVar.f1195a.getBoundsInScreen(this.f1232d);
                    if (this.f1232d.equals(n)) {
                        bVar.f1195a.getBoundsInParent(this.f1232d);
                        if (bVar.f1196b != -1) {
                            b.i.l.w.b bVar2 = new b.i.l.w.b(AccessibilityNodeInfo.obtain());
                            for (int i4 = bVar.f1196b; i4 != -1; i4 = bVar2.f1196b) {
                                View view3 = this.i;
                                bVar2.f1196b = -1;
                                bVar2.f1195a.setParent(view3, -1);
                                bVar2.f1195a.setBoundsInParent(n);
                                q(i4, bVar2);
                                bVar2.f1195a.getBoundsInParent(this.f1233e);
                                Rect rect = this.f1232d;
                                Rect rect2 = this.f1233e;
                                rect.offset(rect2.left, rect2.top);
                            }
                            bVar2.f1195a.recycle();
                        }
                        this.f1232d.offset(this.g[0] - this.i.getScrollX(), this.g[1] - this.i.getScrollY());
                    }
                    if (this.i.getLocalVisibleRect(this.f)) {
                        this.f.offset(this.g[0] - this.i.getScrollX(), this.g[1] - this.i.getScrollY());
                        if (this.f1232d.intersect(this.f)) {
                            bVar.f1195a.setBoundsInScreen(this.f1232d);
                            Rect rect3 = this.f1232d;
                            if (rect3 != null && !rect3.isEmpty() && this.i.getWindowVisibility() == 0) {
                                View view4 = this.i;
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
                                bVar.f1195a.setVisibleToUser(true);
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

    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0130, code lost:
        if (r13 < ((r17 * r17) + ((r12 * 13) * r12))) goto L_0x0132;
     */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x013c A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00d1  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0137  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x013f  */
    public final boolean n(int i2, Rect rect) {
        b.i.l.w.b bVar;
        int i3;
        Object obj;
        boolean z;
        int i4;
        int i5;
        ArrayList arrayList = new ArrayList();
        m(arrayList);
        i iVar = new i(10);
        int i6 = 0;
        for (int i7 = 0; i7 < arrayList.size(); i7++) {
            iVar.g(i7, l(i7));
        }
        int i8 = this.l;
        b.i.l.w.b bVar2 = i8 == Integer.MIN_VALUE ? null : (b.i.l.w.b) iVar.d(i8);
        int i9 = -1;
        if (i2 == 1 || i2 == 2) {
            boolean z2 = m.o(this.i) == 1;
            c<i<b.i.l.w.b>, b.i.l.w.b> cVar = p;
            b<b.i.l.w.b> bVar3 = o;
            if (((b) cVar) != null) {
                int i10 = iVar.i();
                ArrayList arrayList2 = new ArrayList(i10);
                for (int i11 = 0; i11 < i10; i11++) {
                    if (iVar.f830b) {
                        iVar.c();
                    }
                    arrayList2.add((b.i.l.w.b) iVar.f832d[i11]);
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
                        bVar = (b.i.l.w.b) obj;
                    }
                } else if (i2 == 2) {
                    int size2 = arrayList2.size();
                    int lastIndexOf = (bVar2 == null ? -1 : arrayList2.lastIndexOf(bVar2)) + 1;
                    if (lastIndexOf < size2) {
                        obj = arrayList2.get(lastIndexOf);
                        bVar = (b.i.l.w.b) obj;
                    }
                } else {
                    throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD}.");
                }
                obj = null;
                bVar = (b.i.l.w.b) obj;
            } else {
                throw null;
            }
        } else if (i2 == 17 || i2 == 33 || i2 == 66 || i2 == 130) {
            Rect rect2 = new Rect();
            int i13 = this.l;
            if (i13 != Integer.MIN_VALUE) {
                o(i13).f1195a.getBoundsInParent(rect2);
            } else if (rect != null) {
                rect2.set(rect);
            } else {
                View view = this.i;
                int width = view.getWidth();
                int height = view.getHeight();
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
            c<i<b.i.l.w.b>, b.i.l.w.b> cVar2 = p;
            b<b.i.l.w.b> bVar4 = o;
            Rect rect3 = new Rect(rect2);
            if (i2 != 17) {
                if (i2 == 33) {
                    i5 = rect2.height() + 1;
                } else if (i2 == 66) {
                    i4 = -(rect2.width() + 1);
                } else if (i2 == 130) {
                    i5 = -(rect2.height() + 1);
                } else {
                    throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                }
                rect3.offset(0, i5);
                if (((b) cVar2) == null) {
                    int i14 = iVar.i();
                    Rect rect4 = new Rect();
                    bVar = null;
                    for (int i15 = 0; i15 < i14; i15++) {
                        if (iVar.f830b) {
                            iVar.c();
                        }
                        b.i.l.w.b bVar5 = (b.i.l.w.b) iVar.f832d[i15];
                        if (bVar5 != bVar2) {
                            ((C0030a) bVar4).a(bVar5, rect4);
                            if (i.j.u0(rect2, rect4, i2)) {
                                if (i.j.u0(rect2, rect3, i2) && !i.j.c(i2, rect2, rect4, rect3)) {
                                    if (!i.j.c(i2, rect2, rect3, rect4)) {
                                        int z0 = i.j.z0(i2, rect2, rect4);
                                        int A0 = i.j.A0(i2, rect2, rect4);
                                        int i16 = (A0 * A0) + (z0 * 13 * z0);
                                        int z02 = i.j.z0(i2, rect2, rect3);
                                        int A02 = i.j.A0(i2, rect2, rect3);
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
                    throw null;
                }
            } else {
                i4 = rect2.width() + 1;
            }
            rect3.offset(i4, 0);
            if (((b) cVar2) == null) {
            }
        } else {
            throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD, FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        if (bVar == null) {
            i3 = Integer.MIN_VALUE;
        } else {
            if (iVar.f830b) {
                iVar.c();
            }
            while (true) {
                if (i6 >= iVar.f833e) {
                    break;
                } else if (iVar.f832d[i6] == bVar) {
                    i9 = i6;
                    break;
                } else {
                    i6++;
                }
            }
            i3 = iVar.f(i9);
        }
        return r(i3);
    }

    public b.i.l.w.b o(int i2) {
        if (i2 != -1) {
            return l(i2);
        }
        b.i.l.w.b bVar = new b.i.l.w.b(AccessibilityNodeInfo.obtain(this.i));
        m.J(this.i, bVar);
        ArrayList arrayList = new ArrayList();
        m(arrayList);
        if (bVar.f1195a.getChildCount() <= 0 || arrayList.size() <= 0) {
            int size = arrayList.size();
            for (int i3 = 0; i3 < size; i3++) {
                bVar.f1195a.addChild(this.i, ((Integer) arrayList.get(i3)).intValue());
            }
            return bVar;
        }
        throw new RuntimeException("Views cannot have both real and virtual children");
    }

    public abstract boolean p(int i2, int i3, Bundle bundle);

    public abstract void q(int i2, b.i.l.w.b bVar);

    public final boolean r(int i2) {
        int i3;
        if ((!this.i.isFocused() && !this.i.requestFocus()) || (i3 = this.l) == i2) {
            return false;
        }
        if (i3 != Integer.MIN_VALUE) {
            k(i3);
        }
        this.l = i2;
        Chip.b bVar = (Chip.b) this;
        if (i2 == 1) {
            Chip chip = Chip.this;
            chip.m = true;
            chip.refreshDrawableState();
        }
        s(i2, 8);
        return true;
    }

    public final boolean s(int i2, int i3) {
        ViewParent parent;
        AccessibilityEvent accessibilityEvent;
        if (i2 == Integer.MIN_VALUE || !this.h.isEnabled() || (parent = this.i.getParent()) == null) {
            return false;
        }
        if (i2 != -1) {
            accessibilityEvent = AccessibilityEvent.obtain(i3);
            b.i.l.w.b o2 = o(i2);
            accessibilityEvent.getText().add(o2.g());
            accessibilityEvent.setContentDescription(o2.e());
            accessibilityEvent.setScrollable(o2.f1195a.isScrollable());
            accessibilityEvent.setPassword(o2.f1195a.isPassword());
            accessibilityEvent.setEnabled(o2.f1195a.isEnabled());
            accessibilityEvent.setChecked(o2.f1195a.isChecked());
            if (!accessibilityEvent.getText().isEmpty() || accessibilityEvent.getContentDescription() != null) {
                accessibilityEvent.setClassName(o2.f1195a.getClassName());
                accessibilityEvent.setSource(this.i, i2);
                accessibilityEvent.setPackageName(this.i.getContext().getPackageName());
            } else {
                throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
            }
        } else {
            accessibilityEvent = AccessibilityEvent.obtain(i3);
            this.i.onInitializeAccessibilityEvent(accessibilityEvent);
        }
        return parent.requestSendAccessibilityEvent(this.i, accessibilityEvent);
    }

    public final void t(int i2) {
        int i3 = this.m;
        if (i3 != i2) {
            this.m = i2;
            s(i2, RecyclerView.d0.FLAG_IGNORE);
            s(i3, RecyclerView.d0.FLAG_TMP_DETACHED);
        }
    }
}
