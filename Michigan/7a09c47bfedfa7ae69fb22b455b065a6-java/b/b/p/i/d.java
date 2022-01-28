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
    public final Context f693c;

    /* renamed from: d  reason: collision with root package name */
    public final int f694d;

    /* renamed from: e  reason: collision with root package name */
    public final int f695e;

    /* renamed from: f  reason: collision with root package name */
    public final int f696f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f697g;
    public final Handler h;
    public final List<g> i = new ArrayList();
    public final List<C0013d> j = new ArrayList();
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
            if (d.this.c() && d.this.j.size() > 0 && !d.this.j.get(0).f705a.B) {
                View view = d.this.q;
                if (view == null || !view.isShown()) {
                    d.this.dismiss();
                    return;
                }
                for (C0013d dVar : d.this.j) {
                    dVar.f705a.a();
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
            public final /* synthetic */ C0013d f701b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ MenuItem f702c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ g f703d;

            public a(C0013d dVar, MenuItem menuItem, g gVar) {
                this.f701b = dVar;
                this.f702c = menuItem;
                this.f703d = gVar;
            }

            public void run() {
                C0013d dVar = this.f701b;
                if (dVar != null) {
                    d.this.B = true;
                    dVar.f706b.c(false);
                    d.this.B = false;
                }
                if (this.f702c.isEnabled() && this.f702c.hasSubMenu()) {
                    this.f703d.r(this.f702c, 4);
                }
            }
        }

        public c() {
        }

        @Override // b.b.q.l0
        public void f(g gVar, MenuItem menuItem) {
            C0013d dVar = null;
            d.this.h.removeCallbacksAndMessages(null);
            int size = d.this.j.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    i = -1;
                    break;
                } else if (gVar == d.this.j.get(i).f706b) {
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
    public static class C0013d {

        /* renamed from: a  reason: collision with root package name */
        public final m0 f705a;

        /* renamed from: b  reason: collision with root package name */
        public final g f706b;

        /* renamed from: c  reason: collision with root package name */
        public final int f707c;

        public C0013d(m0 m0Var, g gVar, int i) {
            this.f705a = m0Var;
            this.f706b = gVar;
            this.f707c = i;
        }
    }

    public d(Context context, View view, int i2, int i3, boolean z2) {
        int i4 = 0;
        this.n = 0;
        this.o = 0;
        this.f693c = context;
        this.p = view;
        this.f695e = i2;
        this.f696f = i3;
        this.f697g = z2;
        this.w = false;
        this.r = b.i.l.m.p(view) != 1 ? 1 : i4;
        Resources resources = context.getResources();
        this.f694d = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(b.b.d.abc_config_prefDialogWidth));
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
            } else if (gVar == this.j.get(i3).f706b) {
                break;
            } else {
                i3++;
            }
        }
        if (i3 >= 0) {
            int i4 = i3 + 1;
            if (i4 < this.j.size()) {
                this.j.get(i4).f706b.c(false);
            }
            C0013d remove = this.j.remove(i3);
            remove.f706b.u(this);
            if (this.B) {
                remove.f705a.C.setExitTransition(null);
                remove.f705a.C.setAnimationStyle(0);
            }
            remove.f705a.dismiss();
            int size2 = this.j.size();
            if (size2 > 0) {
                i2 = this.j.get(size2 - 1).f707c;
            } else {
                i2 = b.i.l.m.p(this.p) == 1 ? 0 : 1;
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
                this.j.get(0).f706b.c(false);
            }
        }
    }

    @Override // b.b.p.i.p
    public boolean c() {
        return this.j.size() > 0 && this.j.get(0).f705a.c();
    }

    @Override // b.b.p.i.m
    public boolean d() {
        return false;
    }

    @Override // b.b.p.i.p
    public void dismiss() {
        int size = this.j.size();
        if (size > 0) {
            C0013d[] dVarArr = (C0013d[]) this.j.toArray(new C0013d[size]);
            for (int i2 = size - 1; i2 >= 0; i2--) {
                C0013d dVar = dVarArr[i2];
                if (dVar.f705a.c()) {
                    dVar.f705a.dismiss();
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
        for (C0013d dVar : this.j) {
            if (rVar == dVar.f706b) {
                dVar.f705a.f879d.requestFocus();
                return true;
            }
        }
        if (!rVar.hasVisibleItems()) {
            return false;
        }
        rVar.b(this, this.f693c);
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
        for (C0013d dVar : this.j) {
            ListAdapter adapter = dVar.f705a.f879d.getAdapter();
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
        List<C0013d> list = this.j;
        return list.get(list.size() - 1).f705a.f879d;
    }

    @Override // b.b.p.i.k
    public void l(g gVar) {
        gVar.b(this, this.f693c);
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
            this.o = Gravity.getAbsoluteGravity(this.n, b.i.l.m.p(view));
        }
    }

    public void onDismiss() {
        C0013d dVar;
        int size = this.j.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                dVar = null;
                break;
            }
            dVar = this.j.get(i2);
            if (!dVar.f705a.c()) {
                break;
            }
            i2++;
        }
        if (dVar != null) {
            dVar.f706b.c(false);
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
            this.o = Gravity.getAbsoluteGravity(i2, b.i.l.m.p(this.p));
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
        C0013d dVar;
        int i2;
        int i3;
        int i4;
        MenuItem menuItem;
        int i5;
        f fVar;
        int firstVisiblePosition;
        LayoutInflater from = LayoutInflater.from(this.f693c);
        f fVar2 = new f(gVar, from, this.f697g, C);
        if (!c() && this.w) {
            fVar2.f718d = true;
        } else if (c()) {
            fVar2.f718d = k.v(gVar);
        }
        View view = null;
        int n2 = k.n(fVar2, null, this.f693c, this.f694d);
        m0 m0Var = new m0(this.f693c, null, this.f695e, this.f696f);
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
            List<C0013d> list = this.j;
            dVar = list.get(list.size() - 1);
            g gVar2 = dVar.f706b;
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
                f0 f0Var = dVar.f705a.f879d;
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
                List<C0013d> list2 = this.j;
                f0 f0Var2 = list2.get(list2.size() - 1).f705a.f879d;
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
                    m0Var.f882g = i4;
                    m0Var.l = true;
                    m0Var.k = true;
                    m0Var.n(i3);
                } else if (!z2) {
                    n2 = view.getWidth();
                    i4 = i2 - n2;
                    m0Var.f882g = i4;
                    m0Var.l = true;
                    m0Var.k = true;
                    m0Var.n(i3);
                }
                i4 = i2 + n2;
                m0Var.f882g = i4;
                m0Var.l = true;
                m0Var.k = true;
                m0Var.n(i3);
            } else {
                if (this.s) {
                    m0Var.f882g = this.u;
                }
                if (this.t) {
                    m0Var.n(this.v);
                }
                Rect rect2 = this.f750b;
                m0Var.A = rect2 != null ? new Rect(rect2) : null;
            }
            this.j.add(new C0013d(m0Var, gVar, this.r));
            m0Var.a();
            f0 f0Var3 = m0Var.f879d;
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
        this.j.add(new C0013d(m0Var, gVar, this.r));
        m0Var.a();
        f0 f0Var32 = m0Var.f879d;
        f0Var32.setOnKeyListener(this);
        if (dVar == null) {
        }
    }
}
