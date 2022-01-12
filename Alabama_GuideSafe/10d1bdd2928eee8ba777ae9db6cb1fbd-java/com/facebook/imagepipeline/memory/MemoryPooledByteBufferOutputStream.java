package com.facebook.imagepipeline.memory;

import androidx.appcompat.app.AppCompatDelegateImpl;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.common.memory.PooledByteBufferOutputStream;
import com.facebook.common.references.CloseableReference;
import java.io.IOException;

public class MemoryPooledByteBufferOutputStream extends PooledByteBufferOutputStream {
    public CloseableReference<MemoryChunk> mBufRef;
    public int mCount;
    public final MemoryChunkPool mPool;

    public static class InvalidStreamException extends RuntimeException {
        public InvalidStreamException() {
            super("OutputStream no longer valid");
        }
    }

    public MemoryPooledByteBufferOutputStream(MemoryChunkPool memoryChunkPool, int i) {
        AppCompatDelegateImpl.ConfigurationImplApi17.checkArgument(i > 0);
        if (memoryChunkPool != null) {
            this.mPool = memoryChunkPool;
            this.mCount = 0;
            this.mBufRef = CloseableReference.of(memoryChunkPool.get(i), this.mPool);
            return;
        }
        throw null;
    }

    @Override // java.io.OutputStream, java.io.Closeable, com.facebook.common.memory.PooledByteBufferOutputStream, java.lang.AutoCloseable
    public void close() {
        CloseableReference.closeSafely(this.mBufRef);
        this.mBufRef = null;
        this.mCount = -1;
        super.close();
    }

    public final void ensureValid() {
        if (!CloseableReference.isValid(this.mBufRef)) {
            throw new InvalidStreamException();
        }
    }

    public MemoryPooledByteBuffer toByteBuffer() {
        ensureValid();
        return new MemoryPooledByteBuffer(this.mBufRef, this.mCount);
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        write(new byte[]{(byte) i});
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        if (i < 0 || i2 < 0 || i + i2 > bArr.length) {
            StringBuilder outline17 = GeneratedOutlineSupport.outline17("length=");
            outline17.append(bArr.length);
            outline17.append("; regionStart=");
            outline17.append(i);
            outline17.append("; regionLength=");
            outline17.append(i2);
            throw new ArrayIndexOutOfBoundsException(outline17.toString());
        }
        ensureValid();
        int i3 = this.mCount + i2;
        ensureValid();
        if (i3 > this.mBufRef.get().getSize()) {
            MemoryChunk memoryChunk = (MemoryChunk) this.mPool.get(i3);
            this.mBufRef.get().copy(0, memoryChunk, 0, this.mCount);
            this.mBufRef.close();
            this.mBufRef = CloseableReference.of(memoryChunk, this.mPool);
        }
        this.mBufRef.get().write(this.mCount, bArr, i, i2);
        this.mCount += i2;
    }
}
