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
    public static WeakHashMap<View, r> f1159a = null;

    /* renamed from: b  reason: collision with root package name */
    public static Field f1160b;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f1161c = false;

    public class a implements View.OnApplyWindowInsetsListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ j f1162a;

        public a(j jVar) {
            this.f1162a = jVar;
        }

        public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
            if (windowInsets != null) {
                return this.f1162a.a(view, new v(windowInsets)).j();
            }
            throw null;
        }
    }

    public static abstract class b<T> {

        /* renamed from: a  reason: collision with root package name */
        public final int f1163a;

        /* renamed from: b  reason: collision with root package name */
        public final Class<T> f1164b;

        /* renamed from: c  reason: collision with root package name */
        public final int f1165c;

        public b(int i, Class<T> cls, int i2) {
            this.f1163a = i;
            this.f1164b = cls;
            this.f1165c = i2;
        }

        public b(int i, Class<T> cls, int i2, int i3) {
            this.f1163a = i;
            this.f1164b = cls;
            this.f1165c = i3;
        }

        public boolean a(Boolean bool, Boolean bool2) {
            return (bool == null ? false : bool.booleanValue()) == (bool2 == null ? false : bool2.booleanValue());
        }

        public abstract T b(View view);

        public abstract void c(View view, T t);

        public T d(View view) {
            if (Build.VERSION.SDK_INT >= this.f1165c) {
                return b(view);
            }
            T t = (T) view.getTag(this.f1163a);
            if (this.f1164b.isInstance(t)) {
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
        public static final ArrayList<WeakReference<View>> f1166d = new ArrayList<>();

        /* renamed from: a  reason: collision with root package name */
        public WeakHashMap<View, Boolean> f1167a = null;

        /* renamed from: b  reason: collision with root package name */
        public SparseArray<WeakReference<View>> f1168b = null;

        /* renamed from: c  reason: collision with root package name */
        public WeakReference<KeyEvent> f1169c = null;

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
            WeakHashMap<View, Boolean> weakHashMap = this.f1167a;
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
        new AtomicInteger(1);
        new WeakHashMap();
    }

    public static boolean A(View view) {
        return view.isAttachedToWindow();
    }

    public static boolean B(View view) {
        return view.isLaidOut();
    }

    public static boolean C(View view) {
        return view.isNestedScrollingEnabled();
    }

    public static boolean D(View view) {
        return view.isPaddingRelative();
    }

    public static boolean E(View view) {
        Boolean bool = (Boolean) new n(b.i.b.tag_screen_reader_focusable, Boolean.class, 28).d(view);
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public static void F(View view, int i) {
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

    public static void G(View view, int i) {
        view.offsetLeftAndRight(i);
    }

    public static void H(View view, int i) {
        view.offsetTopAndBottom(i);
    }

    public static v I(View view, v vVar) {
        WindowInsets j = vVar.j();
        if (j == null) {
            return vVar;
        }
        WindowInsets onApplyWindowInsets = view.onApplyWindowInsets(j);
        return !onApplyWindowInsets.equals(j) ? new v(onApplyWindowInsets) : vVar;
    }

    public static void J(View view, b.i.l.w.b bVar) {
        view.onInitializeAccessibilityNodeInfo(bVar.f1195a);
    }

    public static boolean K(View view, int i, Bundle bundle) {
        return view.performAccessibilityAction(i, bundle);
    }

    public static void L(View view) {
        view.postInvalidateOnAnimation();
    }

    public static void M(View view, Runnable runnable) {
        view.postOnAnimation(runnable);
    }

    public static void N(View view, Runnable runnable, long j) {
        view.postOnAnimationDelayed(runnable, j);
    }

    public static void O(View view, int i) {
        P(i, view);
        F(view, 0);
    }

    public static void P(int i, View view) {
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

    public static void Q(View view, b.a aVar, CharSequence charSequence, b.i.l.w.d dVar) {
        b.a aVar2 = new b.a(null, aVar.f1200b, null, dVar, aVar.f1201c);
        a f = f(view);
        if (f == null) {
            f = new a();
        }
        T(view, f);
        P(aVar2.a(), view);
        ArrayList arrayList = (ArrayList) view.getTag(b.i.b.tag_accessibility_actions);
        if (arrayList == null) {
            arrayList = new ArrayList();
            view.setTag(b.i.b.tag_accessibility_actions, arrayList);
        }
        arrayList.add(aVar2);
        F(view, 0);
    }

    public static void R(View view) {
        view.requestApplyInsets();
    }

    public static void S(View view, @SuppressLint({"ContextFirst"}) Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i, int i2) {
        if (Build.VERSION.SDK_INT >= 29) {
            view.saveAttributeDataForStyleable(context, iArr, attributeSet, typedArray, i, i2);
        }
    }

    public static void T(View view, a aVar) {
        if (aVar == null && (g(view) instanceof a.C0025a)) {
            aVar = new a();
        }
        view.setAccessibilityDelegate(aVar == null ? null : aVar.f1140b);
    }

    public static void U(View view, boolean z) {
        p pVar = new p(b.i.b.tag_accessibility_heading, Boolean.class, 28);
        Boolean valueOf = Boolean.valueOf(z);
        if (Build.VERSION.SDK_INT >= pVar.f1165c) {
            pVar.c(view, valueOf);
        } else if (pVar.e(pVar.d(view), valueOf)) {
            a f = f(view);
            if (f == null) {
                f = new a();
            }
            T(view, f);
            view.setTag(pVar.f1163a, valueOf);
            F(view, 0);
        }
    }

    public static void V(View view, int i) {
        view.setAccessibilityLiveRegion(i);
    }

    public static void W(View view, Drawable drawable) {
        view.setBackground(drawable);
    }

    public static void X(View view, Rect rect) {
        view.setClipBounds(rect);
    }

    public static void Y(View view, float f) {
        view.setElevation(f);
    }

    public static void Z(View view, boolean z) {
        view.setHasTransientState(z);
    }

    public static r a(View view) {
        if (f1159a == null) {
            f1159a = new WeakHashMap<>();
        }
        r rVar = f1159a.get(view);
        if (rVar != null) {
            return rVar;
        }
        r rVar2 = new r(view);
        f1159a.put(view, rVar2);
        return rVar2;
    }

    public static void a0(View view, int i) {
        view.setImportantForAccessibility(i);
    }

    public static v b(View view, v vVar, Rect rect) {
        WindowInsets j = vVar.j();
        if (j != null) {
            return v.k(view.computeSystemWindowInsets(j, rect));
        }
        rect.setEmpty();
        return vVar;
    }

    public static void b0(View view, j jVar) {
        if (jVar == null) {
            view.setOnApplyWindowInsetsListener(null);
        } else {
            view.setOnApplyWindowInsetsListener(new a(jVar));
        }
    }

    public static v c(View view, v vVar) {
        WindowInsets j = vVar.j();
        return (j == null || view.dispatchApplyWindowInsets(j).equals(j)) ? vVar : new v(j);
    }

    public static void c0(View view, int i, int i2, int i3, int i4) {
        view.setPaddingRelative(i, i2, i3, i4);
    }

    public static boolean d(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        d a2 = d.a(view);
        if (keyEvent.getAction() == 0) {
            WeakHashMap<View, Boolean> weakHashMap = a2.f1167a;
            if (weakHashMap != null) {
                weakHashMap.clear();
            }
            if (!d.f1166d.isEmpty()) {
                synchronized (d.f1166d) {
                    if (a2.f1167a == null) {
                        a2.f1167a = new WeakHashMap<>();
                    }
                    int size = d.f1166d.size();
                    while (true) {
                        size--;
                        if (size < 0) {
                            break;
                        }
                        View view2 = d.f1166d.get(size).get();
                        if (view2 == null) {
                            d.f1166d.remove(size);
                        } else {
                            a2.f1167a.put(view2, Boolean.TRUE);
                            for (ViewParent parent = view2.getParent(); parent instanceof View; parent = parent.getParent()) {
                                a2.f1167a.put((View) parent, Boolean.TRUE);
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
                if (a2.f1168b == null) {
                    a2.f1168b = new SparseArray<>();
                }
                a2.f1168b.put(keyCode, new WeakReference<>(b2));
            }
        }
        if (b2 != null) {
            return true;
        }
        return false;
    }

    public static void d0(View view, int i, int i2) {
        view.setScrollIndicators(i, i2);
    }

    public static boolean e(View view, KeyEvent keyEvent) {
        int indexOfKey;
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        d a2 = d.a(view);
        WeakReference<KeyEvent> weakReference = a2.f1169c;
        if (weakReference != null && weakReference.get() == keyEvent) {
            return false;
        }
        a2.f1169c = new WeakReference<>(keyEvent);
        WeakReference<View> weakReference2 = null;
        if (a2.f1168b == null) {
            a2.f1168b = new SparseArray<>();
        }
        SparseArray<WeakReference<View>> sparseArray = a2.f1168b;
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

    public static void e0(View view, String str) {
        view.setTransitionName(str);
    }

    public static a f(View view) {
        View.AccessibilityDelegate g = g(view);
        if (g == null) {
            return null;
        }
        return g instanceof a.C0025a ? ((a.C0025a) g).f1141a : new a(g);
    }

    public static void f0(View view) {
        view.stopNestedScroll();
    }

    public static View.AccessibilityDelegate g(View view) {
        if (Build.VERSION.SDK_INT >= 29) {
            return view.getAccessibilityDelegate();
        }
        if (f1161c) {
            return null;
        }
        if (f1160b == null) {
            try {
                Field declaredField = View.class.getDeclaredField("mAccessibilityDelegate");
                f1160b = declaredField;
                declaredField.setAccessible(true);
            } catch (Throwable unused) {
                f1161c = true;
                return null;
            }
        }
        Object obj = f1160b.get(view);
        if (obj instanceof View.AccessibilityDelegate) {
            return (View.AccessibilityDelegate) obj;
        }
        return null;
    }

    public static ColorStateList h(View view) {
        return view.getBackgroundTintList();
    }

    public static Rect i(View view) {
        return view.getClipBounds();
    }

    public static Display j(View view) {
        return view.getDisplay();
    }

    public static float k(View view) {
        return view.getElevation();
    }

    public static boolean l(View view) {
        return view.getFitsSystemWindows();
    }

    public static int m(View view) {
        return view.getImportantForAccessibility();
    }

    @SuppressLint({"InlinedApi"})
    public static int n(View view) {
        if (Build.VERSION.SDK_INT >= 26) {
            return view.getImportantForAutofill();
        }
        return 0;
    }

    public static int o(View view) {
        return view.getLayoutDirection();
    }

    public static int p(View view) {
        return view.getMinimumHeight();
    }

    public static int q(View view) {
        return view.getMinimumWidth();
    }

    public static int r(View view) {
        return view.getPaddingEnd();
    }

    public static int s(View view) {
        return view.getPaddingStart();
    }

    public static v t(View view) {
        return v.k(view.getRootWindowInsets());
    }

    public static String u(View view) {
        return view.getTransitionName();
    }

    public static int v(View view) {
        return view.getWindowSystemUiVisibility();
    }

    public static float w(View view) {
        return view.getZ();
    }

    public static boolean x(View view) {
        return view.hasOnClickListeners();
    }

    public static boolean y(View view) {
        return view.hasOverlappingRendering();
    }

    public static boolean z(View view) {
        return view.hasTransientState();
    }
}
