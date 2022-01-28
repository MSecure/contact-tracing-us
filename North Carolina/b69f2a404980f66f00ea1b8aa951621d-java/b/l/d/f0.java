package b.l.d;

import android.graphics.Rect;
import android.view.View;
import androidx.fragment.app.Fragment;
import b.e.a;
import b.l.d.g0;
import java.util.ArrayList;

public final class f0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ l0 f1273b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ a f1274c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Object f1275d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ g0.b f1276e;
    public final /* synthetic */ ArrayList f;
    public final /* synthetic */ View g;
    public final /* synthetic */ Fragment h;
    public final /* synthetic */ Fragment i;
    public final /* synthetic */ boolean j;
    public final /* synthetic */ ArrayList k;
    public final /* synthetic */ Object l;
    public final /* synthetic */ Rect m;

    public f0(l0 l0Var, a aVar, Object obj, g0.b bVar, ArrayList arrayList, View view, Fragment fragment, Fragment fragment2, boolean z, ArrayList arrayList2, Object obj2, Rect rect) {
        this.f1273b = l0Var;
        this.f1274c = aVar;
        this.f1275d = obj;
        this.f1276e = bVar;
        this.f = arrayList;
        this.g = view;
        this.h = fragment;
        this.i = fragment2;
        this.j = z;
        this.k = arrayList2;
        this.l = obj2;
        this.m = rect;
    }

    public void run() {
        a<String, View> e2 = g0.e(this.f1273b, this.f1274c, this.f1275d, this.f1276e);
        if (e2 != null) {
            this.f.addAll(e2.values());
            this.f.add(this.g);
        }
        g0.c(this.h, this.i, this.j, e2, false);
        Object obj = this.f1275d;
        if (obj != null) {
            this.f1273b.v(obj, this.k, this.f);
            View k2 = g0.k(e2, this.f1276e, this.l, this.j);
            if (k2 != null) {
                this.f1273b.j(k2, this.m);
            }
        }
    }
}
