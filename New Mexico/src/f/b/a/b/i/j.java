package f.b.a.b.i;

import f.b.a.b.b;
import f.b.a.b.e;
import f.b.a.b.f;
import f.b.a.b.g;
import java.util.Set;
/* loaded from: classes.dex */
public final class j implements g {
    public final Set<b> a;
    public final i b;
    public final l c;

    public j(Set<b> set, i iVar, l lVar) {
        this.a = set;
        this.b = iVar;
        this.c = lVar;
    }

    public <T> f<T> a(String str, Class<T> cls, b bVar, e<T, byte[]> eVar) {
        if (this.a.contains(bVar)) {
            return new k(this.b, str, bVar, eVar, this.c);
        }
        throw new IllegalArgumentException(String.format("%s is not supported byt this factory. Supported encodings are: %s.", bVar, this.a));
    }
}
