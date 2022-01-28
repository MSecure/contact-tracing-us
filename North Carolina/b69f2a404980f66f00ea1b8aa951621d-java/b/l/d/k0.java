package b.l.d;

import android.view.View;
import b.i.l.m;
import java.util.ArrayList;
import java.util.Map;

public class k0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ArrayList f1315b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Map f1316c;

    public k0(l0 l0Var, ArrayList arrayList, Map map) {
        this.f1315b = arrayList;
        this.f1316c = map;
    }

    public void run() {
        int size = this.f1315b.size();
        for (int i = 0; i < size; i++) {
            View view = (View) this.f1315b.get(i);
            view.setTransitionName((String) this.f1316c.get(m.u(view)));
        }
    }
}
