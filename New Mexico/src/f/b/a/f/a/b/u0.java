package f.b.a.f.a.b;

import com.google.android.play.core.assetpacks.AssetPackState;
import f.b.a.f.a.e.a;
import f.b.a.f.a.e.r;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.io.SequenceInputStream;
import java.util.Objects;
import java.util.zip.GZIPInputStream;
/* loaded from: classes.dex */
public final class u0 {

    /* renamed from: g */
    public static final a f3317g = new a("ExtractChunkTaskHandler");
    public final byte[] a = new byte[8192];
    public final d0 b;
    public final r<v3> c;

    /* renamed from: d */
    public final r<y> f3318d;

    /* renamed from: e */
    public final d1 f3319e;

    /* renamed from: f */
    public final m2 f3320f;

    public u0(d0 d0Var, r<v3> rVar, r<y> rVar2, d1 d1Var, m2 m2Var) {
        this.b = d0Var;
        this.c = rVar;
        this.f3318d = rVar2;
        this.f3319e = d1Var;
        this.f3320f = m2Var;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:134|(2:13|(12:15|(1:(1:(6:19|20|(2:21|(2:23|140)(1:141))|139|25|(1:27)(2:28|29))(2:30|31))(2:32|(10:34|(7:60|(4:61|(2:65|(1:73)(4:69|(1:71)|146|72))|74|(1:76)(1:144))|145|78|(1:80)|81|(2:83|(1:85)(2:86|(1:88)(3:89|(2:91|(1:93)(2:94|95))(1:96)|97))))|99|100|(2:135|102)|106|130|107|109|(4:111|353|115|116)(1:119))(2:35|36)))(2:37|(4:39|(4:40|(1:42)|43|(1:47)(1:142))|48|(3:50|51|52))(2:54|55))|53|(0)|99|100|(0)|106|130|107|109|(0)(0))(2:56|57))|58|(0)|99|100|(0)|106|130|107|109|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x0324, code lost:
        f.b.a.f.a.b.u0.f3317g.e("Could not close file for chunk %s of slice %s of pack %s.", java.lang.Integer.valueOf(r23.f3309h), r23.f3307f, r23.b);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0343  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0389 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:135:0x02c8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01b6 A[Catch: all -> 0x02bc, TryCatch #5 {all -> 0x02bc, blocks: (B:52:0x0180, B:54:0x0186, B:55:0x0190, B:56:0x0191, B:57:0x01b1, B:60:0x01b6, B:61:0x01bf, B:63:0x01ca, B:65:0x01ce, B:67:0x01d4, B:69:0x01da, B:71:0x0200, B:72:0x020c, B:73:0x0210, B:74:0x0218, B:76:0x021c, B:78:0x0220, B:80:0x0224, B:81:0x0235, B:83:0x023b, B:85:0x0242, B:86:0x0255, B:88:0x0259, B:89:0x0268, B:91:0x026f, B:94:0x0296, B:95:0x029d, B:96:0x029e, B:97:0x02af), top: B:134:0x0043 }] */
    /* JADX WARN: Type inference failed for: r10v0, types: [f.b.a.f.a.b.d0] */
    /* JADX WARN: Type inference failed for: r13v0, types: [long] */
    /* JADX WARN: Type inference failed for: r13v1, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r13v2 */
    /* JADX WARN: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump */
    public final void a(t0 t0Var) {
        Throwable th;
        InputStream inputStream;
        InputStream inputStream2;
        double d2;
        e3 c;
        long j2;
        File file;
        int min;
        int max;
        long j3;
        int read;
        ?? r10 = this.b;
        String str = t0Var.b;
        int i2 = t0Var.c;
        ?? r13 = t0Var.f3305d;
        String str2 = t0Var.f3307f;
        y2 y2Var = new y2(r10, str, i2, r13, str2);
        File r = r10.r(str, i2, r13, str2);
        if (!r.exists()) {
            r.mkdirs();
        }
        try {
            InputStream inputStream3 = t0Var.f3313l;
            InputStream gZIPInputStream = t0Var.f3308g != 1 ? inputStream3 : new GZIPInputStream(inputStream3, 8192);
            try {
            } catch (Throwable th2) {
                th = th2;
                r13 = gZIPInputStream;
            }
            try {
                if (t0Var.f3309h > 0) {
                    x2 b = y2Var.b();
                    int i3 = ((j0) b).f3246e;
                    int i4 = t0Var.f3309h;
                    if (i3 == i4 - 1) {
                        int i5 = ((j0) b).a;
                        if (i5 == 1) {
                            f3317g.a("Resuming zip entry from last chunk during file %s.", ((j0) b).b);
                            File file2 = new File(((j0) b).b);
                            if (file2.exists()) {
                                RandomAccessFile randomAccessFile = new RandomAccessFile(file2, "rw");
                                randomAccessFile.seek(((j0) b).c);
                                long j4 = ((j0) b).f3245d;
                                while (true) {
                                    min = (int) Math.min(j4, 8192L);
                                    max = Math.max(gZIPInputStream.read(this.a, 0, min), 0);
                                    if (max > 0) {
                                        randomAccessFile.write(this.a, 0, max);
                                    }
                                    j3 = j4 - ((long) max);
                                    if (j3 <= 0 || max <= 0) {
                                        break;
                                    }
                                    j4 = j3;
                                }
                                long length = randomAccessFile.length();
                                randomAccessFile.close();
                                if (max != min) {
                                    f3317g.a("Chunk has ended while resuming the previous chunks file content.", new Object[0]);
                                    inputStream = gZIPInputStream;
                                    y2Var.f(file2.getCanonicalPath(), length, j3, t0Var.f3309h);
                                }
                            } else {
                                throw new z0("Partial file specified in checkpoint does not exist. Corrupt directory.", t0Var.a);
                            }
                        } else if (i5 == 2) {
                            f3317g.a("Resuming zip entry from last chunk during local file header.", new Object[0]);
                            d0 d0Var = this.b;
                            String str3 = t0Var.b;
                            int i6 = t0Var.c;
                            long j5 = t0Var.f3305d;
                            String str4 = t0Var.f3307f;
                            Objects.requireNonNull(d0Var);
                            File file3 = new File(d0Var.r(str3, i6, j5, str4), "checkpoint_ext.dat");
                            if (file3.exists()) {
                                inputStream2 = new SequenceInputStream(new FileInputStream(file3), gZIPInputStream);
                                inputStream = gZIPInputStream;
                                if (inputStream2 != null) {
                                    n0 n0Var = new n0(inputStream2);
                                    File b2 = b(t0Var);
                                    do {
                                        c = n0Var.c();
                                        if (!((k0) c).f3254d && !n0Var.f3269f) {
                                            if (!c.h() || c.g()) {
                                                y2Var.j(((k0) c).f3256f, n0Var);
                                            } else {
                                                y2Var.i(((k0) c).f3256f);
                                                File file4 = new File(b2, ((k0) c).a);
                                                file4.getParentFile().mkdirs();
                                                FileOutputStream fileOutputStream = new FileOutputStream(file4);
                                                int read2 = n0Var.read(this.a, 0, 8192);
                                                while (read2 > 0) {
                                                    fileOutputStream.write(this.a, 0, read2);
                                                    read2 = n0Var.read(this.a, 0, 8192);
                                                }
                                                fileOutputStream.close();
                                            }
                                        }
                                        if (n0Var.f3268e) {
                                            break;
                                        }
                                    } while (!n0Var.f3269f);
                                    if (n0Var.f3269f) {
                                        f3317g.a("Writing central directory metadata.", new Object[0]);
                                        y2Var.j(((k0) c).f3256f, inputStream2);
                                    }
                                    if (!t0Var.a()) {
                                        if (((k0) c).f3254d) {
                                            f3317g.a("Writing slice checkpoint for partial local file header.", new Object[0]);
                                            y2Var.g(((k0) c).f3256f, t0Var.f3309h);
                                        } else if (n0Var.f3269f) {
                                            f3317g.a("Writing slice checkpoint for central directory.", new Object[0]);
                                            y2Var.e(t0Var.f3309h);
                                        } else {
                                            if (((k0) c).c == 0) {
                                                f3317g.a("Writing slice checkpoint for partial file.", new Object[0]);
                                                file = new File(b(t0Var), ((k0) c).a);
                                                j2 = ((k0) c).b - n0Var.f3267d;
                                                if (file.length() != j2) {
                                                    throw new z0("Partial file is of unexpected size.");
                                                }
                                            } else {
                                                f3317g.a("Writing slice checkpoint for partial unextractable file.", new Object[0]);
                                                file = y2Var.c();
                                                j2 = file.length();
                                            }
                                            y2Var.f(file.getCanonicalPath(), j2, n0Var.f3267d, t0Var.f3309h);
                                        }
                                    }
                                }
                                inputStream.close();
                                if (t0Var.a()) {
                                    try {
                                        y2Var.h(t0Var.f3309h);
                                    } catch (IOException e2) {
                                        f3317g.b("Writing extraction finished checkpoint failed with %s.", e2.getMessage());
                                        throw new z0("Writing extraction finished checkpoint failed.", e2, t0Var.a);
                                    }
                                }
                                f3317g.d("Extraction finished for chunk %s of slice %s of pack %s of session %s.", Integer.valueOf(t0Var.f3309h), t0Var.f3307f, t0Var.b, Integer.valueOf(t0Var.a));
                                this.c.a().a(t0Var.a, t0Var.b, t0Var.f3307f, t0Var.f3309h);
                                t0Var.f3313l.close();
                                if (t0Var.f3312k == 3) {
                                    y a = this.f3318d.a();
                                    String str5 = t0Var.b;
                                    long j6 = t0Var.f3311j;
                                    d1 d1Var = this.f3319e;
                                    synchronized (d1Var) {
                                        d2 = (((double) t0Var.f3309h) + 1.0d) / ((double) t0Var.f3310i);
                                        d1Var.a.put(str5, Double.valueOf(d2));
                                    }
                                    a.o.post(new x(a, AssetPackState.h(str5, 3, 0, j6, j6, d2, 1, t0Var.f3306e, this.f3320f.a(t0Var.b))));
                                    return;
                                }
                                return;
                            }
                            throw new z0("Checkpoint extension file not found.", t0Var.a);
                        } else if (i5 == 3) {
                            f3317g.a("Resuming central directory from last chunk.", new Object[0]);
                            long j7 = ((j0) b).c;
                            RandomAccessFile randomAccessFile2 = new RandomAccessFile(y2Var.c(), "rw");
                            randomAccessFile2.seek(j7);
                            do {
                                read = gZIPInputStream.read(y2Var.a);
                                if (read > 0) {
                                    randomAccessFile2.write(y2Var.a, 0, read);
                                    continue;
                                }
                            } while (read == 8192);
                            randomAccessFile2.close();
                            if (t0Var.a()) {
                                inputStream = gZIPInputStream;
                            } else {
                                throw new z0("Chunk has ended twice during central directory. This should not be possible with chunk sizes of 50MB.", t0Var.a);
                            }
                        } else {
                            throw new z0(String.format("Slice checkpoint file corrupt. Unexpected FileExtractionStatus %s.", Integer.valueOf(((j0) b).a)), t0Var.a);
                        }
                        inputStream2 = null;
                        if (inputStream2 != null) {
                        }
                        inputStream.close();
                        if (t0Var.a()) {
                        }
                        f3317g.d("Extraction finished for chunk %s of slice %s of pack %s of session %s.", Integer.valueOf(t0Var.f3309h), t0Var.f3307f, t0Var.b, Integer.valueOf(t0Var.a));
                        this.c.a().a(t0Var.a, t0Var.b, t0Var.f3307f, t0Var.f3309h);
                        t0Var.f3313l.close();
                        if (t0Var.f3312k == 3) {
                        }
                    } else {
                        throw new z0(String.format("Trying to resume with chunk number %s when previously processed chunk was number %s.", Integer.valueOf(i4), Integer.valueOf(((j0) b).f3246e)), t0Var.a);
                    }
                }
                inputStream = gZIPInputStream;
                inputStream2 = inputStream;
                if (inputStream2 != null) {
                }
                inputStream.close();
                if (t0Var.a()) {
                }
                f3317g.d("Extraction finished for chunk %s of slice %s of pack %s of session %s.", Integer.valueOf(t0Var.f3309h), t0Var.f3307f, t0Var.b, Integer.valueOf(t0Var.a));
                this.c.a().a(t0Var.a, t0Var.b, t0Var.f3307f, t0Var.f3309h);
                t0Var.f3313l.close();
                if (t0Var.f3312k == 3) {
                }
            } catch (Throwable th3) {
                th = th3;
                try {
                    r13.close();
                } catch (Throwable unused) {
                }
                throw th;
            }
        } catch (IOException e3) {
            f3317g.b("IOException during extraction %s.", e3.getMessage());
            throw new z0(String.format("Error extracting chunk %s of slice %s of pack %s of session %s.", Integer.valueOf(t0Var.f3309h), t0Var.f3307f, t0Var.b, Integer.valueOf(t0Var.a)), e3, t0Var.a);
        }
    }

    public final File b(t0 t0Var) {
        File s = this.b.s(t0Var.b, t0Var.c, t0Var.f3305d, t0Var.f3307f);
        if (!s.exists()) {
            s.mkdirs();
        }
        return s;
    }
}
