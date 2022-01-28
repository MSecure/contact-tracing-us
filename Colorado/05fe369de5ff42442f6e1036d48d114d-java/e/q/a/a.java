package e.q.a;

import e.p.h0;
import e.p.l;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public abstract class a {
    public static <T extends l & h0> a b(T t) {
        return new b(t, t.i());
    }

    @Deprecated
    public abstract void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);
}
