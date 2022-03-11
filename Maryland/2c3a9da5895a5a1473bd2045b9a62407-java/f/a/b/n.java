package f.a.b;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.GuardedBy;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import f.a.b.b;
import f.a.b.c;
import f.a.b.o;
import f.a.b.p;
import f.a.b.v;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public abstract class n<T> implements Comparable<n<T>> {
    public final v.a b;
    public final int c;

    /* renamed from: d  reason: collision with root package name */
    public final String f2053d;

    /* renamed from: e  reason: collision with root package name */
    public final int f2054e;

    /* renamed from: f  reason: collision with root package name */
    public final Object f2055f;
    @GuardedBy("mLock")
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    public p.a f2056g;

    /* renamed from: h  reason: collision with root package name */
    public Integer f2057h;

    /* renamed from: i  reason: collision with root package name */
    public o f2058i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f2059j;
    @GuardedBy("mLock")

    /* renamed from: k  reason: collision with root package name */
    public boolean f2060k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f2061l;
    public r m;
    public b.a n;
    @GuardedBy("mLock")
    public b o;

    public class a implements Runnable {
        public final /* synthetic */ String b;
        public final /* synthetic */ long c;

        public a(String str, long j2) {
            this.b = str;
            this.c = j2;
        }

        public void run() {
            n.this.b.a(this.b, this.c);
            n nVar = n.this;
            nVar.b.b(nVar.toString());
        }
    }

    public interface b {
    }

    public enum c {
        LOW,
        NORMAL,
        HIGH,
        IMMEDIATE
    }

    public n(int i2, String str, @Nullable p.a aVar) {
        Uri parse;
        String host;
        this.b = v.a.c ? new v.a() : null;
        this.f2055f = new Object();
        this.f2059j = true;
        int i3 = 0;
        this.f2060k = false;
        this.f2061l = false;
        this.n = null;
        this.c = i2;
        this.f2053d = str;
        this.f2056g = aVar;
        this.m = new e();
        if (!(TextUtils.isEmpty(str) || (parse = Uri.parse(str)) == null || (host = parse.getHost()) == null)) {
            i3 = host.hashCode();
        }
        this.f2054e = i3;
    }

    public void a(String str) {
        if (v.a.c) {
            this.b.a(str, Thread.currentThread().getId());
        }
    }

    public abstract void b(T t);

    public void c(String str) {
        o oVar = this.f2058i;
        if (oVar != null) {
            synchronized (oVar.b) {
                oVar.b.remove(this);
            }
            synchronized (oVar.f2072j) {
                for (o.a aVar : oVar.f2072j) {
                    aVar.a(this);
                }
            }
        }
        if (v.a.c) {
            long id = Thread.currentThread().getId();
            if (Looper.myLooper() != Looper.getMainLooper()) {
                new Handler(Looper.getMainLooper()).post(new a(str, id));
                return;
            }
            this.b.a(str, id);
            this.b.b(toString());
        }
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        n nVar = (n) obj;
        Objects.requireNonNull(nVar);
        return this.f2057h.intValue() - nVar.f2057h.intValue();
    }

    public byte[] e() {
        return null;
    }

    public String f() {
        return f.a.a.a.a.t("application/x-www-form-urlencoded; charset=", "UTF-8");
    }

    public String h() {
        String str = this.f2053d;
        int i2 = this.c;
        if (i2 == 0 || i2 == -1) {
            return str;
        }
        return Integer.toString(i2) + '-' + str;
    }

    public Map<String, String> i() {
        return Collections.emptyMap();
    }

    @Deprecated
    public byte[] l() {
        return null;
    }

    public boolean m() {
        synchronized (this.f2055f) {
        }
        return false;
    }

    public void n() {
        b bVar;
        synchronized (this.f2055f) {
            bVar = this.o;
        }
        if (bVar != null) {
            ((c.a) bVar).b(this);
        }
    }

    public void o(p<?> pVar) {
        b bVar;
        List<n<?>> remove;
        synchronized (this.f2055f) {
            bVar = this.o;
        }
        if (bVar != null) {
            c.a aVar = (c.a) bVar;
            b.a aVar2 = pVar.b;
            if (aVar2 != null) {
                if (!(aVar2.f2038d < System.currentTimeMillis())) {
                    String h2 = h();
                    synchronized (aVar) {
                        remove = aVar.a.remove(h2);
                    }
                    if (remove != null) {
                        if (v.a) {
                            v.c("Releasing %d waiting requests for cacheKey=%s.", Integer.valueOf(remove.size()), h2);
                        }
                        for (n<?> nVar : remove) {
                            ((f) aVar.b.f2044e).a(nVar, pVar, null);
                        }
                        return;
                    }
                    return;
                }
            }
            aVar.b(this);
        }
    }

    public abstract p<T> q(k kVar);

    public String toString() {
        StringBuilder h2 = f.a.a.a.a.h("0x");
        h2.append(Integer.toHexString(this.f2054e));
        String sb = h2.toString();
        StringBuilder sb2 = new StringBuilder();
        m();
        sb2.append("[ ] ");
        sb2.append(this.f2053d);
        sb2.append(" ");
        sb2.append(sb);
        sb2.append(" ");
        sb2.append(c.NORMAL);
        sb2.append(" ");
        sb2.append(this.f2057h);
        return sb2.toString();
    }
}
