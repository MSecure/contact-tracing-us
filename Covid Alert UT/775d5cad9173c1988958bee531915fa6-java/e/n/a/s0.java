package e.n.a;

import android.graphics.Rect;
import android.view.View;
import e.e.a;
import e.n.a.t0;
import java.util.ArrayList;

public class s0 implements Runnable {
    public final /* synthetic */ v0 b;
    public final /* synthetic */ a c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Object f1774d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ t0.b f1775e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ ArrayList f1776f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ View f1777g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ m f1778h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ m f1779i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ boolean f1780j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ ArrayList f1781k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Object f1782l;
    public final /* synthetic */ Rect m;

    public s0(v0 v0Var, a aVar, Object obj, t0.b bVar, ArrayList arrayList, View view, m mVar, m mVar2, boolean z, ArrayList arrayList2, Object obj2, Rect rect) {
        this.b = v0Var;
        this.c = aVar;
        this.f1774d = obj;
        this.f1775e = bVar;
        this.f1776f = arrayList;
        this.f1777g = view;
        this.f1778h = mVar;
        this.f1779i = mVar2;
        this.f1780j = z;
        this.f1781k = arrayList2;
        this.f1782l = obj2;
        this.m = rect;
    }

    public void run() {
        a<String, View> e2 = t0.e(this.b, this.c, this.f1774d, this.f1775e);
        if (e2 != null) {
            this.f1776f.addAll(e2.values());
            this.f1776f.add(this.f1777g);
        }
        t0.c(this.f1778h, this.f1779i, this.f1780j, e2, false);
        Object obj = this.f1774d;
        if (obj != null) {
            this.b.x(obj, this.f1781k, this.f1776f);
            View k2 = t0.k(e2, this.f1775e, this.f1782l, this.f1780j);
            if (k2 != null) {
                this.b.j(k2, this.m);
            }
        }
    }
}
