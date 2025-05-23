package b.p;

import android.content.Context;
import android.content.SharedPreferences;
import b.b.k.i;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.CRC32;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

public final class d implements Closeable {

    /* renamed from: b  reason: collision with root package name */
    public final File f1437b;

    /* renamed from: c  reason: collision with root package name */
    public final long f1438c;

    /* renamed from: d  reason: collision with root package name */
    public final File f1439d;

    /* renamed from: e  reason: collision with root package name */
    public final RandomAccessFile f1440e;
    public final FileChannel f;
    public final FileLock g;

    public static class a extends File {

        /* renamed from: b  reason: collision with root package name */
        public long f1441b = -1;

        public a(File file, String str) {
            super(file, str);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0043, code lost:
        r3 = e;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0043 A[ExcHandler: Error | RuntimeException (e java.lang.Throwable), Splitter:B:1:0x0023] */
    public d(File file, File file2) {
        file.getPath();
        file2.getPath();
        this.f1437b = file;
        this.f1439d = file2;
        this.f1438c = d(file);
        File file3 = new File(file2, "MultiDex.lock");
        RandomAccessFile randomAccessFile = new RandomAccessFile(file3, "rw");
        this.f1440e = randomAccessFile;
        try {
            this.f = randomAccessFile.getChannel();
            try {
                file3.getPath();
                this.g = this.f.lock();
                file3.getPath();
            } catch (IOException | Error | RuntimeException e2) {
                this.f.close();
                throw e2;
            }
        } catch (IOException e3) {
            Throwable e4 = e3;
            try {
                this.f1440e.close();
            } catch (IOException unused) {
            }
            throw e4;
        } catch (Error | RuntimeException e5) {
        }
    }

    /* JADX INFO: finally extract failed */
    public static void a(ZipFile zipFile, ZipEntry zipEntry, File file, String str) {
        InputStream inputStream = zipFile.getInputStream(zipEntry);
        File createTempFile = File.createTempFile(c.a.a.a.a.o("tmp-", str), ".zip", file.getParentFile());
        createTempFile.getPath();
        try {
            ZipOutputStream zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(createTempFile)));
            try {
                ZipEntry zipEntry2 = new ZipEntry("classes.dex");
                zipEntry2.setTime(zipEntry.getTime());
                zipOutputStream.putNextEntry(zipEntry2);
                byte[] bArr = new byte[16384];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    zipOutputStream.write(bArr, 0, read);
                }
                zipOutputStream.closeEntry();
                zipOutputStream.close();
                if (createTempFile.setReadOnly()) {
                    file.getPath();
                    if (!createTempFile.renameTo(file)) {
                        throw new IOException("Failed to rename \"" + createTempFile.getAbsolutePath() + "\" to \"" + file.getAbsolutePath() + "\"");
                    }
                    return;
                }
                throw new IOException("Failed to mark readonly \"" + createTempFile.getAbsolutePath() + "\" (tmp of \"" + file.getAbsolutePath() + "\")");
            } catch (Throwable th) {
                zipOutputStream.close();
                throw th;
            }
        } finally {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
            createTempFile.delete();
        }
    }

    public static long b(File file) {
        long lastModified = file.lastModified();
        return lastModified == -1 ? lastModified - 1 : lastModified;
    }

    /* JADX INFO: finally extract failed */
    public static long d(File file) {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        try {
            e Y = i.j.Y(randomAccessFile);
            CRC32 crc32 = new CRC32();
            long j = Y.f1443b;
            randomAccessFile.seek(Y.f1442a);
            int min = (int) Math.min(16384L, j);
            byte[] bArr = new byte[16384];
            while (true) {
                int read = randomAccessFile.read(bArr, 0, min);
                if (read == -1) {
                    break;
                }
                crc32.update(bArr, 0, read);
                j -= (long) read;
                if (j == 0) {
                    break;
                }
                min = (int) Math.min(16384L, j);
            }
            long value = crc32.getValue();
            randomAccessFile.close();
            return value == -1 ? value - 1 : value;
        } catch (Throwable th) {
            randomAccessFile.close();
            throw th;
        }
    }

    public static void h(Context context, String str, long j, long j2, List<a> list) {
        SharedPreferences.Editor edit = context.getSharedPreferences("multidex.version", 4).edit();
        edit.putLong(str + "timestamp", j);
        edit.putLong(str + "crc", j2);
        edit.putInt(str + "dex.number", list.size() + 1);
        int i = 2;
        for (a aVar : list) {
            edit.putLong(str + "dex.crc." + i, aVar.f1441b);
            edit.putLong(str + "dex.time." + i, aVar.lastModified());
            i++;
        }
        edit.commit();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.g.release();
        this.f.close();
        this.f1440e.close();
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x005c A[SYNTHETIC, Splitter:B:10:0x005c] */
    public List<? extends File> e(Context context, String str, boolean z) {
        List<a> list;
        boolean z2;
        this.f1437b.getPath();
        if (this.g.isValid()) {
            if (!z) {
                File file = this.f1437b;
                long j = this.f1438c;
                SharedPreferences sharedPreferences = context.getSharedPreferences("multidex.version", 4);
                if (sharedPreferences.getLong(str + "timestamp", -1) == b(file)) {
                    if (sharedPreferences.getLong(str + "crc", -1) == j) {
                        z2 = false;
                        if (!z2) {
                            try {
                                list = f(context, str);
                            } catch (IOException unused) {
                            }
                            list.size();
                            return list;
                        }
                    }
                }
                z2 = true;
                if (!z2) {
                }
            }
            List<a> g2 = g();
            h(context, str, b(this.f1437b), this.f1438c, g2);
            list = g2;
            list.size();
            return list;
        }
        throw new IllegalStateException("MultiDexExtractor was closed");
    }

    public final List<a> f(Context context, String str) {
        String str2 = this.f1437b.getName() + ".classes";
        SharedPreferences sharedPreferences = context.getSharedPreferences("multidex.version", 4);
        int i = sharedPreferences.getInt(str + "dex.number", 1);
        ArrayList arrayList = new ArrayList(i + -1);
        int i2 = 2;
        while (i2 <= i) {
            a aVar = new a(this.f1439d, c.a.a.a.a.m(str2, i2, ".zip"));
            if (aVar.isFile()) {
                aVar.f1441b = d(aVar);
                long j = sharedPreferences.getLong(str + "dex.crc." + i2, -1);
                long j2 = sharedPreferences.getLong(str + "dex.time." + i2, -1);
                long lastModified = aVar.lastModified();
                if (j2 == lastModified && j == aVar.f1441b) {
                    arrayList.add(aVar);
                    i2++;
                    sharedPreferences = sharedPreferences;
                    str2 = str2;
                } else {
                    throw new IOException("Invalid extracted dex: " + aVar + " (key \"" + str + "\"), expected modification time: " + j2 + ", modification time: " + lastModified + ", expected crc: " + j + ", file crc: " + aVar.f1441b);
                }
            } else {
                StringBuilder g2 = c.a.a.a.a.g("Missing extracted secondary dex file '");
                g2.append(aVar.getPath());
                g2.append("'");
                throw new IOException(g2.toString());
            }
        }
        return arrayList;
    }

    public final List<a> g() {
        String str = this.f1437b.getName() + ".classes";
        File[] listFiles = this.f1439d.listFiles(new c(this));
        if (listFiles == null) {
            this.f1439d.getPath();
        } else {
            for (File file : listFiles) {
                file.getPath();
                file.length();
                file.delete();
                file.getPath();
            }
        }
        ArrayList arrayList = new ArrayList();
        ZipFile zipFile = new ZipFile(this.f1437b);
        int i = 2;
        String str2 = "classes2.dex";
        while (true) {
            try {
                ZipEntry entry = zipFile.getEntry(str2);
                if (entry == null) {
                    return arrayList;
                }
                a aVar = new a(this.f1439d, str + i + ".zip");
                arrayList.add(aVar);
                String str3 = "Extraction is needed for file " + aVar;
                int i2 = 0;
                boolean z = false;
                while (i2 < 3 && !z) {
                    i2++;
                    a(zipFile, entry, aVar, str);
                    try {
                        aVar.f1441b = d(aVar);
                        z = true;
                    } catch (IOException unused) {
                        aVar.getAbsolutePath();
                        z = false;
                    }
                    aVar.getAbsolutePath();
                    aVar.length();
                    if (!z) {
                        aVar.delete();
                        if (aVar.exists()) {
                            aVar.getPath();
                        }
                    }
                }
                if (z) {
                    i++;
                    str2 = "classes" + i + ".dex";
                } else {
                    throw new IOException("Could not create zip file " + aVar.getAbsolutePath() + " for secondary dex (" + i + ")");
                }
            } finally {
                try {
                    zipFile.close();
                } catch (IOException unused2) {
                }
            }
        }
    }
}
