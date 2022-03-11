package androidx.work;

import e.c0.f;
import e.c0.k;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes.dex */
public final class OverwritingInputMerger extends k {
    @Override // e.c0.k
    public f a(List<f> list) {
        f.a aVar = new f.a();
        HashMap hashMap = new HashMap();
        for (f fVar : list) {
            hashMap.putAll(Collections.unmodifiableMap(fVar.a));
        }
        aVar.b(hashMap);
        return aVar.a();
    }
}
