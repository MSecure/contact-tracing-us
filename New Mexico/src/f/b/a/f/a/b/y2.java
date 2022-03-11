package f.b.a.f.a.b;

import f.b.a.f.a.e.a;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.Objects;
import java.util.Properties;
/* loaded from: classes.dex */
public final class y2 {

    /* renamed from: h  reason: collision with root package name */
    public static final a f3343h = new a("SliceMetadataManager");
    public final d0 b;
    public final String c;

    /* renamed from: d  reason: collision with root package name */
    public final int f3344d;

    /* renamed from: e  reason: collision with root package name */
    public final long f3345e;

    /* renamed from: f  reason: collision with root package name */
    public final String f3346f;
    public final byte[] a = new byte[8192];

    /* renamed from: g  reason: collision with root package name */
    public int f3347g = -1;

    public y2(d0 d0Var, String str, int i2, long j2, String str2) {
        this.b = d0Var;
        this.c = str;
        this.f3344d = i2;
        this.f3345e = j2;
        this.f3346f = str2;
    }

    public final int a() {
        File q = this.b.q(this.c, this.f3344d, this.f3345e, this.f3346f);
        if (!q.exists()) {
            return 0;
        }
        FileInputStream fileInputStream = new FileInputStream(q);
        try {
            Properties properties = new Properties();
            properties.load(fileInputStream);
            fileInputStream.close();
            if (Integer.parseInt(properties.getProperty("fileStatus", "-1")) == 4) {
                return -1;
            }
            if (properties.getProperty("previousChunk") != null) {
                return Integer.parseInt(properties.getProperty("previousChunk")) + 1;
            }
            throw new z0("Slice checkpoint file corrupt.");
        } catch (Throwable th) {
            try {
                fileInputStream.close();
            } catch (Throwable unused) {
            }
            throw th;
        }
    }

    public final x2 b() {
        File q = this.b.q(this.c, this.f3344d, this.f3345e, this.f3346f);
        if (q.exists()) {
            Properties properties = new Properties();
            FileInputStream fileInputStream = new FileInputStream(q);
            try {
                properties.load(fileInputStream);
                fileInputStream.close();
                if (properties.getProperty("fileStatus") == null || properties.getProperty("previousChunk") == null) {
                    throw new z0("Slice checkpoint file corrupt.");
                }
                try {
                    int parseInt = Integer.parseInt(properties.getProperty("fileStatus"));
                    String property = properties.getProperty("fileName");
                    long parseLong = Long.parseLong(properties.getProperty("fileOffset", "-1"));
                    long parseLong2 = Long.parseLong(properties.getProperty("remainingBytes", "-1"));
                    int parseInt2 = Integer.parseInt(properties.getProperty("previousChunk"));
                    this.f3347g = Integer.parseInt(properties.getProperty("metadataFileCounter", "0"));
                    return new j0(parseInt, property, parseLong, parseLong2, parseInt2);
                } catch (NumberFormatException e2) {
                    throw new z0("Slice checkpoint file corrupt.", e2);
                }
            } catch (Throwable th) {
                try {
                    fileInputStream.close();
                } catch (Throwable unused) {
                }
                throw th;
            }
        } else {
            throw new z0("Slice checkpoint file does not exist.");
        }
    }

    public final File c() {
        return new File(l(), String.format("%s-NAM.dat", Integer.valueOf(this.f3347g)));
    }

    public final void d(long j2, byte[] bArr, int i2, int i3) {
        RandomAccessFile randomAccessFile = new RandomAccessFile(c(), "rw");
        try {
            randomAccessFile.seek(j2);
            randomAccessFile.write(bArr, i2, i3);
            randomAccessFile.close();
        } catch (Throwable th) {
            try {
                randomAccessFile.close();
            } catch (Throwable unused) {
            }
            throw th;
        }
    }

    public final void e(int i2) {
        Properties properties = new Properties();
        properties.put("fileStatus", "3");
        properties.put("fileOffset", String.valueOf(c().length()));
        properties.put("previousChunk", String.valueOf(i2));
        properties.put("metadataFileCounter", String.valueOf(this.f3347g));
        FileOutputStream fileOutputStream = new FileOutputStream(m());
        try {
            properties.store(fileOutputStream, (String) null);
            fileOutputStream.close();
        } catch (Throwable th) {
            try {
                fileOutputStream.close();
            } catch (Throwable unused) {
            }
            throw th;
        }
    }

    public final void f(String str, long j2, long j3, int i2) {
        Properties properties = new Properties();
        properties.put("fileStatus", "1");
        properties.put("fileName", str);
        properties.put("fileOffset", String.valueOf(j2));
        properties.put("remainingBytes", String.valueOf(j3));
        properties.put("previousChunk", String.valueOf(i2));
        properties.put("metadataFileCounter", String.valueOf(this.f3347g));
        FileOutputStream fileOutputStream = new FileOutputStream(m());
        try {
            properties.store(fileOutputStream, (String) null);
            fileOutputStream.close();
        } catch (Throwable th) {
            try {
                fileOutputStream.close();
            } catch (Throwable unused) {
            }
            throw th;
        }
    }

    public final void g(byte[] bArr, int i2) {
        Properties properties = new Properties();
        properties.put("fileStatus", "2");
        properties.put("previousChunk", String.valueOf(i2));
        properties.put("metadataFileCounter", String.valueOf(this.f3347g));
        FileOutputStream fileOutputStream = new FileOutputStream(m());
        try {
            properties.store(fileOutputStream, (String) null);
            fileOutputStream.close();
            d0 d0Var = this.b;
            String str = this.c;
            int i3 = this.f3344d;
            long j2 = this.f3345e;
            String str2 = this.f3346f;
            Objects.requireNonNull(d0Var);
            File file = new File(d0Var.r(str, i3, j2, str2), "checkpoint_ext.dat");
            if (file.exists()) {
                file.delete();
            }
            fileOutputStream = new FileOutputStream(file);
            try {
                fileOutputStream.write(bArr);
            } finally {
                try {
                    fileOutputStream.close();
                } catch (Throwable unused) {
                }
            }
        } finally {
        }
    }

    public final void h(int i2) {
        Properties properties = new Properties();
        properties.put("fileStatus", "4");
        properties.put("previousChunk", String.valueOf(i2));
        properties.put("metadataFileCounter", String.valueOf(this.f3347g));
        FileOutputStream fileOutputStream = new FileOutputStream(m());
        try {
            properties.store(fileOutputStream, (String) null);
            fileOutputStream.close();
        } catch (Throwable th) {
            try {
                fileOutputStream.close();
            } catch (Throwable unused) {
            }
            throw th;
        }
    }

    public final void i(byte[] bArr) {
        this.f3347g++;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(l(), String.format("%s-LFH.dat", Integer.valueOf(this.f3347g))));
            fileOutputStream.write(bArr);
            fileOutputStream.close();
        } catch (IOException e2) {
            throw new z0("Could not write metadata file.", e2);
        }
    }

    public final void j(byte[] bArr, InputStream inputStream) {
        this.f3347g++;
        FileOutputStream fileOutputStream = new FileOutputStream(c());
        try {
            fileOutputStream.write(bArr);
            int read = inputStream.read(this.a);
            while (read > 0) {
                fileOutputStream.write(this.a, 0, read);
                read = inputStream.read(this.a);
            }
            fileOutputStream.close();
        } catch (Throwable th) {
            try {
                fileOutputStream.close();
            } catch (Throwable unused) {
            }
            throw th;
        }
    }

    public final void k(byte[] bArr, int i2, int i3) {
        this.f3347g++;
        FileOutputStream fileOutputStream = new FileOutputStream(c());
        try {
            fileOutputStream.write(bArr, 0, i3);
            fileOutputStream.close();
        } catch (Throwable th) {
            try {
                fileOutputStream.close();
            } catch (Throwable unused) {
            }
            throw th;
        }
    }

    public final File l() {
        File r = this.b.r(this.c, this.f3344d, this.f3345e, this.f3346f);
        if (!r.exists()) {
            r.mkdirs();
        }
        return r;
    }

    public final File m() {
        File q = this.b.q(this.c, this.f3344d, this.f3345e, this.f3346f);
        q.getParentFile().mkdirs();
        q.createNewFile();
        return q;
    }
}
