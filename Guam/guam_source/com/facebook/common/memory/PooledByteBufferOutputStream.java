package com.facebook.common.memory;

import androidx.appcompat.app.AppCompatDelegateImpl;
import java.io.IOException;
import java.io.OutputStream;

public abstract class PooledByteBufferOutputStream extends OutputStream {
    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            super.close();
        } catch (IOException e) {
            AppCompatDelegateImpl.ConfigurationImplApi17.propagateIfPossible(e);
            throw new RuntimeException(e);
        }
    }
}
