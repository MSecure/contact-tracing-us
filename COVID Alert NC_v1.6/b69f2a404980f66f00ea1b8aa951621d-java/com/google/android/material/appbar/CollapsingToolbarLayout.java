package com.google.android.material.appbar;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.appcompat.widget.Toolbar;
import b.b.k.i;
import b.i.l.m;
import b.i.l.v;
import c.b.a.b.c0.c;
import c.b.a.b.k;
import c.b.a.b.l;
import c.b.a.b.n.f;
import c.b.a.b.n.g;
import com.google.android.material.appbar.AppBarLayout;
import java.util.ArrayList;
import java.util.List;

public class CollapsingToolbarLayout extends FrameLayout {
    public static final int y = k.Widget_Design_CollapsingToolbar;

    /* renamed from: b  reason: collision with root package name */
    public boolean f4445b = true;

    /* renamed from: c  reason: collision with root package name */
    public int f4446c;

    /* renamed from: d  reason: collision with root package name */
    public Toolbar f4447d;

    /* renamed from: e  reason: collision with root package name */
    public View f4448e;
    public View f;
    public int g;
    public int h;
    public int i;
    public int j;
    public final Rect k = new Rect();
    public final c.b.a.b.c0.b l;
    public boolean m;
    public boolean n;
    public Drawable o;
    public Drawable p;
    public int q;
    public boolean r;
    public ValueAnimator s;
    public long t;
    public int u = -1;
    public AppBarLayout.c v;
    public int w;
    public v x;

    public static class a extends FrameLayout.LayoutParams {

        /* renamed from: a  reason: collision with root package name */
        public int f4449a = 0;

        /* renamed from: b  reason: collision with root package name */
        public float f4450b = 0.5f;

        public a(int i, int i2) {
            super(i, i2);
        }

        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l.CollapsingToolbarLayout_Layout);
            this.f4449a = obtainStyledAttributes.getInt(l.CollapsingToolbarLayout_Layout_layout_collapseMode, 0);
            this.f4450b = obtainStyledAttributes.getFloat(l.CollapsingToolbarLayout_Layout_layout_collapseParallaxMultiplier, 0.5f);
            obtainStyledAttributes.recycle();
        }

        public a(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    public class b implements AppBarLayout.c {
        public b() {
        }

        @Override // com.google.android.material.appbar.AppBarLayout.a
        public void a(AppBarLayout appBarLayout, int i) {
            int i2;
            CollapsingToolbarLayout collapsingToolbarLayout = CollapsingToolbarLayout.this;
            collapsingToolbarLayout.w = i;
            v vVar = collapsingToolbarLayout.x;
            int e2 = vVar != null ? vVar.e() : 0;
            int childCount = CollapsingToolbarLayout.this.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = CollapsingToolbarLayout.this.getChildAt(i3);
                a aVar = (a) childAt.getLayoutParams();
                c.b.a.b.n.k d2 = CollapsingToolbarLayout.d(childAt);
                int i4 = aVar.f4449a;
                if (i4 == 1) {
                    i2 = i.j.w(-i, 0, CollapsingToolbarLayout.this.c(childAt));
                } else if (i4 == 2) {
                    i2 = Math.round(((float) (-i)) * aVar.f4450b);
                }
                d2.b(i2);
            }
            CollapsingToolbarLayout.this.f();
            CollapsingToolbarLayout collapsingToolbarLayout2 = CollapsingToolbarLayout.this;
            if (collapsingToolbarLayout2.p != null && e2 > 0) {
                m.L(collapsingToolbarLayout2);
            }
            CollapsingToolbarLayout.this.l.w(((float) Math.abs(i)) / ((float) ((CollapsingToolbarLayout.this.getHeight() - m.p(CollapsingToolbarLayout.this)) - e2)));
        }
    }

    public CollapsingToolbarLayout(Context context, AttributeSet attributeSet) {
        super(c.b.a.b.m0.a.a.a(context, attributeSet, 0, y), attributeSet, 0);
        Context context2 = getContext();
        c.b.a.b.c0.b bVar = new c.b.a.b.c0.b(this);
        this.l = bVar;
        bVar.K = c.b.a.b.m.a.f3112e;
        bVar.m();
        TypedArray d2 = c.b.a.b.c0.i.d(context2, attributeSet, l.CollapsingToolbarLayout, 0, y, new int[0]);
        this.l.u(d2.getInt(l.CollapsingToolbarLayout_expandedTitleGravity, 8388691));
        this.l.q(d2.getInt(l.CollapsingToolbarLayout_collapsedTitleGravity, 8388627));
        int dimensionPixelSize = d2.getDimensionPixelSize(l.CollapsingToolbarLayout_expandedTitleMargin, 0);
        this.j = dimensionPixelSize;
        this.i = dimensionPixelSize;
        this.h = dimensionPixelSize;
        this.g = dimensionPixelSize;
        if (d2.hasValue(l.CollapsingToolbarLayout_expandedTitleMarginStart)) {
            this.g = d2.getDimensionPixelSize(l.CollapsingToolbarLayout_expandedTitleMarginStart, 0);
        }
        if (d2.hasValue(l.CollapsingToolbarLayout_expandedTitleMarginEnd)) {
            this.i = d2.getDimensionPixelSize(l.CollapsingToolbarLayout_expandedTitleMarginEnd, 0);
        }
        if (d2.hasValue(l.CollapsingToolbarLayout_expandedTitleMarginTop)) {
            this.h = d2.getDimensionPixelSize(l.CollapsingToolbarLayout_expandedTitleMarginTop, 0);
        }
        if (d2.hasValue(l.CollapsingToolbarLayout_expandedTitleMarginBottom)) {
            this.j = d2.getDimensionPixelSize(l.CollapsingToolbarLayout_expandedTitleMarginBottom, 0);
        }
        this.m = d2.getBoolean(l.CollapsingToolbarLayout_titleEnabled, true);
        setTitle(d2.getText(l.CollapsingToolbarLayout_title));
        this.l.s(k.TextAppearance_Design_CollapsingToolbar_Expanded);
        this.l.o(b.b.i.TextAppearance_AppCompat_Widget_ActionBar_Title);
        if (d2.hasValue(l.CollapsingToolbarLayout_expandedTitleTextAppearance)) {
            this.l.s(d2.getResourceId(l.CollapsingToolbarLayout_expandedTitleTextAppearance, 0));
        }
        if (d2.hasValue(l.CollapsingToolbarLayout_collapsedTitleTextAppearance)) {
            this.l.o(d2.getResourceId(l.CollapsingToolbarLayout_collapsedTitleTextAppearance, 0));
        }
        this.u = d2.getDimensionPixelSize(l.CollapsingToolbarLayout_scrimVisibleHeightTrigger, -1);
        if (d2.hasValue(l.CollapsingToolbarLayout_maxLines)) {
            c.b.a.b.c0.b bVar2 = this.l;
            int i2 = d2.getInt(l.CollapsingToolbarLayout_maxLines, 1);
            if (i2 != bVar2.Y) {
                bVar2.Y = i2;
                bVar2.f();
                bVar2.m();
            }
        }
        this.t = (long) d2.getInt(l.CollapsingToolbarLayout_scrimAnimationDuration, 600);
        setContentScrim(d2.getDrawable(l.CollapsingToolbarLayout_contentScrim));
        setStatusBarScrim(d2.getDrawable(l.CollapsingToolbarLayout_statusBarScrim));
        this.f4446c = d2.getResourceId(l.CollapsingToolbarLayout_toolbarId, -1);
        d2.recycle();
        setWillNotDraw(false);
        m.b0(this, new f(this));
    }

    public static int b(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            return view.getHeight();
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        return view.getHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    public static c.b.a.b.n.k d(View view) {
        c.b.a.b.n.k kVar = (c.b.a.b.n.k) view.getTag(c.b.a.b.f.view_offset_helper);
        if (kVar != null) {
            return kVar;
        }
        c.b.a.b.n.k kVar2 = new c.b.a.b.n.k(view);
        view.setTag(c.b.a.b.f.view_offset_helper, kVar2);
        return kVar2;
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:29:0x0028 */
    public final void a() {
        if (this.f4445b) {
            Toolbar toolbar = null;
            this.f4447d = null;
            this.f4448e = null;
            int i2 = this.f4446c;
            if (i2 != -1) {
                Toolbar toolbar2 = (Toolbar) findViewById(i2);
                this.f4447d = toolbar2;
                if (toolbar2 != null) {
                    ViewParent parent = toolbar2.getParent();
                    View view = toolbar2;
                    while (parent != this && parent != null) {
                        if (parent instanceof View) {
                            view = (View) parent;
                        }
                        parent = parent.getParent();
                        view = view;
                    }
                    this.f4448e = view;
                }
            }
            if (this.f4447d == null) {
                int childCount = getChildCount();
                int i3 = 0;
                while (true) {
                    if (i3 >= childCount) {
                        break;
                    }
                    View childAt = getChildAt(i3);
                    if (childAt instanceof Toolbar) {
                        toolbar = (Toolbar) childAt;
                        break;
                    }
                    i3++;
                }
                this.f4447d = toolbar;
            }
            e();
            this.f4445b = false;
        }
    }

    public final int c(View view) {
        return ((getHeight() - d(view).f3158b) - view.getHeight()) - ((FrameLayout.LayoutParams) ((a) view.getLayoutParams())).bottomMargin;
    }

    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof a;
    }

    public void draw(Canvas canvas) {
        Drawable drawable;
        super.draw(canvas);
        a();
        if (this.f4447d == null && (drawable = this.o) != null && this.q > 0) {
            drawable.mutate().setAlpha(this.q);
            this.o.draw(canvas);
        }
        if (this.m && this.n) {
            this.l.g(canvas);
        }
        if (this.p != null && this.q > 0) {
            v vVar = this.x;
            int e2 = vVar != null ? vVar.e() : 0;
            if (e2 > 0) {
                this.p.setBounds(0, -this.w, getWidth(), e2 - this.w);
                this.p.mutate().setAlpha(this.q);
                this.p.draw(canvas);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0018, code lost:
        r0 = true;
     */
    public boolean drawChild(Canvas canvas, View view, long j2) {
        boolean z;
        if (this.o != null && this.q > 0) {
            if ((r0 = this.f4448e) != null) {
            }
            boolean z2 = false;
            if (z2) {
                this.o.mutate().setAlpha(this.q);
                this.o.draw(canvas);
                z = true;
                return super.drawChild(canvas, view, j2) || z;
            }
        }
        z = false;
        if (super.drawChild(canvas, view, j2)) {
            return true;
        }
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.p;
        boolean z = false;
        if (drawable != null && drawable.isStateful()) {
            z = false | drawable.setState(drawableState);
        }
        Drawable drawable2 = this.o;
        if (drawable2 != null && drawable2.isStateful()) {
            z |= drawable2.setState(drawableState);
        }
        c.b.a.b.c0.b bVar = this.l;
        if (bVar != null) {
            z |= bVar.y(drawableState);
        }
        if (z) {
            invalidate();
        }
    }

    public final void e() {
        View view;
        if (!this.m && (view = this.f) != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f);
            }
        }
        if (this.m && this.f4447d != null) {
            if (this.f == null) {
                this.f = new View(getContext());
            }
            if (this.f.getParent() == null) {
                this.f4447d.addView(this.f, -1, -1);
            }
        }
    }

    public final void f() {
        if (this.o != null || this.p != null) {
            setScrimsShown(getHeight() + this.w < getScrimVisibleHeightTrigger());
        }
    }

    @Override // android.widget.FrameLayout, android.widget.FrameLayout
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new a(-1, -1);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new a(layoutParams);
    }

    @Override // android.widget.FrameLayout, android.widget.FrameLayout, android.view.ViewGroup
    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new a(getContext(), attributeSet);
    }

    public int getCollapsedTitleGravity() {
        return this.l.h;
    }

    public Typeface getCollapsedTitleTypeface() {
        Typeface typeface = this.l.s;
        return typeface != null ? typeface : Typeface.DEFAULT;
    }

    public Drawable getContentScrim() {
        return this.o;
    }

    public int getExpandedTitleGravity() {
        return this.l.g;
    }

    public int getExpandedTitleMarginBottom() {
        return this.j;
    }

    public int getExpandedTitleMarginEnd() {
        return this.i;
    }

    public int getExpandedTitleMarginStart() {
        return this.g;
    }

    public int getExpandedTitleMarginTop() {
        return this.h;
    }

    public Typeface getExpandedTitleTypeface() {
        Typeface typeface = this.l.t;
        return typeface != null ? typeface : Typeface.DEFAULT;
    }

    public int getMaxLines() {
        return this.l.Y;
    }

    public int getScrimAlpha() {
        return this.q;
    }

    public long getScrimAnimationDuration() {
        return this.t;
    }

    public int getScrimVisibleHeightTrigger() {
        int i2 = this.u;
        if (i2 >= 0) {
            return i2;
        }
        v vVar = this.x;
        int e2 = vVar != null ? vVar.e() : 0;
        int p2 = m.p(this);
        return p2 > 0 ? Math.min((p2 * 2) + e2, getHeight()) : getHeight() / 3;
    }

    public Drawable getStatusBarScrim() {
        return this.p;
    }

    public CharSequence getTitle() {
        if (this.m) {
            return this.l.x;
        }
        return null;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (parent instanceof AppBarLayout) {
            setFitsSystemWindows(m.l((View) parent));
            if (this.v == null) {
                this.v = new b();
            }
            AppBarLayout appBarLayout = (AppBarLayout) parent;
            AppBarLayout.c cVar = this.v;
            if (appBarLayout.i == null) {
                appBarLayout.i = new ArrayList();
            }
            if (cVar != null && !appBarLayout.i.contains(cVar)) {
                appBarLayout.i.add(cVar);
            }
            requestApplyInsets();
        }
    }

    public void onDetachedFromWindow() {
        List<AppBarLayout.a> list;
        ViewParent parent = getParent();
        AppBarLayout.c cVar = this.v;
        if (!(cVar == null || !(parent instanceof AppBarLayout) || (list = ((AppBarLayout) parent).i) == null || cVar == null)) {
            list.remove(cVar);
        }
        super.onDetachedFromWindow();
    }

    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        View view;
        super.onLayout(z, i2, i3, i4, i5);
        v vVar = this.x;
        if (vVar != null) {
            int e2 = vVar.e();
            int childCount = getChildCount();
            for (int i6 = 0; i6 < childCount; i6++) {
                View childAt = getChildAt(i6);
                if (!m.l(childAt) && childAt.getTop() < e2) {
                    childAt.offsetTopAndBottom(e2);
                }
            }
        }
        int childCount2 = getChildCount();
        for (int i7 = 0; i7 < childCount2; i7++) {
            c.b.a.b.n.k d2 = d(getChildAt(i7));
            d2.f3158b = d2.f3157a.getTop();
            d2.f3159c = d2.f3157a.getLeft();
        }
        if (this.m && (view = this.f) != null) {
            boolean z2 = m.A(view) && this.f.getVisibility() == 0;
            this.n = z2;
            if (z2) {
                boolean z3 = getLayoutDirection() == 1;
                View view2 = this.f4448e;
                if (view2 == null) {
                    view2 = this.f4447d;
                }
                int c2 = c(view2);
                c.a(this, this.f, this.k);
                c.b.a.b.c0.b bVar = this.l;
                int i8 = this.k.left;
                Toolbar toolbar = this.f4447d;
                int titleMarginEnd = i8 + (z3 ? toolbar.getTitleMarginEnd() : toolbar.getTitleMarginStart());
                int titleMarginTop = this.f4447d.getTitleMarginTop() + this.k.top + c2;
                int i9 = this.k.right;
                Toolbar toolbar2 = this.f4447d;
                int titleMarginStart = i9 + (z3 ? toolbar2.getTitleMarginStart() : toolbar2.getTitleMarginEnd());
                int titleMarginBottom = (this.k.bottom + c2) - this.f4447d.getTitleMarginBottom();
                if (!c.b.a.b.c0.b.n(bVar.f2929e, titleMarginEnd, titleMarginTop, titleMarginStart, titleMarginBottom)) {
                    bVar.f2929e.set(titleMarginEnd, titleMarginTop, titleMarginStart, titleMarginBottom);
                    bVar.G = true;
                    bVar.l();
                }
                c.b.a.b.c0.b bVar2 = this.l;
                int i10 = z3 ? this.i : this.g;
                int i11 = this.k.top + this.h;
                int i12 = (i4 - i2) - (z3 ? this.g : this.i);
                int i13 = (i5 - i3) - this.j;
                if (!c.b.a.b.c0.b.n(bVar2.f2928d, i10, i11, i12, i13)) {
                    bVar2.f2928d.set(i10, i11, i12, i13);
                    bVar2.G = true;
                    bVar2.l();
                }
                this.l.m();
            }
        }
        if (this.f4447d != null) {
            if (this.m && TextUtils.isEmpty(this.l.x)) {
                setTitle(this.f4447d.getTitle());
            }
            View view3 = this.f4448e;
            if (view3 == null || view3 == this) {
                view3 = this.f4447d;
            }
            setMinimumHeight(b(view3));
        }
        f();
        int childCount3 = getChildCount();
        for (int i14 = 0; i14 < childCount3; i14++) {
            d(getChildAt(i14)).a();
        }
    }

    public void onMeasure(int i2, int i3) {
        a();
        super.onMeasure(i2, i3);
        int mode = View.MeasureSpec.getMode(i3);
        v vVar = this.x;
        int e2 = vVar != null ? vVar.e() : 0;
        if (mode == 0 && e2 > 0) {
            super.onMeasure(i2, View.MeasureSpec.makeMeasureSpec(getMeasuredHeight() + e2, 1073741824));
        }
    }

    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        Drawable drawable = this.o;
        if (drawable != null) {
            drawable.setBounds(0, 0, i2, i3);
        }
    }

    public void setCollapsedTitleGravity(int i2) {
        c.b.a.b.c0.b bVar = this.l;
        if (bVar.h != i2) {
            bVar.h = i2;
            bVar.m();
        }
    }

    public void setCollapsedTitleTextAppearance(int i2) {
        this.l.o(i2);
    }

    public void setCollapsedTitleTextColor(int i2) {
        setCollapsedTitleTextColor(ColorStateList.valueOf(i2));
    }

    public void setCollapsedTitleTextColor(ColorStateList colorStateList) {
        c.b.a.b.c0.b bVar = this.l;
        if (bVar.l != colorStateList) {
            bVar.l = colorStateList;
            bVar.m();
        }
    }

    public void setCollapsedTitleTypeface(Typeface typeface) {
        this.l.r(typeface);
    }

    public void setContentScrim(Drawable drawable) {
        Drawable drawable2 = this.o;
        if (drawable2 != drawable) {
            Drawable drawable3 = null;
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            if (drawable != null) {
                drawable3 = drawable.mutate();
            }
            this.o = drawable3;
            if (drawable3 != null) {
                drawable3.setBounds(0, 0, getWidth(), getHeight());
                this.o.setCallback(this);
                this.o.setAlpha(this.q);
            }
            m.L(this);
        }
    }

    public void setContentScrimColor(int i2) {
        setContentScrim(new ColorDrawable(i2));
    }

    public void setContentScrimResource(int i2) {
        setContentScrim(b.i.e.a.c(getContext(), i2));
    }

    public void setExpandedTitleColor(int i2) {
        setExpandedTitleTextColor(ColorStateList.valueOf(i2));
    }

    public void setExpandedTitleGravity(int i2) {
        c.b.a.b.c0.b bVar = this.l;
        if (bVar.g != i2) {
            bVar.g = i2;
            bVar.m();
        }
    }

    public void setExpandedTitleMarginBottom(int i2) {
        this.j = i2;
        requestLayout();
    }

    public void setExpandedTitleMarginEnd(int i2) {
        this.i = i2;
        requestLayout();
    }

    public void setExpandedTitleMarginStart(int i2) {
        this.g = i2;
        requestLayout();
    }

    public void setExpandedTitleMarginTop(int i2) {
        this.h = i2;
        requestLayout();
    }

    public void setExpandedTitleTextAppearance(int i2) {
        this.l.s(i2);
    }

    public void setExpandedTitleTextColor(ColorStateList colorStateList) {
        c.b.a.b.c0.b bVar = this.l;
        if (bVar.k != colorStateList) {
            bVar.k = colorStateList;
            bVar.m();
        }
    }

    public void setExpandedTitleTypeface(Typeface typeface) {
        this.l.v(typeface);
    }

    public void setMaxLines(int i2) {
        c.b.a.b.c0.b bVar = this.l;
        if (i2 != bVar.Y) {
            bVar.Y = i2;
            bVar.f();
            bVar.m();
        }
    }

    public void setScrimAlpha(int i2) {
        Toolbar toolbar;
        if (i2 != this.q) {
            if (!(this.o == null || (toolbar = this.f4447d) == null)) {
                m.L(toolbar);
            }
            this.q = i2;
            m.L(this);
        }
    }

    public void setScrimAnimationDuration(long j2) {
        this.t = j2;
    }

    public void setScrimVisibleHeightTrigger(int i2) {
        if (this.u != i2) {
            this.u = i2;
            f();
        }
    }

    public void setScrimsShown(boolean z) {
        int i2 = 0;
        boolean z2 = m.B(this) && !isInEditMode();
        if (this.r != z) {
            int i3 = 255;
            if (z2) {
                if (!z) {
                    i3 = 0;
                }
                a();
                ValueAnimator valueAnimator = this.s;
                if (valueAnimator == null) {
                    ValueAnimator valueAnimator2 = new ValueAnimator();
                    this.s = valueAnimator2;
                    valueAnimator2.setDuration(this.t);
                    this.s.setInterpolator(i3 > this.q ? c.b.a.b.m.a.f3110c : c.b.a.b.m.a.f3111d);
                    this.s.addUpdateListener(new g(this));
                } else if (valueAnimator.isRunning()) {
                    this.s.cancel();
                }
                this.s.setIntValues(this.q, i3);
                this.s.start();
            } else {
                if (z) {
                    i2 = 255;
                }
                setScrimAlpha(i2);
            }
            this.r = z;
        }
    }

    public void setStatusBarScrim(Drawable drawable) {
        Drawable drawable2 = this.p;
        if (drawable2 != drawable) {
            Drawable drawable3 = null;
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            if (drawable != null) {
                drawable3 = drawable.mutate();
            }
            this.p = drawable3;
            if (drawable3 != null) {
                if (drawable3.isStateful()) {
                    this.p.setState(getDrawableState());
                }
                this.p.setLayoutDirection(m.o(this));
                this.p.setVisible(getVisibility() == 0, false);
                this.p.setCallback(this);
                this.p.setAlpha(this.q);
            }
            m.L(this);
        }
    }

    public void setStatusBarScrimColor(int i2) {
        setStatusBarScrim(new ColorDrawable(i2));
    }

    public void setStatusBarScrimResource(int i2) {
        setStatusBarScrim(b.i.e.a.c(getContext(), i2));
    }

    public void setTitle(CharSequence charSequence) {
        this.l.z(charSequence);
        setContentDescription(getTitle());
    }

    public void setTitleEnabled(boolean z) {
        if (z != this.m) {
            this.m = z;
            setContentDescription(getTitle());
            e();
            requestLayout();
        }
    }

    public void setVisibility(int i2) {
        super.setVisibility(i2);
        boolean z = i2 == 0;
        Drawable drawable = this.p;
        if (!(drawable == null || drawable.isVisible() == z)) {
            this.p.setVisible(z, false);
        }
        Drawable drawable2 = this.o;
        if (drawable2 != null && drawable2.isVisible() != z) {
            this.o.setVisible(z, false);
        }
    }

    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.o || drawable == this.p;
    }

    @Override // android.widget.FrameLayout, android.widget.FrameLayout
    /* renamed from: generateDefaultLayoutParams  reason: collision with other method in class */
    public FrameLayout.LayoutParams m350generateDefaultLayoutParams() {
        return new a(-1, -1);
    }
}
