package e.i.i;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import androidx.core.R$id;
import e.i.i.a;
import e.i.i.x.b;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class m {
    public static final AtomicInteger a = new AtomicInteger(1);
    public static WeakHashMap<View, s> b = null;
    public static Field c;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f1481d = false;

    /* renamed from: e  reason: collision with root package name */
    public static ThreadLocal<Rect> f1482e;

    /* renamed from: f  reason: collision with root package name */
    public static final int[] f1483f = {R$id.accessibility_custom_action_0, R$id.accessibility_custom_action_1, R$id.accessibility_custom_action_2, R$id.accessibility_custom_action_3, R$id.accessibility_custom_action_4, R$id.accessibility_custom_action_5, R$id.accessibility_custom_action_6, R$id.accessibility_custom_action_7, R$id.accessibility_custom_action_8, R$id.accessibility_custom_action_9, R$id.accessibility_custom_action_10, R$id.accessibility_custom_action_11, R$id.accessibility_custom_action_12, R$id.accessibility_custom_action_13, R$id.accessibility_custom_action_14, R$id.accessibility_custom_action_15, R$id.accessibility_custom_action_16, R$id.accessibility_custom_action_17, R$id.accessibility_custom_action_18, R$id.accessibility_custom_action_19, R$id.accessibility_custom_action_20, R$id.accessibility_custom_action_21, R$id.accessibility_custom_action_22, R$id.accessibility_custom_action_23, R$id.accessibility_custom_action_24, R$id.accessibility_custom_action_25, R$id.accessibility_custom_action_26, R$id.accessibility_custom_action_27, R$id.accessibility_custom_action_28, R$id.accessibility_custom_action_29, R$id.accessibility_custom_action_30, R$id.accessibility_custom_action_31};

    public class a implements View.OnApplyWindowInsetsListener {
        public final /* synthetic */ k a;

        public a(k kVar) {
            this.a = kVar;
        }

        public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
            return this.a.a(view, w.h(windowInsets, view)).f();
        }
    }

    public static abstract class b<T> {
        public final int a;
        public final Class<T> b;
        public final int c;

        /* renamed from: d  reason: collision with root package name */
        public final int f1484d;

        public b(int i2, Class<T> cls, int i3) {
            this.a = i2;
            this.b = cls;
            this.f1484d = 0;
            this.c = i3;
        }

        public b(int i2, Class<T> cls, int i3, int i4) {
            this.a = i2;
            this.b = cls;
            this.f1484d = i3;
            this.c = i4;
        }

        public boolean a(Boolean bool, Boolean bool2) {
            return (bool == null ? false : bool.booleanValue()) == (bool2 == null ? false : bool2.booleanValue());
        }

        public abstract T b(View view);

        public T c(View view) {
            if (Build.VERSION.SDK_INT >= this.c) {
                return b(view);
            }
            T t = (T) view.getTag(this.a);
            if (this.b.isInstance(t)) {
                return t;
            }
            return null;
        }
    }

    public interface c {
        boolean a(View view, KeyEvent keyEvent);
    }

    public static class d {

        /* renamed from: d  reason: collision with root package name */
        public static final ArrayList<WeakReference<View>> f1485d = new ArrayList<>();
        public WeakHashMap<View, Boolean> a = null;
        public SparseArray<WeakReference<View>> b = null;
        public WeakReference<KeyEvent> c = null;

        public final View a(View view, KeyEvent keyEvent) {
            WeakHashMap<View, Boolean> weakHashMap = this.a;
            if (weakHashMap != null && weakHashMap.containsKey(view)) {
                if (view instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                        View a2 = a(viewGroup.getChildAt(childCount), keyEvent);
                        if (a2 != null) {
                            return a2;
                        }
                    }
                }
                if (b(view, keyEvent)) {
                    return view;
                }
            }
            return null;
        }

        public final boolean b(View view, KeyEvent keyEvent) {
            ArrayList arrayList = (ArrayList) view.getTag(R$id.tag_unhandled_key_listeners);
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

    public static void a(View view, b.a aVar) {
        a f2 = f(view);
        if (f2 == null) {
            f2 = new a();
        }
        r(view, f2);
        o(aVar.a(), view);
        h(view).add(aVar);
        k(view, 0);
    }

    public static s b(View view) {
        if (b == null) {
            b = new WeakHashMap<>();
        }
        s sVar = b.get(view);
        if (sVar != null) {
            return sVar;
        }
        s sVar2 = new s(view);
        b.put(view, sVar2);
        return sVar2;
    }

    public static void c(View view, int i2) {
        view.offsetLeftAndRight(i2);
        if (view.getVisibility() == 0) {
            float translationY = view.getTranslationY();
            view.setTranslationY(1.0f + translationY);
            view.setTranslationY(translationY);
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                t((View) parent);
            }
        }
    }

    public static void d(View view, int i2) {
        view.offsetTopAndBottom(i2);
        if (view.getVisibility() == 0) {
            float translationY = view.getTranslationY();
            view.setTranslationY(1.0f + translationY);
            view.setTranslationY(translationY);
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                t((View) parent);
            }
        }
    }

    public static boolean e(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        ArrayList<WeakReference<View>> arrayList = d.f1485d;
        int i2 = R$id.tag_unhandled_key_event_manager;
        d dVar = (d) view.getTag(i2);
        if (dVar == null) {
            dVar = new d();
            view.setTag(i2, dVar);
        }
        if (keyEvent.getAction() == 0) {
            Boolean bool = Boolean.TRUE;
            WeakHashMap<View, Boolean> weakHashMap = dVar.a;
            if (weakHashMap != null) {
                weakHashMap.clear();
            }
            ArrayList<WeakReference<View>> arrayList2 = d.f1485d;
            if (!arrayList2.isEmpty()) {
                synchronized (arrayList2) {
                    if (dVar.a == null) {
                        dVar.a = new WeakHashMap<>();
                    }
                    int size = arrayList2.size();
                    while (true) {
                        size--;
                        if (size < 0) {
                            break;
                        }
                        ArrayList<WeakReference<View>> arrayList3 = d.f1485d;
                        View view2 = arrayList3.get(size).get();
                        if (view2 == null) {
                            arrayList3.remove(size);
                        } else {
                            dVar.a.put(view2, bool);
                            for (ViewParent parent = view2.getParent(); parent instanceof View; parent = parent.getParent()) {
                                dVar.a.put((View) parent, bool);
                            }
                        }
                    }
                }
            }
        }
        View a2 = dVar.a(view, keyEvent);
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (a2 != null && !KeyEvent.isModifierKey(keyCode)) {
                if (dVar.b == null) {
                    dVar.b = new SparseArray<>();
                }
                dVar.b.put(keyCode, new WeakReference<>(a2));
            }
        }
        if (a2 != null) {
            return true;
        }
        return false;
    }

    public static a f(View view) {
        View.AccessibilityDelegate g2 = g(view);
        if (g2 == null) {
            return null;
        }
        return g2 instanceof a.C0038a ? ((a.C0038a) g2).a : new a(g2);
    }

    public static View.AccessibilityDelegate g(View view) {
        if (Build.VERSION.SDK_INT >= 29) {
            return view.getAccessibilityDelegate();
        }
        if (f1481d) {
            return null;
        }
        if (c == null) {
            try {
                Field declaredField = View.class.getDeclaredField("mAccessibilityDelegate");
                c = declaredField;
                declaredField.setAccessible(true);
            } catch (Throwable unused) {
                f1481d = true;
                return null;
            }
        }
        Object obj = c.get(view);
        if (obj instanceof View.AccessibilityDelegate) {
            return (View.AccessibilityDelegate) obj;
        }
        return null;
    }

    public static List<b.a> h(View view) {
        int i2 = R$id.tag_accessibility_actions;
        ArrayList arrayList = (ArrayList) view.getTag(i2);
        if (arrayList != null) {
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        view.setTag(i2, arrayList2);
        return arrayList2;
    }

    public static Rect i() {
        if (f1482e == null) {
            f1482e = new ThreadLocal<>();
        }
        Rect rect = f1482e.get();
        if (rect == null) {
            rect = new Rect();
            f1482e.set(rect);
        }
        rect.setEmpty();
        return rect;
    }

    public static w j(View view) {
        WindowInsets rootWindowInsets;
        if (Build.VERSION.SDK_INT < 23 || (rootWindowInsets = view.getRootWindowInsets()) == null) {
            return null;
        }
        w g2 = w.g(rootWindowInsets);
        g2.a.l(g2);
        View rootView = view.getRootView();
        Rect rect = new Rect();
        rootView.getWindowVisibleDisplayFrame(rect);
        g2.a.k(rect, rootView.getHeight());
        return g2;
    }

    public static void k(View view, int i2) {
        if (((AccessibilityManager) view.getContext().getSystemService("accessibility")).isEnabled()) {
            boolean z = ((CharSequence) new o(R$id.tag_accessibility_pane_title, CharSequence.class, 8, 28).c(view)) != null;
            if (view.getAccessibilityLiveRegion() != 0 || (z && view.getVisibility() == 0)) {
                AccessibilityEvent obtain = AccessibilityEvent.obtain();
                obtain.setEventType(z ? 32 : 2048);
                obtain.setContentChangeTypes(i2);
                view.sendAccessibilityEventUnchecked(obtain);
            } else if (view.getParent() != null) {
                try {
                    view.getParent().notifySubtreeAccessibilityStateChanged(view, view, i2);
                } catch (AbstractMethodError e2) {
                    Log.e("ViewCompat", view.getParent().getClass().getSimpleName() + " does not fully implement ViewParent", e2);
                }
            }
        }
    }

    public static void l(View view, int i2) {
        if (Build.VERSION.SDK_INT >= 23) {
            view.offsetLeftAndRight(i2);
            return;
        }
        Rect i3 = i();
        boolean z = false;
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            i3.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
            z = !i3.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
        c(view, i2);
        if (z && i3.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
            ((View) parent).invalidate(i3);
        }
    }

    public static void m(View view, int i2) {
        if (Build.VERSION.SDK_INT >= 23) {
            view.offsetTopAndBottom(i2);
            return;
        }
        Rect i3 = i();
        boolean z = false;
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            i3.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
            z = !i3.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
        d(view, i2);
        if (z && i3.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
            ((View) parent).invalidate(i3);
        }
    }

    public static void n(View view, int i2) {
        o(i2, view);
        k(view, 0);
    }

    public static void o(int i2, View view) {
        List<b.a> h2 = h(view);
        for (int i3 = 0; i3 < h2.size(); i3++) {
            if (h2.get(i3).a() == i2) {
                h2.remove(i3);
                return;
            }
        }
    }

    public static void p(View view, b.a aVar, CharSequence charSequence, e.i.i.x.d dVar) {
        if (dVar == null) {
            o(aVar.a(), view);
            k(view, 0);
            return;
        }
        a(view, new b.a(null, aVar.b, null, dVar, aVar.c));
    }

    public static void q(View view, Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i2, int i3) {
        if (Build.VERSION.SDK_INT >= 29) {
            view.saveAttributeDataForStyleable(context, iArr, attributeSet, typedArray, i2, i3);
        }
    }

    public static void r(View view, a aVar) {
        if (aVar == null && (g(view) instanceof a.C0038a)) {
            aVar = new a();
        }
        view.setAccessibilityDelegate(aVar == null ? null : aVar.b);
    }

    public static void s(View view, k kVar) {
        if (kVar == null) {
            view.setOnApplyWindowInsetsListener(null);
        } else {
            view.setOnApplyWindowInsetsListener(new a(kVar));
        }
    }

    public static void t(View view) {
        float translationY = view.getTranslationY();
        view.setTranslationY(1.0f + translationY);
        view.setTranslationY(translationY);
    }
}
