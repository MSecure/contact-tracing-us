package b.b0;

import android.annotation.SuppressLint;
import b.b0.y.g;
import b.b0.y.k;
import java.util.Collections;
import java.util.List;

@SuppressLint({"AddedAbstractMethod"})
public abstract class v {
    public final p a(w wVar) {
        List singletonList = Collections.singletonList(wVar);
        k kVar = (k) this;
        if (!singletonList.isEmpty()) {
            return new g(kVar, null, f.KEEP, singletonList, null).a();
        }
        throw new IllegalArgumentException("enqueue needs at least one WorkRequest.");
    }
}
