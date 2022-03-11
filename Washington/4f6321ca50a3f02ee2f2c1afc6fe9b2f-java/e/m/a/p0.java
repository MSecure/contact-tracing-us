package e.m.a;

import android.view.View;
import java.util.ArrayList;

public class p0 implements Runnable {
    public final /* synthetic */ Object b;
    public final /* synthetic */ u0 c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ View f1655d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ l f1656e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ ArrayList f1657f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ArrayList f1658g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ ArrayList f1659h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Object f1660i;

    public p0(Object obj, u0 u0Var, View view, l lVar, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, Object obj2) {
        this.b = obj;
        this.c = u0Var;
        this.f1655d = view;
        this.f1656e = lVar;
        this.f1657f = arrayList;
        this.f1658g = arrayList2;
        this.f1659h = arrayList3;
        this.f1660i = obj2;
    }

    public void run() {
        Object obj = this.b;
        if (obj != null) {
            this.c.o(obj, this.f1655d);
            this.f1658g.addAll(s0.h(this.c, this.b, this.f1656e, this.f1657f, this.f1655d));
        }
        if (this.f1659h != null) {
            if (this.f1660i != null) {
                ArrayList<View> arrayList = new ArrayList<>();
                arrayList.add(this.f1655d);
                this.c.p(this.f1660i, this.f1659h, arrayList);
            }
            this.f1659h.clear();
            this.f1659h.add(this.f1655d);
        }
    }
}
