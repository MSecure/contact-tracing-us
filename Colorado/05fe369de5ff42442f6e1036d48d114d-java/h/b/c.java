package h.b;

import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class c {
    public static final a a;

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0016  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    static {
        ClassNotFoundException classNotFoundException;
        Class<?> cls;
        Level level = Level.WARNING;
        a aVar = null;
        try {
            cls = Class.forName("io.perfmark.impl.SecretPerfMarkImpl$PerfMarkImpl");
            classNotFoundException = null;
        } catch (ClassNotFoundException e2) {
            classNotFoundException = e2;
            level = Level.FINE;
            cls = null;
            if (cls != null) {
            }
            if (aVar == null) {
            }
            a = aVar;
            if (classNotFoundException != null) {
            }
        } catch (Throwable th) {
            classNotFoundException = th;
            cls = null;
            if (cls != null) {
            }
            if (aVar == null) {
            }
            a = aVar;
            if (classNotFoundException != null) {
            }
        }
        if (cls != null) {
            try {
                aVar = (a) cls.asSubclass(a.class).getConstructor(d.class).newInstance(a.a);
            } catch (Throwable th2) {
                classNotFoundException = th2;
            }
        }
        if (aVar == null) {
            aVar = new a(a.a);
        }
        a = aVar;
        if (classNotFoundException != null) {
            Logger.getLogger(c.class.getName()).log(level, "Error during PerfMark.<clinit>", (Throwable) classNotFoundException);
        }
    }

    public static b a() {
        Objects.requireNonNull(a);
        return a.b;
    }
}
