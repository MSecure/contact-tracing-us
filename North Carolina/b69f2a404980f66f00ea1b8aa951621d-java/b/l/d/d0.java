package b.l.d;

import android.view.View;
import androidx.fragment.app.Fragment;
import java.util.ArrayList;

public final class d0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object f1259b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ l0 f1260c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ View f1261d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Fragment f1262e;
    public final /* synthetic */ ArrayList f;
    public final /* synthetic */ ArrayList g;
    public final /* synthetic */ ArrayList h;
    public final /* synthetic */ Object i;

    public d0(Object obj, l0 l0Var, View view, Fragment fragment, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, Object obj2) {
        this.f1259b = obj;
        this.f1260c = l0Var;
        this.f1261d = view;
        this.f1262e = fragment;
        this.f = arrayList;
        this.g = arrayList2;
        this.h = arrayList3;
        this.i = obj2;
    }

    public void run() {
        Object obj = this.f1259b;
        if (obj != null) {
            this.f1260c.n(obj, this.f1261d);
            this.g.addAll(g0.h(this.f1260c, this.f1259b, this.f1262e, this.f, this.f1261d));
        }
        if (this.h != null) {
            if (this.i != null) {
                ArrayList<View> arrayList = new ArrayList<>();
                arrayList.add(this.f1261d);
                this.f1260c.o(this.i, this.h, arrayList);
            }
            this.h.clear();
            this.h.add(this.f1261d);
        }
    }
}
