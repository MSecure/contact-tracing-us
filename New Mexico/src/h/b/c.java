package h.b;

import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
/* loaded from: classes.dex */
public final class c {
    public static final a a;

    /* JADX WARN: Removed duplicated region for block: B:16:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0016 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    static {
        ClassNotFoundException th;
        Class<?> cls;
        Level level = Level.WARNING;
        a aVar = null;
        try {
            cls = Class.forName("io.perfmark.impl.SecretPerfMarkImpl$PerfMarkImpl");
            th = null;
        } catch (ClassNotFoundException e2) {
            th = e2;
            level = Level.FINE;
            cls = null;
            if (cls != null) {
            }
            if (aVar == null) {
            }
            a = aVar;
            if (th != null) {
            }
        } catch (Throwable th2) {
            th = th2;
            cls = null;
            if (cls != null) {
            }
            if (aVar == null) {
            }
            a = aVar;
            if (th != null) {
            }
        }
        if (cls != null) {
            try {
                aVar = (a) cls.asSubclass(a.class).getConstructor(d.class).newInstance(a.a);
            } catch (Throwable th3) {
                th = th3;
            }
        }
        if (aVar == null) {
            aVar = new a(a.a);
        }
        a = aVar;
        if (th != null) {
            Logger.getLogger(c.class.getName()).log(level, "Error during PerfMark.<clinit>", (Throwable) th);
        }
    }

    public static b a() {
        Objects.requireNonNull(a);
        return a.b;
    }
}
