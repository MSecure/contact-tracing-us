package e.b.f;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$layout;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.widget.ActionMenuView;
import e.b.a.m;
import e.b.e.i.g;
import e.b.e.i.i;
import e.b.e.i.k;
import e.b.e.i.l;
import e.b.e.i.m;
import e.b.e.i.n;
import e.b.e.i.p;
import e.b.e.i.r;
import java.util.ArrayList;
import java.util.Objects;

public class c extends e.b.e.i.b {

    /* renamed from: j  reason: collision with root package name */
    public d f865j;

    /* renamed from: k  reason: collision with root package name */
    public Drawable f866k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f867l;
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
    public RunnableC0020c w;
    public b x;
    public final f y = new f();

    public class a extends l {
        public a(Context context, r rVar, View view) {
            super(context, rVar, view, false, R$attr.actionOverflowMenuStyle, 0);
            if (!rVar.A.g()) {
                View view2 = c.this.f865j;
                this.f814f = view2 == null ? (View) c.this.f769i : view2;
            }
            d(c.this.y);
        }

        @Override // e.b.e.i.l
        public void c() {
            c cVar = c.this;
            cVar.v = null;
            Objects.requireNonNull(cVar);
            super.c();
        }
    }

    public class b extends ActionMenuItemView.b {
        public b() {
        }
    }

    /* renamed from: e.b.f.c$c  reason: collision with other inner class name */
    public class RunnableC0020c implements Runnable {
        public e b;

        public RunnableC0020c(e eVar) {
            this.b = eVar;
        }

        public void run() {
            g.a aVar;
            g gVar = c.this.f764d;
            if (!(gVar == null || (aVar = gVar.f791e) == null)) {
                aVar.b(gVar);
            }
            View view = (View) c.this.f769i;
            if (!(view == null || view.getWindowToken() == null || !this.b.f())) {
                c.this.u = this.b;
            }
            c.this.w = null;
        }
    }

    public class d extends n implements ActionMenuView.a {

        public class a extends h0 {
            public a(View view, c cVar) {
                super(view);
            }

            @Override // e.b.f.h0
            public p b() {
                e eVar = c.this.u;
                if (eVar == null) {
                    return null;
                }
                return eVar.a();
            }

            @Override // e.b.f.h0
            public boolean c() {
                c.this.n();
                return true;
            }

            @Override // e.b.f.h0
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
            super(context, null, R$attr.actionOverflowButtonStyle);
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            m.h.h1(this, getContentDescription());
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

        public boolean setFrame(int i2, int i3, int i4, int i5) {
            boolean frame = super.setFrame(i2, i3, i4, i5);
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
            super(context, gVar, view, z, R$attr.actionOverflowMenuStyle, 0);
            this.f815g = 8388613;
            d(c.this.y);
        }

        @Override // e.b.e.i.l
        public void c() {
            g gVar = c.this.f764d;
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

        @Override // e.b.e.i.m.a
        public void b(g gVar, boolean z) {
            if (gVar instanceof r) {
                gVar.k().c(false);
            }
            m.a aVar = c.this.f766f;
            if (aVar != null) {
                aVar.b(gVar, z);
            }
        }

        @Override // e.b.e.i.m.a
        public boolean c(g gVar) {
            c cVar = c.this;
            if (gVar == cVar.f764d) {
                return false;
            }
            int i2 = ((r) gVar).A.a;
            m.a aVar = cVar.f766f;
            if (aVar != null) {
                return aVar.c(gVar);
            }
            return false;
        }
    }

    public c(Context context) {
        super(context, R$layout.abc_action_menu_layout, R$layout.abc_action_menu_item_layout);
    }

    public boolean a() {
        return k() | l();
    }

    @Override // e.b.e.i.m
    public void b(g gVar, boolean z) {
        a();
        m.a aVar = this.f766f;
        if (aVar != null) {
            aVar.b(gVar, z);
        }
    }

    public View c(i iVar, View view, ViewGroup viewGroup) {
        n.a aVar;
        View actionView = iVar.getActionView();
        int i2 = 0;
        if (actionView == null || iVar.f()) {
            if (view instanceof n.a) {
                aVar = (n.a) view;
            } else {
                aVar = (n.a) this.f765e.inflate(this.f768h, viewGroup, false);
            }
            aVar.d(iVar, 0);
            ActionMenuItemView actionMenuItemView = (ActionMenuItemView) aVar;
            actionMenuItemView.setItemInvoker((ActionMenuView) this.f769i);
            if (this.x == null) {
                this.x = new b();
            }
            actionMenuItemView.setPopupCallback(this.x);
            actionView = (View) aVar;
        }
        if (iVar.C) {
            i2 = 8;
        }
        actionView.setVisibility(i2);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(actionMenuView.j(layoutParams));
        }
        return actionView;
    }

    @Override // e.b.e.i.m
    public boolean d() {
        int i2;
        ArrayList<i> arrayList;
        int i3;
        boolean z;
        g gVar = this.f764d;
        if (gVar != null) {
            arrayList = gVar.l();
            i2 = arrayList.size();
        } else {
            arrayList = null;
            i2 = 0;
        }
        int i4 = this.q;
        int i5 = this.p;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) this.f769i;
        int i6 = 0;
        boolean z2 = false;
        int i7 = 0;
        int i8 = 0;
        while (true) {
            i3 = 2;
            z = true;
            if (i6 >= i2) {
                break;
            }
            i iVar = arrayList.get(i6);
            int i9 = iVar.y;
            if ((i9 & 2) == 2) {
                i8++;
            } else if ((i9 & 1) == 1) {
                i7++;
            } else {
                z2 = true;
            }
            if (this.r && iVar.C) {
                i4 = 0;
            }
            i6++;
        }
        if (this.m && (z2 || i7 + i8 > i4)) {
            i4--;
        }
        int i10 = i4 - i8;
        SparseBooleanArray sparseBooleanArray = this.t;
        sparseBooleanArray.clear();
        int i11 = 0;
        int i12 = 0;
        while (i11 < i2) {
            i iVar2 = arrayList.get(i11);
            int i13 = iVar2.y;
            if ((i13 & 2) == i3) {
                View c = c(iVar2, null, viewGroup);
                c.measure(makeMeasureSpec, makeMeasureSpec);
                int measuredWidth = c.getMeasuredWidth();
                i5 -= measuredWidth;
                if (i12 == 0) {
                    i12 = measuredWidth;
                }
                int i14 = iVar2.b;
                if (i14 != 0) {
                    sparseBooleanArray.put(i14, z);
                }
                iVar2.k(z);
            } else if ((i13 & 1) == z) {
                int i15 = iVar2.b;
                boolean z3 = sparseBooleanArray.get(i15);
                boolean z4 = (i10 > 0 || z3) && i5 > 0;
                if (z4) {
                    View c2 = c(iVar2, null, viewGroup);
                    c2.measure(makeMeasureSpec, makeMeasureSpec);
                    int measuredWidth2 = c2.getMeasuredWidth();
                    i5 -= measuredWidth2;
                    if (i12 == 0) {
                        i12 = measuredWidth2;
                    }
                    z4 &= i5 + i12 > 0;
                }
                if (z4 && i15 != 0) {
                    sparseBooleanArray.put(i15, true);
                } else if (z3) {
                    sparseBooleanArray.put(i15, false);
                    for (int i16 = 0; i16 < i11; i16++) {
                        i iVar3 = arrayList.get(i16);
                        if (iVar3.b == i15) {
                            if (iVar3.g()) {
                                i10++;
                            }
                            iVar3.k(false);
                        }
                    }
                }
                if (z4) {
                    i10--;
                }
                iVar2.k(z4);
            } else {
                iVar2.k(false);
                i11++;
                i3 = 2;
                z = true;
            }
            i11++;
            i3 = 2;
            z = true;
        }
        return true;
    }

    @Override // e.b.e.i.m
    public void e(Context context, g gVar) {
        this.c = context;
        LayoutInflater.from(context);
        this.f764d = gVar;
        Resources resources = context.getResources();
        if (!this.n) {
            this.m = true;
        }
        int i2 = 2;
        this.o = context.getResources().getDisplayMetrics().widthPixels / 2;
        Configuration configuration = context.getResources().getConfiguration();
        int i3 = configuration.screenWidthDp;
        int i4 = configuration.screenHeightDp;
        if (configuration.smallestScreenWidthDp > 600 || i3 > 600 || ((i3 > 960 && i4 > 720) || (i3 > 720 && i4 > 960))) {
            i2 = 5;
        } else if (i3 >= 500 || ((i3 > 640 && i4 > 480) || (i3 > 480 && i4 > 640))) {
            i2 = 4;
        } else if (i3 >= 360) {
            i2 = 3;
        }
        this.q = i2;
        int i5 = this.o;
        if (this.m) {
            if (this.f865j == null) {
                d dVar = new d(this.b);
                this.f865j = dVar;
                if (this.f867l) {
                    dVar.setImageDrawable(this.f866k);
                    this.f866k = null;
                    this.f867l = false;
                }
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.f865j.measure(makeMeasureSpec, makeMeasureSpec);
            }
            i5 -= this.f865j.getMeasuredWidth();
        } else {
            this.f865j = null;
        }
        this.p = i5;
        this.s = (int) (resources.getDisplayMetrics().density * 56.0f);
    }

    @Override // e.b.e.i.m
    public boolean i(r rVar) {
        boolean z = false;
        if (!rVar.hasVisibleItems()) {
            return false;
        }
        r rVar2 = rVar;
        while (true) {
            g gVar = rVar2.z;
            if (gVar == this.f764d) {
                break;
            }
            rVar2 = (r) gVar;
        }
        i iVar = rVar2.A;
        ViewGroup viewGroup = (ViewGroup) this.f769i;
        View view = null;
        if (viewGroup != null) {
            int childCount = viewGroup.getChildCount();
            int i2 = 0;
            while (true) {
                if (i2 >= childCount) {
                    break;
                }
                View childAt = viewGroup.getChildAt(i2);
                if ((childAt instanceof n.a) && ((n.a) childAt).getItemData() == iVar) {
                    view = childAt;
                    break;
                }
                i2++;
            }
        }
        if (view == null) {
            return false;
        }
        int i3 = rVar.A.a;
        int size = rVar.size();
        int i4 = 0;
        while (true) {
            if (i4 >= size) {
                break;
            }
            MenuItem item = rVar.getItem(i4);
            if (item.isVisible() && item.getIcon() != null) {
                z = true;
                break;
            }
            i4++;
        }
        a aVar = new a(this.c, rVar, view);
        this.v = aVar;
        aVar.f816h = z;
        k kVar = aVar.f818j;
        if (kVar != null) {
            kVar.p(z);
        }
        if (this.v.f()) {
            m.a aVar2 = this.f766f;
            if (aVar2 != null) {
                aVar2.c(rVar);
            }
            return true;
        }
        throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
    }

    @Override // e.b.e.i.m
    public void j(boolean z) {
        n nVar;
        int i2;
        boolean z2;
        ViewGroup viewGroup = (ViewGroup) this.f769i;
        ArrayList<i> arrayList = null;
        boolean z3 = false;
        if (viewGroup != null) {
            g gVar = this.f764d;
            if (gVar != null) {
                gVar.i();
                ArrayList<i> l2 = this.f764d.l();
                int size = l2.size();
                i2 = 0;
                for (int i3 = 0; i3 < size; i3++) {
                    i iVar = l2.get(i3);
                    if (iVar.g()) {
                        View childAt = viewGroup.getChildAt(i2);
                        i itemData = childAt instanceof n.a ? ((n.a) childAt).getItemData() : null;
                        View c = c(iVar, childAt, viewGroup);
                        if (iVar != itemData) {
                            c.setPressed(false);
                            c.jumpDrawablesToCurrentState();
                        }
                        if (c != childAt) {
                            ViewGroup viewGroup2 = (ViewGroup) c.getParent();
                            if (viewGroup2 != null) {
                                viewGroup2.removeView(c);
                            }
                            ((ViewGroup) this.f769i).addView(c, i2);
                        }
                        i2++;
                    }
                }
            } else {
                i2 = 0;
            }
            while (i2 < viewGroup.getChildCount()) {
                if (viewGroup.getChildAt(i2) == this.f865j) {
                    z2 = false;
                } else {
                    viewGroup.removeViewAt(i2);
                    z2 = true;
                }
                if (!z2) {
                    i2++;
                }
            }
        }
        ((View) this.f769i).requestLayout();
        g gVar2 = this.f764d;
        if (gVar2 != null) {
            gVar2.i();
            ArrayList<i> arrayList2 = gVar2.f795i;
            int size2 = arrayList2.size();
            for (int i4 = 0; i4 < size2; i4++) {
                e.i.i.b bVar = arrayList2.get(i4).A;
            }
        }
        g gVar3 = this.f764d;
        if (gVar3 != null) {
            gVar3.i();
            arrayList = gVar3.f796j;
        }
        if (this.m && arrayList != null) {
            int size3 = arrayList.size();
            if (size3 == 1) {
                z3 = !arrayList.get(0).C;
            } else if (size3 > 0) {
                z3 = true;
            }
        }
        d dVar = this.f865j;
        if (z3) {
            if (dVar == null) {
                this.f865j = new d(this.b);
            }
            ViewGroup viewGroup3 = (ViewGroup) this.f865j.getParent();
            if (viewGroup3 != this.f769i) {
                if (viewGroup3 != null) {
                    viewGroup3.removeView(this.f865j);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.f769i;
                d dVar2 = this.f865j;
                ActionMenuView.c q2 = actionMenuView.h();
                q2.a = true;
                actionMenuView.addView(dVar2, q2);
            }
        } else if (dVar != null && dVar.getParent() == (nVar = this.f769i)) {
            ((ViewGroup) nVar).removeView(this.f865j);
        }
        ((ActionMenuView) this.f769i).setOverflowReserved(this.m);
    }

    public boolean k() {
        n nVar;
        RunnableC0020c cVar = this.w;
        if (cVar == null || (nVar = this.f769i) == null) {
            e eVar = this.u;
            if (eVar == null) {
                return false;
            }
            if (eVar.b()) {
                eVar.f818j.dismiss();
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
        aVar.f818j.dismiss();
        return true;
    }

    public boolean m() {
        e eVar = this.u;
        return eVar != null && eVar.b();
    }

    public boolean n() {
        g gVar;
        if (!this.m || m() || (gVar = this.f764d) == null || this.f769i == null || this.w != null) {
            return false;
        }
        gVar.i();
        if (gVar.f796j.isEmpty()) {
            return false;
        }
        RunnableC0020c cVar = new RunnableC0020c(new e(this.c, this.f764d, this.f865j, true));
        this.w = cVar;
        ((View) this.f769i).post(cVar);
        return true;
    }
}
