package androidx.work;

import b.z.e;
import b.z.j;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public final class OverwritingInputMerger extends j {
    @Override // b.z.j
    public e b(List<e> list) {
        e.a aVar = new e.a();
        HashMap hashMap = new HashMap();
        for (e eVar : list) {
            hashMap.putAll(Collections.unmodifiableMap(eVar.f1913a));
        }
        aVar.b(hashMap);
        return aVar.a();
    }
}
