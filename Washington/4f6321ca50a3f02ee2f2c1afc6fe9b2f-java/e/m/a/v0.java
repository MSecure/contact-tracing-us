package e.m.a;

import android.view.View;
import e.i.i.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class v0 implements Runnable {
    public final /* synthetic */ ArrayList b;
    public final /* synthetic */ Map c;

    public v0(u0 u0Var, ArrayList arrayList, Map map) {
        this.b = arrayList;
        this.c = map;
    }

    public void run() {
        String str;
        int size = this.b.size();
        for (int i2 = 0; i2 < size; i2++) {
            View view = (View) this.b.get(i2);
            AtomicInteger atomicInteger = l.a;
            String transitionName = view.getTransitionName();
            if (transitionName != null) {
                Iterator it = this.c.entrySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        str = null;
                        break;
                    }
                    Map.Entry entry = (Map.Entry) it.next();
                    if (transitionName.equals(entry.getValue())) {
                        str = (String) entry.getKey();
                        break;
                    }
                }
                view.setTransitionName(str);
            }
        }
    }
}
