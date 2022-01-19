package com.facebook.imagepipeline.memory;

import androidx.appcompat.app.AppCompatDelegateImpl;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.common.references.ResourceReleaser;

public class FlexByteArrayPool {
    public final SoftRefByteArrayPool mDelegatePool;
    public final ResourceReleaser<byte[]> mResourceReleaser;

    public static class SoftRefByteArrayPool extends GenericByteArrayPool {
        public SoftRefByteArrayPool(MemoryTrimmableRegistry memoryTrimmableRegistry, PoolParams poolParams, PoolStatsTracker poolStatsTracker) {
            super(memoryTrimmableRegistry, poolParams, poolStatsTracker);
        }

        @Override // com.facebook.imagepipeline.memory.BasePool
        public Bucket<byte[]> newBucket(int i) {
            return new OOMSoftReferenceBucket(i, this.mPoolParams.maxNumThreads, 0);
        }
    }

    public FlexByteArrayPool(MemoryTrimmableRegistry memoryTrimmableRegistry, PoolParams poolParams) {
        AppCompatDelegateImpl.ConfigurationImplApi17.checkArgument(poolParams.maxNumThreads > 0);
        this.mDelegatePool = new SoftRefByteArrayPool(memoryTrimmableRegistry, poolParams, NoOpPoolStatsTracker.getInstance());
        this.mResourceReleaser = new ResourceReleaser<byte[]>() {
            /* class com.facebook.imagepipeline.memory.FlexByteArrayPool.AnonymousClass1 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.facebook.common.references.ResourceReleaser
            public void release(byte[] bArr) {
                FlexByteArrayPool.this.mDelegatePool.release(bArr);
            }
        };
    }
}
