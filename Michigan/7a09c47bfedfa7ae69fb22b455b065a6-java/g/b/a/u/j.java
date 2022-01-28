package g.b.a.u;

import c.a.a.a.a;
import java.util.concurrent.ConcurrentHashMap;

public final class j {

    /* renamed from: e  reason: collision with root package name */
    public static final j f6597e = new j('0', '+', '-', '.');

    /* renamed from: a  reason: collision with root package name */
    public final char f6598a;

    /* renamed from: b  reason: collision with root package name */
    public final char f6599b;

    /* renamed from: c  reason: collision with root package name */
    public final char f6600c;

    /* renamed from: d  reason: collision with root package name */
    public final char f6601d;

    static {
        new ConcurrentHashMap(16, 0.75f, 2);
    }

    public j(char c2, char c3, char c4, char c5) {
        this.f6598a = c2;
        this.f6599b = c3;
        this.f6600c = c4;
        this.f6601d = c5;
    }

    public String a(String str) {
        char c2 = this.f6598a;
        if (c2 == '0') {
            return str;
        }
        int i = c2 - '0';
        char[] charArray = str.toCharArray();
        for (int i2 = 0; i2 < charArray.length; i2++) {
            charArray[i2] = (char) (charArray[i2] + i);
        }
        return new String(charArray);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return this.f6598a == jVar.f6598a && this.f6599b == jVar.f6599b && this.f6600c == jVar.f6600c && this.f6601d == jVar.f6601d;
    }

    public int hashCode() {
        return this.f6598a + this.f6599b + this.f6600c + this.f6601d;
    }

    public String toString() {
        StringBuilder h = a.h("DecimalStyle[");
        h.append(this.f6598a);
        h.append(this.f6599b);
        h.append(this.f6600c);
        h.append(this.f6601d);
        h.append("]");
        return h.toString();
    }
}
