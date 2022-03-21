package f.b.a.b.i;

import android.util.Base64;
import f.b.a.b.d;
import f.b.a.b.i.b;

public abstract class i {

    public static abstract class a {
        public abstract i a();

        public abstract a b(String str);

        public abstract a c(d dVar);
    }

    public static a a() {
        b.C0076b bVar = new b.C0076b();
        bVar.c(d.DEFAULT);
        return bVar;
    }

    public abstract String b();

    public abstract byte[] c();

    public abstract d d();

    public final String toString() {
        Object[] objArr = new Object[3];
        objArr[0] = b();
        objArr[1] = d();
        objArr[2] = c() == null ? "" : Base64.encodeToString(c(), 2);
        return String.format("TransportContext(%s, %s, %s)", objArr);
    }
}
