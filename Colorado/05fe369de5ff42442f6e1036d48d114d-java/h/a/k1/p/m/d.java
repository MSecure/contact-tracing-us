package h.a.k1.p.m;

import k.h;

public final class d {

    /* renamed from: d  reason: collision with root package name */
    public static final h f4167d = h.b(":status");

    /* renamed from: e  reason: collision with root package name */
    public static final h f4168e = h.b(":method");

    /* renamed from: f  reason: collision with root package name */
    public static final h f4169f = h.b(":path");

    /* renamed from: g  reason: collision with root package name */
    public static final h f4170g = h.b(":scheme");

    /* renamed from: h  reason: collision with root package name */
    public static final h f4171h = h.b(":authority");
    public final h a;
    public final h b;
    public final int c;

    static {
        h.b(":host");
        h.b(":version");
    }

    public d(String str, String str2) {
        this(h.b(str), h.b(str2));
    }

    public d(h hVar, String str) {
        this(hVar, h.b(str));
    }

    public d(h hVar, h hVar2) {
        this.a = hVar;
        this.b = hVar2;
        this.c = hVar2.l() + hVar.l() + 32;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.a.equals(dVar.a) && this.b.equals(dVar.b);
    }

    public int hashCode() {
        return this.b.hashCode() + ((this.a.hashCode() + 527) * 31);
    }

    public String toString() {
        return String.format("%s: %s", this.a.q(), this.b.q());
    }
}
