package h.a.k1.p;

public enum k {
    TLS_1_2("TLSv1.2"),
    TLS_1_1("TLSv1.1"),
    TLS_1_0("TLSv1"),
    SSL_3_0("SSLv3");
    
    public final String b;

    /* access modifiers changed from: public */
    k(String str) {
        this.b = str;
    }
}
