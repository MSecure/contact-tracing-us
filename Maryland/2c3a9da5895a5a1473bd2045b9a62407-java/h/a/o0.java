package h.a;

import f.b.b.a.k;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicReferenceArray;

public final class o0<ReqT, RespT> {
    public final c a;
    public final String b;
    public final String c;

    /* renamed from: d  reason: collision with root package name */
    public final b<ReqT> f4054d;

    /* renamed from: e  reason: collision with root package name */
    public final b<RespT> f4055e;

    /* renamed from: f  reason: collision with root package name */
    public final Object f4056f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f4057g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f4058h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f4059i;

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
        f.b.a.c.b.o.b.A(cVar, "type");
        this.a = cVar;
        f.b.a.c.b.o.b.A(str, "fullMethodName");
        this.b = str;
        f.b.a.c.b.o.b.A(str, "fullMethodName");
        int lastIndexOf = str.lastIndexOf(47);
        this.c = lastIndexOf == -1 ? null : str.substring(0, lastIndexOf);
        f.b.a.c.b.o.b.A(bVar, "requestMarshaller");
        this.f4054d = bVar;
        f.b.a.c.b.o.b.A(bVar2, "responseMarshaller");
        this.f4055e = bVar2;
        this.f4056f = null;
        this.f4057g = z;
        this.f4058h = z2;
        this.f4059i = z3;
    }

    public static String a(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        f.b.a.c.b.o.b.A(str, "fullServiceName");
        sb.append(str);
        sb.append("/");
        f.b.a.c.b.o.b.A(str2, "methodName");
        sb.append(str2);
        return sb.toString();
    }

    public InputStream b(ReqT reqt) {
        return this.f4054d.b(reqt);
    }

    public String toString() {
        k T1 = f.b.a.c.b.o.b.T1(this);
        T1.d("fullMethodName", this.b);
        T1.d("type", this.a);
        T1.c("idempotent", this.f4057g);
        T1.c("safe", this.f4058h);
        T1.c("sampledToLocalTracing", this.f4059i);
        T1.d("requestMarshaller", this.f4054d);
        T1.d("responseMarshaller", this.f4055e);
        T1.d("schemaDescriptor", this.f4056f);
        T1.f2964d = true;
        return T1.toString();
    }
}
