package f.b.e.a;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;

public class a implements Closeable {
    public static final char[] p = ")]}'\n".toCharArray();
    public final Reader b;
    public final char[] c = new char[1024];

    /* renamed from: d  reason: collision with root package name */
    public int f3261d = 0;

    /* renamed from: e  reason: collision with root package name */
    public int f3262e = 0;

    /* renamed from: f  reason: collision with root package name */
    public int f3263f = 0;

    /* renamed from: g  reason: collision with root package name */
    public int f3264g = 0;

    /* renamed from: h  reason: collision with root package name */
    public int f3265h = 0;

    /* renamed from: i  reason: collision with root package name */
    public long f3266i;

    /* renamed from: j  reason: collision with root package name */
    public int f3267j;

    /* renamed from: k  reason: collision with root package name */
    public String f3268k;

    /* renamed from: l  reason: collision with root package name */
    public int[] f3269l;
    public int m;
    public String[] n;
    public int[] o;

    public a(Reader reader) {
        int[] iArr = new int[32];
        this.f3269l = iArr;
        this.m = 0;
        this.m = 1;
        iArr[0] = 6;
        this.n = new String[32];
        this.o = new int[32];
        this.b = reader;
    }

    public String A() {
        StringBuilder sb = new StringBuilder();
        sb.append('$');
        int i2 = this.m;
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = this.f3269l[i3];
            if (i4 == 1 || i4 == 2) {
                sb.append('[');
                sb.append(this.o[i3]);
                sb.append(']');
            } else if (i4 == 3 || i4 == 4 || i4 == 5) {
                sb.append('.');
                String[] strArr = this.n;
                if (strArr[i3] != null) {
                    sb.append(strArr[i3]);
                }
            }
        }
        return sb.toString();
    }

    public boolean N() {
        int i2 = this.f3265h;
        if (i2 == 0) {
            i2 = d();
        }
        return (i2 == 2 || i2 == 4) ? false : true;
    }

    public final boolean P(char c2) {
        if (c2 == '\t' || c2 == '\n' || c2 == '\f' || c2 == '\r' || c2 == ' ') {
            return false;
        }
        if (c2 != '#') {
            if (c2 == ',') {
                return false;
            }
            if (!(c2 == '/' || c2 == '=')) {
                if (c2 == '{' || c2 == '}' || c2 == ':') {
                    return false;
                }
                if (c2 != ';') {
                    switch (c2) {
                        case '[':
                        case ']':
                            return false;
                        case '\\':
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        c();
        throw null;
    }

    public String V() {
        return " at line " + (this.f3263f + 1) + " column " + ((this.f3261d - this.f3264g) + 1) + " path " + A();
    }

    public final int W(boolean z) {
        char[] cArr = this.c;
        int i2 = this.f3261d;
        int i3 = this.f3262e;
        while (true) {
            if (i2 == i3) {
                this.f3261d = i2;
                if (v(1)) {
                    i2 = this.f3261d;
                    i3 = this.f3262e;
                } else if (!z) {
                    return -1;
                } else {
                    StringBuilder h2 = f.a.a.a.a.h("End of input");
                    h2.append(V());
                    throw new EOFException(h2.toString());
                }
            }
            int i4 = i2 + 1;
            char c2 = cArr[i2];
            if (c2 == '\n') {
                this.f3263f++;
                this.f3264g = i4;
            } else if (!(c2 == ' ' || c2 == '\r' || c2 == '\t')) {
                if (c2 == '/') {
                    this.f3261d = i4;
                    if (i4 == i3) {
                        this.f3261d = i4 - 1;
                        boolean v = v(2);
                        this.f3261d++;
                        if (!v) {
                            return c2;
                        }
                    }
                    c();
                    throw null;
                }
                this.f3261d = i4;
                if (c2 != '#') {
                    return c2;
                }
                c();
                throw null;
            }
            i2 = i4;
        }
    }

    public final String X(char c2) {
        int i2;
        int i3;
        char[] cArr = this.c;
        StringBuilder sb = null;
        loop0:
        while (true) {
            int i4 = this.f3261d;
            int i5 = this.f3262e;
            int i6 = i4;
            while (true) {
                if (i6 < i5) {
                    int i7 = i6 + 1;
                    char c3 = cArr[i6];
                    if (c3 == c2) {
                        this.f3261d = i7;
                        int i8 = (i7 - i4) - 1;
                        if (sb == null) {
                            return new String(cArr, i4, i8);
                        }
                        sb.append(cArr, i4, i8);
                        return sb.toString();
                    }
                    char c4 = '\n';
                    if (c3 == '\\') {
                        this.f3261d = i7;
                        int i9 = (i7 - i4) - 1;
                        if (sb == null) {
                            sb = new StringBuilder(Math.max((i9 + 1) * 2, 16));
                        }
                        sb.append(cArr, i4, i9);
                        if (this.f3261d != this.f3262e || v(1)) {
                            char[] cArr2 = this.c;
                            int i10 = this.f3261d;
                            int i11 = i10 + 1;
                            this.f3261d = i11;
                            char c5 = cArr2[i10];
                            if (c5 == '\n') {
                                this.f3263f++;
                                this.f3264g = i11;
                            } else if (!(c5 == '\"' || c5 == '\'' || c5 == '/' || c5 == '\\')) {
                                if (c5 == 'b') {
                                    c4 = '\b';
                                } else if (c5 == 'f') {
                                    c4 = '\f';
                                } else if (c5 != 'n') {
                                    if (c5 == 'r') {
                                        c4 = '\r';
                                    } else if (c5 == 't') {
                                        c4 = '\t';
                                    } else if (c5 != 'u') {
                                        b0("Invalid escape sequence");
                                        throw null;
                                    } else if (i11 + 4 <= this.f3262e || v(4)) {
                                        c5 = 0;
                                        int i12 = this.f3261d;
                                        int i13 = i12 + 4;
                                        while (i12 < i13) {
                                            char c6 = this.c[i12];
                                            char c7 = (char) (c5 << 4);
                                            if (c6 < '0' || c6 > '9') {
                                                if (c6 >= 'a' && c6 <= 'f') {
                                                    i3 = c6 - 'a';
                                                } else if (c6 < 'A' || c6 > 'F') {
                                                    StringBuilder h2 = f.a.a.a.a.h("\\u");
                                                    h2.append(new String(this.c, this.f3261d, 4));
                                                } else {
                                                    i3 = c6 - 'A';
                                                }
                                                i2 = i3 + 10;
                                            } else {
                                                i2 = c6 - '0';
                                            }
                                            c5 = (char) (i2 + c7);
                                            i12++;
                                        }
                                        this.f3261d += 4;
                                    } else {
                                        b0("Unterminated escape sequence");
                                        throw null;
                                    }
                                }
                                sb.append(c4);
                            }
                            c4 = c5;
                            sb.append(c4);
                        } else {
                            b0("Unterminated escape sequence");
                            throw null;
                        }
                    } else {
                        if (c3 == '\n') {
                            this.f3263f++;
                            this.f3264g = i7;
                        }
                        i6 = i7;
                    }
                } else {
                    if (sb == null) {
                        sb = new StringBuilder(Math.max((i6 - i4) * 2, 16));
                    }
                    sb.append(cArr, i4, i6 - i4);
                    this.f3261d = i6;
                    if (!v(1)) {
                        b0("Unterminated string");
                        throw null;
                    }
                }
            }
        }
        StringBuilder h22 = f.a.a.a.a.h("\\u");
        h22.append(new String(this.c, this.f3261d, 4));
        throw new NumberFormatException(h22.toString());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x004b, code lost:
        c();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x004e, code lost:
        throw null;
     */
    public final String Y() {
        int i2;
        String str;
        int i3 = 0;
        StringBuilder sb = null;
        while (true) {
            i2 = 0;
            while (true) {
                int i4 = this.f3261d;
                if (i4 + i2 < this.f3262e) {
                    char c2 = this.c[i4 + i2];
                    if (!(c2 == '\t' || c2 == '\n' || c2 == '\f' || c2 == '\r' || c2 == ' ')) {
                        if (c2 != '#') {
                            if (c2 != ',') {
                                if (!(c2 == '/' || c2 == '=')) {
                                    if (!(c2 == '{' || c2 == '}' || c2 == ':')) {
                                        if (c2 != ';') {
                                            switch (c2) {
                                                case '[':
                                                case ']':
                                                    break;
                                                case '\\':
                                                    break;
                                                default:
                                                    i2++;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                } else if (i2 >= this.c.length) {
                    if (sb == null) {
                        sb = new StringBuilder(Math.max(i2, 16));
                    }
                    sb.append(this.c, this.f3261d, i2);
                    this.f3261d += i2;
                    if (!v(1)) {
                    }
                } else if (v(i2 + 1)) {
                }
            }
        }
        i3 = i2;
        if (sb == null) {
            str = new String(this.c, this.f3261d, i3);
        } else {
            sb.append(this.c, this.f3261d, i3);
            str = sb.toString();
        }
        this.f3261d += i3;
        return str;
    }

    public b Z() {
        int i2 = this.f3265h;
        if (i2 == 0) {
            i2 = d();
        }
        switch (i2) {
            case 1:
                return b.BEGIN_OBJECT;
            case 2:
                return b.END_OBJECT;
            case 3:
                return b.BEGIN_ARRAY;
            case 4:
                return b.END_ARRAY;
            case 5:
            case 6:
                return b.BOOLEAN;
            case 7:
                return b.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return b.STRING;
            case 12:
            case 13:
            case 14:
                return b.NAME;
            case 15:
            case 16:
                return b.NUMBER;
            case 17:
                return b.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    public final void a0(int i2) {
        int i3 = this.m;
        int[] iArr = this.f3269l;
        if (i3 == iArr.length) {
            int i4 = i3 * 2;
            this.f3269l = Arrays.copyOf(iArr, i4);
            this.o = Arrays.copyOf(this.o, i4);
            this.n = (String[]) Arrays.copyOf(this.n, i4);
        }
        int[] iArr2 = this.f3269l;
        int i5 = this.m;
        this.m = i5 + 1;
        iArr2[i5] = i2;
    }

    public final IOException b0(String str) {
        StringBuilder h2 = f.a.a.a.a.h(str);
        h2.append(V());
        throw new c(h2.toString());
    }

    public final void c() {
        b0("Use JsonReader.setLenient(true) to accept malformed JSON");
        throw null;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f3265h = 0;
        this.f3269l[0] = 8;
        this.m = 1;
        this.b.close();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:129:0x01a7, code lost:
        if (P(r15) != false) goto L_0x0130;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x01a9, code lost:
        if (r8 != 2) goto L_0x01cd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x01ab, code lost:
        if (r17 == false) goto L_0x01cd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x01b1, code lost:
        if (r11 != Long.MIN_VALUE) goto L_0x01b5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x01b3, code lost:
        if (r18 == false) goto L_0x01cd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x01b9, code lost:
        if (r11 != 0) goto L_0x01bd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:137:0x01bb, code lost:
        if (r18 != false) goto L_0x01cd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x01bd, code lost:
        if (r18 == false) goto L_0x01c0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x01c0, code lost:
        r11 = -r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x01c1, code lost:
        r21.f3266i = r11;
        r21.f3261d += r7;
        r15 = 15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x01cd, code lost:
        if (r8 == 2) goto L_0x01d5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x01d0, code lost:
        if (r8 == 4) goto L_0x01d5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x01d3, code lost:
        if (r8 != 7) goto L_0x0130;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x01d5, code lost:
        r21.f3267j = r7;
        r15 = 16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:0x01db, code lost:
        r21.f3265h = r15;
     */
    /* JADX WARNING: Removed duplicated region for block: B:189:0x0241  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0119 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x011a  */
    public int d() {
        int W;
        int i2;
        int i3;
        int i4;
        String str;
        String str2;
        char c2;
        int W2;
        int[] iArr = this.f3269l;
        int i5 = this.m;
        int i6 = iArr[i5 - 1];
        char c3 = 1;
        if (i6 == 1) {
            iArr[i5 - 1] = 2;
            W = W(true);
            if (W != 34) {
                i2 = 9;
            } else if (W != 39) {
                if (W == 44 || W == 59) {
                    i3 = 1;
                } else if (W == 91) {
                    this.f3265h = 3;
                    return 3;
                } else if (W == 93) {
                    i3 = 1;
                    if (i6 == 1) {
                        this.f3265h = 4;
                        return 4;
                    }
                } else if (W != 123) {
                    int i7 = this.f3261d - 1;
                    this.f3261d = i7;
                    char c4 = this.c[i7];
                    if (c4 == 't' || c4 == 'T') {
                        str2 = "true";
                        str = "TRUE";
                        i4 = 5;
                    } else if (c4 == 'f' || c4 == 'F') {
                        str2 = "false";
                        str = "FALSE";
                        i4 = 6;
                    } else {
                        if (c4 == 'n' || c4 == 'N') {
                            str2 = "null";
                            str = "NULL";
                            i4 = 7;
                        }
                        i4 = 0;
                        if (i4 == 0) {
                            return i4;
                        }
                        char[] cArr = this.c;
                        int i8 = this.f3261d;
                        int i9 = this.f3262e;
                        long j2 = 0;
                        long j3 = 0;
                        int i10 = 0;
                        char c5 = 0;
                        boolean z = true;
                        boolean z2 = false;
                        while (true) {
                            if (i8 + i10 == i9) {
                                if (i10 == cArr.length) {
                                    break;
                                } else if (!v(i10 + 1)) {
                                    break;
                                } else {
                                    i8 = this.f3261d;
                                    i9 = this.f3262e;
                                }
                            }
                            char c6 = cArr[i8 + i10];
                            if (c6 == '+') {
                                if (c5 != 5) {
                                    break;
                                }
                            } else if (c6 != 'E' && c6 != 'e') {
                                if (c6 == '-') {
                                    if (c5 != 0) {
                                        if (c5 != 5) {
                                            break;
                                        }
                                    } else {
                                        c5 = 1;
                                        z2 = true;
                                        i10++;
                                        c3 = 1;
                                        j2 = 0;
                                    }
                                } else if (c6 == '.') {
                                    if (c5 != 2) {
                                        break;
                                    }
                                    c5 = 3;
                                    i10++;
                                    c3 = 1;
                                    j2 = 0;
                                } else if (c6 >= '0' && c6 <= '9') {
                                    if (c5 == c3 || c5 == 0) {
                                        j3 = (long) (-(c6 - '0'));
                                        c5 = 2;
                                    } else if (c5 == 2) {
                                        if (j3 == j2) {
                                            break;
                                        }
                                        long j4 = (10 * j3) - ((long) (c6 - '0'));
                                        int i11 = (j3 > -922337203685477580L ? 1 : (j3 == -922337203685477580L ? 0 : -1));
                                        z &= i11 > 0 || (i11 == 0 && j4 < j3);
                                        j3 = j4;
                                    } else if (c5 == 3) {
                                        c5 = 4;
                                    } else if (c5 == 5 || c5 == 6) {
                                        c5 = 7;
                                    }
                                    i10++;
                                    c3 = 1;
                                    j2 = 0;
                                }
                            } else if (c5 != 2 && c5 != 4) {
                                break;
                            } else {
                                c5 = 5;
                                i10++;
                                c3 = 1;
                                j2 = 0;
                            }
                            c5 = 6;
                            i10++;
                            c3 = 1;
                            j2 = 0;
                        }
                        int i12 = 0;
                        if (i12 != 0) {
                            return i12;
                        }
                        if (!P(this.c[this.f3261d])) {
                            b0("Expected value");
                            throw null;
                        }
                        c();
                        throw null;
                    }
                    int length = str2.length();
                    int i13 = 1;
                    while (true) {
                        if (i13 < length) {
                            if ((this.f3261d + i13 >= this.f3262e && !v(i13 + 1)) || ((c2 = this.c[this.f3261d + i13]) != str2.charAt(i13) && c2 != str.charAt(i13))) {
                                break;
                            }
                            i13++;
                        } else if ((this.f3261d + length >= this.f3262e && !v(length + 1)) || !P(this.c[this.f3261d + length])) {
                            this.f3261d += length;
                            this.f3265h = i4;
                        }
                    }
                    i4 = 0;
                    if (i4 == 0) {
                    }
                } else {
                    i2 = 1;
                }
                if (i6 == i3 || i6 == 2) {
                    c();
                    throw null;
                }
                b0("Unexpected value");
                throw null;
            } else {
                c();
                throw null;
            }
        } else {
            if (i6 == 2) {
                int W3 = W(true);
                if (W3 != 44) {
                    if (W3 == 59) {
                        c();
                        throw null;
                    } else if (W3 == 93) {
                        this.f3265h = 4;
                        return 4;
                    } else {
                        b0("Unterminated array");
                        throw null;
                    }
                }
            } else if (i6 == 3 || i6 == 5) {
                iArr[i5 - 1] = 4;
                if (i6 != 5 || (W2 = W(true)) == 44) {
                    int W4 = W(true);
                    if (W4 == 34) {
                        i2 = 13;
                    } else if (W4 == 39) {
                        c();
                        throw null;
                    } else if (W4 != 125) {
                        c();
                        throw null;
                    } else if (i6 != 5) {
                        this.f3265h = 2;
                        return 2;
                    } else {
                        b0("Expected name");
                        throw null;
                    }
                } else if (W2 == 59) {
                    c();
                    throw null;
                } else if (W2 == 125) {
                    this.f3265h = 2;
                    return 2;
                } else {
                    b0("Unterminated object");
                    throw null;
                }
            } else if (i6 == 4) {
                iArr[i5 - 1] = 5;
                int W5 = W(true);
                if (W5 != 58) {
                    if (W5 != 61) {
                        b0("Expected ':'");
                        throw null;
                    }
                    c();
                    throw null;
                }
            } else if (i6 == 6) {
                iArr[i5 - 1] = 7;
            } else if (i6 == 7) {
                if (W(false) == -1) {
                    i2 = 17;
                } else {
                    c();
                    throw null;
                }
            } else if (i6 == 8) {
                throw new IllegalStateException("JsonReader is closed");
            }
            W = W(true);
            if (W != 34) {
            }
        }
        this.f3265h = i2;
        return i2;
    }

    public String toString() {
        return a.class.getSimpleName() + V();
    }

    public final boolean v(int i2) {
        int i3;
        int i4;
        char[] cArr = this.c;
        int i5 = this.f3264g;
        int i6 = this.f3261d;
        this.f3264g = i5 - i6;
        int i7 = this.f3262e;
        if (i7 != i6) {
            int i8 = i7 - i6;
            this.f3262e = i8;
            System.arraycopy(cArr, i6, cArr, 0, i8);
        } else {
            this.f3262e = 0;
        }
        this.f3261d = 0;
        do {
            Reader reader = this.b;
            int i9 = this.f3262e;
            int read = reader.read(cArr, i9, cArr.length - i9);
            if (read == -1) {
                return false;
            }
            i3 = this.f3262e + read;
            this.f3262e = i3;
            if (this.f3263f == 0 && (i4 = this.f3264g) == 0 && i3 > 0 && cArr[0] == 65279) {
                this.f3261d++;
                this.f3264g = i4 + 1;
                i2++;
                continue;
            }
        } while (i3 < i2);
        return true;
    }
}
