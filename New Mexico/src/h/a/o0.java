package h.a;

import f.b.b.a.k;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicReferenceArray;
/* loaded from: classes.dex */
public final class o0<ReqT, RespT> {
    public final c a;
    public final String b;
    public final String c;

    /* renamed from: d  reason: collision with root package name */
    public final b<ReqT> f4528d;

    /* renamed from: e  reason: collision with root package name */
    public final b<RespT> f4529e;

    /* renamed from: f  reason: collision with root package name */
    public final Object f4530f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f4531g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f4532h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f4533i;

    /* loaded from: classes.dex */
    public interface b<T> {
        T a(InputStream inputStream);

        InputStream b(T t);
    }

    /* loaded from: classes.dex */
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
        this.f4528d = bVar;
        f.b.a.c.b.o.b.A(bVar2, "responseMarshaller");
        this.f4529e = bVar2;
        this.f4530f = null;
        this.f4531g = z;
        this.f4532h = z2;
        this.f4533i = z3;
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
        return this.f4528d.b(reqt);
    }

    public String toString() {
        k u1 = f.b.a.c.b.o.b.u1(this);
        u1.d("fullMethodName", this.b);
        u1.d("type", this.a);
        u1.c("idempotent", this.f4531g);
        u1.c("safe", this.f4532h);
        u1.c("sampledToLocalTracing", this.f4533i);
        u1.d("requestMarshaller", this.f4528d);
        u1.d("responseMarshaller", this.f4529e);
        u1.d("schemaDescriptor", this.f4530f);
        u1.f3376d = true;
        return u1.toString();
    }
}
