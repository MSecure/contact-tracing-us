package com.facebook.imagepipeline.memory;

import android.util.Log;
import androidx.appcompat.app.AppCompatDelegateImpl;
import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.common.internal.DoNotStrip;
import com.facebook.imagepipeline.nativecode.ImagePipelineNativeLoader;
import java.io.Closeable;
import java.nio.ByteBuffer;

@DoNotStrip
public class NativeMemoryChunk implements MemoryChunk, Closeable {
    public boolean mIsClosed;
    public final long mNativePtr;
    public final int mSize;

    static {
        ImagePipelineNativeLoader.load();
    }

    public NativeMemoryChunk(int i) {
        AppCompatDelegateImpl.ConfigurationImplApi17.checkArgument(i > 0);
        this.mSize = i;
        this.mNativePtr = nativeAllocate(i);
        this.mIsClosed = false;
    }

    @DoNotStrip
    public static native long nativeAllocate(int i);

    @DoNotStrip
    public static native void nativeCopyFromByteArray(long j, byte[] bArr, int i, int i2);

    @DoNotStrip
    public static native void nativeCopyToByteArray(long j, byte[] bArr, int i, int i2);

    @DoNotStrip
    public static native void nativeFree(long j);

    @DoNotStrip
    public static native void nativeMemcpy(long j, long j2, int i);

    @DoNotStrip
    public static native byte nativeReadByte(long j);

    @Override // java.io.Closeable, com.facebook.imagepipeline.memory.MemoryChunk, java.lang.AutoCloseable
    public synchronized void close() {
        if (!this.mIsClosed) {
            this.mIsClosed = true;
            nativeFree(this.mNativePtr);
        }
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    public void copy(int i, MemoryChunk memoryChunk, int i2, int i3) {
        if (memoryChunk != null) {
            if (memoryChunk.getUniqueId() == this.mNativePtr) {
                StringBuilder outline17 = GeneratedOutlineSupport.outline17("Copying from NativeMemoryChunk ");
                outline17.append(Integer.toHexString(System.identityHashCode(this)));
                outline17.append(" to NativeMemoryChunk ");
                outline17.append(Integer.toHexString(System.identityHashCode(memoryChunk)));
                outline17.append(" which share the same address ");
                outline17.append(Long.toHexString(this.mNativePtr));
                Log.w("NativeMemoryChunk", outline17.toString());
                AppCompatDelegateImpl.ConfigurationImplApi17.checkArgument(false);
            }
            if (memoryChunk.getUniqueId() < this.mNativePtr) {
                synchronized (memoryChunk) {
                    synchronized (this) {
                        doCopy(i, memoryChunk, i2, i3);
                    }
                }
                return;
            }
            synchronized (this) {
                synchronized (memoryChunk) {
                    doCopy(i, memoryChunk, i2, i3);
                }
            }
            return;
        }
        throw null;
    }

    public final void doCopy(int i, MemoryChunk memoryChunk, int i2, int i3) {
        if (memoryChunk instanceof NativeMemoryChunk) {
            AppCompatDelegateImpl.ConfigurationImplApi17.checkState(!isClosed());
            AppCompatDelegateImpl.ConfigurationImplApi17.checkState(!memoryChunk.isClosed());
            AppCompatDelegateImpl.ConfigurationImplApi17.checkBounds(i, memoryChunk.getSize(), i2, i3, this.mSize);
            nativeMemcpy(memoryChunk.getNativePtr() + ((long) i2), this.mNativePtr + ((long) i), i3);
            return;
        }
        throw new IllegalArgumentException("Cannot copy two incompatible MemoryChunks");
    }

    @Override // java.lang.Object
    public void finalize() throws Throwable {
        if (!isClosed()) {
            StringBuilder outline17 = GeneratedOutlineSupport.outline17("finalize: Chunk ");
            outline17.append(Integer.toHexString(System.identityHashCode(this)));
            outline17.append(" still active. ");
            Log.w("NativeMemoryChunk", outline17.toString());
            try {
                close();
            } finally {
                super.finalize();
            }
        }
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    public ByteBuffer getByteBuffer() {
        return null;
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    public long getNativePtr() {
        return this.mNativePtr;
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    public int getSize() {
        return this.mSize;
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    public long getUniqueId() {
        return this.mNativePtr;
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    public synchronized boolean isClosed() {
        return this.mIsClosed;
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    public synchronized int read(int i, byte[] bArr, int i2, int i3) {
        int adjustByteCount;
        if (bArr != null) {
            AppCompatDelegateImpl.ConfigurationImplApi17.checkState(!isClosed());
            adjustByteCount = AppCompatDelegateImpl.ConfigurationImplApi17.adjustByteCount(i, i3, this.mSize);
            AppCompatDelegateImpl.ConfigurationImplApi17.checkBounds(i, bArr.length, i2, adjustByteCount, this.mSize);
            nativeCopyToByteArray(this.mNativePtr + ((long) i), bArr, i2, adjustByteCount);
        } else {
            throw null;
        }
        return adjustByteCount;
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    public synchronized int write(int i, byte[] bArr, int i2, int i3) {
        int adjustByteCount;
        AppCompatDelegateImpl.ConfigurationImplApi17.checkState(!isClosed());
        adjustByteCount = AppCompatDelegateImpl.ConfigurationImplApi17.adjustByteCount(i, i3, this.mSize);
        AppCompatDelegateImpl.ConfigurationImplApi17.checkBounds(i, bArr.length, i2, adjustByteCount, this.mSize);
        nativeCopyFromByteArray(this.mNativePtr + ((long) i), bArr, i2, adjustByteCount);
        return adjustByteCount;
    }

    public NativeMemoryChunk() {
        this.mSize = 0;
        this.mNativePtr = 0;
        this.mIsClosed = true;
    }

    @Override // com.facebook.imagepipeline.memory.MemoryChunk
    public synchronized byte read(int i) {
        boolean z = true;
        AppCompatDelegateImpl.ConfigurationImplApi17.checkState(!isClosed());
        AppCompatDelegateImpl.ConfigurationImplApi17.checkArgument(i >= 0);
        if (i >= this.mSize) {
            z = false;
        }
        AppCompatDelegateImpl.ConfigurationImplApi17.checkArgument(z);
        return nativeReadByte(this.mNativePtr + ((long) i));
    }
}
