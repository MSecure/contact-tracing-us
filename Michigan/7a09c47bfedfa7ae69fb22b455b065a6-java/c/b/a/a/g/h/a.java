package c.b.a.a.g.h;

import java.io.PrintStream;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final c f3836a;

    /* renamed from: c.b.a.a.g.h.a$a  reason: collision with other inner class name */
    public static final class C0071a extends c {
        @Override // c.b.a.a.g.h.c
        public final void a(Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0080  */
    /* JADX WARNING: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    static {
        c cVar;
        Integer num = null;
        try {
            num = (Integer) Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);
        } catch (Exception e2) {
            System.err.println("Failed to retrieve value from android.os.Build$VERSION.SDK_INT due to the following exception.");
            e2.printStackTrace(System.err);
        } catch (Throwable th) {
            PrintStream printStream = System.err;
            String name = C0071a.class.getName();
            StringBuilder sb = new StringBuilder(name.length() + 133);
            sb.append("An error has occurred when initializing the try-with-resources desuguring strategy. The default strategy ");
            sb.append(name);
            sb.append("will be used. The error is: ");
            printStream.println(sb.toString());
            th.printStackTrace(System.err);
            cVar = new C0071a();
        }
        if (num == null || num.intValue() < 19) {
            cVar = Boolean.getBoolean("com.google.devtools.build.android.desugar.runtime.twr_disable_mimic") ^ true ? new d() : new C0071a();
            f3836a = cVar;
            if (num == null) {
                num.intValue();
                return;
            }
            return;
        }
        cVar = new f();
        f3836a = cVar;
        if (num == null) {
        }
    }
}
