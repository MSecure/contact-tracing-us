package f.b.a.f.a.c;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes.dex */
public final class d {
    public final Map<String, Object> a = new HashMap();
    public final AtomicBoolean b = new AtomicBoolean(false);

    public final synchronized boolean a() {
        if (!this.b.get()) {
            synchronized (this) {
                this.a.put("assetOnlyUpdates", Boolean.FALSE);
            }
        }
        Object obj = this.a.get("assetOnlyUpdates");
        if (!(obj instanceof Boolean)) {
            return false;
        }
        return ((Boolean) obj).booleanValue();
    }
}
