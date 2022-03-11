package f.b.c.k.s;

import f.b.c.k.u.h;
/* loaded from: classes.dex */
public class w {
    public final a a;
    public final h b;

    /* loaded from: classes.dex */
    public enum a {
        ASCENDING(1),
        DESCENDING(-1);
        
        public final int b;

        a(int i2) {
            this.b = i2;
        }
    }

    public w(a aVar, h hVar) {
        this.a = aVar;
        this.b = hVar;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof w)) {
            return false;
        }
        w wVar = (w) obj;
        return this.a == wVar.a && this.b.equals(wVar.b);
    }

    public int hashCode() {
        return this.b.hashCode() + ((this.a.hashCode() + 899) * 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.a == a.ASCENDING ? "" : "-");
        sb.append(this.b.c());
        return sb.toString();
    }
}
