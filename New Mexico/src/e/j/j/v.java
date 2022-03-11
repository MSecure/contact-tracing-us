package e.j.j;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.core.R$id;
import e.j.j.b0;
import e.j.j.c;
import e.j.j.c0.b;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class v {
    public static Field c;

    /* renamed from: e */
    public static ThreadLocal<Rect> f1642e;
    public static final AtomicInteger a = new AtomicInteger(1);
    public static WeakHashMap<View, x> b = null;

    /* renamed from: d */
    public static boolean f1641d = false;

    /* renamed from: f */
    public static final int[] f1643f = {R$id.accessibility_custom_action_0, R$id.accessibility_custom_action_1, R$id.accessibility_custom_action_2, R$id.accessibility_custom_action_3, R$id.accessibility_custom_action_4, R$id.accessibility_custom_action_5, R$id.accessibility_custom_action_6, R$id.accessibility_custom_action_7, R$id.accessibility_custom_action_8, R$id.accessibility_custom_action_9, R$id.accessibility_custom_action_10, R$id.accessibility_custom_action_11, R$id.accessibility_custom_action_12, R$id.accessibility_custom_action_13, R$id.accessibility_custom_action_14, R$id.accessibility_custom_action_15, R$id.accessibility_custom_action_16, R$id.accessibility_custom_action_17, R$id.accessibility_custom_action_18, R$id.accessibility_custom_action_19, R$id.accessibility_custom_action_20, R$id.accessibility_custom_action_21, R$id.accessibility_custom_action_22, R$id.accessibility_custom_action_23, R$id.accessibility_custom_action_24, R$id.accessibility_custom_action_25, R$id.accessibility_custom_action_26, R$id.accessibility_custom_action_27, R$id.accessibility_custom_action_28, R$id.accessibility_custom_action_29, R$id.accessibility_custom_action_30, R$id.accessibility_custom_action_31};

    /* renamed from: g */
    public static final p f1644g = a.b;

    /* renamed from: h */
    public static final a f1645h = new a();

    /* loaded from: classes.dex */
    public static class a implements ViewTreeObserver.OnGlobalLayoutListener, View.OnAttachStateChangeListener {
        public final WeakHashMap<View, Boolean> b = new WeakHashMap<>();

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (Build.VERSION.SDK_INT < 28) {
                for (Map.Entry<View, Boolean> entry : this.b.entrySet()) {
                    View key = entry.getKey();
                    boolean booleanValue = entry.getValue().booleanValue();
                    boolean z = key.getVisibility() == 0;
                    if (booleanValue != z) {
                        v.m(key, z ? 16 : 32);
                        this.b.put(key, Boolean.valueOf(z));
                    }
                }
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(this);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    /* loaded from: classes.dex */
    public static abstract class b<T> {
        public final int a;
        public final Class<T> b;
        public final int c;

        /* renamed from: d */
        public final int f1646d;

        public b(int i2, Class<T> cls, int i3) {
            this.a = i2;
            this.b = cls;
            this.f1646d = 0;
            this.c = i3;
        }

        public b(int i2, Class<T> cls, int i3, int i4) {
            this.a = i2;
            this.b = cls;
            this.f1646d = i3;
            this.c = i4;
        }

        public boolean a(Boolean bool, Boolean bool2) {
            return (bool != null && bool.booleanValue()) == (bool2 != null && bool2.booleanValue());
        }

        public abstract T b(View view);

        public abstract void c(View view, T t);

        public T d(View view) {
            if (Build.VERSION.SDK_INT >= this.c) {
                return b(view);
            }
            T t = (T) view.getTag(this.a);
            if (this.b.isInstance(t)) {
                return t;
            }
            return null;
        }

        public void e(View view, T t) {
            if (Build.VERSION.SDK_INT >= this.c) {
                c(view, t);
            } else if (f(d(view), t)) {
                c g2 = v.g(view);
                if (g2 == null) {
                    g2 = new c();
                }
                v.u(view, g2);
                view.setTag(this.a, t);
                v.m(view, this.f1646d);
            }
        }

        public abstract boolean f(T t, T t2);
    }

    /* loaded from: classes.dex */
    public static class c {
        public static boolean a(View view) {
            return view.hasOnClickListeners();
        }
    }

    /* loaded from: classes.dex */
    public static class d {
        public static AccessibilityNodeProvider a(View view) {
            return view.getAccessibilityNodeProvider();
        }

        public static boolean b(View view) {
            return view.getFitsSystemWindows();
        }

        public static int c(View view) {
            return view.getImportantForAccessibility();
        }

        public static int d(View view) {
            return view.getMinimumHeight();
        }

        public static int e(View view) {
            return view.getMinimumWidth();
        }

        public static ViewParent f(View view) {
            return view.getParentForAccessibility();
        }

        public static int g(View view) {
            return view.getWindowSystemUiVisibility();
        }

        public static boolean h(View view) {
            return view.hasOverlappingRendering();
        }

        public static boolean i(View view) {
            return view.hasTransientState();
        }

        public static boolean j(View view, int i2, Bundle bundle) {
            return view.performAccessibilityAction(i2, bundle);
        }

        public static void k(View view) {
            view.postInvalidateOnAnimation();
        }

        public static void l(View view, int i2, int i3, int i4, int i5) {
            view.postInvalidateOnAnimation(i2, i3, i4, i5);
        }

        public static void m(View view, Runnable runnable) {
            view.postOnAnimation(runnable);
        }

        public static void n(View view, Runnable runnable, long j2) {
            view.postOnAnimationDelayed(runnable, j2);
        }

        public static void o(ViewTreeObserver viewTreeObserver, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
            viewTreeObserver.removeOnGlobalLayoutListener(onGlobalLayoutListener);
        }

        public static void p(View view) {
            view.requestFitSystemWindows();
        }

        public static void q(View view, Drawable drawable) {
            view.setBackground(drawable);
        }

        public static void r(View view, boolean z) {
            view.setHasTransientState(z);
        }

        public static void s(View view, int i2) {
            view.setImportantForAccessibility(i2);
        }
    }

    /* loaded from: classes.dex */
    public static class e {
        public static int a() {
            return View.generateViewId();
        }

        public static Display b(View view) {
            return view.getDisplay();
        }

        public static int c(View view) {
            return view.getLabelFor();
        }

        public static int d(View view) {
            return view.getLayoutDirection();
        }

        public static int e(View view) {
            return view.getPaddingEnd();
        }

        public static int f(View view) {
            return view.getPaddingStart();
        }

        public static boolean g(View view) {
            return view.isPaddingRelative();
        }

        public static void h(View view, int i2) {
            view.setLabelFor(i2);
        }

        public static void i(View view, Paint paint) {
            view.setLayerPaint(paint);
        }

        public static void j(View view, int i2) {
            view.setLayoutDirection(i2);
        }

        public static void k(View view, int i2, int i3, int i4, int i5) {
            view.setPaddingRelative(i2, i3, i4, i5);
        }
    }

    /* loaded from: classes.dex */
    public static class f {
        public static Rect a(View view) {
            return view.getClipBounds();
        }

        public static boolean b(View view) {
            return view.isInLayout();
        }

        public static void c(View view, Rect rect) {
            view.setClipBounds(rect);
        }
    }

    /* loaded from: classes.dex */
    public static class g {
        public static int a(View view) {
            return view.getAccessibilityLiveRegion();
        }

        public static boolean b(View view) {
            return view.isAttachedToWindow();
        }

        public static boolean c(View view) {
            return view.isLaidOut();
        }

        public static boolean d(View view) {
            return view.isLayoutDirectionResolved();
        }

        public static void e(ViewParent viewParent, View view, View view2, int i2) {
            viewParent.notifySubtreeAccessibilityStateChanged(view, view2, i2);
        }

        public static void f(View view, int i2) {
            view.setAccessibilityLiveRegion(i2);
        }

        public static void g(AccessibilityEvent accessibilityEvent, int i2) {
            accessibilityEvent.setContentChangeTypes(i2);
        }
    }

    /* loaded from: classes.dex */
    public static class h {
        public static WindowInsets a(View view, WindowInsets windowInsets) {
            return view.dispatchApplyWindowInsets(windowInsets);
        }

        public static WindowInsets b(View view, WindowInsets windowInsets) {
            return view.onApplyWindowInsets(windowInsets);
        }

        public static void c(View view) {
            view.requestApplyInsets();
        }
    }

    /* loaded from: classes.dex */
    public static class i {

        /* loaded from: classes.dex */
        public class a implements View.OnApplyWindowInsetsListener {
            public b0 a = null;
            public final /* synthetic */ View b;
            public final /* synthetic */ n c;

            public a(View view, n nVar) {
                this.b = view;
                this.c = nVar;
            }

            @Override // android.view.View.OnApplyWindowInsetsListener
            public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                b0 i2 = b0.i(windowInsets, view);
                int i3 = Build.VERSION.SDK_INT;
                if (i3 < 30) {
                    i.a(windowInsets, this.b);
                    if (i2.equals(this.a)) {
                        return this.c.a(view, i2).g();
                    }
                }
                this.a = i2;
                b0 a = this.c.a(view, i2);
                if (i3 >= 30) {
                    return a.g();
                }
                AtomicInteger atomicInteger = v.a;
                h.c(view);
                return a.g();
            }
        }

        public static void a(WindowInsets windowInsets, View view) {
            View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = (View.OnApplyWindowInsetsListener) view.getTag(R$id.tag_window_insets_animation_callback);
            if (onApplyWindowInsetsListener != null) {
                onApplyWindowInsetsListener.onApplyWindowInsets(view, windowInsets);
            }
        }

        public static b0 b(View view, b0 b0Var, Rect rect) {
            WindowInsets g2 = b0Var.g();
            if (g2 != null) {
                return b0.i(view.computeSystemWindowInsets(g2, rect), view);
            }
            rect.setEmpty();
            return b0Var;
        }

        public static boolean c(View view, float f2, float f3, boolean z) {
            return view.dispatchNestedFling(f2, f3, z);
        }

        public static boolean d(View view, float f2, float f3) {
            return view.dispatchNestedPreFling(f2, f3);
        }

        public static boolean e(View view, int i2, int i3, int[] iArr, int[] iArr2) {
            return view.dispatchNestedPreScroll(i2, i3, iArr, iArr2);
        }

        public static boolean f(View view, int i2, int i3, int i4, int i5, int[] iArr) {
            return view.dispatchNestedScroll(i2, i3, i4, i5, iArr);
        }

        public static ColorStateList g(View view) {
            return view.getBackgroundTintList();
        }

        public static PorterDuff.Mode h(View view) {
            return view.getBackgroundTintMode();
        }

        public static float i(View view) {
            return view.getElevation();
        }

        public static b0 j(View view) {
            if (!b0.a.f1608d || !view.isAttachedToWindow()) {
                return null;
            }
            try {
                Object obj = b0.a.a.get(view.getRootView());
                if (obj == null) {
                    return null;
                }
                Rect rect = (Rect) b0.a.b.get(obj);
                Rect rect2 = (Rect) b0.a.c.get(obj);
                if (rect == null || rect2 == null) {
                    return null;
                }
                int i2 = Build.VERSION.SDK_INT;
                b0.e dVar = i2 >= 30 ? new b0.d() : i2 >= 29 ? new b0.c() : new b0.b();
                dVar.b(e.j.c.b.a(rect.left, rect.top, rect.right, rect.bottom));
                dVar.c(e.j.c.b.a(rect2.left, rect2.top, rect2.right, rect2.bottom));
                b0 a2 = dVar.a();
                a2.a.m(a2);
                a2.a.d(view.getRootView());
                return a2;
            } catch (IllegalAccessException e2) {
                e2.getMessage();
                return null;
            }
        }

        public static String k(View view) {
            return view.getTransitionName();
        }

        public static float l(View view) {
            return view.getTranslationZ();
        }

        public static float m(View view) {
            return view.getZ();
        }

        public static boolean n(View view) {
            return view.hasNestedScrollingParent();
        }

        public static boolean o(View view) {
            return view.isImportantForAccessibility();
        }

        public static boolean p(View view) {
            return view.isNestedScrollingEnabled();
        }

        public static void q(View view, ColorStateList colorStateList) {
            view.setBackgroundTintList(colorStateList);
        }

        public static void r(View view, PorterDuff.Mode mode) {
            view.setBackgroundTintMode(mode);
        }

        public static void s(View view, float f2) {
            view.setElevation(f2);
        }

        public static void t(View view, boolean z) {
            view.setNestedScrollingEnabled(z);
        }

        public static void u(View view, n nVar) {
            if (Build.VERSION.SDK_INT < 30) {
                view.setTag(R$id.tag_on_apply_window_listener, nVar);
            }
            if (nVar == null) {
                view.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener) view.getTag(R$id.tag_window_insets_animation_callback));
            } else {
                view.setOnApplyWindowInsetsListener(new a(view, nVar));
            }
        }

        public static void v(View view, String str) {
            view.setTransitionName(str);
        }

        public static void w(View view, float f2) {
            view.setTranslationZ(f2);
        }

        public static void x(View view, float f2) {
            view.setZ(f2);
        }

        public static boolean y(View view, int i2) {
            return view.startNestedScroll(i2);
        }

        public static void z(View view) {
            view.stopNestedScroll();
        }
    }

    /* loaded from: classes.dex */
    public static class j {
        public static int a(View view) {
            return view.getScrollIndicators();
        }

        public static void b(View view, int i2) {
            view.setScrollIndicators(i2);
        }

        public static void c(View view, int i2, int i3) {
            view.setScrollIndicators(i2, i3);
        }
    }

    /* loaded from: classes.dex */
    public static class k {
        public static void a(View view, Collection<View> collection, int i2) {
            view.addKeyboardNavigationClusters(collection, i2);
        }

        public static int b(View view) {
            return view.getImportantForAutofill();
        }

        public static int c(View view) {
            return view.getNextClusterForwardId();
        }

        public static boolean d(View view) {
            return view.hasExplicitFocusable();
        }

        public static boolean e(View view) {
            return view.isFocusedByDefault();
        }

        public static boolean f(View view) {
            return view.isImportantForAutofill();
        }

        public static boolean g(View view) {
            return view.isKeyboardNavigationCluster();
        }

        public static View h(View view, View view2, int i2) {
            return view.keyboardNavigationClusterSearch(view2, i2);
        }

        public static boolean i(View view) {
            return view.restoreDefaultFocus();
        }

        public static void j(View view, String... strArr) {
            view.setAutofillHints(strArr);
        }

        public static void k(View view, boolean z) {
            view.setFocusedByDefault(z);
        }

        public static void l(View view, int i2) {
            view.setImportantForAutofill(i2);
        }

        public static void m(View view, boolean z) {
            view.setKeyboardNavigationCluster(z);
        }

        public static void n(View view, int i2) {
            view.setNextClusterForwardId(i2);
        }

        public static void o(View view, CharSequence charSequence) {
            view.setTooltipText(charSequence);
        }
    }

    /* loaded from: classes.dex */
    public static class l {
        public static void a(View view, o oVar) {
            int i2 = R$id.tag_unhandled_key_listeners;
            e.f.h hVar = (e.f.h) view.getTag(i2);
            if (hVar == null) {
                hVar = new e.f.h();
                view.setTag(i2, hVar);
            }
            Objects.requireNonNull(oVar);
            b bVar = new b(oVar);
            hVar.put(oVar, bVar);
            view.addOnUnhandledKeyEventListener(bVar);
        }

        public static CharSequence b(View view) {
            return view.getAccessibilityPaneTitle();
        }

        public static boolean c(View view) {
            return view.isAccessibilityHeading();
        }

        public static boolean d(View view) {
            return view.isScreenReaderFocusable();
        }

        public static void e(View view, o oVar) {
            View.OnUnhandledKeyEventListener onUnhandledKeyEventListener;
            e.f.h hVar = (e.f.h) view.getTag(R$id.tag_unhandled_key_listeners);
            if (hVar != null && (onUnhandledKeyEventListener = (View.OnUnhandledKeyEventListener) hVar.getOrDefault(oVar, null)) != null) {
                view.removeOnUnhandledKeyEventListener(onUnhandledKeyEventListener);
            }
        }

        public static <T> T f(View view, int i2) {
            return (T) view.requireViewById(i2);
        }

        public static void g(View view, boolean z) {
            view.setAccessibilityHeading(z);
        }

        public static void h(View view, CharSequence charSequence) {
            view.setAccessibilityPaneTitle(charSequence);
        }

        public static void i(View view, boolean z) {
            view.setScreenReaderFocusable(z);
        }
    }

    /* loaded from: classes.dex */
    public static class m {
        public static View.AccessibilityDelegate a(View view) {
            return view.getAccessibilityDelegate();
        }

        public static List<Rect> b(View view) {
            return view.getSystemGestureExclusionRects();
        }

        public static void c(View view, Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i2, int i3) {
            view.saveAttributeDataForStyleable(context, iArr, attributeSet, typedArray, i2, i3);
        }

        public static void d(View view, List<Rect> list) {
            view.setSystemGestureExclusionRects(list);
        }
    }

    /* loaded from: classes.dex */
    public static class n {
        public static CharSequence a(View view) {
            return view.getStateDescription();
        }

        public static void b(View view, CharSequence charSequence) {
            view.setStateDescription(charSequence);
        }
    }

    /* loaded from: classes.dex */
    public interface o {
        boolean onUnhandledKeyEvent(View view, KeyEvent keyEvent);
    }

    /* loaded from: classes.dex */
    public static class p {

        /* renamed from: d */
        public static final ArrayList<WeakReference<View>> f1647d = new ArrayList<>();
        public WeakHashMap<View, Boolean> a = null;
        public SparseArray<WeakReference<View>> b = null;
        public WeakReference<KeyEvent> c = null;

        public final View a(View view, KeyEvent keyEvent) {
            WeakHashMap<View, Boolean> weakHashMap = this.a;
            if (weakHashMap != null && weakHashMap.containsKey(view)) {
                if (view instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                        View a = a(viewGroup.getChildAt(childCount), keyEvent);
                        if (a != null) {
                            return a;
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
                if (((o) arrayList.get(size)).onUnhandledKeyEvent(view, keyEvent)) {
                    return true;
                }
            }
            return false;
        }
    }

    public static void a(View view, b.a aVar) {
        c g2 = g(view);
        if (g2 == null) {
            g2 = new c();
        }
        u(view, g2);
        r(aVar.a(), view);
        j(view).add(aVar);
        m(view, 0);
    }

    public static x b(View view) {
        if (b == null) {
            b = new WeakHashMap<>();
        }
        x xVar = b.get(view);
        if (xVar != null) {
            return xVar;
        }
        x xVar2 = new x(view);
        b.put(view, xVar2);
        return xVar2;
    }

    public static void c(View view, int i2) {
        view.offsetLeftAndRight(i2);
        if (view.getVisibility() == 0) {
            float translationY = view.getTranslationY();
            view.setTranslationY(1.0f + translationY);
            view.setTranslationY(translationY);
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                v((View) parent);
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
                v((View) parent);
            }
        }
    }

    public static b0 e(View view, b0 b0Var) {
        WindowInsets g2 = b0Var.g();
        if (g2 != null) {
            WindowInsets a2 = h.a(view, g2);
            if (!a2.equals(g2)) {
                return b0.i(a2, view);
            }
        }
        return b0Var;
    }

    public static boolean f(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        ArrayList<WeakReference<View>> arrayList = p.f1647d;
        int i2 = R$id.tag_unhandled_key_event_manager;
        p pVar = (p) view.getTag(i2);
        if (pVar == null) {
            pVar = new p();
            view.setTag(i2, pVar);
        }
        if (keyEvent.getAction() == 0) {
            WeakHashMap<View, Boolean> weakHashMap = pVar.a;
            if (weakHashMap != null) {
                weakHashMap.clear();
            }
            ArrayList<WeakReference<View>> arrayList2 = p.f1647d;
            if (!arrayList2.isEmpty()) {
                synchronized (arrayList2) {
                    if (pVar.a == null) {
                        pVar.a = new WeakHashMap<>();
                    }
                    int size = arrayList2.size();
                    while (true) {
                        size--;
                        if (size < 0) {
                            break;
                        }
                        ArrayList<WeakReference<View>> arrayList3 = p.f1647d;
                        View view2 = arrayList3.get(size).get();
                        if (view2 == null) {
                            arrayList3.remove(size);
                        } else {
                            pVar.a.put(view2, Boolean.TRUE);
                            for (ViewParent parent = view2.getParent(); parent instanceof View; parent = parent.getParent()) {
                                pVar.a.put((View) parent, Boolean.TRUE);
                            }
                        }
                    }
                }
            }
        }
        View a2 = pVar.a(view, keyEvent);
        if (keyEvent.getAction() == 0) {
            int keyCode = keyEvent.getKeyCode();
            if (a2 != null && !KeyEvent.isModifierKey(keyCode)) {
                if (pVar.b == null) {
                    pVar.b = new SparseArray<>();
                }
                pVar.b.put(keyCode, new WeakReference<>(a2));
            }
        }
        if (a2 != null) {
            return true;
        }
        return false;
    }

    public static c g(View view) {
        View.AccessibilityDelegate h2 = h(view);
        if (h2 == null) {
            return null;
        }
        return h2 instanceof c.a ? ((c.a) h2).a : new c(h2);
    }

    public static View.AccessibilityDelegate h(View view) {
        if (Build.VERSION.SDK_INT >= 29) {
            return m.a(view);
        }
        if (f1641d) {
            return null;
        }
        if (c == null) {
            try {
                Field declaredField = View.class.getDeclaredField("mAccessibilityDelegate");
                c = declaredField;
                declaredField.setAccessible(true);
            } catch (Throwable unused) {
                f1641d = true;
                return null;
            }
        }
        Object obj = c.get(view);
        if (obj instanceof View.AccessibilityDelegate) {
            return (View.AccessibilityDelegate) obj;
        }
        return null;
    }

    public static CharSequence i(View view) {
        return new s(R$id.tag_accessibility_pane_title, CharSequence.class, 8, 28).d(view);
    }

    public static List<b.a> j(View view) {
        int i2 = R$id.tag_accessibility_actions;
        ArrayList arrayList = (ArrayList) view.getTag(i2);
        if (arrayList != null) {
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        view.setTag(i2, arrayList2);
        return arrayList2;
    }

    public static Rect k() {
        if (f1642e == null) {
            f1642e = new ThreadLocal<>();
        }
        Rect rect = f1642e.get();
        if (rect == null) {
            rect = new Rect();
            f1642e.set(rect);
        }
        rect.setEmpty();
        return rect;
    }

    public static b0 l(View view) {
        if (Build.VERSION.SDK_INT < 23) {
            return i.j(view);
        }
        WindowInsets rootWindowInsets = view.getRootWindowInsets();
        if (rootWindowInsets == null) {
            return null;
        }
        b0 h2 = b0.h(rootWindowInsets);
        h2.a.m(h2);
        h2.a.d(view.getRootView());
        return h2;
    }

    public static void m(View view, int i2) {
        AccessibilityManager accessibilityManager = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled()) {
            boolean z = i(view) != null && view.getVisibility() == 0;
            int i3 = 32;
            if (g.a(view) != 0 || z) {
                AccessibilityEvent obtain = AccessibilityEvent.obtain();
                if (!z) {
                    i3 = 2048;
                }
                obtain.setEventType(i3);
                g.g(obtain, i2);
                if (z) {
                    obtain.getText().add(i(view));
                    if (d.c(view) == 0) {
                        d.s(view, 1);
                    }
                    ViewParent parent = view.getParent();
                    while (true) {
                        if (!(parent instanceof View)) {
                            break;
                        } else if (d.c((View) parent) == 4) {
                            d.s(view, 2);
                            break;
                        } else {
                            parent = parent.getParent();
                        }
                    }
                }
                view.sendAccessibilityEventUnchecked(obtain);
            } else if (i2 == 32) {
                AccessibilityEvent obtain2 = AccessibilityEvent.obtain();
                view.onInitializeAccessibilityEvent(obtain2);
                obtain2.setEventType(32);
                g.g(obtain2, i2);
                obtain2.setSource(view);
                view.onPopulateAccessibilityEvent(obtain2);
                obtain2.getText().add(i(view));
                accessibilityManager.sendAccessibilityEvent(obtain2);
            } else if (view.getParent() != null) {
                try {
                    g.e(view.getParent(), view, view, i2);
                } catch (AbstractMethodError unused) {
                    view.getParent().getClass().getSimpleName();
                }
            }
        }
    }

    public static void n(View view, int i2) {
        if (Build.VERSION.SDK_INT >= 23) {
            view.offsetLeftAndRight(i2);
            return;
        }
        Rect k2 = k();
        boolean z = false;
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            k2.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
            z = !k2.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
        c(view, i2);
        if (z && k2.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
            ((View) parent).invalidate(k2);
        }
    }

    public static void o(View view, int i2) {
        if (Build.VERSION.SDK_INT >= 23) {
            view.offsetTopAndBottom(i2);
            return;
        }
        Rect k2 = k();
        boolean z = false;
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            k2.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
            z = !k2.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
        d(view, i2);
        if (z && k2.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
            ((View) parent).invalidate(k2);
        }
    }

    public static b0 p(View view, b0 b0Var) {
        WindowInsets g2 = b0Var.g();
        if (g2 != null) {
            WindowInsets b2 = h.b(view, g2);
            if (!b2.equals(g2)) {
                return b0.i(b2, view);
            }
        }
        return b0Var;
    }

    public static e q(View view, e eVar) {
        if (Log.isLoggable("ViewCompat", 3)) {
            String str = "performReceiveContent: " + eVar + ", view=" + view.getClass().getSimpleName() + "[" + view.getId() + "]";
        }
        o oVar = (o) view.getTag(R$id.tag_on_receive_content_listener);
        if (oVar != null) {
            e a2 = oVar.a(view, eVar);
            if (a2 == null) {
                return null;
            }
            return (view instanceof p ? (p) view : f1644g).a(a2);
        }
        return (view instanceof p ? (p) view : f1644g).a(eVar);
    }

    public static void r(int i2, View view) {
        List<b.a> j2 = j(view);
        for (int i3 = 0; i3 < j2.size(); i3++) {
            if (j2.get(i3).a() == i2) {
                j2.remove(i3);
                return;
            }
        }
    }

    public static void s(View view, b.a aVar, CharSequence charSequence, e.j.j.c0.d dVar) {
        a(view, new b.a(null, aVar.b, null, dVar, aVar.c));
    }

    public static void t(View view, Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i2, int i3) {
        if (Build.VERSION.SDK_INT >= 29) {
            m.c(view, context, iArr, attributeSet, typedArray, i2, i3);
        }
    }

    public static void u(View view, c cVar) {
        if (cVar == null && (h(view) instanceof c.a)) {
            cVar = new c();
        }
        view.setAccessibilityDelegate(cVar == null ? null : cVar.b);
    }

    public static void v(View view) {
        float translationY = view.getTranslationY();
        view.setTranslationY(1.0f + translationY);
        view.setTranslationY(translationY);
    }
}
