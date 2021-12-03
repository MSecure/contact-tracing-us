package androidx.startup;

import android.content.ComponentName;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Trace;
import e.x.a;
import e.x.b;
import e.x.c;
import java.util.HashSet;
import java.util.Objects;

public final class InitializationProvider extends ContentProvider {
    public int delete(Uri uri, String str, String[] strArr) {
        throw new IllegalStateException("Not allowed.");
    }

    public String getType(Uri uri) {
        throw new IllegalStateException("Not allowed.");
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        throw new IllegalStateException("Not allowed.");
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: e.x.a */
    /* JADX DEBUG: Multi-variable search result rejected for r6v5, resolved type: java.util.Set<java.lang.Class<? extends e.x.b<?>>> */
    /* JADX WARN: Multi-variable type inference failed */
    public boolean onCreate() {
        Context context = getContext();
        if (context != null) {
            a b = a.b(context);
            Objects.requireNonNull(b);
            try {
                Trace.beginSection("Startup");
                Bundle bundle = b.c.getPackageManager().getProviderInfo(new ComponentName(b.c.getPackageName(), InitializationProvider.class.getName()), 128).metaData;
                String string = b.c.getString(R$string.androidx_startup);
                if (bundle != null) {
                    HashSet hashSet = new HashSet();
                    for (String str : bundle.keySet()) {
                        if (string.equals(bundle.getString(str, null))) {
                            Class<?> cls = Class.forName(str);
                            if (b.class.isAssignableFrom(cls)) {
                                b.b.add(cls);
                                b.a(cls, hashSet);
                            }
                        }
                    }
                }
                Trace.endSection();
                return true;
            } catch (PackageManager.NameNotFoundException | ClassNotFoundException e2) {
                throw new c(e2);
            } catch (Throwable th) {
                Trace.endSection();
                throw th;
            }
        } else {
            throw new c("Context cannot be null");
        }
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        throw new IllegalStateException("Not allowed.");
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        throw new IllegalStateException("Not allowed.");
    }
}
