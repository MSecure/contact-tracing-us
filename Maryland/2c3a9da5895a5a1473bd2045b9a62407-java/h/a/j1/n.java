package h.a.j1;

import f.b.a.c.b.o.b;
import h.a.b0;
import h.a.d0;
import h.a.e;
import java.text.MessageFormat;
import java.util.Collection;
import java.util.logging.Level;

public final class n extends e {
    public final o a;
    public final z2 b;

    public n(o oVar, z2 z2Var) {
        b.A(oVar, "tracer");
        this.a = oVar;
        b.A(z2Var, "time");
        this.b = z2Var;
    }

    public static Level d(e.a aVar) {
        int ordinal = aVar.ordinal();
        return ordinal != 2 ? ordinal != 3 ? Level.FINEST : Level.FINE : Level.FINER;
    }

    @Override // h.a.e
    public void a(e.a aVar, String str) {
        d0 d0Var = this.a.b;
        Level d2 = d(aVar);
        if (o.f3792e.isLoggable(d2)) {
            o.a(d0Var, d2, str);
        }
        if (c(aVar) && aVar != e.a.DEBUG) {
            o oVar = this.a;
            int ordinal = aVar.ordinal();
            b0.a aVar2 = ordinal != 2 ? ordinal != 3 ? b0.a.CT_INFO : b0.a.CT_ERROR : b0.a.CT_WARNING;
            Long valueOf = Long.valueOf(this.b.a());
            b.A(str, "description");
            b.A(aVar2, "severity");
            b.A(valueOf, "timestampNanos");
            b.G(true, "at least one of channelRef and subchannelRef must be null");
            b0 b0Var = new b0(str, aVar2, valueOf.longValue(), null, null, null);
            synchronized (oVar.a) {
                Collection<b0> collection = oVar.c;
                if (collection != null) {
                    collection.add(b0Var);
                }
            }
        }
    }

    @Override // h.a.e
    public void b(e.a aVar, String str, Object... objArr) {
        a(aVar, (c(aVar) || o.f3792e.isLoggable(d(aVar))) ? MessageFormat.format(str, objArr) : null);
    }

    public final boolean c(e.a aVar) {
        boolean z;
        if (aVar != e.a.DEBUG) {
            o oVar = this.a;
            synchronized (oVar.a) {
                z = oVar.c != null;
            }
            if (z) {
                return true;
            }
        }
        return false;
    }
}
