package com.facebook.imagepipeline.image;

import com.facebook.common.logging.FLog;
import java.io.Closeable;

public abstract class CloseableImage implements Closeable, ImageInfo {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    public abstract void close();

    @Override // java.lang.Object
    public void finalize() throws Throwable {
        if (!isClosed()) {
            FLog.w("CloseableImage", "finalize: %s %x still open.", getClass().getSimpleName(), Integer.valueOf(System.identityHashCode(this)));
            try {
                close();
            } finally {
                super.finalize();
            }
        }
    }

    public abstract boolean isClosed();
}
