package com.google.android.gms.dynamite;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.common.util.DynamiteApi;
import f.b.a.c.d.e;
import f.b.a.c.d.f;
import f.b.a.c.d.g;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;
/* loaded from: classes.dex */
public final class DynamiteModule {
    public static Boolean b;
    public static e c;

    /* renamed from: d */
    public static g f470d;

    /* renamed from: e */
    public static String f471e;

    /* renamed from: f */
    public static int f472f;

    /* renamed from: g */
    public static final ThreadLocal<c> f473g = new ThreadLocal<>();

    /* renamed from: h */
    public static final b.AbstractC0004b f474h = new f.b.a.c.d.a();
    @RecentlyNonNull

    /* renamed from: i */
    public static final b f475i = new f.b.a.c.d.b();
    public final Context a;

    @DynamiteApi
    /* loaded from: classes.dex */
    public static class DynamiteLoaderClassLoader {
        @RecentlyNullable
        public static ClassLoader sClassLoader;
    }

    /* loaded from: classes.dex */
    public static class a extends Exception {
        public a(String str, f.b.a.c.d.a aVar) {
            super(str);
        }

        public a(String str, Throwable th, f.b.a.c.d.a aVar) {
            super(str, th);
        }
    }

    /* loaded from: classes.dex */
    public interface b {

        /* loaded from: classes.dex */
        public static class a {
            public int a = 0;
            public int b = 0;
            public int c = 0;
        }

        /* renamed from: com.google.android.gms.dynamite.DynamiteModule$b$b */
        /* loaded from: classes.dex */
        public interface AbstractC0004b {
            int a(Context context, String str);

            int b(Context context, String str, boolean z);
        }

        a a(Context context, String str, AbstractC0004b bVar);
    }

    /* loaded from: classes.dex */
    public static class c {
        public Cursor a;

        public c() {
        }

        public c(f.b.a.c.d.a aVar) {
        }
    }

    /* loaded from: classes.dex */
    public static class d implements b.AbstractC0004b {
        public final int a;

        public d(int i2) {
            this.a = i2;
        }

        @Override // com.google.android.gms.dynamite.DynamiteModule.b.AbstractC0004b
        public final int a(Context context, String str) {
            return this.a;
        }

        @Override // com.google.android.gms.dynamite.DynamiteModule.b.AbstractC0004b
        public final int b(Context context, String str, boolean z) {
            return 0;
        }
    }

    public DynamiteModule(Context context) {
        Objects.requireNonNull(context, "null reference");
        this.a = context;
    }

    @RecentlyNonNull
    public static DynamiteModule a(@RecentlyNonNull Context context, @RecentlyNonNull b bVar, @RecentlyNonNull String str) {
        ThreadLocal<c> threadLocal = f473g;
        c cVar = threadLocal.get();
        c cVar2 = new c(null);
        threadLocal.set(cVar2);
        try {
            b.a a2 = bVar.a(context, str, f474h);
            int i2 = a2.a;
            str.length();
            str.length();
            int i3 = a2.c;
            if (i3 == 0 || ((i3 == -1 && a2.a == 0) || (i3 == 1 && a2.b == 0))) {
                int i4 = a2.a;
                int i5 = a2.b;
                StringBuilder sb = new StringBuilder(91);
                sb.append("No acceptable module found. Local version is ");
                sb.append(i4);
                sb.append(" and remote version is ");
                sb.append(i5);
                sb.append(".");
                throw new a(sb.toString(), null);
            } else if (i3 == -1) {
                DynamiteModule b2 = b(context, str);
                Cursor cursor = cVar2.a;
                if (cursor != null) {
                    cursor.close();
                }
                threadLocal.set(cVar);
                return b2;
            } else if (i3 == 1) {
                try {
                    DynamiteModule c2 = c(context, str, a2.b);
                    Cursor cursor2 = cVar2.a;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    threadLocal.set(cVar);
                    return c2;
                } catch (a e2) {
                    String valueOf = String.valueOf(e2.getMessage());
                    if (valueOf.length() != 0) {
                        "Failed to load remote module: ".concat(valueOf);
                    } else {
                        new String("Failed to load remote module: ");
                    }
                    int i6 = a2.a;
                    if (i6 == 0 || bVar.a(context, str, new d(i6)).c != -1) {
                        throw new a("Remote load failed. No local fallback found.", e2, null);
                    }
                    DynamiteModule b3 = b(context, str);
                    Cursor cursor3 = cVar2.a;
                    if (cursor3 != null) {
                        cursor3.close();
                    }
                    f473g.set(cVar);
                    return b3;
                }
            } else {
                int i7 = a2.c;
                StringBuilder sb2 = new StringBuilder(47);
                sb2.append("VersionPolicy returned invalid code:");
                sb2.append(i7);
                throw new a(sb2.toString(), null);
            }
        } catch (Throwable th) {
            Cursor cursor4 = cVar2.a;
            if (cursor4 != null) {
                cursor4.close();
            }
            f473g.set(cVar);
            throw th;
        }
    }

    public static DynamiteModule b(Context context, String str) {
        String valueOf = String.valueOf(str);
        if (valueOf.length() != 0) {
            "Selected local version of ".concat(valueOf);
        } else {
            new String("Selected local version of ");
        }
        return new DynamiteModule(context.getApplicationContext());
    }

    public static DynamiteModule c(Context context, String str, int i2) {
        Boolean bool;
        f.b.a.c.c.a aVar;
        try {
            synchronized (DynamiteModule.class) {
                bool = b;
            }
            if (bool == null) {
                throw new a("Failed to determine which loading route to use.", null);
            } else if (bool.booleanValue()) {
                return h(context, str, i2);
            } else {
                String.valueOf(str).length();
                e d2 = d(context);
                if (d2 != null) {
                    int b2 = d2.b();
                    if (b2 >= 3) {
                        c cVar = f473g.get();
                        if (cVar != null) {
                            aVar = d2.c(new f.b.a.c.c.b(context), str, i2, new f.b.a.c.c.b(cVar.a));
                        } else {
                            throw new a("No cached result cursor holder", null);
                        }
                    } else if (b2 == 2) {
                        aVar = d2.J(new f.b.a.c.c.b(context), str, i2);
                    } else {
                        aVar = d2.k(new f.b.a.c.c.b(context), str, i2);
                    }
                    if (f.b.a.c.c.b.Q(aVar) != null) {
                        return new DynamiteModule((Context) f.b.a.c.c.b.Q(aVar));
                    }
                    throw new a("Failed to load remote module.", null);
                }
                throw new a("Failed to create IDynamiteLoader.", null);
            }
        } catch (RemoteException e2) {
            throw new a("Failed to load remote module.", e2, null);
        } catch (a e3) {
            throw e3;
        } catch (Throwable th) {
            f.b.a.c.b.o.a.a(context, th);
            throw new a("Failed to load remote module.", th, null);
        }
    }

    public static e d(Context context) {
        e eVar;
        synchronized (DynamiteModule.class) {
            e eVar2 = c;
            if (eVar2 != null) {
                return eVar2;
            }
            try {
                IBinder iBinder = (IBinder) context.createPackageContext("com.google.android.gms", 3).getClassLoader().loadClass("com.google.android.gms.chimera.container.DynamiteLoaderImpl").newInstance();
                if (iBinder == null) {
                    eVar = null;
                } else {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoader");
                    eVar = queryLocalInterface instanceof e ? (e) queryLocalInterface : new f.b.a.c.d.d(iBinder);
                }
                if (eVar != null) {
                    c = eVar;
                    return eVar;
                }
            } catch (Exception e2) {
                String valueOf = String.valueOf(e2.getMessage());
                if (valueOf.length() != 0) {
                    "Failed to load IDynamiteLoader from GmsCore: ".concat(valueOf);
                } else {
                    new String("Failed to load IDynamiteLoader from GmsCore: ");
                }
            }
            return null;
        }
    }

    public static void e(ClassLoader classLoader) {
        g gVar;
        try {
            IBinder iBinder = (IBinder) classLoader.loadClass("com.google.android.gms.dynamiteloader.DynamiteLoaderV2").getConstructor(new Class[0]).newInstance(new Object[0]);
            if (iBinder == null) {
                gVar = null;
            } else {
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoaderV2");
                gVar = queryLocalInterface instanceof g ? (g) queryLocalInterface : new f(iBinder);
            }
            f470d = gVar;
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e2) {
            throw new a("Failed to instantiate dynamite loader", e2, null);
        }
    }

    public static boolean f(Cursor cursor) {
        c cVar = f473g.get();
        if (cVar == null || cVar.a != null) {
            return false;
        }
        cVar.a = cursor;
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0032, code lost:
        if (f(r5) != false) goto L_0x0036;
     */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public static int g(Context context, String str, boolean z) {
        Throwable th;
        RemoteException e2;
        e d2 = d(context);
        if (d2 == null) {
            return 0;
        }
        try {
            Cursor cursor = null;
            try {
                int b2 = d2.b();
                try {
                    if (b2 >= 3) {
                        Cursor cursor2 = (Cursor) f.b.a.c.c.b.Q(d2.y(new f.b.a.c.c.b(context), str, z));
                        if (cursor2 != null) {
                            try {
                                if (cursor2.moveToFirst()) {
                                    int i2 = cursor2.getInt(0);
                                    if (i2 > 0) {
                                    }
                                    cursor = cursor2;
                                    if (cursor != null) {
                                        cursor.close();
                                    }
                                    return i2;
                                }
                            } catch (RemoteException e3) {
                                e2 = e3;
                                cursor = cursor2;
                                String valueOf = String.valueOf(e2.getMessage());
                                if (valueOf.length() != 0) {
                                    "Failed to retrieve remote module version: ".concat(valueOf);
                                } else {
                                    new String("Failed to retrieve remote module version: ");
                                }
                                if (cursor != null) {
                                    cursor.close();
                                }
                                return 0;
                            } catch (Throwable th2) {
                                th = th2;
                                cursor = cursor2;
                                if (cursor != null) {
                                    cursor.close();
                                }
                                throw th;
                            }
                        }
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        return 0;
                    } else if (b2 == 2) {
                        return d2.e(new f.b.a.c.c.b(context), str, z);
                    } else {
                        return d2.C(new f.b.a.c.c.b(context), str, z);
                    }
                } catch (RemoteException e4) {
                    e2 = e4;
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (RemoteException e5) {
                e2 = e5;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    public static DynamiteModule h(Context context, String str, int i2) {
        g gVar;
        Boolean valueOf;
        f.b.a.c.c.a aVar;
        String.valueOf(str).length();
        synchronized (DynamiteModule.class) {
            gVar = f470d;
        }
        if (gVar != null) {
            c cVar = f473g.get();
            if (cVar == null || cVar.a == null) {
                throw new a("No result cursor", null);
            }
            Context applicationContext = context.getApplicationContext();
            Cursor cursor = cVar.a;
            new f.b.a.c.c.b(null);
            synchronized (DynamiteModule.class) {
                valueOf = Boolean.valueOf(f472f >= 2);
            }
            if (valueOf.booleanValue()) {
                aVar = gVar.A(new f.b.a.c.c.b(applicationContext), str, i2, new f.b.a.c.c.b(cursor));
            } else {
                aVar = gVar.c(new f.b.a.c.c.b(applicationContext), str, i2, new f.b.a.c.c.b(cursor));
            }
            Context context2 = (Context) f.b.a.c.c.b.Q(aVar);
            if (context2 != null) {
                return new DynamiteModule(context2);
            }
            throw new a("Failed to get module context", null);
        }
        throw new a("DynamiteLoaderV2 was not cached.", null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x006c, code lost:
        if (f(r8) != false) goto L_0x0073;
     */
    /* JADX WARN: Removed duplicated region for block: B:43:0x009f  */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public static int i(Context context, String str, boolean z) {
        Exception e2;
        Cursor cursor = null;
        try {
            ContentResolver contentResolver = context.getContentResolver();
            String str2 = z ? "api_force_staging" : "api";
            StringBuilder sb = new StringBuilder(str2.length() + 42 + String.valueOf(str).length());
            sb.append("content://com.google.android.gms.chimera/");
            sb.append(str2);
            sb.append("/");
            sb.append(str);
            Cursor query = contentResolver.query(Uri.parse(sb.toString()), null, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        int i2 = query.getInt(0);
                        if (i2 > 0) {
                            synchronized (DynamiteModule.class) {
                                f471e = query.getString(2);
                                int columnIndex = query.getColumnIndex("loaderVersion");
                                if (columnIndex >= 0) {
                                    f472f = query.getInt(columnIndex);
                                }
                            }
                        }
                        cursor = query;
                        if (cursor != null) {
                            cursor.close();
                        }
                        return i2;
                    }
                } catch (Exception e3) {
                    e2 = e3;
                    cursor = query;
                    try {
                        if (e2 instanceof a) {
                            throw e2;
                        }
                        throw new a("V2 version check failed", e2, null);
                    } catch (Throwable th) {
                        th = th;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    cursor = query;
                    if (cursor != null) {
                    }
                    throw th;
                }
            }
            throw new a("Failed to connect to dynamite module ContentResolver.", null);
        } catch (Exception e4) {
            e2 = e4;
            cursor = null;
        } catch (Throwable th3) {
            th = th3;
        }
    }
}
