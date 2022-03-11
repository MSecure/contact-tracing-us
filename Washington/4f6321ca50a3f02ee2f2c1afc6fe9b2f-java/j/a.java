package j;

import j.j.b.e;

public final class a implements Comparable<a> {

    /* renamed from: f  reason: collision with root package name */
    public static final a f3996f = new a(1, 4, 10);
    public final int b;
    public final int c;

    /* renamed from: d  reason: collision with root package name */
    public final int f3997d;

    /* renamed from: e  reason: collision with root package name */
    public final int f3998e;

    public a(int i2, int i3, int i4) {
        this.c = i2;
        this.f3997d = i3;
        this.f3998e = i4;
        if (i2 >= 0 && 255 >= i2 && i3 >= 0 && 255 >= i3 && i4 >= 0 && 255 >= i4) {
            this.b = (i2 << 16) + (i3 << 8) + i4;
            return;
        }
        throw new IllegalArgumentException(("Version components are out of range: " + i2 + '.' + i3 + '.' + i4).toString());
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public int compareTo(a aVar) {
        a aVar2 = aVar;
        e.c(aVar2, "other");
        return this.b - aVar2.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            obj = null;
        }
        a aVar = (a) obj;
        return aVar != null && this.b == aVar.b;
    }

    public int hashCode() {
        return this.b;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.c);
        sb.append('.');
        sb.append(this.f3997d);
        sb.append('.');
        sb.append(this.f3998e);
        return sb.toString();
    }
}
