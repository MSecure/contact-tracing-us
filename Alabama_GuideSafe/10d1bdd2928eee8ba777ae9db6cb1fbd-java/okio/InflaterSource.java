package okio;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.bridge.ColorPropConverter;
import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

public final class InflaterSource implements Source {
    public int bufferBytesHeldByInflater;
    public boolean closed;
    public final Inflater inflater;
    public final BufferedSource source;

    public InflaterSource(BufferedSource bufferedSource, Inflater inflater2) {
        if (inflater2 != null) {
            this.source = bufferedSource;
            this.inflater = inflater2;
            return;
        }
        throw new IllegalArgumentException("inflater == null");
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.closed) {
            this.inflater.end();
            this.closed = true;
            this.source.close();
        }
    }

    @Override // okio.Source
    public long read(Buffer buffer, long j) throws IOException {
        Segment writableSegment;
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i < 0) {
            throw new IllegalArgumentException(GeneratedOutlineSupport.outline7("byteCount < 0: ", j));
        } else if (this.closed) {
            throw new IllegalStateException("closed");
        } else if (i == 0) {
            return 0;
        } else {
            while (true) {
                boolean z = false;
                if (this.inflater.needsInput()) {
                    releaseInflatedBytes();
                    if (this.inflater.getRemaining() != 0) {
                        throw new IllegalStateException(ColorPropConverter.PREFIX_ATTR);
                    } else if (this.source.exhausted()) {
                        z = true;
                    } else {
                        Segment segment = this.source.buffer().head;
                        int i2 = segment.limit;
                        int i3 = segment.pos;
                        int i4 = i2 - i3;
                        this.bufferBytesHeldByInflater = i4;
                        this.inflater.setInput(segment.data, i3, i4);
                    }
                }
                try {
                    writableSegment = buffer.writableSegment(1);
                    int inflate = this.inflater.inflate(writableSegment.data, writableSegment.limit, (int) Math.min(j, (long) (8192 - writableSegment.limit)));
                    if (inflate > 0) {
                        writableSegment.limit += inflate;
                        long j2 = (long) inflate;
                        buffer.size += j2;
                        return j2;
                    } else if (this.inflater.finished()) {
                        break;
                    } else if (this.inflater.needsDictionary()) {
                        break;
                    } else if (z) {
                        throw new EOFException("source exhausted prematurely");
                    }
                } catch (DataFormatException e) {
                    throw new IOException(e);
                }
            }
            releaseInflatedBytes();
            if (writableSegment.pos != writableSegment.limit) {
                return -1;
            }
            buffer.head = writableSegment.pop();
            SegmentPool.recycle(writableSegment);
            return -1;
        }
    }

    public final void releaseInflatedBytes() throws IOException {
        int i = this.bufferBytesHeldByInflater;
        if (i != 0) {
            int remaining = i - this.inflater.getRemaining();
            this.bufferBytesHeldByInflater -= remaining;
            this.source.skip((long) remaining);
        }
    }

    @Override // okio.Source
    public Timeout timeout() {
        return this.source.timeout();
    }
}
