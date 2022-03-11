package e.m.a;

import e.e.h;
import e.m.a.l;
import f.a.a.a.a;

public class y {
    public static final h<String, Class<?>> a = new h<>();

    public static Class<?> b(ClassLoader classLoader, String str) {
        h<String, Class<?>> hVar = a;
        Class<?> orDefault = hVar.getOrDefault(str, null);
        if (orDefault != null) {
            return orDefault;
        }
        Class<?> cls = Class.forName(str, false, classLoader);
        hVar.put(str, cls);
        return cls;
    }

    /* JADX DEBUG: Type inference failed for r3v3. Raw type applied. Possible types: java.lang.Class<?>, java.lang.Class<? extends e.m.a.l> */
    public static Class<? extends l> c(ClassLoader classLoader, String str) {
        try {
            return b(classLoader, str);
        } catch (ClassNotFoundException e2) {
            throw new l.c(a.c("Unable to instantiate fragment ", str, ": make sure class name exists"), e2);
        } catch (ClassCastException e3) {
            throw new l.c(a.c("Unable to instantiate fragment ", str, ": make sure class is a valid subclass of Fragment"), e3);
        }
    }

    public l a(ClassLoader classLoader, String str) {
        throw null;
    }
}
