package com.facebook.common.memory;

import androidx.appcompat.app.AppCompatDelegateImpl;
import com.facebook.common.logging.FLog;
import com.facebook.common.references.ResourceReleaser;
import java.io.IOException;
import java.io.InputStream;

public class PooledByteArrayBufferedInputStream extends InputStream {
    public int mBufferOffset;
    public int mBufferedSize;
    public final byte[] mByteArray;
    public boolean mClosed;
    public final InputStream mInputStream;
    public final ResourceReleaser<byte[]> mResourceReleaser;

    public PooledByteArrayBufferedInputStream(InputStream inputStream, byte[] bArr, ResourceReleaser<byte[]> resourceReleaser) {
        if (inputStream != null) {
            this.mInputStream = inputStream;
            if (bArr != null) {
                this.mByteArray = bArr;
                if (resourceReleaser != null) {
                    this.mResourceReleaser = resourceReleaser;
                    this.mBufferedSize = 0;
                    this.mBufferOffset = 0;
                    this.mClosed = false;
                    return;
                }
                throw null;
            }
            throw null;
        }
        throw null;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        AppCompatDelegateImpl.ConfigurationImplApi17.checkState(this.mBufferOffset <= this.mBufferedSize);
        ensureNotClosed();
        return this.mInputStream.available() + (this.mBufferedSize - this.mBufferOffset);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable, java.io.InputStream
    public void close() throws IOException {
        if (!this.mClosed) {
            this.mClosed = true;
            this.mResourceReleaser.release(this.mByteArray);
            super.close();
        }
    }

    public final boolean ensureDataInBuffer() throws IOException {
        if (this.mBufferOffset < this.mBufferedSize) {
            return true;
        }
        int read = this.mInputStream.read(this.mByteArray);
        if (read <= 0) {
            return false;
        }
        this.mBufferedSize = read;
        this.mBufferOffset = 0;
        return true;
    }

    public final void ensureNotClosed() throws IOException {
        if (this.mClosed) {
            throw new IOException("stream already closed");
        }
    }

    @Override // java.lang.Object
    public void finalize() throws Throwable {
        if (!this.mClosed) {
            FLog.e("PooledByteInputStream", "Finalized without closing");
            close();
        }
        super.finalize();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        AppCompatDelegateImpl.ConfigurationImplApi17.checkState(this.mBufferOffset <= this.mBufferedSize);
        ensureNotClosed();
        if (!ensureDataInBuffer()) {
            return -1;
        }
        byte[] bArr = this.mByteArray;
        int i = this.mBufferOffset;
        this.mBufferOffset = i + 1;
        return bArr[i] & 255;
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        AppCompatDelegateImpl.ConfigurationImplApi17.checkState(this.mBufferOffset <= this.mBufferedSize);
        ensureNotClosed();
        int i = this.mBufferedSize;
        int i2 = this.mBufferOffset;
        long j2 = (long) (i - i2);
        if (j2 >= j) {
            this.mBufferOffset = (int) (((long) i2) + j);
            return j;
        }
        this.mBufferOffset = i;
        return this.mInputStream.skip(j - j2) + j2;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        AppCompatDelegateImpl.ConfigurationImplApi17.checkState(this.mBufferOffset <= this.mBufferedSize);
        ensureNotClosed();
        if (!ensureDataInBuffer()) {
            return -1;
        }
        int min = Math.min(this.mBufferedSize - this.mBufferOffset, i2);
        System.arraycopy(this.mByteArray, this.mBufferOffset, bArr, i, min);
        this.mBufferOffset += min;
        return min;
    }
}
