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
    public final /* synthetic */ Object f1669d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ s0.b f1670e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ ArrayList f1671f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ View f1672g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ l f1673h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ l f1674i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ boolean f1675j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ ArrayList f1676k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Object f1677l;
    public final /* synthetic */ Rect m;

    public r0(u0 u0Var, a aVar, Object obj, s0.b bVar, ArrayList arrayList, View view, l lVar, l lVar2, boolean z, ArrayList arrayList2, Object obj2, Rect rect) {
        this.b = u0Var;
        this.c = aVar;
        this.f1669d = obj;
        this.f1670e = bVar;
        this.f1671f = arrayList;
        this.f1672g = view;
        this.f1673h = lVar;
        this.f1674i = lVar2;
        this.f1675j = z;
        this.f1676k = arrayList2;
        this.f1677l = obj2;
        this.m = rect;
    }

    public void run() {
        a<String, View> e2 = s0.e(this.b, this.c, this.f1669d, this.f1670e);
        if (e2 != null) {
            this.f1671f.addAll(e2.values());
            this.f1671f.add(this.f1672g);
        }
        s0.c(this.f1673h, this.f1674i, this.f1675j, e2, false);
        Object obj = this.f1669d;
        if (obj != null) {
            this.b.x(obj, this.f1676k, this.f1671f);
            View k2 = s0.k(e2, this.f1670e, this.f1677l, this.f1675j);
            if (k2 != null) {
                this.b.j(k2, this.m);
            }
        }
    }
}
