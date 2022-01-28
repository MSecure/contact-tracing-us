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
    public final int f802d;

    /* renamed from: e  reason: collision with root package name */
    public final int f803e;

    /* renamed from: f  reason: collision with root package name */
    public View f804f;

    /* renamed from: g  reason: collision with root package name */
    public int f805g = 8388611;

    /* renamed from: h  reason: collision with root package name */
    public boolean f806h;

    /* renamed from: i  reason: collision with root package name */
    public m.a f807i;

    /* renamed from: j  reason: collision with root package name */
    public k f808j;

    /* renamed from: k  reason: collision with root package name */
    public PopupWindow.OnDismissListener f809k;

    /* renamed from: l  reason: collision with root package name */
    public final PopupWindow.OnDismissListener f810l = new a();

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
        this.f804f = view;
        this.c = z;
        this.f802d = i2;
        this.f803e = i3;
    }

    public k a() {
        if (this.f808j == null) {
            Display defaultDisplay = ((WindowManager) this.a.getSystemService("window")).getDefaultDisplay();
            Point point = new Point();
            defaultDisplay.getRealSize(point);
            k dVar = Math.min(point.x, point.y) >= this.a.getResources().getDimensionPixelSize(R$dimen.abc_cascading_menus_min_smallest_width) ? new d(this.a, this.f804f, this.f802d, this.f803e, this.c) : new q(this.a, this.b, this.f804f, this.f802d, this.f803e, this.c);
            dVar.l(this.b);
            dVar.s(this.f810l);
            dVar.o(this.f804f);
            dVar.h(this.f807i);
            dVar.p(this.f806h);
            dVar.q(this.f805g);
            this.f808j = dVar;
        }
        return this.f808j;
    }

    public boolean b() {
        k kVar = this.f808j;
        return kVar != null && kVar.c();
    }

    public void c() {
        this.f808j = null;
        PopupWindow.OnDismissListener onDismissListener = this.f809k;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public void d(m.a aVar) {
        this.f807i = aVar;
        k kVar = this.f808j;
        if (kVar != null) {
            kVar.h(aVar);
        }
    }

    public final void e(int i2, int i3, boolean z, boolean z2) {
        k a2 = a();
        a2.t(z2);
        if (z) {
            int i4 = this.f805g;
            View view = this.f804f;
            AtomicInteger atomicInteger = e.i.i.m.a;
            if ((Gravity.getAbsoluteGravity(i4, view.getLayoutDirection()) & 7) == 5) {
                i2 -= this.f804f.getWidth();
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
        if (this.f804f == null) {
            return false;
        }
        e(0, 0, false, false);
        return true;
    }
}
