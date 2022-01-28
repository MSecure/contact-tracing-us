package com.facebook.imagepipeline.cache;

import androidx.appcompat.app.AppCompatDelegateImpl;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.logging.FLog;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.EncodedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class StagingArea {
    public static final Class<?> TAG = StagingArea.class;
    public Map<CacheKey, EncodedImage> mMap = new HashMap();

    public void clearAll() {
        ArrayList arrayList;
        synchronized (this) {
            arrayList = new ArrayList(this.mMap.values());
            this.mMap.clear();
        }
        for (int i = 0; i < arrayList.size(); i++) {
            EncodedImage encodedImage = (EncodedImage) arrayList.get(i);
            if (encodedImage != null) {
                CloseableReference.closeSafely(encodedImage.mPooledByteBufferRef);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0049, code lost:
        r1 = r8;
     */
    public synchronized EncodedImage get(CacheKey cacheKey) {
        if (cacheKey != null) {
            EncodedImage encodedImage = this.mMap.get(cacheKey);
            if (encodedImage != null) {
                synchronized (encodedImage) {
                    if (!EncodedImage.isValid(encodedImage)) {
                        this.mMap.remove(cacheKey);
                        FLog.w(TAG, "Found closed reference %d for key %s (%d)", Integer.valueOf(System.identityHashCode(encodedImage)), cacheKey.getUriString(), Integer.valueOf(System.identityHashCode(cacheKey)));
                        return null;
                    }
                    EncodedImage cloneOrNull = EncodedImage.cloneOrNull(encodedImage);
                }
            }
            return encodedImage;
        }
        throw null;
    }

    public final synchronized void logStats() {
        FLog.v(TAG, "Count = %d", Integer.valueOf(this.mMap.size()));
    }

    public boolean remove(CacheKey cacheKey) {
        EncodedImage remove;
        if (cacheKey != null) {
            synchronized (this) {
                remove = this.mMap.remove(cacheKey);
            }
            if (remove == null) {
                return false;
            }
            try {
                return remove.isValid();
            } finally {
                CloseableReference.closeSafely(remove.mPooledByteBufferRef);
            }
        } else {
            throw null;
        }
    }

    /* JADX INFO: finally extract failed */
    public synchronized boolean remove(CacheKey cacheKey, EncodedImage encodedImage) {
        if (cacheKey == null) {
            throw null;
        } else if (encodedImage != null) {
            AppCompatDelegateImpl.ConfigurationImplApi17.checkArgument(EncodedImage.isValid(encodedImage));
            EncodedImage encodedImage2 = this.mMap.get(cacheKey);
            if (encodedImage2 == null) {
                return false;
            }
            CloseableReference<PooledByteBuffer> byteBufferRef = encodedImage2.getByteBufferRef();
            CloseableReference<PooledByteBuffer> byteBufferRef2 = encodedImage.getByteBufferRef();
            if (!(byteBufferRef == null || byteBufferRef2 == null)) {
                try {
                    if (byteBufferRef.get() == byteBufferRef2.get()) {
                        this.mMap.remove(cacheKey);
                        CloseableReference.closeSafely(byteBufferRef2);
                        CloseableReference.closeSafely(byteBufferRef);
                        EncodedImage.closeSafely(encodedImage2);
                        logStats();
                        return true;
                    }
                } catch (Throwable th) {
                    CloseableReference.closeSafely(byteBufferRef2);
                    CloseableReference.closeSafely(byteBufferRef);
                    EncodedImage.closeSafely(encodedImage2);
                    throw th;
                }
            }
            CloseableReference.closeSafely(byteBufferRef2);
            CloseableReference.closeSafely(byteBufferRef);
            EncodedImage.closeSafely(encodedImage2);
            return false;
        } else {
            throw null;
        }
    }
}
