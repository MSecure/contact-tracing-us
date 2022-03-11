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
/* loaded from: classes.dex */
public class f {
    public final Context a;
    public final b b;
    public final String c;

    /* renamed from: d */
    public final f.b.c.k.r.a f3496d;

    /* renamed from: e */
    public final c f3497e;

    /* renamed from: f */
    public final q f3498f;

    /* renamed from: g */
    public h f3499g = new h.b().a();

    /* renamed from: h */
    public volatile n f3500h;

    /* renamed from: i */
    public final c0 f3501i;

    /* loaded from: classes.dex */
    public interface a {
    }

    public f(Context context, b bVar, String str, f.b.c.k.r.a aVar, c cVar, f.b.c.a aVar2, a aVar3, c0 c0Var) {
        Objects.requireNonNull(context);
        this.a = context;
        this.b = bVar;
        this.f3498f = new q(bVar);
        Objects.requireNonNull(str);
        this.c = str;
        this.f3496d = aVar;
        this.f3497e = cVar;
        this.f3501i = c0Var;
    }

    public static f a(Context context, f.b.c.a aVar, f.b.c.e.b.a aVar2, String str, a aVar3, c0 c0Var) {
        f.b.c.k.r.a aVar4;
        aVar.a();
        String str2 = aVar.c.f3472g;
        if (str2 != null) {
            b bVar = new b(str2, str);
            c cVar = new c();
            if (aVar2 == null) {
                m.a(m.a.DEBUG, "FirebaseFirestore", "Firebase Auth not available, falling back to unauthenticated usage.", new Object[0]);
                aVar4 = new f.b.c.k.r.b();
            } else {
                aVar4 = new e(aVar2);
            }
            aVar.a();
            return new f(context, bVar, aVar.b, aVar4, cVar, aVar, aVar3, c0Var);
        }
        throw new IllegalArgumentException("FirebaseOptions.getProjectId() cannot be null");
    }
}
