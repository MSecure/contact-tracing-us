package j.l;
/* loaded from: classes.dex */
public final class c extends a {

    /* renamed from: e  reason: collision with root package name */
    public static final c f4574e = new c(1, 0);

    /* renamed from: f  reason: collision with root package name */
    public static final c f4575f = null;

    public c(int i2, int i3) {
        super(i2, i3, 1);
    }

    @Override // j.l.a, java.lang.Object
    public boolean equals(Object obj) {
        if (obj instanceof c) {
            if (!isEmpty() || !((c) obj).isEmpty()) {
                c cVar = (c) obj;
                if (!(this.b == cVar.b && this.c == cVar.c)) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // j.l.a, java.lang.Object
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (this.b * 31) + this.c;
    }

    @Override // j.l.a
    public boolean isEmpty() {
        return this.b > this.c;
    }

    @Override // j.l.a, java.lang.Object
    public String toString() {
        return this.b + ".." + this.c;
    }
}
