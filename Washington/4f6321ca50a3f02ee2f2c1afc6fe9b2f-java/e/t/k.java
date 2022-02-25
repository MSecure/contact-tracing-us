package e.t;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import e.v.a.b;
import e.v.a.c;
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

public class k implements c {
    public final Context b;
    public final String c;

    /* renamed from: d  reason: collision with root package name */
    public final File f1880d;

    /* renamed from: e  reason: collision with root package name */
    public final int f1881e;

    /* renamed from: f  reason: collision with root package name */
    public final c f1882f;

    /* renamed from: g  reason: collision with root package name */
    public a f1883g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f1884h;

    @Override // e.v.a.c
    public synchronized b I() {
        if (!this.f1884h) {
            d();
            this.f1884h = true;
        }
        return this.f1882f.I();
    }

    /* JADX INFO: finally extract failed */
    public final void c(File file) {
        ReadableByteChannel readableByteChannel;
        if (this.c != null) {
            readableByteChannel = Channels.newChannel(this.b.getAssets().open(this.c));
        } else if (this.f1880d != null) {
            readableByteChannel = new FileInputStream(this.f1880d).getChannel();
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

    @Override // java.io.Closeable, e.v.a.c, java.lang.AutoCloseable
    public synchronized void close() {
        this.f1882f.close();
        this.f1884h = false;
    }

    public final void d() {
        String databaseName = this.f1882f.getDatabaseName();
        File databasePath = this.b.getDatabasePath(databaseName);
        e.t.p.a aVar = new e.t.p.a(databaseName, this.b.getFilesDir(), this.f1883g == null);
        try {
            aVar.b.lock();
            if (aVar.c) {
                try {
                    FileChannel channel = new FileOutputStream(aVar.a).getChannel();
                    aVar.f1887d = channel;
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
            } else if (this.f1883g == null) {
                aVar.a();
            } else {
                try {
                    int c2 = e.t.p.b.c(databasePath);
                    int i2 = this.f1881e;
                    if (c2 == i2) {
                        aVar.a();
                    } else if (this.f1883g.a(c2, i2)) {
                        aVar.a();
                    } else {
                        if (this.b.deleteDatabase(databaseName)) {
                            try {
                                c(databasePath);
                            } catch (IOException e4) {
                                Log.w("ROOM", "Unable to copy database file.", e4);
                            }
                        } else {
                            Log.w("ROOM", "Failed to delete database file (" + databaseName + ") for a copy destructive migration.");
                        }
                        aVar.a();
                    }
                } catch (IOException e5) {
                    Log.w("ROOM", "Unable to read database version.", e5);
                    aVar.a();
                }
            }
        } finally {
            aVar.a();
        }
    }

    @Override // e.v.a.c
    public String getDatabaseName() {
        return this.f1882f.getDatabaseName();
    }

    @Override // e.v.a.c
    public void setWriteAheadLoggingEnabled(boolean z) {
        this.f1882f.setWriteAheadLoggingEnabled(z);
    }
}
