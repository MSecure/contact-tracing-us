package h.a;

import f.b.a.c.b.o.b;
import f.b.b.a.k;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.Arrays;

public final class z extends x0 {

    /* renamed from: f  reason: collision with root package name */
    public static final /* synthetic */ int f4087f = 0;
    public final SocketAddress b;
    public final InetSocketAddress c;

    /* renamed from: d  reason: collision with root package name */
    public final String f4088d;

    /* renamed from: e  reason: collision with root package name */
    public final String f4089e;

    public z(SocketAddress socketAddress, InetSocketAddress inetSocketAddress, String str, String str2, a aVar) {
        b.A(socketAddress, "proxyAddress");
        b.A(inetSocketAddress, "targetAddress");
        if (socketAddress instanceof InetSocketAddress) {
            b.H(!((InetSocketAddress) socketAddress).isUnresolved(), "The proxy address %s is not resolved", socketAddress);
        }
        this.b = socketAddress;
        this.c = inetSocketAddress;
        this.f4088d = str;
        this.f4089e = str2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof z)) {
            return false;
        }
        z zVar = (z) obj;
        return b.t0(this.b, zVar.b) && b.t0(this.c, zVar.c) && b.t0(this.f4088d, zVar.f4088d) && b.t0(this.f4089e, zVar.f4089e);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.b, this.c, this.f4088d, this.f4089e});
    }

    public String toString() {
        k T1 = b.T1(this);
        T1.d("proxyAddr", this.b);
        T1.d("targetAddr", this.c);
        T1.d("username", this.f4088d);
        T1.c("hasPassword", this.f4089e != null);
        return T1.toString();
    }
}
