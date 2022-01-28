package com.google.android.material.snackbar;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import b.i.l.m;
import b.i.l.v;
import b.x.t;
import c.b.a.b.i0.j;
import c.b.a.b.i0.k;
import c.b.a.b.i0.l;
import c.b.a.b.i0.n;
import c.b.a.b.i0.o;
import com.google.android.material.behavior.SwipeDismissBehavior;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import java.util.List;

public abstract class BaseTransientBottomBar<B extends BaseTransientBottomBar<B>> {
    public static final Handler o = new Handler(Looper.getMainLooper(), new a());
    public static final int[] p = {c.b.a.b.b.snackbarStyle};

    /* renamed from: a  reason: collision with root package name */
    public final ViewGroup f6101a;

    /* renamed from: b  reason: collision with root package name */
    public final Context f6102b;

    /* renamed from: c  reason: collision with root package name */
    public final i f6103c;

    /* renamed from: d  reason: collision with root package name */
    public final n f6104d;

    /* renamed from: e  reason: collision with root package name */
    public int f6105e;

    /* renamed from: f  reason: collision with root package name */
    public final Runnable f6106f = new b();

    /* renamed from: g  reason: collision with root package name */
    public Rect f6107g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;
    public final AccessibilityManager m;
    public o.b n = new e();

    public static class Behavior extends SwipeDismissBehavior<View> {
        public final f j = new f(this);

        @Override // com.google.android.material.behavior.SwipeDismissBehavior
        public boolean B(View view) {
            if (this.j != null) {
                return view instanceof i;
            }
            throw null;
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean j(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            f fVar = this.j;
            if (fVar != null) {
                int actionMasked = motionEvent.getActionMasked();
                if (actionMasked != 0) {
                    if (actionMasked == 1 || actionMasked == 3) {
                        o.b().f(fVar.f6112a);
                    }
                } else if (coordinatorLayout.l(view, (int) motionEvent.getX(), (int) motionEvent.getY())) {
                    o.b().e(fVar.f6112a);
                }
                return super.j(coordinatorLayout, view, motionEvent);
            }
            throw null;
        }
    }

    public static class a implements Handler.Callback {
        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i == 0) {
                BaseTransientBottomBar baseTransientBottomBar = (BaseTransientBottomBar) message.obj;
                baseTransientBottomBar.f6103c.setOnAttachStateChangeListener(new j(baseTransientBottomBar));
                if (baseTransientBottomBar.f6103c.getParent() == null) {
                    ViewGroup.LayoutParams layoutParams = baseTransientBottomBar.f6103c.getLayoutParams();
                    if (layoutParams instanceof CoordinatorLayout.f) {
                        CoordinatorLayout.f fVar = (CoordinatorLayout.f) layoutParams;
                        Behavior behavior = new Behavior();
                        f fVar2 = behavior.j;
                        if (fVar2 != null) {
                            fVar2.f6112a = baseTransientBottomBar.n;
                            behavior.f6012b = new l(baseTransientBottomBar);
                            fVar.b(behavior);
                            fVar.f192g = 80;
                        } else {
                            throw null;
                        }
                    }
                    baseTransientBottomBar.l = 0;
                    baseTransientBottomBar.g();
                    baseTransientBottomBar.f6103c.setVisibility(4);
                    baseTransientBottomBar.f6101a.addView(baseTransientBottomBar.f6103c);
                }
                if (m.C(baseTransientBottomBar.f6103c)) {
                    baseTransientBottomBar.f();
                } else {
                    baseTransientBottomBar.f6103c.setOnLayoutChangeListener(new k(baseTransientBottomBar));
                }
                return true;
            } else if (i != 1) {
                return false;
            } else {
                BaseTransientBottomBar baseTransientBottomBar2 = (BaseTransientBottomBar) message.obj;
                int i2 = message.arg1;
                if (!baseTransientBottomBar2.e() || baseTransientBottomBar2.f6103c.getVisibility() != 0) {
                    baseTransientBottomBar2.c(i2);
                } else if (baseTransientBottomBar2.f6103c.getAnimationMode() == 1) {
                    ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
                    ofFloat.setInterpolator(c.b.a.b.m.a.f4410a);
                    ofFloat.addUpdateListener(new c.b.a.b.i0.c(baseTransientBottomBar2));
                    ofFloat.setDuration(75L);
                    ofFloat.addListener(new c.b.a.b.i0.b(baseTransientBottomBar2, i2));
                    ofFloat.start();
                } else {
                    ValueAnimator valueAnimator = new ValueAnimator();
                    valueAnimator.setIntValues(0, baseTransientBottomBar2.b());
                    valueAnimator.setInterpolator(c.b.a.b.m.a.f4411b);
                    valueAnimator.setDuration(250L);
                    valueAnimator.addListener(new c.b.a.b.i0.g(baseTransientBottomBar2, i2));
                    valueAnimator.addUpdateListener(new c.b.a.b.i0.h(baseTransientBottomBar2));
                    valueAnimator.start();
                }
                return true;
            }
        }
    }

    public class b implements Runnable {
        public b() {
        }

        public void run() {
            Context context;
            BaseTransientBottomBar baseTransientBottomBar = BaseTransientBottomBar.this;
            if (baseTransientBottomBar.f6103c != null && (context = baseTransientBottomBar.f6102b) != null) {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRealMetrics(displayMetrics);
                int i = displayMetrics.heightPixels;
                BaseTransientBottomBar baseTransientBottomBar2 = BaseTransientBottomBar.this;
                int[] iArr = new int[2];
                baseTransientBottomBar2.f6103c.getLocationOnScreen(iArr);
                int height = (i - (baseTransientBottomBar2.f6103c.getHeight() + iArr[1])) + ((int) BaseTransientBottomBar.this.f6103c.getTranslationY());
                BaseTransientBottomBar baseTransientBottomBar3 = BaseTransientBottomBar.this;
                if (height < baseTransientBottomBar3.k) {
                    ViewGroup.LayoutParams layoutParams = baseTransientBottomBar3.f6103c.getLayoutParams();
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                        int i2 = marginLayoutParams.bottomMargin;
                        BaseTransientBottomBar baseTransientBottomBar4 = BaseTransientBottomBar.this;
                        marginLayoutParams.bottomMargin = (baseTransientBottomBar4.k - height) + i2;
                        baseTransientBottomBar4.f6103c.requestLayout();
                    }
                }
            }
        }
    }

    public class c implements b.i.l.j {
        public c() {
        }

        @Override // b.i.l.j
        public v a(View view, v vVar) {
            BaseTransientBottomBar.this.h = vVar.a();
            BaseTransientBottomBar.this.i = vVar.b();
            BaseTransientBottomBar.this.j = vVar.c();
            BaseTransientBottomBar.this.g();
            return vVar;
        }
    }

    public class d extends b.i.l.a {
        public d() {
        }

        @Override // b.i.l.a
        public void d(View view, b.i.l.w.b bVar) {
            this.f1847a.onInitializeAccessibilityNodeInfo(view, bVar.f1906a);
            bVar.f1906a.addAction(1048576);
            bVar.f1906a.setDismissable(true);
        }

        @Override // b.i.l.a
        public boolean g(View view, int i, Bundle bundle) {
            if (i != 1048576) {
                return super.g(view, i, bundle);
            }
            ((Snackbar) BaseTransientBottomBar.this).a(3);
            return true;
        }
    }

    public class e implements o.b {
        public e() {
        }

        @Override // c.b.a.b.i0.o.b
        public void a() {
            Handler handler = BaseTransientBottomBar.o;
            handler.sendMessage(handler.obtainMessage(0, BaseTransientBottomBar.this));
        }

        @Override // c.b.a.b.i0.o.b
        public void b(int i) {
            Handler handler = BaseTransientBottomBar.o;
            handler.sendMessage(handler.obtainMessage(1, i, 0, BaseTransientBottomBar.this));
        }
    }

    public static class f {

        /* renamed from: a  reason: collision with root package name */
        public o.b f6112a;

        public f(SwipeDismissBehavior<?> swipeDismissBehavior) {
            swipeDismissBehavior.f6017g = SwipeDismissBehavior.C(0.0f, 0.1f, 1.0f);
            swipeDismissBehavior.h = SwipeDismissBehavior.C(0.0f, 0.6f, 1.0f);
            swipeDismissBehavior.f6015e = 0;
        }
    }

    public interface g {
    }

    public interface h {
    }

    public static class i extends FrameLayout {
        public static final View.OnTouchListener i = new a();

        /* renamed from: b  reason: collision with root package name */
        public h f6113b;

        /* renamed from: c  reason: collision with root package name */
        public g f6114c;

        /* renamed from: d  reason: collision with root package name */
        public int f6115d;

        /* renamed from: e  reason: collision with root package name */
        public final float f6116e;

        /* renamed from: f  reason: collision with root package name */
        public final float f6117f;

        /* renamed from: g  reason: collision with root package name */
        public ColorStateList f6118g;
        public PorterDuff.Mode h;

        public static class a implements View.OnTouchListener {
            @SuppressLint({"ClickableViewAccessibility"})
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        }

        public i(Context context, AttributeSet attributeSet) {
            super(c.b.a.b.m0.a.a.a(context, attributeSet, 0, 0), attributeSet);
            Context context2 = getContext();
            TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, c.b.a.b.l.SnackbarLayout);
            if (obtainStyledAttributes.hasValue(c.b.a.b.l.SnackbarLayout_elevation)) {
                m.Z(this, (float) obtainStyledAttributes.getDimensionPixelSize(c.b.a.b.l.SnackbarLayout_elevation, 0));
            }
            this.f6115d = obtainStyledAttributes.getInt(c.b.a.b.l.SnackbarLayout_animationMode, 0);
            this.f6116e = obtainStyledAttributes.getFloat(c.b.a.b.l.SnackbarLayout_backgroundOverlayColorAlpha, 1.0f);
            setBackgroundTintList(t.B1(context2, obtainStyledAttributes, c.b.a.b.l.SnackbarLayout_backgroundTint));
            setBackgroundTintMode(t.m2(obtainStyledAttributes.getInt(c.b.a.b.l.SnackbarLayout_backgroundTintMode, -1), PorterDuff.Mode.SRC_IN));
            this.f6117f = obtainStyledAttributes.getFloat(c.b.a.b.l.SnackbarLayout_actionTextColorAlpha, 1.0f);
            obtainStyledAttributes.recycle();
            setOnTouchListener(i);
            setFocusable(true);
            if (getBackground() == null) {
                float dimension = getResources().getDimension(c.b.a.b.d.mtrl_snackbar_background_corner_radius);
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setShape(0);
                gradientDrawable.setCornerRadius(dimension);
                int i2 = c.b.a.b.b.colorSurface;
                int i3 = c.b.a.b.b.colorOnSurface;
                gradientDrawable.setColor(t.a2(t.A1(this, i2), t.A1(this, i3), getBackgroundOverlayColorAlpha()));
                ColorStateList colorStateList = this.f6118g;
                if (colorStateList != null) {
                    gradientDrawable.setTintList(colorStateList);
                }
                m.X(this, gradientDrawable);
            }
        }

        public float getActionTextColorAlpha() {
            return this.f6117f;
        }

        public int getAnimationMode() {
            return this.f6115d;
        }

        public float getBackgroundOverlayColorAlpha() {
            return this.f6116e;
        }

        public void onAttachedToWindow() {
            WindowInsets rootWindowInsets;
            super.onAttachedToWindow();
            g gVar = this.f6114c;
            if (gVar != null) {
                j jVar = (j) gVar;
                if (jVar == null) {
                    throw null;
                } else if (Build.VERSION.SDK_INT >= 29 && (rootWindowInsets = jVar.f4335a.f6103c.getRootWindowInsets()) != null) {
                    jVar.f4335a.k = rootWindowInsets.getMandatorySystemGestureInsets().bottom;
                    jVar.f4335a.g();
                }
            }
            m.S(this);
        }

        public void onDetachedFromWindow() {
            boolean z;
            super.onDetachedFromWindow();
            g gVar = this.f6114c;
            if (gVar != null) {
                j jVar = (j) gVar;
                BaseTransientBottomBar baseTransientBottomBar = jVar.f4335a;
                if (baseTransientBottomBar != null) {
                    o b2 = o.b();
                    o.b bVar = baseTransientBottomBar.n;
                    synchronized (b2.f4340a) {
                        if (!b2.c(bVar)) {
                            if (!b2.d(bVar)) {
                                z = false;
                            }
                        }
                        z = true;
                    }
                    if (z) {
                        BaseTransientBottomBar.o.post(new c.b.a.b.i0.i(jVar));
                        return;
                    }
                    return;
                }
                throw null;
            }
        }

        public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
            super.onLayout(z, i2, i3, i4, i5);
            h hVar = this.f6113b;
            if (hVar != null) {
                k kVar = (k) hVar;
                kVar.f4336a.f6103c.setOnLayoutChangeListener(null);
                kVar.f4336a.f();
            }
        }

        public void setAnimationMode(int i2) {
            this.f6115d = i2;
        }

        public void setBackground(Drawable drawable) {
            setBackgroundDrawable(drawable);
        }

        public void setBackgroundDrawable(Drawable drawable) {
            if (!(drawable == null || this.f6118g == null)) {
                drawable = drawable.mutate();
                drawable.setTintList(this.f6118g);
                drawable.setTintMode(this.h);
            }
            super.setBackgroundDrawable(drawable);
        }

        public void setBackgroundTintList(ColorStateList colorStateList) {
            this.f6118g = colorStateList;
            if (getBackground() != null) {
                Drawable mutate = getBackground().mutate();
                mutate.setTintList(colorStateList);
                mutate.setTintMode(this.h);
                if (mutate != getBackground()) {
                    super.setBackgroundDrawable(mutate);
                }
            }
        }

        public void setBackgroundTintMode(PorterDuff.Mode mode) {
            this.h = mode;
            if (getBackground() != null) {
                Drawable mutate = getBackground().mutate();
                mutate.setTintMode(mode);
                if (mutate != getBackground()) {
                    super.setBackgroundDrawable(mutate);
                }
            }
        }

        public void setOnAttachStateChangeListener(g gVar) {
            this.f6114c = gVar;
        }

        public void setOnClickListener(View.OnClickListener onClickListener) {
            setOnTouchListener(onClickListener != null ? null : i);
            super.setOnClickListener(onClickListener);
        }

        public void setOnLayoutChangeListener(h hVar) {
            this.f6113b = hVar;
        }
    }

    public BaseTransientBottomBar(ViewGroup viewGroup, View view, n nVar) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null parent");
        } else if (view == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null content");
        } else if (nVar != null) {
            this.f6101a = viewGroup;
            this.f6104d = nVar;
            Context context = viewGroup.getContext();
            this.f6102b = context;
            c.b.a.b.c0.k.c(context, c.b.a.b.c0.k.f4216a, "Theme.AppCompat");
            LayoutInflater from = LayoutInflater.from(this.f6102b);
            TypedArray obtainStyledAttributes = this.f6102b.obtainStyledAttributes(p);
            int resourceId = obtainStyledAttributes.getResourceId(0, -1);
            obtainStyledAttributes.recycle();
            i iVar = (i) from.inflate(resourceId != -1 ? c.b.a.b.h.mtrl_layout_snackbar : c.b.a.b.h.design_layout_snackbar, this.f6101a, false);
            this.f6103c = iVar;
            if (view instanceof SnackbarContentLayout) {
                SnackbarContentLayout snackbarContentLayout = (SnackbarContentLayout) view;
                float actionTextColorAlpha = iVar.getActionTextColorAlpha();
                if (actionTextColorAlpha != 1.0f) {
                    snackbarContentLayout.f6120c.setTextColor(t.a2(t.A1(snackbarContentLayout, c.b.a.b.b.colorSurface), snackbarContentLayout.f6120c.getCurrentTextColor(), actionTextColorAlpha));
                }
            }
            this.f6103c.addView(view);
            ViewGroup.LayoutParams layoutParams = this.f6103c.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                this.f6107g = new Rect(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
            }
            m.W(this.f6103c, 1);
            this.f6103c.setImportantForAccessibility(1);
            this.f6103c.setFitsSystemWindows(true);
            m.c0(this.f6103c, new c());
            m.U(this.f6103c, new d());
            this.m = (AccessibilityManager) this.f6102b.getSystemService("accessibility");
        } else {
            throw new IllegalArgumentException("Transient bottom bar must have non-null callback");
        }
    }

    public void a(int i2) {
        o.c cVar;
        o b2 = o.b();
        o.b bVar = this.n;
        synchronized (b2.f4340a) {
            if (b2.c(bVar)) {
                cVar = b2.f4342c;
            } else if (b2.d(bVar)) {
                cVar = b2.f4343d;
            }
            b2.a(cVar, i2);
        }
    }

    public final int b() {
        int height = this.f6103c.getHeight();
        ViewGroup.LayoutParams layoutParams = this.f6103c.getLayoutParams();
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? height + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin : height;
    }

    public void c(int i2) {
        o b2 = o.b();
        o.b bVar = this.n;
        synchronized (b2.f4340a) {
            if (b2.c(bVar)) {
                b2.f4342c = null;
                if (b2.f4343d != null) {
                    b2.h();
                }
            }
        }
        ViewParent parent = this.f6103c.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.f6103c);
        }
    }

    public void d() {
        o b2 = o.b();
        o.b bVar = this.n;
        synchronized (b2.f4340a) {
            if (b2.c(bVar)) {
                b2.g(b2.f4342c);
            }
        }
    }

    public boolean e() {
        List<AccessibilityServiceInfo> enabledAccessibilityServiceList = this.m.getEnabledAccessibilityServiceList(1);
        return enabledAccessibilityServiceList != null && enabledAccessibilityServiceList.isEmpty();
    }

    public final void f() {
        if (e()) {
            this.f6103c.post(new c.b.a.b.i0.m(this));
            return;
        }
        this.f6103c.setVisibility(0);
        d();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x004c, code lost:
        if (((r0 instanceof androidx.coordinatorlayout.widget.CoordinatorLayout.f) && (((androidx.coordinatorlayout.widget.CoordinatorLayout.f) r0).f186a instanceof com.google.android.material.behavior.SwipeDismissBehavior)) != false) goto L_0x0050;
     */
    public final void g() {
        Rect rect;
        ViewGroup.LayoutParams layoutParams = this.f6103c.getLayoutParams();
        if ((layoutParams instanceof ViewGroup.MarginLayoutParams) && (rect = this.f6107g) != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.bottomMargin = rect.bottom + this.h;
            marginLayoutParams.leftMargin = rect.left + this.i;
            marginLayoutParams.rightMargin = rect.right + this.j;
            this.f6103c.requestLayout();
            if (Build.VERSION.SDK_INT >= 29) {
                boolean z = true;
                if (this.k > 0) {
                    ViewGroup.LayoutParams layoutParams2 = this.f6103c.getLayoutParams();
                }
                z = false;
                if (z) {
                    this.f6103c.removeCallbacks(this.f6106f);
                    this.f6103c.post(this.f6106f);
                }
            }
        }
    }
}
