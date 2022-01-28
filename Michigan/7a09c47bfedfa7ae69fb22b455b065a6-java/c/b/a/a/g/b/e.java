package c.b.a.a.g.b;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.os.Process;
import android.os.UserManager;
import b.b.k.i;

public abstract class e<T> {

    /* renamed from: g  reason: collision with root package name */
    public static final Object f3249g = new Object();
    @SuppressLint({"StaticFieldLeak"})
    public static Context h;
    public static volatile Boolean i;
    public static volatile Boolean j;

    /* renamed from: a  reason: collision with root package name */
    public final o f3250a;

    /* renamed from: b  reason: collision with root package name */
    public final String f3251b;

    /* renamed from: c  reason: collision with root package name */
    public final String f3252c;

    /* renamed from: d  reason: collision with root package name */
    public final T f3253d;

    /* renamed from: e  reason: collision with root package name */
    public volatile b f3254e = null;

    /* renamed from: f  reason: collision with root package name */
    public volatile SharedPreferences f3255f = null;

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    public e(o oVar, String str, Object obj, i iVar) {
        if (oVar.f3378a == null && oVar.f3379b == null) {
            throw new IllegalArgumentException("Must pass a valid SharedPreferences file name or ContentProvider URI");
        } else if (oVar.f3378a == null || oVar.f3379b == null) {
            this.f3250a = oVar;
            String valueOf = String.valueOf(oVar.f3380c);
            String valueOf2 = String.valueOf(str);
            this.f3252c = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
            String valueOf3 = String.valueOf(oVar.f3381d);
            String valueOf4 = String.valueOf(str);
            this.f3251b = valueOf4.length() != 0 ? valueOf3.concat(valueOf4) : new String(valueOf3);
            this.f3253d = obj;
        } else {
            throw new IllegalArgumentException("Must pass one of SharedPreferences file name or ContentProvider URI");
        }
    }

    public static <V> V c(m<V> mVar) {
        long clearCallingIdentity;
        try {
            return mVar.a();
        } catch (SecurityException unused) {
            clearCallingIdentity = Binder.clearCallingIdentity();
            V a2 = mVar.a();
            Binder.restoreCallingIdentity(clearCallingIdentity);
            return a2;
        } catch (Throwable th) {
            Binder.restoreCallingIdentity(clearCallingIdentity);
            throw th;
        }
    }

    public static boolean d(String str) {
        if (j()) {
            return ((Boolean) c(new h(str))).booleanValue();
        }
        return false;
    }

    public static e e(o oVar, String str) {
        return new j(oVar, str, Boolean.FALSE);
    }

    public static e g(o oVar, String str) {
        return new k(oVar, str, null);
    }

    public static boolean j() {
        if (i == null) {
            Context context = h;
            boolean z = false;
            if (context == null) {
                return false;
            }
            if (i.j.i(context, "com.google.android.providers.gsf.permission.READ_GSERVICES", Binder.getCallingPid(), Binder.getCallingUid(), Binder.getCallingPid() == Process.myPid() ? context.getPackageName() : null) == 0) {
                z = true;
            }
            i = Boolean.valueOf(z);
        }
        return i.booleanValue();
    }

    public final T a() {
        if (h != null) {
            if (this.f3250a.f3383f) {
                T i2 = i();
                if (i2 != null) {
                    return i2;
                }
                T h2 = h();
                if (h2 != null) {
                    return h2;
                }
            } else {
                T h3 = h();
                if (h3 != null) {
                    return h3;
                }
                T i3 = i();
                if (i3 != null) {
                    return i3;
                }
            }
            return this.f3253d;
        }
        throw new IllegalStateException("Must call PhenotypeFlag.init() first");
    }

    public abstract T b(SharedPreferences sharedPreferences);

    public abstract T f(String str);

    @TargetApi(24)
    public final T h() {
        boolean z;
        if (!d("gms:phenotype:phenotype_flag:debug_bypass_phenotype")) {
            o oVar = this.f3250a;
            if (oVar.f3379b != null) {
                if (this.f3254e == null) {
                    ContentResolver contentResolver = h.getContentResolver();
                    Uri uri = this.f3250a.f3379b;
                    b bVar = b.h.get(uri);
                    if (bVar == null) {
                        bVar = new b(contentResolver, uri);
                        b putIfAbsent = b.h.putIfAbsent(uri, bVar);
                        if (putIfAbsent == null) {
                            bVar.f3222a.registerContentObserver(bVar.f3223b, false, bVar.f3224c);
                        } else {
                            bVar = putIfAbsent;
                        }
                    }
                    this.f3254e = bVar;
                }
                String str = (String) c(new f(this, this.f3254e));
                if (str != null) {
                    return f(str);
                }
            } else if (oVar.f3378a != null) {
                if (Build.VERSION.SDK_INT < 24 || h.isDeviceProtectedStorage()) {
                    z = true;
                } else {
                    if (j == null || !j.booleanValue()) {
                        j = Boolean.valueOf(((UserManager) h.getSystemService(UserManager.class)).isUserUnlocked());
                    }
                    z = j.booleanValue();
                }
                if (!z) {
                    return null;
                }
                if (this.f3255f == null) {
                    this.f3255f = h.getSharedPreferences(this.f3250a.f3378a, 0);
                }
                SharedPreferences sharedPreferences = this.f3255f;
                if (sharedPreferences.contains(this.f3251b)) {
                    return b(sharedPreferences);
                }
            }
        } else {
            String valueOf = String.valueOf(this.f3251b);
            if (valueOf.length() != 0) {
                "Bypass reading Phenotype values for flag: ".concat(valueOf);
            } else {
                new String("Bypass reading Phenotype values for flag: ");
            }
        }
        return null;
    }

    public final T i() {
        String str;
        if (this.f3250a.f3382e || !j() || (str = (String) c(new g(this))) == null) {
            return null;
        }
        return f(str);
    }
}
