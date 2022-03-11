package f.b.c.k;
/* loaded from: classes.dex */
public final class h {
    public final String a;
    public final boolean b;
    public final boolean c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f3511d = true;

    /* renamed from: e  reason: collision with root package name */
    public final long f3512e = 104857600;

    /* loaded from: classes.dex */
    public static final class b {
        public String a = "firestore.googleapis.com";
        public boolean b = true;
        public boolean c = true;

        public h a() {
            if (this.b || !this.a.equals("firestore.googleapis.com")) {
                return new h(this, null);
            }
            throw new IllegalStateException("You can't set the 'sslEnabled' setting unless you also set a non-default 'host'.");
        }
    }

    public h(b bVar, a aVar) {
        this.a = bVar.a;
        this.b = bVar.b;
        this.c = bVar.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || h.class != obj.getClass()) {
            return false;
        }
        h hVar = (h) obj;
        return this.a.equals(hVar.a) && this.b == hVar.b && this.c == hVar.c && this.f3511d == hVar.f3511d && this.f3512e == hVar.f3512e;
    }

    public int hashCode() {
        return (((((((this.a.hashCode() * 31) + (this.b ? 1 : 0)) * 31) + (this.c ? 1 : 0)) * 31) + (this.f3511d ? 1 : 0)) * 31) + ((int) this.f3512e);
    }

    public String toString() {
        StringBuilder h2 = f.a.a.a.a.h("FirebaseFirestoreSettings{host=");
        h2.append(this.a);
        h2.append(", sslEnabled=");
        h2.append(this.b);
        h2.append(", persistenceEnabled=");
        h2.append(this.c);
        h2.append(", timestampsInSnapshotsEnabled=");
        h2.append(this.f3511d);
        h2.append(", cacheSizeBytes=");
        h2.append(this.f3512e);
        h2.append("}");
        return h2.toString();
    }
}
