package b.r;

import android.content.Context;
import android.os.Build;
import androidx.recyclerview.widget.RecyclerView;
import b.r.q.b;
import b.u.a.c;
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
    public final Context f1664b;

    /* renamed from: c  reason: collision with root package name */
    public final String f1665c;

    /* renamed from: d  reason: collision with root package name */
    public final File f1666d;

    /* renamed from: e  reason: collision with root package name */
    public final int f1667e;
    public final c f;
    public a g;
    public boolean h;

    /* JADX INFO: finally extract failed */
    public final void a(File file) {
        ReadableByteChannel readableByteChannel;
        if (this.f1665c != null) {
            readableByteChannel = Channels.newChannel(this.f1664b.getAssets().open(this.f1665c));
        } else if (this.f1666d != null) {
            readableByteChannel = new FileInputStream(this.f1666d).getChannel();
        } else {
            throw new IllegalStateException("copyFromAssetPath and copyFromFile == null!");
        }
        File createTempFile = File.createTempFile("room-copy-helper", ".tmp", this.f1664b.getCacheDir());
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
                channel.transferFrom(readableByteChannel, 0, RecyclerView.FOREVER_NS);
            }
            channel.force(false);
            readableByteChannel.close();
            channel.close();
            File parentFile = file.getParentFile();
            if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
                StringBuilder g2 = a.g("Failed to create directories for ");
                g2.append(file.getAbsolutePath());
                throw new IOException(g2.toString());
            } else if (!createTempFile.renameTo(file)) {
                StringBuilder g3 = a.g("Failed to move intermediate file (");
                g3.append(createTempFile.getAbsolutePath());
                g3.append(") to destination (");
                g3.append(file.getAbsolutePath());
                g3.append(").");
                throw new IOException(g3.toString());
            }
        } catch (Throwable th) {
            readableByteChannel.close();
            channel.close();
            throw th;
        }
    }

    public final void b() {
        String databaseName = this.f.getDatabaseName();
        File databasePath = this.f1664b.getDatabasePath(databaseName);
        a aVar = this.g;
        b.r.q.a aVar2 = new b.r.q.a(databaseName, this.f1664b.getFilesDir(), aVar == null || aVar.j);
        try {
            aVar2.f1683b.lock();
            if (aVar2.f1684c) {
                try {
                    FileChannel channel = new FileOutputStream(aVar2.f1682a).getChannel();
                    aVar2.f1685d = channel;
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
            } else if (this.g == null) {
                aVar2.a();
            } else {
                try {
                    int c2 = b.c(databasePath);
                    if (c2 == this.f1667e) {
                        aVar2.a();
                    } else if (this.g.a(c2, this.f1667e)) {
                        aVar2.a();
                    } else {
                        if (this.f1664b.deleteDatabase(databaseName)) {
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

    @Override // b.u.a.c
    public synchronized b.u.a.b c() {
        if (!this.h) {
            b();
            this.h = true;
        }
        return this.f.c();
    }

    @Override // java.io.Closeable, b.u.a.c, java.lang.AutoCloseable
    public synchronized void close() {
        this.f.close();
        this.h = false;
    }

    @Override // b.u.a.c
    public String getDatabaseName() {
        return this.f.getDatabaseName();
    }

    @Override // b.u.a.c
    public void setWriteAheadLoggingEnabled(boolean z) {
        this.f.setWriteAheadLoggingEnabled(z);
    }
}
