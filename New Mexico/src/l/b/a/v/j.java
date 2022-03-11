package l.b.a.v;

import f.a.a.a.a;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes.dex */
public final class j {

    /* renamed from: e  reason: collision with root package name */
    public static final j f4737e = new j('0', '+', '-', '.');
    public final char a;
    public final char b;
    public final char c;

    /* renamed from: d  reason: collision with root package name */
    public final char f4738d;

    static {
        new ConcurrentHashMap(16, 0.75f, 2);
    }

    public j(char c, char c2, char c3, char c4) {
        this.a = c;
        this.b = c2;
        this.c = c3;
        this.f4738d = c4;
    }

    public String a(String str) {
        char c = this.a;
        if (c == '0') {
            return str;
        }
        int i2 = c - '0';
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
        return this.a == jVar.a && this.b == jVar.b && this.c == jVar.c && this.f4738d == jVar.f4738d;
    }

    public int hashCode() {
        return this.a + this.b + this.c + this.f4738d;
    }

    public String toString() {
        StringBuilder h2 = a.h("DecimalStyle[");
        h2.append(this.a);
        h2.append(this.b);
        h2.append(this.c);
        h2.append(this.f4738d);
        h2.append("]");
        return h2.toString();
    }
}
