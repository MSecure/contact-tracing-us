package f.b.a.a.a;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import com.google.android.apps.exposurenotification.nearby.StateUpdatedWorker;
import com.google.android.gms.nearby.exposurenotification.DailySummariesConfig;
import e.b.a.m;
import e.p.a.b;
import f.b.a.a.a.c0.q1;
import f.b.a.a.a.j0.c;
import f.b.a.a.a.j0.e;
import f.b.a.a.a.j0.f;
import f.b.a.a.a.n0.a1;
import f.b.a.a.a.n0.b1;
import g.b.a.c.c.d;
import java.util.Objects;
/*  JADX ERROR: UnsupportedOperationException in pass: OverrideMethodVisitor
    java.lang.UnsupportedOperationException
    	at jadx.core.utils.ImmutableList.listIterator(ImmutableList.java:198)
    	at java.util.AbstractList.equals(AbstractList.java:519)
    	at jadx.core.dex.visitors.OverrideMethodVisitor.fixMethodArgTypes(OverrideMethodVisitor.java:297)
    	at jadx.core.dex.visitors.OverrideMethodVisitor.processMth(OverrideMethodVisitor.java:71)
    	at jadx.core.dex.visitors.OverrideMethodVisitor.processCls(OverrideMethodVisitor.java:56)
    	at jadx.core.dex.visitors.OverrideMethodVisitor.visit(OverrideMethodVisitor.java:48)
    */
/* loaded from: classes.dex */
public class h implements b {
    public final /* synthetic */ k a;

    public h(k kVar) {
        this.a = kVar;
    }

    @Override // e.p.a.b
    public ListenableWorker a(Context context, WorkerParameters workerParameters) {
        k kVar = this.a.t;
        Objects.requireNonNull(kVar);
        b1 b1Var = new b1(kVar.w.get());
        q1 q1Var = kVar.x.get();
        a1 b = kVar.b();
        f fVar = kVar.f2298j;
        DailySummariesConfig i2 = kVar.i();
        Objects.requireNonNull(fVar);
        e eVar = new e(i2);
        DailySummariesConfig i3 = kVar.i();
        f fVar2 = kVar.f2298j;
        Context t = d.t(kVar.c);
        Objects.requireNonNull(fVar2);
        return new StateUpdatedWorker(context, workerParameters, b1Var, q1Var, b, eVar, i3, new c(new f.b.a.a.a.j0.b[]{new f.b.a.a.a.j0.b(t, 1), new f.b.a.a.a.j0.b(t, 2), new f.b.a.a.a.j0.b(t, 3), new f.b.a.a.a.j0.b(t, 4)}), m.e.j1(kVar.b), kVar.v.get(), kVar.A.get(), kVar.B.get(), m.e.k1(kVar.f2293e));
    }
}
