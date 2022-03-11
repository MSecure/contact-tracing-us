package f.b.e.a;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
/* loaded from: classes.dex */
public class a implements Closeable {
    public static final char[] p = ")]}'\n".toCharArray();
    public final Reader b;

    /* renamed from: i  reason: collision with root package name */
    public long f3775i;

    /* renamed from: j  reason: collision with root package name */
    public int f3776j;

    /* renamed from: k  reason: collision with root package name */
    public String f3777k;

    /* renamed from: l  reason: collision with root package name */
    public int[] f3778l;
    public int m;
    public final char[] c = new char[1024];

    /* renamed from: d  reason: collision with root package name */
    public int f3770d = 0;

    /* renamed from: e  reason: collision with root package name */
    public int f3771e = 0;

    /* renamed from: f  reason: collision with root package name */
    public int f3772f = 0;

    /* renamed from: g  reason: collision with root package name */
    public int f3773g = 0;

    /* renamed from: h  reason: collision with root package name */
    public int f3774h = 0;
    public String[] n = new String[32];
    public int[] o = new int[32];

    public a(Reader reader) {
        int[] iArr = new int[32];
        this.f3778l = iArr;
        this.m = 0;
        this.m = 1;
        iArr[0] = 6;
        this.b = reader;
    }

    public boolean J() {
        int i2 = this.f3774h;
        if (i2 == 0) {
            i2 = d();
        }
        return (i2 == 2 || i2 == 4) ? false : true;
    }

    public final boolean L(char c) {
        if (c == '\t' || c == '\n' || c == '\f' || c == '\r' || c == ' ') {
            return false;
        }
        if (c != '#') {
            if (c == ',') {
                return false;
            }
            if (!(c == '/' || c == '=')) {
                if (c == '{' || c == '}' || c == ':') {
                    return false;
                }
                if (c != ';') {
                    switch (c) {
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

    public String Q() {
        return " at line " + (this.f3772f + 1) + " column " + ((this.f3770d - this.f3773g) + 1) + " path " + x();
    }

    public final int R(boolean z) {
        char[] cArr = this.c;
        int i2 = this.f3770d;
        int i3 = this.f3771e;
        while (true) {
            if (i2 == i3) {
                this.f3770d = i2;
                if (t(1)) {
                    i2 = this.f3770d;
                    i3 = this.f3771e;
                } else if (!z) {
                    return -1;
                } else {
                    StringBuilder h2 = f.a.a.a.a.h("End of input");
                    h2.append(Q());
                    throw new EOFException(h2.toString());
                }
            }
            int i4 = i2 + 1;
            char c = cArr[i2];
            if (c == '\n') {
                this.f3772f++;
                this.f3773g = i4;
            } else if (!(c == ' ' || c == '\r' || c == '\t')) {
                if (c == '/') {
                    this.f3770d = i4;
                    if (i4 == i3) {
                        this.f3770d = i4 - 1;
                        boolean t = t(2);
                        this.f3770d++;
                        if (!t) {
                            return c;
                        }
                    }
                    c();
                    throw null;
                }
                this.f3770d = i4;
                if (c != '#') {
                    return c;
                }
                c();
                throw null;
            }
            i2 = i4;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:70:0x00ce, code lost:
        r0 = f.a.a.a.a.h("\\u");
        r0.append(new java.lang.String(r11.c, r11.f3770d, 4));
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00e9, code lost:
        throw new java.lang.NumberFormatException(r0.toString());
     */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public final String S(char c) {
        int i2;
        int i3;
        char[] cArr = this.c;
        StringBuilder sb = null;
        loop0: while (true) {
            int i4 = this.f3770d;
            int i5 = this.f3771e;
            int i6 = i4;
            while (true) {
                if (i6 < i5) {
                    int i7 = i6 + 1;
                    char c2 = cArr[i6];
                    if (c2 == c) {
                        this.f3770d = i7;
                        int i8 = (i7 - i4) - 1;
                        if (sb == null) {
                            return new String(cArr, i4, i8);
                        }
                        sb.append(cArr, i4, i8);
                        return sb.toString();
                    }
                    char c3 = '\n';
                    if (c2 == '\\') {
                        this.f3770d = i7;
                        int i9 = (i7 - i4) - 1;
                        if (sb == null) {
                            sb = new StringBuilder(Math.max((i9 + 1) * 2, 16));
                        }
                        sb.append(cArr, i4, i9);
                        if (this.f3770d != this.f3771e || t(1)) {
                            char[] cArr2 = this.c;
                            int i10 = this.f3770d;
                            int i11 = i10 + 1;
                            this.f3770d = i11;
                            char c4 = cArr2[i10];
                            if (c4 == '\n') {
                                this.f3772f++;
                                this.f3773g = i11;
                            } else if (!(c4 == '\"' || c4 == '\'' || c4 == '/' || c4 == '\\')) {
                                if (c4 == 'b') {
                                    c3 = '\b';
                                } else if (c4 == 'f') {
                                    c3 = '\f';
                                } else if (c4 != 'n') {
                                    if (c4 == 'r') {
                                        c3 = '\r';
                                    } else if (c4 == 't') {
                                        c3 = '\t';
                                    } else if (c4 != 'u') {
                                        W("Invalid escape sequence");
                                        throw null;
                                    } else if (i11 + 4 <= this.f3771e || t(4)) {
                                        c4 = 0;
                                        int i12 = this.f3770d;
                                        int i13 = i12 + 4;
                                        while (i12 < i13) {
                                            char c5 = this.c[i12];
                                            char c6 = (char) (c4 << 4);
                                            if (c5 < '0' || c5 > '9') {
                                                if (c5 >= 'a' && c5 <= 'f') {
                                                    i3 = c5 - 'a';
                                                } else if (c5 < 'A' || c5 > 'F') {
                                                    break loop0;
                                                } else {
                                                    i3 = c5 - 'A';
                                                }
                                                i2 = i3 + 10;
                                            } else {
                                                i2 = c5 - '0';
                                            }
                                            c4 = (char) (i2 + c6);
                                            i12++;
                                        }
                                        this.f3770d += 4;
                                    } else {
                                        W("Unterminated escape sequence");
                                        throw null;
                                    }
                                }
                                sb.append(c3);
                            }
                            c3 = c4;
                            sb.append(c3);
                        } else {
                            W("Unterminated escape sequence");
                            throw null;
                        }
                    } else {
                        if (c2 == '\n') {
                            this.f3772f++;
                            this.f3773g = i7;
                        }
                        i6 = i7;
                    }
                } else {
                    if (sb == null) {
                        sb = new StringBuilder(Math.max((i6 - i4) * 2, 16));
                    }
                    sb.append(cArr, i4, i6 - i4);
                    this.f3770d = i6;
                    if (!t(1)) {
                        W("Unterminated string");
                        throw null;
                    }
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x004b, code lost:
        c();
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x004e, code lost:
        throw null;
     */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x008b  */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public final String T() {
        String str;
        int i2 = 0;
        StringBuilder sb = null;
        do {
            int i3 = 0;
            while (true) {
                int i4 = this.f3770d;
                if (i4 + i3 < this.f3771e) {
                    char c = this.c[i4 + i3];
                    if (!(c == '\t' || c == '\n' || c == '\f' || c == '\r' || c == ' ')) {
                        if (c != '#') {
                            if (c != ',') {
                                if (!(c == '/' || c == '=')) {
                                    if (!(c == '{' || c == '}' || c == ':')) {
                                        if (c != ';') {
                                            switch (c) {
                                                case '[':
                                                case ']':
                                                    break;
                                                case '\\':
                                                    break;
                                                default:
                                                    i3++;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                } else if (i3 >= this.c.length) {
                    if (sb == null) {
                        sb = new StringBuilder(Math.max(i3, 16));
                    }
                    sb.append(this.c, this.f3770d, i3);
                    this.f3770d += i3;
                } else if (t(i3 + 1)) {
                }
            }
            i2 = i3;
            if (sb != null) {
                str = new String(this.c, this.f3770d, i2);
            } else {
                sb.append(this.c, this.f3770d, i2);
                str = sb.toString();
            }
            this.f3770d += i2;
            return str;
        } while (t(1));
        if (sb != null) {
        }
        this.f3770d += i2;
        return str;
    }

    public b U() {
        int i2 = this.f3774h;
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

    public final void V(int i2) {
        int i3 = this.m;
        int[] iArr = this.f3778l;
        if (i3 == iArr.length) {
            int i4 = i3 * 2;
            this.f3778l = Arrays.copyOf(iArr, i4);
            this.o = Arrays.copyOf(this.o, i4);
            this.n = (String[]) Arrays.copyOf(this.n, i4);
        }
        int[] iArr2 = this.f3778l;
        int i5 = this.m;
        this.m = i5 + 1;
        iArr2[i5] = i2;
    }

    public final IOException W(String str) {
        StringBuilder h2 = f.a.a.a.a.h(str);
        h2.append(Q());
        throw new c(h2.toString());
    }

    public final void c() {
        W("Use JsonReader.setLenient(true) to accept malformed JSON");
        throw null;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f3774h = 0;
        this.f3778l[0] = 8;
        this.m = 1;
        this.b.close();
    }

    /* JADX WARN: Code restructure failed: missing block: B:131:0x01a7, code lost:
        if (L(r15) != false) goto L_0x0130;
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x01a9, code lost:
        if (r8 != 2) goto L_0x01cd;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x01ab, code lost:
        if (r17 == false) goto L_0x01cd;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x01b1, code lost:
        if (r11 != Long.MIN_VALUE) goto L_0x01b5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x01b3, code lost:
        if (r18 == false) goto L_0x01cd;
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x01b9, code lost:
        if (r11 != 0) goto L_0x01bd;
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x01bb, code lost:
        if (r18 != false) goto L_0x01cd;
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x01bd, code lost:
        if (r18 == false) goto L_0x01c0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x01c0, code lost:
        r11 = -r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x01c1, code lost:
        r21.f3775i = r11;
        r21.f3770d += r7;
        r15 = 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x01cd, code lost:
        if (r8 == 2) goto L_0x01d5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x01d0, code lost:
        if (r8 == 4) goto L_0x01d5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x01d3, code lost:
        if (r8 != 7) goto L_0x0130;
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x01d5, code lost:
        r21.f3776j = r7;
        r15 = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x01db, code lost:
        r21.f3774h = r15;
     */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0209 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:169:0x020a  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0119 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x011a  */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public int d() {
        int i2;
        int i3;
        int i4;
        int i5;
        String str;
        String str2;
        char c;
        int R;
        int[] iArr = this.f3778l;
        int i6 = this.m;
        int i7 = iArr[i6 - 1];
        char c2 = 1;
        if (i7 == 1) {
            iArr[i6 - 1] = 2;
        } else if (i7 == 2) {
            int R2 = R(true);
            if (R2 != 44) {
                if (R2 == 59) {
                    c();
                    throw null;
                } else if (R2 == 93) {
                    this.f3774h = 4;
                    return 4;
                } else {
                    W("Unterminated array");
                    throw null;
                }
            }
        } else {
            if (i7 == 3 || i7 == 5) {
                iArr[i6 - 1] = 4;
                if (i7 != 5 || (R = R(true)) == 44) {
                    int R3 = R(true);
                    if (R3 == 34) {
                        i2 = 13;
                    } else if (R3 == 39) {
                        c();
                        throw null;
                    } else if (R3 != 125) {
                        c();
                        throw null;
                    } else if (i7 != 5) {
                        this.f3774h = 2;
                        return 2;
                    } else {
                        W("Expected name");
                        throw null;
                    }
                } else if (R == 59) {
                    c();
                    throw null;
                } else if (R == 125) {
                    this.f3774h = 2;
                    return 2;
                } else {
                    W("Unterminated object");
                    throw null;
                }
            } else if (i7 == 4) {
                iArr[i6 - 1] = 5;
                int R4 = R(true);
                if (R4 != 58) {
                    if (R4 != 61) {
                        W("Expected ':'");
                        throw null;
                    }
                    c();
                    throw null;
                }
            } else if (i7 == 6) {
                iArr[i6 - 1] = 7;
            } else if (i7 == 7) {
                if (R(false) == -1) {
                    i2 = 17;
                } else {
                    c();
                    throw null;
                }
            } else if (i7 == 8) {
                throw new IllegalStateException("JsonReader is closed");
            }
            this.f3774h = i2;
            return i2;
        }
        int R5 = R(true);
        if (R5 == 34) {
            i2 = 9;
        } else if (R5 != 39) {
            if (R5 == 44 || R5 == 59) {
                i3 = 1;
            } else if (R5 == 91) {
                this.f3774h = 3;
                return 3;
            } else if (R5 == 93) {
                i3 = 1;
                if (i7 == 1) {
                    this.f3774h = 4;
                    return 4;
                }
            } else if (R5 != 123) {
                int i8 = this.f3770d - 1;
                this.f3770d = i8;
                char c3 = this.c[i8];
                if (c3 == 't' || c3 == 'T') {
                    str2 = "true";
                    str = "TRUE";
                    i4 = 5;
                } else if (c3 == 'f' || c3 == 'F') {
                    str2 = "false";
                    str = "FALSE";
                    i4 = 6;
                } else {
                    if (c3 == 'n' || c3 == 'N') {
                        str2 = "null";
                        str = "NULL";
                        i4 = 7;
                    }
                    i4 = 0;
                    if (i4 == 0) {
                        return i4;
                    }
                    char[] cArr = this.c;
                    int i9 = this.f3770d;
                    int i10 = this.f3771e;
                    long j2 = 0;
                    long j3 = 0;
                    int i11 = 0;
                    char c4 = 0;
                    boolean z = true;
                    boolean z2 = false;
                    while (true) {
                        if (i9 + i11 == i10) {
                            if (i11 == cArr.length) {
                                break;
                            } else if (!t(i11 + 1)) {
                                break;
                            } else {
                                i9 = this.f3770d;
                                i10 = this.f3771e;
                            }
                        }
                        char c5 = cArr[i9 + i11];
                        if (c5 != '+') {
                            if (c5 == 'E' || c5 == 'e') {
                                if (c4 != 2 && c4 != 4) {
                                    break;
                                }
                                c4 = 5;
                                i11++;
                                c2 = 1;
                                j2 = 0;
                            } else if (c5 != '-') {
                                if (c5 == '.') {
                                    if (c4 != 2) {
                                        break;
                                    }
                                    c4 = 3;
                                    i11++;
                                    c2 = 1;
                                    j2 = 0;
                                } else if (c5 < '0' || c5 > '9') {
                                    break;
                                } else {
                                    if (c4 == c2 || c4 == 0) {
                                        j3 = (long) (-(c5 - '0'));
                                        c4 = 2;
                                    } else if (c4 == 2) {
                                        if (j3 == j2) {
                                            break;
                                        }
                                        long j4 = (10 * j3) - ((long) (c5 - '0'));
                                        int i12 = (j3 > -922337203685477580L ? 1 : (j3 == -922337203685477580L ? 0 : -1));
                                        z &= i12 > 0 || (i12 == 0 && j4 < j3);
                                        j3 = j4;
                                    } else if (c4 == 3) {
                                        c4 = 4;
                                    } else if (c4 == 5 || c4 == 6) {
                                        c4 = 7;
                                    }
                                    i11++;
                                    c2 = 1;
                                    j2 = 0;
                                }
                            } else if (c4 == 0) {
                                c4 = 1;
                                z2 = true;
                                i11++;
                                c2 = 1;
                                j2 = 0;
                            } else {
                                if (c4 != 5) {
                                    break;
                                }
                                c4 = 6;
                                i11++;
                                c2 = 1;
                                j2 = 0;
                            }
                            if (i5 == 0) {
                                return i5;
                            }
                            if (!L(this.c[this.f3770d])) {
                                W("Expected value");
                                throw null;
                            }
                            c();
                            throw null;
                        }
                        if (c4 != 5) {
                            break;
                        }
                        c4 = 6;
                        i11++;
                        c2 = 1;
                        j2 = 0;
                    }
                    i5 = 0;
                    if (i5 == 0) {
                    }
                }
                int length = str2.length();
                int i13 = 1;
                while (true) {
                    if (i13 < length) {
                        if ((this.f3770d + i13 >= this.f3771e && !t(i13 + 1)) || ((c = this.c[this.f3770d + i13]) != str2.charAt(i13) && c != str.charAt(i13))) {
                            break;
                        }
                        i13++;
                    } else if ((this.f3770d + length >= this.f3771e && !t(length + 1)) || !L(this.c[this.f3770d + length])) {
                        this.f3770d += length;
                        this.f3774h = i4;
                    }
                }
                i4 = 0;
                if (i4 == 0) {
                }
            } else {
                i2 = 1;
            }
            if (i7 == i3 || i7 == 2) {
                c();
                throw null;
            }
            W("Unexpected value");
            throw null;
        } else {
            c();
            throw null;
        }
        this.f3774h = i2;
        return i2;
    }

    public final boolean t(int i2) {
        int i3;
        int i4;
        char[] cArr = this.c;
        int i5 = this.f3773g;
        int i6 = this.f3770d;
        this.f3773g = i5 - i6;
        int i7 = this.f3771e;
        if (i7 != i6) {
            int i8 = i7 - i6;
            this.f3771e = i8;
            System.arraycopy(cArr, i6, cArr, 0, i8);
        } else {
            this.f3771e = 0;
        }
        this.f3770d = 0;
        do {
            Reader reader = this.b;
            int i9 = this.f3771e;
            int read = reader.read(cArr, i9, cArr.length - i9);
            if (read == -1) {
                return false;
            }
            i3 = this.f3771e + read;
            this.f3771e = i3;
            if (this.f3772f == 0 && (i4 = this.f3773g) == 0 && i3 > 0 && cArr[0] == 65279) {
                this.f3770d++;
                this.f3773g = i4 + 1;
                i2++;
                continue;
            }
        } while (i3 < i2);
        return true;
    }

    @Override // java.lang.Object
    public String toString() {
        return a.class.getSimpleName() + Q();
    }

    public String x() {
        StringBuilder sb = new StringBuilder();
        sb.append('$');
        int i2 = this.m;
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = this.f3778l[i3];
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
}
