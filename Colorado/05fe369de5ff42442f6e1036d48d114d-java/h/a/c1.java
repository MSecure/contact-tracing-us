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
    public static final boolean f3765d = Boolean.parseBoolean(System.getProperty("io.grpc.Status.failOnEqualsForTest", "false"));

    /* renamed from: e  reason: collision with root package name */
    public static final List<c1> f3766e;

    /* renamed from: f  reason: collision with root package name */
    public static final c1 f3767f = b.OK.a();

    /* renamed from: g  reason: collision with root package name */
    public static final c1 f3768g = b.CANCELLED.a();

    /* renamed from: h  reason: collision with root package name */
    public static final c1 f3769h = b.UNKNOWN.a();

    /* renamed from: i  reason: collision with root package name */
    public static final c1 f3770i = b.DEADLINE_EXCEEDED.a();

    /* renamed from: j  reason: collision with root package name */
    public static final c1 f3771j = b.PERMISSION_DENIED.a();

    /* renamed from: k  reason: collision with root package name */
    public static final c1 f3772k = b.UNAUTHENTICATED.a();

    /* renamed from: l  reason: collision with root package name */
    public static final c1 f3773l = b.RESOURCE_EXHAUSTED.a();
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
            return c1.f3766e.get(this.b);
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
                return c1.f3767f;
            }
            int length = bArr.length;
            if (length != 1) {
                if (length == 2 && bArr[0] >= 48 && bArr[0] <= 57) {
                    i2 = 0 + ((bArr[0] - 48) * 10);
                }
                c1 c1Var = c1.f3769h;
                StringBuilder i3 = f.a.a.a.a.i("Unknown code ");
                i3.append(new String(bArr, f.b.b.a.d.a));
                return c1Var.g(i3.toString());
            }
            c = 0;
            if (bArr[c] >= 48 && bArr[c] <= 57) {
                int i4 = (bArr[c] - 48) + i2;
                List<c1> list = c1.f3766e;
                if (i4 < list.size()) {
                    return list.get(i4);
                }
            }
            c1 c1Var2 = c1.f3769h;
            StringBuilder i32 = f.a.a.a.a.i("Unknown code ");
            i32.append(new String(bArr, f.b.b.a.d.a));
            return c1Var2.g(i32.toString());
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
                StringBuilder i3 = f.a.a.a.a.i("Code value duplication between ");
                i3.append(c1Var.a.name());
                i3.append(" & ");
                i3.append(bVar.name());
                throw new IllegalStateException(i3.toString());
            }
        }
        f3766e = Collections.unmodifiableList(new ArrayList(treeMap.values()));
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
            List<c1> list = f3766e;
            if (i2 <= list.size()) {
                return list.get(i2);
            }
        }
        c1 c1Var = f3769h;
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
        return f3769h.f(th);
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
        k q1 = f.b.a.c.b.o.b.q1(this);
        q1.d("code", this.a.name());
        q1.d("description", this.b);
        Throwable th = this.c;
        String str = th;
        if (th != null) {
            Object obj = v.a;
            StringWriter stringWriter = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter));
            str = stringWriter.toString();
        }
        q1.d("cause", str);
        return q1.toString();
    }
}
