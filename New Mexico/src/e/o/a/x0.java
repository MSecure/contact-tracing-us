package e.o.a;

import android.view.View;
import e.j.j.v;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes.dex */
public class x0 implements Runnable {
    public final /* synthetic */ ArrayList b;
    public final /* synthetic */ Map c;

    public x0(v0 v0Var, ArrayList arrayList, Map map) {
        this.b = arrayList;
        this.c = map;
    }

    @Override // java.lang.Runnable
    public void run() {
        int size = this.b.size();
        for (int i2 = 0; i2 < size; i2++) {
            View view = (View) this.b.get(i2);
            AtomicInteger atomicInteger = v.a;
            v.i.v(view, (String) this.c.get(v.i.k(view)));
        }
    }
}
