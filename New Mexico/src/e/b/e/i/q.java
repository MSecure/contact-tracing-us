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
import e.j.j.v;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public final class q extends k implements PopupWindow.OnDismissListener, AdapterView.OnItemClickListener, m, View.OnKeyListener {
    public static final int w = R$layout.abc_popup_menu_item_layout;
    public final Context c;

    /* renamed from: d  reason: collision with root package name */
    public final g f884d;

    /* renamed from: e  reason: collision with root package name */
    public final f f885e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f886f;

    /* renamed from: g  reason: collision with root package name */
    public final int f887g;

    /* renamed from: h  reason: collision with root package name */
    public final int f888h;

    /* renamed from: i  reason: collision with root package name */
    public final int f889i;

    /* renamed from: j  reason: collision with root package name */
    public final q0 f890j;
    public PopupWindow.OnDismissListener m;
    public View n;
    public View o;
    public m.a p;
    public ViewTreeObserver q;
    public boolean r;
    public boolean s;
    public int t;
    public boolean v;

    /* renamed from: k  reason: collision with root package name */
    public final ViewTreeObserver.OnGlobalLayoutListener f891k = new a();

    /* renamed from: l  reason: collision with root package name */
    public final View.OnAttachStateChangeListener f892l = new b();
    public int u = 0;

    /* loaded from: classes.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (q.this.c()) {
                q qVar = q.this;
                if (!qVar.f890j.z) {
                    View view = qVar.o;
                    if (view == null || !view.isShown()) {
                        q.this.dismiss();
                    } else {
                        q.this.f890j.a();
                    }
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
            ViewTreeObserver viewTreeObserver = q.this.q;
            if (viewTreeObserver != null) {
                if (!viewTreeObserver.isAlive()) {
                    q.this.q = view.getViewTreeObserver();
                }
                q qVar = q.this;
                qVar.q.removeGlobalOnLayoutListener(qVar.f891k);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    }

    public q(Context context, g gVar, View view, int i2, int i3, boolean z) {
        this.c = context;
        this.f884d = gVar;
        this.f886f = z;
        this.f885e = new f(gVar, LayoutInflater.from(context), z, w);
        this.f888h = i2;
        this.f889i = i3;
        Resources resources = context.getResources();
        this.f887g = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R$dimen.abc_config_prefDialogWidth));
        this.n = view;
        this.f890j = new q0(context, null, i2, i3);
        gVar.b(this, context);
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00c8 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00c9  */
    @Override // e.b.e.i.p
    /* Code decompiled incorrectly, please refer to instructions dump */
    public void a() {
        View view;
        boolean z = false;
        if (!c()) {
            if (!this.r && (view = this.n) != null) {
                this.o = view;
                this.f890j.A.setOnDismissListener(this);
                q0 q0Var = this.f890j;
                q0Var.r = this;
                q0Var.s(true);
                View view2 = this.o;
                boolean z2 = this.q == null;
                ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
                this.q = viewTreeObserver;
                if (z2) {
                    viewTreeObserver.addOnGlobalLayoutListener(this.f891k);
                }
                view2.addOnAttachStateChangeListener(this.f892l);
                q0 q0Var2 = this.f890j;
                q0Var2.q = view2;
                q0Var2.m = this.u;
                if (!this.s) {
                    this.t = k.n(this.f885e, null, this.c, this.f887g);
                    this.s = true;
                }
                this.f890j.r(this.t);
                this.f890j.A.setInputMethodMode(2);
                q0 q0Var3 = this.f890j;
                Rect rect = this.b;
                Objects.requireNonNull(q0Var3);
                q0Var3.y = rect != null ? new Rect(rect) : null;
                this.f890j.a();
                j0 j0Var = this.f890j.f1004d;
                j0Var.setOnKeyListener(this);
                if (this.v && this.f884d.m != null) {
                    FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.c).inflate(R$layout.abc_popup_menu_header_item_layout, (ViewGroup) j0Var, false);
                    TextView textView = (TextView) frameLayout.findViewById(16908310);
                    if (textView != null) {
                        textView.setText(this.f884d.m);
                    }
                    frameLayout.setEnabled(false);
                    j0Var.addHeaderView(frameLayout, null, false);
                }
                this.f890j.o(this.f885e);
                this.f890j.a();
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
        if (gVar == this.f884d) {
            dismiss();
            m.a aVar = this.p;
            if (aVar != null) {
                aVar.b(gVar, z);
            }
        }
    }

    @Override // e.b.e.i.p
    public boolean c() {
        return !this.r && this.f890j.c();
    }

    @Override // e.b.e.i.m
    public boolean d() {
        return false;
    }

    @Override // e.b.e.i.p
    public void dismiss() {
        if (c()) {
            this.f890j.dismiss();
        }
    }

    @Override // e.b.e.i.m
    public void h(m.a aVar) {
        this.p = aVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0070  */
    @Override // e.b.e.i.m
    /* Code decompiled incorrectly, please refer to instructions dump */
    public boolean i(r rVar) {
        boolean z;
        if (rVar.hasVisibleItems()) {
            l lVar = new l(this.c, rVar, this.o, this.f886f, this.f888h, this.f889i);
            lVar.d(this.p);
            boolean v = k.v(rVar);
            lVar.f878h = v;
            k kVar = lVar.f880j;
            if (kVar != null) {
                kVar.p(v);
            }
            lVar.f881k = this.m;
            this.m = null;
            this.f884d.c(false);
            q0 q0Var = this.f890j;
            int i2 = q0Var.f1007g;
            int i3 = !q0Var.f1010j ? 0 : q0Var.f1008h;
            int i4 = this.u;
            View view = this.n;
            AtomicInteger atomicInteger = v.a;
            if ((Gravity.getAbsoluteGravity(i4, v.e.d(view)) & 7) == 5) {
                i2 += this.n.getWidth();
            }
            if (!lVar.b()) {
                if (lVar.f876f == null) {
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
        f fVar = this.f885e;
        if (fVar != null) {
            fVar.notifyDataSetChanged();
        }
    }

    @Override // e.b.e.i.p
    public ListView k() {
        return this.f890j.f1004d;
    }

    @Override // e.b.e.i.k
    public void l(g gVar) {
    }

    @Override // e.b.e.i.k
    public void o(View view) {
        this.n = view;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        this.r = true;
        this.f884d.c(true);
        ViewTreeObserver viewTreeObserver = this.q;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.q = this.o.getViewTreeObserver();
            }
            this.q.removeGlobalOnLayoutListener(this.f891k);
            this.q = null;
        }
        this.o.removeOnAttachStateChangeListener(this.f892l);
        PopupWindow.OnDismissListener onDismissListener = this.m;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
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
        this.f885e.f848d = z;
    }

    @Override // e.b.e.i.k
    public void q(int i2) {
        this.u = i2;
    }

    @Override // e.b.e.i.k
    public void r(int i2) {
        this.f890j.f1007g = i2;
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
        q0 q0Var = this.f890j;
        q0Var.f1008h = i2;
        q0Var.f1010j = true;
    }
}
