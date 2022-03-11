package g.b.a.c.b;

import android.os.Bundle;
import e.r.e0;
import e.r.f0;
import e.w.c;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public final class d implements f0.b {
    public final Set<String> a;
    public final f0.b b;
    public final e.r.a c;

    /* loaded from: classes.dex */
    public class a extends e.r.a {

        /* renamed from: d */
        public final /* synthetic */ g.b.a.c.a.d f4064d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(d dVar, c cVar, Bundle bundle, g.b.a.c.a.d dVar2) {
            super(cVar, bundle);
            this.f4064d = dVar2;
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        Map<String, i.a.a<e0>> a();
    }

    public d(c cVar, Bundle bundle, Set<String> set, f0.b bVar, g.b.a.c.a.d dVar) {
        this.a = set;
        this.b = bVar;
        this.c = new a(this, cVar, bundle, dVar);
    }

    @Override // e.r.f0.b
    public <T extends e0> T a(Class<T> cls) {
        return this.a.contains(cls.getName()) ? (T) this.c.a(cls) : (T) this.b.a(cls);
    }
}
