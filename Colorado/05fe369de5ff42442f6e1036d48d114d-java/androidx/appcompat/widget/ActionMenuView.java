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
import android.widget.LinearLayout;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.widget.Toolbar;
import e.b.a.t;
import e.b.e.i.g;
import e.b.e.i.i;
import e.b.e.i.m;
import e.b.e.i.n;
import e.b.f.c;
import e.b.f.e1;
import e.b.f.i0;

public class ActionMenuView extends i0 implements g.b, n {
    public int A;
    public e B;
    public g q;
    public Context r;
    public int s = 0;
    public boolean t;
    public e.b.f.c u;
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
        @Override // e.b.e.i.m.a
        public void b(g gVar, boolean z) {
        }

        @Override // e.b.e.i.m.a
        public boolean c(g gVar) {
            return false;
        }
    }

    public static class c extends i0.a {
        @ViewDebug.ExportedProperty
        public boolean a;
        @ViewDebug.ExportedProperty
        public int b;
        @ViewDebug.ExportedProperty
        public int c;
        @ViewDebug.ExportedProperty

        /* renamed from: d  reason: collision with root package name */
        public boolean f75d;
        @ViewDebug.ExportedProperty

        /* renamed from: e  reason: collision with root package name */
        public boolean f76e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f77f;

        public c(int i2, int i3) {
            super(i2, i3);
            this.a = false;
        }

        public c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public c(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public c(c cVar) {
            super(cVar);
            this.a = cVar.a;
        }
    }

    public class d implements g.a {
        public d() {
        }

        @Override // e.b.e.i.g.a
        public boolean a(g gVar, MenuItem menuItem) {
            e eVar = ActionMenuView.this.B;
            if (eVar == null) {
                return false;
            }
            Toolbar.f fVar = Toolbar.this.H;
            if (fVar != null ? t.this.c.onMenuItemSelected(0, menuItem) : false) {
                return true;
            }
            return false;
        }

        @Override // e.b.e.i.g.a
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
        float f2 = context.getResources().getDisplayMetrics().density;
        this.z = (int) (56.0f * f2);
        this.A = (int) (f2 * 4.0f);
        this.r = context;
    }

    public static int t(View view, int i2, int i3, int i4, int i5) {
        c cVar = (c) view.getLayoutParams();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i4) - i5, View.MeasureSpec.getMode(i4));
        ActionMenuItemView actionMenuItemView = view instanceof ActionMenuItemView ? (ActionMenuItemView) view : null;
        boolean z2 = false;
        boolean z3 = actionMenuItemView != null && actionMenuItemView.c();
        int i6 = 2;
        if (i3 <= 0 || (z3 && i3 < 2)) {
            i6 = 0;
        } else {
            view.measure(View.MeasureSpec.makeMeasureSpec(i3 * i2, Integer.MIN_VALUE), makeMeasureSpec);
            int measuredWidth = view.getMeasuredWidth();
            int i7 = measuredWidth / i2;
            if (measuredWidth % i2 != 0) {
                i7++;
            }
            if (!z3 || i7 >= 2) {
                i6 = i7;
            }
        }
        if (!cVar.a && z3) {
            z2 = true;
        }
        cVar.f75d = z2;
        cVar.b = i6;
        view.measure(View.MeasureSpec.makeMeasureSpec(i2 * i6, 1073741824), makeMeasureSpec);
        return i6;
    }

    @Override // e.b.e.i.g.b
    public boolean a(i iVar) {
        return this.q.s(iVar, null, 0);
    }

    @Override // e.b.e.i.n
    public void b(g gVar) {
        this.q = gVar;
    }

    @Override // e.b.f.i0
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof c;
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    @Override // e.b.f.i0, android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new c(getContext(), attributeSet);
    }

    public Menu getMenu() {
        if (this.q == null) {
            Context context = getContext();
            g gVar = new g(context);
            this.q = gVar;
            gVar.f781e = new d();
            e.b.f.c cVar = new e.b.f.c(context);
            this.u = cVar;
            cVar.m = true;
            cVar.n = true;
            m.a aVar = this.v;
            if (aVar == null) {
                aVar = new b();
            }
            cVar.f756f = aVar;
            this.q.b(cVar, this.r);
            e.b.f.c cVar2 = this.u;
            cVar2.f759i = this;
            this.q = cVar2.f754d;
        }
        return this.q;
    }

    public Drawable getOverflowIcon() {
        getMenu();
        e.b.f.c cVar = this.u;
        c.d dVar = cVar.f855j;
        if (dVar != null) {
            return dVar.getDrawable();
        }
        if (cVar.f857l) {
            return cVar.f856k;
        }
        return null;
    }

    public int getPopupTheme() {
        return this.s;
    }

    public int getWindowAnimations() {
        return 0;
    }

    @Override // e.b.f.i0
    public i0.a i(AttributeSet attributeSet) {
        return new c(getContext(), attributeSet);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        e.b.f.c cVar = this.u;
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
        e.b.f.c cVar = this.u;
        if (cVar != null) {
            cVar.a();
        }
    }

    @Override // e.b.f.i0
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        int i6;
        int i7;
        if (!this.x) {
            super.onLayout(z2, i2, i3, i4, i5);
            return;
        }
        int childCount = getChildCount();
        int i8 = (i5 - i3) / 2;
        int dividerWidth = getDividerWidth();
        int i9 = i4 - i2;
        int paddingRight = (i9 - getPaddingRight()) - getPaddingLeft();
        boolean a2 = e1.a(this);
        int i10 = 0;
        int i11 = 0;
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = getChildAt(i12);
            if (childAt.getVisibility() != 8) {
                c cVar = (c) childAt.getLayoutParams();
                if (cVar.a) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    if (s(i12)) {
                        measuredWidth += dividerWidth;
                    }
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (a2) {
                        i6 = getPaddingLeft() + ((LinearLayout.LayoutParams) cVar).leftMargin;
                        i7 = i6 + measuredWidth;
                    } else {
                        i7 = (getWidth() - getPaddingRight()) - ((LinearLayout.LayoutParams) cVar).rightMargin;
                        i6 = i7 - measuredWidth;
                    }
                    int i13 = i8 - (measuredHeight / 2);
                    childAt.layout(i6, i13, i7, measuredHeight + i13);
                    paddingRight -= measuredWidth;
                    i10 = 1;
                } else {
                    paddingRight -= (childAt.getMeasuredWidth() + ((LinearLayout.LayoutParams) cVar).leftMargin) + ((LinearLayout.LayoutParams) cVar).rightMargin;
                    s(i12);
                    i11++;
                }
            }
        }
        if (childCount == 1 && i10 == 0) {
            View childAt2 = getChildAt(0);
            int measuredWidth2 = childAt2.getMeasuredWidth();
            int measuredHeight2 = childAt2.getMeasuredHeight();
            int i14 = (i9 / 2) - (measuredWidth2 / 2);
            int i15 = i8 - (measuredHeight2 / 2);
            childAt2.layout(i14, i15, measuredWidth2 + i14, measuredHeight2 + i15);
            return;
        }
        int i16 = i11 - (i10 ^ 1);
        int max = Math.max(0, i16 > 0 ? paddingRight / i16 : 0);
        if (a2) {
            int width = getWidth() - getPaddingRight();
            for (int i17 = 0; i17 < childCount; i17++) {
                View childAt3 = getChildAt(i17);
                c cVar2 = (c) childAt3.getLayoutParams();
                if (childAt3.getVisibility() != 8 && !cVar2.a) {
                    int i18 = width - ((LinearLayout.LayoutParams) cVar2).rightMargin;
                    int measuredWidth3 = childAt3.getMeasuredWidth();
                    int measuredHeight3 = childAt3.getMeasuredHeight();
                    int i19 = i8 - (measuredHeight3 / 2);
                    childAt3.layout(i18 - measuredWidth3, i19, i18, measuredHeight3 + i19);
                    width = i18 - ((measuredWidth3 + ((LinearLayout.LayoutParams) cVar2).leftMargin) + max);
                }
            }
            return;
        }
        int paddingLeft = getPaddingLeft();
        for (int i20 = 0; i20 < childCount; i20++) {
            View childAt4 = getChildAt(i20);
            c cVar3 = (c) childAt4.getLayoutParams();
            if (childAt4.getVisibility() != 8 && !cVar3.a) {
                int i21 = paddingLeft + ((LinearLayout.LayoutParams) cVar3).leftMargin;
                int measuredWidth4 = childAt4.getMeasuredWidth();
                int measuredHeight4 = childAt4.getMeasuredHeight();
                int i22 = i8 - (measuredHeight4 / 2);
                childAt4.layout(i21, i22, i21 + measuredWidth4, measuredHeight4 + i22);
                paddingLeft = measuredWidth4 + ((LinearLayout.LayoutParams) cVar3).rightMargin + max + i21;
            }
        }
    }

    /* JADX WARN: Type inference failed for: r3v32, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r3v38 */
    /* JADX WARN: Type inference failed for: r3v39 */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // e.b.f.i0
    public void onMeasure(int i2, int i3) {
        int i4;
        boolean z2;
        int i5;
        int i6;
        boolean z3;
        int i7;
        ?? r3;
        g gVar;
        boolean z4 = this.x;
        boolean z5 = View.MeasureSpec.getMode(i2) == 1073741824;
        this.x = z5;
        if (z4 != z5) {
            this.y = 0;
        }
        int size = View.MeasureSpec.getSize(i2);
        if (!(!this.x || (gVar = this.q) == null || size == this.y)) {
            this.y = size;
            gVar.q(true);
        }
        int childCount = getChildCount();
        if (!this.x || childCount <= 0) {
            for (int i8 = 0; i8 < childCount; i8++) {
                c cVar = (c) getChildAt(i8).getLayoutParams();
                ((LinearLayout.LayoutParams) cVar).rightMargin = 0;
                ((LinearLayout.LayoutParams) cVar).leftMargin = 0;
            }
            super.onMeasure(i2, i3);
            return;
        }
        int mode = View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i2);
        int size3 = View.MeasureSpec.getSize(i3);
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i3, paddingBottom, -2);
        int i9 = size2 - paddingRight;
        int i10 = this.z;
        int i11 = i9 / i10;
        int i12 = i9 % i10;
        if (i11 == 0) {
            setMeasuredDimension(i9, 0);
            return;
        }
        int i13 = (i12 / i11) + i10;
        int childCount2 = getChildCount();
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        boolean z6 = false;
        long j2 = 0;
        while (i18 < childCount2) {
            View childAt = getChildAt(i18);
            if (childAt.getVisibility() != 8) {
                boolean z7 = childAt instanceof ActionMenuItemView;
                int i19 = i14 + 1;
                if (z7) {
                    int i20 = this.A;
                    i7 = i19;
                    r3 = 0;
                    childAt.setPadding(i20, 0, i20, 0);
                } else {
                    i7 = i19;
                    r3 = 0;
                }
                c cVar2 = (c) childAt.getLayoutParams();
                cVar2.f77f = r3;
                int i21 = r3 == true ? 1 : 0;
                int i22 = r3 == true ? 1 : 0;
                int i23 = r3 == true ? 1 : 0;
                cVar2.c = i21;
                cVar2.b = r3;
                cVar2.f75d = r3;
                ((LinearLayout.LayoutParams) cVar2).leftMargin = r3;
                ((LinearLayout.LayoutParams) cVar2).rightMargin = r3;
                cVar2.f76e = z7 && ((ActionMenuItemView) childAt).c();
                int t2 = t(childAt, i13, cVar2.a ? 1 : i11, childMeasureSpec, paddingBottom);
                i16 = Math.max(i16, t2);
                if (cVar2.f75d) {
                    i17++;
                }
                if (cVar2.a) {
                    z6 = true;
                }
                i11 -= t2;
                i15 = Math.max(i15, childAt.getMeasuredHeight());
                if (t2 == 1) {
                    j2 |= (long) (1 << i18);
                }
                i14 = i7;
            }
            i18++;
            size3 = size3;
            i9 = i9;
        }
        boolean z8 = z6 && i14 == 2;
        boolean z9 = false;
        while (true) {
            if (i17 <= 0 || i11 <= 0) {
                i4 = i15;
                z2 = z9;
            } else {
                int i24 = Integer.MAX_VALUE;
                int i25 = 0;
                int i26 = 0;
                long j3 = 0;
                while (i25 < childCount2) {
                    c cVar3 = (c) getChildAt(i25).getLayoutParams();
                    if (cVar3.f75d) {
                        int i27 = cVar3.b;
                        if (i27 < i24) {
                            j3 = 1 << i25;
                            i24 = i27;
                            i26 = 1;
                        } else if (i27 == i24) {
                            i26++;
                            j3 |= 1 << i25;
                        }
                    }
                    i25++;
                    z9 = z9;
                    i15 = i15;
                }
                i4 = i15;
                z2 = z9;
                j2 |= j3;
                if (i26 > i11) {
                    break;
                }
                int i28 = i24 + 1;
                int i29 = 0;
                while (i29 < childCount2) {
                    View childAt2 = getChildAt(i29);
                    c cVar4 = (c) childAt2.getLayoutParams();
                    long j4 = (long) (1 << i29);
                    if ((j3 & j4) == 0) {
                        if (cVar4.b == i28) {
                            j2 |= j4;
                        }
                        z3 = z8;
                    } else {
                        if (!z8 || !cVar4.f76e || i11 != 1) {
                            z3 = z8;
                        } else {
                            int i30 = this.A;
                            z3 = z8;
                            childAt2.setPadding(i30 + i13, 0, i30, 0);
                        }
                        cVar4.b++;
                        cVar4.f77f = true;
                        i11--;
                    }
                    i29++;
                    i17 = i17;
                    z8 = z3;
                }
                i15 = i4;
                z9 = true;
            }
        }
        i4 = i15;
        z2 = z9;
        boolean z10 = !z6 && i14 == 1;
        if (i11 > 0 && j2 != 0 && (i11 < i14 - 1 || z10 || i16 > 1)) {
            float bitCount = (float) Long.bitCount(j2);
            if (!z10) {
                if ((j2 & 1) != 0 && !((c) getChildAt(0).getLayoutParams()).f76e) {
                    bitCount -= 0.5f;
                }
                int i31 = childCount2 - 1;
                if ((j2 & ((long) (1 << i31))) != 0 && !((c) getChildAt(i31).getLayoutParams()).f76e) {
                    bitCount -= 0.5f;
                }
            }
            int i32 = bitCount > 0.0f ? (int) (((float) (i11 * i13)) / bitCount) : 0;
            for (int i33 = 0; i33 < childCount2; i33++) {
                if ((j2 & ((long) (1 << i33))) != 0) {
                    View childAt3 = getChildAt(i33);
                    c cVar5 = (c) childAt3.getLayoutParams();
                    if (childAt3 instanceof ActionMenuItemView) {
                        cVar5.c = i32;
                        cVar5.f77f = true;
                        if (i33 == 0 && !cVar5.f76e) {
                            ((LinearLayout.LayoutParams) cVar5).leftMargin = (-i32) / 2;
                        }
                    } else if (cVar5.a) {
                        cVar5.c = i32;
                        cVar5.f77f = true;
                        ((LinearLayout.LayoutParams) cVar5).rightMargin = (-i32) / 2;
                    } else {
                        if (i33 != 0) {
                            ((LinearLayout.LayoutParams) cVar5).leftMargin = i32 / 2;
                        }
                        if (i33 != childCount2 - 1) {
                            ((LinearLayout.LayoutParams) cVar5).rightMargin = i32 / 2;
                        }
                    }
                    z2 = true;
                }
            }
        }
        if (z2) {
            for (int i34 = 0; i34 < childCount2; i34++) {
                View childAt4 = getChildAt(i34);
                c cVar6 = (c) childAt4.getLayoutParams();
                if (cVar6.f77f) {
                    childAt4.measure(View.MeasureSpec.makeMeasureSpec((cVar6.b * i13) + cVar6.c, 1073741824), childMeasureSpec);
                }
            }
        }
        if (mode != 1073741824) {
            i6 = i9;
            i5 = i4;
        } else {
            i5 = size3;
            i6 = i9;
        }
        setMeasuredDimension(i6, i5);
    }

    /* renamed from: q */
    public c h() {
        c cVar = new c(-2, -2);
        ((LinearLayout.LayoutParams) cVar).gravity = 16;
        return cVar;
    }

    /* renamed from: r */
    public c j(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams == null) {
            return h();
        }
        c cVar = layoutParams instanceof c ? new c((c) layoutParams) : new c(layoutParams);
        if (((LinearLayout.LayoutParams) cVar).gravity <= 0) {
            ((LinearLayout.LayoutParams) cVar).gravity = 16;
        }
        return cVar;
    }

    public boolean s(int i2) {
        boolean z2 = false;
        if (i2 == 0) {
            return false;
        }
        View childAt = getChildAt(i2 - 1);
        View childAt2 = getChildAt(i2);
        if (i2 < getChildCount() && (childAt instanceof a)) {
            z2 = false | ((a) childAt).a();
        }
        return (i2 <= 0 || !(childAt2 instanceof a)) ? z2 : z2 | ((a) childAt2).b();
    }

    public void setExpandedActionViewsExclusive(boolean z2) {
        this.u.r = z2;
    }

    public void setOnMenuItemClickListener(e eVar) {
        this.B = eVar;
    }

    public void setOverflowIcon(Drawable drawable) {
        getMenu();
        e.b.f.c cVar = this.u;
        c.d dVar = cVar.f855j;
        if (dVar != null) {
            dVar.setImageDrawable(drawable);
            return;
        }
        cVar.f857l = true;
        cVar.f856k = drawable;
    }

    public void setOverflowReserved(boolean z2) {
        this.t = z2;
    }

    public void setPopupTheme(int i2) {
        if (this.s != i2) {
            this.s = i2;
            if (i2 == 0) {
                this.r = getContext();
            } else {
                this.r = new ContextThemeWrapper(getContext(), i2);
            }
        }
    }

    public void setPresenter(e.b.f.c cVar) {
        this.u = cVar;
        cVar.f759i = this;
        this.q = cVar.f754d;
    }
}
