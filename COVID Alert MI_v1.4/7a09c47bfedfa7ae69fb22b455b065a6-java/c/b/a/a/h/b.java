package c.b.a.a.h;

import android.net.Uri;
import b.x.t;
import c.b.a.a.d.k.a;
import c.b.a.a.g.f.c;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final a.g<c> f4080a = new a.g<>();

    /* renamed from: b  reason: collision with root package name */
    public static final a.AbstractC0062a<c, a.d.c> f4081b;

    static {
        d dVar = new d();
        f4081b = dVar;
        a.g<c> gVar = f4080a;
        t.D(dVar, "Cannot construct an Api with a null ClientBuilder");
        t.D(gVar, "Cannot construct an Api with a null ClientKey");
    }

    public static Uri a(String str) {
        String valueOf = String.valueOf(Uri.encode(str));
        return Uri.parse(valueOf.length() != 0 ? "content://com.google.android.gms.phenotype/".concat(valueOf) : new String("content://com.google.android.gms.phenotype/"));
    }
}
