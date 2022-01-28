package e.m.a;

import android.graphics.Rect;
import android.view.View;
import e.e.a;
import e.m.a.t0;
import java.util.ArrayList;

public class s0 implements Runnable {
    public final /* synthetic */ v0 b;
    public final /* synthetic */ a c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Object f1501d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ t0.b f1502e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ ArrayList f1503f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ View f1504g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ m f1505h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ m f1506i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ boolean f1507j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ ArrayList f1508k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Object f1509l;
    public final /* synthetic */ Rect m;

    public s0(v0 v0Var, a aVar, Object obj, t0.b bVar, ArrayList arrayList, View view, m mVar, m mVar2, boolean z, ArrayList arrayList2, Object obj2, Rect rect) {
        this.b = v0Var;
        this.c = aVar;
        this.f1501d = obj;
        this.f1502e = bVar;
        this.f1503f = arrayList;
        this.f1504g = view;
        this.f1505h = mVar;
        this.f1506i = mVar2;
        this.f1507j = z;
        this.f1508k = arrayList2;
        this.f1509l = obj2;
        this.m = rect;
    }

    public void run() {
        a<String, View> e2 = t0.e(this.b, this.c, this.f1501d, this.f1502e);
        if (e2 != null) {
            this.f1503f.addAll(e2.values());
            this.f1503f.add(this.f1504g);
        }
        t0.c(this.f1505h, this.f1506i, this.f1507j, e2, false);
        Object obj = this.f1501d;
        if (obj != null) {
            this.b.x(obj, this.f1508k, this.f1503f);
            View k2 = t0.k(e2, this.f1502e, this.f1509l, this.f1507j);
            if (k2 != null) {
                this.b.j(k2, this.m);
            }
        }
    }
}
