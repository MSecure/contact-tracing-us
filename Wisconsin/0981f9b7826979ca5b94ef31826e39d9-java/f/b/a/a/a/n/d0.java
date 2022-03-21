package f.b.a.a.a.n;

import f.b.a.a.a.s.n;
import f.b.a.a.a.s.q;
import f.b.a.a.a.w.g0;
import f.b.a.a.a.w.k0;
import java.io.File;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import l.a.a.a.b;
import l.b.a.c;

public class d0 {

    /* renamed from: f  reason: collision with root package name */
    public static final c f2137f = c.h(60);

    /* renamed from: g  reason: collision with root package name */
    public static final f.b.b.c.a f2138g = f.b.b.c.a.c.e();

    /* renamed from: h  reason: collision with root package name */
    public static final f.b.b.c.a f2139h = f.b.b.c.a.a;
    public final f0 a;
    public final g0 b;
    public final k0 c;

    /* renamed from: d  reason: collision with root package name */
    public final ExecutorService f2140d;

    /* renamed from: e  reason: collision with root package name */
    public final ScheduledExecutorService f2141e;

    public static class a {
        public final q a;
        public final n b;

        public a(String str, q qVar, n nVar) {
            this.a = qVar;
            this.b = nVar;
        }
    }

    public d0(f0 f0Var, g0 g0Var, k0 k0Var, ExecutorService executorService, ScheduledExecutorService scheduledExecutorService) {
        this.a = f0Var;
        this.b = g0Var;
        this.c = k0Var;
        this.f2140d = executorService;
        this.f2141e = scheduledExecutorService;
    }

    public final a a(File file) {
        ZipFile zipFile = new ZipFile(file);
        try {
            ZipEntry entry = zipFile.getEntry("export.sig");
            ZipEntry entry2 = zipFile.getEntry("export.bin");
            byte[] a2 = b.a(zipFile.getInputStream(entry));
            byte[] a3 = b.a(zipFile.getInputStream(entry2));
            byte[] copyOf = Arrays.copyOf(a3, 16);
            byte[] copyOfRange = Arrays.copyOfRange(a3, 16, a3.length);
            a aVar = new a(new String(copyOf), q.parseFrom(copyOfRange), n.parseFrom(a2));
            zipFile.close();
            return aVar;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }
}
