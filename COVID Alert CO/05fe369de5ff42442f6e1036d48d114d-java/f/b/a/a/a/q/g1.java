package f.b.a.a.a.q;

import f.b.a.a.a.b0.m0;
import f.b.a.a.a.b0.r0;
import f.b.a.a.a.b0.v0;
import f.b.a.a.a.v.i;
import f.b.a.a.a.v.l;
import java.io.File;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import l.a.a.a.b;
import l.b.a.d;

public class g1 {

    /* renamed from: h  reason: collision with root package name */
    public static final f.b.a.a.a.i.e0.a f2331h = f.b.a.a.a.i.e0.a.e("KeyFileSubmitter");

    /* renamed from: i  reason: collision with root package name */
    public static final d f2332i = d.l(60);

    /* renamed from: j  reason: collision with root package name */
    public static final f.b.b.c.a f2333j = f.b.b.c.a.c.e();

    /* renamed from: k  reason: collision with root package name */
    public static final f.b.b.c.a f2334k = f.b.b.c.a.a;
    public final i1 a;
    public final m0 b;
    public final r0 c;

    /* renamed from: d  reason: collision with root package name */
    public final v0 f2335d;

    /* renamed from: e  reason: collision with root package name */
    public final ExecutorService f2336e;

    /* renamed from: f  reason: collision with root package name */
    public final ScheduledExecutorService f2337f;

    /* renamed from: g  reason: collision with root package name */
    public final f.b.a.a.a.i.f0.a f2338g;

    public static class a {
        public final l a;
        public final i b;

        public a(String str, l lVar, i iVar) {
            this.a = lVar;
            this.b = iVar;
        }
    }

    public g1(i1 i1Var, m0 m0Var, r0 r0Var, v0 v0Var, f.b.a.a.a.i.f0.a aVar, ExecutorService executorService, ScheduledExecutorService scheduledExecutorService) {
        this.a = i1Var;
        this.b = m0Var;
        this.c = r0Var;
        this.f2335d = v0Var;
        this.f2338g = aVar;
        this.f2336e = executorService;
        this.f2337f = scheduledExecutorService;
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
            a aVar = new a(new String(copyOf), l.parseFrom(copyOfRange), i.parseFrom(a2));
            zipFile.close();
            return aVar;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }
}
