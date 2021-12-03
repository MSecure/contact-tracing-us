package h.a;

import f.b.a.c.b.o.b;
import f.b.b.a.k;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.Arrays;

public final class z extends x0 {

    /* renamed from: f  reason: collision with root package name */
    public static final /* synthetic */ int f4306f = 0;
    public final SocketAddress b;
    public final InetSocketAddress c;

    /* renamed from: d  reason: collision with root package name */
    public final String f4307d;

    /* renamed from: e  reason: collision with root package name */
    public final String f4308e;

    public z(SocketAddress socketAddress, InetSocketAddress inetSocketAddress, String str, String str2, a aVar) {
        b.z(socketAddress, "proxyAddress");
        b.z(inetSocketAddress, "targetAddress");
        if (socketAddress instanceof InetSocketAddress) {
            b.G(!((InetSocketAddress) socketAddress).isUnresolved(), "The proxy address %s is not resolved", socketAddress);
        }
        this.b = socketAddress;
        this.c = inetSocketAddress;
        this.f4307d = str;
        this.f4308e = str2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof z)) {
            return false;
        }
        z zVar = (z) obj;
        return b.m0(this.b, zVar.b) && b.m0(this.c, zVar.c) && b.m0(this.f4307d, zVar.f4307d) && b.m0(this.f4308e, zVar.f4308e);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.b, this.c, this.f4307d, this.f4308e});
    }

    public String toString() {
        k t1 = b.t1(this);
        t1.d("proxyAddr", this.b);
        t1.d("targetAddr", this.c);
        t1.d("username", this.f4307d);
        t1.c("hasPassword", this.f4308e != null);
        return t1.toString();
    }
}
