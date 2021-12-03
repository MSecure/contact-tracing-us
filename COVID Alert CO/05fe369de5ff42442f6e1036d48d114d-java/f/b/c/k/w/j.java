package f.b.c.k.w;

import android.content.Context;
import f.b.c.k.g;
import f.b.c.k.r.a;
import f.b.c.k.s.e;
import f.b.c.k.x.c;
import h.a.c1;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class j {

    /* renamed from: d  reason: collision with root package name */
    public static final Set<String> f3338d = new HashSet(Arrays.asList("date", "x-google-backends", "x-google-netmon-label", "x-google-service", "x-google-gfe-request-trace"));
    public final h0 a;
    public final c b;
    public final t c;

    public j(e eVar, c cVar, a aVar, Context context, c0 c0Var) {
        this.b = cVar;
        this.a = new h0(eVar.a);
        this.c = new t(cVar, context, aVar, eVar, c0Var);
    }

    public static boolean a(c1 c1Var) {
        g.a aVar = g.a.t.get(c1Var.a.b, g.a.UNKNOWN);
        switch (aVar.ordinal()) {
            case 0:
                throw new IllegalArgumentException("Treated status OK as error");
            case 1:
            case 2:
            case 4:
            case 8:
            case 13:
            case 14:
            case 16:
                return false;
            case 3:
            case 5:
            case 6:
            case 7:
            case 9:
            case 10:
            case 11:
            case 12:
            case 15:
                return true;
            default:
                throw new IllegalArgumentException("Unknown gRPC status code: " + aVar);
        }
    }
}
