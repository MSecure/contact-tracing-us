package e.s.a;

import e.r.h0;
import e.r.l;
import java.io.FileDescriptor;
import java.io.PrintWriter;
/* loaded from: classes.dex */
public abstract class a {
    public static <T extends l & h0> a b(T t) {
        return new b(t, t.i());
    }

    @Deprecated
    public abstract void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);
}
