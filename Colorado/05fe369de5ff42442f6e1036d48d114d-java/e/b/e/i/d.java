package e.b.e.i;

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
import androidx.appcompat.R$dimen;
import androidx.appcompat.R$layout;
import e.b.e.i.m;
import e.b.f.f0;
import e.b.f.l0;
import e.b.f.m0;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public final class d extends k implements m, View.OnKeyListener, PopupWindow.OnDismissListener {
    public static final int C = R$layout.abc_cascading_menu_item_layout;
    public PopupWindow.OnDismissListener A;
    public boolean B;
    public final Context c;

    /* renamed from: d  reason: collision with root package name */
    public final int f760d;

    /* renamed from: e  reason: collision with root package name */
    public final int f761e;

    /* renamed from: f  reason: collision with root package name */
    public final int f762f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f763g;

    /* renamed from: h  reason: collision with root package name */
    public final Handler f764h;

    /* renamed from: i  reason: collision with root package name */
    public final List<g> f765i = new ArrayList();

    /* renamed from: j  reason: collision with root package name */
    public final List<C0017d> f766j = new ArrayList();

    /* renamed from: k  reason: collision with root package name */
    public final ViewTreeObserver.OnGlobalLayoutListener f767k = new a();

    /* renamed from: l  reason: collision with root package name */
    public final View.OnAttachStateChangeListener f768l = new b();
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
            if (d.this.c() && d.this.f766j.size() > 0 && !d.this.f766j.get(0).a.z) {
                View view = d.this.q;
                if (view == null || !view.isShown()) {
                    d.this.dismiss();
                    return;
                }
                for (C0017d dVar : d.this.f766j) {
                    dVar.a.a();
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
                dVar.z.removeGlobalOnLayoutListener(dVar.f767k);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    }

    public class c implements l0 {

        public class a implements Runnable {
            public final /* synthetic */ C0017d b;
            public final /* synthetic */ MenuItem c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ g f769d;

            public a(C0017d dVar, MenuItem menuItem, g gVar) {
                this.b = dVar;
                this.c = menuItem;
                this.f769d = gVar;
            }

            public void run() {
                C0017d dVar = this.b;
                if (dVar != null) {
                    d.this.B = true;
                    dVar.b.c(false);
                    d.this.B = false;
                }
                if (this.c.isEnabled() && this.c.hasSubMenu()) {
                    this.f769d.r(this.c, 4);
                }
            }
        }

        public c() {
        }

        @Override // e.b.f.l0
        public void f(g gVar, MenuItem menuItem) {
            C0017d dVar = null;
            d.this.f764h.removeCallbacksAndMessages(null);
            int size = d.this.f766j.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    i2 = -1;
                    break;
                } else if (gVar == d.this.f766j.get(i2).b) {
                    break;
                } else {
                    i2++;
                }
            }
            if (i2 != -1) {
                int i3 = i2 + 1;
                if (i3 < d.this.f766j.size()) {
                    dVar = d.this.f766j.get(i3);
                }
                d.this.f764h.postAtTime(new a(dVar, menuItem, gVar), gVar, SystemClock.uptimeMillis() + 200);
            }
        }

        @Override // e.b.f.l0
        public void h(g gVar, MenuItem menuItem) {
            d.this.f764h.removeCallbacksAndMessages(gVar);
        }
    }

    /* renamed from: e.b.e.i.d$d  reason: collision with other inner class name */
    public static class C0017d {
        public final m0 a;
        public final g b;
        public final int c;

        public C0017d(m0 m0Var, g gVar, int i2) {
            this.a = m0Var;
            this.b = gVar;
            this.c = i2;
        }
    }

    public d(Context context, View view, int i2, int i3, boolean z2) {
        int i4 = 0;
        this.n = 0;
        this.o = 0;
        this.c = context;
        this.p = view;
        this.f761e = i2;
        this.f762f = i3;
        this.f763g = z2;
        this.w = false;
        AtomicInteger atomicInteger = e.i.i.m.a;
        this.r = view.getLayoutDirection() != 1 ? 1 : i4;
        Resources resources = context.getResources();
        this.f760d = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R$dimen.abc_config_prefDialogWidth));
        this.f764h = new Handler();
    }

    @Override // e.b.e.i.p
    public void a() {
        if (!c()) {
            for (g gVar : this.f765i) {
                w(gVar);
            }
            this.f765i.clear();
            View view = this.p;
            this.q = view;
            if (view != null) {
                boolean z2 = this.z == null;
                ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
                this.z = viewTreeObserver;
                if (z2) {
                    viewTreeObserver.addOnGlobalLayoutListener(this.f767k);
                }
                this.q.addOnAttachStateChangeListener(this.f768l);
            }
        }
    }

    @Override // e.b.e.i.m
    public void b(g gVar, boolean z2) {
        int i2;
        int size = this.f766j.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                i3 = -1;
                break;
            } else if (gVar == this.f766j.get(i3).b) {
                break;
            } else {
                i3++;
            }
        }
        if (i3 >= 0) {
            int i4 = i3 + 1;
            if (i4 < this.f766j.size()) {
                this.f766j.get(i4).b.c(false);
            }
            C0017d remove = this.f766j.remove(i3);
            remove.b.u(this);
            if (this.B) {
                m0 m0Var = remove.a;
                Objects.requireNonNull(m0Var);
                if (Build.VERSION.SDK_INT >= 23) {
                    m0Var.A.setExitTransition(null);
                }
                remove.a.A.setAnimationStyle(0);
            }
            remove.a.dismiss();
            int size2 = this.f766j.size();
            if (size2 > 0) {
                i2 = this.f766j.get(size2 - 1).c;
            } else {
                View view = this.p;
                AtomicInteger atomicInteger = e.i.i.m.a;
                i2 = view.getLayoutDirection() == 1 ? 0 : 1;
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
                        this.z.removeGlobalOnLayoutListener(this.f767k);
                    }
                    this.z = null;
                }
                this.q.removeOnAttachStateChangeListener(this.f768l);
                this.A.onDismiss();
            } else if (z2) {
                this.f766j.get(0).b.c(false);
            }
        }
    }

    @Override // e.b.e.i.p
    public boolean c() {
        return this.f766j.size() > 0 && this.f766j.get(0).a.c();
    }

    @Override // e.b.e.i.m
    public boolean d() {
        return false;
    }

    @Override // e.b.e.i.p
    public void dismiss() {
        int size = this.f766j.size();
        if (size > 0) {
            C0017d[] dVarArr = (C0017d[]) this.f766j.toArray(new C0017d[size]);
            for (int i2 = size - 1; i2 >= 0; i2--) {
                C0017d dVar = dVarArr[i2];
                if (dVar.a.c()) {
                    dVar.a.dismiss();
                }
            }
        }
    }

    @Override // e.b.e.i.m
    public void h(m.a aVar) {
        this.y = aVar;
    }

    @Override // e.b.e.i.m
    public boolean i(r rVar) {
        for (C0017d dVar : this.f766j) {
            if (rVar == dVar.b) {
                dVar.a.f902d.requestFocus();
                return true;
            }
        }
        if (!rVar.hasVisibleItems()) {
            return false;
        }
        rVar.b(this, this.c);
        if (c()) {
            w(rVar);
        } else {
            this.f765i.add(rVar);
        }
        m.a aVar = this.y;
        if (aVar != null) {
            aVar.c(rVar);
        }
        return true;
    }

    @Override // e.b.e.i.m
    public void j(boolean z2) {
        for (C0017d dVar : this.f766j) {
            ListAdapter adapter = dVar.a.f902d.getAdapter();
            if (adapter instanceof HeaderViewListAdapter) {
                adapter = ((HeaderViewListAdapter) adapter).getWrappedAdapter();
            }
            ((f) adapter).notifyDataSetChanged();
        }
    }

    @Override // e.b.e.i.p
    public ListView k() {
        if (this.f766j.isEmpty()) {
            return null;
        }
        List<C0017d> list = this.f766j;
        return list.get(list.size() - 1).a.f902d;
    }

    @Override // e.b.e.i.k
    public void l(g gVar) {
        gVar.b(this, this.c);
        if (c()) {
            w(gVar);
        } else {
            this.f765i.add(gVar);
        }
    }

    @Override // e.b.e.i.k
    public boolean m() {
        return false;
    }

    @Override // e.b.e.i.k
    public void o(View view) {
        if (this.p != view) {
            this.p = view;
            int i2 = this.n;
            AtomicInteger atomicInteger = e.i.i.m.a;
            this.o = Gravity.getAbsoluteGravity(i2, view.getLayoutDirection());
        }
    }

    public void onDismiss() {
        C0017d dVar;
        int size = this.f766j.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                dVar = null;
                break;
            }
            dVar = this.f766j.get(i2);
            if (!dVar.a.c()) {
                break;
            }
            i2++;
        }
        if (dVar != null) {
            dVar.b.c(false);
        }
    }

    public boolean onKey(View view, int i2, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i2 != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    @Override // e.b.e.i.k
    public void p(boolean z2) {
        this.w = z2;
    }

    @Override // e.b.e.i.k
    public void q(int i2) {
        if (this.n != i2) {
            this.n = i2;
            View view = this.p;
            AtomicInteger atomicInteger = e.i.i.m.a;
            this.o = Gravity.getAbsoluteGravity(i2, view.getLayoutDirection());
        }
    }

    @Override // e.b.e.i.k
    public void r(int i2) {
        this.s = true;
        this.u = i2;
    }

    @Override // e.b.e.i.k
    public void s(PopupWindow.OnDismissListener onDismissListener) {
        this.A = onDismissListener;
    }

    @Override // e.b.e.i.k
    public void t(boolean z2) {
        this.x = z2;
    }

    @Override // e.b.e.i.k
    public void u(int i2) {
        this.t = true;
        this.v = i2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0141, code lost:
        if (((r10.getWidth() + r12[0]) + r4) > r11.right) goto L_0x014b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0147, code lost:
        if ((r12[0] - r4) < 0) goto L_0x0149;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x014b, code lost:
        r10 = 0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00e9  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x01ae  */
    public final void w(g gVar) {
        C0017d dVar;
        int i2;
        int i3;
        int i4;
        MenuItem menuItem;
        int i5;
        f fVar;
        int firstVisiblePosition;
        LayoutInflater from = LayoutInflater.from(this.c);
        f fVar2 = new f(gVar, from, this.f763g, C);
        if (!c() && this.w) {
            fVar2.f776d = true;
        } else if (c()) {
            fVar2.f776d = k.v(gVar);
        }
        View view = null;
        int n2 = k.n(fVar2, null, this.c, this.f760d);
        m0 m0Var = new m0(this.c, null, this.f761e, this.f762f);
        m0Var.E = this.m;
        m0Var.r = this;
        m0Var.A.setOnDismissListener(this);
        m0Var.q = this.p;
        m0Var.m = this.o;
        m0Var.s(true);
        m0Var.A.setInputMethodMode(2);
        m0Var.o(fVar2);
        m0Var.r(n2);
        m0Var.m = this.o;
        if (this.f766j.size() > 0) {
            List<C0017d> list = this.f766j;
            dVar = list.get(list.size() - 1);
            g gVar2 = dVar.b;
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
                f0 f0Var = dVar.a.f902d;
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
                    Method method = m0.F;
                    if (method != null) {
                        try {
                            method.invoke(m0Var.A, Boolean.FALSE);
                        } catch (Exception unused) {
                        }
                    }
                } else {
                    m0Var.A.setTouchModal(false);
                }
                int i8 = Build.VERSION.SDK_INT;
                if (i8 >= 23) {
                    m0Var.A.setEnterTransition(null);
                }
                List<C0017d> list2 = this.f766j;
                f0 f0Var2 = list2.get(list2.size() - 1).a.f902d;
                int[] iArr = new int[2];
                f0Var2.getLocationOnScreen(iArr);
                Rect rect = new Rect();
                this.q.getWindowVisibleDisplayFrame(rect);
                if (this.r == 1) {
                }
                int i9 = 1;
                boolean z2 = i9 == 1;
                this.r = i9;
                if (i8 >= 26) {
                    m0Var.q = view;
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
                    m0Var.f905g = i4;
                    m0Var.f910l = true;
                    m0Var.f909k = true;
                    m0Var.n(i3);
                } else if (!z2) {
                    n2 = view.getWidth();
                    i4 = i2 - n2;
                    m0Var.f905g = i4;
                    m0Var.f910l = true;
                    m0Var.f909k = true;
                    m0Var.n(i3);
                }
                i4 = i2 + n2;
                m0Var.f905g = i4;
                m0Var.f910l = true;
                m0Var.f909k = true;
                m0Var.n(i3);
            } else {
                if (this.s) {
                    m0Var.f905g = this.u;
                }
                if (this.t) {
                    m0Var.n(this.v);
                }
                Rect rect2 = this.b;
                m0Var.y = rect2 != null ? new Rect(rect2) : null;
            }
            this.f766j.add(new C0017d(m0Var, gVar, this.r));
            m0Var.a();
            f0 f0Var3 = m0Var.f902d;
            f0Var3.setOnKeyListener(this);
            if (dVar == null && this.x && gVar.m != null) {
                FrameLayout frameLayout = (FrameLayout) from.inflate(R$layout.abc_popup_menu_header_item_layout, (ViewGroup) f0Var3, false);
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
        this.f766j.add(new C0017d(m0Var, gVar, this.r));
        m0Var.a();
        f0 f0Var32 = m0Var.f902d;
        f0Var32.setOnKeyListener(this);
        if (dVar == null) {
        }
    }
}
