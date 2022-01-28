package h.a.j1;

import f.b.b.a.u;
import h.a.x0;
import h.a.y0;
import h.a.z;
import java.net.Authenticator;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class i2 implements y0 {

    /* renamed from: d  reason: collision with root package name */
    public static final Logger f3945d = Logger.getLogger(i2.class.getName());

    /* renamed from: e  reason: collision with root package name */
    public static final c f3946e = new a();

    /* renamed from: f  reason: collision with root package name */
    public static final u<ProxySelector> f3947f = new b();
    public final u<ProxySelector> a;
    public final c b;
    public final InetSocketAddress c;

    public class a implements c {
        @Override // h.a.j1.i2.c
        public PasswordAuthentication a(String str, InetAddress inetAddress, int i2, String str2, String str3, String str4) {
            URL url;
            try {
                url = new URL(str2, str, i2, "");
            } catch (MalformedURLException unused) {
                i2.f3945d.log(Level.WARNING, String.format("failed to create URL for Authenticator: %s %s", str2, str));
                url = null;
            }
            return Authenticator.requestPasswordAuthentication(str, inetAddress, i2, str2, str3, null, url, Authenticator.RequestorType.PROXY);
        }
    }

    public class b implements u<ProxySelector> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // f.b.b.a.u
        public ProxySelector get() {
            return ProxySelector.getDefault();
        }
    }

    public interface c {
        PasswordAuthentication a(String str, InetAddress inetAddress, int i2, String str2, String str3, String str4);
    }

    public i2() {
        u<ProxySelector> uVar = f3947f;
        c cVar = f3946e;
        String str = System.getenv("GRPC_PROXY_EXP");
        Objects.requireNonNull(uVar);
        this.a = uVar;
        Objects.requireNonNull(cVar);
        this.b = cVar;
        if (str != null) {
            String[] split = str.split(":", 2);
            int i2 = split.length > 1 ? Integer.parseInt(split[1]) : 80;
            f3945d.warning("Detected GRPC_PROXY_EXP and will honor it, but this feature will be removed in a future release. Use the JVM flags \"-Dhttps.proxyHost=HOST -Dhttps.proxyPort=PORT\" to set the https proxy for this JVM.");
            this.c = new InetSocketAddress(split[0], i2);
            return;
        }
        this.c = null;
    }

    @Override // h.a.y0
    public x0 a(SocketAddress socketAddress) {
        String str = null;
        if (!(socketAddress instanceof InetSocketAddress)) {
            return null;
        }
        InetSocketAddress inetSocketAddress = this.c;
        if (inetSocketAddress != null) {
            int i2 = z.f4306f;
            f.b.a.c.b.o.b.z(inetSocketAddress, "proxyAddress");
            InetSocketAddress inetSocketAddress2 = (InetSocketAddress) socketAddress;
            f.b.a.c.b.o.b.z(inetSocketAddress2, "targetAddress");
            return new z(inetSocketAddress, inetSocketAddress2, null, null, null);
        }
        InetSocketAddress inetSocketAddress3 = (InetSocketAddress) socketAddress;
        try {
            try {
                URI uri = new URI("https", null, q0.c(inetSocketAddress3), inetSocketAddress3.getPort(), null, null, null);
                ProxySelector proxySelector = this.a.get();
                if (proxySelector == null) {
                    f3945d.log(Level.FINE, "proxy selector is null, so continuing without proxy lookup");
                    return null;
                }
                List<Proxy> select = proxySelector.select(uri);
                if (select.size() > 1) {
                    f3945d.warning("More than 1 proxy detected, gRPC will select the first one");
                }
                Proxy proxy = select.get(0);
                if (proxy.type() == Proxy.Type.DIRECT) {
                    return null;
                }
                InetSocketAddress inetSocketAddress4 = (InetSocketAddress) proxy.address();
                PasswordAuthentication a2 = this.b.a(q0.c(inetSocketAddress4), inetSocketAddress4.getAddress(), inetSocketAddress4.getPort(), "https", "", null);
                InetSocketAddress inetSocketAddress5 = inetSocketAddress4.isUnresolved() ? new InetSocketAddress(InetAddress.getByName(inetSocketAddress4.getHostName()), inetSocketAddress4.getPort()) : inetSocketAddress4;
                int i3 = z.f4306f;
                f.b.a.c.b.o.b.z(inetSocketAddress3, "targetAddress");
                f.b.a.c.b.o.b.z(inetSocketAddress5, "proxyAddress");
                if (a2 == null) {
                    return new z(inetSocketAddress5, inetSocketAddress3, null, null, null);
                }
                String userName = a2.getUserName();
                if (a2.getPassword() != null) {
                    str = new String(a2.getPassword());
                }
                return new z(inetSocketAddress5, inetSocketAddress3, userName, str, null);
            } catch (URISyntaxException e2) {
                f3945d.log(Level.WARNING, "Failed to construct URI for proxy lookup, proceeding without proxy", (Throwable) e2);
                return null;
            }
        } catch (Throwable th) {
            f3945d.log(Level.WARNING, "Failed to get host for proxy lookup, proceeding without proxy", th);
            return null;
        }
    }
}
