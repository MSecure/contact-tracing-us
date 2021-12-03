package f.b.c.k.s;

import f.a.a.a.a;
import f.b.a.c.b.o.b;
import f.b.c.k.s.i;
import f.b.c.k.u.f;
import f.b.c.k.u.h;
import f.b.c.k.u.o;
import f.b.d.a.s;
import java.util.ArrayList;
import java.util.List;

public class q extends h {

    /* renamed from: d  reason: collision with root package name */
    public final List<f> f3249d;

    /* JADX WARNING: Illegal instructions before constructor call */
    public q(h hVar, s sVar) {
        super(hVar, r0, sVar);
        i.a aVar = i.a.IN;
        ArrayList arrayList = new ArrayList();
        this.f3249d = arrayList;
        arrayList.addAll(c(aVar, sVar));
    }

    public static List<f> c(i.a aVar, s sVar) {
        b.M0(aVar == i.a.IN || aVar == i.a.NOT_IN, "extractDocumentKeysFromArrayValue requires IN or NOT_IN operators", new Object[0]);
        b.M0(o.d(sVar), "KeyFieldInFilter/KeyFieldNotInFilter expects an ArrayValue", new Object[0]);
        ArrayList arrayList = new ArrayList();
        for (s sVar2 : sVar.n().a()) {
            b.M0(o.i(sVar2), a.f(a.i("Comparing on key with "), aVar.b, ", but an array value was not a ReferenceValue"), new Object[0]);
            arrayList.add(f.b(sVar2.v()));
        }
        return arrayList;
    }
}
