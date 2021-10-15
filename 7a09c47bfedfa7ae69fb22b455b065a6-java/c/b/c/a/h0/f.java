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
        public final Map<Integer, c> f4835a;

        /* renamed from: b  reason: collision with root package name */
        public final int f4836b;

        public b(p pVar, a aVar) {
            if (!pVar.b().isEmpty()) {
                p.a<P> aVar2 = pVar.f5215b;
                if (aVar2 != null) {
                    this.f4836b = aVar2.f5221e;
                    List<p.a> b2 = pVar.b();
                    HashMap hashMap = new HashMap();
                    for (p.a aVar3 : b2) {
                        if (!aVar3.f5220d.equals(f1.RAW)) {
                            StringBuilder h = c.a.a.a.a.h("Key ");
                            h.append(aVar3.f5221e);
                            h.append(" has non raw prefix type");
                            throw new GeneralSecurityException(h.toString());
                        } else if (aVar3.f5217a.a().size() <= 1) {
                            hashMap.put(Integer.valueOf(aVar3.f5221e), aVar3.f5217a.a().get(Integer.valueOf(aVar3.f5217a.b())));
                        } else {
                            StringBuilder h2 = c.a.a.a.a.h("More PRFs than expected in KeyTypeManager for key ");
                            h2.append(aVar3.f5221e);
                            throw new GeneralSecurityException(h2.toString());
                        }
                    }
                    this.f4835a = Collections.unmodifiableMap(hashMap);
                    return;
                }
                throw new GeneralSecurityException("Primary key not set.");
            }
            throw new GeneralSecurityException("No primitives provided.");
        }

        @Override // c.b.c.a.h0.e
        public Map<Integer, c> a() {
            return this.f4835a;
        }

        @Override // c.b.c.a.h0.e
        public int b() {
            return this.f4836b;
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
