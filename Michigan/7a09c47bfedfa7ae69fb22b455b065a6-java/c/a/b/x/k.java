package c.a.b.x;

import android.support.annotation.GuardedBy;
import android.support.annotation.Nullable;
import b.x.t;
import c.a.b.l;
import c.a.b.o;
import c.a.b.q;
import java.io.UnsupportedEncodingException;

public class k extends o<String> {

    /* renamed from: b  reason: collision with root package name */
    public final Object f2887b = new Object();
    @GuardedBy("mLock")
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public q.b<String> f2888c;

    public k(String str, q.b<String> bVar, @Nullable q.a aVar) {
        super(0, str, aVar);
        this.f2888c = bVar;
    }

    @Override // c.a.b.o
    public void cancel() {
        super.cancel();
        synchronized (this.f2887b) {
            this.f2888c = null;
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // c.a.b.o
    public void deliverResponse(String str) {
        q.b<String> bVar;
        String str2 = str;
        synchronized (this.f2887b) {
            bVar = this.f2888c;
        }
        if (bVar != null) {
            bVar.a(str2);
        }
    }

    @Override // c.a.b.o
    public q<String> parseNetworkResponse(l lVar) {
        String str;
        try {
            str = new String(lVar.f2828b, t.k2(lVar.f2829c, "ISO-8859-1"));
        } catch (UnsupportedEncodingException unused) {
            str = new String(lVar.f2828b);
        }
        return new q<>(str, t.j2(lVar));
    }
}
