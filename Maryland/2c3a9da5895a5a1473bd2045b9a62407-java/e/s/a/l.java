package e.s.a;

import androidx.recyclerview.widget.RecyclerView;
import e.s.a.k;
import f.b.a.a.a.r.f3;
import f.b.a.a.a.r.q3;
import java.util.Objects;

public class l implements Runnable {
    public final /* synthetic */ k.f b;
    public final /* synthetic */ int c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ k f1845d;

    public l(k kVar, k.f fVar, int i2) {
        this.f1845d = kVar;
        this.b = fVar;
        this.c = i2;
    }

    public void run() {
        RecyclerView recyclerView = this.f1845d.r;
        if (recyclerView != null && recyclerView.isAttachedToWindow()) {
            k.f fVar = this.b;
            if (!fVar.f1841k && fVar.f1835e.e() != -1) {
                RecyclerView.j itemAnimator = this.f1845d.r.getItemAnimator();
                if (itemAnimator == null || !itemAnimator.k()) {
                    k kVar = this.f1845d;
                    int size = kVar.p.size();
                    boolean z = false;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= size) {
                            break;
                        } else if (!kVar.p.get(i2).f1842l) {
                            z = true;
                            break;
                        } else {
                            i2++;
                        }
                    }
                    if (!z) {
                        k.d dVar = this.f1845d.m;
                        RecyclerView.b0 b0Var = this.b.f1835e;
                        q3.a aVar = (q3.a) dVar;
                        Objects.requireNonNull(aVar);
                        int e2 = b0Var.e();
                        q3 q3Var = q3.this;
                        f3 f3Var = aVar.f2265k;
                        int i3 = q3.d0;
                        q3Var.z0(f3Var, e2);
                        return;
                    }
                }
                this.f1845d.r.post(this);
            }
        }
    }
}
