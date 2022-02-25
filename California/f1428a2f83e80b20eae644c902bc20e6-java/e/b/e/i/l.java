package e.b.e.i;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import androidx.appcompat.R$dimen;
import e.b.e.i.m;
import java.util.concurrent.atomic.AtomicInteger;

public class l {
    public final Context a;
    public final g b;
    public final boolean c;

    /* renamed from: d  reason: collision with root package name */
    public final int f809d;

    /* renamed from: e  reason: collision with root package name */
    public final int f810e;

    /* renamed from: f  reason: collision with root package name */
    public View f811f;

    /* renamed from: g  reason: collision with root package name */
    public int f812g = 8388611;

    /* renamed from: h  reason: collision with root package name */
    public boolean f813h;

    /* renamed from: i  reason: collision with root package name */
    public m.a f814i;

    /* renamed from: j  reason: collision with root package name */
    public k f815j;

    /* renamed from: k  reason: collision with root package name */
    public PopupWindow.OnDismissListener f816k;

    /* renamed from: l  reason: collision with root package name */
    public final PopupWindow.OnDismissListener f817l = new a();

    public class a implements PopupWindow.OnDismissListener {
        public a() {
        }

        public void onDismiss() {
            l.this.c();
        }
    }

    public l(Context context, g gVar, View view, boolean z, int i2, int i3) {
        this.a = context;
        this.b = gVar;
        this.f811f = view;
        this.c = z;
        this.f809d = i2;
        this.f810e = i3;
    }

    public k a() {
        if (this.f815j == null) {
            Display defaultDisplay = ((WindowManager) this.a.getSystemService("window")).getDefaultDisplay();
            Point point = new Point();
            defaultDisplay.getRealSize(point);
            k dVar = Math.min(point.x, point.y) >= this.a.getResources().getDimensionPixelSize(R$dimen.abc_cascading_menus_min_smallest_width) ? new d(this.a, this.f811f, this.f809d, this.f810e, this.c) : new q(this.a, this.b, this.f811f, this.f809d, this.f810e, this.c);
            dVar.l(this.b);
            dVar.s(this.f817l);
            dVar.o(this.f811f);
            dVar.h(this.f814i);
            dVar.p(this.f813h);
            dVar.q(this.f812g);
            this.f815j = dVar;
        }
        return this.f815j;
    }

    public boolean b() {
        k kVar = this.f815j;
        return kVar != null && kVar.c();
    }

    public void c() {
        this.f815j = null;
        PopupWindow.OnDismissListener onDismissListener = this.f816k;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public void d(m.a aVar) {
        this.f814i = aVar;
        k kVar = this.f815j;
        if (kVar != null) {
            kVar.h(aVar);
        }
    }

    public final void e(int i2, int i3, boolean z, boolean z2) {
        k a2 = a();
        a2.t(z2);
        if (z) {
            int i4 = this.f812g;
            View view = this.f811f;
            AtomicInteger atomicInteger = e.i.i.l.a;
            if ((Gravity.getAbsoluteGravity(i4, view.getLayoutDirection()) & 7) == 5) {
                i2 -= this.f811f.getWidth();
            }
            a2.r(i2);
            a2.u(i3);
            int i5 = (int) ((this.a.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            a2.b = new Rect(i2 - i5, i3 - i5, i2 + i5, i3 + i5);
        }
        a2.a();
    }

    public boolean f() {
        if (b()) {
            return true;
        }
        if (this.f811f == null) {
            return false;
        }
        e(0, 0, false, false);
        return true;
    }
}
