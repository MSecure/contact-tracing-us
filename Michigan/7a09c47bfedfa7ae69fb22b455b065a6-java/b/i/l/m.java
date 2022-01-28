package b.i.l;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import b.i.l.a;
import b.i.l.w.b;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class m {

    /* renamed from: a  reason: collision with root package name */
    public static final AtomicInteger f1867a = new AtomicInteger(1);

    /* renamed from: b  reason: collision with root package name */
    public static WeakHashMap<View, r> f1868b = null;

    /* renamed from: c  reason: collision with root package name */
    public static Field f1869c;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f1870d = false;

    public class a implements View.OnApplyWindowInsetsListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ j f1871a;

        public a(j jVar) {
            this.f1871a = jVar;
        }

        public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
            if (windowInsets != null) {
                return this.f1871a.a(view, new v(windowInsets)).i();
            }
            throw null;
        }
    }

    public static abstract class b<T> {

        /* renamed from: a  reason: collision with root package name */
        public final int f1872a;

        /* renamed from: b  reason: collision with root package name */
        public final Class<T> f1873b;

        /* renamed from: c  reason: collision with root package name */
        public final int f1874c;

        public b(int i, Class<T> cls, int i2) {
            this.f1872a = i;
            this.f1873b = cls;
            this.f1874c = i2;
        }

        public b(int i, Class<T> cls, int i2, int i3) {
            this.f1872a = i;
            this.f1873b = cls;
            this.f1874c = i3;
        }

        public boolean a(Boolean bool, Boolean bool2) {
            return (bool == null ? false : bool.booleanValue()) == (bool2 == null ? false : bool2.booleanValue());
        }

        public abstract T b(View view);

        public abstract void c(View view, T t);

        public T d(View view) {
            if (Build.VERSION.SDK_INT >= this.f1874c) {
                return b(view);
            }
            T t = (T) view.getTag(this.f1872a);
            if (this.f1873b.isInstance(t)) {
                return t;
            }
            return null;
        }

        public abstract boolean e(T t, T t2);
    }

    public interface c {
        boolean a(View view, KeyEvent keyEvent);
    }

    public static class d {

        /* renamed from: d  reason: collision with root package name */
        public static final ArrayList<WeakReference<View>> f1875d = new ArrayList<>();

        /* renamed from: a  reason: collision with root package name */
        public WeakHashMap<View, Boolean> f1876a = null;

        /* renamed from: b  reason: collision with root package name */
        public SparseArray<WeakReference<View>> f1877b = null;

        /* renamed from: c  reason: collision with root package name */
        public WeakReference<KeyEvent> f1878c = null;

        public static d a(View view) {
            d dVar = (d) view.getTag(b.i.b.tag_unhandled_key_event_manager);
            if (dVar != null) {
                return dVar;
            }
            d dVar2 = new d();
            view.setTag(b.i.b.tag_unhandled_key_event_manager, dVar2);
            return dVar2;
        }

        public final View b(View view, KeyEvent keyEvent) {
            WeakHashMap<View, Boolean> weakHashMap = this.f1876a;
            if (weakHashMap != null && weakHashMap.containsKey(view)) {
                if (view instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                        View b2 = b(viewGroup.getChildAt(childCount), keyEvent);
                        if (b2 != null) {
                            return b2;
                        }
                    }
                }
                if (c(view, keyEvent)) {
                    return view;
                }
            }
            return null;
        }

        public final boolean c(View view, KeyEvent keyEvent) {
            ArrayList arrayList = (ArrayList) view.getTag(b.i.b.tag_unhandled_key_listeners);
            if (arrayList == null) {
                return false;
            }
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (((c) arrayList.get(size)).a(view, keyEvent)) {
                    return true;
                }
            }
            return false;
        }
    }

    static {
        new WeakHashMap();
    }

    public static boolean A(View view) {
        return view.hasTransientState();
    }

    public static boolean B(View view) {
        return view.isAttachedToWindow();
    }

    public static boolean C(View view) {
        return view.isLaidOut();
    }

    public static boolean D(View view) {
        return view.isNestedScrollingEnabled();
    }

    public static boolean E(View view) {
        return view.isPaddingRelative();
    }

    public static boolean F(View view) {
        Boolean bool = (Boolean) new n(b.i.b.tag_screen_reader_focusable, Boolean.class, 28).d(view);
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public static void G(View view, int i) {
        if (((AccessibilityManager) view.getContext().getSystemService("accessibility")).isEnabled()) {
            boolean z = ((CharSequence) new o(b.i.b.tag_accessibility_pane_title, CharSequence.class, 8, 28).d(view)) != null;
            if (view.getAccessibilityLiveRegion() != 0 || (z && view.getVisibility() == 0)) {
                AccessibilityEvent obtain = AccessibilityEvent.obtain();
                obtain.setEventType(z ? 32 : 2048);
                obtain.setContentChangeTypes(i);
                view.sendAccessibilityEventUnchecked(obtain);
            } else if (view.getParent() != null) {
                try {
                    view.getParent().notifySubtreeAccessibilityStateChanged(view, view, i);
                } catch (AbstractMethodError unused) {
                    view.getParent().getClass().getSimpleName();
                }
            }
        }
    }

    public static void H(View view, int i) {
        view.offsetLeftAndRight(i);
    }

    public static void I(View view, int i) {
        view.offsetTopAndBottom(i);
    }

    public static v J(View view, v vVar) {
        WindowInsets i = vVar.i();
        if (i == null) {
            return vVar;
        }
        WindowInsets onApplyWindowInsets = view.onApplyWindowInsets(i);
        return !onApplyWindowInsets.equals(i) ? new v(onApplyWindowInsets) : vVar;
    }

    public static void K(View view, b.i.l.w.b bVar) {
        view.onInitializeAccessibilityNodeInfo(bVar.f1906a);
    }

    public static boolean L(View view, int i, Bundle bundle) {
        return view.performAccessibilityAction(i, bundle);
    }

    public static void M(View view) {
        view.postInvalidateOnAnimation();
    }

    public static void N(View view, Runnable runnable) {
        view.postOnAnimation(runnable);
    }

    public static void O(View view, Runnable runnable, long j) {
        view.postOnAnimationDelayed(runnable, j);
    }

    public static void P(View view, int i) {
        Q(i, view);
        G(view, 0);
    }

    public static void Q(int i, View view) {
        ArrayList arrayList = (ArrayList) view.getTag(b.i.b.tag_accessibility_actions);
        if (arrayList == null) {
            arrayList = new ArrayList();
            view.setTag(b.i.b.tag_accessibility_actions, arrayList);
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            if (((b.a) arrayList.get(i2)).a() == i) {
                arrayList.remove(i2);
                return;
            }
        }
    }

    public static void R(View view, b.a aVar, CharSequence charSequence, b.i.l.w.d dVar) {
        b.a aVar2 = new b.a(null, aVar.f1913b, null, dVar, aVar.f1914c);
        a g2 = g(view);
        if (g2 == null) {
            g2 = new a();
        }
        U(view, g2);
        Q(aVar2.a(), view);
        ArrayList arrayList = (ArrayList) view.getTag(b.i.b.tag_accessibility_actions);
        if (arrayList == null) {
            arrayList = new ArrayList();
            view.setTag(b.i.b.tag_accessibility_actions, arrayList);
        }
        arrayList.add(aVar2);
        G(view, 0);
    }

    public static void S(View view) {
        view.requestApplyInsets();
    }

    public static void T(View view, @SuppressLint({"ContextFirst"}) Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i, int i2) {
        if (Build.VERSION.SDK_INT >= 29) {
            view.saveAttributeDataForStyleable(context, iArr, attributeSet, typedArray, i, i2);
        }
    }

    public static void U(View view, a aVar) {
        if (aVar == null && (h(view) instanceof a.C0035a)) {
            aVar = new a();
        }
        view.setAccessibilityDelegate(aVar == null ? null : aVar.f1848b);
    }

    public static void V(View view, boolean z) {
        p pVar = new p(b.i.b.tag_accessibility_heading, Boolean.class, 28);
        Boolean valueOf = Boolean.valueOf(z);
        if (Build.VERSION.SDK_INT >= pVar.f1874c) {
            pVar.c(view, valueOf);
        } else if (pVar.e(pVar.d(view), valueOf)) {
            a g2 = g(view);
            if (g2 == null) {
                g2 = new a();
            }
            U(view, g2);
            view.setTag(pVar.f1872a, valueOf);
            G(view, 0);
        }
    }

    public static void W(View view, int i) {
        view.setAccessibilityLiveRegion(i);
    }

    public static void X(View view, Drawable drawable) {
        view.setBackground(drawable);
    }

    public static void Y(View view, Rect rect) {
        view.setClipBounds(rect);
    }

    public static void Z(View view, float f2) {
        view.setElevation(f2);
    }

    public static r a(View view) {
        if (f1868b == null) {
            f1868b = new WeakHashMap<>();
        }
        r rVar = f1868b.get(view);
        if (rVar != null) {
            return rVar;
        }
        r rVar2 = new r(view);
        f1868b.put(view, rVar2);
        return rVar2;
    }

    public static void a0(View view, boolean z) {
        view.setHasTransientState(z);
    }

    public static v b(View view, v vVar, Rect rect) {
        WindowInsets i = vVar.i();
        if (i != null) {
            return v.j(view.computeSystemWindowInsets(i, rect));
        }
        rect.setEmpty();
        return vVar;
    }

    public static void b0(View view, int i) {
        view.setImportantForAccessibility(i);
    }

    public static v c(View view, v vVar) {
        WindowInsets i = vVar.i();
        return (i == null || view.dispatchApplyWindowInsets(i).equals(i)) ? vVar : new v(i);
    }

    public static void c0(View view, j jVar) {
        if (jVar == null) {
            view.setOnApplyWindowInsetsListener(null);
        } else {
            view.setOnApplyWindowInsetsListener(new a(jVar));
        }
    }

    public static boolean d(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        d a2 = d.a(view);
        if (keyEvent.getAction() == 0) {
            WeakHashMap<View, Boolean> weakHashMap = a2.f1876a;
            if (weakHashMap != null) {
                weakHashMap.clear();
            }
            if (!d.f1875d.isEmpty()) {
                synchronized (d.f1875d) {
                    if (a2.f1876a == null) {
                        a2.f1876a = new WeakHashMap<>();
                    }
                    int size = d.f1875d.size();
                    while (true) {
                        size--;
                        if (size < 0) {
                            break;
                        }
                        View view2 = d.f1875d.get(size).get();
                        if (view2 == null) {
                            d.f1875d.remove(size);
                        } else {
                            a2.f1876a.put(view2, Boolean.TRUE);
                            for (ViewParent parent = view2.getParent(); parent instanceof View; parent = parent.getParent()) {
                                a2.f1876a.put((View) parent, Boolean.TRUE);
                            }
                        }
                    }
                }
            }
        }
        View b2 = a2.b(view, keyEvent);
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (b2 != null && !KeyEvent.isModifierKey(keyCode)) {
                if (a2.f1877b == null) {
                    a2.f1877b = new SparseArray<>();
                }
                a2.f1877b.put(keyCode, new WeakReference<>(b2));
            }
        }
        if (b2 != null) {
            return true;
        }
        return false;
    }

    public static void d0(View view, int i, int i2, int i3, int i4) {
        view.setPaddingRelative(i, i2, i3, i4);
    }

    public static boolean e(View view, KeyEvent keyEvent) {
        int indexOfKey;
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        d a2 = d.a(view);
        WeakReference<KeyEvent> weakReference = a2.f1878c;
        if (weakReference != null && weakReference.get() == keyEvent) {
            return false;
        }
        a2.f1878c = new WeakReference<>(keyEvent);
        WeakReference<View> weakReference2 = null;
        if (a2.f1877b == null) {
            a2.f1877b = new SparseArray<>();
        }
        SparseArray<WeakReference<View>> sparseArray = a2.f1877b;
        if (keyEvent.getAction() == 1 && (indexOfKey = sparseArray.indexOfKey(keyEvent.getKeyCode())) >= 0) {
            weakReference2 = sparseArray.valueAt(indexOfKey);
            sparseArray.removeAt(indexOfKey);
        }
        if (weakReference2 == null) {
            weakReference2 = sparseArray.get(keyEvent.getKeyCode());
        }
        if (weakReference2 == null) {
            return false;
        }
        View view2 = weakReference2.get();
        if (view2 != null && view2.isAttachedToWindow()) {
            a2.c(view2, keyEvent);
        }
        return true;
    }

    public static void e0(View view, int i, int i2) {
        view.setScrollIndicators(i, i2);
    }

    public static int f() {
        return View.generateViewId();
    }

    public static void f0(View view, String str) {
        view.setTransitionName(str);
    }

    public static a g(View view) {
        View.AccessibilityDelegate h = h(view);
        if (h == null) {
            return null;
        }
        return h instanceof a.C0035a ? ((a.C0035a) h).f1849a : new a(h);
    }

    public static void g0(View view) {
        view.stopNestedScroll();
    }

    public static View.AccessibilityDelegate h(View view) {
        if (Build.VERSION.SDK_INT >= 29) {
            return view.getAccessibilityDelegate();
        }
        if (f1870d) {
            return null;
        }
        if (f1869c == null) {
            try {
                Field declaredField = View.class.getDeclaredField("mAccessibilityDelegate");
                f1869c = declaredField;
                declaredField.setAccessible(true);
            } catch (Throwable unused) {
                f1870d = true;
                return null;
            }
        }
        Object obj = f1869c.get(view);
        if (obj instanceof View.AccessibilityDelegate) {
            return (View.AccessibilityDelegate) obj;
        }
        return null;
    }

    public static ColorStateList i(View view) {
        return view.getBackgroundTintList();
    }

    public static Rect j(View view) {
        return view.getClipBounds();
    }

    public static Display k(View view) {
        return view.getDisplay();
    }

    public static float l(View view) {
        return view.getElevation();
    }

    public static boolean m(View view) {
        return view.getFitsSystemWindows();
    }

    public static int n(View view) {
        return view.getImportantForAccessibility();
    }

    @SuppressLint({"InlinedApi"})
    public static int o(View view) {
        if (Build.VERSION.SDK_INT >= 26) {
            return view.getImportantForAutofill();
        }
        return 0;
    }

    public static int p(View view) {
        return view.getLayoutDirection();
    }

    public static int q(View view) {
        return view.getMinimumHeight();
    }

    public static int r(View view) {
        return view.getMinimumWidth();
    }

    public static int s(View view) {
        return view.getPaddingEnd();
    }

    public static int t(View view) {
        return view.getPaddingStart();
    }

    public static v u(View view) {
        return v.j(view.getRootWindowInsets());
    }

    public static String v(View view) {
        return view.getTransitionName();
    }

    public static int w(View view) {
        return view.getWindowSystemUiVisibility();
    }

    public static float x(View view) {
        return view.getZ();
    }

    public static boolean y(View view) {
        return view.hasOnClickListeners();
    }

    public static boolean z(View view) {
        return view.hasOverlappingRendering();
    }
}
