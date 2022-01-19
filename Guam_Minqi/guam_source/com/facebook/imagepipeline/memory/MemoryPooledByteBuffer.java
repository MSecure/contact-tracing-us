package com.facebook.imagepipeline.memory;

import androidx.appcompat.app.AppCompatDelegateImpl;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;

public class MemoryPooledByteBuffer implements PooledByteBuffer {
    public CloseableReference<MemoryChunk> mBufRef;
    public final int mSize;

    public MemoryPooledByteBuffer(CloseableReference<MemoryChunk> closeableReference, int i) {
        if (closeableReference != null) {
            AppCompatDelegateImpl.ConfigurationImplApi17.checkArgument(i >= 0 && i <= closeableReference.get().getSize());
            this.mBufRef = closeableReference.clone();
            this.mSize = i;
            return;
        }
        throw null;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        CloseableReference.closeSafely(this.mBufRef);
        this.mBufRef = null;
    }

    public synchronized void ensureValid() {
        synchronized (this) {
        }
        if (!CloseableReference.isValid(this.mBufRef)) {
            throw new PooledByteBuffer.ClosedException();
        }
    }

    @Override // com.facebook.common.memory.PooledByteBuffer
    public synchronized boolean isClosed() {
        return !CloseableReference.isValid(this.mBufRef);
    }

    @Override // com.facebook.common.memory.PooledByteBuffer
    public synchronized byte read(int i) {
        ensureValid();
        boolean z = true;
        AppCompatDelegateImpl.ConfigurationImplApi17.checkArgument(i >= 0);
        if (i >= this.mSize) {
            z = false;
        }
        AppCompatDelegateImpl.ConfigurationImplApi17.checkArgument(z);
        return this.mBufRef.get().read(i);
    }

    @Override // com.facebook.common.memory.PooledByteBuffer
    public synchronized int size() {
        ensureValid();
        return this.mSize;
    }

    @Override // com.facebook.common.memory.PooledByteBuffer
    public synchronized int read(int i, byte[] bArr, int i2, int i3) {
        ensureValid();
        AppCompatDelegateImpl.ConfigurationImplApi17.checkArgument(i + i3 <= this.mSize);
        return this.mBufRef.get().read(i, bArr, i2, i3);
    }
}
