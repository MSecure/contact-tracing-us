package h.a;

import f.b.b.a.k;
import f.b.b.a.v;
import h.a.n0;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

public final class c1 {

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f3830d = Boolean.parseBoolean(System.getProperty("io.grpc.Status.failOnEqualsForTest", "false"));

    /* renamed from: e  reason: collision with root package name */
    public static final List<c1> f3831e;

    /* renamed from: f  reason: collision with root package name */
    public static final c1 f3832f = b.OK.a();

    /* renamed from: g  reason: collision with root package name */
    public static final c1 f3833g = b.CANCELLED.a();

    /* renamed from: h  reason: collision with root package name */
    public static final c1 f3834h = b.UNKNOWN.a();

    /* renamed from: i  reason: collision with root package name */
    public static final c1 f3835i = b.DEADLINE_EXCEEDED.a();

    /* renamed from: j  reason: collision with root package name */
    public static final c1 f3836j = b.PERMISSION_DENIED.a();

    /* renamed from: k  reason: collision with root package name */
    public static final c1 f3837k = b.UNAUTHENTICATED.a();

    /* renamed from: l  reason: collision with root package name */
    public static final c1 f3838l = b.RESOURCE_EXHAUSTED.a();
    public static final c1 m = b.INTERNAL.a();
    public static final c1 n = b.UNAVAILABLE.a();
    public static final n0.f<c1> o = n0.f.b("grpc-status", false, new c(null));
    public static final n0.i<String> p;
    public static final n0.f<String> q;
    public final b a;
    public final String b;
    public final Throwable c;

    public enum b {
        OK(0),
        CANCELLED(1),
        UNKNOWN(2),
        INVALID_ARGUMENT(3),
        DEADLINE_EXCEEDED(4),
        NOT_FOUND(5),
        ALREADY_EXISTS(6),
        PERMISSION_DENIED(7),
        RESOURCE_EXHAUSTED(8),
        FAILED_PRECONDITION(9),
        ABORTED(10),
        OUT_OF_RANGE(11),
        UNIMPLEMENTED(12),
        INTERNAL(13),
        UNAVAILABLE(14),
        DATA_LOSS(15),
        UNAUTHENTICATED(16);
        
        public final int b;
        public final byte[] c;

        /* access modifiers changed from: public */
        b(int i2) {
            this.b = i2;
            this.c = Integer.toString(i2).getBytes(f.b.b.a.d.a);
        }

        public c1 a() {
            return c1.f3831e.get(this.b);
        }
    }

    public static final class c implements n0.i<c1> {
        public c(a aVar) {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // h.a.n0.i
        public byte[] a(c1 c1Var) {
            return c1Var.a.c;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // h.a.n0.i
        public c1 b(byte[] bArr) {
            char c = 1;
            int i2 = 0;
            if (bArr.length == 1 && bArr[0] == 48) {
                return c1.f3832f;
            }
            int length = bArr.length;
            if (length != 1) {
                if (length == 2 && bArr[0] >= 48 && bArr[0] <= 57) {
                    i2 = 0 + ((bArr[0] - 48) * 10);
                }
                c1 c1Var = c1.f3834h;
                StringBuilder h2 = f.a.a.a.a.h("Unknown code ");
                h2.append(new String(bArr, f.b.b.a.d.a));
                return c1Var.g(h2.toString());
            }
            c = 0;
            if (bArr[c] >= 48 && bArr[c] <= 57) {
                int i3 = (bArr[c] - 48) + i2;
                List<c1> list = c1.f3831e;
                if (i3 < list.size()) {
                    return list.get(i3);
                }
            }
            c1 c1Var2 = c1.f3834h;
            StringBuilder h22 = f.a.a.a.a.h("Unknown code ");
            h22.append(new String(bArr, f.b.b.a.d.a));
            return c1Var2.g(h22.toString());
        }
    }

    public static final class d implements n0.i<String> {
        public static final byte[] a = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70};

        public d(a aVar) {
        }

        public static boolean c(byte b) {
            return b < 32 || b >= 126 || b == 37;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // h.a.n0.i
        public byte[] a(String str) {
            byte[] bytes = str.getBytes(f.b.b.a.d.b);
            int i2 = 0;
            while (i2 < bytes.length) {
                if (c(bytes[i2])) {
                    byte[] bArr = new byte[(((bytes.length - i2) * 3) + i2)];
                    if (i2 != 0) {
                        System.arraycopy(bytes, 0, bArr, 0, i2);
                    }
                    int i3 = i2;
                    while (i2 < bytes.length) {
                        byte b = bytes[i2];
                        if (c(b)) {
                            bArr[i3] = 37;
                            byte[] bArr2 = a;
                            bArr[i3 + 1] = bArr2[(b >> 4) & 15];
                            bArr[i3 + 2] = bArr2[b & 15];
                            i3 += 3;
                        } else {
                            bArr[i3] = b;
                            i3++;
                        }
                        i2++;
                    }
                    byte[] bArr3 = new byte[i3];
                    System.arraycopy(bArr, 0, bArr3, 0, i3);
                    return bArr3;
                }
                i2++;
            }
            return bytes;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // h.a.n0.i
        public String b(byte[] bArr) {
            for (int i2 = 0; i2 < bArr.length; i2++) {
                byte b = bArr[i2];
                if (b < 32 || b >= 126 || (b == 37 && i2 + 2 < bArr.length)) {
                    ByteBuffer allocate = ByteBuffer.allocate(bArr.length);
                    int i3 = 0;
                    while (i3 < bArr.length) {
                        if (bArr[i3] == 37 && i3 + 2 < bArr.length) {
                            try {
                                allocate.put((byte) Integer.parseInt(new String(bArr, i3 + 1, 2, f.b.b.a.d.a), 16));
                                i3 += 3;
                            } catch (NumberFormatException unused) {
                            }
                        }
                        allocate.put(bArr[i3]);
                        i3++;
                    }
                    return new String(allocate.array(), 0, allocate.position(), f.b.b.a.d.b);
                }
            }
            return new String(bArr, 0);
        }
    }

    static {
        TreeMap treeMap = new TreeMap();
        b[] values = b.values();
        for (int i2 = 0; i2 < 17; i2++) {
            b bVar = values[i2];
            c1 c1Var = (c1) treeMap.put(Integer.valueOf(bVar.b), new c1(bVar, null, null));
            if (c1Var != null) {
                StringBuilder h2 = f.a.a.a.a.h("Code value duplication between ");
                h2.append(c1Var.a.name());
                h2.append(" & ");
                h2.append(bVar.name());
                throw new IllegalStateException(h2.toString());
            }
        }
        f3831e = Collections.unmodifiableList(new ArrayList(treeMap.values()));
        b.INVALID_ARGUMENT.a();
        b.NOT_FOUND.a();
        b.ALREADY_EXISTS.a();
        b.FAILED_PRECONDITION.a();
        b.ABORTED.a();
        b.OUT_OF_RANGE.a();
        b.UNIMPLEMENTED.a();
        b.DATA_LOSS.a();
        d dVar = new d(null);
        p = dVar;
        q = n0.f.b("grpc-message", false, dVar);
    }

    public c1(b bVar, String str, Throwable th) {
        f.b.a.c.b.o.b.z(bVar, "code");
        this.a = bVar;
        this.b = str;
        this.c = th;
    }

    public static String b(c1 c1Var) {
        if (c1Var.b == null) {
            return c1Var.a.toString();
        }
        return c1Var.a + ": " + c1Var.b;
    }

    public static c1 c(int i2) {
        if (i2 >= 0) {
            List<c1> list = f3831e;
            if (i2 <= list.size()) {
                return list.get(i2);
            }
        }
        c1 c1Var = f3834h;
        return c1Var.g("Unknown code " + i2);
    }

    public static c1 d(Throwable th) {
        f.b.a.c.b.o.b.z(th, "t");
        for (Throwable th2 = th; th2 != null; th2 = th2.getCause()) {
            if (th2 instanceof d1) {
                return ((d1) th2).b;
            }
            if (th2 instanceof e1) {
                return ((e1) th2).b;
            }
        }
        return f3834h.f(th);
    }

    public c1 a(String str) {
        if (str == null) {
            return this;
        }
        if (this.b == null) {
            return new c1(this.a, str, this.c);
        }
        b bVar = this.a;
        return new c1(bVar, this.b + "\n" + str, this.c);
    }

    public boolean e() {
        return b.OK == this.a;
    }

    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public c1 f(Throwable th) {
        return f.b.a.c.b.o.b.m0(this.c, th) ? this : new c1(this.a, this.b, th);
    }

    public c1 g(String str) {
        return f.b.a.c.b.o.b.m0(this.b, str) ? this : new c1(this.a, str, this.c);
    }

    public int hashCode() {
        return super.hashCode();
    }

    public String toString() {
        k t1 = f.b.a.c.b.o.b.t1(this);
        t1.d("code", this.a.name());
        t1.d("description", this.b);
        Throwable th = this.c;
        String str = th;
        if (th != null) {
            Object obj = v.a;
            StringWriter stringWriter = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter));
            str = stringWriter.toString();
        }
        t1.d("cause", str);
        return t1.toString();
    }
}
