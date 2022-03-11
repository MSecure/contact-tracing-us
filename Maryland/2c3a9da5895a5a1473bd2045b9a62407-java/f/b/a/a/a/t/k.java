package f.b.a.a.a.t;

import android.util.Log;
import f.a.a.a.a;
import f.b.a.a.a.u.c;
import f.b.b.a.g;
import java.util.List;
import java.util.Objects;

public final /* synthetic */ class k implements g {
    public final /* synthetic */ a0 a;
    public final /* synthetic */ double b;
    public final /* synthetic */ b0 c;

    public /* synthetic */ k(a0 a0Var, double d2, b0 b0Var) {
        this.a = a0Var;
        this.b = d2;
        this.c = b0Var;
    }

    @Override // f.b.b.a.g
    public final Object a(Object obj) {
        a0 a0Var = this.a;
        double d2 = this.b;
        b0 b0Var = this.c;
        List list = (List) obj;
        Objects.requireNonNull(a0Var);
        String o = b0Var.o();
        String f2 = b0Var.f();
        f.b.a.a.a.u.g gVar = (f.b.a.a.a.u.g) f.b.a.a.a.u.g.newBuilder().setBins(list.size()).setEpsilon(d2).setNumberServers(2).setPrime(4293918721L).build();
        StringBuilder h2 = a.h("Generating packets w/ params: bins=");
        h2.append(gVar.getBins());
        h2.append(" epsilon=");
        h2.append(gVar.getEpsilon());
        Log.i("PrioSubmitter", h2.toString());
        c.b newBuilder = c.newBuilder();
        newBuilder.addAllDataBits(list);
        newBuilder.setPrioParameters(gVar);
        newBuilder.addPublicKeys(o);
        newBuilder.addPublicKeys(f2);
        return (c) newBuilder.build();
    }
}
