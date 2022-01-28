package e.b.i;

import c.a.a.a.a;
import c.b.a.a.c.n.c;
import e.b.g.b;

public class j {

    /* renamed from: a  reason: collision with root package name */
    public String f4910a;

    /* renamed from: b  reason: collision with root package name */
    public int f4911b = 0;

    public j(String str) {
        c.J1(str);
        this.f4910a = str;
    }

    public static String m(String str) {
        StringBuilder b2 = b.b();
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        int i = 0;
        char c2 = 0;
        while (i < length) {
            char c3 = charArray[i];
            if (c3 != '\\' || (c2 != 0 && c2 == '\\')) {
                b2.append(c3);
            }
            i++;
            c2 = c3;
        }
        return b.j(b2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x0048 A[EDGE_INSN: B:37:0x0048->B:30:0x0048 ?: BREAK  , SYNTHETIC] */
    public String a(char c2, char c3) {
        char c4 = 0;
        boolean z = false;
        boolean z2 = false;
        int i = 0;
        int i2 = -1;
        int i3 = -1;
        while (!g()) {
            char b2 = b();
            if (c4 == 0 || c4 != '\\') {
                if (b2 == '\'' && b2 != c2 && !z) {
                    z2 = !z2;
                } else if (b2 == '\"' && b2 != c2 && !z2) {
                    z = !z;
                }
                if (!z2 && !z) {
                    if (b2 == c2) {
                        i++;
                        if (i2 == -1) {
                            i2 = this.f4911b;
                        }
                    } else if (b2 == c3) {
                        i--;
                    }
                }
                if (i <= 0) {
                    break;
                }
            }
            if (i > 0 && c4 != 0) {
                i3 = this.f4911b;
            }
            c4 = b2;
            continue;
            if (i <= 0) {
            }
        }
        String substring = i3 >= 0 ? this.f4910a.substring(i2, i3) : "";
        if (i <= 0) {
            return substring;
        }
        throw new IllegalArgumentException(a.p("Did not find balanced marker at '", substring, "'"));
    }

    public char b() {
        String str = this.f4910a;
        int i = this.f4911b;
        this.f4911b = i + 1;
        return str.charAt(i);
    }

    public void c(String str) {
        if (i(str)) {
            int length = str.length();
            int length2 = this.f4910a.length();
            int i = this.f4911b;
            if (length <= length2 - i) {
                this.f4911b = i + length;
                return;
            }
            throw new IllegalStateException("Queue not long enough to consume sequence");
        }
        throw new IllegalStateException("Queue did not match expected sequence");
    }

    public String d() {
        int i = this.f4911b;
        while (!g()) {
            if (!k()) {
                char[] cArr = {'-', '_'};
                boolean z = false;
                if (!g()) {
                    int i2 = 0;
                    while (true) {
                        if (i2 >= 2) {
                            break;
                        }
                        if (this.f4910a.charAt(this.f4911b) == cArr[i2]) {
                            z = true;
                            break;
                        }
                        i2++;
                    }
                }
                if (!z) {
                    break;
                }
            }
            this.f4911b++;
        }
        return this.f4910a.substring(i, this.f4911b);
    }

    public String e(String str) {
        int indexOf = this.f4910a.indexOf(str, this.f4911b);
        if (indexOf == -1) {
            return l();
        }
        String substring = this.f4910a.substring(this.f4911b, indexOf);
        this.f4911b = substring.length() + this.f4911b;
        return substring;
    }

    public boolean f() {
        boolean z = false;
        while (true) {
            if (!(!g() && b.g(this.f4910a.charAt(this.f4911b)))) {
                return z;
            }
            this.f4911b++;
            z = true;
        }
    }

    public boolean g() {
        return this.f4910a.length() - this.f4911b == 0;
    }

    public boolean h(String str) {
        if (!i(str)) {
            return false;
        }
        this.f4911b = str.length() + this.f4911b;
        return true;
    }

    public boolean i(String str) {
        return this.f4910a.regionMatches(true, this.f4911b, str, 0, str.length());
    }

    public boolean j(String... strArr) {
        for (String str : strArr) {
            if (i(str)) {
                return true;
            }
        }
        return false;
    }

    public boolean k() {
        return !g() && Character.isLetterOrDigit(this.f4910a.charAt(this.f4911b));
    }

    public String l() {
        String str = this.f4910a;
        String substring = str.substring(this.f4911b, str.length());
        this.f4911b = this.f4910a.length();
        return substring;
    }

    public String toString() {
        return this.f4910a.substring(this.f4911b);
    }
}
