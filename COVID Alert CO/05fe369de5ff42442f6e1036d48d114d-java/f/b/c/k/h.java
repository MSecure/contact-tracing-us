package f.b.c.k;

public final class h {
    public final String a;
    public final boolean b;
    public final boolean c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f3193d = true;

    /* renamed from: e  reason: collision with root package name */
    public final long f3194e = 104857600;

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
        return this.a.equals(hVar.a) && this.b == hVar.b && this.c == hVar.c && this.f3193d == hVar.f3193d && this.f3194e == hVar.f3194e;
    }

    public int hashCode() {
        return (((((((this.a.hashCode() * 31) + (this.b ? 1 : 0)) * 31) + (this.c ? 1 : 0)) * 31) + (this.f3193d ? 1 : 0)) * 31) + ((int) this.f3194e);
    }

    public String toString() {
        StringBuilder i2 = f.a.a.a.a.i("FirebaseFirestoreSettings{host=");
        i2.append(this.a);
        i2.append(", sslEnabled=");
        i2.append(this.b);
        i2.append(", persistenceEnabled=");
        i2.append(this.c);
        i2.append(", timestampsInSnapshotsEnabled=");
        i2.append(this.f3193d);
        i2.append(", cacheSizeBytes=");
        i2.append(this.f3194e);
        i2.append("}");
        return i2.toString();
    }
}
