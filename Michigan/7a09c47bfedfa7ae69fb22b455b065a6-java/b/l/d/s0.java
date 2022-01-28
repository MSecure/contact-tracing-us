package b.l.d;

import android.view.View;
import b.i.l.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class s0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ArrayList f2129b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Map f2130c;

    public s0(r0 r0Var, ArrayList arrayList, Map map) {
        this.f2129b = arrayList;
        this.f2130c = map;
    }

    public void run() {
        String str;
        int size = this.f2129b.size();
        for (int i = 0; i < size; i++) {
            View view = (View) this.f2129b.get(i);
            String v = m.v(view);
            if (v != null) {
                Iterator it = this.f2130c.entrySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        str = null;
                        break;
                    }
                    Map.Entry entry = (Map.Entry) it.next();
                    if (v.equals(entry.getValue())) {
                        str = (String) entry.getKey();
                        break;
                    }
                }
                view.setTransitionName(str);
            }
        }
    }
}
