package c.b.a.a.g.b;

import android.content.SharedPreferences;
import android.util.Base64;

public final class l extends e<T> {
    public final Object k = new Object();
    public String l;
    public T m;
    public final /* synthetic */ n n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public l(o oVar, String str, Object obj, n nVar) {
        super(oVar, str, obj, null);
        this.n = nVar;
    }

    @Override // c.b.a.a.g.b.e
    public final T b(SharedPreferences sharedPreferences) {
        try {
            return (T) f(sharedPreferences.getString(this.f3251b, ""));
        } catch (ClassCastException unused) {
            String valueOf = String.valueOf(this.f3251b);
            if (valueOf.length() != 0) {
                "Invalid byte[] value in SharedPreferences for ".concat(valueOf);
                return null;
            }
            new String("Invalid byte[] value in SharedPreferences for ");
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0023, code lost:
        java.lang.String.valueOf(r3.f3251b).length();
        java.lang.String.valueOf(r4).length();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0034, code lost:
        return null;
     */
    @Override // c.b.a.a.g.b.e
    public final T f(String str) {
        T t;
        synchronized (this.k) {
            if (!str.equals(this.l)) {
                n nVar = this.n;
                this.l = str;
                this.m = (T) ((f5) nVar).a(Base64.decode(str, 3));
            }
            t = this.m;
        }
        return t;
    }
}
