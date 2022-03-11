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
import e.b.f.f0;
import e.b.f.m0;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public final class q extends k implements PopupWindow.OnDismissListener, AdapterView.OnItemClickListener, m, View.OnKeyListener {
    public static final int w = R$layout.abc_popup_menu_item_layout;
    public final Context c;

    /* renamed from: d  reason: collision with root package name */
    public final g f822d;

    /* renamed from: e  reason: collision with root package name */
    public final f f823e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f824f;

    /* renamed from: g  reason: collision with root package name */
    public final int f825g;

    /* renamed from: h  reason: collision with root package name */
    public final int f826h;

    /* renamed from: i  reason: collision with root package name */
    public final int f827i;

    /* renamed from: j  reason: collision with root package name */
    public final m0 f828j;

    /* renamed from: k  reason: collision with root package name */
    public final ViewTreeObserver.OnGlobalLayoutListener f829k = new a();

    /* renamed from: l  reason: collision with root package name */
    public final View.OnAttachStateChangeListener f830l = new b();
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
                if (!qVar.f828j.z) {
                    View view = qVar.o;
                    if (view == null || !view.isShown()) {
                        q.this.dismiss();
                    } else {
                        q.this.f828j.a();
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
                qVar.q.removeGlobalOnLayoutListener(qVar.f829k);
            }
            view.removeOnAttachStateChangeListener(this);
        }
    }

    public q(Context context, g gVar, View view, int i2, int i3, boolean z) {
        this.c = context;
        this.f822d = gVar;
        this.f824f = z;
        this.f823e = new f(gVar, LayoutInflater.from(context), z, w);
        this.f826h = i2;
        this.f827i = i3;
        Resources resources = context.getResources();
        this.f825g = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R$dimen.abc_config_prefDialogWidth));
        this.n = view;
        this.f828j = new m0(context, null, i2, i3);
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
                this.f828j.A.setOnDismissListener(this);
                m0 m0Var = this.f828j;
                m0Var.r = this;
                m0Var.s(true);
                View view2 = this.o;
                boolean z2 = this.q == null;
                ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
                this.q = viewTreeObserver;
                if (z2) {
                    viewTreeObserver.addOnGlobalLayoutListener(this.f829k);
                }
                view2.addOnAttachStateChangeListener(this.f830l);
                m0 m0Var2 = this.f828j;
                m0Var2.q = view2;
                m0Var2.m = this.u;
                if (!this.s) {
                    this.t = k.n(this.f823e, null, this.c, this.f825g);
                    this.s = true;
                }
                this.f828j.r(this.t);
                this.f828j.A.setInputMethodMode(2);
                m0 m0Var3 = this.f828j;
                Rect rect = this.b;
                Objects.requireNonNull(m0Var3);
                m0Var3.y = rect != null ? new Rect(rect) : null;
                this.f828j.a();
                f0 f0Var = this.f828j.f912d;
                f0Var.setOnKeyListener(this);
                if (this.v && this.f822d.m != null) {
                    FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.c).inflate(R$layout.abc_popup_menu_header_item_layout, (ViewGroup) f0Var, false);
                    TextView textView = (TextView) frameLayout.findViewById(16908310);
                    if (textView != null) {
                        textView.setText(this.f822d.m);
                    }
                    frameLayout.setEnabled(false);
                    f0Var.addHeaderView(frameLayout, null, false);
                }
                this.f828j.o(this.f823e);
                this.f828j.a();
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
        if (gVar == this.f822d) {
            dismiss();
            m.a aVar = this.p;
            if (aVar != null) {
                aVar.b(gVar, z);
            }
        }
    }

    @Override // e.b.e.i.p
    public boolean c() {
        return !this.r && this.f828j.c();
    }

    @Override // e.b.e.i.m
    public boolean d() {
        return false;
    }

    @Override // e.b.e.i.p
    public void dismiss() {
        if (c()) {
            this.f828j.dismiss();
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
            l lVar = new l(this.c, rVar, this.o, this.f824f, this.f826h, this.f827i);
            lVar.d(this.p);
            boolean v2 = k.v(rVar);
            lVar.f816h = v2;
            k kVar = lVar.f818j;
            if (kVar != null) {
                kVar.p(v2);
            }
            lVar.f819k = this.m;
            this.m = null;
            this.f822d.c(false);
            m0 m0Var = this.f828j;
            int i2 = m0Var.f915g;
            int i3 = !m0Var.f918j ? 0 : m0Var.f916h;
            int i4 = this.u;
            View view = this.n;
            AtomicInteger atomicInteger = e.i.i.m.a;
            if ((Gravity.getAbsoluteGravity(i4, view.getLayoutDirection()) & 7) == 5) {
                i2 += this.n.getWidth();
            }
            if (!lVar.b()) {
                if (lVar.f814f == null) {
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
        f fVar = this.f823e;
        if (fVar != null) {
            fVar.notifyDataSetChanged();
        }
    }

    @Override // e.b.e.i.p
    public ListView k() {
        return this.f828j.f912d;
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
        this.f822d.c(true);
        ViewTreeObserver viewTreeObserver = this.q;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.q = this.o.getViewTreeObserver();
            }
            this.q.removeGlobalOnLayoutListener(this.f829k);
            this.q = null;
        }
        this.o.removeOnAttachStateChangeListener(this.f830l);
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
        this.f823e.f786d = z;
    }

    @Override // e.b.e.i.k
    public void q(int i2) {
        this.u = i2;
    }

    @Override // e.b.e.i.k
    public void r(int i2) {
        this.f828j.f915g = i2;
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
        m0 m0Var = this.f828j;
        m0Var.f916h = i2;
        m0Var.f918j = true;
    }
}
