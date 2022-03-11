package e.m.a;

import android.view.View;
import java.util.ArrayList;

public class s0 implements Runnable {
    public final /* synthetic */ Object b;
    public final /* synthetic */ x0 c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ View f1682d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ l f1683e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ ArrayList f1684f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ArrayList f1685g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ ArrayList f1686h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Object f1687i;

    public s0(Object obj, x0 x0Var, View view, l lVar, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, Object obj2) {
        this.b = obj;
        this.c = x0Var;
        this.f1682d = view;
        this.f1683e = lVar;
        this.f1684f = arrayList;
        this.f1685g = arrayList2;
        this.f1686h = arrayList3;
        this.f1687i = obj2;
    }

    public void run() {
        Object obj = this.b;
        if (obj != null) {
            this.c.o(obj, this.f1682d);
            this.f1685g.addAll(v0.h(this.c, this.b, this.f1683e, this.f1684f, this.f1682d));
        }
        if (this.f1686h != null) {
            if (this.f1687i != null) {
                ArrayList<View> arrayList = new ArrayList<>();
                arrayList.add(this.f1682d);
                this.c.p(this.f1687i, this.f1686h, arrayList);
            }
            this.f1686h.clear();
            this.f1686h.add(this.f1682d);
        }
    }
}
