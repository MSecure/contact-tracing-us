package f.b.a.a.a.c0;

import f.b.a.a.a.h0.i;
import f.b.a.a.a.h0.l;
import f.b.a.a.a.n0.a1;
import f.b.a.a.a.n0.p0;
import f.b.a.a.a.n0.v0;
import java.io.File;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import l.a.a.a.b;
import l.b.a.d;
/* loaded from: classes.dex */
public class n1 {

    /* renamed from: h */
    public static final f.b.a.a.a.t.p0.a f2196h = f.b.a.a.a.t.p0.a.e("KeyFileSubmitter");

    /* renamed from: i */
    public static final d f2197i = d.l(60);

    /* renamed from: j */
    public static final f.b.b.c.a f2198j = f.b.b.c.a.c.e();

    /* renamed from: k */
    public static final f.b.b.c.a f2199k = f.b.b.c.a.a;
    public final q1 a;
    public final p0 b;
    public final v0 c;

    /* renamed from: d */
    public final a1 f2200d;

    /* renamed from: e */
    public final ExecutorService f2201e;

    /* renamed from: f */
    public final ScheduledExecutorService f2202f;

    /* renamed from: g */
    public final f.b.a.a.a.t.q0.a f2203g;

    /* loaded from: classes.dex */
    public static class a {
        public final l a;
        public final i b;

        public a(String str, l lVar, i iVar) {
            this.a = lVar;
            this.b = iVar;
        }
    }

    public n1(q1 q1Var, p0 p0Var, v0 v0Var, a1 a1Var, f.b.a.a.a.t.q0.a aVar, ExecutorService executorService, ScheduledExecutorService scheduledExecutorService) {
        this.a = q1Var;
        this.b = p0Var;
        this.c = v0Var;
        this.f2200d = a1Var;
        this.f2203g = aVar;
        this.f2201e = executorService;
        this.f2202f = scheduledExecutorService;
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
            try {
                zipFile.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }
}
