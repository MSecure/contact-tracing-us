package f.b.c.k;

import android.util.SparseArray;
import f.b.c.b;
/* loaded from: classes.dex */
public class g extends b {

    /* loaded from: classes.dex */
    public enum a {
        OK(0),
        CANCELLED(1),
        UNKNOWN(2),
        INVALID_ARGUMENT(3),
        DEADLINE_EXCEEDED(4),
        NOT_FOUND(5),
        ALREADY_EXISTS(6),
        PERMISSION_DENIED(7),
        RESOURCE_EXHAUSTED(8),
        FAILED_PRECONDITION(9),
        ABORTED(10),
        OUT_OF_RANGE(11),
        UNIMPLEMENTED(12),
        INTERNAL(13),
        UNAVAILABLE(14),
        DATA_LOSS(15),
        UNAUTHENTICATED(16);
        
        public static final SparseArray<a> t;
        public final int b;

        static {
            SparseArray<a> sparseArray = new SparseArray<>();
            a[] values = values();
            for (int i2 = 0; i2 < 17; i2++) {
                a aVar = values[i2];
                a aVar2 = sparseArray.get(aVar.b);
                if (aVar2 == null) {
                    sparseArray.put(aVar.b, aVar);
                } else {
                    throw new IllegalStateException("Code value duplication between " + aVar2 + "&" + aVar.name());
                }
            }
            t = sparseArray;
        }

        a(int i2) {
            this.b = i2;
        }
    }

    public g(String str, a aVar) {
        super(str);
        f.b.a.c.b.o.b.C(str, "Provided message must not be null.");
        f.b.a.c.b.o.b.P0(aVar != a.OK, "A FirebaseFirestoreException should never be thrown for OK", new Object[0]);
        f.b.a.c.b.o.b.C(aVar, "Provided code must not be null.");
    }

    public g(String str, a aVar, Throwable th) {
        super(str, th);
        f.b.a.c.b.o.b.C(str, "Provided message must not be null.");
        f.b.a.c.b.o.b.P0(aVar != a.OK, "A FirebaseFirestoreException should never be thrown for OK", new Object[0]);
        f.b.a.c.b.o.b.C(aVar, "Provided code must not be null.");
    }
}
