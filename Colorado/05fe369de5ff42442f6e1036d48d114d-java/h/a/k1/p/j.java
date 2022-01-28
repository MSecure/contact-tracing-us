package h.a.k1.p;

public enum j {
    HTTP_1_0("http/1.0"),
    HTTP_1_1("http/1.1"),
    SPDY_3("spdy/3.1"),
    HTTP_2("h2");
    
    public final String b;

    /* access modifiers changed from: public */
    j(String str) {
        this.b = str;
    }

    public String toString() {
        return this.b;
    }
}
