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
import e.j.j.v;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class l {
    public final Context a;
    public final g b;
    public final boolean c;

    /* renamed from: d */
    public final int f874d;

    /* renamed from: e */
    public final int f875e;

    /* renamed from: f */
    public View f876f;

    /* renamed from: h */
    public boolean f878h;

    /* renamed from: i */
    public m.a f879i;

    /* renamed from: j */
    public k f880j;

    /* renamed from: k */
    public PopupWindow.OnDismissListener f881k;

    /* renamed from: g */
    public int f877g = 8388611;

    /* renamed from: l */
    public final PopupWindow.OnDismissListener f882l = new a();

    /* loaded from: classes.dex */
    public class a implements PopupWindow.OnDismissListener {
        public a() {
            l.this = r1;
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            l.this.c();
        }
    }

    public l(Context context, g gVar, View view, boolean z, int i2, int i3) {
        this.a = context;
        this.b = gVar;
        this.f876f = view;
        this.c = z;
        this.f874d = i2;
        this.f875e = i3;
    }

    public k a() {
        if (this.f880j == null) {
            Display defaultDisplay = ((WindowManager) this.a.getSystemService("window")).getDefaultDisplay();
            Point point = new Point();
            defaultDisplay.getRealSize(point);
            k dVar = Math.min(point.x, point.y) >= this.a.getResources().getDimensionPixelSize(R$dimen.abc_cascading_menus_min_smallest_width) ? new d(this.a, this.f876f, this.f874d, this.f875e, this.c) : new q(this.a, this.b, this.f876f, this.f874d, this.f875e, this.c);
            dVar.l(this.b);
            dVar.s(this.f882l);
            dVar.o(this.f876f);
            dVar.h(this.f879i);
            dVar.p(this.f878h);
            dVar.q(this.f877g);
            this.f880j = dVar;
        }
        return this.f880j;
    }

    public boolean b() {
        k kVar = this.f880j;
        return kVar != null && kVar.c();
    }

    public void c() {
        this.f880j = null;
        PopupWindow.OnDismissListener onDismissListener = this.f881k;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public void d(m.a aVar) {
        this.f879i = aVar;
        k kVar = this.f880j;
        if (kVar != null) {
            kVar.h(aVar);
        }
    }

    public final void e(int i2, int i3, boolean z, boolean z2) {
        k a2 = a();
        a2.t(z2);
        if (z) {
            int i4 = this.f877g;
            View view = this.f876f;
            AtomicInteger atomicInteger = v.a;
            if ((Gravity.getAbsoluteGravity(i4, v.e.d(view)) & 7) == 5) {
                i2 -= this.f876f.getWidth();
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
        if (this.f876f == null) {
            return false;
        }
        e(0, 0, false, false);
        return true;
    }
}
