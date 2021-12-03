package h.a;

import f.b.a.c.b.o.b;
import f.b.b.a.k;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.Arrays;

public final class z extends x0 {

    /* renamed from: f  reason: collision with root package name */
    public static final /* synthetic */ int f4241f = 0;
    public final SocketAddress b;
    public final InetSocketAddress c;

    /* renamed from: d  reason: collision with root package name */
    public final String f4242d;

    /* renamed from: e  reason: collision with root package name */
    public final String f4243e;

    public z(SocketAddress socketAddress, InetSocketAddress inetSocketAddress, String str, String str2, a aVar) {
        b.z(socketAddress, "proxyAddress");
        b.z(inetSocketAddress, "targetAddress");
        if (socketAddress instanceof InetSocketAddress) {
            b.G(!((InetSocketAddress) socketAddress).isUnresolved(), "The proxy address %s is not resolved", socketAddress);
        }
        this.b = socketAddress;
        this.c = inetSocketAddress;
        this.f4242d = str;
        this.f4243e = str2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof z)) {
            return false;
        }
        z zVar = (z) obj;
        return b.m0(this.b, zVar.b) && b.m0(this.c, zVar.c) && b.m0(this.f4242d, zVar.f4242d) && b.m0(this.f4243e, zVar.f4243e);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.b, this.c, this.f4242d, this.f4243e});
    }

    public String toString() {
        k q1 = b.q1(this);
        q1.d("proxyAddr", this.b);
        q1.d("targetAddr", this.c);
        q1.d("username", this.f4242d);
        q1.c("hasPassword", this.f4243e != null);
        return q1.toString();
    }
}
