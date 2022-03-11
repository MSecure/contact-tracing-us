package e.q.a;

import e.p.d0;
import e.p.j;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public abstract class a {
    public static <T extends j & d0> a b(T t) {
        return new b(t, t.h());
    }

    @Deprecated
    public abstract void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);
}
