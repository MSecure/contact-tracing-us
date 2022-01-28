package com.facebook.imagepipeline.cache;

import com.facebook.common.memory.PooledByteBuffer;

public final class EncodedCountingMemoryCacheFactory$1 implements ValueDescriptor<PooledByteBuffer> {
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.facebook.imagepipeline.cache.ValueDescriptor
    public int getSizeInBytes(PooledByteBuffer pooledByteBuffer) {
        return pooledByteBuffer.size();
    }
}
