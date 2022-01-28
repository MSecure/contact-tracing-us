package com.facebook.react.modules.network;

import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;

public class ProgressResponseBody extends ResponseBody {
    public BufferedSource mBufferedSource;
    public final ProgressListener mProgressListener;
    public final ResponseBody mResponseBody;
    public long mTotalBytesRead = 0;

    public ProgressResponseBody(ResponseBody responseBody, ProgressListener progressListener) {
        this.mResponseBody = responseBody;
        this.mProgressListener = progressListener;
    }

    @Override // okhttp3.ResponseBody
    public long contentLength() {
        return this.mResponseBody.contentLength();
    }

    @Override // okhttp3.ResponseBody
    public MediaType contentType() {
        return this.mResponseBody.contentType();
    }

    @Override // okhttp3.ResponseBody
    public BufferedSource source() {
        if (this.mBufferedSource == null) {
            this.mBufferedSource = Okio.buffer(new ForwardingSource(this.mResponseBody.source()) {
                /* class com.facebook.react.modules.network.ProgressResponseBody.AnonymousClass1 */

                @Override // okio.Source, okio.ForwardingSource
                public long read(Buffer buffer, long j) throws IOException {
                    long read = super.read(buffer, j);
                    int i = (read > -1 ? 1 : (read == -1 ? 0 : -1));
                    ProgressResponseBody.this.mTotalBytesRead += i != 0 ? read : 0;
                    ProgressResponseBody progressResponseBody = ProgressResponseBody.this;
                    progressResponseBody.mProgressListener.onProgress(progressResponseBody.mTotalBytesRead, progressResponseBody.mResponseBody.contentLength(), i == 0);
                    return read;
                }
            });
        }
        return this.mBufferedSource;
    }
}
