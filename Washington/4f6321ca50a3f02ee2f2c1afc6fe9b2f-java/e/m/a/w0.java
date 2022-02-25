package e.m.a;

import android.view.View;
import e.i.i.l;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class w0 implements Runnable {
    public final /* synthetic */ ArrayList b;
    public final /* synthetic */ Map c;

    public w0(u0 u0Var, ArrayList arrayList, Map map) {
        this.b = arrayList;
        this.c = map;
    }

    public void run() {
        int size = this.b.size();
        for (int i2 = 0; i2 < size; i2++) {
            View view = (View) this.b.get(i2);
            AtomicInteger atomicInteger = l.a;
            view.setTransitionName((String) this.c.get(view.getTransitionName()));
        }
    }
}
