package e.m.a;

import android.graphics.Rect;
import android.view.View;
import e.e.a;
import e.m.a.v0;
import java.util.ArrayList;

public class u0 implements Runnable {
    public final /* synthetic */ x0 b;
    public final /* synthetic */ a c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Object f1696d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ v0.b f1697e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ ArrayList f1698f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ View f1699g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ l f1700h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ l f1701i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ boolean f1702j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ ArrayList f1703k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Object f1704l;
    public final /* synthetic */ Rect m;

    public u0(x0 x0Var, a aVar, Object obj, v0.b bVar, ArrayList arrayList, View view, l lVar, l lVar2, boolean z, ArrayList arrayList2, Object obj2, Rect rect) {
        this.b = x0Var;
        this.c = aVar;
        this.f1696d = obj;
        this.f1697e = bVar;
        this.f1698f = arrayList;
        this.f1699g = view;
        this.f1700h = lVar;
        this.f1701i = lVar2;
        this.f1702j = z;
        this.f1703k = arrayList2;
        this.f1704l = obj2;
        this.m = rect;
    }

    public void run() {
        a<String, View> e2 = v0.e(this.b, this.c, this.f1696d, this.f1697e);
        if (e2 != null) {
            this.f1698f.addAll(e2.values());
            this.f1698f.add(this.f1699g);
        }
        v0.c(this.f1700h, this.f1701i, this.f1702j, e2, false);
        Object obj = this.f1696d;
        if (obj != null) {
            this.b.x(obj, this.f1703k, this.f1698f);
            View k2 = v0.k(e2, this.f1697e, this.f1704l, this.f1702j);
            if (k2 != null) {
                this.b.j(k2, this.m);
            }
        }
    }
}
