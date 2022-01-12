package org.spongycastle.asn1;

import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import org.spongycastle.util.io.Streams;

public class DefiniteLengthInputStream extends LimitedInputStream {
    public static final byte[] EMPTY_BYTES = new byte[0];
    public final int _originalLength;
    public int _remaining;

    public DefiniteLengthInputStream(InputStream inputStream, int i) {
        super(inputStream, i);
        if (i >= 0) {
            this._originalLength = i;
            this._remaining = i;
            if (i == 0) {
                setParentEofDetect(true);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("negative lengths not allowed");
    }

    @Override // org.spongycastle.asn1.LimitedInputStream
    public int getRemaining() {
        return this._remaining;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (this._remaining == 0) {
            return -1;
        }
        int read = this._in.read();
        if (read >= 0) {
            int i = this._remaining - 1;
            this._remaining = i;
            if (i == 0) {
                setParentEofDetect(true);
            }
            return read;
        }
        StringBuilder outline17 = GeneratedOutlineSupport.outline17("DEF length ");
        outline17.append(this._originalLength);
        outline17.append(" object truncated by ");
        outline17.append(this._remaining);
        throw new EOFException(outline17.toString());
    }

    public byte[] toByteArray() throws IOException {
        int i = this._remaining;
        if (i == 0) {
            return EMPTY_BYTES;
        }
        byte[] bArr = new byte[i];
        int readFully = i - Streams.readFully(this._in, bArr);
        this._remaining = readFully;
        if (readFully == 0) {
            setParentEofDetect(true);
            return bArr;
        }
        StringBuilder outline17 = GeneratedOutlineSupport.outline17("DEF length ");
        outline17.append(this._originalLength);
        outline17.append(" object truncated by ");
        outline17.append(this._remaining);
        throw new EOFException(outline17.toString());
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = this._remaining;
        if (i3 == 0) {
            return -1;
        }
        int read = this._in.read(bArr, i, Math.min(i2, i3));
        if (read >= 0) {
            int i4 = this._remaining - read;
            this._remaining = i4;
            if (i4 == 0) {
                setParentEofDetect(true);
            }
            return read;
        }
        StringBuilder outline17 = GeneratedOutlineSupport.outline17("DEF length ");
        outline17.append(this._originalLength);
        outline17.append(" object truncated by ");
        outline17.append(this._remaining);
        throw new EOFException(outline17.toString());
    }
}
