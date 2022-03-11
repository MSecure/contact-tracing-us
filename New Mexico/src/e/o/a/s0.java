package e.o.a;

import android.graphics.Rect;
import android.view.View;
import e.f.a;
import e.o.a.t0;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class s0 implements Runnable {
    public final /* synthetic */ v0 b;
    public final /* synthetic */ a c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Object f1859d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ t0.b f1860e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ ArrayList f1861f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ View f1862g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ m f1863h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ m f1864i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ boolean f1865j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ ArrayList f1866k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Object f1867l;
    public final /* synthetic */ Rect m;

    public s0(v0 v0Var, a aVar, Object obj, t0.b bVar, ArrayList arrayList, View view, m mVar, m mVar2, boolean z, ArrayList arrayList2, Object obj2, Rect rect) {
        this.b = v0Var;
        this.c = aVar;
        this.f1859d = obj;
        this.f1860e = bVar;
        this.f1861f = arrayList;
        this.f1862g = view;
        this.f1863h = mVar;
        this.f1864i = mVar2;
        this.f1865j = z;
        this.f1866k = arrayList2;
        this.f1867l = obj2;
        this.m = rect;
    }

    @Override // java.lang.Runnable
    public void run() {
        a<String, View> e2 = t0.e(this.b, this.c, this.f1859d, this.f1860e);
        if (e2 != null) {
            this.f1861f.addAll(e2.values());
            this.f1861f.add(this.f1862g);
        }
        t0.c(this.f1863h, this.f1864i, this.f1865j, e2, false);
        Object obj = this.f1859d;
        if (obj != null) {
            this.b.x(obj, this.f1866k, this.f1861f);
            View k2 = t0.k(e2, this.f1860e, this.f1867l, this.f1865j);
            if (k2 != null) {
                this.b.j(k2, this.m);
            }
        }
    }
}
