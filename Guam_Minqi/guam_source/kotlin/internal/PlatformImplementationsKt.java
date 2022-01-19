package kotlin.internal;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import okio.AsyncTimeout;

/* compiled from: PlatformImplementations.kt */
public final class PlatformImplementationsKt {
    public static final PlatformImplementations IMPLEMENTATIONS;

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00d9  */
    static {
        int i;
        PlatformImplementations platformImplementations;
        String property = System.getProperty("java.specification.version");
        if (property != null) {
            int indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) property, '.', 0, false, 6);
            if (indexOf$default < 0) {
                try {
                    i = Integer.parseInt(property) * AsyncTimeout.TIMEOUT_WRITE_SIZE;
                } catch (NumberFormatException unused) {
                }
            } else {
                int i2 = indexOf$default + 1;
                int indexOf$default2 = StringsKt__StringsKt.indexOf$default((CharSequence) property, '.', i2, false, 4);
                if (indexOf$default2 < 0) {
                    indexOf$default2 = property.length();
                }
                String substring = property.substring(0, indexOf$default);
                Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                String substring2 = property.substring(i2, indexOf$default2);
                Intrinsics.checkNotNullExpressionValue(substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                i = Integer.parseInt(substring2) + (Integer.parseInt(substring) * AsyncTimeout.TIMEOUT_WRITE_SIZE);
            }
            if (i >= 65544) {
                try {
                    Object newInstance = Class.forName("kotlin.internal.jdk8.JDK8PlatformImplementations").newInstance();
                    Intrinsics.checkNotNullExpressionValue(newInstance, "Class.forName(\"kotlin.in…entations\").newInstance()");
                    try {
                        platformImplementations = (PlatformImplementations) newInstance;
                        IMPLEMENTATIONS = platformImplementations;
                    } catch (ClassCastException e) {
                        ClassLoader classLoader = newInstance.getClass().getClassLoader();
                        ClassLoader classLoader2 = PlatformImplementations.class.getClassLoader();
                        Throwable initCause = new ClassCastException("Instance classloader: " + classLoader + ", base type classloader: " + classLoader2).initCause(e);
                        Intrinsics.checkNotNullExpressionValue(initCause, "ClassCastException(\"Inst…baseTypeCL\").initCause(e)");
                        throw initCause;
                    }
                } catch (ClassNotFoundException unused2) {
                    try {
                        Object newInstance2 = Class.forName("kotlin.internal.JRE8PlatformImplementations").newInstance();
                        Intrinsics.checkNotNullExpressionValue(newInstance2, "Class.forName(\"kotlin.in…entations\").newInstance()");
                        try {
                            platformImplementations = (PlatformImplementations) newInstance2;
                        } catch (ClassCastException e2) {
                            ClassLoader classLoader3 = newInstance2.getClass().getClassLoader();
                            ClassLoader classLoader4 = PlatformImplementations.class.getClassLoader();
                            Throwable initCause2 = new ClassCastException("Instance classloader: " + classLoader3 + ", base type classloader: " + classLoader4).initCause(e2);
                            Intrinsics.checkNotNullExpressionValue(initCause2, "ClassCastException(\"Inst…baseTypeCL\").initCause(e)");
                            throw initCause2;
                        }
                    } catch (ClassNotFoundException unused3) {
                    }
                }
            }
            if (i >= 65543) {
                try {
                    Object newInstance3 = Class.forName("kotlin.internal.jdk7.JDK7PlatformImplementations").newInstance();
                    Intrinsics.checkNotNullExpressionValue(newInstance3, "Class.forName(\"kotlin.in…entations\").newInstance()");
                    try {
                        platformImplementations = (PlatformImplementations) newInstance3;
                        IMPLEMENTATIONS = platformImplementations;
                    } catch (ClassCastException e3) {
                        ClassLoader classLoader5 = newInstance3.getClass().getClassLoader();
                        ClassLoader classLoader6 = PlatformImplementations.class.getClassLoader();
                        Throwable initCause3 = new ClassCastException("Instance classloader: " + classLoader5 + ", base type classloader: " + classLoader6).initCause(e3);
                        Intrinsics.checkNotNullExpressionValue(initCause3, "ClassCastException(\"Inst…baseTypeCL\").initCause(e)");
                        throw initCause3;
                    }
                } catch (ClassNotFoundException unused4) {
                    try {
                        Object newInstance4 = Class.forName("kotlin.internal.JRE7PlatformImplementations").newInstance();
                        Intrinsics.checkNotNullExpressionValue(newInstance4, "Class.forName(\"kotlin.in…entations\").newInstance()");
                        try {
                            platformImplementations = (PlatformImplementations) newInstance4;
                        } catch (ClassCastException e4) {
                            ClassLoader classLoader7 = newInstance4.getClass().getClassLoader();
                            ClassLoader classLoader8 = PlatformImplementations.class.getClassLoader();
                            Throwable initCause4 = new ClassCastException("Instance classloader: " + classLoader7 + ", base type classloader: " + classLoader8).initCause(e4);
                            Intrinsics.checkNotNullExpressionValue(initCause4, "ClassCastException(\"Inst…baseTypeCL\").initCause(e)");
                            throw initCause4;
                        }
                    } catch (ClassNotFoundException unused5) {
                    }
                }
            }
            platformImplementations = new PlatformImplementations();
            IMPLEMENTATIONS = platformImplementations;
        }
        i = 65542;
        if (i >= 65544) {
        }
        if (i >= 65543) {
        }
        platformImplementations = new PlatformImplementations();
        IMPLEMENTATIONS = platformImplementations;
    }
}
