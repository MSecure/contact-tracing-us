package b.b.q;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.widget.ActionMenuView;
import b.b.k.i;
import b.b.p.i.g;
import b.b.p.i.k;
import b.b.p.i.l;
import b.b.p.i.m;
import b.b.p.i.n;
import b.b.p.i.p;
import b.b.p.i.r;
import java.util.ArrayList;

public class c extends b.b.p.i.b {
    public d j;
    public Drawable k;
    public boolean l;
    public boolean m;
    public boolean n;
    public int o;
    public int p;
    public int q;
    public boolean r;
    public int s;
    public final SparseBooleanArray t = new SparseBooleanArray();
    public e u;
    public a v;
    public RunnableC0012c w;
    public b x;
    public final f y = new f();
    public int z;

    public class a extends l {
        public a(Context context, r rVar, View view) {
            super(context, rVar, view, false, b.b.a.actionOverflowMenuStyle, 0);
            if (!rVar.B.g()) {
                View view2 = c.this.j;
                this.f = view2 == null ? (View) c.this.i : view2;
            }
            d(c.this.y);
        }

        @Override // b.b.p.i.l
        public void c() {
            c cVar = c.this;
            cVar.v = null;
            cVar.z = 0;
            super.c();
        }
    }

    public class b extends ActionMenuItemView.b {
        public b() {
        }
    }

    /* renamed from: b.b.q.c$c  reason: collision with other inner class name */
    public class RunnableC0012c implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public e f607b;

        public RunnableC0012c(e eVar) {
            this.f607b = eVar;
        }

        public void run() {
            g.a aVar;
            g gVar = c.this.f512d;
            if (!(gVar == null || (aVar = gVar.f544e) == null)) {
                aVar.b(gVar);
            }
            View view = (View) c.this.i;
            if (!(view == null || view.getWindowToken() == null || !this.f607b.f())) {
                c.this.u = this.f607b;
            }
            c.this.w = null;
        }
    }

    public class d extends n implements ActionMenuView.a {

        public class a extends h0 {
            public a(View view, c cVar) {
                super(view);
            }

            @Override // b.b.q.h0
            public p b() {
                e eVar = c.this.u;
                if (eVar == null) {
                    return null;
                }
                return eVar.a();
            }

            @Override // b.b.q.h0
            public boolean c() {
                c.this.n();
                return true;
            }

            @Override // b.b.q.h0
            public boolean d() {
                c cVar = c.this;
                if (cVar.w != null) {
                    return false;
                }
                cVar.k();
                return true;
            }
        }

        public d(Context context) {
            super(context, null, b.b.a.actionOverflowButtonStyle);
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            i.j.e1(this, getContentDescription());
            setOnTouchListener(new a(this, c.this));
        }

        @Override // androidx.appcompat.widget.ActionMenuView.a
        public boolean a() {
            return false;
        }

        @Override // androidx.appcompat.widget.ActionMenuView.a
        public boolean b() {
            return false;
        }

        public boolean performClick() {
            if (super.performClick()) {
                return true;
            }
            playSoundEffect(0);
            c.this.n();
            return true;
        }

        public boolean setFrame(int i, int i2, int i3, int i4) {
            boolean frame = super.setFrame(i, i2, i3, i4);
            Drawable drawable = getDrawable();
            Drawable background = getBackground();
            if (!(drawable == null || background == null)) {
                int width = getWidth();
                int height = getHeight();
                int max = Math.max(width, height) / 2;
                int paddingLeft = (width + (getPaddingLeft() - getPaddingRight())) / 2;
                int paddingTop = (height + (getPaddingTop() - getPaddingBottom())) / 2;
                background.setHotspotBounds(paddingLeft - max, paddingTop - max, paddingLeft + max, paddingTop + max);
            }
            return frame;
        }
    }

    public class e extends l {
        public e(Context context, g gVar, View view, boolean z) {
            super(context, gVar, view, z, b.b.a.actionOverflowMenuStyle, 0);
            this.g = 8388613;
            d(c.this.y);
        }

        @Override // b.b.p.i.l
        public void c() {
            g gVar = c.this.f512d;
            if (gVar != null) {
                gVar.c(true);
            }
            c.this.u = null;
            super.c();
        }
    }

    public class f implements m.a {
        public f() {
        }

        @Override // b.b.p.i.m.a
        public void b(g gVar, boolean z) {
            if (gVar instanceof r) {
                gVar.k().c(false);
            }
            m.a aVar = c.this.f;
            if (aVar != null) {
                aVar.b(gVar, z);
            }
        }

        @Override // b.b.p.i.m.a
        public boolean c(g gVar) {
            c cVar = c.this;
            if (gVar == cVar.f512d) {
                return false;
            }
            int i = ((r) gVar).B.f548a;
            m.a aVar = cVar.f;
            if (aVar != null) {
                return aVar.c(gVar);
            }
            return false;
        }
    }

    public c(Context context) {
        super(context, b.b.g.abc_action_menu_layout, b.b.g.abc_action_menu_item_layout);
    }

    @Override // b.b.p.i.b
    public View a(b.b.p.i.i iVar, View view, ViewGroup viewGroup) {
        View actionView = iVar.getActionView();
        if (actionView == null || iVar.f()) {
            actionView = super.a(iVar, view, viewGroup);
        }
        actionView.setVisibility(iVar.C ? 8 : 0);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(actionMenuView.k(layoutParams));
        }
        return actionView;
    }

    @Override // b.b.p.i.m
    public void b(g gVar, boolean z2) {
        c();
        m.a aVar = this.f;
        if (aVar != null) {
            aVar.b(gVar, z2);
        }
    }

    public boolean c() {
        return k() | l();
    }

    @Override // b.b.p.i.m
    public boolean d() {
        int i;
        ArrayList<b.b.p.i.i> arrayList;
        int i2;
        boolean z2;
        boolean z3;
        boolean z4;
        g gVar = this.f512d;
        View view = null;
        if (gVar != null) {
            arrayList = gVar.l();
            i = arrayList.size();
        } else {
            arrayList = null;
            i = 0;
        }
        int i3 = this.q;
        int i4 = this.p;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) this.i;
        int i5 = 0;
        boolean z5 = false;
        int i6 = 0;
        int i7 = 0;
        while (true) {
            i2 = 2;
            z2 = true;
            if (i5 >= i) {
                break;
            }
            b.b.p.i.i iVar = arrayList.get(i5);
            if ((iVar.y & 2) == 2) {
                i7++;
                z4 = z5;
            } else if ((iVar.y & 1) == 1) {
                i6++;
                z4 = z5;
            } else {
                z4 = true;
            }
            if (this.r && iVar.C) {
                i3 = 0;
            }
            i5++;
            z5 = z4;
        }
        if (this.m && (z5 || i6 + i7 > i3)) {
            i3--;
        }
        int i8 = i3 - i7;
        SparseBooleanArray sparseBooleanArray = this.t;
        sparseBooleanArray.clear();
        int i9 = 0;
        int i10 = 0;
        while (i9 < i) {
            b.b.p.i.i iVar2 = arrayList.get(i9);
            if ((iVar2.y & i2) == i2 ? z2 : false) {
                View a2 = a(iVar2, view, viewGroup);
                a2.measure(makeMeasureSpec, makeMeasureSpec);
                int measuredWidth = a2.getMeasuredWidth();
                i4 -= measuredWidth;
                if (i10 == 0) {
                    i10 = measuredWidth;
                }
                int i11 = iVar2.f549b;
                if (i11 != 0) {
                    sparseBooleanArray.put(i11, z2);
                }
                iVar2.k(z2);
            } else {
                int i12 = iVar2.y;
                int i13 = z2 ? 1 : 0;
                boolean z6 = z2 ? 1 : 0;
                boolean z7 = z2 ? 1 : 0;
                if ((i12 & i13) == z2 ? z2 : false) {
                    int i14 = iVar2.f549b;
                    boolean z8 = sparseBooleanArray.get(i14);
                    boolean z9 = ((i8 > 0 || z8) && i4 > 0) ? z2 : false;
                    if (z9) {
                        View a3 = a(iVar2, view, viewGroup);
                        a3.measure(makeMeasureSpec, makeMeasureSpec);
                        int measuredWidth2 = a3.getMeasuredWidth();
                        i4 -= measuredWidth2;
                        if (i10 == 0) {
                            i10 = measuredWidth2;
                        }
                        if (i4 + i10 > 0) {
                            boolean z10 = z2 ? 1 : 0;
                            boolean z11 = z2 ? 1 : 0;
                            boolean z12 = z2 ? 1 : 0;
                            z3 = z10;
                        } else {
                            z3 = false;
                        }
                        z9 &= z3;
                    }
                    if (z9 && i14 != 0) {
                        sparseBooleanArray.put(i14, z2);
                    } else if (z8) {
                        sparseBooleanArray.put(i14, false);
                        for (int i15 = 0; i15 < i9; i15++) {
                            b.b.p.i.i iVar3 = arrayList.get(i15);
                            if (iVar3.f549b == i14) {
                                if (iVar3.g()) {
                                    i8++;
                                }
                                iVar3.k(false);
                            }
                        }
                    }
                    if (z9) {
                        i8--;
                    }
                    iVar2.k(z9);
                } else {
                    iVar2.k(false);
                    i9++;
                    view = null;
                    i2 = 2;
                    z2 = true;
                }
            }
            i9++;
            view = null;
            i2 = 2;
            z2 = true;
        }
        return z2;
    }

    @Override // b.b.p.i.m
    public void e(Context context, g gVar) {
        this.f511c = context;
        LayoutInflater.from(context);
        this.f512d = gVar;
        Resources resources = context.getResources();
        if (!this.n) {
            this.m = true;
        }
        int i = 2;
        this.o = context.getResources().getDisplayMetrics().widthPixels / 2;
        Configuration configuration = context.getResources().getConfiguration();
        int i2 = configuration.screenWidthDp;
        int i3 = configuration.screenHeightDp;
        if (configuration.smallestScreenWidthDp > 600 || i2 > 600 || ((i2 > 960 && i3 > 720) || (i2 > 720 && i3 > 960))) {
            i = 5;
        } else if (i2 >= 500 || ((i2 > 640 && i3 > 480) || (i2 > 480 && i3 > 640))) {
            i = 4;
        } else if (i2 >= 360) {
            i = 3;
        }
        this.q = i;
        int i4 = this.o;
        if (this.m) {
            if (this.j == null) {
                d dVar = new d(this.f510b);
                this.j = dVar;
                if (this.l) {
                    dVar.setImageDrawable(this.k);
                    this.k = null;
                    this.l = false;
                }
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.j.measure(makeMeasureSpec, makeMeasureSpec);
            }
            i4 -= this.j.getMeasuredWidth();
        } else {
            this.j = null;
        }
        this.p = i4;
        this.s = (int) (resources.getDisplayMetrics().density * 56.0f);
    }

    @Override // b.b.p.i.m, b.b.p.i.b
    public boolean i(r rVar) {
        boolean z2 = false;
        if (!rVar.hasVisibleItems()) {
            return false;
        }
        r rVar2 = rVar;
        while (true) {
            g gVar = rVar2.A;
            if (gVar == this.f512d) {
                break;
            }
            rVar2 = (r) gVar;
        }
        b.b.p.i.i iVar = rVar2.B;
        ViewGroup viewGroup = (ViewGroup) this.i;
        View view = null;
        if (viewGroup != null) {
            int childCount = viewGroup.getChildCount();
            int i = 0;
            while (true) {
                if (i >= childCount) {
                    break;
                }
                View childAt = viewGroup.getChildAt(i);
                if ((childAt instanceof n.a) && ((n.a) childAt).getItemData() == iVar) {
                    view = childAt;
                    break;
                }
                i++;
            }
        }
        if (view == null) {
            return false;
        }
        int i2 = rVar.B.f548a;
        int size = rVar.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                break;
            }
            MenuItem item = rVar.getItem(i3);
            if (item.isVisible() && item.getIcon() != null) {
                z2 = true;
                break;
            }
            i3++;
        }
        a aVar = new a(this.f511c, rVar, view);
        this.v = aVar;
        aVar.h = z2;
        k kVar = aVar.j;
        if (kVar != null) {
            kVar.p(z2);
        }
        if (this.v.f()) {
            super.i(rVar);
            return true;
        }
        throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
    }

    @Override // b.b.p.i.m, b.b.p.i.b
    public void j(boolean z2) {
        ArrayList<b.b.p.i.i> arrayList;
        n nVar;
        super.j(z2);
        ((View) this.i).requestLayout();
        g gVar = this.f512d;
        boolean z3 = false;
        if (gVar != null) {
            gVar.i();
            ArrayList<b.b.p.i.i> arrayList2 = gVar.i;
            int size = arrayList2.size();
            for (int i = 0; i < size; i++) {
                b.i.l.b bVar = arrayList2.get(i).A;
            }
        }
        g gVar2 = this.f512d;
        if (gVar2 != null) {
            gVar2.i();
            arrayList = gVar2.j;
        } else {
            arrayList = null;
        }
        if (this.m && arrayList != null) {
            int size2 = arrayList.size();
            if (size2 == 1) {
                z3 = !arrayList.get(0).C;
            } else if (size2 > 0) {
                z3 = true;
            }
        }
        d dVar = this.j;
        if (z3) {
            if (dVar == null) {
                this.j = new d(this.f510b);
            }
            ViewGroup viewGroup = (ViewGroup) this.j.getParent();
            if (viewGroup != this.i) {
                if (viewGroup != null) {
                    viewGroup.removeView(this.j);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.i;
                d dVar2 = this.j;
                ActionMenuView.c r2 = actionMenuView.i();
                r2.f51c = true;
                actionMenuView.addView(dVar2, r2);
            }
        } else if (dVar != null && dVar.getParent() == (nVar = this.i)) {
            ((ViewGroup) nVar).removeView(this.j);
        }
        ((ActionMenuView) this.i).setOverflowReserved(this.m);
    }

    public boolean k() {
        n nVar;
        RunnableC0012c cVar = this.w;
        if (cVar == null || (nVar = this.i) == null) {
            e eVar = this.u;
            if (eVar == null) {
                return false;
            }
            if (eVar.b()) {
                eVar.j.dismiss();
            }
            return true;
        }
        ((View) nVar).removeCallbacks(cVar);
        this.w = null;
        return true;
    }

    public boolean l() {
        a aVar = this.v;
        if (aVar == null) {
            return false;
        }
        if (!aVar.b()) {
            return true;
        }
        aVar.j.dismiss();
        return true;
    }

    public boolean m() {
        e eVar = this.u;
        return eVar != null && eVar.b();
    }

    public boolean n() {
        g gVar;
        if (!this.m || m() || (gVar = this.f512d) == null || this.i == null || this.w != null) {
            return false;
        }
        gVar.i();
        if (gVar.j.isEmpty()) {
            return false;
        }
        RunnableC0012c cVar = new RunnableC0012c(new e(this.f511c, this.f512d, this.j, true));
        this.w = cVar;
        ((View) this.i).post(cVar);
        return true;
    }
}
