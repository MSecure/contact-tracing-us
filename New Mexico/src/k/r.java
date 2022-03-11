package k;

import java.io.Closeable;
import java.io.Flushable;
/* loaded from: classes.dex */
public interface r extends Closeable, Flushable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    @Override // java.io.Flushable
    void flush();

    void h(e eVar, long j2);
}
