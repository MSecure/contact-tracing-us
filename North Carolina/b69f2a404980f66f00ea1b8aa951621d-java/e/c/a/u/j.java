package e.c.a.u;

import c.a.a.a.a;
import java.util.concurrent.ConcurrentHashMap;

public final class j {

    /* renamed from: e  reason: collision with root package name */
    public static final j f5129e = new j('0', '+', '-', '.');

    /* renamed from: a  reason: collision with root package name */
    public final char f5130a;

    /* renamed from: b  reason: collision with root package name */
    public final char f5131b;

    /* renamed from: c  reason: collision with root package name */
    public final char f5132c;

    /* renamed from: d  reason: collision with root package name */
    public final char f5133d;

    static {
        new ConcurrentHashMap(16, 0.75f, 2);
    }

    public j(char c2, char c3, char c4, char c5) {
        this.f5130a = c2;
        this.f5131b = c3;
        this.f5132c = c4;
        this.f5133d = c5;
    }

    public String a(String str) {
        char c2 = this.f5130a;
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
        return this.f5130a == jVar.f5130a && this.f5131b == jVar.f5131b && this.f5132c == jVar.f5132c && this.f5133d == jVar.f5133d;
    }

    public int hashCode() {
        return this.f5130a + this.f5131b + this.f5132c + this.f5133d;
    }

    public String toString() {
        StringBuilder g = a.g("DecimalStyle[");
        g.append(this.f5130a);
        g.append(this.f5131b);
        g.append(this.f5132c);
        g.append(this.f5133d);
        g.append("]");
        return g.toString();
    }
}
