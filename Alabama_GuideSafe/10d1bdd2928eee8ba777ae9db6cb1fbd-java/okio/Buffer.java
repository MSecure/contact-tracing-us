package okio;

import androidx.recyclerview.widget.RecyclerView;
import com.android.tools.r8.GeneratedOutlineSupport;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import okhttp3.internal.http2.Http2Connection;

public final class Buffer implements BufferedSource, BufferedSink, Cloneable, ByteChannel {
    public static final byte[] DIGITS = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};
    public Segment head;
    public long size;

    public static final class UnsafeCursor implements Closeable {
        public Buffer buffer;
        public byte[] data;
        public int end = -1;
        public long offset = -1;
        public boolean readWrite;
        public Segment segment;
        public int start = -1;

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.buffer != null) {
                this.buffer = null;
                this.segment = null;
                this.offset = -1;
                this.data = null;
                this.start = -1;
                this.end = -1;
                return;
            }
            throw new IllegalStateException("not attached to a buffer");
        }

        public final int seek(long j) {
            int i = (j > -1 ? 1 : (j == -1 ? 0 : -1));
            if (i >= 0) {
                Buffer buffer2 = this.buffer;
                long j2 = buffer2.size;
                if (j <= j2) {
                    if (i == 0 || j == j2) {
                        this.segment = null;
                        this.offset = j;
                        this.data = null;
                        this.start = -1;
                        this.end = -1;
                        return -1;
                    }
                    long j3 = 0;
                    Segment segment2 = buffer2.head;
                    Segment segment3 = this.segment;
                    if (segment3 != null) {
                        long j4 = this.offset - ((long) (this.start - segment3.pos));
                        if (j4 > j) {
                            j2 = j4;
                            segment3 = segment2;
                            segment2 = segment3;
                        } else {
                            j3 = j4;
                        }
                    } else {
                        segment3 = segment2;
                    }
                    if (j2 - j > j - j3) {
                        while (true) {
                            int i2 = segment3.limit;
                            int i3 = segment3.pos;
                            if (j < ((long) (i2 - i3)) + j3) {
                                break;
                            }
                            j3 += (long) (i2 - i3);
                            segment3 = segment3.next;
                        }
                    } else {
                        while (j2 > j) {
                            segment2 = segment2.prev;
                            j2 -= (long) (segment2.limit - segment2.pos);
                        }
                        segment3 = segment2;
                        j3 = j2;
                    }
                    if (this.readWrite && segment3.shared) {
                        Segment segment4 = new Segment((byte[]) segment3.data.clone(), segment3.pos, segment3.limit, false, true);
                        Buffer buffer3 = this.buffer;
                        if (buffer3.head == segment3) {
                            buffer3.head = segment4;
                        }
                        segment3.push(segment4);
                        segment4.prev.pop();
                        segment3 = segment4;
                    }
                    this.segment = segment3;
                    this.offset = j;
                    this.data = segment3.data;
                    int i4 = segment3.pos + ((int) (j - j3));
                    this.start = i4;
                    int i5 = segment3.limit;
                    this.end = i5;
                    return i5 - i4;
                }
            }
            throw new ArrayIndexOutOfBoundsException(String.format("offset=%s > size=%s", Long.valueOf(j), Long.valueOf(this.buffer.size)));
        }
    }

    @Override // okio.BufferedSource, okio.BufferedSink
    public Buffer buffer() {
        return this;
    }

    public final void clear() {
        try {
            skip(this.size);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    @Override // okio.Source, java.lang.AutoCloseable, okio.Sink, java.io.Closeable, java.nio.channels.Channel
    public void close() {
    }

    public final long completeSegmentByteCount() {
        long j = this.size;
        if (j == 0) {
            return 0;
        }
        Segment segment = this.head.prev;
        int i = segment.limit;
        return (i >= 8192 || !segment.owner) ? j : j - ((long) (i - segment.pos));
    }

    public final Buffer copyTo(Buffer buffer, long j, long j2) {
        if (buffer != null) {
            Util.checkOffsetAndCount(this.size, j, j2);
            if (j2 == 0) {
                return this;
            }
            buffer.size += j2;
            Segment segment = this.head;
            while (true) {
                int i = segment.limit;
                int i2 = segment.pos;
                if (j < ((long) (i - i2))) {
                    break;
                }
                j -= (long) (i - i2);
                segment = segment.next;
            }
            while (j2 > 0) {
                Segment sharedCopy = segment.sharedCopy();
                int i3 = (int) (((long) sharedCopy.pos) + j);
                sharedCopy.pos = i3;
                sharedCopy.limit = Math.min(i3 + ((int) j2), sharedCopy.limit);
                Segment segment2 = buffer.head;
                if (segment2 == null) {
                    sharedCopy.prev = sharedCopy;
                    sharedCopy.next = sharedCopy;
                    buffer.head = sharedCopy;
                } else {
                    segment2.prev.push(sharedCopy);
                }
                j2 -= (long) (sharedCopy.limit - sharedCopy.pos);
                segment = segment.next;
                j = 0;
            }
            return this;
        }
        throw new IllegalArgumentException("out == null");
    }

    @Override // okio.BufferedSink
    public BufferedSink emit() {
        return this;
    }

    @Override // okio.BufferedSink
    public BufferedSink emitCompleteSegments() throws IOException {
        return this;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Buffer)) {
            return false;
        }
        Buffer buffer = (Buffer) obj;
        long j = this.size;
        if (j != buffer.size) {
            return false;
        }
        long j2 = 0;
        if (j == 0) {
            return true;
        }
        Segment segment = this.head;
        Segment segment2 = buffer.head;
        int i = segment.pos;
        int i2 = segment2.pos;
        while (j2 < this.size) {
            long min = (long) Math.min(segment.limit - i, segment2.limit - i2);
            int i3 = 0;
            while (((long) i3) < min) {
                int i4 = i + 1;
                int i5 = i2 + 1;
                if (segment.data[i] != segment2.data[i2]) {
                    return false;
                }
                i3++;
                i = i4;
                i2 = i5;
            }
            if (i == segment.limit) {
                segment = segment.next;
                i = segment.pos;
            }
            if (i2 == segment2.limit) {
                segment2 = segment2.next;
                i2 = segment2.pos;
            }
            j2 += min;
        }
        return true;
    }

    @Override // okio.BufferedSource
    public boolean exhausted() {
        return this.size == 0;
    }

    @Override // okio.Sink, okio.BufferedSink, java.io.Flushable
    public void flush() {
    }

    @Override // okio.BufferedSource
    public Buffer getBuffer() {
        return this;
    }

    public final byte getByte(long j) {
        int i;
        Util.checkOffsetAndCount(this.size, j, 1);
        long j2 = this.size;
        if (j2 - j > j) {
            Segment segment = this.head;
            while (true) {
                int i2 = segment.limit;
                int i3 = segment.pos;
                long j3 = (long) (i2 - i3);
                if (j < j3) {
                    return segment.data[i3 + ((int) j)];
                }
                j -= j3;
                segment = segment.next;
            }
        } else {
            long j4 = j - j2;
            Segment segment2 = this.head;
            do {
                segment2 = segment2.prev;
                int i4 = segment2.limit;
                i = segment2.pos;
                j4 += (long) (i4 - i);
            } while (j4 < 0);
            return segment2.data[i + ((int) j4)];
        }
    }

    public int hashCode() {
        Segment segment = this.head;
        if (segment == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = segment.limit;
            for (int i3 = segment.pos; i3 < i2; i3++) {
                i = (i * 31) + segment.data[i3];
            }
            segment = segment.next;
        } while (segment != this.head);
        return i;
    }

    @Override // okio.BufferedSource
    public long indexOf(byte b) {
        return indexOf(b, 0, RecyclerView.FOREVER_NS);
    }

    public long indexOfElement(ByteString byteString) {
        int i;
        int i2;
        Segment segment = this.head;
        if (segment == null) {
            return -1;
        }
        long j = this.size;
        long j2 = 0;
        if (j - 0 >= 0) {
            j = 0;
            while (true) {
                long j3 = ((long) (segment.limit - segment.pos)) + j;
                if (j3 >= 0) {
                    break;
                }
                segment = segment.next;
                j = j3;
            }
        } else {
            while (j > 0) {
                segment = segment.prev;
                j -= (long) (segment.limit - segment.pos);
            }
        }
        if (byteString.size() == 2) {
            byte b = byteString.getByte(0);
            byte b2 = byteString.getByte(1);
            while (j < this.size) {
                byte[] bArr = segment.data;
                i2 = (int) ((((long) segment.pos) + j2) - j);
                int i3 = segment.limit;
                while (i2 < i3) {
                    byte b3 = bArr[i2];
                    if (b3 == b || b3 == b2) {
                        i = segment.pos;
                    } else {
                        i2++;
                    }
                }
                j2 = ((long) (segment.limit - segment.pos)) + j;
                segment = segment.next;
                j = j2;
            }
            return -1;
        }
        byte[] internalArray = byteString.internalArray();
        while (j < this.size) {
            byte[] bArr2 = segment.data;
            i2 = (int) ((((long) segment.pos) + j2) - j);
            int i4 = segment.limit;
            while (i2 < i4) {
                byte b4 = bArr2[i2];
                for (byte b5 : internalArray) {
                    if (b4 == b5) {
                        i = segment.pos;
                    }
                }
                i2++;
            }
            j2 = ((long) (segment.limit - segment.pos)) + j;
            segment = segment.next;
            j = j2;
        }
        return -1;
        return ((long) (i2 - i)) + j;
    }

    @Override // okio.BufferedSource
    public InputStream inputStream() {
        return new InputStream() {
            /* class okio.Buffer.AnonymousClass2 */

            @Override // java.io.InputStream
            public int available() {
                return (int) Math.min(Buffer.this.size, 2147483647L);
            }

            @Override // java.io.Closeable, java.lang.AutoCloseable, java.io.InputStream
            public void close() {
            }

            @Override // java.io.InputStream
            public int read() {
                Buffer buffer = Buffer.this;
                if (buffer.size > 0) {
                    return buffer.readByte() & 255;
                }
                return -1;
            }

            public String toString() {
                return Buffer.this + ".inputStream()";
            }

            @Override // java.io.InputStream
            public int read(byte[] bArr, int i, int i2) {
                return Buffer.this.read(bArr, i, i2);
            }
        };
    }

    public boolean isOpen() {
        return true;
    }

    @Override // okio.BufferedSink
    public OutputStream outputStream() {
        return new OutputStream() {
            /* class okio.Buffer.AnonymousClass1 */

            @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            @Override // java.io.OutputStream, java.io.Flushable
            public void flush() {
            }

            public String toString() {
                return Buffer.this + ".outputStream()";
            }

            @Override // java.io.OutputStream
            public void write(int i) {
                Buffer.this.writeByte((int) ((byte) i));
            }

            @Override // java.io.OutputStream
            public void write(byte[] bArr, int i, int i2) {
                Buffer.this.write(bArr, i, i2);
            }
        };
    }

    @Override // okio.BufferedSource
    public BufferedSource peek() {
        return Okio.buffer(new PeekSource(this));
    }

    public int read(byte[] bArr, int i, int i2) {
        Util.checkOffsetAndCount((long) bArr.length, (long) i, (long) i2);
        Segment segment = this.head;
        if (segment == null) {
            return -1;
        }
        int min = Math.min(i2, segment.limit - segment.pos);
        System.arraycopy(segment.data, segment.pos, bArr, i, min);
        int i3 = segment.pos + min;
        segment.pos = i3;
        this.size -= (long) min;
        if (i3 == segment.limit) {
            this.head = segment.pop();
            SegmentPool.recycle(segment);
        }
        return min;
    }

    @Override // okio.BufferedSource
    public long readAll(Sink sink) throws IOException {
        long j = this.size;
        if (j > 0) {
            sink.write(this, j);
        }
        return j;
    }

    public final UnsafeCursor readAndWriteUnsafe(UnsafeCursor unsafeCursor) {
        if (unsafeCursor.buffer == null) {
            unsafeCursor.buffer = this;
            unsafeCursor.readWrite = true;
            return unsafeCursor;
        }
        throw new IllegalStateException("already attached to a buffer");
    }

    @Override // okio.BufferedSource
    public byte readByte() {
        long j = this.size;
        if (j != 0) {
            Segment segment = this.head;
            int i = segment.pos;
            int i2 = segment.limit;
            int i3 = i + 1;
            byte b = segment.data[i];
            this.size = j - 1;
            if (i3 == i2) {
                this.head = segment.pop();
                SegmentPool.recycle(segment);
            } else {
                segment.pos = i3;
            }
            return b;
        }
        throw new IllegalStateException("size == 0");
    }

    @Override // okio.BufferedSource
    public byte[] readByteArray() {
        try {
            return readByteArray(this.size);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public ByteString readByteString() {
        return new ByteString(readByteArray());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00b4, code lost:
        if (r7 == false) goto L_0x00b7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:?, code lost:
        return -r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:?, code lost:
        return r2;
     */
    @Override // okio.BufferedSource
    public long readDecimalLong() {
        byte b;
        long j = 0;
        if (this.size != 0) {
            long j2 = -922337203685477580L;
            long j3 = -7;
            int i = 0;
            boolean z = false;
            boolean z2 = false;
            loop0:
            while (true) {
                Segment segment = this.head;
                byte[] bArr = segment.data;
                int i2 = segment.pos;
                int i3 = segment.limit;
                while (true) {
                    if (i2 >= i3) {
                        break;
                    }
                    b = bArr[i2];
                    if (b >= 48 && b <= 57) {
                        int i4 = 48 - b;
                        int i5 = (j > j2 ? 1 : (j == j2 ? 0 : -1));
                        if (i5 < 0 || (i5 == 0 && ((long) i4) < j3)) {
                            Buffer writeDecimalLong = new Buffer().writeDecimalLong(j);
                            writeDecimalLong.writeByte((int) b);
                        } else {
                            j = (j * 10) + ((long) i4);
                        }
                    } else if (b == 45 && i == 0) {
                        j3--;
                        z = true;
                    } else if (i != 0) {
                        z2 = true;
                    } else {
                        StringBuilder outline17 = GeneratedOutlineSupport.outline17("Expected leading [0-9] or '-' character but was 0x");
                        outline17.append(Integer.toHexString(b));
                        throw new NumberFormatException(outline17.toString());
                    }
                    i2++;
                    i++;
                    j2 = -922337203685477580L;
                }
                if (i2 == i3) {
                    this.head = segment.pop();
                    SegmentPool.recycle(segment);
                } else {
                    segment.pos = i2;
                }
                if (z2 || this.head == null) {
                    this.size -= (long) i;
                } else {
                    j2 = -922337203685477580L;
                }
            }
            Buffer writeDecimalLong2 = new Buffer().writeDecimalLong(j);
            writeDecimalLong2.writeByte((int) b);
            if (!z) {
                writeDecimalLong2.readByte();
            }
            StringBuilder outline172 = GeneratedOutlineSupport.outline17("Number too large: ");
            outline172.append(writeDecimalLong2.readUtf8());
            throw new NumberFormatException(outline172.toString());
        }
        throw new IllegalStateException("size == 0");
    }

    @Override // okio.BufferedSource
    public void readFully(Buffer buffer, long j) throws EOFException {
        long j2 = this.size;
        if (j2 >= j) {
            buffer.write(this, j);
        } else {
            buffer.write(this, j2);
            throw new EOFException();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0087, code lost:
        if (r8 != r9) goto L_0x0093;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0089, code lost:
        r14.head = r6.pop();
        okio.SegmentPool.recycle(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0093, code lost:
        r6.pos = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0095, code lost:
        if (r1 != false) goto L_0x009b;
     */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0070 A[SYNTHETIC] */
    @Override // okio.BufferedSource
    public long readHexadecimalUnsignedLong() {
        int i;
        int i2;
        if (this.size != 0) {
            int i3 = 0;
            boolean z = false;
            long j = 0;
            do {
                Segment segment = this.head;
                byte[] bArr = segment.data;
                int i4 = segment.pos;
                int i5 = segment.limit;
                while (true) {
                    if (i4 >= i5) {
                        break;
                    }
                    byte b = bArr[i4];
                    if (b < 48 || b > 57) {
                        if (b >= 97 && b <= 102) {
                            i2 = b - 97;
                        } else if (b >= 65 && b <= 70) {
                            i2 = b - 65;
                        } else if (i3 == 0) {
                            z = true;
                        } else {
                            StringBuilder outline17 = GeneratedOutlineSupport.outline17("Expected leading [0-9a-fA-F] character but was 0x");
                            outline17.append(Integer.toHexString(b));
                            throw new NumberFormatException(outline17.toString());
                        }
                        i = i2 + 10;
                    } else {
                        i = b - 48;
                    }
                    if ((-1152921504606846976L & j) == 0) {
                        j = (j << 4) | ((long) i);
                        i4++;
                        i3++;
                    } else {
                        Buffer writeHexadecimalUnsignedLong = new Buffer().writeHexadecimalUnsignedLong(j);
                        writeHexadecimalUnsignedLong.writeByte((int) b);
                        StringBuilder outline172 = GeneratedOutlineSupport.outline17("Number too large: ");
                        outline172.append(writeHexadecimalUnsignedLong.readUtf8());
                        throw new NumberFormatException(outline172.toString());
                    }
                }
                if (i3 == 0) {
                }
            } while (this.head != null);
            this.size -= (long) i3;
            return j;
        }
        throw new IllegalStateException("size == 0");
    }

    @Override // okio.BufferedSource
    public int readInt() {
        long j = this.size;
        if (j >= 4) {
            Segment segment = this.head;
            int i = segment.pos;
            int i2 = segment.limit;
            if (i2 - i < 4) {
                return ((readByte() & 255) << 24) | ((readByte() & 255) << 16) | ((readByte() & 255) << 8) | (readByte() & 255);
            }
            byte[] bArr = segment.data;
            int i3 = i + 1;
            int i4 = i3 + 1;
            int i5 = ((bArr[i] & 255) << 24) | ((bArr[i3] & 255) << 16);
            int i6 = i4 + 1;
            int i7 = i5 | ((bArr[i4] & 255) << 8);
            int i8 = i6 + 1;
            int i9 = i7 | (bArr[i6] & 255);
            this.size = j - 4;
            if (i8 == i2) {
                this.head = segment.pop();
                SegmentPool.recycle(segment);
            } else {
                segment.pos = i8;
            }
            return i9;
        }
        StringBuilder outline17 = GeneratedOutlineSupport.outline17("size < 4: ");
        outline17.append(this.size);
        throw new IllegalStateException(outline17.toString());
    }

    @Override // okio.BufferedSource
    public int readIntLe() {
        return Util.reverseBytesInt(readInt());
    }

    @Override // okio.BufferedSource
    public long readLong() {
        long j = this.size;
        if (j >= 8) {
            Segment segment = this.head;
            int i = segment.pos;
            int i2 = segment.limit;
            if (i2 - i < 8) {
                return ((((long) readInt()) & 4294967295L) << 32) | (4294967295L & ((long) readInt()));
            }
            byte[] bArr = segment.data;
            int i3 = i + 1;
            int i4 = i3 + 1;
            long j2 = (((long) bArr[i3]) & 255) << 48;
            int i5 = i4 + 1;
            int i6 = i5 + 1;
            int i7 = i6 + 1;
            int i8 = i7 + 1;
            int i9 = i8 + 1;
            int i10 = i9 + 1;
            long j3 = (((long) bArr[i9]) & 255) | j2 | ((((long) bArr[i]) & 255) << 56) | ((((long) bArr[i4]) & 255) << 40) | ((((long) bArr[i5]) & 255) << 32) | ((((long) bArr[i6]) & 255) << 24) | ((((long) bArr[i7]) & 255) << 16) | ((((long) bArr[i8]) & 255) << 8);
            this.size = j - 8;
            if (i10 == i2) {
                this.head = segment.pop();
                SegmentPool.recycle(segment);
            } else {
                segment.pos = i10;
            }
            return j3;
        }
        StringBuilder outline17 = GeneratedOutlineSupport.outline17("size < 8: ");
        outline17.append(this.size);
        throw new IllegalStateException(outline17.toString());
    }

    @Override // okio.BufferedSource
    public short readShort() {
        long j = this.size;
        if (j >= 2) {
            Segment segment = this.head;
            int i = segment.pos;
            int i2 = segment.limit;
            if (i2 - i < 2) {
                return (short) (((readByte() & 255) << 8) | (readByte() & 255));
            }
            byte[] bArr = segment.data;
            int i3 = i + 1;
            int i4 = i3 + 1;
            int i5 = ((bArr[i] & 255) << 8) | (bArr[i3] & 255);
            this.size = j - 2;
            if (i4 == i2) {
                this.head = segment.pop();
                SegmentPool.recycle(segment);
            } else {
                segment.pos = i4;
            }
            return (short) i5;
        }
        StringBuilder outline17 = GeneratedOutlineSupport.outline17("size < 2: ");
        outline17.append(this.size);
        throw new IllegalStateException(outline17.toString());
    }

    @Override // okio.BufferedSource
    public short readShortLe() {
        return Util.reverseBytesShort(readShort());
    }

    @Override // okio.BufferedSource
    public String readString(Charset charset) {
        try {
            return readString(this.size, charset);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    @Override // okio.BufferedSource
    public String readUtf8() {
        try {
            return readString(this.size, Util.UTF_8);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public int readUtf8CodePoint() throws EOFException {
        int i;
        int i2;
        int i3;
        if (this.size != 0) {
            byte b = getByte(0);
            if ((b & 128) == 0) {
                i3 = b & Byte.MAX_VALUE;
                i = 0;
                i2 = 1;
            } else if ((b & 224) == 192) {
                i3 = b & 31;
                i2 = 2;
                i = 128;
            } else if ((b & 240) == 224) {
                i3 = b & 15;
                i2 = 3;
                i = 2048;
            } else if ((b & 248) == 240) {
                i3 = b & 7;
                i2 = 4;
                i = AsyncTimeout.TIMEOUT_WRITE_SIZE;
            } else {
                skip(1);
                return 65533;
            }
            long j = (long) i2;
            if (this.size >= j) {
                for (int i4 = 1; i4 < i2; i4++) {
                    long j2 = (long) i4;
                    byte b2 = getByte(j2);
                    if ((b2 & 192) == 128) {
                        i3 = (i3 << 6) | (b2 & 63);
                    } else {
                        skip(j2);
                        return 65533;
                    }
                }
                skip(j);
                if (i3 > 1114111) {
                    return 65533;
                }
                if ((i3 < 55296 || i3 > 57343) && i3 >= i) {
                    return i3;
                }
                return 65533;
            }
            StringBuilder outline18 = GeneratedOutlineSupport.outline18("size < ", i2, ": ");
            outline18.append(this.size);
            outline18.append(" (to read code point prefixed 0x");
            outline18.append(Integer.toHexString(b));
            outline18.append(")");
            throw new EOFException(outline18.toString());
        }
        throw new EOFException();
    }

    public String readUtf8Line(long j) throws EOFException {
        if (j > 0) {
            long j2 = j - 1;
            if (getByte(j2) == 13) {
                String readUtf8 = readUtf8(j2);
                skip(2);
                return readUtf8;
            }
        }
        String readUtf82 = readUtf8(j);
        skip(1);
        return readUtf82;
    }

    @Override // okio.BufferedSource
    public String readUtf8LineStrict() throws EOFException {
        return readUtf8LineStrict(RecyclerView.FOREVER_NS);
    }

    @Override // okio.BufferedSource
    public boolean request(long j) {
        return this.size >= j;
    }

    @Override // okio.BufferedSource
    public void require(long j) throws EOFException {
        if (this.size < j) {
            throw new EOFException();
        }
    }

    @Override // okio.BufferedSource
    public int select(Options options) {
        int selectPrefix = selectPrefix(options, false);
        if (selectPrefix == -1) {
            return -1;
        }
        try {
            skip((long) options.byteStrings[selectPrefix].size());
            return selectPrefix;
        } catch (EOFException unused) {
            throw new AssertionError();
        }
    }

    public int selectPrefix(Options options, boolean z) {
        int i;
        int i2;
        int i3;
        Segment segment;
        int i4;
        Segment segment2 = this.head;
        int i5 = -2;
        if (segment2 != null) {
            byte[] bArr = segment2.data;
            int i6 = segment2.pos;
            int i7 = segment2.limit;
            int[] iArr = options.trie;
            Segment segment3 = segment2;
            int i8 = 0;
            int i9 = -1;
            loop0:
            while (true) {
                int i10 = i8 + 1;
                int i11 = iArr[i8];
                int i12 = i10 + 1;
                int i13 = iArr[i10];
                if (i13 != -1) {
                    i9 = i13;
                }
                if (segment3 == null) {
                    break;
                }
                if (i11 < 0) {
                    int i14 = (i11 * -1) + i12;
                    while (true) {
                        int i15 = i6 + 1;
                        int i16 = i12 + 1;
                        if ((bArr[i6] & 255) != iArr[i12]) {
                            return i9;
                        }
                        boolean z2 = i16 == i14;
                        if (i15 == i7) {
                            Segment segment4 = segment3.next;
                            i4 = segment4.pos;
                            byte[] bArr2 = segment4.data;
                            i3 = segment4.limit;
                            if (segment4 != segment2) {
                                segment = segment4;
                                bArr = bArr2;
                            } else if (!z2) {
                                break loop0;
                            } else {
                                bArr = bArr2;
                                segment = null;
                            }
                        } else {
                            i3 = i7;
                            i4 = i15;
                            segment = segment3;
                        }
                        if (z2) {
                            i = iArr[i16];
                            i2 = i4;
                            i7 = i3;
                            segment3 = segment;
                            break;
                        }
                        i6 = i4;
                        i7 = i3;
                        i12 = i16;
                        segment3 = segment;
                    }
                } else {
                    int i17 = i6 + 1;
                    int i18 = bArr[i6] & 255;
                    int i19 = i12 + i11;
                    while (i12 != i19) {
                        if (i18 == iArr[i12]) {
                            i = iArr[i12 + i11];
                            if (i17 == i7) {
                                segment3 = segment3.next;
                                i2 = segment3.pos;
                                bArr = segment3.data;
                                i7 = segment3.limit;
                                if (segment3 == segment2) {
                                    segment3 = null;
                                }
                            } else {
                                i2 = i17;
                            }
                        } else {
                            i12++;
                        }
                    }
                    return i9;
                }
                if (i >= 0) {
                    return i;
                }
                i8 = -i;
                i6 = i2;
                i5 = -2;
            }
            return z ? i5 : i9;
        } else if (z) {
            return -2;
        } else {
            return options.indexOf(ByteString.EMPTY);
        }
    }

    @Override // okio.BufferedSource
    public void skip(long j) throws EOFException {
        while (j > 0) {
            Segment segment = this.head;
            if (segment != null) {
                int min = (int) Math.min(j, (long) (segment.limit - segment.pos));
                long j2 = (long) min;
                this.size -= j2;
                j -= j2;
                Segment segment2 = this.head;
                int i = segment2.pos + min;
                segment2.pos = i;
                if (i == segment2.limit) {
                    this.head = segment2.pop();
                    SegmentPool.recycle(segment2);
                }
            } else {
                throw new EOFException();
            }
        }
    }

    @Override // okio.Source, okio.Sink
    public Timeout timeout() {
        return Timeout.NONE;
    }

    public String toString() {
        ByteString byteString;
        long j = this.size;
        if (j <= 2147483647L) {
            int i = (int) j;
            if (i == 0) {
                byteString = ByteString.EMPTY;
            } else {
                byteString = new SegmentedByteString(this, i);
            }
            return byteString.toString();
        }
        StringBuilder outline17 = GeneratedOutlineSupport.outline17("size > Integer.MAX_VALUE: ");
        outline17.append(this.size);
        throw new IllegalArgumentException(outline17.toString());
    }

    public Segment writableSegment(int i) {
        if (i < 1 || i > 8192) {
            throw new IllegalArgumentException();
        }
        Segment segment = this.head;
        if (segment == null) {
            Segment take = SegmentPool.take();
            this.head = take;
            take.prev = take;
            take.next = take;
            return take;
        }
        Segment segment2 = segment.prev;
        if (segment2.limit + i <= 8192 && segment2.owner) {
            return segment2;
        }
        Segment take2 = SegmentPool.take();
        segment2.push(take2);
        return take2;
    }

    @Override // okio.BufferedSink
    public long writeAll(Source source) throws IOException {
        if (source != null) {
            long j = 0;
            while (true) {
                long read = source.read(this, 8192);
                if (read == -1) {
                    return j;
                }
                j += read;
            }
        } else {
            throw new IllegalArgumentException("source == null");
        }
    }

    public Buffer writeLong(long j) {
        Segment writableSegment = writableSegment(8);
        byte[] bArr = writableSegment.data;
        int i = writableSegment.limit;
        int i2 = i + 1;
        bArr[i] = (byte) ((int) ((j >>> 56) & 255));
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((int) ((j >>> 48) & 255));
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((int) ((j >>> 40) & 255));
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((int) ((j >>> 32) & 255));
        int i6 = i5 + 1;
        bArr[i5] = (byte) ((int) ((j >>> 24) & 255));
        int i7 = i6 + 1;
        bArr[i6] = (byte) ((int) ((j >>> 16) & 255));
        int i8 = i7 + 1;
        bArr[i7] = (byte) ((int) ((j >>> 8) & 255));
        bArr[i8] = (byte) ((int) (j & 255));
        writableSegment.limit = i8 + 1;
        this.size += 8;
        return this;
    }

    public Buffer writeString(String str, int i, int i2, Charset charset) {
        if (i < 0) {
            throw new IllegalAccessError(GeneratedOutlineSupport.outline5("beginIndex < 0: ", i));
        } else if (i2 < i) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
        } else if (i2 > str.length()) {
            StringBuilder outline18 = GeneratedOutlineSupport.outline18("endIndex > string.length: ", i2, " > ");
            outline18.append(str.length());
            throw new IllegalArgumentException(outline18.toString());
        } else if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        } else if (charset.equals(Util.UTF_8)) {
            writeUtf8(str, i, i2);
            return this;
        } else {
            byte[] bytes = str.substring(i, i2).getBytes(charset);
            write(bytes, 0, bytes.length);
            return this;
        }
    }

    public Buffer writeUtf8CodePoint(int i) {
        if (i < 128) {
            writeByte(i);
        } else if (i < 2048) {
            writeByte((i >> 6) | 192);
            writeByte((i & 63) | 128);
        } else if (i < 65536) {
            if (i < 55296 || i > 57343) {
                writeByte((i >> 12) | 224);
                writeByte(((i >> 6) & 63) | 128);
                writeByte((i & 63) | 128);
            } else {
                writeByte(63);
            }
        } else if (i <= 1114111) {
            writeByte((i >> 18) | 240);
            writeByte(((i >> 12) & 63) | 128);
            writeByte(((i >> 6) & 63) | 128);
            writeByte((i & 63) | 128);
        } else {
            StringBuilder outline17 = GeneratedOutlineSupport.outline17("Unexpected code point: ");
            outline17.append(Integer.toHexString(i));
            throw new IllegalArgumentException(outline17.toString());
        }
        return this;
    }

    @Override // java.lang.Object
    public Buffer clone() {
        Buffer buffer = new Buffer();
        if (this.size == 0) {
            return buffer;
        }
        Segment sharedCopy = this.head.sharedCopy();
        buffer.head = sharedCopy;
        sharedCopy.prev = sharedCopy;
        sharedCopy.next = sharedCopy;
        Segment segment = this.head;
        while (true) {
            segment = segment.next;
            if (segment != this.head) {
                buffer.head.prev.push(segment.sharedCopy());
            } else {
                buffer.size = this.size;
                return buffer;
            }
        }
    }

    public long indexOf(byte b, long j, long j2) {
        Segment segment;
        long j3 = 0;
        if (j < 0 || j2 < j) {
            throw new IllegalArgumentException(String.format("size=%s fromIndex=%s toIndex=%s", Long.valueOf(this.size), Long.valueOf(j), Long.valueOf(j2)));
        }
        long j4 = this.size;
        if (j2 <= j4) {
            j4 = j2;
        }
        if (j == j4 || (segment = this.head) == null) {
            return -1;
        }
        long j5 = this.size;
        if (j5 - j < j) {
            while (j5 > j) {
                segment = segment.prev;
                j5 -= (long) (segment.limit - segment.pos);
            }
        } else {
            while (true) {
                long j6 = ((long) (segment.limit - segment.pos)) + j3;
                if (j6 >= j) {
                    break;
                }
                segment = segment.next;
                j3 = j6;
            }
            j5 = j3;
        }
        long j7 = j;
        while (j5 < j4) {
            byte[] bArr = segment.data;
            int min = (int) Math.min((long) segment.limit, (((long) segment.pos) + j4) - j5);
            for (int i = (int) ((((long) segment.pos) + j7) - j5); i < min; i++) {
                if (bArr[i] == b) {
                    return ((long) (i - segment.pos)) + j5;
                }
            }
            j5 += (long) (segment.limit - segment.pos);
            segment = segment.next;
            j7 = j5;
        }
        return -1;
    }

    @Override // okio.BufferedSource
    public ByteString readByteString(long j) throws EOFException {
        return new ByteString(readByteArray(j));
    }

    @Override // okio.BufferedSource
    public String readUtf8LineStrict(long j) throws EOFException {
        if (j >= 0) {
            long j2 = RecyclerView.FOREVER_NS;
            if (j != RecyclerView.FOREVER_NS) {
                j2 = j + 1;
            }
            long indexOf = indexOf((byte) 10, 0, j2);
            if (indexOf != -1) {
                return readUtf8Line(indexOf);
            }
            if (j2 < this.size && getByte(j2 - 1) == 13 && getByte(j2) == 10) {
                return readUtf8Line(j2);
            }
            Buffer buffer = new Buffer();
            copyTo(buffer, 0, Math.min(32L, this.size));
            StringBuilder outline17 = GeneratedOutlineSupport.outline17("\\n not found: limit=");
            outline17.append(Math.min(this.size, j));
            outline17.append(" content=");
            outline17.append(buffer.readByteString().hex());
            outline17.append((char) 8230);
            throw new EOFException(outline17.toString());
        }
        throw new IllegalArgumentException(GeneratedOutlineSupport.outline7("limit < 0: ", j));
    }

    @Override // okio.BufferedSink
    public Buffer writeByte(int i) {
        Segment writableSegment = writableSegment(1);
        byte[] bArr = writableSegment.data;
        int i2 = writableSegment.limit;
        writableSegment.limit = i2 + 1;
        bArr[i2] = (byte) i;
        this.size++;
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer writeDecimalLong(long j) {
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i == 0) {
            writeByte(48);
            return this;
        }
        boolean z = false;
        int i2 = 1;
        if (i < 0) {
            j = -j;
            if (j < 0) {
                writeUtf8("-9223372036854775808");
                return this;
            }
            z = true;
        }
        if (j >= 100000000) {
            i2 = j < 1000000000000L ? j < 10000000000L ? j < Http2Connection.DEGRADED_PONG_TIMEOUT_NS ? 9 : 10 : j < 100000000000L ? 11 : 12 : j < 1000000000000000L ? j < 10000000000000L ? 13 : j < 100000000000000L ? 14 : 15 : j < 100000000000000000L ? j < 10000000000000000L ? 16 : 17 : j < 1000000000000000000L ? 18 : 19;
        } else if (j >= 10000) {
            i2 = j < 1000000 ? j < 100000 ? 5 : 6 : j < 10000000 ? 7 : 8;
        } else if (j >= 100) {
            i2 = j < 1000 ? 3 : 4;
        } else if (j >= 10) {
            i2 = 2;
        }
        if (z) {
            i2++;
        }
        Segment writableSegment = writableSegment(i2);
        byte[] bArr = writableSegment.data;
        int i3 = writableSegment.limit + i2;
        while (j != 0) {
            i3--;
            bArr[i3] = DIGITS[(int) (j % 10)];
            j /= 10;
        }
        if (z) {
            bArr[i3 - 1] = 45;
        }
        writableSegment.limit += i2;
        this.size += (long) i2;
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer writeHexadecimalUnsignedLong(long j) {
        if (j == 0) {
            writeByte(48);
            return this;
        }
        int numberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j)) / 4) + 1;
        Segment writableSegment = writableSegment(numberOfTrailingZeros);
        byte[] bArr = writableSegment.data;
        int i = writableSegment.limit;
        for (int i2 = (i + numberOfTrailingZeros) - 1; i2 >= i; i2--) {
            bArr[i2] = DIGITS[(int) (15 & j)];
            j >>>= 4;
        }
        writableSegment.limit += numberOfTrailingZeros;
        this.size += (long) numberOfTrailingZeros;
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer writeInt(int i) {
        Segment writableSegment = writableSegment(4);
        byte[] bArr = writableSegment.data;
        int i2 = writableSegment.limit;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 24) & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i >>> 16) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((i >>> 8) & 255);
        bArr[i5] = (byte) (i & 255);
        writableSegment.limit = i5 + 1;
        this.size += 4;
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer writeShort(int i) {
        Segment writableSegment = writableSegment(2);
        byte[] bArr = writableSegment.data;
        int i2 = writableSegment.limit;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        bArr[i3] = (byte) (i & 255);
        writableSegment.limit = i3 + 1;
        this.size += 2;
        return this;
    }

    @Override // okio.BufferedSink
    public Buffer writeUtf8(String str) {
        writeUtf8(str, 0, str.length());
        return this;
    }

    @Override // okio.BufferedSource
    public byte[] readByteArray(long j) throws EOFException {
        Util.checkOffsetAndCount(this.size, 0, j);
        if (j <= 2147483647L) {
            byte[] bArr = new byte[((int) j)];
            readFully(bArr);
            return bArr;
        }
        throw new IllegalArgumentException(GeneratedOutlineSupport.outline7("byteCount > Integer.MAX_VALUE: ", j));
    }

    public String readString(long j, Charset charset) throws EOFException {
        Util.checkOffsetAndCount(this.size, 0, j);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        } else if (j > 2147483647L) {
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline7("byteCount > Integer.MAX_VALUE: ", j));
        } else if (j == 0) {
            return "";
        } else {
            Segment segment = this.head;
            if (((long) segment.pos) + j > ((long) segment.limit)) {
                return new String(readByteArray(j), charset);
            }
            String str = new String(segment.data, segment.pos, (int) j, charset);
            int i = (int) (((long) segment.pos) + j);
            segment.pos = i;
            this.size -= j;
            if (i == segment.limit) {
                this.head = segment.pop();
                SegmentPool.recycle(segment);
            }
            return str;
        }
    }

    public String readUtf8(long j) throws EOFException {
        return readString(j, Util.UTF_8);
    }

    public Buffer writeUtf8(String str, int i, int i2) {
        char charAt;
        if (i < 0) {
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline5("beginIndex < 0: ", i));
        } else if (i2 < i) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
        } else if (i2 <= str.length()) {
            while (i < i2) {
                char charAt2 = str.charAt(i);
                if (charAt2 < 128) {
                    Segment writableSegment = writableSegment(1);
                    byte[] bArr = writableSegment.data;
                    int i3 = writableSegment.limit - i;
                    int min = Math.min(i2, 8192 - i3);
                    int i4 = i + 1;
                    bArr[i + i3] = (byte) charAt2;
                    while (true) {
                        i = i4;
                        if (i >= min || (charAt = str.charAt(i)) >= 128) {
                            int i5 = writableSegment.limit;
                            int i6 = (i3 + i) - i5;
                            writableSegment.limit = i5 + i6;
                            this.size += (long) i6;
                        } else {
                            i4 = i + 1;
                            bArr[i + i3] = (byte) charAt;
                        }
                    }
                    int i52 = writableSegment.limit;
                    int i62 = (i3 + i) - i52;
                    writableSegment.limit = i52 + i62;
                    this.size += (long) i62;
                } else {
                    if (charAt2 < 2048) {
                        writeByte((charAt2 >> 6) | 192);
                        writeByte((charAt2 & '?') | 128);
                    } else if (charAt2 < 55296 || charAt2 > 57343) {
                        writeByte((charAt2 >> '\f') | 224);
                        writeByte(((charAt2 >> 6) & 63) | 128);
                        writeByte((charAt2 & '?') | 128);
                    } else {
                        int i7 = i + 1;
                        char charAt3 = i7 < i2 ? str.charAt(i7) : 0;
                        if (charAt2 > 56319 || charAt3 < 56320 || charAt3 > 57343) {
                            writeByte(63);
                            i = i7;
                        } else {
                            int i8 = (((charAt2 & 10239) << 10) | (9215 & charAt3)) + AsyncTimeout.TIMEOUT_WRITE_SIZE;
                            writeByte((i8 >> 18) | 240);
                            writeByte(((i8 >> 12) & 63) | 128);
                            writeByte(((i8 >> 6) & 63) | 128);
                            writeByte((i8 & 63) | 128);
                            i += 2;
                        }
                    }
                    i++;
                }
            }
            return this;
        } else {
            StringBuilder outline18 = GeneratedOutlineSupport.outline18("endIndex > string.length: ", i2, " > ");
            outline18.append(str.length());
            throw new IllegalArgumentException(outline18.toString());
        }
    }

    @Override // okio.BufferedSink
    public Buffer write(ByteString byteString) {
        if (byteString != null) {
            byteString.write(this);
            return this;
        }
        throw new IllegalArgumentException("byteString == null");
    }

    @Override // okio.BufferedSource
    public void readFully(byte[] bArr) throws EOFException {
        int i = 0;
        while (i < bArr.length) {
            int read = read(bArr, i, bArr.length - i);
            if (read != -1) {
                i += read;
            } else {
                throw new EOFException();
            }
        }
    }

    @Override // okio.BufferedSink
    public Buffer write(byte[] bArr) {
        if (bArr != null) {
            write(bArr, 0, bArr.length);
            return this;
        }
        throw new IllegalArgumentException("source == null");
    }

    @Override // okio.BufferedSink
    public Buffer write(byte[] bArr, int i, int i2) {
        if (bArr != null) {
            long j = (long) i2;
            Util.checkOffsetAndCount((long) bArr.length, (long) i, j);
            int i3 = i2 + i;
            while (i < i3) {
                Segment writableSegment = writableSegment(1);
                int min = Math.min(i3 - i, 8192 - writableSegment.limit);
                System.arraycopy(bArr, i, writableSegment.data, writableSegment.limit, min);
                i += min;
                writableSegment.limit += min;
            }
            this.size += j;
            return this;
        }
        throw new IllegalArgumentException("source == null");
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        Segment segment = this.head;
        if (segment == null) {
            return -1;
        }
        int min = Math.min(byteBuffer.remaining(), segment.limit - segment.pos);
        byteBuffer.put(segment.data, segment.pos, min);
        int i = segment.pos + min;
        segment.pos = i;
        this.size -= (long) min;
        if (i == segment.limit) {
            this.head = segment.pop();
            SegmentPool.recycle(segment);
        }
        return min;
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer != null) {
            int remaining = byteBuffer.remaining();
            int i = remaining;
            while (i > 0) {
                Segment writableSegment = writableSegment(1);
                int min = Math.min(i, 8192 - writableSegment.limit);
                byteBuffer.get(writableSegment.data, writableSegment.limit, min);
                i -= min;
                writableSegment.limit += min;
            }
            this.size += (long) remaining;
            return remaining;
        }
        throw new IllegalArgumentException("source == null");
    }

    public long indexOf(ByteString byteString, long j) throws IOException {
        int i;
        boolean z;
        Segment segment;
        if (byteString.size() != 0) {
            long j2 = 0;
            if (j >= 0) {
                Segment segment2 = this.head;
                long j3 = -1;
                if (segment2 == null) {
                    return -1;
                }
                long j4 = this.size;
                if (j4 - j < j) {
                    while (j4 > j) {
                        segment2 = segment2.prev;
                        j4 -= (long) (segment2.limit - segment2.pos);
                    }
                } else {
                    while (true) {
                        long j5 = ((long) (segment2.limit - segment2.pos)) + j2;
                        if (j5 >= j) {
                            break;
                        }
                        segment2 = segment2.next;
                        j2 = j5;
                    }
                    j4 = j2;
                }
                byte b = byteString.getByte(0);
                int size2 = byteString.size();
                long j6 = (this.size - ((long) size2)) + 1;
                long j7 = j4;
                long j8 = j;
                while (j7 < j6) {
                    byte[] bArr = segment2.data;
                    byte b2 = b;
                    int min = (int) Math.min((long) segment2.limit, (((long) segment2.pos) + j6) - j7);
                    int i2 = (int) ((((long) segment2.pos) + j8) - j7);
                    while (i2 < min) {
                        if (bArr[i2] == b2) {
                            int i3 = i2 + 1;
                            int i4 = segment2.limit;
                            byte[] bArr2 = segment2.data;
                            Segment segment3 = segment2;
                            int i5 = 1;
                            while (true) {
                                if (i5 >= size2) {
                                    i = min;
                                    z = true;
                                    break;
                                }
                                if (i3 == i4) {
                                    Segment segment4 = segment3.next;
                                    byte[] bArr3 = segment4.data;
                                    segment = segment4;
                                    bArr2 = bArr3;
                                    i3 = segment4.pos;
                                    i4 = segment4.limit;
                                } else {
                                    segment = segment3;
                                }
                                i = min;
                                if (bArr2[i3] != byteString.getByte(i5)) {
                                    z = false;
                                    break;
                                }
                                i3++;
                                i5++;
                                segment3 = segment;
                                min = i;
                            }
                            if (z) {
                                return ((long) (i2 - segment2.pos)) + j7;
                            }
                        } else {
                            i = min;
                        }
                        i2++;
                        min = i;
                        b2 = b2;
                    }
                    j7 += (long) (segment2.limit - segment2.pos);
                    segment2 = segment2.next;
                    b = b2;
                    j8 = j7;
                    j3 = -1;
                }
                return j3;
            }
            throw new IllegalArgumentException("fromIndex < 0");
        }
        throw new IllegalArgumentException("bytes is empty");
    }

    @Override // okio.Source
    public long read(Buffer buffer, long j) {
        if (buffer == null) {
            throw new IllegalArgumentException("sink == null");
        } else if (j >= 0) {
            long j2 = this.size;
            if (j2 == 0) {
                return -1;
            }
            if (j > j2) {
                j = j2;
            }
            buffer.write(this, j);
            return j;
        } else {
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline7("byteCount < 0: ", j));
        }
    }

    @Override // okio.Sink
    public void write(Buffer buffer, long j) {
        Segment segment;
        int i;
        if (buffer == null) {
            throw new IllegalArgumentException("source == null");
        } else if (buffer != this) {
            Util.checkOffsetAndCount(buffer.size, 0, j);
            while (j > 0) {
                Segment segment2 = buffer.head;
                int i2 = 0;
                if (j < ((long) (segment2.limit - segment2.pos))) {
                    Segment segment3 = this.head;
                    Segment segment4 = segment3 != null ? segment3.prev : null;
                    if (segment4 != null && segment4.owner) {
                        long j2 = ((long) segment4.limit) + j;
                        if (segment4.shared) {
                            i = 0;
                        } else {
                            i = segment4.pos;
                        }
                        if (j2 - ((long) i) <= 8192) {
                            buffer.head.writeTo(segment4, (int) j);
                            buffer.size -= j;
                            this.size += j;
                            return;
                        }
                    }
                    Segment segment5 = buffer.head;
                    int i3 = (int) j;
                    if (segment5 == null) {
                        throw null;
                    } else if (i3 <= 0 || i3 > segment5.limit - segment5.pos) {
                        throw new IllegalArgumentException();
                    } else {
                        if (i3 >= 1024) {
                            segment = segment5.sharedCopy();
                        } else {
                            segment = SegmentPool.take();
                            System.arraycopy(segment5.data, segment5.pos, segment.data, 0, i3);
                        }
                        segment.limit = segment.pos + i3;
                        segment5.pos += i3;
                        segment5.prev.push(segment);
                        buffer.head = segment;
                    }
                }
                Segment segment6 = buffer.head;
                long j3 = (long) (segment6.limit - segment6.pos);
                buffer.head = segment6.pop();
                Segment segment7 = this.head;
                if (segment7 == null) {
                    this.head = segment6;
                    segment6.prev = segment6;
                    segment6.next = segment6;
                } else {
                    segment7.prev.push(segment6);
                    Segment segment8 = segment6.prev;
                    if (segment8 == segment6) {
                        throw new IllegalStateException();
                    } else if (segment8.owner) {
                        int i4 = segment6.limit - segment6.pos;
                        int i5 = 8192 - segment8.limit;
                        if (!segment8.shared) {
                            i2 = segment8.pos;
                        }
                        if (i4 <= i5 + i2) {
                            segment6.writeTo(segment6.prev, i4);
                            segment6.pop();
                            SegmentPool.recycle(segment6);
                        }
                    }
                }
                buffer.size -= j3;
                this.size += j3;
                j -= j3;
            }
        } else {
            throw new IllegalArgumentException("source == this");
        }
    }
}
