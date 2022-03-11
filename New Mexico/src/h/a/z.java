package h.a;

import f.b.a.c.b.o.b;
import f.b.b.a.k;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.Arrays;
/* loaded from: classes.dex */
public final class z extends x0 {

    /* renamed from: f  reason: collision with root package name */
    public static final /* synthetic */ int f4561f = 0;
    public final SocketAddress b;
    public final InetSocketAddress c;

    /* renamed from: d  reason: collision with root package name */
    public final String f4562d;

    /* renamed from: e  reason: collision with root package name */
    public final String f4563e;

    public z(SocketAddress socketAddress, InetSocketAddress inetSocketAddress, String str, String str2, a aVar) {
        b.A(socketAddress, "proxyAddress");
        b.A(inetSocketAddress, "targetAddress");
        if (socketAddress instanceof InetSocketAddress) {
            b.H(!((InetSocketAddress) socketAddress).isUnresolved(), "The proxy address %s is not resolved", socketAddress);
        }
        this.b = socketAddress;
        this.c = inetSocketAddress;
        this.f4562d = str;
        this.f4563e = str2;
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (!(obj instanceof z)) {
            return false;
        }
        z zVar = (z) obj;
        return b.n0(this.b, zVar.b) && b.n0(this.c, zVar.c) && b.n0(this.f4562d, zVar.f4562d) && b.n0(this.f4563e, zVar.f4563e);
    }

    @Override // java.lang.Object
    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.b, this.c, this.f4562d, this.f4563e});
    }

    @Override // java.lang.Object
    public String toString() {
        k u1 = b.u1(this);
        u1.d("proxyAddr", this.b);
        u1.d("targetAddr", this.c);
        u1.d("username", this.f4562d);
        u1.c("hasPassword", this.f4563e != null);
        return u1.toString();
    }
}
