package e.m.a;

import android.view.View;
import java.util.ArrayList;

public class q0 implements Runnable {
    public final /* synthetic */ Object b;
    public final /* synthetic */ v0 c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ View f1487d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ m f1488e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ ArrayList f1489f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ArrayList f1490g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ ArrayList f1491h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Object f1492i;

    public q0(Object obj, v0 v0Var, View view, m mVar, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, Object obj2) {
        this.b = obj;
        this.c = v0Var;
        this.f1487d = view;
        this.f1488e = mVar;
        this.f1489f = arrayList;
        this.f1490g = arrayList2;
        this.f1491h = arrayList3;
        this.f1492i = obj2;
    }

    public void run() {
        Object obj = this.b;
        if (obj != null) {
            this.c.o(obj, this.f1487d);
            this.f1490g.addAll(t0.h(this.c, this.b, this.f1488e, this.f1489f, this.f1487d));
        }
        if (this.f1491h != null) {
            if (this.f1492i != null) {
                ArrayList<View> arrayList = new ArrayList<>();
                arrayList.add(this.f1487d);
                this.c.p(this.f1492i, this.f1491h, arrayList);
            }
            this.f1491h.clear();
            this.f1491h.add(this.f1487d);
        }
    }
}
