package com.facebook.imagepipeline.decoder;

import androidx.appcompat.app.AppCompatDelegateImpl;
import com.facebook.common.internal.Closeables;
import com.facebook.common.memory.ByteArrayPool;
import com.facebook.common.memory.PooledByteArrayBufferedInputStream;
import com.facebook.imagepipeline.image.EncodedImage;
import java.io.IOException;
import java.io.InputStream;

public class ProgressiveJpegParser {
    public int mBestScanEndOffset;
    public int mBestScanNumber;
    public final ByteArrayPool mByteArrayPool;
    public int mBytesParsed;
    public boolean mEndMarkerRead;
    public int mLastByteRead;
    public int mNextFullScanNumber;
    public int mParserState;

    public ProgressiveJpegParser(ByteArrayPool byteArrayPool) {
        if (byteArrayPool != null) {
            this.mByteArrayPool = byteArrayPool;
            this.mBytesParsed = 0;
            this.mLastByteRead = 0;
            this.mNextFullScanNumber = 0;
            this.mBestScanEndOffset = 0;
            this.mBestScanNumber = 0;
            this.mParserState = 0;
            return;
        }
        throw null;
    }

    public final boolean doParseMoreData(InputStream inputStream) {
        int read;
        int i = this.mBestScanNumber;
        while (true) {
            try {
                boolean z = false;
                if (this.mParserState != 6 && (read = inputStream.read()) != -1) {
                    int i2 = this.mBytesParsed + 1;
                    this.mBytesParsed = i2;
                    if (this.mEndMarkerRead) {
                        this.mParserState = 6;
                        this.mEndMarkerRead = false;
                        return false;
                    }
                    int i3 = this.mParserState;
                    if (i3 != 0) {
                        if (i3 != 1) {
                            if (i3 != 2) {
                                if (i3 != 3) {
                                    if (i3 == 4) {
                                        this.mParserState = 5;
                                    } else if (i3 != 5) {
                                        AppCompatDelegateImpl.ConfigurationImplApi17.checkState(false);
                                    } else {
                                        int i4 = ((this.mLastByteRead << 8) + read) - 2;
                                        AppCompatDelegateImpl.ConfigurationImplApi17.skip(inputStream, (long) i4);
                                        this.mBytesParsed += i4;
                                        this.mParserState = 2;
                                    }
                                } else if (read == 255) {
                                    this.mParserState = 3;
                                } else if (read == 0) {
                                    this.mParserState = 2;
                                } else if (read == 217) {
                                    this.mEndMarkerRead = true;
                                    int i5 = i2 - 2;
                                    if (this.mNextFullScanNumber > 0) {
                                        this.mBestScanEndOffset = i5;
                                    }
                                    int i6 = this.mNextFullScanNumber;
                                    this.mNextFullScanNumber = i6 + 1;
                                    this.mBestScanNumber = i6;
                                    this.mParserState = 2;
                                } else {
                                    if (read == 218) {
                                        int i7 = i2 - 2;
                                        if (this.mNextFullScanNumber > 0) {
                                            this.mBestScanEndOffset = i7;
                                        }
                                        int i8 = this.mNextFullScanNumber;
                                        this.mNextFullScanNumber = i8 + 1;
                                        this.mBestScanNumber = i8;
                                    }
                                    if (read != 1) {
                                        if (read < 208 || read > 215) {
                                            if (!(read == 217 || read == 216)) {
                                                z = true;
                                            }
                                        }
                                    }
                                    if (z) {
                                        this.mParserState = 4;
                                    } else {
                                        this.mParserState = 2;
                                    }
                                }
                            } else if (read == 255) {
                                this.mParserState = 3;
                            }
                        } else if (read == 216) {
                            this.mParserState = 2;
                        } else {
                            this.mParserState = 6;
                        }
                    } else if (read == 255) {
                        this.mParserState = 1;
                    } else {
                        this.mParserState = 6;
                    }
                    this.mLastByteRead = read;
                }
            } catch (IOException e) {
                AppCompatDelegateImpl.ConfigurationImplApi17.propagateIfPossible(e);
                throw new RuntimeException(e);
            }
        }
        return (this.mParserState == 6 || this.mBestScanNumber == i) ? false : true;
    }

    public boolean parseMoreData(EncodedImage encodedImage) {
        if (this.mParserState == 6 || encodedImage.getSize() <= this.mBytesParsed) {
            return false;
        }
        PooledByteArrayBufferedInputStream pooledByteArrayBufferedInputStream = new PooledByteArrayBufferedInputStream(encodedImage.getInputStream(), (byte[]) this.mByteArrayPool.get(16384), this.mByteArrayPool);
        try {
            AppCompatDelegateImpl.ConfigurationImplApi17.skip(pooledByteArrayBufferedInputStream, (long) this.mBytesParsed);
            boolean doParseMoreData = doParseMoreData(pooledByteArrayBufferedInputStream);
            Closeables.closeQuietly(pooledByteArrayBufferedInputStream);
            return doParseMoreData;
        } catch (IOException e) {
            AppCompatDelegateImpl.ConfigurationImplApi17.propagateIfPossible(e);
            throw new RuntimeException(e);
        } catch (Throwable th) {
            Closeables.closeQuietly(pooledByteArrayBufferedInputStream);
            throw th;
        }
    }
}
