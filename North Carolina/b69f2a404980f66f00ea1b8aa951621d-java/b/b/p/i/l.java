package b.b.p.i;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import b.b.d;
import b.b.p.i.m;

public class l {

    /* renamed from: a  reason: collision with root package name */
    public final Context f565a;

    /* renamed from: b  reason: collision with root package name */
    public final g f566b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f567c;

    /* renamed from: d  reason: collision with root package name */
    public final int f568d;

    /* renamed from: e  reason: collision with root package name */
    public final int f569e;
    public View f;
    public int g = 8388611;
    public boolean h;
    public m.a i;
    public k j;
    public PopupWindow.OnDismissListener k;
    public final PopupWindow.OnDismissListener l = new a();

    public class a implements PopupWindow.OnDismissListener {
        public a() {
        }

        public void onDismiss() {
            l.this.c();
        }
    }

    public l(Context context, g gVar, View view, boolean z, int i2, int i3) {
        this.f565a = context;
        this.f566b = gVar;
        this.f = view;
        this.f567c = z;
        this.f568d = i2;
        this.f569e = i3;
    }

    public k a() {
        if (this.j == null) {
            Display defaultDisplay = ((WindowManager) this.f565a.getSystemService("window")).getDefaultDisplay();
            Point point = new Point();
            defaultDisplay.getRealSize(point);
            k dVar = Math.min(point.x, point.y) >= this.f565a.getResources().getDimensionPixelSize(d.abc_cascading_menus_min_smallest_width) ? new d(this.f565a, this.f, this.f568d, this.f569e, this.f567c) : new q(this.f565a, this.f566b, this.f, this.f568d, this.f569e, this.f567c);
            dVar.l(this.f566b);
            dVar.s(this.l);
            dVar.o(this.f);
            dVar.h(this.i);
            dVar.p(this.h);
            dVar.q(this.g);
            this.j = dVar;
        }
        return this.j;
    }

    public boolean b() {
        k kVar = this.j;
        return kVar != null && kVar.c();
    }

    public void c() {
        this.j = null;
        PopupWindow.OnDismissListener onDismissListener = this.k;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public void d(m.a aVar) {
        this.i = aVar;
        k kVar = this.j;
        if (kVar != null) {
            kVar.h(aVar);
        }
    }

    public final void e(int i2, int i3, boolean z, boolean z2) {
        k a2 = a();
        a2.t(z2);
        if (z) {
            if ((Gravity.getAbsoluteGravity(this.g, b.i.l.m.o(this.f)) & 7) == 5) {
                i2 -= this.f.getWidth();
            }
            a2.r(i2);
            a2.u(i3);
            int i4 = (int) ((this.f565a.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            a2.f564b = new Rect(i2 - i4, i3 - i4, i2 + i4, i3 + i4);
        }
        a2.a();
    }

    public boolean f() {
        if (b()) {
            return true;
        }
        if (this.f == null) {
            return false;
        }
        e(0, 0, false, false);
        return true;
    }
}
