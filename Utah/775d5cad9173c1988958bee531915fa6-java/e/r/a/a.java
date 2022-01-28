package e.r.a;

import e.q.h0;
import e.q.l;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public abstract class a {
    public static <T extends l & h0> a b(T t) {
        return new b(t, t.i());
    }

    @Deprecated
    public abstract void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);
}
