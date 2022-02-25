package e.m.a;

import android.graphics.Rect;
import android.view.View;
import e.e.a;
import e.m.a.s0;
import java.util.ArrayList;

public class r0 implements Runnable {
    public final /* synthetic */ u0 b;
    public final /* synthetic */ a c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Object f1670d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ s0.b f1671e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ ArrayList f1672f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ View f1673g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ l f1674h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ l f1675i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ boolean f1676j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ ArrayList f1677k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Object f1678l;
    public final /* synthetic */ Rect m;

    public r0(u0 u0Var, a aVar, Object obj, s0.b bVar, ArrayList arrayList, View view, l lVar, l lVar2, boolean z, ArrayList arrayList2, Object obj2, Rect rect) {
        this.b = u0Var;
        this.c = aVar;
        this.f1670d = obj;
        this.f1671e = bVar;
        this.f1672f = arrayList;
        this.f1673g = view;
        this.f1674h = lVar;
        this.f1675i = lVar2;
        this.f1676j = z;
        this.f1677k = arrayList2;
        this.f1678l = obj2;
        this.m = rect;
    }

    public void run() {
        a<String, View> e2 = s0.e(this.b, this.c, this.f1670d, this.f1671e);
        if (e2 != null) {
            this.f1672f.addAll(e2.values());
            this.f1672f.add(this.f1673g);
        }
        s0.c(this.f1674h, this.f1675i, this.f1676j, e2, false);
        Object obj = this.f1670d;
        if (obj != null) {
            this.b.x(obj, this.f1677k, this.f1672f);
            View k2 = s0.k(e2, this.f1671e, this.f1678l, this.f1676j);
            if (k2 != null) {
                this.b.j(k2, this.m);
            }
        }
    }
}
