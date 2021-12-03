package h.a;

import f.b.b.a.k;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicReferenceArray;

public final class o0<ReqT, RespT> {
    public final c a;
    public final String b;
    public final String c;

    /* renamed from: d  reason: collision with root package name */
    public final b<ReqT> f4208d;

    /* renamed from: e  reason: collision with root package name */
    public final b<RespT> f4209e;

    /* renamed from: f  reason: collision with root package name */
    public final Object f4210f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f4211g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f4212h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f4213i;

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
        this.f4208d = bVar;
        f.b.a.c.b.o.b.z(bVar2, "responseMarshaller");
        this.f4209e = bVar2;
        this.f4210f = null;
        this.f4211g = z;
        this.f4212h = z2;
        this.f4213i = z3;
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
        return this.f4208d.b(reqt);
    }

    public String toString() {
        k q1 = f.b.a.c.b.o.b.q1(this);
        q1.d("fullMethodName", this.b);
        q1.d("type", this.a);
        q1.c("idempotent", this.f4211g);
        q1.c("safe", this.f4212h);
        q1.c("sampledToLocalTracing", this.f4213i);
        q1.d("requestMarshaller", this.f4208d);
        q1.d("responseMarshaller", this.f4209e);
        q1.d("schemaDescriptor", this.f4210f);
        q1.f3058d = true;
        return q1.toString();
    }
}
