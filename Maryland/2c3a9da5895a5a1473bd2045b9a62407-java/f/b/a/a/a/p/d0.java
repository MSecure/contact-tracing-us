package f.b.a.a.a.p;

import f.b.a.a.a.u.n;
import f.b.a.a.a.u.q;
import f.b.a.a.a.y.h0;
import f.b.a.a.a.y.m0;
import f.b.a.a.a.y.q0;
import java.io.File;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import l.a.a.a.b;
import l.b.a.c;

public class d0 {

    /* renamed from: h  reason: collision with root package name */
    public static final c f2218h = c.i(60);

    /* renamed from: i  reason: collision with root package name */
    public static final f.b.b.c.a f2219i = f.b.b.c.a.c.e();

    /* renamed from: j  reason: collision with root package name */
    public static final f.b.b.c.a f2220j = f.b.b.c.a.a;
    public final f0 a;
    public final h0 b;
    public final m0 c;

    /* renamed from: d  reason: collision with root package name */
    public final q0 f2221d;

    /* renamed from: e  reason: collision with root package name */
    public final ExecutorService f2222e;

    /* renamed from: f  reason: collision with root package name */
    public final ScheduledExecutorService f2223f;

    /* renamed from: g  reason: collision with root package name */
    public final f.b.a.a.a.h.s.a f2224g;

    public static class a {
        public final q a;
        public final n b;

        public a(String str, q qVar, n nVar) {
            this.a = qVar;
            this.b = nVar;
        }
    }

    public d0(f0 f0Var, h0 h0Var, m0 m0Var, q0 q0Var, f.b.a.a.a.h.s.a aVar, ExecutorService executorService, ScheduledExecutorService scheduledExecutorService) {
        this.a = f0Var;
        this.b = h0Var;
        this.c = m0Var;
        this.f2221d = q0Var;
        this.f2224g = aVar;
        this.f2222e = executorService;
        this.f2223f = scheduledExecutorService;
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
