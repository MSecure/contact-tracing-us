package h.a.j1;

import f.b.a.c.b.o.b;
import h.a.e;
import h.a.z;
import java.io.Closeable;
import java.net.SocketAddress;
import java.util.Arrays;
import java.util.concurrent.ScheduledExecutorService;

public interface x extends Closeable {

    public static final class a {
        public String a = "unknown-authority";
        public h.a.a b = h.a.a.b;
        public String c;

        /* renamed from: d  reason: collision with root package name */
        public z f3777d;

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.a.equals(aVar.a) && this.b.equals(aVar.b) && b.t0(this.c, aVar.c) && b.t0(this.f3777d, aVar.f3777d);
        }

        public int hashCode() {
            return Arrays.hashCode(new Object[]{this.a, this.b, this.c, this.f3777d});
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    z f(SocketAddress socketAddress, a aVar, e eVar);

    ScheduledExecutorService q();
}
