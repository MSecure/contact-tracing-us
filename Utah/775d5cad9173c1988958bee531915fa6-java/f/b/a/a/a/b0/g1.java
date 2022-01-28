package f.b.a.a.a.b0;

import f.b.a.a.a.g0.i;
import f.b.a.a.a.g0.l;
import f.b.a.a.a.l0.m0;
import f.b.a.a.a.l0.r0;
import f.b.a.a.a.l0.v0;
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
    public static final f.b.a.a.a.s.d0.a f2161h = f.b.a.a.a.s.d0.a.e("KeyFileSubmitter");

    /* renamed from: i  reason: collision with root package name */
    public static final d f2162i = d.l(60);

    /* renamed from: j  reason: collision with root package name */
    public static final f.b.b.c.a f2163j = f.b.b.c.a.c.e();

    /* renamed from: k  reason: collision with root package name */
    public static final f.b.b.c.a f2164k = f.b.b.c.a.a;
    public final i1 a;
    public final m0 b;
    public final r0 c;

    /* renamed from: d  reason: collision with root package name */
    public final v0 f2165d;

    /* renamed from: e  reason: collision with root package name */
    public final ExecutorService f2166e;

    /* renamed from: f  reason: collision with root package name */
    public final ScheduledExecutorService f2167f;

    /* renamed from: g  reason: collision with root package name */
    public final f.b.a.a.a.s.e0.a f2168g;

    public static class a {
        public final l a;
        public final i b;

        public a(String str, l lVar, i iVar) {
            this.a = lVar;
            this.b = iVar;
        }
    }

    public g1(i1 i1Var, m0 m0Var, r0 r0Var, v0 v0Var, f.b.a.a.a.s.e0.a aVar, ExecutorService executorService, ScheduledExecutorService scheduledExecutorService) {
        this.a = i1Var;
        this.b = m0Var;
        this.c = r0Var;
        this.f2165d = v0Var;
        this.f2168g = aVar;
        this.f2166e = executorService;
        this.f2167f = scheduledExecutorService;
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
