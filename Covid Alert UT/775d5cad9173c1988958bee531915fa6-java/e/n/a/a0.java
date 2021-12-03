package e.n.a;

import e.e.h;
import e.n.a.m;
import f.a.a.a.a;

public class a0 {
    public static final h<ClassLoader, h<String, Class<?>>> a = new h<>();

    public static Class<?> b(ClassLoader classLoader, String str) {
        h<ClassLoader, h<String, Class<?>>> hVar = a;
        h<String, Class<?>> orDefault = hVar.getOrDefault(classLoader, null);
        if (orDefault == null) {
            orDefault = new h<>();
            hVar.put(classLoader, orDefault);
        }
        Class<?> orDefault2 = orDefault.getOrDefault(str, null);
        if (orDefault2 != null) {
            return orDefault2;
        }
        Class<?> cls = Class.forName(str, false, classLoader);
        orDefault.put(str, cls);
        return cls;
    }

    /* JADX DEBUG: Type inference failed for r3v3. Raw type applied. Possible types: java.lang.Class<?>, java.lang.Class<? extends e.n.a.m> */
    public static Class<? extends m> c(ClassLoader classLoader, String str) {
        try {
            return b(classLoader, str);
        } catch (ClassNotFoundException e2) {
            throw new m.e(a.c("Unable to instantiate fragment ", str, ": make sure class name exists"), e2);
        } catch (ClassCastException e3) {
            throw new m.e(a.c("Unable to instantiate fragment ", str, ": make sure class is a valid subclass of Fragment"), e3);
        }
    }

    public m a(ClassLoader classLoader, String str) {
        throw null;
    }
}
