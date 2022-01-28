package e.b.e.i;

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
import androidx.appcompat.R$dimen;
import androidx.appcompat.R$layout;
import e.b.e.i.m;
import e.b.f.j0;
import e.b.f.q0;
import e.i.i.v;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public final class q extends k implements PopupWindow.OnDismissListener, AdapterView.OnItemClickListener, m, View.OnKeyListener {
    public static final int w = R$layout.abc_popup_menu_item_layout;
    public final Context c;

    /* renamed from: d  reason: collision with root package name */
    public final g f820d;

    /* renamed from: e  reason: collision with root package name */
    public final f f821e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f822f;

    /* renamed from: g  reason: collision with root package name */
    public final int f823g;

    /* renamed from: h  reason: collision with root package name */
    public final int f824h;

    /* renamed from: i  reason: collision with root package name */
    public final int f825i;

    /* renamed from: j  reason: collision with root package name */
    public final q0 f826j;

    /* renamed from: k  reason: collision with root package name */
    public final ViewTreeObserver.OnGlobalLayoutListener f827k = new a();

    /* renamed from: l  reason: collision with root package name */
    public final View.OnAttachStateChangeListener f828l = new b();
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
                if (!qVar.f826j.z) {
                    View view = qVar.o;
                    if (view == null || !view.isShown()) {
                        q.this.dismiss();
                    } else {
                        q.this.f826j.a();
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
                qVar.q.removeGlobalOnLayoutListener(qVar.f827k);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    }

    public q(Context context, g gVar, View view, int i2, int i3, boolean z) {
        this.c = context;
        this.f820d = gVar;
        this.f822f = z;
        this.f821e = new f(gVar, LayoutInflater.from(context), z, w);
        this.f824h = i2;
        this.f825i = i3;
        Resources resources = context.getResources();
        this.f823g = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R$dimen.abc_config_prefDialogWidth));
        this.n = view;
        this.f826j = new q0(context, null, i2, i3);
        gVar.b(this, context);
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x00c8 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00c9  */
    @Override // e.b.e.i.p
    public void a() {
        View view;
        boolean z = false;
        if (!c()) {
            if (!this.r && (view = this.n) != null) {
                this.o = view;
                this.f826j.A.setOnDismissListener(this);
                q0 q0Var = this.f826j;
                q0Var.r = this;
                q0Var.s(true);
                View view2 = this.o;
                boolean z2 = this.q == null;
                ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
                this.q = viewTreeObserver;
                if (z2) {
                    viewTreeObserver.addOnGlobalLayoutListener(this.f827k);
                }
                view2.addOnAttachStateChangeListener(this.f828l);
                q0 q0Var2 = this.f826j;
                q0Var2.q = view2;
                q0Var2.m = this.u;
                if (!this.s) {
                    this.t = k.n(this.f821e, null, this.c, this.f823g);
                    this.s = true;
                }
                this.f826j.r(this.t);
                this.f826j.A.setInputMethodMode(2);
                q0 q0Var3 = this.f826j;
                Rect rect = this.b;
                Objects.requireNonNull(q0Var3);
                q0Var3.y = rect != null ? new Rect(rect) : null;
                this.f826j.a();
                j0 j0Var = this.f826j.f940d;
                j0Var.setOnKeyListener(this);
                if (this.v && this.f820d.m != null) {
                    FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.c).inflate(R$layout.abc_popup_menu_header_item_layout, (ViewGroup) j0Var, false);
                    TextView textView = (TextView) frameLayout.findViewById(16908310);
                    if (textView != null) {
                        textView.setText(this.f820d.m);
                    }
                    frameLayout.setEnabled(false);
                    j0Var.addHeaderView(frameLayout, null, false);
                }
                this.f826j.o(this.f821e);
                this.f826j.a();
            }
            if (z) {
                throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
            }
            return;
        }
        z = true;
        if (z) {
        }
    }

    @Override // e.b.e.i.m
    public void b(g gVar, boolean z) {
        if (gVar == this.f820d) {
            dismiss();
            m.a aVar = this.p;
            if (aVar != null) {
                aVar.b(gVar, z);
            }
        }
    }

    @Override // e.b.e.i.p
    public boolean c() {
        return !this.r && this.f826j.c();
    }

    @Override // e.b.e.i.m
    public boolean d() {
        return false;
    }

    @Override // e.b.e.i.p
    public void dismiss() {
        if (c()) {
            this.f826j.dismiss();
        }
    }

    @Override // e.b.e.i.m
    public void h(m.a aVar) {
        this.p = aVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0070  */
    @Override // e.b.e.i.m
    public boolean i(r rVar) {
        boolean z;
        if (rVar.hasVisibleItems()) {
            l lVar = new l(this.c, rVar, this.o, this.f822f, this.f824h, this.f825i);
            lVar.d(this.p);
            boolean v2 = k.v(rVar);
            lVar.f814h = v2;
            k kVar = lVar.f816j;
            if (kVar != null) {
                kVar.p(v2);
            }
            lVar.f817k = this.m;
            this.m = null;
            this.f820d.c(false);
            q0 q0Var = this.f826j;
            int i2 = q0Var.f943g;
            int i3 = !q0Var.f946j ? 0 : q0Var.f944h;
            int i4 = this.u;
            View view = this.n;
            AtomicInteger atomicInteger = v.a;
            if ((Gravity.getAbsoluteGravity(i4, v.e.d(view)) & 7) == 5) {
                i2 += this.n.getWidth();
            }
            if (!lVar.b()) {
                if (lVar.f812f == null) {
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

    @Override // e.b.e.i.m
    public void j(boolean z) {
        this.s = false;
        f fVar = this.f821e;
        if (fVar != null) {
            fVar.notifyDataSetChanged();
        }
    }

    @Override // e.b.e.i.p
    public ListView k() {
        return this.f826j.f940d;
    }

    @Override // e.b.e.i.k
    public void l(g gVar) {
    }

    @Override // e.b.e.i.k
    public void o(View view) {
        this.n = view;
    }

    public void onDismiss() {
        this.r = true;
        this.f820d.c(true);
        ViewTreeObserver viewTreeObserver = this.q;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.q = this.o.getViewTreeObserver();
            }
            this.q.removeGlobalOnLayoutListener(this.f827k);
            this.q = null;
        }
        this.o.removeOnAttachStateChangeListener(this.f828l);
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

    @Override // e.b.e.i.k
    public void p(boolean z) {
        this.f821e.f784d = z;
    }

    @Override // e.b.e.i.k
    public void q(int i2) {
        this.u = i2;
    }

    @Override // e.b.e.i.k
    public void r(int i2) {
        this.f826j.f943g = i2;
    }

    @Override // e.b.e.i.k
    public void s(PopupWindow.OnDismissListener onDismissListener) {
        this.m = onDismissListener;
    }

    @Override // e.b.e.i.k
    public void t(boolean z) {
        this.v = z;
    }

    @Override // e.b.e.i.k
    public void u(int i2) {
        q0 q0Var = this.f826j;
        q0Var.f944h = i2;
        q0Var.f946j = true;
    }
}
