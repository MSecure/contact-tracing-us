package f.e.a;
/* loaded from: classes.dex */
public enum c {
    HTTP_1_0("http/1.0"),
    HTTP_1_1("http/1.1"),
    SPDY_3("spdy/3.1"),
    HTTP_2("h2");
    
    public final String b;

    c(String str) {
        this.b = str;
    }

    @Override // java.lang.Enum, java.lang.Object
    public String toString() {
        return this.b;
    }
}
