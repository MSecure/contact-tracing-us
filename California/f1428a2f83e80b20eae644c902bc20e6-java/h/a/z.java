package h.a;

import f.b.a.c.b.o.b;
import f.b.b.a.k;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.Arrays;

public final class z extends x0 {

    /* renamed from: f  reason: collision with root package name */
    public static final /* synthetic */ int f3983f = 0;
    public final SocketAddress b;
    public final InetSocketAddress c;

    /* renamed from: d  reason: collision with root package name */
    public final String f3984d;

    /* renamed from: e  reason: collision with root package name */
    public final String f3985e;

    public z(SocketAddress socketAddress, InetSocketAddress inetSocketAddress, String str, String str2, a aVar) {
        b.A(socketAddress, "proxyAddress");
        b.A(inetSocketAddress, "targetAddress");
        if (socketAddress instanceof InetSocketAddress) {
            b.H(!((InetSocketAddress) socketAddress).isUnresolved(), "The proxy address %s is not resolved", socketAddress);
        }
        this.b = socketAddress;
        this.c = inetSocketAddress;
        this.f3984d = str;
        this.f3985e = str2;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof z)) {
            return false;
        }
        z zVar = (z) obj;
        return b.t0(this.b, zVar.b) && b.t0(this.c, zVar.c) && b.t0(this.f3984d, zVar.f3984d) && b.t0(this.f3985e, zVar.f3985e);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.b, this.c, this.f3984d, this.f3985e});
    }

    public String toString() {
        k U1 = b.U1(this);
        U1.d("proxyAddr", this.b);
        U1.d("targetAddr", this.c);
        U1.d("username", this.f3984d);
        U1.c("hasPassword", this.f3985e != null);
        return U1.toString();
    }
}
