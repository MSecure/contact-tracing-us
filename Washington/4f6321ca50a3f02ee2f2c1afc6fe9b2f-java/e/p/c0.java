package e.p;

import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class c0 {
    public final HashMap<String, a0> a = new HashMap<>();

    public final void a() {
        for (a0 a0Var : this.a.values()) {
            a0Var.b = true;
            Map<String, Object> map = a0Var.a;
            if (map != null) {
                synchronized (map) {
                    for (Object obj : a0Var.a.values()) {
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
            a0Var.a();
        }
        this.a.clear();
    }
}
