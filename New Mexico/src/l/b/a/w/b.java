package l.b.a.w;

import l.b.a.x.d;
import l.b.a.x.m;
/* loaded from: classes.dex */
public abstract class b extends c implements d {
    @Override // l.b.a.x.d
    public d h(long j2, m mVar) {
        return j2 == Long.MIN_VALUE ? m(Long.MAX_VALUE, mVar).m(1, mVar) : m(-j2, mVar);
    }
}
