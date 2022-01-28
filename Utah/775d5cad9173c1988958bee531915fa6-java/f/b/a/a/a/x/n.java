package f.b.a.a.a.x;

import android.content.Context;
import e.b.a.m;
import f.b.a.a.a.c0.g;
import f.b.a.a.a.g0.d;
import f.b.a.a.a.i0.c;
import f.b.a.a.a.z.r;
import f.b.b.c.a;
import f.b.b.f.a.p;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import l.b.a.d;

public class n {
    public static final f.b.a.a.a.s.d0.a m = f.b.a.a.a.s.d0.a.e("DiagnosisKeyDownloader");
    public static final SecureRandom n = new SecureRandom();
    public static final f.b.b.c.a o;
    public static final d p = d.l(30);
    public final Context a;
    public final c b;
    public final r c;

    /* renamed from: d  reason: collision with root package name */
    public final o f2448d;

    /* renamed from: e  reason: collision with root package name */
    public final Map<String, List<o>> f2449e;

    /* renamed from: f  reason: collision with root package name */
    public final g f2450f;

    /* renamed from: g  reason: collision with root package name */
    public final ExecutorService f2451g;

    /* renamed from: h  reason: collision with root package name */
    public final ExecutorService f2452h;

    /* renamed from: i  reason: collision with root package name */
    public final ScheduledExecutorService f2453i;

    /* renamed from: j  reason: collision with root package name */
    public final r f2454j;

    /* renamed from: k  reason: collision with root package name */
    public final f.b.a.a.a.s.e0.a f2455k;

    /* renamed from: l  reason: collision with root package name */
    public final p<f.b.b.b.c<q>> f2456l = new a();

    public class a implements p<f.b.b.b.c<q>> {
        public a() {
        }

        @Override // f.b.b.f.a.p
        public void a(Throwable th) {
            n.this.f2454j.l(d.EnumC0074d.RPC_TYPE_KEYS_DOWNLOAD, th);
            n.m.a(m.e.i0(th).toString());
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // f.b.b.f.a.p
        public void b(f.b.b.b.c<q> cVar) {
            f.b.b.b.a<q> t = cVar.listIterator();
            int i2 = 0;
            while (t.hasNext()) {
                i2 = (int) (t.next().a().length() + ((long) i2));
            }
            n.this.f2454j.j(d.EnumC0074d.RPC_TYPE_KEYS_DOWNLOAD, i2);
        }
    }

    static {
        a.e eVar = (a.e) f.b.b.c.a.b.e();
        Character ch = eVar.f3167e;
        f.b.b.c.a aVar = eVar;
        if (ch != null) {
            aVar = eVar.h(eVar.f3166d, null);
        }
        o = aVar;
    }

    public n(Context context, g gVar, c cVar, r rVar, o oVar, Map<String, List<o>> map, ExecutorService executorService, ExecutorService executorService2, ScheduledExecutorService scheduledExecutorService, r rVar2, f.b.a.a.a.s.e0.a aVar) {
        this.a = context;
        this.f2450f = gVar;
        this.b = cVar;
        this.c = rVar;
        this.f2448d = oVar;
        this.f2449e = map;
        this.f2451g = executorService;
        this.f2452h = executorService2;
        this.f2453i = scheduledExecutorService;
        this.f2454j = rVar2;
        this.f2455k = aVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0095, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x009a, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x009b, code lost:
        r4.addSuppressed(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x009e, code lost:
        throw r5;
     */
    public final File a(byte[] bArr, String str) {
        File file = new File(this.a.getFilesDir(), str);
        BigInteger bigInteger = l.a.a.a.a.a;
        int length = bArr.length;
        if (!file.exists()) {
            File parentFile = file.getParentFile();
            if (parentFile != null && !parentFile.mkdirs() && !parentFile.isDirectory()) {
                throw new IOException("Directory '" + parentFile + "' could not be created");
            }
        } else if (file.isDirectory()) {
            throw new IOException("File '" + file + "' exists but is a directory");
        } else if (!file.canWrite()) {
            throw new IOException("File '" + file + "' cannot be written to");
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file, false);
        fileOutputStream.write(bArr, 0, length);
        fileOutputStream.close();
        return file;
    }
}
