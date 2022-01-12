package com.google.common.hash;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public abstract class AbstractByteHasher extends AbstractHasher {
    public AbstractByteHasher() {
        ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN);
    }
}
