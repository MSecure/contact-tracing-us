package androidx.appcompat.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
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
import androidx.recyclerview.widget.RecyclerView;
import b.b.f;
import b.b.k.u;
import b.b.p.i.m;
import b.b.q.c0;
import b.b.q.d0;
import b.i.l.g;
import b.i.l.h;
import b.i.l.i;
import b.i.l.v;
import com.google.android.gms.nearby.messages.BleSignal;

@SuppressLint({"UnknownNullness"})
public class ActionBarOverlayLayout extends ViewGroup implements c0, g, h {
    public static final int[] G = {b.b.a.actionBarSize, 16842841};
    public OverScroller A;
    public ViewPropertyAnimator B;
    public final AnimatorListenerAdapter C;
    public final Runnable D;
    public final Runnable E;
    public final i F;

    /* renamed from: b  reason: collision with root package name */
    public int f84b;

    /* renamed from: c  reason: collision with root package name */
    public int f85c = 0;

    /* renamed from: d  reason: collision with root package name */
    public ContentFrameLayout f86d;

    /* renamed from: e  reason: collision with root package name */
    public ActionBarContainer f87e;

    /* renamed from: f  reason: collision with root package name */
    public d0 f88f;

    /* renamed from: g  reason: collision with root package name */
    public Drawable f89g;
    public boolean h;
    public boolean i;
    public boolean j;
    public boolean k;
    public boolean l;
    public int m;
    public int n;
    public final Rect o = new Rect();
    public final Rect p = new Rect();
    public final Rect q = new Rect();
    public final Rect r = new Rect();
    public final Rect s = new Rect();
    public final Rect t = new Rect();
    public final Rect u = new Rect();
    public v v;
    public v w;
    public v x;
    public v y;
    public d z;

    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        public void onAnimationCancel(Animator animator) {
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.B = null;
            actionBarOverlayLayout.l = false;
        }

        public void onAnimationEnd(Animator animator) {
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.B = null;
            actionBarOverlayLayout.l = false;
        }
    }

    public class b implements Runnable {
        public b() {
        }

        public void run() {
            ActionBarOverlayLayout.this.q();
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.B = actionBarOverlayLayout.f87e.animate().translationY(0.0f).setListener(ActionBarOverlayLayout.this.C);
        }
    }

    public class c implements Runnable {
        public c() {
        }

        public void run() {
            ActionBarOverlayLayout.this.q();
            ActionBarOverlayLayout actionBarOverlayLayout = ActionBarOverlayLayout.this;
            actionBarOverlayLayout.B = actionBarOverlayLayout.f87e.animate().translationY((float) (-ActionBarOverlayLayout.this.f87e.getHeight())).setListener(ActionBarOverlayLayout.this.C);
        }
    }

    public interface d {
    }

    public static class e extends ViewGroup.MarginLayoutParams {
        public e(int i, int i2) {
            super(i, i2);
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
        v vVar = v.f1888b;
        this.v = vVar;
        this.w = vVar;
        this.x = vVar;
        this.y = vVar;
        this.C = new a();
        this.D = new b();
        this.E = new c();
        r(context);
        this.F = new i();
    }

    @Override // b.b.q.c0
    public void a(Menu menu, m.a aVar) {
        s();
        this.f88f.a(menu, aVar);
    }

    @Override // b.b.q.c0
    public boolean b() {
        s();
        return this.f88f.b();
    }

    @Override // b.b.q.c0
    public boolean c() {
        s();
        return this.f88f.c();
    }

    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof e;
    }

    @Override // b.b.q.c0
    public boolean d() {
        s();
        return this.f88f.d();
    }

    public void draw(Canvas canvas) {
        int i2;
        super.draw(canvas);
        if (this.f89g != null && !this.h) {
            if (this.f87e.getVisibility() == 0) {
                i2 = (int) (this.f87e.getTranslationY() + ((float) this.f87e.getBottom()) + 0.5f);
            } else {
                i2 = 0;
            }
            this.f89g.setBounds(0, i2, getWidth(), this.f89g.getIntrinsicHeight() + i2);
            this.f89g.draw(canvas);
        }
    }

    @Override // b.b.q.c0
    public boolean e() {
        s();
        return this.f88f.e();
    }

    @Override // b.b.q.c0
    public void f() {
        s();
        this.f88f.f();
    }

    public boolean fitSystemWindows(Rect rect) {
        return super.fitSystemWindows(rect);
    }

    @Override // b.b.q.c0
    public boolean g() {
        s();
        return this.f88f.g();
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
        ActionBarContainer actionBarContainer = this.f87e;
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
        return this.f88f.getTitle();
    }

    @Override // b.i.l.g
    public void h(View view, View view2, int i2, int i3) {
        if (i3 == 0) {
            onNestedScrollAccepted(view, view2, i2);
        }
    }

    @Override // b.i.l.g
    public void i(View view, int i2) {
        if (i2 == 0) {
            onStopNestedScroll(view);
        }
    }

    @Override // b.i.l.g
    public void j(View view, int i2, int i3, int[] iArr, int i4) {
        if (i4 == 0) {
            onNestedPreScroll(view, i2, i3, iArr);
        }
    }

    @Override // b.b.q.c0
    public void k(int i2) {
        s();
        if (i2 == 2) {
            this.f88f.t();
        } else if (i2 == 5) {
            this.f88f.v();
        } else if (i2 == 109) {
            setOverlayMode(true);
        }
    }

    @Override // b.b.q.c0
    public void l() {
        s();
        this.f88f.h();
    }

    @Override // b.i.l.h
    public void m(View view, int i2, int i3, int i4, int i5, int i6, int[] iArr) {
        if (i6 == 0) {
            onNestedScroll(view, i2, i3, i4, i5);
        }
    }

    @Override // b.i.l.g
    public void n(View view, int i2, int i3, int i4, int i5, int i6) {
        if (i6 == 0) {
            onNestedScroll(view, i2, i3, i4, i5);
        }
    }

    @Override // b.i.l.g
    public boolean o(View view, View view2, int i2, int i3) {
        return i3 == 0 && onStartNestedScroll(view, view2, i2);
    }

    public WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        s();
        if (windowInsets != null) {
            v vVar = new v(windowInsets);
            boolean p2 = p(this.f87e, new Rect(vVar.b(), vVar.d(), vVar.c(), vVar.a()), true, true, false, true);
            b.i.l.m.b(this, vVar, this.o);
            Rect rect = this.o;
            v h2 = vVar.f1889a.h(rect.left, rect.top, rect.right, rect.bottom);
            this.v = h2;
            boolean z2 = true;
            if (!this.w.equals(h2)) {
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
            return vVar.f1889a.a().f1889a.c().f1889a.b().i();
        }
        throw null;
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        r(getContext());
        b.i.l.m.S(this);
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
        v vVar;
        s();
        measureChildWithMargins(this.f87e, i2, 0, i3, 0);
        e eVar = (e) this.f87e.getLayoutParams();
        int max = Math.max(0, this.f87e.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) eVar).leftMargin + ((ViewGroup.MarginLayoutParams) eVar).rightMargin);
        int max2 = Math.max(0, this.f87e.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) eVar).topMargin + ((ViewGroup.MarginLayoutParams) eVar).bottomMargin);
        int combineMeasuredStates = View.combineMeasuredStates(0, this.f87e.getMeasuredState());
        boolean z2 = (b.i.l.m.w(this) & RecyclerView.a0.FLAG_TMP_DETACHED) != 0;
        if (z2) {
            i4 = this.f84b;
            if (this.j && this.f87e.getTabContainer() != null) {
                i4 += this.f84b;
            }
        } else {
            i4 = this.f87e.getVisibility() != 8 ? this.f87e.getMeasuredHeight() : 0;
        }
        this.q.set(this.o);
        v vVar2 = this.v;
        this.x = vVar2;
        if (this.i || z2) {
            b.i.f.b a2 = b.i.f.b.a(this.x.b(), this.x.d() + i4, this.x.c(), this.x.a() + 0);
            v vVar3 = this.x;
            v.c bVar = Build.VERSION.SDK_INT >= 29 ? new v.b(vVar3) : new v.a(vVar3);
            bVar.c(a2);
            vVar = bVar.a();
        } else {
            Rect rect = this.q;
            rect.top += i4;
            rect.bottom += 0;
            vVar = vVar2.f1889a.h(0, i4, 0, 0);
        }
        this.x = vVar;
        p(this.f86d, this.q, true, true, true, true);
        if (!this.y.equals(this.x)) {
            v vVar4 = this.x;
            this.y = vVar4;
            b.i.l.m.c(this.f86d, vVar4);
        }
        measureChildWithMargins(this.f86d, i2, 0, i3, 0);
        e eVar2 = (e) this.f86d.getLayoutParams();
        int max3 = Math.max(max, this.f86d.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) eVar2).leftMargin + ((ViewGroup.MarginLayoutParams) eVar2).rightMargin);
        int max4 = Math.max(max2, this.f86d.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) eVar2).topMargin + ((ViewGroup.MarginLayoutParams) eVar2).bottomMargin);
        int combineMeasuredStates2 = View.combineMeasuredStates(combineMeasuredStates, this.f86d.getMeasuredState());
        setMeasuredDimension(View.resolveSizeAndState(Math.max(getPaddingRight() + getPaddingLeft() + max3, getSuggestedMinimumWidth()), i2, combineMeasuredStates2), View.resolveSizeAndState(Math.max(getPaddingBottom() + getPaddingTop() + max4, getSuggestedMinimumHeight()), i3, combineMeasuredStates2 << 16));
    }

    public boolean onNestedFling(View view, float f2, float f3, boolean z2) {
        boolean z3 = false;
        if (!this.k || !z2) {
            return false;
        }
        this.A.fling(0, 0, 0, (int) f3, 0, 0, BleSignal.UNKNOWN_TX_POWER, Integer.MAX_VALUE);
        if (this.A.getFinalY() > this.f87e.getHeight()) {
            z3 = true;
        }
        if (z3) {
            q();
            this.E.run();
        } else {
            q();
            this.D.run();
        }
        this.l = true;
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
        u uVar;
        b.b.p.g gVar;
        this.F.f1861a = i2;
        this.m = getActionBarHideOffset();
        q();
        d dVar = this.z;
        if (dVar != null && (gVar = (uVar = (u) dVar).u) != null) {
            gVar.a();
            uVar.u = null;
        }
    }

    public boolean onStartNestedScroll(View view, View view2, int i2) {
        if ((i2 & 2) == 0 || this.f87e.getVisibility() != 0) {
            return false;
        }
        return this.k;
    }

    public void onStopNestedScroll(View view) {
        if (this.k && !this.l) {
            if (this.m <= this.f87e.getHeight()) {
                q();
                postDelayed(this.D, 600);
            } else {
                q();
                postDelayed(this.E, 600);
            }
        }
        d dVar = this.z;
        if (dVar != null && ((u) dVar) == null) {
            throw null;
        }
    }

    public void onWindowSystemUiVisibilityChanged(int i2) {
        super.onWindowSystemUiVisibilityChanged(i2);
        s();
        int i3 = this.n ^ i2;
        this.n = i2;
        boolean z2 = (i2 & 4) == 0;
        boolean z3 = (i2 & RecyclerView.a0.FLAG_TMP_DETACHED) != 0;
        d dVar = this.z;
        if (dVar != null) {
            ((u) dVar).p = !z3;
            if (z2 || !z3) {
                u uVar = (u) this.z;
                if (uVar.r) {
                    uVar.r = false;
                    uVar.s(true);
                }
            } else {
                u uVar2 = (u) dVar;
                if (!uVar2.r) {
                    uVar2.r = true;
                    uVar2.s(true);
                }
            }
        }
        if ((i3 & RecyclerView.a0.FLAG_TMP_DETACHED) != 0 && this.z != null) {
            b.i.l.m.S(this);
        }
    }

    public void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
        this.f85c = i2;
        d dVar = this.z;
        if (dVar != null) {
            ((u) dVar).o = i2;
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
        this.f84b = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        Drawable drawable = obtainStyledAttributes.getDrawable(1);
        this.f89g = drawable;
        setWillNotDraw(drawable == null);
        obtainStyledAttributes.recycle();
        if (context.getApplicationInfo().targetSdkVersion < 19) {
            z2 = true;
        }
        this.h = z2;
        this.A = new OverScroller(context);
    }

    public void s() {
        d0 d0Var;
        if (this.f86d == null) {
            this.f86d = (ContentFrameLayout) findViewById(f.action_bar_activity_content);
            this.f87e = (ActionBarContainer) findViewById(f.action_bar_container);
            View findViewById = findViewById(f.action_bar);
            if (findViewById instanceof d0) {
                d0Var = (d0) findViewById;
            } else if (findViewById instanceof Toolbar) {
                d0Var = ((Toolbar) findViewById).getWrapper();
            } else {
                StringBuilder h2 = c.a.a.a.a.h("Can't make a decor toolbar out of ");
                h2.append(findViewById.getClass().getSimpleName());
                throw new IllegalStateException(h2.toString());
            }
            this.f88f = d0Var;
        }
    }

    public void setActionBarHideOffset(int i2) {
        q();
        this.f87e.setTranslationY((float) (-Math.max(0, Math.min(i2, this.f87e.getHeight()))));
    }

    public void setActionBarVisibilityCallback(d dVar) {
        this.z = dVar;
        if (getWindowToken() != null) {
            ((u) this.z).o = this.f85c;
            int i2 = this.n;
            if (i2 != 0) {
                onWindowSystemUiVisibilityChanged(i2);
                b.i.l.m.S(this);
            }
        }
    }

    public void setHasNonEmbeddedTabs(boolean z2) {
        this.j = z2;
    }

    public void setHideOnContentScrollEnabled(boolean z2) {
        if (z2 != this.k) {
            this.k = z2;
            if (!z2) {
                q();
                setActionBarHideOffset(0);
            }
        }
    }

    public void setIcon(int i2) {
        s();
        this.f88f.setIcon(i2);
    }

    public void setIcon(Drawable drawable) {
        s();
        this.f88f.setIcon(drawable);
    }

    public void setLogo(int i2) {
        s();
        this.f88f.m(i2);
    }

    public void setOverlayMode(boolean z2) {
        this.i = z2;
        this.h = z2 && getContext().getApplicationInfo().targetSdkVersion < 19;
    }

    public void setShowingForActionMode(boolean z2) {
    }

    public void setUiOptions(int i2) {
    }

    @Override // b.b.q.c0
    public void setWindowCallback(Window.Callback callback) {
        s();
        this.f88f.setWindowCallback(callback);
    }

    @Override // b.b.q.c0
    public void setWindowTitle(CharSequence charSequence) {
        s();
        this.f88f.setWindowTitle(charSequence);
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }
}
