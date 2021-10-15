package b.l.d;

import android.view.View;
import b.i.l.m;
import java.util.ArrayList;
import java.util.Map;

public class t0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ArrayList f2134b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Map f2135c;

    public t0(r0 r0Var, ArrayList arrayList, Map map) {
        this.f2134b = arrayList;
        this.f2135c = map;
    }

    public void run() {
        int size = this.f2134b.size();
        for (int i = 0; i < size; i++) {
            View view = (View) this.f2134b.get(i);
            view.setTransitionName((String) this.f2135c.get(m.v(view)));
        }
    }
}
