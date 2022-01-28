package c.b.a.a.g.h;

import c.b.a.a.g.h.e1;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class s1<T extends e1> {

    /* renamed from: a  reason: collision with root package name */
    public static final Logger f4027a = Logger.getLogger(b1.class.getName());

    /* renamed from: b  reason: collision with root package name */
    public static String f4028b = "com.google.protobuf.BlazeGeneratedExtensionRegistryLiteLoader";

    public static <T extends e1> T a(Class<T> cls) {
        String str;
        ClassLoader classLoader = s1.class.getClassLoader();
        if (cls.equals(e1.class)) {
            str = f4028b;
        } else if (cls.getPackage().equals(s1.class.getPackage())) {
            str = String.format("%s.BlazeGenerated%sLoader", cls.getPackage().getName(), cls.getSimpleName());
        } else {
            throw new IllegalArgumentException(cls.getName());
        }
        try {
            try {
                return cls.cast(((s1) Class.forName(str, true, classLoader).getConstructor(new Class[0]).newInstance(new Object[0])).b());
            } catch (NoSuchMethodException e2) {
                throw new IllegalStateException(e2);
            } catch (InstantiationException e3) {
                throw new IllegalStateException(e3);
            } catch (IllegalAccessException e4) {
                throw new IllegalStateException(e4);
            } catch (InvocationTargetException e5) {
                throw new IllegalStateException(e5);
            }
        } catch (ClassNotFoundException unused) {
            Iterator it = ServiceLoader.load(s1.class, classLoader).iterator();
            ArrayList arrayList = new ArrayList();
            while (it.hasNext()) {
                try {
                    arrayList.add(cls.cast(((s1) it.next()).b()));
                } catch (ServiceConfigurationError e6) {
                    Logger logger = f4027a;
                    Level level = Level.SEVERE;
                    String simpleName = cls.getSimpleName();
                    logger.logp(level, "com.google.protobuf.GeneratedExtensionRegistryLoader", "load", simpleName.length() != 0 ? "Unable to load ".concat(simpleName) : new String("Unable to load "), (Throwable) e6);
                }
            }
            if (arrayList.size() == 1) {
                return (T) ((e1) arrayList.get(0));
            }
            if (arrayList.size() == 0) {
                return null;
            }
            try {
                return (T) ((e1) cls.getMethod("combine", Collection.class).invoke(null, arrayList));
            } catch (NoSuchMethodException e7) {
                throw new IllegalStateException(e7);
            } catch (IllegalAccessException e8) {
                throw new IllegalStateException(e8);
            } catch (InvocationTargetException e9) {
                throw new IllegalStateException(e9);
            }
        }
    }

    public abstract T b();
}
