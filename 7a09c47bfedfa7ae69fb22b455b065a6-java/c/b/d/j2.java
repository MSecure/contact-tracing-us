package c.b.d;

import b.x.t;
import c.b.d.j;
import c.b.d.n2;
import c.b.d.q2;
import c.b.d.r;
import c.b.d.s;
import c.b.d.u;
import java.io.IOException;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public final class j2 {

    public static class b extends IOException {
        public b(String str) {
            super(str);
        }
    }

    public static final class c {

        /* renamed from: c  reason: collision with root package name */
        public static final c f5329c = new c(true, n2.a.f5445a);

        /* renamed from: a  reason: collision with root package name */
        public final boolean f5330a;

        /* renamed from: b  reason: collision with root package name */
        public final n2 f5331b;

        public c(boolean z, n2 n2Var) {
            this.f5330a = z;
            this.f5331b = n2Var;
        }

        public static void d(int i, int i2, List<?> list, d dVar) {
            String str;
            for (Object obj : list) {
                dVar.d(String.valueOf(i));
                dVar.d(": ");
                int i3 = i2 & 7;
                if (i3 == 0) {
                    str = j2.l(((Long) obj).longValue());
                } else if (i3 == 1) {
                    str = String.format(null, "0x%016x", (Long) obj);
                } else if (i3 == 2) {
                    try {
                        j jVar = (j) obj;
                        q2.b b2 = q2.b();
                        try {
                            k q = jVar.q();
                            b2.f(q);
                            q.a(0);
                            q2 b3 = b2.build();
                            dVar.d("{");
                            dVar.a();
                            dVar.b();
                            e(b3, dVar);
                            dVar.c();
                            dVar.d("}");
                        } catch (o0 e2) {
                            throw e2;
                        } catch (IOException e3) {
                            throw new RuntimeException("Reading from a ByteString threw an IOException (should never happen).", e3);
                        }
                    } catch (o0 unused) {
                        dVar.d("\"");
                        dVar.d(j2.c((j) obj));
                        str = "\"";
                    }
                    dVar.a();
                } else if (i3 == 3) {
                    e((q2) obj, dVar);
                    dVar.a();
                } else if (i3 == 5) {
                    str = String.format(null, "0x%08x", (Integer) obj);
                } else {
                    throw new IllegalArgumentException(c.a.a.a.a.n("Bad tag: ", i2));
                }
                dVar.d(str);
                dVar.a();
            }
        }

        public static void e(q2 q2Var, d dVar) {
            for (Map.Entry<Integer, q2.c> entry : q2Var.f5484b.entrySet()) {
                int intValue = entry.getKey().intValue();
                q2.c value = entry.getValue();
                d(intValue, 0, value.f5489a, dVar);
                d(intValue, 5, value.f5490b, dVar);
                d(intValue, 1, value.f5491c, dVar);
                d(intValue, 2, value.f5492d, dVar);
                for (q2 q2Var2 : value.f5493e) {
                    dVar.d(entry.getKey().toString());
                    dVar.d(" {");
                    dVar.a();
                    dVar.b();
                    e(q2Var2, dVar);
                    dVar.c();
                    dVar.d("}");
                    dVar.a();
                }
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:21:0x007a A[RETURN] */
        public final void a(k1 k1Var, d dVar) {
            if (k1Var.getDescriptorForType().f5789b.equals("google.protobuf.Any")) {
                s.b descriptorForType = k1Var.getDescriptorForType();
                boolean z = true;
                s.g n = descriptorForType.n(1);
                s.g n2 = descriptorForType.n(2);
                if (n != null && n.f5823g == s.g.b.STRING && n2 != null && n2.f5823g == s.g.b.BYTES) {
                    String str = (String) k1Var.getField(n);
                    if (!str.isEmpty()) {
                        Object field = k1Var.getField(n2);
                        try {
                            s.b a2 = this.f5331b.a(str);
                            if (a2 != null) {
                                u.b c2 = u.a(a2).newBuilderForType();
                                c2.mergeFrom((j) field);
                                dVar.d("[");
                                dVar.d(str);
                                dVar.d("] {");
                                dVar.a();
                                dVar.b();
                                a(c2, dVar);
                                dVar.c();
                                dVar.d("}");
                                dVar.a();
                                if (z) {
                                    return;
                                }
                            }
                        } catch (o0 unused) {
                        }
                    }
                }
                z = false;
                if (z) {
                }
            }
            for (Map.Entry<s.g, Object> entry : k1Var.getAllFields().entrySet()) {
                s.g key = entry.getKey();
                Object value = entry.getValue();
                if (key.e()) {
                    for (Object obj : (List) value) {
                        b(key, obj, dVar);
                    }
                } else {
                    b(key, value, dVar);
                }
            }
            e(k1Var.getUnknownFields(), dVar);
        }

        public final void b(s.g gVar, Object obj, d dVar) {
            String str;
            String str2;
            String str3;
            String str4;
            if (gVar.s()) {
                dVar.d("[");
                if (gVar.h.s().f5663d && gVar.f5823g == s.g.b.MESSAGE) {
                    if (gVar.f5819c.d() == r.h.c.LABEL_OPTIONAL) {
                        if (!gVar.s()) {
                            throw new UnsupportedOperationException(String.format("This field is not an extension. (%s)", gVar.f5820d));
                        } else if (gVar.f5822f == gVar.p()) {
                            str4 = gVar.p().f5789b;
                            dVar.d(str4);
                            str = "]";
                        }
                    }
                }
                str4 = gVar.f5820d;
                dVar.d(str4);
                str = "]";
            } else {
                str = gVar.f5823g == s.g.b.GROUP ? gVar.p().f() : gVar.f();
            }
            dVar.d(str);
            if (gVar.f5823g.f5835b == s.g.a.MESSAGE) {
                dVar.d(" {");
                dVar.a();
                dVar.b();
            } else {
                dVar.d(": ");
            }
            switch (gVar.f5823g.ordinal()) {
                case 0:
                    str2 = ((Double) obj).toString();
                    dVar.d(str2);
                    break;
                case 1:
                    str2 = ((Float) obj).toString();
                    dVar.d(str2);
                    break;
                case 2:
                case 15:
                case 17:
                    str2 = ((Long) obj).toString();
                    dVar.d(str2);
                    break;
                case 3:
                case 5:
                    str2 = j2.l(((Long) obj).longValue());
                    dVar.d(str2);
                    break;
                case 4:
                case 14:
                case 16:
                    str2 = ((Integer) obj).toString();
                    dVar.d(str2);
                    break;
                case 6:
                case 12:
                    str2 = j2.k(((Integer) obj).intValue());
                    dVar.d(str2);
                    break;
                case 7:
                    str2 = ((Boolean) obj).toString();
                    dVar.d(str2);
                    break;
                case 8:
                    dVar.d("\"");
                    String str5 = (String) obj;
                    str3 = this.f5330a ? t.p1(j.h(str5)) : j2.e(str5).replace("\n", "\\n");
                    dVar.d(str3);
                    dVar.d("\"");
                    break;
                case 9:
                case 10:
                    a((f1) obj, dVar);
                    break;
                case 11:
                    dVar.d("\"");
                    str3 = obj instanceof j ? j2.c((j) obj) : j2.d((byte[]) obj);
                    dVar.d(str3);
                    dVar.d("\"");
                    break;
                case 13:
                    str2 = ((s.f) obj).f5814b.a();
                    dVar.d(str2);
                    break;
            }
            if (gVar.f5823g.f5835b == s.g.a.MESSAGE) {
                dVar.c();
                dVar.d("}");
            }
            dVar.a();
        }

        public String c(k1 k1Var) {
            try {
                StringBuilder sb = new StringBuilder();
                a(k1Var, j2.a(sb));
                return sb.toString();
            } catch (IOException e2) {
                throw new IllegalStateException(e2);
            }
        }
    }

    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        public final Appendable f5332a;

        /* renamed from: b  reason: collision with root package name */
        public final StringBuilder f5333b = new StringBuilder();

        /* renamed from: c  reason: collision with root package name */
        public final boolean f5334c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f5335d = false;

        public d(Appendable appendable, boolean z, a aVar) {
            this.f5332a = appendable;
            this.f5334c = z;
        }

        public void a() {
            if (!this.f5334c) {
                this.f5332a.append("\n");
            }
            this.f5335d = true;
        }

        public void b() {
            this.f5333b.append("  ");
        }

        public void c() {
            int length = this.f5333b.length();
            if (length != 0) {
                this.f5333b.setLength(length - 2);
                return;
            }
            throw new IllegalArgumentException(" Outdent() without matching Indent().");
        }

        public void d(CharSequence charSequence) {
            if (this.f5335d) {
                this.f5335d = false;
                this.f5332a.append(this.f5334c ? " " : this.f5333b);
            }
            this.f5332a.append(charSequence);
        }
    }

    static {
        Logger.getLogger(j2.class.getName());
        n2.b();
    }

    public static d a(Appendable appendable) {
        return new d(appendable, false, null);
    }

    public static int b(byte b2) {
        if (48 <= b2 && b2 <= 57) {
            return b2 - 48;
        }
        return ((97 > b2 || b2 > 122) ? b2 - 65 : b2 - 97) + 10;
    }

    public static String c(j jVar) {
        return t.p1(jVar);
    }

    public static String d(byte[] bArr) {
        return t.q1(new l2(bArr));
    }

    public static String e(String str) {
        return str.replace("\\", "\\\\").replace("\"", "\\\"");
    }

    public static boolean f(byte b2) {
        return (48 <= b2 && b2 <= 57) || (97 <= b2 && b2 <= 102) || (65 <= b2 && b2 <= 70);
    }

    public static boolean g(byte b2) {
        return 48 <= b2 && b2 <= 55;
    }

    public static long h(String str, boolean z, boolean z2) {
        int i;
        int i2;
        int i3 = 0;
        if (str.startsWith("-", 0)) {
            if (z) {
                i3 = 1;
            } else {
                throw new NumberFormatException(c.a.a.a.a.q("Number must be positive: ", str));
            }
        }
        int i4 = 10;
        if (str.startsWith("0x", i3)) {
            i2 = i3 + 2;
            i = 16;
        } else {
            if (str.startsWith("0", i3)) {
                i4 = 8;
            }
            i = i4;
            i2 = i3;
        }
        String substring = str.substring(i2);
        if (substring.length() < 16) {
            long parseLong = Long.parseLong(substring, i);
            if (i3 != 0) {
                parseLong = -parseLong;
            }
            if (z2) {
                return parseLong;
            }
            if (z) {
                if (parseLong <= 2147483647L && parseLong >= -2147483648L) {
                    return parseLong;
                }
                throw new NumberFormatException(c.a.a.a.a.q("Number out of range for 32-bit signed integer: ", str));
            } else if (parseLong < 4294967296L && parseLong >= 0) {
                return parseLong;
            } else {
                throw new NumberFormatException(c.a.a.a.a.q("Number out of range for 32-bit unsigned integer: ", str));
            }
        } else {
            BigInteger bigInteger = new BigInteger(substring, i);
            if (i3 != 0) {
                bigInteger = bigInteger.negate();
            }
            if (!z2) {
                if (z) {
                    if (bigInteger.bitLength() > 31) {
                        throw new NumberFormatException(c.a.a.a.a.q("Number out of range for 32-bit signed integer: ", str));
                    }
                } else if (bigInteger.bitLength() > 32) {
                    throw new NumberFormatException(c.a.a.a.a.q("Number out of range for 32-bit unsigned integer: ", str));
                }
            } else if (z) {
                if (bigInteger.bitLength() > 63) {
                    throw new NumberFormatException(c.a.a.a.a.q("Number out of range for 64-bit signed integer: ", str));
                }
            } else if (bigInteger.bitLength() > 64) {
                throw new NumberFormatException(c.a.a.a.a.q("Number out of range for 64-bit unsigned integer: ", str));
            }
            return bigInteger.longValue();
        }
    }

    public static c i() {
        return c.f5329c;
    }

    public static j j(CharSequence charSequence) {
        int i;
        int i2;
        j.g gVar = (j.g) j.h(charSequence.toString());
        int length = gVar.f5327e.length;
        byte[] bArr = new byte[length];
        int i3 = 0;
        int i4 = 0;
        while (true) {
            byte[] bArr2 = gVar.f5327e;
            if (i3 < bArr2.length) {
                byte b2 = bArr2[i3];
                if (b2 == 92) {
                    i3++;
                    if (i3 < bArr2.length) {
                        byte b3 = bArr2[i3];
                        if (g(b3)) {
                            int b4 = b(b3);
                            int i5 = i3 + 1;
                            byte[] bArr3 = gVar.f5327e;
                            if (i5 < bArr3.length && g(bArr3[i5])) {
                                b4 = (b4 * 8) + b(gVar.f5327e[i5]);
                                i3 = i5;
                            }
                            int i6 = i3 + 1;
                            byte[] bArr4 = gVar.f5327e;
                            if (i6 < bArr4.length && g(bArr4[i6])) {
                                b4 = (b4 * 8) + b(gVar.f5327e[i6]);
                                i3 = i6;
                            }
                            i2 = i4 + 1;
                            bArr[i4] = (byte) b4;
                        } else if (b3 == 34) {
                            i = i4 + 1;
                            bArr[i4] = 34;
                        } else if (b3 == 39) {
                            i = i4 + 1;
                            bArr[i4] = 39;
                        } else if (b3 == 92) {
                            i = i4 + 1;
                            bArr[i4] = 92;
                        } else if (b3 == 102) {
                            i = i4 + 1;
                            bArr[i4] = 12;
                        } else if (b3 == 110) {
                            i = i4 + 1;
                            bArr[i4] = 10;
                        } else if (b3 == 114) {
                            i = i4 + 1;
                            bArr[i4] = 13;
                        } else if (b3 == 116) {
                            i = i4 + 1;
                            bArr[i4] = 9;
                        } else if (b3 == 118) {
                            i = i4 + 1;
                            bArr[i4] = 11;
                        } else if (b3 == 120) {
                            i3++;
                            byte[] bArr5 = gVar.f5327e;
                            if (i3 < bArr5.length && f(bArr5[i3])) {
                                int b5 = b(gVar.f5327e[i3]);
                                int i7 = i3 + 1;
                                byte[] bArr6 = gVar.f5327e;
                                if (i7 < bArr6.length && f(bArr6[i7])) {
                                    b5 = (b5 * 16) + b(gVar.f5327e[i7]);
                                    i3 = i7;
                                }
                                i2 = i4 + 1;
                                bArr[i4] = (byte) b5;
                            }
                        } else if (b3 == 97) {
                            i = i4 + 1;
                            bArr[i4] = 7;
                        } else if (b3 == 98) {
                            i = i4 + 1;
                            bArr[i4] = 8;
                        } else {
                            StringBuilder h = c.a.a.a.a.h("Invalid escape sequence: '\\");
                            h.append((char) b3);
                            h.append('\'');
                            throw new b(h.toString());
                        }
                        i4 = i2;
                        i3++;
                    } else {
                        throw new b("Invalid escape sequence: '\\' at end of string.");
                    }
                } else {
                    i = i4 + 1;
                    bArr[i4] = b2;
                }
                i4 = i;
                i3++;
            } else if (length == i4) {
                return new j.g(bArr);
            } else {
                return j.g(bArr, 0, i4);
            }
        }
        throw new b("Invalid escape sequence: '\\x' with no digits");
    }

    public static String k(int i) {
        return i >= 0 ? Integer.toString(i) : Long.toString(((long) i) & 4294967295L);
    }

    public static String l(long j) {
        return j >= 0 ? Long.toString(j) : BigInteger.valueOf(j & Long.MAX_VALUE).setBit(63).toString();
    }
}
