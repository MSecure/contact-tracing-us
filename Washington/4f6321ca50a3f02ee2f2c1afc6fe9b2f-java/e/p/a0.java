package e.p;

import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public abstract class a0 {
    public final Map<String, Object> a = new HashMap();
    public volatile boolean b = false;

    public void a() {
    }

    public <T> T b(String str, T t) {
        Object obj;
        synchronized (this.a) {
            obj = this.a.get(str);
            if (obj == null) {
                this.a.put(str, t);
            }
        }
        if (obj != null) {
            t = obj;
        }
        if (this.b && (t instanceof Closeable)) {
            try {
                t.close();
            } catch (IOException e2) {
                throw new RuntimeException(e2);
            }
        }
        return t;
    }
}
