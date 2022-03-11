package h.a;

import f.b.b.a.k;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicReferenceArray;

public final class o0<ReqT, RespT> {
    public final c a;
    public final String b;
    public final String c;

    /* renamed from: d  reason: collision with root package name */
    public final b<ReqT> f3958d;

    /* renamed from: e  reason: collision with root package name */
    public final b<RespT> f3959e;

    /* renamed from: f  reason: collision with root package name */
    public final Object f3960f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f3961g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f3962h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f3963i;

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
        this.f3958d = bVar;
        f.b.a.c.b.o.b.A(bVar2, "responseMarshaller");
        this.f3959e = bVar2;
        this.f3960f = null;
        this.f3961g = z;
        this.f3962h = z2;
        this.f3963i = z3;
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
        return this.f3958d.b(reqt);
    }

    public String toString() {
        k U1 = f.b.a.c.b.o.b.U1(this);
        U1.d("fullMethodName", this.b);
        U1.d("type", this.a);
        U1.c("idempotent", this.f3961g);
        U1.c("safe", this.f3962h);
        U1.c("sampledToLocalTracing", this.f3963i);
        U1.d("requestMarshaller", this.f3958d);
        U1.d("responseMarshaller", this.f3959e);
        U1.d("schemaDescriptor", this.f3960f);
        U1.f2868d = true;
        return U1.toString();
    }
}
