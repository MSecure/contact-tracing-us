package b.s;

import android.content.Context;
import android.os.Build;
import b.s.q.b;
import b.w.a.c;
import c.a.a.a.a;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;

public class l implements c {

    /* renamed from: b  reason: collision with root package name */
    public final Context f2532b;

    /* renamed from: c  reason: collision with root package name */
    public final String f2533c;

    /* renamed from: d  reason: collision with root package name */
    public final File f2534d;

    /* renamed from: e  reason: collision with root package name */
    public final int f2535e;

    /* renamed from: f  reason: collision with root package name */
    public final c f2536f;

    /* renamed from: g  reason: collision with root package name */
    public a f2537g;
    public boolean h;

    /* JADX INFO: finally extract failed */
    public final void a(File file) {
        ReadableByteChannel readableByteChannel;
        if (this.f2533c != null) {
            readableByteChannel = Channels.newChannel(this.f2532b.getAssets().open(this.f2533c));
        } else if (this.f2534d != null) {
            readableByteChannel = new FileInputStream(this.f2534d).getChannel();
        } else {
            throw new IllegalStateException("copyFromAssetPath and copyFromFile == null!");
        }
        File createTempFile = File.createTempFile("room-copy-helper", ".tmp", this.f2532b.getCacheDir());
        createTempFile.deleteOnExit();
        FileChannel channel = new FileOutputStream(createTempFile).getChannel();
        try {
            if (Build.VERSION.SDK_INT <= 23) {
                InputStream newInputStream = Channels.newInputStream(readableByteChannel);
                OutputStream newOutputStream = Channels.newOutputStream(channel);
                byte[] bArr = new byte[4096];
                while (true) {
                    int read = newInputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    newOutputStream.write(bArr, 0, read);
                }
            } else {
                channel.transferFrom(readableByteChannel, 0, Long.MAX_VALUE);
            }
            channel.force(false);
            readableByteChannel.close();
            channel.close();
            File parentFile = file.getParentFile();
            if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
                StringBuilder h2 = a.h("Failed to create directories for ");
                h2.append(file.getAbsolutePath());
                throw new IOException(h2.toString());
            } else if (!createTempFile.renameTo(file)) {
                StringBuilder h3 = a.h("Failed to move intermediate file (");
                h3.append(createTempFile.getAbsolutePath());
                h3.append(") to destination (");
                h3.append(file.getAbsolutePath());
                h3.append(").");
                throw new IOException(h3.toString());
            }
        } catch (Throwable th) {
            readableByteChannel.close();
            channel.close();
            throw th;
        }
    }

    public final void b() {
        String databaseName = this.f2536f.getDatabaseName();
        File databasePath = this.f2532b.getDatabasePath(databaseName);
        a aVar = this.f2537g;
        b.s.q.a aVar2 = new b.s.q.a(databaseName, this.f2532b.getFilesDir(), aVar == null || aVar.j);
        try {
            aVar2.f2553b.lock();
            if (aVar2.f2554c) {
                try {
                    FileChannel channel = new FileOutputStream(aVar2.f2552a).getChannel();
                    aVar2.f2555d = channel;
                    channel.lock();
                } catch (IOException e2) {
                    throw new IllegalStateException("Unable to grab copy lock.", e2);
                }
            }
            if (!databasePath.exists()) {
                try {
                    a(databasePath);
                } catch (IOException e3) {
                    throw new RuntimeException("Unable to copy database file.", e3);
                }
            } else if (this.f2537g == null) {
                aVar2.a();
            } else {
                try {
                    int c2 = b.c(databasePath);
                    if (c2 == this.f2535e) {
                        aVar2.a();
                    } else if (this.f2537g.a(c2, this.f2535e)) {
                        aVar2.a();
                    } else {
                        if (this.f2532b.deleteDatabase(databaseName)) {
                            try {
                                a(databasePath);
                            } catch (IOException unused) {
                            }
                        }
                        aVar2.a();
                    }
                } catch (IOException unused2) {
                    aVar2.a();
                }
            }
        } finally {
            aVar2.a();
        }
    }

    @Override // b.w.a.c, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        this.f2536f.close();
        this.h = false;
    }

    @Override // b.w.a.c
    public String getDatabaseName() {
        return this.f2536f.getDatabaseName();
    }

    @Override // b.w.a.c
    public synchronized b.w.a.b p() {
        if (!this.h) {
            b();
            this.h = true;
        }
        return this.f2536f.p();
    }

    @Override // b.w.a.c
    public void setWriteAheadLoggingEnabled(boolean z) {
        this.f2536f.setWriteAheadLoggingEnabled(z);
    }
}
