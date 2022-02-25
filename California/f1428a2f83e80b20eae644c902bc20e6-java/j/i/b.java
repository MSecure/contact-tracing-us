package j.i;

import j.j.b.e;
import j.m.h;

public final class b {
    public static final a a;

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00dc  */
    static {
        int i2;
        a aVar;
        String property = System.getProperty("java.specification.version");
        if (property != null) {
            int g2 = h.g(property, '.', 0, false, 6);
            if (g2 < 0) {
                try {
                    i2 = Integer.parseInt(property) * 65536;
                } catch (NumberFormatException unused) {
                }
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
            if (i2 >= 65544) {
                try {
                    Object newInstance = Class.forName("j.i.d.a").newInstance();
                    e.b(newInstance, "Class.forName(\"kotlin.in…entations\").newInstance()");
                    try {
                        aVar = (a) newInstance;
                        a = aVar;
                    } catch (ClassCastException e2) {
                        ClassLoader classLoader = newInstance.getClass().getClassLoader();
                        ClassLoader classLoader2 = a.class.getClassLoader();
                        Throwable initCause = new ClassCastException("Instance classloader: " + classLoader + ", base type classloader: " + classLoader2).initCause(e2);
                        e.b(initCause, "ClassCastException(\"Inst…baseTypeCL\").initCause(e)");
                        throw initCause;
                    }
                } catch (ClassNotFoundException unused2) {
                    try {
                        Object newInstance2 = Class.forName("kotlin.internal.JRE8PlatformImplementations").newInstance();
                        e.b(newInstance2, "Class.forName(\"kotlin.in…entations\").newInstance()");
                        try {
                            aVar = (a) newInstance2;
                        } catch (ClassCastException e3) {
                            ClassLoader classLoader3 = newInstance2.getClass().getClassLoader();
                            ClassLoader classLoader4 = a.class.getClassLoader();
                            Throwable initCause2 = new ClassCastException("Instance classloader: " + classLoader3 + ", base type classloader: " + classLoader4).initCause(e3);
                            e.b(initCause2, "ClassCastException(\"Inst…baseTypeCL\").initCause(e)");
                            throw initCause2;
                        }
                    } catch (ClassNotFoundException unused3) {
                    }
                }
            }
            if (i2 >= 65543) {
                try {
                    Object newInstance3 = Class.forName("j.i.c.a").newInstance();
                    e.b(newInstance3, "Class.forName(\"kotlin.in…entations\").newInstance()");
                    try {
                        aVar = (a) newInstance3;
                        a = aVar;
                    } catch (ClassCastException e4) {
                        ClassLoader classLoader5 = newInstance3.getClass().getClassLoader();
                        ClassLoader classLoader6 = a.class.getClassLoader();
                        Throwable initCause3 = new ClassCastException("Instance classloader: " + classLoader5 + ", base type classloader: " + classLoader6).initCause(e4);
                        e.b(initCause3, "ClassCastException(\"Inst…baseTypeCL\").initCause(e)");
                        throw initCause3;
                    }
                } catch (ClassNotFoundException unused4) {
                    try {
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
                    } catch (ClassNotFoundException unused5) {
                    }
                }
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
