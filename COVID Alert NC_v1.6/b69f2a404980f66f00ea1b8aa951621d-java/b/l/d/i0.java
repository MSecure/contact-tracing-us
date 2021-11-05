package b.l.d;

import android.view.View;
import b.i.l.m;
import java.util.ArrayList;

public class i0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f1306b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ArrayList f1307c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ ArrayList f1308d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ ArrayList f1309e;
    public final /* synthetic */ ArrayList f;

    public i0(l0 l0Var, int i, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4) {
        this.f1306b = i;
        this.f1307c = arrayList;
        this.f1308d = arrayList2;
        this.f1309e = arrayList3;
        this.f = arrayList4;
    }

    public void run() {
        for (int i = 0; i < this.f1306b; i++) {
            m.e0((View) this.f1307c.get(i), (String) this.f1308d.get(i));
            ((View) this.f1309e.get(i)).setTransitionName((String) this.f.get(i));
        }
    }
}
