package k;

import f.a.a.a.a;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class h implements Serializable, Comparable<h> {

    /* renamed from: e  reason: collision with root package name */
    public static final char[] f4006e = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: f  reason: collision with root package name */
    public static final h f4007f = f(new byte[0]);
    public final byte[] b;
    public transient int c;

    /* renamed from: d  reason: collision with root package name */
    public transient String f4008d;

    public h(byte[] bArr) {
        this.b = bArr;
    }

    public static h b(String str) {
        if (str != null) {
            h hVar = new h(str.getBytes(u.a));
            hVar.f4008d = str;
            return hVar;
        }
        throw new IllegalArgumentException("s == null");
    }

    public static h f(byte... bArr) {
        if (bArr != null) {
            return new h((byte[]) bArr.clone());
        }
        throw new IllegalArgumentException("data == null");
    }

    public String a() {
        byte[] bArr = this.b;
        byte[] bArr2 = d.a;
        byte[] bArr3 = new byte[(((bArr.length + 2) / 3) * 4)];
        int length = bArr.length - (bArr.length % 3);
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3 += 3) {
            int i4 = i2 + 1;
            bArr3[i2] = bArr2[(bArr[i3] & 255) >> 2];
            int i5 = i4 + 1;
            int i6 = i3 + 1;
            bArr3[i4] = bArr2[((bArr[i3] & 3) << 4) | ((bArr[i6] & 255) >> 4)];
            int i7 = i5 + 1;
            int i8 = i3 + 2;
            bArr3[i5] = bArr2[((bArr[i6] & 15) << 2) | ((bArr[i8] & 255) >> 6)];
            i2 = i7 + 1;
            bArr3[i7] = bArr2[bArr[i8] & 63];
        }
        int length2 = bArr.length % 3;
        if (length2 == 1) {
            int i9 = i2 + 1;
            bArr3[i2] = bArr2[(bArr[length] & 255) >> 2];
            int i10 = i9 + 1;
            bArr3[i9] = bArr2[(bArr[length] & 3) << 4];
            bArr3[i10] = 61;
            bArr3[i10 + 1] = 61;
        } else if (length2 == 2) {
            int i11 = i2 + 1;
            bArr3[i2] = bArr2[(bArr[length] & 255) >> 2];
            int i12 = i11 + 1;
            int i13 = length + 1;
            bArr3[i11] = bArr2[((bArr[i13] & 255) >> 4) | ((bArr[length] & 3) << 4)];
            bArr3[i12] = bArr2[(bArr[i13] & 15) << 2];
            bArr3[i12 + 1] = 61;
        }
        try {
            return new String(bArr3, "US-ASCII");
        } catch (UnsupportedEncodingException e2) {
            throw new AssertionError(e2);
        }
    }

    public byte c(int i2) {
        return this.b[i2];
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x0027 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029 A[RETURN, SYNTHETIC] */
    @Override // java.lang.Comparable
    public int compareTo(h hVar) {
        h hVar2 = hVar;
        int l2 = l();
        int l3 = hVar2.l();
        int min = Math.min(l2, l3);
        for (int i2 = 0; i2 < min; i2++) {
            int c2 = c(i2) & 255;
            int c3 = hVar2.c(i2) & 255;
            if (c2 != c3) {
                return c2 < c3 ? -1 : 1;
            }
        }
        if (l2 == l3) {
            return 0;
        }
        if (l2 < l3) {
        }
    }

    public String e() {
        byte[] bArr = this.b;
        char[] cArr = new char[(bArr.length * 2)];
        int i2 = 0;
        for (byte b2 : bArr) {
            int i3 = i2 + 1;
            char[] cArr2 = f4006e;
            cArr[i2] = cArr2[(b2 >> 4) & 15];
            i2 = i3 + 1;
            cArr[i3] = cArr2[b2 & 15];
        }
        return new String(cArr);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof h) {
            h hVar = (h) obj;
            int l2 = hVar.l();
            byte[] bArr = this.b;
            return l2 == bArr.length && hVar.i(0, bArr, 0, bArr.length);
        }
    }

    public boolean h(int i2, h hVar, int i3, int i4) {
        return hVar.i(i3, this.b, i2, i4);
    }

    public int hashCode() {
        int i2 = this.c;
        if (i2 != 0) {
            return i2;
        }
        int hashCode = Arrays.hashCode(this.b);
        this.c = hashCode;
        return hashCode;
    }

    public boolean i(int i2, byte[] bArr, int i3, int i4) {
        if (i2 >= 0) {
            byte[] bArr2 = this.b;
            return i2 <= bArr2.length - i4 && i3 >= 0 && i3 <= bArr.length - i4 && u.a(bArr2, i2, bArr, i3, i4);
        }
    }

    public int l() {
        return this.b.length;
    }

    public h m(int i2, int i3) {
        if (i2 >= 0) {
            byte[] bArr = this.b;
            if (i3 <= bArr.length) {
                int i4 = i3 - i2;
                if (i4 < 0) {
                    throw new IllegalArgumentException("endIndex < beginIndex");
                } else if (i2 == 0 && i3 == bArr.length) {
                    return this;
                } else {
                    byte[] bArr2 = new byte[i4];
                    System.arraycopy(bArr, i2, bArr2, 0, i4);
                    return new h(bArr2);
                }
            } else {
                StringBuilder h2 = a.h("endIndex > length(");
                h2.append(this.b.length);
                h2.append(")");
                throw new IllegalArgumentException(h2.toString());
            }
        } else {
            throw new IllegalArgumentException("beginIndex < 0");
        }
    }

    public h n() {
        int i2 = 0;
        while (true) {
            byte[] bArr = this.b;
            if (i2 >= bArr.length) {
                return this;
            }
            byte b2 = bArr[i2];
            if (b2 < 65 || b2 > 90) {
                i2++;
            } else {
                byte[] bArr2 = (byte[]) bArr.clone();
                bArr2[i2] = (byte) (b2 + 32);
                for (int i3 = i2 + 1; i3 < bArr2.length; i3++) {
                    byte b3 = bArr2[i3];
                    if (b3 >= 65 && b3 <= 90) {
                        bArr2[i3] = (byte) (b3 + 32);
                    }
                }
                return new h(bArr2);
            }
        }
    }

    public byte[] o() {
        return (byte[]) this.b.clone();
    }

    public String q() {
        String str = this.f4008d;
        if (str != null) {
            return str;
        }
        String str2 = new String(this.b, u.a);
        this.f4008d = str2;
        return str2;
    }

    public void r(e eVar) {
        byte[] bArr = this.b;
        eVar.a0(bArr, 0, bArr.length);
    }

    public String toString() {
        StringBuilder sb;
        StringBuilder sb2;
        if (this.b.length == 0) {
            return "[size=0]";
        }
        String q = q();
        int length = q.length();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i2 >= length) {
                i2 = q.length();
                break;
            } else if (i3 == 64) {
                break;
            } else {
                int codePointAt = q.codePointAt(i2);
                if ((!Character.isISOControl(codePointAt) || codePointAt == 10 || codePointAt == 13) && codePointAt != 65533) {
                    i3++;
                    i2 += Character.charCount(codePointAt);
                }
            }
        }
        i2 = -1;
        if (i2 == -1) {
            if (this.b.length <= 64) {
                sb2 = a.h("[hex=");
                sb2.append(e());
                sb2.append("]");
            } else {
                sb2 = a.h("[size=");
                sb2.append(this.b.length);
                sb2.append(" hex=");
                sb2.append(m(0, 64).e());
                sb2.append("…]");
            }
            return sb2.toString();
        }
        String replace = q.substring(0, i2).replace("\\", "\\\\").replace("\n", "\\n").replace("\r", "\\r");
        if (i2 < q.length()) {
            sb = a.h("[size=");
            sb.append(this.b.length);
            sb.append(" text=");
            sb.append(replace);
            sb.append("…]");
        } else {
            sb = a.j("[text=", replace, "]");
        }
        return sb.toString();
    }
}
