package h.a.k1;

import f.a.a.a.a;
import h.a.k1.p.b;
import h.a.k1.p.d;
import h.a.k1.p.j;
import h.a.k1.p.l;
import java.io.IOException;
import java.net.Socket;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public final class k {
    public static final List<j> a = Collections.unmodifiableList(Arrays.asList(j.HTTP_2));

    public static SSLSocket a(SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, Socket socket, String str, int i2, b bVar) {
        f.b.a.c.b.o.b.z(sSLSocketFactory, "sslSocketFactory");
        f.b.a.c.b.o.b.z(socket, "socket");
        f.b.a.c.b.o.b.z(bVar, "spec");
        SSLSocket sSLSocket = (SSLSocket) sSLSocketFactory.createSocket(socket, str, i2, true);
        List<j> list = null;
        String[] strArr = bVar.b != null ? (String[]) l.a(String.class, bVar.b, sSLSocket.getEnabledCipherSuites()) : null;
        String[] strArr2 = (String[]) l.a(String.class, bVar.c, sSLSocket.getEnabledProtocols());
        b.C0150b bVar2 = new b.C0150b(bVar);
        if (bVar2.a) {
            if (strArr == null) {
                bVar2.b = null;
            } else {
                bVar2.b = (String[]) strArr.clone();
            }
            if (bVar2.a) {
                if (strArr2 == null) {
                    bVar2.c = null;
                } else {
                    bVar2.c = (String[]) strArr2.clone();
                }
                b a2 = bVar2.a();
                sSLSocket.setEnabledProtocols(a2.c);
                String[] strArr3 = a2.b;
                if (strArr3 != null) {
                    sSLSocket.setEnabledCipherSuites(strArr3);
                }
                i iVar = i.f4106d;
                if (bVar.f4129d) {
                    list = a;
                }
                String c = iVar.c(sSLSocket, str, list);
                List<j> list2 = a;
                j jVar = j.HTTP_1_0;
                if (!c.equals("http/1.0")) {
                    jVar = j.HTTP_1_1;
                    if (!c.equals("http/1.1")) {
                        jVar = j.HTTP_2;
                        if (!c.equals("h2")) {
                            jVar = j.SPDY_3;
                            if (!c.equals("spdy/3.1")) {
                                throw new IOException(a.c("Unexpected protocol: ", c));
                            }
                        }
                    }
                }
                boolean contains = list2.contains(jVar);
                f.b.a.c.b.o.b.G(contains, "Only " + list2 + " are supported, but negotiated protocol is %s", c);
                if (hostnameVerifier == null) {
                    hostnameVerifier = d.a;
                }
                if (hostnameVerifier.verify((!str.startsWith("[") || !str.endsWith("]")) ? str : str.substring(1, str.length() - 1), sSLSocket.getSession())) {
                    return sSLSocket;
                }
                throw new SSLPeerUnverifiedException(a.c("Cannot verify hostname: ", str));
            }
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }
        throw new IllegalStateException("no cipher suites for cleartext connections");
    }
}
