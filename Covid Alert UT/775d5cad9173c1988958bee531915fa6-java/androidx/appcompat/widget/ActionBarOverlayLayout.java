package androidx.appcompat.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.OverScroller;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$id;
import e.b.a.w;
import e.b.e.g;
import e.b.e.i.m;
import e.b.f.g0;
import e.b.f.h0;
import e.i.i.b0;
import e.i.i.k;
import e.i.i.l;
import e.i.i.m;
import e.i.i.v;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class ActionBarOverlayLayout extends ViewGroup implements g0, k, l {
    public static final int[] G = {R$attr.actionBarSize, 16842841};
    public OverScroller A;
    public ViewPropertyAnimator B;
    public final AnimatorListenerAdapter C;
    public final Runnable D;
    public final Runnable E;
    public final m F;
    public int b;
    public int c = 0;

    /* renamed from: d  reason: collision with root package name */
    public ContentFrameLayout f66d;

    /* renamed from: e  reason: collision with root package name */
    public ActionBarContainer f67e;

    /* renamed from: f  reason: collision with root package name */
    public h0 f68f;

    /* renamed from: g  reason: collision with root package name */
    public Drawable f69g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f70h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f71i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f72j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f73k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f74l;
    public int m;
    public int n;
    public final Rect o = new Rect();
    public final Rect p = new Rect();
    public final Rect q = new Rect();
    public final Rect r = new Rect();
    public final Rect s = new Rect();
    public final Rect t = new Rect();
    public final Rect u = new Rect();
    public b0 v;
    public b0 w;
    public b0 x;
    public b0 y;
    public d z;

    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        public void onAnimationCancel(Animator animator) {
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.B = null;
            actionBarOverlayLayout.f74l = false;
        }

        public void onAnimationEnd(Animator animator) {
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.B = null;
            actionBarOverlayLayout.f74l = false;
        }
    }

    public class b implements Runnable {
        public b() {
        }

        public void run() {
            ActionBarOverlayLayout.this.q();
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.B = actionBarOverlayLayout.f67e.animate().translationY(0.0f).setListener(ActionBarOverlayLayout.this.C);
        }
    }

    public class c implements Runnable {
        public c() {
        }

        public void run() {
            ActionBarOverlayLayout.this.q();
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.B = actionBarOverlayLayout.f67e.animate().translationY((float) (-ActionBarOverlayLayout.this.f67e.getHeight())).setListener(ActionBarOverlayLayout.this.C);
        }
    }

    public interface d {
    }

    public static class e extends ViewGroup.MarginLayoutParams {
        public e(int i2, int i3) {
            super(i2, i3);
        }

        public e(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public e(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b0 b0Var = b0.b;
        this.v = b0Var;
        this.w = b0Var;
        this.x = b0Var;
        this.y = b0Var;
        this.C = new a();
        this.D = new b();
        this.E = new c();
        r(context);
        this.F = new m();
    }

    @Override // e.b.f.g0
    public void a(Menu menu, m.a aVar) {
        s();
        this.f68f.a(menu, aVar);
    }

    @Override // e.b.f.g0
    public boolean b() {
        s();
        return this.f68f.b();
    }

    @Override // e.b.f.g0
    public boolean c() {
        s();
        return this.f68f.c();
    }

    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof e;
    }

    @Override // e.b.f.g0
    public boolean d() {
        s();
        return this.f68f.d();
    }

    public void draw(Canvas canvas) {
        int i2;
        super.draw(canvas);
        if (this.f69g != null && !this.f70h) {
            if (this.f67e.getVisibility() == 0) {
                i2 = (int) (this.f67e.getTranslationY() + ((float) this.f67e.getBottom()) + 0.5f);
            } else {
                i2 = 0;
            }
            this.f69g.setBounds(0, i2, getWidth(), this.f69g.getIntrinsicHeight() + i2);
            this.f69g.draw(canvas);
        }
    }

    @Override // e.b.f.g0
    public boolean e() {
        s();
        return this.f68f.e();
    }

    @Override // e.b.f.g0
    public void f() {
        s();
        this.f68f.f();
    }

    public boolean fitSystemWindows(Rect rect) {
        return super.fitSystemWindows(rect);
    }

    @Override // e.b.f.g0
    public boolean g() {
        s();
        return this.f68f.g();
    }

    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new e(-1, -1);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new e(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new e(layoutParams);
    }

    public int getActionBarHideOffset() {
        ActionBarContainer actionBarContainer = this.f67e;
        if (actionBarContainer != null) {
            return -((int) actionBarContainer.getTranslationY());
        }
        return 0;
    }

    public int getNestedScrollAxes() {
        return this.F.a();
    }

    public CharSequence getTitle() {
        s();
        return this.f68f.getTitle();
    }

    @Override // e.i.i.k
    public void h(View view, View view2, int i2, int i3) {
        if (i3 == 0) {
            onNestedScrollAccepted(view, view2, i2);
        }
    }

    @Override // e.i.i.k
    public void i(View view, int i2) {
        if (i2 == 0) {
            onStopNestedScroll(view);
        }
    }

    @Override // e.i.i.k
    public void j(View view, int i2, int i3, int[] iArr, int i4) {
        if (i4 == 0) {
            onNestedPreScroll(view, i2, i3, iArr);
        }
    }

    @Override // e.b.f.g0
    public void k(int i2) {
        s();
        if (i2 == 2) {
            this.f68f.t();
        } else if (i2 == 5) {
            this.f68f.v();
        } else if (i2 == 109) {
            setOverlayMode(true);
        }
    }

    @Override // e.b.f.g0
    public void l() {
        s();
        this.f68f.h();
    }

    @Override // e.i.i.l
    public void m(View view, int i2, int i3, int i4, int i5, int i6, int[] iArr) {
        if (i6 == 0) {
            onNestedScroll(view, i2, i3, i4, i5);
        }
    }

    @Override // e.i.i.k
    public void n(View view, int i2, int i3, int i4, int i5, int i6) {
        if (i6 == 0) {
            onNestedScroll(view, i2, i3, i4, i5);
        }
    }

    @Override // e.i.i.k
    public boolean o(View view, View view2, int i2, int i3) {
        return i3 == 0 && onStartNestedScroll(view, view2, i2);
    }

    public WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        s();
        b0 i2 = b0.i(windowInsets, this);
        boolean p2 = p(this.f67e, new Rect(i2.b(), i2.d(), i2.c(), i2.a()), true, true, false, true);
        Rect rect = this.o;
        AtomicInteger atomicInteger = v.a;
        v.i.b(this, i2, rect);
        Rect rect2 = this.o;
        b0 i3 = i2.a.i(rect2.left, rect2.top, rect2.right, rect2.bottom);
        this.v = i3;
        boolean z2 = true;
        if (!this.w.equals(i3)) {
            this.w = this.v;
            p2 = true;
        }
        if (!this.p.equals(this.o)) {
            this.p.set(this.o);
        } else {
            z2 = p2;
        }
        if (z2) {
            requestLayout();
        }
        return i2.a.a().a.c().a.b().g();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        r(getContext());
        AtomicInteger atomicInteger = v.a;
        v.h.c(this);
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        q();
    }

    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                e eVar = (e) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i7 = ((ViewGroup.MarginLayoutParams) eVar).leftMargin + paddingLeft;
                int i8 = ((ViewGroup.MarginLayoutParams) eVar).topMargin + paddingTop;
                childAt.layout(i7, i8, measuredWidth + i7, measuredHeight + i8);
            }
        }
    }

    public void onMeasure(int i2, int i3) {
        int i4;
        b0 b0Var;
        s();
        measureChildWithMargins(this.f67e, i2, 0, i3, 0);
        e eVar = (e) this.f67e.getLayoutParams();
        int max = Math.max(0, this.f67e.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) eVar).leftMargin + ((ViewGroup.MarginLayoutParams) eVar).rightMargin);
        int max2 = Math.max(0, this.f67e.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) eVar).topMargin + ((ViewGroup.MarginLayoutParams) eVar).bottomMargin);
        int combineMeasuredStates = View.combineMeasuredStates(0, this.f67e.getMeasuredState());
        AtomicInteger atomicInteger = v.a;
        boolean z2 = (v.d.g(this) & 256) != 0;
        if (z2) {
            i4 = this.b;
            if (this.f72j && this.f67e.getTabContainer() != null) {
                i4 += this.b;
            }
        } else {
            i4 = this.f67e.getVisibility() != 8 ? this.f67e.getMeasuredHeight() : 0;
        }
        this.q.set(this.o);
        b0 b0Var2 = this.v;
        this.x = b0Var2;
        if (this.f71i || z2) {
            e.i.c.b a2 = e.i.c.b.a(b0Var2.b(), this.x.d() + i4, this.x.c(), this.x.a() + 0);
            b0 b0Var3 = this.x;
            int i5 = Build.VERSION.SDK_INT;
            b0.e dVar = i5 >= 30 ? new b0.d(b0Var3) : i5 >= 29 ? new b0.c(b0Var3) : new b0.b(b0Var3);
            dVar.c(a2);
            b0Var = dVar.a();
        } else {
            Rect rect = this.q;
            rect.top += i4;
            rect.bottom += 0;
            b0Var = b0Var2.a.i(0, i4, 0, 0);
        }
        this.x = b0Var;
        p(this.f66d, this.q, true, true, true, true);
        if (!this.y.equals(this.x)) {
            b0 b0Var4 = this.x;
            this.y = b0Var4;
            v.e(this.f66d, b0Var4);
        }
        measureChildWithMargins(this.f66d, i2, 0, i3, 0);
        e eVar2 = (e) this.f66d.getLayoutParams();
        int max3 = Math.max(max, this.f66d.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) eVar2).leftMargin + ((ViewGroup.MarginLayoutParams) eVar2).rightMargin);
        int max4 = Math.max(max2, this.f66d.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) eVar2).topMargin + ((ViewGroup.MarginLayoutParams) eVar2).bottomMargin);
        int combineMeasuredStates2 = View.combineMeasuredStates(combineMeasuredStates, this.f66d.getMeasuredState());
        setMeasuredDimension(View.resolveSizeAndState(Math.max(getPaddingRight() + getPaddingLeft() + max3, getSuggestedMinimumWidth()), i2, combineMeasuredStates2), View.resolveSizeAndState(Math.max(getPaddingBottom() + getPaddingTop() + max4, getSuggestedMinimumHeight()), i3, combineMeasuredStates2 << 16));
    }

    public boolean onNestedFling(View view, float f2, float f3, boolean z2) {
        boolean z3 = false;
        if (!this.f73k || !z2) {
            return false;
        }
        this.A.fling(0, 0, 0, (int) f3, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        if (this.A.getFinalY() > this.f67e.getHeight()) {
            z3 = true;
        }
        if (z3) {
            q();
            this.E.run();
        } else {
            q();
            this.D.run();
        }
        this.f74l = true;
        return true;
    }

    public boolean onNestedPreFling(View view, float f2, float f3) {
        return false;
    }

    public void onNestedPreScroll(View view, int i2, int i3, int[] iArr) {
    }

    public void onNestedScroll(View view, int i2, int i3, int i4, int i5) {
        int i6 = this.m + i3;
        this.m = i6;
        setActionBarHideOffset(i6);
    }

    public void onNestedScrollAccepted(View view, View view2, int i2) {
        w wVar;
        g gVar;
        this.F.a = i2;
        this.m = getActionBarHideOffset();
        q();
        d dVar = this.z;
        if (dVar != null && (gVar = (wVar = (w) dVar).t) != null) {
            gVar.a();
            wVar.t = null;
        }
    }

    public boolean onStartNestedScroll(View view, View view2, int i2) {
        if ((i2 & 2) == 0 || this.f67e.getVisibility() != 0) {
            return false;
        }
        return this.f73k;
    }

    public void onStopNestedScroll(View view) {
        if (this.f73k && !this.f74l) {
            if (this.m <= this.f67e.getHeight()) {
                q();
                postDelayed(this.D, 600);
            } else {
                q();
                postDelayed(this.E, 600);
            }
        }
        d dVar = this.z;
        if (dVar != null) {
            Objects.requireNonNull((w) dVar);
        }
    }

    @Deprecated
    public void onWindowSystemUiVisibilityChanged(int i2) {
        super.onWindowSystemUiVisibilityChanged(i2);
        s();
        int i3 = this.n ^ i2;
        this.n = i2;
        boolean z2 = (i2 & 4) == 0;
        boolean z3 = (i2 & 256) != 0;
        d dVar = this.z;
        if (dVar != null) {
            ((w) dVar).p = !z3;
            if (z2 || !z3) {
                w wVar = (w) dVar;
                if (wVar.q) {
                    wVar.q = false;
                    wVar.w(true);
                }
            } else {
                w wVar2 = (w) dVar;
                if (!wVar2.q) {
                    wVar2.q = true;
                    wVar2.w(true);
                }
            }
        }
        if ((i3 & 256) != 0 && this.z != null) {
            AtomicInteger atomicInteger = v.a;
            v.h.c(this);
        }
    }

    public void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
        this.c = i2;
        d dVar = this.z;
        if (dVar != null) {
            ((w) dVar).o = i2;
        }
    }

    public final boolean p(View view, Rect rect, boolean z2, boolean z3, boolean z4, boolean z5) {
        boolean z6;
        int i2;
        int i3;
        int i4;
        int i5;
        e eVar = (e) view.getLayoutParams();
        if (!z2 || ((ViewGroup.MarginLayoutParams) eVar).leftMargin == (i5 = rect.left)) {
            z6 = false;
        } else {
            ((ViewGroup.MarginLayoutParams) eVar).leftMargin = i5;
            z6 = true;
        }
        if (z3 && ((ViewGroup.MarginLayoutParams) eVar).topMargin != (i4 = rect.top)) {
            ((ViewGroup.MarginLayoutParams) eVar).topMargin = i4;
            z6 = true;
        }
        if (z5 && ((ViewGroup.MarginLayoutParams) eVar).rightMargin != (i3 = rect.right)) {
            ((ViewGroup.MarginLayoutParams) eVar).rightMargin = i3;
            z6 = true;
        }
        if (!z4 || ((ViewGroup.MarginLayoutParams) eVar).bottomMargin == (i2 = rect.bottom)) {
            return z6;
        }
        ((ViewGroup.MarginLayoutParams) eVar).bottomMargin = i2;
        return true;
    }

    public void q() {
        removeCallbacks(this.D);
        removeCallbacks(this.E);
        ViewPropertyAnimator viewPropertyAnimator = this.B;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
    }

    public final void r(Context context) {
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(G);
        boolean z2 = false;
        this.b = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        Drawable drawable = obtainStyledAttributes.getDrawable(1);
        this.f69g = drawable;
        setWillNotDraw(drawable == null);
        obtainStyledAttributes.recycle();
        if (context.getApplicationInfo().targetSdkVersion < 19) {
            z2 = true;
        }
        this.f70h = z2;
        this.A = new OverScroller(context);
    }

    public void s() {
        h0 h0Var;
        if (this.f66d == null) {
            this.f66d = (ContentFrameLayout) findViewById(R$id.action_bar_activity_content);
            this.f67e = (ActionBarContainer) findViewById(R$id.action_bar_container);
            View findViewById = findViewById(R$id.action_bar);
            if (findViewById instanceof h0) {
                h0Var = (h0) findViewById;
            } else if (findViewById instanceof Toolbar) {
                h0Var = ((Toolbar) findViewById).getWrapper();
            } else {
                StringBuilder h2 = f.a.a.a.a.h("Can't make a decor toolbar out of ");
                h2.append(findViewById.getClass().getSimpleName());
                throw new IllegalStateException(h2.toString());
            }
            this.f68f = h0Var;
        }
    }

    public void setActionBarHideOffset(int i2) {
        q();
        this.f67e.setTranslationY((float) (-Math.max(0, Math.min(i2, this.f67e.getHeight()))));
    }

    public void setActionBarVisibilityCallback(d dVar) {
        this.z = dVar;
        if (getWindowToken() != null) {
            ((w) this.z).o = this.c;
            int i2 = this.n;
            if (i2 != 0) {
                onWindowSystemUiVisibilityChanged(i2);
                AtomicInteger atomicInteger = v.a;
                v.h.c(this);
            }
        }
    }

    public void setHasNonEmbeddedTabs(boolean z2) {
        this.f72j = z2;
    }

    public void setHideOnContentScrollEnabled(boolean z2) {
        if (z2 != this.f73k) {
            this.f73k = z2;
            if (!z2) {
                q();
                setActionBarHideOffset(0);
            }
        }
    }

    public void setIcon(int i2) {
        s();
        this.f68f.setIcon(i2);
    }

    public void setIcon(Drawable drawable) {
        s();
        this.f68f.setIcon(drawable);
    }

    public void setLogo(int i2) {
        s();
        this.f68f.m(i2);
    }

    public void setOverlayMode(boolean z2) {
        this.f71i = z2;
        this.f70h = z2 && getContext().getApplicationInfo().targetSdkVersion < 19;
    }

    public void setShowingForActionMode(boolean z2) {
    }

    public void setUiOptions(int i2) {
    }

    @Override // e.b.f.g0
    public void setWindowCallback(Window.Callback callback) {
        s();
        this.f68f.setWindowCallback(callback);
    }

    @Override // e.b.f.g0
    public void setWindowTitle(CharSequence charSequence) {
        s();
        this.f68f.setWindowTitle(charSequence);
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }
}
