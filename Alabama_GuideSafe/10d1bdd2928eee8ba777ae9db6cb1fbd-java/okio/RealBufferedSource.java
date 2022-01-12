package okio;

import androidx.recyclerview.widget.RecyclerView;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public final class RealBufferedSource implements BufferedSource {
    public final Buffer buffer = new Buffer();
    public boolean closed;
    public final Source source;

    public RealBufferedSource(Source source2) {
        if (source2 != null) {
            this.source = source2;
            return;
        }
        throw new NullPointerException("source == null");
    }

    @Override // okio.BufferedSource
    public Buffer buffer() {
        return this.buffer;
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
    public void close() throws IOException {
        if (!this.closed) {
            this.closed = true;
            this.source.close();
            this.buffer.clear();
        }
    }

    @Override // okio.BufferedSource
    public boolean exhausted() throws IOException {
        if (!this.closed) {
            return this.buffer.exhausted() && this.source.read(this.buffer, 8192) == -1;
        }
        throw new IllegalStateException("closed");
    }

    @Override // okio.BufferedSource
    public Buffer getBuffer() {
        return this.buffer;
    }

    @Override // okio.BufferedSource
    public long indexOf(byte b) throws IOException {
        return indexOf(b, 0, RecyclerView.FOREVER_NS);
    }

    @Override // okio.BufferedSource
    public InputStream inputStream() {
        return new InputStream() {
            /* class okio.RealBufferedSource.AnonymousClass1 */

            @Override // java.io.InputStream
            public int available() throws IOException {
                RealBufferedSource realBufferedSource = RealBufferedSource.this;
                if (!realBufferedSource.closed) {
                    return (int) Math.min(realBufferedSource.buffer.size, 2147483647L);
                }
                throw new IOException("closed");
            }

            @Override // java.io.Closeable, java.lang.AutoCloseable, java.io.InputStream
            public void close() throws IOException {
                RealBufferedSource.this.close();
            }

            @Override // java.io.InputStream
            public int read() throws IOException {
                RealBufferedSource realBufferedSource = RealBufferedSource.this;
                if (!realBufferedSource.closed) {
                    Buffer buffer = realBufferedSource.buffer;
                    if (buffer.size == 0 && realBufferedSource.source.read(buffer, 8192) == -1) {
                        return -1;
                    }
                    return RealBufferedSource.this.buffer.readByte() & 255;
                }
                throw new IOException("closed");
            }

            public String toString() {
                return RealBufferedSource.this + ".inputStream()";
            }

            @Override // java.io.InputStream
            public int read(byte[] bArr, int i, int i2) throws IOException {
                if (!RealBufferedSource.this.closed) {
                    Util.checkOffsetAndCount((long) bArr.length, (long) i, (long) i2);
                    RealBufferedSource realBufferedSource = RealBufferedSource.this;
                    Buffer buffer = realBufferedSource.buffer;
                    if (buffer.size == 0 && realBufferedSource.source.read(buffer, 8192) == -1) {
                        return -1;
                    }
                    return RealBufferedSource.this.buffer.read(bArr, i, i2);
                }
                throw new IOException("closed");
            }
        };
    }

    public boolean isOpen() {
        return !this.closed;
    }

    @Override // okio.BufferedSource
    public BufferedSource peek() {
        return new RealBufferedSource(new PeekSource(this));
    }

    @Override // okio.Source
    public long read(Buffer buffer2, long j) throws IOException {
        if (buffer2 == null) {
            throw new IllegalArgumentException("sink == null");
        } else if (j < 0) {
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline7("byteCount < 0: ", j));
        } else if (!this.closed) {
            Buffer buffer3 = this.buffer;
            if (buffer3.size == 0 && this.source.read(buffer3, 8192) == -1) {
                return -1;
            }
            return this.buffer.read(buffer2, Math.min(j, this.buffer.size));
        } else {
            throw new IllegalStateException("closed");
        }
    }

    @Override // okio.BufferedSource
    public long readAll(Sink sink) throws IOException {
        long j = 0;
        while (this.source.read(this.buffer, 8192) != -1) {
            long completeSegmentByteCount = this.buffer.completeSegmentByteCount();
            if (completeSegmentByteCount > 0) {
                j += completeSegmentByteCount;
                sink.write(this.buffer, completeSegmentByteCount);
            }
        }
        Buffer buffer2 = this.buffer;
        long j2 = buffer2.size;
        if (j2 <= 0) {
            return j;
        }
        long j3 = j + j2;
        sink.write(buffer2, j2);
        return j3;
    }

    @Override // okio.BufferedSource
    public byte readByte() throws IOException {
        require(1);
        return this.buffer.readByte();
    }

    @Override // okio.BufferedSource
    public byte[] readByteArray(long j) throws IOException {
        if (request(j)) {
            return this.buffer.readByteArray(j);
        }
        throw new EOFException();
    }

    @Override // okio.BufferedSource
    public ByteString readByteString(long j) throws IOException {
        if (request(j)) {
            return this.buffer.readByteString(j);
        }
        throw new EOFException();
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x002b  */
    @Override // okio.BufferedSource
    public long readDecimalLong() throws IOException {
        require(1);
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (!request((long) i2)) {
                break;
            }
            byte b = this.buffer.getByte((long) i);
            if ((b >= 48 && b <= 57) || (i == 0 && b == 45)) {
                i = i2;
            } else if (i == 0) {
                throw new NumberFormatException(String.format("Expected leading [0-9] or '-' character but was %#x", Byte.valueOf(b)));
            }
        }
        if (i == 0) {
        }
        return this.buffer.readDecimalLong();
    }

    @Override // okio.BufferedSource
    public void readFully(Buffer buffer2, long j) throws IOException {
        try {
            if (request(j)) {
                Buffer buffer3 = this.buffer;
                long j2 = buffer3.size;
                if (j2 >= j) {
                    buffer2.write(buffer3, j);
                } else {
                    buffer2.write(buffer3, j2);
                    throw new EOFException();
                }
            } else {
                throw new EOFException();
            }
        } catch (EOFException e) {
            buffer2.writeAll(this.buffer);
            throw e;
        }
    }

    @Override // okio.BufferedSource
    public long readHexadecimalUnsignedLong() throws IOException {
        require(1);
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (!request((long) i2)) {
                break;
            }
            byte b = this.buffer.getByte((long) i);
            if ((b >= 48 && b <= 57) || ((b >= 97 && b <= 102) || (b >= 65 && b <= 70))) {
                i = i2;
            } else if (i == 0) {
                throw new NumberFormatException(String.format("Expected leading [0-9a-fA-F] character but was %#x", Byte.valueOf(b)));
            }
        }
        return this.buffer.readHexadecimalUnsignedLong();
    }

    @Override // okio.BufferedSource
    public int readInt() throws IOException {
        require(4);
        return this.buffer.readInt();
    }

    @Override // okio.BufferedSource
    public int readIntLe() throws IOException {
        require(4);
        return this.buffer.readIntLe();
    }

    @Override // okio.BufferedSource
    public long readLong() throws IOException {
        require(8);
        return this.buffer.readLong();
    }

    @Override // okio.BufferedSource
    public short readShort() throws IOException {
        require(2);
        return this.buffer.readShort();
    }

    @Override // okio.BufferedSource
    public short readShortLe() throws IOException {
        require(2);
        return this.buffer.readShortLe();
    }

    @Override // okio.BufferedSource
    public String readString(Charset charset) throws IOException {
        if (charset != null) {
            this.buffer.writeAll(this.source);
            return this.buffer.readString(charset);
        }
        throw new IllegalArgumentException("charset == null");
    }

    @Override // okio.BufferedSource
    public String readUtf8() throws IOException {
        this.buffer.writeAll(this.source);
        return this.buffer.readUtf8();
    }

    @Override // okio.BufferedSource
    public String readUtf8LineStrict() throws IOException {
        return readUtf8LineStrict(RecyclerView.FOREVER_NS);
    }

    @Override // okio.BufferedSource
    public boolean request(long j) throws IOException {
        Buffer buffer2;
        if (j < 0) {
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline7("byteCount < 0: ", j));
        } else if (!this.closed) {
            do {
                buffer2 = this.buffer;
                if (buffer2.size >= j) {
                    return true;
                }
            } while (this.source.read(buffer2, 8192) != -1);
            return false;
        } else {
            throw new IllegalStateException("closed");
        }
    }

    @Override // okio.BufferedSource
    public void require(long j) throws IOException {
        if (!request(j)) {
            throw new EOFException();
        }
    }

    @Override // okio.BufferedSource
    public int select(Options options) throws IOException {
        if (!this.closed) {
            do {
                int selectPrefix = this.buffer.selectPrefix(options, true);
                if (selectPrefix == -1) {
                    return -1;
                }
                if (selectPrefix != -2) {
                    this.buffer.skip((long) options.byteStrings[selectPrefix].size());
                    return selectPrefix;
                }
            } while (this.source.read(this.buffer, 8192) != -1);
            return -1;
        }
        throw new IllegalStateException("closed");
    }

    @Override // okio.BufferedSource
    public void skip(long j) throws IOException {
        if (!this.closed) {
            while (j > 0) {
                Buffer buffer2 = this.buffer;
                if (buffer2.size == 0 && this.source.read(buffer2, 8192) == -1) {
                    throw new EOFException();
                }
                long min = Math.min(j, this.buffer.size);
                this.buffer.skip(min);
                j -= min;
            }
            return;
        }
        throw new IllegalStateException("closed");
    }

    @Override // okio.Source
    public Timeout timeout() {
        return this.source.timeout();
    }

    public String toString() {
        StringBuilder outline17 = GeneratedOutlineSupport.outline17("buffer(");
        outline17.append(this.source);
        outline17.append(")");
        return outline17.toString();
    }

    public long indexOf(byte b, long j, long j2) throws IOException {
        if (this.closed) {
            throw new IllegalStateException("closed");
        } else if (j < 0 || j2 < j) {
            throw new IllegalArgumentException(String.format("fromIndex=%s toIndex=%s", Long.valueOf(j), Long.valueOf(j2)));
        } else {
            while (j < j2) {
                long indexOf = this.buffer.indexOf(b, j, j2);
                if (indexOf == -1) {
                    Buffer buffer2 = this.buffer;
                    long j3 = buffer2.size;
                    if (j3 >= j2 || this.source.read(buffer2, 8192) == -1) {
                        break;
                    }
                    j = Math.max(j, j3);
                } else {
                    return indexOf;
                }
            }
            return -1;
        }
    }

    @Override // okio.BufferedSource
    public String readUtf8LineStrict(long j) throws IOException {
        if (j >= 0) {
            long j2 = j == RecyclerView.FOREVER_NS ? Long.MAX_VALUE : j + 1;
            long indexOf = indexOf((byte) 10, 0, j2);
            if (indexOf != -1) {
                return this.buffer.readUtf8Line(indexOf);
            }
            if (j2 < RecyclerView.FOREVER_NS && request(j2) && this.buffer.getByte(j2 - 1) == 13 && request(1 + j2) && this.buffer.getByte(j2) == 10) {
                return this.buffer.readUtf8Line(j2);
            }
            Buffer buffer2 = new Buffer();
            Buffer buffer3 = this.buffer;
            buffer3.copyTo(buffer2, 0, Math.min(32L, buffer3.size));
            StringBuilder outline17 = GeneratedOutlineSupport.outline17("\\n not found: limit=");
            outline17.append(Math.min(this.buffer.size, j));
            outline17.append(" content=");
            outline17.append(buffer2.readByteString().hex());
            outline17.append((char) 8230);
            throw new EOFException(outline17.toString());
        }
        throw new IllegalArgumentException(GeneratedOutlineSupport.outline7("limit < 0: ", j));
    }

    @Override // okio.BufferedSource
    public byte[] readByteArray() throws IOException {
        this.buffer.writeAll(this.source);
        return this.buffer.readByteArray();
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        Buffer buffer2 = this.buffer;
        if (buffer2.size == 0 && this.source.read(buffer2, 8192) == -1) {
            return -1;
        }
        return this.buffer.read(byteBuffer);
    }

    @Override // okio.BufferedSource
    public void readFully(byte[] bArr) throws IOException {
        try {
            require((long) bArr.length);
            this.buffer.readFully(bArr);
        } catch (EOFException e) {
            int i = 0;
            while (true) {
                Buffer buffer2 = this.buffer;
                long j = buffer2.size;
                if (j > 0) {
                    int read = buffer2.read(bArr, i, (int) j);
                    if (read != -1) {
                        i += read;
                    } else {
                        throw new AssertionError();
                    }
                } else {
                    throw e;
                }
            }
        }
    }
}
