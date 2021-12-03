package f.b.a.a.a.b0;

import android.database.Cursor;
import com.google.android.apps.exposurenotification.nearby.ProvideDiagnosisKeysWorker;
import e.b.a.m;
import e.u.p.b;
import f.b.a.a.a.l0.r;
import f.b.a.a.a.l0.s;
import f.b.a.a.a.x.g;
import f.b.a.a.a.x.h;
import f.b.a.a.a.x.k;
import f.b.a.a.a.x.n;
import f.b.a.a.a.x.o;
import f.b.b.b.a;
import f.b.b.b.c;
import f.b.b.b.e;
import f.b.b.b.j;
import f.b.b.f.a.i;
import f.b.b.f.a.j;
import f.b.b.f.a.l;
import f.b.b.f.a.u;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import l.b.a.d;

public final /* synthetic */ class e0 implements i {
    public final /* synthetic */ ProvideDiagnosisKeysWorker a;

    public /* synthetic */ e0(ProvideDiagnosisKeysWorker provideDiagnosisKeysWorker) {
        this.a = provideDiagnosisKeysWorker;
    }

    /* JADX INFO: finally extract failed */
    @Override // f.b.b.f.a.i
    public final u a(Object obj) {
        e eVar;
        Void r10 = (Void) obj;
        n nVar = this.a.f376g;
        Objects.requireNonNull(nVar);
        a<Object> aVar = c.c;
        c.a aVar2 = new c.a();
        aVar2.c(nVar.f2448d);
        f.b.a.a.a.i0.c cVar = nVar.b;
        cVar.a();
        int i2 = e.f3134d;
        e.a aVar3 = new e.a();
        f.b.a.a.a.l0.u uVar = cVar.b;
        l.b.a.e w = cVar.c.c().w(d.f(14));
        r rVar = uVar.a;
        long G = w.G();
        s sVar = (s) rVar;
        Objects.requireNonNull(sVar);
        e.u.i t = e.u.i.t("SELECT countryCode FROM CountryEntity WHERE lastSeenTimestampMillis >= ?", 1);
        t.x(1, G);
        sVar.a.b();
        Cursor b = b.b(sVar.a, t, false, null);
        try {
            ArrayList arrayList = new ArrayList(b.getCount());
            while (b.moveToNext()) {
                arrayList.add(b.getString(0));
            }
            b.close();
            t.Q();
            aVar3.d(arrayList);
            aVar3.f(cVar.f2255d);
            int i3 = aVar3.b;
            if (i3 == 0) {
                eVar = f.b.b.b.i.f3152j;
            } else if (i3 != 1) {
                eVar = e.p(i3, aVar3.a);
                aVar3.b = eVar.size();
                aVar3.c = true;
            } else {
                eVar = new j(aVar3.a[0]);
            }
            for (String str : eVar.h()) {
                if (nVar.f2449e.containsKey(str)) {
                    aVar2.d(nVar.f2449e.get(str));
                }
            }
            f.b.a.a.a.x.r rVar2 = nVar.c;
            c<o> f2 = aVar2.f();
            Objects.requireNonNull(rVar2);
            f.b.a.a.a.s.d0.a aVar4 = f.b.a.a.a.x.r.f2457f;
            StringBuilder h2 = f.a.a.a.a.h("Getting download URIs for ");
            h2.append(f2.size());
            h2.append(" servers.");
            aVar4.a(h2.toString());
            ArrayList arrayList2 = new ArrayList();
            for (o oVar : f2) {
                arrayList2.add(l.x(m.e.l0(new g(rVar2, oVar))).y(new h(rVar2, oVar), rVar2.f2459d));
            }
            l A = l.x(l.x(new j.a(c.r(arrayList2), true)).y(k.a, rVar2.f2460e)).z(new f.b.a.a.a.x.c(nVar), nVar.f2451g).A(n.p.t(), TimeUnit.MILLISECONDS, nVar.f2453i);
            f.b.a.c.b.o.b.g(A, nVar.f2456l, nVar.f2451g);
            return A;
        } catch (Throwable th) {
            b.close();
            t.Q();
            throw th;
        }
    }
}
