package f.a.b.w;

import android.support.annotation.GuardedBy;
import android.support.annotation.Nullable;
import f.a.b.n;
import f.a.b.p;
import f.a.b.v;
import java.io.UnsupportedEncodingException;
/* loaded from: classes.dex */
public abstract class g<T> extends n<T> {
    public static final String s = String.format("application/json; charset=%s", "utf-8");
    public final Object p = new Object();
    @GuardedBy("mLock")
    @Nullable
    public p.b<T> q;
    @Nullable
    public final String r;

    public g(int i2, String str, @Nullable String str2, p.b<T> bVar, @Nullable p.a aVar) {
        super(i2, str, aVar);
        this.q = bVar;
        this.r = str2;
    }

    @Override // f.a.b.n
    public byte[] e() {
        try {
            String str = this.r;
            if (str == null) {
                return null;
            }
            return str.getBytes("utf-8");
        } catch (UnsupportedEncodingException unused) {
            v.a("Unsupported Encoding while trying to get the bytes of %s using %s", this.r, "utf-8");
            return null;
        }
    }

    @Override // f.a.b.n
    public String f() {
        return s;
    }

    @Override // f.a.b.n
    @Deprecated
    public byte[] l() {
        return e();
    }
}
