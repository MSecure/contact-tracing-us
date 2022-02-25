package h.a.k1.p;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class b {

    /* renamed from: e  reason: collision with root package name */
    public static final a[] f3869e;

    /* renamed from: f  reason: collision with root package name */
    public static final b f3870f;
    public final boolean a;
    public final String[] b;
    public final String[] c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f3871d;

    /* renamed from: h.a.k1.p.b$b  reason: collision with other inner class name */
    public static final class C0145b {
        public boolean a;
        public String[] b;
        public String[] c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f3872d;

        public C0145b(b bVar) {
            this.a = bVar.a;
            this.b = bVar.b;
            this.c = bVar.c;
            this.f3872d = bVar.f3871d;
        }

        public C0145b(boolean z) {
            this.a = z;
        }

        public b a() {
            return new b(this, null);
        }

        public C0145b b(a... aVarArr) {
            if (this.a) {
                String[] strArr = new String[aVarArr.length];
                for (int i2 = 0; i2 < aVarArr.length; i2++) {
                    strArr[i2] = aVarArr[i2].b;
                }
                this.b = strArr;
                return this;
            }
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }

        public C0145b c(boolean z) {
            if (this.a) {
                this.f3872d = z;
                return this;
            }
            throw new IllegalStateException("no TLS extensions for cleartext connections");
        }

        public C0145b d(k... kVarArr) {
            if (!this.a) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            } else if (kVarArr.length != 0) {
                String[] strArr = new String[kVarArr.length];
                for (int i2 = 0; i2 < kVarArr.length; i2++) {
                    strArr[i2] = kVarArr[i2].b;
                }
                this.c = strArr;
                return this;
            } else {
                throw new IllegalArgumentException("At least one TlsVersion is required");
            }
        }
    }

    static {
        a[] aVarArr = {a.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256, a.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256, a.TLS_DHE_RSA_WITH_AES_128_GCM_SHA256, a.TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA, a.TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA, a.TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA, a.TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA, a.TLS_DHE_RSA_WITH_AES_128_CBC_SHA, a.TLS_DHE_DSS_WITH_AES_128_CBC_SHA, a.TLS_DHE_RSA_WITH_AES_256_CBC_SHA, a.TLS_RSA_WITH_AES_128_GCM_SHA256, a.TLS_RSA_WITH_AES_128_CBC_SHA, a.TLS_RSA_WITH_AES_256_CBC_SHA, a.TLS_RSA_WITH_3DES_EDE_CBC_SHA};
        f3869e = aVarArr;
        C0145b bVar = new C0145b(true);
        bVar.b(aVarArr);
        k kVar = k.TLS_1_0;
        bVar.d(k.TLS_1_2, k.TLS_1_1, kVar);
        bVar.c(true);
        b a2 = bVar.a();
        f3870f = a2;
        C0145b bVar2 = new C0145b(a2);
        bVar2.d(kVar);
        bVar2.c(true);
        bVar2.a();
        new C0145b(false).a();
    }

    public b(C0145b bVar, a aVar) {
        this.a = bVar.a;
        this.b = bVar.b;
        this.c = bVar.c;
        this.f3871d = bVar.f3872d;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        b bVar = (b) obj;
        boolean z = this.a;
        if (z != bVar.a) {
            return false;
        }
        return !z || (Arrays.equals(this.b, bVar.b) && Arrays.equals(this.c, bVar.c) && this.f3871d == bVar.f3871d);
    }

    public int hashCode() {
        if (this.a) {
            return ((((527 + Arrays.hashCode(this.b)) * 31) + Arrays.hashCode(this.c)) * 31) + (!this.f3871d ? 1 : 0);
        }
        return 17;
    }

    public String toString() {
        List list;
        String str;
        k kVar;
        if (!this.a) {
            return "ConnectionSpec()";
        }
        String[] strArr = this.b;
        int i2 = 0;
        if (strArr == null) {
            list = null;
        } else {
            a[] aVarArr = new a[strArr.length];
            int i3 = 0;
            while (true) {
                String[] strArr2 = this.b;
                if (i3 >= strArr2.length) {
                    break;
                }
                String str2 = strArr2[i3];
                a aVar = a.TLS_RSA_WITH_NULL_MD5;
                if (str2.startsWith("SSL_")) {
                    StringBuilder h2 = f.a.a.a.a.h("TLS_");
                    h2.append(str2.substring(4));
                    str2 = h2.toString();
                }
                aVarArr[i3] = a.valueOf(str2);
                i3++;
            }
            String[] strArr3 = l.a;
            list = Collections.unmodifiableList(Arrays.asList((Object[]) aVarArr.clone()));
        }
        if (list == null) {
            str = "[use default]";
        } else {
            str = list.toString();
        }
        StringBuilder j2 = f.a.a.a.a.j("ConnectionSpec(cipherSuites=", str, ", tlsVersions=");
        k[] kVarArr = new k[this.c.length];
        while (true) {
            String[] strArr4 = this.c;
            if (i2 < strArr4.length) {
                String str3 = strArr4[i2];
                if ("TLSv1.2".equals(str3)) {
                    kVar = k.TLS_1_2;
                } else if ("TLSv1.1".equals(str3)) {
                    kVar = k.TLS_1_1;
                } else if ("TLSv1".equals(str3)) {
                    kVar = k.TLS_1_0;
                } else if ("SSLv3".equals(str3)) {
                    kVar = k.SSL_3_0;
                } else {
                    throw new IllegalArgumentException(f.a.a.a.a.t("Unexpected TLS version: ", str3));
                }
                kVarArr[i2] = kVar;
                i2++;
            } else {
                String[] strArr5 = l.a;
                j2.append(Collections.unmodifiableList(Arrays.asList((Object[]) kVarArr.clone())));
                j2.append(", supportsTlsExtensions=");
                j2.append(this.f3871d);
                j2.append(")");
                return j2.toString();
            }
        }
    }
}
