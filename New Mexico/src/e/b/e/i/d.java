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
import e.b.f.j0;
import e.b.f.p0;
import e.b.f.q0;
import e.j.j.v;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public final class d extends k implements m, View.OnKeyListener, PopupWindow.OnDismissListener {
    public static final int C = R$layout.abc_cascading_menu_item_layout;
    public PopupWindow.OnDismissListener A;
    public boolean B;
    public final Context c;

    /* renamed from: d  reason: collision with root package name */
    public final int f832d;

    /* renamed from: e  reason: collision with root package name */
    public final int f833e;

    /* renamed from: f  reason: collision with root package name */
    public final int f834f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f835g;

    /* renamed from: h  reason: collision with root package name */
    public final Handler f836h;
    public View p;
    public View q;
    public int r;
    public boolean s;
    public boolean t;
    public int u;
    public int v;
    public boolean x;
    public m.a y;
    public ViewTreeObserver z;

    /* renamed from: i  reason: collision with root package name */
    public final List<g> f837i = new ArrayList();

    /* renamed from: j  reason: collision with root package name */
    public final List<C0018d> f838j = new ArrayList();

    /* renamed from: k  reason: collision with root package name */
    public final ViewTreeObserver.OnGlobalLayoutListener f839k = new a();

    /* renamed from: l  reason: collision with root package name */
    public final View.OnAttachStateChangeListener f840l = new b();
    public final p0 m = new c();
    public int n = 0;
    public int o = 0;
    public boolean w = false;

    /* loaded from: classes.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (d.this.c() && d.this.f838j.size() > 0 && !d.this.f838j.get(0).a.z) {
                View view = d.this.q;
                if (view == null || !view.isShown()) {
                    d.this.dismiss();
                    return;
                }
                for (C0018d dVar : d.this.f838j) {
                    dVar.a.a();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements View.OnAttachStateChangeListener {
        public b() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            ViewTreeObserver viewTreeObserver = d.this.z;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    d.this.z = view.getViewTreeObserver();
                }
                d dVar = d.this;
                dVar.z.removeGlobalOnLayoutListener(dVar.f839k);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    }

    /* loaded from: classes.dex */
    public class c implements p0 {

        /* loaded from: classes.dex */
        public class a implements Runnable {
            public final /* synthetic */ C0018d b;
            public final /* synthetic */ MenuItem c;

            /* renamed from: d  reason: collision with root package name */
            public final /* synthetic */ g f841d;

            public a(C0018d dVar, MenuItem menuItem, g gVar) {
                this.b = dVar;
                this.c = menuItem;
                this.f841d = gVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                C0018d dVar = this.b;
                if (dVar != null) {
                    d.this.B = true;
                    dVar.b.c(false);
                    d.this.B = false;
                }
                if (this.c.isEnabled() && this.c.hasSubMenu()) {
                    this.f841d.r(this.c, 4);
                }
            }
        }

        public c() {
        }

        @Override // e.b.f.p0
        public void f(g gVar, MenuItem menuItem) {
            C0018d dVar = null;
            d.this.f836h.removeCallbacksAndMessages(null);
            int size = d.this.f838j.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    i2 = -1;
                    break;
                } else if (gVar == d.this.f838j.get(i2).b) {
                    break;
                } else {
                    i2++;
                }
            }
            if (i2 != -1) {
                int i3 = i2 + 1;
                if (i3 < d.this.f838j.size()) {
                    dVar = d.this.f838j.get(i3);
                }
                d.this.f836h.postAtTime(new a(dVar, menuItem, gVar), gVar, SystemClock.uptimeMillis() + 200);
            }
        }

        @Override // e.b.f.p0
        public void h(g gVar, MenuItem menuItem) {
            d.this.f836h.removeCallbacksAndMessages(gVar);
        }
    }

    /* renamed from: e.b.e.i.d$d  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0018d {
        public final q0 a;
        public final g b;
        public final int c;

        public C0018d(q0 q0Var, g gVar, int i2) {
            this.a = q0Var;
            this.b = gVar;
            this.c = i2;
        }
    }

    public d(Context context, View view, int i2, int i3, boolean z) {
        int i4 = 0;
        this.c = context;
        this.p = view;
        this.f833e = i2;
        this.f834f = i3;
        this.f835g = z;
        AtomicInteger atomicInteger = v.a;
        this.r = v.e.d(view) != 1 ? 1 : i4;
        Resources resources = context.getResources();
        this.f832d = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R$dimen.abc_config_prefDialogWidth));
        this.f836h = new Handler();
    }

    @Override // e.b.e.i.p
    public void a() {
        if (!c()) {
            for (g gVar : this.f837i) {
                w(gVar);
            }
            this.f837i.clear();
            View view = this.p;
            this.q = view;
            if (view != null) {
                boolean z = this.z == null;
                ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
                this.z = viewTreeObserver;
                if (z) {
                    viewTreeObserver.addOnGlobalLayoutListener(this.f839k);
                }
                this.q.addOnAttachStateChangeListener(this.f840l);
            }
        }
    }

    @Override // e.b.e.i.m
    public void b(g gVar, boolean z) {
        int i2;
        int size = this.f838j.size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                i3 = -1;
                break;
            } else if (gVar == this.f838j.get(i3).b) {
                break;
            } else {
                i3++;
            }
        }
        if (i3 >= 0) {
            int i4 = i3 + 1;
            if (i4 < this.f838j.size()) {
                this.f838j.get(i4).b.c(false);
            }
            C0018d remove = this.f838j.remove(i3);
            remove.b.u(this);
            if (this.B) {
                q0 q0Var = remove.a;
                Objects.requireNonNull(q0Var);
                if (Build.VERSION.SDK_INT >= 23) {
                    q0Var.A.setExitTransition(null);
                }
                remove.a.A.setAnimationStyle(0);
            }
            remove.a.dismiss();
            int size2 = this.f838j.size();
            if (size2 > 0) {
                i2 = this.f838j.get(size2 - 1).c;
            } else {
                View view = this.p;
                AtomicInteger atomicInteger = v.a;
                i2 = v.e.d(view) == 1 ? 0 : 1;
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
                        this.z.removeGlobalOnLayoutListener(this.f839k);
                    }
                    this.z = null;
                }
                this.q.removeOnAttachStateChangeListener(this.f840l);
                this.A.onDismiss();
            } else if (z) {
                this.f838j.get(0).b.c(false);
            }
        }
    }

    @Override // e.b.e.i.p
    public boolean c() {
        return this.f838j.size() > 0 && this.f838j.get(0).a.c();
    }

    @Override // e.b.e.i.m
    public boolean d() {
        return false;
    }

    @Override // e.b.e.i.p
    public void dismiss() {
        int size = this.f838j.size();
        if (size > 0) {
            C0018d[] dVarArr = (C0018d[]) this.f838j.toArray(new C0018d[size]);
            for (int i2 = size - 1; i2 >= 0; i2--) {
                C0018d dVar = dVarArr[i2];
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
        for (C0018d dVar : this.f838j) {
            if (rVar == dVar.b) {
                dVar.a.f1004d.requestFocus();
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
            this.f837i.add(rVar);
        }
        m.a aVar = this.y;
        if (aVar != null) {
            aVar.c(rVar);
        }
        return true;
    }

    @Override // e.b.e.i.m
    public void j(boolean z) {
        for (C0018d dVar : this.f838j) {
            ListAdapter adapter = dVar.a.f1004d.getAdapter();
            if (adapter instanceof HeaderViewListAdapter) {
                adapter = ((HeaderViewListAdapter) adapter).getWrappedAdapter();
            }
            ((f) adapter).notifyDataSetChanged();
        }
    }

    @Override // e.b.e.i.p
    public ListView k() {
        if (this.f838j.isEmpty()) {
            return null;
        }
        List<C0018d> list = this.f838j;
        return list.get(list.size() - 1).a.f1004d;
    }

    @Override // e.b.e.i.k
    public void l(g gVar) {
        gVar.b(this, this.c);
        if (c()) {
            w(gVar);
        } else {
            this.f837i.add(gVar);
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
            AtomicInteger atomicInteger = v.a;
            this.o = Gravity.getAbsoluteGravity(i2, v.e.d(view));
        }
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        C0018d dVar;
        int size = this.f838j.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                dVar = null;
                break;
            }
            dVar = this.f838j.get(i2);
            if (!dVar.a.c()) {
                break;
            }
            i2++;
        }
        if (dVar != null) {
            dVar.b.c(false);
        }
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i2, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i2 != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    @Override // e.b.e.i.k
    public void p(boolean z) {
        this.w = z;
    }

    @Override // e.b.e.i.k
    public void q(int i2) {
        if (this.n != i2) {
            this.n = i2;
            View view = this.p;
            AtomicInteger atomicInteger = v.a;
            this.o = Gravity.getAbsoluteGravity(i2, v.e.d(view));
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
    public void t(boolean z) {
        this.x = z;
    }

    @Override // e.b.e.i.k
    public void u(int i2) {
        this.t = true;
        this.v = i2;
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01ae  */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public final void w(g gVar) {
        C0018d dVar;
        int i2;
        int i3;
        int i4;
        MenuItem menuItem;
        int i5;
        f fVar;
        int firstVisiblePosition;
        LayoutInflater from = LayoutInflater.from(this.c);
        f fVar2 = new f(gVar, from, this.f835g, C);
        if (!c() && this.w) {
            fVar2.f848d = true;
        } else if (c()) {
            fVar2.f848d = k.v(gVar);
        }
        View view = null;
        int n = k.n(fVar2, null, this.c, this.f832d);
        q0 q0Var = new q0(this.c, null, this.f833e, this.f834f);
        q0Var.E = this.m;
        q0Var.r = this;
        q0Var.A.setOnDismissListener(this);
        q0Var.q = this.p;
        q0Var.m = this.o;
        q0Var.s(true);
        q0Var.A.setInputMethodMode(2);
        q0Var.o(fVar2);
        q0Var.r(n);
        q0Var.m = this.o;
        if (this.f838j.size() > 0) {
            List<C0018d> list = this.f838j;
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
                j0 j0Var = dVar.a.f1004d;
                ListAdapter adapter = j0Var.getAdapter();
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
                if (i7 != -1 && (firstVisiblePosition = (i7 + i5) - j0Var.getFirstVisiblePosition()) >= 0 && firstVisiblePosition < j0Var.getChildCount()) {
                    view = j0Var.getChildAt(firstVisiblePosition);
                }
            }
            if (view == null) {
                if (Build.VERSION.SDK_INT <= 28) {
                    Method method = q0.F;
                    if (method != null) {
                        try {
                            method.invoke(q0Var.A, Boolean.FALSE);
                        } catch (Exception unused) {
                        }
                    }
                } else {
                    q0Var.A.setTouchModal(false);
                }
                int i8 = Build.VERSION.SDK_INT;
                if (i8 >= 23) {
                    q0Var.A.setEnterTransition(null);
                }
                List<C0018d> list2 = this.f838j;
                j0 j0Var2 = list2.get(list2.size() - 1).a.f1004d;
                int[] iArr = new int[2];
                j0Var2.getLocationOnScreen(iArr);
                Rect rect = new Rect();
                this.q.getWindowVisibleDisplayFrame(rect);
                int i9 = (this.r != 1 ? iArr[0] - n >= 0 : (j0Var2.getWidth() + iArr[0]) + n > rect.right) ? 0 : 1;
                boolean z = i9 == 1;
                this.r = i9;
                if (i8 >= 26) {
                    q0Var.q = view;
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
                if ((this.o & 5) == 5) {
                    if (!z) {
                        n = view.getWidth();
                        i4 = i2 - n;
                    }
                    i4 = i2 + n;
                } else {
                    if (z) {
                        n = view.getWidth();
                        i4 = i2 + n;
                    }
                    i4 = i2 - n;
                }
                q0Var.f1007g = i4;
                q0Var.f1012l = true;
                q0Var.f1011k = true;
                q0Var.n(i3);
            } else {
                if (this.s) {
                    q0Var.f1007g = this.u;
                }
                if (this.t) {
                    q0Var.n(this.v);
                }
                Rect rect2 = this.b;
                q0Var.y = rect2 != null ? new Rect(rect2) : null;
            }
            this.f838j.add(new C0018d(q0Var, gVar, this.r));
            q0Var.a();
            j0 j0Var3 = q0Var.f1004d;
            j0Var3.setOnKeyListener(this);
            if (dVar == null && this.x && gVar.m != null) {
                FrameLayout frameLayout = (FrameLayout) from.inflate(R$layout.abc_popup_menu_header_item_layout, (ViewGroup) j0Var3, false);
                frameLayout.setEnabled(false);
                ((TextView) frameLayout.findViewById(16908310)).setText(gVar.m);
                j0Var3.addHeaderView(frameLayout, null, false);
                q0Var.a();
                return;
            }
            return;
        }
        dVar = null;
        view = null;
        if (view == null) {
        }
        this.f838j.add(new C0018d(q0Var, gVar, this.r));
        q0Var.a();
        j0 j0Var32 = q0Var.f1004d;
        j0Var32.setOnKeyListener(this);
        if (dVar == null) {
        }
    }
}
