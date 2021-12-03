package e.n.a;

import android.view.View;
import java.util.ArrayList;

public class q0 implements Runnable {
    public final /* synthetic */ Object b;
    public final /* synthetic */ v0 c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ View f1760d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ m f1761e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ ArrayList f1762f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ArrayList f1763g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ ArrayList f1764h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Object f1765i;

    public q0(Object obj, v0 v0Var, View view, m mVar, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, Object obj2) {
        this.b = obj;
        this.c = v0Var;
        this.f1760d = view;
        this.f1761e = mVar;
        this.f1762f = arrayList;
        this.f1763g = arrayList2;
        this.f1764h = arrayList3;
        this.f1765i = obj2;
    }

    public void run() {
        Object obj = this.b;
        if (obj != null) {
            this.c.o(obj, this.f1760d);
            this.f1763g.addAll(t0.h(this.c, this.b, this.f1761e, this.f1762f, this.f1760d));
        }
        if (this.f1764h != null) {
            if (this.f1765i != null) {
                ArrayList<View> arrayList = new ArrayList<>();
                arrayList.add(this.f1760d);
                this.c.p(this.f1765i, this.f1764h, arrayList);
            }
            this.f1764h.clear();
            this.f1764h.add(this.f1760d);
        }
    }
}
