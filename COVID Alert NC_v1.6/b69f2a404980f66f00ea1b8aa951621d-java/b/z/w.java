package b.z;

import androidx.work.ListenableWorker;
import b.z.y.r.p;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public abstract class w {

    /* renamed from: a  reason: collision with root package name */
    public UUID f1936a;

    /* renamed from: b  reason: collision with root package name */
    public p f1937b;

    /* renamed from: c  reason: collision with root package name */
    public Set<String> f1938c;

    public static abstract class a<B extends a<?, ?>, W extends w> {

        /* renamed from: a  reason: collision with root package name */
        public boolean f1939a = false;

        /* renamed from: b  reason: collision with root package name */
        public UUID f1940b = UUID.randomUUID();

        /* renamed from: c  reason: collision with root package name */
        public p f1941c;

        /* renamed from: d  reason: collision with root package name */
        public Set<String> f1942d = new HashSet();

        public a(Class<? extends ListenableWorker> cls) {
            this.f1941c = new p(this.f1940b.toString(), cls.getName());
            this.f1942d.add(cls.getName());
            c();
        }

        public final W a() {
            W b2 = b();
            this.f1940b = UUID.randomUUID();
            p pVar = new p(this.f1941c);
            this.f1941c = pVar;
            pVar.f2091a = this.f1940b.toString();
            return b2;
        }

        public abstract W b();

        public abstract B c();
    }

    public w(UUID uuid, p pVar, Set<String> set) {
        this.f1936a = uuid;
        this.f1937b = pVar;
        this.f1938c = set;
    }

    public String a() {
        return this.f1936a.toString();
    }
}
