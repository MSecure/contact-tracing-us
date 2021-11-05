package c.b.c.a.h0;

import c.b.c.a.i0.f1;
import c.b.c.a.p;
import c.b.c.a.q;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class f implements q<e> {

    public static class b extends e {

        /* renamed from: a  reason: collision with root package name */
        public final Map<Integer, c> f3482a;

        /* renamed from: b  reason: collision with root package name */
        public final int f3483b;

        public b(p pVar, a aVar) {
            if (!pVar.b().isEmpty()) {
                p.a<P> aVar2 = pVar.f3814b;
                if (aVar2 != null) {
                    this.f3483b = aVar2.f3820e;
                    List<p.a> b2 = pVar.b();
                    HashMap hashMap = new HashMap();
                    for (p.a aVar3 : b2) {
                        if (!aVar3.f3819d.equals(f1.RAW)) {
                            StringBuilder g = c.a.a.a.a.g("Key ");
                            g.append(aVar3.f3820e);
                            g.append(" has non raw prefix type");
                            throw new GeneralSecurityException(g.toString());
                        } else if (aVar3.f3816a.a().size() <= 1) {
                            hashMap.put(Integer.valueOf(aVar3.f3820e), aVar3.f3816a.a().get(Integer.valueOf(aVar3.f3816a.b())));
                        } else {
                            StringBuilder g2 = c.a.a.a.a.g("More PRFs than expected in KeyTypeManager for key ");
                            g2.append(aVar3.f3820e);
                            throw new GeneralSecurityException(g2.toString());
                        }
                    }
                    this.f3482a = Collections.unmodifiableMap(hashMap);
                    return;
                }
                throw new GeneralSecurityException("Primary key not set.");
            }
            throw new GeneralSecurityException("No primitives provided.");
        }

        @Override // c.b.c.a.h0.e
        public Map<Integer, c> a() {
            return this.f3482a;
        }

        @Override // c.b.c.a.h0.e
        public int b() {
            return this.f3483b;
        }
    }

    @Override // c.b.c.a.q
    public Class<e> a() {
        return e.class;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [c.b.c.a.p] */
    @Override // c.b.c.a.q
    public e b(p<e> pVar) {
        return new b(pVar, null);
    }
}
