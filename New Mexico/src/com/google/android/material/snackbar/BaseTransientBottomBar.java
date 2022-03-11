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
import e.j.j.b0;
import e.j.j.v;
import f.b.a.e.w.j;
import f.b.a.e.w.k;
import f.b.a.e.w.l;
import f.b.a.e.w.n;
import f.b.a.e.w.p;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public abstract class BaseTransientBottomBar<B extends BaseTransientBottomBar<B>> {
    public final ViewGroup a;
    public final Context b;
    public final i c;

    /* renamed from: d */
    public final n f593d;

    /* renamed from: e */
    public int f594e;

    /* renamed from: g */
    public Rect f596g;

    /* renamed from: h */
    public int f597h;

    /* renamed from: i */
    public int f598i;

    /* renamed from: j */
    public int f599j;

    /* renamed from: k */
    public int f600k;

    /* renamed from: l */
    public final AccessibilityManager f601l;
    public static final int[] o = {R$attr.snackbarStyle};
    public static final String p = BaseTransientBottomBar.class.getSimpleName();
    public static final Handler n = new Handler(Looper.getMainLooper(), new a());

    /* renamed from: f */
    public final Runnable f595f = new b();
    public p.b m = new e();

    /* loaded from: classes.dex */
    public static class Behavior extends SwipeDismissBehavior<View> {

        /* renamed from: i */
        public final f f602i = new f(this);

        @Override // com.google.android.material.behavior.SwipeDismissBehavior
        public boolean B(View view) {
            Objects.requireNonNull(this.f602i);
            return view instanceof i;
        }

        @Override // com.google.android.material.behavior.SwipeDismissBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
        public boolean j(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
            f fVar = this.f602i;
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

    /* loaded from: classes.dex */
    public static class a implements Handler.Callback {
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 0) {
                BaseTransientBottomBar baseTransientBottomBar = (BaseTransientBottomBar) message.obj;
                baseTransientBottomBar.c.setOnAttachStateChangeListener(new j(baseTransientBottomBar));
                if (baseTransientBottomBar.c.getParent() == null) {
                    ViewGroup.LayoutParams layoutParams = baseTransientBottomBar.c.getLayoutParams();
                    if (layoutParams instanceof CoordinatorLayout.f) {
                        CoordinatorLayout.f fVar = (CoordinatorLayout.f) layoutParams;
                        Behavior behavior = new Behavior();
                        f fVar2 = behavior.f602i;
                        Objects.requireNonNull(fVar2);
                        fVar2.a = baseTransientBottomBar.m;
                        behavior.b = new l(baseTransientBottomBar);
                        fVar.b(behavior);
                        fVar.f146g = 80;
                    }
                    baseTransientBottomBar.h();
                    baseTransientBottomBar.c.setVisibility(4);
                    baseTransientBottomBar.a.addView(baseTransientBottomBar.c);
                }
                i iVar = baseTransientBottomBar.c;
                AtomicInteger atomicInteger = v.a;
                if (v.g.c(iVar)) {
                    baseTransientBottomBar.g();
                } else {
                    baseTransientBottomBar.c.setOnLayoutChangeListener(new k(baseTransientBottomBar));
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
                    ofFloat.addUpdateListener(new f.b.a.e.w.c(baseTransientBottomBar2));
                    ofFloat.setDuration(75L);
                    ofFloat.addListener(new f.b.a.e.w.b(baseTransientBottomBar2, i3));
                    ofFloat.start();
                } else {
                    ValueAnimator valueAnimator = new ValueAnimator();
                    valueAnimator.setIntValues(0, baseTransientBottomBar2.c());
                    valueAnimator.setInterpolator(f.b.a.e.a.a.b);
                    valueAnimator.setDuration(250L);
                    valueAnimator.addListener(new f.b.a.e.w.g(baseTransientBottomBar2, i3));
                    valueAnimator.addUpdateListener(new f.b.a.e.w.h(baseTransientBottomBar2));
                    valueAnimator.start();
                }
                return true;
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public b() {
            BaseTransientBottomBar.this = r1;
        }

        @Override // java.lang.Runnable
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
                if (height < baseTransientBottomBar3.f600k) {
                    ViewGroup.LayoutParams layoutParams = baseTransientBottomBar3.c.getLayoutParams();
                    if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
                        Handler handler = BaseTransientBottomBar.n;
                        String str = BaseTransientBottomBar.p;
                        return;
                    }
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    int i3 = marginLayoutParams.bottomMargin;
                    BaseTransientBottomBar baseTransientBottomBar4 = BaseTransientBottomBar.this;
                    marginLayoutParams.bottomMargin = (baseTransientBottomBar4.f600k - height) + i3;
                    baseTransientBottomBar4.c.requestLayout();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements e.j.j.n {
        public c() {
            BaseTransientBottomBar.this = r1;
        }

        @Override // e.j.j.n
        public b0 a(View view, b0 b0Var) {
            BaseTransientBottomBar.this.f597h = b0Var.a();
            BaseTransientBottomBar.this.f598i = b0Var.b();
            BaseTransientBottomBar.this.f599j = b0Var.c();
            BaseTransientBottomBar.this.h();
            return b0Var;
        }
    }

    /* loaded from: classes.dex */
    public class d extends e.j.j.c {
        public d() {
            BaseTransientBottomBar.this = r1;
        }

        @Override // e.j.j.c
        public void d(View view, e.j.j.c0.b bVar) {
            this.a.onInitializeAccessibilityNodeInfo(view, bVar.a);
            bVar.a.addAction(1048576);
            bVar.a.setDismissable(true);
        }

        @Override // e.j.j.c
        public boolean g(View view, int i2, Bundle bundle) {
            if (i2 != 1048576) {
                return super.g(view, i2, bundle);
            }
            BaseTransientBottomBar.this.a();
            return true;
        }
    }

    /* loaded from: classes.dex */
    public class e implements p.b {
        public e() {
            BaseTransientBottomBar.this = r1;
        }

        @Override // f.b.a.e.w.p.b
        public void a() {
            Handler handler = BaseTransientBottomBar.n;
            handler.sendMessage(handler.obtainMessage(0, BaseTransientBottomBar.this));
        }

        @Override // f.b.a.e.w.p.b
        public void b(int i2) {
            Handler handler = BaseTransientBottomBar.n;
            handler.sendMessage(handler.obtainMessage(1, i2, 0, BaseTransientBottomBar.this));
        }
    }

    /* loaded from: classes.dex */
    public static class f {
        public p.b a;

        public f(SwipeDismissBehavior<?> swipeDismissBehavior) {
            swipeDismissBehavior.f510f = SwipeDismissBehavior.C(0.0f, 0.1f, 1.0f);
            swipeDismissBehavior.f511g = SwipeDismissBehavior.C(0.0f, 0.6f, 1.0f);
            swipeDismissBehavior.f508d = 0;
        }
    }

    /* loaded from: classes.dex */
    public interface g {
    }

    /* loaded from: classes.dex */
    public interface h {
    }

    /* loaded from: classes.dex */
    public static class i extends FrameLayout {

        /* renamed from: k */
        public static final View.OnTouchListener f604k = new a();
        public h b;
        public g c;

        /* renamed from: d */
        public int f605d;

        /* renamed from: e */
        public final float f606e;

        /* renamed from: f */
        public final float f607f;

        /* renamed from: g */
        public final int f608g;

        /* renamed from: h */
        public final int f609h;

        /* renamed from: i */
        public ColorStateList f610i;

        /* renamed from: j */
        public PorterDuff.Mode f611j;

        /* loaded from: classes.dex */
        public static class a implements View.OnTouchListener {
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        }

        public i(Context context, AttributeSet attributeSet) {
            super(f.b.a.e.z.a.a.a(context, attributeSet, 0, 0), attributeSet);
            Drawable drawable;
            Context context2 = getContext();
            TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, R$styleable.SnackbarLayout);
            int i2 = R$styleable.SnackbarLayout_elevation;
            if (obtainStyledAttributes.hasValue(i2)) {
                AtomicInteger atomicInteger = v.a;
                v.i.s(this, (float) obtainStyledAttributes.getDimensionPixelSize(i2, 0));
            }
            this.f605d = obtainStyledAttributes.getInt(R$styleable.SnackbarLayout_animationMode, 0);
            this.f606e = obtainStyledAttributes.getFloat(R$styleable.SnackbarLayout_backgroundOverlayColorAlpha, 1.0f);
            setBackgroundTintList(f.b.a.c.b.o.b.y0(context2, obtainStyledAttributes, R$styleable.SnackbarLayout_backgroundTint));
            setBackgroundTintMode(f.b.a.c.b.o.b.g1(obtainStyledAttributes.getInt(R$styleable.SnackbarLayout_backgroundTintMode, -1), PorterDuff.Mode.SRC_IN));
            this.f607f = obtainStyledAttributes.getFloat(R$styleable.SnackbarLayout_actionTextColorAlpha, 1.0f);
            this.f608g = obtainStyledAttributes.getDimensionPixelSize(R$styleable.SnackbarLayout_android_maxWidth, -1);
            this.f609h = obtainStyledAttributes.getDimensionPixelSize(R$styleable.SnackbarLayout_maxActionInlineWidth, -1);
            obtainStyledAttributes.recycle();
            setOnTouchListener(f604k);
            setFocusable(true);
            if (getBackground() == null) {
                float dimension = getResources().getDimension(R$dimen.mtrl_snackbar_background_corner_radius);
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setShape(0);
                gradientDrawable.setCornerRadius(dimension);
                int i3 = R$attr.colorSurface;
                int i4 = R$attr.colorOnSurface;
                gradientDrawable.setColor(f.b.a.c.b.o.b.b1(f.b.a.c.b.o.b.x0(this, i3), f.b.a.c.b.o.b.x0(this, i4), getBackgroundOverlayColorAlpha()));
                if (this.f610i != null) {
                    drawable = m.e.X1(gradientDrawable);
                    drawable.setTintList(this.f610i);
                } else {
                    drawable = m.e.X1(gradientDrawable);
                }
                AtomicInteger atomicInteger2 = v.a;
                v.d.q(this, drawable);
            }
        }

        public float getActionTextColorAlpha() {
            return this.f607f;
        }

        public int getAnimationMode() {
            return this.f605d;
        }

        public float getBackgroundOverlayColorAlpha() {
            return this.f606e;
        }

        public int getMaxInlineActionWidth() {
            return this.f609h;
        }

        public int getMaxWidth() {
            return this.f608g;
        }

        @Override // android.view.View, android.view.ViewGroup
        public void onAttachedToWindow() {
            WindowInsets rootWindowInsets;
            super.onAttachedToWindow();
            g gVar = this.c;
            if (gVar != null) {
                j jVar = (j) gVar;
                Objects.requireNonNull(jVar);
                if (Build.VERSION.SDK_INT >= 29 && (rootWindowInsets = jVar.a.c.getRootWindowInsets()) != null) {
                    jVar.a.f600k = rootWindowInsets.getMandatorySystemGestureInsets().bottom;
                    jVar.a.h();
                }
            }
            AtomicInteger atomicInteger = v.a;
            v.h.c(this);
        }

        @Override // android.view.View, android.view.ViewGroup
        public void onDetachedFromWindow() {
            boolean z;
            super.onDetachedFromWindow();
            g gVar = this.c;
            if (gVar != null) {
                j jVar = (j) gVar;
                BaseTransientBottomBar baseTransientBottomBar = jVar.a;
                Objects.requireNonNull(baseTransientBottomBar);
                p b = p.b();
                p.b bVar = baseTransientBottomBar.m;
                synchronized (b.a) {
                    if (!b.c(bVar) && !b.d(bVar)) {
                        z = false;
                    }
                    z = true;
                }
                if (z) {
                    BaseTransientBottomBar.n.post(new f.b.a.e.w.i(jVar));
                }
            }
        }

        @Override // android.widget.FrameLayout, android.view.View, android.view.ViewGroup
        public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
            super.onLayout(z, i2, i3, i4, i5);
            h hVar = this.b;
            if (hVar != null) {
                k kVar = (k) hVar;
                kVar.a.c.setOnLayoutChangeListener(null);
                kVar.a.g();
            }
        }

        public void setAnimationMode(int i2) {
            this.f605d = i2;
        }

        @Override // android.view.View
        public void setBackground(Drawable drawable) {
            setBackgroundDrawable(drawable);
        }

        @Override // android.view.View
        public void setBackgroundDrawable(Drawable drawable) {
            if (!(drawable == null || this.f610i == null)) {
                drawable = m.e.X1(drawable.mutate());
                drawable.setTintList(this.f610i);
                drawable.setTintMode(this.f611j);
            }
            super.setBackgroundDrawable(drawable);
        }

        @Override // android.view.View
        public void setBackgroundTintList(ColorStateList colorStateList) {
            this.f610i = colorStateList;
            if (getBackground() != null) {
                Drawable X1 = m.e.X1(getBackground().mutate());
                X1.setTintList(colorStateList);
                X1.setTintMode(this.f611j);
                if (X1 != getBackground()) {
                    super.setBackgroundDrawable(X1);
                }
            }
        }

        @Override // android.view.View
        public void setBackgroundTintMode(PorterDuff.Mode mode) {
            this.f611j = mode;
            if (getBackground() != null) {
                Drawable X1 = m.e.X1(getBackground().mutate());
                X1.setTintMode(mode);
                if (X1 != getBackground()) {
                    super.setBackgroundDrawable(X1);
                }
            }
        }

        public void setOnAttachStateChangeListener(g gVar) {
            this.c = gVar;
        }

        @Override // android.view.View
        public void setOnClickListener(View.OnClickListener onClickListener) {
            setOnTouchListener(onClickListener != null ? null : f604k);
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
            this.f593d = nVar;
            this.b = context;
            f.b.a.e.q.k.c(context, f.b.a.e.q.k.a, "Theme.AppCompat");
            LayoutInflater from = LayoutInflater.from(context);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(o);
            int resourceId = obtainStyledAttributes.getResourceId(0, -1);
            obtainStyledAttributes.recycle();
            i iVar = (i) from.inflate(resourceId != -1 ? R$layout.mtrl_layout_snackbar : R$layout.design_layout_snackbar, viewGroup, false);
            this.c = iVar;
            if (view instanceof SnackbarContentLayout) {
                SnackbarContentLayout snackbarContentLayout = (SnackbarContentLayout) view;
                float actionTextColorAlpha = iVar.getActionTextColorAlpha();
                if (actionTextColorAlpha != 1.0f) {
                    snackbarContentLayout.c.setTextColor(f.b.a.c.b.o.b.b1(f.b.a.c.b.o.b.x0(snackbarContentLayout, R$attr.colorSurface), snackbarContentLayout.c.getCurrentTextColor(), actionTextColorAlpha));
                }
                snackbarContentLayout.setMaxInlineActionWidth(iVar.getMaxInlineActionWidth());
                snackbarContentLayout.setMaxWidth(iVar.getMaxWidth());
            }
            iVar.addView(view);
            ViewGroup.LayoutParams layoutParams = iVar.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                this.f596g = new Rect(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
            }
            AtomicInteger atomicInteger = v.a;
            v.g.f(iVar, 1);
            v.d.s(iVar, 1);
            iVar.setFitsSystemWindows(true);
            v.i.u(iVar, new c());
            v.u(iVar, new d());
            this.f601l = (AccessibilityManager) context.getSystemService("accessibility");
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
        p.b bVar = this.m;
        synchronized (b2.a) {
            if (b2.c(bVar)) {
                cVar = b2.c;
            } else if (b2.d(bVar)) {
                cVar = b2.f3125d;
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
        p.b bVar = this.m;
        synchronized (b2.a) {
            if (b2.c(bVar)) {
                b2.c = null;
                if (b2.f3125d != null) {
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
        p.b bVar = this.m;
        synchronized (b2.a) {
            if (b2.c(bVar)) {
                b2.g(b2.c);
            }
        }
    }

    public boolean f() {
        AccessibilityManager accessibilityManager = this.f601l;
        if (accessibilityManager == null) {
            return true;
        }
        List<AccessibilityServiceInfo> enabledAccessibilityServiceList = accessibilityManager.getEnabledAccessibilityServiceList(1);
        return enabledAccessibilityServiceList != null && enabledAccessibilityServiceList.isEmpty();
    }

    public final void g() {
        if (f()) {
            this.c.post(new f.b.a.e.w.m(this));
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
        if ((layoutParams instanceof ViewGroup.MarginLayoutParams) && (rect = this.f596g) != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.bottomMargin = rect.bottom + this.f597h;
            marginLayoutParams.leftMargin = rect.left + this.f598i;
            marginLayoutParams.rightMargin = rect.right + this.f599j;
            this.c.requestLayout();
            if (Build.VERSION.SDK_INT >= 29) {
                boolean z = false;
                if (this.f600k > 0) {
                    ViewGroup.LayoutParams layoutParams2 = this.c.getLayoutParams();
                    if ((layoutParams2 instanceof CoordinatorLayout.f) && (((CoordinatorLayout.f) layoutParams2).a instanceof SwipeDismissBehavior)) {
                        z = true;
                    }
                }
                if (z) {
                    this.c.removeCallbacks(this.f595f);
                    this.c.post(this.f595f);
                }
            }
        }
    }
}
