package e.s.a;

import androidx.recyclerview.widget.RecyclerView;
import e.s.a.k;
import f.b.a.a.a.s.q6;
import f.b.a.a.a.s.z4;
import java.util.Objects;

public class l implements Runnable {
    public final /* synthetic */ k.f b;
    public final /* synthetic */ int c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ k f1661d;

    public l(k kVar, k.f fVar, int i2) {
        this.f1661d = kVar;
        this.b = fVar;
        this.c = i2;
    }

    public void run() {
        RecyclerView recyclerView = this.f1661d.r;
        if (recyclerView != null && recyclerView.isAttachedToWindow()) {
            k.f fVar = this.b;
            if (!fVar.f1657k && fVar.f1651e.e() != -1) {
                RecyclerView.j itemAnimator = this.f1661d.r.getItemAnimator();
                if (itemAnimator == null || !itemAnimator.k()) {
                    k kVar = this.f1661d;
                    int size = kVar.p.size();
                    boolean z = false;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= size) {
                            break;
                        } else if (!kVar.p.get(i2).f1658l) {
                            z = true;
                            break;
                        } else {
                            i2++;
                        }
                    }
                    if (!z) {
                        k.d dVar = this.f1661d.m;
                        RecyclerView.b0 b0Var = this.b.f1651e;
                        q6.a aVar = (q6.a) dVar;
                        Objects.requireNonNull(aVar);
                        int e2 = b0Var.e();
                        q6 q6Var = q6.this;
                        z4 z4Var = aVar.f2392k;
                        int i3 = q6.c0;
                        q6Var.C0(z4Var, e2);
                        return;
                    }
                }
                this.f1661d.r.post(this);
            }
        }
    }
}
