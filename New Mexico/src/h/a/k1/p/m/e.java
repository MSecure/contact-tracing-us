package h.a.k1.p.m;

import h.a.k1.p.m.g;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Logger;
import k.g;
import k.h;
import k.l;
import k.n;
import k.s;
/* loaded from: classes.dex */
public final class e {
    public static final h a = h.b(":");
    public static final d[] b;
    public static final Map<h, Integer> c;

    /* loaded from: classes.dex */
    public static final class a {
        public final g b;
        public int c;

        /* renamed from: d  reason: collision with root package name */
        public int f4492d;
        public final List<d> a = new ArrayList();

        /* renamed from: e  reason: collision with root package name */
        public d[] f4493e = new d[8];

        /* renamed from: f  reason: collision with root package name */
        public int f4494f = 7;

        /* renamed from: g  reason: collision with root package name */
        public int f4495g = 0;

        /* renamed from: h  reason: collision with root package name */
        public int f4496h = 0;

        public a(int i2, s sVar) {
            this.c = i2;
            this.f4492d = i2;
            Logger logger = l.a;
            this.b = new n(sVar);
        }

        public final void a() {
            Arrays.fill(this.f4493e, (Object) null);
            this.f4494f = this.f4493e.length - 1;
            this.f4495g = 0;
            this.f4496h = 0;
        }

        public final int b(int i2) {
            return this.f4494f + 1 + i2;
        }

        public final int c(int i2) {
            int i3;
            int i4 = 0;
            if (i2 > 0) {
                int length = this.f4493e.length;
                while (true) {
                    length--;
                    i3 = this.f4494f;
                    if (length < i3 || i2 <= 0) {
                        break;
                    }
                    d[] dVarArr = this.f4493e;
                    i2 -= dVarArr[length].c;
                    this.f4496h -= dVarArr[length].c;
                    this.f4495g--;
                    i4++;
                }
                d[] dVarArr2 = this.f4493e;
                System.arraycopy(dVarArr2, i3 + 1, dVarArr2, i3 + 1 + i4, this.f4495g);
                this.f4494f += i4;
            }
            return i4;
        }

        public final h d(int i2) {
            d dVar;
            if (i2 >= 0 && i2 <= e.b.length + -1) {
                dVar = e.b[i2];
            } else {
                int b = b(i2 - e.b.length);
                if (b >= 0) {
                    d[] dVarArr = this.f4493e;
                    if (b < dVarArr.length) {
                        dVar = dVarArr[b];
                    }
                }
                StringBuilder h2 = f.a.a.a.a.h("Header index too large ");
                h2.append(i2 + 1);
                throw new IOException(h2.toString());
            }
            return dVar.a;
        }

        public final void e(int i2, d dVar) {
            this.a.add(dVar);
            int i3 = dVar.c;
            if (i2 != -1) {
                i3 -= this.f4493e[(this.f4494f + 1) + i2].c;
            }
            int i4 = this.f4492d;
            if (i3 > i4) {
                a();
                return;
            }
            int c = c((this.f4496h + i3) - i4);
            if (i2 == -1) {
                int i5 = this.f4495g + 1;
                d[] dVarArr = this.f4493e;
                if (i5 > dVarArr.length) {
                    d[] dVarArr2 = new d[dVarArr.length * 2];
                    System.arraycopy(dVarArr, 0, dVarArr2, dVarArr.length, dVarArr.length);
                    this.f4494f = this.f4493e.length - 1;
                    this.f4493e = dVarArr2;
                }
                int i6 = this.f4494f;
                this.f4494f = i6 - 1;
                this.f4493e[i6] = dVar;
                this.f4495g++;
            } else {
                this.f4493e[this.f4494f + 1 + i2 + c + i2] = dVar;
            }
            this.f4496h += i3;
        }

        public h f() {
            int readByte = this.b.readByte() & 255;
            boolean z = (readByte & 128) == 128;
            int g2 = g(readByte, 127);
            if (!z) {
                return this.b.n((long) g2);
            }
            g gVar = g.f4509d;
            byte[] I = this.b.I((long) g2);
            Objects.requireNonNull(gVar);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            g.a aVar = gVar.a;
            int i2 = 0;
            int i3 = 0;
            for (byte b : I) {
                i2 = (i2 << 8) | (b & 255);
                i3 += 8;
                while (i3 >= 8) {
                    int i4 = i3 - 8;
                    aVar = aVar.a[(i2 >>> i4) & 255];
                    if (aVar.a == null) {
                        byteArrayOutputStream.write(aVar.b);
                        i3 -= aVar.c;
                        aVar = gVar.a;
                    } else {
                        i3 = i4;
                    }
                }
            }
            while (i3 > 0) {
                g.a aVar2 = aVar.a[(i2 << (8 - i3)) & 255];
                if (aVar2.a != null || aVar2.c > i3) {
                    break;
                }
                byteArrayOutputStream.write(aVar2.b);
                i3 -= aVar2.c;
                aVar = gVar.a;
            }
            return h.f(byteArrayOutputStream.toByteArray());
        }

        public int g(int i2, int i3) {
            int i4 = i2 & i3;
            if (i4 < i3) {
                return i4;
            }
            int i5 = 0;
            while (true) {
                int readByte = this.b.readByte() & 255;
                if ((readByte & 128) == 0) {
                    return i3 + (readByte << i5);
                }
                i3 += (readByte & 127) << i5;
                i5 += 7;
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class b {
        public final k.e a;

        /* renamed from: d  reason: collision with root package name */
        public int f4497d;

        /* renamed from: f  reason: collision with root package name */
        public int f4499f;
        public int b = Integer.MAX_VALUE;
        public d[] c = new d[8];

        /* renamed from: e  reason: collision with root package name */
        public int f4498e = 7;

        public b(k.e eVar) {
            this.a = eVar;
        }

        public final void a(d dVar) {
            int i2;
            int i3 = dVar.c;
            if (i3 > 4096) {
                Arrays.fill(this.c, (Object) null);
                this.f4498e = this.c.length - 1;
                this.f4497d = 0;
                this.f4499f = 0;
                return;
            }
            int i4 = (this.f4499f + i3) - 4096;
            if (i4 > 0) {
                int length = this.c.length - 1;
                int i5 = 0;
                while (true) {
                    i2 = this.f4498e;
                    if (length < i2 || i4 <= 0) {
                        break;
                    }
                    d[] dVarArr = this.c;
                    i4 -= dVarArr[length].c;
                    this.f4499f -= dVarArr[length].c;
                    this.f4497d--;
                    i5++;
                    length--;
                }
                d[] dVarArr2 = this.c;
                int i6 = i2 + 1;
                System.arraycopy(dVarArr2, i6, dVarArr2, i6 + i5, this.f4497d);
                this.f4498e += i5;
            }
            int i7 = this.f4497d + 1;
            d[] dVarArr3 = this.c;
            if (i7 > dVarArr3.length) {
                d[] dVarArr4 = new d[dVarArr3.length * 2];
                System.arraycopy(dVarArr3, 0, dVarArr4, dVarArr3.length, dVarArr3.length);
                this.f4498e = this.c.length - 1;
                this.c = dVarArr4;
            }
            int i8 = this.f4498e;
            this.f4498e = i8 - 1;
            this.c[i8] = dVar;
            this.f4497d++;
            this.f4499f += i3;
        }

        public void b(h hVar) {
            c(hVar.l(), 127, 0);
            this.a.T(hVar);
        }

        public void c(int i2, int i3, int i4) {
            int i5;
            k.e eVar;
            if (i2 < i3) {
                eVar = this.a;
                i5 = i2 | i4;
            } else {
                this.a.V(i4 | i3);
                i5 = i2 - i3;
                while (i5 >= 128) {
                    this.a.V(128 | (i5 & 127));
                    i5 >>>= 7;
                }
                eVar = this.a;
            }
            eVar.V(i5);
        }
    }

    static {
        d dVar = new d(d.f4491h, "");
        int i2 = 0;
        h hVar = d.f4488e;
        h hVar2 = d.f4489f;
        h hVar3 = d.f4490g;
        h hVar4 = d.f4487d;
        d[] dVarArr = {dVar, new d(hVar, "GET"), new d(hVar, "POST"), new d(hVar2, "/"), new d(hVar2, "/index.html"), new d(hVar3, "http"), new d(hVar3, "https"), new d(hVar4, "200"), new d(hVar4, "204"), new d(hVar4, "206"), new d(hVar4, "304"), new d(hVar4, "400"), new d(hVar4, "404"), new d(hVar4, "500"), new d("accept-charset", ""), new d("accept-encoding", "gzip, deflate"), new d("accept-language", ""), new d("accept-ranges", ""), new d("accept", ""), new d("access-control-allow-origin", ""), new d("age", ""), new d("allow", ""), new d("authorization", ""), new d("cache-control", ""), new d("content-disposition", ""), new d("content-encoding", ""), new d("content-language", ""), new d("content-length", ""), new d("content-location", ""), new d("content-range", ""), new d("content-type", ""), new d("cookie", ""), new d("date", ""), new d("etag", ""), new d("expect", ""), new d("expires", ""), new d("from", ""), new d("host", ""), new d("if-match", ""), new d("if-modified-since", ""), new d("if-none-match", ""), new d("if-range", ""), new d("if-unmodified-since", ""), new d("last-modified", ""), new d("link", ""), new d("location", ""), new d("max-forwards", ""), new d("proxy-authenticate", ""), new d("proxy-authorization", ""), new d("range", ""), new d("referer", ""), new d("refresh", ""), new d("retry-after", ""), new d("server", ""), new d("set-cookie", ""), new d("strict-transport-security", ""), new d("transfer-encoding", ""), new d("user-agent", ""), new d("vary", ""), new d("via", ""), new d("www-authenticate", "")};
        b = dVarArr;
        LinkedHashMap linkedHashMap = new LinkedHashMap(dVarArr.length);
        while (true) {
            d[] dVarArr2 = b;
            if (i2 < dVarArr2.length) {
                if (!linkedHashMap.containsKey(dVarArr2[i2].a)) {
                    linkedHashMap.put(dVarArr2[i2].a, Integer.valueOf(i2));
                }
                i2++;
            } else {
                c = Collections.unmodifiableMap(linkedHashMap);
                return;
            }
        }
    }

    public static h a(h hVar) {
        int l2 = hVar.l();
        for (int i2 = 0; i2 < l2; i2++) {
            byte c2 = hVar.c(i2);
            if (c2 >= 65 && c2 <= 90) {
                StringBuilder h2 = f.a.a.a.a.h("PROTOCOL_ERROR response malformed: mixed case name: ");
                h2.append(hVar.q());
                throw new IOException(h2.toString());
            }
        }
        return hVar;
    }
}
