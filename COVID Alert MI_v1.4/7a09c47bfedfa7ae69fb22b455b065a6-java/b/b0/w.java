package b.b0;

import androidx.work.ListenableWorker;
import b.b0.y.r.p;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public abstract class w {

    /* renamed from: a  reason: collision with root package name */
    public UUID f1056a;

    /* renamed from: b  reason: collision with root package name */
    public p f1057b;

    /* renamed from: c  reason: collision with root package name */
    public Set<String> f1058c;

    public static abstract class a<B extends a<?, ?>, W extends w> {

        /* renamed from: a  reason: collision with root package name */
        public boolean f1059a = false;

        /* renamed from: b  reason: collision with root package name */
        public UUID f1060b = UUID.randomUUID();

        /* renamed from: c  reason: collision with root package name */
        public p f1061c;

        /* renamed from: d  reason: collision with root package name */
        public Set<String> f1062d = new HashSet();

        public a(Class<? extends ListenableWorker> cls) {
            this.f1061c = new p(this.f1060b.toString(), cls.getName());
            this.f1062d.add(cls.getName());
            c();
        }

        public final W a() {
            W b2 = b();
            this.f1060b = UUID.randomUUID();
            p pVar = new p(this.f1061c);
            this.f1061c = pVar;
            pVar.f1234a = this.f1060b.toString();
            return b2;
        }

        public abstract W b();

        public abstract B c();
    }

    public w(UUID uuid, p pVar, Set<String> set) {
        this.f1056a = uuid;
        this.f1057b = pVar;
        this.f1058c = set;
    }

    public String a() {
        return this.f1056a.toString();
    }
}
