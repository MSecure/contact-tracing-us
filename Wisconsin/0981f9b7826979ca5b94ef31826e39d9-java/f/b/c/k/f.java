package f.b.c.k;

import android.content.Context;
import f.b.c.k.h;
import f.b.c.k.r.e;
import f.b.c.k.s.n;
import f.b.c.k.u.b;
import f.b.c.k.w.c0;
import f.b.c.k.x.c;
import f.b.c.k.x.m;
import java.util.Objects;

public class f {
    public final Context a;
    public final b b;
    public final String c;

    /* renamed from: d  reason: collision with root package name */
    public final f.b.c.k.r.a f2987d;

    /* renamed from: e  reason: collision with root package name */
    public final c f2988e;

    /* renamed from: f  reason: collision with root package name */
    public final q f2989f;

    /* renamed from: g  reason: collision with root package name */
    public h f2990g = new h.b().a();

    /* renamed from: h  reason: collision with root package name */
    public volatile n f2991h;

    /* renamed from: i  reason: collision with root package name */
    public final c0 f2992i;

    public interface a {
    }

    public f(Context context, b bVar, String str, f.b.c.k.r.a aVar, c cVar, f.b.c.a aVar2, a aVar3, c0 c0Var) {
        Objects.requireNonNull(context);
        this.a = context;
        this.b = bVar;
        this.f2989f = new q(bVar);
        Objects.requireNonNull(str);
        this.c = str;
        this.f2987d = aVar;
        this.f2988e = cVar;
        this.f2992i = c0Var;
    }

    public static f a(Context context, f.b.c.a aVar, f.b.c.e.b.a aVar2, String str, a aVar3, c0 c0Var) {
        f.b.c.k.r.b bVar;
        aVar.a();
        String str2 = aVar.c.f2963g;
        if (str2 != null) {
            b bVar2 = new b(str2, str);
            c cVar = new c();
            if (aVar2 == null) {
                m.a(m.a.DEBUG, "FirebaseFirestore", "Firebase Auth not available, falling back to unauthenticated usage.", new Object[0]);
                bVar = new f.b.c.k.r.b();
            } else {
                bVar = new e(aVar2);
            }
            aVar.a();
            return new f(context, bVar2, aVar.b, bVar, cVar, aVar, aVar3, c0Var);
        }
        throw new IllegalArgumentException("FirebaseOptions.getProjectId() cannot be null");
    }
}
