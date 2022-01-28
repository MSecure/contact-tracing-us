package com.google.android.material.snackbar;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.animation.ValueAnimator;
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
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$layout;
import com.google.android.material.R$styleable;
import com.google.android.material.behavior.SwipeDismissBehavior;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import e.b.a.m;
import e.i.i.w;
import f.b.a.e.v.j;
import f.b.a.e.v.k;
import f.b.a.e.v.l;
import f.b.a.e.v.m;
import f.b.a.e.v.n;
import f.b.a.e.v.p;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class BaseTransientBottomBar<B extends BaseTransientBottomBar<B>> {
    public static final Handler o = new Handler(Looper.getMainLooper(), new a());
    public static final int[] p = {R$attr.snackbarStyle};
    public static final String q = BaseTransientBottomBar.class.getSimpleName();
    public final ViewGroup a;
    public final Context b;
    public final i c;

    /* renamed from: d  reason: collision with root package name */
    public final n f587d;

    /* renamed from: e  reason: collision with root package name */
    public int f588e;

    /* renamed from: f  reason: collision with root package name */
    public final Runnable f589f = new b();

    /* renamed from: g  reason: collision with root package name */
    public Rect f590g;

    /* renamed from: h  reason: collision with root package name */
    public int f591h;

    /* renamed from: i  reason: collision with root package name */
    public int f592i;

    /* renamed from: j  reason: collision with root package name */
    public int f593j;

    /* renamed from: k  reason: collision with root package name */
    public int f594k;

    /* renamed from: l  reason: collision with root package name */
    public int f595l;
    public final AccessibilityManager m;
    public p.b n = new e();

    public static class Behavior extends SwipeDismissBehavior<View> {

        /* renamed from: i  reason: collision with root package name */
        public final f f596i = new f(this);

        @Override // com.google.android.material.behavior.SwipeDismissBehavior
        public boolean B(View view) {
            Objects.requireNonNull(this.f596i);
            return view instanceof i;
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean j(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            f fVar = this.f596i;
            Objects.requireNonNull(fVar);
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked != 0) {
                if (actionMasked == 1 || actionMasked == 3) {
                    p.b().f(fVar.a);
                }
            } else if (coordinatorLayout.p(view, (int) motionEvent.getX(), (int) motionEvent.getY())) {
                p.b().e(fVar.a);
            }
            return super.j(coordinatorLayout, view, motionEvent);
        }
    }

    public static class a implements Handler.Callback {
        public boolean handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 0) {
                BaseTransientBottomBar baseTransientBottomBar = (BaseTransientBottomBar) message.obj;
                baseTransientBottomBar.c.setOnAttachStateChangeListener(new k(baseTransientBottomBar));
                if (baseTransientBottomBar.c.getParent() == null) {
                    ViewGroup.LayoutParams layoutParams = baseTransientBottomBar.c.getLayoutParams();
                    if (layoutParams instanceof CoordinatorLayout.f) {
                        CoordinatorLayout.f fVar = (CoordinatorLayout.f) layoutParams;
                        Behavior behavior = new Behavior();
                        f fVar2 = behavior.f596i;
                        Objects.requireNonNull(fVar2);
                        fVar2.a = baseTransientBottomBar.n;
                        behavior.b = new m(baseTransientBottomBar);
                        fVar.b(behavior);
                        fVar.f145g = 80;
                    }
                    baseTransientBottomBar.f595l = 0;
                    baseTransientBottomBar.h();
                    baseTransientBottomBar.c.setVisibility(4);
                    baseTransientBottomBar.a.addView(baseTransientBottomBar.c);
                }
                i iVar = baseTransientBottomBar.c;
                AtomicInteger atomicInteger = e.i.i.m.a;
                if (iVar.isLaidOut()) {
                    baseTransientBottomBar.g();
                } else {
                    baseTransientBottomBar.c.setOnLayoutChangeListener(new l(baseTransientBottomBar));
                }
                return true;
            } else if (i2 != 1) {
                return false;
            } else {
                BaseTransientBottomBar baseTransientBottomBar2 = (BaseTransientBottomBar) message.obj;
                int i3 = message.arg1;
                if (!baseTransientBottomBar2.f() || baseTransientBottomBar2.c.getVisibility() != 0) {
                    baseTransientBottomBar2.d(i3);
                } else if (baseTransientBottomBar2.c.getAnimationMode() == 1) {
                    ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
                    ofFloat.setInterpolator(f.b.a.e.a.a.a);
                    ofFloat.addUpdateListener(new f.b.a.e.v.d(baseTransientBottomBar2));
                    ofFloat.setDuration(75L);
                    ofFloat.addListener(new f.b.a.e.v.c(baseTransientBottomBar2, i3));
                    ofFloat.start();
                } else {
                    ValueAnimator valueAnimator = new ValueAnimator();
                    valueAnimator.setIntValues(0, baseTransientBottomBar2.c());
                    valueAnimator.setInterpolator(f.b.a.e.a.a.b);
                    valueAnimator.setDuration(250L);
                    valueAnimator.addListener(new f.b.a.e.v.h(baseTransientBottomBar2, i3));
                    valueAnimator.addUpdateListener(new f.b.a.e.v.i(baseTransientBottomBar2));
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
            if (baseTransientBottomBar.c != null && (context = baseTransientBottomBar.b) != null) {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRealMetrics(displayMetrics);
                int i2 = displayMetrics.heightPixels;
                BaseTransientBottomBar baseTransientBottomBar2 = BaseTransientBottomBar.this;
                int[] iArr = new int[2];
                baseTransientBottomBar2.c.getLocationOnScreen(iArr);
                int height = (i2 - (baseTransientBottomBar2.c.getHeight() + iArr[1])) + ((int) BaseTransientBottomBar.this.c.getTranslationY());
                BaseTransientBottomBar baseTransientBottomBar3 = BaseTransientBottomBar.this;
                if (height < baseTransientBottomBar3.f594k) {
                    ViewGroup.LayoutParams layoutParams = baseTransientBottomBar3.c.getLayoutParams();
                    if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                        Handler handler = BaseTransientBottomBar.o;
                        String str = BaseTransientBottomBar.q;
                        return;
                    }
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    int i3 = marginLayoutParams.bottomMargin;
                    BaseTransientBottomBar baseTransientBottomBar4 = BaseTransientBottomBar.this;
                    marginLayoutParams.bottomMargin = (baseTransientBottomBar4.f594k - height) + i3;
                    baseTransientBottomBar4.c.requestLayout();
                }
            }
        }
    }

    public class c implements e.i.i.k {
        public c() {
        }

        @Override // e.i.i.k
        public w a(View view, w wVar) {
            BaseTransientBottomBar.this.f591h = wVar.a();
            BaseTransientBottomBar.this.f592i = wVar.b();
            BaseTransientBottomBar.this.f593j = wVar.c();
            BaseTransientBottomBar.this.h();
            return wVar;
        }
    }

    public class d extends e.i.i.a {
        public d() {
        }

        @Override // e.i.i.a
        public void d(View view, e.i.i.x.b bVar) {
            this.a.onInitializeAccessibilityNodeInfo(view, bVar.a);
            bVar.a.addAction(1048576);
            bVar.a.setDismissable(true);
        }

        @Override // e.i.i.a
        public boolean g(View view, int i2, Bundle bundle) {
            if (i2 != 1048576) {
                return super.g(view, i2, bundle);
            }
            BaseTransientBottomBar.this.a();
            return true;
        }
    }

    public class e implements p.b {
        public e() {
        }

        @Override // f.b.a.e.v.p.b
        public void a() {
            Handler handler = BaseTransientBottomBar.o;
            handler.sendMessage(handler.obtainMessage(0, BaseTransientBottomBar.this));
        }

        @Override // f.b.a.e.v.p.b
        public void b(int i2) {
            Handler handler = BaseTransientBottomBar.o;
            handler.sendMessage(handler.obtainMessage(1, i2, 0, BaseTransientBottomBar.this));
        }
    }

    public static class f {
        public p.b a;

        public f(SwipeDismissBehavior<?> swipeDismissBehavior) {
            swipeDismissBehavior.f502f = SwipeDismissBehavior.C(0.0f, 0.1f, 1.0f);
            swipeDismissBehavior.f503g = SwipeDismissBehavior.C(0.0f, 0.6f, 1.0f);
            swipeDismissBehavior.f500d = 0;
        }
    }

    public interface g {
    }

    public interface h {
    }

    public static class i extends FrameLayout {

        /* renamed from: i  reason: collision with root package name */
        public static final View.OnTouchListener f598i = new a();
        public h b;
        public g c;

        /* renamed from: d  reason: collision with root package name */
        public int f599d;

        /* renamed from: e  reason: collision with root package name */
        public final float f600e;

        /* renamed from: f  reason: collision with root package name */
        public final float f601f;

        /* renamed from: g  reason: collision with root package name */
        public ColorStateList f602g;

        /* renamed from: h  reason: collision with root package name */
        public PorterDuff.Mode f603h;

        public static class a implements View.OnTouchListener {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        }

        public i(Context context, AttributeSet attributeSet) {
            super(f.b.a.e.y.a.a.a(context, attributeSet, 0, 0), attributeSet);
            Drawable drawable;
            Context context2 = getContext();
            TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, R$styleable.SnackbarLayout);
            int i2 = R$styleable.SnackbarLayout_elevation;
            if (obtainStyledAttributes.hasValue(i2)) {
                AtomicInteger atomicInteger = e.i.i.m.a;
                setElevation((float) obtainStyledAttributes.getDimensionPixelSize(i2, 0));
            }
            this.f599d = obtainStyledAttributes.getInt(R$styleable.SnackbarLayout_animationMode, 0);
            this.f600e = obtainStyledAttributes.getFloat(R$styleable.SnackbarLayout_backgroundOverlayColorAlpha, 1.0f);
            setBackgroundTintList(f.b.a.c.b.o.b.w0(context2, obtainStyledAttributes, R$styleable.SnackbarLayout_backgroundTint));
            setBackgroundTintMode(f.b.a.c.b.o.b.c1(obtainStyledAttributes.getInt(R$styleable.SnackbarLayout_backgroundTintMode, -1), PorterDuff.Mode.SRC_IN));
            this.f601f = obtainStyledAttributes.getFloat(R$styleable.SnackbarLayout_actionTextColorAlpha, 1.0f);
            obtainStyledAttributes.recycle();
            setOnTouchListener(f598i);
            setFocusable(true);
            if (getBackground() == null) {
                float dimension = getResources().getDimension(R$dimen.mtrl_snackbar_background_corner_radius);
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setShape(0);
                gradientDrawable.setCornerRadius(dimension);
                int i3 = R$attr.colorSurface;
                int i4 = R$attr.colorOnSurface;
                gradientDrawable.setColor(f.b.a.c.b.o.b.X0(f.b.a.c.b.o.b.v0(this, i3), f.b.a.c.b.o.b.v0(this, i4), getBackgroundOverlayColorAlpha()));
                if (this.f602g != null) {
                    drawable = m.h.C1(gradientDrawable);
                    drawable.setTintList(this.f602g);
                } else {
                    drawable = m.h.C1(gradientDrawable);
                }
                AtomicInteger atomicInteger2 = e.i.i.m.a;
                setBackground(drawable);
            }
        }

        public float getActionTextColorAlpha() {
            return this.f601f;
        }

        public int getAnimationMode() {
            return this.f599d;
        }

        public float getBackgroundOverlayColorAlpha() {
            return this.f600e;
        }

        public void onAttachedToWindow() {
            WindowInsets rootWindowInsets;
            super.onAttachedToWindow();
            g gVar = this.c;
            if (gVar != null) {
                k kVar = (k) gVar;
                Objects.requireNonNull(kVar);
                if (Build.VERSION.SDK_INT >= 29 && (rootWindowInsets = kVar.a.c.getRootWindowInsets()) != null) {
                    kVar.a.f594k = rootWindowInsets.getMandatorySystemGestureInsets().bottom;
                    kVar.a.h();
                }
            }
            AtomicInteger atomicInteger = e.i.i.m.a;
            requestApplyInsets();
        }

        public void onDetachedFromWindow() {
            boolean z;
            super.onDetachedFromWindow();
            g gVar = this.c;
            if (gVar != null) {
                k kVar = (k) gVar;
                BaseTransientBottomBar baseTransientBottomBar = kVar.a;
                Objects.requireNonNull(baseTransientBottomBar);
                p b2 = p.b();
                p.b bVar = baseTransientBottomBar.n;
                synchronized (b2.a) {
                    if (!b2.c(bVar)) {
                        if (!b2.d(bVar)) {
                            z = false;
                        }
                    }
                    z = true;
                }
                if (z) {
                    BaseTransientBottomBar.o.post(new j(kVar));
                }
            }
        }

        public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
            super.onLayout(z, i2, i3, i4, i5);
            h hVar = this.b;
            if (hVar != null) {
                l lVar = (l) hVar;
                lVar.a.c.setOnLayoutChangeListener(null);
                lVar.a.g();
            }
        }

        public void setAnimationMode(int i2) {
            this.f599d = i2;
        }

        public void setBackground(Drawable drawable) {
            setBackgroundDrawable(drawable);
        }

        public void setBackgroundDrawable(Drawable drawable) {
            if (!(drawable == null || this.f602g == null)) {
                drawable = m.h.C1(drawable.mutate());
                drawable.setTintList(this.f602g);
                drawable.setTintMode(this.f603h);
            }
            super.setBackgroundDrawable(drawable);
        }

        public void setBackgroundTintList(ColorStateList colorStateList) {
            this.f602g = colorStateList;
            if (getBackground() != null) {
                Drawable C1 = m.h.C1(getBackground().mutate());
                C1.setTintList(colorStateList);
                C1.setTintMode(this.f603h);
                if (C1 != getBackground()) {
                    super.setBackgroundDrawable(C1);
                }
            }
        }

        public void setBackgroundTintMode(PorterDuff.Mode mode) {
            this.f603h = mode;
            if (getBackground() != null) {
                Drawable C1 = m.h.C1(getBackground().mutate());
                C1.setTintMode(mode);
                if (C1 != getBackground()) {
                    super.setBackgroundDrawable(C1);
                }
            }
        }

        public void setOnAttachStateChangeListener(g gVar) {
            this.c = gVar;
        }

        public void setOnClickListener(View.OnClickListener onClickListener) {
            setOnTouchListener(onClickListener != null ? null : f598i);
            super.setOnClickListener(onClickListener);
        }

        public void setOnLayoutChangeListener(h hVar) {
            this.b = hVar;
        }
    }

    public BaseTransientBottomBar(Context context, ViewGroup viewGroup, View view, n nVar) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null parent");
        } else if (view == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null content");
        } else if (nVar != null) {
            this.a = viewGroup;
            this.f587d = nVar;
            this.b = context;
            f.b.a.e.p.k.c(context, f.b.a.e.p.k.a, "Theme.AppCompat");
            LayoutInflater from = LayoutInflater.from(context);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(p);
            int resourceId = obtainStyledAttributes.getResourceId(0, -1);
            obtainStyledAttributes.recycle();
            i iVar = (i) from.inflate(resourceId != -1 ? R$layout.mtrl_layout_snackbar : R$layout.design_layout_snackbar, viewGroup, false);
            this.c = iVar;
            if (view instanceof SnackbarContentLayout) {
                SnackbarContentLayout snackbarContentLayout = (SnackbarContentLayout) view;
                float actionTextColorAlpha = iVar.getActionTextColorAlpha();
                if (actionTextColorAlpha != 1.0f) {
                    snackbarContentLayout.c.setTextColor(f.b.a.c.b.o.b.X0(f.b.a.c.b.o.b.v0(snackbarContentLayout, R$attr.colorSurface), snackbarContentLayout.c.getCurrentTextColor(), actionTextColorAlpha));
                }
            }
            iVar.addView(view);
            ViewGroup.LayoutParams layoutParams = iVar.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                this.f590g = new Rect(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
            }
            AtomicInteger atomicInteger = e.i.i.m.a;
            iVar.setAccessibilityLiveRegion(1);
            iVar.setImportantForAccessibility(1);
            iVar.setFitsSystemWindows(true);
            e.i.i.m.r(iVar, new c());
            e.i.i.m.q(iVar, new d());
            this.m = (AccessibilityManager) context.getSystemService("accessibility");
        } else {
            throw new IllegalArgumentException("Transient bottom bar must have non-null callback");
        }
    }

    public void a() {
        b(3);
    }

    public void b(int i2) {
        p.c cVar;
        p b2 = p.b();
        p.b bVar = this.n;
        synchronized (b2.a) {
            if (b2.c(bVar)) {
                cVar = b2.c;
            } else if (b2.d(bVar)) {
                cVar = b2.f3019d;
            }
            b2.a(cVar, i2);
        }
    }

    public final int c() {
        int height = this.c.getHeight();
        ViewGroup.LayoutParams layoutParams = this.c.getLayoutParams();
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? height + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin : height;
    }

    public void d(int i2) {
        p b2 = p.b();
        p.b bVar = this.n;
        synchronized (b2.a) {
            if (b2.c(bVar)) {
                b2.c = null;
                if (b2.f3019d != null) {
                    b2.h();
                }
            }
        }
        ViewParent parent = this.c.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.c);
        }
    }

    public void e() {
        p b2 = p.b();
        p.b bVar = this.n;
        synchronized (b2.a) {
            if (b2.c(bVar)) {
                b2.g(b2.c);
            }
        }
    }

    public boolean f() {
        AccessibilityManager accessibilityManager = this.m;
        if (accessibilityManager == null) {
            return true;
        }
        List<AccessibilityServiceInfo> enabledAccessibilityServiceList = accessibilityManager.getEnabledAccessibilityServiceList(1);
        return enabledAccessibilityServiceList != null && enabledAccessibilityServiceList.isEmpty();
    }

    public final void g() {
        if (f()) {
            this.c.post(new f.b.a.e.v.a(this));
            return;
        }
        if (this.c.getParent() != null) {
            this.c.setVisibility(0);
        }
        e();
    }

    public final void h() {
        Rect rect;
        ViewGroup.LayoutParams layoutParams = this.c.getLayoutParams();
        if ((layoutParams instanceof ViewGroup.MarginLayoutParams) && (rect = this.f590g) != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.bottomMargin = rect.bottom + this.f591h;
            marginLayoutParams.leftMargin = rect.left + this.f592i;
            marginLayoutParams.rightMargin = rect.right + this.f593j;
            this.c.requestLayout();
            if (Build.VERSION.SDK_INT >= 29) {
                boolean z = false;
                if (this.f594k > 0) {
                    ViewGroup.LayoutParams layoutParams2 = this.c.getLayoutParams();
                    if ((layoutParams2 instanceof CoordinatorLayout.f) && (((CoordinatorLayout.f) layoutParams2).a instanceof SwipeDismissBehavior)) {
                        z = true;
                    }
                }
                if (z) {
                    this.c.removeCallbacks(this.f589f);
                    this.c.post(this.f589f);
                }
            }
        }
    }
}
