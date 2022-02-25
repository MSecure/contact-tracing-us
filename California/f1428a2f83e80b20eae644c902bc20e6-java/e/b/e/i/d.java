package e.b.e.i;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
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
import e.i.i.l;
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
    public final int f767d;

    /* renamed from: e  reason: collision with root package name */
    public final int f768e;

    /* renamed from: f  reason: collision with root package name */
    public final int f769f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f770g;

    /* renamed from: h  reason: collision with root package name */
    public final Handler f771h;

    /* renamed from: i  reason: collision with root package name */
    public final List<g> f772i = new ArrayList();

    /* renamed from: j  reason: collision with root package name */
    public final List<C0015d> f773j = new ArrayList();

    /* renamed from: k  reason: collision with root package name */
    public final ViewTreeObserver.OnGlobalLayoutListener f774k = new a();

    /* renamed from: l  reason: collision with root package name */
    public final View.OnAttachStateChangeListener f775l = new b();
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
            if (d.this.c() && d.this.f773j.size() > 0 && !d.this.f773j.get(0).a.z) {
                View view = d.this.q;
                if (view == null || !view.isShown()) {
                    d.this.dismiss();
                    return;
                }
                for (C0015d dVar : d.this.f773j) {
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
                dVar.z.removeGlobalOnLayoutListener(dVar.f774k);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    }

    public class c implements l0 {

        public class a implements Runnable {
            public final /* synthetic */ C0015d b;
            public final /* synthetic */ MenuItem c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ g f776d;

            public a(C0015d dVar, MenuItem menuItem, g gVar) {
                this.b = dVar;
                this.c = menuItem;
                this.f776d = gVar;
            }

            public void run() {
                C0015d dVar = this.b;
                if (dVar != null) {
                    d.this.B = true;
                    dVar.b.c(false);
                    d.this.B = false;
                }
                if (this.c.isEnabled() && this.c.hasSubMenu()) {
                    this.f776d.r(this.c, 4);
                }
            }
        }

        public c() {
        }

        @Override // e.b.f.l0
        public void f(g gVar, MenuItem menuItem) {
            C0015d dVar = null;
            d.this.f771h.removeCallbacksAndMessages(null);
            int size = d.this.f773j.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    i2 = -1;
                    break;
                } else if (gVar == d.this.f773j.get(i2).b) {
                    break;
                } else {
                    i2++;
                }
            }
            if (i2 != -1) {
                int i3 = i2 + 1;
                if (i3 < d.this.f773j.size()) {
                    dVar = d.this.f773j.get(i3);
                }
                d.this.f771h.postAtTime(new a(dVar, menuItem, gVar), gVar, SystemClock.uptimeMillis() + 200);
            }
        }

        @Override // e.b.f.l0
        public void h(g gVar, MenuItem menuItem) {
            d.this.f771h.removeCallbacksAndMessages(gVar);
        }
    }

    /* renamed from: e.b.e.i.d$d  reason: collision with other inner class name */
    public static class C0015d {
        public final m0 a;
        public final g b;
        public final int c;

        public C0015d(m0 m0Var, g gVar, int i2) {
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
        this.f768e = i2;
        this.f769f = i3;
        this.f770g = z2;
        this.w = false;
        AtomicInteger atomicInteger = l.a;
        this.r = view.getLayoutDirection() != 1 ? 1 : i4;
        Resources resources = context.getResources();
        this.f767d = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R$dimen.abc_config_prefDialogWidth));
        this.f771h = new Handler();
    }

    @Override // e.b.e.i.p
    public void a() {
        if (!c()) {
            for (g gVar : this.f772i) {
                w(gVar);
            }
            this.f772i.clear();
            View view = this.p;
            this.q = view;
            if (view != null) {
                boolean z2 = this.z == null;
                ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
                this.z = viewTreeObserver;
                if (z2) {
                    viewTreeObserver.addOnGlobalLayoutListener(this.f774k);
                }
                this.q.addOnAttachStateChangeListener(this.f775l);
            }
        }
    }

    @Override // e.b.e.i.m
    public void b(g gVar, boolean z2) {
        int i2;
        int size = this.f773j.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                i3 = -1;
                break;
            } else if (gVar == this.f773j.get(i3).b) {
                break;
            } else {
                i3++;
            }
        }
        if (i3 >= 0) {
            int i4 = i3 + 1;
            if (i4 < this.f773j.size()) {
                this.f773j.get(i4).b.c(false);
            }
            C0015d remove = this.f773j.remove(i3);
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
            int size2 = this.f773j.size();
            if (size2 > 0) {
                i2 = this.f773j.get(size2 - 1).c;
            } else {
                View view = this.p;
                AtomicInteger atomicInteger = l.a;
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
                        this.z.removeGlobalOnLayoutListener(this.f774k);
                    }
                    this.z = null;
                }
                this.q.removeOnAttachStateChangeListener(this.f775l);
                this.A.onDismiss();
            } else if (z2) {
                this.f773j.get(0).b.c(false);
            }
        }
    }

    @Override // e.b.e.i.p
    public boolean c() {
        return this.f773j.size() > 0 && this.f773j.get(0).a.c();
    }

    @Override // e.b.e.i.m
    public boolean d() {
        return false;
    }

    @Override // e.b.e.i.p
    public void dismiss() {
        int size = this.f773j.size();
        if (size > 0) {
            C0015d[] dVarArr = (C0015d[]) this.f773j.toArray(new C0015d[size]);
            for (int i2 = size - 1; i2 >= 0; i2--) {
                C0015d dVar = dVarArr[i2];
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
        for (C0015d dVar : this.f773j) {
            if (rVar == dVar.b) {
                dVar.a.f909d.requestFocus();
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
            this.f772i.add(rVar);
        }
        m.a aVar = this.y;
        if (aVar != null) {
            aVar.c(rVar);
        }
        return true;
    }

    @Override // e.b.e.i.m
    public void j(boolean z2) {
        for (C0015d dVar : this.f773j) {
            ListAdapter adapter = dVar.a.f909d.getAdapter();
            if (adapter instanceof HeaderViewListAdapter) {
                adapter = ((HeaderViewListAdapter) adapter).getWrappedAdapter();
            }
            ((f) adapter).notifyDataSetChanged();
        }
    }

    @Override // e.b.e.i.p
    public ListView k() {
        if (this.f773j.isEmpty()) {
            return null;
        }
        List<C0015d> list = this.f773j;
        return list.get(list.size() - 1).a.f909d;
    }

    @Override // e.b.e.i.k
    public void l(g gVar) {
        gVar.b(this, this.c);
        if (c()) {
            w(gVar);
        } else {
            this.f772i.add(gVar);
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
            AtomicInteger atomicInteger = l.a;
            this.o = Gravity.getAbsoluteGravity(i2, view.getLayoutDirection());
        }
    }

    public void onDismiss() {
        C0015d dVar;
        int size = this.f773j.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                dVar = null;
                break;
            }
            dVar = this.f773j.get(i2);
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
            AtomicInteger atomicInteger = l.a;
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

    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0146, code lost:
        if (((r9.getWidth() + r11[0]) + r5) > r10.right) goto L_0x0151;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x014d, code lost:
        if ((r11[0] - r5) < 0) goto L_0x014f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0151, code lost:
        r9 = 0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00e9  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x01b8  */
    public final void w(g gVar) {
        C0015d dVar;
        int i2;
        int i3;
        int i4;
        char c2;
        MenuItem menuItem;
        int i5;
        f fVar;
        int firstVisiblePosition;
        int i6 = Build.VERSION.SDK_INT;
        LayoutInflater from = LayoutInflater.from(this.c);
        f fVar2 = new f(gVar, from, this.f770g, C);
        if (!c() && this.w) {
            fVar2.f783d = true;
        } else if (c()) {
            fVar2.f783d = k.v(gVar);
        }
        View view = null;
        int n2 = k.n(fVar2, null, this.c, this.f767d);
        m0 m0Var = new m0(this.c, null, this.f768e, this.f769f);
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
        if (this.f773j.size() > 0) {
            List<C0015d> list = this.f773j;
            dVar = list.get(list.size() - 1);
            g gVar2 = dVar.b;
            int size = gVar2.size();
            int i7 = 0;
            while (true) {
                if (i7 >= size) {
                    menuItem = null;
                    break;
                }
                menuItem = gVar2.getItem(i7);
                if (menuItem.hasSubMenu() && gVar == menuItem.getSubMenu()) {
                    break;
                }
                i7++;
            }
            if (menuItem != null) {
                f0 f0Var = dVar.a.f909d;
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
                int i8 = 0;
                while (true) {
                    if (i8 >= count) {
                        i8 = -1;
                        break;
                    } else if (menuItem == fVar.getItem(i8)) {
                        break;
                    } else {
                        i8++;
                    }
                }
                if (i8 != -1 && (firstVisiblePosition = (i8 + i5) - f0Var.getFirstVisiblePosition()) >= 0 && firstVisiblePosition < f0Var.getChildCount()) {
                    view = f0Var.getChildAt(firstVisiblePosition);
                }
            }
            if (view == null) {
                if (i6 <= 28) {
                    Method method = m0.F;
                    if (method != null) {
                        try {
                            method.invoke(m0Var.A, Boolean.FALSE);
                        } catch (Exception unused) {
                            Log.i("MenuPopupWindow", "Could not invoke setTouchModal() on PopupWindow. Oh well.");
                        }
                    }
                } else {
                    m0Var.A.setTouchModal(false);
                }
                if (i6 >= 23) {
                    m0Var.A.setEnterTransition(null);
                }
                List<C0015d> list2 = this.f773j;
                f0 f0Var2 = list2.get(list2.size() - 1).a.f909d;
                int[] iArr = new int[2];
                f0Var2.getLocationOnScreen(iArr);
                Rect rect = new Rect();
                this.q.getWindowVisibleDisplayFrame(rect);
                if (this.r == 1) {
                }
                int i9 = 1;
                boolean z2 = i9 == 1;
                this.r = i9;
                if (i6 >= 26) {
                    m0Var.q = view;
                    i3 = 0;
                    i2 = 0;
                } else {
                    int[] iArr2 = new int[2];
                    this.p.getLocationOnScreen(iArr2);
                    int[] iArr3 = new int[2];
                    view.getLocationOnScreen(iArr3);
                    if ((this.o & 7) == 5) {
                        c2 = 0;
                        iArr2[0] = this.p.getWidth() + iArr2[0];
                        iArr3[0] = view.getWidth() + iArr3[0];
                    } else {
                        c2 = 0;
                    }
                    i2 = iArr3[c2] - iArr2[c2];
                    i3 = iArr3[1] - iArr2[1];
                }
                if ((this.o & 5) != 5) {
                    if (z2) {
                        n2 = view.getWidth();
                    }
                    i4 = i2 - n2;
                    m0Var.f912g = i4;
                    m0Var.f917l = true;
                    m0Var.f916k = true;
                    m0Var.n(i3);
                } else if (!z2) {
                    n2 = view.getWidth();
                    i4 = i2 - n2;
                    m0Var.f912g = i4;
                    m0Var.f917l = true;
                    m0Var.f916k = true;
                    m0Var.n(i3);
                }
                i4 = i2 + n2;
                m0Var.f912g = i4;
                m0Var.f917l = true;
                m0Var.f916k = true;
                m0Var.n(i3);
            } else {
                if (this.s) {
                    m0Var.f912g = this.u;
                }
                if (this.t) {
                    m0Var.n(this.v);
                }
                Rect rect2 = this.b;
                m0Var.y = rect2 != null ? new Rect(rect2) : null;
            }
            this.f773j.add(new C0015d(m0Var, gVar, this.r));
            m0Var.a();
            f0 f0Var3 = m0Var.f909d;
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
        this.f773j.add(new C0015d(m0Var, gVar, this.r));
        m0Var.a();
        f0 f0Var32 = m0Var.f909d;
        f0Var32.setOnKeyListener(this);
        if (dVar == null) {
        }
    }
}
