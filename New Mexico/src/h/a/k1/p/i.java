package h.a.k1.p;

import java.io.EOFException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.Socket;
import java.security.AccessController;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivilegedActionException;
import java.security.Provider;
import java.security.Security;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
/* loaded from: classes.dex */
public class i {
    public static final Logger b = Logger.getLogger(i.class.getName());
    public static final String[] c = {"com.google.android.gms.org.conscrypt.OpenSSLProvider", "org.conscrypt.OpenSSLProvider", "com.android.org.conscrypt.OpenSSLProvider", "org.apache.harmony.xnet.provider.jsse.OpenSSLProvider", "com.google.android.libraries.stitch.sslguard.SslGuardProvider"};

    /* renamed from: d  reason: collision with root package name */
    public static final i f4455d;
    public final Provider a;

    /* loaded from: classes.dex */
    public static class a extends i {

        /* renamed from: e  reason: collision with root package name */
        public final e<Socket> f4456e;

        /* renamed from: f  reason: collision with root package name */
        public final e<Socket> f4457f;

        /* renamed from: g  reason: collision with root package name */
        public final e<Socket> f4458g;

        /* renamed from: h  reason: collision with root package name */
        public final e<Socket> f4459h;

        /* renamed from: i  reason: collision with root package name */
        public final e f4460i;

        public a(e<Socket> eVar, e<Socket> eVar2, Method method, Method method2, e<Socket> eVar3, e<Socket> eVar4, Provider provider, e eVar5) {
            super(provider);
            this.f4456e = eVar;
            this.f4457f = eVar2;
            this.f4458g = eVar3;
            this.f4459h = eVar4;
            this.f4460i = eVar5;
        }

        @Override // h.a.k1.p.i
        public void c(SSLSocket sSLSocket, String str, List<j> list) {
            if (str != null) {
                this.f4456e.d(sSLSocket, Boolean.TRUE);
                this.f4457f.d(sSLSocket, str);
            }
            e<Socket> eVar = this.f4459h;
            Objects.requireNonNull(eVar);
            if (eVar.a(sSLSocket.getClass()) != null) {
                this.f4459h.e(sSLSocket, i.b(list));
            }
        }

        @Override // h.a.k1.p.i
        public String d(SSLSocket sSLSocket) {
            byte[] bArr;
            e<Socket> eVar = this.f4458g;
            Objects.requireNonNull(eVar);
            if ((eVar.a(sSLSocket.getClass()) != null) && (bArr = (byte[]) this.f4458g.e(sSLSocket, new Object[0])) != null) {
                return new String(bArr, l.b);
            }
            return null;
        }

        @Override // h.a.k1.p.i
        public e e() {
            return this.f4460i;
        }
    }

    /* loaded from: classes.dex */
    public static class b extends i {

        /* renamed from: e  reason: collision with root package name */
        public final Method f4461e;

        /* renamed from: f  reason: collision with root package name */
        public final Method f4462f;

        public b(Provider provider, Method method, Method method2, f fVar) {
            super(provider);
            this.f4461e = method;
            this.f4462f = method2;
        }

        @Override // h.a.k1.p.i
        public void c(SSLSocket sSLSocket, String str, List<j> list) {
            SSLParameters sSLParameters = sSLSocket.getSSLParameters();
            ArrayList arrayList = new ArrayList(list.size());
            for (j jVar : list) {
                if (jVar != j.HTTP_1_0) {
                    arrayList.add(jVar.b);
                }
            }
            try {
                this.f4461e.invoke(sSLParameters, arrayList.toArray(new String[arrayList.size()]));
                sSLSocket.setSSLParameters(sSLParameters);
            } catch (IllegalAccessException e2) {
                throw new RuntimeException(e2);
            } catch (InvocationTargetException e3) {
                throw new RuntimeException(e3);
            }
        }

        @Override // h.a.k1.p.i
        public String d(SSLSocket sSLSocket) {
            try {
                return (String) this.f4462f.invoke(sSLSocket, new Object[0]);
            } catch (IllegalAccessException e2) {
                throw new RuntimeException(e2);
            } catch (InvocationTargetException e3) {
                throw new RuntimeException(e3);
            }
        }

        @Override // h.a.k1.p.i
        public e e() {
            return e.ALPN_AND_NPN;
        }
    }

    /* loaded from: classes.dex */
    public static class c extends i {

        /* renamed from: e  reason: collision with root package name */
        public final Method f4463e;

        /* renamed from: f  reason: collision with root package name */
        public final Method f4464f;

        /* renamed from: g  reason: collision with root package name */
        public final Method f4465g;

        /* renamed from: h  reason: collision with root package name */
        public final Class<?> f4466h;

        /* renamed from: i  reason: collision with root package name */
        public final Class<?> f4467i;

        public c(Method method, Method method2, Method method3, Class<?> cls, Class<?> cls2, Provider provider) {
            super(provider);
            this.f4463e = method;
            this.f4464f = method2;
            this.f4465g = method3;
            this.f4466h = cls;
            this.f4467i = cls2;
        }

        @Override // h.a.k1.p.i
        public void a(SSLSocket sSLSocket) {
            try {
                this.f4465g.invoke(null, sSLSocket);
            } catch (IllegalAccessException unused) {
                throw new AssertionError();
            } catch (InvocationTargetException unused2) {
            }
        }

        @Override // h.a.k1.p.i
        public void c(SSLSocket sSLSocket, String str, List<j> list) {
            ArrayList arrayList = new ArrayList(list.size());
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                j jVar = list.get(i2);
                if (jVar != j.HTTP_1_0) {
                    arrayList.add(jVar.b);
                }
            }
            try {
                this.f4463e.invoke(null, sSLSocket, Proxy.newProxyInstance(i.class.getClassLoader(), new Class[]{this.f4466h, this.f4467i}, new d(arrayList)));
            } catch (IllegalAccessException e2) {
                throw new AssertionError(e2);
            } catch (InvocationTargetException e3) {
                throw new AssertionError(e3);
            }
        }

        @Override // h.a.k1.p.i
        public String d(SSLSocket sSLSocket) {
            try {
                d dVar = (d) Proxy.getInvocationHandler(this.f4464f.invoke(null, sSLSocket));
                boolean z = dVar.b;
                if (!z && dVar.c == null) {
                    i.b.log(Level.INFO, "ALPN callback dropped: SPDY and HTTP/2 are disabled. Is alpn-boot on the boot class path?");
                    return null;
                } else if (z) {
                    return null;
                } else {
                    return dVar.c;
                }
            } catch (IllegalAccessException unused) {
                throw new AssertionError();
            } catch (InvocationTargetException unused2) {
                throw new AssertionError();
            }
        }

        @Override // h.a.k1.p.i
        public e e() {
            return e.ALPN_AND_NPN;
        }
    }

    /* loaded from: classes.dex */
    public static class d implements InvocationHandler {
        public final List<String> a;
        public boolean b;
        public String c;

        public d(List<String> list) {
            this.a = list;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) {
            Object obj2;
            String name = method.getName();
            Class<?> returnType = method.getReturnType();
            if (objArr == null) {
                objArr = l.a;
            }
            if (name.equals("supports") && Boolean.TYPE == returnType) {
                return Boolean.TRUE;
            }
            if (name.equals("unsupported") && Void.TYPE == returnType) {
                this.b = true;
                return null;
            } else if (name.equals("protocols") && objArr.length == 0) {
                return this.a;
            } else {
                if ((name.equals("selectProtocol") || name.equals("select")) && String.class == returnType && objArr.length == 1 && (objArr[0] instanceof List)) {
                    List list = (List) objArr[0];
                    int size = list.size();
                    int i2 = 0;
                    while (true) {
                        if (i2 >= size) {
                            obj2 = this.a.get(0);
                            break;
                        } else if (this.a.contains(list.get(i2))) {
                            obj2 = list.get(i2);
                            break;
                        } else {
                            i2++;
                        }
                    }
                    String str = (String) obj2;
                    this.c = str;
                    return str;
                } else if ((!name.equals("protocolSelected") && !name.equals("selected")) || objArr.length != 1) {
                    return method.invoke(this, objArr);
                } else {
                    this.c = (String) objArr[0];
                    return null;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public enum e {
        ALPN_AND_NPN,
        NPN,
        NONE
    }

    static {
        Method method;
        Provider provider;
        i iVar;
        i iVar2;
        Method method2;
        Method method3;
        boolean z;
        e eVar = e.ALPN_AND_NPN;
        Provider[] providers = Security.getProviders();
        int length = providers.length;
        boolean z2 = false;
        int i2 = 0;
        loop0: while (true) {
            method = null;
            if (i2 >= length) {
                b.log(Level.WARNING, "Unable to find Conscrypt");
                provider = null;
                break;
            }
            Provider provider2 = providers[i2];
            String[] strArr = c;
            for (String str : strArr) {
                if (str.equals(provider2.getClass().getName())) {
                    b.log(Level.FINE, "Found registered provider {0}", str);
                    provider = provider2;
                    break loop0;
                }
            }
            i2++;
        }
        if (provider != null) {
            e eVar2 = new e(null, "setUseSessionTickets", Boolean.TYPE);
            e eVar3 = new e(null, "setHostname", String.class);
            e eVar4 = new e(byte[].class, "getAlpnSelectedProtocol", new Class[0]);
            e eVar5 = new e(null, "setAlpnProtocols", byte[].class);
            try {
                Class<?> cls = Class.forName("android.net.TrafficStats");
                method3 = cls.getMethod("tagSocket", Socket.class);
                try {
                    method = cls.getMethod("untagSocket", Socket.class);
                } catch (ClassNotFoundException | NoSuchMethodException unused) {
                }
                method2 = method;
            } catch (ClassNotFoundException | NoSuchMethodException unused2) {
                method3 = null;
                method2 = null;
            }
            if (!provider.getName().equals("GmsCore_OpenSSL") && !provider.getName().equals("Conscrypt") && !provider.getName().equals("Ssl_Guard")) {
                try {
                    i.class.getClassLoader().loadClass("android.net.Network");
                    z = true;
                } catch (ClassNotFoundException e2) {
                    b.log(Level.FINE, "Can't find class", (Throwable) e2);
                    z = false;
                }
                if (!z) {
                    try {
                        i.class.getClassLoader().loadClass("android.app.ActivityOptions");
                        z2 = true;
                    } catch (ClassNotFoundException e3) {
                        b.log(Level.FINE, "Can't find class", (Throwable) e3);
                    }
                    eVar = z2 ? e.NPN : e.NONE;
                }
            }
            iVar2 = new a(eVar2, eVar3, method3, method2, eVar4, eVar5, provider, eVar);
        } else {
            try {
                Provider provider3 = SSLContext.getDefault().getProvider();
                try {
                    SSLContext instance = SSLContext.getInstance("TLS", provider3);
                    instance.init(null, null, null);
                    ((Method) AccessController.doPrivileged(new f())).invoke(instance.createSSLEngine(), new Object[0]);
                    iVar2 = new b(provider3, (Method) AccessController.doPrivileged(new g()), (Method) AccessController.doPrivileged(new h()), null);
                } catch (IllegalAccessException | InvocationTargetException | KeyManagementException | NoSuchAlgorithmException | PrivilegedActionException unused3) {
                    try {
                        Class<?> cls2 = Class.forName("org.eclipse.jetty.alpn.ALPN");
                        iVar = new c(cls2.getMethod("put", SSLSocket.class, Class.forName("org.eclipse.jetty.alpn.ALPN$Provider")), cls2.getMethod("get", SSLSocket.class), cls2.getMethod("remove", SSLSocket.class), Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider"), Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider"), provider3);
                    } catch (ClassNotFoundException | NoSuchMethodException unused4) {
                        iVar = new i(provider3);
                    }
                    iVar2 = iVar;
                }
            } catch (NoSuchAlgorithmException e4) {
                throw new RuntimeException(e4);
            }
        }
        f4455d = iVar2;
    }

    public i(Provider provider) {
        this.a = provider;
    }

    public static byte[] b(List<j> list) {
        k.e eVar = new k.e();
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            j jVar = list.get(i2);
            if (jVar != j.HTTP_1_0) {
                eVar.V(jVar.b.length());
                eVar.Y(jVar.b);
            }
        }
        try {
            return eVar.I(eVar.c);
        } catch (EOFException e2) {
            throw new AssertionError(e2);
        }
    }

    public void a(SSLSocket sSLSocket) {
    }

    public void c(SSLSocket sSLSocket, String str, List<j> list) {
    }

    public String d(SSLSocket sSLSocket) {
        return null;
    }

    public e e() {
        return e.NONE;
    }
}
