package h.a;

import f.b.b.a.k;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicReferenceArray;

public final class o0<ReqT, RespT> {
    public final c a;
    public final String b;
    public final String c;

    /* renamed from: d  reason: collision with root package name */
    public final b<ReqT> f4273d;

    /* renamed from: e  reason: collision with root package name */
    public final b<RespT> f4274e;

    /* renamed from: f  reason: collision with root package name */
    public final Object f4275f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f4276g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f4277h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f4278i;

    public interface b<T> {
        T a(InputStream inputStream);

        InputStream b(T t);
    }

    public enum c {
        UNARY,
        CLIENT_STREAMING,
        SERVER_STREAMING,
        BIDI_STREAMING,
        UNKNOWN
    }

    public o0(c cVar, String str, b bVar, b bVar2, Object obj, boolean z, boolean z2, boolean z3, a aVar) {
        new AtomicReferenceArray(2);
        f.b.a.c.b.o.b.z(cVar, "type");
        this.a = cVar;
        f.b.a.c.b.o.b.z(str, "fullMethodName");
        this.b = str;
        f.b.a.c.b.o.b.z(str, "fullMethodName");
        int lastIndexOf = str.lastIndexOf(47);
        this.c = lastIndexOf == -1 ? null : str.substring(0, lastIndexOf);
        f.b.a.c.b.o.b.z(bVar, "requestMarshaller");
        this.f4273d = bVar;
        f.b.a.c.b.o.b.z(bVar2, "responseMarshaller");
        this.f4274e = bVar2;
        this.f4275f = null;
        this.f4276g = z;
        this.f4277h = z2;
        this.f4278i = z3;
    }

    public static String a(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        f.b.a.c.b.o.b.z(str, "fullServiceName");
        sb.append(str);
        sb.append("/");
        f.b.a.c.b.o.b.z(str2, "methodName");
        sb.append(str2);
        return sb.toString();
    }

    public InputStream b(ReqT reqt) {
        return this.f4273d.b(reqt);
    }

    public String toString() {
        k t1 = f.b.a.c.b.o.b.t1(this);
        t1.d("fullMethodName", this.b);
        t1.d("type", this.a);
        t1.c("idempotent", this.f4276g);
        t1.c("safe", this.f4277h);
        t1.c("sampledToLocalTracing", this.f4278i);
        t1.d("requestMarshaller", this.f4273d);
        t1.d("responseMarshaller", this.f4274e);
        t1.d("schemaDescriptor", this.f4275f);
        t1.f3121d = true;
        return t1.toString();
    }
}
