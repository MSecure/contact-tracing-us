package com.facebook.react.devsupport;

import com.android.tools.r8.GeneratedOutlineSupport;
import com.facebook.react.bridge.ColorPropConverter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;

public class MultipartStreamReader {
    public static final String CRLF = "\r\n";
    public final String mBoundary;
    public long mLastProgressEvent;
    public final BufferedSource mSource;

    public interface ChunkListener {
        void onChunkComplete(Map<String, String> map, Buffer buffer, boolean z) throws IOException;

        void onChunkProgress(Map<String, String> map, long j, long j2) throws IOException;
    }

    public MultipartStreamReader(BufferedSource bufferedSource, String str) {
        this.mSource = bufferedSource;
        this.mBoundary = str;
    }

    private void emitChunk(Buffer buffer, boolean z, ChunkListener chunkListener) throws IOException {
        ByteString encodeUtf8 = ByteString.encodeUtf8("\r\n\r\n");
        long indexOf = buffer.indexOf(encodeUtf8, 0);
        if (indexOf == -1) {
            chunkListener.onChunkComplete(null, buffer, z);
            return;
        }
        Buffer buffer2 = new Buffer();
        Buffer buffer3 = new Buffer();
        buffer.read(buffer2, indexOf);
        buffer.skip((long) encodeUtf8.data.length);
        long j = buffer.size;
        if (j > 0) {
            buffer3.write(buffer, j);
        }
        chunkListener.onChunkComplete(parseHeaders(buffer2), buffer3, z);
    }

    private void emitProgress(Map<String, String> map, long j, boolean z, ChunkListener chunkListener) throws IOException {
        if (map != null && chunkListener != null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.mLastProgressEvent > 16 || z) {
                this.mLastProgressEvent = currentTimeMillis;
                chunkListener.onChunkProgress(map, j, map.get("Content-Length") != null ? Long.parseLong(map.get("Content-Length")) : 0);
            }
        }
    }

    private Map<String, String> parseHeaders(Buffer buffer) {
        HashMap hashMap = new HashMap();
        String[] split = buffer.readUtf8().split(CRLF);
        for (String str : split) {
            int indexOf = str.indexOf(ColorPropConverter.PACKAGE_DELIMITER);
            if (indexOf != -1) {
                hashMap.put(str.substring(0, indexOf).trim(), str.substring(indexOf + 1).trim());
            }
        }
        return hashMap;
    }

    public boolean readAllParts(ChunkListener chunkListener) throws IOException {
        boolean z;
        boolean z2;
        long j;
        StringBuilder outline17 = GeneratedOutlineSupport.outline17("\r\n--");
        outline17.append(this.mBoundary);
        outline17.append(CRLF);
        ByteString encodeUtf8 = ByteString.encodeUtf8(outline17.toString());
        StringBuilder outline172 = GeneratedOutlineSupport.outline17("\r\n--");
        outline172.append(this.mBoundary);
        outline172.append("--");
        outline172.append(CRLF);
        ByteString encodeUtf82 = ByteString.encodeUtf8(outline172.toString());
        ByteString encodeUtf83 = ByteString.encodeUtf8("\r\n\r\n");
        Buffer buffer = new Buffer();
        Map<String, String> map = null;
        long j2 = 0;
        long j3 = 0;
        long j4 = 0;
        while (true) {
            long max = Math.max(j2 - ((long) encodeUtf82.data.length), j3);
            long indexOf = buffer.indexOf(encodeUtf8, max);
            if (indexOf == -1) {
                indexOf = buffer.indexOf(encodeUtf82, max);
                z = true;
            } else {
                z = false;
            }
            if (indexOf == -1) {
                long j5 = buffer.size;
                if (map == null) {
                    long indexOf2 = buffer.indexOf(encodeUtf83, max);
                    if (indexOf2 >= 0) {
                        this.mSource.read(buffer, indexOf2);
                        Buffer buffer2 = new Buffer();
                        j = j5;
                        buffer.copyTo(buffer2, max, indexOf2 - max);
                        j4 = buffer2.size + ((long) encodeUtf83.data.length);
                        map = parseHeaders(buffer2);
                    } else {
                        j = j5;
                    }
                } else {
                    j = j5;
                    emitProgress(map, j - j4, false, chunkListener);
                }
                if (this.mSource.read(buffer, (long) 4096) <= 0) {
                    return false;
                }
                j2 = j;
            } else {
                long j6 = indexOf - j3;
                if (j3 > 0) {
                    Buffer buffer3 = new Buffer();
                    buffer.skip(j3);
                    buffer.read(buffer3, j6);
                    emitProgress(map, buffer3.size - j4, true, chunkListener);
                    z2 = z;
                    emitChunk(buffer3, z2, chunkListener);
                    map = null;
                    j4 = 0;
                } else {
                    z2 = z;
                    buffer.skip(indexOf);
                }
                if (z2) {
                    return true;
                }
                j3 = (long) encodeUtf8.data.length;
                j2 = j3;
            }
        }
    }
}
