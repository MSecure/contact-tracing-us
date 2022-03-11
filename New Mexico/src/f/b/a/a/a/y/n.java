package f.b.a.a.a.y;

import android.content.Context;
import e.b.a.m;
import f.b.a.a.a.a0.r;
import f.b.a.a.a.d0.g;
import f.b.a.a.a.h0.d;
import f.b.a.a.a.k0.c;
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
/* loaded from: classes.dex */
public class n {
    public static final f.b.a.a.a.t.p0.a m = f.b.a.a.a.t.p0.a.e("DiagnosisKeyDownloader");
    public static final SecureRandom n = new SecureRandom();
    public static final f.b.b.c.a o;
    public static final d p;
    public final Context a;
    public final c b;
    public final r c;

    /* renamed from: d */
    public final o f2496d;

    /* renamed from: e */
    public final Map<String, List<o>> f2497e;

    /* renamed from: f */
    public final g f2498f;

    /* renamed from: g */
    public final ExecutorService f2499g;

    /* renamed from: h */
    public final ExecutorService f2500h;

    /* renamed from: i */
    public final ScheduledExecutorService f2501i;

    /* renamed from: j */
    public final r f2502j;

    /* renamed from: k */
    public final f.b.a.a.a.t.q0.a f2503k;

    /* renamed from: l */
    public final p<f.b.b.b.c<q>> f2504l = new a();

    /* loaded from: classes.dex */
    public class a implements p<f.b.b.b.c<q>> {
        public a() {
            n.this = r1;
        }

        @Override // f.b.b.f.a.p
        public void a(f.b.b.b.c<q> cVar) {
            f.b.b.b.a<q> t = cVar.listIterator();
            int i2 = 0;
            while (t.hasNext()) {
                i2 = (int) (t.next().a().length() + ((long) i2));
            }
            n.this.f2502j.j(d.EnumC0076d.RPC_TYPE_KEYS_DOWNLOAD, i2);
        }

        @Override // f.b.b.f.a.p
        public void b(Throwable th) {
            n.this.f2502j.l(d.EnumC0076d.RPC_TYPE_KEYS_DOWNLOAD, th);
            n.m.a(m.e.j0(th).toString());
        }
    }

    static {
        a.e eVar = (a.e) f.b.b.c.a.b.e();
        Character ch = eVar.f3422e;
        f.b.b.c.a aVar = eVar;
        if (ch != null) {
            aVar = eVar.h(eVar.f3421d, null);
        }
        o = aVar;
        p = l.b.a.d.l(30);
    }

    public n(Context context, g gVar, c cVar, r rVar, o oVar, Map<String, List<o>> map, ExecutorService executorService, ExecutorService executorService2, ScheduledExecutorService scheduledExecutorService, r rVar2, f.b.a.a.a.t.q0.a aVar) {
        this.a = context;
        this.f2498f = gVar;
        this.b = cVar;
        this.c = rVar;
        this.f2496d = oVar;
        this.f2497e = map;
        this.f2499g = executorService;
        this.f2500h = executorService2;
        this.f2501i = scheduledExecutorService;
        this.f2502j = rVar2;
        this.f2503k = aVar;
    }

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
        try {
            fileOutputStream.write(bArr, 0, length);
            fileOutputStream.close();
            return file;
        } finally {
            try {
                throw th;
            } catch (Throwable th) {
            }
        }
    }
}
