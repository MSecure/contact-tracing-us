package f.b.c.f;

import f.b.c.m.a;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final /* synthetic */ class i implements a {
    public final Set a;

    public i(Set set) {
        this.a = set;
    }

    @Override // f.b.c.m.a
    public Object get() {
        Set<t> set = this.a;
        int i2 = k.f3223e;
        HashSet hashSet = new HashSet();
        for (t tVar : set) {
            hashSet.add(tVar.get());
        }
        return Collections.unmodifiableSet(hashSet);
    }
}
