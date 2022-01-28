package f.b.a.d.a;

import com.google.android.apps.exposurenotification.privateanalytics.PrioJni;
import f.b.a.a.a.f0.q;
import f.b.a.d.a.i0.a;
import f.b.a.d.a.i0.b;
import f.b.a.d.a.i0.e;
import f.b.a.d.a.x;
import f.b.b.a.g;
import java.util.Objects;

public final /* synthetic */ class n implements g {
    public final /* synthetic */ g0 a;

    public /* synthetic */ n(g0 g0Var) {
        this.a = g0Var;
    }

    @Override // f.b.b.a.g
    public final Object a(Object obj) {
        boolean z;
        b bVar;
        g0 g0Var = this.a;
        a aVar = (a) obj;
        Objects.requireNonNull(g0Var);
        Objects.requireNonNull(aVar, "Null createPacketsParameters");
        x xVar = (x) g0Var.f2806g;
        Objects.requireNonNull(xVar);
        e.b h2 = e.h();
        x.b bVar2 = x.b;
        d0 d0Var = xVar.a;
        synchronized (bVar2) {
            if (!bVar2.b) {
                bVar2.b = true;
                try {
                    ((q) d0Var).a.a("Loading Prio native library");
                    System.loadLibrary("prioclient");
                    bVar2.a = true;
                    ((q) d0Var).a.a("Prio native library loaded successfully");
                } catch (NullPointerException | SecurityException | UnsatisfiedLinkError e2) {
                    bVar2.a = false;
                    ((q) d0Var).a.d("Prio native library load failed.", e2);
                }
            } else {
                ((q) d0Var).a.a("Prio native library load skipped; already attempted with result=" + bVar2.a);
            }
            z = bVar2.a;
        }
        if (z) {
            try {
                bVar = b.g(PrioJni.createPackets(aVar.toByteArray()));
                d0 d0Var2 = xVar.a;
                ((q) d0Var2).a.a("Response Status: " + bVar.d().g());
                if (bVar.d().g() != e.c.OK) {
                    d0 d0Var3 = xVar.a;
                    ((q) d0Var3).a.g("Error when creating packets: " + bVar.d().f());
                }
            } catch (Exception unused) {
                e.c cVar = e.c.UNKNOWN_FAILURE;
                h2.copyOnWrite();
                e.c((e) h2.instance, cVar);
                h2.copyOnWrite();
                e.d((e) h2.instance, "Unable to parse responseBytes");
                ((q) xVar.a).a.g("Unable to parse responseBytes");
            }
        } else {
            e.c cVar2 = e.c.LIBRARY_UNAVAILABLE;
            h2.copyOnWrite();
            e.c((e) h2.instance, cVar2);
            h2.copyOnWrite();
            e.d((e) h2.instance, "Prio is not available.");
            ((q) xVar.a).a.c("Prio is not available.");
            b.C0089b f2 = b.f();
            f2.copyOnWrite();
            b.c((b) f2.instance, (e) h2.build());
            bVar = (b) f2.build();
        }
        Objects.requireNonNull(bVar, "Null createPacketsResponse");
        return new p(aVar, bVar, null);
    }
}
