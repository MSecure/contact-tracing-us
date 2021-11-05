package b.b.p.i;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.SystemClock;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import b.b.g;
import b.b.p.i.m;
import b.b.q.f0;
import b.b.q.l0;
import b.b.q.m0;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public final class d extends k implements m, View.OnKeyListener, PopupWindow.OnDismissListener {
    public static final int C = g.abc_cascading_menu_item_layout;
    public PopupWindow.OnDismissListener A;
    public boolean B;

    /* renamed from: c  reason: collision with root package name */
    public final Context f517c;

    /* renamed from: d  reason: collision with root package name */
    public final int f518d;

    /* renamed from: e  reason: collision with root package name */
    public final int f519e;
    public final int f;
    public final boolean g;
    public final Handler h;
    public final List<g> i = new ArrayList();
    public final List<C0010d> j = new ArrayList();
    public final ViewTreeObserver.OnGlobalLayoutListener k = new a();
    public final View.OnAttachStateChangeListener l = new b();
    public final l0 m = new c();
    public int n;
    public int o;
    public View p;
    public View q;
    public int r;
    public boolean s;
    public boolean t;
    public int u;
    public int v;
    public boolean w;
    public boolean x;
    public m.a y;
    public ViewTreeObserver z;

    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public a() {
        }

        public void onGlobalLayout() {
            if (d.this.c() && d.this.j.size() > 0 && !d.this.j.get(0).f527a.B) {
                View view = d.this.q;
                if (view == null || !view.isShown()) {
                    d.this.dismiss();
                    return;
                }
                for (C0010d dVar : d.this.j) {
                    dVar.f527a.a();
                }
            }
        }
    }

    public class b implements View.OnAttachStateChangeListener {
        public b() {
        }

        public void onViewAttachedToWindow(View view) {
        }

        public void onViewDetachedFromWindow(View view) {
            ViewTreeObserver viewTreeObserver = d.this.z;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    d.this.z = view.getViewTreeObserver();
                }
                d dVar = d.this;
                dVar.z.removeGlobalOnLayoutListener(dVar.k);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    }

    public class c implements l0 {

        public class a implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ C0010d f523b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ MenuItem f524c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ g f525d;

            public a(C0010d dVar, MenuItem menuItem, g gVar) {
                this.f523b = dVar;
                this.f524c = menuItem;
                this.f525d = gVar;
            }

            public void run() {
                C0010d dVar = this.f523b;
                if (dVar != null) {
                    d.this.B = true;
                    dVar.f528b.c(false);
                    d.this.B = false;
                }
                if (this.f524c.isEnabled() && this.f524c.hasSubMenu()) {
                    this.f525d.r(this.f524c, 4);
                }
            }
        }

        public c() {
        }

        @Override // b.b.q.l0
        public void f(g gVar, MenuItem menuItem) {
            C0010d dVar = null;
            d.this.h.removeCallbacksAndMessages(null);
            int size = d.this.j.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    i = -1;
                    break;
                } else if (gVar == d.this.j.get(i).f528b) {
                    break;
                } else {
                    i++;
                }
            }
            if (i != -1) {
                int i2 = i + 1;
                if (i2 < d.this.j.size()) {
                    dVar = d.this.j.get(i2);
                }
                d.this.h.postAtTime(new a(dVar, menuItem, gVar), gVar, SystemClock.uptimeMillis() + 200);
            }
        }

        @Override // b.b.q.l0
        public void h(g gVar, MenuItem menuItem) {
            d.this.h.removeCallbacksAndMessages(gVar);
        }
    }

    /* renamed from: b.b.p.i.d$d  reason: collision with other inner class name */
    public static class C0010d {

        /* renamed from: a  reason: collision with root package name */
        public final m0 f527a;

        /* renamed from: b  reason: collision with root package name */
        public final g f528b;

        /* renamed from: c  reason: collision with root package name */
        public final int f529c;

        public C0010d(m0 m0Var, g gVar, int i) {
            this.f527a = m0Var;
            this.f528b = gVar;
            this.f529c = i;
        }
    }

    public d(Context context, View view, int i2, int i3, boolean z2) {
        int i4 = 0;
        this.n = 0;
        this.o = 0;
        this.f517c = context;
        this.p = view;
        this.f519e = i2;
        this.f = i3;
        this.g = z2;
        this.w = false;
        this.r = b.i.l.m.o(view) != 1 ? 1 : i4;
        Resources resources = context.getResources();
        this.f518d = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(b.b.d.abc_config_prefDialogWidth));
        this.h = new Handler();
    }

    @Override // b.b.p.i.p
    public void a() {
        if (!c()) {
            for (g gVar : this.i) {
                w(gVar);
            }
            this.i.clear();
            View view = this.p;
            this.q = view;
            if (view != null) {
                boolean z2 = this.z == null;
                ViewTreeObserver viewTreeObserver = this.q.getViewTreeObserver();
                this.z = viewTreeObserver;
                if (z2) {
                    viewTreeObserver.addOnGlobalLayoutListener(this.k);
                }
                this.q.addOnAttachStateChangeListener(this.l);
            }
        }
    }

    @Override // b.b.p.i.m
    public void b(g gVar, boolean z2) {
        int i2;
        int size = this.j.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                i3 = -1;
                break;
            } else if (gVar == this.j.get(i3).f528b) {
                break;
            } else {
                i3++;
            }
        }
        if (i3 >= 0) {
            int i4 = i3 + 1;
            if (i4 < this.j.size()) {
                this.j.get(i4).f528b.c(false);
            }
            C0010d remove = this.j.remove(i3);
            remove.f528b.u(this);
            if (this.B) {
                remove.f527a.C.setExitTransition(null);
                remove.f527a.C.setAnimationStyle(0);
            }
            remove.f527a.dismiss();
            int size2 = this.j.size();
            if (size2 > 0) {
                i2 = this.j.get(size2 - 1).f529c;
            } else {
                i2 = b.i.l.m.o(this.p) == 1 ? 0 : 1;
            }
            this.r = i2;
            if (size2 == 0) {
                dismiss();
                m.a aVar = this.y;
                if (aVar != null) {
                    aVar.b(gVar, true);
                }
                ViewTreeObserver viewTreeObserver = this.z;
                if (viewTreeObserver != null) {
                    if (viewTreeObserver.isAlive()) {
                        this.z.removeGlobalOnLayoutListener(this.k);
                    }
                    this.z = null;
                }
                this.q.removeOnAttachStateChangeListener(this.l);
                this.A.onDismiss();
            } else if (z2) {
                this.j.get(0).f528b.c(false);
            }
        }
    }

    @Override // b.b.p.i.p
    public boolean c() {
        return this.j.size() > 0 && this.j.get(0).f527a.c();
    }

    @Override // b.b.p.i.m
    public boolean d() {
        return false;
    }

    @Override // b.b.p.i.p
    public void dismiss() {
        int size = this.j.size();
        if (size > 0) {
            C0010d[] dVarArr = (C0010d[]) this.j.toArray(new C0010d[size]);
            for (int i2 = size - 1; i2 >= 0; i2--) {
                C0010d dVar = dVarArr[i2];
                if (dVar.f527a.c()) {
                    dVar.f527a.dismiss();
                }
            }
        }
    }

    @Override // b.b.p.i.m
    public void h(m.a aVar) {
        this.y = aVar;
    }

    @Override // b.b.p.i.m
    public boolean i(r rVar) {
        for (C0010d dVar : this.j) {
            if (rVar == dVar.f528b) {
                dVar.f527a.f670d.requestFocus();
                return true;
            }
        }
        if (!rVar.hasVisibleItems()) {
            return false;
        }
        rVar.b(this, this.f517c);
        if (c()) {
            w(rVar);
        } else {
            this.i.add(rVar);
        }
        m.a aVar = this.y;
        if (aVar != null) {
            aVar.c(rVar);
        }
        return true;
    }

    @Override // b.b.p.i.m
    public void j(boolean z2) {
        for (C0010d dVar : this.j) {
            ListAdapter adapter = dVar.f527a.f670d.getAdapter();
            if (adapter instanceof HeaderViewListAdapter) {
                adapter = ((HeaderViewListAdapter) adapter).getWrappedAdapter();
            }
            ((f) adapter).notifyDataSetChanged();
        }
    }

    @Override // b.b.p.i.p
    public ListView k() {
        if (this.j.isEmpty()) {
            return null;
        }
        List<C0010d> list = this.j;
        return list.get(list.size() - 1).f527a.f670d;
    }

    @Override // b.b.p.i.k
    public void l(g gVar) {
        gVar.b(this, this.f517c);
        if (c()) {
            w(gVar);
        } else {
            this.i.add(gVar);
        }
    }

    @Override // b.b.p.i.k
    public boolean m() {
        return false;
    }

    @Override // b.b.p.i.k
    public void o(View view) {
        if (this.p != view) {
            this.p = view;
            this.o = Gravity.getAbsoluteGravity(this.n, b.i.l.m.o(view));
        }
    }

    public void onDismiss() {
        C0010d dVar;
        int size = this.j.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                dVar = null;
                break;
            }
            dVar = this.j.get(i2);
            if (!dVar.f527a.c()) {
                break;
            }
            i2++;
        }
        if (dVar != null) {
            dVar.f528b.c(false);
        }
    }

    public boolean onKey(View view, int i2, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i2 != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    @Override // b.b.p.i.k
    public void p(boolean z2) {
        this.w = z2;
    }

    @Override // b.b.p.i.k
    public void q(int i2) {
        if (this.n != i2) {
            this.n = i2;
            this.o = Gravity.getAbsoluteGravity(i2, b.i.l.m.o(this.p));
        }
    }

    @Override // b.b.p.i.k
    public void r(int i2) {
        this.s = true;
        this.u = i2;
    }

    @Override // b.b.p.i.k
    public void s(PopupWindow.OnDismissListener onDismissListener) {
        this.A = onDismissListener;
    }

    @Override // b.b.p.i.k
    public void t(boolean z2) {
        this.x = z2;
    }

    @Override // b.b.p.i.k
    public void u(int i2) {
        this.t = true;
        this.v = i2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0139, code lost:
        if (((r9.getWidth() + r11[0]) + r4) > r10.right) goto L_0x0143;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x013f, code lost:
        if ((r11[0] - r4) < 0) goto L_0x0141;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0143, code lost:
        r9 = 0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00e9  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x01a8  */
    public final void w(g gVar) {
        C0010d dVar;
        int i2;
        int i3;
        int i4;
        MenuItem menuItem;
        int i5;
        f fVar;
        int firstVisiblePosition;
        LayoutInflater from = LayoutInflater.from(this.f517c);
        f fVar2 = new f(gVar, from, this.g, C);
        if (!c() && this.w) {
            fVar2.f538d = true;
        } else if (c()) {
            fVar2.f538d = k.v(gVar);
        }
        View view = null;
        int n2 = k.n(fVar2, null, this.f517c, this.f518d);
        m0 m0Var = new m0(this.f517c, null, this.f519e, this.f);
        m0Var.G = this.m;
        m0Var.t = this;
        m0Var.C.setOnDismissListener(this);
        m0Var.s = this.p;
        m0Var.m = this.o;
        m0Var.s(true);
        m0Var.C.setInputMethodMode(2);
        m0Var.o(fVar2);
        m0Var.r(n2);
        m0Var.m = this.o;
        if (this.j.size() > 0) {
            List<C0010d> list = this.j;
            dVar = list.get(list.size() - 1);
            g gVar2 = dVar.f528b;
            int size = gVar2.size();
            int i6 = 0;
            while (true) {
                if (i6 >= size) {
                    menuItem = null;
                    break;
                }
                menuItem = gVar2.getItem(i6);
                if (menuItem.hasSubMenu() && gVar == menuItem.getSubMenu()) {
                    break;
                }
                i6++;
            }
            if (menuItem != null) {
                f0 f0Var = dVar.f527a.f670d;
                ListAdapter adapter = f0Var.getAdapter();
                if (adapter instanceof HeaderViewListAdapter) {
                    HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
                    i5 = headerViewListAdapter.getHeadersCount();
                    fVar = (f) headerViewListAdapter.getWrappedAdapter();
                } else {
                    fVar = (f) adapter;
                    i5 = 0;
                }
                int count = fVar.getCount();
                int i7 = 0;
                while (true) {
                    if (i7 >= count) {
                        i7 = -1;
                        break;
                    } else if (menuItem == fVar.getItem(i7)) {
                        break;
                    } else {
                        i7++;
                    }
                }
                if (i7 != -1 && (firstVisiblePosition = (i7 + i5) - f0Var.getFirstVisiblePosition()) >= 0 && firstVisiblePosition < f0Var.getChildCount()) {
                    view = f0Var.getChildAt(firstVisiblePosition);
                }
            }
            if (view == null) {
                if (Build.VERSION.SDK_INT <= 28) {
                    Method method = m0.H;
                    if (method != null) {
                        try {
                            method.invoke(m0Var.C, Boolean.FALSE);
                        } catch (Exception unused) {
                        }
                    }
                } else {
                    m0Var.C.setTouchModal(false);
                }
                m0Var.C.setEnterTransition(null);
                List<C0010d> list2 = this.j;
                f0 f0Var2 = list2.get(list2.size() - 1).f527a.f670d;
                int[] iArr = new int[2];
                f0Var2.getLocationOnScreen(iArr);
                Rect rect = new Rect();
                this.q.getWindowVisibleDisplayFrame(rect);
                if (this.r == 1) {
                }
                int i8 = 1;
                boolean z2 = i8 == 1;
                this.r = i8;
                if (Build.VERSION.SDK_INT >= 26) {
                    m0Var.s = view;
                    i3 = 0;
                    i2 = 0;
                } else {
                    int[] iArr2 = new int[2];
                    this.p.getLocationOnScreen(iArr2);
                    int[] iArr3 = new int[2];
                    view.getLocationOnScreen(iArr3);
                    if ((this.o & 7) == 5) {
                        iArr2[0] = this.p.getWidth() + iArr2[0];
                        iArr3[0] = view.getWidth() + iArr3[0];
                    }
                    i2 = iArr3[0] - iArr2[0];
                    i3 = iArr3[1] - iArr2[1];
                }
                if ((this.o & 5) != 5) {
                    if (z2) {
                        n2 = view.getWidth();
                    }
                    i4 = i2 - n2;
                    m0Var.g = i4;
                    m0Var.l = true;
                    m0Var.k = true;
                    m0Var.n(i3);
                } else if (!z2) {
                    n2 = view.getWidth();
                    i4 = i2 - n2;
                    m0Var.g = i4;
                    m0Var.l = true;
                    m0Var.k = true;
                    m0Var.n(i3);
                }
                i4 = i2 + n2;
                m0Var.g = i4;
                m0Var.l = true;
                m0Var.k = true;
                m0Var.n(i3);
            } else {
                if (this.s) {
                    m0Var.g = this.u;
                }
                if (this.t) {
                    m0Var.n(this.v);
                }
                Rect rect2 = this.f564b;
                m0Var.A = rect2 != null ? new Rect(rect2) : null;
            }
            this.j.add(new C0010d(m0Var, gVar, this.r));
            m0Var.a();
            f0 f0Var3 = m0Var.f670d;
            f0Var3.setOnKeyListener(this);
            if (dVar == null && this.x && gVar.m != null) {
                FrameLayout frameLayout = (FrameLayout) from.inflate(g.abc_popup_menu_header_item_layout, (ViewGroup) f0Var3, false);
                frameLayout.setEnabled(false);
                ((TextView) frameLayout.findViewById(16908310)).setText(gVar.m);
                f0Var3.addHeaderView(frameLayout, null, false);
                m0Var.a();
                return;
            }
            return;
        }
        dVar = null;
        view = null;
        if (view == null) {
        }
        this.j.add(new C0010d(m0Var, gVar, this.r));
        m0Var.a();
        f0 f0Var32 = m0Var.f670d;
        f0Var32.setOnKeyListener(this);
        if (dVar == null) {
        }
    }
}
