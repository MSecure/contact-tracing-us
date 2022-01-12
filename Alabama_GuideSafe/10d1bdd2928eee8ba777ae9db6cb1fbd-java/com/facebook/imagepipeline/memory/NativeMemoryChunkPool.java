package com.facebook.imagepipeline.memory;

import com.facebook.common.memory.MemoryTrimmableRegistry;

public class NativeMemoryChunkPool extends MemoryChunkPool {
    public NativeMemoryChunkPool(MemoryTrimmableRegistry memoryTrimmableRegistry, PoolParams poolParams, PoolStatsTracker poolStatsTracker) {
        super(memoryTrimmableRegistry, poolParams, poolStatsTracker);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.facebook.imagepipeline.memory.BasePool
    public MemoryChunk alloc(int i) {
        return new NativeMemoryChunk(i);
    }
}
