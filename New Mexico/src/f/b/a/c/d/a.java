package f.b.a.c.d;

import android.content.Context;
import android.os.Build;
import com.google.android.gms.dynamite.DynamiteModule;
import dalvik.system.DelegateLastClassLoader;
import e.b.a.m;
import java.lang.reflect.Field;
import java.util.Objects;
/* loaded from: classes.dex */
public final class a implements DynamiteModule.b.AbstractC0004b {
    @Override // com.google.android.gms.dynamite.DynamiteModule.b.AbstractC0004b
    public final int a(Context context, String str) {
        try {
            ClassLoader classLoader = context.getApplicationContext().getClassLoader();
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 61);
            sb.append("com.google.android.gms.dynamite.descriptors.");
            sb.append(str);
            sb.append(".ModuleDescriptor");
            Class<?> loadClass = classLoader.loadClass(sb.toString());
            Field declaredField = loadClass.getDeclaredField("MODULE_ID");
            Field declaredField2 = loadClass.getDeclaredField("MODULE_VERSION");
            if (m.e.X(declaredField.get(null), str)) {
                return declaredField2.getInt(null);
            }
            String.valueOf(declaredField.get(null)).length();
            String.valueOf(str).length();
            return 0;
        } catch (ClassNotFoundException unused) {
            while (true) {
                String.valueOf(str).length();
                return 0;
            }
        } catch (Exception e2) {
            String valueOf = String.valueOf(e2.getMessage());
            if (valueOf.length() != 0) {
                "Failed to load module descriptor class: ".concat(valueOf);
                return 0;
            }
            new String("Failed to load module descriptor class: ");
            return 0;
        }
    }

    @Override // com.google.android.gms.dynamite.DynamiteModule.b.AbstractC0004b
    public final int b(Context context, String str, boolean z) {
        Field declaredField;
        ClassLoader systemClassLoader;
        ClassLoader classLoader;
        try {
            synchronized (DynamiteModule.class) {
                Boolean bool = DynamiteModule.b;
                if (bool == null) {
                    try {
                        declaredField = context.getApplicationContext().getClassLoader().loadClass(DynamiteModule.DynamiteLoaderClassLoader.class.getName()).getDeclaredField("sClassLoader");
                    } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException e2) {
                        String.valueOf(e2).length();
                        bool = Boolean.FALSE;
                    }
                    synchronized (declaredField.getDeclaringClass()) {
                        ClassLoader classLoader2 = (ClassLoader) declaredField.get(null);
                        if (classLoader2 == null) {
                            if ("com.google.android.gms".equals(context.getApplicationContext().getPackageName())) {
                                systemClassLoader = ClassLoader.getSystemClassLoader();
                            } else {
                                try {
                                    int i2 = DynamiteModule.i(context, str, z);
                                    String str2 = DynamiteModule.f471e;
                                    if (str2 != null && !str2.isEmpty()) {
                                        if (Build.VERSION.SDK_INT >= 29) {
                                            String str3 = DynamiteModule.f471e;
                                            Objects.requireNonNull(str3, "null reference");
                                            classLoader = new DelegateLastClassLoader(str3, ClassLoader.getSystemClassLoader());
                                        } else {
                                            String str4 = DynamiteModule.f471e;
                                            Objects.requireNonNull(str4, "null reference");
                                            classLoader = new c(str4, ClassLoader.getSystemClassLoader());
                                        }
                                        DynamiteModule.e(classLoader);
                                        declaredField.set(null, classLoader);
                                        DynamiteModule.b = Boolean.TRUE;
                                        return i2;
                                    }
                                    return i2;
                                } catch (DynamiteModule.a unused) {
                                    systemClassLoader = ClassLoader.getSystemClassLoader();
                                }
                            }
                            declaredField.set(null, systemClassLoader);
                        } else if (classLoader2 != ClassLoader.getSystemClassLoader()) {
                            try {
                                DynamiteModule.e(classLoader2);
                            } catch (DynamiteModule.a unused2) {
                            }
                            bool = Boolean.TRUE;
                            DynamiteModule.b = bool;
                        }
                        bool = Boolean.FALSE;
                        DynamiteModule.b = bool;
                    }
                }
                if (!bool.booleanValue()) {
                    return DynamiteModule.g(context, str, z);
                }
                try {
                    return DynamiteModule.i(context, str, z);
                } catch (DynamiteModule.a e3) {
                    String valueOf = String.valueOf(e3.getMessage());
                    if (valueOf.length() != 0) {
                        "Failed to retrieve remote module version: ".concat(valueOf);
                    } else {
                        new String("Failed to retrieve remote module version: ");
                    }
                    return 0;
                }
            }
        } catch (Throwable th) {
            f.b.a.c.b.o.a.a(context, th);
            throw th;
        }
    }
}
