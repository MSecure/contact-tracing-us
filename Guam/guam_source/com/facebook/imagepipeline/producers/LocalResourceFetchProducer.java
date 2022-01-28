package com.facebook.imagepipeline.producers;

import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Executor;

public class LocalResourceFetchProducer extends LocalFetchProducer {
    public final Resources mResources;

    public LocalResourceFetchProducer(Executor executor, PooledByteBufferFactory pooledByteBufferFactory, Resources resources) {
        super(executor, pooledByteBufferFactory);
        this.mResources = resources;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0038, code lost:
        if (r1 == null) goto L_0x003d;
     */
    @Override // com.facebook.imagepipeline.producers.LocalFetchProducer
    public EncodedImage getEncodedImage(ImageRequest imageRequest) throws IOException {
        int i;
        InputStream openRawResource = this.mResources.openRawResource(Integer.parseInt(imageRequest.mSourceUri.getPath().substring(1)));
        AssetFileDescriptor assetFileDescriptor = null;
        try {
            assetFileDescriptor = this.mResources.openRawResourceFd(Integer.parseInt(imageRequest.mSourceUri.getPath().substring(1)));
            i = (int) assetFileDescriptor.getLength();
        } catch (Resources.NotFoundException unused) {
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
        return getByteBufferBackedEncodedImage(openRawResource, i);
    }

    @Override // com.facebook.imagepipeline.producers.LocalFetchProducer
    public String getProducerName() {
        return "LocalResourceFetchProducer";
    }
}
