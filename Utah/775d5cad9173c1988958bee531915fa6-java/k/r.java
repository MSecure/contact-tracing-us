package k;

import java.io.Closeable;
import java.io.Flushable;

public interface r extends Closeable, Flushable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    @Override // java.io.Flushable
    void flush();

    void h(e eVar, long j2);
}
