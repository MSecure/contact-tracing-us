package f.b.f.a;

public class d extends Exception {
    public a b;
    public String c;

    public enum a {
        INVALID_COUNTRY_CODE,
        NOT_A_NUMBER,
        TOO_SHORT_AFTER_IDD,
        TOO_SHORT_NSN,
        TOO_LONG
    }

    public d(a aVar, String str) {
        super(str);
        this.c = str;
        this.b = aVar;
    }

    public String toString() {
        StringBuilder h2 = f.a.a.a.a.h("Error type: ");
        h2.append(this.b);
        h2.append(". ");
        h2.append(this.c);
        return h2.toString();
    }
}
