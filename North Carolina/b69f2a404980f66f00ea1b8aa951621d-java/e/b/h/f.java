package e.b.h;

import c.b.a.a.c.n.c;
import e.b.h.j;
import e.b.h.m;
import e.b.i.g;
import e.b.i.h;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;

public class f extends i {
    public a j = new a();
    public g k;
    public b l = b.noQuirks;
    public boolean m = false;

    public static class a implements Cloneable {

        /* renamed from: b  reason: collision with root package name */
        public j.b f4834b = j.b.base;

        /* renamed from: c  reason: collision with root package name */
        public Charset f4835c = Charset.forName("UTF8");

        /* renamed from: d  reason: collision with root package name */
        public ThreadLocal<CharsetEncoder> f4836d = new ThreadLocal<>();

        /* renamed from: e  reason: collision with root package name */
        public j.a f4837e;
        public boolean f = true;
        public boolean g = false;
        public int h = 1;
        public EnumC0115a i = EnumC0115a.html;

        /* renamed from: e.b.h.f$a$a  reason: collision with other inner class name */
        public enum EnumC0115a {
            html,
            xml
        }

        /* renamed from: a */
        public a clone() {
            try {
                a aVar = (a) super.clone();
                String name = this.f4835c.name();
                if (aVar != null) {
                    aVar.f4835c = Charset.forName(name);
                    aVar.f4834b = j.b.valueOf(this.f4834b.name());
                    return aVar;
                }
                throw null;
            } catch (CloneNotSupportedException e2) {
                throw new RuntimeException(e2);
            }
        }

        public CharsetEncoder b() {
            CharsetEncoder newEncoder = this.f4835c.newEncoder();
            this.f4836d.set(newEncoder);
            String name = newEncoder.charset().name();
            this.f4837e = name.equals("US-ASCII") ? j.a.ascii : name.startsWith("UTF-") ? j.a.utf : j.a.fallback;
            return newEncoder;
        }
    }

    public enum b {
        noQuirks,
        quirks,
        limitedQuirks
    }

    public f(String str) {
        super(h.a("#root", e.b.i.f.f4882c), str, null);
    }

    /* renamed from: O */
    public f j() {
        f fVar = (f) super.j();
        fVar.j = this.j.clone();
        return fVar;
    }

    public final i P(String str, m mVar) {
        if (mVar.s().equals(str)) {
            return (i) mVar;
        }
        int h = mVar.h();
        for (int i = 0; i < h; i++) {
            i P = P(str, mVar.g(i));
            if (P != null) {
                return P;
            }
        }
        return null;
    }

    @Override // e.b.h.i, e.b.h.m
    public String s() {
        return "#document";
    }

    @Override // e.b.h.m
    public String t() {
        StringBuilder b2 = e.b.g.b.b();
        int size = this.f.size();
        for (int i = 0; i < size; i++) {
            m mVar = this.f.get(i);
            if (mVar != null) {
                c.s2(new m.a(b2, c.L1(mVar)), mVar);
            } else {
                throw null;
            }
        }
        String j2 = e.b.g.b.j(b2);
        return c.L1(this).f ? j2.trim() : j2;
    }
}
