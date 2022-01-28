package h.a.k1.p;

import f.a.a.a.a;
import javax.security.auth.x500.X500Principal;

public final class c {
    public final String a;
    public final int b;
    public int c;

    /* renamed from: d  reason: collision with root package name */
    public int f4196d;

    /* renamed from: e  reason: collision with root package name */
    public int f4197e;

    /* renamed from: f  reason: collision with root package name */
    public int f4198f;

    /* renamed from: g  reason: collision with root package name */
    public char[] f4199g;

    public c(X500Principal x500Principal) {
        String name = x500Principal.getName("RFC2253");
        this.a = name;
        this.b = name.length();
    }

    public final int a(int i2) {
        int i3;
        int i4;
        int i5 = i2 + 1;
        if (i5 < this.b) {
            char[] cArr = this.f4199g;
            char c2 = cArr[i2];
            if (c2 >= '0' && c2 <= '9') {
                i3 = c2 - '0';
            } else if (c2 >= 'a' && c2 <= 'f') {
                i3 = c2 - 'W';
            } else if (c2 < 'A' || c2 > 'F') {
                StringBuilder h2 = a.h("Malformed DN: ");
                h2.append(this.a);
                throw new IllegalStateException(h2.toString());
            } else {
                i3 = c2 - '7';
            }
            char c3 = cArr[i5];
            if (c3 >= '0' && c3 <= '9') {
                i4 = c3 - '0';
            } else if (c3 >= 'a' && c3 <= 'f') {
                i4 = c3 - 'W';
            } else if (c3 < 'A' || c3 > 'F') {
                StringBuilder h3 = a.h("Malformed DN: ");
                h3.append(this.a);
                throw new IllegalStateException(h3.toString());
            } else {
                i4 = c3 - '7';
            }
            return (i3 << 4) + i4;
        }
        StringBuilder h4 = a.h("Malformed DN: ");
        h4.append(this.a);
        throw new IllegalStateException(h4.toString());
    }

    public final char b() {
        int i2;
        int i3 = this.c + 1;
        this.c = i3;
        if (i3 != this.b) {
            char[] cArr = this.f4199g;
            char c2 = cArr[i3];
            if (!(c2 == ' ' || c2 == '%' || c2 == '\\' || c2 == '_' || c2 == '\"' || c2 == '#')) {
                switch (c2) {
                    case '*':
                    case '+':
                    case ',':
                        break;
                    default:
                        switch (c2) {
                            case ';':
                            case '<':
                            case '=':
                            case '>':
                                break;
                            default:
                                int a2 = a(i3);
                                this.c++;
                                if (a2 >= 128) {
                                    if (a2 < 192 || a2 > 247) {
                                        return '?';
                                    }
                                    if (a2 <= 223) {
                                        a2 &= 31;
                                        i2 = 1;
                                    } else if (a2 <= 239) {
                                        i2 = 2;
                                        a2 &= 15;
                                    } else {
                                        i2 = 3;
                                        a2 &= 7;
                                    }
                                    for (int i4 = 0; i4 < i2; i4++) {
                                        int i5 = this.c + 1;
                                        this.c = i5;
                                        if (i5 == this.b || this.f4199g[i5] != '\\') {
                                            return '?';
                                        }
                                        int i6 = i5 + 1;
                                        this.c = i6;
                                        int a3 = a(i6);
                                        this.c++;
                                        if ((a3 & 192) != 128) {
                                            return '?';
                                        }
                                        a2 = (a2 << 6) + (a3 & 63);
                                    }
                                }
                                return (char) a2;
                        }
                }
            }
            return cArr[i3];
        }
        StringBuilder h2 = a.h("Unexpected end of DN: ");
        h2.append(this.a);
        throw new IllegalStateException(h2.toString());
    }

    /* JADX WARNING: Removed duplicated region for block: B:6:0x0015 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x0017  */
    public final String c() {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        char[] cArr;
        while (true) {
            i2 = this.c;
            i3 = this.b;
            if (i2 < i3 && this.f4199g[i2] == ' ') {
                this.c = i2 + 1;
            } else if (i2 != i3) {
                return null;
            } else {
                this.f4196d = i2;
                do {
                    this.c = i2 + 1;
                    i2 = this.c;
                    i4 = this.b;
                    if (i2 >= i4) {
                        break;
                    }
                    cArr = this.f4199g;
                    if (cArr[i2] == '=') {
                        break;
                    }
                } while (cArr[i2] != ' ');
                if (i2 < i4) {
                    this.f4197e = i2;
                    if (this.f4199g[i2] == ' ') {
                        while (true) {
                            i5 = this.c;
                            i6 = this.b;
                            if (i5 >= i6) {
                                break;
                            }
                            char[] cArr2 = this.f4199g;
                            if (cArr2[i5] == '=' || cArr2[i5] != ' ') {
                                break;
                            }
                            this.c = i5 + 1;
                        }
                        if (this.f4199g[i5] != '=' || i5 == i6) {
                            StringBuilder h2 = a.h("Unexpected end of DN: ");
                            h2.append(this.a);
                            throw new IllegalStateException(h2.toString());
                        }
                    }
                    int i7 = this.c;
                    do {
                        this.c = i7 + 1;
                        i7 = this.c;
                        if (i7 >= this.b) {
                            break;
                        }
                    } while (this.f4199g[i7] == ' ');
                    int i8 = this.f4197e;
                    int i9 = this.f4196d;
                    if (i8 - i9 > 4) {
                        char[] cArr3 = this.f4199g;
                        if (cArr3[i9 + 3] == '.' && ((cArr3[i9] == 'O' || cArr3[i9] == 'o') && ((cArr3[i9 + 1] == 'I' || cArr3[i9 + 1] == 'i') && (cArr3[i9 + 2] == 'D' || cArr3[i9 + 2] == 'd')))) {
                            this.f4196d = i9 + 4;
                        }
                    }
                    char[] cArr4 = this.f4199g;
                    int i10 = this.f4196d;
                    return new String(cArr4, i10, this.f4197e - i10);
                }
                StringBuilder h3 = a.h("Unexpected end of DN: ");
                h3.append(this.a);
                throw new IllegalStateException(h3.toString());
            }
        }
        if (i2 != i3) {
        }
    }
}
