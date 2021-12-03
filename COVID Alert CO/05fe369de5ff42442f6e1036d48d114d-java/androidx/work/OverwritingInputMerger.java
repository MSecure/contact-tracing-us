package androidx.work;

import e.z.e;
import e.z.i;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public final class OverwritingInputMerger extends i {
    @Override // e.z.i
    public e a(List<e> list) {
        e.a aVar = new e.a();
        HashMap hashMap = new HashMap();
        for (e eVar : list) {
            hashMap.putAll(Collections.unmodifiableMap(eVar.a));
        }
        aVar.b(hashMap);
        return aVar.a();
    }
}
