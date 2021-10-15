package b.p.a;

import b.o.a0;
import b.o.i;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public abstract class a {
    public static <T extends i & a0> a b(T t) {
        return new b(t, t.getViewModelStore());
    }

    @Deprecated
    public abstract void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);
}
