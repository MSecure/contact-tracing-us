package h.a.k1;

import f.b.a.c.b.o.b;
import h.a.k1.p.e;
import h.a.k1.p.i;
import h.a.k1.p.j;
import h.a.k1.p.l;
import java.net.Socket;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLSocket;

public class i {
    public static final Logger b = Logger.getLogger(i.class.getName());
    public static final h.a.k1.p.i c = h.a.k1.p.i.f3981d;

    /* renamed from: d  reason: collision with root package name */
    public static i f3952d;
    public final h.a.k1.p.i a;

    public static final class a extends i {

        /* renamed from: e  reason: collision with root package name */
        public static final e<Socket> f3953e = new e<>(null, "setUseSessionTickets", Boolean.TYPE);

        /* renamed from: f  reason: collision with root package name */
        public static final e<Socket> f3954f = new e<>(null, "setHostname", String.class);

        /* renamed from: g  reason: collision with root package name */
        public static final e<Socket> f3955g = new e<>(byte[].class, "getAlpnSelectedProtocol", new Class[0]);

        /* renamed from: h  reason: collision with root package name */
        public static final e<Socket> f3956h = new e<>(null, "setAlpnProtocols", byte[].class);

        /* renamed from: i  reason: collision with root package name */
        public static final e<Socket> f3957i = new e<>(byte[].class, "getNpnSelectedProtocol", new Class[0]);

        /* renamed from: j  reason: collision with root package name */
        public static final e<Socket> f3958j = new e<>(null, "setNpnProtocols", byte[].class);

        public a(h.a.k1.p.i iVar) {
            super(iVar);
        }

        @Override // h.a.k1.i
        public void a(SSLSocket sSLSocket, String str, List<j> list) {
            if (str != null) {
                f3953e.d(sSLSocket, Boolean.TRUE);
                f3954f.d(sSLSocket, str);
            }
            Object[] objArr = {h.a.k1.p.i.b(list)};
            if (this.a.e() == i.e.ALPN_AND_NPN) {
                f3956h.e(sSLSocket, objArr);
            }
            if (this.a.e() != i.e.NONE) {
                f3958j.e(sSLSocket, objArr);
                return;
            }
            throw new RuntimeException("We can not do TLS handshake on this Android version, please install the Google Play Services Dynamic Security Provider to use TLS");
        }

        @Override // h.a.k1.i
        public String b(SSLSocket sSLSocket) {
            if (this.a.e() == i.e.ALPN_AND_NPN) {
                try {
                    byte[] bArr = (byte[]) f3955g.e(sSLSocket, new Object[0]);
                    if (bArr != null) {
                        return new String(bArr, l.b);
                    }
                } catch (Exception e2) {
                    i.b.log(Level.FINE, "Failed calling getAlpnSelectedProtocol()", (Throwable) e2);
                }
            }
            if (this.a.e() == i.e.NONE) {
                return null;
            }
            try {
                byte[] bArr2 = (byte[]) f3957i.e(sSLSocket, new Object[0]);
                if (bArr2 != null) {
                    return new String(bArr2, l.b);
                }
                return null;
            } catch (Exception e3) {
                i.b.log(Level.FINE, "Failed calling getNpnSelectedProtocol()", (Throwable) e3);
                return null;
            }
        }

        @Override // h.a.k1.i
        public String c(SSLSocket sSLSocket, String str, List<j> list) {
            String b = b(sSLSocket);
            return b == null ? i.super.c(sSLSocket, str, list) : b;
        }
    }

    static {
        boolean z;
        ClassLoader classLoader = i.class.getClassLoader();
        try {
            classLoader.loadClass("com.android.org.conscrypt.OpenSSLSocketImpl");
        } catch (ClassNotFoundException e2) {
            b.log(Level.FINE, "Unable to find Conscrypt. Skipping", (Throwable) e2);
            try {
                classLoader.loadClass("org.apache.harmony.xnet.provider.jsse.OpenSSLSocketImpl");
            } catch (ClassNotFoundException e3) {
                b.log(Level.FINE, "Unable to find any OpenSSLSocketImpl. Skipping", (Throwable) e3);
                z = false;
            }
        }
        z = true;
        f3952d = z ? new a(c) : new i(c);
    }

    public i(h.a.k1.p.i iVar) {
        b.A(iVar, "platform");
        this.a = iVar;
    }

    public void a(SSLSocket sSLSocket, String str, List<j> list) {
        this.a.c(sSLSocket, str, list);
    }

    public String b(SSLSocket sSLSocket) {
        return this.a.d(sSLSocket);
    }

    public String c(SSLSocket sSLSocket, String str, List<j> list) {
        if (list != null) {
            a(sSLSocket, str, list);
        }
        try {
            sSLSocket.startHandshake();
            String b2 = b(sSLSocket);
            if (b2 != null) {
                return b2;
            }
            throw new RuntimeException("TLS ALPN negotiation failed with protocols: " + list);
        } finally {
            this.a.a(sSLSocket);
        }
    }
}
