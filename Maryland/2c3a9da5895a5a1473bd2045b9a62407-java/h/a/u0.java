package h.a;

import h.a.q0;
import java.net.URI;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.logging.Logger;

public final class u0 {

    /* renamed from: d  reason: collision with root package name */
    public static final Logger f4083d = Logger.getLogger(u0.class.getName());

    /* renamed from: e  reason: collision with root package name */
    public static u0 f4084e;
    public final q0.c a = new a(null);
    public final LinkedHashSet<s0> b = new LinkedHashSet<>();
    public List<s0> c = Collections.emptyList();

    public final class a extends q0.c {
        public a(t0 t0Var) {
        }

        @Override // h.a.q0.c
        public String a() {
            List<s0> list;
            u0 u0Var = u0.this;
            synchronized (u0Var) {
                list = u0Var.c;
            }
            return list.isEmpty() ? "unknown" : list.get(0).a();
        }

        @Override // h.a.q0.c
        public q0 b(URI uri, q0.a aVar) {
            List<s0> list;
            u0 u0Var = u0.this;
            synchronized (u0Var) {
                list = u0Var.c;
            }
            for (s0 s0Var : list) {
                q0 b = s0Var.b(uri, aVar);
                if (b != null) {
                    return b;
                }
            }
            return null;
        }
    }

    public static final class b implements b1<s0> {
        public b(t0 t0Var) {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // h.a.b1
        public int a(s0 s0Var) {
            return s0Var.d();
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // h.a.b1
        public boolean b(s0 s0Var) {
            return s0Var.c();
        }
    }
}
