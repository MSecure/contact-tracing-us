package j.j;

import j.k.b.e;
import j.n.h;
/* loaded from: classes.dex */
public final class b {
    public static final a a;

    /* JADX WARN: Removed duplicated region for block: B:45:0x0056 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00dc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    static {
        int i2;
        a aVar;
        Object newInstance;
        String property = System.getProperty("java.specification.version");
        if (property != null) {
            int g2 = h.g(property, '.', 0, false, 6);
            try {
                if (g2 < 0) {
                    i2 = Integer.parseInt(property) * 65536;
                } else {
                    int i3 = g2 + 1;
                    int g3 = h.g(property, '.', i3, false, 4);
                    if (g3 < 0) {
                        g3 = property.length();
                    }
                    String substring = property.substring(0, g2);
                    e.b(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    String substring2 = property.substring(i3, g3);
                    e.b(substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    i2 = Integer.parseInt(substring2) + (Integer.parseInt(substring) * 65536);
                }
            } catch (NumberFormatException unused) {
            }
            if (i2 >= 65544) {
                try {
                    try {
                        newInstance = Class.forName("j.j.d.a").newInstance();
                        e.b(newInstance, "Class.forName(\"kotlin.in…entations\").newInstance()");
                    } catch (ClassNotFoundException unused2) {
                    }
                } catch (ClassNotFoundException unused3) {
                    Object newInstance2 = Class.forName("kotlin.internal.JRE8PlatformImplementations").newInstance();
                    e.b(newInstance2, "Class.forName(\"kotlin.in…entations\").newInstance()");
                    try {
                        aVar = (a) newInstance2;
                    } catch (ClassCastException e2) {
                        ClassLoader classLoader = newInstance2.getClass().getClassLoader();
                        ClassLoader classLoader2 = a.class.getClassLoader();
                        Throwable initCause = new ClassCastException("Instance classloader: " + classLoader + ", base type classloader: " + classLoader2).initCause(e2);
                        e.b(initCause, "ClassCastException(\"Inst…baseTypeCL\").initCause(e)");
                        throw initCause;
                    }
                }
                try {
                    aVar = (a) newInstance;
                    a = aVar;
                } catch (ClassCastException e3) {
                    ClassLoader classLoader3 = newInstance.getClass().getClassLoader();
                    ClassLoader classLoader4 = a.class.getClassLoader();
                    Throwable initCause2 = new ClassCastException("Instance classloader: " + classLoader3 + ", base type classloader: " + classLoader4).initCause(e3);
                    e.b(initCause2, "ClassCastException(\"Inst…baseTypeCL\").initCause(e)");
                    throw initCause2;
                }
            }
            if (i2 >= 65543) {
                try {
                    Object newInstance3 = Class.forName("j.j.c.a").newInstance();
                    e.b(newInstance3, "Class.forName(\"kotlin.in…entations\").newInstance()");
                    try {
                        try {
                            aVar = (a) newInstance3;
                        } catch (ClassCastException e4) {
                            ClassLoader classLoader5 = newInstance3.getClass().getClassLoader();
                            ClassLoader classLoader6 = a.class.getClassLoader();
                            Throwable initCause3 = new ClassCastException("Instance classloader: " + classLoader5 + ", base type classloader: " + classLoader6).initCause(e4);
                            e.b(initCause3, "ClassCastException(\"Inst…baseTypeCL\").initCause(e)");
                            throw initCause3;
                        }
                    } catch (ClassNotFoundException unused4) {
                    }
                } catch (ClassNotFoundException unused5) {
                    Object newInstance4 = Class.forName("kotlin.internal.JRE7PlatformImplementations").newInstance();
                    e.b(newInstance4, "Class.forName(\"kotlin.in…entations\").newInstance()");
                    try {
                        aVar = (a) newInstance4;
                    } catch (ClassCastException e5) {
                        ClassLoader classLoader7 = newInstance4.getClass().getClassLoader();
                        ClassLoader classLoader8 = a.class.getClassLoader();
                        Throwable initCause4 = new ClassCastException("Instance classloader: " + classLoader7 + ", base type classloader: " + classLoader8).initCause(e5);
                        e.b(initCause4, "ClassCastException(\"Inst…baseTypeCL\").initCause(e)");
                        throw initCause4;
                    }
                }
                a = aVar;
            }
            aVar = new a();
            a = aVar;
        }
        i2 = 65542;
        if (i2 >= 65544) {
        }
        if (i2 >= 65543) {
        }
        aVar = new a();
        a = aVar;
    }
}
