package f.b.a.a.a.n;

import android.database.Cursor;
import com.google.android.apps.exposurenotification.nearby.ProvideDiagnosisKeysWorker;
import e.b.a.m;
import e.t.p.b;
import f.b.a.a.a.k.g;
import f.b.a.a.a.k.h;
import f.b.a.a.a.k.k;
import f.b.a.a.a.k.n;
import f.b.a.a.a.u.d;
import f.b.a.a.a.w.o;
import f.b.a.a.a.w.p;
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
        n nVar = this.a.f355e;
        Objects.requireNonNull(nVar);
        a<Object> aVar = c.c;
        c.a aVar2 = new c.a();
        aVar2.c(nVar.f2081d);
        d dVar = nVar.b;
        dVar.a();
        int i2 = e.f2881d;
        e.a aVar3 = new e.a();
        f.b.a.a.a.w.r rVar = dVar.b;
        l.b.a.d v = dVar.c.b().v(l.b.a.c.e(14));
        o oVar = rVar.a;
        long D = v.D();
        p pVar = (p) oVar;
        Objects.requireNonNull(pVar);
        e.t.i v2 = e.t.i.v("SELECT countryCode FROM CountryEntity WHERE lastSeenTimestampMillis >= ?", 1);
        v2.A(1, D);
        pVar.a.b();
        Cursor b = b.b(pVar.a, v2, false, null);
        try {
            ArrayList arrayList = new ArrayList(b.getCount());
            while (b.moveToNext()) {
                arrayList.add(b.getString(0));
            }
            b.close();
            v2.V();
            aVar3.d(arrayList);
            aVar3.f(dVar.f2250d);
            int i3 = aVar3.b;
            if (i3 == 0) {
                eVar = f.b.b.b.i.f2899j;
            } else if (i3 != 1) {
                eVar = e.p(i3, aVar3.a);
                aVar3.b = eVar.size();
                aVar3.c = true;
            } else {
                eVar = new j(aVar3.a[0]);
            }
            for (String str : eVar.h()) {
                if (nVar.f2082e.containsKey(str)) {
                    aVar2.d(nVar.f2082e.get(str));
                }
            }
            f.b.a.a.a.k.r rVar2 = nVar.c;
            c<f.b.a.a.a.k.o> f2 = aVar2.f();
            Objects.requireNonNull(rVar2);
            f2.size();
            ArrayList arrayList2 = new ArrayList();
            for (f.b.a.a.a.k.o oVar2 : f2) {
                arrayList2.add(l.x(m.h.f0(new g(rVar2, oVar2))).y(new h(rVar2, oVar2), rVar2.f2091d));
            }
            l A = l.x(l.x(new j.a(c.r(arrayList2), true)).y(k.a, rVar2.f2092e)).z(new f.b.a.a.a.k.c(nVar), nVar.f2084g).A(n.o.q(), TimeUnit.MILLISECONDS, nVar.f2086i);
            f.b.a.c.b.o.b.g(A, nVar.f2089l, nVar.f2084g);
            return A;
        } catch (Throwable th) {
            b.close();
            v2.V();
            throw th;
        }
    }
}
