package b.b.p.i;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import b.b.d;
import b.b.g;
import b.b.p.i.m;
import b.b.q.f0;
import b.b.q.m0;

public final class q extends k implements PopupWindow.OnDismissListener, AdapterView.OnItemClickListener, m, View.OnKeyListener {
    public static final int w = g.abc_popup_menu_item_layout;

    /* renamed from: c  reason: collision with root package name */
    public final Context f572c;

    /* renamed from: d  reason: collision with root package name */
    public final g f573d;

    /* renamed from: e  reason: collision with root package name */
    public final f f574e;
    public final boolean f;
    public final int g;
    public final int h;
    public final int i;
    public final m0 j;
    public final ViewTreeObserver.OnGlobalLayoutListener k = new a();
    public final View.OnAttachStateChangeListener l = new b();
    public PopupWindow.OnDismissListener m;
    public View n;
    public View o;
    public m.a p;
    public ViewTreeObserver q;
    public boolean r;
    public boolean s;
    public int t;
    public int u = 0;
    public boolean v;

    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public a() {
        }

        public void onGlobalLayout() {
            if (q.this.c()) {
                q qVar = q.this;
                if (!qVar.j.B) {
                    View view = qVar.o;
                    if (view == null || !view.isShown()) {
                        q.this.dismiss();
                    } else {
                        q.this.j.a();
                    }
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
            ViewTreeObserver viewTreeObserver = q.this.q;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    q.this.q = view.getViewTreeObserver();
                }
                q qVar = q.this;
                qVar.q.removeGlobalOnLayoutListener(qVar.k);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    }

    public q(Context context, g gVar, View view, int i2, int i3, boolean z) {
        this.f572c = context;
        this.f573d = gVar;
        this.f = z;
        this.f574e = new f(gVar, LayoutInflater.from(context), this.f, w);
        this.h = i2;
        this.i = i3;
        Resources resources = context.getResources();
        this.g = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(d.abc_config_prefDialogWidth));
        this.n = view;
        this.j = new m0(this.f572c, null, this.h, this.i);
        gVar.b(this, context);
    }

    @Override // b.b.p.i.p
    public void a() {
        View view;
        boolean z = true;
        if (!c()) {
            if (this.r || (view = this.n) == null) {
                z = false;
            } else {
                this.o = view;
                this.j.C.setOnDismissListener(this);
                m0 m0Var = this.j;
                m0Var.t = this;
                m0Var.s(true);
                View view2 = this.o;
                boolean z2 = this.q == null;
                ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
                this.q = viewTreeObserver;
                if (z2) {
                    viewTreeObserver.addOnGlobalLayoutListener(this.k);
                }
                view2.addOnAttachStateChangeListener(this.l);
                m0 m0Var2 = this.j;
                m0Var2.s = view2;
                m0Var2.m = this.u;
                if (!this.s) {
                    this.t = k.n(this.f574e, null, this.f572c, this.g);
                    this.s = true;
                }
                this.j.r(this.t);
                this.j.C.setInputMethodMode(2);
                m0 m0Var3 = this.j;
                Rect rect = this.f564b;
                if (m0Var3 != null) {
                    m0Var3.A = rect != null ? new Rect(rect) : null;
                    this.j.a();
                    f0 f0Var = this.j.f670d;
                    f0Var.setOnKeyListener(this);
                    if (this.v && this.f573d.m != null) {
                        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.f572c).inflate(g.abc_popup_menu_header_item_layout, (ViewGroup) f0Var, false);
                        TextView textView = (TextView) frameLayout.findViewById(16908310);
                        if (textView != null) {
                            textView.setText(this.f573d.m);
                        }
                        frameLayout.setEnabled(false);
                        f0Var.addHeaderView(frameLayout, null, false);
                    }
                    this.j.o(this.f574e);
                    this.j.a();
                } else {
                    throw null;
                }
            }
        }
        if (!z) {
            throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
        }
    }

    @Override // b.b.p.i.m
    public void b(g gVar, boolean z) {
        if (gVar == this.f573d) {
            dismiss();
            m.a aVar = this.p;
            if (aVar != null) {
                aVar.b(gVar, z);
            }
        }
    }

    @Override // b.b.p.i.p
    public boolean c() {
        return !this.r && this.j.c();
    }

    @Override // b.b.p.i.m
    public boolean d() {
        return false;
    }

    @Override // b.b.p.i.p
    public void dismiss() {
        if (c()) {
            this.j.dismiss();
        }
    }

    @Override // b.b.p.i.m
    public void h(m.a aVar) {
        this.p = aVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x006e  */
    @Override // b.b.p.i.m
    public boolean i(r rVar) {
        boolean z;
        if (rVar.hasVisibleItems()) {
            l lVar = new l(this.f572c, rVar, this.o, this.f, this.h, this.i);
            lVar.d(this.p);
            boolean v2 = k.v(rVar);
            lVar.h = v2;
            k kVar = lVar.j;
            if (kVar != null) {
                kVar.p(v2);
            }
            lVar.k = this.m;
            this.m = null;
            this.f573d.c(false);
            m0 m0Var = this.j;
            int i2 = m0Var.g;
            int i3 = !m0Var.j ? 0 : m0Var.h;
            if ((Gravity.getAbsoluteGravity(this.u, b.i.l.m.o(this.n)) & 7) == 5) {
                i2 += this.n.getWidth();
            }
            if (!lVar.b()) {
                if (lVar.f == null) {
                    z = false;
                    if (z) {
                        m.a aVar = this.p;
                        if (aVar != null) {
                            aVar.c(rVar);
                        }
                        return true;
                    }
                } else {
                    lVar.e(i2, i3, true, true);
                }
            }
            z = true;
            if (z) {
            }
        }
        return false;
    }

    @Override // b.b.p.i.m
    public void j(boolean z) {
        this.s = false;
        f fVar = this.f574e;
        if (fVar != null) {
            fVar.notifyDataSetChanged();
        }
    }

    @Override // b.b.p.i.p
    public ListView k() {
        return this.j.f670d;
    }

    @Override // b.b.p.i.k
    public void l(g gVar) {
    }

    @Override // b.b.p.i.k
    public void o(View view) {
        this.n = view;
    }

    public void onDismiss() {
        this.r = true;
        this.f573d.c(true);
        ViewTreeObserver viewTreeObserver = this.q;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.q = this.o.getViewTreeObserver();
            }
            this.q.removeGlobalOnLayoutListener(this.k);
            this.q = null;
        }
        this.o.removeOnAttachStateChangeListener(this.l);
        PopupWindow.OnDismissListener onDismissListener = this.m;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
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
    public void p(boolean z) {
        this.f574e.f538d = z;
    }

    @Override // b.b.p.i.k
    public void q(int i2) {
        this.u = i2;
    }

    @Override // b.b.p.i.k
    public void r(int i2) {
        this.j.g = i2;
    }

    @Override // b.b.p.i.k
    public void s(PopupWindow.OnDismissListener onDismissListener) {
        this.m = onDismissListener;
    }

    @Override // b.b.p.i.k
    public void t(boolean z) {
        this.v = z;
    }

    @Override // b.b.p.i.k
    public void u(int i2) {
        m0 m0Var = this.j;
        m0Var.h = i2;
        m0Var.j = true;
    }
}
