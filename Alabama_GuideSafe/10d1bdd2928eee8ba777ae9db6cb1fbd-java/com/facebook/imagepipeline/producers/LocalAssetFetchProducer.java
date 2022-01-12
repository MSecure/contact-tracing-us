package com.facebook.imagepipeline.producers;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Executor;

public class LocalAssetFetchProducer extends LocalFetchProducer {
    public final AssetManager mAssetManager;

    public LocalAssetFetchProducer(Executor executor, PooledByteBufferFactory pooledByteBufferFactory, AssetManager assetManager) {
        super(executor, pooledByteBufferFactory);
        this.mAssetManager = assetManager;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0031, code lost:
        if (r1 == null) goto L_0x0036;
     */
    @Override // com.facebook.imagepipeline.producers.LocalFetchProducer
    public EncodedImage getEncodedImage(ImageRequest imageRequest) throws IOException {
        int i;
        InputStream open = this.mAssetManager.open(imageRequest.mSourceUri.getPath().substring(1), 2);
        AssetFileDescriptor assetFileDescriptor = null;
        try {
            assetFileDescriptor = this.mAssetManager.openFd(imageRequest.mSourceUri.getPath().substring(1));
            i = (int) assetFileDescriptor.getLength();
        } catch (IOException unused) {
            i = -1;
        } catch (Throwable th) {
            if (assetFileDescriptor != null) {
                try {
                    assetFileDescriptor.close();
                } catch (IOException unused2) {
                }
            }
            throw th;
        }
        try {
            assetFileDescriptor.close();
        } catch (IOException unused3) {
        }
        return getByteBufferBackedEncodedImage(open, i);
    }

    @Override // com.facebook.imagepipeline.producers.LocalFetchProducer
    public String getProducerName() {
        return "LocalAssetFetchProducer";
    }
}
