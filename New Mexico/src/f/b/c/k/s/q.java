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
/* loaded from: classes.dex */
public class q extends h {

    /* renamed from: d */
    public final List<f> f3567d;

    /* JADX WARN: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public q(h hVar, s sVar) {
        super(hVar, r0, sVar);
        i.a aVar = i.a.IN;
        ArrayList arrayList = new ArrayList();
        this.f3567d = arrayList;
        arrayList.addAll(c(aVar, sVar));
    }

    public static List<f> c(i.a aVar, s sVar) {
        b.P0(aVar == i.a.IN || aVar == i.a.NOT_IN, "extractDocumentKeysFromArrayValue requires IN or NOT_IN operators", new Object[0]);
        b.P0(o.d(sVar), "KeyFieldInFilter/KeyFieldNotInFilter expects an ArrayValue", new Object[0]);
        ArrayList arrayList = new ArrayList();
        for (s sVar2 : sVar.n().a()) {
            b.P0(o.i(sVar2), a.e(a.h("Comparing on key with "), aVar.b, ", but an array value was not a ReferenceValue"), new Object[0]);
            arrayList.add(f.b(sVar2.v()));
        }
        return arrayList;
    }
}
