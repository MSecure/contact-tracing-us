package com.facebook.imagepipeline.memory;

import androidx.appcompat.app.AppCompatDelegateImpl;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.memory.PooledByteBufferOutputStream;
import com.facebook.common.memory.PooledByteStreams;
import java.io.IOException;
import java.io.InputStream;

public class MemoryPooledByteBufferFactory implements PooledByteBufferFactory {
    public final MemoryChunkPool mPool;
    public final PooledByteStreams mPooledByteStreams;

    public MemoryPooledByteBufferFactory(MemoryChunkPool memoryChunkPool, PooledByteStreams pooledByteStreams) {
        this.mPool = memoryChunkPool;
        this.mPooledByteStreams = pooledByteStreams;
    }

    @Override // com.facebook.common.memory.PooledByteBufferFactory
    public PooledByteBuffer newByteBuffer(InputStream inputStream) throws IOException {
        MemoryChunkPool memoryChunkPool = this.mPool;
        MemoryPooledByteBufferOutputStream memoryPooledByteBufferOutputStream = new MemoryPooledByteBufferOutputStream(memoryChunkPool, memoryChunkPool.mBucketSizes[0]);
        try {
            this.mPooledByteStreams.copy(inputStream, memoryPooledByteBufferOutputStream);
            return memoryPooledByteBufferOutputStream.toByteBuffer();
        } finally {
            memoryPooledByteBufferOutputStream.close();
        }
    }

    @Override // com.facebook.common.memory.PooledByteBufferFactory
    public PooledByteBufferOutputStream newOutputStream() {
        MemoryChunkPool memoryChunkPool = this.mPool;
        return new MemoryPooledByteBufferOutputStream(memoryChunkPool, memoryChunkPool.mBucketSizes[0]);
    }

    @Override // com.facebook.common.memory.PooledByteBufferFactory
    public PooledByteBufferOutputStream newOutputStream(int i) {
        return new MemoryPooledByteBufferOutputStream(this.mPool, i);
    }

    @Override // com.facebook.common.memory.PooledByteBufferFactory
    public PooledByteBuffer newByteBuffer(byte[] bArr) {
        MemoryPooledByteBufferOutputStream memoryPooledByteBufferOutputStream = new MemoryPooledByteBufferOutputStream(this.mPool, bArr.length);
        try {
            memoryPooledByteBufferOutputStream.write(bArr, 0, bArr.length);
            MemoryPooledByteBuffer byteBuffer = memoryPooledByteBufferOutputStream.toByteBuffer();
            memoryPooledByteBufferOutputStream.close();
            return byteBuffer;
        } catch (IOException e) {
            AppCompatDelegateImpl.ConfigurationImplApi17.propagateIfPossible(e);
            throw new RuntimeException(e);
        } catch (Throwable th) {
            memoryPooledByteBufferOutputStream.close();
            throw th;
        }
    }

    @Override // com.facebook.common.memory.PooledByteBufferFactory
    public PooledByteBuffer newByteBuffer(InputStream inputStream, int i) throws IOException {
        MemoryPooledByteBufferOutputStream memoryPooledByteBufferOutputStream = new MemoryPooledByteBufferOutputStream(this.mPool, i);
        try {
            this.mPooledByteStreams.copy(inputStream, memoryPooledByteBufferOutputStream);
            return memoryPooledByteBufferOutputStream.toByteBuffer();
        } finally {
            memoryPooledByteBufferOutputStream.close();
        }
    }
}
