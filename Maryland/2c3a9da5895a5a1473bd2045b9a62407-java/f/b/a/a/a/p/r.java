package f.b.a.a.a.p;

import android.database.Cursor;
import com.google.android.apps.exposurenotification.nearby.ProvideDiagnosisKeysWorker;
import e.b.a.m;
import e.t.p.b;
import f.b.a.a.a.m.g;
import f.b.a.a.a.m.h;
import f.b.a.a.a.m.k;
import f.b.a.a.a.m.n;
import f.b.a.a.a.m.o;
import f.b.a.a.a.w.d;
import f.b.a.a.a.y.p;
import f.b.a.a.a.y.q;
import f.b.a.a.a.y.s;
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

public final /* synthetic */ class r implements i {
    public final /* synthetic */ ProvideDiagnosisKeysWorker a;

    public /* synthetic */ r(ProvideDiagnosisKeysWorker provideDiagnosisKeysWorker) {
        this.a = provideDiagnosisKeysWorker;
    }

    /* JADX INFO: finally extract failed */
    @Override // f.b.b.f.a.i
    public final u a(Object obj) {
        e eVar;
        Void r10 = (Void) obj;
        n nVar = this.a.f365e;
        Objects.requireNonNull(nVar);
        a<Object> aVar = c.c;
        c.a aVar2 = new c.a();
        aVar2.c(nVar.f2161d);
        d dVar = nVar.b;
        dVar.a();
        int i2 = e.f2977d;
        e.a aVar3 = new e.a();
        s sVar = dVar.b;
        l.b.a.d w = dVar.c.b().w(l.b.a.c.e(14));
        p pVar = sVar.a;
        long E = w.E();
        q qVar = (q) pVar;
        Objects.requireNonNull(qVar);
        e.t.i v = e.t.i.v("SELECT countryCode FROM CountryEntity WHERE lastSeenTimestampMillis >= ?", 1);
        v.A(1, E);
        qVar.a.b();
        Cursor b = b.b(qVar.a, v, false, null);
        try {
            ArrayList arrayList = new ArrayList(b.getCount());
            while (b.moveToNext()) {
                arrayList.add(b.getString(0));
            }
            b.close();
            v.V();
            aVar3.d(arrayList);
            aVar3.f(dVar.f2327d);
            int i3 = aVar3.b;
            if (i3 == 0) {
                eVar = f.b.b.b.i.f2995j;
            } else if (i3 != 1) {
                eVar = e.p(i3, aVar3.a);
                aVar3.b = eVar.size();
                aVar3.c = true;
            } else {
                eVar = new j(aVar3.a[0]);
            }
            for (String str : eVar.h()) {
                if (nVar.f2162e.containsKey(str)) {
                    aVar2.d(nVar.f2162e.get(str));
                }
            }
            f.b.a.a.a.m.r rVar = nVar.c;
            c<o> f2 = aVar2.f();
            Objects.requireNonNull(rVar);
            f2.size();
            ArrayList arrayList2 = new ArrayList();
            for (o oVar : f2) {
                arrayList2.add(l.x(m.h.f0(new g(rVar, oVar))).y(new h(rVar, oVar), rVar.f2171d));
            }
            l A = l.x(l.x(new j.a(c.r(arrayList2), true)).y(k.a, rVar.f2172e)).z(new f.b.a.a.a.m.c(nVar), nVar.f2164g).A(n.o.r(), TimeUnit.MILLISECONDS, nVar.f2166i);
            f.b.a.c.b.o.b.g(A, nVar.f2169l, nVar.f2164g);
            return A;
        } catch (Throwable th) {
            b.close();
            v.V();
            throw th;
        }
    }
}
