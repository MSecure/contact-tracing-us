package f.b.a.a.a.q;

import android.database.Cursor;
import com.google.android.apps.exposurenotification.nearby.ProvideDiagnosisKeysWorker;
import e.b.a.m;
import e.t.p.b;
import f.b.a.a.a.b0.r;
import f.b.a.a.a.b0.s;
import f.b.a.a.a.n.g;
import f.b.a.a.a.n.h;
import f.b.a.a.a.n.k;
import f.b.a.a.a.n.n;
import f.b.a.a.a.n.o;
import f.b.a.a.a.y.d;
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
        n nVar = this.a.f374e;
        Objects.requireNonNull(nVar);
        a<Object> aVar = c.c;
        c.a aVar2 = new c.a();
        aVar2.c(nVar.f2256d);
        d dVar = nVar.b;
        dVar.a();
        int i2 = e.f3071d;
        e.a aVar3 = new e.a();
        f.b.a.a.a.b0.u uVar = dVar.b;
        l.b.a.e w = dVar.c.c().w(l.b.a.d.f(14));
        r rVar = uVar.a;
        long G = w.G();
        s sVar = (s) rVar;
        Objects.requireNonNull(sVar);
        e.t.i t = e.t.i.t("SELECT countryCode FROM CountryEntity WHERE lastSeenTimestampMillis >= ?", 1);
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
            aVar3.f(dVar.f2464d);
            int i3 = aVar3.b;
            if (i3 == 0) {
                eVar = f.b.b.b.i.f3089j;
            } else if (i3 != 1) {
                eVar = e.p(i3, aVar3.a);
                aVar3.b = eVar.size();
                aVar3.c = true;
            } else {
                eVar = new j(aVar3.a[0]);
            }
            for (String str : eVar.h()) {
                if (nVar.f2257e.containsKey(str)) {
                    aVar2.d(nVar.f2257e.get(str));
                }
            }
            f.b.a.a.a.n.r rVar2 = nVar.c;
            c<o> f2 = aVar2.f();
            Objects.requireNonNull(rVar2);
            f.b.a.a.a.i.e0.a aVar4 = f.b.a.a.a.n.r.f2265f;
            StringBuilder i4 = f.a.a.a.a.i("Getting download URIs for ");
            i4.append(f2.size());
            i4.append(" servers.");
            aVar4.a(i4.toString());
            ArrayList arrayList2 = new ArrayList();
            for (o oVar : f2) {
                arrayList2.add(l.x(m.h.h0(new g(rVar2, oVar))).y(new h(rVar2, oVar), rVar2.f2267d));
            }
            l A = l.x(l.x(new j.a(c.r(arrayList2), true)).y(k.a, rVar2.f2268e)).z(new f.b.a.a.a.n.c(nVar), nVar.f2259g).A(n.p.t(), TimeUnit.MILLISECONDS, nVar.f2261i);
            f.b.a.c.b.o.b.g(A, nVar.f2264l, nVar.f2259g);
            return A;
        } catch (Throwable th) {
            b.close();
            t.Q();
            throw th;
        }
    }
}
