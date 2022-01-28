package b.l.d;

import android.view.View;
import b.i.l.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class j0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ArrayList f1310b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Map f1311c;

    public j0(l0 l0Var, ArrayList arrayList, Map map) {
        this.f1310b = arrayList;
        this.f1311c = map;
    }

    public void run() {
        String str;
        int size = this.f1310b.size();
        for (int i = 0; i < size; i++) {
            View view = (View) this.f1310b.get(i);
            String u = m.u(view);
            if (u != null) {
                Iterator it = this.f1311c.entrySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        str = null;
                        break;
                    }
                    Map.Entry entry = (Map.Entry) it.next();
                    if (u.equals(entry.getValue())) {
                        str = (String) entry.getKey();
                        break;
                    }
                }
                view.setTransitionName(str);
            }
        }
    }
}
