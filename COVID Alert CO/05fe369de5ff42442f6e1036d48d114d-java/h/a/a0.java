package h.a;

import java.security.cert.Certificate;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;

public final class a0 {

    /* renamed from: d  reason: collision with root package name */
    public static final Logger f3750d = Logger.getLogger(a0.class.getName());

    /* renamed from: e  reason: collision with root package name */
    public static final a0 f3751e = new a0();
    public final ConcurrentNavigableMap<Long, c0<Object>> a = new ConcurrentSkipListMap();
    public final ConcurrentMap<Long, c0<Object>> b = new ConcurrentHashMap();
    public final ConcurrentMap<Long, c0<Object>> c = new ConcurrentHashMap();

    public static final class b {
        public b(SSLSession sSLSession) {
            sSLSession.getCipherSuite();
            Certificate[] localCertificates = sSLSession.getLocalCertificates();
            if (localCertificates != null) {
                Certificate certificate = localCertificates[0];
            }
            try {
                Certificate[] peerCertificates = sSLSession.getPeerCertificates();
                if (peerCertificates != null) {
                    Certificate certificate2 = peerCertificates[0];
                }
            } catch (SSLPeerUnverifiedException e2) {
                a0.f3750d.log(Level.FINE, String.format("Peer cert not available for peerHost=%s", sSLSession.getPeerHost()), (Throwable) e2);
            }
        }
    }

    public a0() {
        new ConcurrentSkipListMap();
        new ConcurrentHashMap();
    }

    public static <T extends c0<?>> void a(Map<Long, T> map, T t) {
        map.put(Long.valueOf(t.c().c), t);
    }

    public static <T extends c0<?>> void b(Map<Long, T> map, T t) {
        map.remove(Long.valueOf(t.c().c));
    }
}
