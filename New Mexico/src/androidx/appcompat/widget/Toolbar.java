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
import androidx.appcompat.R$attr;
import androidx.appcompat.R$styleable;
import androidx.appcompat.widget.ActionMenuView;
import e.b.a.a;
import e.b.a.m;
import e.b.e.i.g;
import e.b.e.i.i;
import e.b.e.i.m;
import e.b.e.i.r;
import e.b.f.c1;
import e.b.f.d0;
import e.b.f.e1;
import e.b.f.h0;
import e.b.f.i1;
import e.b.f.o;
import e.b.f.q;
import e.b.f.t0;
import e.j.j.v;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
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
    public e1 J;
    public e.b.f.c K;
    public d L;
    public m.a M;
    public g.a N;
    public boolean O;
    public final Runnable P;
    public ActionMenuView b;
    public TextView c;

    /* renamed from: d */
    public TextView f93d;

    /* renamed from: e */
    public ImageButton f94e;

    /* renamed from: f */
    public ImageView f95f;

    /* renamed from: g */
    public Drawable f96g;

    /* renamed from: h */
    public CharSequence f97h;

    /* renamed from: i */
    public ImageButton f98i;

    /* renamed from: j */
    public View f99j;

    /* renamed from: k */
    public Context f100k;

    /* renamed from: l */
    public int f101l;
    public int m;
    public int n;
    public int o;
    public int p;
    public int q;
    public int r;
    public int s;
    public int t;
    public t0 u;
    public int v;
    public int w;
    public int x;
    public CharSequence y;
    public CharSequence z;

    /* loaded from: classes.dex */
    public class a implements ActionMenuView.e {
        public a() {
            Toolbar.this = r1;
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public b() {
            Toolbar.this = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            Toolbar.this.v();
        }
    }

    /* loaded from: classes.dex */
    public class c implements View.OnClickListener {
        public c() {
            Toolbar.this = r1;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d dVar = Toolbar.this.L;
            i iVar = dVar == null ? null : dVar.c;
            if (iVar != null) {
                iVar.collapseActionView();
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements m {
        public e.b.e.i.g b;
        public i c;

        public d() {
            Toolbar.this = r1;
        }

        @Override // e.b.e.i.m
        public void b(e.b.e.i.g gVar, boolean z) {
        }

        @Override // e.b.e.i.m
        public boolean d() {
            return false;
        }

        @Override // e.b.e.i.m
        public void e(Context context, e.b.e.i.g gVar) {
            i iVar;
            e.b.e.i.g gVar2 = this.b;
            if (!(gVar2 == null || (iVar = this.c) == null)) {
                gVar2.d(iVar);
            }
            this.b = gVar;
        }

        @Override // e.b.e.i.m
        public boolean f(e.b.e.i.g gVar, i iVar) {
            View view = Toolbar.this.f99j;
            if (view instanceof e.b.e.b) {
                ((e.b.e.b) view).e();
            }
            Toolbar toolbar = Toolbar.this;
            toolbar.removeView(toolbar.f99j);
            Toolbar toolbar2 = Toolbar.this;
            toolbar2.removeView(toolbar2.f98i);
            Toolbar toolbar3 = Toolbar.this;
            toolbar3.f99j = null;
            int size = toolbar3.F.size();
            while (true) {
                size--;
                if (size >= 0) {
                    toolbar3.addView(toolbar3.F.get(size));
                } else {
                    toolbar3.F.clear();
                    this.c = null;
                    Toolbar.this.requestLayout();
                    iVar.C = false;
                    iVar.n.q(false);
                    return true;
                }
            }
        }

        @Override // e.b.e.i.m
        public boolean g(e.b.e.i.g gVar, i iVar) {
            Toolbar.this.c();
            ViewParent parent = Toolbar.this.f98i.getParent();
            Toolbar toolbar = Toolbar.this;
            if (parent != toolbar) {
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(toolbar.f98i);
                }
                Toolbar toolbar2 = Toolbar.this;
                toolbar2.addView(toolbar2.f98i);
            }
            Toolbar.this.f99j = iVar.getActionView();
            this.c = iVar;
            ViewParent parent2 = Toolbar.this.f99j.getParent();
            Toolbar toolbar3 = Toolbar.this;
            if (parent2 != toolbar3) {
                if (parent2 instanceof ViewGroup) {
                    ((ViewGroup) parent2).removeView(toolbar3.f99j);
                }
                e h2 = Toolbar.this.generateDefaultLayoutParams();
                Toolbar toolbar4 = Toolbar.this;
                h2.a = 8388611 | (toolbar4.o & 112);
                h2.b = 2;
                toolbar4.f99j.setLayoutParams(h2);
                Toolbar toolbar5 = Toolbar.this;
                toolbar5.addView(toolbar5.f99j);
            }
            Toolbar toolbar6 = Toolbar.this;
            int childCount = toolbar6.getChildCount();
            while (true) {
                childCount--;
                if (childCount < 0) {
                    break;
                }
                View childAt = toolbar6.getChildAt(childCount);
                if (!(((e) childAt.getLayoutParams()).b == 2 || childAt == toolbar6.b)) {
                    toolbar6.removeViewAt(childCount);
                    toolbar6.F.add(childAt);
                }
            }
            Toolbar.this.requestLayout();
            iVar.C = true;
            iVar.n.q(false);
            View view = Toolbar.this.f99j;
            if (view instanceof e.b.e.b) {
                ((e.b.e.b) view).c();
            }
            return true;
        }

        @Override // e.b.e.i.m
        public boolean i(r rVar) {
            return false;
        }

        @Override // e.b.e.i.m
        public void j(boolean z) {
            if (this.c != null) {
                e.b.e.i.g gVar = this.b;
                boolean z2 = false;
                if (gVar != null) {
                    int size = gVar.size();
                    int i2 = 0;
                    while (true) {
                        if (i2 >= size) {
                            break;
                        } else if (this.b.getItem(i2) == this.c) {
                            z2 = true;
                            break;
                        } else {
                            i2++;
                        }
                    }
                }
                if (!z2) {
                    f(this.b, this.c);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class e extends a.C0014a {
        public int b;

        public e(int i2, int i3) {
            super(i2, i3);
            this.b = 0;
            this.a = 8388627;
        }

        public e(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.b = 0;
        }

        public e(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.b = 0;
        }

        public e(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.b = 0;
            ((ViewGroup.MarginLayoutParams) this).leftMargin = marginLayoutParams.leftMargin;
            ((ViewGroup.MarginLayoutParams) this).topMargin = marginLayoutParams.topMargin;
            ((ViewGroup.MarginLayoutParams) this).rightMargin = marginLayoutParams.rightMargin;
            ((ViewGroup.MarginLayoutParams) this).bottomMargin = marginLayoutParams.bottomMargin;
        }

        public e(e eVar) {
            super((a.C0014a) eVar);
            this.b = 0;
            this.b = eVar.b;
        }

        public e(a.C0014a aVar) {
            super(aVar);
            this.b = 0;
        }
    }

    /* loaded from: classes.dex */
    public interface f {
    }

    /* loaded from: classes.dex */
    public static class g extends e.l.a.a {
        public static final Parcelable.Creator<g> CREATOR = new a();

        /* renamed from: d */
        public int f103d;

        /* renamed from: e */
        public boolean f104e;

        /* loaded from: classes.dex */
        public class a implements Parcelable.ClassLoaderCreator<g> {
            @Override // android.os.Parcelable.Creator
            public Object createFromParcel(Parcel parcel) {
                return new g(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            public Object[] newArray(int i2) {
                return new g[i2];
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            public g createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new g(parcel, classLoader);
            }
        }

        public g(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f103d = parcel.readInt();
            this.f104e = parcel.readInt() != 0;
        }

        public g(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // e.l.a.a, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeParcelable(this.b, i2);
            parcel.writeInt(this.f103d);
            parcel.writeInt(this.f104e ? 1 : 0);
        }
    }

    public Toolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.toolbarStyle);
    }

    public Toolbar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.x = 8388627;
        this.E = new ArrayList<>();
        this.F = new ArrayList<>();
        this.G = new int[2];
        this.I = new a();
        this.P = new b();
        Context context2 = getContext();
        int[] iArr = R$styleable.Toolbar;
        c1 q = c1.q(context2, attributeSet, iArr, i2, 0);
        v.t(this, context, iArr, attributeSet, q.b, i2, 0);
        this.m = q.l(R$styleable.Toolbar_titleTextAppearance, 0);
        this.n = q.l(R$styleable.Toolbar_subtitleTextAppearance, 0);
        this.x = q.b.getInteger(R$styleable.Toolbar_android_gravity, this.x);
        this.o = q.b.getInteger(R$styleable.Toolbar_buttonGravity, 48);
        int e2 = q.e(R$styleable.Toolbar_titleMargin, 0);
        int i3 = R$styleable.Toolbar_titleMargins;
        e2 = q.o(i3) ? q.e(i3, e2) : e2;
        this.t = e2;
        this.s = e2;
        this.r = e2;
        this.q = e2;
        int e3 = q.e(R$styleable.Toolbar_titleMarginStart, -1);
        if (e3 >= 0) {
            this.q = e3;
        }
        int e4 = q.e(R$styleable.Toolbar_titleMarginEnd, -1);
        if (e4 >= 0) {
            this.r = e4;
        }
        int e5 = q.e(R$styleable.Toolbar_titleMarginTop, -1);
        if (e5 >= 0) {
            this.s = e5;
        }
        int e6 = q.e(R$styleable.Toolbar_titleMarginBottom, -1);
        if (e6 >= 0) {
            this.t = e6;
        }
        this.p = q.f(R$styleable.Toolbar_maxButtonHeight, -1);
        int e7 = q.e(R$styleable.Toolbar_contentInsetStart, Integer.MIN_VALUE);
        int e8 = q.e(R$styleable.Toolbar_contentInsetEnd, Integer.MIN_VALUE);
        int f2 = q.f(R$styleable.Toolbar_contentInsetLeft, 0);
        int f3 = q.f(R$styleable.Toolbar_contentInsetRight, 0);
        d();
        t0 t0Var = this.u;
        t0Var.f1028h = false;
        if (f2 != Integer.MIN_VALUE) {
            t0Var.f1025e = f2;
            t0Var.a = f2;
        }
        if (f3 != Integer.MIN_VALUE) {
            t0Var.f1026f = f3;
            t0Var.b = f3;
        }
        if (!(e7 == Integer.MIN_VALUE && e8 == Integer.MIN_VALUE)) {
            t0Var.a(e7, e8);
        }
        this.v = q.e(R$styleable.Toolbar_contentInsetStartWithNavigation, Integer.MIN_VALUE);
        this.w = q.e(R$styleable.Toolbar_contentInsetEndWithActions, Integer.MIN_VALUE);
        this.f96g = q.g(R$styleable.Toolbar_collapseIcon);
        this.f97h = q.n(R$styleable.Toolbar_collapseContentDescription);
        CharSequence n = q.n(R$styleable.Toolbar_title);
        if (!TextUtils.isEmpty(n)) {
            setTitle(n);
        }
        CharSequence n2 = q.n(R$styleable.Toolbar_subtitle);
        if (!TextUtils.isEmpty(n2)) {
            setSubtitle(n2);
        }
        this.f100k = getContext();
        setPopupTheme(q.l(R$styleable.Toolbar_popupTheme, 0));
        Drawable g2 = q.g(R$styleable.Toolbar_navigationIcon);
        if (g2 != null) {
            setNavigationIcon(g2);
        }
        CharSequence n3 = q.n(R$styleable.Toolbar_navigationContentDescription);
        if (!TextUtils.isEmpty(n3)) {
            setNavigationContentDescription(n3);
        }
        Drawable g3 = q.g(R$styleable.Toolbar_logo);
        if (g3 != null) {
            setLogo(g3);
        }
        CharSequence n4 = q.n(R$styleable.Toolbar_logoDescription);
        if (!TextUtils.isEmpty(n4)) {
            setLogoDescription(n4);
        }
        int i4 = R$styleable.Toolbar_titleTextColor;
        if (q.o(i4)) {
            setTitleTextColor(q.c(i4));
        }
        int i5 = R$styleable.Toolbar_subtitleTextColor;
        if (q.o(i5)) {
            setSubtitleTextColor(q.c(i5));
        }
        int i6 = R$styleable.Toolbar_menu;
        if (q.o(i6)) {
            getMenuInflater().inflate(q.l(i6, 0), getMenu());
        }
        q.b.recycle();
    }

    private MenuInflater getMenuInflater() {
        return new e.b.e.f(getContext());
    }

    public final void a(List<View> list, int i2) {
        AtomicInteger atomicInteger = v.a;
        boolean z = v.e.d(this) == 1;
        int childCount = getChildCount();
        int absoluteGravity = Gravity.getAbsoluteGravity(i2, v.e.d(this));
        list.clear();
        if (z) {
            for (int i3 = childCount - 1; i3 >= 0; i3--) {
                View childAt = getChildAt(i3);
                e eVar = (e) childAt.getLayoutParams();
                if (eVar.b == 0 && u(childAt) && j(eVar.a) == absoluteGravity) {
                    list.add(childAt);
                }
            }
            return;
        }
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt2 = getChildAt(i4);
            e eVar2 = (e) childAt2.getLayoutParams();
            if (eVar2.b == 0 && u(childAt2) && j(eVar2.a) == absoluteGravity) {
                list.add(childAt2);
            }
        }
    }

    public final void b(View view, boolean z) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        e h2 = layoutParams == null ? generateDefaultLayoutParams() : !checkLayoutParams(layoutParams) ? generateLayoutParams(layoutParams) : (e) layoutParams;
        h2.b = 1;
        if (!z || this.f99j == null) {
            addView(view, h2);
            return;
        }
        view.setLayoutParams(h2);
        this.F.add(view);
    }

    public void c() {
        if (this.f98i == null) {
            o oVar = new o(getContext(), null, R$attr.toolbarNavigationButtonStyle);
            this.f98i = oVar;
            oVar.setImageDrawable(this.f96g);
            this.f98i.setContentDescription(this.f97h);
            e h2 = generateDefaultLayoutParams();
            h2.a = 8388611 | (this.o & 112);
            h2.b = 2;
            this.f98i.setLayoutParams(h2);
            this.f98i.setOnClickListener(new c());
        }
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof e);
    }

    public final void d() {
        if (this.u == null) {
            this.u = new t0();
        }
    }

    public final void e() {
        f();
        ActionMenuView actionMenuView = this.b;
        if (actionMenuView.q == null) {
            e.b.e.i.g gVar = (e.b.e.i.g) actionMenuView.getMenu();
            if (this.L == null) {
                this.L = new d();
            }
            this.b.setExpandedActionViewsExclusive(true);
            gVar.b(this.L, this.f100k);
        }
    }

    public final void f() {
        if (this.b == null) {
            ActionMenuView actionMenuView = new ActionMenuView(getContext(), null);
            this.b = actionMenuView;
            actionMenuView.setPopupTheme(this.f101l);
            this.b.setOnMenuItemClickListener(this.I);
            ActionMenuView actionMenuView2 = this.b;
            m.a aVar = this.M;
            g.a aVar2 = this.N;
            actionMenuView2.v = aVar;
            actionMenuView2.w = aVar2;
            e h2 = generateDefaultLayoutParams();
            h2.a = 8388613 | (this.o & 112);
            this.b.setLayoutParams(h2);
            b(this.b, false);
        }
    }

    public final void g() {
        if (this.f94e == null) {
            this.f94e = new o(getContext(), null, R$attr.toolbarNavigationButtonStyle);
            e h2 = generateDefaultLayoutParams();
            h2.a = 8388611 | (this.o & 112);
            this.f94e.setLayoutParams(h2);
        }
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new e(getContext(), attributeSet);
    }

    public CharSequence getCollapseContentDescription() {
        ImageButton imageButton = this.f98i;
        if (imageButton != null) {
            return imageButton.getContentDescription();
        }
        return null;
    }

    public Drawable getCollapseIcon() {
        ImageButton imageButton = this.f98i;
        if (imageButton != null) {
            return imageButton.getDrawable();
        }
        return null;
    }

    public int getContentInsetEnd() {
        t0 t0Var = this.u;
        if (t0Var != null) {
            return t0Var.f1027g ? t0Var.a : t0Var.b;
        }
        return 0;
    }

    public int getContentInsetEndWithActions() {
        int i2 = this.w;
        return i2 != Integer.MIN_VALUE ? i2 : getContentInsetEnd();
    }

    public int getContentInsetLeft() {
        t0 t0Var = this.u;
        if (t0Var != null) {
            return t0Var.a;
        }
        return 0;
    }

    public int getContentInsetRight() {
        t0 t0Var = this.u;
        if (t0Var != null) {
            return t0Var.b;
        }
        return 0;
    }

    public int getContentInsetStart() {
        t0 t0Var = this.u;
        if (t0Var != null) {
            return t0Var.f1027g ? t0Var.b : t0Var.a;
        }
        return 0;
    }

    public int getContentInsetStartWithNavigation() {
        int i2 = this.v;
        return i2 != Integer.MIN_VALUE ? i2 : getContentInsetStart();
    }

    public int getCurrentContentInsetEnd() {
        e.b.e.i.g gVar;
        ActionMenuView actionMenuView = this.b;
        return actionMenuView != null && (gVar = actionMenuView.q) != null && gVar.hasVisibleItems() ? Math.max(getContentInsetEnd(), Math.max(this.w, 0)) : getContentInsetEnd();
    }

    public int getCurrentContentInsetLeft() {
        AtomicInteger atomicInteger = v.a;
        return v.e.d(this) == 1 ? getCurrentContentInsetEnd() : getCurrentContentInsetStart();
    }

    public int getCurrentContentInsetRight() {
        AtomicInteger atomicInteger = v.a;
        return v.e.d(this) == 1 ? getCurrentContentInsetStart() : getCurrentContentInsetEnd();
    }

    public int getCurrentContentInsetStart() {
        return getNavigationIcon() != null ? Math.max(getContentInsetStart(), Math.max(this.v, 0)) : getContentInsetStart();
    }

    public Drawable getLogo() {
        ImageView imageView = this.f95f;
        if (imageView != null) {
            return imageView.getDrawable();
        }
        return null;
    }

    public CharSequence getLogoDescription() {
        ImageView imageView = this.f95f;
        if (imageView != null) {
            return imageView.getContentDescription();
        }
        return null;
    }

    public Menu getMenu() {
        e();
        return this.b.getMenu();
    }

    public CharSequence getNavigationContentDescription() {
        ImageButton imageButton = this.f94e;
        if (imageButton != null) {
            return imageButton.getContentDescription();
        }
        return null;
    }

    public Drawable getNavigationIcon() {
        ImageButton imageButton = this.f94e;
        if (imageButton != null) {
            return imageButton.getDrawable();
        }
        return null;
    }

    public e.b.f.c getOuterActionMenuPresenter() {
        return this.K;
    }

    public Drawable getOverflowIcon() {
        e();
        return this.b.getOverflowIcon();
    }

    public Context getPopupContext() {
        return this.f100k;
    }

    public int getPopupTheme() {
        return this.f101l;
    }

    public CharSequence getSubtitle() {
        return this.z;
    }

    public final TextView getSubtitleTextView() {
        return this.f93d;
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
        return this.c;
    }

    public h0 getWrapper() {
        if (this.J == null) {
            this.J = new e1(this, true);
        }
        return this.J;
    }

    /* renamed from: h */
    public e generateDefaultLayoutParams() {
        return new e(-2, -2);
    }

    /* renamed from: i */
    public e generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof e ? new e((e) layoutParams) : layoutParams instanceof a.C0014a ? new e((a.C0014a) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new e((ViewGroup.MarginLayoutParams) layoutParams) : new e(layoutParams);
    }

    public final int j(int i2) {
        AtomicInteger atomicInteger = v.a;
        int d2 = v.e.d(this);
        int absoluteGravity = Gravity.getAbsoluteGravity(i2, d2) & 7;
        if (absoluteGravity == 1 || absoluteGravity == 3 || absoluteGravity == 5) {
            return absoluteGravity;
        }
        return d2 == 1 ? 5 : 3;
    }

    public final int k(View view, int i2) {
        e eVar = (e) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i3 = i2 > 0 ? (measuredHeight - i2) / 2 : 0;
        int i4 = eVar.a & 112;
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

    public void n(int i2) {
        getMenuInflater().inflate(i2, getMenu());
    }

    public final boolean o(View view) {
        return view.getParent() == this || this.F.contains(view);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.P);
    }

    @Override // android.view.View
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

    /* JADX WARN: Removed duplicated region for block: B:109:0x0297 A[LOOP:0: B:108:0x0295->B:109:0x0297, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:112:0x02b9 A[LOOP:1: B:111:0x02b7->B:112:0x02b9, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:115:0x02de A[LOOP:2: B:114:0x02dc->B:115:0x02de, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:118:0x031f  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0330 A[LOOP:3: B:122:0x032e->B:123:0x0330, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x021d  */
    @Override // android.view.ViewGroup, android.view.View
    /* Code decompiled incorrectly, please refer to instructions dump */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        boolean u;
        boolean u2;
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
        AtomicInteger atomicInteger = v.a;
        boolean z2 = v.e.d(this) == 1;
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
        int d2 = v.d.d(this);
        int min = d2 >= 0 ? Math.min(d2, i5 - i3) : 0;
        if (u(this.f94e)) {
            ImageButton imageButton = this.f94e;
            if (z2) {
                i6 = r(imageButton, i26, iArr, min);
                i7 = paddingLeft;
                if (u(this.f98i)) {
                    ImageButton imageButton2 = this.f98i;
                    if (z2) {
                        i6 = r(imageButton2, i6, iArr, min);
                    } else {
                        i7 = q(imageButton2, i7, iArr, min);
                    }
                }
                if (u(this.b)) {
                    ActionMenuView actionMenuView = this.b;
                    if (z2) {
                        i7 = q(actionMenuView, i7, iArr, min);
                    } else {
                        i6 = r(actionMenuView, i6, iArr, min);
                    }
                }
                int currentContentInsetLeft = getCurrentContentInsetLeft();
                int currentContentInsetRight = getCurrentContentInsetRight();
                iArr[0] = Math.max(0, currentContentInsetLeft - i7);
                iArr[1] = Math.max(0, currentContentInsetRight - (i26 - i6));
                int max = Math.max(i7, currentContentInsetLeft);
                int min2 = Math.min(i6, i26 - currentContentInsetRight);
                if (u(this.f99j)) {
                    View view = this.f99j;
                    if (z2) {
                        min2 = r(view, min2, iArr, min);
                    } else {
                        max = q(view, max, iArr, min);
                    }
                }
                if (u(this.f95f)) {
                    ImageView imageView = this.f95f;
                    if (z2) {
                        min2 = r(imageView, min2, iArr, min);
                    } else {
                        max = q(imageView, max, iArr, min);
                    }
                }
                u = u(this.c);
                u2 = u(this.f93d);
                if (!u) {
                    e eVar = (e) this.c.getLayoutParams();
                    i8 = paddingRight;
                    i9 = this.c.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) eVar).topMargin + ((ViewGroup.MarginLayoutParams) eVar).bottomMargin + 0;
                } else {
                    i8 = paddingRight;
                    i9 = 0;
                }
                if (!u2) {
                    e eVar2 = (e) this.f93d.getLayoutParams();
                    i10 = width;
                    i9 += this.f93d.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) eVar2).topMargin + ((ViewGroup.MarginLayoutParams) eVar2).bottomMargin;
                } else {
                    i10 = width;
                }
                if (!u || u2) {
                    TextView textView = !u ? this.c : this.f93d;
                    TextView textView2 = !u2 ? this.f93d : this.c;
                    e eVar3 = (e) textView.getLayoutParams();
                    e eVar4 = (e) textView2.getLayoutParams();
                    boolean z3 = (!u && this.c.getMeasuredWidth() > 0) || (u2 && this.f93d.getMeasuredWidth() > 0);
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
                    if (!z2) {
                        int i33 = (z3 ? this.q : 0) - iArr[1];
                        min2 -= Math.max(0, i33);
                        iArr[1] = Math.max(0, -i33);
                        if (u) {
                            int measuredWidth = min2 - this.c.getMeasuredWidth();
                            int measuredHeight = this.c.getMeasuredHeight() + i21;
                            this.c.layout(measuredWidth, i21, min2, measuredHeight);
                            i24 = measuredWidth - this.r;
                            i21 = measuredHeight + ((ViewGroup.MarginLayoutParams) ((e) this.c.getLayoutParams())).bottomMargin;
                        } else {
                            i24 = min2;
                        }
                        if (u2) {
                            int i34 = i21 + ((ViewGroup.MarginLayoutParams) ((e) this.f93d.getLayoutParams())).topMargin;
                            this.f93d.layout(min2 - this.f93d.getMeasuredWidth(), i34, min2, this.f93d.getMeasuredHeight() + i34);
                            i25 = min2 - this.r;
                        } else {
                            i25 = min2;
                        }
                        if (z3) {
                            min2 = Math.min(i24, i25);
                        }
                        max = i20;
                    } else {
                        int i35 = (z3 ? this.q : 0) - iArr[0];
                        int max2 = Math.max(0, i35) + i20;
                        iArr[0] = Math.max(0, -i35);
                        if (u) {
                            int measuredWidth2 = this.c.getMeasuredWidth() + max2;
                            int measuredHeight2 = this.c.getMeasuredHeight() + i21;
                            this.c.layout(max2, i21, measuredWidth2, measuredHeight2);
                            i22 = measuredWidth2 + this.r;
                            i21 = measuredHeight2 + ((ViewGroup.MarginLayoutParams) ((e) this.c.getLayoutParams())).bottomMargin;
                        } else {
                            i22 = max2;
                        }
                        if (u2) {
                            int i36 = i21 + ((ViewGroup.MarginLayoutParams) ((e) this.f93d.getLayoutParams())).topMargin;
                            int measuredWidth3 = this.f93d.getMeasuredWidth() + max2;
                            this.f93d.layout(max2, i36, measuredWidth3, this.f93d.getMeasuredHeight() + i36);
                            i23 = measuredWidth3 + this.r;
                        } else {
                            i23 = max2;
                        }
                        max = z3 ? Math.max(i22, i23) : max2;
                    }
                } else {
                    i12 = paddingLeft;
                    i11 = min;
                }
                a(this.E, 3);
                size = this.E.size();
                i13 = max;
                for (i14 = 0; i14 < size; i14++) {
                    i13 = q(this.E.get(i14), i13, iArr, i11);
                }
                a(this.E, 5);
                size2 = this.E.size();
                for (i15 = 0; i15 < size2; i15++) {
                    min2 = r(this.E.get(i15), min2, iArr, i11);
                }
                a(this.E, 1);
                ArrayList<View> arrayList = this.E;
                int i37 = iArr[0];
                int i38 = iArr[1];
                size3 = arrayList.size();
                int i39 = 0;
                for (i16 = 0; i16 < size3; i16++) {
                    View view2 = arrayList.get(i16);
                    e eVar5 = (e) view2.getLayoutParams();
                    int i40 = ((ViewGroup.MarginLayoutParams) eVar5).leftMargin - i37;
                    int i41 = ((ViewGroup.MarginLayoutParams) eVar5).rightMargin - i38;
                    int max3 = Math.max(0, i40);
                    int max4 = Math.max(0, i41);
                    i37 = Math.max(0, -i40);
                    i38 = Math.max(0, -i41);
                    i39 += view2.getMeasuredWidth() + max3 + max4;
                }
                i17 = ((((i10 - i12) - i8) / 2) + i12) - (i39 / 2);
                int i42 = i39 + i17;
                if (i17 >= i13) {
                    i13 = i42 > min2 ? i17 - (i42 - min2) : i17;
                }
                size4 = this.E.size();
                int i43 = i13;
                for (i18 = 0; i18 < size4; i18++) {
                    i43 = q(this.E.get(i18), i43, iArr, i11);
                }
                this.E.clear();
            }
            i7 = q(imageButton, paddingLeft, iArr, min);
        } else {
            i7 = paddingLeft;
        }
        i6 = i26;
        if (u(this.f98i)) {
        }
        if (u(this.b)) {
        }
        int currentContentInsetLeft2 = getCurrentContentInsetLeft();
        int currentContentInsetRight2 = getCurrentContentInsetRight();
        iArr[0] = Math.max(0, currentContentInsetLeft2 - i7);
        iArr[1] = Math.max(0, currentContentInsetRight2 - (i26 - i6));
        int max5 = Math.max(i7, currentContentInsetLeft2);
        int min22 = Math.min(i6, i26 - currentContentInsetRight2);
        if (u(this.f99j)) {
        }
        if (u(this.f95f)) {
        }
        u = u(this.c);
        u2 = u(this.f93d);
        if (!u) {
        }
        if (!u2) {
        }
        if (!u) {
        }
        if (!u) {
        }
        if (!u2) {
        }
        e eVar32 = (e) textView.getLayoutParams();
        e eVar42 = (e) textView2.getLayoutParams();
        if (!u) {
        }
        i19 = this.x & 112;
        i12 = paddingLeft;
        if (i19 != 48) {
        }
        if (!z2) {
        }
        a(this.E, 3);
        size = this.E.size();
        i13 = max5;
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
        int i392 = 0;
        while (i16 < size3) {
        }
        i17 = ((((i10 - i12) - i8) / 2) + i12) - (i392 / 2);
        int i422 = i392 + i17;
        if (i17 >= i13) {
        }
        size4 = this.E.size();
        int i432 = i13;
        while (i18 < size4) {
        }
        this.E.clear();
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x0296  */
    @Override // android.view.View
    /* Code decompiled incorrectly, please refer to instructions dump */
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
        boolean z = true;
        int i11 = 0;
        if (i1.a(this)) {
            c3 = 1;
            c2 = 0;
        } else {
            c3 = 0;
            c2 = 1;
        }
        if (u(this.f94e)) {
            t(this.f94e, i2, 0, i3, 0, this.p);
            i6 = l(this.f94e) + this.f94e.getMeasuredWidth();
            i5 = Math.max(0, m(this.f94e) + this.f94e.getMeasuredHeight());
            i4 = View.combineMeasuredStates(0, this.f94e.getMeasuredState());
        } else {
            i6 = 0;
            i5 = 0;
            i4 = 0;
        }
        if (u(this.f98i)) {
            t(this.f98i, i2, 0, i3, 0, this.p);
            i6 = l(this.f98i) + this.f98i.getMeasuredWidth();
            i5 = Math.max(i5, m(this.f98i) + this.f98i.getMeasuredHeight());
            i4 = View.combineMeasuredStates(i4, this.f98i.getMeasuredState());
        }
        int currentContentInsetStart = getCurrentContentInsetStart();
        int max = Math.max(currentContentInsetStart, i6) + 0;
        iArr[c3] = Math.max(0, currentContentInsetStart - i6);
        if (u(this.b)) {
            t(this.b, i2, max, i3, 0, this.p);
            i7 = l(this.b) + this.b.getMeasuredWidth();
            i5 = Math.max(i5, m(this.b) + this.b.getMeasuredHeight());
            i4 = View.combineMeasuredStates(i4, this.b.getMeasuredState());
        } else {
            i7 = 0;
        }
        int currentContentInsetEnd = getCurrentContentInsetEnd();
        int max2 = Math.max(currentContentInsetEnd, i7) + max;
        iArr[c2] = Math.max(0, currentContentInsetEnd - i7);
        if (u(this.f99j)) {
            max2 += s(this.f99j, i2, max2, i3, 0, iArr);
            i5 = Math.max(i5, m(this.f99j) + this.f99j.getMeasuredHeight());
            i4 = View.combineMeasuredStates(i4, this.f99j.getMeasuredState());
        }
        if (u(this.f95f)) {
            max2 += s(this.f95f, i2, max2, i3, 0, iArr);
            i5 = Math.max(i5, m(this.f95f) + this.f95f.getMeasuredHeight());
            i4 = View.combineMeasuredStates(i4, this.f95f.getMeasuredState());
        }
        int childCount = getChildCount();
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            if (((e) childAt.getLayoutParams()).b == 0 && u(childAt)) {
                max2 += s(childAt, i2, max2, i3, 0, iArr);
                i5 = Math.max(i5, m(childAt) + childAt.getMeasuredHeight());
                i4 = View.combineMeasuredStates(i4, childAt.getMeasuredState());
            }
        }
        int i13 = this.s + this.t;
        int i14 = this.q + this.r;
        if (u(this.c)) {
            s(this.c, i2, max2 + i14, i3, i13, iArr);
            i9 = l(this.c) + this.c.getMeasuredWidth();
            i8 = m(this.c) + this.c.getMeasuredHeight();
            i10 = View.combineMeasuredStates(i4, this.c.getMeasuredState());
        } else {
            i10 = i4;
            i9 = 0;
            i8 = 0;
        }
        if (u(this.f93d)) {
            i9 = Math.max(i9, s(this.f93d, i2, max2 + i14, i3, i8 + i13, iArr));
            i8 = m(this.f93d) + this.f93d.getMeasuredHeight() + i8;
            i10 = View.combineMeasuredStates(i10, this.f93d.getMeasuredState());
        }
        int max3 = Math.max(i5, i8);
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingBottom = getPaddingBottom() + getPaddingTop() + max3;
        int resolveSizeAndState = View.resolveSizeAndState(Math.max(paddingRight + max2 + i9, getSuggestedMinimumWidth()), i2, -16777216 & i10);
        i11 = View.resolveSizeAndState(Math.max(paddingBottom, getSuggestedMinimumHeight()), i3, i10 << 16);
        if (this.O) {
            int childCount2 = getChildCount();
            for (int i15 = 0; i15 < childCount2; i15++) {
                View childAt2 = getChildAt(i15);
                if (!u(childAt2) || childAt2.getMeasuredWidth() <= 0 || childAt2.getMeasuredHeight() <= 0) {
                }
            }
            if (!z) {
            }
            setMeasuredDimension(resolveSizeAndState, i11);
        }
        z = false;
        if (!z) {
        }
        setMeasuredDimension(resolveSizeAndState, i11);
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        MenuItem findItem;
        if (!(parcelable instanceof g)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        g gVar = (g) parcelable;
        super.onRestoreInstanceState(gVar.b);
        ActionMenuView actionMenuView = this.b;
        e.b.e.i.g gVar2 = actionMenuView != null ? actionMenuView.q : null;
        int i2 = gVar.f103d;
        if (!(i2 == 0 || this.L == null || gVar2 == null || (findItem = gVar2.findItem(i2)) == null)) {
            findItem.expandActionView();
        }
        if (gVar.f104e) {
            removeCallbacks(this.P);
            post(this.P);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0027, code lost:
        if (r1 != Integer.MIN_VALUE) goto L_0x003e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0035, code lost:
        if (r1 != Integer.MIN_VALUE) goto L_0x003e;
     */
    @Override // android.view.View
    /* Code decompiled incorrectly, please refer to instructions dump */
    public void onRtlPropertiesChanged(int i2) {
        int i3;
        super.onRtlPropertiesChanged(i2);
        d();
        t0 t0Var = this.u;
        boolean z = true;
        if (i2 != 1) {
            z = false;
        }
        if (z != t0Var.f1027g) {
            t0Var.f1027g = z;
            if (!t0Var.f1028h) {
                t0Var.a = t0Var.f1025e;
            } else if (z) {
                int i4 = t0Var.f1024d;
                if (i4 == Integer.MIN_VALUE) {
                    i4 = t0Var.f1025e;
                }
                t0Var.a = i4;
                i3 = t0Var.c;
            } else {
                int i5 = t0Var.c;
                if (i5 == Integer.MIN_VALUE) {
                    i5 = t0Var.f1025e;
                }
                t0Var.a = i5;
                i3 = t0Var.f1024d;
            }
            i3 = t0Var.f1026f;
            t0Var.b = i3;
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        i iVar;
        g gVar = new g(super.onSaveInstanceState());
        d dVar = this.L;
        if (!(dVar == null || (iVar = dVar.c) == null)) {
            gVar.f103d = iVar.a;
        }
        gVar.f104e = p();
        return gVar;
    }

    @Override // android.view.View
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

    public boolean p() {
        ActionMenuView actionMenuView = this.b;
        if (actionMenuView != null) {
            e.b.f.c cVar = actionMenuView.u;
            if (cVar != null && cVar.m()) {
                return true;
            }
        }
        return false;
    }

    public final int q(View view, int i2, int[] iArr, int i3) {
        e eVar = (e) view.getLayoutParams();
        int i4 = ((ViewGroup.MarginLayoutParams) eVar).leftMargin - iArr[0];
        int max = Math.max(0, i4) + i2;
        iArr[0] = Math.max(0, -i4);
        int k2 = k(view, i3);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max, k2, max + measuredWidth, view.getMeasuredHeight() + k2);
        return measuredWidth + ((ViewGroup.MarginLayoutParams) eVar).rightMargin + max;
    }

    public final int r(View view, int i2, int[] iArr, int i3) {
        e eVar = (e) view.getLayoutParams();
        int i4 = ((ViewGroup.MarginLayoutParams) eVar).rightMargin - iArr[1];
        int max = i2 - Math.max(0, i4);
        iArr[1] = Math.max(0, -i4);
        int k2 = k(view, i3);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max - measuredWidth, k2, max, view.getMeasuredHeight() + k2);
        return max - (measuredWidth + ((ViewGroup.MarginLayoutParams) eVar).leftMargin);
    }

    public final int s(View view, int i2, int i3, int i4, int i5, int[] iArr) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i6 = marginLayoutParams.leftMargin - iArr[0];
        int i7 = marginLayoutParams.rightMargin - iArr[1];
        int max = Math.max(0, i7) + Math.max(0, i6);
        iArr[0] = Math.max(0, -i6);
        iArr[1] = Math.max(0, -i7);
        view.measure(ViewGroup.getChildMeasureSpec(i2, getPaddingRight() + getPaddingLeft() + max + i3, marginLayoutParams.width), ViewGroup.getChildMeasureSpec(i4, getPaddingBottom() + getPaddingTop() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i5, marginLayoutParams.height));
        return view.getMeasuredWidth() + max;
    }

    public void setCollapseContentDescription(int i2) {
        setCollapseContentDescription(i2 != 0 ? getContext().getText(i2) : null);
    }

    public void setCollapseContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            c();
        }
        ImageButton imageButton = this.f98i;
        if (imageButton != null) {
            imageButton.setContentDescription(charSequence);
        }
    }

    public void setCollapseIcon(int i2) {
        setCollapseIcon(m.e.i0(getContext(), i2));
    }

    public void setCollapseIcon(Drawable drawable) {
        if (drawable != null) {
            c();
            this.f98i.setImageDrawable(drawable);
            return;
        }
        ImageButton imageButton = this.f98i;
        if (imageButton != null) {
            imageButton.setImageDrawable(this.f96g);
        }
    }

    public void setCollapsible(boolean z) {
        this.O = z;
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
        setLogo(m.e.i0(getContext(), i2));
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            if (this.f95f == null) {
                this.f95f = new q(getContext(), null, 0);
            }
            if (!o(this.f95f)) {
                b(this.f95f, true);
            }
        } else {
            ImageView imageView = this.f95f;
            if (imageView != null && o(imageView)) {
                removeView(this.f95f);
                this.F.remove(this.f95f);
            }
        }
        ImageView imageView2 = this.f95f;
        if (imageView2 != null) {
            imageView2.setImageDrawable(drawable);
        }
    }

    public void setLogoDescription(int i2) {
        setLogoDescription(getContext().getText(i2));
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence) && this.f95f == null) {
            this.f95f = new q(getContext(), null, 0);
        }
        ImageView imageView = this.f95f;
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
        ImageButton imageButton = this.f94e;
        if (imageButton != null) {
            imageButton.setContentDescription(charSequence);
        }
    }

    public void setNavigationIcon(int i2) {
        setNavigationIcon(m.e.i0(getContext(), i2));
    }

    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null) {
            g();
            if (!o(this.f94e)) {
                b(this.f94e, true);
            }
        } else {
            ImageButton imageButton = this.f94e;
            if (imageButton != null && o(imageButton)) {
                removeView(this.f94e);
                this.F.remove(this.f94e);
            }
        }
        ImageButton imageButton2 = this.f94e;
        if (imageButton2 != null) {
            imageButton2.setImageDrawable(drawable);
        }
    }

    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        g();
        this.f94e.setOnClickListener(onClickListener);
    }

    public void setOnMenuItemClickListener(f fVar) {
        this.H = fVar;
    }

    public void setOverflowIcon(Drawable drawable) {
        e();
        this.b.setOverflowIcon(drawable);
    }

    public void setPopupTheme(int i2) {
        if (this.f101l != i2) {
            this.f101l = i2;
            if (i2 == 0) {
                this.f100k = getContext();
            } else {
                this.f100k = new ContextThemeWrapper(getContext(), i2);
            }
        }
    }

    public void setSubtitle(int i2) {
        setSubtitle(getContext().getText(i2));
    }

    public void setSubtitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.f93d == null) {
                Context context = getContext();
                d0 d0Var = new d0(context, null);
                this.f93d = d0Var;
                d0Var.setSingleLine();
                this.f93d.setEllipsize(TextUtils.TruncateAt.END);
                int i2 = this.n;
                if (i2 != 0) {
                    this.f93d.setTextAppearance(context, i2);
                }
                ColorStateList colorStateList = this.B;
                if (colorStateList != null) {
                    this.f93d.setTextColor(colorStateList);
                }
            }
            if (!o(this.f93d)) {
                b(this.f93d, true);
            }
        } else {
            TextView textView = this.f93d;
            if (textView != null && o(textView)) {
                removeView(this.f93d);
                this.F.remove(this.f93d);
            }
        }
        TextView textView2 = this.f93d;
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
        TextView textView = this.f93d;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public void setTitle(int i2) {
        setTitle(getContext().getText(i2));
    }

    public void setTitle(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (this.c == null) {
                Context context = getContext();
                d0 d0Var = new d0(context, null);
                this.c = d0Var;
                d0Var.setSingleLine();
                this.c.setEllipsize(TextUtils.TruncateAt.END);
                int i2 = this.m;
                if (i2 != 0) {
                    this.c.setTextAppearance(context, i2);
                }
                ColorStateList colorStateList = this.A;
                if (colorStateList != null) {
                    this.c.setTextColor(colorStateList);
                }
            }
            if (!o(this.c)) {
                b(this.c, true);
            }
        } else {
            TextView textView = this.c;
            if (textView != null && o(textView)) {
                removeView(this.c);
                this.F.remove(this.c);
            }
        }
        TextView textView2 = this.c;
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
        TextView textView = this.c;
        if (textView != null) {
            textView.setTextColor(colorStateList);
        }
    }

    public final void t(View view, int i2, int i3, int i4, int i5, int i6) {
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

    public final boolean u(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    public boolean v() {
        ActionMenuView actionMenuView = this.b;
        if (actionMenuView != null) {
            e.b.f.c cVar = actionMenuView.u;
            if (cVar != null && cVar.n()) {
                return true;
            }
        }
        return false;
    }
}
