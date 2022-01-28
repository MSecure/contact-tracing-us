package f.b.a.a.a.n;

import android.content.Context;
import e.b.a.m;
import f.b.a.a.a.p.r;
import f.b.a.a.a.r.g;
import f.b.a.a.a.v.d;
import f.b.b.b.c;
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
    public static final f.b.a.a.a.i.e0.a m = f.b.a.a.a.i.e0.a.e("DiagnosisKeyDownloader");
    public static final SecureRandom n = new SecureRandom();
    public static final f.b.b.c.a o;
    public static final d p = d.l(30);
    public final Context a;
    public final f.b.a.a.a.y.d b;
    public final r c;

    /* renamed from: d  reason: collision with root package name */
    public final o f2256d;

    /* renamed from: e  reason: collision with root package name */
    public final Map<String, List<o>> f2257e;

    /* renamed from: f  reason: collision with root package name */
    public final g f2258f;

    /* renamed from: g  reason: collision with root package name */
    public final ExecutorService f2259g;

    /* renamed from: h  reason: collision with root package name */
    public final ExecutorService f2260h;

    /* renamed from: i  reason: collision with root package name */
    public final ScheduledExecutorService f2261i;

    /* renamed from: j  reason: collision with root package name */
    public final r f2262j;

    /* renamed from: k  reason: collision with root package name */
    public final f.b.a.a.a.i.f0.a f2263k;

    /* renamed from: l  reason: collision with root package name */
    public final p<c<q>> f2264l = new a();

    public class a implements p<c<q>> {
        public a() {
        }

        @Override // f.b.b.f.a.p
        public void a(Throwable th) {
            n.this.f2262j.l(d.EnumC0076d.RPC_TYPE_KEYS_DOWNLOAD, th);
            n.m.a(m.h.e0(th).toString());
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // f.b.b.f.a.p
        public void b(c<q> cVar) {
            f.b.b.b.a<q> t = cVar.listIterator();
            int i2 = 0;
            while (t.hasNext()) {
                i2 = (int) (t.next().a().length() + ((long) i2));
            }
            n.this.f2262j.j(d.EnumC0076d.RPC_TYPE_KEYS_DOWNLOAD, i2);
        }
    }

    static {
        a.e eVar = (a.e) f.b.b.c.a.b.e();
        Character ch = eVar.f3104e;
        f.b.b.c.a aVar = eVar;
        if (ch != null) {
            aVar = eVar.h(eVar.f3103d, null);
        }
        o = aVar;
    }

    public n(Context context, g gVar, f.b.a.a.a.y.d dVar, r rVar, o oVar, Map<String, List<o>> map, ExecutorService executorService, ExecutorService executorService2, ScheduledExecutorService scheduledExecutorService, r rVar2, f.b.a.a.a.i.f0.a aVar) {
        this.a = context;
        this.f2258f = gVar;
        this.b = dVar;
        this.c = rVar;
        this.f2256d = oVar;
        this.f2257e = map;
        this.f2259g = executorService;
        this.f2260h = executorService2;
        this.f2261i = scheduledExecutorService;
        this.f2262j = rVar2;
        this.f2263k = aVar;
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
