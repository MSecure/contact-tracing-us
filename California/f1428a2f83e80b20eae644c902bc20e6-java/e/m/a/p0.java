package e.m.a;

import android.view.View;
import java.util.ArrayList;

public class p0 implements Runnable {
    public final /* synthetic */ Object b;
    public final /* synthetic */ u0 c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ View f1656d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ l f1657e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ ArrayList f1658f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ArrayList f1659g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ ArrayList f1660h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Object f1661i;

    public p0(Object obj, u0 u0Var, View view, l lVar, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, Object obj2) {
        this.b = obj;
        this.c = u0Var;
        this.f1656d = view;
        this.f1657e = lVar;
        this.f1658f = arrayList;
        this.f1659g = arrayList2;
        this.f1660h = arrayList3;
        this.f1661i = obj2;
    }

    public void run() {
        Object obj = this.b;
        if (obj != null) {
            this.c.o(obj, this.f1656d);
            this.f1659g.addAll(s0.h(this.c, this.b, this.f1657e, this.f1658f, this.f1656d));
        }
        if (this.f1660h != null) {
            if (this.f1661i != null) {
                ArrayList<View> arrayList = new ArrayList<>();
                arrayList.add(this.f1656d);
                this.c.p(this.f1661i, this.f1660h, arrayList);
            }
            this.f1660h.clear();
            this.f1660h.add(this.f1656d);
        }
    }
}
