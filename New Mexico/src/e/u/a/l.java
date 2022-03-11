package e.u.a;

import androidx.recyclerview.widget.RecyclerView;
import e.u.a.k;
import f.b.a.a.a.e0.c7;
import f.b.a.a.a.e0.n5;
import java.util.Objects;
/* loaded from: classes.dex */
public class l implements Runnable {
    public final /* synthetic */ k.f b;
    public final /* synthetic */ int c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ k f2021d;

    public l(k kVar, k.f fVar, int i2) {
        this.f2021d = kVar;
        this.b = fVar;
        this.c = i2;
    }

    @Override // java.lang.Runnable
    public void run() {
        RecyclerView recyclerView = this.f2021d.r;
        if (recyclerView != null && recyclerView.isAttachedToWindow()) {
            k.f fVar = this.b;
            if (!fVar.f2017k && fVar.f2011e.e() != -1) {
                RecyclerView.j itemAnimator = this.f2021d.r.getItemAnimator();
                if (itemAnimator == null || !itemAnimator.k()) {
                    k kVar = this.f2021d;
                    int size = kVar.p.size();
                    boolean z = false;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= size) {
                            break;
                        } else if (!kVar.p.get(i2).f2018l) {
                            z = true;
                            break;
                        } else {
                            i2++;
                        }
                    }
                    if (!z) {
                        k.d dVar = this.f2021d.m;
                        RecyclerView.b0 b0Var = this.b.f2011e;
                        c7.a aVar = (c7.a) dVar;
                        Objects.requireNonNull(aVar);
                        int e2 = b0Var.e();
                        c7 c7Var = c7.this;
                        n5 n5Var = aVar.f2219k;
                        int i3 = c7.d0;
                        c7Var.L0(n5Var, e2);
                        return;
                    }
                }
                this.f2021d.r.post(this);
            }
        }
    }
}
