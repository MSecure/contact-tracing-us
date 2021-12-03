package f.a.b.w;

import android.support.annotation.GuardedBy;
import android.support.annotation.Nullable;
import e.b.a.m;
import f.a.b.k;
import f.a.b.n;
import f.a.b.p;
import java.io.UnsupportedEncodingException;

public class j extends n<String> {
    public final Object p = new Object();
    @GuardedBy("mLock")
    @Nullable
    public p.b<String> q;

    public j(int i2, String str, p.b<String> bVar, @Nullable p.a aVar) {
        super(i2, str, aVar);
        this.q = bVar;
    }

    @Override // f.a.b.n
    public p<String> q(k kVar) {
        String str;
        try {
            str = new String(kVar.b, m.e.b1(kVar.c, "ISO-8859-1"));
        } catch (UnsupportedEncodingException unused) {
            str = new String(kVar.b);
        }
        return new p<>(str, m.e.a1(kVar));
    }
}
