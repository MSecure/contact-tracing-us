package com.google.android.gms.dynamite;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.common.util.DynamiteApi;
import f.b.a.c.d.e;
import f.b.a.c.d.f;
import f.b.a.c.d.g;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;

public final class DynamiteModule {
    public static Boolean b = null;
    public static e c = null;

    /* renamed from: d  reason: collision with root package name */
    public static g f420d = null;

    /* renamed from: e  reason: collision with root package name */
    public static String f421e = null;

    /* renamed from: f  reason: collision with root package name */
    public static int f422f = -1;

    /* renamed from: g  reason: collision with root package name */
    public static final ThreadLocal<c> f423g = new ThreadLocal<>();

    /* renamed from: h  reason: collision with root package name */
    public static final b.AbstractC0003b f424h = new f.b.a.c.d.a();
    @RecentlyNonNull

    /* renamed from: i  reason: collision with root package name */
    public static final b f425i = new f.b.a.c.d.b();
    public final Context a;

    @DynamiteApi
    public static class DynamiteLoaderClassLoader {
        @RecentlyNullable
        public static ClassLoader sClassLoader;
    }

    public static class a extends Exception {
        public a(String str, f.b.a.c.d.a aVar) {
            super(str);
        }

        public a(String str, Throwable th, f.b.a.c.d.a aVar) {
            super(str, th);
        }
    }

    public interface b {

        public static class a {
            public int a = 0;
            public int b = 0;
            public int c = 0;
        }

        /* renamed from: com.google.android.gms.dynamite.DynamiteModule$b$b  reason: collision with other inner class name */
        public interface AbstractC0003b {
            int a(Context context, String str);

            int b(Context context, String str, boolean z);
        }

        a a(Context context, String str, AbstractC0003b bVar);
    }

    public static class c {
        public Cursor a;

        public c() {
        }

        public c(f.b.a.c.d.a aVar) {
        }
    }

    public static class d implements b.AbstractC0003b {
        public final int a;

        public d(int i2) {
            this.a = i2;
        }

        @Override // com.google.android.gms.dynamite.DynamiteModule.b.AbstractC0003b
        public final int a(Context context, String str) {
            return this.a;
        }

        @Override // com.google.android.gms.dynamite.DynamiteModule.b.AbstractC0003b
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
        Cursor cursor;
        ThreadLocal<c> threadLocal = f423g;
        c cVar = threadLocal.get();
        c cVar2 = new c(null);
        threadLocal.set(cVar2);
        try {
            b.a a2 = bVar.a(context, str, f424h);
            int i2 = a2.a;
            int i3 = a2.b;
            StringBuilder sb = new StringBuilder(str.length() + 68 + str.length());
            sb.append("Considering local module ");
            sb.append(str);
            sb.append(":");
            sb.append(i2);
            sb.append(" and remote module ");
            sb.append(str);
            sb.append(":");
            sb.append(i3);
            Log.i("DynamiteModule", sb.toString());
            int i4 = a2.c;
            if (i4 == 0 || ((i4 == -1 && a2.a == 0) || (i4 == 1 && a2.b == 0))) {
                int i5 = a2.a;
                int i6 = a2.b;
                StringBuilder sb2 = new StringBuilder(91);
                sb2.append("No acceptable module found. Local version is ");
                sb2.append(i5);
                sb2.append(" and remote version is ");
                sb2.append(i6);
                sb2.append(".");
                throw new a(sb2.toString(), null);
            } else if (i4 == -1) {
                DynamiteModule b2 = b(context, str);
                Cursor cursor2 = cVar2.a;
                if (cursor2 != null) {
                    cursor2.close();
                }
                threadLocal.set(cVar);
                return b2;
            } else if (i4 == 1) {
                try {
                    DynamiteModule c2 = c(context, str, a2.b);
                    Cursor cursor3 = cVar2.a;
                    if (cursor3 != null) {
                        cursor3.close();
                    }
                    threadLocal.set(cVar);
                    return c2;
                } catch (a e2) {
                    String valueOf = String.valueOf(e2.getMessage());
                    Log.w("DynamiteModule", valueOf.length() != 0 ? "Failed to load remote module: ".concat(valueOf) : new String("Failed to load remote module: "));
                    int i7 = a2.a;
                    if (i7 == 0 || bVar.a(context, str, new d(i7)).c != -1) {
                        throw new a("Remote load failed. No local fallback found.", e2, null);
                    }
                    return b(context, str);
                }
            } else {
                int i8 = a2.c;
                StringBuilder sb3 = new StringBuilder(47);
                sb3.append("VersionPolicy returned invalid code:");
                sb3.append(i8);
                throw new a(sb3.toString(), null);
            }
        } finally {
            cursor = cVar2.a;
            if (cursor != null) {
                cursor.close();
            }
            f423g.set(cVar);
        }
    }

    public static DynamiteModule b(Context context, String str) {
        String valueOf = String.valueOf(str);
        Log.i("DynamiteModule", valueOf.length() != 0 ? "Selected local version of ".concat(valueOf) : new String("Selected local version of "));
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
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 51);
                sb.append("Selected remote version of ");
                sb.append(str);
                sb.append(", version >= ");
                sb.append(i2);
                Log.i("DynamiteModule", sb.toString());
                e d2 = d(context);
                if (d2 != null) {
                    int a2 = d2.a();
                    if (a2 >= 3) {
                        c cVar = f423g.get();
                        if (cVar != null) {
                            aVar = d2.b(new f.b.a.c.c.b(context), str, i2, new f.b.a.c.c.b(cVar.a));
                        } else {
                            throw new a("No cached result cursor holder", null);
                        }
                    } else if (a2 == 2) {
                        Log.w("DynamiteModule", "IDynamite loader version = 2");
                        aVar = d2.x(new f.b.a.c.c.b(context), str, i2);
                    } else {
                        Log.w("DynamiteModule", "Dynamite loader version < 2, falling back to createModuleContext");
                        aVar = d2.k(new f.b.a.c.c.b(context), str, i2);
                    }
                    if (f.b.a.c.c.b.C(aVar) != null) {
                        return new DynamiteModule((Context) f.b.a.c.c.b.C(aVar));
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
                Log.e("DynamiteModule", valueOf.length() != 0 ? "Failed to load IDynamiteLoader from GmsCore: ".concat(valueOf) : new String("Failed to load IDynamiteLoader from GmsCore: "));
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
            f420d = gVar;
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e2) {
            throw new a("Failed to instantiate dynamite loader", e2, null);
        }
    }

    public static boolean f(Cursor cursor) {
        c cVar = f423g.get();
        if (cVar == null || cVar.a != null) {
            return false;
        }
        cVar.a = cursor;
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:48:0x008b A[Catch:{ all -> 0x0078 }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0090 A[Catch:{ all -> 0x0078 }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00a1  */
    public static int g(Context context, String str, boolean z) {
        Throwable th;
        RemoteException e2;
        e d2 = d(context);
        if (d2 == null) {
            return 0;
        }
        Cursor cursor = null;
        try {
            int a2 = d2.a();
            if (a2 >= 3) {
                try {
                    Cursor cursor2 = (Cursor) f.b.a.c.c.b.C(d2.m(new f.b.a.c.c.b(context), str, z));
                    if (cursor2 != null) {
                        try {
                            if (cursor2.moveToFirst()) {
                                int i2 = cursor2.getInt(0);
                                if (i2 <= 0 || !f(cursor2)) {
                                    cursor = cursor2;
                                }
                                if (cursor != null) {
                                    cursor.close();
                                }
                                return i2;
                            }
                        } catch (RemoteException e3) {
                            e2 = e3;
                            cursor = cursor2;
                            try {
                                String valueOf = String.valueOf(e2.getMessage());
                                Log.w("DynamiteModule", valueOf.length() != 0 ? "Failed to retrieve remote module version: ".concat(valueOf) : new String("Failed to retrieve remote module version: "));
                                if (cursor != null) {
                                }
                                return 0;
                            } catch (Throwable th2) {
                                th = th2;
                                if (cursor != null) {
                                    cursor.close();
                                }
                                throw th;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            cursor = cursor2;
                            if (cursor != null) {
                            }
                            throw th;
                        }
                    }
                    Log.w("DynamiteModule", "Failed to retrieve remote module version.");
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    return 0;
                } catch (RemoteException e4) {
                    e2 = e4;
                    String valueOf2 = String.valueOf(e2.getMessage());
                    Log.w("DynamiteModule", valueOf2.length() != 0 ? "Failed to retrieve remote module version: ".concat(valueOf2) : new String("Failed to retrieve remote module version: "));
                    if (cursor != null) {
                    }
                    return 0;
                } catch (Throwable th4) {
                    th = th4;
                    if (cursor != null) {
                    }
                    throw th;
                }
            } else if (a2 == 2) {
                Log.w("DynamiteModule", "IDynamite loader version = 2, no high precision latency measurement.");
                return d2.c(new f.b.a.c.c.b(context), str, z);
            } else {
                Log.w("DynamiteModule", "IDynamite loader version < 2, falling back to getModuleVersion2");
                return d2.p(new f.b.a.c.c.b(context), str, z);
            }
        } catch (RemoteException e5) {
            e2 = e5;
            String valueOf22 = String.valueOf(e2.getMessage());
            Log.w("DynamiteModule", valueOf22.length() != 0 ? "Failed to retrieve remote module version: ".concat(valueOf22) : new String("Failed to retrieve remote module version: "));
            if (cursor != null) {
                cursor.close();
            }
            return 0;
        }
    }

    public static DynamiteModule h(Context context, String str, int i2) {
        g gVar;
        Boolean valueOf;
        f.b.a.c.c.a aVar;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 51);
        sb.append("Selected remote version of ");
        sb.append(str);
        sb.append(", version >= ");
        sb.append(i2);
        Log.i("DynamiteModule", sb.toString());
        synchronized (DynamiteModule.class) {
            gVar = f420d;
        }
        if (gVar != null) {
            c cVar = f423g.get();
            if (cVar == null || cVar.a == null) {
                throw new a("No result cursor", null);
            }
            Context applicationContext = context.getApplicationContext();
            Cursor cursor = cVar.a;
            new f.b.a.c.c.b(null);
            synchronized (DynamiteModule.class) {
                valueOf = Boolean.valueOf(f422f >= 2);
            }
            if (valueOf.booleanValue()) {
                aVar = gVar.o(new f.b.a.c.c.b(applicationContext), str, i2, new f.b.a.c.c.b(cursor));
            } else {
                Log.w("DynamiteModule", "Dynamite loader version < 2, falling back to loadModule2");
                aVar = gVar.b(new f.b.a.c.c.b(applicationContext), str, i2, new f.b.a.c.c.b(cursor));
            }
            Context context2 = (Context) f.b.a.c.c.b.C(aVar);
            if (context2 != null) {
                return new DynamiteModule(context2);
            }
            throw new a("Failed to get module context", null);
        }
        throw new a("DynamiteLoaderV2 was not cached.", null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x006c, code lost:
        if (f(r8) != false) goto L_0x0073;
     */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0099 A[Catch:{ all -> 0x00a2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x009a A[Catch:{ all -> 0x00a2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00a6  */
    public static int i(Context context, String str, boolean z) {
        Throwable th;
        Cursor cursor;
        Exception e2;
        Cursor cursor2 = null;
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
                                f421e = query.getString(2);
                                int columnIndex = query.getColumnIndex("loaderVersion");
                                if (columnIndex >= 0) {
                                    f422f = query.getInt(columnIndex);
                                }
                            }
                        }
                        cursor2 = query;
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        return i2;
                    }
                } catch (Exception e3) {
                    cursor = query;
                    e2 = e3;
                    try {
                        if (!(e2 instanceof a)) {
                            throw e2;
                        }
                        throw new a("V2 version check failed", e2, null);
                    } catch (Throwable th2) {
                        th = th2;
                        cursor2 = cursor;
                        if (cursor2 != null) {
                            cursor2.close();
                        }
                        throw th;
                    }
                } catch (Throwable th3) {
                    cursor2 = query;
                    th = th3;
                    if (cursor2 != null) {
                    }
                    throw th;
                }
            }
            Log.w("DynamiteModule", "Failed to retrieve remote module version.");
            throw new a("Failed to connect to dynamite module ContentResolver.", null);
        } catch (Exception e4) {
            e2 = e4;
            cursor = null;
            if (!(e2 instanceof a)) {
            }
        } catch (Throwable th4) {
            th = th4;
            if (cursor2 != null) {
            }
            throw th;
        }
    }
}
