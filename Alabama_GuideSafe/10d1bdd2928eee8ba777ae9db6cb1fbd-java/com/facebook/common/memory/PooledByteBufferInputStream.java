package com.facebook.common.memory;

import androidx.appcompat.app.AppCompatDelegateImpl;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.InputStream;

public class PooledByteBufferInputStream extends InputStream {
    public int mMark = 0;
    public int mOffset = 0;
    public final PooledByteBuffer mPooledByteBuffer;

    public PooledByteBufferInputStream(PooledByteBuffer pooledByteBuffer) {
        AppCompatDelegateImpl.ConfigurationImplApi17.checkArgument(!pooledByteBuffer.isClosed());
        this.mPooledByteBuffer = pooledByteBuffer;
    }

    @Override // java.io.InputStream
    public int available() {
        return this.mPooledByteBuffer.size() - this.mOffset;
    }

    public void mark(int i) {
        this.mMark = this.mOffset;
    }

    public boolean markSupported() {
        return true;
    }

    @Override // java.io.InputStream
    public int read() {
        if (available() <= 0) {
            return -1;
        }
        PooledByteBuffer pooledByteBuffer = this.mPooledByteBuffer;
        int i = this.mOffset;
        this.mOffset = i + 1;
        return pooledByteBuffer.read(i) & 255;
    }

    @Override // java.io.InputStream
    public void reset() {
        this.mOffset = this.mMark;
    }

    @Override // java.io.InputStream
    public long skip(long j) {
        AppCompatDelegateImpl.ConfigurationImplApi17.checkArgument(j >= 0);
        int min = Math.min((int) j, available());
        this.mOffset += min;
        return (long) min;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        if (i < 0 || i2 < 0 || i + i2 > bArr.length) {
            StringBuilder outline17 = GeneratedOutlineSupport.outline17("length=");
            outline17.append(bArr.length);
            outline17.append("; regionStart=");
            outline17.append(i);
            outline17.append("; regionLength=");
            outline17.append(i2);
            throw new ArrayIndexOutOfBoundsException(outline17.toString());
        }
        int available = available();
        if (available <= 0) {
            return -1;
        }
        if (i2 <= 0) {
            return 0;
        }
        int min = Math.min(available, i2);
        this.mPooledByteBuffer.read(this.mOffset, bArr, i, min);
        this.mOffset += min;
        return min;
    }
}
