package okio;

import java.io.IOException;

public final class PeekSource implements Source {
    public final Buffer buffer;
    public boolean closed;
    public int expectedPos;
    public Segment expectedSegment;
    public long pos;
    public final BufferedSource upstream;

    public PeekSource(BufferedSource bufferedSource) {
        this.upstream = bufferedSource;
        Buffer buffer2 = bufferedSource.buffer();
        this.buffer = buffer2;
        Segment segment = buffer2.head;
        this.expectedSegment = segment;
        this.expectedPos = segment != null ? segment.pos : -1;
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.closed = true;
    }

    @Override // okio.Source
    public long read(Buffer buffer2, long j) throws IOException {
        Segment segment;
        Segment segment2;
        if (!this.closed) {
            Segment segment3 = this.expectedSegment;
            if (segment3 == null || (segment3 == (segment2 = this.buffer.head) && this.expectedPos == segment2.pos)) {
                this.upstream.request(this.pos + j);
                if (this.expectedSegment == null && (segment = this.buffer.head) != null) {
                    this.expectedSegment = segment;
                    this.expectedPos = segment.pos;
                }
                long min = Math.min(j, this.buffer.size - this.pos);
                if (min <= 0) {
                    return -1;
                }
                this.buffer.copyTo(buffer2, this.pos, min);
                this.pos += min;
                return min;
            }
            throw new IllegalStateException("Peek source is invalid because upstream source was used");
        }
        throw new IllegalStateException("closed");
    }

    @Override // okio.Source
    public Timeout timeout() {
        return this.upstream.timeout();
    }
}
