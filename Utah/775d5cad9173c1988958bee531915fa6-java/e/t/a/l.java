package e.t.a;

import androidx.recyclerview.widget.RecyclerView;
import e.t.a.k;
import f.b.a.a.a.d0.o6;
import f.b.a.a.a.d0.z4;
import java.util.Objects;

public class l implements Runnable {
    public final /* synthetic */ k.f b;
    public final /* synthetic */ int c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ k f1936d;

    public l(k kVar, k.f fVar, int i2) {
        this.f1936d = kVar;
        this.b = fVar;
        this.c = i2;
    }

    public void run() {
        RecyclerView recyclerView = this.f1936d.r;
        if (recyclerView != null && recyclerView.isAttachedToWindow()) {
            k.f fVar = this.b;
            if (!fVar.f1932k && fVar.f1926e.e() != -1) {
                RecyclerView.j itemAnimator = this.f1936d.r.getItemAnimator();
                if (itemAnimator == null || !itemAnimator.k()) {
                    k kVar = this.f1936d;
                    int size = kVar.p.size();
                    boolean z = false;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= size) {
                            break;
                        } else if (!kVar.p.get(i2).f1933l) {
                            z = true;
                            break;
                        } else {
                            i2++;
                        }
                    }
                    if (!z) {
                        k.d dVar = this.f1936d.m;
                        RecyclerView.b0 b0Var = this.b.f1926e;
                        o6.a aVar = (o6.a) dVar;
                        Objects.requireNonNull(aVar);
                        int e2 = b0Var.e();
                        o6 o6Var = o6.this;
                        z4 z4Var = aVar.f2188k;
                        int i3 = o6.d0;
                        o6Var.I0(z4Var, e2);
                        return;
                    }
                }
                this.f1936d.r.post(this);
            }
        }
    }
}
