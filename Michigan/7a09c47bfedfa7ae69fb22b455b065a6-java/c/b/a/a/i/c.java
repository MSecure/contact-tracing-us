package c.b.a.a.i;

import b.x.t;
import c.b.a.a.d.k.a;
import com.google.android.gms.common.api.Scope;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final a.g<c.b.a.a.i.b.a> f4097a = new a.g<>();

    /* renamed from: b  reason: collision with root package name */
    public static final a.g<c.b.a.a.i.b.a> f4098b = new a.g<>();

    /* renamed from: c  reason: collision with root package name */
    public static final a.AbstractC0062a<c.b.a.a.i.b.a, a> f4099c = new e();

    /* renamed from: d  reason: collision with root package name */
    public static final a.AbstractC0062a<c.b.a.a.i.b.a, g> f4100d = new d();

    static {
        new Scope("profile");
        new Scope("email");
        a.AbstractC0062a<c.b.a.a.i.b.a, a> aVar = f4099c;
        a.g<c.b.a.a.i.b.a> gVar = f4097a;
        t.D(aVar, "Cannot construct an Api with a null ClientBuilder");
        t.D(gVar, "Cannot construct an Api with a null ClientKey");
        a.AbstractC0062a<c.b.a.a.i.b.a, g> aVar2 = f4100d;
        a.g<c.b.a.a.i.b.a> gVar2 = f4098b;
        t.D(aVar2, "Cannot construct an Api with a null ClientBuilder");
        t.D(gVar2, "Cannot construct an Api with a null ClientKey");
    }
}
