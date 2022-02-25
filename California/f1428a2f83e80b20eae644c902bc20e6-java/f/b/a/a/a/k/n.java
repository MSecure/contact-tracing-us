package f.b.a.a.a.k;

import android.content.Context;
import e.b.a.m;
import f.b.a.a.a.m.p;
import f.b.a.a.a.o.g;
import f.b.a.a.a.s.i;
import f.b.a.a.a.u.d;
import f.b.b.c.a;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import l.b.a.c;

public class n {
    public static final SecureRandom m = new SecureRandom();
    public static final f.b.b.c.a n;
    public static final c o = c.h(30);
    public final Context a;
    public final d b;
    public final r c;

    /* renamed from: d  reason: collision with root package name */
    public final o f2082d;

    /* renamed from: e  reason: collision with root package name */
    public final Map<String, List<o>> f2083e;

    /* renamed from: f  reason: collision with root package name */
    public final g f2084f;

    /* renamed from: g  reason: collision with root package name */
    public final ExecutorService f2085g;

    /* renamed from: h  reason: collision with root package name */
    public final ExecutorService f2086h;

    /* renamed from: i  reason: collision with root package name */
    public final ScheduledExecutorService f2087i;

    /* renamed from: j  reason: collision with root package name */
    public final p f2088j;

    /* renamed from: k  reason: collision with root package name */
    public final f.b.a.a.a.h.s.a f2089k;

    /* renamed from: l  reason: collision with root package name */
    public f.b.b.f.a.p<f.b.b.b.c<q>> f2090l = new a();

    public class a implements f.b.b.f.a.p<f.b.b.b.c<q>> {
        public a() {
        }

        @Override // f.b.b.f.a.p
        public void a(Throwable th) {
            n.this.f2088j.l(i.d.RPC_TYPE_KEYS_DOWNLOAD, th);
            m.h.c0(th).toString();
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // f.b.b.f.a.p
        public void b(f.b.b.b.c<q> cVar) {
            f.b.b.b.a<q> t = cVar.listIterator();
            int i2 = 0;
            while (t.hasNext()) {
                i2 = (int) (t.next().a().length() + ((long) i2));
            }
            n.this.f2088j.j(i.d.RPC_TYPE_KEYS_DOWNLOAD, i2);
        }
    }

    static {
        a.e eVar = (a.e) f.b.b.c.a.b.e();
        Character ch = eVar.f2906e;
        f.b.b.c.a aVar = eVar;
        if (ch != null) {
            aVar = eVar.h(eVar.f2905d, null);
        }
        n = aVar;
    }

    public n(Context context, g gVar, d dVar, r rVar, o oVar, Map<String, List<o>> map, ExecutorService executorService, ExecutorService executorService2, ScheduledExecutorService scheduledExecutorService, p pVar, f.b.a.a.a.h.s.a aVar) {
        this.a = context;
        this.f2084f = gVar;
        this.b = dVar;
        this.c = rVar;
        this.f2082d = oVar;
        this.f2083e = map;
        this.f2085g = executorService;
        this.f2086h = executorService2;
        this.f2087i = scheduledExecutorService;
        this.f2088j = pVar;
        this.f2089k = aVar;
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
