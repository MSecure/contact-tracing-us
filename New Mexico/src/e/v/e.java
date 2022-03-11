package e.v;

import androidx.lifecycle.LiveData;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;
/* loaded from: classes.dex */
public class e {
    public final Set<LiveData> a = Collections.newSetFromMap(new IdentityHashMap());
    public final g b;

    public e(g gVar) {
        this.b = gVar;
    }
}
