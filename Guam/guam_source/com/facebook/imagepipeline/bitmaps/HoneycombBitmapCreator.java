package com.facebook.imagepipeline.bitmaps;

import com.facebook.common.webp.BitmapCreator;
import com.facebook.imagepipeline.memory.FlexByteArrayPool;
import com.facebook.imagepipeline.memory.PoolConfig;
import com.facebook.imagepipeline.memory.PoolFactory;

public class HoneycombBitmapCreator implements BitmapCreator {
    public HoneycombBitmapCreator(PoolFactory poolFactory) {
        if (poolFactory.mFlexByteArrayPool == null) {
            PoolConfig poolConfig = poolFactory.mConfig;
            poolFactory.mFlexByteArrayPool = new FlexByteArrayPool(poolConfig.mMemoryTrimmableRegistry, poolConfig.mFlexByteArrayPoolParams);
        }
        poolFactory.getPooledByteBufferFactory(0);
    }
}
