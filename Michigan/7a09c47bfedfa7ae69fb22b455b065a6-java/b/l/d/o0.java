package b.l.d;

import android.graphics.Rect;
import android.view.View;
import androidx.fragment.app.Fragment;
import b.e.a;
import b.l.d.p0;
import java.util.ArrayList;

public class o0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ r0 f2085b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ a f2086c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Object f2087d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ p0.b f2088e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ ArrayList f2089f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ View f2090g;
    public final /* synthetic */ Fragment h;
    public final /* synthetic */ Fragment i;
    public final /* synthetic */ boolean j;
    public final /* synthetic */ ArrayList k;
    public final /* synthetic */ Object l;
    public final /* synthetic */ Rect m;

    public o0(r0 r0Var, a aVar, Object obj, p0.b bVar, ArrayList arrayList, View view, Fragment fragment, Fragment fragment2, boolean z, ArrayList arrayList2, Object obj2, Rect rect) {
        this.f2085b = r0Var;
        this.f2086c = aVar;
        this.f2087d = obj;
        this.f2088e = bVar;
        this.f2089f = arrayList;
        this.f2090g = view;
        this.h = fragment;
        this.i = fragment2;
        this.j = z;
        this.k = arrayList2;
        this.l = obj2;
        this.m = rect;
    }

    public void run() {
        a<String, View> e2 = p0.e(this.f2085b, this.f2086c, this.f2087d, this.f2088e);
        if (e2 != null) {
            this.f2089f.addAll(e2.values());
            this.f2089f.add(this.f2090g);
        }
        p0.c(this.h, this.i, this.j, e2, false);
        Object obj = this.f2087d;
        if (obj != null) {
            this.f2085b.x(obj, this.k, this.f2089f);
            View k2 = p0.k(e2, this.f2088e, this.l, this.j);
            if (k2 != null) {
                this.f2085b.j(k2, this.m);
            }
        }
    }
}
