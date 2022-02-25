package f.b.a.a.a.r;

import android.util.Log;
import f.a.a.a.a;
import f.b.a.a.a.s.c;
import f.b.b.a.g;
import java.util.List;
import java.util.Objects;

public final /* synthetic */ class j implements g {
    public final /* synthetic */ z a;
    public final /* synthetic */ double b;
    public final /* synthetic */ a0 c;

    public /* synthetic */ j(z zVar, double d2, a0 a0Var) {
        this.a = zVar;
        this.b = d2;
        this.c = a0Var;
    }

    @Override // f.b.b.a.g
    public final Object a(Object obj) {
        z zVar = this.a;
        double d2 = this.b;
        a0 a0Var = this.c;
        List list = (List) obj;
        Objects.requireNonNull(zVar);
        String k2 = a0Var.k();
        String d3 = a0Var.d();
        f.b.a.a.a.s.g gVar = (f.b.a.a.a.s.g) f.b.a.a.a.s.g.newBuilder().setBins(list.size()).setEpsilon(d2).setNumberServers(2).setPrime(4293918721L).build();
        StringBuilder h2 = a.h("Generating packets w/ params: bins=");
        h2.append(gVar.getBins());
        h2.append(" epsilon=");
        h2.append(gVar.getEpsilon());
        Log.i("PrioSubmitter", h2.toString());
        if (gVar.hasHammingWeight()) {
            StringBuilder h3 = a.h("Hamming weight specified =");
            h3.append(gVar.getHammingWeight());
            Log.i("PrioSubmitter", h3.toString());
        }
        c.b newBuilder = c.newBuilder();
        newBuilder.addAllDataBits(list);
        newBuilder.setPrioParameters(gVar);
        newBuilder.addPublicKeys(k2);
        newBuilder.addPublicKeys(d3);
        return (c) newBuilder.build();
    }
}
