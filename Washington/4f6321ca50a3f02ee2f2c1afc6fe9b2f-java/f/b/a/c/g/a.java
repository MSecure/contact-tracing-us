package f.b.a.c.g;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.util.Log;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.dynamite.DynamiteModule;
import e.b.a.m;
import f.b.a.c.b.e;
import f.b.a.c.b.f;
import f.b.a.c.b.g;
import f.b.a.c.b.i;
import java.lang.reflect.Method;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

public class a {
    public static final e a = e.b;
    public static final Object b = new Object();
    public static Method c;

    public static void a(@RecentlyNonNull Context context) {
        Context context2;
        Context context3;
        m.h.p(context, "Context must not be null");
        Objects.requireNonNull(a);
        AtomicBoolean atomicBoolean = i.a;
        e eVar = e.b;
        int b2 = eVar.b(context, 11925000);
        if (b2 != 0) {
            Intent a2 = eVar.a(context, b2, "e");
            StringBuilder sb = new StringBuilder(57);
            sb.append("GooglePlayServices not available due to error ");
            sb.append(b2);
            Log.e("GooglePlayServicesUtil", sb.toString());
            if (a2 == null) {
                throw new f(b2);
            }
            throw new g(b2, "Google Play Services not available", a2);
        }
        try {
            context2 = DynamiteModule.a(context, DynamiteModule.f425i, "com.google.android.gms.providerinstaller").a;
        } catch (DynamiteModule.a e2) {
            String valueOf = String.valueOf(e2.getMessage());
            Log.w("ProviderInstaller", valueOf.length() != 0 ? "Failed to load providerinstaller module: ".concat(valueOf) : new String("Failed to load providerinstaller module: "));
            context2 = null;
        }
        if (context2 == null) {
            try {
                AtomicBoolean atomicBoolean2 = i.a;
                try {
                    context3 = context.createPackageContext("com.google.android.gms", 3);
                } catch (PackageManager.NameNotFoundException unused) {
                    context3 = null;
                }
                context2 = context3;
            } catch (Resources.NotFoundException e3) {
                String valueOf2 = String.valueOf(e3.getMessage());
                Log.w("ProviderInstaller", valueOf2.length() != 0 ? "Failed to load GMS Core context for providerinstaller: ".concat(valueOf2) : new String("Failed to load GMS Core context for providerinstaller: "));
                f.b.a.c.b.o.a.a(context, e3);
                context2 = null;
            }
        }
        if (context2 != null) {
            synchronized (b) {
                try {
                    if (c == null) {
                        c = context2.getClassLoader().loadClass("com.google.android.gms.common.security.ProviderInstallerImpl").getMethod("insertProvider", Context.class);
                    }
                    c.invoke(null, context2);
                } catch (Exception e4) {
                    Throwable cause = e4.getCause();
                    if (Log.isLoggable("ProviderInstaller", 6)) {
                        String valueOf3 = String.valueOf(cause == null ? e4.getMessage() : cause.getMessage());
                        Log.e("ProviderInstaller", valueOf3.length() != 0 ? "Failed to install provider: ".concat(valueOf3) : new String("Failed to install provider: "));
                    }
                    throw new f(8);
                } catch (Throwable th) {
                    throw th;
                }
            }
            return;
        }
        Log.e("ProviderInstaller", "Failed to get remote context");
        throw new f(8);
    }
}
