package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.widget.Toolbar;
import b.b.k.r;
import b.b.p.i.g;
import b.b.p.i.i;
import b.b.p.i.m;
import b.b.p.i.n;
import b.b.q.c;
import b.b.q.e1;
import b.b.q.i0;

public class ActionMenuView extends i0 implements g.b, n {
    public int A;
    public e B;
    public g q;
    public Context r;
    public int s = 0;
    public boolean t;
    public b.b.q.c u;
    public m.a v;
    public g.a w;
    public boolean x;
    public int y;
    public int z;

    public interface a {
        boolean a();

        boolean b();
    }

    public static class b implements m.a {
        @Override // b.b.p.i.m.a
        public void b(g gVar, boolean z) {
        }

        @Override // b.b.p.i.m.a
        public boolean c(g gVar) {
            return false;
        }
    }

    public static class c extends i0.a {
        @ViewDebug.ExportedProperty

        /* renamed from: c  reason: collision with root package name */
        public boolean f51c;
        @ViewDebug.ExportedProperty

        /* renamed from: d  reason: collision with root package name */
        public int f52d;
        @ViewDebug.ExportedProperty

        /* renamed from: e  reason: collision with root package name */
        public int f53e;
        @ViewDebug.ExportedProperty
        public boolean f;
        @ViewDebug.ExportedProperty
        public boolean g;
        public boolean h;

        public c(int i, int i2) {
            super(i, i2);
            this.f51c = false;
        }

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public c(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public c(c cVar) {
            super(cVar);
            this.f51c = cVar.f51c;
        }
    }

    public class d implements g.a {
        public d() {
        }

        @Override // b.b.p.i.g.a
        public boolean a(g gVar, MenuItem menuItem) {
            e eVar = ActionMenuView.this.B;
            if (eVar == null) {
                return false;
            }
            Toolbar.f fVar = Toolbar.this.H;
            if (fVar != null ? r.this.f416c.onMenuItemSelected(0, menuItem) : false) {
                return true;
            }
            return false;
        }

        @Override // b.b.p.i.g.a
        public void b(g gVar) {
            g.a aVar = ActionMenuView.this.w;
            if (aVar != null) {
                aVar.b(gVar);
            }
        }
    }

    public interface e {
    }

    public ActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBaselineAligned(false);
        float f = context.getResources().getDisplayMetrics().density;
        this.z = (int) (56.0f * f);
        this.A = (int) (f * 4.0f);
        this.r = context;
    }

    public static int u(View view, int i, int i2, int i3, int i4) {
        c cVar = (c) view.getLayoutParams();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i3) - i4, View.MeasureSpec.getMode(i3));
        ActionMenuItemView actionMenuItemView = view instanceof ActionMenuItemView ? (ActionMenuItemView) view : null;
        boolean z2 = false;
        boolean z3 = actionMenuItemView != null && actionMenuItemView.c();
        int i5 = 2;
        if (i2 <= 0 || (z3 && i2 < 2)) {
            i5 = 0;
        } else {
            view.measure(View.MeasureSpec.makeMeasureSpec(i2 * i, Integer.MIN_VALUE), makeMeasureSpec);
            int measuredWidth = view.getMeasuredWidth();
            int i6 = measuredWidth / i;
            if (measuredWidth % i != 0) {
                i6++;
            }
            if (!z3 || i6 >= 2) {
                i5 = i6;
            }
        }
        if (!cVar.f51c && z3) {
            z2 = true;
        }
        cVar.f = z2;
        cVar.f52d = i5;
        view.measure(View.MeasureSpec.makeMeasureSpec(i * i5, 1073741824), makeMeasureSpec);
        return i5;
    }

    @Override // b.b.p.i.g.b
    public boolean a(i iVar) {
        return this.q.s(iVar, null, 0);
    }

    @Override // b.b.p.i.n
    public void b(g gVar) {
        this.q = gVar;
    }

    @Override // b.b.q.i0
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof c;
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    @Override // b.b.q.i0, android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new c(getContext(), attributeSet);
    }

    public Menu getMenu() {
        if (this.q == null) {
            Context context = getContext();
            g gVar = new g(context);
            this.q = gVar;
            gVar.f544e = new d();
            b.b.q.c cVar = new b.b.q.c(context);
            this.u = cVar;
            cVar.m = true;
            cVar.n = true;
            m.a aVar = this.v;
            if (aVar == null) {
                aVar = new b();
            }
            cVar.f = aVar;
            this.q.b(this.u, this.r);
            b.b.q.c cVar2 = this.u;
            cVar2.i = this;
            this.q = cVar2.f512d;
        }
        return this.q;
    }

    public Drawable getOverflowIcon() {
        getMenu();
        b.b.q.c cVar = this.u;
        c.d dVar = cVar.j;
        if (dVar != null) {
            return dVar.getDrawable();
        }
        if (cVar.l) {
            return cVar.k;
        }
        return null;
    }

    public int getPopupTheme() {
        return this.s;
    }

    public int getWindowAnimations() {
        return 0;
    }

    @Override // b.b.q.i0
    public i0.a j(AttributeSet attributeSet) {
        return new c(getContext(), attributeSet);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        b.b.q.c cVar = this.u;
        if (cVar != null) {
            cVar.j(false);
            if (this.u.m()) {
                this.u.k();
                this.u.n();
            }
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b.b.q.c cVar = this.u;
        if (cVar != null) {
            cVar.c();
        }
    }

    @Override // b.b.q.i0
    public void onLayout(boolean z2, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        if (!this.x) {
            super.onLayout(z2, i, i2, i3, i4);
            return;
        }
        int childCount = getChildCount();
        int i7 = (i4 - i2) / 2;
        int dividerWidth = getDividerWidth();
        int i8 = i3 - i;
        int paddingRight = (i8 - getPaddingRight()) - getPaddingLeft();
        boolean a2 = e1.a(this);
        int i9 = 0;
        int i10 = 0;
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if (childAt.getVisibility() != 8) {
                c cVar = (c) childAt.getLayoutParams();
                if (cVar.f51c) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    if (t(i11)) {
                        measuredWidth += dividerWidth;
                    }
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (a2) {
                        i5 = getPaddingLeft() + ((ViewGroup.MarginLayoutParams) cVar).leftMargin;
                        i6 = i5 + measuredWidth;
                    } else {
                        i6 = (getWidth() - getPaddingRight()) - ((ViewGroup.MarginLayoutParams) cVar).rightMargin;
                        i5 = i6 - measuredWidth;
                    }
                    int i12 = i7 - (measuredHeight / 2);
                    childAt.layout(i5, i12, i6, measuredHeight + i12);
                    paddingRight -= measuredWidth;
                    i9 = 1;
                } else {
                    paddingRight -= (childAt.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) cVar).leftMargin) + ((ViewGroup.MarginLayoutParams) cVar).rightMargin;
                    t(i11);
                    i10++;
                }
            }
        }
        if (childCount == 1 && i9 == 0) {
            View childAt2 = getChildAt(0);
            int measuredWidth2 = childAt2.getMeasuredWidth();
            int measuredHeight2 = childAt2.getMeasuredHeight();
            int i13 = (i8 / 2) - (measuredWidth2 / 2);
            int i14 = i7 - (measuredHeight2 / 2);
            childAt2.layout(i13, i14, measuredWidth2 + i13, measuredHeight2 + i14);
            return;
        }
        int i15 = i10 - (i9 ^ 1);
        int max = Math.max(0, i15 > 0 ? paddingRight / i15 : 0);
        if (a2) {
            int width = getWidth() - getPaddingRight();
            for (int i16 = 0; i16 < childCount; i16++) {
                View childAt3 = getChildAt(i16);
                c cVar2 = (c) childAt3.getLayoutParams();
                if (childAt3.getVisibility() != 8 && !cVar2.f51c) {
                    int i17 = width - ((ViewGroup.MarginLayoutParams) cVar2).rightMargin;
                    int measuredWidth3 = childAt3.getMeasuredWidth();
                    int measuredHeight3 = childAt3.getMeasuredHeight();
                    int i18 = i7 - (measuredHeight3 / 2);
                    childAt3.layout(i17 - measuredWidth3, i18, i17, measuredHeight3 + i18);
                    width = i17 - ((measuredWidth3 + ((ViewGroup.MarginLayoutParams) cVar2).leftMargin) + max);
                }
            }
            return;
        }
        int paddingLeft = getPaddingLeft();
        for (int i19 = 0; i19 < childCount; i19++) {
            View childAt4 = getChildAt(i19);
            c cVar3 = (c) childAt4.getLayoutParams();
            if (childAt4.getVisibility() != 8 && !cVar3.f51c) {
                int i20 = paddingLeft + ((ViewGroup.MarginLayoutParams) cVar3).leftMargin;
                int measuredWidth4 = childAt4.getMeasuredWidth();
                int measuredHeight4 = childAt4.getMeasuredHeight();
                int i21 = i7 - (measuredHeight4 / 2);
                childAt4.layout(i20, i21, i20 + measuredWidth4, measuredHeight4 + i21);
                paddingLeft = measuredWidth4 + ((ViewGroup.MarginLayoutParams) cVar3).rightMargin + max + i20;
            }
        }
    }

    /* JADX WARN: Type inference failed for: r3v33, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r3v39 */
    /* JADX WARN: Type inference failed for: r3v40 */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // b.b.q.i0
    public void onMeasure(int i, int i2) {
        int i3;
        boolean z2;
        int i4;
        int i5;
        boolean z3;
        int i6;
        ?? r3;
        g gVar;
        boolean z4 = this.x;
        boolean z5 = View.MeasureSpec.getMode(i) == 1073741824;
        this.x = z5;
        if (z4 != z5) {
            this.y = 0;
        }
        int size = View.MeasureSpec.getSize(i);
        if (!(!this.x || (gVar = this.q) == null || size == this.y)) {
            this.y = size;
            gVar.q(true);
        }
        int childCount = getChildCount();
        if (!this.x || childCount <= 0) {
            for (int i7 = 0; i7 < childCount; i7++) {
                c cVar = (c) getChildAt(i7).getLayoutParams();
                ((ViewGroup.MarginLayoutParams) cVar).rightMargin = 0;
                ((ViewGroup.MarginLayoutParams) cVar).leftMargin = 0;
            }
            super.onMeasure(i, i2);
            return;
        }
        int mode = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i);
        int size3 = View.MeasureSpec.getSize(i2);
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i2, paddingBottom, -2);
        int i8 = size2 - paddingRight;
        int i9 = this.z;
        int i10 = i8 / i9;
        int i11 = i8 % i9;
        if (i10 == 0) {
            setMeasuredDimension(i8, 0);
            return;
        }
        int i12 = (i11 / i10) + i9;
        int childCount2 = getChildCount();
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        boolean z6 = false;
        long j = 0;
        while (i17 < childCount2) {
            View childAt = getChildAt(i17);
            if (childAt.getVisibility() != 8) {
                boolean z7 = childAt instanceof ActionMenuItemView;
                int i18 = i13 + 1;
                if (z7) {
                    int i19 = this.A;
                    i6 = i18;
                    r3 = 0;
                    childAt.setPadding(i19, 0, i19, 0);
                } else {
                    i6 = i18;
                    r3 = 0;
                }
                c cVar2 = (c) childAt.getLayoutParams();
                cVar2.h = r3;
                int i20 = r3 == true ? 1 : 0;
                int i21 = r3 == true ? 1 : 0;
                int i22 = r3 == true ? 1 : 0;
                cVar2.f53e = i20;
                cVar2.f52d = r3;
                cVar2.f = r3;
                ((ViewGroup.MarginLayoutParams) cVar2).leftMargin = r3;
                ((ViewGroup.MarginLayoutParams) cVar2).rightMargin = r3;
                cVar2.g = z7 && ((ActionMenuItemView) childAt).c();
                int u2 = u(childAt, i12, cVar2.f51c ? 1 : i10, childMeasureSpec, paddingBottom);
                i15 = Math.max(i15, u2);
                if (cVar2.f) {
                    i16++;
                }
                if (cVar2.f51c) {
                    z6 = true;
                }
                i10 -= u2;
                i14 = Math.max(i14, childAt.getMeasuredHeight());
                if (u2 == 1) {
                    j |= (long) (1 << i17);
                }
                i13 = i6;
            }
            i17++;
            size3 = size3;
            i8 = i8;
        }
        boolean z8 = z6 && i13 == 2;
        boolean z9 = false;
        while (true) {
            if (i16 <= 0 || i10 <= 0) {
                i3 = i14;
                z2 = z9;
            } else {
                int i23 = Integer.MAX_VALUE;
                int i24 = 0;
                int i25 = 0;
                long j2 = 0;
                while (i24 < childCount2) {
                    c cVar3 = (c) getChildAt(i24).getLayoutParams();
                    if (cVar3.f) {
                        int i26 = cVar3.f52d;
                        if (i26 < i23) {
                            j2 = 1 << i24;
                            i23 = i26;
                            i25 = 1;
                        } else if (i26 == i23) {
                            i25++;
                            j2 |= 1 << i24;
                        }
                    }
                    i24++;
                    z9 = z9;
                    i14 = i14;
                }
                i3 = i14;
                z2 = z9;
                j |= j2;
                if (i25 > i10) {
                    break;
                }
                int i27 = i23 + 1;
                int i28 = 0;
                while (i28 < childCount2) {
                    View childAt2 = getChildAt(i28);
                    c cVar4 = (c) childAt2.getLayoutParams();
                    long j3 = (long) (1 << i28);
                    if ((j2 & j3) == 0) {
                        if (cVar4.f52d == i27) {
                            j |= j3;
                        }
                        z3 = z8;
                    } else {
                        if (!z8 || !cVar4.g || i10 != 1) {
                            z3 = z8;
                        } else {
                            int i29 = this.A;
                            z3 = z8;
                            childAt2.setPadding(i29 + i12, 0, i29, 0);
                        }
                        cVar4.f52d++;
                        cVar4.h = true;
                        i10--;
                    }
                    i28++;
                    i16 = i16;
                    z8 = z3;
                }
                i14 = i3;
                z9 = true;
            }
        }
        i3 = i14;
        z2 = z9;
        boolean z10 = !z6 && i13 == 1;
        if (i10 > 0 && j != 0 && (i10 < i13 - 1 || z10 || i15 > 1)) {
            float bitCount = (float) Long.bitCount(j);
            if (!z10) {
                if ((j & 1) != 0 && !((c) getChildAt(0).getLayoutParams()).g) {
                    bitCount -= 0.5f;
                }
                int i30 = childCount2 - 1;
                if ((j & ((long) (1 << i30))) != 0 && !((c) getChildAt(i30).getLayoutParams()).g) {
                    bitCount -= 0.5f;
                }
            }
            int i31 = bitCount > 0.0f ? (int) (((float) (i10 * i12)) / bitCount) : 0;
            for (int i32 = 0; i32 < childCount2; i32++) {
                if ((j & ((long) (1 << i32))) != 0) {
                    View childAt3 = getChildAt(i32);
                    c cVar5 = (c) childAt3.getLayoutParams();
                    if (childAt3 instanceof ActionMenuItemView) {
                        cVar5.f53e = i31;
                        cVar5.h = true;
                        if (i32 == 0 && !cVar5.g) {
                            ((ViewGroup.MarginLayoutParams) cVar5).leftMargin = (-i31) / 2;
                        }
                        z2 = true;
                    } else if (cVar5.f51c) {
                        cVar5.f53e = i31;
                        cVar5.h = true;
                        ((ViewGroup.MarginLayoutParams) cVar5).rightMargin = (-i31) / 2;
                        z2 = true;
                    } else {
                        if (i32 != 0) {
                            ((ViewGroup.MarginLayoutParams) cVar5).leftMargin = i31 / 2;
                        }
                        if (i32 != childCount2 - 1) {
                            ((ViewGroup.MarginLayoutParams) cVar5).rightMargin = i31 / 2;
                        }
                    }
                }
            }
        }
        if (z2) {
            for (int i33 = 0; i33 < childCount2; i33++) {
                View childAt4 = getChildAt(i33);
                c cVar6 = (c) childAt4.getLayoutParams();
                if (cVar6.h) {
                    childAt4.measure(View.MeasureSpec.makeMeasureSpec((cVar6.f52d * i12) + cVar6.f53e, 1073741824), childMeasureSpec);
                }
            }
        }
        if (mode != 1073741824) {
            i5 = i8;
            i4 = i3;
        } else {
            i4 = size3;
            i5 = i8;
        }
        setMeasuredDimension(i5, i4);
    }

    /* renamed from: r */
    public c i() {
        c cVar = new c(-2, -2);
        cVar.f658b = 16;
        return cVar;
    }

    /* renamed from: s */
    public c k(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams == null) {
            return i();
        }
        c cVar = layoutParams instanceof c ? new c((c) layoutParams) : new c(layoutParams);
        if (cVar.f658b <= 0) {
            cVar.f658b = 16;
        }
        return cVar;
    }

    public void setExpandedActionViewsExclusive(boolean z2) {
        this.u.r = z2;
    }

    public void setOnMenuItemClickListener(e eVar) {
        this.B = eVar;
    }

    public void setOverflowIcon(Drawable drawable) {
        getMenu();
        b.b.q.c cVar = this.u;
        c.d dVar = cVar.j;
        if (dVar != null) {
            dVar.setImageDrawable(drawable);
            return;
        }
        cVar.l = true;
        cVar.k = drawable;
    }

    public void setOverflowReserved(boolean z2) {
        this.t = z2;
    }

    public void setPopupTheme(int i) {
        if (this.s != i) {
            this.s = i;
            if (i == 0) {
                this.r = getContext();
            } else {
                this.r = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public void setPresenter(b.b.q.c cVar) {
        this.u = cVar;
        cVar.i = this;
        this.q = cVar.f512d;
    }

    public boolean t(int i) {
        boolean z2 = false;
        if (i == 0) {
            return false;
        }
        View childAt = getChildAt(i - 1);
        View childAt2 = getChildAt(i);
        if (i < getChildCount() && (childAt instanceof a)) {
            z2 = false | ((a) childAt).a();
        }
        return (i <= 0 || !(childAt2 instanceof a)) ? z2 : z2 | ((a) childAt2).b();
    }
}
