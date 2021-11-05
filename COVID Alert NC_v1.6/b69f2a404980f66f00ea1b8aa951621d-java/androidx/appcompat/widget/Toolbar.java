package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.ActionMenuView;
import b.b.j;
import b.b.k.a;
import b.b.p.i.g;
import b.b.p.i.i;
import b.b.p.i.m;
import b.b.p.i.r;
import b.b.q.a1;
import b.b.q.d0;
import b.b.q.e1;
import b.b.q.l;
import b.b.q.n;
import b.b.q.p0;
import b.b.q.y0;
import b.b.q.z;
import java.util.ArrayList;
import java.util.List;

public class Toolbar extends ViewGroup {
    public ColorStateList A;
    public ColorStateList B;
    public boolean C;
    public boolean D;
    public final ArrayList<View> E;
    public final ArrayList<View> F;
    public final int[] G;
    public f H;
    public final ActionMenuView.e I;
    public a1 J;
    public b.b.q.c K;
    public d L;
    public m.a M;
    public g.a N;
    public boolean O;
    public final Runnable P;

    /* renamed from: b  reason: collision with root package name */
    public ActionMenuView f86b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f87c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f88d;

    /* renamed from: e  reason: collision with root package name */
    public ImageButton f89e;
    public ImageView f;
    public Drawable g;
    public CharSequence h;
    public ImageButton i;
    public View j;
    public Context k;
    public int l;
    public int m;
    public int n;
    public int o;
    public int p;
    public int q;
    public int r;
    public int s;
    public int t;
    public p0 u;
    public int v;
    public int w;
    public int x;
    public CharSequence y;
    public CharSequence z;

    public class a implements ActionMenuView.e {
        public a() {
        }
    }

    public class b implements Runnable {
        public b() {
        }

        public void run() {
            Toolbar.this.u();
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        public void onClick(View view) {
            d dVar = Toolbar.this.L;
            i iVar = dVar == null ? null : dVar.f94c;
            if (iVar != null) {
                iVar.collapseActionView();
            }
        }
    }

    public class d implements m {

        /* renamed from: b  reason: collision with root package name */
        public b.b.p.i.g f93b;

        /* renamed from: c  reason: collision with root package name */
        public i f94c;

        public d() {
        }

        @Override // b.b.p.i.m
        public void b(b.b.p.i.g gVar, boolean z) {
        }

        @Override // b.b.p.i.m
        public boolean d() {
            return false;
        }

        @Override // b.b.p.i.m
        public void e(Context context, b.b.p.i.g gVar) {
            i iVar;
            b.b.p.i.g gVar2 = this.f93b;
            if (!(gVar2 == null || (iVar = this.f94c) == null)) {
                gVar2.d(iVar);
            }
            this.f93b = gVar;
        }

        @Override // b.b.p.i.m
        public boolean f(b.b.p.i.g gVar, i iVar) {
            View view = Toolbar.this.j;
            if (view instanceof b.b.p.b) {
                ((b.b.p.b) view).f();
            }
            Toolbar toolbar = Toolbar.this;
            toolbar.removeView(toolbar.j);
            Toolbar toolbar2 = Toolbar.this;
            toolbar2.removeView(toolbar2.i);
            Toolbar toolbar3 = Toolbar.this;
            toolbar3.j = null;
            int size = toolbar3.F.size();
            while (true) {
                size--;
                if (size >= 0) {
                    toolbar3.addView(toolbar3.F.get(size));
                } else {
                    toolbar3.F.clear();
                    this.f94c = null;
                    Toolbar.this.requestLayout();
                    iVar.C = false;
                    iVar.n.q(false);
                    return true;
                }
            }
        }

        @Override // b.b.p.i.m
        public boolean g(b.b.p.i.g gVar, i iVar) {
            Toolbar.this.c();
            ViewParent parent = Toolbar.this.i.getParent();
            Toolbar toolbar = Toolbar.this;
            if (parent != toolbar) {
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(toolbar.i);
                }
                Toolbar toolbar2 = Toolbar.this;
                toolbar2.addView(toolbar2.i);
            }
            Toolbar.this.j = iVar.getActionView();
            this.f94c = iVar;
            ViewParent parent2 = Toolbar.this.j.getParent();
            Toolbar toolbar3 = Toolbar.this;
            if (parent2 != toolbar3) {
                if (parent2 instanceof ViewGroup) {
                    ((ViewGroup) parent2).removeView(toolbar3.j);
                }
                e h = Toolbar.this.generateDefaultLayoutParams();
                Toolbar toolbar4 = Toolbar.this;
                h.f359a = 8388611 | (toolbar4.o & 112);
                h.f96b = 2;
                toolbar4.j.setLayoutParams(h);
                Toolbar toolbar5 = Toolbar.this;
                toolbar5.addView(toolbar5.j);
            }
            Toolbar toolbar6 = Toolbar.this;
            int childCount = toolbar6.getChildCount();
            while (true) {
                childCount--;
                if (childCount < 0) {
                    break;
                }
                View childAt = toolbar6.getChildAt(childCount);
                if (!(((e) childAt.getLayoutParams()).f96b == 2 || childAt == toolbar6.f86b)) {
                    toolbar6.removeViewAt(childCount);
                    toolbar6.F.add(childAt);
                }
            }
            Toolbar.this.requestLayout();
            iVar.C = true;
            iVar.n.q(false);
            View view = Toolbar.this.j;
            if (view instanceof b.b.p.b) {
                ((b.b.p.b) view).c();
            }
            return true;
        }

        @Override // b.b.p.i.m
        public void h(m.a aVar) {
        }

        @Override // b.b.p.i.m
        public boolean i(r rVar) {
            return false;
        }

        @Override // b.b.p.i.m
        public void j(boolean z) {
            if (this.f94c != null) {
                b.b.p.i.g gVar = this.f93b;
                boolean z2 = false;
                if (gVar != null) {
                    int size = gVar.size();
                    int i = 0;
                    while (true) {
                        if (i >= size) {
                            break;
                        } else if (this.f93b.getItem(i) == this.f94c) {
                            z2 = true;
                            break;
                        } else {
                            i++;
                        }
                    }
                }
                if (!z2) {
                    f(this.f93b, this.f94c);
                }
            }
        }
    }

    public static class e extends a.C0005a {

        /* renamed from: b  reason: collision with root package name */
        public int f96b = 0;

        public e(int i, int i2) {
            super(i, i2);
            this.f359a = 8388627;
        }

        public e(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public e(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public e(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            ((ViewGroup.MarginLayoutParams) this).leftMargin = marginLayoutParams.leftMargin;
            ((ViewGroup.MarginLayoutParams) this).topMargin = marginLayoutParams.topMargin;
            ((ViewGroup.MarginLayoutParams) this).rightMargin = marginLayoutParams.rightMargin;
            ((ViewGroup.MarginLayoutParams) this).bottomMargin = marginLayoutParams.bottomMargin;
        }

        public e(e eVar) {
            super((a.C0005a) eVar);
            this.f96b = eVar.f96b;
        }

        public e(a.C0005a aVar) {
            super(aVar);
        }
    }

    public interface f {
    }

    public static class g extends b.k.a.a {
        public static final Parcelable.Creator<g> CREATOR = new a();

        /* renamed from: d  reason: collision with root package name */
        public int f97d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f98e;

        public class a implements Parcelable.ClassLoaderCreator<g> {
            @Override // android.os.Parcelable.Creator
            public Object createFromParcel(Parcel parcel) {
                return new g(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            public Object[] newArray(int i) {
                return new g[i];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public g createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new g(parcel, classLoader);
            }
        }

        public g(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f97d = parcel.readInt();
            this.f98e = parcel.readInt() != 0;
        }

        public g(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // b.k.a.a
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable(this.f1231b, i);
            parcel.writeInt(this.f97d);
            parcel.writeInt(this.f98e ? 1 : 0);
        }
    }

    public Toolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, b.b.a.toolbarStyle);
    }

    public Toolbar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.x = 8388627;
        this.E = new ArrayList<>();
        this.F = new ArrayList<>();
        this.G = new int[2];
        this.I = new a();
        this.P = new b();
        y0 q2 = y0.q(getContext(), attributeSet, j.Toolbar, i2, 0);
        b.i.l.m.S(this, context, j.Toolbar, attributeSet, q2.f759b, i2, 0);
        this.m = q2.l(j.Toolbar_titleTextAppearance, 0);
        this.n = q2.l(j.Toolbar_subtitleTextAppearance, 0);
        this.x = q2.f759b.getInteger(j.Toolbar_android_gravity, this.x);
        this.o = q2.f759b.getInteger(j.Toolbar_buttonGravity, 48);
        int e2 = q2.e(j.Toolbar_titleMargin, 0);
        e2 = q2.o(j.Toolbar_titleMargins) ? q2.e(j.Toolbar_titleMargins, e2) : e2;
        this.t = e2;
        this.s = e2;
        this.r = e2;
        this.q = e2;
        int e3 = q2.e(j.Toolbar_titleMarginStart, -1);
        if (e3 >= 0) {
            this.q = e3;
        }
        int e4 = q2.e(j.Toolbar_titleMarginEnd, -1);
        if (e4 >= 0) {
            this.r = e4;
        }
        int e5 = q2.e(j.Toolbar_titleMarginTop, -1);
        if (e5 >= 0) {
            this.s = e5;
        }
        int e6 = q2.e(j.Toolbar_titleMarginBottom, -1);
        if (e6 >= 0) {
            this.t = e6;
        }
        this.p = q2.f(j.Toolbar_maxButtonHeight, -1);
        int e7 = q2.e(j.Toolbar_contentInsetStart, Integer.MIN_VALUE);
        int e8 = q2.e(j.Toolbar_contentInsetEnd, Integer.MIN_VALUE);
        int f2 = q2.f(j.Toolbar_contentInsetLeft, 0);
        int f3 = q2.f(j.Toolbar_contentInsetRight, 0);
        d();
        p0 p0Var = this.u;
        p0Var.h = false;
        if (f2 != Integer.MIN_VALUE) {
            p0Var.f695e = f2;
            p0Var.f691a = f2;
        }
        if (f3 != Integer.MIN_VALUE) {
            p0Var.f = f3;
            p0Var.f692b = f3;
        }
        if (!(e7 == Integer.MIN_VALUE && e8 == Integer.MIN_VALUE)) {
            this.u.a(e7, e8);
        }
        this.v = q2.e(j.Toolbar_contentInsetStartWithNavigation, Integer.MIN_VALUE);
        this.w = q2.e(j.Toolbar_contentInsetEndWithActions, Integer.MIN_VALUE);
        this.g = q2.g(j.Toolbar_collapseIcon);
        this.h = q2.n(j.Toolbar_collapseContentDescription);
        CharSequence n2 = q2.n(j.Toolbar_title);
        if (!TextUtils.isEmpty(n2)) {
            setTitle(n2);
        }
        CharSequence n3 = q2.n(j.Toolbar_subtitle);
        if (!TextUtils.isEmpty(n3)) {
            setSubtitle(n3);
        }
        this.k = getContext();
        setPopupTheme(q2.l(j.Toolbar_popupTheme, 0));
        Drawable g2 = q2.g(j.Toolbar_navigationIcon);
        if (g2 != null) {
            setNavigationIcon(g2);
        }
        CharSequence n4 = q2.n(j.Toolbar_navigationContentDescription);
        if (!TextUtils.isEmpty(n4)) {
            setNavigationContentDescription(n4);
        }
        Drawable g3 = q2.g(j.Toolbar_logo);
        if (g3 != null) {
            setLogo(g3);
        }
        CharSequence n5 = q2.n(j.Toolbar_logoDescription);
        if (!TextUtils.isEmpty(n5)) {
            setLogoDescription(n5);
        }
        if (q2.o(j.Toolbar_titleTextColor)) {
            setTitleTextColor(q2.c(j.Toolbar_titleTextColor));
        }
        if (q2.o(j.Toolbar_subtitleTextColor)) {
            setSubtitleTextColor(q2.c(j.Toolbar_subtitleTextColor));
        }
        if (q2.o(j.Toolbar_menu)) {
            getMenuInflater().inflate(q2.l(j.Toolbar_menu, 0), getMenu());
        }
        q2.f759b.recycle();
    }

    private MenuInflater getMenuInflater() {
        return new b.b.p.f(getContext());
    }

    public final void a(List<View> list, int i2) {
        boolean z2 = b.i.l.m.o(this) == 1;
        int childCount = getChildCount();
        int absoluteGravity = Gravity.getAbsoluteGravity(i2, getLayoutDirection());
        list.clear();
        if (z2) {
            for (int i3 = childCount - 1; i3 >= 0; i3--) {
                View childAt = getChildAt(i3);
                e eVar = (e) childAt.getLayoutParams();
                if (eVar.f96b == 0 && t(childAt) && j(eVar.f359a) == absoluteGravity) {
                    list.add(childAt);
                }
            }
            return;
        }
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt2 = getChildAt(i4);
            e eVar2 = (e) childAt2.getLayoutParams();
            if (eVar2.f96b == 0 && t(childAt2) && j(eVar2.f359a) == absoluteGravity) {
                list.add(childAt2);
            }
        }
    }

    public final void b(View view, boolean z2) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        e h2 = layoutParams == null ? generateDefaultLayoutParams() : !checkLayoutParams(layoutParams) ? generateLayoutParams(layoutParams) : (e) layoutParams;
        h2.f96b = 1;
        if (!z2 || this.j == null) {
            addView(view, h2);
            return;
        }
        view.setLayoutParams(h2);
        this.F.add(view);
    }

    public void c() {
        if (this.i == null) {
            l lVar = new l(getContext(), null, b.b.a.toolbarNavigationButtonStyle);
            this.i = lVar;
            lVar.setImageDrawable(this.g);
            this.i.setContentDescription(this.h);
            e h2 = generateDefaultLayoutParams();
            h2.f359a = 8388611 | (this.o & 112);
            h2.f96b = 2;
            this.i.setLayoutParams(h2);
            this.i.setOnClickListener(new c());
        }
    }

    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof e);
    }

    public final void d() {
        if (this.u == null) {
            this.u = new p0();
        }
    }

    public final void e() {
        f();
        ActionMenuView actionMenuView = this.f86b;
        if (actionMenuView.q == null) {
            b.b.p.i.g gVar = (b.b.p.i.g) actionMenuView.getMenu();
            if (this.L == null) {
                this.L = new d();
            }
            this.f86b.setExpandedActionViewsExclusive(true);
            gVar.b(this.L, this.k);
        }
    }

    public final void f() {
        if (this.f86b == null) {
            ActionMenuView actionMenuView = new ActionMenuView(getContext(), null);
            this.f86b = actionMenuView;
            actionMenuView.setPopupTheme(this.l);
            this.f86b.setOnMenuItemClickListener(this.I);
            ActionMenuView actionMenuView2 = this.f86b;
            m.a aVar = this.M;
            g.a aVar2 = this.N;
            actionMenuView2.v = aVar;
            actionMenuView2.w = aVar2;
            e h2 = generateDefaultLayoutParams();
            h2.f359a = 8388613 | (this.o & 112);
            this.f86b.setLayoutParams(h2);
            b(this.f86b, false);
        }
    }

    public final void g() {
        if (this.f89e == null) {
            this.f89e = new l(getContext(), null, b.b.a.toolbarNavigationButtonStyle);
            e h2 = generateDefaultLayoutParams();
            h2.f359a = 8388611 | (this.o & 112);
            this.f89e.setLayoutParams(h2);
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new e(getContext(), attributeSet);
    }

    public CharSequence getCollapseContentDescription() {
        ImageButton imageButton = this.i;
        if (imageButton != null) {
            return imageButton.getContentDescription();
        }
        return null;
    }

    public Drawable getCollapseIcon() {
        ImageButton imageButton = this.i;
        if (imageButton != null) {
            return imageButton.getDrawable();
        }
        return null;
    }

    public int getContentInsetEnd() {
        p0 p0Var = this.u;
        if (p0Var != null) {
            return p0Var.g ? p0Var.f691a : p0Var.f692b;
        }
        return 0;
    }

    public int getContentInsetEndWithActions() {
        int i2 = this.w;
        return i2 != Integer.MIN_VALUE ? i2 : getContentInsetEnd();
    }

    public int getContentInsetLeft() {
        p0 p0Var = this.u;
        if (p0Var != null) {
            return p0Var.f691a;
        }
        return 0;
    }

    public int getContentInsetRight() {
        p0 p0Var = this.u;
        if (p0Var != null) {
            return p0Var.f692b;
        }
        return 0;
    }

    public int getContentInsetStart() {
        p0 p0Var = this.u;
        if (p0Var != null) {
            return p0Var.g ? p0Var.f692b : p0Var.f691a;
        }
        return 0;
    }

    public int getContentInsetStartWithNavigation() {
        int i2 = this.v;
        return i2 != Integer.MIN_VALUE ? i2 : getContentInsetStart();
    }

    public int getCurrentContentInsetEnd() {
        b.b.p.i.g gVar;
        ActionMenuView actionMenuView = this.f86b;
        return actionMenuView != null && (gVar = actionMenuView.q) != null && gVar.hasVisibleItems() ? Math.max(getContentInsetEnd(), Math.max(this.w, 0)) : getContentInsetEnd();
    }

    public int getCurrentContentInsetLeft() {
        return b.i.l.m.o(this) == 1 ? getCurrentContentInsetEnd() : getCurrentContentInsetStart();
    }

    public int getCurrentContentInsetRight() {
        return b.i.l.m.o(this) == 1 ? getCurrentContentInsetStart() : getCurrentContentInsetEnd();
    }

    public int getCurrentContentInsetStart() {
        return getNavigationIcon() != null ? Math.max(getContentInsetStart(), Math.max(this.v, 0)) : getContentInsetStart();
    }

    public Drawable getLogo() {
        ImageView imageView = this.f;
        if (imageView != null) {
            return imageView.getDrawable();
        }
        return null;
    }

    public CharSequence getLogoDescription() {
        ImageView imageView = this.f;
        if (imageView != null) {
            return imageView.getContentDescription();
        }
        return null;
    }

    public Menu getMenu() {
        e();
        return this.f86b.getMenu();
    }

    public CharSequence getNavigationContentDescription() {
        ImageButton imageButton = this.f89e;
        if (imageButton != null) {
            return imageButton.getContentDescription();
        }
        return null;
    }

    public Drawable getNavigationIcon() {
        ImageButton imageButton = this.f89e;
        if (imageButton != null) {
            return imageButton.getDrawable();
        }
        return null;
    }

    public b.b.q.c getOuterActionMenuPresenter() {
        return this.K;
    }

    public Drawable getOverflowIcon() {
        e();
        return this.f86b.getOverflowIcon();
    }

    public Context getPopupContext() {
        return this.k;
    }

    public int getPopupTheme() {
        return this.l;
    }

    public CharSequence getSubtitle() {
        return this.z;
    }

    public final TextView getSubtitleTextView() {
        return this.f88d;
    }

    public CharSequence getTitle() {
        return this.y;
    }

    public int getTitleMarginBottom() {
        return this.t;
    }

    public int getTitleMarginEnd() {
        return this.r;
    }

    public int getTitleMarginStart() {
        return this.q;
    }

    public int getTitleMarginTop() {
        return this.s;
    }

    public final TextView getTitleTextView() {
        return this.f87c;
    }

    public d0 getWrapper() {
        if (this.J == null) {
            this.J = new a1(this, true);
        }
        return this.J;
    }

    /* renamed from: h */
    public e generateDefaultLayoutParams() {
        return new e(-2, -2);
    }

    /* renamed from: i */
    public e generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof e ? new e((e) layoutParams) : layoutParams instanceof a.C0005a ? new e((a.C0005a) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new e((ViewGroup.MarginLayoutParams) layoutParams) : new e(layoutParams);
    }

    public final int j(int i2) {
        int o2 = b.i.l.m.o(this);
        int absoluteGravity = Gravity.getAbsoluteGravity(i2, o2) & 7;
        if (absoluteGravity == 1 || absoluteGravity == 3 || absoluteGravity == 5) {
            return absoluteGravity;
        }
        return o2 == 1 ? 5 : 3;
    }

    public final int k(View view, int i2) {
        e eVar = (e) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i3 = i2 > 0 ? (measuredHeight - i2) / 2 : 0;
        int i4 = eVar.f359a & 112;
        if (!(i4 == 16 || i4 == 48 || i4 == 80)) {
            i4 = this.x & 112;
        }
        if (i4 == 48) {
            return getPaddingTop() - i3;
        }
        if (i4 == 80) {
            return (((getHeight() - getPaddingBottom()) - measuredHeight) - ((ViewGroup.MarginLayoutParams) eVar).bottomMargin) - i3;
        }
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int height = getHeight();
        int i5 = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
        int i6 = ((ViewGroup.MarginLayoutParams) eVar).topMargin;
        if (i5 < i6) {
            i5 = i6;
        } else {
            int i7 = (((height - paddingBottom) - measuredHeight) - i5) - paddingTop;
            int i8 = ((ViewGroup.MarginLayoutParams) eVar).bottomMargin;
            if (i7 < i8) {
                i5 = Math.max(0, i5 - (i8 - i7));
            }
        }
        return paddingTop + i5;
    }

    public final int l(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.getMarginStart() + marginLayoutParams.getMarginEnd();
    }

    public final int m(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    public final boolean n(View view) {
        return view.getParent() == this || this.F.contains(view);
    }

    public boolean o() {
        ActionMenuView actionMenuView = this.f86b;
        if (actionMenuView != null) {
            b.b.q.c cVar = actionMenuView.u;
            if (cVar != null && cVar.m()) {
                return true;
            }
        }
        return false;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.P);
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.D = false;
        }
        if (!this.D) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.D = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.D = false;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:107:0x0295 A[LOOP:0: B:106:0x0293->B:107:0x0295, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x02b7 A[LOOP:1: B:109:0x02b5->B:110:0x02b7, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x02dc A[LOOP:2: B:112:0x02da->B:113:0x02dc, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x031d  */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x0331 A[LOOP:3: B:120:0x032f->B:121:0x0331, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00ad  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00c2  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00dd  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00f6  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00fb  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0113  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0122  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0125  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0129  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x012c  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x015d  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x019b  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x01ac  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x021b  */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        boolean t2;
        boolean t3;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int size;
        int i13;
        int i14;
        int size2;
        int i15;
        int size3;
        int i16;
        int i17;
        int size4;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        int i24;
        int i25;
        boolean z3 = b.i.l.m.o(this) == 1;
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i26 = width - paddingRight;
        int[] iArr = this.G;
        iArr[1] = 0;
        iArr[0] = 0;
        int minimumHeight = getMinimumHeight();
        int min = minimumHeight >= 0 ? Math.min(minimumHeight, i5 - i3) : 0;
        if (t(this.f89e)) {
            ImageButton imageButton = this.f89e;
            if (z3) {
                i6 = q(imageButton, i26, iArr, min);
                i7 = paddingLeft;
                if (t(this.i)) {
                    ImageButton imageButton2 = this.i;
                    if (z3) {
                        i6 = q(imageButton2, i6, iArr, min);
                    } else {
                        i7 = p(imageButton2, i7, iArr, min);
                    }
                }
                if (t(this.f86b)) {
                    ActionMenuView actionMenuView = this.f86b;
                    if (z3) {
                        i7 = p(actionMenuView, i7, iArr, min);
                    } else {
                        i6 = q(actionMenuView, i6, iArr, min);
                    }
                }
                int currentContentInsetLeft = getCurrentContentInsetLeft();
                int currentContentInsetRight = getCurrentContentInsetRight();
                iArr[0] = Math.max(0, currentContentInsetLeft - i7);
                iArr[1] = Math.max(0, currentContentInsetRight - (i26 - i6));
                int max = Math.max(i7, currentContentInsetLeft);
                int min2 = Math.min(i6, i26 - currentContentInsetRight);
                if (t(this.j)) {
                    View view = this.j;
                    if (z3) {
                        min2 = q(view, min2, iArr, min);
                    } else {
                        max = p(view, max, iArr, min);
                    }
                }
                if (t(this.f)) {
                    ImageView imageView = this.f;
                    if (z3) {
                        min2 = q(imageView, min2, iArr, min);
                    } else {
                        max = p(imageView, max, iArr, min);
                    }
                }
                t2 = t(this.f87c);
                t3 = t(this.f88d);
                if (!t2) {
                    e eVar = (e) this.f87c.getLayoutParams();
                    i8 = paddingRight;
                    i9 = this.f87c.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) eVar).topMargin + ((ViewGroup.MarginLayoutParams) eVar).bottomMargin + 0;
                } else {
                    i8 = paddingRight;
                    i9 = 0;
                }
                if (!t3) {
                    e eVar2 = (e) this.f88d.getLayoutParams();
                    i10 = width;
                    i9 += this.f88d.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) eVar2).topMargin + ((ViewGroup.MarginLayoutParams) eVar2).bottomMargin;
                } else {
                    i10 = width;
                }
                if (!t2 || t3) {
                    TextView textView = !t2 ? this.f87c : this.f88d;
                    TextView textView2 = !t3 ? this.f88d : this.f87c;
                    e eVar3 = (e) textView.getLayoutParams();
                    e eVar4 = (e) textView2.getLayoutParams();
                    boolean z4 = (!t2 && this.f87c.getMeasuredWidth() > 0) || (t3 && this.f88d.getMeasuredWidth() > 0);
                    i19 = this.x & 112;
                    i12 = paddingLeft;
                    if (i19 != 48) {
                        i20 = max;
                        i11 = min;
                        i21 = getPaddingTop() + ((ViewGroup.MarginLayoutParams) eVar3).topMargin + this.s;
                    } else if (i19 != 80) {
                        int i27 = (((height - paddingTop) - paddingBottom) - i9) / 2;
                        int i28 = ((ViewGroup.MarginLayoutParams) eVar3).topMargin;
                        i11 = min;
                        int i29 = this.s;
                        i20 = max;
                        if (i27 < i28 + i29) {
                            i27 = i28 + i29;
                        } else {
                            int i30 = (((height - paddingBottom) - i9) - i27) - paddingTop;
                            int i31 = ((ViewGroup.MarginLayoutParams) eVar3).bottomMargin;
                            int i32 = this.t;
                            if (i30 < i31 + i32) {
                                i27 = Math.max(0, i27 - ((((ViewGroup.MarginLayoutParams) eVar4).bottomMargin + i32) - i30));
                            }
                        }
                        i21 = paddingTop + i27;
                    } else {
                        i20 = max;
                        i11 = min;
                        i21 = (((height - paddingBottom) - ((ViewGroup.MarginLayoutParams) eVar4).bottomMargin) - this.t) - i9;
                    }
                    if (!z3) {
                        int i33 = (z4 ? this.q : 0) - iArr[1];
                        min2 -= Math.max(0, i33);
                        iArr[1] = Math.max(0, -i33);
                        if (t2) {
                            int measuredWidth = min2 - this.f87c.getMeasuredWidth();
                            int measuredHeight = this.f87c.getMeasuredHeight() + i21;
                            this.f87c.layout(measuredWidth, i21, min2, measuredHeight);
                            i24 = measuredWidth - this.r;
                            i21 = measuredHeight + ((ViewGroup.MarginLayoutParams) ((e) this.f87c.getLayoutParams())).bottomMargin;
                        } else {
                            i24 = min2;
                        }
                        if (t3) {
                            int i34 = i21 + ((ViewGroup.MarginLayoutParams) ((e) this.f88d.getLayoutParams())).topMargin;
                            this.f88d.layout(min2 - this.f88d.getMeasuredWidth(), i34, min2, this.f88d.getMeasuredHeight() + i34);
                            i25 = min2 - this.r;
                        } else {
                            i25 = min2;
                        }
                        if (z4) {
                            min2 = Math.min(i24, i25);
                        }
                        max = i20;
                    } else {
                        int i35 = (z4 ? this.q : 0) - iArr[0];
                        int max2 = Math.max(0, i35) + i20;
                        iArr[0] = Math.max(0, -i35);
                        if (t2) {
                            int measuredWidth2 = this.f87c.getMeasuredWidth() + max2;
                            int measuredHeight2 = this.f87c.getMeasuredHeight() + i21;
                            this.f87c.layout(max2, i21, measuredWidth2, measuredHeight2);
                            i22 = measuredWidth2 + this.r;
                            i21 = measuredHeight2 + ((ViewGroup.MarginLayoutParams) ((e) this.f87c.getLayoutParams())).bottomMargin;
                        } else {
                            i22 = max2;
                        }
                        if (t3) {
                            int i36 = i21 + ((ViewGroup.MarginLayoutParams) ((e) this.f88d.getLayoutParams())).topMargin;
                            int measuredWidth3 = this.f88d.getMeasuredWidth() + max2;
                            this.f88d.layout(max2, i36, measuredWidth3, this.f88d.getMeasuredHeight() + i36);
                            i23 = measuredWidth3 + this.r;
                        } else {
                            i23 = max2;
                        }
                        max = z4 ? Math.max(i22, i23) : max2;
                    }
                } else {
                    i12 = paddingLeft;
                    i11 = min;
                }
                a(this.E, 3);
                size = this.E.size();
                i13 = max;
                for (i14 = 0; i14 < size; i14++) {
                    i13 = p(this.E.get(i14), i13, iArr, i11);
                }
                a(this.E, 5);
                size2 = this.E.size();
                for (i15 = 0; i15 < size2; i15++) {
                    min2 = q(this.E.get(i15), min2, iArr, i11);
                }
                a(this.E, 1);
                ArrayList<View> arrayList = this.E;
                int i37 = iArr[0];
                int i38 = iArr[1];
                size3 = arrayList.size();
                int i39 = i37;
                i16 = 0;
                int i40 = 0;
                while (i16 < size3) {
                    View view2 = arrayList.get(i16);
                    e eVar5 = (e) view2.getLayoutParams();
                    int i41 = ((ViewGroup.MarginLayoutParams) eVar5).leftMargin - i39;
                    int i42 = ((ViewGroup.MarginLayoutParams) eVar5).rightMargin - i38;
                    int max3 = Math.max(0, i41);
                    int max4 = Math.max(0, i42);
                    int max5 = Math.max(0, -i41);
                    int max6 = Math.max(0, -i42);
                    i40 += view2.getMeasuredWidth() + max3 + max4;
                    i16++;
                    i38 = max6;
                    i39 = max5;
                }
                i17 = ((((i10 - i12) - i8) / 2) + i12) - (i40 / 2);
                int i43 = i40 + i17;
                if (i17 >= i13) {
                    i13 = i43 > min2 ? i17 - (i43 - min2) : i17;
                }
                size4 = this.E.size();
                int i44 = i13;
                for (i18 = 0; i18 < size4; i18++) {
                    i44 = p(this.E.get(i18), i44, iArr, i11);
                }
                this.E.clear();
            }
            i7 = p(imageButton, paddingLeft, iArr, min);
        } else {
            i7 = paddingLeft;
        }
        i6 = i26;
        if (t(this.i)) {
        }
        if (t(this.f86b)) {
        }
        int currentContentInsetLeft2 = getCurrentContentInsetLeft();
        int currentContentInsetRight2 = getCurrentContentInsetRight();
        iArr[0] = Math.max(0, currentContentInsetLeft2 - i7);
        iArr[1] = Math.max(0, currentContentInsetRight2 - (i26 - i6));
        int max7 = Math.max(i7, currentContentInsetLeft2);
        int min22 = Math.min(i6, i26 - currentContentInsetRight2);
        if (t(this.j)) {
        }
        if (t(this.f)) {
        }
        t2 = t(this.f87c);
        t3 = t(this.f88d);
        if (!t2) {
        }
        if (!t3) {
        }
        if (!t2) {
        }
        if (!t2) {
        }
        if (!t3) {
        }
        e eVar32 = (e) textView.getLayoutParams();
        e eVar42 = (e) textView2.getLayoutParams();
        if (!t2) {
        }
        i19 = this.x & 112;
        i12 = paddingLeft;
        if (i19 != 48) {
        }
        if (!z3) {
        }
        a(this.E, 3);
        size = this.E.size();
        i13 = max7;
        while (i14 < size) {
        }
        a(this.E, 5);
        size2 = this.E.size();
        while (i15 < size2) {
        }
        a(this.E, 1);
        ArrayList<View> arrayList2 = this.E;
        int i372 = iArr[0];
        int i382 = iArr[1];
        size3 = arrayList2.size();
        int i392 = i372;
        i16 = 0;
        int i402 = 0;
        while (i16 < size3) {
        }
        i17 = ((((i10 - i12) - i8) / 2) + i12) - (i402 / 2);
        int i432 = i402 + i17;
        if (i17 >= i13) {
        }
        size4 = this.E.size();
        int i442 = i13;
        while (i18 < size4) {
        }
        this.E.clear();
    }

    public void onMeasure(int i2, int i3) {
        char c2;
        char c3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int[] iArr = this.G;
        boolean z2 = true;
        int i11 = 0;
        if (e1.a(this)) {
            c3 = 1;
            c2 = 0;
        } else {
            c2 = 1;
            c3 = 0;
        }
        if (t(this.f89e)) {
            s(this.f89e, i2, 0, i3, 0, this.p);
            i6 = l(this.f89e) + this.f89e.getMeasuredWidth();
            i5 = Math.max(0, m(this.f89e) + this.f89e.getMeasuredHeight());
            i4 = View.combineMeasuredStates(0, this.f89e.getMeasuredState());
        } else {
            i6 = 0;
            i5 = 0;
            i4 = 0;
        }
        if (t(this.i)) {
            s(this.i, i2, 0, i3, 0, this.p);
            i6 = l(this.i) + this.i.getMeasuredWidth();
            i5 = Math.max(i5, m(this.i) + this.i.getMeasuredHeight());
            i4 = View.combineMeasuredStates(i4, this.i.getMeasuredState());
        }
        int currentContentInsetStart = getCurrentContentInsetStart();
        int max = Math.max(currentContentInsetStart, i6) + 0;
        iArr[c3] = Math.max(0, currentContentInsetStart - i6);
        if (t(this.f86b)) {
            s(this.f86b, i2, max, i3, 0, this.p);
            i7 = l(this.f86b) + this.f86b.getMeasuredWidth();
            i5 = Math.max(i5, m(this.f86b) + this.f86b.getMeasuredHeight());
            i4 = View.combineMeasuredStates(i4, this.f86b.getMeasuredState());
        } else {
            i7 = 0;
        }
        int currentContentInsetEnd = getCurrentContentInsetEnd();
        int max2 = Math.max(currentContentInsetEnd, i7) + max;
        iArr[c2] = Math.max(0, currentContentInsetEnd - i7);
        if (t(this.j)) {
            max2 += r(this.j, i2, max2, i3, 0, iArr);
            i5 = Math.max(i5, m(this.j) + this.j.getMeasuredHeight());
            i4 = View.combineMeasuredStates(i4, this.j.getMeasuredState());
        }
        if (t(this.f)) {
            max2 += r(this.f, i2, max2, i3, 0, iArr);
            i5 = Math.max(i5, m(this.f) + this.f.getMeasuredHeight());
            i4 = View.combineMeasuredStates(i4, this.f.getMeasuredState());
        }
        int childCount = getChildCount();
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            if (((e) childAt.getLayoutParams()).f96b == 0 && t(childAt)) {
                max2 += r(childAt, i2, max2, i3, 0, iArr);
                i5 = Math.max(i5, m(childAt) + childAt.getMeasuredHeight());
                i4 = View.combineMeasuredStates(i4, childAt.getMeasuredState());
            }
        }
        int i13 = this.s + this.t;
        int i14 = this.q + this.r;
        if (t(this.f87c)) {
            r(this.f87c, i2, max2 + i14, i3, i13, iArr);
            int l2 = l(this.f87c) + this.f87c.getMeasuredWidth();
            i8 = m(this.f87c) + this.f87c.getMeasuredHeight();
            i10 = View.combineMeasuredStates(i4, this.f87c.getMeasuredState());
            i9 = l2;
        } else {
            i8 = 0;
            i10 = i4;
            i9 = 0;
        }
        if (t(this.f88d)) {
            i9 = Math.max(i9, r(this.f88d, i2, max2 + i14, i3, i8 + i13, iArr));
            i8 = m(this.f88d) + this.f88d.getMeasuredHeight() + i8;
            i10 = View.combineMeasuredStates(i10, this.f88d.getMeasuredState());
        }
        int max3 = Math.max(i5, i8);
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingBottom = getPaddingBottom() + getPaddingTop() + max3;
        int resolveSizeAndState = View.resolveSizeAndState(Math.max(paddingRight + max2 + i9, getSuggestedMinimumWidth()), i2, -16777216 & i10);
        int resolveSizeAndState2 = View.resolveSizeAndState(Math.max(paddingBottom, getSuggestedMinimumHeight()), i3, i10 << 16);
        if (this.O) {
            int childCount2 = getChildCount();
            int i15 = 0;
            while (true) {
                if (i15 >= childCount2) {
                    break;
                }
                View childAt2 = getChildAt(i15);
                if (t(childAt2) && childAt2.getMeasuredWidth() > 0 && childAt2.getMeasuredHeight() > 0) {
                    break;
                }
                i15++;
            }
        }
        z2 = false;
        if (!z2) {
            i11 = resolveSizeAndState2;
        }
        setMeasuredDimension(resolveSizeAndState, i11);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        MenuItem findItem;
        if (!(parcelable instanceof g)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        g gVar = (g) parcelable;
        super.onRestoreInstanceState(gVar.f1231b);
        ActionMenuView actionMenuView = this.f86b;
        b.b.p.i.g gVar2 = actionMenuView != null ? actionMenuView.q : null;
        int i2 = gVar.f97d;
        if (!(i2 == 0 || this.L == null || gVar2 == null || (findItem = gVar2.findItem(i2)) == null)) {
            findItem.expandActionView();
        }
        if (gVar.f98e) {
            removeCallbacks(this.P);
            post(this.P);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0027, code lost:
        if (r1 != Integer.MIN_VALUE) goto L_0x003e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0035, code lost:
        if (r1 != Integer.MIN_VALUE) goto L_0x003e;
     */
    public void onRtlPropertiesChanged(int i2) {
        int i3;
        super.onRtlPropertiesChanged(i2);
        d();
        p0 p0Var = this.u;
        boolean z2 = true;
        if (i2 != 1) {
            z2 = false;
        }
        if (z2 != p0Var.g) {
            p0Var.g = z2;
            if (!p0Var.h) {
                p0Var.f691a = p0Var.f695e;
            } else if (z2) {
                int i4 = p0Var.f694d;
                if (i4 == Integer.MIN_VALUE) {
                    i4 = p0Var.f695e;
                }
                p0Var.f691a = i4;
                i3 = p0Var.f693c;
            } else {
                int i5 = p0Var.f693c;
                if (i5 == Integer.MIN_VALUE) {
                    i5 = p0Var.f695e;
                }
                p0Var.f691a = i5;
                i3 = p0Var.f694d;
            }
            i3 = p0Var.f;
            p0Var.f692b = i3;
        }
    }

    public Parcelable onSaveInstanceState() {
        i iVar;
        g gVar = new g(super.onSaveInstanceState());
        d dVar = this.L;
        if (!(dVar == null || (iVar = dVar.f94c) == null)) {
            gVar.f97d = iVar.f548a;
        }
        gVar.f98e = o();
        return gVar;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.C = false;
        }
        if (!this.C) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.C = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.C = false;
        }
        return true;
    }

    public final int p(View view, int i2, int[] iArr, int i3) {
        e eVar = (e) view.getLayoutParams();
        int i4 = ((ViewGroup.MarginLayoutParams) eVar).leftMargin - iArr[0];
        int max = Math.max(0, i4) + i2;
        iArr[0] = Math.max(0, -i4);
        int k2 = k(view, i3);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max, k2, max + measuredWidth, view.getMeasuredHeight() + k2);
        return measuredWidth + ((ViewGroup.MarginLayoutParams) eVar).rightMargin + max;
    }

    public final int q(View view, int i2, int[] iArr, int i3) {
        e eVar = (e) view.getLayoutParams();
        int i4 = ((ViewGroup.MarginLayoutParams) eVar).rightMargin - iArr[1];
        int max = i2 - Math.max(0, i4);
        iArr[1] = Math.max(0, -i4);
        int k2 = k(view, i3);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max - measuredWidth, k2, max, view.getMeasuredHeight() + k2);
        return max - (measuredWidth + ((ViewGroup.MarginLayoutParams) eVar).leftMargin);
    }

    public final int r(View view, int i2, int i3, int i4, int i5, int[] iArr) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i6 = marginLayoutParams.leftMargin - iArr[0];
        int i7 = marginLayoutParams.rightMargin - iArr[1];
        int max = Math.max(0, i7) + Math.max(0, i6);
        iArr[0] = Math.max(0, -i6);
        iArr[1] = Math.max(0, -i7);
        view.measure(ViewGroup.getChildMeasureSpec(i2, getPaddingRight() + getPaddingLeft() + max + i3, marginLayoutParams.width), ViewGroup.getChildMeasureSpec(i4, getPaddingBottom() + getPaddingTop() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i5, marginLayoutParams.height));
        return view.getMeasuredWidth() + max;
    }

    public final void s(View view, int i2, int i3, int i4, int i5, int i6) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i2, getPaddingRight() + getPaddingLeft() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i3, marginLayoutParams.width);
        int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i4, getPaddingBottom() + getPaddingTop() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i5, marginLayoutParams.height);
        int mode = View.MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i6 >= 0) {
            if (mode != 0) {
                i6 = Math.min(View.MeasureSpec.getSize(childMeasureSpec2), i6);
            }
            childMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i6, 1073741824);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    public void setCollapseContentDescription(int i2) {
        setCollapseContentDescription(i2 != 0 ? getContext().getText(i2) : null);
    }

    public void setCollapseContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            c();
        }
        ImageButton imageButton = this.i;
        if (imageButton != null) {
            imageButton.setContentDescription(charSequence);
        }
    }

    public void setCollapseIcon(int i2) {
        setCollapseIcon(b.b.l.a.a.b(getContext(), i2));
    }

    public void setCollapseIcon(Drawable drawable) {
        if (drawable != null) {
            c();
            this.i.setImageDrawable(drawable);
            return;
        }
        ImageButton imageButton = this.i;
        if (imageButton != null) {
            imageButton.setImageDrawable(this.g);
        }
    }

    public void setCollapsible(boolean z2) {
        this.O = z2;
        requestLayout();
    }

    public void setContentInsetEndWithActions(int i2) {
        if (i2 < 0) {
            i2 = Integer.MIN_VALUE;
        }
        if (i2 != this.w) {
            this.w = i2;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setContentInsetStartWithNavigation(int i2) {
        if (i2 < 0) {
            i2 = Integer.MIN_VALUE;
        }
        if (i2 != this.v) {
            this.v = i2;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setLogo(int i2) {
        setLogo(b.b.l.a.a.b(getContext(), i2));
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            if (this.f == null) {
                this.f = new n(getContext(), null, 0);
            }
            if (!n(this.f)) {
                b(this.f, true);
            }
        } else {
            ImageView imageView = this.f;
            if (imageView != null && n(imageView)) {
                removeView(this.f);
                this.F.remove(this.f);
            }
        }
        ImageView imageView2 = this.f;
        if (imageView2 != null) {
            imageView2.setImageDrawable(drawable);
        }
    }

    public void setLogoDescription(int i2) {
        setLogoDescription(getContext().getText(i2));
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence) && this.f == null) {
            this.f = new n(getContext(), null, 0);
        }
        ImageView imageView = this.f;
        if (imageView != null) {
            imageView.setContentDescription(charSequence);
        }
    }

    public void setNavigationContentDescription(int i2) {
        setNavigationContentDescription(i2 != 0 ? getContext().getText(i2) : null);
    }

    public void setNavigationContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            g();
        }
        ImageButton imageButton = this.f89e;
        if (imageButton != null) {
            imageButton.setContentDescription(charSequence);
        }
    }

    public void setNavigationIcon(int i2) {
        setNavigationIcon(b.b.l.a.a.b(getContext(), i2));
    }

    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null) {
            g();
            if (!n(this.f89e)) {
                b(this.f89e, true);
            }
        } else {
            ImageButton imageButton = this.f89e;
            if (imageButton != null && n(imageButton)) {
                removeView(this.f89e);
                this.F.remove(this.f89e);
            }
        }
        ImageButton imageButton2 = this.f89e;
        if (imageButton2 != null) {
            imageButton2.setImageDrawable(drawable);
        }
    }

    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        g();
        this.f89e.setOnClickListener(onClickListener);
    }

    public void setOnMenuItemClickListener(f fVar) {
        this.H = fVar;
    }

    public void setOverflowIcon(Drawable drawable) {
        e();
        this.f86b.setOverflowIcon(drawable);
    }

    public void setPopupTheme(int i2) {
        if (this.l != i2) {
            this.l = i2;
            if (i2 == 0) {
                this.k = getContext();
            } else {
                this.k = new ContextThemeWrapper(getContext(), i2);
            }
        }
    }

    public void setSubtitle(int i2) {
        setSubtitle(getContext().getText(i2));
    }

    public void setSubtitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.f88d == null) {
                Context context = getContext();
                z zVar = new z(context, null);
                this.f88d = zVar;
                zVar.setSingleLine();
                this.f88d.setEllipsize(TextUtils.TruncateAt.END);
                int i2 = this.n;
                if (i2 != 0) {
                    this.f88d.setTextAppearance(context, i2);
                }
                ColorStateList colorStateList = this.B;
                if (colorStateList != null) {
                    this.f88d.setTextColor(colorStateList);
                }
            }
            if (!n(this.f88d)) {
                b(this.f88d, true);
            }
        } else {
            TextView textView = this.f88d;
            if (textView != null && n(textView)) {
                removeView(this.f88d);
                this.F.remove(this.f88d);
            }
        }
        TextView textView2 = this.f88d;
        if (textView2 != null) {
            textView2.setText(charSequence);
        }
        this.z = charSequence;
    }

    public void setSubtitleTextColor(int i2) {
        setSubtitleTextColor(ColorStateList.valueOf(i2));
    }

    public void setSubtitleTextColor(ColorStateList colorStateList) {
        this.B = colorStateList;
        TextView textView = this.f88d;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public void setTitle(int i2) {
        setTitle(getContext().getText(i2));
    }

    public void setTitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.f87c == null) {
                Context context = getContext();
                z zVar = new z(context, null);
                this.f87c = zVar;
                zVar.setSingleLine();
                this.f87c.setEllipsize(TextUtils.TruncateAt.END);
                int i2 = this.m;
                if (i2 != 0) {
                    this.f87c.setTextAppearance(context, i2);
                }
                ColorStateList colorStateList = this.A;
                if (colorStateList != null) {
                    this.f87c.setTextColor(colorStateList);
                }
            }
            if (!n(this.f87c)) {
                b(this.f87c, true);
            }
        } else {
            TextView textView = this.f87c;
            if (textView != null && n(textView)) {
                removeView(this.f87c);
                this.F.remove(this.f87c);
            }
        }
        TextView textView2 = this.f87c;
        if (textView2 != null) {
            textView2.setText(charSequence);
        }
        this.y = charSequence;
    }

    public void setTitleMarginBottom(int i2) {
        this.t = i2;
        requestLayout();
    }

    public void setTitleMarginEnd(int i2) {
        this.r = i2;
        requestLayout();
    }

    public void setTitleMarginStart(int i2) {
        this.q = i2;
        requestLayout();
    }

    public void setTitleMarginTop(int i2) {
        this.s = i2;
        requestLayout();
    }

    public void setTitleTextColor(int i2) {
        setTitleTextColor(ColorStateList.valueOf(i2));
    }

    public void setTitleTextColor(ColorStateList colorStateList) {
        this.A = colorStateList;
        TextView textView = this.f87c;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public final boolean t(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    public boolean u() {
        ActionMenuView actionMenuView = this.f86b;
        if (actionMenuView != null) {
            b.b.q.c cVar = actionMenuView.u;
            if (cVar != null && cVar.n()) {
                return true;
            }
        }
        return false;
    }
}
