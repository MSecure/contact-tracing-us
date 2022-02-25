package f.b.a.c.d;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import com.google.android.gms.dynamite.DynamiteModule;
import dalvik.system.DelegateLastClassLoader;
import e.b.a.m;
import java.lang.reflect.Field;
import java.util.Objects;

public final class a implements DynamiteModule.b.AbstractC0003b {
    @Override // com.google.android.gms.dynamite.DynamiteModule.b.AbstractC0003b
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
            if (m.h.U(declaredField.get(null), str)) {
                return declaredField2.getInt(null);
            }
            String valueOf = String.valueOf(declaredField.get(null));
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 51 + String.valueOf(str).length());
            sb2.append("Module descriptor id '");
            sb2.append(valueOf);
            sb2.append("' didn't match expected id '");
            sb2.append(str);
            sb2.append("'");
            Log.e("DynamiteModule", sb2.toString());
            return 0;
        } catch (ClassNotFoundException unused) {
            StringBuilder sb3 = new StringBuilder(String.valueOf(str).length() + 45);
            sb3.append("Local module descriptor class for ");
            sb3.append(str);
            sb3.append(" not found.");
            Log.w("DynamiteModule", sb3.toString());
            return 0;
        } catch (Exception e2) {
            String valueOf2 = String.valueOf(e2.getMessage());
            Log.e("DynamiteModule", valueOf2.length() != 0 ? "Failed to load module descriptor class: ".concat(valueOf2) : new String("Failed to load module descriptor class: "));
            return 0;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:66:?, code lost:
        return r6;
     */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00cd A[SYNTHETIC, Splitter:B:49:0x00cd] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00f4  */
    @Override // com.google.android.gms.dynamite.DynamiteModule.b.AbstractC0003b
    public final int b(Context context, String str, boolean z) {
        Boolean bool;
        ClassLoader classLoader;
        Boolean bool2 = Boolean.TRUE;
        Boolean bool3 = Boolean.FALSE;
        try {
            synchronized (DynamiteModule.class) {
                bool = DynamiteModule.b;
                if (bool == null) {
                    try {
                        Field declaredField = context.getApplicationContext().getClassLoader().loadClass(DynamiteModule.DynamiteLoaderClassLoader.class.getName()).getDeclaredField("sClassLoader");
                        synchronized (declaredField.getDeclaringClass()) {
                            ClassLoader classLoader2 = (ClassLoader) declaredField.get(null);
                            if (classLoader2 == null) {
                                if (!"com.google.android.gms".equals(context.getApplicationContext().getPackageName())) {
                                    try {
                                        int i2 = DynamiteModule.i(context, str, z);
                                        String str2 = DynamiteModule.f422e;
                                        if (str2 != null) {
                                            if (!str2.isEmpty()) {
                                                if (Build.VERSION.SDK_INT >= 29) {
                                                    String str3 = DynamiteModule.f422e;
                                                    Objects.requireNonNull(str3, "null reference");
                                                    classLoader = new DelegateLastClassLoader(str3, ClassLoader.getSystemClassLoader());
                                                } else {
                                                    String str4 = DynamiteModule.f422e;
                                                    Objects.requireNonNull(str4, "null reference");
                                                    classLoader = new c(str4, ClassLoader.getSystemClassLoader());
                                                }
                                                DynamiteModule.e(classLoader);
                                                declaredField.set(null, classLoader);
                                                DynamiteModule.b = bool2;
                                            }
                                        }
                                    } catch (DynamiteModule.a unused) {
                                    }
                                }
                                declaredField.set(null, ClassLoader.getSystemClassLoader());
                            } else if (classLoader2 != ClassLoader.getSystemClassLoader()) {
                                try {
                                    DynamiteModule.e(classLoader2);
                                } catch (DynamiteModule.a unused2) {
                                }
                            }
                            bool2 = bool3;
                        }
                    } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException e2) {
                        String valueOf = String.valueOf(e2);
                        StringBuilder sb = new StringBuilder(valueOf.length() + 30);
                        sb.append("Failed to load module via V2: ");
                        sb.append(valueOf);
                        Log.w("DynamiteModule", sb.toString());
                    }
                }
            }
            DynamiteModule.b = bool3;
            bool = bool3;
            if (bool.booleanValue()) {
                return DynamiteModule.g(context, str, z);
            }
            try {
                return DynamiteModule.i(context, str, z);
            } catch (DynamiteModule.a e3) {
                String valueOf2 = String.valueOf(e3.getMessage());
                Log.w("DynamiteModule", valueOf2.length() != 0 ? "Failed to retrieve remote module version: ".concat(valueOf2) : new String("Failed to retrieve remote module version: "));
                return 0;
            }
            bool3 = bool2;
            DynamiteModule.b = bool3;
            bool = bool3;
            if (bool.booleanValue()) {
            }
        } catch (Throwable th) {
            f.b.a.c.b.o.a.a(context, th);
            throw th;
        }
    }
}
