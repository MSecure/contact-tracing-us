package h.a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class m0 {
    public static final Iterable<Class<?>> a;
    public static final m0 b;

    public class a implements b1<m0> {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // h.a.b1
        public int a(m0 m0Var) {
            return m0Var.c();
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // h.a.b1
        public boolean b(m0 m0Var) {
            return m0Var.b();
        }
    }

    public static final class b implements Iterable<Class<?>> {
        public b(a aVar) {
        }

        @Override // java.lang.Iterable
        public Iterator<Class<?>> iterator() {
            ArrayList arrayList = new ArrayList();
            try {
                arrayList.add(Class.forName("h.a.k1.e"));
            } catch (ClassNotFoundException unused) {
            }
            try {
                arrayList.add(Class.forName("io.grpc.netty.NettyChannelProvider"));
            } catch (ClassNotFoundException unused2) {
            }
            return arrayList.iterator();
        }
    }

    public static final class c extends RuntimeException {
        public c(String str) {
            super(str);
        }
    }

    static {
        Object obj = null;
        b bVar = new b(null);
        a = bVar;
        List q = g.b.a.c.c.c.q(m0.class, bVar, m0.class.getClassLoader(), new a());
        if (!q.isEmpty()) {
            obj = q.get(0);
        }
        b = (m0) obj;
    }

    public abstract l0<?> a(String str);

    public abstract boolean b();

    public abstract int c();
}
