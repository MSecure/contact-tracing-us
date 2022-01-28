package l.b.a.v;

import f.a.a.a.a;
import java.util.concurrent.ConcurrentHashMap;

public final class j {

    /* renamed from: e  reason: collision with root package name */
    public static final j f4417e = new j('0', '+', '-', '.');
    public final char a;
    public final char b;
    public final char c;

    /* renamed from: d  reason: collision with root package name */
    public final char f4418d;

    static {
        new ConcurrentHashMap(16, 0.75f, 2);
    }

    public j(char c2, char c3, char c4, char c5) {
        this.a = c2;
        this.b = c3;
        this.c = c4;
        this.f4418d = c5;
    }

    public String a(String str) {
        char c2 = this.a;
        if (c2 == '0') {
            return str;
        }
        int i2 = c2 - '0';
        char[] charArray = str.toCharArray();
        for (int i3 = 0; i3 < charArray.length; i3++) {
            charArray[i3] = (char) (charArray[i3] + i2);
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
        return this.a == jVar.a && this.b == jVar.b && this.c == jVar.c && this.f4418d == jVar.f4418d;
    }

    public int hashCode() {
        return this.a + this.b + this.c + this.f4418d;
    }

    public String toString() {
        StringBuilder i2 = a.i("DecimalStyle[");
        i2.append(this.a);
        i2.append(this.b);
        i2.append(this.c);
        i2.append(this.f4418d);
        i2.append("]");
        return i2.toString();
    }
}
