package e.v;

import android.content.Context;
import android.os.Build;
import e.x.a.b;
import e.x.a.c;
import f.a.a.a.a;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
/* loaded from: classes.dex */
public class k implements c {
    public final Context b;
    public final String c;

    /* renamed from: d  reason: collision with root package name */
    public final File f2089d;

    /* renamed from: e  reason: collision with root package name */
    public final int f2090e;

    /* renamed from: f  reason: collision with root package name */
    public final c f2091f;

    /* renamed from: g  reason: collision with root package name */
    public a f2092g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f2093h;

    @Override // e.x.a.c
    public synchronized b E() {
        if (!this.f2093h) {
            d();
            this.f2093h = true;
        }
        return this.f2091f.E();
    }

    /* JADX WARN: Finally extract failed */
    public final void c(File file) {
        ReadableByteChannel readableByteChannel;
        if (this.c != null) {
            readableByteChannel = Channels.newChannel(this.b.getAssets().open(this.c));
        } else if (this.f2089d != null) {
            readableByteChannel = new FileInputStream(this.f2089d).getChannel();
        } else {
            throw new IllegalStateException("copyFromAssetPath and copyFromFile == null!");
        }
        File createTempFile = File.createTempFile("room-copy-helper", ".tmp", this.b.getCacheDir());
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

    @Override // e.x.a.c, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        this.f2091f.close();
        this.f2093h = false;
    }

    public final void d() {
        String databaseName = this.f2091f.getDatabaseName();
        File databasePath = this.b.getDatabasePath(databaseName);
        e.v.p.a aVar = new e.v.p.a(databaseName, this.b.getFilesDir(), this.f2092g == null);
        try {
            aVar.b.lock();
            if (aVar.c) {
                try {
                    FileChannel channel = new FileOutputStream(aVar.a).getChannel();
                    aVar.f2096d = channel;
                    channel.lock();
                } catch (IOException e2) {
                    throw new IllegalStateException("Unable to grab copy lock.", e2);
                }
            }
            if (!databasePath.exists()) {
                try {
                    c(databasePath);
                } catch (IOException e3) {
                    throw new RuntimeException("Unable to copy database file.", e3);
                }
            } else if (this.f2092g != null) {
                try {
                    int c = e.v.p.b.c(databasePath);
                    int i2 = this.f2090e;
                    if (c != i2) {
                        if (!this.f2092g.a(c, i2)) {
                            if (this.b.deleteDatabase(databaseName)) {
                                try {
                                    c(databasePath);
                                } catch (IOException unused) {
                                }
                            }
                        }
                    }
                } catch (IOException unused2) {
                }
            }
        } finally {
            aVar.a();
        }
    }

    @Override // e.x.a.c
    public String getDatabaseName() {
        return this.f2091f.getDatabaseName();
    }

    @Override // e.x.a.c
    public void setWriteAheadLoggingEnabled(boolean z) {
        this.f2091f.setWriteAheadLoggingEnabled(z);
    }
}
