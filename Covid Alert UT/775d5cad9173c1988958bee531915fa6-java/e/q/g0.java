package e.q;

import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class g0 {
    public final HashMap<String, e0> a = new HashMap<>();

    public final void a() {
        for (e0 e0Var : this.a.values()) {
            e0Var.b = true;
            Map<String, Object> map = e0Var.a;
            if (map != null) {
                synchronized (map) {
                    for (Object obj : e0Var.a.values()) {
                        if (obj instanceof Closeable) {
                            try {
                                ((Closeable) obj).close();
                            } catch (IOException e2) {
                                throw new RuntimeException(e2);
                            }
                        }
                    }
                }
            }
            e0Var.a();
        }
        this.a.clear();
    }
}
